package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import java.io.Closeable

interface ProtocolStream : Closeable {
    fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>) : Single<T>
    fun send(frame: RequestFrame) : Single<Boolean>
    fun allEventFrames(): Observable<ResponseFrame>
}