package pl.wendigo.chrome.domain.memory

/**
 * MemoryDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class MemoryDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * 
	 */
	  fun getDOMCounters() : io.reactivex.Flowable<GetDOMCountersResponse> {
        return connectionRemote.runAndCaptureResponse("Memory.getDOMCounters", null, GetDOMCountersResponse::class.java)
	}

	/**
	 * Enable/disable suppressing memory pressure notifications in all processes.
	 */
	  fun setPressureNotificationsSuppressed(input : SetPressureNotificationsSuppressedRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.setPressureNotificationsSuppressed", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Simulate a memory pressure notification in all processes.
	 */
	  fun simulatePressureNotification(input : SimulatePressureNotificationRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.simulatePressureNotification", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
    /**
     * Returns flowable capturing all Memory domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "Memory"
        }
    }
}

/**
 * Represents responseFrame from Memory. method call.
 *
 * 
 */
data class GetDOMCountersResponse(
  /**
   * 
   */
  val documents : Int,

  /**
   * 
   */
  val nodes : Int,

  /**
   * 
   */
  val jsEventListeners : Int

)

/**
 * Represents requestFrame parameters that can be used with Memory.setPressureNotificationsSuppressed method call.
 *
 * Enable/disable suppressing memory pressure notifications in all processes.
 */
data class SetPressureNotificationsSuppressedRequest (
    /**
     * If true, memory pressure notifications will be suppressed.
     */
    val suppressed : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Memory.simulatePressureNotification method call.
 *
 * Simulate a memory pressure notification in all processes.
 */
data class SimulatePressureNotificationRequest (
    /**
     * Memory pressure level of the notification.
     */
    val level : PressureLevel

)


