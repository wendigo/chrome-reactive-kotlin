package pl.wendigo.chrome.api.overlay

/**
 * This domain provides various functionality related to drawing atop the inspected page.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Overlay](https://chromedevtools.github.io/devtools-protocol/tot/Overlay) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class OverlayOperations internal constructor(private val connection : pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables domain notifications.
     *
     * @link Protocol [Overlay#disable](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-disable) method documentation.
     */
        fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Enables domain notifications.
     *
     * @link Protocol [Overlay#enable](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-enable) method documentation.
     */
        fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * For testing.
     *
     * @link Protocol [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) method documentation.
     */
        fun getHighlightObjectForTest(input: GetHighlightObjectForTestRequest): io.reactivex.Single<GetHighlightObjectForTestResponse> = connection.runAndCaptureResponse("Overlay.getHighlightObjectForTest", input, GetHighlightObjectForTestResponse::class.java)


    /**
     * Hides any highlight.
     *
     * @link Protocol [Overlay#hideHighlight](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-hideHighlight) method documentation.
     */
        fun hideHighlight(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.hideHighlight", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Highlights owner element of the frame with given id.
     *
     * @link Protocol [Overlay#highlightFrame](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightFrame) method documentation.
     */
        fun highlightFrame(input: HighlightFrameRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.highlightFrame", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
objectId must be specified.
     *
     * @link Protocol [Overlay#highlightNode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightNode) method documentation.
     */
        fun highlightNode(input: HighlightNodeRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.highlightNode", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
     *
     * @link Protocol [Overlay#highlightQuad](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightQuad) method documentation.
     */
        fun highlightQuad(input: HighlightQuadRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.highlightQuad", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
     *
     * @link Protocol [Overlay#highlightRect](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightRect) method documentation.
     */
        fun highlightRect(input: HighlightRectRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.highlightRect", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
Backend then generates 'inspectNodeRequested' event upon element selection.
     *
     * @link Protocol [Overlay#setInspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setInspectMode) method documentation.
     */
        fun setInspectMode(input: SetInspectModeRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setInspectMode", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Highlights owner element of all frames detected to be ads.
     *
     * @link Protocol [Overlay#setShowAdHighlights](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowAdHighlights) method documentation.
     */
        fun setShowAdHighlights(input: SetShowAdHighlightsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowAdHighlights", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *
     *
     * @link Protocol [Overlay#setPausedInDebuggerMessage](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setPausedInDebuggerMessage) method documentation.
     */
        fun setPausedInDebuggerMessage(input: SetPausedInDebuggerMessageRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setPausedInDebuggerMessage", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Requests that backend shows debug borders on layers
     *
     * @link Protocol [Overlay#setShowDebugBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowDebugBorders) method documentation.
     */
        fun setShowDebugBorders(input: SetShowDebugBordersRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowDebugBorders", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Requests that backend shows the FPS counter
     *
     * @link Protocol [Overlay#setShowFPSCounter](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFPSCounter) method documentation.
     */
        fun setShowFPSCounter(input: SetShowFPSCounterRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowFPSCounter", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Requests that backend shows paint rectangles
     *
     * @link Protocol [Overlay#setShowPaintRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowPaintRects) method documentation.
     */
        fun setShowPaintRects(input: SetShowPaintRectsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowPaintRects", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Requests that backend shows layout shift regions
     *
     * @link Protocol [Overlay#setShowLayoutShiftRegions](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowLayoutShiftRegions) method documentation.
     */
        fun setShowLayoutShiftRegions(input: SetShowLayoutShiftRegionsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowLayoutShiftRegions", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Requests that backend shows scroll bottleneck rects
     *
     * @link Protocol [Overlay#setShowScrollBottleneckRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowScrollBottleneckRects) method documentation.
     */
        fun setShowScrollBottleneckRects(input: SetShowScrollBottleneckRectsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowScrollBottleneckRects", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Requests that backend shows hit-test borders on layers
     *
     * @link Protocol [Overlay#setShowHitTestBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHitTestBorders) method documentation.
     */
        fun setShowHitTestBorders(input: SetShowHitTestBordersRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowHitTestBorders", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Paints viewport size upon main frame resize.
     *
     * @link Protocol [Overlay#setShowViewportSizeOnResize](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowViewportSizeOnResize) method documentation.
     */
        fun setShowViewportSizeOnResize(input: SetShowViewportSizeOnResizeRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Overlay.setShowViewportSizeOnResize", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *  Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
     */
    fun inspectNodeRequested(): io.reactivex.Flowable<InspectNodeRequestedEvent> = connection.captureEvents("Overlay.inspectNodeRequested", InspectNodeRequestedEvent::class.java);

    /**
     *  Fired when the node should be highlighted. This happens after call to `setInspectMode`.
     */
    fun nodeHighlightRequested(): io.reactivex.Flowable<NodeHighlightRequestedEvent> = connection.captureEvents("Overlay.nodeHighlightRequested", NodeHighlightRequestedEvent::class.java);

    /**
     *  Fired when user asks to capture screenshot of some area on the page.
     */
    fun screenshotRequested(): io.reactivex.Flowable<ScreenshotRequestedEvent> = connection.captureEvents("Overlay.screenshotRequested", ScreenshotRequestedEvent::class.java);

    /**
     *  Fired when user cancels the inspect mode.
     */
    fun inspectModeCanceled(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.captureEvents("Overlay.inspectModeCanceled", pl.wendigo.chrome.protocol.Event::class.java);


    /**
     * Returns flowable capturing all Overlay domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "Overlay"
        }
    }
}




/**
 * Represents request frame that can be used with [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) operation call.
 *
 * For testing.
 * @link [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) method documentation.
 * @see [OverlayOperations.getHighlightObjectForTest]
 */
data class GetHighlightObjectForTestRequest (
    /**
     * Id of the node to get highlight object for.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId,

    /**
     * Whether to include distance info.
     */
    val includeDistance: Boolean? = null,

    /**
     * Whether to include style info.
     */
    val includeStyle: Boolean? = null

)
/**
 * Represents response frame that is returned from [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) operation call.
 * For testing.
 *
  
  * @link [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) method documentation.
  * @see [OverlayOperations.getHighlightObjectForTest]
 */
data class GetHighlightObjectForTestResponse(
  /**
   * Highlight data for the node.
   */
  val highlight: com.fasterxml.jackson.databind.JsonNode

)



/**
 * Represents request frame that can be used with [Overlay#highlightFrame](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightFrame) operation call.
 *
 * Highlights owner element of the frame with given id.
 * @link [Overlay#highlightFrame](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightFrame) method documentation.
 * @see [OverlayOperations.highlightFrame]
 */
data class HighlightFrameRequest (
    /**
     * Identifier of the frame to highlight.
     */
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**
     * The content box highlight fill color (default: transparent).
     */
    val contentColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**
     * The content box highlight outline color (default: transparent).
     */
    val contentOutlineColor: pl.wendigo.chrome.api.dom.RGBA? = null

)

/**
 * Represents request frame that can be used with [Overlay#highlightNode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightNode) operation call.
 *
 * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
objectId must be specified.
 * @link [Overlay#highlightNode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightNode) method documentation.
 * @see [OverlayOperations.highlightNode]
 */
data class HighlightNodeRequest (
    /**
     * A descriptor for the highlight appearance.
     */
    val highlightConfig: HighlightConfig,

    /**
     * Identifier of the node to highlight.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId? = null,

    /**
     * Identifier of the backend node to highlight.
     */
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

    /**
     * JavaScript object id of the node to be highlighted.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null,

    /**
     * Selectors to highlight relevant nodes.
     */
    val selector: String? = null

)

/**
 * Represents request frame that can be used with [Overlay#highlightQuad](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightQuad) operation call.
 *
 * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
 * @link [Overlay#highlightQuad](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightQuad) method documentation.
 * @see [OverlayOperations.highlightQuad]
 */
data class HighlightQuadRequest (
    /**
     * Quad to highlight
     */
    val quad: pl.wendigo.chrome.api.dom.Quad,

    /**
     * The highlight fill color (default: transparent).
     */
    val color: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor: pl.wendigo.chrome.api.dom.RGBA? = null

)

/**
 * Represents request frame that can be used with [Overlay#highlightRect](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightRect) operation call.
 *
 * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
 * @link [Overlay#highlightRect](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightRect) method documentation.
 * @see [OverlayOperations.highlightRect]
 */
data class HighlightRectRequest (
    /**
     * X coordinate
     */
    val x: Int,

    /**
     * Y coordinate
     */
    val y: Int,

    /**
     * Rectangle width
     */
    val width: Int,

    /**
     * Rectangle height
     */
    val height: Int,

    /**
     * The highlight fill color (default: transparent).
     */
    val color: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor: pl.wendigo.chrome.api.dom.RGBA? = null

)

/**
 * Represents request frame that can be used with [Overlay#setInspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setInspectMode) operation call.
 *
 * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
Backend then generates 'inspectNodeRequested' event upon element selection.
 * @link [Overlay#setInspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setInspectMode) method documentation.
 * @see [OverlayOperations.setInspectMode]
 */
data class SetInspectModeRequest (
    /**
     * Set an inspection mode.
     */
    val mode: InspectMode,

    /**
     * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled
== false`.
     */
    val highlightConfig: HighlightConfig? = null

)

/**
 * Represents request frame that can be used with [Overlay#setShowAdHighlights](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowAdHighlights) operation call.
 *
 * Highlights owner element of all frames detected to be ads.
 * @link [Overlay#setShowAdHighlights](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowAdHighlights) method documentation.
 * @see [OverlayOperations.setShowAdHighlights]
 */
data class SetShowAdHighlightsRequest (
    /**
     * True for showing ad highlights
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setPausedInDebuggerMessage](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setPausedInDebuggerMessage) operation call.
 *
 *
 * @link [Overlay#setPausedInDebuggerMessage](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setPausedInDebuggerMessage) method documentation.
 * @see [OverlayOperations.setPausedInDebuggerMessage]
 */
data class SetPausedInDebuggerMessageRequest (
    /**
     * The message to display, also triggers resume and step over controls.
     */
    val message: String? = null

)

/**
 * Represents request frame that can be used with [Overlay#setShowDebugBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowDebugBorders) operation call.
 *
 * Requests that backend shows debug borders on layers
 * @link [Overlay#setShowDebugBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowDebugBorders) method documentation.
 * @see [OverlayOperations.setShowDebugBorders]
 */
data class SetShowDebugBordersRequest (
    /**
     * True for showing debug borders
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowFPSCounter](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFPSCounter) operation call.
 *
 * Requests that backend shows the FPS counter
 * @link [Overlay#setShowFPSCounter](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFPSCounter) method documentation.
 * @see [OverlayOperations.setShowFPSCounter]
 */
data class SetShowFPSCounterRequest (
    /**
     * True for showing the FPS counter
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowPaintRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowPaintRects) operation call.
 *
 * Requests that backend shows paint rectangles
 * @link [Overlay#setShowPaintRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowPaintRects) method documentation.
 * @see [OverlayOperations.setShowPaintRects]
 */
data class SetShowPaintRectsRequest (
    /**
     * True for showing paint rectangles
     */
    val result: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowLayoutShiftRegions](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowLayoutShiftRegions) operation call.
 *
 * Requests that backend shows layout shift regions
 * @link [Overlay#setShowLayoutShiftRegions](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowLayoutShiftRegions) method documentation.
 * @see [OverlayOperations.setShowLayoutShiftRegions]
 */
data class SetShowLayoutShiftRegionsRequest (
    /**
     * True for showing layout shift regions
     */
    val result: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowScrollBottleneckRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowScrollBottleneckRects) operation call.
 *
 * Requests that backend shows scroll bottleneck rects
 * @link [Overlay#setShowScrollBottleneckRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowScrollBottleneckRects) method documentation.
 * @see [OverlayOperations.setShowScrollBottleneckRects]
 */
data class SetShowScrollBottleneckRectsRequest (
    /**
     * True for showing scroll bottleneck rects
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowHitTestBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHitTestBorders) operation call.
 *
 * Requests that backend shows hit-test borders on layers
 * @link [Overlay#setShowHitTestBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHitTestBorders) method documentation.
 * @see [OverlayOperations.setShowHitTestBorders]
 */
data class SetShowHitTestBordersRequest (
    /**
     * True for showing hit-test borders
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowViewportSizeOnResize](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowViewportSizeOnResize) operation call.
 *
 * Paints viewport size upon main frame resize.
 * @link [Overlay#setShowViewportSizeOnResize](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowViewportSizeOnResize) method documentation.
 * @see [OverlayOperations.setShowViewportSizeOnResize]
 */
data class SetShowViewportSizeOnResizeRequest (
    /**
     * Whether to paint size or not.
     */
    val show: Boolean

)

/**
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
 *
 * @link [Overlay#inspectNodeRequested](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#event-inspectNodeRequested) event documentation.
   */
data class InspectNodeRequestedEvent(
  /**
   * Id of the node to inspect.
   */
  val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId

): pl.wendigo.chrome.protocol.Event(domain = "Overlay", name = "inspectNodeRequested")

/**
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 *
 * @link [Overlay#nodeHighlightRequested](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#event-nodeHighlightRequested) event documentation.
   */
data class NodeHighlightRequestedEvent(
  /**
   *
   */
  val nodeId: pl.wendigo.chrome.api.dom.NodeId

): pl.wendigo.chrome.protocol.Event(domain = "Overlay", name = "nodeHighlightRequested")

/**
 * Fired when user asks to capture screenshot of some area on the page.
 *
 * @link [Overlay#screenshotRequested](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#event-screenshotRequested) event documentation.
   */
data class ScreenshotRequestedEvent(
  /**
   * Viewport to capture, in device independent pixels (dip).
   */
  val viewport: pl.wendigo.chrome.api.page.Viewport

): pl.wendigo.chrome.protocol.Event(domain = "Overlay", name = "screenshotRequested")


