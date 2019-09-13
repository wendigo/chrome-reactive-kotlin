package pl.wendigo.chrome.domain.webaudio

/**
 * This domain allows inspection of Web Audio API.
https://webaudio.github.io/web-audio-api/
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/WebAudio](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio)
 */
class WebAudio internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Enables the WebAudio domain and starts sending context lifetime events.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAudio.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables the WebAudio domain.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAudio.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Fetch the realtime data from the registered contexts.
     */
    fun getRealtimeData(input: GetRealtimeDataRequest): io.reactivex.Single<GetRealtimeDataResponse> {
        return connectionRemote.runAndCaptureResponse("WebAudio.getRealtimeData", input, GetRealtimeDataResponse::class.java).map {
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
        return connectionRemote.captureEvents("WebAudio.contextCreated", ContextCreatedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.contextWillBeDestroyed", ContextWillBeDestroyedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.contextChanged", ContextChangedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.audioListenerCreated", AudioListenerCreatedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.audioListenerWillBeDestroyed", AudioListenerWillBeDestroyedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.audioNodeCreated", AudioNodeCreatedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.audioNodeWillBeDestroyed", AudioNodeWillBeDestroyedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.audioParamCreated", AudioParamCreatedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.audioParamWillBeDestroyed", AudioParamWillBeDestroyedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.nodesConnected", NodesConnectedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.nodesDisconnected", NodesDisconnectedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.nodeParamConnected", NodeParamConnectedEvent::class.java)
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
        return connectionRemote.captureEvents("WebAudio.nodeParamDisconnected", NodeParamDisconnectedEvent::class.java)
    }

    /**
     * Returns flowable capturing all WebAudio domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "WebAudio"
        }
    }
}

/**
 * Represents request frame that can be used with WebAudio.getRealtimeData method call.
 *
 * Fetch the realtime data from the registered contexts.
 */
data class GetRealtimeDataRequest(
    /**
     *
     */
    val contextId: GraphObjectId

)

/**
 * Represents response frame for WebAudio.getRealtimeData method call.
 *
 * Fetch the realtime data from the registered contexts.
 */
data class GetRealtimeDataResponse(
    /**  
     *  
     */  
    val realtimeData: ContextRealtimeData

)

/**
 * Represents event frames for WebAudio.contextCreated
 *
 * Notifies that a new BaseAudioContext has been created.
 */
data class ContextCreatedEvent(
    /**  
     *  
     */  
    val context: BaseAudioContext

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "contextCreated")

/**
 * Represents event frames for WebAudio.contextWillBeDestroyed
 *
 * Notifies that an existing BaseAudioContext will be destroyed.
 */
data class ContextWillBeDestroyedEvent(
    /**  
     *  
     */  
    val contextId: GraphObjectId

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "contextWillBeDestroyed")

/**
 * Represents event frames for WebAudio.contextChanged
 *
 * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
 */
data class ContextChangedEvent(
    /**  
     *  
     */  
    val context: BaseAudioContext

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "contextChanged")

/**
 * Represents event frames for WebAudio.audioListenerCreated
 *
 * Notifies that the construction of an AudioListener has finished.
 */
data class AudioListenerCreatedEvent(
    /**  
     *  
     */  
    val listener: AudioListener

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "audioListenerCreated")

/**
 * Represents event frames for WebAudio.audioListenerWillBeDestroyed
 *
 * Notifies that a new AudioListener has been created.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "audioListenerWillBeDestroyed")

/**
 * Represents event frames for WebAudio.audioNodeCreated
 *
 * Notifies that a new AudioNode has been created.
 */
data class AudioNodeCreatedEvent(
    /**  
     *  
     */  
    val node: AudioNode

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "audioNodeCreated")

/**
 * Represents event frames for WebAudio.audioNodeWillBeDestroyed
 *
 * Notifies that an existing AudioNode has been destroyed.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "audioNodeWillBeDestroyed")

/**
 * Represents event frames for WebAudio.audioParamCreated
 *
 * Notifies that a new AudioParam has been created.
 */
data class AudioParamCreatedEvent(
    /**  
     *  
     */  
    val param: AudioParam

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "audioParamCreated")

/**
 * Represents event frames for WebAudio.audioParamWillBeDestroyed
 *
 * Notifies that an existing AudioParam has been destroyed.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "audioParamWillBeDestroyed")

/**
 * Represents event frames for WebAudio.nodesConnected
 *
 * Notifies that two AudioNodes are connected.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "nodesConnected")

/**
 * Represents event frames for WebAudio.nodesDisconnected
 *
 * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "nodesDisconnected")

/**
 * Represents event frames for WebAudio.nodeParamConnected
 *
 * Notifies that an AudioNode is connected to an AudioParam.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "nodeParamConnected")

/**
 * Represents event frames for WebAudio.nodeParamDisconnected
 *
 * Notifies that an AudioNode is disconnected to an AudioParam.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "WebAudio", name = "nodeParamDisconnected")
