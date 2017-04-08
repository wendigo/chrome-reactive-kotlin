package pl.wendigo.chrome.domain.rendering

/**
 * This domain allows to control rendering of the page.
 */
@pl.wendigo.chrome.Experimental class RenderingDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * Requests that backend shows paint rectangles
	 */
	  fun setShowPaintRects(input : SetShowPaintRectsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Rendering.setShowPaintRects", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Requests that backend shows debug borders on layers
	 */
	  fun setShowDebugBorders(input : SetShowDebugBordersRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Rendering.setShowDebugBorders", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Requests that backend shows the FPS counter
	 */
	  fun setShowFPSCounter(input : SetShowFPSCounterRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Rendering.setShowFPSCounter", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Requests that backend shows scroll bottleneck rects
	 */
	  fun setShowScrollBottleneckRects(input : SetShowScrollBottleneckRectsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Rendering.setShowScrollBottleneckRects", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Paints viewport size upon main frame resize.
	 */
	  fun setShowViewportSizeOnResize(input : SetShowViewportSizeOnResizeRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Rendering.setShowViewportSizeOnResize", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
    /**
     * Returns flowable capturing all Rendering domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "Rendering"
        }
    }
}
/**
 * Represents requestFrame parameters that can be used with Rendering.setShowPaintRects method call.
 *
 * Requests that backend shows paint rectangles
 */
data class SetShowPaintRectsRequest (
    /**
     * True for showing paint rectangles
     */
    val result : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Rendering.setShowDebugBorders method call.
 *
 * Requests that backend shows debug borders on layers
 */
data class SetShowDebugBordersRequest (
    /**
     * True for showing debug borders
     */
    val show : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Rendering.setShowFPSCounter method call.
 *
 * Requests that backend shows the FPS counter
 */
data class SetShowFPSCounterRequest (
    /**
     * True for showing the FPS counter
     */
    val show : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Rendering.setShowScrollBottleneckRects method call.
 *
 * Requests that backend shows scroll bottleneck rects
 */
data class SetShowScrollBottleneckRectsRequest (
    /**
     * True for showing scroll bottleneck rects
     */
    val show : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Rendering.setShowViewportSizeOnResize method call.
 *
 * Paints viewport size upon main frame resize.
 */
data class SetShowViewportSizeOnResizeRequest (
    /**
     * Whether to paint size or not.
     */
    val show : Boolean

)


