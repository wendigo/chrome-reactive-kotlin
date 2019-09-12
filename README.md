# chrome-reactive-kotlin

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.wendigo/chrome-reactive-kotlin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/pl.wendigo/chrome-reactive-kotlin) [![Build Status](https://travis-ci.org/wendigo/chrome-reactive-kotlin.svg?branch=master)](https://travis-ci.org/wendigo/chrome-reactive-kotlin)

**chrome-reactive-kotlin** is a low level [Chrome DevTools Protocol](https://chromedevtools.github.io/debugger-protocol-viewer/) client written in [Kotlin](https://kotlinlang.org) and leveraging [RxJava2](https://github.com/ReactiveX/RxJava) for easy composability. 

Library exposes all protocol domains in a single, cohesive and highly composable API. It supports both headless and standalone Chrome versions and understands [BrowserContext](https://chromedevtools.github.io/debugger-protocol-viewer/tot/Target/) from [Target]((https://chromedevtools.github.io/debugger-protocol-viewer/tot/Target/)) domain.

For debugging purposes you can use my other project: [chrome-protocol-proxy](https://github.com/wendigo/chrome-protocol-proxy).

Please note that most up-to-date protocol is used at the moment.



# Usage

Add to your Kotlin or Java project (Gradle dependency): 

```compile group: 'pl.wendigo', name: 'chrome-reactive-kotlin', version: '0.5.+'```

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
