package pl.wendigo.chrome

import java.io.Closeable
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.Request
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import pl.wendigo.chrome.protocol.FrameMapper
import pl.wendigo.chrome.protocol.headless.HeadlessChromeProtocol
import pl.wendigo.chrome.protocol.inspector.InspectablePage
import pl.wendigo.chrome.protocol.inspector.InspectorException
import pl.wendigo.chrome.protocol.inspector.ProtocolVersion

/**
 * Creates new browser that allows querying remote chrome instance for debugging sessions
 */
class Browser(
    private val chromeAddress: String,
    private val client: OkHttpClient,
    private val mapper: FrameMapper
) : Closeable {
    /**
     * Opens new page.
     */
    fun openNewPage(url: String? = null): InspectablePage {
        return mapper.deserialize(runInspectorCommand("new?url=$url"), InspectablePage::class.java)
    }

    /**
     * Returns currently opened pages and associated data (debugger connection uris)
     */
    fun openedPages(): List<InspectablePage> {
        return mapper.deserialize(this.runInspectorCommand("list"), Array<InspectablePage>::class.java).filter {
            it.webSocketDebuggerUrl != null
        }
    }

    /**
     * Closes given page.
     */
    fun closePage(page: InspectablePage): String {
        return runInspectorCommand("close/${page.id}")
    }

    /**
     * Activates given page.
     */
    fun activatePage(page: InspectablePage): String {
        return runInspectorCommand("activate/${page.id}")
    }

    /**
     * Fetches protocol version information.
     */
    fun version(): ProtocolVersion {
        return mapper.deserialize(runInspectorCommand("version"), ProtocolVersion::class.java)
    }

    /**
     * Finds opened page by its' url.
     */
    fun findPageByUrl(url: String): InspectablePage {
        return this.openedPages().first { it.url == url }
    }

    /**
     * Run inspector command for given URI.
     */
    private fun runInspectorCommand(uri: String): String {
        val response = client.newCall(Request.Builder().url("http://$chromeAddress/json/$uri").build()).execute()

        if (response.isSuccessful) {
            return response.body?.string() ?: ""
        } else {
            throw InspectorException("Could not query inspector $uri: $response")
        }
    }

    /**
     * Opens new headless debugging session via chrome debugging protocol.
     *
     * When opening headless session new browser context is created and communication goes through Target domain
     * with target id/session id.
     */
    @JvmOverloads
    fun headlessSession(url: String, eventBufferSize: Int = 128, width: Int = 1024, height: Int = 768): HeadlessChromeProtocol {
        return HeadlessChromeProtocol.create(ChromeProtocol(ChromeDebuggerConnection.openSession(version().webSocketDebugUrl, eventBufferSize)), url, width, height)
    }

    override fun close() {
        return client.dispatcher.executorService.shutdown()
    }

    companion object {
        /**
         * Creates new Browser instance by connecting to remote chrome debugger.
         */
        @JvmStatic
        fun connect(chromeAddress: String): Browser {
            return Browser(
                chromeAddress,
                OkHttpClient.Builder().readTimeout(0, TimeUnit.MILLISECONDS).build(),
                FrameMapper()
            )
        }
    }
}
