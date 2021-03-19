package pl.wendigo.chrome

import io.reactivex.rxjava3.core.Flowable
import pl.wendigo.chrome.api.accessibility.AccessibilityOperations
import pl.wendigo.chrome.api.animation.AnimationOperations
import pl.wendigo.chrome.api.applicationcache.ApplicationCacheOperations
import pl.wendigo.chrome.api.audits.AuditsOperations
import pl.wendigo.chrome.api.backgroundservice.BackgroundServiceOperations
import pl.wendigo.chrome.api.browser.BrowserOperations
import pl.wendigo.chrome.api.cachestorage.CacheStorageOperations
import pl.wendigo.chrome.api.cast.CastOperations
import pl.wendigo.chrome.api.console.ConsoleOperations
import pl.wendigo.chrome.api.css.CSSOperations
import pl.wendigo.chrome.api.database.DatabaseOperations
import pl.wendigo.chrome.api.debugger.DebuggerOperations
import pl.wendigo.chrome.api.deviceorientation.DeviceOrientationOperations
import pl.wendigo.chrome.api.dom.DOMOperations
import pl.wendigo.chrome.api.domdebugger.DOMDebuggerOperations
import pl.wendigo.chrome.api.domsnapshot.DOMSnapshotOperations
import pl.wendigo.chrome.api.domstorage.DOMStorageOperations
import pl.wendigo.chrome.api.emulation.EmulationOperations
import pl.wendigo.chrome.api.fetch.FetchOperations
import pl.wendigo.chrome.api.headlessexperimental.HeadlessExperimentalOperations
import pl.wendigo.chrome.api.heapprofiler.HeapProfilerOperations
import pl.wendigo.chrome.api.indexeddb.IndexedDBOperations
import pl.wendigo.chrome.api.input.InputOperations
import pl.wendigo.chrome.api.inspector.InspectorOperations
import pl.wendigo.chrome.api.io.IOOperations
import pl.wendigo.chrome.api.layertree.LayerTreeOperations
import pl.wendigo.chrome.api.log.LogOperations
import pl.wendigo.chrome.api.media.MediaOperations
import pl.wendigo.chrome.api.memory.MemoryOperations
import pl.wendigo.chrome.api.network.NetworkOperations
import pl.wendigo.chrome.api.overlay.OverlayOperations
import pl.wendigo.chrome.api.page.PageOperations
import pl.wendigo.chrome.api.performance.PerformanceOperations
import pl.wendigo.chrome.api.performancetimeline.PerformanceTimelineOperations
import pl.wendigo.chrome.api.profiler.ProfilerOperations
import pl.wendigo.chrome.api.runtime.RuntimeOperations
import pl.wendigo.chrome.api.schema.SchemaOperations
import pl.wendigo.chrome.api.security.SecurityOperations
import pl.wendigo.chrome.api.serviceworker.ServiceWorkerOperations
import pl.wendigo.chrome.api.storage.StorageOperations
import pl.wendigo.chrome.api.systeminfo.SystemInfoOperations
import pl.wendigo.chrome.api.target.TargetOperations
import pl.wendigo.chrome.api.tethering.TetheringOperations
import pl.wendigo.chrome.api.tracing.TracingOperations
import pl.wendigo.chrome.api.webaudio.WebAudioOperations
import pl.wendigo.chrome.api.webauthn.WebAuthnOperations
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import java.io.Closeable

/**
 * DevToolsProtocol represents all operations on all domains that can be issued to control Chrome via [DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).
 *
 * @link [https://github.com/chromedevtools/devtools-protocol](https://github.com/chromedevtools/devtools-protocol)
 * @link [https://chromedevtools.github.io/devtools-protocol/](https://chromedevtools.github.io/devtools-protocol/)
 */
open class DevToolsProtocol internal constructor(internal val connection: ChromeDebuggerConnection) : Closeable {

    /**
     * Register events mappings.
     */
    init {
        connection.registerEventSerializer("Animation.animationCanceled", pl.wendigo.chrome.api.animation.AnimationCanceledEvent.serializer())
        connection.registerEventSerializer("Animation.animationCreated", pl.wendigo.chrome.api.animation.AnimationCreatedEvent.serializer())
        connection.registerEventSerializer("Animation.animationStarted", pl.wendigo.chrome.api.animation.AnimationStartedEvent.serializer())
        connection.registerEventSerializer("ApplicationCache.applicationCacheStatusUpdated", pl.wendigo.chrome.api.applicationcache.ApplicationCacheStatusUpdatedEvent.serializer())
        connection.registerEventSerializer("ApplicationCache.networkStateUpdated", pl.wendigo.chrome.api.applicationcache.NetworkStateUpdatedEvent.serializer())
        connection.registerEventSerializer("Audits.issueAdded", pl.wendigo.chrome.api.audits.IssueAddedEvent.serializer())
        connection.registerEventSerializer("BackgroundService.backgroundServiceEventReceived", pl.wendigo.chrome.api.backgroundservice.BackgroundServiceEventReceivedEvent.serializer())
        connection.registerEventSerializer("BackgroundService.recordingStateChanged", pl.wendigo.chrome.api.backgroundservice.RecordingStateChangedEvent.serializer())
        connection.registerEventSerializer("CSS.fontsUpdated", pl.wendigo.chrome.api.css.FontsUpdatedEvent.serializer())
        connection.registerEventSerializer("CSS.mediaQueryResultChanged", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("CSS.styleSheetAdded", pl.wendigo.chrome.api.css.StyleSheetAddedEvent.serializer())
        connection.registerEventSerializer("CSS.styleSheetChanged", pl.wendigo.chrome.api.css.StyleSheetChangedEvent.serializer())
        connection.registerEventSerializer("CSS.styleSheetRemoved", pl.wendigo.chrome.api.css.StyleSheetRemovedEvent.serializer())
        connection.registerEventSerializer("Cast.issueUpdated", pl.wendigo.chrome.api.cast.IssueUpdatedEvent.serializer())
        connection.registerEventSerializer("Cast.sinksUpdated", pl.wendigo.chrome.api.cast.SinksUpdatedEvent.serializer())
        connection.registerEventSerializer("Console.messageAdded", pl.wendigo.chrome.api.console.MessageAddedEvent.serializer())
        connection.registerEventSerializer("DOM.attributeModified", pl.wendigo.chrome.api.dom.AttributeModifiedEvent.serializer())
        connection.registerEventSerializer("DOM.attributeRemoved", pl.wendigo.chrome.api.dom.AttributeRemovedEvent.serializer())
        connection.registerEventSerializer("DOM.characterDataModified", pl.wendigo.chrome.api.dom.CharacterDataModifiedEvent.serializer())
        connection.registerEventSerializer("DOM.childNodeCountUpdated", pl.wendigo.chrome.api.dom.ChildNodeCountUpdatedEvent.serializer())
        connection.registerEventSerializer("DOM.childNodeInserted", pl.wendigo.chrome.api.dom.ChildNodeInsertedEvent.serializer())
        connection.registerEventSerializer("DOM.childNodeRemoved", pl.wendigo.chrome.api.dom.ChildNodeRemovedEvent.serializer())
        connection.registerEventSerializer("DOM.distributedNodesUpdated", pl.wendigo.chrome.api.dom.DistributedNodesUpdatedEvent.serializer())
        connection.registerEventSerializer("DOM.documentUpdated", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("DOM.inlineStyleInvalidated", pl.wendigo.chrome.api.dom.InlineStyleInvalidatedEvent.serializer())
        connection.registerEventSerializer("DOM.pseudoElementAdded", pl.wendigo.chrome.api.dom.PseudoElementAddedEvent.serializer())
        connection.registerEventSerializer("DOM.pseudoElementRemoved", pl.wendigo.chrome.api.dom.PseudoElementRemovedEvent.serializer())
        connection.registerEventSerializer("DOM.setChildNodes", pl.wendigo.chrome.api.dom.SetChildNodesEvent.serializer())
        connection.registerEventSerializer("DOM.shadowRootPopped", pl.wendigo.chrome.api.dom.ShadowRootPoppedEvent.serializer())
        connection.registerEventSerializer("DOM.shadowRootPushed", pl.wendigo.chrome.api.dom.ShadowRootPushedEvent.serializer())
        connection.registerEventSerializer("DOMStorage.domStorageItemAdded", pl.wendigo.chrome.api.domstorage.DomStorageItemAddedEvent.serializer())
        connection.registerEventSerializer("DOMStorage.domStorageItemRemoved", pl.wendigo.chrome.api.domstorage.DomStorageItemRemovedEvent.serializer())
        connection.registerEventSerializer("DOMStorage.domStorageItemUpdated", pl.wendigo.chrome.api.domstorage.DomStorageItemUpdatedEvent.serializer())
        connection.registerEventSerializer("DOMStorage.domStorageItemsCleared", pl.wendigo.chrome.api.domstorage.DomStorageItemsClearedEvent.serializer())
        connection.registerEventSerializer("Database.addDatabase", pl.wendigo.chrome.api.database.AddDatabaseEvent.serializer())
        connection.registerEventSerializer("Debugger.breakpointResolved", pl.wendigo.chrome.api.debugger.BreakpointResolvedEvent.serializer())
        connection.registerEventSerializer("Debugger.paused", pl.wendigo.chrome.api.debugger.PausedEvent.serializer())
        connection.registerEventSerializer("Debugger.resumed", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Debugger.scriptFailedToParse", pl.wendigo.chrome.api.debugger.ScriptFailedToParseEvent.serializer())
        connection.registerEventSerializer("Debugger.scriptParsed", pl.wendigo.chrome.api.debugger.ScriptParsedEvent.serializer())
        connection.registerEventSerializer("Emulation.virtualTimeBudgetExpired", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Fetch.authRequired", pl.wendigo.chrome.api.fetch.AuthRequiredEvent.serializer())
        connection.registerEventSerializer("Fetch.requestPaused", pl.wendigo.chrome.api.fetch.RequestPausedEvent.serializer())
        connection.registerEventSerializer("HeadlessExperimental.needsBeginFramesChanged", pl.wendigo.chrome.api.headlessexperimental.NeedsBeginFramesChangedEvent.serializer())
        connection.registerEventSerializer("HeapProfiler.addHeapSnapshotChunk", pl.wendigo.chrome.api.heapprofiler.AddHeapSnapshotChunkEvent.serializer())
        connection.registerEventSerializer("HeapProfiler.heapStatsUpdate", pl.wendigo.chrome.api.heapprofiler.HeapStatsUpdateEvent.serializer())
        connection.registerEventSerializer("HeapProfiler.lastSeenObjectId", pl.wendigo.chrome.api.heapprofiler.LastSeenObjectIdEvent.serializer())
        connection.registerEventSerializer("HeapProfiler.reportHeapSnapshotProgress", pl.wendigo.chrome.api.heapprofiler.ReportHeapSnapshotProgressEvent.serializer())
        connection.registerEventSerializer("HeapProfiler.resetProfiles", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Inspector.detached", pl.wendigo.chrome.api.inspector.DetachedEvent.serializer())
        connection.registerEventSerializer("Inspector.targetCrashed", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Inspector.targetReloadedAfterCrash", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("LayerTree.layerPainted", pl.wendigo.chrome.api.layertree.LayerPaintedEvent.serializer())
        connection.registerEventSerializer("LayerTree.layerTreeDidChange", pl.wendigo.chrome.api.layertree.LayerTreeDidChangeEvent.serializer())
        connection.registerEventSerializer("Log.entryAdded", pl.wendigo.chrome.api.log.EntryAddedEvent.serializer())
        connection.registerEventSerializer("Media.playerErrorsRaised", pl.wendigo.chrome.api.media.PlayerErrorsRaisedEvent.serializer())
        connection.registerEventSerializer("Media.playerEventsAdded", pl.wendigo.chrome.api.media.PlayerEventsAddedEvent.serializer())
        connection.registerEventSerializer("Media.playerMessagesLogged", pl.wendigo.chrome.api.media.PlayerMessagesLoggedEvent.serializer())
        connection.registerEventSerializer("Media.playerPropertiesChanged", pl.wendigo.chrome.api.media.PlayerPropertiesChangedEvent.serializer())
        connection.registerEventSerializer("Media.playersCreated", pl.wendigo.chrome.api.media.PlayersCreatedEvent.serializer())
        connection.registerEventSerializer("Network.dataReceived", pl.wendigo.chrome.api.network.DataReceivedEvent.serializer())
        connection.registerEventSerializer("Network.eventSourceMessageReceived", pl.wendigo.chrome.api.network.EventSourceMessageReceivedEvent.serializer())
        connection.registerEventSerializer("Network.loadingFailed", pl.wendigo.chrome.api.network.LoadingFailedEvent.serializer())
        connection.registerEventSerializer("Network.loadingFinished", pl.wendigo.chrome.api.network.LoadingFinishedEvent.serializer())
        connection.registerEventSerializer("Network.requestIntercepted", pl.wendigo.chrome.api.network.RequestInterceptedEvent.serializer())
        connection.registerEventSerializer("Network.requestServedFromCache", pl.wendigo.chrome.api.network.RequestServedFromCacheEvent.serializer())
        connection.registerEventSerializer("Network.requestWillBeSent", pl.wendigo.chrome.api.network.RequestWillBeSentEvent.serializer())
        connection.registerEventSerializer("Network.requestWillBeSentExtraInfo", pl.wendigo.chrome.api.network.RequestWillBeSentExtraInfoEvent.serializer())
        connection.registerEventSerializer("Network.resourceChangedPriority", pl.wendigo.chrome.api.network.ResourceChangedPriorityEvent.serializer())
        connection.registerEventSerializer("Network.responseReceived", pl.wendigo.chrome.api.network.ResponseReceivedEvent.serializer())
        connection.registerEventSerializer("Network.responseReceivedExtraInfo", pl.wendigo.chrome.api.network.ResponseReceivedExtraInfoEvent.serializer())
        connection.registerEventSerializer("Network.signedExchangeReceived", pl.wendigo.chrome.api.network.SignedExchangeReceivedEvent.serializer())
        connection.registerEventSerializer("Network.trustTokenOperationDone", pl.wendigo.chrome.api.network.TrustTokenOperationDoneEvent.serializer())
        connection.registerEventSerializer("Network.webSocketClosed", pl.wendigo.chrome.api.network.WebSocketClosedEvent.serializer())
        connection.registerEventSerializer("Network.webSocketCreated", pl.wendigo.chrome.api.network.WebSocketCreatedEvent.serializer())
        connection.registerEventSerializer("Network.webSocketFrameError", pl.wendigo.chrome.api.network.WebSocketFrameErrorEvent.serializer())
        connection.registerEventSerializer("Network.webSocketFrameReceived", pl.wendigo.chrome.api.network.WebSocketFrameReceivedEvent.serializer())
        connection.registerEventSerializer("Network.webSocketFrameSent", pl.wendigo.chrome.api.network.WebSocketFrameSentEvent.serializer())
        connection.registerEventSerializer("Network.webSocketHandshakeResponseReceived", pl.wendigo.chrome.api.network.WebSocketHandshakeResponseReceivedEvent.serializer())
        connection.registerEventSerializer("Network.webSocketWillSendHandshakeRequest", pl.wendigo.chrome.api.network.WebSocketWillSendHandshakeRequestEvent.serializer())
        connection.registerEventSerializer("Network.webTransportClosed", pl.wendigo.chrome.api.network.WebTransportClosedEvent.serializer())
        connection.registerEventSerializer("Network.webTransportConnectionEstablished", pl.wendigo.chrome.api.network.WebTransportConnectionEstablishedEvent.serializer())
        connection.registerEventSerializer("Network.webTransportCreated", pl.wendigo.chrome.api.network.WebTransportCreatedEvent.serializer())
        connection.registerEventSerializer("Overlay.inspectModeCanceled", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Overlay.inspectNodeRequested", pl.wendigo.chrome.api.overlay.InspectNodeRequestedEvent.serializer())
        connection.registerEventSerializer("Overlay.nodeHighlightRequested", pl.wendigo.chrome.api.overlay.NodeHighlightRequestedEvent.serializer())
        connection.registerEventSerializer("Overlay.screenshotRequested", pl.wendigo.chrome.api.overlay.ScreenshotRequestedEvent.serializer())
        connection.registerEventSerializer("Page.compilationCacheProduced", pl.wendigo.chrome.api.page.CompilationCacheProducedEvent.serializer())
        connection.registerEventSerializer("Page.documentOpened", pl.wendigo.chrome.api.page.DocumentOpenedEvent.serializer())
        connection.registerEventSerializer("Page.domContentEventFired", pl.wendigo.chrome.api.page.DomContentEventFiredEvent.serializer())
        connection.registerEventSerializer("Page.downloadProgress", pl.wendigo.chrome.api.page.DownloadProgressEvent.serializer())
        connection.registerEventSerializer("Page.downloadWillBegin", pl.wendigo.chrome.api.page.DownloadWillBeginEvent.serializer())
        connection.registerEventSerializer("Page.fileChooserOpened", pl.wendigo.chrome.api.page.FileChooserOpenedEvent.serializer())
        connection.registerEventSerializer("Page.frameAttached", pl.wendigo.chrome.api.page.FrameAttachedEvent.serializer())
        connection.registerEventSerializer("Page.frameClearedScheduledNavigation", pl.wendigo.chrome.api.page.FrameClearedScheduledNavigationEvent.serializer())
        connection.registerEventSerializer("Page.frameDetached", pl.wendigo.chrome.api.page.FrameDetachedEvent.serializer())
        connection.registerEventSerializer("Page.frameNavigated", pl.wendigo.chrome.api.page.FrameNavigatedEvent.serializer())
        connection.registerEventSerializer("Page.frameRequestedNavigation", pl.wendigo.chrome.api.page.FrameRequestedNavigationEvent.serializer())
        connection.registerEventSerializer("Page.frameResized", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Page.frameScheduledNavigation", pl.wendigo.chrome.api.page.FrameScheduledNavigationEvent.serializer())
        connection.registerEventSerializer("Page.frameStartedLoading", pl.wendigo.chrome.api.page.FrameStartedLoadingEvent.serializer())
        connection.registerEventSerializer("Page.frameStoppedLoading", pl.wendigo.chrome.api.page.FrameStoppedLoadingEvent.serializer())
        connection.registerEventSerializer("Page.interstitialHidden", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Page.interstitialShown", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Page.javascriptDialogClosed", pl.wendigo.chrome.api.page.JavascriptDialogClosedEvent.serializer())
        connection.registerEventSerializer("Page.javascriptDialogOpening", pl.wendigo.chrome.api.page.JavascriptDialogOpeningEvent.serializer())
        connection.registerEventSerializer("Page.lifecycleEvent", pl.wendigo.chrome.api.page.LifecycleEventEvent.serializer())
        connection.registerEventSerializer("Page.loadEventFired", pl.wendigo.chrome.api.page.LoadEventFiredEvent.serializer())
        connection.registerEventSerializer("Page.navigatedWithinDocument", pl.wendigo.chrome.api.page.NavigatedWithinDocumentEvent.serializer())
        connection.registerEventSerializer("Page.screencastFrame", pl.wendigo.chrome.api.page.ScreencastFrameEvent.serializer())
        connection.registerEventSerializer("Page.screencastVisibilityChanged", pl.wendigo.chrome.api.page.ScreencastVisibilityChangedEvent.serializer())
        connection.registerEventSerializer("Page.windowOpen", pl.wendigo.chrome.api.page.WindowOpenEvent.serializer())
        connection.registerEventSerializer("Performance.metrics", pl.wendigo.chrome.api.performance.MetricsEvent.serializer())
        connection.registerEventSerializer("PerformanceTimeline.timelineEventAdded", pl.wendigo.chrome.api.performancetimeline.TimelineEventAddedEvent.serializer())
        connection.registerEventSerializer("Profiler.consoleProfileFinished", pl.wendigo.chrome.api.profiler.ConsoleProfileFinishedEvent.serializer())
        connection.registerEventSerializer("Profiler.consoleProfileStarted", pl.wendigo.chrome.api.profiler.ConsoleProfileStartedEvent.serializer())
        connection.registerEventSerializer("Profiler.preciseCoverageDeltaUpdate", pl.wendigo.chrome.api.profiler.PreciseCoverageDeltaUpdateEvent.serializer())
        connection.registerEventSerializer("Runtime.bindingCalled", pl.wendigo.chrome.api.runtime.BindingCalledEvent.serializer())
        connection.registerEventSerializer("Runtime.consoleAPICalled", pl.wendigo.chrome.api.runtime.ConsoleAPICalledEvent.serializer())
        connection.registerEventSerializer("Runtime.exceptionRevoked", pl.wendigo.chrome.api.runtime.ExceptionRevokedEvent.serializer())
        connection.registerEventSerializer("Runtime.exceptionThrown", pl.wendigo.chrome.api.runtime.ExceptionThrownEvent.serializer())
        connection.registerEventSerializer("Runtime.executionContextCreated", pl.wendigo.chrome.api.runtime.ExecutionContextCreatedEvent.serializer())
        connection.registerEventSerializer("Runtime.executionContextDestroyed", pl.wendigo.chrome.api.runtime.ExecutionContextDestroyedEvent.serializer())
        connection.registerEventSerializer("Runtime.executionContextsCleared", pl.wendigo.chrome.protocol.Event.serializer())
        connection.registerEventSerializer("Runtime.inspectRequested", pl.wendigo.chrome.api.runtime.InspectRequestedEvent.serializer())
        connection.registerEventSerializer("Security.certificateError", pl.wendigo.chrome.api.security.CertificateErrorEvent.serializer())
        connection.registerEventSerializer("Security.securityStateChanged", pl.wendigo.chrome.api.security.SecurityStateChangedEvent.serializer())
        connection.registerEventSerializer("Security.visibleSecurityStateChanged", pl.wendigo.chrome.api.security.VisibleSecurityStateChangedEvent.serializer())
        connection.registerEventSerializer("ServiceWorker.workerErrorReported", pl.wendigo.chrome.api.serviceworker.WorkerErrorReportedEvent.serializer())
        connection.registerEventSerializer("ServiceWorker.workerRegistrationUpdated", pl.wendigo.chrome.api.serviceworker.WorkerRegistrationUpdatedEvent.serializer())
        connection.registerEventSerializer("ServiceWorker.workerVersionUpdated", pl.wendigo.chrome.api.serviceworker.WorkerVersionUpdatedEvent.serializer())
        connection.registerEventSerializer("Storage.cacheStorageContentUpdated", pl.wendigo.chrome.api.storage.CacheStorageContentUpdatedEvent.serializer())
        connection.registerEventSerializer("Storage.cacheStorageListUpdated", pl.wendigo.chrome.api.storage.CacheStorageListUpdatedEvent.serializer())
        connection.registerEventSerializer("Storage.indexedDBContentUpdated", pl.wendigo.chrome.api.storage.IndexedDBContentUpdatedEvent.serializer())
        connection.registerEventSerializer("Storage.indexedDBListUpdated", pl.wendigo.chrome.api.storage.IndexedDBListUpdatedEvent.serializer())
        connection.registerEventSerializer("Target.attachedToTarget", pl.wendigo.chrome.api.target.AttachedToTargetEvent.serializer())
        connection.registerEventSerializer("Target.detachedFromTarget", pl.wendigo.chrome.api.target.DetachedFromTargetEvent.serializer())
        connection.registerEventSerializer("Target.receivedMessageFromTarget", pl.wendigo.chrome.api.target.ReceivedMessageFromTargetEvent.serializer())
        connection.registerEventSerializer("Target.targetCrashed", pl.wendigo.chrome.api.target.TargetCrashedEvent.serializer())
        connection.registerEventSerializer("Target.targetCreated", pl.wendigo.chrome.api.target.TargetCreatedEvent.serializer())
        connection.registerEventSerializer("Target.targetDestroyed", pl.wendigo.chrome.api.target.TargetDestroyedEvent.serializer())
        connection.registerEventSerializer("Target.targetInfoChanged", pl.wendigo.chrome.api.target.TargetInfoChangedEvent.serializer())
        connection.registerEventSerializer("Tethering.accepted", pl.wendigo.chrome.api.tethering.AcceptedEvent.serializer())
        connection.registerEventSerializer("Tracing.bufferUsage", pl.wendigo.chrome.api.tracing.BufferUsageEvent.serializer())
        connection.registerEventSerializer("Tracing.dataCollected", pl.wendigo.chrome.api.tracing.DataCollectedEvent.serializer())
        connection.registerEventSerializer("Tracing.tracingComplete", pl.wendigo.chrome.api.tracing.TracingCompleteEvent.serializer())
        connection.registerEventSerializer("WebAudio.audioListenerCreated", pl.wendigo.chrome.api.webaudio.AudioListenerCreatedEvent.serializer())
        connection.registerEventSerializer("WebAudio.audioListenerWillBeDestroyed", pl.wendigo.chrome.api.webaudio.AudioListenerWillBeDestroyedEvent.serializer())
        connection.registerEventSerializer("WebAudio.audioNodeCreated", pl.wendigo.chrome.api.webaudio.AudioNodeCreatedEvent.serializer())
        connection.registerEventSerializer("WebAudio.audioNodeWillBeDestroyed", pl.wendigo.chrome.api.webaudio.AudioNodeWillBeDestroyedEvent.serializer())
        connection.registerEventSerializer("WebAudio.audioParamCreated", pl.wendigo.chrome.api.webaudio.AudioParamCreatedEvent.serializer())
        connection.registerEventSerializer("WebAudio.audioParamWillBeDestroyed", pl.wendigo.chrome.api.webaudio.AudioParamWillBeDestroyedEvent.serializer())
        connection.registerEventSerializer("WebAudio.contextChanged", pl.wendigo.chrome.api.webaudio.ContextChangedEvent.serializer())
        connection.registerEventSerializer("WebAudio.contextCreated", pl.wendigo.chrome.api.webaudio.ContextCreatedEvent.serializer())
        connection.registerEventSerializer("WebAudio.contextWillBeDestroyed", pl.wendigo.chrome.api.webaudio.ContextWillBeDestroyedEvent.serializer())
        connection.registerEventSerializer("WebAudio.nodeParamConnected", pl.wendigo.chrome.api.webaudio.NodeParamConnectedEvent.serializer())
        connection.registerEventSerializer("WebAudio.nodeParamDisconnected", pl.wendigo.chrome.api.webaudio.NodeParamDisconnectedEvent.serializer())
        connection.registerEventSerializer("WebAudio.nodesConnected", pl.wendigo.chrome.api.webaudio.NodesConnectedEvent.serializer())
        connection.registerEventSerializer("WebAudio.nodesDisconnected", pl.wendigo.chrome.api.webaudio.NodesDisconnectedEvent.serializer())
    }

    /**
     * This domain is deprecated - use Runtime or Log instead.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Console](Domain Console documentation)
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated - use Runtime or Log instead.")
    val Console: ConsoleOperations by lazy {
        ConsoleOperations(connection)
    }

    /**
     * Debugger domain exposes JavaScript debugging capabilities. It allows setting and removing
breakpoints, stepping through execution, exploring stack traces, etc.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Debugger](Domain Debugger documentation)
     */
    val Debugger: DebuggerOperations by lazy {
        DebuggerOperations(connection)
    }

    /**
     * Lazily returns [HeapProfilerOperations] domain object allowing to perform operations on [HeapProfiler](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler](Domain HeapProfiler documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val HeapProfiler: HeapProfilerOperations by lazy {
        HeapProfilerOperations(connection)
    }

    /**
     * Lazily returns [ProfilerOperations] domain object allowing to perform operations on [Profiler](https://chromedevtools.github.io/devtools-protocol/tot/Profiler) protocol domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Profiler](Domain Profiler documentation)
     */
    val Profiler: ProfilerOperations by lazy {
        ProfilerOperations(connection)
    }

    /**
     * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects.
Evaluation results are returned as mirror object that expose object type, string representation
and unique identifier that can be used for further object reference. Original objects are
maintained in memory unless they are either explicitly released or are released along with the
other objects in their object group.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Runtime](Domain Runtime documentation)
     */
    val Runtime: RuntimeOperations by lazy {
        RuntimeOperations(connection)
    }

    /**
     * This domain is deprecated.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Schema](Domain Schema documentation)
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated.")
    val Schema: SchemaOperations by lazy {
        SchemaOperations(connection)
    }

    /**
     * Lazily returns [AccessibilityOperations] domain object allowing to perform operations on [Accessibility](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Accessibility](Domain Accessibility documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Accessibility: AccessibilityOperations by lazy {
        AccessibilityOperations(connection)
    }

    /**
     * Lazily returns [AnimationOperations] domain object allowing to perform operations on [Animation](https://chromedevtools.github.io/devtools-protocol/tot/Animation) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Animation](Domain Animation documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Animation: AnimationOperations by lazy {
        AnimationOperations(connection)
    }

    /**
     * Lazily returns [ApplicationCacheOperations] domain object allowing to perform operations on [ApplicationCache](https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache](Domain ApplicationCache documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val ApplicationCache: ApplicationCacheOperations by lazy {
        ApplicationCacheOperations(connection)
    }

    /**
     * Audits domain allows investigation of page violations and possible improvements.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Audits](Domain Audits documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Audits: AuditsOperations by lazy {
        AuditsOperations(connection)
    }

    /**
     * Defines events for background web platform features.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService](Domain BackgroundService documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val BackgroundService: BackgroundServiceOperations by lazy {
        BackgroundServiceOperations(connection)
    }

    /**
     * The Browser domain defines methods and events for browser managing.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Browser](Domain Browser documentation)
     */
    val Browser: BrowserOperations by lazy {
        BrowserOperations(connection)
    }

    /**
     * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles)
have an associated `id` used in subsequent operations on the related object. Each object type has
a specific `id` structure, and those are not interchangeable between objects of different kinds.
CSS objects can be loaded using the `get*ForNode()` calls (which accept a DOM node id). A client
can also keep track of stylesheets via the `styleSheetAdded`/`styleSheetRemoved` events and
subsequently load the required stylesheet contents using the `getStyleSheet[Text]()` methods.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/CSS](Domain CSS documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val CSS: CSSOperations by lazy {
        CSSOperations(connection)
    }

    /**
     * Lazily returns [CacheStorageOperations] domain object allowing to perform operations on [CacheStorage](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage](Domain CacheStorage documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val CacheStorage: CacheStorageOperations by lazy {
        CacheStorageOperations(connection)
    }

    /**
     * A domain for interacting with Cast, Presentation API, and Remote Playback API
functionalities.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Cast](Domain Cast documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Cast: CastOperations by lazy {
        CastOperations(connection)
    }

    /**
     * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object
that has an `id`. This `id` can be used to get additional information on the Node, resolve it into
the JavaScript object wrapper, etc. It is important that client receives DOM events only for the
nodes that are known to the client. Backend keeps track of the nodes that were sent to the client
and never sends the same node twice. It is client's responsibility to collect information about
the nodes that were sent to the client.<p>Note that `iframe` owner elements will return
corresponding document elements as their child nodes.</p>
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOM](Domain DOM documentation)
     */
    val DOM: DOMOperations by lazy {
        DOMOperations(connection)
    }

    /**
     * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
execution will stop on these operations as if there was a regular breakpoint set.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger](Domain DOMDebugger documentation)
     */
    val DOMDebugger: DOMDebuggerOperations by lazy {
        DOMDebuggerOperations(connection)
    }

    /**
     * This domain facilitates obtaining document snapshots with DOM, layout, and style information.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot](Domain DOMSnapshot documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val DOMSnapshot: DOMSnapshotOperations by lazy {
        DOMSnapshotOperations(connection)
    }

    /**
     * Query and modify DOM storage.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage](Domain DOMStorage documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val DOMStorage: DOMStorageOperations by lazy {
        DOMStorageOperations(connection)
    }

    /**
     * Lazily returns [DatabaseOperations] domain object allowing to perform operations on [Database](https://chromedevtools.github.io/devtools-protocol/tot/Database) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Database](Domain Database documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Database: DatabaseOperations by lazy {
        DatabaseOperations(connection)
    }

    /**
     * Lazily returns [DeviceOrientationOperations] domain object allowing to perform operations on [DeviceOrientation](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation](Domain DeviceOrientation documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val DeviceOrientation: DeviceOrientationOperations by lazy {
        DeviceOrientationOperations(connection)
    }

    /**
     * This domain emulates different environments for the page.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Emulation](Domain Emulation documentation)
     */
    val Emulation: EmulationOperations by lazy {
        EmulationOperations(connection)
    }

    /**
     * This domain provides experimental commands only supported in headless mode.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental](Domain HeadlessExperimental documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val HeadlessExperimental: HeadlessExperimentalOperations by lazy {
        HeadlessExperimentalOperations(connection)
    }

    /**
     * Input/Output operations for streams produced by DevTools.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/IO](Domain IO documentation)
     */
    val IO: IOOperations by lazy {
        IOOperations(connection)
    }

    /**
     * Lazily returns [IndexedDBOperations] domain object allowing to perform operations on [IndexedDB](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB](Domain IndexedDB documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val IndexedDB: IndexedDBOperations by lazy {
        IndexedDBOperations(connection)
    }

    /**
     * Lazily returns [InputOperations] domain object allowing to perform operations on [Input](https://chromedevtools.github.io/devtools-protocol/tot/Input) protocol domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Input](Domain Input documentation)
     */
    val Input: InputOperations by lazy {
        InputOperations(connection)
    }

    /**
     * Lazily returns [InspectorOperations] domain object allowing to perform operations on [Inspector](https://chromedevtools.github.io/devtools-protocol/tot/Inspector) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Inspector](Domain Inspector documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Inspector: InspectorOperations by lazy {
        InspectorOperations(connection)
    }

    /**
     * Lazily returns [LayerTreeOperations] domain object allowing to perform operations on [LayerTree](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/LayerTree](Domain LayerTree documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val LayerTree: LayerTreeOperations by lazy {
        LayerTreeOperations(connection)
    }

    /**
     * Provides access to log entries.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Log](Domain Log documentation)
     */
    val Log: LogOperations by lazy {
        LogOperations(connection)
    }

    /**
     * Lazily returns [MemoryOperations] domain object allowing to perform operations on [Memory](https://chromedevtools.github.io/devtools-protocol/tot/Memory) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Memory](Domain Memory documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Memory: MemoryOperations by lazy {
        MemoryOperations(connection)
    }

    /**
     * Network domain allows tracking network activities of the page. It exposes information about http,
file, data and other requests and responses, their headers, bodies, timing, etc.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Network](Domain Network documentation)
     */
    val Network: NetworkOperations by lazy {
        NetworkOperations(connection)
    }

    /**
     * This domain provides various functionality related to drawing atop the inspected page.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Overlay](Domain Overlay documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Overlay: OverlayOperations by lazy {
        OverlayOperations(connection)
    }

    /**
     * Actions and events related to the inspected page belong to the page domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Page](Domain Page documentation)
     */
    val Page: PageOperations by lazy {
        PageOperations(connection)
    }

    /**
     * Lazily returns [PerformanceOperations] domain object allowing to perform operations on [Performance](https://chromedevtools.github.io/devtools-protocol/tot/Performance) protocol domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Performance](Domain Performance documentation)
     */
    val Performance: PerformanceOperations by lazy {
        PerformanceOperations(connection)
    }

    /**
     * Reporting of performance timeline events, as specified in
https://w3c.github.io/performance-timeline/#dom-performanceobserver.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline](Domain PerformanceTimeline documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val PerformanceTimeline: PerformanceTimelineOperations by lazy {
        PerformanceTimelineOperations(connection)
    }

    /**
     * Security
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Security](Domain Security documentation)
     */
    val Security: SecurityOperations by lazy {
        SecurityOperations(connection)
    }

    /**
     * Lazily returns [ServiceWorkerOperations] domain object allowing to perform operations on [ServiceWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker](Domain ServiceWorker documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val ServiceWorker: ServiceWorkerOperations by lazy {
        ServiceWorkerOperations(connection)
    }

    /**
     * Lazily returns [StorageOperations] domain object allowing to perform operations on [Storage](https://chromedevtools.github.io/devtools-protocol/tot/Storage) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Storage](Domain Storage documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Storage: StorageOperations by lazy {
        StorageOperations(connection)
    }

    /**
     * The SystemInfo domain defines methods and events for querying low-level system information.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo](Domain SystemInfo documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val SystemInfo: SystemInfoOperations by lazy {
        SystemInfoOperations(connection)
    }

    /**
     * Supports additional targets discovery and allows to attach to them.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Target](Domain Target documentation)
     */
    val Target: TargetOperations by lazy {
        TargetOperations(connection)
    }

    /**
     * The Tethering domain defines methods and events for browser port binding.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Tethering](Domain Tethering documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Tethering: TetheringOperations by lazy {
        TetheringOperations(connection)
    }

    /**
     * Lazily returns [TracingOperations] domain object allowing to perform operations on [Tracing](https://chromedevtools.github.io/devtools-protocol/tot/Tracing) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Tracing](Domain Tracing documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Tracing: TracingOperations by lazy {
        TracingOperations(connection)
    }

    /**
     * A domain for letting clients substitute browser's network layer with client code.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Fetch](Domain Fetch documentation)
     */
    val Fetch: FetchOperations by lazy {
        FetchOperations(connection)
    }

    /**
     * This domain allows inspection of Web Audio API.
https://webaudio.github.io/web-audio-api/
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/WebAudio](Domain WebAudio documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val WebAudio: WebAudioOperations by lazy {
        WebAudioOperations(connection)
    }

    /**
     * This domain allows configuring virtual authenticators to test the WebAuthn
API.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn](Domain WebAuthn documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val WebAuthn: WebAuthnOperations by lazy {
        WebAuthnOperations(connection)
    }

    /**
     * This domain allows detailed inspection of media elements
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Media](Domain Media documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Media: MediaOperations by lazy {
        MediaOperations(connection)
    }

    /**
     * Returns [Flowable] capturing all events.
     */
    fun Events(): Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents()
    }

    /**
     * Closes target.
     */
    override fun close() {
        return connection.close()
    }
}
