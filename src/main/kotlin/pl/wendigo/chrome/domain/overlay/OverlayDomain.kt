package pl.wendigo.chrome.domain.overlay

/**
 * This domain provides various functionality related to drawing atop the inspected page.
 */
class OverlayDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disables domain notifications.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables domain notifications.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * For testing.
     */
    fun getHighlightObjectForTest(input: GetHighlightObjectForTestRequest): io.reactivex.Single<GetHighlightObjectForTestResponse> {
        return connectionRemote.runAndCaptureResponse("Overlay.getHighlightObjectForTest", input, GetHighlightObjectForTestResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Hides any highlight.
     */
    fun hideHighlight(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.hideHighlight", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights owner element of the frame with given id.
     */
    fun highlightFrame(input: HighlightFrameRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.highlightFrame", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
objectId must be specified.
     */
    fun highlightNode(input: HighlightNodeRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.highlightNode", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
     */
    fun highlightQuad(input: HighlightQuadRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.highlightQuad", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
     */
    fun highlightRect(input: HighlightRectRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.highlightRect", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
Backend then generates 'inspectNodeRequested' event upon element selection.
     */
    fun setInspectMode(input: SetInspectModeRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setInspectMode", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights owner element of all frames detected to be ads.
     */
    fun setShowAdHighlights(input: SetShowAdHighlightsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowAdHighlights", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun setPausedInDebuggerMessage(input: SetPausedInDebuggerMessageRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setPausedInDebuggerMessage", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that backend shows debug borders on layers
     */
    fun setShowDebugBorders(input: SetShowDebugBordersRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowDebugBorders", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that backend shows the FPS counter
     */
    fun setShowFPSCounter(input: SetShowFPSCounterRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowFPSCounter", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that backend shows paint rectangles
     */
    fun setShowPaintRects(input: SetShowPaintRectsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowPaintRects", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that backend shows layout shift regions
     */
    fun setShowLayoutShiftRegions(input: SetShowLayoutShiftRegionsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowLayoutShiftRegions", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that backend shows scroll bottleneck rects
     */
    fun setShowScrollBottleneckRects(input: SetShowScrollBottleneckRectsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowScrollBottleneckRects", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that backend shows hit-test borders on layers
     */
    fun setShowHitTestBorders(input: SetShowHitTestBordersRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowHitTestBorders", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Paints viewport size upon main frame resize.
     */
    fun setShowViewportSizeOnResize(input: SetShowViewportSizeOnResizeRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Overlay.setShowViewportSizeOnResize", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
     */
    fun inspectNodeRequested(): io.reactivex.Flowable<InspectNodeRequestedEvent> {
        return inspectNodeRequestedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
     */
    fun inspectNodeRequestedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<InspectNodeRequestedEvent>> {
        return connectionRemote.captureEvents("Overlay.inspectNodeRequested", InspectNodeRequestedEvent::class.java)
    }

    /**
     *  Fired when the node should be highlighted. This happens after call to `setInspectMode`.
     */
    fun nodeHighlightRequested(): io.reactivex.Flowable<NodeHighlightRequestedEvent> {
        return nodeHighlightRequestedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
     */
    fun nodeHighlightRequestedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NodeHighlightRequestedEvent>> {
        return connectionRemote.captureEvents("Overlay.nodeHighlightRequested", NodeHighlightRequestedEvent::class.java)
    }

    /**
     *  Fired when user asks to capture screenshot of some area on the page.
     */
    fun screenshotRequested(): io.reactivex.Flowable<ScreenshotRequestedEvent> {
        return screenshotRequestedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when user asks to capture screenshot of some area on the page.
     */
    fun screenshotRequestedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ScreenshotRequestedEvent>> {
        return connectionRemote.captureEvents("Overlay.screenshotRequested", ScreenshotRequestedEvent::class.java)
    }

    /**
     *  Fired when user cancels the inspect mode.
     */
    fun inspectModeCanceled(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return inspectModeCanceledTimed().map {
            it.value()
        }
    }

    /**
     * Fired when user cancels the inspect mode.
     */
    fun inspectModeCanceledTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Overlay.inspectModeCanceled", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Returns flowable capturing all Overlay domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Overlay"
        }
    }
}

/**
 * Represents request frame that can be used with Overlay.getHighlightObjectForTest method call.
 *
 * For testing.
 */
data class GetHighlightObjectForTestRequest(
    /**
     * Id of the node to get highlight object for.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId,

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
 * Represents response frame for Overlay.getHighlightObjectForTest method call.
 *
 * For testing.
 */
data class GetHighlightObjectForTestResponse(
    /**  
     * Highlight data for the node.  
     */  
    val highlight: String

)

/**
 * Represents request frame that can be used with Overlay.highlightFrame method call.
 *
 * Highlights owner element of the frame with given id.
 */
data class HighlightFrameRequest(
    /**
     * Identifier of the frame to highlight.
     */
    val frameId: pl.wendigo.chrome.domain.page.FrameId,

    /**
     * The content box highlight fill color (default: transparent).
     */
    val contentColor: pl.wendigo.chrome.domain.dom.RGBA? = null,

    /**
     * The content box highlight outline color (default: transparent).
     */
    val contentOutlineColor: pl.wendigo.chrome.domain.dom.RGBA? = null

)

/**
 * Represents request frame that can be used with Overlay.highlightNode method call.
 *
 * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
objectId must be specified.
 */
data class HighlightNodeRequest(
    /**
     * A descriptor for the highlight appearance.
     */
    val highlightConfig: HighlightConfig,

    /**
     * Identifier of the node to highlight.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId? = null,

    /**
     * Identifier of the backend node to highlight.
     */
    val backendNodeId: pl.wendigo.chrome.domain.dom.BackendNodeId? = null,

    /**
     * JavaScript object id of the node to be highlighted.
     */
    val objectId: pl.wendigo.chrome.domain.runtime.RemoteObjectId? = null,

    /**
     * Selectors to highlight relevant nodes.
     */
    val selector: String? = null

)

/**
 * Represents request frame that can be used with Overlay.highlightQuad method call.
 *
 * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
 */
data class HighlightQuadRequest(
    /**
     * Quad to highlight
     */
    val quad: pl.wendigo.chrome.domain.dom.Quad,

    /**
     * The highlight fill color (default: transparent).
     */
    val color: pl.wendigo.chrome.domain.dom.RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor: pl.wendigo.chrome.domain.dom.RGBA? = null

)

/**
 * Represents request frame that can be used with Overlay.highlightRect method call.
 *
 * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
 */
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
    val color: pl.wendigo.chrome.domain.dom.RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor: pl.wendigo.chrome.domain.dom.RGBA? = null

)

/**
 * Represents request frame that can be used with Overlay.setInspectMode method call.
 *
 * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
Backend then generates 'inspectNodeRequested' event upon element selection.
 */
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
 * Represents request frame that can be used with Overlay.setShowAdHighlights method call.
 *
 * Highlights owner element of all frames detected to be ads.
 */
data class SetShowAdHighlightsRequest(
    /**
     * True for showing ad highlights
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setPausedInDebuggerMessage method call.
 *
 *
 */
data class SetPausedInDebuggerMessageRequest(
    /**
     * The message to display, also triggers resume and step over controls.
     */
    val message: String? = null

)

/**
 * Represents request frame that can be used with Overlay.setShowDebugBorders method call.
 *
 * Requests that backend shows debug borders on layers
 */
data class SetShowDebugBordersRequest(
    /**
     * True for showing debug borders
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setShowFPSCounter method call.
 *
 * Requests that backend shows the FPS counter
 */
data class SetShowFPSCounterRequest(
    /**
     * True for showing the FPS counter
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setShowPaintRects method call.
 *
 * Requests that backend shows paint rectangles
 */
data class SetShowPaintRectsRequest(
    /**
     * True for showing paint rectangles
     */
    val result: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setShowLayoutShiftRegions method call.
 *
 * Requests that backend shows layout shift regions
 */
data class SetShowLayoutShiftRegionsRequest(
    /**
     * True for showing layout shift regions
     */
    val result: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setShowScrollBottleneckRects method call.
 *
 * Requests that backend shows scroll bottleneck rects
 */
data class SetShowScrollBottleneckRectsRequest(
    /**
     * True for showing scroll bottleneck rects
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setShowHitTestBorders method call.
 *
 * Requests that backend shows hit-test borders on layers
 */
data class SetShowHitTestBordersRequest(
    /**
     * True for showing hit-test borders
     */
    val show: Boolean

)

/**
 * Represents request frame that can be used with Overlay.setShowViewportSizeOnResize method call.
 *
 * Paints viewport size upon main frame resize.
 */
data class SetShowViewportSizeOnResizeRequest(
    /**
     * Whether to paint size or not.
     */
    val show: Boolean

)

/**
 * Represents event frames for Overlay.inspectNodeRequested
 *
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
 */
data class InspectNodeRequestedEvent(
    /**  
     * Id of the node to inspect.  
     */  
    val backendNodeId: pl.wendigo.chrome.domain.dom.BackendNodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Overlay", name = "inspectNodeRequested")

/**
 * Represents event frames for Overlay.nodeHighlightRequested
 *
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 */
data class NodeHighlightRequestedEvent(
    /**  
     *  
     */  
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Overlay", name = "nodeHighlightRequested")

/**
 * Represents event frames for Overlay.screenshotRequested
 *
 * Fired when user asks to capture screenshot of some area on the page.
 */
data class ScreenshotRequestedEvent(
    /**  
     * Viewport to capture, in device independent pixels (dip).  
     */  
    val viewport: pl.wendigo.chrome.domain.page.Viewport

) : pl.wendigo.chrome.ProtocolEvent(domain = "Overlay", name = "screenshotRequested")
