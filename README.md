# chrome-reactive-kotlin

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.wendigo/chrome-reactive-kotlin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/pl.wendigo/chrome-reactive-kotlin)

Chrome-reactive-kotlin is a low level [Chrome Debugging Protocol](https://chromedevtools.github.io/debugger-protocol-viewer/) client written in [Kotlin](https://kotlinlang.org) and leveraging [RxJava2](https://github.com/ReactiveX/RxJava). 

Library exposes all protocol domains in a single, cohesive and highly composable fashion. It supports both headless and standalone Chrome versions and understands [BrowserContext](https://chromedevtools.github.io/debugger-protocol-viewer/tot/Target/) from Target domain.

For debugging purposes you can use my [chrome-protocol-proxy](https://github.com/wendigo/chrome-protocol-proxy).

# Usage

Add to your Kotlin or Java project (Gradle dependency): 

```compile group: 'pl.wendigo', name: 'chrome-reactive-kotlin', version: '0.2.3'```

# Example

```kotlin
package pl.wendigo.chrome

import pl.wendigo.chrome.domain.page.NavigateRequest

fun main(args : Array<String>) {

    val inspector = Inspector.connect("127.0.0.1:9222")
    val protocol = ChromeProtocol.openSession(inspector.openedPages().firstOrError().blockingGet())
    val headless = protocol.headless("about:blank", 1280, 1024).blockingGet()

    println("browserContext: ${headless.browserContextId}")
    println("target: ${headless.targetId}")

    headless.Page.enable().blockingGet()

    val event = headless.Page.navigate(NavigateRequest(url="https://serafin.tech")).flatMap{ (frameId) ->
        headless.Page.frameStoppedLoading().filter {
            it.frameId == frameId
        }
        .take(1)
        .singleOrError()
    }.blockingGet()

    println("page loaded: $event")
}
```

or if you prefer fully reactive composition:

```kotlin
package pl.wendigo.chrome

import pl.wendigo.chrome.domain.page.NavigateRequest

fun main(args : Array<String>) {

    val loaded = Inspector.connect("127.0.0.1:9222")
        .openedPages()
        .firstOrError()
        .map(InspectablePage::connect)
        .flatMap { protocol ->
            protocol.headless(url = "about:blank", width = 1280, height = 1024)
        }.flatMap { headlessProtocol ->
            headlessProtocol.Page.enable().flatMap {
                headlessProtocol.Page.navigate(NavigateRequest(url = "https://serafin.tech")).flatMap { (frameId) ->
                    headlessProtocol.Page.frameStoppedLoading().filter {
                        it.frameId == frameId
                    }.take(1).singleOrError()
                }
            }
        }

    println("Page was loaded ${loaded.blockingGet()}")
}
```
