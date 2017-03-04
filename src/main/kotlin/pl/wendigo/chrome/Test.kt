package pl.wendigo.chrome

import pl.wendigo.chrome.domain.page.NavigateRequest

class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val api = RemoteChrome.connect("127.0.0.1", 9292)

            api.DOM.enable().concatWith { api.Page.enable() }.concatWith { api.CSS.enable() }
                .flatMap {
                    api.Page.navigate(NavigateRequest(url="http://allegro.pl"))
                }
                .flatMap { frame ->
                    api.Page.onFrameStoppedLoading().filter {
                        event -> event.frameId == frame.frameId
                    }
            }
            .subscribe({ println("Button is on " + it); api.Close() }, {
              println("Got exception" + it)
            })
        }
    }
}