package pl.wendigo.chrome.domain.profiler

/**
 * ProfilerDomain represents remote debugger protocol domain.
 */
class ProfilerDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     *
     */
    fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
     */
    fun setSamplingInterval(input : SetSamplingIntervalRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.setSamplingInterval", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun start() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.start", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun stop() : io.reactivex.Single<StopResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.stop", null, StopResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code coverage may be incomplete. Enabling prevents running optimized code and resets execution counters.
     */
    fun startPreciseCoverage(input : StartPreciseCoverageRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.startPreciseCoverage", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disable precise code coverage. Disabling releases unnecessary execution count records and allows executing optimized code.
     */
    fun stopPreciseCoverage() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.stopPreciseCoverage", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
     */
    fun takePreciseCoverage() : io.reactivex.Single<TakePreciseCoverageResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.takePreciseCoverage", null, TakePreciseCoverageResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
     */
    fun getBestEffortCoverage() : io.reactivex.Single<GetBestEffortCoverageResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.getBestEffortCoverage", null, GetBestEffortCoverageResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sent when new profile recording is started using console.profile() call.
     */
    fun consoleProfileStarted() : io.reactivex.Flowable<ConsoleProfileStartedEvent> {
        return consoleProfileStartedTimed().map {
            it.value()
        }
    }

    /**
     * Sent when new profile recording is started using console.profile() call.
     */
    fun consoleProfileStartedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ConsoleProfileStartedEvent>> {
        return connectionRemote.captureEvents("Profiler.consoleProfileStarted", ConsoleProfileStartedEvent::class.java)
    }

    /**
     * Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinished() : io.reactivex.Flowable<ConsoleProfileFinishedEvent> {
        return consoleProfileFinishedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinishedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ConsoleProfileFinishedEvent>> {
        return connectionRemote.captureEvents("Profiler.consoleProfileFinished", ConsoleProfileFinishedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Profiler domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Profiler"
        }
    }
}

/**
 * Represents request frame that can be used with Profiler.setSamplingInterval method call.
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
 * Represents response frame for Profiler.stop method call.
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
 * Represents request frame that can be used with Profiler.startPreciseCoverage method call.
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
 * Represents response frame for Profiler.takePreciseCoverage method call.
 *
 * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
 */
data class TakePreciseCoverageResponse(
  /**
   * Coverage data for the current isolate.
   */
  val result : List<ScriptCoverage>

)

/**
 * Represents response frame for Profiler.getBestEffortCoverage method call.
 *
 * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
 */
data class GetBestEffortCoverageResponse(
  /**
   * Coverage data for the current isolate.
   */
  val result : List<ScriptCoverage>

)

/**
 * Represents event frames for Profiler.consoleProfileStarted
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
 * Represents event frames for Profiler.consoleProfileFinished
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

