package pl.wendigo.chrome.api.target

import kotlinx.serialization.json.Json

/**
 * Supports additional targets discovery and allows to attach to them.
 *
 * @link Protocol [Target](https://chromedevtools.github.io/devtools-protocol/tot/Target) domain documentation.
 */

class TargetDomain internal constructor(connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) :
    pl.wendigo.chrome.api.Domain("Target", """Supports additional targets discovery and allows to attach to them.""", connection) {
    /**
     * Activates (focuses) the target.
     *
     * @link Protocol [Target#activateTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-activateTarget) method documentation.
     */
    
    fun activateTarget(input: ActivateTargetRequest) = connection.request("Target.activateTarget", Json.encodeToJsonElement(ActivateTargetRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Attaches to the target with given id.
     *
     * @link Protocol [Target#attachToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToTarget) method documentation.
     */
    
    fun attachToTarget(input: AttachToTargetRequest) = connection.request("Target.attachToTarget", Json.encodeToJsonElement(AttachToTargetRequest.serializer(), input), AttachToTargetResponse.serializer())

    /**
     * Attaches to the browser target, only uses flat sessionId mode.
     *
     * @link Protocol [Target#attachToBrowserTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToBrowserTarget) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun attachToBrowserTarget() = connection.request("Target.attachToBrowserTarget", null, AttachToBrowserTargetResponse.serializer())

    /**
     * Closes the target. If the target is a page that gets closed too.
     *
     * @link Protocol [Target#closeTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-closeTarget) method documentation.
     */
    
    fun closeTarget(input: CloseTargetRequest) = connection.request("Target.closeTarget", Json.encodeToJsonElement(CloseTargetRequest.serializer(), input), CloseTargetResponse.serializer())

    /**
     * Inject object to the target's main frame that provides a communication
channel with browser target.

Injected object will be available as `window[bindingName]`.

The object has the follwing API:
- `binding.send(json)` - a method to send messages over the remote debugging protocol
- `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
     *
     * @link Protocol [Target#exposeDevToolsProtocol](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-exposeDevToolsProtocol) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun exposeDevToolsProtocol(input: ExposeDevToolsProtocolRequest) = connection.request("Target.exposeDevToolsProtocol", Json.encodeToJsonElement(ExposeDevToolsProtocolRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
one.
     *
     * @link Protocol [Target#createBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createBrowserContext) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun createBrowserContext(input: CreateBrowserContextRequest) = connection.request("Target.createBrowserContext", Json.encodeToJsonElement(CreateBrowserContextRequest.serializer(), input), CreateBrowserContextResponse.serializer())

    /**
     * Returns all browser contexts created with `Target.createBrowserContext` method.
     *
     * @link Protocol [Target#getBrowserContexts](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getBrowserContexts) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getBrowserContexts() = connection.request("Target.getBrowserContexts", null, GetBrowserContextsResponse.serializer())

    /**
     * Creates a new page.
     *
     * @link Protocol [Target#createTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createTarget) method documentation.
     */
    
    fun createTarget(input: CreateTargetRequest) = connection.request("Target.createTarget", Json.encodeToJsonElement(CreateTargetRequest.serializer(), input), CreateTargetResponse.serializer())

    /**
     * Detaches session with given id.
     *
     * @link Protocol [Target#detachFromTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-detachFromTarget) method documentation.
     */
    
    fun detachFromTarget(input: DetachFromTargetRequest) = connection.request("Target.detachFromTarget", Json.encodeToJsonElement(DetachFromTargetRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Deletes a BrowserContext. All the belonging pages will be closed without calling their
beforeunload hooks.
     *
     * @link Protocol [Target#disposeBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-disposeBrowserContext) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun disposeBrowserContext(input: DisposeBrowserContextRequest) = connection.request("Target.disposeBrowserContext", Json.encodeToJsonElement(DisposeBrowserContextRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Returns information about a target.
     *
     * @link Protocol [Target#getTargetInfo](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargetInfo) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getTargetInfo(input: GetTargetInfoRequest) = connection.request("Target.getTargetInfo", Json.encodeToJsonElement(GetTargetInfoRequest.serializer(), input), GetTargetInfoResponse.serializer())

    /**
     * Retrieves a list of available targets.
     *
     * @link Protocol [Target#getTargets](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargets) method documentation.
     */
    
    fun getTargets() = connection.request("Target.getTargets", null, GetTargetsResponse.serializer())

    /**
     * Sends protocol message over session with given id.
Consider using flat mode instead; see commands attachToTarget, setAutoAttach,
and crbug.com/991325.
     *
     * @link Protocol [Target#sendMessageToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-sendMessageToTarget) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "{{sendMessageToTarget}} is deprecated.")
    fun sendMessageToTarget(input: SendMessageToTargetRequest) = connection.request("Target.sendMessageToTarget", Json.encodeToJsonElement(SendMessageToTargetRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Controls whether to automatically attach to new targets which are considered to be related to
this one. When turned on, attaches to all existing related targets as well. When turned off,
automatically detaches from all currently attached targets.
     *
     * @link Protocol [Target#setAutoAttach](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setAutoAttach) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setAutoAttach(input: SetAutoAttachRequest) = connection.request("Target.setAutoAttach", Json.encodeToJsonElement(SetAutoAttachRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Controls whether to discover available targets and notify via
`targetCreated/targetInfoChanged/targetDestroyed` events.
     *
     * @link Protocol [Target#setDiscoverTargets](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setDiscoverTargets) method documentation.
     */
    
    fun setDiscoverTargets(input: SetDiscoverTargetsRequest) = connection.request("Target.setDiscoverTargets", Json.encodeToJsonElement(SetDiscoverTargetsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
`true`.
     *
     * @link Protocol [Target#setRemoteLocations](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setRemoteLocations) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setRemoteLocations(input: SetRemoteLocationsRequest) = connection.request("Target.setRemoteLocations", Json.encodeToJsonElement(SetRemoteLocationsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Issued when attached to target because of auto-attach or `attachToTarget` command.
     */
    fun attachedToTarget(): io.reactivex.rxjava3.core.Flowable<AttachedToTargetEvent> = connection.events("Target.attachedToTarget", AttachedToTargetEvent.serializer())

    /**
     *  Issued when detached from target for any reason (including `detachFromTarget` command). Can be
issued multiple times per target if multiple sessions have been attached to it.
     */
    fun detachedFromTarget(): io.reactivex.rxjava3.core.Flowable<DetachedFromTargetEvent> = connection.events("Target.detachedFromTarget", DetachedFromTargetEvent.serializer())

    /**
     *  Notifies about a new protocol message received from the session (as reported in
`attachedToTarget` event).
     */
    fun receivedMessageFromTarget(): io.reactivex.rxjava3.core.Flowable<ReceivedMessageFromTargetEvent> = connection.events("Target.receivedMessageFromTarget", ReceivedMessageFromTargetEvent.serializer())

    /**
     *  Issued when a possible inspection target is created.
     */
    fun targetCreated(): io.reactivex.rxjava3.core.Flowable<TargetCreatedEvent> = connection.events("Target.targetCreated", TargetCreatedEvent.serializer())

    /**
     *  Issued when a target is destroyed.
     */
    fun targetDestroyed(): io.reactivex.rxjava3.core.Flowable<TargetDestroyedEvent> = connection.events("Target.targetDestroyed", TargetDestroyedEvent.serializer())

    /**
     *  Issued when a target has crashed.
     */
    fun targetCrashed(): io.reactivex.rxjava3.core.Flowable<TargetCrashedEvent> = connection.events("Target.targetCrashed", TargetCrashedEvent.serializer())

    /**
     *  Issued when some information about a target has changed. This only happens between
`targetCreated` and `targetDestroyed`.
     */
    fun targetInfoChanged(): io.reactivex.rxjava3.core.Flowable<TargetInfoChangedEvent> = connection.events("Target.targetInfoChanged", TargetInfoChangedEvent.serializer())
}

/**
 * Represents request frame that can be used with [Target#activateTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-activateTarget) operation call.
 *
 * Activates (focuses) the target.
 * @link [Target#activateTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-activateTarget) method documentation.
 * @see [TargetOperations.activateTarget]
 */
@kotlinx.serialization.Serializable
data class ActivateTargetRequest(
    /**
     *
     */
    val targetId: TargetID

)

/**
 * Represents request frame that can be used with [Target#attachToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToTarget) operation call.
 *
 * Attaches to the target with given id.
 * @link [Target#attachToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToTarget) method documentation.
 * @see [TargetOperations.attachToTarget]
 */
@kotlinx.serialization.Serializable
data class AttachToTargetRequest(
    /**
     *
     */
    val targetId: TargetID,

    /**
     * Enables "flat" access to the session via specifying sessionId attribute in the commands.
We plan to make this the default, deprecate non-flattened mode,
and eventually retire it. See crbug.com/991325.
     */
    val flatten: Boolean? = null

)

/**
 * Represents response frame that is returned from [Target#attachToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToTarget) operation call.
 * Attaches to the target with given id.
 *
  
 * @link [Target#attachToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToTarget) method documentation.
 * @see [TargetOperations.attachToTarget]
 */
@kotlinx.serialization.Serializable
data class AttachToTargetResponse(
    /**  
     * Id assigned to the session.  
     */  
    val sessionId: SessionID

)

/**
 * Represents response frame that is returned from [Target#attachToBrowserTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToBrowserTarget) operation call.
 * Attaches to the browser target, only uses flat sessionId mode.
 *
  
 * @link [Target#attachToBrowserTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-attachToBrowserTarget) method documentation.
 * @see [TargetOperations.attachToBrowserTarget]
 */
@kotlinx.serialization.Serializable
data class AttachToBrowserTargetResponse(
    /**  
     * Id assigned to the session.  
     */  
    val sessionId: SessionID

)

/**
 * Represents request frame that can be used with [Target#closeTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-closeTarget) operation call.
 *
 * Closes the target. If the target is a page that gets closed too.
 * @link [Target#closeTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-closeTarget) method documentation.
 * @see [TargetOperations.closeTarget]
 */
@kotlinx.serialization.Serializable
data class CloseTargetRequest(
    /**
     *
     */
    val targetId: TargetID

)

/**
 * Represents response frame that is returned from [Target#closeTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-closeTarget) operation call.
 * Closes the target. If the target is a page that gets closed too.
 *
  
 * @link [Target#closeTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-closeTarget) method documentation.
 * @see [TargetOperations.closeTarget]
 */
@kotlinx.serialization.Serializable
data class CloseTargetResponse(
    /**  
     * Always set to true. If an error occurs, the response indicates protocol error.  
     */  
    val success: Boolean

)

/**
 * Represents request frame that can be used with [Target#exposeDevToolsProtocol](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-exposeDevToolsProtocol) operation call.
 *
 * Inject object to the target's main frame that provides a communication
channel with browser target.

Injected object will be available as `window[bindingName]`.

The object has the follwing API:
- `binding.send(json)` - a method to send messages over the remote debugging protocol
- `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
 * @link [Target#exposeDevToolsProtocol](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-exposeDevToolsProtocol) method documentation.
 * @see [TargetOperations.exposeDevToolsProtocol]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Target#createBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createBrowserContext) operation call.
 *
 * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
one.
 * @link [Target#createBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createBrowserContext) method documentation.
 * @see [TargetOperations.createBrowserContext]
 */
@kotlinx.serialization.Serializable
data class CreateBrowserContextRequest(
    /**
     * If specified, disposes this context when debugging session disconnects.
     */
    val disposeOnDetach: Boolean? = null,

    /**
     * Proxy server, similar to the one passed to --proxy-server
     */
    val proxyServer: String? = null,

    /**
     * Proxy bypass list, similar to the one passed to --proxy-bypass-list
     */
    val proxyBypassList: String? = null

)

/**
 * Represents response frame that is returned from [Target#createBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createBrowserContext) operation call.
 * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
one.
 *
  
 * @link [Target#createBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createBrowserContext) method documentation.
 * @see [TargetOperations.createBrowserContext]
 */
@kotlinx.serialization.Serializable
data class CreateBrowserContextResponse(
    /**  
     * The id of the context created.  
     */  
    val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID

)

/**
 * Represents response frame that is returned from [Target#getBrowserContexts](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getBrowserContexts) operation call.
 * Returns all browser contexts created with `Target.createBrowserContext` method.
 *
  
 * @link [Target#getBrowserContexts](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getBrowserContexts) method documentation.
 * @see [TargetOperations.getBrowserContexts]
 */
@kotlinx.serialization.Serializable
data class GetBrowserContextsResponse(
    /**  
     * An array of browser context ids.  
     */  
    val browserContextIds: List<pl.wendigo.chrome.api.browser.BrowserContextID>

)

/**
 * Represents request frame that can be used with [Target#createTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createTarget) operation call.
 *
 * Creates a new page.
 * @link [Target#createTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createTarget) method documentation.
 * @see [TargetOperations.createTarget]
 */
@kotlinx.serialization.Serializable
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
    val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID? = null,

    /**
     * Whether BeginFrames for this target will be controlled via DevTools (headless chrome only,
not supported on MacOS yet, false by default).
     */
    @pl.wendigo.chrome.protocol.Experimental val enableBeginFrameControl: Boolean? = null,

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
 * Represents response frame that is returned from [Target#createTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createTarget) operation call.
 * Creates a new page.
 *
  
 * @link [Target#createTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-createTarget) method documentation.
 * @see [TargetOperations.createTarget]
 */
@kotlinx.serialization.Serializable
data class CreateTargetResponse(
    /**  
     * The id of the page opened.  
     */  
    val targetId: TargetID

)

/**
 * Represents request frame that can be used with [Target#detachFromTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-detachFromTarget) operation call.
 *
 * Detaches session with given id.
 * @link [Target#detachFromTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-detachFromTarget) method documentation.
 * @see [TargetOperations.detachFromTarget]
 */
@kotlinx.serialization.Serializable
data class DetachFromTargetRequest(
    /**
     * Session to detach.
     */
    val sessionId: SessionID? = null,

    /**
     * Deprecated.
     */
    @Deprecated(message = "") val targetId: TargetID? = null

)

/**
 * Represents request frame that can be used with [Target#disposeBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-disposeBrowserContext) operation call.
 *
 * Deletes a BrowserContext. All the belonging pages will be closed without calling their
beforeunload hooks.
 * @link [Target#disposeBrowserContext](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-disposeBrowserContext) method documentation.
 * @see [TargetOperations.disposeBrowserContext]
 */
@kotlinx.serialization.Serializable
data class DisposeBrowserContextRequest(
    /**
     *
     */
    val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID

)

/**
 * Represents request frame that can be used with [Target#getTargetInfo](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargetInfo) operation call.
 *
 * Returns information about a target.
 * @link [Target#getTargetInfo](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargetInfo) method documentation.
 * @see [TargetOperations.getTargetInfo]
 */
@kotlinx.serialization.Serializable
data class GetTargetInfoRequest(
    /**
     *
     */
    val targetId: TargetID? = null

)

/**
 * Represents response frame that is returned from [Target#getTargetInfo](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargetInfo) operation call.
 * Returns information about a target.
 *
  
 * @link [Target#getTargetInfo](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargetInfo) method documentation.
 * @see [TargetOperations.getTargetInfo]
 */
@kotlinx.serialization.Serializable
data class GetTargetInfoResponse(
    /**  
     *  
     */  
    val targetInfo: TargetInfo

)

/**
 * Represents response frame that is returned from [Target#getTargets](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargets) operation call.
 * Retrieves a list of available targets.
 *
  
 * @link [Target#getTargets](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-getTargets) method documentation.
 * @see [TargetOperations.getTargets]
 */
@kotlinx.serialization.Serializable
data class GetTargetsResponse(
    /**  
     * The list of targets.  
     */  
    val targetInfos: List<TargetInfo>

)

/**
 * Represents request frame that can be used with [Target#sendMessageToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-sendMessageToTarget) operation call.
 *
 * Sends protocol message over session with given id.
Consider using flat mode instead; see commands attachToTarget, setAutoAttach,
and crbug.com/991325.
 * @link [Target#sendMessageToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-sendMessageToTarget) method documentation.
 * @see [TargetOperations.sendMessageToTarget]
 */
@kotlinx.serialization.Serializable
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
    @Deprecated(message = "") val targetId: TargetID? = null

)

/**
 * Represents request frame that can be used with [Target#setAutoAttach](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setAutoAttach) operation call.
 *
 * Controls whether to automatically attach to new targets which are considered to be related to
this one. When turned on, attaches to all existing related targets as well. When turned off,
automatically detaches from all currently attached targets.
 * @link [Target#setAutoAttach](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setAutoAttach) method documentation.
 * @see [TargetOperations.setAutoAttach]
 */
@kotlinx.serialization.Serializable
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
We plan to make this the default, deprecate non-flattened mode,
and eventually retire it. See crbug.com/991325.
     */
    val flatten: Boolean? = null

)

/**
 * Represents request frame that can be used with [Target#setDiscoverTargets](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setDiscoverTargets) operation call.
 *
 * Controls whether to discover available targets and notify via
`targetCreated/targetInfoChanged/targetDestroyed` events.
 * @link [Target#setDiscoverTargets](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setDiscoverTargets) method documentation.
 * @see [TargetOperations.setDiscoverTargets]
 */
@kotlinx.serialization.Serializable
data class SetDiscoverTargetsRequest(
    /**
     * Whether to discover available targets.
     */
    val discover: Boolean

)

/**
 * Represents request frame that can be used with [Target#setRemoteLocations](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setRemoteLocations) operation call.
 *
 * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
`true`.
 * @link [Target#setRemoteLocations](https://chromedevtools.github.io/devtools-protocol/tot/Target#method-setRemoteLocations) method documentation.
 * @see [TargetOperations.setRemoteLocations]
 */
@kotlinx.serialization.Serializable
data class SetRemoteLocationsRequest(
    /**
     * List of remote locations.
     */
    val locations: List<RemoteLocation>

)

/**
 * Issued when attached to target because of auto-attach or `attachToTarget` command.
 *
 * @link [Target#attachedToTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-attachedToTarget) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "attachedToTarget"
} 

/**
 * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
issued multiple times per target if multiple sessions have been attached to it.
 *
 * @link [Target#detachedFromTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-detachedFromTarget) event documentation.
 */
@kotlinx.serialization.Serializable
data class DetachedFromTargetEvent(
    /**  
     * Detached session identifier.  
     */  
    val sessionId: SessionID,

    /**  
     * Deprecated.  
     */  
    val targetId: TargetID? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "detachedFromTarget"
} 

/**
 * Notifies about a new protocol message received from the session (as reported in
`attachedToTarget` event).
 *
 * @link [Target#receivedMessageFromTarget](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-receivedMessageFromTarget) event documentation.
 */
@kotlinx.serialization.Serializable
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
    val targetId: TargetID? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "receivedMessageFromTarget"
} 

/**
 * Issued when a possible inspection target is created.
 *
 * @link [Target#targetCreated](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-targetCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class TargetCreatedEvent(
    /**  
     *  
     */  
    val targetInfo: TargetInfo

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "targetCreated"
} 

/**
 * Issued when a target is destroyed.
 *
 * @link [Target#targetDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-targetDestroyed) event documentation.
 */
@kotlinx.serialization.Serializable
data class TargetDestroyedEvent(
    /**  
     *  
     */  
    val targetId: TargetID

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "targetDestroyed"
} 

/**
 * Issued when a target has crashed.
 *
 * @link [Target#targetCrashed](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-targetCrashed) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "targetCrashed"
} 

/**
 * Issued when some information about a target has changed. This only happens between
`targetCreated` and `targetDestroyed`.
 *
 * @link [Target#targetInfoChanged](https://chromedevtools.github.io/devtools-protocol/tot/Target#event-targetInfoChanged) event documentation.
 */
@kotlinx.serialization.Serializable
data class TargetInfoChangedEvent(
    /**  
     *  
     */  
    val targetInfo: TargetInfo

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Target" 
    override fun eventName() = "targetInfoChanged"
} 
