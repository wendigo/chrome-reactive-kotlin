package pl.wendigo.chrome

import org.testcontainers.containers.Container
import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class ChromeProtocolSpecification extends Specification {

    @Shared
    public GenericContainer container = new GenericContainer("zenika/alpine-chrome")
            .withExposedPorts(9222)
    .withLogConsumer()
            .withCommand(
                    "chromium-browser",
                    "--headless",
                    "--disable-gpu",
                    "--disable-software-rasterizer",
                    "--disable-dev-shm-usage",
                    "--no-sandbox",
                    "--remote-debugging-port=9222",
                    "--remote-debugging-address=0.0.0.0",
                    "about:blank"
            )
            .withPrivilegedMode(true)

    def "should open headless session"() {
        given:
            def address = container.getContainerIpAddress() + ":" + container.firstMappedPort
            def chrome = Browser.connect(address)

        when:
            def session = chrome.headlessSession("about:blank", 128)
            def layout = session.page.getLayoutMetrics().blockingGet()

        then:
            with (session.sessionDescriptor) {
                browserContextId != ""
                targetId != ""
                sessionId != ""
                sessionId != ""
            }

            with (layout.layoutViewport) {
                clientHeight == 768
                clientWidth == 1024
            }

        cleanup:
            session.close()
    }
}
