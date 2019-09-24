package examples

import pl.wendigo.chrome.api.page.NavigateRequest

fun main() {
    val browser = Browser.connect("127.0.0.1:9223")
    val session = browser.headlessSession("about:blank")

    await {
        session.Page.enable()
    }

    await {
        session2.Page.enable()
    }

    await {
        session.Page.navigate(NavigateRequest(url = "https://github.com/wendigo/chrome-reactive-kotlin")).flatMap { (frameId) ->
            session.Page.frameStoppedLoading().filter {
                it.frameId == frameId
            }.take(1).singleOrError()
        }
    }

    println("Page 1 was loaded")

    session.close()
}
