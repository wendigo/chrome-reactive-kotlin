package pl.wendigo.chrome.api.performancetimeline

/**
 * Reporting of performance timeline events, as specified in
https://w3c.github.io/performance-timeline/#dom-performanceobserver.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [PerformanceTimeline](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class PerformanceTimelineOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Previously buffered events would be reported before method returns.
The specified filter overrides any previous filters, passing empty
filter disables recording.
Note that not all types exposed to the web platform are currently supported.
See also: timelineEventAdded
     *
     * @link Protocol [PerformanceTimeline#enable](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#method-enable) method documentation.
     */
    fun enable(input: EnableRequest) = connection.request("PerformanceTimeline.enable", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Sent when a performance timeline event is added. See reportPerformanceTimeline method.
     */
    fun timelineEventAdded(): io.reactivex.Flowable<TimelineEventAddedEvent> = connection.events("PerformanceTimeline.timelineEventAdded", TimelineEventAddedEvent::class.java)

    /**
     * Returns flowable capturing all PerformanceTimeline domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "PerformanceTimeline"
        }
    }
}
/**
 * Represents request frame that can be used with [PerformanceTimeline#enable](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#method-enable) operation call.
 *
 * Previously buffered events would be reported before method returns.
The specified filter overrides any previous filters, passing empty
filter disables recording.
Note that not all types exposed to the web platform are currently supported.
See also: timelineEventAdded
 * @link [PerformanceTimeline#enable](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#method-enable) method documentation.
 * @see [PerformanceTimelineOperations.enable]
 */
data class EnableRequest(
    /**
     *
     */
    val eventTypes: List<String>

)

/**
 * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
 *
 * @link [PerformanceTimeline#timelineEventAdded](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#event-timelineEventAdded) event documentation.
 */
data class TimelineEventAddedEvent(
    /**  
     *  
     */  
    val event: TimelineEvent

) : pl.wendigo.chrome.protocol.Event(domain = "PerformanceTimeline", name = "timelineEventAdded")
