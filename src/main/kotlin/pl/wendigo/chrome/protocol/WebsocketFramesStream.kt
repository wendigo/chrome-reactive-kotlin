package pl.wendigo.chrome.protocol

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.slf4j.LoggerFactory

class WebsocketFramesStream : WebSocketListener, FramesStream {
    private val messages: Subject<ResponseFrame>
    private val mapper: FrameMapper
    private val connection: WebSocket
    private val client: OkHttpClient

    constructor(uri: String, messages: Subject<ResponseFrame>, mapper: FrameMapper, client: OkHttpClient) : super() {
        this.messages = messages
        this.mapper = mapper
        this.client = client
        this.connection = client.newWebSocket(Request.Builder().url(uri).build(), this)
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
    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) = messages.onComplete()

    /**
     * onFailure is called when websocket protocol error occurs.
     */
    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        logger.warn("Caught websocket error: $t")
    }

    /**
     * Returns protocol response (if any).
     */
    override fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>): Single<T> {
        return frames()
            .filter { it.matchesRequest(requestFrame) }
            .map { frame -> mapper.deserializeResponse(requestFrame, frame, clazz) }
            .subscribeOn(Schedulers.io())
            .firstOrError()
    }

    /**
     * Sends frame over the connection.
     */
    override fun send(frame: RequestFrame): Single<Boolean> {
        return Single.just(connection.send(mapper.serialize(frame)))
    }

    /**
     * Returns all event frames.
     */
    override fun eventFrames(): Flowable<ResponseFrame> = frames().filter(ResponseFrame::isEvent)

    /**
     * Returns all frames.
     */
    override fun frames(): Flowable<ResponseFrame> = messages.toFlowable(BackpressureStrategy.BUFFER)

    /**
     * Closes stream
     */
    override fun close() {
        try {
            connection.close(1000, "Goodbye!")
            client.connectionPool.evictAll()
        } catch (e: Exception) {
            logger.warn("Caught exception while closing websocket stream: ${e.message}")
        }

        try {
            messages.onComplete()
        } catch (e: Exception) {
            logger.warn("Caught exception while completing subject: ${e.message}")
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(WebsocketFramesStream::class.java)!!
    }
}