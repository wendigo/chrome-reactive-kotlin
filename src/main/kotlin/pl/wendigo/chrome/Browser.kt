package pl.wendigo.chrome

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.api.ProtocolDomains
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.protocol.DebuggerWebsocketConnection
import pl.wendigo.chrome.targets.Manager
import pl.wendigo.chrome.targets.Target
import java.io.Closeable
import kotlin.math.max

/**
 * Creates new browser that allows querying remote chrome instance for debugging sessions
 */
class Browser private constructor(
    private val browserInfo: BrowserInfo,
    private val options: Options,
    connection: DebuggerWebsocketConnection,
    private val manager: Manager
) : ProtocolDomains(connection), Closeable, AutoCloseable {
    /**
     * Creates new target and opens new debugging session via debugging protocol.
     *
     * If incognito is true then new browser context is created (similar to incognito mode but you can have many of those).
     */
    @JvmOverloads
    fun target(url: String = options.blankPage, incognito: Boolean = options.incognito, width: Int = options.viewportWidth, height: Int = options.viewportHeight): Target {
        return manager.create(
            url = url,
            incognito = incognito,
            width = width,
            height = height
        )
    }

    /**
     * Lists all targets that can be attached to.
     */
    fun targets() = manager.list()

    /**
     * Returns information on browser.
     */
    fun browserInfo() = browserInfo

    /**
     * Attaches to existing target creating new session if multiplexed connections is used.
     */
    fun attach(target: TargetInfo) = manager.attach(target)

    /**
     * Closes target releasing all resources on the browser side and connections.
     */
    fun close(target: Target) {
        manager.close(target)
    }

    /**
     * Closes session manager and all established connections to debugger.
     */
    override fun close() {
        try {
            manager.close()
            DebuggerWebsocketConnection.close()
        } catch (e: Exception) {
            logger.info("Caught exception while closing Browser", e)
        }
    }

    override fun toString(): String {
        return "Browser($browserInfo, $options, $manager)"
    }

    companion object {

        private val logger: Logger = LoggerFactory.getLogger(Browser::class.java)

        /**
         * Creates new Browser instance by connecting to remote chrome debugger.
         */
        private fun connect(chromeAddress: String = "localhost:9222", options: Options): Browser {
            val info = fetchInfo(chromeAddress)
            val connection = DebuggerWebsocketConnection.open(info.webSocketDebuggerUrl, options.eventsBufferSize)
            val protocol = ProtocolDomains(connection)

            return Browser(
                info,
                options,
                connection,
                Manager(
                    info.webSocketDebuggerUrl,
                    options.multiplexConnections,
                    options.eventsBufferSize,
                    protocol
                )
            )
        }

        /**
         * Fetches browser info.
         */
        private fun fetchInfo(chromeAddress: String): BrowserInfo {
            val client = OkHttpClient.Builder().build()
            val info = client.newCall(Request.Builder().url("http://$chromeAddress/json/version").build()).execute()

            return when (info.isSuccessful) {
                true -> Json.decodeFromString(info.body?.string()!!)
                false -> throw BrowserInfoDiscoveryFailedException("Could not query browser info - reponse code was ${info.code}")
            }
        }

        @JvmStatic
        fun builder() = Builder()
    }

    /**
     * [Builder] is responsible for setting options and defaults while creating new instance of [Browser].
     */
    class Builder {
        private var address: String = "localhost:8222"
        private var blankPage: String = "about:blank"
        private var eventsBufferSize: Int = 128
        private var viewportWidth: Int = 1024
        private var viewportHeight: Int = 768
        private var multiplexConnections: Boolean = false
        private var incognito: Boolean = true

        /**
         * Sets browser debugger address (default: localhost:8222)
         */
        fun withAddress(address: String) = this.apply {
            this.address = address
        }

        /**
         * Sets default blank page location (default: about:blank)
         */
        fun withBlankPage(address: String) = this.apply {
            this.blankPage = address
        }

        /**
         *  Sets frames buffer size for underlying [DebuggerFramesStream]'s reactive replaying subject (default: 128)
         *
         *  High buffer size allows to observe N frames prior to subscribing.
         */
        fun withEventsBufferSize(size: Int) = this.apply {
            this.eventsBufferSize = max(size, 1)
        }

        /**
         * Sets default viewport height while creating sessions (default; 768, min: 100)
         */
        fun withViewportHeight(height: Int) = this.apply {
            this.viewportHeight = max(100, height)
        }

        /**
         * Sets default viewport width while creating sessions (default: 1024, min: 100)
         */
        fun withViewportWidth(width: Int) = this.apply {
            this.viewportWidth = max(100, width)
        }

        /**
         * Enables [Manager] to share single, underlying connection to debugger with multiple sessions (default: false)
         */
        fun multiplexConnections(enabled: Boolean) = this.apply {
            this.multiplexConnections = enabled
        }

        /**
         * Enables incognito mode by default while creating sessions (default: false)
         *
         * Incognito mode uses BrowserContext to separate different targets from each other.
         */
        fun incognito(enabled: Boolean) = this.apply {
            this.incognito = enabled
        }

        /**
         * Creates new instance of [Browser] with configuration passed to builder
         */
        fun build() = connect(
            address,
            Options(
                eventsBufferSize = eventsBufferSize,
                viewportHeight = viewportHeight,
                viewportWidth = viewportWidth,
                incognito = incognito,
                blankPage = blankPage,
                multiplexConnections = multiplexConnections
            )
        )
    }

    @Serializable
    data class BrowserInfo(
        @SerialName("Browser")
        val browser: String,

        @SerialName("Protocol-Version")
        val protocolVersion: String,

        @SerialName("User-Agent")
        val userAgent: String,

        @SerialName("V8-Version")
        val v8Version: String? = null,

        @SerialName("WebKit-Version")
        val webKitVersion: String,

        @SerialName("webSocketDebuggerUrl")
        val webSocketDebuggerUrl: String
    )

    private data class Options(
        val eventsBufferSize: Int,
        val viewportWidth: Int,
        val viewportHeight: Int,
        val multiplexConnections: Boolean,
        val incognito: Boolean,
        val blankPage: String
    )
}
