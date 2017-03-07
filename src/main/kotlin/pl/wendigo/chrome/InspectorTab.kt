package pl.wendigo.chrome

/**
 * Inspector tab represents inspectable page
 */
internal data class InspectorTab(
    /**
     * Tab description
     */
    val description: String,

    /**
     * Devtools url
     */
    val devtoolsFrontendUrl: String,

    /**
     * Tab identifier
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
    val webSocketDebuggerUrl: String
)