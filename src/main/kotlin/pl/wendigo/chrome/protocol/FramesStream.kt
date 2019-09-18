package pl.wendigo.chrome.protocol

import io.reactivex.Flowable
import io.reactivex.Single
import java.io.Closeable

interface FramesStream : Closeable {
    fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>): Single<T>
    fun send(frame: RequestFrame): Single<Boolean>
    fun eventFrames(): Flowable<ResponseFrame>
    fun frames(): Flowable<ResponseFrame>
}
