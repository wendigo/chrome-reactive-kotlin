package pl.wendigo.chrome.samples

import pl.wendigo.chrome.Browser

object CreateBrowser {
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

        println(browser.browserInfo())
    }
}
