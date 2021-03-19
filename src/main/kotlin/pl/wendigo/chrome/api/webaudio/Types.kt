package pl.wendigo.chrome.api.webaudio

/**
 * An unique ID for a graph object (AudioContext, AudioNode, AudioParam) in Web Audio API
 *
 * @link [WebAudio#GraphObjectId](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-GraphObjectId) type documentation.
 */

typealias GraphObjectId = String

/**
 * Enum of BaseAudioContext types
 *
 * @link [WebAudio#ContextType](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ContextType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ContextType {
    @kotlinx.serialization.SerialName("realtime")
    REALTIME,

    @kotlinx.serialization.SerialName("offline")
    OFFLINE;
}

/**
 * Enum of AudioContextState from the spec
 *
 * @link [WebAudio#ContextState](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ContextState) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ContextState {
    @kotlinx.serialization.SerialName("suspended")
    SUSPENDED,

    @kotlinx.serialization.SerialName("running")
    RUNNING,

    @kotlinx.serialization.SerialName("closed")
    CLOSED;
}

/**
 * Enum of AudioNode types
 *
 * @link [WebAudio#NodeType](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-NodeType) type documentation.
 */

typealias NodeType = String

/**
 * Enum of AudioNode::ChannelCountMode from the spec
 *
 * @link [WebAudio#ChannelCountMode](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ChannelCountMode) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ChannelCountMode {
    @kotlinx.serialization.SerialName("clamped-max")
    CLAMPED_MAX,

    @kotlinx.serialization.SerialName("explicit")
    EXPLICIT,

    @kotlinx.serialization.SerialName("max")
    MAX;
}

/**
 * Enum of AudioNode::ChannelInterpretation from the spec
 *
 * @link [WebAudio#ChannelInterpretation](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ChannelInterpretation) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ChannelInterpretation {
    @kotlinx.serialization.SerialName("discrete")
    DISCRETE,

    @kotlinx.serialization.SerialName("speakers")
    SPEAKERS;
}

/**
 * Enum of AudioParam types
 *
 * @link [WebAudio#ParamType](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ParamType) type documentation.
 */

typealias ParamType = String

/**
 * Enum of AudioParam::AutomationRate from the spec
 *
 * @link [WebAudio#AutomationRate](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AutomationRate) type documentation.
 */
@kotlinx.serialization.Serializable
enum class AutomationRate {
    @kotlinx.serialization.SerialName("a-rate")
    A_RATE,

    @kotlinx.serialization.SerialName("k-rate")
    K_RATE;
}

/**
 * Fields in AudioContext that change in real-time.
 *
 * @link [WebAudio#ContextRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ContextRealtimeData) type documentation.
 */

@kotlinx.serialization.Serializable
data class ContextRealtimeData(
    /**  
     * The current context time in second in BaseAudioContext.  
     */  
    val currentTime: Double,

    /**  
     * The time spent on rendering graph divided by render qunatum duration,  
     and multiplied by 100. 100 means the audio renderer reached the full  
     capacity and glitch may occur.  
     */  
    val renderCapacity: Double,

    /**  
     * A running mean of callback interval.  
     */  
    val callbackIntervalMean: Double,

    /**  
     * A running variance of callback interval.  
     */  
    val callbackIntervalVariance: Double
)

/**
 * Protocol object for BaseAudioContext
 *
 * @link [WebAudio#BaseAudioContext](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-BaseAudioContext) type documentation.
 */

@kotlinx.serialization.Serializable
data class BaseAudioContext(
    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val contextType: ContextType,

    /**  
     *  
     */  
    val contextState: ContextState,

    /**  
     *  
     */  
    val realtimeData: ContextRealtimeData? = null,

    /**  
     * Platform-dependent callback buffer size.  
     */  
    val callbackBufferSize: Double,

    /**  
     * Number of output channels supported by audio hardware in use.  
     */  
    val maxOutputChannelCount: Double,

    /**  
     * Context sample rate.  
     */  
    val sampleRate: Double
)

/**
 * Protocol object for AudioListener
 *
 * @link [WebAudio#AudioListener](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AudioListener) type documentation.
 */

@kotlinx.serialization.Serializable
data class AudioListener(
    /**  
     *  
     */  
    val listenerId: GraphObjectId,

    /**  
     *  
     */  
    val contextId: GraphObjectId
)

/**
 * Protocol object for AudioNode
 *
 * @link [WebAudio#AudioNode](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AudioNode) type documentation.
 */

@kotlinx.serialization.Serializable
data class AudioNode(
    /**  
     *  
     */  
    val nodeId: GraphObjectId,

    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val nodeType: NodeType,

    /**  
     *  
     */  
    val numberOfInputs: Double,

    /**  
     *  
     */  
    val numberOfOutputs: Double,

    /**  
     *  
     */  
    val channelCount: Double,

    /**  
     *  
     */  
    val channelCountMode: ChannelCountMode,

    /**  
     *  
     */  
    val channelInterpretation: ChannelInterpretation
)

/**
 * Protocol object for AudioParam
 *
 * @link [WebAudio#AudioParam](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AudioParam) type documentation.
 */

@kotlinx.serialization.Serializable
data class AudioParam(
    /**  
     *  
     */  
    val paramId: GraphObjectId,

    /**  
     *  
     */  
    val nodeId: GraphObjectId,

    /**  
     *  
     */  
    val contextId: GraphObjectId,

    /**  
     *  
     */  
    val paramType: ParamType,

    /**  
     *  
     */  
    val rate: AutomationRate,

    /**  
     *  
     */  
    val defaultValue: Double,

    /**  
     *  
     */  
    val minValue: Double,

    /**  
     *  
     */  
    val maxValue: Double
)
