# Module chrome-reactive-kotlin

chrome-reactive-kotlin is a low level Chrome DevTools Protocol client written in Kotlin and leveraging RxJava2 for easy composability.

Library exposes all protocol domains in a single, cohesive and highly composable API. It supports both headless and non-headless Chrome automation capabilities.

Basic usage example:

```
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
}
```

# Package pl.wendigo.chrome

Contains library main API ([Browser] and [DevToolsProtocol])

# Package pl.wendigo.chrome.protocol

Contains DevTools protocol primitives ([DebuggerFramesStream], [RequestFrame]/[ResponseFrame] and [Event] base classes).

# Package pl.wendigo.chrome.targets

Targets management related classes ([Manager], [TargetSession])

