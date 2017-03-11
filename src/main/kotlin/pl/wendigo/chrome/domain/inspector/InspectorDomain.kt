package pl.wendigo.chrome.domain.inspector

/**
 * InspectorDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.Experimental class InspectorDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * Enables inspector domain notifications.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Inspector.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables inspector domain notifications.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Inspector.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
    /**
     * Fired when remote debugging connection is about to be terminated. Contains detach reason.
     */
    fun detached() : io.reactivex.Flowable<DetachedEvent> {
        return connectionRemote.captureEvents("Inspector.detached", DetachedEvent::class.java)
    }

    /**
     * Fired when debugging target has crashed
     */
    fun targetCrashed() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureEvents("Inspector.targetCrashed", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Returns flowable capturing all Inspector domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "Inspector"
        }
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Inspector", name = "detached")


