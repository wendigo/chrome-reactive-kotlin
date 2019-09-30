package pl.wendigo.chrome

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.Closeable
import okhttp3.OkHttpClient
import okhttp3.Request
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import pl.wendigo.chrome.targets.Target
import pl.wendigo.chrome.targets.Manager
import kotlin.math.max

/**
 * Creates new browser that allows querying remote chrome instance for debugging sessions
 */
class Browser private constructor(
    private val options: Options,
    private val info: Info,
    private val manager: Manager
) : Closeable {
    /**
     * Opens new headless debugging session via chrome debugging protocol.
     *
     * When opening headless session new browser context is created and communication goes through Target domain
     * with target id/session id.
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
     *
     */
    fun targets() = manager.list()

    /**
     * Closes session releasing all resources on the browser side and connections.
     */
    fun close(target: Target) {
        manager.close(target)
    }

    /**
     * Closes session manager and all established connections to debugger.
     */
    override fun close() {
        manager.close()
        ChromeDebuggerConnection.Factory.close()
    }

    override fun toString(): String {
        return "Browser($options, sessionManager)"
    }

    companion object {
        /**
         * Creates new Browser instance by connecting to remote chrome debugger.
         */
        private fun connect(chromeAddress: String = "localhost:9222", options: Options): Browser {
            val info = fetchInfo(chromeAddress)

            return Browser(
                options,
                info,
                Manager(
                    info.webSocketDebuggerUrl,
                    options.multiplexConnections,
                    DevToolsProtocol(ChromeDebuggerConnection.open(info.webSocketDebuggerUrl, options.eventsBufferSize))
                )
            )
        }

        /**
         * Fetches browser info.
         */
        private fun fetchInfo(chromeAddress: String): Info {
            val client = OkHttpClient.Builder().build()
            val info = client.newCall(Request.Builder().url("http://$chromeAddress/json/version").build()).execute()

            return when (info.isSuccessful) {
                true -> DEFAULT_MAPPER.readValue(info.body?.string(), Info::class.java)
                false -> throw BrowserInfoDiscoveryFailedException("Could not query browser info - reponse code was ${info.code}")
            }
        }

        @JvmStatic
        fun builder() = Builder()

        private val DEFAULT_MAPPER: ObjectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

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
         *  Sets frames buffer size for underlying reactive replaying subject (default: 128)
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
         * Enables SessionManager to share single, underlying connection to debugger with multiple sessions (default: false)
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
        fun build() = connect(address, Options(
                eventsBufferSize = eventsBufferSize,
                viewportHeight = viewportHeight,
                viewportWidth = viewportWidth,
                incognito = incognito,
                blankPage = blankPage,
                multiplexConnections = multiplexConnections
        ))
    }

    private data class Info(
        @get:JsonProperty("Browser")
        val browser: String,

        @get:JsonProperty("Protocol-Version")
        val protocolVersion: String,

        @get:JsonProperty("User-Agent")
        val userAgent: String,

        @get:JsonProperty("V8-Version")
        val v8Version: String? = null,

        @get:JsonProperty("WebKit-Version")
        val webKitVersion: String,

        @get:JsonProperty("webSocketDebuggerUrl")
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
