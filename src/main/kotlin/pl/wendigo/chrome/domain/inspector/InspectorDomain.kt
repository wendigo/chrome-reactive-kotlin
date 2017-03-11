package pl.wendigo.chrome.domain.inspector

/**
 * InspectorDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class InspectorDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables inspector domain notifications.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Inspector.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables inspector domain notifications.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Inspector.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
  /**
   * Fired when remote debugging connection is about to be terminated. Contains detach reason.
   */
   fun detached() : io.reactivex.Flowable<DetachedEvent> {
      return connection.captureEvents("Inspector.detached", DetachedEvent::class.java)
   }

  /**
   * Fired when debugging target has crashed
   */
   fun targetCrashed() : io.reactivex.Flowable<pl.wendigo.chrome.DebuggerEvent> {
      return connection.captureEvents("Inspector.targetCrashed", pl.wendigo.chrome.DebuggerEvent::class.java)
   }
}






/**
 * Represents responseFrame from Inspector. method call.
 *
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 */
data class DetachedEvent(
  /**
   * The reason why connection has been terminated.
   */
  val reason : String

) : pl.wendigo.chrome.DebuggerEvent(domain = "Inspector", name = "detached")


