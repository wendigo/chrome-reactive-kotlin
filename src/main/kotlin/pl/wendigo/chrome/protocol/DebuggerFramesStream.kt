package pl.wendigo.chrome.protocol

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
import java.io.EOFException

/**
 * DebuggerFramesStream represents connection to remote websocket endpoint of the DevTools Protocol
 * (either inspectable page debugger url http://localhost:9222/json or browser debugger url http://localhost:9222/json/version)
 */
class DebuggerFramesStream : WebSocketListener {
    private val messages: Subject<ResponseFrame>
    private val mapper: FrameMapper
    private val connection: WebSocket
    private val client: OkHttpClient

    /**
     * Creates new WebSocketFramesStream for given web webSocketUri, buffer size, frame mapper, and ws client
     *
     * @param webSocketUri WS endpoint to connect to
     * @param framesBufferSize frames buffer size (how many frames will be replayed prior to subscribing to stream)
     * @param mapper mapper that will serialize/deserialize frames understand by protocol
     * @param webSocketClient client for making websocket connection.
     */
    constructor(webSocketUri: String, framesBufferSize: Int, mapper: FrameMapper, webSocketClient: OkHttpClient) : super() {
        this.messages = ReplaySubject.create(framesBufferSize)
        this.mapper = mapper
        this.client = webSocketClient
        this.connection = webSocketClient.newWebSocket(Request.Builder().url(webSocketUri).build(), this)
    }

    /**
     * onMessage is called when new frame arrives on websocket.
     */
    override fun onMessage(webSocket: WebSocket, text: String) {
        messages.onNext(mapper.deserializeFrame(text))
    }

    /**
     * onClosed is called when websocket is being closed.
     */
    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) = closeSilently()

    /**
     * onFailure is called when websocket protocol error occurs.
     */
    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        if (t !is EOFException) {
            logger.warn("Caught websocket exception: $t")
        }
    }

    /**
     * Returns protocol response for given request frame (if any).
     */
    fun <T> getResponse(requestFrame: RequestFrame, serializer: KSerializer<T>): Single<T> {
        return frames()
            .ofType(MethodCallResponseFrame::class.java)
            .filter { it.matches(requestFrame) }
            .map { frame -> mapper.deserializeResponse(requestFrame, frame, serializer) }
            .subscribeOn(Schedulers.io())
            .firstOrError()
    }

    /**
     * Sends frame over the connection.
     */
    fun send(frame: RequestFrame): Single<Boolean> {
        return Single.just(connection.send(mapper.serialize(frame)))
    }

    /**
     * Returns all frames that represent events from connection.
     */
    fun eventFrames(): Flowable<EventResponseFrame> = frames().ofType(EventResponseFrame::class.java)

    /**
     * Returns all frames received from connection.
     */
    fun frames(): Flowable<ResponseFrame> = messages.toFlowable(BackpressureStrategy.BUFFER)

    /**
     * Closes stream
     */
    fun close() {
        try {
            connection.close(1000, "Goodbye!")
            client.connectionPool.evictAll()
        } catch (e: Exception) {
            logger.warn("Caught exception while closing websocket stream: ${e.message}")
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
        private val logger = LoggerFactory.getLogger(DebuggerFramesStream::class.java)!!
    }
}
