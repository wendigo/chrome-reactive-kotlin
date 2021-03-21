package pl.wendigo.chrome.protocol.websocket

import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import pl.wendigo.chrome.protocol.DeserializationFailed
import pl.wendigo.chrome.protocol.RequestFailed
import pl.wendigo.chrome.protocol.SerializationFailed

/**
 * FrameMapper is responsible for (de)serializing frames exchanged via Chrome's [DevTool Protocol](https://chromedevtools.github.io/devtools-protocol/).
 */
class FrameMapper {
    /**
     * Serializes request frame using internal object mapper
     */
    fun serialize(requestFrame: RequestFrame): String {
        return try {
            Json.encodeToString(requestFrame)
        } catch (e: Exception) {
            throw SerializationFailed("Could not serialize request frame", e)
        }
    }

    /**
     * Deserialize [ResponseFrame] as concrete type.
     */
    internal fun <T> deserializeResponseFrame(request: RequestFrame, response: ResponseFrame, serializer: KSerializer<T>): T {
        when (response) {
            is ErrorResponseFrame -> throw RequestFailed(request, response.error.message)
            is RequestResponseFrame -> try {
                if (serializer == RequestResponseFrame.serializer()) {
                    @Suppress("UNCHECKED_CAST")
                    return response as T
                } else {
                    return Json.decodeFromJsonElement(serializer, response.result)
                }
            } catch (ex: Exception) {
                throw DeserializationFailed("Could not deserialize response frame", ex)
            }
            else -> throw RuntimeException("Unrecognized response type $response")
        }
    }

    /**
     * Deserialize provided frame JSON text to [WebSocketFrame].
     */
    fun deserializeWebSocketMessage(text: String): WebSocketFrame {
        return Json.decodeFromString(WebSocketFrameSerializer, text)
    }

    /**
     * WebSocketFrameSerializer decodes raw WebSocket JSON message by inspecting [JsonElement] and trying to guess correct [WebSocketFrame] type.
     */
    internal object WebSocketFrameSerializer : JsonContentPolymorphicSerializer<WebSocketFrame>(WebSocketFrame::class) {
        override fun selectDeserializer(element: JsonElement) = when {
            "error" in element.jsonObject -> ErrorResponseFrame.serializer()
            "method" in element.jsonObject -> EventResponseFrame.serializer()
            "id" in element.jsonObject -> RequestResponseFrame.serializer()
            else -> throw RuntimeException("Unrecognized frame with JSON representation: $element")
        }
    }
}
