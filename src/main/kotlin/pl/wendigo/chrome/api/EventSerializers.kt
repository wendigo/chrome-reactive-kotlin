package pl.wendigo.chrome.api

import kotlinx.serialization.KSerializer
import pl.wendigo.chrome.protocol.Event
import pl.wendigo.chrome.protocol.websocket.EventResponseFrame

/**
 * EventSerializers is responsible for mapping [EventResponseFrame] to [KSerializer] that can decode this frame to [Event].
 */
object EventSerializers {
    /**
     * Returns [Event] serializer that can decode given [EventResponseFrame] frame.
     */
    fun getByEventName(frame: EventResponseFrame): KSerializer<out Event> = when (frame.eventName) {
        "Animation.animationCanceled" -> pl.wendigo.chrome.api.animation.AnimationCanceledEvent.serializer()
        "Animation.animationCreated" -> pl.wendigo.chrome.api.animation.AnimationCreatedEvent.serializer()
        "Animation.animationStarted" -> pl.wendigo.chrome.api.animation.AnimationStartedEvent.serializer()
        "ApplicationCache.applicationCacheStatusUpdated" -> pl.wendigo.chrome.api.applicationcache.ApplicationCacheStatusUpdatedEvent.serializer()
        "ApplicationCache.networkStateUpdated" -> pl.wendigo.chrome.api.applicationcache.NetworkStateUpdatedEvent.serializer()
        "Audits.issueAdded" -> pl.wendigo.chrome.api.audits.IssueAddedEvent.serializer()
        "BackgroundService.backgroundServiceEventReceived" -> pl.wendigo.chrome.api.backgroundservice.BackgroundServiceEventReceivedEvent.serializer()
        "BackgroundService.recordingStateChanged" -> pl.wendigo.chrome.api.backgroundservice.RecordingStateChangedEvent.serializer()
        "CSS.fontsUpdated" -> pl.wendigo.chrome.api.css.FontsUpdatedEvent.serializer()
        "CSS.mediaQueryResultChanged" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "CSS.styleSheetAdded" -> pl.wendigo.chrome.api.css.StyleSheetAddedEvent.serializer()
        "CSS.styleSheetChanged" -> pl.wendigo.chrome.api.css.StyleSheetChangedEvent.serializer()
        "CSS.styleSheetRemoved" -> pl.wendigo.chrome.api.css.StyleSheetRemovedEvent.serializer()
        "Cast.issueUpdated" -> pl.wendigo.chrome.api.cast.IssueUpdatedEvent.serializer()
        "Cast.sinksUpdated" -> pl.wendigo.chrome.api.cast.SinksUpdatedEvent.serializer()
        "Console.messageAdded" -> pl.wendigo.chrome.api.console.MessageAddedEvent.serializer()
        "DOM.attributeModified" -> pl.wendigo.chrome.api.dom.AttributeModifiedEvent.serializer()
        "DOM.attributeRemoved" -> pl.wendigo.chrome.api.dom.AttributeRemovedEvent.serializer()
        "DOM.characterDataModified" -> pl.wendigo.chrome.api.dom.CharacterDataModifiedEvent.serializer()
        "DOM.childNodeCountUpdated" -> pl.wendigo.chrome.api.dom.ChildNodeCountUpdatedEvent.serializer()
        "DOM.childNodeInserted" -> pl.wendigo.chrome.api.dom.ChildNodeInsertedEvent.serializer()
        "DOM.childNodeRemoved" -> pl.wendigo.chrome.api.dom.ChildNodeRemovedEvent.serializer()
        "DOM.distributedNodesUpdated" -> pl.wendigo.chrome.api.dom.DistributedNodesUpdatedEvent.serializer()
        "DOM.documentUpdated" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "DOM.inlineStyleInvalidated" -> pl.wendigo.chrome.api.dom.InlineStyleInvalidatedEvent.serializer()
        "DOM.pseudoElementAdded" -> pl.wendigo.chrome.api.dom.PseudoElementAddedEvent.serializer()
        "DOM.pseudoElementRemoved" -> pl.wendigo.chrome.api.dom.PseudoElementRemovedEvent.serializer()
        "DOM.setChildNodes" -> pl.wendigo.chrome.api.dom.SetChildNodesEvent.serializer()
        "DOM.shadowRootPopped" -> pl.wendigo.chrome.api.dom.ShadowRootPoppedEvent.serializer()
        "DOM.shadowRootPushed" -> pl.wendigo.chrome.api.dom.ShadowRootPushedEvent.serializer()
        "DOMStorage.domStorageItemAdded" -> pl.wendigo.chrome.api.domstorage.DomStorageItemAddedEvent.serializer()
        "DOMStorage.domStorageItemRemoved" -> pl.wendigo.chrome.api.domstorage.DomStorageItemRemovedEvent.serializer()
        "DOMStorage.domStorageItemUpdated" -> pl.wendigo.chrome.api.domstorage.DomStorageItemUpdatedEvent.serializer()
        "DOMStorage.domStorageItemsCleared" -> pl.wendigo.chrome.api.domstorage.DomStorageItemsClearedEvent.serializer()
        "Database.addDatabase" -> pl.wendigo.chrome.api.database.AddDatabaseEvent.serializer()
        "Debugger.breakpointResolved" -> pl.wendigo.chrome.api.debugger.BreakpointResolvedEvent.serializer()
        "Debugger.paused" -> pl.wendigo.chrome.api.debugger.PausedEvent.serializer()
        "Debugger.resumed" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Debugger.scriptFailedToParse" -> pl.wendigo.chrome.api.debugger.ScriptFailedToParseEvent.serializer()
        "Debugger.scriptParsed" -> pl.wendigo.chrome.api.debugger.ScriptParsedEvent.serializer()
        "Emulation.virtualTimeBudgetExpired" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Fetch.authRequired" -> pl.wendigo.chrome.api.fetch.AuthRequiredEvent.serializer()
        "Fetch.requestPaused" -> pl.wendigo.chrome.api.fetch.RequestPausedEvent.serializer()
        "HeadlessExperimental.needsBeginFramesChanged" -> pl.wendigo.chrome.api.headlessexperimental.NeedsBeginFramesChangedEvent.serializer()
        "HeapProfiler.addHeapSnapshotChunk" -> pl.wendigo.chrome.api.heapprofiler.AddHeapSnapshotChunkEvent.serializer()
        "HeapProfiler.heapStatsUpdate" -> pl.wendigo.chrome.api.heapprofiler.HeapStatsUpdateEvent.serializer()
        "HeapProfiler.lastSeenObjectId" -> pl.wendigo.chrome.api.heapprofiler.LastSeenObjectIdEvent.serializer()
        "HeapProfiler.reportHeapSnapshotProgress" -> pl.wendigo.chrome.api.heapprofiler.ReportHeapSnapshotProgressEvent.serializer()
        "HeapProfiler.resetProfiles" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Inspector.detached" -> pl.wendigo.chrome.api.inspector.DetachedEvent.serializer()
        "Inspector.targetCrashed" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Inspector.targetReloadedAfterCrash" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "LayerTree.layerPainted" -> pl.wendigo.chrome.api.layertree.LayerPaintedEvent.serializer()
        "LayerTree.layerTreeDidChange" -> pl.wendigo.chrome.api.layertree.LayerTreeDidChangeEvent.serializer()
        "Log.entryAdded" -> pl.wendigo.chrome.api.log.EntryAddedEvent.serializer()
        "Media.playerErrorsRaised" -> pl.wendigo.chrome.api.media.PlayerErrorsRaisedEvent.serializer()
        "Media.playerEventsAdded" -> pl.wendigo.chrome.api.media.PlayerEventsAddedEvent.serializer()
        "Media.playerMessagesLogged" -> pl.wendigo.chrome.api.media.PlayerMessagesLoggedEvent.serializer()
        "Media.playerPropertiesChanged" -> pl.wendigo.chrome.api.media.PlayerPropertiesChangedEvent.serializer()
        "Media.playersCreated" -> pl.wendigo.chrome.api.media.PlayersCreatedEvent.serializer()
        "Network.dataReceived" -> pl.wendigo.chrome.api.network.DataReceivedEvent.serializer()
        "Network.eventSourceMessageReceived" -> pl.wendigo.chrome.api.network.EventSourceMessageReceivedEvent.serializer()
        "Network.loadingFailed" -> pl.wendigo.chrome.api.network.LoadingFailedEvent.serializer()
        "Network.loadingFinished" -> pl.wendigo.chrome.api.network.LoadingFinishedEvent.serializer()
        "Network.requestIntercepted" -> pl.wendigo.chrome.api.network.RequestInterceptedEvent.serializer()
        "Network.requestServedFromCache" -> pl.wendigo.chrome.api.network.RequestServedFromCacheEvent.serializer()
        "Network.requestWillBeSent" -> pl.wendigo.chrome.api.network.RequestWillBeSentEvent.serializer()
        "Network.requestWillBeSentExtraInfo" -> pl.wendigo.chrome.api.network.RequestWillBeSentExtraInfoEvent.serializer()
        "Network.resourceChangedPriority" -> pl.wendigo.chrome.api.network.ResourceChangedPriorityEvent.serializer()
        "Network.responseReceived" -> pl.wendigo.chrome.api.network.ResponseReceivedEvent.serializer()
        "Network.responseReceivedExtraInfo" -> pl.wendigo.chrome.api.network.ResponseReceivedExtraInfoEvent.serializer()
        "Network.signedExchangeReceived" -> pl.wendigo.chrome.api.network.SignedExchangeReceivedEvent.serializer()
        "Network.trustTokenOperationDone" -> pl.wendigo.chrome.api.network.TrustTokenOperationDoneEvent.serializer()
        "Network.webSocketClosed" -> pl.wendigo.chrome.api.network.WebSocketClosedEvent.serializer()
        "Network.webSocketCreated" -> pl.wendigo.chrome.api.network.WebSocketCreatedEvent.serializer()
        "Network.webSocketFrameError" -> pl.wendigo.chrome.api.network.WebSocketFrameErrorEvent.serializer()
        "Network.webSocketFrameReceived" -> pl.wendigo.chrome.api.network.WebSocketFrameReceivedEvent.serializer()
        "Network.webSocketFrameSent" -> pl.wendigo.chrome.api.network.WebSocketFrameSentEvent.serializer()
        "Network.webSocketHandshakeResponseReceived" -> pl.wendigo.chrome.api.network.WebSocketHandshakeResponseReceivedEvent.serializer()
        "Network.webSocketWillSendHandshakeRequest" -> pl.wendigo.chrome.api.network.WebSocketWillSendHandshakeRequestEvent.serializer()
        "Network.webTransportClosed" -> pl.wendigo.chrome.api.network.WebTransportClosedEvent.serializer()
        "Network.webTransportConnectionEstablished" -> pl.wendigo.chrome.api.network.WebTransportConnectionEstablishedEvent.serializer()
        "Network.webTransportCreated" -> pl.wendigo.chrome.api.network.WebTransportCreatedEvent.serializer()
        "Overlay.inspectModeCanceled" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Overlay.inspectNodeRequested" -> pl.wendigo.chrome.api.overlay.InspectNodeRequestedEvent.serializer()
        "Overlay.nodeHighlightRequested" -> pl.wendigo.chrome.api.overlay.NodeHighlightRequestedEvent.serializer()
        "Overlay.screenshotRequested" -> pl.wendigo.chrome.api.overlay.ScreenshotRequestedEvent.serializer()
        "Page.compilationCacheProduced" -> pl.wendigo.chrome.api.page.CompilationCacheProducedEvent.serializer()
        "Page.documentOpened" -> pl.wendigo.chrome.api.page.DocumentOpenedEvent.serializer()
        "Page.domContentEventFired" -> pl.wendigo.chrome.api.page.DomContentEventFiredEvent.serializer()
        "Page.downloadProgress" -> pl.wendigo.chrome.api.page.DownloadProgressEvent.serializer()
        "Page.downloadWillBegin" -> pl.wendigo.chrome.api.page.DownloadWillBeginEvent.serializer()
        "Page.fileChooserOpened" -> pl.wendigo.chrome.api.page.FileChooserOpenedEvent.serializer()
        "Page.frameAttached" -> pl.wendigo.chrome.api.page.FrameAttachedEvent.serializer()
        "Page.frameClearedScheduledNavigation" -> pl.wendigo.chrome.api.page.FrameClearedScheduledNavigationEvent.serializer()
        "Page.frameDetached" -> pl.wendigo.chrome.api.page.FrameDetachedEvent.serializer()
        "Page.frameNavigated" -> pl.wendigo.chrome.api.page.FrameNavigatedEvent.serializer()
        "Page.frameRequestedNavigation" -> pl.wendigo.chrome.api.page.FrameRequestedNavigationEvent.serializer()
        "Page.frameResized" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Page.frameScheduledNavigation" -> pl.wendigo.chrome.api.page.FrameScheduledNavigationEvent.serializer()
        "Page.frameStartedLoading" -> pl.wendigo.chrome.api.page.FrameStartedLoadingEvent.serializer()
        "Page.frameStoppedLoading" -> pl.wendigo.chrome.api.page.FrameStoppedLoadingEvent.serializer()
        "Page.interstitialHidden" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Page.interstitialShown" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Page.javascriptDialogClosed" -> pl.wendigo.chrome.api.page.JavascriptDialogClosedEvent.serializer()
        "Page.javascriptDialogOpening" -> pl.wendigo.chrome.api.page.JavascriptDialogOpeningEvent.serializer()
        "Page.lifecycleEvent" -> pl.wendigo.chrome.api.page.LifecycleEventEvent.serializer()
        "Page.loadEventFired" -> pl.wendigo.chrome.api.page.LoadEventFiredEvent.serializer()
        "Page.navigatedWithinDocument" -> pl.wendigo.chrome.api.page.NavigatedWithinDocumentEvent.serializer()
        "Page.screencastFrame" -> pl.wendigo.chrome.api.page.ScreencastFrameEvent.serializer()
        "Page.screencastVisibilityChanged" -> pl.wendigo.chrome.api.page.ScreencastVisibilityChangedEvent.serializer()
        "Page.windowOpen" -> pl.wendigo.chrome.api.page.WindowOpenEvent.serializer()
        "Performance.metrics" -> pl.wendigo.chrome.api.performance.MetricsEvent.serializer()
        "PerformanceTimeline.timelineEventAdded" -> pl.wendigo.chrome.api.performancetimeline.TimelineEventAddedEvent.serializer()
        "Profiler.consoleProfileFinished" -> pl.wendigo.chrome.api.profiler.ConsoleProfileFinishedEvent.serializer()
        "Profiler.consoleProfileStarted" -> pl.wendigo.chrome.api.profiler.ConsoleProfileStartedEvent.serializer()
        "Profiler.preciseCoverageDeltaUpdate" -> pl.wendigo.chrome.api.profiler.PreciseCoverageDeltaUpdateEvent.serializer()
        "Runtime.bindingCalled" -> pl.wendigo.chrome.api.runtime.BindingCalledEvent.serializer()
        "Runtime.consoleAPICalled" -> pl.wendigo.chrome.api.runtime.ConsoleAPICalledEvent.serializer()
        "Runtime.exceptionRevoked" -> pl.wendigo.chrome.api.runtime.ExceptionRevokedEvent.serializer()
        "Runtime.exceptionThrown" -> pl.wendigo.chrome.api.runtime.ExceptionThrownEvent.serializer()
        "Runtime.executionContextCreated" -> pl.wendigo.chrome.api.runtime.ExecutionContextCreatedEvent.serializer()
        "Runtime.executionContextDestroyed" -> pl.wendigo.chrome.api.runtime.ExecutionContextDestroyedEvent.serializer()
        "Runtime.executionContextsCleared" -> pl.wendigo.chrome.protocol.RawEvent.serializer()
        "Runtime.inspectRequested" -> pl.wendigo.chrome.api.runtime.InspectRequestedEvent.serializer()
        "Security.certificateError" -> pl.wendigo.chrome.api.security.CertificateErrorEvent.serializer()
        "Security.securityStateChanged" -> pl.wendigo.chrome.api.security.SecurityStateChangedEvent.serializer()
        "Security.visibleSecurityStateChanged" -> pl.wendigo.chrome.api.security.VisibleSecurityStateChangedEvent.serializer()
        "ServiceWorker.workerErrorReported" -> pl.wendigo.chrome.api.serviceworker.WorkerErrorReportedEvent.serializer()
        "ServiceWorker.workerRegistrationUpdated" -> pl.wendigo.chrome.api.serviceworker.WorkerRegistrationUpdatedEvent.serializer()
        "ServiceWorker.workerVersionUpdated" -> pl.wendigo.chrome.api.serviceworker.WorkerVersionUpdatedEvent.serializer()
        "Storage.cacheStorageContentUpdated" -> pl.wendigo.chrome.api.storage.CacheStorageContentUpdatedEvent.serializer()
        "Storage.cacheStorageListUpdated" -> pl.wendigo.chrome.api.storage.CacheStorageListUpdatedEvent.serializer()
        "Storage.indexedDBContentUpdated" -> pl.wendigo.chrome.api.storage.IndexedDBContentUpdatedEvent.serializer()
        "Storage.indexedDBListUpdated" -> pl.wendigo.chrome.api.storage.IndexedDBListUpdatedEvent.serializer()
        "Target.attachedToTarget" -> pl.wendigo.chrome.api.target.AttachedToTargetEvent.serializer()
        "Target.detachedFromTarget" -> pl.wendigo.chrome.api.target.DetachedFromTargetEvent.serializer()
        "Target.receivedMessageFromTarget" -> pl.wendigo.chrome.api.target.ReceivedMessageFromTargetEvent.serializer()
        "Target.targetCrashed" -> pl.wendigo.chrome.api.target.TargetCrashedEvent.serializer()
        "Target.targetCreated" -> pl.wendigo.chrome.api.target.TargetCreatedEvent.serializer()
        "Target.targetDestroyed" -> pl.wendigo.chrome.api.target.TargetDestroyedEvent.serializer()
        "Target.targetInfoChanged" -> pl.wendigo.chrome.api.target.TargetInfoChangedEvent.serializer()
        "Tethering.accepted" -> pl.wendigo.chrome.api.tethering.AcceptedEvent.serializer()
        "Tracing.bufferUsage" -> pl.wendigo.chrome.api.tracing.BufferUsageEvent.serializer()
        "Tracing.dataCollected" -> pl.wendigo.chrome.api.tracing.DataCollectedEvent.serializer()
        "Tracing.tracingComplete" -> pl.wendigo.chrome.api.tracing.TracingCompleteEvent.serializer()
        "WebAudio.audioListenerCreated" -> pl.wendigo.chrome.api.webaudio.AudioListenerCreatedEvent.serializer()
        "WebAudio.audioListenerWillBeDestroyed" -> pl.wendigo.chrome.api.webaudio.AudioListenerWillBeDestroyedEvent.serializer()
        "WebAudio.audioNodeCreated" -> pl.wendigo.chrome.api.webaudio.AudioNodeCreatedEvent.serializer()
        "WebAudio.audioNodeWillBeDestroyed" -> pl.wendigo.chrome.api.webaudio.AudioNodeWillBeDestroyedEvent.serializer()
        "WebAudio.audioParamCreated" -> pl.wendigo.chrome.api.webaudio.AudioParamCreatedEvent.serializer()
        "WebAudio.audioParamWillBeDestroyed" -> pl.wendigo.chrome.api.webaudio.AudioParamWillBeDestroyedEvent.serializer()
        "WebAudio.contextChanged" -> pl.wendigo.chrome.api.webaudio.ContextChangedEvent.serializer()
        "WebAudio.contextCreated" -> pl.wendigo.chrome.api.webaudio.ContextCreatedEvent.serializer()
        "WebAudio.contextWillBeDestroyed" -> pl.wendigo.chrome.api.webaudio.ContextWillBeDestroyedEvent.serializer()
        "WebAudio.nodeParamConnected" -> pl.wendigo.chrome.api.webaudio.NodeParamConnectedEvent.serializer()
        "WebAudio.nodeParamDisconnected" -> pl.wendigo.chrome.api.webaudio.NodeParamDisconnectedEvent.serializer()
        "WebAudio.nodesConnected" -> pl.wendigo.chrome.api.webaudio.NodesConnectedEvent.serializer()
        "WebAudio.nodesDisconnected" -> pl.wendigo.chrome.api.webaudio.NodesDisconnectedEvent.serializer()
        else -> throw RuntimeException("Unrecognized event frame $frame")
    }
}
