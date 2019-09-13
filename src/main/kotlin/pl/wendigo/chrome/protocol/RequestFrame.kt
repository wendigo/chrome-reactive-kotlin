package pl.wendigo.chrome.protocol

/**
 * Represents request frame.
 */
data class RequestFrame(
    /**
     * Request id, must be unique.
     */
    val id: Long,

    /**
     * Protocol method (domain.method_name i.e. Page.navigateTo)
     */
    val method: String,

    /**
     * Request params (if any)
     */
    val params: Any?
)
