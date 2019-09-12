package pl.wendigo.chrome

import spock.lang.Specification
import pl.wendigo.chrome.domain.page.NavigateRequest

class ChromeProtocolSpecification extends Specification {
    def "should open headless session"() {
        given:
            def chrome = Inspector.connect("127.0.0.1:9222")

        when:
            def session = chrome.version().map {
                ChromeProtocol.openHeadlessSession(it.webSocketDebugUrl, 128)
            }.blockingGet();

            def layout = session.page.getLayoutMetrics().blockingGet()

            println(session.page.navigate(new NavigateRequest("http://empik.com", null, null, null)).blockingGet())

        then:
            with (session.session) {
                browserContextId != ""
                targetId != ""
                sessionId != ""
                sessionId != ""
            }

            with (layout.layoutViewport) {
                clientHeight == 768
                clientWidth == 1024
            }

            //session.close()
    }
}
