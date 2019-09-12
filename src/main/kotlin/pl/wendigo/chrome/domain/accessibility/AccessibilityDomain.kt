package pl.wendigo.chrome.domain.accessibility

/**
 * AccessibilityDomain represents remote debugger protocol domain.
 */
class AccessibilityDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disables the accessibility domain.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Accessibility.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls.
This turns on accessibility for the page, which can impact performance until accessibility is disabled.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Accessibility.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
     */
    fun getPartialAXTree(input: GetPartialAXTreeRequest): io.reactivex.Single<GetPartialAXTreeResponse> {
        return connectionRemote.runAndCaptureResponse("Accessibility.getPartialAXTree", input, GetPartialAXTreeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Fetches the entire accessibility tree
     */
    fun getFullAXTree(): io.reactivex.Single<GetFullAXTreeResponse> {
        return connectionRemote.runAndCaptureResponse("Accessibility.getFullAXTree", null, GetFullAXTreeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Accessibility domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Accessibility"
        }
    }
}

/**
 * Represents request frame that can be used with Accessibility.getPartialAXTree method call.
 *
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 */
data class GetPartialAXTreeRequest(
    /**
     * Identifier of the node to get the partial accessibility tree for.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId? = null,

    /**
     * Identifier of the backend node to get the partial accessibility tree for.
     */
    val backendNodeId: pl.wendigo.chrome.domain.dom.BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper to get the partial accessibility tree for.
     */
    val objectId: pl.wendigo.chrome.domain.runtime.RemoteObjectId? = null,

    /**
     * Whether to fetch this nodes ancestors, siblings and children. Defaults to true.
     */
    val fetchRelatives: Boolean? = null

)

/**
 * Represents response frame for Accessibility.getPartialAXTree method call.
 *
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 */
data class GetPartialAXTreeResponse(
    /**  
     * The `Accessibility.AXNode` for this DOM node, if it exists, plus its ancestors, siblings and  
     children, if requested.  
     */  
    val nodes: List<AXNode>

)

/**
 * Represents response frame for Accessibility.getFullAXTree method call.
 *
 * Fetches the entire accessibility tree
 */
data class GetFullAXTreeResponse(
    /**  
     *  
     */  
    val nodes: List<AXNode>

)
