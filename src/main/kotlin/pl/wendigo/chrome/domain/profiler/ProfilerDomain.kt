package pl.wendigo.chrome.domain.profiler

/**
 * ProfilerDomain represents remote debugger protocol domain.
 */
class ProfilerDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * 
	 */
	  fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
	 */
	  fun setSamplingInterval(input : SetSamplingIntervalRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.setSamplingInterval", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun start() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.start", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun stop() : io.reactivex.Single<StopResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.stop", null, StopResponse::class.java)
	}

	/**
	 * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code coverage may be incomplete. Enabling prevents running optimized code and resets execution counters.
	 */
	@pl.wendigo.chrome.Experimental
    fun startPreciseCoverage(input : StartPreciseCoverageRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.startPreciseCoverage", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disable precise code coverage. Disabling releases unnecessary execution count records and allows executing optimized code.
	 */
	@pl.wendigo.chrome.Experimental
    fun stopPreciseCoverage() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.stopPreciseCoverage", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
	 */
	@pl.wendigo.chrome.Experimental
    fun takePreciseCoverage() : io.reactivex.Single<TakePreciseCoverageResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.takePreciseCoverage", null, TakePreciseCoverageResponse::class.java)
	}

	/**
	 * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
	 */
	@pl.wendigo.chrome.Experimental
    fun getBestEffortCoverage() : io.reactivex.Single<GetBestEffortCoverageResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.getBestEffortCoverage", null, GetBestEffortCoverageResponse::class.java)
	}

  
    /**
     * Sent when new profile recording is started using console.profile() call.
     */
    fun consoleProfileStarted() : io.reactivex.Flowable<ConsoleProfileStartedEvent> {
        return connectionRemote.captureEvents("Profiler.consoleProfileStarted", ConsoleProfileStartedEvent::class.java)
    }

    /**
     * Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinished() : io.reactivex.Flowable<ConsoleProfileFinishedEvent> {
        return connectionRemote.captureEvents("Profiler.consoleProfileFinished", ConsoleProfileFinishedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Profiler domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "Profiler"
        }
    }
}




/**
 * Represents requestFrame parameters that can be used with Profiler.setSamplingInterval method call.
 *
 * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
 */
data class SetSamplingIntervalRequest (
    /**
     * New sampling interval in microseconds.
     */
    val interval : Int

)





/**
 * Represents responseFrame from Profiler. method call.
 *
 * 
 */
data class StopResponse(
  /**
   * Recorded profile.
   */
  val profile : Profile

)

/**
 * Represents requestFrame parameters that can be used with Profiler.startPreciseCoverage method call.
 *
 * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code coverage may be incomplete. Enabling prevents running optimized code and resets execution counters.
 */
data class StartPreciseCoverageRequest (
    /**
     * Collect accurate call counts beyond simple 'covered' or 'not covered'.
     */
    val callCount : Boolean? = null

)





/**
 * Represents responseFrame from Profiler. method call.
 *
 * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
 */
data class TakePreciseCoverageResponse(
  /**
   * Coverage data for the current isolate.
   */
  val result : Array<ScriptCoverage>

)


/**
 * Represents responseFrame from Profiler. method call.
 *
 * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
 */
data class GetBestEffortCoverageResponse(
  /**
   * Coverage data for the current isolate.
   */
  val result : Array<ScriptCoverage>

)

/**
 * Represents responseFrame from Profiler. method call.
 *
 * Sent when new profile recording is started using console.profile() call.
 */
data class ConsoleProfileStartedEvent(
  /**
   * 
   */
  val id : String,

  /**
   * Location of console.profile().
   */
  val location : pl.wendigo.chrome.domain.debugger.Location,

  /**
   * Profile title passed as an argument to console.profile().
   */
  val title : String? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Profiler", name = "consoleProfileStarted")

/**
 * Represents responseFrame from Profiler. method call.
 *
 * 
 */
data class ConsoleProfileFinishedEvent(
  /**
   * 
   */
  val id : String,

  /**
   * Location of console.profileEnd().
   */
  val location : pl.wendigo.chrome.domain.debugger.Location,

  /**
   * 
   */
  val profile : Profile,

  /**
   * Profile title passed as an argument to console.profile().
   */
  val title : String? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Profiler", name = "consoleProfileFinished")

