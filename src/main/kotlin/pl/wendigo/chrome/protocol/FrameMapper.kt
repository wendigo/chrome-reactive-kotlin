package pl.wendigo.chrome.protocol

import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
     * Deserialize response frame as clazz
     */
    fun <T> deserializeResponse(request: RequestFrame, response: MethodCallResponseFrame, serializer: KSerializer<T>): T {
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
     * Deserialize provided text to clazz.
     */
    fun deserializeFrame(text: String): ResponseFrame {
        return Json.decodeFromString(FrameSerializer, text)
    }
}
