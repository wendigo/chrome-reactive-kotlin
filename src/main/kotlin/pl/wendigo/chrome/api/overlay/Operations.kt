package pl.wendigo.chrome.api.overlay

import kotlinx.serialization.json.Json

/**
 * This domain provides various functionality related to drawing atop the inspected page.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Overlay](https://chromedevtools.github.io/devtools-protocol/tot/Overlay) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class OverlayOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables domain notifications.
     *
     * @link Protocol [Overlay#disable](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-disable) method documentation.
     */
    fun disable() = connection.request("Overlay.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables domain notifications.
     *
     * @link Protocol [Overlay#enable](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-enable) method documentation.
     */
    fun enable() = connection.request("Overlay.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * For testing.
     *
     * @link Protocol [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) method documentation.
     */
    fun getHighlightObjectForTest(input: GetHighlightObjectForTestRequest) = connection.request("Overlay.getHighlightObjectForTest", Json.encodeToJsonElement(GetHighlightObjectForTestRequest.serializer(), input), GetHighlightObjectForTestResponse.serializer())

    /**
     * For Persistent Grid testing.
     *
     * @link Protocol [Overlay#getGridHighlightObjectsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getGridHighlightObjectsForTest) method documentation.
     */
    fun getGridHighlightObjectsForTest(input: GetGridHighlightObjectsForTestRequest) = connection.request("Overlay.getGridHighlightObjectsForTest", Json.encodeToJsonElement(GetGridHighlightObjectsForTestRequest.serializer(), input), GetGridHighlightObjectsForTestResponse.serializer())

    /**
     * For Source Order Viewer testing.
     *
     * @link Protocol [Overlay#getSourceOrderHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getSourceOrderHighlightObjectForTest) method documentation.
     */
    fun getSourceOrderHighlightObjectForTest(input: GetSourceOrderHighlightObjectForTestRequest) = connection.request("Overlay.getSourceOrderHighlightObjectForTest", Json.encodeToJsonElement(GetSourceOrderHighlightObjectForTestRequest.serializer(), input), GetSourceOrderHighlightObjectForTestResponse.serializer())

    /**
     * Hides any highlight.
     *
     * @link Protocol [Overlay#hideHighlight](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-hideHighlight) method documentation.
     */
    fun hideHighlight() = connection.request("Overlay.hideHighlight", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlights owner element of the frame with given id.
     *
     * @link Protocol [Overlay#highlightFrame](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightFrame) method documentation.
     */
    fun highlightFrame(input: HighlightFrameRequest) = connection.request("Overlay.highlightFrame", Json.encodeToJsonElement(HighlightFrameRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
objectId must be specified.
     *
     * @link Protocol [Overlay#highlightNode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightNode) method documentation.
     */
    fun highlightNode(input: HighlightNodeRequest) = connection.request("Overlay.highlightNode", Json.encodeToJsonElement(HighlightNodeRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
     *
     * @link Protocol [Overlay#highlightQuad](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightQuad) method documentation.
     */
    fun highlightQuad(input: HighlightQuadRequest) = connection.request("Overlay.highlightQuad", Json.encodeToJsonElement(HighlightQuadRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
     *
     * @link Protocol [Overlay#highlightRect](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightRect) method documentation.
     */
    fun highlightRect(input: HighlightRectRequest) = connection.request("Overlay.highlightRect", Json.encodeToJsonElement(HighlightRectRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlights the source order of the children of the DOM node with given id or with the given
JavaScript object wrapper. Either nodeId or objectId must be specified.
     *
     * @link Protocol [Overlay#highlightSourceOrder](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightSourceOrder) method documentation.
     */
    fun highlightSourceOrder(input: HighlightSourceOrderRequest) = connection.request("Overlay.highlightSourceOrder", Json.encodeToJsonElement(HighlightSourceOrderRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
Backend then generates 'inspectNodeRequested' event upon element selection.
     *
     * @link Protocol [Overlay#setInspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setInspectMode) method documentation.
     */
    fun setInspectMode(input: SetInspectModeRequest) = connection.request("Overlay.setInspectMode", Json.encodeToJsonElement(SetInspectModeRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlights owner element of all frames detected to be ads.
     *
     * @link Protocol [Overlay#setShowAdHighlights](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowAdHighlights) method documentation.
     */
    fun setShowAdHighlights(input: SetShowAdHighlightsRequest) = connection.request("Overlay.setShowAdHighlights", Json.encodeToJsonElement(SetShowAdHighlightsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [Overlay#setPausedInDebuggerMessage](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setPausedInDebuggerMessage) method documentation.
     */
    fun setPausedInDebuggerMessage(input: SetPausedInDebuggerMessageRequest) = connection.request("Overlay.setPausedInDebuggerMessage", Json.encodeToJsonElement(SetPausedInDebuggerMessageRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Requests that backend shows debug borders on layers
     *
     * @link Protocol [Overlay#setShowDebugBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowDebugBorders) method documentation.
     */
    fun setShowDebugBorders(input: SetShowDebugBordersRequest) = connection.request("Overlay.setShowDebugBorders", Json.encodeToJsonElement(SetShowDebugBordersRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Requests that backend shows the FPS counter
     *
     * @link Protocol [Overlay#setShowFPSCounter](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFPSCounter) method documentation.
     */
    fun setShowFPSCounter(input: SetShowFPSCounterRequest) = connection.request("Overlay.setShowFPSCounter", Json.encodeToJsonElement(SetShowFPSCounterRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Highlight multiple elements with the CSS Grid overlay.
     *
     * @link Protocol [Overlay#setShowGridOverlays](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowGridOverlays) method documentation.
     */
    fun setShowGridOverlays(input: SetShowGridOverlaysRequest) = connection.request("Overlay.setShowGridOverlays", Json.encodeToJsonElement(SetShowGridOverlaysRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [Overlay#setShowFlexOverlays](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFlexOverlays) method documentation.
     */
    fun setShowFlexOverlays(input: SetShowFlexOverlaysRequest) = connection.request("Overlay.setShowFlexOverlays", Json.encodeToJsonElement(SetShowFlexOverlaysRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Requests that backend shows paint rectangles
     *
     * @link Protocol [Overlay#setShowPaintRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowPaintRects) method documentation.
     */
    fun setShowPaintRects(input: SetShowPaintRectsRequest) = connection.request("Overlay.setShowPaintRects", Json.encodeToJsonElement(SetShowPaintRectsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Requests that backend shows layout shift regions
     *
     * @link Protocol [Overlay#setShowLayoutShiftRegions](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowLayoutShiftRegions) method documentation.
     */
    fun setShowLayoutShiftRegions(input: SetShowLayoutShiftRegionsRequest) = connection.request("Overlay.setShowLayoutShiftRegions", Json.encodeToJsonElement(SetShowLayoutShiftRegionsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Requests that backend shows scroll bottleneck rects
     *
     * @link Protocol [Overlay#setShowScrollBottleneckRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowScrollBottleneckRects) method documentation.
     */
    fun setShowScrollBottleneckRects(input: SetShowScrollBottleneckRectsRequest) = connection.request("Overlay.setShowScrollBottleneckRects", Json.encodeToJsonElement(SetShowScrollBottleneckRectsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Requests that backend shows hit-test borders on layers
     *
     * @link Protocol [Overlay#setShowHitTestBorders](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHitTestBorders) method documentation.
     */
    fun setShowHitTestBorders(input: SetShowHitTestBordersRequest) = connection.request("Overlay.setShowHitTestBorders", Json.encodeToJsonElement(SetShowHitTestBordersRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Request that backend shows an overlay with web vital metrics.
     *
     * @link Protocol [Overlay#setShowWebVitals](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowWebVitals) method documentation.
     */
    fun setShowWebVitals(input: SetShowWebVitalsRequest) = connection.request("Overlay.setShowWebVitals", Json.encodeToJsonElement(SetShowWebVitalsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Paints viewport size upon main frame resize.
     *
     * @link Protocol [Overlay#setShowViewportSizeOnResize](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowViewportSizeOnResize) method documentation.
     */
    fun setShowViewportSizeOnResize(input: SetShowViewportSizeOnResizeRequest) = connection.request("Overlay.setShowViewportSizeOnResize", Json.encodeToJsonElement(SetShowViewportSizeOnResizeRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Add a dual screen device hinge
     *
     * @link Protocol [Overlay#setShowHinge](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHinge) method documentation.
     */
    fun setShowHinge(input: SetShowHingeRequest) = connection.request("Overlay.setShowHinge", Json.encodeToJsonElement(SetShowHingeRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
     */
    fun inspectNodeRequested(): io.reactivex.rxjava3.core.Flowable<InspectNodeRequestedEvent> = connection.events("Overlay.inspectNodeRequested", InspectNodeRequestedEvent.serializer())

    /**
     *  Fired when the node should be highlighted. This happens after call to `setInspectMode`.
     */
    fun nodeHighlightRequested(): io.reactivex.rxjava3.core.Flowable<NodeHighlightRequestedEvent> = connection.events("Overlay.nodeHighlightRequested", NodeHighlightRequestedEvent.serializer())

    /**
     *  Fired when user asks to capture screenshot of some area on the page.
     */
    fun screenshotRequested(): io.reactivex.rxjava3.core.Flowable<ScreenshotRequestedEvent> = connection.events("Overlay.screenshotRequested", ScreenshotRequestedEvent.serializer())

    /**
     *  Fired when user cancels the inspect mode.
     */
    fun inspectModeCanceled(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Overlay.inspectModeCanceled", pl.wendigo.chrome.protocol.Event.serializer())

    /**
     * Returns flowable capturing all Overlay domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
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
@kotlinx.serialization.Serializable
data class GetHighlightObjectForTestRequest(
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
    val includeStyle: Boolean? = null,

    /**
     * The color format to get config with (default: hex).
     */
    val colorFormat: ColorFormat? = null,

    /**
     * Whether to show accessibility info (default: true).
     */
    val showAccessibilityInfo: Boolean? = null

)

/**
 * Represents response frame that is returned from [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) operation call.
 * For testing.
 *
  
 * @link [Overlay#getHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getHighlightObjectForTest) method documentation.
 * @see [OverlayOperations.getHighlightObjectForTest]
 */
@kotlinx.serialization.Serializable
data class GetHighlightObjectForTestResponse(
    /**  
     * Highlight data for the node.  
     */  
    val highlight: kotlinx.serialization.json.JsonElement

)

/**
 * Represents request frame that can be used with [Overlay#getGridHighlightObjectsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getGridHighlightObjectsForTest) operation call.
 *
 * For Persistent Grid testing.
 * @link [Overlay#getGridHighlightObjectsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getGridHighlightObjectsForTest) method documentation.
 * @see [OverlayOperations.getGridHighlightObjectsForTest]
 */
@kotlinx.serialization.Serializable
data class GetGridHighlightObjectsForTestRequest(
    /**
     * Ids of the node to get highlight object for.
     */
    val nodeIds: List<pl.wendigo.chrome.api.dom.NodeId>

)

/**
 * Represents response frame that is returned from [Overlay#getGridHighlightObjectsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getGridHighlightObjectsForTest) operation call.
 * For Persistent Grid testing.
 *
  
 * @link [Overlay#getGridHighlightObjectsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getGridHighlightObjectsForTest) method documentation.
 * @see [OverlayOperations.getGridHighlightObjectsForTest]
 */
@kotlinx.serialization.Serializable
data class GetGridHighlightObjectsForTestResponse(
    /**  
     * Grid Highlight data for the node ids provided.  
     */  
    val highlights: kotlinx.serialization.json.JsonElement

)

/**
 * Represents request frame that can be used with [Overlay#getSourceOrderHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getSourceOrderHighlightObjectForTest) operation call.
 *
 * For Source Order Viewer testing.
 * @link [Overlay#getSourceOrderHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getSourceOrderHighlightObjectForTest) method documentation.
 * @see [OverlayOperations.getSourceOrderHighlightObjectForTest]
 */
@kotlinx.serialization.Serializable
data class GetSourceOrderHighlightObjectForTestRequest(
    /**
     * Id of the node to highlight.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

)

/**
 * Represents response frame that is returned from [Overlay#getSourceOrderHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getSourceOrderHighlightObjectForTest) operation call.
 * For Source Order Viewer testing.
 *
  
 * @link [Overlay#getSourceOrderHighlightObjectForTest](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-getSourceOrderHighlightObjectForTest) method documentation.
 * @see [OverlayOperations.getSourceOrderHighlightObjectForTest]
 */
@kotlinx.serialization.Serializable
data class GetSourceOrderHighlightObjectForTestResponse(
    /**  
     * Source order highlight data for the node id provided.  
     */  
    val highlight: kotlinx.serialization.json.JsonElement

)

/**
 * Represents request frame that can be used with [Overlay#highlightFrame](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightFrame) operation call.
 *
 * Highlights owner element of the frame with given id.
 * @link [Overlay#highlightFrame](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightFrame) method documentation.
 * @see [OverlayOperations.highlightFrame]
 */
@kotlinx.serialization.Serializable
data class HighlightFrameRequest(
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
@kotlinx.serialization.Serializable
data class HighlightNodeRequest(
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
@kotlinx.serialization.Serializable
data class HighlightQuadRequest(
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
@kotlinx.serialization.Serializable
data class HighlightRectRequest(
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
 * Represents request frame that can be used with [Overlay#highlightSourceOrder](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightSourceOrder) operation call.
 *
 * Highlights the source order of the children of the DOM node with given id or with the given
JavaScript object wrapper. Either nodeId or objectId must be specified.
 * @link [Overlay#highlightSourceOrder](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-highlightSourceOrder) method documentation.
 * @see [OverlayOperations.highlightSourceOrder]
 */
@kotlinx.serialization.Serializable
data class HighlightSourceOrderRequest(
    /**
     * A descriptor for the appearance of the overlay drawing.
     */
    val sourceOrderConfig: SourceOrderConfig,

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
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null

)

/**
 * Represents request frame that can be used with [Overlay#setInspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setInspectMode) operation call.
 *
 * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
Backend then generates 'inspectNodeRequested' event upon element selection.
 * @link [Overlay#setInspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setInspectMode) method documentation.
 * @see [OverlayOperations.setInspectMode]
 */
@kotlinx.serialization.Serializable
data class SetInspectModeRequest(
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
@kotlinx.serialization.Serializable
data class SetShowAdHighlightsRequest(
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
@kotlinx.serialization.Serializable
data class SetPausedInDebuggerMessageRequest(
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
@kotlinx.serialization.Serializable
data class SetShowDebugBordersRequest(
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
@kotlinx.serialization.Serializable
data class SetShowFPSCounterRequest(
    /**
     * True for showing the FPS counter
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowGridOverlays](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowGridOverlays) operation call.
 *
 * Highlight multiple elements with the CSS Grid overlay.
 * @link [Overlay#setShowGridOverlays](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowGridOverlays) method documentation.
 * @see [OverlayOperations.setShowGridOverlays]
 */
@kotlinx.serialization.Serializable
data class SetShowGridOverlaysRequest(
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    val gridNodeHighlightConfigs: List<GridNodeHighlightConfig>

)

/**
 * Represents request frame that can be used with [Overlay#setShowFlexOverlays](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFlexOverlays) operation call.
 *
 *
 * @link [Overlay#setShowFlexOverlays](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowFlexOverlays) method documentation.
 * @see [OverlayOperations.setShowFlexOverlays]
 */
@kotlinx.serialization.Serializable
data class SetShowFlexOverlaysRequest(
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    val flexNodeHighlightConfigs: List<FlexNodeHighlightConfig>

)

/**
 * Represents request frame that can be used with [Overlay#setShowPaintRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowPaintRects) operation call.
 *
 * Requests that backend shows paint rectangles
 * @link [Overlay#setShowPaintRects](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowPaintRects) method documentation.
 * @see [OverlayOperations.setShowPaintRects]
 */
@kotlinx.serialization.Serializable
data class SetShowPaintRectsRequest(
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
@kotlinx.serialization.Serializable
data class SetShowLayoutShiftRegionsRequest(
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
@kotlinx.serialization.Serializable
data class SetShowScrollBottleneckRectsRequest(
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
@kotlinx.serialization.Serializable
data class SetShowHitTestBordersRequest(
    /**
     * True for showing hit-test borders
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowWebVitals](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowWebVitals) operation call.
 *
 * Request that backend shows an overlay with web vital metrics.
 * @link [Overlay#setShowWebVitals](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowWebVitals) method documentation.
 * @see [OverlayOperations.setShowWebVitals]
 */
@kotlinx.serialization.Serializable
data class SetShowWebVitalsRequest(
    /**
     *
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
@kotlinx.serialization.Serializable
data class SetShowViewportSizeOnResizeRequest(
    /**
     * Whether to paint size or not.
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with [Overlay#setShowHinge](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHinge) operation call.
 *
 * Add a dual screen device hinge
 * @link [Overlay#setShowHinge](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#method-setShowHinge) method documentation.
 * @see [OverlayOperations.setShowHinge]
 */
@kotlinx.serialization.Serializable
data class SetShowHingeRequest(
    /**
     * hinge data, null means hideHinge
     */
    val hingeConfig: HingeConfig? = null

)

/**
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
 *
 * @link [Overlay#inspectNodeRequested](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#event-inspectNodeRequested) event documentation.
 */
@kotlinx.serialization.Serializable
data class InspectNodeRequestedEvent(
    /**  
     * Id of the node to inspect.  
     */  
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId

) : pl.wendigo.chrome.protocol.Event(domainName = "Overlay", domainEventName = "inspectNodeRequested")

/**
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 *
 * @link [Overlay#nodeHighlightRequested](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#event-nodeHighlightRequested) event documentation.
 */
@kotlinx.serialization.Serializable
data class NodeHighlightRequestedEvent(
    /**  
     *  
     */  
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

) : pl.wendigo.chrome.protocol.Event(domainName = "Overlay", domainEventName = "nodeHighlightRequested")

/**
 * Fired when user asks to capture screenshot of some area on the page.
 *
 * @link [Overlay#screenshotRequested](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#event-screenshotRequested) event documentation.
 */
@kotlinx.serialization.Serializable
data class ScreenshotRequestedEvent(
    /**  
     * Viewport to capture, in device independent pixels (dip).  
     */  
    val viewport: pl.wendigo.chrome.api.page.Viewport

) : pl.wendigo.chrome.protocol.Event(domainName = "Overlay", domainEventName = "screenshotRequested")
