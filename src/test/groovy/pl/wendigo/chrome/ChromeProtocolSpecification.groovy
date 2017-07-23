package pl.wendigo.chrome

import spock.lang.Specification

class ChromeProtocolSpecification extends Specification {
    def "should open headless session"() {
        given:
            def chrome = Inspector.connect("127.0.0.1:9222")

        when:
            def session = chrome.openNewPage("about:blank").map {
                ChromeProtocol.openHeadlessSession(it)
            }.blockingGet()

            def layout = session.page.getLayoutMetrics().blockingGet()

        then:
            with (session.session) {
                browserContextId != ""
                targetId != ""
                sessionId != ""
                sessionId == targetId + ":1"
            }

            with (layout.layoutViewport) {
                clientHeight == 768
                clientWidth == 1024
            }

        cleanup:
            session.close()
    }
}
