package pl.wendigo.chrome

import io.reactivex.Flowable
import java.io.Closeable
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
        connection.addEventMapping("Animation.animationCanceled", pl.wendigo.chrome.api.animation.AnimationCanceledEvent::class.java)
        connection.addEventMapping("Animation.animationCreated", pl.wendigo.chrome.api.animation.AnimationCreatedEvent::class.java)
        connection.addEventMapping("Animation.animationStarted", pl.wendigo.chrome.api.animation.AnimationStartedEvent::class.java)
        connection.addEventMapping("ApplicationCache.applicationCacheStatusUpdated", pl.wendigo.chrome.api.applicationcache.ApplicationCacheStatusUpdatedEvent::class.java)
        connection.addEventMapping("ApplicationCache.networkStateUpdated", pl.wendigo.chrome.api.applicationcache.NetworkStateUpdatedEvent::class.java)
        connection.addEventMapping("BackgroundService.backgroundServiceEventReceived", pl.wendigo.chrome.api.backgroundservice.BackgroundServiceEventReceivedEvent::class.java)
        connection.addEventMapping("BackgroundService.recordingStateChanged", pl.wendigo.chrome.api.backgroundservice.RecordingStateChangedEvent::class.java)
        connection.addEventMapping("CSS.fontsUpdated", pl.wendigo.chrome.api.css.FontsUpdatedEvent::class.java)
        connection.addEventMapping("CSS.mediaQueryResultChanged", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("CSS.styleSheetAdded", pl.wendigo.chrome.api.css.StyleSheetAddedEvent::class.java)
        connection.addEventMapping("CSS.styleSheetChanged", pl.wendigo.chrome.api.css.StyleSheetChangedEvent::class.java)
        connection.addEventMapping("CSS.styleSheetRemoved", pl.wendigo.chrome.api.css.StyleSheetRemovedEvent::class.java)
        connection.addEventMapping("Cast.issueUpdated", pl.wendigo.chrome.api.cast.IssueUpdatedEvent::class.java)
        connection.addEventMapping("Cast.sinksUpdated", pl.wendigo.chrome.api.cast.SinksUpdatedEvent::class.java)
        connection.addEventMapping("Console.messageAdded", pl.wendigo.chrome.api.console.MessageAddedEvent::class.java)
        connection.addEventMapping("DOM.attributeModified", pl.wendigo.chrome.api.dom.AttributeModifiedEvent::class.java)
        connection.addEventMapping("DOM.attributeRemoved", pl.wendigo.chrome.api.dom.AttributeRemovedEvent::class.java)
        connection.addEventMapping("DOM.characterDataModified", pl.wendigo.chrome.api.dom.CharacterDataModifiedEvent::class.java)
        connection.addEventMapping("DOM.childNodeCountUpdated", pl.wendigo.chrome.api.dom.ChildNodeCountUpdatedEvent::class.java)
        connection.addEventMapping("DOM.childNodeInserted", pl.wendigo.chrome.api.dom.ChildNodeInsertedEvent::class.java)
        connection.addEventMapping("DOM.childNodeRemoved", pl.wendigo.chrome.api.dom.ChildNodeRemovedEvent::class.java)
        connection.addEventMapping("DOM.distributedNodesUpdated", pl.wendigo.chrome.api.dom.DistributedNodesUpdatedEvent::class.java)
        connection.addEventMapping("DOM.documentUpdated", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("DOM.inlineStyleInvalidated", pl.wendigo.chrome.api.dom.InlineStyleInvalidatedEvent::class.java)
        connection.addEventMapping("DOM.pseudoElementAdded", pl.wendigo.chrome.api.dom.PseudoElementAddedEvent::class.java)
        connection.addEventMapping("DOM.pseudoElementRemoved", pl.wendigo.chrome.api.dom.PseudoElementRemovedEvent::class.java)
        connection.addEventMapping("DOM.setChildNodes", pl.wendigo.chrome.api.dom.SetChildNodesEvent::class.java)
        connection.addEventMapping("DOM.shadowRootPopped", pl.wendigo.chrome.api.dom.ShadowRootPoppedEvent::class.java)
        connection.addEventMapping("DOM.shadowRootPushed", pl.wendigo.chrome.api.dom.ShadowRootPushedEvent::class.java)
        connection.addEventMapping("DOMStorage.domStorageItemAdded", pl.wendigo.chrome.api.domstorage.DomStorageItemAddedEvent::class.java)
        connection.addEventMapping("DOMStorage.domStorageItemRemoved", pl.wendigo.chrome.api.domstorage.DomStorageItemRemovedEvent::class.java)
        connection.addEventMapping("DOMStorage.domStorageItemUpdated", pl.wendigo.chrome.api.domstorage.DomStorageItemUpdatedEvent::class.java)
        connection.addEventMapping("DOMStorage.domStorageItemsCleared", pl.wendigo.chrome.api.domstorage.DomStorageItemsClearedEvent::class.java)
        connection.addEventMapping("Database.addDatabase", pl.wendigo.chrome.api.database.AddDatabaseEvent::class.java)
        connection.addEventMapping("Debugger.breakpointResolved", pl.wendigo.chrome.api.debugger.BreakpointResolvedEvent::class.java)
        connection.addEventMapping("Debugger.paused", pl.wendigo.chrome.api.debugger.PausedEvent::class.java)
        connection.addEventMapping("Debugger.resumed", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Debugger.scriptFailedToParse", pl.wendigo.chrome.api.debugger.ScriptFailedToParseEvent::class.java)
        connection.addEventMapping("Debugger.scriptParsed", pl.wendigo.chrome.api.debugger.ScriptParsedEvent::class.java)
        connection.addEventMapping("Emulation.virtualTimeBudgetExpired", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Fetch.authRequired", pl.wendigo.chrome.api.fetch.AuthRequiredEvent::class.java)
        connection.addEventMapping("Fetch.requestPaused", pl.wendigo.chrome.api.fetch.RequestPausedEvent::class.java)
        connection.addEventMapping("HeadlessExperimental.needsBeginFramesChanged", pl.wendigo.chrome.api.headlessexperimental.NeedsBeginFramesChangedEvent::class.java)
        connection.addEventMapping("HeapProfiler.addHeapSnapshotChunk", pl.wendigo.chrome.api.heapprofiler.AddHeapSnapshotChunkEvent::class.java)
        connection.addEventMapping("HeapProfiler.heapStatsUpdate", pl.wendigo.chrome.api.heapprofiler.HeapStatsUpdateEvent::class.java)
        connection.addEventMapping("HeapProfiler.lastSeenObjectId", pl.wendigo.chrome.api.heapprofiler.LastSeenObjectIdEvent::class.java)
        connection.addEventMapping("HeapProfiler.reportHeapSnapshotProgress", pl.wendigo.chrome.api.heapprofiler.ReportHeapSnapshotProgressEvent::class.java)
        connection.addEventMapping("HeapProfiler.resetProfiles", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Inspector.detached", pl.wendigo.chrome.api.inspector.DetachedEvent::class.java)
        connection.addEventMapping("Inspector.targetCrashed", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Inspector.targetReloadedAfterCrash", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("LayerTree.layerPainted", pl.wendigo.chrome.api.layertree.LayerPaintedEvent::class.java)
        connection.addEventMapping("LayerTree.layerTreeDidChange", pl.wendigo.chrome.api.layertree.LayerTreeDidChangeEvent::class.java)
        connection.addEventMapping("Log.entryAdded", pl.wendigo.chrome.api.log.EntryAddedEvent::class.java)
        connection.addEventMapping("Media.playerEventsAdded", pl.wendigo.chrome.api.media.PlayerEventsAddedEvent::class.java)
        connection.addEventMapping("Media.playerPropertiesChanged", pl.wendigo.chrome.api.media.PlayerPropertiesChangedEvent::class.java)
        connection.addEventMapping("Media.playersCreated", pl.wendigo.chrome.api.media.PlayersCreatedEvent::class.java)
        connection.addEventMapping("Network.dataReceived", pl.wendigo.chrome.api.network.DataReceivedEvent::class.java)
        connection.addEventMapping("Network.eventSourceMessageReceived", pl.wendigo.chrome.api.network.EventSourceMessageReceivedEvent::class.java)
        connection.addEventMapping("Network.loadingFailed", pl.wendigo.chrome.api.network.LoadingFailedEvent::class.java)
        connection.addEventMapping("Network.loadingFinished", pl.wendigo.chrome.api.network.LoadingFinishedEvent::class.java)
        connection.addEventMapping("Network.requestIntercepted", pl.wendigo.chrome.api.network.RequestInterceptedEvent::class.java)
        connection.addEventMapping("Network.requestServedFromCache", pl.wendigo.chrome.api.network.RequestServedFromCacheEvent::class.java)
        connection.addEventMapping("Network.requestWillBeSent", pl.wendigo.chrome.api.network.RequestWillBeSentEvent::class.java)
        connection.addEventMapping("Network.requestWillBeSentExtraInfo", pl.wendigo.chrome.api.network.RequestWillBeSentExtraInfoEvent::class.java)
        connection.addEventMapping("Network.resourceChangedPriority", pl.wendigo.chrome.api.network.ResourceChangedPriorityEvent::class.java)
        connection.addEventMapping("Network.responseReceived", pl.wendigo.chrome.api.network.ResponseReceivedEvent::class.java)
        connection.addEventMapping("Network.responseReceivedExtraInfo", pl.wendigo.chrome.api.network.ResponseReceivedExtraInfoEvent::class.java)
        connection.addEventMapping("Network.signedExchangeReceived", pl.wendigo.chrome.api.network.SignedExchangeReceivedEvent::class.java)
        connection.addEventMapping("Network.webSocketClosed", pl.wendigo.chrome.api.network.WebSocketClosedEvent::class.java)
        connection.addEventMapping("Network.webSocketCreated", pl.wendigo.chrome.api.network.WebSocketCreatedEvent::class.java)
        connection.addEventMapping("Network.webSocketFrameError", pl.wendigo.chrome.api.network.WebSocketFrameErrorEvent::class.java)
        connection.addEventMapping("Network.webSocketFrameReceived", pl.wendigo.chrome.api.network.WebSocketFrameReceivedEvent::class.java)
        connection.addEventMapping("Network.webSocketFrameSent", pl.wendigo.chrome.api.network.WebSocketFrameSentEvent::class.java)
        connection.addEventMapping("Network.webSocketHandshakeResponseReceived", pl.wendigo.chrome.api.network.WebSocketHandshakeResponseReceivedEvent::class.java)
        connection.addEventMapping("Network.webSocketWillSendHandshakeRequest", pl.wendigo.chrome.api.network.WebSocketWillSendHandshakeRequestEvent::class.java)
        connection.addEventMapping("Overlay.inspectModeCanceled", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Overlay.inspectNodeRequested", pl.wendigo.chrome.api.overlay.InspectNodeRequestedEvent::class.java)
        connection.addEventMapping("Overlay.nodeHighlightRequested", pl.wendigo.chrome.api.overlay.NodeHighlightRequestedEvent::class.java)
        connection.addEventMapping("Overlay.screenshotRequested", pl.wendigo.chrome.api.overlay.ScreenshotRequestedEvent::class.java)
        connection.addEventMapping("Page.compilationCacheProduced", pl.wendigo.chrome.api.page.CompilationCacheProducedEvent::class.java)
        connection.addEventMapping("Page.domContentEventFired", pl.wendigo.chrome.api.page.DomContentEventFiredEvent::class.java)
        connection.addEventMapping("Page.downloadWillBegin", pl.wendigo.chrome.api.page.DownloadWillBeginEvent::class.java)
        connection.addEventMapping("Page.fileChooserOpened", pl.wendigo.chrome.api.page.FileChooserOpenedEvent::class.java)
        connection.addEventMapping("Page.frameAttached", pl.wendigo.chrome.api.page.FrameAttachedEvent::class.java)
        connection.addEventMapping("Page.frameClearedScheduledNavigation", pl.wendigo.chrome.api.page.FrameClearedScheduledNavigationEvent::class.java)
        connection.addEventMapping("Page.frameDetached", pl.wendigo.chrome.api.page.FrameDetachedEvent::class.java)
        connection.addEventMapping("Page.frameNavigated", pl.wendigo.chrome.api.page.FrameNavigatedEvent::class.java)
        connection.addEventMapping("Page.frameRequestedNavigation", pl.wendigo.chrome.api.page.FrameRequestedNavigationEvent::class.java)
        connection.addEventMapping("Page.frameResized", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Page.frameScheduledNavigation", pl.wendigo.chrome.api.page.FrameScheduledNavigationEvent::class.java)
        connection.addEventMapping("Page.frameStartedLoading", pl.wendigo.chrome.api.page.FrameStartedLoadingEvent::class.java)
        connection.addEventMapping("Page.frameStoppedLoading", pl.wendigo.chrome.api.page.FrameStoppedLoadingEvent::class.java)
        connection.addEventMapping("Page.interstitialHidden", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Page.interstitialShown", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Page.javascriptDialogClosed", pl.wendigo.chrome.api.page.JavascriptDialogClosedEvent::class.java)
        connection.addEventMapping("Page.javascriptDialogOpening", pl.wendigo.chrome.api.page.JavascriptDialogOpeningEvent::class.java)
        connection.addEventMapping("Page.lifecycleEvent", pl.wendigo.chrome.api.page.LifecycleEventEvent::class.java)
        connection.addEventMapping("Page.loadEventFired", pl.wendigo.chrome.api.page.LoadEventFiredEvent::class.java)
        connection.addEventMapping("Page.navigatedWithinDocument", pl.wendigo.chrome.api.page.NavigatedWithinDocumentEvent::class.java)
        connection.addEventMapping("Page.screencastFrame", pl.wendigo.chrome.api.page.ScreencastFrameEvent::class.java)
        connection.addEventMapping("Page.screencastVisibilityChanged", pl.wendigo.chrome.api.page.ScreencastVisibilityChangedEvent::class.java)
        connection.addEventMapping("Page.windowOpen", pl.wendigo.chrome.api.page.WindowOpenEvent::class.java)
        connection.addEventMapping("Performance.metrics", pl.wendigo.chrome.api.performance.MetricsEvent::class.java)
        connection.addEventMapping("Profiler.consoleProfileFinished", pl.wendigo.chrome.api.profiler.ConsoleProfileFinishedEvent::class.java)
        connection.addEventMapping("Profiler.consoleProfileStarted", pl.wendigo.chrome.api.profiler.ConsoleProfileStartedEvent::class.java)
        connection.addEventMapping("Runtime.bindingCalled", pl.wendigo.chrome.api.runtime.BindingCalledEvent::class.java)
        connection.addEventMapping("Runtime.consoleAPICalled", pl.wendigo.chrome.api.runtime.ConsoleAPICalledEvent::class.java)
        connection.addEventMapping("Runtime.exceptionRevoked", pl.wendigo.chrome.api.runtime.ExceptionRevokedEvent::class.java)
        connection.addEventMapping("Runtime.exceptionThrown", pl.wendigo.chrome.api.runtime.ExceptionThrownEvent::class.java)
        connection.addEventMapping("Runtime.executionContextCreated", pl.wendigo.chrome.api.runtime.ExecutionContextCreatedEvent::class.java)
        connection.addEventMapping("Runtime.executionContextDestroyed", pl.wendigo.chrome.api.runtime.ExecutionContextDestroyedEvent::class.java)
        connection.addEventMapping("Runtime.executionContextsCleared", pl.wendigo.chrome.protocol.Event::class.java)
        connection.addEventMapping("Runtime.inspectRequested", pl.wendigo.chrome.api.runtime.InspectRequestedEvent::class.java)
        connection.addEventMapping("Security.certificateError", pl.wendigo.chrome.api.security.CertificateErrorEvent::class.java)
        connection.addEventMapping("Security.securityStateChanged", pl.wendigo.chrome.api.security.SecurityStateChangedEvent::class.java)
        connection.addEventMapping("Security.visibleSecurityStateChanged", pl.wendigo.chrome.api.security.VisibleSecurityStateChangedEvent::class.java)
        connection.addEventMapping("ServiceWorker.workerErrorReported", pl.wendigo.chrome.api.serviceworker.WorkerErrorReportedEvent::class.java)
        connection.addEventMapping("ServiceWorker.workerRegistrationUpdated", pl.wendigo.chrome.api.serviceworker.WorkerRegistrationUpdatedEvent::class.java)
        connection.addEventMapping("ServiceWorker.workerVersionUpdated", pl.wendigo.chrome.api.serviceworker.WorkerVersionUpdatedEvent::class.java)
        connection.addEventMapping("Storage.cacheStorageContentUpdated", pl.wendigo.chrome.api.storage.CacheStorageContentUpdatedEvent::class.java)
        connection.addEventMapping("Storage.cacheStorageListUpdated", pl.wendigo.chrome.api.storage.CacheStorageListUpdatedEvent::class.java)
        connection.addEventMapping("Storage.indexedDBContentUpdated", pl.wendigo.chrome.api.storage.IndexedDBContentUpdatedEvent::class.java)
        connection.addEventMapping("Storage.indexedDBListUpdated", pl.wendigo.chrome.api.storage.IndexedDBListUpdatedEvent::class.java)
        connection.addEventMapping("Target.attachedToTarget", pl.wendigo.chrome.api.target.AttachedToTargetEvent::class.java)
        connection.addEventMapping("Target.detachedFromTarget", pl.wendigo.chrome.api.target.DetachedFromTargetEvent::class.java)
        connection.addEventMapping("Target.receivedMessageFromTarget", pl.wendigo.chrome.api.target.ReceivedMessageFromTargetEvent::class.java)
        connection.addEventMapping("Target.targetCrashed", pl.wendigo.chrome.api.target.TargetCrashedEvent::class.java)
        connection.addEventMapping("Target.targetCreated", pl.wendigo.chrome.api.target.TargetCreatedEvent::class.java)
        connection.addEventMapping("Target.targetDestroyed", pl.wendigo.chrome.api.target.TargetDestroyedEvent::class.java)
        connection.addEventMapping("Target.targetInfoChanged", pl.wendigo.chrome.api.target.TargetInfoChangedEvent::class.java)
        connection.addEventMapping("Tethering.accepted", pl.wendigo.chrome.api.tethering.AcceptedEvent::class.java)
        connection.addEventMapping("Tracing.bufferUsage", pl.wendigo.chrome.api.tracing.BufferUsageEvent::class.java)
        connection.addEventMapping("Tracing.dataCollected", pl.wendigo.chrome.api.tracing.DataCollectedEvent::class.java)
        connection.addEventMapping("Tracing.tracingComplete", pl.wendigo.chrome.api.tracing.TracingCompleteEvent::class.java)
        connection.addEventMapping("WebAudio.audioListenerCreated", pl.wendigo.chrome.api.webaudio.AudioListenerCreatedEvent::class.java)
        connection.addEventMapping("WebAudio.audioListenerWillBeDestroyed", pl.wendigo.chrome.api.webaudio.AudioListenerWillBeDestroyedEvent::class.java)
        connection.addEventMapping("WebAudio.audioNodeCreated", pl.wendigo.chrome.api.webaudio.AudioNodeCreatedEvent::class.java)
        connection.addEventMapping("WebAudio.audioNodeWillBeDestroyed", pl.wendigo.chrome.api.webaudio.AudioNodeWillBeDestroyedEvent::class.java)
        connection.addEventMapping("WebAudio.audioParamCreated", pl.wendigo.chrome.api.webaudio.AudioParamCreatedEvent::class.java)
        connection.addEventMapping("WebAudio.audioParamWillBeDestroyed", pl.wendigo.chrome.api.webaudio.AudioParamWillBeDestroyedEvent::class.java)
        connection.addEventMapping("WebAudio.contextChanged", pl.wendigo.chrome.api.webaudio.ContextChangedEvent::class.java)
        connection.addEventMapping("WebAudio.contextCreated", pl.wendigo.chrome.api.webaudio.ContextCreatedEvent::class.java)
        connection.addEventMapping("WebAudio.contextWillBeDestroyed", pl.wendigo.chrome.api.webaudio.ContextWillBeDestroyedEvent::class.java)
        connection.addEventMapping("WebAudio.nodeParamConnected", pl.wendigo.chrome.api.webaudio.NodeParamConnectedEvent::class.java)
        connection.addEventMapping("WebAudio.nodeParamDisconnected", pl.wendigo.chrome.api.webaudio.NodeParamDisconnectedEvent::class.java)
        connection.addEventMapping("WebAudio.nodesConnected", pl.wendigo.chrome.api.webaudio.NodesConnectedEvent::class.java)
        connection.addEventMapping("WebAudio.nodesDisconnected", pl.wendigo.chrome.api.webaudio.NodesDisconnectedEvent::class.java)
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
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Fetch](Domain Fetch documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
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
