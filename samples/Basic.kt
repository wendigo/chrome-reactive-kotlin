package examples

import pl.wendigo.chrome.api.page.NavigateRequest
import pl.wendigo.chrome.Browser

fun main() {
    val chrome = Browser.builder().withAddress("127.0.0.1:9222").build()

    chrome.use { browser ->
        browser.target("about:blank").use { target ->
            await {
                target.Page.enable()
            }

            await {
                target.Page.navigate(NavigateRequest(url = "https://github.com/wendigo/chrome-reactive-kotlin")).flatMap { (frameId) ->
                    target.Page.frameStoppedLoading().filter {
                        it.frameId == frameId
                    }.take(1).singleOrError()
                }
            }
        }

        browser.targets().forEach {
            println("Target ${it.targetId} has url: ${it.url}")
        }
    }
}
