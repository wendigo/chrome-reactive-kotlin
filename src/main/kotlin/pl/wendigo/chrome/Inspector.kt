package pl.wendigo.chrome

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Creates new inspector that allows querying remote chrome instance for debugging sessions
 */
class Inspector(
    private val chromeAddress: String,
    private val client: OkHttpClient,
    private val mapper: FrameMapper
) {
    /**
     * Opens new page.
     */
    fun openNewPage(url: String? = null): Single<InspectablePage> {
        return runInspectorCommand("new?url=$url").map {
            mapper.deserialize(it, InspectablePage::class.java)
        }
    }

    /**
     * Returns currently opened pages and associated data (debugger connection uris)
     */
    fun openedPages(): Flowable<InspectablePage> {
        return this.runInspectorCommand("list").flatMapObservable {
            Observable.fromArray(*mapper.deserialize(it, Array<InspectablePage>::class.java))
        }.toFlowable(BackpressureStrategy.BUFFER).filter {
            it.webSocketDebuggerUrl != null
        }
    }

    /**
     * Closes given page.
     */
    fun close(page: InspectablePage): Single<String> {
        return runInspectorCommand("close/${page.id}")
    }

    /**
     * Activates given page.
     */
    fun activate(page: InspectablePage): Single<String> {
        return runInspectorCommand("activate/${page.id}")
    }

    /**
     * Fetches protocol version information
     */
    fun version(): Single<ProtocolVersion> {
        return runInspectorCommand("version").map {
            mapper.deserialize(it, ProtocolVersion::class.java)
        }
    }

    /**
     * Finds opened page by its' url
     */
    fun findTab(tabUrl: String): Single<InspectablePage> {
        return this.openedPages().filter { it.url == tabUrl }.singleOrError()
    }

    /**
     * Run inspector command from URI
     */
    internal fun runInspectorCommand(uri: String): Single<String> {
        return Single.fromCallable {
            Request.Builder().url("http://$chromeAddress/json/$uri").build()
        }.map {
            client.newCall(it).execute()
        }.flatMap {
            if (it.isSuccessful) {
                Single.just(it.body?.string() ?: "")
            } else {
                Single.error(InspectorCommandFailed(it.body?.string() ?: ""))
            }
        }
    }

    companion object {
        /**
         * Creates new Inspector instance by connecting to remote chrome debugger.
         */
        @JvmStatic
        fun connect(chromeAddress: String): Inspector {
            return Inspector(
                chromeAddress,
                OkHttpClient.Builder().readTimeout(0, TimeUnit.MILLISECONDS).build(),
                FrameMapper()
            )
        }
    }
}
