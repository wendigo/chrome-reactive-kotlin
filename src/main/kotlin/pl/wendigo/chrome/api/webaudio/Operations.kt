package pl.wendigo.chrome.api.webaudio

/**
 * This domain allows inspection of Web Audio API.
https://webaudio.github.io/web-audio-api/
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [WebAudio](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class WebAudioOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Enables the WebAudio domain and starts sending context lifetime events.
     *
     * @link Protocol [WebAudio#enable](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-enable) method documentation.
     */
    fun enable() = connection.request("WebAudio.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disables the WebAudio domain.
     *
     * @link Protocol [WebAudio#disable](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-disable) method documentation.
     */
    fun disable() = connection.request("WebAudio.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Fetch the realtime data from the registered contexts.
     *
     * @link Protocol [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) method documentation.
     */
    fun getRealtimeData(input: GetRealtimeDataRequest) = connection.request("WebAudio.getRealtimeData", input, GetRealtimeDataResponse::class.java)

    /**
     *  Notifies that a new BaseAudioContext has been created.
     */
    fun contextCreated(): io.reactivex.rxjava3.core.Flowable<ContextCreatedEvent> = connection.events("WebAudio.contextCreated", ContextCreatedEvent::class.java)

    /**
     *  Notifies that an existing BaseAudioContext will be destroyed.
     */
    fun contextWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<ContextWillBeDestroyedEvent> = connection.events("WebAudio.contextWillBeDestroyed", ContextWillBeDestroyedEvent::class.java)

    /**
     *  Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
     */
    fun contextChanged(): io.reactivex.rxjava3.core.Flowable<ContextChangedEvent> = connection.events("WebAudio.contextChanged", ContextChangedEvent::class.java)

    /**
     *  Notifies that the construction of an AudioListener has finished.
     */
    fun audioListenerCreated(): io.reactivex.rxjava3.core.Flowable<AudioListenerCreatedEvent> = connection.events("WebAudio.audioListenerCreated", AudioListenerCreatedEvent::class.java)

    /**
     *  Notifies that a new AudioListener has been created.
     */
    fun audioListenerWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<AudioListenerWillBeDestroyedEvent> = connection.events("WebAudio.audioListenerWillBeDestroyed", AudioListenerWillBeDestroyedEvent::class.java)

    /**
     *  Notifies that a new AudioNode has been created.
     */
    fun audioNodeCreated(): io.reactivex.rxjava3.core.Flowable<AudioNodeCreatedEvent> = connection.events("WebAudio.audioNodeCreated", AudioNodeCreatedEvent::class.java)

    /**
     *  Notifies that an existing AudioNode has been destroyed.
     */
    fun audioNodeWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<AudioNodeWillBeDestroyedEvent> = connection.events("WebAudio.audioNodeWillBeDestroyed", AudioNodeWillBeDestroyedEvent::class.java)

    /**
     *  Notifies that a new AudioParam has been created.
     */
    fun audioParamCreated(): io.reactivex.rxjava3.core.Flowable<AudioParamCreatedEvent> = connection.events("WebAudio.audioParamCreated", AudioParamCreatedEvent::class.java)

    /**
     *  Notifies that an existing AudioParam has been destroyed.
     */
    fun audioParamWillBeDestroyed(): io.reactivex.rxjava3.core.Flowable<AudioParamWillBeDestroyedEvent> = connection.events("WebAudio.audioParamWillBeDestroyed", AudioParamWillBeDestroyedEvent::class.java)

    /**
     *  Notifies that two AudioNodes are connected.
     */
    fun nodesConnected(): io.reactivex.rxjava3.core.Flowable<NodesConnectedEvent> = connection.events("WebAudio.nodesConnected", NodesConnectedEvent::class.java)

    /**
     *  Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
     */
    fun nodesDisconnected(): io.reactivex.rxjava3.core.Flowable<NodesDisconnectedEvent> = connection.events("WebAudio.nodesDisconnected", NodesDisconnectedEvent::class.java)

    /**
     *  Notifies that an AudioNode is connected to an AudioParam.
     */
    fun nodeParamConnected(): io.reactivex.rxjava3.core.Flowable<NodeParamConnectedEvent> = connection.events("WebAudio.nodeParamConnected", NodeParamConnectedEvent::class.java)

    /**
     *  Notifies that an AudioNode is disconnected to an AudioParam.
     */
    fun nodeParamDisconnected(): io.reactivex.rxjava3.core.Flowable<NodeParamDisconnectedEvent> = connection.events("WebAudio.nodeParamDisconnected", NodeParamDisconnectedEvent::class.java)

    /**
     * Returns flowable capturing all WebAudio domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "WebAudio"
        }
    }
}

/**
 * Represents request frame that can be used with [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) operation call.
 *
 * Fetch the realtime data from the registered contexts.
 * @link [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) method documentation.
 * @see [WebAudioOperations.getRealtimeData]
 */
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
 * @see [WebAudioOperations.getRealtimeData]
 */
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
data class ContextCreatedEvent(
    /**  
     *  
     */  
    val context: BaseAudioContext

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "contextCreated")

/**
 * Notifies that an existing BaseAudioContext will be destroyed.
 *
 * @link [WebAudio#contextWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-contextWillBeDestroyed) event documentation.
 */
data class ContextWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "contextWillBeDestroyed")

/**
 * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
 *
 * @link [WebAudio#contextChanged](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-contextChanged) event documentation.
 */
data class ContextChangedEvent(
    /**  
     *  
     */  
    val context: BaseAudioContext

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "contextChanged")

/**
 * Notifies that the construction of an AudioListener has finished.
 *
 * @link [WebAudio#audioListenerCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioListenerCreated) event documentation.
 */
data class AudioListenerCreatedEvent(
    /**  
     *  
     */  
    val listener: AudioListener

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "audioListenerCreated")

/**
 * Notifies that a new AudioListener has been created.
 *
 * @link [WebAudio#audioListenerWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioListenerWillBeDestroyed) event documentation.
 */
data class AudioListenerWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val listenerId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "audioListenerWillBeDestroyed")

/**
 * Notifies that a new AudioNode has been created.
 *
 * @link [WebAudio#audioNodeCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioNodeCreated) event documentation.
 */
data class AudioNodeCreatedEvent(
    /**  
     *  
     */  
    val node: AudioNode

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "audioNodeCreated")

/**
 * Notifies that an existing AudioNode has been destroyed.
 *
 * @link [WebAudio#audioNodeWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioNodeWillBeDestroyed) event documentation.
 */
data class AudioNodeWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val nodeId: GraphObjectId

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "audioNodeWillBeDestroyed")

/**
 * Notifies that a new AudioParam has been created.
 *
 * @link [WebAudio#audioParamCreated](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioParamCreated) event documentation.
 */
data class AudioParamCreatedEvent(
    /**  
     *  
     */  
    val param: AudioParam

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "audioParamCreated")

/**
 * Notifies that an existing AudioParam has been destroyed.
 *
 * @link [WebAudio#audioParamWillBeDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-audioParamWillBeDestroyed) event documentation.
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "audioParamWillBeDestroyed")

/**
 * Notifies that two AudioNodes are connected.
 *
 * @link [WebAudio#nodesConnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodesConnected) event documentation.
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "nodesConnected")

/**
 * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
 *
 * @link [WebAudio#nodesDisconnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodesDisconnected) event documentation.
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "nodesDisconnected")

/**
 * Notifies that an AudioNode is connected to an AudioParam.
 *
 * @link [WebAudio#nodeParamConnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodeParamConnected) event documentation.
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "nodeParamConnected")

/**
 * Notifies that an AudioNode is disconnected to an AudioParam.
 *
 * @link [WebAudio#nodeParamDisconnected](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#event-nodeParamDisconnected) event documentation.
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "WebAudio", name = "nodeParamDisconnected")
