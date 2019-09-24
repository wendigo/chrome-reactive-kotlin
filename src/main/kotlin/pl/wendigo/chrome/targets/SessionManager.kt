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

class SessionManager(val api: DevToolsProtocol) {

    val targets: MutableMap<TargetID, TargetInfo> = mutableMapOf()

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
        logger.info("Closing {}", session)

        await {
            api.Target.closeTarget(CloseTargetRequest(session.targetInfo.targetId))
        }.run {
            logger.info("Closed {}", session.targetInfo)
        }

        if (!session.targetInfo.browserContextId.isNullOrEmpty()) {
            await {
                api.Target.disposeBrowserContext(DisposeBrowserContextRequest(session.targetInfo.browserContextId))
            }.run {
                logger.info("Destroyed browser context {}", session.targetInfo.browserContextId)
            }
        }
    }

    fun createTarget(url: String, incognito: Boolean = true, eventBufferSize: Int = 128, width: Int = 1024, height: Int = 768): Session {
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

    fun attach(target: TargetInfo): Session {
        val (sessionId) = await {
            api.Target.attachToTarget(AttachToTargetRequest(targetId = target.targetId))
        }

        val connection = ChromeDebuggerConnection(
            FramesStream(
                FrameMapper(),
                api,
                Target(sessionId, target.targetId)
            )
        )

        return Session(
            targetInfo = target,
            sessionId = sessionId,
            connection = connection
        )
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(SessionManager::class.java)
    }
}