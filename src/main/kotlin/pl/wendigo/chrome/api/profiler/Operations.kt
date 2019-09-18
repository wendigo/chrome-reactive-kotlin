package pl.wendigo.chrome.api.profiler

/**
 * ProfilerOperations represents Profiler protocol domain request/response operations and events that can be captured.
 *
 * @link Protocol [Profiler](https://chromedevtools.github.io/devtools-protocol/tot/Profiler) domain documentation.
 */
class ProfilerOperations internal constructor(private val connection : pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     *
     *
     * @link Protocol [Profiler#enable](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-enable) method documentation.
     */
        fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Profiler.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *
     *
     * @link Protocol [Profiler#disable](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-disable) method documentation.
     */
        fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Profiler.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
     *
     * @link Protocol [Profiler#setSamplingInterval](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-setSamplingInterval) method documentation.
     */
        fun setSamplingInterval(input: SetSamplingIntervalRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Profiler.setSamplingInterval", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *
     *
     * @link Protocol [Profiler#start](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-start) method documentation.
     */
        fun start(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Profiler.start", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *
     *
     * @link Protocol [Profiler#stop](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-stop) method documentation.
     */
        fun stop(): io.reactivex.Single<StopResponse> = connection.runAndCaptureResponse("Profiler.stop", null, StopResponse::class.java)


    /**
     *  Sent when new profile recodring is started using console.profile() call.
     */
    fun consoleProfileStarted(): io.reactivex.Flowable<ConsoleProfileStartedEvent> = connection.captureEvents("Profiler.consoleProfileStarted", ConsoleProfileStartedEvent::class.java);

    /**
     *  Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinished(): io.reactivex.Flowable<ConsoleProfileFinishedEvent> = connection.captureEvents("Profiler.consoleProfileFinished", ConsoleProfileFinishedEvent::class.java);


    /**
     * Returns flowable capturing all Profiler domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "Profiler"
        }
    }
}




/**
 * Represents request frame that can be used with [Profiler#setSamplingInterval](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-setSamplingInterval) operation call.
 *
 * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
 * @link [Profiler#setSamplingInterval](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#method-setSamplingInterval) method documentation.
 * @see [ProfilerOperations.setSamplingInterval]
 */
data class SetSamplingIntervalRequest (
    /**
     * New sampling interval in microseconds.
     */
    val interval: Int

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
 * Sent when new profile recodring is started using console.profile() call.
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

): pl.wendigo.chrome.protocol.Event(domain = "Profiler", name = "consoleProfileStarted")

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

): pl.wendigo.chrome.protocol.Event(domain = "Profiler", name = "consoleProfileFinished")

