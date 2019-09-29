package pl.wendigo.chrome.targets

import java.io.Closeable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.*
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection

class SessionManager(
    private val browserDebuggerAddress: String,
    private val multiplexConnections: Boolean,
    private val api: DevToolsProtocol
) : Closeable {
    private val targets: MutableMap<TargetID, TargetInfo> = mutableMapOf()

    /**
     * Closes underlying connection to debugger.
     */
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

    /**
     * Closes target for given [Session] and destroys browser context if present.
     *
     * If [multiplexConnections] is false, then underlying for [Session] is also closed.
     */
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

        if (!multiplexConnections) {
            session.close()
        }
    }

    /**
     * Creates new target with given [url] and viewport [width] and [height].
     *
     * If [incognito] is true, than new target is created in separate browser context (think of it as incognito window).
     */
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

    /**
     * Attaches to given [TargetInfo] and returns new [Session] for it.
     *
     * If [multiplexConnections] is true then existing debugger browser connection is used.
     * If not - new underlying connection to target's debugger is established.
     */
    fun attach(target: TargetInfo): Session {

        val sessionId = when (multiplexConnections) {
            true -> await {
                api.Target.attachToTarget(AttachToTargetRequest(
                        targetId = target.targetId,
                        flatten = true
                ))
            }.sessionId

            false -> ""
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
        return when (multiplexConnections) {
            true -> api.connection.cloneForSessionId(sessionId)
            false -> ChromeDebuggerConnection.open(targetWsAddress(target.targetId), 128)
        }
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(SessionManager::class.java)
    }
}
