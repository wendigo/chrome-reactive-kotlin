package pl.wendigo.chrome.domain.backgroundservice

/**
 * Defines events for background web platform features.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService)
 */
class BackgroundService internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Enables event updates for the service.
     */
    fun startObserving(input: StartObservingRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("BackgroundService.startObserving", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables event updates for the service.
     */
    fun stopObserving(input: StopObservingRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("BackgroundService.stopObserving", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Set the recording state for the service.
     */
    fun setRecording(input: SetRecordingRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("BackgroundService.setRecording", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears all stored data for the service.
     */
    fun clearEvents(input: ClearEventsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("BackgroundService.clearEvents", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Called when the recording state for the service has been updated.
     */
    fun recordingStateChanged(): io.reactivex.Flowable<RecordingStateChangedEvent> {
        return recordingStateChangedTimed().map {
            it.value()
        }
    }

    /**
     * Called when the recording state for the service has been updated.
     */
    fun recordingStateChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<RecordingStateChangedEvent>> {
        return connectionRemote.captureEvents("BackgroundService.recordingStateChanged", RecordingStateChangedEvent::class.java)
    }

    /**
     *  Called with all existing backgroundServiceEvents when enabled, and all new
events afterwards if enabled and recording.
     */
    fun backgroundServiceEventReceived(): io.reactivex.Flowable<BackgroundServiceEventReceivedEvent> {
        return backgroundServiceEventReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Called with all existing backgroundServiceEvents when enabled, and all new
events afterwards if enabled and recording.
     */
    fun backgroundServiceEventReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<BackgroundServiceEventReceivedEvent>> {
        return connectionRemote.captureEvents("BackgroundService.backgroundServiceEventReceived", BackgroundServiceEventReceivedEvent::class.java)
    }

    /**
     * Returns flowable capturing all BackgroundService domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "BackgroundService"
        }
    }
}
/**
 * Represents request frame that can be used with BackgroundService.startObserving method call.
 *
 * Enables event updates for the service.
 */
data class StartObservingRequest(
    /**
     *
     */
    val service: ServiceName

)

/**
 * Represents request frame that can be used with BackgroundService.stopObserving method call.
 *
 * Disables event updates for the service.
 */
data class StopObservingRequest(
    /**
     *
     */
    val service: ServiceName

)

/**
 * Represents request frame that can be used with BackgroundService.setRecording method call.
 *
 * Set the recording state for the service.
 */
data class SetRecordingRequest(
    /**
     *
     */
    val shouldRecord: Boolean,

    /**
     *
     */
    val service: ServiceName

)

/**
 * Represents request frame that can be used with BackgroundService.clearEvents method call.
 *
 * Clears all stored data for the service.
 */
data class ClearEventsRequest(
    /**
     *
     */
    val service: ServiceName

)

/**
 * Represents event frames for BackgroundService.recordingStateChanged
 *
 * Called when the recording state for the service has been updated.
 */
data class RecordingStateChangedEvent(
    /**  
     *  
     */  
    val isRecording: Boolean,

    /**  
     *  
     */  
    val service: ServiceName

) : pl.wendigo.chrome.ProtocolEvent(domain = "BackgroundService", name = "recordingStateChanged")

/**
 * Represents event frames for BackgroundService.backgroundServiceEventReceived
 *
 * Called with all existing backgroundServiceEvents when enabled, and all new
events afterwards if enabled and recording.
 */
data class BackgroundServiceEventReceivedEvent(
    /**  
     *  
     */  
    val backgroundServiceEvent: BackgroundServiceEvent

) : pl.wendigo.chrome.ProtocolEvent(domain = "BackgroundService", name = "backgroundServiceEventReceived")
