# Module chrome-reactive-kotlin

chrome-reactive-kotlin is a low level Chrome DevTools Protocol client written in Kotlin and leveraging RxJava2 for easy composeability.

Library exposes all protocol domains in a single, cohesive and highly composable API. It supports both headless and non-headless Chrome automation capabilities.

Basic usage example:

```
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

session.close()
```

# Package pl.wendigo.chrome

Contains library main API ([Browser] and [DevToolsProtocol])

# Package pl.wendigo.chrome.headless

Contains headless operations related classes ([HeadlessDevToolsProtocol])

# Package pl.wendigo.chrome.protocol

Contains DevTools protocol primitives ([WebsocketFramesStream], [RequestFrame]/[ResponseFrame] and [Event] base classes).

# Package pl.wendigo.chrome.protocol.inspector

Inspector related classes ([InspectablePage])