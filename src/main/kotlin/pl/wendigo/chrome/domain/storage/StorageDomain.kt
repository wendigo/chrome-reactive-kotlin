package pl.wendigo.chrome.domain.storage

/**
 * StorageDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class StorageDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Clears storage for origin.
	 */
	  fun clearDataForOrigin(input : ClearDataForOriginRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Storage.clearDataForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java)
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



