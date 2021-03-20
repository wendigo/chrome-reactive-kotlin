package pl.wendigo.chrome.api.accessibility

import kotlinx.serialization.json.Json

/**
 * AccessibilityDomain represents Accessibility protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Accessibility](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class AccessibilityDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebSocketConnection) :
    pl.wendigo.chrome.protocol.Domain("Accessibility", """""", connection) {
    /**
     * Disables the accessibility domain.
     *
     * @link Protocol [Accessibility#disable](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Accessibility.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls.
This turns on accessibility for the page, which can impact performance until accessibility is disabled.
     *
     * @link Protocol [Accessibility#enable](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Accessibility.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
     *
     * @link Protocol [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getPartialAXTree(input: GetPartialAXTreeRequest): io.reactivex.rxjava3.core.Single<GetPartialAXTreeResponse> = connection.request("Accessibility.getPartialAXTree", Json.encodeToJsonElement(GetPartialAXTreeRequest.serializer(), input), GetPartialAXTreeResponse.serializer())

    /**
     * Fetches the entire accessibility tree for the root Document
     *
     * @link Protocol [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getFullAXTree(input: GetFullAXTreeRequest): io.reactivex.rxjava3.core.Single<GetFullAXTreeResponse> = connection.request("Accessibility.getFullAXTree", Json.encodeToJsonElement(GetFullAXTreeRequest.serializer(), input), GetFullAXTreeResponse.serializer())

    /**
     * Fetches a particular accessibility node by AXNodeId.
Requires `enable()` to have been called previously.
     *
     * @link Protocol [Accessibility#getChildAXNodes](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getChildAXNodes) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getChildAXNodes(input: GetChildAXNodesRequest): io.reactivex.rxjava3.core.Single<GetChildAXNodesResponse> = connection.request("Accessibility.getChildAXNodes", Json.encodeToJsonElement(GetChildAXNodesRequest.serializer(), input), GetChildAXNodesResponse.serializer())

    /**
     * Query a DOM node's accessibility subtree for accessible name and role.
This command computes the name and role for all nodes in the subtree, including those that are
ignored for accessibility, and returns those that mactch the specified name and role. If no DOM
node is specified, or the DOM node does not exist, the command returns an error. If neither
`accessibleName` or `role` is specified, it returns all the accessibility nodes in the subtree.
     *
     * @link Protocol [Accessibility#queryAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-queryAXTree) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun queryAXTree(input: QueryAXTreeRequest): io.reactivex.rxjava3.core.Single<QueryAXTreeResponse> = connection.request("Accessibility.queryAXTree", Json.encodeToJsonElement(QueryAXTreeRequest.serializer(), input), QueryAXTreeResponse.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) operation call.
 *
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 * @link [Accessibility#getPartialAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getPartialAXTree) method documentation.
 * @see [AccessibilityDomain.getPartialAXTree]
 */
@kotlinx.serialization.Serializable
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
 * @see [AccessibilityDomain.getPartialAXTree]
 */
@kotlinx.serialization.Serializable
data class GetPartialAXTreeResponse(
    /**  
     * The `Accessibility.AXNode` for this DOM node, if it exists, plus its ancestors, siblings and  
     children, if requested.  
     */  
    val nodes: List<AXNode>

)

/**
 * Represents request frame that can be used with [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) operation call.
 *
 * Fetches the entire accessibility tree for the root Document
 * @link [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) method documentation.
 * @see [AccessibilityDomain.getFullAXTree]
 */
@kotlinx.serialization.Serializable
data class GetFullAXTreeRequest(
    /**
     * The maximum depth at which descendants of the root node should be retrieved.
If omitted, the full tree is returned.
     */
    val max_depth: Int? = null

)

/**
 * Represents response frame that is returned from [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) operation call.
 * Fetches the entire accessibility tree for the root Document
 *
  
 * @link [Accessibility#getFullAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getFullAXTree) method documentation.
 * @see [AccessibilityDomain.getFullAXTree]
 */
@kotlinx.serialization.Serializable
data class GetFullAXTreeResponse(
    /**  
     *  
     */  
    val nodes: List<AXNode>

)

/**
 * Represents request frame that can be used with [Accessibility#getChildAXNodes](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getChildAXNodes) operation call.
 *
 * Fetches a particular accessibility node by AXNodeId.
Requires `enable()` to have been called previously.
 * @link [Accessibility#getChildAXNodes](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getChildAXNodes) method documentation.
 * @see [AccessibilityDomain.getChildAXNodes]
 */
@kotlinx.serialization.Serializable
data class GetChildAXNodesRequest(
    /**
     *
     */
    val id: AXNodeId

)

/**
 * Represents response frame that is returned from [Accessibility#getChildAXNodes](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getChildAXNodes) operation call.
 * Fetches a particular accessibility node by AXNodeId.
Requires `enable()` to have been called previously.
 *
  
 * @link [Accessibility#getChildAXNodes](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-getChildAXNodes) method documentation.
 * @see [AccessibilityDomain.getChildAXNodes]
 */
@kotlinx.serialization.Serializable
data class GetChildAXNodesResponse(
    /**  
     *  
     */  
    val nodes: List<AXNode>

)

/**
 * Represents request frame that can be used with [Accessibility#queryAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-queryAXTree) operation call.
 *
 * Query a DOM node's accessibility subtree for accessible name and role.
This command computes the name and role for all nodes in the subtree, including those that are
ignored for accessibility, and returns those that mactch the specified name and role. If no DOM
node is specified, or the DOM node does not exist, the command returns an error. If neither
`accessibleName` or `role` is specified, it returns all the accessibility nodes in the subtree.
 * @link [Accessibility#queryAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-queryAXTree) method documentation.
 * @see [AccessibilityDomain.queryAXTree]
 */
@kotlinx.serialization.Serializable
data class QueryAXTreeRequest(
    /**
     * Identifier of the node for the root to query.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId? = null,

    /**
     * Identifier of the backend node for the root to query.
     */
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper for the root to query.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null,

    /**
     * Find nodes with this computed name.
     */
    val accessibleName: String? = null,

    /**
     * Find nodes with this computed role.
     */
    val role: String? = null

)

/**
 * Represents response frame that is returned from [Accessibility#queryAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-queryAXTree) operation call.
 * Query a DOM node's accessibility subtree for accessible name and role.
This command computes the name and role for all nodes in the subtree, including those that are
ignored for accessibility, and returns those that mactch the specified name and role. If no DOM
node is specified, or the DOM node does not exist, the command returns an error. If neither
`accessibleName` or `role` is specified, it returns all the accessibility nodes in the subtree.
 *
  
 * @link [Accessibility#queryAXTree](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#method-queryAXTree) method documentation.
 * @see [AccessibilityDomain.queryAXTree]
 */
@kotlinx.serialization.Serializable
data class QueryAXTreeResponse(
    /**  
     * A list of `Accessibility.AXNode` matching the specified attributes,  
     including nodes that are ignored for accessibility.  
     */  
    val nodes: List<AXNode>

)
