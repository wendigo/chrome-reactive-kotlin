package pl.wendigo.chrome.api.accessibility

/**
 * AccessibilityOperations represents Accessibility protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Accessibility](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class AccessibilityOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables the accessibility domain.
     *
     * @link Protocol [Accessibility#disable](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-disable) method documentation.
     */
    fun disable() = connection.request("Accessibility.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls.
This turns on accessibility for the page, which can impact performance until accessibility is disabled.
     *
     * @link Protocol [Accessibility#enable](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-enable) method documentation.
     */
    fun enable() = connection.request("Accessibility.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
     *
     * @link Protocol [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getPartialAXTree(input: GetPartialAXTreeRequest) = connection.request("Accessibility.getPartialAXTree", input, GetPartialAXTreeResponse::class.java)

    /**
     * Fetches the entire accessibility tree
     *
     * @link Protocol [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getFullAXTree() = connection.request("Accessibility.getFullAXTree", null, GetFullAXTreeResponse::class.java)

    /**
     * Returns flowable capturing all Accessibility domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Accessibility"
        }
    }
}

/**
 * Represents request frame that can be used with [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) operation call.
 *
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 * @link [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) method documentation.
 * @see [AccessibilityOperations.getPartialAXTree]
 */
data class GetPartialAXTreeRequest(
    /**
     * Identifier of the node to get the partial accessibility tree for.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId? = null,

    /**
     * Identifier of the backend node to get the partial accessibility tree for.
     */
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper to get the partial accessibility tree for.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null,

    /**
     * Whether to fetch this nodes ancestors, siblings and children. Defaults to true.
     */
    val fetchRelatives: Boolean? = null

)
/**
 * Represents response frame that is returned from [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) operation call.
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 *
  
 * @link [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) method documentation.
 * @see [AccessibilityOperations.getPartialAXTree]
 */
data class GetPartialAXTreeResponse(
    /**  
     * The `Accessibility.AXNode` for this DOM node, if it exists, plus its ancestors, siblings and  
     children, if requested.  
     */  
    val nodes: List<AXNode>

)

/**
 * Represents response frame that is returned from [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) operation call.
 * Fetches the entire accessibility tree
 *
  
 * @link [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) method documentation.
 * @see [AccessibilityOperations.getFullAXTree]
 */
data class GetFullAXTreeResponse(
    /**  
     *  
     */  
    val nodes: List<AXNode>

)
