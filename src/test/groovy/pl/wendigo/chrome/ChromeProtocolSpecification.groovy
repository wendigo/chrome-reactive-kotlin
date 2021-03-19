package pl.wendigo.chrome

import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class ChromeProtocolSpecification
        extends Specification
{

    @Shared
    public GenericContainer container = new GenericContainer("eu.gcr.io/zenika-hub/alpine-chrome:89")
            .withExposedPorts(9222)
            .withCommand(
                    "chromium-browser",
                    "--headless",
                    "--disable-gpu",
                    "--disable-software-rasterizer",
                    "--disable-dev-shm-usage",
                    "--no-sandbox",
                    "--disable-setuid-sandbox",
                    "--remote-debugging-port=9222",
                    "--remote-debugging-address=0.0.0.0",
                    "about:blank"
            )
            .withPrivilegedMode(true)

    def "should return browser information"()
    {
        given:
        def chrome = getBrowser()

        expect:
        chrome.getInfo().browser == "HeadlessChrome/89.0.4389.72"
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
        chrome.close()
    }

    private Browser getBrowser()
    {
        def address = container.getContainerIpAddress() + ":" + container.firstMappedPort

        return Browser.builder()
                .withAddress(address)
                .withEventsBufferSize(128)
                .withViewportHeight(600)
                .withViewportWidth(900)
                .incognito(true)
                .multiplexConnections(true)
                .build()
    }
}
