package pl.wendigo.chrome.domain.domsnapshot

/**
 * This domain facilitates obtaining document snapshots with DOM, layout, and style information.
 */
class DOMSnapshotDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
     */
    fun getSnapshot(input : GetSnapshotRequest) : io.reactivex.Single<GetSnapshotResponse> {
        return connectionRemote.runAndCaptureResponse("DOMSnapshot.getSnapshot", input, GetSnapshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all DOMSnapshot domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "DOMSnapshot"
        }
    }
}
/**
 * Represents request frame that can be used with DOMSnapshot.getSnapshot method call.
 *
 * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
 */
data class GetSnapshotRequest (
    /**
     * Whitelist of computed styles to return.
     */
    val computedStyleWhitelist : List<String>,

    /**
     * Whether or not to retrieve details of DOM listeners (default false).
     */
    val includeEventListeners : Boolean? = null

)

/**
 * Represents response frame for DOMSnapshot.getSnapshot method call.
 *
 * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
template contents, and imported documents) in a flattened array, as well as layout and
white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
flattened.
 */
data class GetSnapshotResponse(
  /**
   * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
   */
  val domNodes : List<DOMNode>,

  /**
   * The nodes in the layout tree.
   */
  val layoutTreeNodes : List<LayoutTreeNode>,

  /**
   * Whitelisted ComputedStyle properties for each node in the layout tree.
   */
  val computedStyles : List<ComputedStyle>

)

