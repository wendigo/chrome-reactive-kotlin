package pl.wendigo.chrome.domain.tracing

/**
 * TracingDomain represents remote debugger protocol domain.
 */
class TracingDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Stop trace events collection.
     */
    fun end() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Tracing.end", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Gets supported tracing categories.
     */
    fun getCategories() : io.reactivex.Single<GetCategoriesResponse> {
        return connectionRemote.runAndCaptureResponse("Tracing.getCategories", null, GetCategoriesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Record a clock sync marker in the trace.
     */
    fun recordClockSyncMarker(input : RecordClockSyncMarkerRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Tracing.recordClockSyncMarker", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Request a global memory dump.
     */
    fun requestMemoryDump() : io.reactivex.Single<RequestMemoryDumpResponse> {
        return connectionRemote.runAndCaptureResponse("Tracing.requestMemoryDump", null, RequestMemoryDumpResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Start trace events collection.
     */
    fun start(input : StartRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Tracing.start", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Tracing.bufferUsage events.
     */
    fun bufferUsage() : io.reactivex.Flowable<BufferUsageEvent> {
        return bufferUsageTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Tracing.bufferUsage events.
     */
    fun bufferUsageTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<BufferUsageEvent>> {
        return connectionRemote.captureEvents("Tracing.bufferUsage", BufferUsageEvent::class.java)
    }

    /**
     * Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
     */
    fun dataCollected() : io.reactivex.Flowable<DataCollectedEvent> {
        return dataCollectedTimed().map {
            it.value()
        }
    }

    /**
     * Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
     */
    fun dataCollectedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<DataCollectedEvent>> {
        return connectionRemote.captureEvents("Tracing.dataCollected", DataCollectedEvent::class.java)
    }

    /**
     * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
     */
    fun tracingComplete() : io.reactivex.Flowable<TracingCompleteEvent> {
        return tracingCompleteTimed().map {
            it.value()
        }
    }

    /**
     * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
     */
    fun tracingCompleteTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<TracingCompleteEvent>> {
        return connectionRemote.captureEvents("Tracing.tracingComplete", TracingCompleteEvent::class.java)
    }

    /**
     * Returns flowable capturing all Tracing domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Tracing"
        }
    }
}

/**
 * Represents response frame for Tracing.getCategories method call.
 *
 * Gets supported tracing categories.
 */
data class GetCategoriesResponse(
  /**
   * A list of supported tracing categories.
   */
  val categories : List<String>

)

/**
 * Represents request frame that can be used with Tracing.recordClockSyncMarker method call.
 *
 * Record a clock sync marker in the trace.
 */
data class RecordClockSyncMarkerRequest (
    /**
     * The ID of this clock sync marker
     */
    val syncId : String

)

/**
 * Represents response frame for Tracing.requestMemoryDump method call.
 *
 * Request a global memory dump.
 */
data class RequestMemoryDumpResponse(
  /**
   * GUID of the resulting global memory dump.
   */
  val dumpGuid : String,

  /**
   * True iff the global memory dump succeeded.
   */
  val success : Boolean

)

/**
 * Represents request frame that can be used with Tracing.start method call.
 *
 * Start trace events collection.
 */
data class StartRequest (
    /**
     * Category/tag filter
     */
    @pl.wendigo.chrome.Deprecated val categories : String? = null,

    /**
     * Tracing options
     */
    @pl.wendigo.chrome.Deprecated val options : String? = null,

    /**
     * If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
     */
    val bufferUsageReportingInterval : Double? = null,

    /**
     * Whether to report trace events as series of dataCollected events or to save trace to a
stream (defaults to `ReportEvents`).
     */
    val transferMode : String? = null,

    /**
     * Compression format to use. This only applies when using `ReturnAsStream`
transfer mode (defaults to `none`)
     */
    val streamCompression : StreamCompression? = null,

    /**
     *
     */
    val traceConfig : TraceConfig? = null

)

/**
 * Represents event frames for Tracing.bufferUsage
 *
 *
 */
data class BufferUsageEvent(
  /**
   * A number in range [0..1] that indicates the used size of event buffer as a fraction of its
total size.
   */
  val percentFull : Double? = null,

  /**
   * An approximate number of events in the trace log.
   */
  val eventCount : Double? = null,

  /**
   * A number in range [0..1] that indicates the used size of event buffer as a fraction of its
total size.
   */
  val value : Double? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Tracing", name = "bufferUsage")

/**
 * Represents event frames for Tracing.dataCollected
 *
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be
send as a sequence of dataCollected events followed by tracingComplete event.
 */
data class DataCollectedEvent(
  /**
   *
   */
  val value : List<Any>

) : pl.wendigo.chrome.ProtocolEvent(domain = "Tracing", name = "dataCollected")

/**
 * Represents event frames for Tracing.tracingComplete
 *
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
 */
data class TracingCompleteEvent(
  /**
   * A handle of the stream that holds resulting trace data.
   */
  val stream : pl.wendigo.chrome.domain.io.StreamHandle? = null,

  /**
   * Compression format of returned stream.
   */
  val streamCompression : StreamCompression? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Tracing", name = "tracingComplete")

