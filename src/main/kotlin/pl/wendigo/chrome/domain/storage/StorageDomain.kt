package pl.wendigo.chrome.domain.storage

/**
 * StorageDomain represents remote debugger protocol domain.
 */
class StorageDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Clears storage for origin.
     */
    fun clearDataForOrigin(input : ClearDataForOriginRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Storage.clearDataForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns usage and quota in bytes.
     */
    fun getUsageAndQuota(input : GetUsageAndQuotaRequest) : io.reactivex.Single<GetUsageAndQuotaResponse> {
        return connectionRemote.runAndCaptureResponse("Storage.getUsageAndQuota", input, GetUsageAndQuotaResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Storage domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Storage"
        }
    }
}
/**
 * Represents requestFrame parameters that can be used with Storage.clearDataForOrigin method call.
 *
 * Clears storage for origin.
 */
data class ClearDataForOriginRequest (
    /**
     * Security origin.
     */
    val origin : String,

    /**
     * Comma separated origin names.
     */
    val storageTypes : String

)

/**
 * Represents requestFrame parameters that can be used with Storage.getUsageAndQuota method call.
 *
 * Returns usage and quota in bytes.
 */
data class GetUsageAndQuotaRequest (
    /**
     * Security origin.
     */
    val origin : String

)

/**
 * Represents responseFrame from Storage. method call.
 *
 * Returns usage and quota in bytes.
 */
data class GetUsageAndQuotaResponse(
  /**
   * Storage usage (bytes).
   */
  val usage : Double,

  /**
   * Storage quota (bytes).
   */
  val quota : Double,

  /**
   * Storage usage per type (bytes).
   */
  val usageBreakdown : List<UsageForType>

)

