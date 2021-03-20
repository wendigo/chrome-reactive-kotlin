package pl.wendigo.chrome

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

typealias SingleBlock<T> = () -> Single<T>
typealias FlowableBlock<T> = () -> Flowable<T>

fun <T> sync(block: SingleBlock<T>): T where T : Any {
    return block.invoke().blockingGet()
}

fun <T> sync(single: Single<T>): T where T : Any {
    return single.blockingGet()
}

fun <T> awaitMany(block: FlowableBlock<T>): List<T> {
    return block.invoke().toList().blockingGet()
}

fun <T> on(flowable: Flowable<T>, listener: (T) -> Unit) {
    flowable.subscribe(listener)
}
