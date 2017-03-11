package pl.wendigo.chrome.domain.target

/**
 * Supports additional targets discovery and allows to attach to them.
 */
@pl.wendigo.chrome.ProtocolExperimental class TargetDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Controls whether to discover available targets and notify via <code>targetCreated/targetDestroyed</code> events.
	 */
	  fun setDiscoverTargets(input : SetDiscoverTargetsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.setDiscoverTargets", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Controls whether to automatically attach to new targets which are considered to be related to this one. When turned on, attaches to all existing related targets as well. When turned off, automatically detaches from all currently attached targets.
	 */
	  fun setAutoAttach(input : SetAutoAttachRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.setAutoAttach", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun setAttachToFrames(input : SetAttachToFramesRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.setAttachToFrames", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Enables target discovery for the specified locations, when <code>setDiscoverTargets</code> was set to <code>true</code>.
	 */
	  fun setRemoteLocations(input : SetRemoteLocationsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.setRemoteLocations", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Sends protocol message to the target with given id.
	 */
	  fun sendMessageToTarget(input : SendMessageToTargetRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.sendMessageToTarget", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns information about a target.
	 */
	  fun getTargetInfo(input : GetTargetInfoRequest) : io.reactivex.Flowable<GetTargetInfoResponse> {
        return connection.runAndCaptureResponse("Target.getTargetInfo", input, GetTargetInfoResponse::class.java)
	}

	/**
	 * Activates (focuses) the target.
	 */
	  fun activateTarget(input : ActivateTargetRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.activateTarget", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Closes the target. If the target is a page that gets closed too.
	 */
	  fun closeTarget(input : CloseTargetRequest) : io.reactivex.Flowable<CloseTargetResponse> {
        return connection.runAndCaptureResponse("Target.closeTarget", input, CloseTargetResponse::class.java)
	}

	/**
	 * Attaches to the target with given id.
	 */
	  fun attachToTarget(input : AttachToTargetRequest) : io.reactivex.Flowable<AttachToTargetResponse> {
        return connection.runAndCaptureResponse("Target.attachToTarget", input, AttachToTargetResponse::class.java)
	}

	/**
	 * Detaches from the target with given id.
	 */
	  fun detachFromTarget(input : DetachFromTargetRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Target.detachFromTarget", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than one.
	 */
	  fun createBrowserContext() : io.reactivex.Flowable<CreateBrowserContextResponse> {
        return connection.runAndCaptureResponse("Target.createBrowserContext", null, CreateBrowserContextResponse::class.java)
	}

	/**
	 * Deletes a BrowserContext, will fail of any open page uses it.
	 */
	  fun disposeBrowserContext(input : DisposeBrowserContextRequest) : io.reactivex.Flowable<DisposeBrowserContextResponse> {
        return connection.runAndCaptureResponse("Target.disposeBrowserContext", input, DisposeBrowserContextResponse::class.java)
	}

	/**
	 * Creates a new page.
	 */
	  fun createTarget(input : CreateTargetRequest) : io.reactivex.Flowable<CreateTargetResponse> {
        return connection.runAndCaptureResponse("Target.createTarget", input, CreateTargetResponse::class.java)
	}

	/**
	 * Retrieves a list of available targets.
	 */
	  fun getTargets() : io.reactivex.Flowable<GetTargetsResponse> {
        return connection.runAndCaptureResponse("Target.getTargets", null, GetTargetsResponse::class.java)
	}

  
  /**
   * Issued when a possible inspection target is created.
   */
   fun targetCreated() : io.reactivex.Flowable<TargetCreatedEvent> {
      return connection.captureEvents("Target.targetCreated", TargetCreatedEvent::class.java)
   }

  /**
   * Issued when a target is destroyed.
   */
   fun targetDestroyed() : io.reactivex.Flowable<TargetDestroyedEvent> {
      return connection.captureEvents("Target.targetDestroyed", TargetDestroyedEvent::class.java)
   }

  /**
   * Issued when attached to target because of auto-attach or <code>attachToTarget</code> command.
   */
   fun attachedToTarget() : io.reactivex.Flowable<AttachedToTargetEvent> {
      return connection.captureEvents("Target.attachedToTarget", AttachedToTargetEvent::class.java)
   }

  /**
   * Issued when detached from target for any reason (including <code>detachFromTarget</code> command).
   */
   fun detachedFromTarget() : io.reactivex.Flowable<DetachedFromTargetEvent> {
      return connection.captureEvents("Target.detachedFromTarget", DetachedFromTargetEvent::class.java)
   }

  /**
   * Notifies about new protocol message from attached target.
   */
   fun receivedMessageFromTarget() : io.reactivex.Flowable<ReceivedMessageFromTargetEvent> {
      return connection.captureEvents("Target.receivedMessageFromTarget", ReceivedMessageFromTargetEvent::class.java)
   }
}

/**
 * Represents requestFrame parameters that can be used with Target.setDiscoverTargets method call.
 *
 * Controls whether to discover available targets and notify via <code>targetCreated/targetDestroyed</code> events.
 */
data class SetDiscoverTargetsRequest (
    /**
     * Whether to discover available targets.
     */
    val discover : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Target.setAutoAttach method call.
 *
 * Controls whether to automatically attach to new targets which are considered to be related to this one. When turned on, attaches to all existing related targets as well. When turned off, automatically detaches from all currently attached targets.
 */
data class SetAutoAttachRequest (
    /**
     * Whether to auto-attach to related targets.
     */
    val autoAttach : Boolean,

    /**
     * Whether to pause new targets when attaching to them. Use <code>Runtime.runIfWaitingForDebugger</code> to run paused targets.
     */
    val waitForDebuggerOnStart : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Target.setAttachToFrames method call.
 *
 * 
 */
data class SetAttachToFramesRequest (
    /**
     * Whether to attach to frames.
     */
    val value : Boolean

)


/**
 * Represents requestFrame parameters that can be used with Target.setRemoteLocations method call.
 *
 * Enables target discovery for the specified locations, when <code>setDiscoverTargets</code> was set to <code>true</code>.
 */
data class SetRemoteLocationsRequest (
    /**
     * List of remote locations.
     */
    val locations : Array<RemoteLocation>

)


/**
 * Represents requestFrame parameters that can be used with Target.sendMessageToTarget method call.
 *
 * Sends protocol message to the target with given id.
 */
data class SendMessageToTargetRequest (
    /**
     * 
     */
    val targetId : String,

    /**
     * 
     */
    val message : String

)


/**
 * Represents requestFrame parameters that can be used with Target.getTargetInfo method call.
 *
 * Returns information about a target.
 */
data class GetTargetInfoRequest (
    /**
     * 
     */
    val targetId : TargetID

)

/**
 * Represents responseFrame from Target. method call.
 *
 * Returns information about a target.
 */
data class GetTargetInfoResponse(
  /**
   * 
   */
  val targetInfo : TargetInfo

)

/**
 * Represents requestFrame parameters that can be used with Target.activateTarget method call.
 *
 * Activates (focuses) the target.
 */
data class ActivateTargetRequest (
    /**
     * 
     */
    val targetId : TargetID

)


/**
 * Represents requestFrame parameters that can be used with Target.closeTarget method call.
 *
 * Closes the target. If the target is a page that gets closed too.
 */
data class CloseTargetRequest (
    /**
     * 
     */
    val targetId : TargetID

)

/**
 * Represents responseFrame from Target. method call.
 *
 * Closes the target. If the target is a page that gets closed too.
 */
data class CloseTargetResponse(
  /**
   * 
   */
  val success : Boolean

)

/**
 * Represents requestFrame parameters that can be used with Target.attachToTarget method call.
 *
 * Attaches to the target with given id.
 */
data class AttachToTargetRequest (
    /**
     * 
     */
    val targetId : TargetID

)

/**
 * Represents responseFrame from Target. method call.
 *
 * Attaches to the target with given id.
 */
data class AttachToTargetResponse(
  /**
   * Whether attach succeeded.
   */
  val success : Boolean

)

/**
 * Represents requestFrame parameters that can be used with Target.detachFromTarget method call.
 *
 * Detaches from the target with given id.
 */
data class DetachFromTargetRequest (
    /**
     * 
     */
    val targetId : TargetID

)



/**
 * Represents responseFrame from Target. method call.
 *
 * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than one.
 */
data class CreateBrowserContextResponse(
  /**
   * The id of the context created.
   */
  val browserContextId : BrowserContextID

)

/**
 * Represents requestFrame parameters that can be used with Target.disposeBrowserContext method call.
 *
 * Deletes a BrowserContext, will fail of any open page uses it.
 */
data class DisposeBrowserContextRequest (
    /**
     * 
     */
    val browserContextId : BrowserContextID

)

/**
 * Represents responseFrame from Target. method call.
 *
 * Deletes a BrowserContext, will fail of any open page uses it.
 */
data class DisposeBrowserContextResponse(
  /**
   * 
   */
  val success : Boolean

)

/**
 * Represents requestFrame parameters that can be used with Target.createTarget method call.
 *
 * Creates a new page.
 */
data class CreateTargetRequest (
    /**
     * The initial URL the page will be navigated to.
     */
    val url : String,

    /**
     * Frame width in DIP (headless chrome only).
     */
    val width : Int? = null,

    /**
     * Frame height in DIP (headless chrome only).
     */
    val height : Int? = null,

    /**
     * The browser context to create the page in (headless chrome only).
     */
    val browserContextId : BrowserContextID? = null

)

/**
 * Represents responseFrame from Target. method call.
 *
 * Creates a new page.
 */
data class CreateTargetResponse(
  /**
   * The id of the page opened.
   */
  val targetId : TargetID

)


/**
 * Represents responseFrame from Target. method call.
 *
 * Retrieves a list of available targets.
 */
data class GetTargetsResponse(
  /**
   * The list of targets.
   */
  val targetInfos : Array<TargetInfo>

)


/**
 * Represents responseFrame from Target. method call.
 *
 * Issued when a possible inspection target is created.
 */
data class TargetCreatedEvent(
  /**
   * 
   */
  val targetInfo : TargetInfo

) : pl.wendigo.chrome.DebuggerEvent(domain = "Target", name = "targetCreated")

/**
 * Represents responseFrame from Target. method call.
 *
 * Issued when a target is destroyed.
 */
data class TargetDestroyedEvent(
  /**
   * 
   */
  val targetId : TargetID

) : pl.wendigo.chrome.DebuggerEvent(domain = "Target", name = "targetDestroyed")

/**
 * Represents responseFrame from Target. method call.
 *
 * Issued when attached to target because of auto-attach or <code>attachToTarget</code> command.
 */
data class AttachedToTargetEvent(
  /**
   * 
   */
  val targetInfo : TargetInfo,

  /**
   * 
   */
  val waitingForDebugger : Boolean

) : pl.wendigo.chrome.DebuggerEvent(domain = "Target", name = "attachedToTarget")

/**
 * Represents responseFrame from Target. method call.
 *
 * Issued when detached from target for any reason (including <code>detachFromTarget</code> command).
 */
data class DetachedFromTargetEvent(
  /**
   * 
   */
  val targetId : TargetID

) : pl.wendigo.chrome.DebuggerEvent(domain = "Target", name = "detachedFromTarget")

/**
 * Represents responseFrame from Target. method call.
 *
 * Notifies about new protocol message from attached target.
 */
data class ReceivedMessageFromTargetEvent(
  /**
   * 
   */
  val targetId : TargetID,

  /**
   * 
   */
  val message : String

) : pl.wendigo.chrome.DebuggerEvent(domain = "Target", name = "receivedMessageFromTarget")

