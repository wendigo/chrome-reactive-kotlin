package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

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
    override fun onMessage(webSocket: WebSocket?, text: String?) {
        messages.onNext(mapper.deserialize(text!!, ResponseFrame::class.java))
    }

    /**
     * onClosed is called when websocket is being closed.
     */
    override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
        messages.onComplete()
    }

    /**
     * onFailure is called when websocket protocol error occurs.
     */
    override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
        messages.onComplete()
    }

    /**
     * Returns protocol response (if any).
     */
    override fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>) : Single<T> {
        return messages
                .filter { it.isResponse(requestFrame.id) }
                .flatMapSingle { mapper.deserializeResponse(requestFrame, it, clazz) }
                .subscribeOn(Schedulers.io())
                .take(1)
                .singleOrError()
    }

    /**
     * Sends frame over the connection.
     */
    override fun send(frame: RequestFrame) : Single<Boolean> {
       return Single
            .just(frame)
            .flatMap { mapper.serialize(it) }
            .map { connection.send(it) }
            .subscribeOn(Schedulers.io())
    }

    /**
     * Returns all event frames.
     */
    override fun eventFrames() : Observable<ResponseFrame> {
        return messages.filter(ResponseFrame::isEvent)
    }

    /**
     * Returns all frames.
     */
    override fun frames() : Observable<ResponseFrame> {
        return messages
    }

    /**
     * Closes stream
     */
    override fun close() {
        try {
            connection.close(1000, "Goodbye!")
            client.connectionPool().evictAll()
            client.dispatcher().executorService().shutdown()
        } catch (e : Exception) {
            messages.onError(e)
        }

        messages.onComplete()
    }

    /**
     * Closes stream with error
     */
    fun close(e: Exception) {
        messages.onError(e)
    }
}