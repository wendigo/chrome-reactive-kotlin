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
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("WebAudio.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables the WebAudio domain.
     *
     * @link Protocol [WebAudio#disable](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("WebAudio.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Fetch the realtime data from the registered contexts.
     *
     * @link Protocol [WebAudio#getRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#method-getRealtimeData) method documentation.
     */
    fun getRealtimeData(input: GetRealtimeDataRequest): io.reactivex.Single<GetRealtimeDataResponse> {
        return connection.runAndCaptureResponse("WebAudio.getRealtimeData", input, GetRealtimeDataResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Notifies that a new BaseAudioContext has been created.
     */
    fun contextCreated(): io.reactivex.Flowable<ContextCreatedEvent> {
        return contextCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that a new BaseAudioContext has been created.
     */
    fun contextCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ContextCreatedEvent>> {
        return connection.captureEvents("WebAudio.contextCreated", ContextCreatedEvent::class.java)
    }

    /**
     *  Notifies that an existing BaseAudioContext will be destroyed.
     */
    fun contextWillBeDestroyed(): io.reactivex.Flowable<ContextWillBeDestroyedEvent> {
        return contextWillBeDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that an existing BaseAudioContext will be destroyed.
     */
    fun contextWillBeDestroyedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ContextWillBeDestroyedEvent>> {
        return connection.captureEvents("WebAudio.contextWillBeDestroyed", ContextWillBeDestroyedEvent::class.java)
    }

    /**
     *  Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
     */
    fun contextChanged(): io.reactivex.Flowable<ContextChangedEvent> {
        return contextChangedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
     */
    fun contextChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ContextChangedEvent>> {
        return connection.captureEvents("WebAudio.contextChanged", ContextChangedEvent::class.java)
    }

    /**
     *  Notifies that the construction of an AudioListener has finished.
     */
    fun audioListenerCreated(): io.reactivex.Flowable<AudioListenerCreatedEvent> {
        return audioListenerCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that the construction of an AudioListener has finished.
     */
    fun audioListenerCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AudioListenerCreatedEvent>> {
        return connection.captureEvents("WebAudio.audioListenerCreated", AudioListenerCreatedEvent::class.java)
    }

    /**
     *  Notifies that a new AudioListener has been created.
     */
    fun audioListenerWillBeDestroyed(): io.reactivex.Flowable<AudioListenerWillBeDestroyedEvent> {
        return audioListenerWillBeDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that a new AudioListener has been created.
     */
    fun audioListenerWillBeDestroyedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AudioListenerWillBeDestroyedEvent>> {
        return connection.captureEvents("WebAudio.audioListenerWillBeDestroyed", AudioListenerWillBeDestroyedEvent::class.java)
    }

    /**
     *  Notifies that a new AudioNode has been created.
     */
    fun audioNodeCreated(): io.reactivex.Flowable<AudioNodeCreatedEvent> {
        return audioNodeCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that a new AudioNode has been created.
     */
    fun audioNodeCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AudioNodeCreatedEvent>> {
        return connection.captureEvents("WebAudio.audioNodeCreated", AudioNodeCreatedEvent::class.java)
    }

    /**
     *  Notifies that an existing AudioNode has been destroyed.
     */
    fun audioNodeWillBeDestroyed(): io.reactivex.Flowable<AudioNodeWillBeDestroyedEvent> {
        return audioNodeWillBeDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that an existing AudioNode has been destroyed.
     */
    fun audioNodeWillBeDestroyedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AudioNodeWillBeDestroyedEvent>> {
        return connection.captureEvents("WebAudio.audioNodeWillBeDestroyed", AudioNodeWillBeDestroyedEvent::class.java)
    }

    /**
     *  Notifies that a new AudioParam has been created.
     */
    fun audioParamCreated(): io.reactivex.Flowable<AudioParamCreatedEvent> {
        return audioParamCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that a new AudioParam has been created.
     */
    fun audioParamCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AudioParamCreatedEvent>> {
        return connection.captureEvents("WebAudio.audioParamCreated", AudioParamCreatedEvent::class.java)
    }

    /**
     *  Notifies that an existing AudioParam has been destroyed.
     */
    fun audioParamWillBeDestroyed(): io.reactivex.Flowable<AudioParamWillBeDestroyedEvent> {
        return audioParamWillBeDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that an existing AudioParam has been destroyed.
     */
    fun audioParamWillBeDestroyedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AudioParamWillBeDestroyedEvent>> {
        return connection.captureEvents("WebAudio.audioParamWillBeDestroyed", AudioParamWillBeDestroyedEvent::class.java)
    }

    /**
     *  Notifies that two AudioNodes are connected.
     */
    fun nodesConnected(): io.reactivex.Flowable<NodesConnectedEvent> {
        return nodesConnectedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that two AudioNodes are connected.
     */
    fun nodesConnectedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NodesConnectedEvent>> {
        return connection.captureEvents("WebAudio.nodesConnected", NodesConnectedEvent::class.java)
    }

    /**
     *  Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
     */
    fun nodesDisconnected(): io.reactivex.Flowable<NodesDisconnectedEvent> {
        return nodesDisconnectedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
     */
    fun nodesDisconnectedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NodesDisconnectedEvent>> {
        return connection.captureEvents("WebAudio.nodesDisconnected", NodesDisconnectedEvent::class.java)
    }

    /**
     *  Notifies that an AudioNode is connected to an AudioParam.
     */
    fun nodeParamConnected(): io.reactivex.Flowable<NodeParamConnectedEvent> {
        return nodeParamConnectedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that an AudioNode is connected to an AudioParam.
     */
    fun nodeParamConnectedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NodeParamConnectedEvent>> {
        return connection.captureEvents("WebAudio.nodeParamConnected", NodeParamConnectedEvent::class.java)
    }

    /**
     *  Notifies that an AudioNode is disconnected to an AudioParam.
     */
    fun nodeParamDisconnected(): io.reactivex.Flowable<NodeParamDisconnectedEvent> {
        return nodeParamDisconnectedTimed().map {
            it.value()
        }
    }

    /**
     * Notifies that an AudioNode is disconnected to an AudioParam.
     */
    fun nodeParamDisconnectedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NodeParamDisconnectedEvent>> {
        return connection.captureEvents("WebAudio.nodeParamDisconnected", NodeParamDisconnectedEvent::class.java)
    }

    /**
     * Returns flowable capturing all WebAudio domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
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
