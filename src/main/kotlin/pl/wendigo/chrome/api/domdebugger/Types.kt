package pl.wendigo.chrome.api.domdebugger

/**
 * DOM breakpoint type.
 *
 * @link [DOMDebugger#DOMBreakpointType](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#type-DOMBreakpointType) type documentation.
 */
enum class DOMBreakpointType {
    @com.fasterxml.jackson.annotation.JsonProperty("subtree-modified")
    SUBTREE_MODIFIED,

    @com.fasterxml.jackson.annotation.JsonProperty("attribute-modified")
    ATTRIBUTE_MODIFIED,

    @com.fasterxml.jackson.annotation.JsonProperty("node-removed")
    NODE_REMOVED;
}

/**
 * CSP Violation type.
 *
 * @link [DOMDebugger#CSPViolationType](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#type-CSPViolationType) type documentation.
 */
enum class CSPViolationType {
    @com.fasterxml.jackson.annotation.JsonProperty("trustedtype-sink-violation")
    TRUSTEDTYPE_SINK_VIOLATION,

    @com.fasterxml.jackson.annotation.JsonProperty("trustedtype-policy-violation")
    TRUSTEDTYPE_POLICY_VIOLATION;
}

/**
 * Object event listener.
 *
 * @link [DOMDebugger#EventListener](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#type-EventListener) type documentation.
 */

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
