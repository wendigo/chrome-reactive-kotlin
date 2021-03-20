package pl.wendigo.chrome.api

import io.reactivex.rxjava3.core.Flowable
import pl.wendigo.chrome.api.accessibility.AccessibilityDomain
import pl.wendigo.chrome.api.animation.AnimationDomain
import pl.wendigo.chrome.api.applicationcache.ApplicationCacheDomain
import pl.wendigo.chrome.api.audits.AuditsDomain
import pl.wendigo.chrome.api.backgroundservice.BackgroundServiceDomain
import pl.wendigo.chrome.api.browser.BrowserDomain
import pl.wendigo.chrome.api.cachestorage.CacheStorageDomain
import pl.wendigo.chrome.api.cast.CastDomain
import pl.wendigo.chrome.api.console.ConsoleDomain
import pl.wendigo.chrome.api.css.CSSDomain
import pl.wendigo.chrome.api.database.DatabaseDomain
import pl.wendigo.chrome.api.debugger.DebuggerDomain
import pl.wendigo.chrome.api.deviceorientation.DeviceOrientationDomain
import pl.wendigo.chrome.api.dom.DOMDomain
import pl.wendigo.chrome.api.domdebugger.DOMDebuggerDomain
import pl.wendigo.chrome.api.domsnapshot.DOMSnapshotDomain
import pl.wendigo.chrome.api.domstorage.DOMStorageDomain
import pl.wendigo.chrome.api.emulation.EmulationDomain
import pl.wendigo.chrome.api.fetch.FetchDomain
import pl.wendigo.chrome.api.headlessexperimental.HeadlessExperimentalDomain
import pl.wendigo.chrome.api.heapprofiler.HeapProfilerDomain
import pl.wendigo.chrome.api.indexeddb.IndexedDBDomain
import pl.wendigo.chrome.api.input.InputDomain
import pl.wendigo.chrome.api.inspector.InspectorDomain
import pl.wendigo.chrome.api.io.IODomain
import pl.wendigo.chrome.api.layertree.LayerTreeDomain
import pl.wendigo.chrome.api.log.LogDomain
import pl.wendigo.chrome.api.media.MediaDomain
import pl.wendigo.chrome.api.memory.MemoryDomain
import pl.wendigo.chrome.api.network.NetworkDomain
import pl.wendigo.chrome.api.overlay.OverlayDomain
import pl.wendigo.chrome.api.page.PageDomain
import pl.wendigo.chrome.api.performance.PerformanceDomain
import pl.wendigo.chrome.api.performancetimeline.PerformanceTimelineDomain
import pl.wendigo.chrome.api.profiler.ProfilerDomain
import pl.wendigo.chrome.api.runtime.RuntimeDomain
import pl.wendigo.chrome.api.schema.SchemaDomain
import pl.wendigo.chrome.api.security.SecurityDomain
import pl.wendigo.chrome.api.serviceworker.ServiceWorkerDomain
import pl.wendigo.chrome.api.storage.StorageDomain
import pl.wendigo.chrome.api.systeminfo.SystemInfoDomain
import pl.wendigo.chrome.api.target.TargetDomain
import pl.wendigo.chrome.api.tethering.TetheringDomain
import pl.wendigo.chrome.api.tracing.TracingDomain
import pl.wendigo.chrome.api.webaudio.WebAudioDomain
import pl.wendigo.chrome.api.webauthn.WebAuthnDomain
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import java.io.Closeable

/**
 * DevToolsProtocol represents all domains that can be controlled Chrome via [DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).
 *
 * @link [https://github.com/chromedevtools/devtools-protocol](https://github.com/chromedevtools/devtools-protocol)
 * @link [https://chromedevtools.github.io/devtools-protocol/](https://chromedevtools.github.io/devtools-protocol/)
 */
open class DevToolsProtocol internal constructor(internal val connection: ChromeDebuggerConnection) : Closeable {
    /**
     * This domain is deprecated - use Runtime or Log instead.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Console](Domain Console documentation)
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated - use Runtime or Log instead.")
    val Console: ConsoleDomain by lazy {
        ConsoleDomain(connection)
    }

    /**
     * Debugger domain exposes JavaScript debugging capabilities. It allows setting and removing
breakpoints, stepping through execution, exploring stack traces, etc.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Debugger](Domain Debugger documentation)
     */
    
    val Debugger: DebuggerDomain by lazy {
        DebuggerDomain(connection)
    }

    /**
     * Lazily returns [HeapProfilerDomain] domain object allowing to invoke methods on [HeapProfiler](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler](Domain HeapProfiler documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val HeapProfiler: HeapProfilerDomain by lazy {
        HeapProfilerDomain(connection)
    }

    /**
     * Lazily returns [ProfilerDomain] domain object allowing to invoke methods on [Profiler](https://chromedevtools.github.io/devtools-protocol/tot/Profiler) protocol domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Profiler](Domain Profiler documentation)
     */
    
    val Profiler: ProfilerDomain by lazy {
        ProfilerDomain(connection)
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
    
    val Runtime: RuntimeDomain by lazy {
        RuntimeDomain(connection)
    }

    /**
     * This domain is deprecated.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Schema](Domain Schema documentation)
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated.")
    val Schema: SchemaDomain by lazy {
        SchemaDomain(connection)
    }

    /**
     * Lazily returns [AccessibilityDomain] domain object allowing to invoke methods on [Accessibility](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Accessibility](Domain Accessibility documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Accessibility: AccessibilityDomain by lazy {
        AccessibilityDomain(connection)
    }

    /**
     * Lazily returns [AnimationDomain] domain object allowing to invoke methods on [Animation](https://chromedevtools.github.io/devtools-protocol/tot/Animation) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Animation](Domain Animation documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Animation: AnimationDomain by lazy {
        AnimationDomain(connection)
    }

    /**
     * Lazily returns [ApplicationCacheDomain] domain object allowing to invoke methods on [ApplicationCache](https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache](Domain ApplicationCache documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val ApplicationCache: ApplicationCacheDomain by lazy {
        ApplicationCacheDomain(connection)
    }

    /**
     * Audits domain allows investigation of page violations and possible improvements.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Audits](Domain Audits documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Audits: AuditsDomain by lazy {
        AuditsDomain(connection)
    }

    /**
     * Defines events for background web platform features.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService](Domain BackgroundService documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val BackgroundService: BackgroundServiceDomain by lazy {
        BackgroundServiceDomain(connection)
    }

    /**
     * The Browser domain defines methods and events for browser managing.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Browser](Domain Browser documentation)
     */
    
    val Browser: BrowserDomain by lazy {
        BrowserDomain(connection)
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
    val CSS: CSSDomain by lazy {
        CSSDomain(connection)
    }

    /**
     * Lazily returns [CacheStorageDomain] domain object allowing to invoke methods on [CacheStorage](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage](Domain CacheStorage documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val CacheStorage: CacheStorageDomain by lazy {
        CacheStorageDomain(connection)
    }

    /**
     * A domain for interacting with Cast, Presentation API, and Remote Playback API
functionalities.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Cast](Domain Cast documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Cast: CastDomain by lazy {
        CastDomain(connection)
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
    
    val DOM: DOMDomain by lazy {
        DOMDomain(connection)
    }

    /**
     * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
execution will stop on these operations as if there was a regular breakpoint set.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger](Domain DOMDebugger documentation)
     */
    
    val DOMDebugger: DOMDebuggerDomain by lazy {
        DOMDebuggerDomain(connection)
    }

    /**
     * This domain facilitates obtaining document snapshots with DOM, layout, and style information.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot](Domain DOMSnapshot documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val DOMSnapshot: DOMSnapshotDomain by lazy {
        DOMSnapshotDomain(connection)
    }

    /**
     * Query and modify DOM storage.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage](Domain DOMStorage documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val DOMStorage: DOMStorageDomain by lazy {
        DOMStorageDomain(connection)
    }

    /**
     * Lazily returns [DatabaseDomain] domain object allowing to invoke methods on [Database](https://chromedevtools.github.io/devtools-protocol/tot/Database) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Database](Domain Database documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Database: DatabaseDomain by lazy {
        DatabaseDomain(connection)
    }

    /**
     * Lazily returns [DeviceOrientationDomain] domain object allowing to invoke methods on [DeviceOrientation](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation](Domain DeviceOrientation documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val DeviceOrientation: DeviceOrientationDomain by lazy {
        DeviceOrientationDomain(connection)
    }

    /**
     * This domain emulates different environments for the page.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Emulation](Domain Emulation documentation)
     */
    
    val Emulation: EmulationDomain by lazy {
        EmulationDomain(connection)
    }

    /**
     * This domain provides experimental commands only supported in headless mode.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental](Domain HeadlessExperimental documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val HeadlessExperimental: HeadlessExperimentalDomain by lazy {
        HeadlessExperimentalDomain(connection)
    }

    /**
     * Input/Output operations for streams produced by DevTools.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/IO](Domain IO documentation)
     */
    
    val IO: IODomain by lazy {
        IODomain(connection)
    }

    /**
     * Lazily returns [IndexedDBDomain] domain object allowing to invoke methods on [IndexedDB](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB](Domain IndexedDB documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val IndexedDB: IndexedDBDomain by lazy {
        IndexedDBDomain(connection)
    }

    /**
     * Lazily returns [InputDomain] domain object allowing to invoke methods on [Input](https://chromedevtools.github.io/devtools-protocol/tot/Input) protocol domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Input](Domain Input documentation)
     */
    
    val Input: InputDomain by lazy {
        InputDomain(connection)
    }

    /**
     * Lazily returns [InspectorDomain] domain object allowing to invoke methods on [Inspector](https://chromedevtools.github.io/devtools-protocol/tot/Inspector) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Inspector](Domain Inspector documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Inspector: InspectorDomain by lazy {
        InspectorDomain(connection)
    }

    /**
     * Lazily returns [LayerTreeDomain] domain object allowing to invoke methods on [LayerTree](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/LayerTree](Domain LayerTree documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val LayerTree: LayerTreeDomain by lazy {
        LayerTreeDomain(connection)
    }

    /**
     * Provides access to log entries.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Log](Domain Log documentation)
     */
    
    val Log: LogDomain by lazy {
        LogDomain(connection)
    }

    /**
     * Lazily returns [MemoryDomain] domain object allowing to invoke methods on [Memory](https://chromedevtools.github.io/devtools-protocol/tot/Memory) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Memory](Domain Memory documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Memory: MemoryDomain by lazy {
        MemoryDomain(connection)
    }

    /**
     * Network domain allows tracking network activities of the page. It exposes information about http,
file, data and other requests and responses, their headers, bodies, timing, etc.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Network](Domain Network documentation)
     */
    
    val Network: NetworkDomain by lazy {
        NetworkDomain(connection)
    }

    /**
     * This domain provides various functionality related to drawing atop the inspected page.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Overlay](Domain Overlay documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Overlay: OverlayDomain by lazy {
        OverlayDomain(connection)
    }

    /**
     * Actions and events related to the inspected page belong to the page domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Page](Domain Page documentation)
     */
    
    val Page: PageDomain by lazy {
        PageDomain(connection)
    }

    /**
     * Lazily returns [PerformanceDomain] domain object allowing to invoke methods on [Performance](https://chromedevtools.github.io/devtools-protocol/tot/Performance) protocol domain.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Performance](Domain Performance documentation)
     */
    
    val Performance: PerformanceDomain by lazy {
        PerformanceDomain(connection)
    }

    /**
     * Reporting of performance timeline events, as specified in
https://w3c.github.io/performance-timeline/#dom-performanceobserver.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/PerformanceTimeline](Domain PerformanceTimeline documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val PerformanceTimeline: PerformanceTimelineDomain by lazy {
        PerformanceTimelineDomain(connection)
    }

    /**
     * Security
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Security](Domain Security documentation)
     */
    
    val Security: SecurityDomain by lazy {
        SecurityDomain(connection)
    }

    /**
     * Lazily returns [ServiceWorkerDomain] domain object allowing to invoke methods on [ServiceWorker](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker](Domain ServiceWorker documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val ServiceWorker: ServiceWorkerDomain by lazy {
        ServiceWorkerDomain(connection)
    }

    /**
     * Lazily returns [StorageDomain] domain object allowing to invoke methods on [Storage](https://chromedevtools.github.io/devtools-protocol/tot/Storage) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Storage](Domain Storage documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Storage: StorageDomain by lazy {
        StorageDomain(connection)
    }

    /**
     * The SystemInfo domain defines methods and events for querying low-level system information.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo](Domain SystemInfo documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val SystemInfo: SystemInfoDomain by lazy {
        SystemInfoDomain(connection)
    }

    /**
     * Supports additional targets discovery and allows to attach to them.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Target](Domain Target documentation)
     */
    
    val Target: TargetDomain by lazy {
        TargetDomain(connection)
    }

    /**
     * The Tethering domain defines methods and events for browser port binding.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Tethering](Domain Tethering documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Tethering: TetheringDomain by lazy {
        TetheringDomain(connection)
    }

    /**
     * Lazily returns [TracingDomain] domain object allowing to invoke methods on [Tracing](https://chromedevtools.github.io/devtools-protocol/tot/Tracing) protocol domain.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Tracing](Domain Tracing documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Tracing: TracingDomain by lazy {
        TracingDomain(connection)
    }

    /**
     * A domain for letting clients substitute browser's network layer with client code.
     *
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Fetch](Domain Fetch documentation)
     */
    
    val Fetch: FetchDomain by lazy {
        FetchDomain(connection)
    }

    /**
     * This domain allows inspection of Web Audio API.
https://webaudio.github.io/web-audio-api/
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/WebAudio](Domain WebAudio documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val WebAudio: WebAudioDomain by lazy {
        WebAudioDomain(connection)
    }

    /**
     * This domain allows configuring virtual authenticators to test the WebAuthn
API.
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn](Domain WebAuthn documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val WebAuthn: WebAuthnDomain by lazy {
        WebAuthnDomain(connection)
    }

    /**
     * This domain allows detailed inspection of media elements
     *
     * This API is marked as experimental in protocol definition and can change in the future.
     * @link [https://chromedevtools.github.io/devtools-protocol/tot/Media](Domain Media documentation)
     */
    @pl.wendigo.chrome.protocol.Experimental
    val Media: MediaDomain by lazy {
        MediaDomain(connection)
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

    /**
     * Returns a list of all protocol domain objects.
     */
    fun domains(): List<pl.wendigo.chrome.api.Domain> = listOf(
        ConsoleDomain(connection),
        DebuggerDomain(connection),
        HeapProfilerDomain(connection),
        ProfilerDomain(connection),
        RuntimeDomain(connection),
        SchemaDomain(connection),
        AccessibilityDomain(connection),
        AnimationDomain(connection),
        ApplicationCacheDomain(connection),
        AuditsDomain(connection),
        BackgroundServiceDomain(connection),
        BrowserDomain(connection),
        CSSDomain(connection),
        CacheStorageDomain(connection),
        CastDomain(connection),
        DOMDomain(connection),
        DOMDebuggerDomain(connection),
        DOMSnapshotDomain(connection),
        DOMStorageDomain(connection),
        DatabaseDomain(connection),
        DeviceOrientationDomain(connection),
        EmulationDomain(connection),
        HeadlessExperimentalDomain(connection),
        IODomain(connection),
        IndexedDBDomain(connection),
        InputDomain(connection),
        InspectorDomain(connection),
        LayerTreeDomain(connection),
        LogDomain(connection),
        MemoryDomain(connection),
        NetworkDomain(connection),
        OverlayDomain(connection),
        PageDomain(connection),
        PerformanceDomain(connection),
        PerformanceTimelineDomain(connection),
        SecurityDomain(connection),
        ServiceWorkerDomain(connection),
        StorageDomain(connection),
        SystemInfoDomain(connection),
        TargetDomain(connection),
        TetheringDomain(connection),
        TracingDomain(connection),
        FetchDomain(connection),
        WebAudioDomain(connection),
        WebAuthnDomain(connection),
        MediaDomain(connection),
    )
}
