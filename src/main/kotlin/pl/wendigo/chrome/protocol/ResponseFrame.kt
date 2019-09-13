package pl.wendigo.chrome.protocol

import com.fasterxml.jackson.databind.JsonNode

/**
 * Represents generic protocol response.
 */
data class ResponseFrame(
    /**
     * Response id.
     */
    val id: Long?,

    /**
     * Response result.
     */
    val result: JsonNode?,

    /**
     * Request error.
     */
    val error: RequestError?,

    /**
     * Request method or response event name.
     */
    val method: String?,

    /**
     * Response params.
     */
    val params: JsonNode?
) {
    /**
     * Checks if response is event
     */
    internal fun isEvent(): Boolean = this.method != null

    /**
     * Checks if response is event
     */
    internal fun isResponse(): Boolean = !this.isEvent()

    internal fun isResponse(requestId: Long): Boolean = isResponse() && id == requestId
}
