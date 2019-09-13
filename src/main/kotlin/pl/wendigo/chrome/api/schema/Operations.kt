package pl.wendigo.chrome.api.schema

/**
 * Provides information about the protocol schema.
 *
 * @link Protocol [Schema](https://chromedevtools.github.io/devtools-protocol/tot/Schema) domain documentation.
 */
class SchemaOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Returns supported domains.
     *
     * @link Protocol [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) method documentation.
     */
    fun getDomains(): io.reactivex.Single<GetDomainsResponse> {
        return connection.runAndCaptureResponse("Schema.getDomains", null, GetDomainsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Schema domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Schema"
        }
    }
}

/**
 * Represents response frame that is returned from [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) operation call.
 * Returns supported domains.
 *
  
 * @link [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) method documentation.
 * @see [SchemaOperations.getDomains]
 */
data class GetDomainsResponse(
    /**  
     * List of supported domains.  
     */  
    val domains: List<Domain>

)
