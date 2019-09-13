package pl.wendigo.chrome.protocol

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Timed

interface DebuggerProtocol {
    fun registerEventMappings(mapOf: Map<String, Class<out Event>>)
    fun <T> runAndCaptureResponse(name: String, params: Any?, clazz: Class<T>): Single<Timed<T>>
    fun <T> captureEvents(name: String, outClazz: Class<T>): Flowable<Timed<T>> where T : Event
    fun captureAllEvents(): Flowable<Timed<Event>>
    fun close()
}
