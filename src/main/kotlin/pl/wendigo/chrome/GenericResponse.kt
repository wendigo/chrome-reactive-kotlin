package pl.wendigo.chrome

import com.fasterxml.jackson.databind.JsonNode

data class GenericResponse(
        val id: Long,
        val result: JsonNode?,
        val error: ProtocolError?,
        val method: String?,
        val params: JsonNode?
) {
    internal fun toLog(): String {
        return "${method ?: "response"}(id=$id, error=${error?.message ?: "no"}, params=$params)"
    }
}

data class ProtocolError(
        val code: Long,
        val message: String,
        val data: String?
)