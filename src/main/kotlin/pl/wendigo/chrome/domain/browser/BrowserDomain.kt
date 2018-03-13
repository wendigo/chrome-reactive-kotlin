package pl.wendigo.chrome.domain.browser

/**
 * The Browser domain defines methods and events for browser managing.
 */
class BrowserDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Close browser gracefully.
     */
    fun close() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Browser.close", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns version information.
     */
    fun getVersion() : io.reactivex.Single<GetVersionResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getVersion", null, GetVersionResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the command line switches for the browser process if, and only if
--enable-automation is on the commandline.
     */
    fun getBrowserCommandLine() : io.reactivex.Single<GetBrowserCommandLineResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getBrowserCommandLine", null, GetBrowserCommandLineResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Get Chrome histograms.
     */
    fun getHistograms(input : GetHistogramsRequest) : io.reactivex.Single<GetHistogramsResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getHistograms", input, GetHistogramsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Get a Chrome histogram by name.
     */
    fun getHistogram(input : GetHistogramRequest) : io.reactivex.Single<GetHistogramResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getHistogram", input, GetHistogramResponse::class.java).map {
            it.value()
        }
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
     * Get the browser window that contains the devtools target.
     */
    fun getWindowForTarget(input : GetWindowForTargetRequest) : io.reactivex.Single<GetWindowForTargetResponse> {
        return connectionRemote.runAndCaptureResponse("Browser.getWindowForTarget", input, GetWindowForTargetResponse::class.java).map {
            it.value()
        }
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
     * Returns flowable capturing all Browser domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Browser"
        }
    }
}

/**
 * Represents response frame for Browser.getVersion method call.
 *
 * Returns version information.
 */
data class GetVersionResponse(
  /**
   * Protocol version.
   */
  val protocolVersion : String,

  /**
   * Product name.
   */
  val product : String,

  /**
   * Product revision.
   */
  val revision : String,

  /**
   * User-Agent.
   */
  val userAgent : String,

  /**
   * V8 version.
   */
  val jsVersion : String

)

/**
 * Represents response frame for Browser.getBrowserCommandLine method call.
 *
 * Returns the command line switches for the browser process if, and only if
--enable-automation is on the commandline.
 */
data class GetBrowserCommandLineResponse(
  /**
   * Commandline parameters
   */
  val arguments : List<String>

)

/**
 * Represents request frame that can be used with Browser.getHistograms method call.
 *
 * Get Chrome histograms.
 */
data class GetHistogramsRequest (
    /**
     * Requested substring in name. Only histograms which have query as a
substring in their name are extracted. An empty or absent query returns
all histograms.
     */
    val query : String? = null

)

/**
 * Represents response frame for Browser.getHistograms method call.
 *
 * Get Chrome histograms.
 */
data class GetHistogramsResponse(
  /**
   * Histograms.
   */
  val histograms : List<Histogram>

)

/**
 * Represents request frame that can be used with Browser.getHistogram method call.
 *
 * Get a Chrome histogram by name.
 */
data class GetHistogramRequest (
    /**
     * Requested histogram name.
     */
    val name : String

)

/**
 * Represents response frame for Browser.getHistogram method call.
 *
 * Get a Chrome histogram by name.
 */
data class GetHistogramResponse(
  /**
   * Histogram.
   */
  val histogram : Histogram

)

/**
 * Represents request frame that can be used with Browser.getWindowBounds method call.
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
 * Represents response frame for Browser.getWindowBounds method call.
 *
 * Get position and size of the browser window.
 */
data class GetWindowBoundsResponse(
  /**
   * Bounds information of the window. When window state is 'minimized', the restored window
position and size are returned.
   */
  val bounds : Bounds

)

/**
 * Represents request frame that can be used with Browser.getWindowForTarget method call.
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
 * Represents response frame for Browser.getWindowForTarget method call.
 *
 * Get the browser window that contains the devtools target.
 */
data class GetWindowForTargetResponse(
  /**
   * Browser window id.
   */
  val windowId : WindowID,

  /**
   * Bounds information of the window. When window state is 'minimized', the restored window
position and size are returned.
   */
  val bounds : Bounds

)

/**
 * Represents request frame that can be used with Browser.setWindowBounds method call.
 *
 * Set position and/or size of the browser window.
 */
data class SetWindowBoundsRequest (
    /**
     * Browser window id.
     */
    val windowId : WindowID,

    /**
     * New window bounds. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined
with 'left', 'top', 'width' or 'height'. Leaves unspecified fields unchanged.
     */
    val bounds : Bounds

)

