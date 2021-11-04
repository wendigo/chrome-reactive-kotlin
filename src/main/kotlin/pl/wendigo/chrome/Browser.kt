package pl.wendigo.chrome

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testcontainers.utility.DockerImageName
import pl.wendigo.chrome.api.ProtocolDomains
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.protocol.ProtocolConnection
import pl.wendigo.chrome.targets.Manager
import pl.wendigo.chrome.targets.Target
import java.io.Closeable
import kotlin.math.max

/**
 * Creates new browser that allows querying remote Chrome instance for debugging sessions
 *
 * @sample pl.wendigo.chrome.samples.Containerized.main
 */
open class Browser internal constructor(
    private val browserInfo: BrowserInfo,
    private val options: Options,
    connection: ProtocolConnection,
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
    fun targets(): List<TargetInfo> = manager.list()

    /**
     * Returns information on browser.
     */
    fun browserInfo(): BrowserInfo = browserInfo

    /**
     * Attaches to existing target creating new session if multiplexed connections is used.
     */
    fun attach(target: TargetInfo): Target = manager.attach(target)

    /**
     * Closes target releasing all resources on the browser side and connections.
     */
    fun close(target: Target) {
        manager.close(target)
    }

    /**
     * Closes session manager and established connection to the debugger.
     */
    override fun close() {
        try {
            manager.close()
            connection.close()
        } catch (e: Exception) {
            logger.info("Caught exception while closing Browser", e)
        }
    }

    override fun toString(): String {
        return "Browser($browserInfo, $options, $manager)"
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(Browser::class.java)
        private val decoder = Json {
            ignoreUnknownKeys = true;
            isLenient = true
        }

        /**
         * Returns library build info.
         */
        @JvmStatic
        fun buildInfo(): BuildInfo {
            return Browser.javaClass.getResource("/version.json")!!.readText().run {
                decoder.decodeFromString(BuildInfo.serializer(), this)
            }
        }

        /**
         * Creates new Browser instance by connecting to remote chrome debugger.
         */
        private fun connect(chromeAddress: String = "localhost:9222", options: Options): Browser {
            val info = fetchInfo(chromeAddress)
            val connection = ProtocolConnection.open(info.webSocketDebuggerUrl, options.eventsBufferSize)
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
        internal fun fetchInfo(chromeAddress: String): BrowserInfo {
            val client = OkHttpClient.Builder().build()
            val info = client.newCall(Request.Builder().url("http://$chromeAddress/json/version").build()).execute()

            return when (info.isSuccessful) {
                true -> decoder.decodeFromString(info.body?.string()!!)
                false -> throw BrowserInfoDiscoveryFailedException("Could not query browser info - response code was ${info.code}")
            }
        }

        @JvmStatic
        fun builder() = Builder()
    }

    /**
     * [Builder] is responsible for setting options and defaults while creating new instance of [Browser].
     */
    class Builder {
        private var address: String = "localhost:9222"
        private var blankPage: String = "about:blank"
        private var eventsBufferSize: Int = 128
        private var viewportWidth: Int = 1024
        private var viewportHeight: Int = 768

        private var multiplexConnections: Boolean = true // see https://crbug.com/991325
        private var incognito: Boolean = true
        private var dockerImage: String = "eu.gcr.io/zenika-hub/alpine-chrome:89"
        private var runDockerImage: Boolean = false

        /**
         * Sets browser debugger address (default: localhost:9222)
         */
        fun withAddress(address: String): Builder = this.apply {
            this.address = address
        }

        /**
         * Sets default blank page location (default: about:blank)
         */
        fun withBlankPage(address: String): Builder = this.apply {
            this.blankPage = address
        }

        /**
         *  Sets frames buffer size for underlying [pl.wendigo.chrome.protocol.WebSocketFramesStream]'s reactive replaying subject (default: 128)
         *
         *  High buffer size allows to observe N frames prior to subscribing.
         */
        fun withEventsBufferSize(size: Int): Builder = this.apply {
            this.eventsBufferSize = max(size, 1)
        }

        /**
         * Sets default viewport height while creating sessions (default; 768, min: 100)
         */
        fun withViewportHeight(height: Int): Builder = this.apply {
            this.viewportHeight = max(100, height)
        }

        /**
         * Sets default viewport width while creating sessions (default: 1024, min: 100)
         */
        fun withViewportWidth(width: Int): Builder = this.apply {
            this.viewportWidth = max(100, width)
        }

        /**
         * Enables [Manager] to share single, underlying WebSocket connection to debugger with multiple sessions (default: true)
         *
         * @see [https://bugs.chromium.org/p/chromium/issues/detail?id=991325](https://bugs.chromium.org/p/chromium/issues/detail?id=991325)
         */
        fun multiplexConnections(enabled: Boolean): Builder = this.apply {
            this.multiplexConnections = enabled
        }

        /**
         * Enables incognito mode while creating new targets (default: true)
         *
         * Incognito mode uses [pl.wendigo.chrome.api.browser.BrowserContextID] to separate different targets from each other (separating cookies, caches, storages...)
         */
        fun incognito(enabled: Boolean): Builder = this.apply {
            this.incognito = enabled
        }

        /**
         * Sets docker image name that will be used to create headless Chrome instance (default: eu.gcr.io/zenika-hub/alpine-chrome:89)
         */
        fun withDockerImage(dockerImage: String): Builder = this.apply {
            this.dockerImage = dockerImage
        }

        /**
         * Enabled creating headless Chrome instance when [Browser] is created (default: false)
         */
        fun runInDocker(enabled: Boolean): Builder = this.apply {
            this.runDockerImage = enabled
        }

        private fun toOptions(): Options = Options(
            eventsBufferSize = eventsBufferSize,
            viewportHeight = viewportHeight,
            viewportWidth = viewportWidth,
            incognito = incognito,
            blankPage = blankPage,
            multiplexConnections = multiplexConnections
        )

        /**
         * Creates new instance of [Browser] with configuration passed to builder
         */
        fun build(): Browser = when (runDockerImage) {
            true -> ContainerizedBrowser.connect(DockerImageName.parse(dockerImage), toOptions())
            false -> connect(address, toOptions())
        }
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

    internal data class Options(
        val eventsBufferSize: Int,
        val viewportWidth: Int,
        val viewportHeight: Int,
        val multiplexConnections: Boolean,
        val incognito: Boolean,
        val blankPage: String
    )
}
