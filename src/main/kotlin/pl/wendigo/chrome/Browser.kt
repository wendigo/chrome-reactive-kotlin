package pl.wendigo.chrome

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.OkHttpClient
import okhttp3.Request
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import pl.wendigo.chrome.targets.Session
import pl.wendigo.chrome.targets.SessionManager
import java.io.Closeable

/**
 * Creates new browser that allows querying remote chrome instance for debugging sessions
 */
class Browser(
    private val info: Info,
    private val sessionManager: SessionManager
) : Closeable {
    /**
     * Opens new headless debugging session via chrome debugging protocol.
     *
     * When opening headless session new browser context is created and communication goes through Target domain
     * with target id/session id.
     */
    @JvmOverloads
    fun session(url: String, incognito: Boolean = true, width: Int = 1024, height: Int = 768): Session {
        return sessionManager.createTarget(
            url = url,
            incognito = incognito,
            width = width,
            height = height
        )
    }

    fun sessions() = sessionManager.targets()

    fun close(session: Session) {
        sessionManager.closeTarget(session)
    }

    override fun close() {
        sessionManager.close()
        ChromeDebuggerConnection.Factory.close()
    }

    override fun toString(): String {
        return "Browser($info, sessionManager)"
    }

    companion object {
        /**
         * Creates new Browser instance by connecting to remote chrome debugger.
         */
        @JvmStatic
        fun connect(chromeAddress: String = "localhost:9222", eventBufferSize: Int = 128): Browser {
            val info = fetchInfo(chromeAddress)

            return Browser(
                info,
                SessionManager(
                    info.webSocketDebuggerUrl,
                    true,
                    DevToolsProtocol(ChromeDebuggerConnection.open(info.webSocketDebuggerUrl, eventBufferSize))
                )
            )
        }

        private fun fetchInfo(chromeAddress: String): Info {
            val client = OkHttpClient.Builder().build()
            val info = client.newCall(Request.Builder().url("http://$chromeAddress/json/version").build()).execute()

            return when (info.isSuccessful) {
                true -> DEFAULT_MAPPER.readValue(info.body?.string(), Info::class.java)
                false -> throw BrowserInfoDiscoveryFailedException("Could not query browser info - reponse code was ${info.code}")
            }
        }

        private val DEFAULT_MAPPER: ObjectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    data class Info(
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
}
