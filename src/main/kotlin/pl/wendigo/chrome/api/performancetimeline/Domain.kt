package pl.wendigo.chrome.api.performancetimeline

import kotlinx.serialization.json.Json

/**
 * Reporting of performance timeline events, as specified in
https://w3c.github.io/performance-timeline/#dom-performanceobserver.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [PerformanceTimeline](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class PerformanceTimelineDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebsocketConnection) :
    pl.wendigo.chrome.api.Domain(
        "PerformanceTimeline",
        """Reporting of performance timeline events, as specified in
https://w3c.github.io/performance-timeline/#dom-performanceobserver.""",
        connection
    ) {
    /**
     * Previously buffered events would be reported before method returns.
See also: timelineEventAdded
     *
     * @link Protocol [PerformanceTimeline#enable](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#method-enable) method documentation.
     */
    
    fun enable(input: EnableRequest) = connection.request("PerformanceTimeline.enable", Json.encodeToJsonElement(EnableRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Sent when a performance timeline event is added. See reportPerformanceTimeline method.
     */
    fun timelineEventAdded(): io.reactivex.rxjava3.core.Flowable<TimelineEventAddedEvent> = connection.events("PerformanceTimeline.timelineEventAdded", TimelineEventAddedEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.api.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
            pl.wendigo.chrome.api.network.NetworkDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [PerformanceTimeline#enable](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#method-enable) operation call.
 *
 * Previously buffered events would be reported before method returns.
See also: timelineEventAdded
 * @link [PerformanceTimeline#enable](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#method-enable) method documentation.
 * @see [PerformanceTimelineOperations.enable]
 */
@kotlinx.serialization.Serializable
data class EnableRequest(
    /**
     * The types of event to report, as specified in
https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype
The specified filter overrides any previous filters, passing empty
filter disables recording.
Note that not all types exposed to the web platform are currently supported.
     */
    val eventTypes: List<String>

)

/**
 * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
 *
 * @link [PerformanceTimeline#timelineEventAdded](https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline#event-timelineEventAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class TimelineEventAddedEvent(
    /**  
     *  
     */  
    val event: TimelineEvent

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "PerformanceTimeline" 
    override fun eventName() = "timelineEventAdded"
} 
