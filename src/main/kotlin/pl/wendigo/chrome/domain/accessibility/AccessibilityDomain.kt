package pl.wendigo.chrome.domain.accessibility

/**
 * AccessibilityDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class AccessibilityDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun getPartialAXTree(input : GetPartialAXTreeRequest) : io.reactivex.Flowable<GetPartialAXTreeResponse> {
        return connection.runAndCaptureResponse("Accessibility.getPartialAXTree", input, GetPartialAXTreeResponse::class.java)
	}

  }

/**
 * Represents requestFrame parameters that can be used with Accessibility.getPartialAXTree method call.
 *
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 */
data class GetPartialAXTreeRequest (
    /**
     * ID of node to get the partial accessibility tree for.
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId,

    /**
     * Whether to fetch this nodes ancestors, siblings and children. Defaults to true.
     */
    val fetchRelatives : Boolean? = null

)

/**
 * Represents responseFrame from Accessibility. method call.
 *
 * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
 */
data class GetPartialAXTreeResponse(
  /**
   * The <code>Accessibility.AXNode</code> for this DOM node, if it exists, plus its ancestors, siblings and children, if requested.
   */
  val nodes : Array<AXNode>

)


