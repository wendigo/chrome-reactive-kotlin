package pl.wendigo.chrome.protocol

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.Single

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
    fun serialize(requestFrame: RequestFrame): Single<String> {
        return try {
            Single.fromCallable { mapper.writeValueAsString(requestFrame) }
        } catch (e: Exception) {
            Single.error(SerializationFailed("Could not serialize request frame", e))
        }
    }

    /**
     * Deserialize response frame as clazz
     */
    fun <T> deserializeResponse(requestFrame: RequestFrame, responseFrame: ResponseFrame, clazz: Class<T>): Single<T> {
        if (responseFrame.error != null) {
            return Single.error(RequestFailed(requestFrame, responseFrame.error.message))
        }

        try {
            if (clazz == ResponseFrame::class.java) {
                @Suppress("UNCHECKED_CAST")
                return Single.just(responseFrame as T)
            } else {
                return Single.fromCallable { mapper.treeToValue(responseFrame.result, clazz) }
            }
        } catch (ex: Exception) {
            return Single.error(DeserializationFailed("Could not deserialize response frame", ex))
        }
    }

    /**
     * Deserialize text to clazz.
     */
    fun <T> deserialize(text: String, clazz: Class<T>): T {
        return mapper.readValue(text, clazz)
    }

    /**
     * Deserialize response frame event to clazz.
     */
    fun <T> deserializeEvent(responseFrame: ResponseFrame, clazz: Class<T>): Single<T> where T : Event {
        try {
            if (clazz == Event::class.java) {
                @Suppress("UNCHECKED_CAST")
                return Single.just(Event.fromMethodName(responseFrame.method!!)) as Single<T>
            } else {
                return Single.fromCallable { mapper.treeToValue(responseFrame.params, clazz) }
            }
        } catch (e: Throwable) {
            return Single.error(DeserializationFailed("Could not deserialize event $responseFrame $clazz", e))
        }
    }
}
