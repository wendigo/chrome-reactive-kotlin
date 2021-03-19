package pl.wendigo.chrome.api.backgroundservice

import kotlinx.serialization.json.Json

/**
 * Defines events for background web platform features.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [BackgroundService](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class BackgroundServiceOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Enables event updates for the service.
     *
     * @link Protocol [BackgroundService#startObserving](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-startObserving) method documentation.
     */
    fun startObserving(input: StartObservingRequest) = connection.request("BackgroundService.startObserving", Json.encodeToJsonElement(StartObservingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Disables event updates for the service.
     *
     * @link Protocol [BackgroundService#stopObserving](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-stopObserving) method documentation.
     */
    fun stopObserving(input: StopObservingRequest) = connection.request("BackgroundService.stopObserving", Json.encodeToJsonElement(StopObservingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Set the recording state for the service.
     *
     * @link Protocol [BackgroundService#setRecording](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-setRecording) method documentation.
     */
    fun setRecording(input: SetRecordingRequest) = connection.request("BackgroundService.setRecording", Json.encodeToJsonElement(SetRecordingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Clears all stored data for the service.
     *
     * @link Protocol [BackgroundService#clearEvents](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-clearEvents) method documentation.
     */
    fun clearEvents(input: ClearEventsRequest) = connection.request("BackgroundService.clearEvents", Json.encodeToJsonElement(ClearEventsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Called when the recording state for the service has been updated.
     */
    fun recordingStateChanged(): io.reactivex.rxjava3.core.Flowable<RecordingStateChangedEvent> = connection.events("BackgroundService.recordingStateChanged", RecordingStateChangedEvent.serializer())

    /**
     *  Called with all existing backgroundServiceEvents when enabled, and all new
events afterwards if enabled and recording.
     */
    fun backgroundServiceEventReceived(): io.reactivex.rxjava3.core.Flowable<BackgroundServiceEventReceivedEvent> = connection.events("BackgroundService.backgroundServiceEventReceived", BackgroundServiceEventReceivedEvent.serializer())

    /**
     * Returns flowable capturing all BackgroundService domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.domain() == "BackgroundService"
        }
    }
}

/**
 * Represents request frame that can be used with [BackgroundService#startObserving](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-startObserving) operation call.
 *
 * Enables event updates for the service.
 * @link [BackgroundService#startObserving](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-startObserving) method documentation.
 * @see [BackgroundServiceOperations.startObserving]
 */
@kotlinx.serialization.Serializable
data class StartObservingRequest(
    /**
     *
     */
    val service: ServiceName

)

/**
 * Represents request frame that can be used with [BackgroundService#stopObserving](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-stopObserving) operation call.
 *
 * Disables event updates for the service.
 * @link [BackgroundService#stopObserving](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-stopObserving) method documentation.
 * @see [BackgroundServiceOperations.stopObserving]
 */
@kotlinx.serialization.Serializable
data class StopObservingRequest(
    /**
     *
     */
    val service: ServiceName

)

/**
 * Represents request frame that can be used with [BackgroundService#setRecording](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-setRecording) operation call.
 *
 * Set the recording state for the service.
 * @link [BackgroundService#setRecording](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-setRecording) method documentation.
 * @see [BackgroundServiceOperations.setRecording]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [BackgroundService#clearEvents](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-clearEvents) operation call.
 *
 * Clears all stored data for the service.
 * @link [BackgroundService#clearEvents](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#method-clearEvents) method documentation.
 * @see [BackgroundServiceOperations.clearEvents]
 */
@kotlinx.serialization.Serializable
data class ClearEventsRequest(
    /**
     *
     */
    val service: ServiceName

)

/**
 * Called when the recording state for the service has been updated.
 *
 * @link [BackgroundService#recordingStateChanged](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#event-recordingStateChanged) event documentation.
 */
@kotlinx.serialization.Serializable
data class RecordingStateChangedEvent(
    /**  
     *  
     */  
    val isRecording: Boolean,

    /**  
     *  
     */  
    val service: ServiceName

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "BackgroundService" 
    override fun eventName() = "recordingStateChanged"
} 

/**
 * Called with all existing backgroundServiceEvents when enabled, and all new
events afterwards if enabled and recording.
 *
 * @link [BackgroundService#backgroundServiceEventReceived](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#event-backgroundServiceEventReceived) event documentation.
 */
@kotlinx.serialization.Serializable
data class BackgroundServiceEventReceivedEvent(
    /**  
     *  
     */  
    val backgroundServiceEvent: BackgroundServiceEvent

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "BackgroundService" 
    override fun eventName() = "backgroundServiceEventReceived"
} 
