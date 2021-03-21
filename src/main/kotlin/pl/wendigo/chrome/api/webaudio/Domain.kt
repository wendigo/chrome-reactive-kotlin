package pl.wendigo.chrome.api.webaudio

import kotlinx.serialization.json.Json

/**
 * This domain allows inspection of Web Audio API.
https://webaudio.github.io/web-audio-api/
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [WebAudio](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class WebAudioDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain(
        "WebAudio",
        """This domain allows inspection of Web Audio API.
https://webaudio.github.io/web-audio-api/""",
        connection
    ) {
    /**
     * Enables the WebAudio domain and starts sending context lifetime events.
     *
     * @link Protocol [WebAudio#enable](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAudio.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Disables the WebAudio domain.
     *
     * @link Protocol [WebAudio#disable](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAudio.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Fetch the realtime data from the registered contexts.
     *
     * @link Protocol [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) method documentation.
     */
    
    fun getRealtimeData(input: GetRealtimeDataRequest): io.reactivex.rxjava3.core.Single<GetRealtimeDataResponse> = connection.request("WebAudio.getRealtimeData", Json.encodeToJsonElement(GetRealtimeDataRequest.serializer(), input), GetRealtimeDataResponse.serializer())

    /**
     *  Notifies that a new BaseAudioContext has been created.
     */
    fun contextCreated(): io.reactivex.rxjava3.core.Flowable<ContextCreatedEvent> = connection.events("WebAudio.contextCreated", ContextCreatedEvent.serializer())

    /**
     *  Notifies that an existing BaseAudioContext will be destroyed.
     */
    fun contextWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<ContextWillBeDestroyedEvent> = connection.events("WebAudio.contextWillBeDestroyed", ContextWillBeDestroyedEvent.serializer())

    /**
     *  Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
     */
    fun contextChanged(): io.reactivex.rxjava3.core.Flowable<ContextChangedEvent> = connection.events("WebAudio.contextChanged", ContextChangedEvent.serializer())

    /**
     *  Notifies that the construction of an AudioListener has finished.
     */
    fun audioListenerCreated(): io.reactivex.rxjava3.core.Flowable<AudioListenerCreatedEvent> = connection.events("WebAudio.audioListenerCreated", AudioListenerCreatedEvent.serializer())

    /**
     *  Notifies that a new AudioListener has been created.
     */
    fun audioListenerWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<AudioListenerWillBeDestroyedEvent> = connection.events("WebAudio.audioListenerWillBeDestroyed", AudioListenerWillBeDestroyedEvent.serializer())

    /**
     *  Notifies that a new AudioNode has been created.
     */
    fun audioNodeCreated(): io.reactivex.rxjava3.core.Flowable<AudioNodeCreatedEvent> = connection.events("WebAudio.audioNodeCreated", AudioNodeCreatedEvent.serializer())

    /**
     *  Notifies that an existing AudioNode has been destroyed.
     */
    fun audioNodeWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<AudioNodeWillBeDestroyedEvent> = connection.events("WebAudio.audioNodeWillBeDestroyed", AudioNodeWillBeDestroyedEvent.serializer())

    /**
     *  Notifies that a new AudioParam has been created.
     */
    fun audioParamCreated(): io.reactivex.rxjava3.core.Flowable<AudioParamCreatedEvent> = connection.events("WebAudio.audioParamCreated", AudioParamCreatedEvent.serializer())

    /**
     *  Notifies that an existing AudioParam has been destroyed.
     */
    fun audioParamWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<AudioParamWillBeDestroyedEvent> = connection.events("WebAudio.audioParamWillBeDestroyed", AudioParamWillBeDestroyedEvent.serializer())

    /**
     *  Notifies that two AudioNodes are connected.
     */
    fun nodesConnected(): io.reactivex.rxjava3.core.Flowable<NodesConnectedEvent> = connection.events("WebAudio.nodesConnected", NodesConnectedEvent.serializer())

    /**
     *  Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
     */
    fun nodesDisconnected(): io.reactivex.rxjava3.core.Flowable<NodesDisconnectedEvent> = connection.events("WebAudio.nodesDisconnected", NodesDisconnectedEvent.serializer())

    /**
     *  Notifies that an AudioNode is connected to an AudioParam.
     */
    fun nodeParamConnected(): io.reactivex.rxjava3.core.Flowable<NodeParamConnectedEvent> = connection.events("WebAudio.nodeParamConnected", NodeParamConnectedEvent.serializer())

    /**
     *  Notifies that an AudioNode is disconnected to an AudioParam.
     */
    fun nodeParamDisconnected(): io.reactivex.rxjava3.core.Flowable<NodeParamDisconnectedEvent> = connection.events("WebAudio.nodeParamDisconnected", NodeParamDisconnectedEvent.serializer())
}

/**
 * Represents request frame that can be used with [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) operation call.
 *
 * Fetch the realtime data from the registered contexts.
 * @link [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) method documentation.
 * @see [WebAudioDomain.getRealtimeData]
 */
@kotlinx.serialization.Serializable
data class GetRealtimeDataRequest(
    /**
     *
     */
    val contextId: GraphObjectId

)

/**
 * Represents response frame that is returned from [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) operation call.
 * Fetch the realtime data from the registered contexts.
 *
  
 * @link [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) method documentation.
 * @see [WebAudioDomain.getRealtimeData]
 */
@kotlinx.serialization.Serializable
data class GetRealtimeDataResponse(
    /**  
     *  
     */  
    val realtimeData: ContextRealtimeData

)

/**
 * Notifies that a new BaseAudioContext has been created.
 *
 * @link [WebAudio#contextCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-contextCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class ContextCreatedEvent(
    /**  
     *  
     */  
    val context: BaseAudioContext

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "contextCreated"
} 

/**
 * Notifies that an existing BaseAudioContext will be destroyed.
 *
 * @link [WebAudio#contextWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-contextWillBeDestroyed) event documentation.
 */
@kotlinx.serialization.Serializable
data class ContextWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "contextWillBeDestroyed"
} 

/**
 * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
 *
 * @link [WebAudio#contextChanged](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-contextChanged) event documentation.
 */
@kotlinx.serialization.Serializable
data class ContextChangedEvent(
    /**  
     *  
     */  
    val context: BaseAudioContext

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "contextChanged"
} 

/**
 * Notifies that the construction of an AudioListener has finished.
 *
 * @link [WebAudio#audioListenerCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioListenerCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class AudioListenerCreatedEvent(
    /**  
     *  
     */  
    val listener: AudioListener

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "audioListenerCreated"
} 

/**
 * Notifies that a new AudioListener has been created.
 *
 * @link [WebAudio#audioListenerWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioListenerWillBeDestroyed) event documentation.
 */
@kotlinx.serialization.Serializable
data class AudioListenerWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val listenerId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "audioListenerWillBeDestroyed"
} 

/**
 * Notifies that a new AudioNode has been created.
 *
 * @link [WebAudio#audioNodeCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioNodeCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class AudioNodeCreatedEvent(
    /**  
     *  
     */  
    val node: AudioNode

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "audioNodeCreated"
} 

/**
 * Notifies that an existing AudioNode has been destroyed.
 *
 * @link [WebAudio#audioNodeWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioNodeWillBeDestroyed) event documentation.
 */
@kotlinx.serialization.Serializable
data class AudioNodeWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val nodeId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "audioNodeWillBeDestroyed"
} 

/**
 * Notifies that a new AudioParam has been created.
 *
 * @link [WebAudio#audioParamCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioParamCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class AudioParamCreatedEvent(
    /**  
     *  
     */  
    val param: AudioParam

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "audioParamCreated"
} 

/**
 * Notifies that an existing AudioParam has been destroyed.
 *
 * @link [WebAudio#audioParamWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioParamWillBeDestroyed) event documentation.
 */
@kotlinx.serialization.Serializable
data class AudioParamWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val nodeId: GraphObjectId,

    /**  
     *  
     */  
    val paramId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "audioParamWillBeDestroyed"
} 

/**
 * Notifies that two AudioNodes are connected.
 *
 * @link [WebAudio#nodesConnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodesConnected) event documentation.
 */
@kotlinx.serialization.Serializable
data class NodesConnectedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val sourceId: GraphObjectId,

    /**  
     *  
     */  
    val destinationId: GraphObjectId,

    /**  
     *  
     */  
    val sourceOutputIndex: Double? = null,

    /**  
     *  
     */  
    val destinationInputIndex: Double? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "nodesConnected"
} 

/**
 * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
 *
 * @link [WebAudio#nodesDisconnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodesDisconnected) event documentation.
 */
@kotlinx.serialization.Serializable
data class NodesDisconnectedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val sourceId: GraphObjectId,

    /**  
     *  
     */  
    val destinationId: GraphObjectId,

    /**  
     *  
     */  
    val sourceOutputIndex: Double? = null,

    /**  
     *  
     */  
    val destinationInputIndex: Double? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "nodesDisconnected"
} 

/**
 * Notifies that an AudioNode is connected to an AudioParam.
 *
 * @link [WebAudio#nodeParamConnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodeParamConnected) event documentation.
 */
@kotlinx.serialization.Serializable
data class NodeParamConnectedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val sourceId: GraphObjectId,

    /**  
     *  
     */  
    val destinationId: GraphObjectId,

    /**  
     *  
     */  
    val sourceOutputIndex: Double? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "nodeParamConnected"
} 

/**
 * Notifies that an AudioNode is disconnected to an AudioParam.
 *
 * @link [WebAudio#nodeParamDisconnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodeParamDisconnected) event documentation.
 */
@kotlinx.serialization.Serializable
data class NodeParamDisconnectedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val sourceId: GraphObjectId,

    /**  
     *  
     */  
    val destinationId: GraphObjectId,

    /**  
     *  
     */  
    val sourceOutputIndex: Double? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "WebAudio" 
    override fun eventName() = "nodeParamDisconnected"
} 
