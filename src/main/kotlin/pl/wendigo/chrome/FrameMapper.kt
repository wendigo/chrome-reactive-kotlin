package pl.wendigo.chrome

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.Single

/**
 * Frame mapper is responsible for (de)serializing frames exchanged via chrome remote debugging protocol.
 */
class FrameMapper {

    companion object {
        private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    /**
     * Serializes request frame using internal object mapper
     */
    internal fun serialize(requestFrame: RequestFrame) : Single<String> {
        try {
            return Single.fromCallable { mapper.writeValueAsString(requestFrame) }
        } catch (e : Exception) {
            return Single.error(SerializationFailed("Could not serialize request frame", e))
        }
    }

    /**
     * Deserialize response frame as clazz
     */
    internal fun <T> deserializeResponse(requestFrame: RequestFrame, responseFrame: ResponseFrame, clazz: Class<T>) : Single<T> {
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
    internal fun <T> deserialize(text: String, clazz: Class<T>) : T {
        return mapper.readValue(text, clazz)
    }

    /**
     * Deserialize response frame event to clazz.
     */
    internal fun <T> deserializeEvent(responseFrame: ResponseFrame, clazz: Class<T>) : Single<T> where T : ProtocolEvent {
        try {
            if (clazz == ProtocolEvent::class.java) {
                @Suppress("UNCHECKED_CAST")
                return Single.just(ProtocolEvent.fromMethodName(responseFrame.method!!)) as Single<T>
            } else {
                return Single.fromCallable { mapper.treeToValue(responseFrame.params, clazz) }
            }
        } catch (e: Exception) {
            return Single.error(DeserializationFailed("Could not deserialize event", e))
        }
    }
}