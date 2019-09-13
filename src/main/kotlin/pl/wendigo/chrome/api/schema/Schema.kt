package pl.wendigo.chrome.domain.schema

/**
 * Provides information about the protocol schema.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Schema](https://chromedevtools.github.io/devtools-protocol/tot/Schema)
 */
class Schema internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Returns supported domains.
     */
    fun getDomains(): io.reactivex.Single<GetDomainsResponse> {
        return connectionRemote.runAndCaptureResponse("Schema.getDomains", null, GetDomainsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Schema domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Schema"
        }
    }
}

/**
 * Represents response frame for Schema.getDomains method call.
 *
 * Returns supported domains.
 */
data class GetDomainsResponse(
    /**  
     * List of supported domains.  
     */  
    val domains: List<Domain>

)
