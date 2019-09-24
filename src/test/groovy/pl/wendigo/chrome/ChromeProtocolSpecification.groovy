package pl.wendigo.chrome

import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class ChromeProtocolSpecification extends Specification {

    @Shared
    public GenericContainer container = new GenericContainer("zenika/alpine-chrome")
            .withExposedPorts(9222)
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
            def chrome = Browser.connect(address, 128)

        when:
            def session = chrome.session("about:blank", true, 128, 1000, 800)
            def layout = session.page.getLayoutMetrics().blockingGet()

        then:
            with (session) {
                targetInfo != null
                sessionId != ""
                targetInfo.type == "page"
            }

            with (layout.layoutViewport) {
                clientHeight == 800
                clientWidth == 1000
            }

        cleanup:
            session.close()
    }
}
