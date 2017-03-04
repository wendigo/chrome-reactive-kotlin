package pl.wendigo.chrome
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

internal class RemoteChromeConnection constructor(
    private val host: String,
    private val port: Int
) : WebSocketListener() {
    private val events: PublishSubject<GenericResponse> = PublishSubject.create()
    private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    internal val responses = ConcurrentHashMap<Long, CompletableFuture<GenericResponse>>()

    private val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(0, TimeUnit.MILLISECONDS)
            .build()

    private val nextCommandId = AtomicLong(0)
    private var remoteConnection: WebSocket? = null

    @Throws(RemoteChromeException::class)
    internal fun connect(): RemoteChromeConnection {
        val wsRequest = Request.Builder()
                .url(getDebuggerConnectionUri().blockingGet())
                .build()

        remoteConnection = client.newWebSocket(wsRequest, this)

        return this
    }

    private fun getDebuggerConnectionUri() : Single<String> {
        return this
                .listOpenPages()
                .filter { it.type == "page" }
                .firstOrError()
                .onErrorResumeNext { this.createNewPage() }
                .map(InspectorTab::webSocketDebuggerUrl)
    }

    internal fun close() {
        events.onComplete()
        client.connectionPool().evictAll()
        client.dispatcher().executorService().shutdown()

        try {
            remoteConnection!!.cancel()
            remoteConnection = null
        } catch (e : Exception) {
            logger.error("Could not close websocket {}", e)
        }
    }

    private fun createNewPage() : Single<InspectorTab> {
        val response = client.newCall(Request.Builder()
                .url("http://$host:$port/json/new")
                .build()
        ).execute()

        if (!response.isSuccessful) {
            return Single.error(RemoteChromeException("Could not create new page"))
        }

        return Single.just(readJson(response.body().string(), InspectorTab::class.java))
    }

    private fun listOpenPages() : Flowable<InspectorTab> {
        val response = client.newCall(Request.Builder()
                .url("http://$host:$port/json/list")
                .build()
        ).execute()

        if (!response.isSuccessful) {
            return Flowable.error(RemoteChromeException("Could not query tabs"))
        }

        return Flowable.fromArray(*readJson(response.body().string(), Array<InspectorTab>::class.java))
    }

    /**
     * Sends request and captures response.
     */
    fun <T> runAndCaptureResponse(name: String, params: Any?, outClazz: Class<T>) : Flowable<T> {
        val request = GenericRequest(
                id = nextCommandId.incrementAndGet(),
                method = name,
                params = params
        )

        val serialized = mapper.writeValueAsString(request)
        val response = Flowable.fromFuture(responses.getOrPut(request.id, { CompletableFuture() }))

        logger.info("<< Sending {}", request.ident())

        if (!remoteConnection!!.send(serialized)) {
            return Flowable.error(RemoteChromeException("Could not enqueue message"))
        }

        return response.doOnSubscribe {
            logger.info("!! Waiting for {}", request.ident())
        }.subscribeOn(Schedulers.io()).map {
            mapper.treeToValue(it.result, outClazz)
        }
    }

    /**
     * Captures events by given name and casts received messages to specified class.
     */
    fun <T> captureEvents(name: String, outClazz: Class<T>) : Flowable<T> {
        return events
                .doOnSubscribe {
                    logger.info(">> Listening for {}", name)
                }
                .doOnDispose {
                    logger.info(">> Stopped listening for {}", name)
                }
                .filter { it.method == name }
                .map { if (outClazz == GenericResponse::class.java) it else mapper.treeToValue(it.params, outClazz) }
                .ofType(outClazz)
                .toFlowable(BackpressureStrategy.LATEST)
    }

    private fun <T> readJson(text: String, clazz: Class<T>): T {
        return mapper.readValue(text, clazz)
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        val response = mapper.readValue(text, GenericResponse::class.java)

        logger.info(">> Received {}", response.ident())

        // Response
        if (response.method == null) {
            responses.remove(response.id).let {
                if (response.error != null) {
                    it!!.completeExceptionally(RemoteChromeException(response.error.message))
                } else {
                    it!!.complete(response)
                }
            }
        } else {
            events.onNext(response)
        }
    }

    override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
        events.onComplete()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(RemoteChromeConnection::class.java)
    }
}

data class GenericResponse(
        val id: Long,
        val result: JsonNode?,
        val error: ProtocolError?,
        val method: String?,
        val params: JsonNode?
) {
    fun ident(): String {
        return "${method ?: "response"}(id=$id, error=${error?.message ?: "no"})"
    }
}

data class ProtocolError(
    val code: Long,
    val message: String,
    val data: String?
)

data class GenericRequest(
    val id: Long,
    val method: String,
    val params: Any?
) {
    fun ident(): String {
        return "$method(id=$id)"
    }
}

data class InspectorTab(
    val description: String,
    val devtoolsFrontendUrl: String,
    val id: String,
    val title: String,
    val type: String,
    val url: String,
    val webSocketDebuggerUrl: String
)