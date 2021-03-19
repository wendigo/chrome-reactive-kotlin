package pl.wendigo.chrome.api.domdebugger

/**
 * DOM breakpoint type.
 *
 * @link [DOMDebugger#DOMBreakpointType](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#type-DOMBreakpointType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class DOMBreakpointType {
    @kotlinx.serialization.SerialName("subtree-modified")
    SUBTREE_MODIFIED,

    @kotlinx.serialization.SerialName("attribute-modified")
    ATTRIBUTE_MODIFIED,

    @kotlinx.serialization.SerialName("node-removed")
    NODE_REMOVED;
}

/**
 * CSP Violation type.
 *
 * @link [DOMDebugger#CSPViolationType](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#type-CSPViolationType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CSPViolationType {
    @kotlinx.serialization.SerialName("trustedtype-sink-violation")
    TRUSTEDTYPE_SINK_VIOLATION,

    @kotlinx.serialization.SerialName("trustedtype-policy-violation")
    TRUSTEDTYPE_POLICY_VIOLATION;
}

/**
 * Object event listener.
 *
 * @link [DOMDebugger#EventListener](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#type-EventListener) type documentation.
 */

@kotlinx.serialization.Serializable
data class EventListener(
    /**  
     * `EventListener`'s type.  
     */  
    val type: String,

    /**  
     * `EventListener`'s useCapture.  
     */  
    val useCapture: Boolean,

    /**  
     * `EventListener`'s passive flag.  
     */  
    val passive: Boolean,

    /**  
     * `EventListener`'s once flag.  
     */  
    val once: Boolean,

    /**  
     * Script id of the handler code.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * Line number in the script (0-based).  
     */  
    val lineNumber: Int,

    /**  
     * Column number in the script (0-based).  
     */  
    val columnNumber: Int,

    /**  
     * Event handler function value.  
     */  
    val handler: pl.wendigo.chrome.api.runtime.RemoteObject? = null,

    /**  
     * Event original handler function value.  
     */  
    val originalHandler: pl.wendigo.chrome.api.runtime.RemoteObject? = null,

    /**  
     * Node the listener is added to (if any).  
     */  
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null
)
