package pl.wendigo.chrome.api.performancetimeline

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 *
 * @link [PerformanceTimeline#LargestContentfulPaint](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#type-LargestContentfulPaint) type documentation.
 */

@kotlinx.serialization.Serializable
data class LargestContentfulPaint(
    /**  
     *  
     */  
    val renderTime: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     *  
     */  
    val loadTime: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     * The number of pixels being painted.  
     */  
    val size: Double,

    /**  
     * The id attribute of the element, if available.  
     */  
    val elementId: String? = null,

    /**  
     * The URL of the image (may be trimmed).  
     */  
    val url: String? = null,

    /**  
     *  
     */  
    val nodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null
)

/**
 *
 *
 * @link [PerformanceTimeline#LayoutShiftAttribution](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#type-LayoutShiftAttribution) type documentation.
 */

@kotlinx.serialization.Serializable
data class LayoutShiftAttribution(
    /**  
     *  
     */  
    val previousRect: pl.wendigo.chrome.api.dom.Rect,

    /**  
     *  
     */  
    val currentRect: pl.wendigo.chrome.api.dom.Rect,

    /**  
     *  
     */  
    val nodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null
)

/**
 * See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
 *
 * @link [PerformanceTimeline#LayoutShift](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#type-LayoutShift) type documentation.
 */

@kotlinx.serialization.Serializable
data class LayoutShift(
    /**  
     * Score increment produced by this event.  
     */  
    val value: Double,

    /**  
     *  
     */  
    val hadRecentInput: Boolean,

    /**  
     *  
     */  
    val lastInputTime: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     *  
     */  
    val sources: List<LayoutShiftAttribution>
)

/**
 *
 *
 * @link [PerformanceTimeline#TimelineEvent](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#type-TimelineEvent) type documentation.
 */

@kotlinx.serialization.Serializable
data class TimelineEvent(
    /**  
     * Identifies the frame that this event is related to. Empty for non-frame targets.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     * The event type, as specified in https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype  
     This determines which of the optional "details" fiedls is present.  
     */  
    val type: String,

    /**  
     * Name may be empty depending on the type.  
     */  
    val name: String,

    /**  
     * Time in seconds since Epoch, monotonically increasing within document lifetime.  
     */  
    val time: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     * Event duration, if applicable.  
     */  
    val duration: Double? = null,

    /**  
     *  
     */  
    val lcpDetails: LargestContentfulPaint? = null,

    /**  
     *  
     */  
    val layoutShiftDetails: LayoutShift? = null
)
