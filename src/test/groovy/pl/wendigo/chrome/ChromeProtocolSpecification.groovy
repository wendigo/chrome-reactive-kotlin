package pl.wendigo.chrome

import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class ChromeProtocolSpecification extends Specification {

    /*@Shared
    public GenericContainer container = new GenericContainer("zenika/alpine-chrome:76")
            .withExposedPorts(9223)
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
            .withPrivilegedMode(true)*/

    def "should open headless session"() {
        given:
            def address = "localhost:9223" //container.getContainerIpAddress() + ":" + container.firstMappedPort
            def chrome = Browser.connect(address, 128)

        when:
            def session = chrome.session("about:blank", true, 1000, 800)
            def layout = session.page.getLayoutMetrics().blockingGet()

        then:
            with (session) {
                target != null
                target.sessionId != ""
                info().type == "page"
            }

            with (layout.layoutViewport) {
                clientHeight == 800
                clientWidth == 1000
            }

        cleanup:
            session.close()
    }
}
