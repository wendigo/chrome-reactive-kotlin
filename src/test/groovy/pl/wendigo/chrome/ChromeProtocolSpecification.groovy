package pl.wendigo.chrome

import org.testcontainers.utility.DockerImageName
import pl.wendigo.chrome.api.target.TargetCreatedEvent
import pl.wendigo.chrome.protocol.Event
import spock.lang.Specification

class ChromeProtocolSpecification
        extends Specification
{
    static def browser = Browser.builder()
        .runInDocker(true)
        .withDockerImage("eu.gcr.io/zenika-hub/alpine-chrome:89")
        .withEventsBufferSize(128)
        .withViewportHeight(600)
        .withViewportWidth(900)
        .incognito(true)
        .multiplexConnections(true)
        .build()

    def "should return browser information"()
    {
        expect:
            browser.browserInfo().browser == "HeadlessChrome/89.0.4389.72"
            browser.browserInfo().protocolVersion == "1.3"
    }

    def "should match protocol version"()
    {
        expect:
            browser.browserInfo().protocolVersion == browser.protocolVersion()
    }

    def "should capture target events"()
    {
        given:
            def targetCreated = [] as List<TargetCreatedEvent>
            browser.getTarget().targetCreated().subscribe(targetCreated.&add)

        when:
            def target = browser.target()

        then:
            targetCreated.findIndexOf {it.targetInfo.targetId == target.info().targetId} > -1
            browser.targets().findIndexOf {it.targetId == target.info().targetId} > -1

        cleanup:
            target.close()
    }

    def "should open new target given provided options"()
    {
        given:
            def target = browser.target()

        when:
            def layout = target.page.getLayoutMetrics().blockingGet()

        then:
            with(target) {
                session.sessionId != ""
                session.browserContextID != ""
                session.targetId != ""
                info().type == "page"
            }

            with(layout.layoutViewport) {
                clientHeight == 600
                clientWidth == 900
            }

        cleanup:
            target.close()
    }

    def "should open and navigate to new target"()
    {
        given:
            def target = browser.target("https://google.com")
            def events = [] as List<Event>

        when:
            target.getPage().events().subscribe(events.&add)
            target.getPage().enable()

        def frame = target.getPage().frameNavigated().blockingFirst()

        then:
            frame.frame.url == "https://www.google.com/"
            events.size() > 0

        cleanup:
            target.close()
    }

    def "should allow creating multiple browser instances"()
    {
        given:
            def container = new HeadlessChromeContainer(DockerImageName.parse("eu.gcr.io/zenika-hub/alpine-chrome:89"))
            container.start()
        when:
            def browser1 = Browser.builder().withAddress(container.getBrowserEndpoint()).build()
            def target1 = browser.target("https://google.com")
            target1.close()
            browser1.close()

        then:
            // this shouldn't fail
            def browser2 = Browser.builder().withAddress(container.getBrowserEndpoint()).build()
            def target2 = browser.target("https://google.com")
            target2.close()
            browser2.close()

        cleanup:
            container.stop()
    }
}
