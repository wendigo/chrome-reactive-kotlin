package pl.wendigo.chrome.domain.audits

/**
 * Audits domain allows investigation of page violations and possible improvements.
 */
class AuditsDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Returns the response body and size if it were re-encoded with the specified settings. Only applies to images.
     */
    fun getEncodedResponse(input : GetEncodedResponseRequest) : io.reactivex.Single<GetEncodedResponseResponse> {
        return connectionRemote.runAndCaptureResponse("Audits.getEncodedResponse", input, GetEncodedResponseResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Audits domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Audits"
        }
    }
}
/**
 * Represents request frame that can be used with Audits.getEncodedResponse method call.
 *
 * Returns the response body and size if it were re-encoded with the specified settings. Only applies to images.
 */
data class GetEncodedResponseRequest (
    /**
     * Identifier of the network request to get content for.
     */
    val requestId : pl.wendigo.chrome.domain.network.RequestId,

    /**
     * The encoding to use.
     */
    val encoding : String,

    /**
     * The quality of the encoding (0-1). (defaults to 1)
     */
    val quality : Double? = null,

    /**
     * Whether to only return the size information (defaults to false).
     */
    val sizeOnly : Boolean? = null

)

/**
 * Represents response frame for Audits.getEncodedResponse method call.
 *
 * Returns the response body and size if it were re-encoded with the specified settings. Only applies to images.
 */
data class GetEncodedResponseResponse(
  /**
   * The encoded body as a base64 string. Omitted if sizeOnly is true.
   */
  val body : String? = null,

  /**
   * Size before re-encoding.
   */
  val originalSize : Int,

  /**
   * Size after re-encoding.
   */
  val encodedSize : Int

)

