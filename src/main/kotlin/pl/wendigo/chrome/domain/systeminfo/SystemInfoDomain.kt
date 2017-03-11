package pl.wendigo.chrome.domain.systeminfo

/**
 * The SystemInfo domain defines methods and events for querying low-level system information.
 */
@pl.wendigo.chrome.ProtocolExperimental class SystemInfoDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Returns information about the system.
	 */
	  fun getInfo() : io.reactivex.Flowable<GetInfoResponse> {
        return connection.runAndCaptureResponse("SystemInfo.getInfo", null, GetInfoResponse::class.java)
	}

  }


/**
 * Represents responseFrame from SystemInfo. method call.
 *
 * Returns information about the system.
 */
data class GetInfoResponse(
  /**
   * Information about the GPUs on the system.
   */
  val gpu : GPUInfo,

  /**
   * A platform-dependent description of the model of the machine. On Mac OS, this is, for example, 'MacBookPro'. Will be the empty string if not supported.
   */
  val modelName : String,

  /**
   * A platform-dependent description of the version of the machine. On Mac OS, this is, for example, '10.1'. Will be the empty string if not supported.
   */
  val modelVersion : String

)


