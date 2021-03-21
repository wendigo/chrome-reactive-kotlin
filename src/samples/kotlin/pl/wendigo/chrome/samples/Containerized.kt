package pl.wendigo.chrome.samples

import pl.wendigo.chrome.Browser
import pl.wendigo.chrome.api.network.EnableRequest
import pl.wendigo.chrome.api.page.NavigateRequest
import pl.wendigo.chrome.sync

object Containerized {
    @JvmStatic
    fun main(args: Array<String>) {
        val browser = Browser
            .builder()
            .withAddress("127.0.0.1:9222")
            .runInDocker(true)
            .multiplexConnections(true)
            .build()

        browser.target("about:blank").use { target ->
            sync(target.Page.enable())
            sync(target.DOM.enable())
            sync(target.CSS.enable())
            sync(target.Network.enable(EnableRequest()))

            browser.events().subscribe {
                println("Received browser event $it")
            }

            target.events().subscribe {
                println("Received target event $it")
            }

            sync(
                target.Page.navigate(NavigateRequest(url = "https://github.com/wendigo/chrome-reactive-kotlin")).flatMap { (frameId) ->
                    target.Page.frameStoppedLoading().filter { (loadedFrameId) ->
                        loadedFrameId == frameId
                    }.take(1).singleOrError()
                }
            )

            println("Created target is ${target.targetId()} with session info ${target.session()}")

            browser.targets().forEach {
                println("Target ${it.targetId} has url: ${it.url} and browser context id: ${it.browserContextId}")
            }

            Thread.sleep(100000)
        }

        browser.close()
    }
}
