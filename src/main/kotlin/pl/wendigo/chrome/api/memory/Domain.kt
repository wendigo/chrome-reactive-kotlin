package pl.wendigo.chrome.api.memory

import kotlinx.serialization.json.Json

/**
 * MemoryDomain represents Memory protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Memory](https://chromedevtools.github.io/devtools-protocol/tot/Memory) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class MemoryDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("Memory", """""", connection) {
    /**
     *
     *
     * @link Protocol [Memory#getDOMCounters](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getDOMCounters) method documentation.
     */
    
    fun getDOMCounters(): io.reactivex.rxjava3.core.Single<GetDOMCountersResponse> = connection.request("Memory.getDOMCounters", null, GetDOMCountersResponse.serializer())

    /**
     *
     *
     * @link Protocol [Memory#prepareForLeakDetection](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-prepareForLeakDetection) method documentation.
     */
    
    fun prepareForLeakDetection(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Memory.prepareForLeakDetection", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Simulate OomIntervention by purging V8 memory.
     *
     * @link Protocol [Memory#forciblyPurgeJavaScriptMemory](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-forciblyPurgeJavaScriptMemory) method documentation.
     */
    
    fun forciblyPurgeJavaScriptMemory(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Memory.forciblyPurgeJavaScriptMemory", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Enable/disable suppressing memory pressure notifications in all processes.
     *
     * @link Protocol [Memory#setPressureNotificationsSuppressed](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-setPressureNotificationsSuppressed) method documentation.
     */
    
    fun setPressureNotificationsSuppressed(input: SetPressureNotificationsSuppressedRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Memory.setPressureNotificationsSuppressed", Json.encodeToJsonElement(SetPressureNotificationsSuppressedRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Simulate a memory pressure notification in all processes.
     *
     * @link Protocol [Memory#simulatePressureNotification](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-simulatePressureNotification) method documentation.
     */
    
    fun simulatePressureNotification(input: SimulatePressureNotificationRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Memory.simulatePressureNotification", Json.encodeToJsonElement(SimulatePressureNotificationRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Start collecting native memory profile.
     *
     * @link Protocol [Memory#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-startSampling) method documentation.
     */
    
    fun startSampling(input: StartSamplingRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Memory.startSampling", Json.encodeToJsonElement(StartSamplingRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Stop collecting native memory profile.
     *
     * @link Protocol [Memory#stopSampling](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-stopSampling) method documentation.
     */
    
    fun stopSampling(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Memory.stopSampling", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Retrieve native memory allocations profile
collected since renderer process startup.
     *
     * @link Protocol [Memory#getAllTimeSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getAllTimeSamplingProfile) method documentation.
     */
    
    fun getAllTimeSamplingProfile(): io.reactivex.rxjava3.core.Single<GetAllTimeSamplingProfileResponse> = connection.request("Memory.getAllTimeSamplingProfile", null, GetAllTimeSamplingProfileResponse.serializer())

    /**
     * Retrieve native memory allocations profile
collected since browser process startup.
     *
     * @link Protocol [Memory#getBrowserSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getBrowserSamplingProfile) method documentation.
     */
    
    fun getBrowserSamplingProfile(): io.reactivex.rxjava3.core.Single<GetBrowserSamplingProfileResponse> = connection.request("Memory.getBrowserSamplingProfile", null, GetBrowserSamplingProfileResponse.serializer())

    /**
     * Retrieve native memory allocations profile collected since last
`startSampling` call.
     *
     * @link Protocol [Memory#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getSamplingProfile) method documentation.
     */
    
    fun getSamplingProfile(): io.reactivex.rxjava3.core.Single<GetSamplingProfileResponse> = connection.request("Memory.getSamplingProfile", null, GetSamplingProfileResponse.serializer())
}

/**
 * Represents response frame that is returned from [Memory#getDOMCounters](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getDOMCounters) operation call.
 *
 *
  
 * @link [Memory#getDOMCounters](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getDOMCounters) method documentation.
 * @see [MemoryDomain.getDOMCounters]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Memory#setPressureNotificationsSuppressed](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-setPressureNotificationsSuppressed) operation call.
 *
 * Enable/disable suppressing memory pressure notifications in all processes.
 * @link [Memory#setPressureNotificationsSuppressed](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-setPressureNotificationsSuppressed) method documentation.
 * @see [MemoryDomain.setPressureNotificationsSuppressed]
 */
@kotlinx.serialization.Serializable
data class SetPressureNotificationsSuppressedRequest(
    /**
     * If true, memory pressure notifications will be suppressed.
     */
    val suppressed: Boolean

)

/**
 * Represents request frame that can be used with [Memory#simulatePressureNotification](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-simulatePressureNotification) operation call.
 *
 * Simulate a memory pressure notification in all processes.
 * @link [Memory#simulatePressureNotification](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-simulatePressureNotification) method documentation.
 * @see [MemoryDomain.simulatePressureNotification]
 */
@kotlinx.serialization.Serializable
data class SimulatePressureNotificationRequest(
    /**
     * Memory pressure level of the notification.
     */
    val level: PressureLevel

)

/**
 * Represents request frame that can be used with [Memory#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-startSampling) operation call.
 *
 * Start collecting native memory profile.
 * @link [Memory#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-startSampling) method documentation.
 * @see [MemoryDomain.startSampling]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [Memory#getAllTimeSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getAllTimeSamplingProfile) operation call.
 * Retrieve native memory allocations profile
collected since renderer process startup.
 *
  
 * @link [Memory#getAllTimeSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getAllTimeSamplingProfile) method documentation.
 * @see [MemoryDomain.getAllTimeSamplingProfile]
 */
@kotlinx.serialization.Serializable
data class GetAllTimeSamplingProfileResponse(
    /**  
     *  
     */  
    val profile: SamplingProfile

)

/**
 * Represents response frame that is returned from [Memory#getBrowserSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getBrowserSamplingProfile) operation call.
 * Retrieve native memory allocations profile
collected since browser process startup.
 *
  
 * @link [Memory#getBrowserSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getBrowserSamplingProfile) method documentation.
 * @see [MemoryDomain.getBrowserSamplingProfile]
 */
@kotlinx.serialization.Serializable
data class GetBrowserSamplingProfileResponse(
    /**  
     *  
     */  
    val profile: SamplingProfile

)

/**
 * Represents response frame that is returned from [Memory#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getSamplingProfile) operation call.
 * Retrieve native memory allocations profile collected since last
`startSampling` call.
 *
  
 * @link [Memory#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/Memory#method-getSamplingProfile) method documentation.
 * @see [MemoryDomain.getSamplingProfile]
 */
@kotlinx.serialization.Serializable
data class GetSamplingProfileResponse(
    /**  
     *  
     */  
    val profile: SamplingProfile

)
