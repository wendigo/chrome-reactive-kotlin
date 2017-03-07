package pl.wendigo.chrome

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