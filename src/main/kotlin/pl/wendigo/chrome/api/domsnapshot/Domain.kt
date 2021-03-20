package pl.wendigo.chrome.api.domsnapshot

import kotlinx.serialization.json.Json

/**
 * This domain facilitates obtaining document snapshots with DOM, layout, and style information.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [DOMSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class DOMSnapshotDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebSocketConnection) :
    pl.wendigo.chrome.protocol.Domain("DOMSnapshot", """This domain facilitates obtaining document snapshots with DOM, layout, and style information.""", connection) {
    /**
     * Disables DOM snapshot agent for the given page.
     *
     * @link Protocol [DOMSnapshot#disable](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMSnapshot.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables DOM snapshot agent for the given page.
     *
     * @link Protocol [DOMSnapshot#enable](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMSnapshot.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
     *
     * @link Protocol [DOMSnapshot#getSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-getSnapshot) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "getSnapshot is deprecated.")
    fun getSnapshot(input: GetSnapshotRequest): io.reactivex.rxjava3.core.Single<GetSnapshotResponse> = connection.request("DOMSnapshot.getSnapshot", Json.encodeToJsonElement(GetSnapshotRequest.serializer(), input), GetSnapshotResponse.serializer())

    /**
     * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
     *
     * @link Protocol [DOMSnapshot#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-captureSnapshot) method documentation.
     */
    
    fun captureSnapshot(input: CaptureSnapshotRequest): io.reactivex.rxjava3.core.Single<CaptureSnapshotResponse> = connection.request("DOMSnapshot.captureSnapshot", Json.encodeToJsonElement(CaptureSnapshotRequest.serializer(), input), CaptureSnapshotResponse.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.css.CSSDomain(connection),
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
            pl.wendigo.chrome.api.domdebugger.DOMDebuggerDomain(connection),
            pl.wendigo.chrome.api.page.PageDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [DOMSnapshot#getSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-getSnapshot) operation call.
 *
 * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
 * @link [DOMSnapshot#getSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-getSnapshot) method documentation.
 * @see [DOMSnapshotDomain.getSnapshot]
 */
@kotlinx.serialization.Serializable
data class GetSnapshotRequest(
    /**
     * Whitelist of computed styles to return.
     */
    val computedStyleWhitelist: List<String>,

    /**
     * Whether or not to retrieve details of DOM listeners (default false).
     */
    val includeEventListeners: Boolean? = null,

    /**
     * Whether to determine and include the paint order index of LayoutTreeNodes (default false).
     */
    val includePaintOrder: Boolean? = null,

    /**
     * Whether to include UA shadow tree in the snapshot (default false).
     */
    val includeUserAgentShadowTree: Boolean? = null

)

/**
 * Represents response frame that is returned from [DOMSnapshot#getSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-getSnapshot) operation call.
 * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
 *
  
 * @link [DOMSnapshot#getSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-getSnapshot) method documentation.
 * @see [DOMSnapshotDomain.getSnapshot]
 */
@kotlinx.serialization.Serializable
data class GetSnapshotResponse(
    /**  
     * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.  
     */  
    val domNodes: List<DOMNode>,

    /**  
     * The nodes in the layout tree.  
     */  
    val layoutTreeNodes: List<LayoutTreeNode>,

    /**  
     * Whitelisted ComputedStyle properties for each node in the layout tree.  
     */  
    val computedStyles: List<ComputedStyle>

)

/**
 * Represents request frame that can be used with [DOMSnapshot#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-captureSnapshot) operation call.
 *
 * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
 * @link [DOMSnapshot#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-captureSnapshot) method documentation.
 * @see [DOMSnapshotDomain.captureSnapshot]
 */
@kotlinx.serialization.Serializable
data class CaptureSnapshotRequest(
    /**
     * Whitelist of computed styles to return.
     */
    val computedStyles: List<String>,

    /**
     * Whether to include layout object paint orders into the snapshot.
     */
    val includePaintOrder: Boolean? = null,

    /**
     * Whether to include DOM rectangles (offsetRects, clientRects, scrollRects) into the snapshot
     */
    val includeDOMRects: Boolean? = null

)

/**
 * Represents response frame that is returned from [DOMSnapshot#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-captureSnapshot) operation call.
 * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
 *
  
 * @link [DOMSnapshot#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/DOMSnapshot#method-captureSnapshot) method documentation.
 * @see [DOMSnapshotDomain.captureSnapshot]
 */
@kotlinx.serialization.Serializable
data class CaptureSnapshotResponse(
    /**  
     * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.  
     */  
    val documents: List<DocumentSnapshot>,

    /**  
     * Shared string table that all string properties refer to with indexes.  
     */  
    val strings: List<String>

)
