package pl.wendigo.chrome

import io.reactivex.Flowable
import io.reactivex.Single

typealias SingleBlock<T> = () -> Single<T>
typealias FlowableBlock<T> = () -> Flowable<T>

fun <T> await(block: SingleBlock<T>): T where T : Any {
    return block.invoke().blockingGet()
}

fun <T> awaitMany(block: FlowableBlock<T>): List<T> {
    return block.invoke().toList().blockingGet()
}
