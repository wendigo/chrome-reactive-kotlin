package pl.wendigo.chrome.samples

import pl.wendigo.chrome.Browser
import pl.wendigo.chrome.sync

object CreateNewTarget {
    @JvmStatic
    fun main(args: Array<String>) {
        val browser = Browser.builder()
            .withAddress("127.0.0.1:9222")
            .withBlankPage("about:blank")
            .withViewportWidth(1280)
            .withViewportHeight(1024)
            .withEventsBufferSize(128)
            .multiplexConnections(true)
            .incognito(true)
            .build()

        // create new Target that will start loading google.com
        val target = browser.target(url = "https://google.com")

        // enable Page domain events
        sync(target.Page.enable())

        // wait for the page to load
        sync(target.Page.loadEventFired().firstOrError())
    }
}
