package pl.wendigo.chrome.api.serviceworker

import kotlinx.serialization.json.Json

/**
 * ServiceWorkerOperations represents ServiceWorker protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [ServiceWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class ServiceWorkerOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     *
     *
     * @link Protocol [ServiceWorker#deliverPushMessage](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-deliverPushMessage) method documentation.
     */
    fun deliverPushMessage(input: DeliverPushMessageRequest) = connection.request("ServiceWorker.deliverPushMessage", Json.encodeToJsonElement(DeliverPushMessageRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#disable](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-disable) method documentation.
     */
    fun disable() = connection.request("ServiceWorker.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#dispatchSyncEvent](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-dispatchSyncEvent) method documentation.
     */
    fun dispatchSyncEvent(input: DispatchSyncEventRequest) = connection.request("ServiceWorker.dispatchSyncEvent", Json.encodeToJsonElement(DispatchSyncEventRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#dispatchPeriodicSyncEvent](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-dispatchPeriodicSyncEvent) method documentation.
     */
    fun dispatchPeriodicSyncEvent(input: DispatchPeriodicSyncEventRequest) = connection.request("ServiceWorker.dispatchPeriodicSyncEvent", Json.encodeToJsonElement(DispatchPeriodicSyncEventRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#enable](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-enable) method documentation.
     */
    fun enable() = connection.request("ServiceWorker.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#inspectWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-inspectWorker) method documentation.
     */
    fun inspectWorker(input: InspectWorkerRequest) = connection.request("ServiceWorker.inspectWorker", Json.encodeToJsonElement(InspectWorkerRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#setForceUpdateOnPageLoad](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-setForceUpdateOnPageLoad) method documentation.
     */
    fun setForceUpdateOnPageLoad(input: SetForceUpdateOnPageLoadRequest) = connection.request("ServiceWorker.setForceUpdateOnPageLoad", Json.encodeToJsonElement(SetForceUpdateOnPageLoadRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#skipWaiting](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-skipWaiting) method documentation.
     */
    fun skipWaiting(input: SkipWaitingRequest) = connection.request("ServiceWorker.skipWaiting", Json.encodeToJsonElement(SkipWaitingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#startWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-startWorker) method documentation.
     */
    fun startWorker(input: StartWorkerRequest) = connection.request("ServiceWorker.startWorker", Json.encodeToJsonElement(StartWorkerRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#stopAllWorkers](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-stopAllWorkers) method documentation.
     */
    fun stopAllWorkers() = connection.request("ServiceWorker.stopAllWorkers", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#stopWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-stopWorker) method documentation.
     */
    fun stopWorker(input: StopWorkerRequest) = connection.request("ServiceWorker.stopWorker", Json.encodeToJsonElement(StopWorkerRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#unregister](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-unregister) method documentation.
     */
    fun unregister(input: UnregisterRequest) = connection.request("ServiceWorker.unregister", Json.encodeToJsonElement(UnregisterRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [ServiceWorker#updateRegistration](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-updateRegistration) method documentation.
     */
    fun updateRegistration(input: UpdateRegistrationRequest) = connection.request("ServiceWorker.updateRegistration", Json.encodeToJsonElement(UpdateRegistrationRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Returns observable capturing all ServiceWorker.workerErrorReported events.
     */
    fun workerErrorReported(): io.reactivex.rxjava3.core.Flowable<WorkerErrorReportedEvent> = connection.events("ServiceWorker.workerErrorReported", WorkerErrorReportedEvent.serializer())

    /**
     *  Returns observable capturing all ServiceWorker.workerRegistrationUpdated events.
     */
    fun workerRegistrationUpdated(): io.reactivex.rxjava3.core.Flowable<WorkerRegistrationUpdatedEvent> = connection.events("ServiceWorker.workerRegistrationUpdated", WorkerRegistrationUpdatedEvent.serializer())

    /**
     *  Returns observable capturing all ServiceWorker.workerVersionUpdated events.
     */
    fun workerVersionUpdated(): io.reactivex.rxjava3.core.Flowable<WorkerVersionUpdatedEvent> = connection.events("ServiceWorker.workerVersionUpdated", WorkerVersionUpdatedEvent.serializer())

    /**
     * Returns flowable capturing all ServiceWorker domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.domain() == "ServiceWorker"
        }
    }
}

/**
 * Represents request frame that can be used with [ServiceWorker#deliverPushMessage](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-deliverPushMessage) operation call.
 *
 *
 * @link [ServiceWorker#deliverPushMessage](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-deliverPushMessage) method documentation.
 * @see [ServiceWorkerOperations.deliverPushMessage]
 */
@kotlinx.serialization.Serializable
data class DeliverPushMessageRequest(
    /**
     *
     */
    val origin: String,

    /**
     *
     */
    val registrationId: RegistrationID,

    /**
     *
     */
    val data: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#dispatchSyncEvent](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-dispatchSyncEvent) operation call.
 *
 *
 * @link [ServiceWorker#dispatchSyncEvent](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-dispatchSyncEvent) method documentation.
 * @see [ServiceWorkerOperations.dispatchSyncEvent]
 */
@kotlinx.serialization.Serializable
data class DispatchSyncEventRequest(
    /**
     *
     */
    val origin: String,

    /**
     *
     */
    val registrationId: RegistrationID,

    /**
     *
     */
    val tag: String,

    /**
     *
     */
    val lastChance: Boolean

)

/**
 * Represents request frame that can be used with [ServiceWorker#dispatchPeriodicSyncEvent](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-dispatchPeriodicSyncEvent) operation call.
 *
 *
 * @link [ServiceWorker#dispatchPeriodicSyncEvent](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-dispatchPeriodicSyncEvent) method documentation.
 * @see [ServiceWorkerOperations.dispatchPeriodicSyncEvent]
 */
@kotlinx.serialization.Serializable
data class DispatchPeriodicSyncEventRequest(
    /**
     *
     */
    val origin: String,

    /**
     *
     */
    val registrationId: RegistrationID,

    /**
     *
     */
    val tag: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#inspectWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-inspectWorker) operation call.
 *
 *
 * @link [ServiceWorker#inspectWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-inspectWorker) method documentation.
 * @see [ServiceWorkerOperations.inspectWorker]
 */
@kotlinx.serialization.Serializable
data class InspectWorkerRequest(
    /**
     *
     */
    val versionId: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#setForceUpdateOnPageLoad](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-setForceUpdateOnPageLoad) operation call.
 *
 *
 * @link [ServiceWorker#setForceUpdateOnPageLoad](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-setForceUpdateOnPageLoad) method documentation.
 * @see [ServiceWorkerOperations.setForceUpdateOnPageLoad]
 */
@kotlinx.serialization.Serializable
data class SetForceUpdateOnPageLoadRequest(
    /**
     *
     */
    val forceUpdateOnPageLoad: Boolean

)

/**
 * Represents request frame that can be used with [ServiceWorker#skipWaiting](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-skipWaiting) operation call.
 *
 *
 * @link [ServiceWorker#skipWaiting](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-skipWaiting) method documentation.
 * @see [ServiceWorkerOperations.skipWaiting]
 */
@kotlinx.serialization.Serializable
data class SkipWaitingRequest(
    /**
     *
     */
    val scopeURL: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#startWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-startWorker) operation call.
 *
 *
 * @link [ServiceWorker#startWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-startWorker) method documentation.
 * @see [ServiceWorkerOperations.startWorker]
 */
@kotlinx.serialization.Serializable
data class StartWorkerRequest(
    /**
     *
     */
    val scopeURL: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#stopWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-stopWorker) operation call.
 *
 *
 * @link [ServiceWorker#stopWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-stopWorker) method documentation.
 * @see [ServiceWorkerOperations.stopWorker]
 */
@kotlinx.serialization.Serializable
data class StopWorkerRequest(
    /**
     *
     */
    val versionId: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#unregister](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-unregister) operation call.
 *
 *
 * @link [ServiceWorker#unregister](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-unregister) method documentation.
 * @see [ServiceWorkerOperations.unregister]
 */
@kotlinx.serialization.Serializable
data class UnregisterRequest(
    /**
     *
     */
    val scopeURL: String

)

/**
 * Represents request frame that can be used with [ServiceWorker#updateRegistration](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-updateRegistration) operation call.
 *
 *
 * @link [ServiceWorker#updateRegistration](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#method-updateRegistration) method documentation.
 * @see [ServiceWorkerOperations.updateRegistration]
 */
@kotlinx.serialization.Serializable
data class UpdateRegistrationRequest(
    /**
     *
     */
    val scopeURL: String

)

/**
 *
 *
 * @link [ServiceWorker#workerErrorReported](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#event-workerErrorReported) event documentation.
 */
@kotlinx.serialization.Serializable
data class WorkerErrorReportedEvent(
    /**  
     *  
     */  
    val errorMessage: ServiceWorkerErrorMessage

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "ServiceWorker" 
    override fun eventName() = "workerErrorReported"
} 

/**
 *
 *
 * @link [ServiceWorker#workerRegistrationUpdated](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#event-workerRegistrationUpdated) event documentation.
 */
@kotlinx.serialization.Serializable
data class WorkerRegistrationUpdatedEvent(
    /**  
     *  
     */  
    val registrations: List<ServiceWorkerRegistration>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "ServiceWorker" 
    override fun eventName() = "workerRegistrationUpdated"
} 

/**
 *
 *
 * @link [ServiceWorker#workerVersionUpdated](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#event-workerVersionUpdated) event documentation.
 */
@kotlinx.serialization.Serializable
data class WorkerVersionUpdatedEvent(
    /**  
     *  
     */  
    val versions: List<ServiceWorkerVersion>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "ServiceWorker" 
    override fun eventName() = "workerVersionUpdated"
} 
