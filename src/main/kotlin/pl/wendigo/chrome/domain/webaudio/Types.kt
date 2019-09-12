package pl.wendigo.chrome.domain.webaudio

/**
 * An unique ID for a graph object (AudioContext, AudioNode, AudioParam) in Web Audio API
 */

typealias GraphObjectId = String

/**
 * Enum of BaseAudioContext types
 */
enum class ContextType {
    @com.fasterxml.jackson.annotation.JsonProperty("realtime") REALTIME,
    @com.fasterxml.jackson.annotation.JsonProperty("offline") OFFLINE;
}

/**
 * Enum of AudioContextState from the spec
 */
enum class ContextState {
    @com.fasterxml.jackson.annotation.JsonProperty("suspended") SUSPENDED,
    @com.fasterxml.jackson.annotation.JsonProperty("running") RUNNING,
    @com.fasterxml.jackson.annotation.JsonProperty("closed") CLOSED;
}

/**
 * Enum of AudioNode types
 */

typealias NodeType = String

/**
 * Enum of AudioNode::ChannelCountMode from the spec
 */
enum class ChannelCountMode {
    @com.fasterxml.jackson.annotation.JsonProperty("clamped-max") CLAMPED_MAX,
    @com.fasterxml.jackson.annotation.JsonProperty("explicit") EXPLICIT,
    @com.fasterxml.jackson.annotation.JsonProperty("max") MAX;
}

/**
 * Enum of AudioNode::ChannelInterpretation from the spec
 */
enum class ChannelInterpretation {
    @com.fasterxml.jackson.annotation.JsonProperty("discrete") DISCRETE,
    @com.fasterxml.jackson.annotation.JsonProperty("speakers") SPEAKERS;
}

/**
 * Enum of AudioParam types
 */

typealias ParamType = String

/**
 * Enum of AudioParam::AutomationRate from the spec
 */
enum class AutomationRate {
    @com.fasterxml.jackson.annotation.JsonProperty("a-rate") A_RATE,
    @com.fasterxml.jackson.annotation.JsonProperty("k-rate") K_RATE;
}

/**
 * Fields in AudioContext that change in real-time.
 */

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
 */

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
 * Protocol object for AudioListner
 */

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
 */

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
 */

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
