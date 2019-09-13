package pl.wendigo.chrome.protocol

/**
 * Represents protocol error.
 */
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
    val data: String?
)
