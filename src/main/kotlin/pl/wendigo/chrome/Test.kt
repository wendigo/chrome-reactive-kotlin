package pl.wendigo.chrome

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import pl.wendigo.chrome.domain.network.EnableRequest
import pl.wendigo.chrome.domain.network.GetResponseBodyRequest
import pl.wendigo.chrome.domain.page.NavigateRequest
import java.util.*

class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val api = RemoteChrome.newTab("127.0.0.1:9292")

            api.onProtocolEvents().observeOn(Schedulers.computation()).filter {it.protocolDomain() == RemoteChrome.Domains.CSS.name}.subscribe {
                println("got next event: ${it.name()}: $it")
            }

            Flowable.merge(listOf(api.DOM.enable(), api.Page.enable(), api.CSS.enable(), api.Network.enable(EnableRequest()), api.Console.enable()))
                    .lastOrError()
                    .toFlowable()
                    .flatMap {
                        api.Page.navigate(NavigateRequest(url = "http://gazeta.pl"))
                    }
                    .flatMap { (frameId) ->
                        api.Page.onFrameStoppedLoading().filter {
                            (loadedFrameId) ->
                            loadedFrameId == frameId
                        }.take(1)
                    }.flatMap {
                api.Network.onResponseReceived()
            }.filter {
                it.response.url.contentEquals("http://static.gazeta.pl/static/video/playerjs/deploy/app/n3j10/skin/hp/skin.json")
            }.take(1).flatMap {
                (requestId) ->
                api.Network.getResponseBody(GetResponseBodyRequest(requestId = requestId))
            }
                    .map {
                        if (it.base64Encoded) Base64.getDecoder().decode(it.body) else it.body
                    }
                    .subscribe({ println("Response captured: " + it); api.close(); }, {
                        println("Got exception" + it)
                    }, {
                        api.close()
                    })
        }
    }
}