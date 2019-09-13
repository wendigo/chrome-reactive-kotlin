package pl.wendigo.chrome.api.animation

/**
 * Animation instance.
 *
 * @link [Animation#Animation](https://chromedevtools.github.io/devtools-protocol/tot/Animation#type-Animation) type documentation.
 */

data class Animation(
    /**  
     * `Animation`'s id.  
     */  
    val id: String,

    /**  
     * `Animation`'s name.  
     */  
    val name: String,

    /**  
     * `Animation`'s internal paused state.  
     */  
    val pausedState: Boolean,

    /**  
     * `Animation`'s play state.  
     */  
    val playState: String,

    /**  
     * `Animation`'s playback rate.  
     */  
    val playbackRate: Double,

    /**  
     * `Animation`'s start time.  
     */  
    val startTime: Double,

    /**  
     * `Animation`'s current time.  
     */  
    val currentTime: Double,

    /**  
     * Animation type of `Animation`.  
     */  
    val type: String,

    /**  
     * `Animation`'s source animation node.  
     */  
    val source: AnimationEffect? = null,

    /**  
     * A unique ID for `Animation` representing the sources that triggered this CSS  
     animation/transition.  
     */  
    val cssId: String? = null
)

/**
 * AnimationEffect instance
 *
 * @link [Animation#AnimationEffect](https://chromedevtools.github.io/devtools-protocol/tot/Animation#type-AnimationEffect) type documentation.
 */

data class AnimationEffect(
    /**  
     * `AnimationEffect`'s delay.  
     */  
    val delay: Double,

    /**  
     * `AnimationEffect`'s end delay.  
     */  
    val endDelay: Double,

    /**  
     * `AnimationEffect`'s iteration start.  
     */  
    val iterationStart: Double,

    /**  
     * `AnimationEffect`'s iterations.  
     */  
    val iterations: Double,

    /**  
     * `AnimationEffect`'s iteration duration.  
     */  
    val duration: Double,

    /**  
     * `AnimationEffect`'s playback direction.  
     */  
    val direction: String,

    /**  
     * `AnimationEffect`'s fill mode.  
     */  
    val fill: String,

    /**  
     * `AnimationEffect`'s target node.  
     */  
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

    /**  
     * `AnimationEffect`'s keyframes.  
     */  
    val keyframesRule: KeyframesRule? = null,

    /**  
     * `AnimationEffect`'s timing function.  
     */  
    val easing: String
)

/**
 * Keyframes Rule
 *
 * @link [Animation#KeyframesRule](https://chromedevtools.github.io/devtools-protocol/tot/Animation#type-KeyframesRule) type documentation.
 */

data class KeyframesRule(
    /**  
     * CSS keyframed animation's name.  
     */  
    val name: String? = null,

    /**  
     * List of animation keyframes.  
     */  
    val keyframes: List<KeyframeStyle>
)

/**
 * Keyframe Style
 *
 * @link [Animation#KeyframeStyle](https://chromedevtools.github.io/devtools-protocol/tot/Animation#type-KeyframeStyle) type documentation.
 */

data class KeyframeStyle(
    /**  
     * Keyframe's time offset.  
     */  
    val offset: String,

    /**  
     * `AnimationEffect`'s timing function.  
     */  
    val easing: String
)
