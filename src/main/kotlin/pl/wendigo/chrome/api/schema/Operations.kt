package pl.wendigo.chrome.api.schema

/**
 * This domain is deprecated.
 *
 * @link Protocol [Schema](https://chromedevtools.github.io/devtools-protocol/tot/Schema) domain documentation.
 */
@Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated.")
class SchemaOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Returns supported domains.
     *
     * @link Protocol [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) method documentation.
     */
    fun getDomains() = connection.request("Schema.getDomains", null, GetDomainsResponse::class.java)

    /**
     * Returns flowable capturing all Schema domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
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
