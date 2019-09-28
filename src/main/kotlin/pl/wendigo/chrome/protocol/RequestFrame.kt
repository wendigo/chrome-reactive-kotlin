package pl.wendigo.chrome.protocol

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents request frame.
 */
data class RequestFrame(
    /**
     * Request id, must be unique.
     */
    val id: Long,

    /**
     * Session ID for flatten mode requests.
     */
    @get:JsonProperty("sessionId")
    val sessionId: String? = null,

    /**
     * Protocol method (domain.method_name i.e. Page.navigateTo)
     */
    val method: String,

    /**
     * Request params (if any)
     */
    val params: Any?
)
