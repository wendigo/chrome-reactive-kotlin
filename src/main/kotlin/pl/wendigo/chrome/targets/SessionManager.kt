package pl.wendigo.chrome.targets

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.AttachToTargetRequest
import pl.wendigo.chrome.api.target.CloseTargetRequest
import pl.wendigo.chrome.api.target.CreateTargetRequest
import pl.wendigo.chrome.api.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.api.target.GetTargetInfoRequest
import pl.wendigo.chrome.api.target.SetDiscoverTargetsRequest
import pl.wendigo.chrome.api.target.TargetID
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import pl.wendigo.chrome.protocol.FrameMapper
import java.io.Closeable

class SessionManager(
    private val browserDebuggerAddress: String,
    private val shareConnections: Boolean,
    val api: DevToolsProtocol
): Closeable {
    private val targets: MutableMap<TargetID, TargetInfo> = mutableMapOf()

    override fun close() {
        api.close()
    }

    init {
        api.Target.targetCreated().filter { it.targetInfo.isPage() }.subscribe {
            targets[it.targetInfo.targetId] = it.targetInfo
            logger.info("Created {}", it.targetInfo)
        }

        api.Target.targetDestroyed().subscribe {
            if (targets.remove(it.targetId) != null) {
                logger.info("Target {} was destroyed", it.targetId)
            }
        }

        api.Target.targetInfoChanged().filter { it.targetInfo.isPage() }.subscribe {
            targets[it.targetInfo.targetId] = it.targetInfo
            logger.info("Changed {}", it.targetInfo)
        }

        api.Target.targetCrashed().subscribe {
            if (targets.remove(it.targetId) != null) {
                logger.info("Target {} crashed", it.targetId)
            }
        }

        await {
            api.Target.setDiscoverTargets(SetDiscoverTargetsRequest(discover = true))
        }
    }

    fun closeTarget(session: Session) {
        logger.info("Closing {}...", session)

        val browserContextID = session.info().browserContextId

        await {
            api.Target.closeTarget(CloseTargetRequest(session.target.targetId))
        }.run {
            logger.info("Closed {}", session.target)
        }

        if (!browserContextID.isNullOrEmpty()) {
            await {
                api.Target.disposeBrowserContext(DisposeBrowserContextRequest(browserContextID))
            }.run {
                logger.info("Destroyed browser context {}", browserContextID)
            }
        }

        if (!shareConnections) {
            session.close()
        }
    }

    fun createTarget(url: String, incognito: Boolean = true, width: Int = 1024, height: Int = 768): Session {
        val browserContextId = when (incognito) {
            true -> await {
                api.Target.createBrowserContext()
            }.browserContextId
            false -> null
        }

        val (targetId) = await {
            api.Target.createTarget(
                CreateTargetRequest(
                    url = url,
                    browserContextId = browserContextId,
                    height = height,
                    width = width,
                    background = true
                )
            )
        }

        val targetInfo = await {
            api.Target.getTargetInfo(GetTargetInfoRequest(targetId = targetId))
        }.targetInfo

        return attach(targetInfo)
    }

    fun targets(): List<TargetInfo> {
        return targets.values.filter {
            it.type == "page"
        }.toList()
    }

    private fun attach(target: TargetInfo): Session {
        val (sessionId) = await {
            api.Target.attachToTarget(AttachToTargetRequest(targetId = target.targetId))
        }

        return Session(
            target = target.toTarget(sessionId),
            connection = openConnection(target, sessionId)
        )
    }

    private fun targetWsAddress(targetID: TargetID): String {
        return browserDebuggerAddress.replace(
                browserDebuggerAddress.substringAfterLast("devtools"),
                "/page/$targetID"
        )
    }

    private fun openConnection(target: TargetInfo, sessionId: String): ChromeDebuggerConnection {
        return when(shareConnections) {
            true -> ChromeDebuggerConnection(
                    FramesStream(
                            FrameMapper(),
                            api,
                            target.toTarget(sessionId)
                    )
            )
            false -> ChromeDebuggerConnection.open(targetWsAddress(target.targetId), 128)
        }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(SessionManager::class.java)
    }
}
