package pl.wendigo.chrome.api.animation

import kotlinx.serialization.json.Json

/**
 * AnimationDomain represents Animation protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Animation](https://chromedevtools.github.io/devtools-protocol/tot/Animation) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class AnimationDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("Animation", """""", connection) {
    /**
     * Disables animation domain notifications.
     *
     * @link Protocol [Animation#disable](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Enables animation domain notifications.
     *
     * @link Protocol [Animation#enable](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Returns the current time of the an animation.
     *
     * @link Protocol [Animation#getCurrentTime](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getCurrentTime) method documentation.
     */
    
    fun getCurrentTime(input: GetCurrentTimeRequest): io.reactivex.rxjava3.core.Single<GetCurrentTimeResponse> = connection.request("Animation.getCurrentTime", Json.encodeToJsonElement(GetCurrentTimeRequest.serializer(), input), GetCurrentTimeResponse.serializer())

    /**
     * Gets the playback rate of the document timeline.
     *
     * @link Protocol [Animation#getPlaybackRate](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getPlaybackRate) method documentation.
     */
    
    fun getPlaybackRate(): io.reactivex.rxjava3.core.Single<GetPlaybackRateResponse> = connection.request("Animation.getPlaybackRate", null, GetPlaybackRateResponse.serializer())

    /**
     * Releases a set of animations to no longer be manipulated.
     *
     * @link Protocol [Animation#releaseAnimations](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-releaseAnimations) method documentation.
     */
    
    fun releaseAnimations(input: ReleaseAnimationsRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.releaseAnimations", Json.encodeToJsonElement(ReleaseAnimationsRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Gets the remote object of the Animation.
     *
     * @link Protocol [Animation#resolveAnimation](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-resolveAnimation) method documentation.
     */
    
    fun resolveAnimation(input: ResolveAnimationRequest): io.reactivex.rxjava3.core.Single<ResolveAnimationResponse> = connection.request("Animation.resolveAnimation", Json.encodeToJsonElement(ResolveAnimationRequest.serializer(), input), ResolveAnimationResponse.serializer())

    /**
     * Seek a set of animations to a particular time within each animation.
     *
     * @link Protocol [Animation#seekAnimations](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-seekAnimations) method documentation.
     */
    
    fun seekAnimations(input: SeekAnimationsRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.seekAnimations", Json.encodeToJsonElement(SeekAnimationsRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Sets the paused state of a set of animations.
     *
     * @link Protocol [Animation#setPaused](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setPaused) method documentation.
     */
    
    fun setPaused(input: SetPausedRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.setPaused", Json.encodeToJsonElement(SetPausedRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Sets the playback rate of the document timeline.
     *
     * @link Protocol [Animation#setPlaybackRate](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setPlaybackRate) method documentation.
     */
    
    fun setPlaybackRate(input: SetPlaybackRateRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.setPlaybackRate", Json.encodeToJsonElement(SetPlaybackRateRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Sets the timing of an animation node.
     *
     * @link Protocol [Animation#setTiming](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setTiming) method documentation.
     */
    
    fun setTiming(input: SetTimingRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Animation.setTiming", Json.encodeToJsonElement(SetTimingRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     *  Event for when an animation has been cancelled.
     */
    fun animationCanceled(): io.reactivex.rxjava3.core.Flowable<AnimationCanceledEvent> = connection.events("Animation.animationCanceled", AnimationCanceledEvent.serializer())

    /**
     *  Event for each animation that has been created.
     */
    fun animationCreated(): io.reactivex.rxjava3.core.Flowable<AnimationCreatedEvent> = connection.events("Animation.animationCreated", AnimationCreatedEvent.serializer())

    /**
     *  Event for animation that has been started.
     */
    fun animationStarted(): io.reactivex.rxjava3.core.Flowable<AnimationStartedEvent> = connection.events("Animation.animationStarted", AnimationStartedEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.runtime.RuntimeDomain(connection),
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [Animation#getCurrentTime](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getCurrentTime) operation call.
 *
 * Returns the current time of the an animation.
 * @link [Animation#getCurrentTime](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getCurrentTime) method documentation.
 * @see [AnimationDomain.getCurrentTime]
 */
@kotlinx.serialization.Serializable
data class GetCurrentTimeRequest(
    /**
     * Id of animation.
     */
    val id: String

)

/**
 * Represents response frame that is returned from [Animation#getCurrentTime](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getCurrentTime) operation call.
 * Returns the current time of the an animation.
 *
  
 * @link [Animation#getCurrentTime](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getCurrentTime) method documentation.
 * @see [AnimationDomain.getCurrentTime]
 */
@kotlinx.serialization.Serializable
data class GetCurrentTimeResponse(
    /**  
     * Current time of the page.  
     */  
    val currentTime: Double

)

/**
 * Represents response frame that is returned from [Animation#getPlaybackRate](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getPlaybackRate) operation call.
 * Gets the playback rate of the document timeline.
 *
  
 * @link [Animation#getPlaybackRate](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-getPlaybackRate) method documentation.
 * @see [AnimationDomain.getPlaybackRate]
 */
@kotlinx.serialization.Serializable
data class GetPlaybackRateResponse(
    /**  
     * Playback rate for animations on page.  
     */  
    val playbackRate: Double

)

/**
 * Represents request frame that can be used with [Animation#releaseAnimations](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-releaseAnimations) operation call.
 *
 * Releases a set of animations to no longer be manipulated.
 * @link [Animation#releaseAnimations](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-releaseAnimations) method documentation.
 * @see [AnimationDomain.releaseAnimations]
 */
@kotlinx.serialization.Serializable
data class ReleaseAnimationsRequest(
    /**
     * List of animation ids to seek.
     */
    val animations: List<String>

)

/**
 * Represents request frame that can be used with [Animation#resolveAnimation](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-resolveAnimation) operation call.
 *
 * Gets the remote object of the Animation.
 * @link [Animation#resolveAnimation](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-resolveAnimation) method documentation.
 * @see [AnimationDomain.resolveAnimation]
 */
@kotlinx.serialization.Serializable
data class ResolveAnimationRequest(
    /**
     * Animation id.
     */
    val animationId: String

)

/**
 * Represents response frame that is returned from [Animation#resolveAnimation](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-resolveAnimation) operation call.
 * Gets the remote object of the Animation.
 *
  
 * @link [Animation#resolveAnimation](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-resolveAnimation) method documentation.
 * @see [AnimationDomain.resolveAnimation]
 */
@kotlinx.serialization.Serializable
data class ResolveAnimationResponse(
    /**  
     * Corresponding remote object.  
     */  
    val remoteObject: pl.wendigo.chrome.api.runtime.RemoteObject

)

/**
 * Represents request frame that can be used with [Animation#seekAnimations](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-seekAnimations) operation call.
 *
 * Seek a set of animations to a particular time within each animation.
 * @link [Animation#seekAnimations](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-seekAnimations) method documentation.
 * @see [AnimationDomain.seekAnimations]
 */
@kotlinx.serialization.Serializable
data class SeekAnimationsRequest(
    /**
     * List of animation ids to seek.
     */
    val animations: List<String>,

    /**
     * Set the current time of each animation.
     */
    val currentTime: Double

)

/**
 * Represents request frame that can be used with [Animation#setPaused](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setPaused) operation call.
 *
 * Sets the paused state of a set of animations.
 * @link [Animation#setPaused](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setPaused) method documentation.
 * @see [AnimationDomain.setPaused]
 */
@kotlinx.serialization.Serializable
data class SetPausedRequest(
    /**
     * Animations to set the pause state of.
     */
    val animations: List<String>,

    /**
     * Paused state to set to.
     */
    val paused: Boolean

)

/**
 * Represents request frame that can be used with [Animation#setPlaybackRate](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setPlaybackRate) operation call.
 *
 * Sets the playback rate of the document timeline.
 * @link [Animation#setPlaybackRate](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setPlaybackRate) method documentation.
 * @see [AnimationDomain.setPlaybackRate]
 */
@kotlinx.serialization.Serializable
data class SetPlaybackRateRequest(
    /**
     * Playback rate for animations on page
     */
    val playbackRate: Double

)

/**
 * Represents request frame that can be used with [Animation#setTiming](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setTiming) operation call.
 *
 * Sets the timing of an animation node.
 * @link [Animation#setTiming](https://chromedevtools.github.io/devtools-protocol/tot/Animation#method-setTiming) method documentation.
 * @see [AnimationDomain.setTiming]
 */
@kotlinx.serialization.Serializable
data class SetTimingRequest(
    /**
     * Animation id.
     */
    val animationId: String,

    /**
     * Duration of the animation.
     */
    val duration: Double,

    /**
     * Delay of the animation.
     */
    val delay: Double

)

/**
 * Event for when an animation has been cancelled.
 *
 * @link [Animation#animationCanceled](https://chromedevtools.github.io/devtools-protocol/tot/Animation#event-animationCanceled) event documentation.
 */
@kotlinx.serialization.Serializable
data class AnimationCanceledEvent(
    /**  
     * Id of the animation that was cancelled.  
     */  
    val id: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Animation" 
    override fun eventName() = "animationCanceled"
} 

/**
 * Event for each animation that has been created.
 *
 * @link [Animation#animationCreated](https://chromedevtools.github.io/devtools-protocol/tot/Animation#event-animationCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class AnimationCreatedEvent(
    /**  
     * Id of the animation that was created.  
     */  
    val id: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Animation" 
    override fun eventName() = "animationCreated"
} 

/**
 * Event for animation that has been started.
 *
 * @link [Animation#animationStarted](https://chromedevtools.github.io/devtools-protocol/tot/Animation#event-animationStarted) event documentation.
 */
@kotlinx.serialization.Serializable
data class AnimationStartedEvent(
    /**  
     * Animation that was started.  
     */  
    val animation: Animation

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Animation" 
    override fun eventName() = "animationStarted"
} 
