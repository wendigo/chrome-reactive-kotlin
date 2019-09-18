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
enum class ContextType {
    @com.fasterxml.jackson.annotation.JsonProperty("realtime") REALTIME,
    @com.fasterxml.jackson.annotation.JsonProperty("offline") OFFLINE;
}

/**
 * Enum of AudioContextState from the spec
 *
 * @link [WebAudio#ContextState](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ContextState) type documentation.
 */
enum class ContextState {
    @com.fasterxml.jackson.annotation.JsonProperty("suspended") SUSPENDED,
    @com.fasterxml.jackson.annotation.JsonProperty("running") RUNNING,
    @com.fasterxml.jackson.annotation.JsonProperty("closed") CLOSED;
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
enum class ChannelCountMode {
    @com.fasterxml.jackson.annotation.JsonProperty("clamped-max") CLAMPED_MAX,
    @com.fasterxml.jackson.annotation.JsonProperty("explicit") EXPLICIT,
    @com.fasterxml.jackson.annotation.JsonProperty("max") MAX;
}

/**
 * Enum of AudioNode::ChannelInterpretation from the spec
 *
 * @link [WebAudio#ChannelInterpretation](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ChannelInterpretation) type documentation.
 */
enum class ChannelInterpretation {
    @com.fasterxml.jackson.annotation.JsonProperty("discrete") DISCRETE,
    @com.fasterxml.jackson.annotation.JsonProperty("speakers") SPEAKERS;
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
enum class AutomationRate {
    @com.fasterxml.jackson.annotation.JsonProperty("a-rate") A_RATE,
    @com.fasterxml.jackson.annotation.JsonProperty("k-rate") K_RATE;
}

/**
 * Fields in AudioContext that change in real-time.
 *
 * @link [WebAudio#ContextRealtimeData](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-ContextRealtimeData) type documentation.
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
 *
 * @link [WebAudio#BaseAudioContext](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-BaseAudioContext) type documentation.
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
 *
 * @link [WebAudio#AudioListener](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AudioListener) type documentation.
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
 *
 * @link [WebAudio#AudioNode](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AudioNode) type documentation.
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
 *
 * @link [WebAudio#AudioParam](https://chromedevtools.github.io/devtools-protocol/tot/WebAudio#type-AudioParam) type documentation.
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

