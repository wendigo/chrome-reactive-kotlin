package pl.wendigo.chrome.domain.schema

/**
 * Provides information about the protocol schema.
 */
class SchemaDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Returns supported domains.
	 */
	  fun getDomains() : io.reactivex.Flowable<GetDomainsResponse> {
        return connection.runAndCaptureResponse("Schema.getDomains", null, GetDomainsResponse::class.java)
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


