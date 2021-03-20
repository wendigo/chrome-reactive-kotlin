package pl.wendigo.chrome.api.schema

/**
 * This domain is deprecated.
 *
 * @link Protocol [Schema](https://chromedevtools.github.io/devtools-protocol/tot/Schema) domain documentation.
 */
@Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated.")
class SchemaDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebsocketConnection) :
    pl.wendigo.chrome.api.Domain("Schema", """This domain is deprecated.""", connection) {
    /**
     * Returns supported domains.
     *
     * @link Protocol [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) method documentation.
     */
    
    fun getDomains() = connection.request("Schema.getDomains", null, GetDomainsResponse.serializer())
}

/**
 * Represents response frame that is returned from [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) operation call.
 * Returns supported domains.
 *
  
 * @link [Schema#getDomains](https://chromedevtools.github.io/devtools-protocol/tot/Schema#method-getDomains) method documentation.
 * @see [SchemaOperations.getDomains]
 */
@kotlinx.serialization.Serializable
data class GetDomainsResponse(
    /**  
     * List of supported domains.  
     */  
    val domains: List<Domain>

)
