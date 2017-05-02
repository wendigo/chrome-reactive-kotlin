package pl.wendigo.chrome.domain.schema

/**
 * Provides information about the protocol schema.
 */
class SchemaDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * Returns supported domains.
	 */
	 fun getDomains() : io.reactivex.Single<GetDomainsResponse> {
        return connectionRemote.runAndCaptureResponse("Schema.getDomains", null, GetDomainsResponse::class.java).map {
            it.value()
        }
	}

    /**
     * Returns supported domains.
    */
     fun getDomainsTimed() : io.reactivex.Single<io.reactivex.schedulers.Timed<GetDomainsResponse>> {
        return connectionRemote.runAndCaptureResponse("Schema.getDomains", null, GetDomainsResponse::class.java)
    }

  
    /**
     * Returns flowable capturing all Schema domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Schema"
        }
    }
}

/**
 * Represents responseFrame from Schema. method call.
 *
 * Returns supported domains.
 */
data class GetDomainsResponse(
  /**
   * List of supported domains.
   */
  val domains : Array<Domain>

)

