package pl.wendigo.chrome.domain.headlessexperimental

/**
 * This domain provides experimental commands only supported in headless mode.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental)
 */
class HeadlessExperimental internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
screenshot from the resulting frame. Requires that the target was created with enabled
BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
https://goo.gl/3zHXhB for more background.
     */
    fun beginFrame(input: BeginFrameRequest): io.reactivex.Single<BeginFrameResponse> {
        return connectionRemote.runAndCaptureResponse("HeadlessExperimental.beginFrame", input, BeginFrameResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Disables headless events for the target.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeadlessExperimental.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables headless events for the target.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeadlessExperimental.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Issued when the target starts or stops needing BeginFrames.
Deprecated. Issue beginFrame unconditionally instead and use result from
beginFrame to detect whether the frames were suppressed.
     */
    fun needsBeginFramesChanged(): io.reactivex.Flowable<NeedsBeginFramesChangedEvent> {
        return needsBeginFramesChangedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when the target starts or stops needing BeginFrames.
Deprecated. Issue beginFrame unconditionally instead and use result from
beginFrame to detect whether the frames were suppressed.
     */
    fun needsBeginFramesChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NeedsBeginFramesChangedEvent>> {
        return connectionRemote.captureEvents("HeadlessExperimental.needsBeginFramesChanged", NeedsBeginFramesChangedEvent::class.java)
    }

    /**
     * Returns flowable capturing all HeadlessExperimental domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "HeadlessExperimental"
        }
    }
}
/**
 * Represents request frame that can be used with HeadlessExperimental.beginFrame method call.
 *
 * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
screenshot from the resulting frame. Requires that the target was created with enabled
BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
https://goo.gl/3zHXhB for more background.
 */
data class BeginFrameRequest(
    /**
     * Timestamp of this BeginFrame in Renderer TimeTicks (milliseconds of uptime). If not set,
the current time will be used.
     */
    val frameTimeTicks: Double? = null,

    /**
     * The interval between BeginFrames that is reported to the compositor, in milliseconds.
Defaults to a 60 frames/second interval, i.e. about 16.666 milliseconds.
     */
    val interval: Double? = null,

    /**
     * Whether updates should not be committed and drawn onto the display. False by default. If
true, only side effects of the BeginFrame will be run, such as layout and animations, but
any visual updates may not be visible on the display or in screenshots.
     */
    val noDisplayUpdates: Boolean? = null,

    /**
     * If set, a screenshot of the frame will be captured and returned in the response. Otherwise,
no screenshot will be captured. Note that capturing a screenshot can fail, for example,
during renderer initialization. In such a case, no screenshot data will be returned.
     */
    val screenshot: ScreenshotParams? = null

)

/**
 * Represents response frame for HeadlessExperimental.beginFrame method call.
 *
 * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
screenshot from the resulting frame. Requires that the target was created with enabled
BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
https://goo.gl/3zHXhB for more background.
 */
data class BeginFrameResponse(
    /**  
     * Whether the BeginFrame resulted in damage and, thus, a new frame was committed to the  
     display. Reported for diagnostic uses, may be removed in the future.  
     */  
    val hasDamage: Boolean,

    /**  
     * Base64-encoded image data of the screenshot, if one was requested and successfully taken.  
     */  
    val screenshotData: String? = null

)

/**
 * Represents event frames for HeadlessExperimental.needsBeginFramesChanged
 *
 * Issued when the target starts or stops needing BeginFrames.
Deprecated. Issue beginFrame unconditionally instead and use result from
beginFrame to detect whether the frames were suppressed.
 */
data class NeedsBeginFramesChangedEvent(
    /**  
     * True if BeginFrames are needed, false otherwise.  
     */  
    val needsBeginFrames: Boolean

) : pl.wendigo.chrome.ProtocolEvent(domain = "HeadlessExperimental", name = "needsBeginFramesChanged")
