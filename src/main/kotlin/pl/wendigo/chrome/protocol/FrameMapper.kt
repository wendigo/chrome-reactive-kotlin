package pl.wendigo.chrome.protocol

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

/**
 * FrameMapper is responsible for (de)serializing frames exchanged via Chrome's [DevTool Protocol](https://chromedevtools.github.io/devtools-protocol/).
 */
class FrameMapper(private val mapper: ObjectMapper = DEFAULT_MAPPER) {
    companion object {
        private val DEFAULT_MAPPER: ObjectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    /**
     * Serializes request frame using internal object mapper
     */
    fun serialize(requestFrame: RequestFrame): String {
        return try {
            mapper.writeValueAsString(requestFrame)
        } catch (e: Exception) {
            throw SerializationFailed("Could not serialize request frame", e)
        }
    }

    /**
     * Deserialize response frame as clazz
     */
    fun <T> deserializeResponse(requestFrame: RequestFrame, responseFrame: ResponseFrame, clazz: Class<T>): T {
        if (responseFrame.error != null) {
            throw RequestFailed(requestFrame, responseFrame.error.message)
        }

        try {
            if (clazz == ResponseFrame::class.java) {
                @Suppress("UNCHECKED_CAST")
                return responseFrame as T
            } else {
                return mapper.treeToValue(responseFrame.result, clazz)
            }
        } catch (ex: Exception) {
            throw DeserializationFailed("Could not deserialize response frame", ex)
        }
    }

    /**
     * Deserialize provided text to clazz.
     */
    fun <T> deserialize(text: String, clazz: Class<T>): T {
        return mapper.readValue(text, clazz)
    }
}
