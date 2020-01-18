package pl.wendigo.chrome.api.tracing

/**
 * TracingOperations represents Tracing protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Tracing](https://chromedevtools.github.io/devtools-protocol/tot/Tracing) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class TracingOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Stop trace events collection.
     *
     * @link Protocol [Tracing#end](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-end) method documentation.
     */
    fun end() = connection.request("Tracing.end", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Gets supported tracing categories.
     *
     * @link Protocol [Tracing#getCategories](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-getCategories) method documentation.
     */
    fun getCategories() = connection.request("Tracing.getCategories", null, GetCategoriesResponse::class.java)

    /**
     * Record a clock sync marker in the trace.
     *
     * @link Protocol [Tracing#recordClockSyncMarker](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-recordClockSyncMarker) method documentation.
     */
    fun recordClockSyncMarker(input: RecordClockSyncMarkerRequest) = connection.request("Tracing.recordClockSyncMarker", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Request a global memory dump.
     *
     * @link Protocol [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) method documentation.
     */
    fun requestMemoryDump(input: RequestMemoryDumpRequest) = connection.request("Tracing.requestMemoryDump", input, RequestMemoryDumpResponse::class.java)

    /**
     * Start trace events collection.
     *
     * @link Protocol [Tracing#start](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-start) method documentation.
     */
    fun start(input: StartRequest) = connection.request("Tracing.start", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Returns observable capturing all Tracing.bufferUsage events.
     */
    fun bufferUsage(): io.reactivex.Flowable<BufferUsageEvent> = connection.events("Tracing.bufferUsage", BufferUsageEvent::class.java)

    /**
     *  Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
     */
    fun dataCollected(): io.reactivex.Flowable<DataCollectedEvent> = connection.events("Tracing.dataCollected", DataCollectedEvent::class.java)

    /**
     *  Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
     */
    fun tracingComplete(): io.reactivex.Flowable<TracingCompleteEvent> = connection.events("Tracing.tracingComplete", TracingCompleteEvent::class.java)

    /**
     * Returns flowable capturing all Tracing domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Tracing"
        }
    }
}

/**
 * Represents response frame that is returned from [Tracing#getCategories](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-getCategories) operation call.
 * Gets supported tracing categories.
 *
  
 * @link [Tracing#getCategories](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-getCategories) method documentation.
 * @see [TracingOperations.getCategories]
 */
data class GetCategoriesResponse(
    /**  
     * A list of supported tracing categories.  
     */  
    val categories: List<String>

)

/**
 * Represents request frame that can be used with [Tracing#recordClockSyncMarker](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-recordClockSyncMarker) operation call.
 *
 * Record a clock sync marker in the trace.
 * @link [Tracing#recordClockSyncMarker](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-recordClockSyncMarker) method documentation.
 * @see [TracingOperations.recordClockSyncMarker]
 */
data class RecordClockSyncMarkerRequest(
    /**
     * The ID of this clock sync marker
     */
    val syncId: String

)

/**
 * Represents request frame that can be used with [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) operation call.
 *
 * Request a global memory dump.
 * @link [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) method documentation.
 * @see [TracingOperations.requestMemoryDump]
 */
data class RequestMemoryDumpRequest(
    /**
     * Enables more deterministic results by forcing garbage collection
     */
    val deterministic: Boolean? = null

)
/**
 * Represents response frame that is returned from [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) operation call.
 * Request a global memory dump.
 *
  
 * @link [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) method documentation.
 * @see [TracingOperations.requestMemoryDump]
 */
data class RequestMemoryDumpResponse(
    /**  
     * GUID of the resulting global memory dump.  
     */  
    val dumpGuid: String,

    /**  
     * True iff the global memory dump succeeded.  
     */  
    val success: Boolean

)

/**
 * Represents request frame that can be used with [Tracing#start](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-start) operation call.
 *
 * Start trace events collection.
 * @link [Tracing#start](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-start) method documentation.
 * @see [TracingOperations.start]
 */
data class StartRequest(
    /**
     * Category/tag filter
     */
    @Deprecated(message = "") val categories: String? = null,

    /**
     * Tracing options
     */
    @Deprecated(message = "") val options: String? = null,

    /**
     * If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
     */
    val bufferUsageReportingInterval: Double? = null,

    /**
     * Whether to report trace events as series of dataCollected events or to save trace to a
stream (defaults to `ReportEvents`).
     */
    val transferMode: String? = null,

    /**
     * Trace data format to use. This only applies when using `ReturnAsStream`
transfer mode (defaults to `json`).
     */
    val streamFormat: StreamFormat? = null,

    /**
     * Compression format to use. This only applies when using `ReturnAsStream`
transfer mode (defaults to `none`)
     */
    val streamCompression: StreamCompression? = null,

    /**
     *
     */
    val traceConfig: TraceConfig? = null

)

/**
 *
 *
 * @link [Tracing#bufferUsage](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#event-bufferUsage) event documentation.
 */
data class BufferUsageEvent(
    /**  
     * A number in range [0..1] that indicates the used size of event buffer as a fraction of its  
     total size.  
     */  
    val percentFull: Double? = null,

    /**  
     * An approximate number of events in the trace log.  
     */  
    val eventCount: Double? = null,

    /**  
     * A number in range [0..1] that indicates the used size of event buffer as a fraction of its  
     total size.  
     */  
    val value: Double? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Tracing", name = "bufferUsage")

/**
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
 *
 * @link [Tracing#dataCollected](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#event-dataCollected) event documentation.
 */
data class DataCollectedEvent(
    /**  
     *  
     */  
    val value: List<Any>

) : pl.wendigo.chrome.protocol.Event(domain = "Tracing", name = "dataCollected")

/**
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
 *
 * @link [Tracing#tracingComplete](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#event-tracingComplete) event documentation.
 */
data class TracingCompleteEvent(
    /**  
     * Indicates whether some trace data is known to have been lost, e.g. because the trace ring  
     buffer wrapped around.  
     */  
    val dataLossOccurred: Boolean,

    /**  
     * A handle of the stream that holds resulting trace data.  
     */  
    val stream: pl.wendigo.chrome.api.io.StreamHandle? = null,

    /**  
     * Trace data format of returned stream.  
     */  
    val traceFormat: StreamFormat? = null,

    /**  
     * Compression format of returned stream.  
     */  
    val streamCompression: StreamCompression? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Tracing", name = "tracingComplete")
