package pl.wendigo.chrome

import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class ChromeProtocolSpecification extends Specification {

    @Shared
    public GenericContainer container = new GenericContainer("zenika/alpine-chrome:76")
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

    def "should open new target given provided options"() {
        given:
            def address = container.getContainerIpAddress() + ":" + container.firstMappedPort

            def chrome = Browser.builder()
                    .withAddress(address)
                    .withEventsBufferSize(128)
                    .withViewportHeight(600)
                    .withViewportWidth(900)
                    .incognito(true)
                    .multiplexConnections(true)
                    .build()

        when:
            def target = chrome.target()
            def layout = target.page.getLayoutMetrics().blockingGet()

        then:
            with (target) {
                session.sessionId != ""
                session.browserContextID != ""
                session.targetId != ""
                info().type == "page"
            }

            with (layout.layoutViewport) {
                clientHeight == 600
                clientWidth == 900
            }

        cleanup:
            chrome.close(target)
            chrome.close()
    }
}
