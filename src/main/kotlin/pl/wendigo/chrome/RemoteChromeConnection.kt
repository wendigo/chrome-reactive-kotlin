package pl.wendigo.chrome
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.ReplaySubject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

internal class RemoteChromeConnection constructor(
    private val host: String,
    private val port: Int,
    private val enableDebug: Boolean = false
) : WebSocketListener() {
    private val events: ReplaySubject<ChromeProtocolEvent> = ReplaySubject.create(1024)

    private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    internal val responses = ConcurrentHashMap<Long, CompletableFuture<GenericResponse>>()

    private val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(0, TimeUnit.MILLISECONDS)
            .build()

    private val mappings: ConcurrentHashMap<String, Class<out ChromeProtocolEvent>> = ConcurrentHashMap()

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

    internal fun registerMappings(mapOf: Map<String, Class<out ChromeProtocolEvent>>) {
        mappings.putAll(mapOf)
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
        return Single.fromCallable {
            Request.Builder().url("http://$host:$port/json/new").build()
        }.map {
            client.newCall(it).execute()
        }.flatMap {
            if (it.isSuccessful) {
                Single.just(readJson(it.body().string(), InspectorTab::class.java))
            } else {
                Single.error(RemoteChromeException("Could not create new page"))
            }
        }
    }

    private fun listOpenPages() : Flowable<InspectorTab> {
        return Flowable.fromCallable {
            Request.Builder().url("http://$host:$port/json/list").build()
        }.map {
            client.newCall(it).execute()
        }.flatMap {
            if (it.isSuccessful) {
                Flowable.fromArray(*readJson(it.body().string(), Array<InspectorTab>::class.java))
            } else {
                Flowable.error(RemoteChromeException("Could not query tabs"))
            }
        }
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

        if (enableDebug) {
            logger.info("<< Sending {}", request.toLog())
        }

        if (!remoteConnection!!.send(serialized)) {
            return Flowable.error(RemoteChromeException("Could not enqueue message"))
        }

        return response.doOnSubscribe {
            logger.info("!! Subscribed for response {}", request.toLog())
        }.subscribeOn(Schedulers.io()).map {
            mapper.treeToValue(it.result, outClazz)
        }
    }

    /**
     * Captures events by given name and casts received messages to specified class.
     */
    fun <T> captureEvents(outClazz: Class<T>) : Flowable<T> where T : ChromeProtocolEvent {
        return events
                .doOnSubscribe {
                    logger.info(">> Subscribed for {}", outClazz.canonicalName)
                }
                .doOnDispose {
                    logger.info(">> Disposed subscription {}", outClazz.canonicalName)
                }
                .ofType(outClazz)
                .doOnNext {
                    logger.info(">> Got next event {}", it)
                }
                .toFlowable(BackpressureStrategy.LATEST)
    }

    /**
     * Captures all events as generated by debugger
     */
    fun captureAllEvents() : Flowable<ChromeProtocolEvent> {
        return  events
                .doOnSubscribe {
                    logger.info(">> Subscribed for all events")
                }
                .doOnDispose {
                    logger.info(">> Disposed all events subscription")
                }
                .doOnNext {
                    logger.info(">> Got next event {}", it)
                }
                .toFlowable(BackpressureStrategy.LATEST)
    }

    private fun <T> readJson(text: String, clazz: Class<T>): T {
        return mapper.readValue(text, clazz)
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        val response = mapper.readValue(text, GenericResponse::class.java)

        if (enableDebug) {
            logger.info(">> Received {}", response.toLog())
        }

        if (response.method == null) {
            responses.remove(response.id).let {
                if (response.error != null) {
                    it!!.completeExceptionally(RemoteChromeException(response.error.message))
                } else {
                    it!!.complete(response)
                }
            }
        } else {
            val clazz = mappings[response.method]

            if (clazz == null) {
                events.onError(RemoteChromeException("Got unrecognized response: ${response.method} not being an event"))
            } else if (clazz == ChromeProtocolEvent::class.java) {
                events.onNext(ChromeProtocolEvent.fromMethodName(response.method))
            } else {
                events.onNext(mapper.treeToValue(response.params, clazz))
            }
        }
    }

    override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
        events.onComplete()
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
        logger.error(">> Got error from websocket: {}", t!!.message)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(RemoteChromeConnection::class.java)
    }
}