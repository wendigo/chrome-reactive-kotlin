package pl.wendigo.chrome.protocol

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import pl.wendigo.chrome.api.target.SessionID

enum class FrameType {
    ERROR,
    RESPONSE,
    EVENT
}

/**
 * Represents protocol frame types.
 */
@Serializable
sealed class ResponseFrame

interface MethodCallResponseFrame {
    fun matches(request: RequestFrame): Boolean
}

@Serializable
data class EventResponseFrame(
    val method: String,
    val params: JsonElement,
    val sessionId: SessionID? = null
) : ResponseFrame() {
    fun matches(method: String, sessionId: SessionID?): Boolean = this.method == method && this.sessionId == sessionId
    fun matches(sessionId: SessionID?): Boolean = this.sessionId == sessionId
}

@Serializable
data class ErrorResponseFrame(
    val id: Long,
    val error: RequestError,
    val sessionId: SessionID? = null
) : ResponseFrame(), MethodCallResponseFrame {
    override fun matches(request: RequestFrame): Boolean = id == request.id && sessionId == request.sessionId
}

@Serializable
data class RequestResponseFrame(
    val id: Long,
    val result: JsonElement,
    val sessionId: SessionID? = null
) : ResponseFrame(), MethodCallResponseFrame {
    override fun matches(request: RequestFrame): Boolean = id == request.id && sessionId == request.sessionId
}

object FrameSerializer : JsonContentPolymorphicSerializer<ResponseFrame>(ResponseFrame::class) {
    override fun selectDeserializer(content: JsonElement) = when {
        "error" in content.jsonObject -> ErrorResponseFrame.serializer()
        "method" in content.jsonObject -> EventResponseFrame.serializer()
        "id" in content.jsonObject -> RequestResponseFrame.serializer()
        else -> throw RuntimeException("Unrecognized frame type: $content")
    }
}
