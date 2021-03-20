package pl.wendigo.chrome.api.tracing

import kotlinx.serialization.json.Json

/**
 * TracingDomain represents Tracing protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Tracing](https://chromedevtools.github.io/devtools-protocol/tot/Tracing) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class TracingDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebSocketConnection) :
    pl.wendigo.chrome.protocol.Domain("Tracing", """""", connection) {
    /**
     * Stop trace events collection.
     *
     * @link Protocol [Tracing#end](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-end) method documentation.
     */
    
    fun end(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Tracing.end", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Gets supported tracing categories.
     *
     * @link Protocol [Tracing#getCategories](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-getCategories) method documentation.
     */
    
    fun getCategories(): io.reactivex.rxjava3.core.Single<GetCategoriesResponse> = connection.request("Tracing.getCategories", null, GetCategoriesResponse.serializer())

    /**
     * Record a clock sync marker in the trace.
     *
     * @link Protocol [Tracing#recordClockSyncMarker](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-recordClockSyncMarker) method documentation.
     */
    
    fun recordClockSyncMarker(input: RecordClockSyncMarkerRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Tracing.recordClockSyncMarker", Json.encodeToJsonElement(RecordClockSyncMarkerRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Request a global memory dump.
     *
     * @link Protocol [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) method documentation.
     */
    
    fun requestMemoryDump(input: RequestMemoryDumpRequest): io.reactivex.rxjava3.core.Single<RequestMemoryDumpResponse> = connection.request("Tracing.requestMemoryDump", Json.encodeToJsonElement(RequestMemoryDumpRequest.serializer(), input), RequestMemoryDumpResponse.serializer())

    /**
     * Start trace events collection.
     *
     * @link Protocol [Tracing#start](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-start) method documentation.
     */
    
    fun start(input: StartRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Tracing.start", Json.encodeToJsonElement(StartRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Returns observable capturing all Tracing.bufferUsage events.
     */
    fun bufferUsage(): io.reactivex.rxjava3.core.Flowable<BufferUsageEvent> = connection.events("Tracing.bufferUsage", BufferUsageEvent.serializer())

    /**
     *  Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
     */
    fun dataCollected(): io.reactivex.rxjava3.core.Flowable<DataCollectedEvent> = connection.events("Tracing.dataCollected", DataCollectedEvent.serializer())

    /**
     *  Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
     */
    fun tracingComplete(): io.reactivex.rxjava3.core.Flowable<TracingCompleteEvent> = connection.events("Tracing.tracingComplete", TracingCompleteEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.io.IODomain(connection),
        )
    }
}

/**
 * Represents response frame that is returned from [Tracing#getCategories](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-getCategories) operation call.
 * Gets supported tracing categories.
 *
  
 * @link [Tracing#getCategories](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-getCategories) method documentation.
 * @see [TracingDomain.getCategories]
 */
@kotlinx.serialization.Serializable
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
 * @see [TracingDomain.recordClockSyncMarker]
 */
@kotlinx.serialization.Serializable
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
 * @see [TracingDomain.requestMemoryDump]
 */
@kotlinx.serialization.Serializable
data class RequestMemoryDumpRequest(
    /**
     * Enables more deterministic results by forcing garbage collection
     */
    val deterministic: Boolean? = null,

    /**
     * Specifies level of details in memory dump. Defaults to "detailed".
     */
    val levelOfDetail: MemoryDumpLevelOfDetail? = null

)

/**
 * Represents response frame that is returned from [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) operation call.
 * Request a global memory dump.
 *
  
 * @link [Tracing#requestMemoryDump](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#method-requestMemoryDump) method documentation.
 * @see [TracingDomain.requestMemoryDump]
 */
@kotlinx.serialization.Serializable
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
 * @see [TracingDomain.start]
 */
@kotlinx.serialization.Serializable
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
    val traceConfig: TraceConfig? = null,

    /**
     * Base64-encoded serialized perfetto.protos.TraceConfig protobuf message
When specified, the parameters `categories`, `options`, `traceConfig`
are ignored. (Encoded as a base64 string when passed over JSON)
     */
    val perfettoConfig: String? = null

)

/**
 *
 *
 * @link [Tracing#bufferUsage](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#event-bufferUsage) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Tracing" 
    override fun eventName() = "bufferUsage"
} 

/**
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
 *
 * @link [Tracing#dataCollected](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#event-dataCollected) event documentation.
 */
@kotlinx.serialization.Serializable
data class DataCollectedEvent(
    /**  
     *  
     */  
    val value: List<kotlinx.serialization.json.JsonElement>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Tracing" 
    override fun eventName() = "dataCollected"
} 

/**
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
 *
 * @link [Tracing#tracingComplete](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#event-tracingComplete) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Tracing" 
    override fun eventName() = "tracingComplete"
} 
