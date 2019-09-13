package pl.wendigo.chrome

import spock.lang.Specification

class ChromeProtocolSpecification extends Specification {
    def "should open headless session"() {
        given:
            def chrome = Browser.connect("127.0.0.1:9222")

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
