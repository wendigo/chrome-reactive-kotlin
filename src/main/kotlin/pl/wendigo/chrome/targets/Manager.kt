package pl.wendigo.chrome.targets

import io.reactivex.rxjava3.core.Flowable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.AttachToTargetRequest
import pl.wendigo.chrome.api.target.CloseTargetRequest
import pl.wendigo.chrome.api.target.CreateBrowserContextRequest
import pl.wendigo.chrome.api.target.CreateTargetRequest
import pl.wendigo.chrome.api.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.api.target.GetTargetInfoRequest
import pl.wendigo.chrome.api.target.SetDiscoverTargetsRequest
import pl.wendigo.chrome.api.target.TargetCrashedEvent
import pl.wendigo.chrome.api.target.TargetCreatedEvent
import pl.wendigo.chrome.api.target.TargetDestroyedEvent
import pl.wendigo.chrome.api.target.TargetID
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.api.target.TargetInfoChangedEvent
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import java.io.Closeable

/**
 * [Manager] is responsible for querying, creating, closing, attaching to debuggable targets on the browser side.
 */
class Manager(
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
            logger.debug("Target {} was created", it.targetInfo)
        }

        api.Target.targetDestroyed().subscribe {
            if (targets.remove(it.targetId) != null) {
                logger.debug("Target {} was destroyed", it.targetId)
            }
        }

        api.Target.targetInfoChanged().filter { it.targetInfo.isPage() }.subscribe {
            targets[it.targetInfo.targetId] = it.targetInfo
            logger.debug("Target {} was changed", it.targetInfo)
        }

        api.Target.targetCrashed().subscribe {
            if (targets.remove(it.targetId) != null) {
                logger.debug("Target {} has crashed", it.targetId)
            }
        }

        await {
            api.Target.setDiscoverTargets(SetDiscoverTargetsRequest(discover = true))
        }
    }

    /**
     * Closes target and destroys browser context if present on the browser side effectively releasing all resources .
     *
     * If [multiplexConnections] is false, then underlying connection to the [Target]'s debugger is also closed.
     */
    fun close(target: Target) {
        logger.info("Closing {}...", target)

        val browserContextID = target.info().browserContextId

        await {
            api.Target.closeTarget(CloseTargetRequest(target.session.targetId))
        }.run {
            logger.info("Closed {}", target.session)
        }

        if (!browserContextID.isNullOrEmpty()) {
            await {
                api.Target.disposeBrowserContext(DisposeBrowserContextRequest(browserContextID))
            }.run {
                logger.info("Destroyed browser context {}", browserContextID)
            }
        }

        if (!multiplexConnections) {
            target.release()
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
            true -> await {
                api.Target.createBrowserContext(CreateBrowserContextRequest(disposeOnDetach = true))
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
            true -> await {
                api.Target.attachToTarget(
                    AttachToTargetRequest(
                        targetId = target.targetId,
                        flatten = true
                    )
                )
            }.sessionId

            false -> ""
        }

        return Target(
            session = target.toTarget(sessionId),
            connection = openConnection(target, sessionId),
            manager = this
        )
    }

    /**
     * Returns Flowable of [TargetCrashedEvent]
     */
    fun targetCrashed(): Flowable<TargetCrashedEvent> = api.Target.targetCrashed()

    /**
     * Returns Flowable of [TargetCreatedEvent]
     */
    fun targetCreated(): Flowable<TargetCreatedEvent> = api.Target.targetCreated()

    /**
     * Returns Flowable of [TargetInfoChangedEvent]
     */
    fun targetInfoChanged(): Flowable<TargetInfoChangedEvent> = api.Target.targetInfoChanged()

    /**
     * Returns Flowable of [TargetDestroyedEvent]
     */
    fun targetDestroyed(): Flowable<TargetDestroyedEvent> = api.Target.targetDestroyed()

    /**
     * Constructs target debugger address (if not using multiplexed connections).
     */
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
        private val logger: Logger = LoggerFactory.getLogger(Manager::class.java)
    }
}
