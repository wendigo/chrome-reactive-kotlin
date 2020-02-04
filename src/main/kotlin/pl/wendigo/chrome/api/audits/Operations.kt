package pl.wendigo.chrome.api.audits

/**
 * Audits domain allows investigation of page violations and possible improvements.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Audits](https://chromedevtools.github.io/devtools-protocol/tot/Audits) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class AuditsOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Returns the response body and size if it were re-encoded with the specified settings. Only
applies to images.
     *
     * @link Protocol [Audits#getEncodedResponse](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-getEncodedResponse) method documentation.
     */
    fun getEncodedResponse(input: GetEncodedResponseRequest) = connection.request("Audits.getEncodedResponse", input, GetEncodedResponseResponse::class.java)

    /**
     * Disables issues domain, prevents further issues from being reported to the client.
     *
     * @link Protocol [Audits#disable](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-disable) method documentation.
     */
    fun disable() = connection.request("Audits.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables issues domain, sends the issues collected so far to the client by means of the
`issueAdded` event.
     *
     * @link Protocol [Audits#enable](https://chromedevtools.github.io/devtools-protocol/tot/Audits#method-enable) method documentation.
     */
    fun enable() = connection.request("Audits.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Returns observable capturing all Audits.issueAdded events.
     */
    fun issueAdded(): io.reactivex.Flowable<IssueAddedEvent> = connection.events("Audits.issueAdded", IssueAddedEvent::class.java)

    /**
     * Returns flowable capturing all Audits domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Audits"
        }
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
data class GetEncodedResponseResponse(
    /**  
     * The encoded body as a base64 string. Omitted if sizeOnly is true.  
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
 *
 *
 * @link [Audits#issueAdded](https://chromedevtools.github.io/devtools-protocol/tot/Audits#event-issueAdded) event documentation.
 */
data class IssueAddedEvent(
    /**  
     *  
     */  
    val issue: Issue

) : pl.wendigo.chrome.protocol.Event(domain = "Audits", name = "issueAdded")
