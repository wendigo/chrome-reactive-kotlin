package pl.wendigo.chrome.api.debugger

/**
 * Breakpoint identifier.
 *
 * @link [Debugger#BreakpointId](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-BreakpointId) type documentation.
 */

typealias BreakpointId = String

/**
 * Call frame identifier.
 *
 * @link [Debugger#CallFrameId](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-CallFrameId) type documentation.
 */

typealias CallFrameId = String

/**
 * Location in the source code.
 *
 * @link [Debugger#Location](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-Location) type documentation.
 */

data class Location(
    /**  
     * Script identifier as reported in the `Debugger.scriptParsed`.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * Line number in the script (0-based).  
     */  
    val lineNumber: Int,

    /**  
     * Column number in the script (0-based).  
     */  
    val columnNumber: Int? = null
)

/**
 * Location in the source code.
 *
 * @link [Debugger#ScriptPosition](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-ScriptPosition) type documentation.
 */

data class ScriptPosition(
    /**  
     *  
     */  
    val lineNumber: Int,

    /**  
     *  
     */  
    val columnNumber: Int
)

/**
 * JavaScript call frame. Array of call frames form the call stack.
 *
 * @link [Debugger#CallFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-CallFrame) type documentation.
 */

data class CallFrame(
    /**  
     * Call frame identifier. This identifier is only valid while the virtual machine is paused.  
     */  
    val callFrameId: CallFrameId,

    /**  
     * Name of the JavaScript function called on this call frame.  
     */  
    val functionName: String,

    /**  
     * Location in the source code.  
     */  
    val functionLocation: Location? = null,

    /**  
     * Location in the source code.  
     */  
    val location: Location,

    /**  
     * JavaScript script name or url.  
     */  
    val url: String,

    /**  
     * Scope chain for this call frame.  
     */  
    val scopeChain: List<Scope>,

    /**  
     * `this` object for this call frame.  
     */  
    @get:com.fasterxml.jackson.annotation.JsonProperty("this")

    val _this: pl.wendigo.chrome.api.runtime.RemoteObject,

    /**  
     * The value being returned, if the function is at return point.  
     */  
    val returnValue: pl.wendigo.chrome.api.runtime.RemoteObject? = null
)

/**
 * Scope description.
 *
 * @link [Debugger#Scope](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-Scope) type documentation.
 */

data class Scope(
    /**  
     * Scope type.  
     */  
    val type: String,

    /**  
     * Object representing the scope. For `global` and `with` scopes it represents the actual  
     object; for the rest of the scopes, it is artificial transient object enumerating scope  
     variables as its properties.  
     */  
    @get:com.fasterxml.jackson.annotation.JsonProperty("object")

    val _object: pl.wendigo.chrome.api.runtime.RemoteObject,

    /**  
     *  
     */  
    val name: String? = null,

    /**  
     * Location in the source code where scope starts  
     */  
    val startLocation: Location? = null,

    /**  
     * Location in the source code where scope ends  
     */  
    val endLocation: Location? = null
)

/**
 * Search match for resource.
 *
 * @link [Debugger#SearchMatch](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-SearchMatch) type documentation.
 */

data class SearchMatch(
    /**  
     * Line number in resource content.  
     */  
    val lineNumber: Double,

    /**  
     * Line with match content.  
     */  
    val lineContent: String
)

/**
 *
 *
 * @link [Debugger#BreakLocation](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#type-BreakLocation) type documentation.
 */

data class BreakLocation(
    /**  
     * Script identifier as reported in the `Debugger.scriptParsed`.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * Line number in the script (0-based).  
     */  
    val lineNumber: Int,

    /**  
     * Column number in the script (0-based).  
     */  
    val columnNumber: Int? = null,

    /**  
     *  
     */  
    val type: String? = null
)
