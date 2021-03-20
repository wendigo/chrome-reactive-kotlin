package pl.wendigo.chrome.api.audits

import kotlinx.serialization.json.Json

/**
 * Audits domain allows investigation of page violations and possible improvements.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Audits](https://chromedevtools.github.io/devtools-protocol/tot/Audits) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class AuditsDomain internal constructor(connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) :
    pl.wendigo.chrome.api.Domain("Audits", """Audits domain allows investigation of page violations and possible improvements.""", connection) {
    /**
     * Returns the response body and size if it were re-encoded with the specified settings. Only
applies to images.
     *
     * @link Protocol [Audits#getEncodedResponse](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-getEncodedResponse) method documentation.
     */
    
    fun getEncodedResponse(input: GetEncodedResponseRequest) = connection.request("Audits.getEncodedResponse", Json.encodeToJsonElement(GetEncodedResponseRequest.serializer(), input), GetEncodedResponseResponse.serializer())

    /**
     * Disables issues domain, prevents further issues from being reported to the client.
     *
     * @link Protocol [Audits#disable](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-disable) method documentation.
     */
    
    fun disable() = connection.request("Audits.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables issues domain, sends the issues collected so far to the client by means of the
`issueAdded` event.
     *
     * @link Protocol [Audits#enable](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-enable) method documentation.
     */
    
    fun enable() = connection.request("Audits.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Runs the contrast check for the target page. Found issues are reported
using Audits.issueAdded event.
     *
     * @link Protocol [Audits#checkContrast](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-checkContrast) method documentation.
     */
    
    fun checkContrast(input: CheckContrastRequest) = connection.request("Audits.checkContrast", Json.encodeToJsonElement(CheckContrastRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Returns observable capturing all Audits.issueAdded events.
     */
    fun issueAdded(): io.reactivex.rxjava3.core.Flowable<IssueAddedEvent> = connection.events("Audits.issueAdded", IssueAddedEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.api.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.network.NetworkDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [Audits#getEncodedResponse](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-getEncodedResponse) operation call.
 *
 * Returns the response body and size if it were re-encoded with the specified settings. Only
applies to images.
 * @link [Audits#getEncodedResponse](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-getEncodedResponse) method documentation.
 * @see [AuditsOperations.getEncodedResponse]
 */
@kotlinx.serialization.Serializable
data class GetEncodedResponseRequest(
    /**
     * Identifier of the network request to get content for.
     */
    val requestId: pl.wendigo.chrome.api.network.RequestId,

    /**
     * The encoding to use.
     */
    val encoding: String,

    /**
     * The quality of the encoding (0-1). (defaults to 1)
     */
    val quality: Double? = null,

    /**
     * Whether to only return the size information (defaults to false).
     */
    val sizeOnly: Boolean? = null

)

/**
 * Represents response frame that is returned from [Audits#getEncodedResponse](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-getEncodedResponse) operation call.
 * Returns the response body and size if it were re-encoded with the specified settings. Only
applies to images.
 *
  
 * @link [Audits#getEncodedResponse](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-getEncodedResponse) method documentation.
 * @see [AuditsOperations.getEncodedResponse]
 */
@kotlinx.serialization.Serializable
data class GetEncodedResponseResponse(
    /**  
     * The encoded body as a base64 string. Omitted if sizeOnly is true. (Encoded as a base64 string when passed over JSON)  
     */  
    val body: String? = null,

    /**  
     * Size before re-encoding.  
     */  
    val originalSize: Int,

    /**  
     * Size after re-encoding.  
     */  
    val encodedSize: Int

)

/**
 * Represents request frame that can be used with [Audits#checkContrast](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-checkContrast) operation call.
 *
 * Runs the contrast check for the target page. Found issues are reported
using Audits.issueAdded event.
 * @link [Audits#checkContrast](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-checkContrast) method documentation.
 * @see [AuditsOperations.checkContrast]
 */
@kotlinx.serialization.Serializable
data class CheckContrastRequest(
    /**
     * Whether to report WCAG AAA level issues. Default is false.
     */
    val reportAAA: Boolean? = null

)

/**
 *
 *
 * @link [Audits#issueAdded](https://chromedevtools.github.io/devtools-protocol/tot/Audits#event-issueAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class IssueAddedEvent(
    /**  
     *  
     */  
    val issue: InspectorIssue

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Audits" 
    override fun eventName() = "issueAdded"
} 
