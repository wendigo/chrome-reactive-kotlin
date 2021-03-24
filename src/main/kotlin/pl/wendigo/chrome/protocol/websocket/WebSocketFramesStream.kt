package pl.wendigo.chrome.protocol.websocket

import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.ReplaySubject
import io.reactivex.rxjava3.subjects.Subject
import kotlinx.serialization.KSerializer
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.EOFException

/**
 * WebSocketFramesStream represents connection to remote WebSocket endpoint of the DevTools Protocol
 * (either inspectable page debugger url http://localhost:9222/json or browser debugger url http://localhost:9222/json/version)
 *
 * @param webSocketUri WebSocket debugger uri to connect to
 * @param framesBufferSize Frames buffer size (how many [ResponseFrame]s will be replayed prior to subscribing to stream)
 * @param mapper FrameMapper that will serialize/deserialize frames exchanged by protocol
 * @param webSocketClient WebSocket client for exchanging WebSocket frames.
 */
class WebSocketFramesStream(
    webSocketUri: String,
    framesBufferSize: Int,
    private val mapper: FrameMapper,
    webSocketClient: OkHttpClient
) : WebSocketListener(), Closeable, AutoCloseable {
    private val messages: Subject<WebSocketFrame> = ReplaySubject.createWithSize(framesBufferSize)
    private val connection: WebSocket = webSocketClient.newWebSocket(Request.Builder().url(webSocketUri).build(), this)
    private val client: OkHttpClient = webSocketClient

    /**
     * onMessage is called when new frame arrives on WebSocket.
     */
    override fun onMessage(webSocket: WebSocket, text: String) {
        messages.onNext(mapper.deserializeWebSocketMessage(text))
    }

    /**
     * onClosed is called when WebSocket is being closed.
     */
    override fun onClosed(webSocket: WebSocket, code: Int, reason: String): Unit = closeSilently()

    /**
     * onFailure is called when WebSocket protocol error occurs.
     */
    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        if (t !is EOFException) {
            logger.warn("Caught WebSocket exception: $t")
        }
    }

    /**
     * Returns protocol response for given request frame (if any).
     */
    fun <T> getResponse(requestFrame: RequestFrame, serializer: KSerializer<T>): Single<T> {
        return frames()
            .ofType(ResponseFrame::class.java)
            .filter { it.matches(requestFrame) }
            .map { frame -> mapper.deserializeResponseFrame(requestFrame, frame, serializer) }
            .subscribeOn(Schedulers.io())
            .firstOrError()
    }

    /**
     * Sends frame over the WebSocket connection.
     */
    fun send(frame: RequestFrame): Single<Boolean> {
        return Single.just(connection.send(mapper.serialize(frame)))
    }

    /**
     * Returns all frames that represent events from WebSocket connection.
     */
    fun eventFrames(): Flowable<EventResponseFrame> = frames().ofType(EventResponseFrame::class.java)

    /**
     * Returns all frames received from WebSocket connection.
     */
    fun frames(): Flowable<WebSocketFrame> = messages.toFlowable(BackpressureStrategy.BUFFER)

    /**
     * Closes WebSocket connection.
     */
    override fun close() {
        try {
            connection.close(1000, "Goodbye!")
            client.connectionPool.evictAll()
            client.dispatcher.executorService.shutdown()
        } catch (e: Exception) {
            logger.warn("Caught exception while closing WebSocket stream: ${e.message}")
        }

        try {
            closeSilently()
        } catch (e: Exception) {
            logger.warn("Caught exception while completing subject: ${e.message}")
        }
    }

    /**
     * Completes frames stream.
     */
    private fun closeSilently() {
        if (!(messages.hasComplete() || messages.hasThrowable())) {
            return messages.onComplete()
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(WebSocketFramesStream::class.java)!!
    }
}
