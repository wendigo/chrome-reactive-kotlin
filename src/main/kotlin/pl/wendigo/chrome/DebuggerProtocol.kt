package pl.wendigo.chrome

import io.reactivex.Flowable
import io.reactivex.Single

internal interface DebuggerProtocol {
    fun registerEventMappings(mapOf: Map<String, Class<out ProtocolEvent>>)
    fun <T> runAndCaptureResponse(name: String, params: Any?, clazz: Class<T>) : Single<T>
    fun <T> captureEvents(name : String, outClazz: Class<T>) : Flowable<T> where T : ProtocolEvent
    fun captureAllEvents() : Flowable<ProtocolEvent>
    fun close()
}