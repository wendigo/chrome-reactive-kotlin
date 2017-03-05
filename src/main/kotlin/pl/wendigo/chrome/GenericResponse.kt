package pl.wendigo.chrome

import com.fasterxml.jackson.databind.JsonNode


/**
 * Represents generic protocol response.
 */
data class GenericResponse(
        /**
         * Response id.
         */
        val id: Long,

        /**
         * Response result.
         */
        val result: JsonNode?,

        /**
         * Response error.
         */
        val error: ProtocolError?,

        /**
         * Request method or response event name.
         */
        val method: String?,

        /**
         * Response params.
         */
        val params: JsonNode?
) {
    internal fun toLog(): String {
        return "${method ?: "response"}(id=$id, error=${error?.message ?: "no"}, params=$params)"
    }
}


/**
 * Represents protocol error.
 */
data class ProtocolError(
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