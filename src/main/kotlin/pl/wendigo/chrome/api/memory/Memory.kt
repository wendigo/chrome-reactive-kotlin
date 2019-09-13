package pl.wendigo.chrome.domain.memory

/**
 * Memory represents remote debugger protocol domain.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Memory](https://chromedevtools.github.io/devtools-protocol/tot/Memory)
 */
class Memory internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     *
     */
    fun getDOMCounters(): io.reactivex.Single<GetDOMCountersResponse> {
        return connectionRemote.runAndCaptureResponse("Memory.getDOMCounters", null, GetDOMCountersResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun prepareForLeakDetection(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.prepareForLeakDetection", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Simulate OomIntervention by purging V8 memory.
     */
    fun forciblyPurgeJavaScriptMemory(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.forciblyPurgeJavaScriptMemory", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enable/disable suppressing memory pressure notifications in all processes.
     */
    fun setPressureNotificationsSuppressed(input: SetPressureNotificationsSuppressedRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.setPressureNotificationsSuppressed", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Simulate a memory pressure notification in all processes.
     */
    fun simulatePressureNotification(input: SimulatePressureNotificationRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.simulatePressureNotification", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Start collecting native memory profile.
     */
    fun startSampling(input: StartSamplingRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.startSampling", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stop collecting native memory profile.
     */
    fun stopSampling(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Memory.stopSampling", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Retrieve native memory allocations profile
collected since renderer process startup.
     */
    fun getAllTimeSamplingProfile(): io.reactivex.Single<GetAllTimeSamplingProfileResponse> {
        return connectionRemote.runAndCaptureResponse("Memory.getAllTimeSamplingProfile", null, GetAllTimeSamplingProfileResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Retrieve native memory allocations profile
collected since browser process startup.
     */
    fun getBrowserSamplingProfile(): io.reactivex.Single<GetBrowserSamplingProfileResponse> {
        return connectionRemote.runAndCaptureResponse("Memory.getBrowserSamplingProfile", null, GetBrowserSamplingProfileResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Retrieve native memory allocations profile collected since last
`startSampling` call.
     */
    fun getSamplingProfile(): io.reactivex.Single<GetSamplingProfileResponse> {
        return connectionRemote.runAndCaptureResponse("Memory.getSamplingProfile", null, GetSamplingProfileResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Memory domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Memory"
        }
    }
}

/**
 * Represents response frame for Memory.getDOMCounters method call.
 *
 *
 */
data class GetDOMCountersResponse(
    /**  
     *  
     */  
    val documents: Int,

    /**  
     *  
     */  
    val nodes: Int,

    /**  
     *  
     */  
    val jsEventListeners: Int

)

/**
 * Represents request frame that can be used with Memory.setPressureNotificationsSuppressed method call.
 *
 * Enable/disable suppressing memory pressure notifications in all processes.
 */
data class SetPressureNotificationsSuppressedRequest(
    /**
     * If true, memory pressure notifications will be suppressed.
     */
    val suppressed: Boolean

)

/**
 * Represents request frame that can be used with Memory.simulatePressureNotification method call.
 *
 * Simulate a memory pressure notification in all processes.
 */
data class SimulatePressureNotificationRequest(
    /**
     * Memory pressure level of the notification.
     */
    val level: PressureLevel

)

/**
 * Represents request frame that can be used with Memory.startSampling method call.
 *
 * Start collecting native memory profile.
 */
data class StartSamplingRequest(
    /**
     * Average number of bytes between samples.
     */
    val samplingInterval: Int? = null,

    /**
     * Do not randomize intervals between samples.
     */
    val suppressRandomness: Boolean? = null

)

/**
 * Represents response frame for Memory.getAllTimeSamplingProfile method call.
 *
 * Retrieve native memory allocations profile
collected since renderer process startup.
 */
data class GetAllTimeSamplingProfileResponse(
    /**  
     *  
     */  
    val profile: SamplingProfile

)

/**
 * Represents response frame for Memory.getBrowserSamplingProfile method call.
 *
 * Retrieve native memory allocations profile
collected since browser process startup.
 */
data class GetBrowserSamplingProfileResponse(
    /**  
     *  
     */  
    val profile: SamplingProfile

)

/**
 * Represents response frame for Memory.getSamplingProfile method call.
 *
 * Retrieve native memory allocations profile collected since last
`startSampling` call.
 */
data class GetSamplingProfileResponse(
    /**  
     *  
     */  
    val profile: SamplingProfile

)
