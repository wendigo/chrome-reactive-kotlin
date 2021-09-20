package pl.wendigo.chrome.protocol.websocket

import kotlinx.serialization.Serializable

/**
 * Represents protocol error.
 */
@Serializable
data class RequestError(
    /**
     * Error code.
     */
    val code: Long,

    /**
     * Error message.
     */
    val message: String,

    /**
     * Associated error data.
     */
    val data: String? = null
)
