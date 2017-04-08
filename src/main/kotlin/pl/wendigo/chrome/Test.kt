package pl.wendigo.chrome

import pl.wendigo.chrome.domain.page.NavigateRequest

fun main(args : Array<String>) {
    val inspector = Inspector.connect("127.0.0.1:9223")
    val page = inspector.openedPages().firstOrError().blockingGet()
    val api = HeadlessChromeDebuggerConnection.openSession(page.webSocketDebuggerUrl!!)


    val protocol = ChromeProtocol(api)

    println(protocol.Page.enable().blockingGet())

    println(protocol.Page.navigate(NavigateRequest(url="http://allegro.pl")).blockingGet())

    Thread.sleep(1000000)


}