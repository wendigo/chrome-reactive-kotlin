package pl.wendigo.chrome

import io.reactivex.Flowable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

internal class Inspector(
        private val chromeAddress: String
) {
    private val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(0, TimeUnit.MILLISECONDS)
            .build()

    internal fun openTab() : Single<InspectorTab> {
        return Single.fromCallable {
            Request.Builder().url("http://$chromeAddress/json/new").build()
        }.map {
            client.newCall(it).execute()
        }.flatMap {
            if (it.isSuccessful) {
                Single.just(FrameMapper.deserialize(it.body().string(), InspectorTab::class.java))
            } else {
                Single.error(RemoteChromeException("Could not create new page"))
            }
        }
    }

    internal fun openTabs() : Flowable<InspectorTab> {
        return Flowable.fromCallable {
            Request.Builder().url("http://$chromeAddress/json/list").build()
        }.map {
            client.newCall(it).execute()
        }.flatMap {
            if (it.isSuccessful) {
                Flowable.fromArray(*FrameMapper.deserialize(it.body().string(), Array<InspectorTab>::class.java))
            } else {
                Flowable.error(RemoteChromeException("Could not query tabs"))
            }
        }
    }

    internal fun findTab(tabUrl: String) : Flowable<InspectorTab> {
        return this.openTabs().filter { it.url == tabUrl }
    }
}

