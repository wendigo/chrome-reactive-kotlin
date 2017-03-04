package pl.wendigo.chrome

/**
 * RemoteChrome represents session established via chrome's remote debugging protocol.
 */
class RemoteChrome internal constructor(private val api: RemoteChromeConnection) {
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
     * Actions and events related to the inspected page belong to the page domain.
     */
    val Page : pl.wendigo.chrome.domain.page.PageDomain by lazy {
        pl.wendigo.chrome.domain.page.PageDomain(api)
    }

    /**
     * This domain allows to control rendering of the page.
     */
    val Rendering : pl.wendigo.chrome.domain.rendering.RenderingDomain by lazy {
        pl.wendigo.chrome.domain.rendering.RenderingDomain(api)
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
     * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles) have an associated <code>id</code> used in subsequent operations on the related object. Each object type has a specific <code>id</code> structure, and those are not interchangeable between objects of different kinds. CSS objects can be loaded using the <code>get*ForNode()</code> calls (which accept a DOM node id). A client can also discover all the existing stylesheets with the <code>getAllStyleSheets()</code> method (or keeping track of the <code>styleSheetAdded</code>/<code>styleSheetRemoved</code> events) and subsequently load the required stylesheet contents using the <code>getStyleSheet[Text]()</code> methods.
     */
    val CSS : pl.wendigo.chrome.domain.css.CSSDomain by lazy {
        pl.wendigo.chrome.domain.css.CSSDomain(api)
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
     * Closes connection to API.
     */
    fun Close() {
      return api.close()
    }

    companion object {
        /**
         * Connects to chrome debugging protocol on host and port.
         */
        @kotlin.jvm.Throws(RemoteChromeException::class)
        fun connect(host: String, port: Int) : RemoteChrome {
          return RemoteChrome(
              RemoteChromeConnection(host, port).connect()
          )
        }
    }
}
