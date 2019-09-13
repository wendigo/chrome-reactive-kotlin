package pl.wendigo.chrome.domain.animation

/**
 * Animation represents remote debugger protocol domain.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Animation](https://chromedevtools.github.io/devtools-protocol/tot/Animation)
 */
class Animation internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disables animation domain notifications.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables animation domain notifications.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the current time of the an animation.
     */
    fun getCurrentTime(input: GetCurrentTimeRequest): io.reactivex.Single<GetCurrentTimeResponse> {
        return connectionRemote.runAndCaptureResponse("Animation.getCurrentTime", input, GetCurrentTimeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Gets the playback rate of the document timeline.
     */
    fun getPlaybackRate(): io.reactivex.Single<GetPlaybackRateResponse> {
        return connectionRemote.runAndCaptureResponse("Animation.getPlaybackRate", null, GetPlaybackRateResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Releases a set of animations to no longer be manipulated.
     */
    fun releaseAnimations(input: ReleaseAnimationsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.releaseAnimations", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Gets the remote object of the Animation.
     */
    fun resolveAnimation(input: ResolveAnimationRequest): io.reactivex.Single<ResolveAnimationResponse> {
        return connectionRemote.runAndCaptureResponse("Animation.resolveAnimation", input, ResolveAnimationResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Seek a set of animations to a particular time within each animation.
     */
    fun seekAnimations(input: SeekAnimationsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.seekAnimations", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets the paused state of a set of animations.
     */
    fun setPaused(input: SetPausedRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.setPaused", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets the playback rate of the document timeline.
     */
    fun setPlaybackRate(input: SetPlaybackRateRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.setPlaybackRate", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets the timing of an animation node.
     */
    fun setTiming(input: SetTimingRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Animation.setTiming", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Event for when an animation has been cancelled.
     */
    fun animationCanceled(): io.reactivex.Flowable<AnimationCanceledEvent> {
        return animationCanceledTimed().map {
            it.value()
        }
    }

    /**
     * Event for when an animation has been cancelled.
     */
    fun animationCanceledTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AnimationCanceledEvent>> {
        return connectionRemote.captureEvents("Animation.animationCanceled", AnimationCanceledEvent::class.java)
    }

    /**
     *  Event for each animation that has been created.
     */
    fun animationCreated(): io.reactivex.Flowable<AnimationCreatedEvent> {
        return animationCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Event for each animation that has been created.
     */
    fun animationCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AnimationCreatedEvent>> {
        return connectionRemote.captureEvents("Animation.animationCreated", AnimationCreatedEvent::class.java)
    }

    /**
     *  Event for animation that has been started.
     */
    fun animationStarted(): io.reactivex.Flowable<AnimationStartedEvent> {
        return animationStartedTimed().map {
            it.value()
        }
    }

    /**
     * Event for animation that has been started.
     */
    fun animationStartedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AnimationStartedEvent>> {
        return connectionRemote.captureEvents("Animation.animationStarted", AnimationStartedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Animation domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Animation"
        }
    }
}

/**
 * Represents request frame that can be used with Animation.getCurrentTime method call.
 *
 * Returns the current time of the an animation.
 */
data class GetCurrentTimeRequest(
    /**
     * Id of animation.
     */
    val id: String

)

/**
 * Represents response frame for Animation.getCurrentTime method call.
 *
 * Returns the current time of the an animation.
 */
data class GetCurrentTimeResponse(
    /**  
     * Current time of the page.  
     */  
    val currentTime: Double

)

/**
 * Represents response frame for Animation.getPlaybackRate method call.
 *
 * Gets the playback rate of the document timeline.
 */
data class GetPlaybackRateResponse(
    /**  
     * Playback rate for animations on page.  
     */  
    val playbackRate: Double

)

/**
 * Represents request frame that can be used with Animation.releaseAnimations method call.
 *
 * Releases a set of animations to no longer be manipulated.
 */
data class ReleaseAnimationsRequest(
    /**
     * List of animation ids to seek.
     */
    val animations: List<String>

)

/**
 * Represents request frame that can be used with Animation.resolveAnimation method call.
 *
 * Gets the remote object of the Animation.
 */
data class ResolveAnimationRequest(
    /**
     * Animation id.
     */
    val animationId: String

)

/**
 * Represents response frame for Animation.resolveAnimation method call.
 *
 * Gets the remote object of the Animation.
 */
data class ResolveAnimationResponse(
    /**  
     * Corresponding remote object.  
     */  
    val remoteObject: pl.wendigo.chrome.domain.runtime.RemoteObject

)

/**
 * Represents request frame that can be used with Animation.seekAnimations method call.
 *
 * Seek a set of animations to a particular time within each animation.
 */
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
 * Represents request frame that can be used with Animation.setPaused method call.
 *
 * Sets the paused state of a set of animations.
 */
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
 * Represents request frame that can be used with Animation.setPlaybackRate method call.
 *
 * Sets the playback rate of the document timeline.
 */
data class SetPlaybackRateRequest(
    /**
     * Playback rate for animations on page
     */
    val playbackRate: Double

)

/**
 * Represents request frame that can be used with Animation.setTiming method call.
 *
 * Sets the timing of an animation node.
 */
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
 * Represents event frames for Animation.animationCanceled
 *
 * Event for when an animation has been cancelled.
 */
data class AnimationCanceledEvent(
    /**  
     * Id of the animation that was cancelled.  
     */  
    val id: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Animation", name = "animationCanceled")

/**
 * Represents event frames for Animation.animationCreated
 *
 * Event for each animation that has been created.
 */
data class AnimationCreatedEvent(
    /**  
     * Id of the animation that was created.  
     */  
    val id: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Animation", name = "animationCreated")

/**
 * Represents event frames for Animation.animationStarted
 *
 * Event for animation that has been started.
 */
data class AnimationStartedEvent(
    /**  
     * Animation that was started.  
     */  
    val animation: Animation

) : pl.wendigo.chrome.ProtocolEvent(domain = "Animation", name = "animationStarted")
