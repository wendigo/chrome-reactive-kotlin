package pl.wendigo.chrome

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * InspectablePage represents debuggable page.
 */
data class InspectablePage(
    /**
     * Page description
     */
    val description: String,

    /**
     * Devtools url
     */
    val devtoolsFrontendUrl: String?,

    /**
     * Identifier
     */
    val id: String,

    /**
     * Current page title
     */
    val title: String,

    /**
     * Type of tab (page, service_worker etc)
     */
    val type: String,

    /**
     * Page url
     */
    val url: String,

    /**
     * Web socket debugger url (ws:// scheme)
     */
    val webSocketDebuggerUrl: String?
) {
    /**
     * Opens new chrome protocol debugger connection.
     */
    fun session(eventBufferSize: Int = 512): ChromeProtocol {
        return ChromeProtocol(ChromeDebuggerConnection.openSession(webSocketDebuggerUrl!!, eventBufferSize))
    }
}

/**
 * Protocol version represents browser build information.
 */
data class ProtocolVersion(
    /**
     * Browser version (i.e. Chrome/58.0.3029.0)
     */
    @get:JsonProperty("Browser")
    val browser: String,

    /**
     * Protocol version (i.e. 1.2)
     */
    @get:JsonProperty("Protocol-Version")
    val version: String,

    /**
     * Browser's reported user agent
     */
    @get:JsonProperty("User-Agent")
    val userAgent: String,

    /**
     * V8 javascript engine version
     */
    @get:JsonProperty("V8-Version")
    val v8version: String,

    /**
     * Webkit rendering engine version
     */
    @get:JsonProperty("WebKit-Version")
    val webkitVersion: String,

    @get:JsonProperty("webSocketDebuggerUrl")
    val webSocketDebugUrl: String
)
