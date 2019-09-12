package pl.wendigo.chrome.domain.domdebugger

/**
 * DOM breakpoint type.
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
 * Object event listener.
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
    val scriptId: pl.wendigo.chrome.domain.runtime.ScriptId,

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
    val handler: pl.wendigo.chrome.domain.runtime.RemoteObject? = null,

    /**  
     * Event original handler function value.  
     */  
    val originalHandler: pl.wendigo.chrome.domain.runtime.RemoteObject? = null,

    /**  
     * Node the listener is added to (if any).  
     */  
    val backendNodeId: pl.wendigo.chrome.domain.dom.BackendNodeId? = null
)
