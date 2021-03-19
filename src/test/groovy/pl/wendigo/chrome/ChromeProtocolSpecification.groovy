package pl.wendigo.chrome

import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import org.testcontainers.utility.DockerImageName
import pl.wendigo.chrome.api.target.TargetCreatedEvent
import pl.wendigo.chrome.protocol.Event
import pl.wendigo.chrome.testing.ChromeHeadlessContainer
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class ChromeProtocolSpecification
        extends Specification
{

    @Shared
    public GenericContainer container = new ChromeHeadlessContainer(DockerImageName.parse("eu.gcr.io/zenika-hub/alpine-chrome:89"))

    def "should return browser information"()
    {
        given:
        def chrome = getBrowser()

        expect:
        chrome.getInfo().browser == "HeadlessChrome/89.0.4389.72"
        chrome.getInfo().protocolVersion == "1.3"
    }

    def "should capture target events"()
    {
        given:
        def chrome = getBrowser()

        when:
        def targetCreated = [] as List<TargetCreatedEvent>
        chrome.targetCreated().subscribe(targetCreated.&add)

        def target = chrome.target()

        then:
            targetCreated.findIndexOf {it.targetInfo.targetId == target.info().targetId} > -1
            chrome.targets().findIndexOf {it.targetId == target.info().targetId} > -1

        cleanup:
        target.close()
    }

    def "should open new target given provided options"()
    {
        given:
        def chrome = getBrowser()

        when:
        def target = chrome.target()
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
        def chrome = getBrowser()
        def target = chrome.target("https://google.com")
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

    private Browser getBrowser()
    {
        return Browser.builder()
                .withAddress(container.getAddress())
                .withEventsBufferSize(128)
                .withViewportHeight(600)
                .withViewportWidth(900)
                .incognito(true)
                .multiplexConnections(true)
                .build()
    }
}
