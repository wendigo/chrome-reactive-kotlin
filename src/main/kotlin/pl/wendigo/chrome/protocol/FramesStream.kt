package pl.wendigo.chrome.protocol

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Timed
import java.io.Closeable

interface FramesStream : Closeable {
    fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>): Single<Timed<T>>
    fun send(frame: RequestFrame): Single<Boolean>
    fun eventFrames(): Observable<Timed<ResponseFrame>>
    fun frames(): Observable<Timed<ResponseFrame>>
}
