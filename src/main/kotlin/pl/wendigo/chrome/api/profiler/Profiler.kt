package pl.wendigo.chrome.domain.profiler

/**
 * Profiler represents remote debugger protocol domain.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Profiler](https://chromedevtools.github.io/devtools-protocol/tot/Profiler)
 */
class Profiler internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     *
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
     */
    fun setSamplingInterval(input: SetSamplingIntervalRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.setSamplingInterval", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun start(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Profiler.start", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun stop(): io.reactivex.Single<StopResponse> {
        return connectionRemote.runAndCaptureResponse("Profiler.stop", null, StopResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Sent when new profile recodring is started using console.profile() call.
     */
    fun consoleProfileStarted(): io.reactivex.Flowable<ConsoleProfileStartedEvent> {
        return consoleProfileStartedTimed().map {
            it.value()
        }
    }

    /**
     * Sent when new profile recodring is started using console.profile() call.
     */
    fun consoleProfileStartedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ConsoleProfileStartedEvent>> {
        return connectionRemote.captureEvents("Profiler.consoleProfileStarted", ConsoleProfileStartedEvent::class.java)
    }

    /**
     * Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinished(): io.reactivex.Flowable<ConsoleProfileFinishedEvent> {
        return consoleProfileFinishedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Profiler.consoleProfileFinished events.
     */
    fun consoleProfileFinishedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ConsoleProfileFinishedEvent>> {
        return connectionRemote.captureEvents("Profiler.consoleProfileFinished", ConsoleProfileFinishedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Profiler domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
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
data class SetSamplingIntervalRequest(
    /**
     * New sampling interval in microseconds.
     */
    val interval: Int

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
    val profile: Profile

)

/**
 * Represents event frames for Profiler.consoleProfileStarted
 *
 * Sent when new profile recodring is started using console.profile() call.
 */
data class ConsoleProfileStartedEvent(
    /**  
     *  
     */  
    val id: String,

    /**  
     * Location of console.profile().  
     */  
    val location: pl.wendigo.chrome.domain.debugger.Location,

    /**  
     * Profile title passed as an argument to console.profile().  
     */  
    val title: String? = null

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
    val id: String,

    /**  
     * Location of console.profileEnd().  
     */  
    val location: pl.wendigo.chrome.domain.debugger.Location,

    /**  
     *  
     */  
    val profile: Profile,

    /**  
     * Profile title passed as an argument to console.profile().  
     */  
    val title: String? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Profiler", name = "consoleProfileFinished")
