package pl.wendigo.chrome.domain.animation

/**
 * AnimationDomain represents remote debugger protocol domain.
 *
 * This class was autogenerated by main.go. Do not edit :)
 */
@pl.wendigo.chrome.ProtocolExperimental class AnimationDomain internal constructor(private val connection : pl.wendigo.chrome.RemoteChromeConnection) {

	/**
	 * Enables animation domain notifications.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables animation domain notifications.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Gets the playback rate of the document timeline.
	 */
	  fun getPlaybackRate() : io.reactivex.Flowable<GetPlaybackRateResponse> {
        return connection.runAndCaptureResponse("Animation.getPlaybackRate", null, GetPlaybackRateResponse::class.java)
	}

	/**
	 * Sets the playback rate of the document timeline.
	 */
	  fun setPlaybackRate(input : SetPlaybackRateRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.setPlaybackRate", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns the current time of the an animation.
	 */
	  fun getCurrentTime(input : GetCurrentTimeRequest) : io.reactivex.Flowable<GetCurrentTimeResponse> {
        return connection.runAndCaptureResponse("Animation.getCurrentTime", input, GetCurrentTimeResponse::class.java)
	}

	/**
	 * Sets the paused state of a set of animations.
	 */
	  fun setPaused(input : SetPausedRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.setPaused", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Sets the timing of an animation node.
	 */
	  fun setTiming(input : SetTimingRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.setTiming", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Seek a set of animations to a particular time within each animation.
	 */
	  fun seekAnimations(input : SeekAnimationsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.seekAnimations", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Releases a set of animations to no longer be manipulated.
	 */
	  fun releaseAnimations(input : ReleaseAnimationsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Animation.releaseAnimations", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Gets the remote object of the Animation.
	 */
	  fun resolveAnimation(input : ResolveAnimationRequest) : io.reactivex.Flowable<ResolveAnimationResponse> {
        return connection.runAndCaptureResponse("Animation.resolveAnimation", input, ResolveAnimationResponse::class.java)
	}

  
  /**
   * Event for each animation that has been created.
   */
   fun onAnimationCreated() : io.reactivex.Flowable<AnimationCreatedEvent> {
      return connection.captureEvents(AnimationCreatedEvent::class.java)
   }

  /**
   * Event for animation that has been started.
   */
   fun onAnimationStarted() : io.reactivex.Flowable<AnimationStartedEvent> {
      return connection.captureEvents(AnimationStartedEvent::class.java)
   }

  /**
   * Event for when an animation has been cancelled.
   */
   fun onAnimationCanceled() : io.reactivex.Flowable<AnimationCanceledEvent> {
      return connection.captureEvents(AnimationCanceledEvent::class.java)
   }
}






/**
 * Represents responseFrame from Animation. method call.
 *
 * Gets the playback rate of the document timeline.
 */
data class GetPlaybackRateResponse(
  /**
   * Playback rate for animations on page.
   */
  val playbackRate : Double

)

/**
 * Represents requestFrame parameters that can be used with Animation.setPlaybackRate method call.
 *
 * Sets the playback rate of the document timeline.
 */
data class SetPlaybackRateRequest (
    /**
     * Playback rate for animations on page
     */
    val playbackRate : Double

)


/**
 * Represents requestFrame parameters that can be used with Animation.getCurrentTime method call.
 *
 * Returns the current time of the an animation.
 */
data class GetCurrentTimeRequest (
    /**
     * Id of animation.
     */
    val id : String

)

/**
 * Represents responseFrame from Animation. method call.
 *
 * Returns the current time of the an animation.
 */
data class GetCurrentTimeResponse(
  /**
   * Current time of the page.
   */
  val currentTime : Double

)

/**
 * Represents requestFrame parameters that can be used with Animation.setPaused method call.
 *
 * Sets the paused state of a set of animations.
 */
data class SetPausedRequest (
    /**
     * Animations to set the pause state of.
     */
    val animations : Array<String>,

    /**
     * Paused state to set to.
     */
    val paused : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Animation.setTiming method call.
 *
 * Sets the timing of an animation node.
 */
data class SetTimingRequest (
    /**
     * Animation id.
     */
    val animationId : String,

    /**
     * Duration of the animation.
     */
    val duration : Double,

    /**
     * Delay of the animation.
     */
    val delay : Double

)


/**
 * Represents requestFrame parameters that can be used with Animation.seekAnimations method call.
 *
 * Seek a set of animations to a particular time within each animation.
 */
data class SeekAnimationsRequest (
    /**
     * List of animation ids to seek.
     */
    val animations : Array<String>,

    /**
     * Set the current time of each animation.
     */
    val currentTime : Double

)


/**
 * Represents requestFrame parameters that can be used with Animation.releaseAnimations method call.
 *
 * Releases a set of animations to no longer be manipulated.
 */
data class ReleaseAnimationsRequest (
    /**
     * List of animation ids to seek.
     */
    val animations : Array<String>

)


/**
 * Represents requestFrame parameters that can be used with Animation.resolveAnimation method call.
 *
 * Gets the remote object of the Animation.
 */
data class ResolveAnimationRequest (
    /**
     * Animation id.
     */
    val animationId : String

)

/**
 * Represents responseFrame from Animation. method call.
 *
 * Gets the remote object of the Animation.
 */
data class ResolveAnimationResponse(
  /**
   * Corresponding remote object.
   */
  val remoteObject : pl.wendigo.chrome.domain.runtime.RemoteObject

)


/**
 * Represents responseFrame from Animation. method call.
 *
 * Event for each animation that has been created.
 */
data class AnimationCreatedEvent(
  /**
   * Id of the animation that was created.
   */
  val id : String

) : pl.wendigo.chrome.ChromeProtocolEvent(protocolDomain = "Animation", protocolEventName = "animationCreated")

/**
 * Represents responseFrame from Animation. method call.
 *
 * Event for animation that has been started.
 */
data class AnimationStartedEvent(
  /**
   * Animation that was started.
   */
  val animation : Animation

) : pl.wendigo.chrome.ChromeProtocolEvent(protocolDomain = "Animation", protocolEventName = "animationStarted")

/**
 * Represents responseFrame from Animation. method call.
 *
 * Event for when an animation has been cancelled.
 */
data class AnimationCanceledEvent(
  /**
   * Id of the animation that was cancelled.
   */
  val id : String

) : pl.wendigo.chrome.ChromeProtocolEvent(protocolDomain = "Animation", protocolEventName = "animationCanceled")

