package pl.wendigo.chrome.targets

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.api.ProtocolDomains
import pl.wendigo.chrome.api.target.AttachToTargetRequest
import pl.wendigo.chrome.api.target.CloseTargetRequest
import pl.wendigo.chrome.api.target.CreateBrowserContextRequest
import pl.wendigo.chrome.api.target.CreateTargetRequest
import pl.wendigo.chrome.api.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.api.target.GetTargetInfoRequest
import pl.wendigo.chrome.api.target.SetDiscoverTargetsRequest
import pl.wendigo.chrome.api.target.TargetID
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.sync
import pl.wendigo.chrome.on
import pl.wendigo.chrome.protocol.DebuggerWebsocketConnection
import java.io.Closeable

/**
 * [Manager] is responsible for querying, creating, closing, attaching to debuggable targets on the browser side.
 */
class Manager(
    private val browserDebuggerAddress: String,
    private val multiplexConnections: Boolean,
    private val eventsBufferSize: Int,
    private val domains: ProtocolDomains
) : Closeable, AutoCloseable {
    private val targets: MutableMap<TargetID, TargetInfo> = mutableMapOf()

    /**
     * Closes underlying connection to debugger.
     */
    override fun close() {
        domains.close()
    }

    init {
        on(domains.Target.targetCreated().filter { it.targetInfo.isPage() }) {
            targets[it.targetInfo.targetId] = it.targetInfo
            logger.debug("Target {} was created", it.targetInfo)
        }

        on(domains.Target.targetDestroyed()) {
            if (targets.remove(it.targetId) != null) {
                logger.debug("Target {} was destroyed", it.targetId)
            }
        }

        on(domains.Target.targetInfoChanged().filter { it.targetInfo.isPage() }) {
            targets[it.targetInfo.targetId] = it.targetInfo
            logger.debug("Target {} was changed", it.targetInfo)
        }

        on(domains.Target.targetCrashed()) {
            if (targets.remove(it.targetId) != null) {
                logger.debug("Target {} has crashed", it.targetId)
            }
        }

        sync(domains.Target.setDiscoverTargets(SetDiscoverTargetsRequest(discover = true)))
    }

    /**
     * Closes target and destroys browser context if present on the browser side effectively releasing all resources .
     *
     * If [multiplexConnections] is false, then underlying connection to the [Target]'s debugger is also closed.
     */
    fun close(target: Target) {
        logger.info("Closing {}...", target)

        val browserContextID = target.info().browserContextId

        sync(domains.Target.closeTarget(CloseTargetRequest(target.session.targetId))).run {
            logger.info("Closed {}", target.session)
        }

        if (!browserContextID.isNullOrEmpty()) {
            sync(domains.Target.disposeBrowserContext(DisposeBrowserContextRequest(browserContextID))).run {
                logger.info("Destroyed browser context {}", browserContextID)
            }
        }

        if (!multiplexConnections) {
            target.closeConnection()
        }
    }

    /**
     * Creates new target with given [url] and viewport [width] and [height].
     *
     * If [incognito] is true, than new target is created in separate browser context (think of it as incognito window).
     */
    internal fun create(url: String, incognito: Boolean = true, width: Int = 1024, height: Int = 768): Target {
        logger.info("Creating new target [url=$url, incognito=$incognito, viewport=[$width, $height]]")

        val browserContextId = when (incognito) {
            true -> sync(domains.Target.createBrowserContext(CreateBrowserContextRequest(disposeOnDetach = true))).browserContextId
            false -> null
        }

        val (targetId) = sync(domains.Target.createTarget(
            CreateTargetRequest(
                url = url,
                browserContextId = browserContextId,
                height = height,
                width = width,
                background = true
            )
        ))

        val targetInfo = sync(domains.Target.getTargetInfo(GetTargetInfoRequest(targetId = targetId))).targetInfo

        logger.info("Created new target [$targetInfo]")

        return attach(targetInfo)
    }

    /**
     * Returns list of all debuggable targets on the browser side.
     */
    fun list(): List<TargetInfo> {
        return targets.values.toList()
    }

    /**
     * Attaches to given [TargetInfo] and returns new [Target] for it.
     *
     * If [multiplexConnections] is true then existing debugger browser connection is used.
     * If not - new underlying connection to target's debugger is established.
     */
    fun attach(target: TargetInfo): Target {
        val sessionId = when (multiplexConnections) {
            true -> sync(domains.Target.attachToTarget(
                    AttachToTargetRequest(
                        targetId = target.targetId,
                        flatten = true
                    )
                )).sessionId

            false -> ""
        }

        return Target(
            session = target.toTarget(sessionId),
            connection = openConnection(target, sessionId),
            manager = this
        )
    }

    /**
     * Constructs target debugger address (if not using multiplexed connections).
     */
    private fun targetWsAddress(targetID: TargetID): String {
        return browserDebuggerAddress.replace(
            browserDebuggerAddress.substringAfterLast("devtools"),
            "/page/$targetID"
        )
    }

    private fun openConnection(target: TargetInfo, sessionId: String): DebuggerWebsocketConnection {
        return when (multiplexConnections) {
            true -> domains.connection.cloneForSessionId(sessionId)
            false -> DebuggerWebsocketConnection.open(targetWsAddress(target.targetId), eventsBufferSize)
        }
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Manager::class.java)
    }
}
