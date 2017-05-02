package pl.wendigo.chrome

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Timed

interface DebuggerProtocol {
    fun registerEventMappings(mapOf: Map<String, Class<out ProtocolEvent>>)
    fun <T> runAndCaptureResponse(name: String, params: Any?, clazz: Class<T>) : Single<Timed<T>>
    fun <T> captureEvents(name : String, outClazz: Class<T>) : Flowable<Timed<T>> where T : ProtocolEvent
    fun captureAllEvents() : Flowable<Timed<ProtocolEvent>>
    fun close()
}