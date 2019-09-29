package pl.wendigo.chrome.protocol

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.ReplaySubject
import io.reactivex.subjects.Subject
import java.io.EOFException
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.slf4j.LoggerFactory

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
        messages.onNext(mapper.deserialize(text, ResponseFrame::class.java))
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
    fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>): Single<T> {
        return frames()
                .filter { it.matchesRequest(requestFrame) }
                .map { frame -> mapper.deserializeResponse(requestFrame, frame, clazz) }
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
    fun eventFrames(): Flowable<ResponseFrame> = frames().filter(ResponseFrame::isEvent)

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
