package pl.wendigo.chrome.domain.animation

/**
 * Animation instance.
 */

data class Animation(
  /**
   * <code>Animation</code>'s id.
   */
  val id : String,

  /**
   * <code>Animation</code>'s name.
   */
  val name : String,

  /**
   * <code>Animation</code>'s internal paused state.
   */
  @pl.wendigo.chrome.ProtocolExperimental val pausedState : Boolean,

  /**
   * <code>Animation</code>'s play state.
   */
  val playState : String,

  /**
   * <code>Animation</code>'s playback rate.
   */
  val playbackRate : Double,

  /**
   * <code>Animation</code>'s start time.
   */
  val startTime : Double,

  /**
   * <code>Animation</code>'s current time.
   */
  val currentTime : Double,

  /**
   * <code>Animation</code>'s source animation node.
   */
  val source : AnimationEffect,

  /**
   * Animation type of <code>Animation</code>.
   */
  val type : String,

  /**
   * A unique ID for <code>Animation</code> representing the sources that triggered this CSS animation/transition.
   */
  val cssId : String? = null
)

/**
 * AnimationEffect instance
 */

data class AnimationEffect(
  /**
   * <code>AnimationEffect</code>'s delay.
   */
  val delay : Double,

  /**
   * <code>AnimationEffect</code>'s end delay.
   */
  val endDelay : Double,

  /**
   * <code>AnimationEffect</code>'s iteration start.
   */
  val iterationStart : Double,

  /**
   * <code>AnimationEffect</code>'s iterations.
   */
  val iterations : Double,

  /**
   * <code>AnimationEffect</code>'s iteration duration.
   */
  val duration : Double,

  /**
   * <code>AnimationEffect</code>'s playback direction.
   */
  val direction : String,

  /**
   * <code>AnimationEffect</code>'s fill mode.
   */
  val fill : String,

  /**
   * <code>AnimationEffect</code>'s target node.
   */
  val backendNodeId : pl.wendigo.chrome.domain.dom.BackendNodeId,

  /**
   * <code>AnimationEffect</code>'s keyframes.
   */
  val keyframesRule : KeyframesRule? = null,

  /**
   * <code>AnimationEffect</code>'s timing function.
   */
  val easing : String
)

/**
 * Keyframes Rule
 */

data class KeyframesRule(
  /**
   * CSS keyframed animation's name.
   */
  val name : String? = null,

  /**
   * List of animation keyframes.
   */
  val keyframes : Array<KeyframeStyle>
)

/**
 * Keyframe Style
 */

data class KeyframeStyle(
  /**
   * Keyframe's time offset.
   */
  val offset : String,

  /**
   * <code>AnimationEffect</code>'s timing function.
   */
  val easing : String
)

