package pl.wendigo.chrome.api.performancetimeline

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 *
 * @link [PerformanceTimeline#LargestContentfulPaint](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#type-LargestContentfulPaint) type documentation.
 */

data class LargestContentfulPaint(
    /**  
     *  
     */  
    val renderTime: Double,

    /**  
     *  
     */  
    val loadTime: Double,

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
 * @link [PerformanceTimeline#TimelineEvent](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#type-TimelineEvent) type documentation.
 */

data class TimelineEvent(
    /**  
     * Identifies the frame that this event is related to. Empty for non-frame targets.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     *  
     */  
    val type: String,

    /**  
     *  
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
    val lcpDetails: LargestContentfulPaint? = null
)
