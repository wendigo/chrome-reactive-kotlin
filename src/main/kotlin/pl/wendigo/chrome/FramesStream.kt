package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import java.io.Closeable

interface FramesStream : Closeable {
    fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>) : Single<T>
    fun send(frame: RequestFrame) : Single<Boolean>
    fun eventFrames() : Observable<ResponseFrame>
    fun frames() : Observable<ResponseFrame>
}