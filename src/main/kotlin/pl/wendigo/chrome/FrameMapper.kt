package pl.wendigo.chrome

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.Observable

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
    internal fun serialize(requestFrame: RequestFrame) : Observable<String> {
        try {
            return Observable.just(mapper.writeValueAsString(requestFrame))
        } catch (e : Exception) {
            return Observable.error(SerializationFailed("Could not serialize request frame", e))
        }
    }

    /**
     * Deserializes response frame as clazz
     */
    internal fun <T> deserializeResponse(requestFrame: RequestFrame, responseFrame: ResponseFrame, clazz: Class<T>) : Observable<T> {
        if (responseFrame.error != null) {
            return Observable.error(RequestFailed(requestFrame, responseFrame.error.message))
        }

        try {
            if (clazz == ResponseFrame::class.java) {
                return Observable.just(responseFrame as T)
            } else {
                return Observable.just(mapper.treeToValue(responseFrame.result, clazz))
            }
        } catch (ex: Exception) {
            return Observable.error(DeserializationFailed("Could not deserialize response frame", ex))
        }
    }

    /**
     * Deserializes text to clazz.
     */
    internal fun <T> deserialize(text: String, clazz: Class<T>) : T {
        return mapper.readValue(text, clazz)
    }

    /**
     * Deserialized response frame being event to clazz.
     */
    internal fun <T> deserializeEvent(responseFrame: ResponseFrame, clazz: Class<T>) : Observable<T> where T : ProtocolEvent {
        try {
            if (clazz == ProtocolEvent::class.java) {
                return Observable.just(ProtocolEvent.fromMethodName(responseFrame.method!!)) as Observable<T>
            } else {
                return Observable.just(mapper.treeToValue(responseFrame.params, clazz))
            }
        } catch (e: Exception) {
            return Observable.error(DeserializationFailed("Could not deserialize event", e))
        }
    }
}