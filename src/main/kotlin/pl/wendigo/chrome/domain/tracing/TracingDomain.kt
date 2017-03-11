package pl.wendigo.chrome.domain.tracing

/**
 * TracingDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class TracingDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Start trace events collection.
	 */
	  fun start(input : StartRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Tracing.start", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Stop trace events collection.
	 */
	  fun end() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Tracing.end", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Gets supported tracing categories.
	 */
	  fun getCategories() : io.reactivex.Flowable<GetCategoriesResponse> {
        return connection.runAndCaptureResponse("Tracing.getCategories", null, GetCategoriesResponse::class.java)
	}

	/**
	 * Request a global memory dump.
	 */
	  fun requestMemoryDump() : io.reactivex.Flowable<RequestMemoryDumpResponse> {
        return connection.runAndCaptureResponse("Tracing.requestMemoryDump", null, RequestMemoryDumpResponse::class.java)
	}

	/**
	 * Record a clock sync marker in the trace.
	 */
	  fun recordClockSyncMarker(input : RecordClockSyncMarkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Tracing.recordClockSyncMarker", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
  /**
   * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
   */
   fun dataCollected() : io.reactivex.Flowable<DataCollectedEvent> {
      return connection.captureEvents("Tracing.dataCollected", DataCollectedEvent::class.java)
   }

  /**
   * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
   */
   fun tracingComplete() : io.reactivex.Flowable<TracingCompleteEvent> {
      return connection.captureEvents("Tracing.tracingComplete", TracingCompleteEvent::class.java)
   }

  /**
   * 
   */
   fun bufferUsage() : io.reactivex.Flowable<BufferUsageEvent> {
      return connection.captureEvents("Tracing.bufferUsage", BufferUsageEvent::class.java)
   }
}

/**
 * Represents requestFrame parameters that can be used with Tracing.start method call.
 *
 * Start trace events collection.
 */
data class StartRequest (
    /**
     * Category/tag filter
     */
    @pl.wendigo.chrome.ProtocolDeprecated val categories : String? = null,

    /**
     * Tracing options
     */
    @pl.wendigo.chrome.ProtocolDeprecated val options : String? = null,

    /**
     * If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
     */
    val bufferUsageReportingInterval : Double? = null,

    /**
     * Whether to report trace events as series of dataCollected events or to save trace to a stream (defaults to <code>ReportEvents</code>).
     */
    val transferMode : String? = null,

    /**
     * 
     */
    val traceConfig : TraceConfig? = null

)





/**
 * Represents responseFrame from Tracing. method call.
 *
 * Gets supported tracing categories.
 */
data class GetCategoriesResponse(
  /**
   * A list of supported tracing categories.
   */
  val categories : Array<String>

)


/**
 * Represents responseFrame from Tracing. method call.
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
 * Represents requestFrame parameters that can be used with Tracing.recordClockSyncMarker method call.
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
 * Represents responseFrame from Tracing. method call.
 *
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
 */
data class DataCollectedEvent(
  /**
   * 
   */
  val value : Array<Any>

) : pl.wendigo.chrome.DebuggerEvent(domain = "Tracing", name = "dataCollected")

/**
 * Represents responseFrame from Tracing. method call.
 *
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
 */
data class TracingCompleteEvent(
  /**
   * A handle of the stream that holds resulting trace data.
   */
  val stream : pl.wendigo.chrome.domain.io.StreamHandle? = null

) : pl.wendigo.chrome.DebuggerEvent(domain = "Tracing", name = "tracingComplete")

/**
 * Represents responseFrame from Tracing. method call.
 *
 * 
 */
data class BufferUsageEvent(
  /**
   * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
   */
  val percentFull : Double? = null,

  /**
   * An approximate number of events in the trace log.
   */
  val eventCount : Double? = null,

  /**
   * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
   */
  val value : Double? = null

) : pl.wendigo.chrome.DebuggerEvent(domain = "Tracing", name = "bufferUsage")

