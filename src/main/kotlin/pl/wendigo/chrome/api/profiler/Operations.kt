package pl.wendigo.chrome.api.profiler

/**
 * ProfilerOperations represents Profiler protocol domain request/response operations and events that can be captured.
 *
 * @link Protocol [Profiler](https://chromedevtools.github.io/devtools-protocol/tot/Profiler) domain documentation.
 */
class ProfilerOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     *
     *
     * @link Protocol [Profiler#disable](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-disable) method documentation.
     */
    fun disable() = connection.request("Profiler.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Profiler#enable](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-enable) method documentation.
     */
    fun enable() = connection.request("Profiler.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Collect coverage data for the current isolate. The coverage data may be incomplete due to
garbage collection.
     *
     * @link Protocol [Profiler#getBestEffortCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getBestEffortCoverage) method documentation.
     */
    fun getBestEffortCoverage() = connection.request("Profiler.getBestEffortCoverage", null, GetBestEffortCoverageResponse::class.java)

    /**
     * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
     *
     * @link Protocol [Profiler#setSamplingInterval](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-setSamplingInterval) method documentation.
     */
    fun setSamplingInterval(input: SetSamplingIntervalRequest) = connection.request("Profiler.setSamplingInterval", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Profiler#start](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-start) method documentation.
     */
    fun start() = connection.request("Profiler.start", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code
coverage may be incomplete. Enabling prevents running optimized code and resets execution
counters.
     *
     * @link Protocol [Profiler#startPreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-startPreciseCoverage) method documentation.
     */
    fun startPreciseCoverage(input: StartPreciseCoverageRequest) = connection.request("Profiler.startPreciseCoverage", input, StartPreciseCoverageResponse::class.java)

    /**
     * Enable type profile.
     *
     * @link Protocol [Profiler#startTypeProfile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-startTypeProfile) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun startTypeProfile() = connection.request("Profiler.startTypeProfile", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Profiler#stop](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-stop) method documentation.
     */
    fun stop() = connection.request("Profiler.stop", null, StopResponse::class.java)

    /**
     * Disable precise code coverage. Disabling releases unnecessary execution count records and allows
executing optimized code.
     *
     * @link Protocol [Profiler#stopPreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-stopPreciseCoverage) method documentation.
     */
    fun stopPreciseCoverage() = connection.request("Profiler.stopPreciseCoverage", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disable type profile. Disabling releases type profile data collected so far.
     *
     * @link Protocol [Profiler#stopTypeProfile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-stopTypeProfile) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun stopTypeProfile() = connection.request("Profiler.stopTypeProfile", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Collect coverage data for the current isolate, and resets execution counters. Precise code
coverage needs to have started.
     *
     * @link Protocol [Profiler#takePreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-takePreciseCoverage) method documentation.
     */
    fun takePreciseCoverage() = connection.request("Profiler.takePreciseCoverage", null, TakePreciseCoverageResponse::class.java)

    /**
     * Collect type profile.
     *
     * @link Protocol [Profiler#takeTypeProfile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-takeTypeProfile) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun takeTypeProfile() = connection.request("Profiler.takeTypeProfile", null, TakeTypeProfileResponse::class.java)

    /**
     * Enable counters collection.
     *
     * @link Protocol [Profiler#enableCounters](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-enableCounters) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun enableCounters() = connection.request("Profiler.enableCounters", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disable counters collection.
     *
     * @link Protocol [Profiler#disableCounters](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-disableCounters) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun disableCounters() = connection.request("Profiler.disableCounters", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Retrieve counters.
     *
     * @link Protocol [Profiler#getCounters](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getCounters) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getCounters() = connection.request("Profiler.getCounters", null, GetCountersResponse::class.java)

    /**
     * Enable run time call stats collection.
     *
     * @link Protocol [Profiler#enableRuntimeCallStats](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-enableRuntimeCallStats) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun enableRuntimeCallStats() = connection.request("Profiler.enableRuntimeCallStats", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disable run time call stats collection.
     *
     * @link Protocol [Profiler#disableRuntimeCallStats](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-disableRuntimeCallStats) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun disableRuntimeCallStats() = connection.request("Profiler.disableRuntimeCallStats", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Retrieve run time call stats.
     *
     * @link Protocol [Profiler#getRuntimeCallStats](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getRuntimeCallStats) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getRuntimeCallStats() = connection.request("Profiler.getRuntimeCallStats", null, GetRuntimeCallStatsResponse::class.java)

    /**
     *  Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinished(): io.reactivex.Flowable<ConsoleProfileFinishedEvent> = connection.events("Profiler.consoleProfileFinished", ConsoleProfileFinishedEvent::class.java)

    /**
     *  Sent when new profile recording is started using console.profile() call.
     */
    fun consoleProfileStarted(): io.reactivex.Flowable<ConsoleProfileStartedEvent> = connection.events("Profiler.consoleProfileStarted", ConsoleProfileStartedEvent::class.java)

    /**
     *  Reports coverage delta since the last poll (either from an event like this, or from
`takePreciseCoverage` for the current isolate. May only be sent if precise code
coverage has been started. This event can be trigged by the embedder to, for example,
trigger collection of coverage data immediatelly at a certain point in time.
     */
    fun preciseCoverageDeltaUpdate(): io.reactivex.Flowable<PreciseCoverageDeltaUpdateEvent> = connection.events("Profiler.preciseCoverageDeltaUpdate", PreciseCoverageDeltaUpdateEvent::class.java)

    /**
     * Returns flowable capturing all Profiler domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Profiler"
        }
    }
}

/**
 * Represents response frame that is returned from [Profiler#getBestEffortCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getBestEffortCoverage) operation call.
 * Collect coverage data for the current isolate. The coverage data may be incomplete due to
garbage collection.
 *
  
 * @link [Profiler#getBestEffortCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getBestEffortCoverage) method documentation.
 * @see [ProfilerOperations.getBestEffortCoverage]
 */
data class GetBestEffortCoverageResponse(
    /**  
     * Coverage data for the current isolate.  
     */  
    val result: List<ScriptCoverage>

)

/**
 * Represents request frame that can be used with [Profiler#setSamplingInterval](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-setSamplingInterval) operation call.
 *
 * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
 * @link [Profiler#setSamplingInterval](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-setSamplingInterval) method documentation.
 * @see [ProfilerOperations.setSamplingInterval]
 */
data class SetSamplingIntervalRequest(
    /**
     * New sampling interval in microseconds.
     */
    val interval: Int

)

/**
 * Represents request frame that can be used with [Profiler#startPreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-startPreciseCoverage) operation call.
 *
 * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code
coverage may be incomplete. Enabling prevents running optimized code and resets execution
counters.
 * @link [Profiler#startPreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-startPreciseCoverage) method documentation.
 * @see [ProfilerOperations.startPreciseCoverage]
 */
data class StartPreciseCoverageRequest(
    /**
     * Collect accurate call counts beyond simple 'covered' or 'not covered'.
     */
    val callCount: Boolean? = null,

    /**
     * Collect block-based coverage.
     */
    val detailed: Boolean? = null,

    /**
     * Allow the backend to send updates on its own initiative
     */
    val allowTriggeredUpdates: Boolean? = null

)
/**
 * Represents response frame that is returned from [Profiler#startPreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-startPreciseCoverage) operation call.
 * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code
coverage may be incomplete. Enabling prevents running optimized code and resets execution
counters.
 *
  
 * @link [Profiler#startPreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-startPreciseCoverage) method documentation.
 * @see [ProfilerOperations.startPreciseCoverage]
 */
data class StartPreciseCoverageResponse(
    /**  
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.  
     */  
    val timestamp: Double

)

/**
 * Represents response frame that is returned from [Profiler#stop](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-stop) operation call.
 *
 *
  
 * @link [Profiler#stop](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-stop) method documentation.
 * @see [ProfilerOperations.stop]
 */
data class StopResponse(
    /**  
     * Recorded profile.  
     */  
    val profile: Profile

)

/**
 * Represents response frame that is returned from [Profiler#takePreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-takePreciseCoverage) operation call.
 * Collect coverage data for the current isolate, and resets execution counters. Precise code
coverage needs to have started.
 *
  
 * @link [Profiler#takePreciseCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-takePreciseCoverage) method documentation.
 * @see [ProfilerOperations.takePreciseCoverage]
 */
data class TakePreciseCoverageResponse(
    /**  
     * Coverage data for the current isolate.  
     */  
    val result: List<ScriptCoverage>,

    /**  
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.  
     */  
    val timestamp: Double

)

/**
 * Represents response frame that is returned from [Profiler#takeTypeProfile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-takeTypeProfile) operation call.
 * Collect type profile.
 *
  
 * @link [Profiler#takeTypeProfile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-takeTypeProfile) method documentation.
 * @see [ProfilerOperations.takeTypeProfile]
 */
data class TakeTypeProfileResponse(
    /**  
     * Type profile for all scripts since startTypeProfile() was turned on.  
     */  
    val result: List<ScriptTypeProfile>

)

/**
 * Represents response frame that is returned from [Profiler#getCounters](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getCounters) operation call.
 * Retrieve counters.
 *
  
 * @link [Profiler#getCounters](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getCounters) method documentation.
 * @see [ProfilerOperations.getCounters]
 */
data class GetCountersResponse(
    /**  
     * Collected counters information.  
     */  
    val result: List<CounterInfo>

)

/**
 * Represents response frame that is returned from [Profiler#getRuntimeCallStats](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getRuntimeCallStats) operation call.
 * Retrieve run time call stats.
 *
  
 * @link [Profiler#getRuntimeCallStats](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-getRuntimeCallStats) method documentation.
 * @see [ProfilerOperations.getRuntimeCallStats]
 */
data class GetRuntimeCallStatsResponse(
    /**  
     * Collected runtime call counter information.  
     */  
    val result: List<RuntimeCallCounterInfo>

)

/**
 *
 *
 * @link [Profiler#consoleProfileFinished](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#event-consoleProfileFinished) event documentation.
 */
data class ConsoleProfileFinishedEvent(
    /**  
     *  
     */  
    val id: String,

    /**  
     * Location of console.profileEnd().  
     */  
    val location: pl.wendigo.chrome.api.debugger.Location,

    /**  
     *  
     */  
    val profile: Profile,

    /**  
     * Profile title passed as an argument to console.profile().  
     */  
    val title: String? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Profiler", name = "consoleProfileFinished")

/**
 * Sent when new profile recording is started using console.profile() call.
 *
 * @link [Profiler#consoleProfileStarted](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#event-consoleProfileStarted) event documentation.
 */
data class ConsoleProfileStartedEvent(
    /**  
     *  
     */  
    val id: String,

    /**  
     * Location of console.profile().  
     */  
    val location: pl.wendigo.chrome.api.debugger.Location,

    /**  
     * Profile title passed as an argument to console.profile().  
     */  
    val title: String? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Profiler", name = "consoleProfileStarted")

/**
 * Reports coverage delta since the last poll (either from an event like this, or from
`takePreciseCoverage` for the current isolate. May only be sent if precise code
coverage has been started. This event can be trigged by the embedder to, for example,
trigger collection of coverage data immediatelly at a certain point in time.
 *
 * @link [Profiler#preciseCoverageDeltaUpdate](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#event-preciseCoverageDeltaUpdate) event documentation.
 */
data class PreciseCoverageDeltaUpdateEvent(
    /**  
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.  
     */  
    val timestamp: Double,

    /**  
     * Identifier for distinguishing coverage events.  
     */  
    val occassion: String,

    /**  
     * Coverage data for the current isolate.  
     */  
    val result: List<ScriptCoverage>

) : pl.wendigo.chrome.protocol.Event(domain = "Profiler", name = "preciseCoverageDeltaUpdate")
