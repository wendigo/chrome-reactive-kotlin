package pl.wendigo.chrome.domain.browser

/**
 * The Browser domain defines methods and events for browser managing.
 */
@pl.wendigo.chrome.Experimental class BrowserDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * Get the browser window that contains the devtools target.
	 */
	 fun getWindowForTarget(input : GetWindowForTargetRequest) : io.reactivex.Single<GetWindowForTargetResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getWindowForTarget", input, GetWindowForTargetResponse::class.java).map {
            it.value()
        }
	}

    /**
     * Get the browser window that contains the devtools target.
    */
     fun getWindowForTargetTimed(input : GetWindowForTargetRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<GetWindowForTargetResponse>> {
        return connectionRemote.runAndCaptureResponse("Browser.getWindowForTarget", input, GetWindowForTargetResponse::class.java)
    }

	/**
	 * Set position and/or size of the browser window.
	 */
	 fun setWindowBounds(input : SetWindowBoundsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Browser.setWindowBounds", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * Set position and/or size of the browser window.
    */
     fun setWindowBoundsTimed(input : SetWindowBoundsRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("Browser.setWindowBounds", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * Get position and size of the browser window.
	 */
	 fun getWindowBounds(input : GetWindowBoundsRequest) : io.reactivex.Single<GetWindowBoundsResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getWindowBounds", input, GetWindowBoundsResponse::class.java).map {
            it.value()
        }
	}

    /**
     * Get position and size of the browser window.
    */
     fun getWindowBoundsTimed(input : GetWindowBoundsRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<GetWindowBoundsResponse>> {
        return connectionRemote.runAndCaptureResponse("Browser.getWindowBounds", input, GetWindowBoundsResponse::class.java)
    }

  
    /**
     * Returns flowable capturing all Browser domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Browser"
        }
    }
}
/**
 * Represents requestFrame parameters that can be used with Browser.getWindowForTarget method call.
 *
 * Get the browser window that contains the devtools target.
 */
data class GetWindowForTargetRequest (
    /**
     * Devtools agent host id.
     */
    val targetId : pl.wendigo.chrome.domain.target.TargetID

)

/**
 * Represents responseFrame from Browser. method call.
 *
 * Get the browser window that contains the devtools target.
 */
data class GetWindowForTargetResponse(
  /**
   * Browser window id.
   */
  val windowId : WindowID,

  /**
   * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
   */
  val bounds : Bounds

)

/**
 * Represents requestFrame parameters that can be used with Browser.setWindowBounds method call.
 *
 * Set position and/or size of the browser window.
 */
data class SetWindowBoundsRequest (
    /**
     * Browser window id.
     */
    val windowId : WindowID,

    /**
     * New window bounds. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined with 'left', 'top', 'width' or 'height'. Leaves unspecified fields unchanged.
     */
    val bounds : Bounds

)


/**
 * Represents requestFrame parameters that can be used with Browser.getWindowBounds method call.
 *
 * Get position and size of the browser window.
 */
data class GetWindowBoundsRequest (
    /**
     * Browser window id.
     */
    val windowId : WindowID

)

/**
 * Represents responseFrame from Browser. method call.
 *
 * Get position and size of the browser window.
 */
data class GetWindowBoundsResponse(
  /**
   * Bounds information of the window. When window state is 'minimized', the restored window position and size are returned.
   */
  val bounds : Bounds

)

