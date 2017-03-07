package pl.wendigo.chrome

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.Observable

internal class FrameMapper {

    companion object {
        private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        internal fun serialize(requestFrame: RequestFrame): String {
            return mapper.writeValueAsString(requestFrame)
        }

        internal fun <T> deserializeResponse(responseFrame: ResponseFrame, outClass: Class<T>) : Observable<T> {
            if (responseFrame.error != null) {
                return Observable.error(RemoteChromeException(responseFrame.error.message))
            }

            if (outClass == ResponseFrame::class.java) {
                return Observable.just(responseFrame as T)
            }
            else {
                return Observable.just(mapper.treeToValue(responseFrame.result, outClass))
            }
        }

        internal fun <T> deserialize(text: String, clazz: Class<T>) : T {
            return mapper.readValue(text, clazz)
        }

        internal fun <T> deserializeEvent(responseFrame: ResponseFrame, outClass: Class<T>) : Observable<T> where T : ChromeProtocolEvent {
            try {
                if (outClass == ChromeProtocolEvent::class.java) {
                    return Observable.just(ChromeProtocolEvent.fromMethodName(responseFrame.method!!)) as Observable<T>
                } else {
                    return Observable.just(mapper.treeToValue(responseFrame.params, outClass))
                }
            } catch (e: Exception) {
                return Observable.error(e)
            }
        }
    }
}