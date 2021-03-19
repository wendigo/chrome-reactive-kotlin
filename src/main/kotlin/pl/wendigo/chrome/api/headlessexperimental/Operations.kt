package pl.wendigo.chrome.api.headlessexperimental

/**
 * This domain provides experimental commands only supported in headless mode.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [HeadlessExperimental](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class HeadlessExperimentalOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
screenshot from the resulting frame. Requires that the target was created with enabled
BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
https://goo.gl/3zHXhB for more background.
     *
     * @link Protocol [HeadlessExperimental#beginFrame](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-beginFrame) method documentation.
     */
    fun beginFrame(input: BeginFrameRequest) = connection.request("HeadlessExperimental.beginFrame", input, BeginFrameResponse::class.java)

    /**
     * Disables headless events for the target.
     *
     * @link Protocol [HeadlessExperimental#disable](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-disable) method documentation.
     */
    fun disable() = connection.request("HeadlessExperimental.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables headless events for the target.
     *
     * @link Protocol [HeadlessExperimental#enable](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-enable) method documentation.
     */
    fun enable() = connection.request("HeadlessExperimental.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Issued when the target starts or stops needing BeginFrames.
Deprecated. Issue beginFrame unconditionally instead and use result from
beginFrame to detect whether the frames were suppressed.
     */
    fun needsBeginFramesChanged(): io.reactivex.rxjava3.core.Flowable<NeedsBeginFramesChangedEvent> = connection.events("HeadlessExperimental.needsBeginFramesChanged", NeedsBeginFramesChangedEvent::class.java)

    /**
     * Returns flowable capturing all HeadlessExperimental domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "HeadlessExperimental"
        }
    }
}

/**
 * Represents request frame that can be used with [HeadlessExperimental#beginFrame](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-beginFrame) operation call.
 *
 * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
screenshot from the resulting frame. Requires that the target was created with enabled
BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
https://goo.gl/3zHXhB for more background.
 * @link [HeadlessExperimental#beginFrame](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-beginFrame) method documentation.
 * @see [HeadlessExperimentalOperations.beginFrame]
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
 * Represents response frame that is returned from [HeadlessExperimental#beginFrame](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-beginFrame) operation call.
 * Sends a BeginFrame to the target and returns when the frame was completed. Optionally captures a
screenshot from the resulting frame. Requires that the target was created with enabled
BeginFrameControl. Designed for use with --run-all-compositor-stages-before-draw, see also
https://goo.gl/3zHXhB for more background.
 *
  
 * @link [HeadlessExperimental#beginFrame](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#method-beginFrame) method documentation.
 * @see [HeadlessExperimentalOperations.beginFrame]
 */
data class BeginFrameResponse(
    /**  
     * Whether the BeginFrame resulted in damage and, thus, a new frame was committed to the  
     display. Reported for diagnostic uses, may be removed in the future.  
     */  
    val hasDamage: Boolean,

    /**  
     * Base64-encoded image data of the screenshot, if one was requested and successfully taken. (Encoded as a base64 string when passed over JSON)  
     */  
    val screenshotData: String? = null

)

/**
 * Issued when the target starts or stops needing BeginFrames.
Deprecated. Issue beginFrame unconditionally instead and use result from
beginFrame to detect whether the frames were suppressed.
 *
 * @link [HeadlessExperimental#needsBeginFramesChanged](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#event-needsBeginFramesChanged) event documentation.
 */
data class NeedsBeginFramesChangedEvent(
    /**  
     * True if BeginFrames are needed, false otherwise.  
     */  
    val needsBeginFrames: Boolean

) : pl.wendigo.chrome.protocol.Event(domain = "HeadlessExperimental", name = "needsBeginFramesChanged")
