package pl.wendigo.chrome

import java.io.Closeable

/**
 * ChromeProtocol represents session established with given inspectablePage via chrome's remote debugging protocol.
 */
open class ChromeProtocol internal constructor(private val api: DebuggerProtocol) : Closeable {

    /**
     * Register event eventNameToClassMapping
     */
    init {
        api.registerEventMappings(mapOf(
            "Animation.animationCanceled" to pl.wendigo.chrome.domain.animation.AnimationCanceledEvent::class.java,
            "Animation.animationCreated" to pl.wendigo.chrome.domain.animation.AnimationCreatedEvent::class.java,
            "Animation.animationStarted" to pl.wendigo.chrome.domain.animation.AnimationStartedEvent::class.java,
            "ApplicationCache.applicationCacheStatusUpdated" to pl.wendigo.chrome.domain.applicationcache.ApplicationCacheStatusUpdatedEvent::class.java,
            "ApplicationCache.networkStateUpdated" to pl.wendigo.chrome.domain.applicationcache.NetworkStateUpdatedEvent::class.java,
            "CSS.fontsUpdated" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "CSS.mediaQueryResultChanged" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "CSS.styleSheetAdded" to pl.wendigo.chrome.domain.css.StyleSheetAddedEvent::class.java,
            "CSS.styleSheetChanged" to pl.wendigo.chrome.domain.css.StyleSheetChangedEvent::class.java,
            "CSS.styleSheetRemoved" to pl.wendigo.chrome.domain.css.StyleSheetRemovedEvent::class.java,
            "Console.messageAdded" to pl.wendigo.chrome.domain.console.MessageAddedEvent::class.java,
            "DOM.attributeModified" to pl.wendigo.chrome.domain.dom.AttributeModifiedEvent::class.java,
            "DOM.attributeRemoved" to pl.wendigo.chrome.domain.dom.AttributeRemovedEvent::class.java,
            "DOM.characterDataModified" to pl.wendigo.chrome.domain.dom.CharacterDataModifiedEvent::class.java,
            "DOM.childNodeCountUpdated" to pl.wendigo.chrome.domain.dom.ChildNodeCountUpdatedEvent::class.java,
            "DOM.childNodeInserted" to pl.wendigo.chrome.domain.dom.ChildNodeInsertedEvent::class.java,
            "DOM.childNodeRemoved" to pl.wendigo.chrome.domain.dom.ChildNodeRemovedEvent::class.java,
            "DOM.distributedNodesUpdated" to pl.wendigo.chrome.domain.dom.DistributedNodesUpdatedEvent::class.java,
            "DOM.documentUpdated" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "DOM.inlineStyleInvalidated" to pl.wendigo.chrome.domain.dom.InlineStyleInvalidatedEvent::class.java,
            "DOM.pseudoElementAdded" to pl.wendigo.chrome.domain.dom.PseudoElementAddedEvent::class.java,
            "DOM.pseudoElementRemoved" to pl.wendigo.chrome.domain.dom.PseudoElementRemovedEvent::class.java,
            "DOM.setChildNodes" to pl.wendigo.chrome.domain.dom.SetChildNodesEvent::class.java,
            "DOM.shadowRootPopped" to pl.wendigo.chrome.domain.dom.ShadowRootPoppedEvent::class.java,
            "DOM.shadowRootPushed" to pl.wendigo.chrome.domain.dom.ShadowRootPushedEvent::class.java,
            "DOMStorage.domStorageItemAdded" to pl.wendigo.chrome.domain.domstorage.DomStorageItemAddedEvent::class.java,
            "DOMStorage.domStorageItemRemoved" to pl.wendigo.chrome.domain.domstorage.DomStorageItemRemovedEvent::class.java,
            "DOMStorage.domStorageItemUpdated" to pl.wendigo.chrome.domain.domstorage.DomStorageItemUpdatedEvent::class.java,
            "DOMStorage.domStorageItemsCleared" to pl.wendigo.chrome.domain.domstorage.DomStorageItemsClearedEvent::class.java,
            "Database.addDatabase" to pl.wendigo.chrome.domain.database.AddDatabaseEvent::class.java,
            "Debugger.breakpointResolved" to pl.wendigo.chrome.domain.debugger.BreakpointResolvedEvent::class.java,
            "Debugger.paused" to pl.wendigo.chrome.domain.debugger.PausedEvent::class.java,
            "Debugger.resumed" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "Debugger.scriptFailedToParse" to pl.wendigo.chrome.domain.debugger.ScriptFailedToParseEvent::class.java,
            "Debugger.scriptParsed" to pl.wendigo.chrome.domain.debugger.ScriptParsedEvent::class.java,
            "Emulation.virtualTimeBudgetExpired" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "HeapProfiler.addHeapSnapshotChunk" to pl.wendigo.chrome.domain.heapprofiler.AddHeapSnapshotChunkEvent::class.java,
            "HeapProfiler.heapStatsUpdate" to pl.wendigo.chrome.domain.heapprofiler.HeapStatsUpdateEvent::class.java,
            "HeapProfiler.lastSeenObjectId" to pl.wendigo.chrome.domain.heapprofiler.LastSeenObjectIdEvent::class.java,
            "HeapProfiler.reportHeapSnapshotProgress" to pl.wendigo.chrome.domain.heapprofiler.ReportHeapSnapshotProgressEvent::class.java,
            "HeapProfiler.resetProfiles" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "Inspector.detached" to pl.wendigo.chrome.domain.inspector.DetachedEvent::class.java,
            "Inspector.targetCrashed" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "LayerTree.layerPainted" to pl.wendigo.chrome.domain.layertree.LayerPaintedEvent::class.java,
            "LayerTree.layerTreeDidChange" to pl.wendigo.chrome.domain.layertree.LayerTreeDidChangeEvent::class.java,
            "Log.entryAdded" to pl.wendigo.chrome.domain.log.EntryAddedEvent::class.java,
            "Network.dataReceived" to pl.wendigo.chrome.domain.network.DataReceivedEvent::class.java,
            "Network.eventSourceMessageReceived" to pl.wendigo.chrome.domain.network.EventSourceMessageReceivedEvent::class.java,
            "Network.loadingFailed" to pl.wendigo.chrome.domain.network.LoadingFailedEvent::class.java,
            "Network.loadingFinished" to pl.wendigo.chrome.domain.network.LoadingFinishedEvent::class.java,
            "Network.requestIntercepted" to pl.wendigo.chrome.domain.network.RequestInterceptedEvent::class.java,
            "Network.requestServedFromCache" to pl.wendigo.chrome.domain.network.RequestServedFromCacheEvent::class.java,
            "Network.requestWillBeSent" to pl.wendigo.chrome.domain.network.RequestWillBeSentEvent::class.java,
            "Network.resourceChangedPriority" to pl.wendigo.chrome.domain.network.ResourceChangedPriorityEvent::class.java,
            "Network.responseReceived" to pl.wendigo.chrome.domain.network.ResponseReceivedEvent::class.java,
            "Network.webSocketClosed" to pl.wendigo.chrome.domain.network.WebSocketClosedEvent::class.java,
            "Network.webSocketCreated" to pl.wendigo.chrome.domain.network.WebSocketCreatedEvent::class.java,
            "Network.webSocketFrameError" to pl.wendigo.chrome.domain.network.WebSocketFrameErrorEvent::class.java,
            "Network.webSocketFrameReceived" to pl.wendigo.chrome.domain.network.WebSocketFrameReceivedEvent::class.java,
            "Network.webSocketFrameSent" to pl.wendigo.chrome.domain.network.WebSocketFrameSentEvent::class.java,
            "Network.webSocketHandshakeResponseReceived" to pl.wendigo.chrome.domain.network.WebSocketHandshakeResponseReceivedEvent::class.java,
            "Network.webSocketWillSendHandshakeRequest" to pl.wendigo.chrome.domain.network.WebSocketWillSendHandshakeRequestEvent::class.java,
            "Overlay.inspectNodeRequested" to pl.wendigo.chrome.domain.overlay.InspectNodeRequestedEvent::class.java,
            "Overlay.nodeHighlightRequested" to pl.wendigo.chrome.domain.overlay.NodeHighlightRequestedEvent::class.java,
            "Overlay.screenshotRequested" to pl.wendigo.chrome.domain.overlay.ScreenshotRequestedEvent::class.java,
            "Page.domContentEventFired" to pl.wendigo.chrome.domain.page.DomContentEventFiredEvent::class.java,
            "Page.frameAttached" to pl.wendigo.chrome.domain.page.FrameAttachedEvent::class.java,
            "Page.frameClearedScheduledNavigation" to pl.wendigo.chrome.domain.page.FrameClearedScheduledNavigationEvent::class.java,
            "Page.frameDetached" to pl.wendigo.chrome.domain.page.FrameDetachedEvent::class.java,
            "Page.frameNavigated" to pl.wendigo.chrome.domain.page.FrameNavigatedEvent::class.java,
            "Page.frameResized" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "Page.frameScheduledNavigation" to pl.wendigo.chrome.domain.page.FrameScheduledNavigationEvent::class.java,
            "Page.frameStartedLoading" to pl.wendigo.chrome.domain.page.FrameStartedLoadingEvent::class.java,
            "Page.frameStoppedLoading" to pl.wendigo.chrome.domain.page.FrameStoppedLoadingEvent::class.java,
            "Page.interstitialHidden" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "Page.interstitialShown" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "Page.javascriptDialogClosed" to pl.wendigo.chrome.domain.page.JavascriptDialogClosedEvent::class.java,
            "Page.javascriptDialogOpening" to pl.wendigo.chrome.domain.page.JavascriptDialogOpeningEvent::class.java,
            "Page.loadEventFired" to pl.wendigo.chrome.domain.page.LoadEventFiredEvent::class.java,
            "Page.screencastFrame" to pl.wendigo.chrome.domain.page.ScreencastFrameEvent::class.java,
            "Page.screencastVisibilityChanged" to pl.wendigo.chrome.domain.page.ScreencastVisibilityChangedEvent::class.java,
            "Performance.metrics" to pl.wendigo.chrome.domain.performance.MetricsEvent::class.java,
            "Profiler.consoleProfileFinished" to pl.wendigo.chrome.domain.profiler.ConsoleProfileFinishedEvent::class.java,
            "Profiler.consoleProfileStarted" to pl.wendigo.chrome.domain.profiler.ConsoleProfileStartedEvent::class.java,
            "Runtime.consoleAPICalled" to pl.wendigo.chrome.domain.runtime.ConsoleAPICalledEvent::class.java,
            "Runtime.exceptionRevoked" to pl.wendigo.chrome.domain.runtime.ExceptionRevokedEvent::class.java,
            "Runtime.exceptionThrown" to pl.wendigo.chrome.domain.runtime.ExceptionThrownEvent::class.java,
            "Runtime.executionContextCreated" to pl.wendigo.chrome.domain.runtime.ExecutionContextCreatedEvent::class.java,
            "Runtime.executionContextDestroyed" to pl.wendigo.chrome.domain.runtime.ExecutionContextDestroyedEvent::class.java,
            "Runtime.executionContextsCleared" to pl.wendigo.chrome.ProtocolEvent::class.java,
            "Runtime.inspectRequested" to pl.wendigo.chrome.domain.runtime.InspectRequestedEvent::class.java,
            "Security.certificateError" to pl.wendigo.chrome.domain.security.CertificateErrorEvent::class.java,
            "Security.securityStateChanged" to pl.wendigo.chrome.domain.security.SecurityStateChangedEvent::class.java,
            "ServiceWorker.workerErrorReported" to pl.wendigo.chrome.domain.serviceworker.WorkerErrorReportedEvent::class.java,
            "ServiceWorker.workerRegistrationUpdated" to pl.wendigo.chrome.domain.serviceworker.WorkerRegistrationUpdatedEvent::class.java,
            "ServiceWorker.workerVersionUpdated" to pl.wendigo.chrome.domain.serviceworker.WorkerVersionUpdatedEvent::class.java,
            "Storage.cacheStorageContentUpdated" to pl.wendigo.chrome.domain.storage.CacheStorageContentUpdatedEvent::class.java,
            "Storage.cacheStorageListUpdated" to pl.wendigo.chrome.domain.storage.CacheStorageListUpdatedEvent::class.java,
            "Target.attachedToTarget" to pl.wendigo.chrome.domain.target.AttachedToTargetEvent::class.java,
            "Target.detachedFromTarget" to pl.wendigo.chrome.domain.target.DetachedFromTargetEvent::class.java,
            "Target.receivedMessageFromTarget" to pl.wendigo.chrome.domain.target.ReceivedMessageFromTargetEvent::class.java,
            "Target.targetCreated" to pl.wendigo.chrome.domain.target.TargetCreatedEvent::class.java,
            "Target.targetDestroyed" to pl.wendigo.chrome.domain.target.TargetDestroyedEvent::class.java,
            "Target.targetInfoChanged" to pl.wendigo.chrome.domain.target.TargetInfoChangedEvent::class.java,
            "Tethering.accepted" to pl.wendigo.chrome.domain.tethering.AcceptedEvent::class.java,
            "Tracing.bufferUsage" to pl.wendigo.chrome.domain.tracing.BufferUsageEvent::class.java,
            "Tracing.dataCollected" to pl.wendigo.chrome.domain.tracing.DataCollectedEvent::class.java,
            "Tracing.tracingComplete" to pl.wendigo.chrome.domain.tracing.TracingCompleteEvent::class.java
        ))
    }

    /**
     * Returns Inspector domain object.
     */
    val Inspector : pl.wendigo.chrome.domain.inspector.InspectorDomain by lazy {
        pl.wendigo.chrome.domain.inspector.InspectorDomain(api)
    }

    /**
     * Returns Memory domain object.
     */
    val Memory : pl.wendigo.chrome.domain.memory.MemoryDomain by lazy {
        pl.wendigo.chrome.domain.memory.MemoryDomain(api)
    }

    /**
     * Returns Performance domain object.
     */
    val Performance : pl.wendigo.chrome.domain.performance.PerformanceDomain by lazy {
        pl.wendigo.chrome.domain.performance.PerformanceDomain(api)
    }

    /**
     * Actions and events related to the inspected page belong to the page domain.
     */
    val Page : pl.wendigo.chrome.domain.page.PageDomain by lazy {
        pl.wendigo.chrome.domain.page.PageDomain(api)
    }

    /**
     * This domain provides various functionality related to drawing atop the inspected page.
     */
    val Overlay : pl.wendigo.chrome.domain.overlay.OverlayDomain by lazy {
        pl.wendigo.chrome.domain.overlay.OverlayDomain(api)
    }

    /**
     * This domain emulates different environments for the page.
     */
    val Emulation : pl.wendigo.chrome.domain.emulation.EmulationDomain by lazy {
        pl.wendigo.chrome.domain.emulation.EmulationDomain(api)
    }

    /**
     * Security
     */
    val Security : pl.wendigo.chrome.domain.security.SecurityDomain by lazy {
        pl.wendigo.chrome.domain.security.SecurityDomain(api)
    }

    /**
     * Network domain allows tracking network activities of the page. It exposes information about http, file, data and other requests and responses, their headers, bodies, timing, etc.
     */
    val Network : pl.wendigo.chrome.domain.network.NetworkDomain by lazy {
        pl.wendigo.chrome.domain.network.NetworkDomain(api)
    }

    /**
     * Returns Database domain object.
     */
    val Database : pl.wendigo.chrome.domain.database.DatabaseDomain by lazy {
        pl.wendigo.chrome.domain.database.DatabaseDomain(api)
    }

    /**
     * Returns IndexedDB domain object.
     */
    val IndexedDB : pl.wendigo.chrome.domain.indexeddb.IndexedDBDomain by lazy {
        pl.wendigo.chrome.domain.indexeddb.IndexedDBDomain(api)
    }

    /**
     * Returns CacheStorage domain object.
     */
    val CacheStorage : pl.wendigo.chrome.domain.cachestorage.CacheStorageDomain by lazy {
        pl.wendigo.chrome.domain.cachestorage.CacheStorageDomain(api)
    }

    /**
     * Query and modify DOM storage.
     */
    val DOMStorage : pl.wendigo.chrome.domain.domstorage.DOMStorageDomain by lazy {
        pl.wendigo.chrome.domain.domstorage.DOMStorageDomain(api)
    }

    /**
     * Returns ApplicationCache domain object.
     */
    val ApplicationCache : pl.wendigo.chrome.domain.applicationcache.ApplicationCacheDomain by lazy {
        pl.wendigo.chrome.domain.applicationcache.ApplicationCacheDomain(api)
    }

    /**
     * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object that has an <code>id</code>. This <code>id</code> can be used to get additional information on the Node, resolve it into the JavaScript object wrapper, etc. It is important that client receives DOM events only for the nodes that are known to the client. Backend keeps track of the nodes that were sent to the client and never sends the same node twice. It is client's responsibility to collect information about the nodes that were sent to the client.<p>Note that <code>iframe</code> owner elements will return corresponding document elements as their child nodes.</p>
     */
    val DOM : pl.wendigo.chrome.domain.dom.DOMDomain by lazy {
        pl.wendigo.chrome.domain.dom.DOMDomain(api)
    }

    /**
     * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles) have an associated <code>id</code> used in subsequent operations on the related object. Each object type has a specific <code>id</code> structure, and those are not interchangeable between objects of different kinds. CSS objects can be loaded using the <code>get*ForNode()</code> calls (which accept a DOM node id). A client can also keep track of stylesheets via the <code>styleSheetAdded</code>/<code>styleSheetRemoved</code> events and subsequently load the required stylesheet contents using the <code>getStyleSheet[Text]()</code> methods.
     */
    val CSS : pl.wendigo.chrome.domain.css.CSSDomain by lazy {
        pl.wendigo.chrome.domain.css.CSSDomain(api)
    }

    /**
     * This domain facilitates obtaining document snapshots with DOM, layout, and style information.
     */
    val DOMSnapshot : pl.wendigo.chrome.domain.domsnapshot.DOMSnapshotDomain by lazy {
        pl.wendigo.chrome.domain.domsnapshot.DOMSnapshotDomain(api)
    }

    /**
     * Input/Output operations for streams produced by DevTools.
     */
    val IO : pl.wendigo.chrome.domain.io.IODomain by lazy {
        pl.wendigo.chrome.domain.io.IODomain(api)
    }

    /**
     * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript execution will stop on these operations as if there was a regular breakpoint set.
     */
    val DOMDebugger : pl.wendigo.chrome.domain.domdebugger.DOMDebuggerDomain by lazy {
        pl.wendigo.chrome.domain.domdebugger.DOMDebuggerDomain(api)
    }

    /**
     * Supports additional targets discovery and allows to attach to them.
     */
    val Target : pl.wendigo.chrome.domain.target.TargetDomain by lazy {
        pl.wendigo.chrome.domain.target.TargetDomain(api)
    }

    /**
     * Returns ServiceWorker domain object.
     */
    val ServiceWorker : pl.wendigo.chrome.domain.serviceworker.ServiceWorkerDomain by lazy {
        pl.wendigo.chrome.domain.serviceworker.ServiceWorkerDomain(api)
    }

    /**
     * Returns Input domain object.
     */
    val Input : pl.wendigo.chrome.domain.input.InputDomain by lazy {
        pl.wendigo.chrome.domain.input.InputDomain(api)
    }

    /**
     * Returns LayerTree domain object.
     */
    val LayerTree : pl.wendigo.chrome.domain.layertree.LayerTreeDomain by lazy {
        pl.wendigo.chrome.domain.layertree.LayerTreeDomain(api)
    }

    /**
     * Returns DeviceOrientation domain object.
     */
    val DeviceOrientation : pl.wendigo.chrome.domain.deviceorientation.DeviceOrientationDomain by lazy {
        pl.wendigo.chrome.domain.deviceorientation.DeviceOrientationDomain(api)
    }

    /**
     * Returns Tracing domain object.
     */
    val Tracing : pl.wendigo.chrome.domain.tracing.TracingDomain by lazy {
        pl.wendigo.chrome.domain.tracing.TracingDomain(api)
    }

    /**
     * Returns Animation domain object.
     */
    val Animation : pl.wendigo.chrome.domain.animation.AnimationDomain by lazy {
        pl.wendigo.chrome.domain.animation.AnimationDomain(api)
    }

    /**
     * Returns Accessibility domain object.
     */
    val Accessibility : pl.wendigo.chrome.domain.accessibility.AccessibilityDomain by lazy {
        pl.wendigo.chrome.domain.accessibility.AccessibilityDomain(api)
    }

    /**
     * Returns Storage domain object.
     */
    val Storage : pl.wendigo.chrome.domain.storage.StorageDomain by lazy {
        pl.wendigo.chrome.domain.storage.StorageDomain(api)
    }

    /**
     * Provides access to log entries.
     */
    val Log : pl.wendigo.chrome.domain.log.LogDomain by lazy {
        pl.wendigo.chrome.domain.log.LogDomain(api)
    }

    /**
     * The SystemInfo domain defines methods and events for querying low-level system information.
     */
    val SystemInfo : pl.wendigo.chrome.domain.systeminfo.SystemInfoDomain by lazy {
        pl.wendigo.chrome.domain.systeminfo.SystemInfoDomain(api)
    }

    /**
     * The Tethering domain defines methods and events for browser port binding.
     */
    val Tethering : pl.wendigo.chrome.domain.tethering.TetheringDomain by lazy {
        pl.wendigo.chrome.domain.tethering.TetheringDomain(api)
    }

    /**
     * The Browser domain defines methods and events for browser managing.
     */
    val Browser : pl.wendigo.chrome.domain.browser.BrowserDomain by lazy {
        pl.wendigo.chrome.domain.browser.BrowserDomain(api)
    }

    /**
     * Provides information about the protocol schema.
     */
    val Schema : pl.wendigo.chrome.domain.schema.SchemaDomain by lazy {
        pl.wendigo.chrome.domain.schema.SchemaDomain(api)
    }

    /**
     * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects. Evaluation results are returned as mirror object that expose object type, string representation and unique identifier that can be used for further object reference. Original objects are maintained in memory unless they are either explicitly released or are released along with the other objects in their object group.
     */
    val Runtime : pl.wendigo.chrome.domain.runtime.RuntimeDomain by lazy {
        pl.wendigo.chrome.domain.runtime.RuntimeDomain(api)
    }

    /**
     * Debugger domain exposes JavaScript debugging capabilities. It allows setting and removing breakpoints, stepping through execution, exploring stack traces, etc.
     */
    val Debugger : pl.wendigo.chrome.domain.debugger.DebuggerDomain by lazy {
        pl.wendigo.chrome.domain.debugger.DebuggerDomain(api)
    }

    /**
     * This domain is deprecated - use Runtime or Log instead.
     */
    val Console : pl.wendigo.chrome.domain.console.ConsoleDomain by lazy {
        pl.wendigo.chrome.domain.console.ConsoleDomain(api)
    }

    /**
     * Returns Profiler domain object.
     */
    val Profiler : pl.wendigo.chrome.domain.profiler.ProfilerDomain by lazy {
        pl.wendigo.chrome.domain.profiler.ProfilerDomain(api)
    }

    /**
     * Returns HeapProfiler domain object.
     */
    val HeapProfiler : pl.wendigo.chrome.domain.heapprofiler.HeapProfilerDomain by lazy {
        pl.wendigo.chrome.domain.heapprofiler.HeapProfilerDomain(api)
    }

    /**
     * Returns flowable capturing all events.
     */
    fun Events() : io.reactivex.Flowable<ProtocolEvent> {
        return api.captureAllEvents().map {
            it.value()
        }
    }

    /**
     * Closes debugging session.
     */
    override fun close() {
        return api.close()
    }

    companion object {

        /**
         * Opens new debugging session via chrome debugging protocol for given InspectablePage.
         */
        @JvmStatic @JvmOverloads
        fun openSession(page: InspectablePage, eventBufferSize: Int = 128) : ChromeProtocol {
            return ChromeProtocol(ChromeDebuggerConnection.openSession(page.webSocketDebuggerUrl!!, eventBufferSize))
        }

        /**
         * Opens new headless debugging session via chrome debugging protocol for given InspectablePage.
         *
         * When opening headless session new browser context is created and communication goes through Target domain
         * with target id/session id.
         */
        @JvmStatic @JvmOverloads
        fun openHeadlessSession(page: InspectablePage, eventBufferSize: Int = 128, width : Int = 1024, height : Int = 768) : HeadlessChromeProtocol {
            return HeadlessChromeProtocol.create(openSession(page, eventBufferSize), page.url, width, height)
        }
    }
}