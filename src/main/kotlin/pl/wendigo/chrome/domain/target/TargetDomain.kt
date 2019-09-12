package pl.wendigo.chrome.domain.target

/**
 * Supports additional targets discovery and allows to attach to them.
 */
class TargetDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Activates (focuses) the target.
     */
    fun activateTarget(input: ActivateTargetRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.activateTarget", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Attaches to the target with given id.
     */
    fun attachToTarget(input: AttachToTargetRequest): io.reactivex.Single<AttachToTargetResponse> {
        return connectionRemote.runAndCaptureResponse("Target.attachToTarget", input, AttachToTargetResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Attaches to the browser target, only uses flat sessionId mode.
     */
    fun attachToBrowserTarget(): io.reactivex.Single<AttachToBrowserTargetResponse> {
        return connectionRemote.runAndCaptureResponse("Target.attachToBrowserTarget", null, AttachToBrowserTargetResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Closes the target. If the target is a page that gets closed too.
     */
    fun closeTarget(input: CloseTargetRequest): io.reactivex.Single<CloseTargetResponse> {
        return connectionRemote.runAndCaptureResponse("Target.closeTarget", input, CloseTargetResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Inject object to the target's main frame that provides a communication
channel with browser target.

Injected object will be available as `window[bindingName]`.

The object has the follwing API:
- `binding.send(json)` - a method to send messages over the remote debugging protocol
- `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
     */
    fun exposeDevToolsProtocol(input: ExposeDevToolsProtocolRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.exposeDevToolsProtocol", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
one.
     */
    fun createBrowserContext(): io.reactivex.Single<CreateBrowserContextResponse> {
        return connectionRemote.runAndCaptureResponse("Target.createBrowserContext", null, CreateBrowserContextResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all browser contexts created with `Target.createBrowserContext` method.
     */
    fun getBrowserContexts(): io.reactivex.Single<GetBrowserContextsResponse> {
        return connectionRemote.runAndCaptureResponse("Target.getBrowserContexts", null, GetBrowserContextsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Creates a new page.
     */
    fun createTarget(input: CreateTargetRequest): io.reactivex.Single<CreateTargetResponse> {
        return connectionRemote.runAndCaptureResponse("Target.createTarget", input, CreateTargetResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Detaches session with given id.
     */
    fun detachFromTarget(input: DetachFromTargetRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.detachFromTarget", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Deletes a BrowserContext. All the belonging pages will be closed without calling their
beforeunload hooks.
     */
    fun disposeBrowserContext(input: DisposeBrowserContextRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.disposeBrowserContext", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns information about a target.
     */
    fun getTargetInfo(input: GetTargetInfoRequest): io.reactivex.Single<GetTargetInfoResponse> {
        return connectionRemote.runAndCaptureResponse("Target.getTargetInfo", input, GetTargetInfoResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Retrieves a list of available targets.
     */
    fun getTargets(): io.reactivex.Single<GetTargetsResponse> {
        return connectionRemote.runAndCaptureResponse("Target.getTargets", null, GetTargetsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sends protocol message over session with given id.
     */
    fun sendMessageToTarget(input: SendMessageToTargetRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.sendMessageToTarget", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Controls whether to automatically attach to new targets which are considered to be related to
this one. When turned on, attaches to all existing related targets as well. When turned off,
automatically detaches from all currently attached targets.
     */
    fun setAutoAttach(input: SetAutoAttachRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.setAutoAttach", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Controls whether to discover available targets and notify via
`targetCreated/targetInfoChanged/targetDestroyed` events.
     */
    fun setDiscoverTargets(input: SetDiscoverTargetsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.setDiscoverTargets", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
`true`.
     */
    fun setRemoteLocations(input: SetRemoteLocationsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Target.setRemoteLocations", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Issued when attached to target because of auto-attach or `attachToTarget` command.
     */
    fun attachedToTarget(): io.reactivex.Flowable<AttachedToTargetEvent> {
        return attachedToTargetTimed().map {
            it.value()
        }
    }

    /**
     * Issued when attached to target because of auto-attach or `attachToTarget` command.
     */
    fun attachedToTargetTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AttachedToTargetEvent>> {
        return connectionRemote.captureEvents("Target.attachedToTarget", AttachedToTargetEvent::class.java)
    }

    /**
     *  Issued when detached from target for any reason (including `detachFromTarget` command). Can be
issued multiple times per target if multiple sessions have been attached to it.
     */
    fun detachedFromTarget(): io.reactivex.Flowable<DetachedFromTargetEvent> {
        return detachedFromTargetTimed().map {
            it.value()
        }
    }

    /**
     * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
issued multiple times per target if multiple sessions have been attached to it.
     */
    fun detachedFromTargetTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<DetachedFromTargetEvent>> {
        return connectionRemote.captureEvents("Target.detachedFromTarget", DetachedFromTargetEvent::class.java)
    }

    /**
     *  Notifies about a new protocol message received from the session (as reported in
`attachedToTarget` event).
     */
    fun receivedMessageFromTarget(): io.reactivex.Flowable<ReceivedMessageFromTargetEvent> {
        return receivedMessageFromTargetTimed().map {
            it.value()
        }
    }

    /**
     * Notifies about a new protocol message received from the session (as reported in
`attachedToTarget` event).
     */
    fun receivedMessageFromTargetTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ReceivedMessageFromTargetEvent>> {
        return connectionRemote.captureEvents("Target.receivedMessageFromTarget", ReceivedMessageFromTargetEvent::class.java)
    }

    /**
     *  Issued when a possible inspection target is created.
     */
    fun targetCreated(): io.reactivex.Flowable<TargetCreatedEvent> {
        return targetCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when a possible inspection target is created.
     */
    fun targetCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<TargetCreatedEvent>> {
        return connectionRemote.captureEvents("Target.targetCreated", TargetCreatedEvent::class.java)
    }

    /**
     *  Issued when a target is destroyed.
     */
    fun targetDestroyed(): io.reactivex.Flowable<TargetDestroyedEvent> {
        return targetDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when a target is destroyed.
     */
    fun targetDestroyedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<TargetDestroyedEvent>> {
        return connectionRemote.captureEvents("Target.targetDestroyed", TargetDestroyedEvent::class.java)
    }

    /**
     *  Issued when a target has crashed.
     */
    fun targetCrashed(): io.reactivex.Flowable<TargetCrashedEvent> {
        return targetCrashedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when a target has crashed.
     */
    fun targetCrashedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<TargetCrashedEvent>> {
        return connectionRemote.captureEvents("Target.targetCrashed", TargetCrashedEvent::class.java)
    }

    /**
     *  Issued when some information about a target has changed. This only happens between
`targetCreated` and `targetDestroyed`.
     */
    fun targetInfoChanged(): io.reactivex.Flowable<TargetInfoChangedEvent> {
        return targetInfoChangedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when some information about a target has changed. This only happens between
`targetCreated` and `targetDestroyed`.
     */
    fun targetInfoChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<TargetInfoChangedEvent>> {
        return connectionRemote.captureEvents("Target.targetInfoChanged", TargetInfoChangedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Target domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Target"
        }
    }
}
/**
 * Represents request frame that can be used with Target.activateTarget method call.
 *
 * Activates (focuses) the target.
 */
data class ActivateTargetRequest(
    /**
     *
     */
    val targetId: TargetID

)

/**
 * Represents request frame that can be used with Target.attachToTarget method call.
 *
 * Attaches to the target with given id.
 */
data class AttachToTargetRequest(
    /**
     *
     */
    val targetId: TargetID,

    /**
     * Enables "flat" access to the session via specifying sessionId attribute in the commands.
     */
    @pl.wendigo.chrome.Experimental val flatten: Boolean? = null

)

/**
 * Represents response frame for Target.attachToTarget method call.
 *
 * Attaches to the target with given id.
 */
data class AttachToTargetResponse(
    /**  
     * Id assigned to the session.  
     */  
    val sessionId: SessionID

)

/**
 * Represents response frame for Target.attachToBrowserTarget method call.
 *
 * Attaches to the browser target, only uses flat sessionId mode.
 */
data class AttachToBrowserTargetResponse(
    /**  
     * Id assigned to the session.  
     */  
    val sessionId: SessionID

)

/**
 * Represents request frame that can be used with Target.closeTarget method call.
 *
 * Closes the target. If the target is a page that gets closed too.
 */
data class CloseTargetRequest(
    /**
     *
     */
    val targetId: TargetID

)

/**
 * Represents response frame for Target.closeTarget method call.
 *
 * Closes the target. If the target is a page that gets closed too.
 */
data class CloseTargetResponse(
    /**  
     *  
     */  
    val success: Boolean

)

/**
 * Represents request frame that can be used with Target.exposeDevToolsProtocol method call.
 *
 * Inject object to the target's main frame that provides a communication
channel with browser target.

Injected object will be available as `window[bindingName]`.

The object has the follwing API:
- `binding.send(json)` - a method to send messages over the remote debugging protocol
- `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
 */
data class ExposeDevToolsProtocolRequest(
    /**
     *
     */
    val targetId: TargetID,

    /**
     * Binding name, 'cdp' if not specified.
     */
    val bindingName: String? = null

)

/**
 * Represents response frame for Target.createBrowserContext method call.
 *
 * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
one.
 */
data class CreateBrowserContextResponse(
    /**  
     * The id of the context created.  
     */  
    val browserContextId: BrowserContextID

)

/**
 * Represents response frame for Target.getBrowserContexts method call.
 *
 * Returns all browser contexts created with `Target.createBrowserContext` method.
 */
data class GetBrowserContextsResponse(
    /**  
     * An array of browser context ids.  
     */  
    val browserContextIds: List<BrowserContextID>

)

/**
 * Represents request frame that can be used with Target.createTarget method call.
 *
 * Creates a new page.
 */
data class CreateTargetRequest(
    /**
     * The initial URL the page will be navigated to.
     */
    val url: String,

    /**
     * Frame width in DIP (headless chrome only).
     */
    val width: Int? = null,

    /**
     * Frame height in DIP (headless chrome only).
     */
    val height: Int? = null,

    /**
     * The browser context to create the page in.
     */
    val browserContextId: BrowserContextID? = null,

    /**
     * Whether BeginFrames for this target will be controlled via DevTools (headless chrome only,
not supported on MacOS yet, false by default).
     */
    @pl.wendigo.chrome.Experimental val enableBeginFrameControl: Boolean? = null,

    /**
     * Whether to create a new Window or Tab (chrome-only, false by default).
     */
    val newWindow: Boolean? = null,

    /**
     * Whether to create the target in background or foreground (chrome-only,
false by default).
     */
    val background: Boolean? = null

)

/**
 * Represents response frame for Target.createTarget method call.
 *
 * Creates a new page.
 */
data class CreateTargetResponse(
    /**  
     * The id of the page opened.  
     */  
    val targetId: TargetID

)

/**
 * Represents request frame that can be used with Target.detachFromTarget method call.
 *
 * Detaches session with given id.
 */
data class DetachFromTargetRequest(
    /**
     * Session to detach.
     */
    val sessionId: SessionID? = null,

    /**
     * Deprecated.
     */
    @pl.wendigo.chrome.Deprecated val targetId: TargetID? = null

)

/**
 * Represents request frame that can be used with Target.disposeBrowserContext method call.
 *
 * Deletes a BrowserContext. All the belonging pages will be closed without calling their
beforeunload hooks.
 */
data class DisposeBrowserContextRequest(
    /**
     *
     */
    val browserContextId: BrowserContextID

)

/**
 * Represents request frame that can be used with Target.getTargetInfo method call.
 *
 * Returns information about a target.
 */
data class GetTargetInfoRequest(
    /**
     *
     */
    val targetId: TargetID? = null

)

/**
 * Represents response frame for Target.getTargetInfo method call.
 *
 * Returns information about a target.
 */
data class GetTargetInfoResponse(
    /**  
     *  
     */  
    val targetInfo: TargetInfo

)

/**
 * Represents response frame for Target.getTargets method call.
 *
 * Retrieves a list of available targets.
 */
data class GetTargetsResponse(
    /**  
     * The list of targets.  
     */  
    val targetInfos: List<TargetInfo>

)

/**
 * Represents request frame that can be used with Target.sendMessageToTarget method call.
 *
 * Sends protocol message over session with given id.
 */
data class SendMessageToTargetRequest(
    /**
     *
     */
    val message: String,

    /**
     * Identifier of the session.
     */
    val sessionId: SessionID? = null,

    /**
     * Deprecated.
     */
    @pl.wendigo.chrome.Deprecated val targetId: TargetID? = null

)

/**
 * Represents request frame that can be used with Target.setAutoAttach method call.
 *
 * Controls whether to automatically attach to new targets which are considered to be related to
this one. When turned on, attaches to all existing related targets as well. When turned off,
automatically detaches from all currently attached targets.
 */
data class SetAutoAttachRequest(
    /**
     * Whether to auto-attach to related targets.
     */
    val autoAttach: Boolean,

    /**
     * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger`
to run paused targets.
     */
    val waitForDebuggerOnStart: Boolean,

    /**
     * Enables "flat" access to the session via specifying sessionId attribute in the commands.
     */
    @pl.wendigo.chrome.Experimental val flatten: Boolean? = null

)

/**
 * Represents request frame that can be used with Target.setDiscoverTargets method call.
 *
 * Controls whether to discover available targets and notify via
`targetCreated/targetInfoChanged/targetDestroyed` events.
 */
data class SetDiscoverTargetsRequest(
    /**
     * Whether to discover available targets.
     */
    val discover: Boolean

)

/**
 * Represents request frame that can be used with Target.setRemoteLocations method call.
 *
 * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
`true`.
 */
data class SetRemoteLocationsRequest(
    /**
     * List of remote locations.
     */
    val locations: List<RemoteLocation>

)

/**
 * Represents event frames for Target.attachedToTarget
 *
 * Issued when attached to target because of auto-attach or `attachToTarget` command.
 */
data class AttachedToTargetEvent(
    /**  
     * Identifier assigned to the session used to send/receive messages.  
     */  
    val sessionId: SessionID,

    /**  
     *  
     */  
    val targetInfo: TargetInfo,

    /**  
     *  
     */  
    val waitingForDebugger: Boolean

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "attachedToTarget")

/**
 * Represents event frames for Target.detachedFromTarget
 *
 * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
issued multiple times per target if multiple sessions have been attached to it.
 */
data class DetachedFromTargetEvent(
    /**  
     * Detached session identifier.  
     */  
    val sessionId: SessionID,

    /**  
     * Deprecated.  
     */  
    @pl.wendigo.chrome.Deprecated val targetId: TargetID? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "detachedFromTarget")

/**
 * Represents event frames for Target.receivedMessageFromTarget
 *
 * Notifies about a new protocol message received from the session (as reported in
`attachedToTarget` event).
 */
data class ReceivedMessageFromTargetEvent(
    /**  
     * Identifier of a session which sends a message.  
     */  
    val sessionId: SessionID,

    /**  
     *  
     */  
    val message: String,

    /**  
     * Deprecated.  
     */  
    @pl.wendigo.chrome.Deprecated val targetId: TargetID? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "receivedMessageFromTarget")

/**
 * Represents event frames for Target.targetCreated
 *
 * Issued when a possible inspection target is created.
 */
data class TargetCreatedEvent(
    /**  
     *  
     */  
    val targetInfo: TargetInfo

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "targetCreated")

/**
 * Represents event frames for Target.targetDestroyed
 *
 * Issued when a target is destroyed.
 */
data class TargetDestroyedEvent(
    /**  
     *  
     */  
    val targetId: TargetID

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "targetDestroyed")

/**
 * Represents event frames for Target.targetCrashed
 *
 * Issued when a target has crashed.
 */
data class TargetCrashedEvent(
    /**  
     *  
     */  
    val targetId: TargetID,

    /**  
     * Termination status type.  
     */  
    val status: String,

    /**  
     * Termination error code.  
     */  
    val errorCode: Int

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "targetCrashed")

/**
 * Represents event frames for Target.targetInfoChanged
 *
 * Issued when some information about a target has changed. This only happens between
`targetCreated` and `targetDestroyed`.
 */
data class TargetInfoChangedEvent(
    /**  
     *  
     */  
    val targetInfo: TargetInfo

) : pl.wendigo.chrome.ProtocolEvent(domain = "Target", name = "targetInfoChanged")
