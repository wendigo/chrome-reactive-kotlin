package pl.wendigo.chrome.api.domdebugger

import kotlinx.serialization.json.Json

/**
 * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
execution will stop on these operations as if there was a regular breakpoint set.
 *
 * @link Protocol [DOMDebugger](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger) domain documentation.
 */

class DOMDebuggerDomain internal constructor(connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) :
    pl.wendigo.chrome.api.Domain(
        "DOMDebugger",
        """DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
execution will stop on these operations as if there was a regular breakpoint set.""",
        connection
    ) {
    /**
     * Returns event listeners of the given object.
     *
     * @link Protocol [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) method documentation.
     */
    
    fun getEventListeners(input: GetEventListenersRequest) = connection.request("DOMDebugger.getEventListeners", Json.encodeToJsonElement(GetEventListenersRequest.serializer(), input), GetEventListenersResponse.serializer())

    /**
     * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
     *
     * @link Protocol [DOMDebugger#removeDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeDOMBreakpoint) method documentation.
     */
    
    fun removeDOMBreakpoint(input: RemoveDOMBreakpointRequest) = connection.request("DOMDebugger.removeDOMBreakpoint", Json.encodeToJsonElement(RemoveDOMBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Removes breakpoint on particular DOM event.
     *
     * @link Protocol [DOMDebugger#removeEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeEventListenerBreakpoint) method documentation.
     */
    
    fun removeEventListenerBreakpoint(input: RemoveEventListenerBreakpointRequest) = connection.request("DOMDebugger.removeEventListenerBreakpoint", Json.encodeToJsonElement(RemoveEventListenerBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Removes breakpoint on particular native event.
     *
     * @link Protocol [DOMDebugger#removeInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeInstrumentationBreakpoint) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun removeInstrumentationBreakpoint(input: RemoveInstrumentationBreakpointRequest) = connection.request("DOMDebugger.removeInstrumentationBreakpoint", Json.encodeToJsonElement(RemoveInstrumentationBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Removes breakpoint from XMLHttpRequest.
     *
     * @link Protocol [DOMDebugger#removeXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeXHRBreakpoint) method documentation.
     */
    
    fun removeXHRBreakpoint(input: RemoveXHRBreakpointRequest) = connection.request("DOMDebugger.removeXHRBreakpoint", Json.encodeToJsonElement(RemoveXHRBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets breakpoint on particular CSP violations.
     *
     * @link Protocol [DOMDebugger#setBreakOnCSPViolation](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setBreakOnCSPViolation) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setBreakOnCSPViolation(input: SetBreakOnCSPViolationRequest) = connection.request("DOMDebugger.setBreakOnCSPViolation", Json.encodeToJsonElement(SetBreakOnCSPViolationRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets breakpoint on particular operation with DOM.
     *
     * @link Protocol [DOMDebugger#setDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setDOMBreakpoint) method documentation.
     */
    
    fun setDOMBreakpoint(input: SetDOMBreakpointRequest) = connection.request("DOMDebugger.setDOMBreakpoint", Json.encodeToJsonElement(SetDOMBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets breakpoint on particular DOM event.
     *
     * @link Protocol [DOMDebugger#setEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setEventListenerBreakpoint) method documentation.
     */
    
    fun setEventListenerBreakpoint(input: SetEventListenerBreakpointRequest) = connection.request("DOMDebugger.setEventListenerBreakpoint", Json.encodeToJsonElement(SetEventListenerBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets breakpoint on particular native event.
     *
     * @link Protocol [DOMDebugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setInstrumentationBreakpoint) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setInstrumentationBreakpoint(input: SetInstrumentationBreakpointRequest) = connection.request("DOMDebugger.setInstrumentationBreakpoint", Json.encodeToJsonElement(SetInstrumentationBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets breakpoint on XMLHttpRequest.
     *
     * @link Protocol [DOMDebugger#setXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setXHRBreakpoint) method documentation.
     */
    
    fun setXHRBreakpoint(input: SetXHRBreakpointRequest) = connection.request("DOMDebugger.setXHRBreakpoint", Json.encodeToJsonElement(SetXHRBreakpointRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.api.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
            pl.wendigo.chrome.api.debugger.DebuggerDomain(connection),
            pl.wendigo.chrome.api.runtime.RuntimeDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) operation call.
 *
 * Returns event listeners of the given object.
 * @link [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) method documentation.
 * @see [DOMDebuggerOperations.getEventListeners]
 */
@kotlinx.serialization.Serializable
data class GetEventListenersRequest(
    /**
     * Identifier of the object to return listeners for.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId,

    /**
     * The maximum depth at which Node children should be retrieved, defaults to 1. Use -1 for the
entire subtree or provide an integer larger than 0.
     */
    val depth: Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
(default is false). Reports listeners for all contexts if pierce is enabled.
     */
    val pierce: Boolean? = null

)

/**
 * Represents response frame that is returned from [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) operation call.
 * Returns event listeners of the given object.
 *
  
 * @link [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) method documentation.
 * @see [DOMDebuggerOperations.getEventListeners]
 */
@kotlinx.serialization.Serializable
data class GetEventListenersResponse(
    /**  
     * Array of relevant listeners.  
     */  
    val listeners: List<EventListener>

)

/**
 * Represents request frame that can be used with [DOMDebugger#removeDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeDOMBreakpoint) operation call.
 *
 * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
 * @link [DOMDebugger#removeDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeDOMBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.removeDOMBreakpoint]
 */
@kotlinx.serialization.Serializable
data class RemoveDOMBreakpointRequest(
    /**
     * Identifier of the node to remove breakpoint from.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId,

    /**
     * Type of the breakpoint to remove.
     */
    val type: DOMBreakpointType

)

/**
 * Represents request frame that can be used with [DOMDebugger#removeEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeEventListenerBreakpoint) operation call.
 *
 * Removes breakpoint on particular DOM event.
 * @link [DOMDebugger#removeEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeEventListenerBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.removeEventListenerBreakpoint]
 */
@kotlinx.serialization.Serializable
data class RemoveEventListenerBreakpointRequest(
    /**
     * Event name.
     */
    val eventName: String,

    /**
     * EventTarget interface name.
     */
    @pl.wendigo.chrome.protocol.Experimental val targetName: String? = null

)

/**
 * Represents request frame that can be used with [DOMDebugger#removeInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeInstrumentationBreakpoint) operation call.
 *
 * Removes breakpoint on particular native event.
 * @link [DOMDebugger#removeInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeInstrumentationBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.removeInstrumentationBreakpoint]
 */
@kotlinx.serialization.Serializable
data class RemoveInstrumentationBreakpointRequest(
    /**
     * Instrumentation name to stop on.
     */
    val eventName: String

)

/**
 * Represents request frame that can be used with [DOMDebugger#removeXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeXHRBreakpoint) operation call.
 *
 * Removes breakpoint from XMLHttpRequest.
 * @link [DOMDebugger#removeXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeXHRBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.removeXHRBreakpoint]
 */
@kotlinx.serialization.Serializable
data class RemoveXHRBreakpointRequest(
    /**
     * Resource URL substring.
     */
    val url: String

)

/**
 * Represents request frame that can be used with [DOMDebugger#setBreakOnCSPViolation](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setBreakOnCSPViolation) operation call.
 *
 * Sets breakpoint on particular CSP violations.
 * @link [DOMDebugger#setBreakOnCSPViolation](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setBreakOnCSPViolation) method documentation.
 * @see [DOMDebuggerOperations.setBreakOnCSPViolation]
 */
@kotlinx.serialization.Serializable
data class SetBreakOnCSPViolationRequest(
    /**
     * CSP Violations to stop upon.
     */
    val violationTypes: List<CSPViolationType>

)

/**
 * Represents request frame that can be used with [DOMDebugger#setDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setDOMBreakpoint) operation call.
 *
 * Sets breakpoint on particular operation with DOM.
 * @link [DOMDebugger#setDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setDOMBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.setDOMBreakpoint]
 */
@kotlinx.serialization.Serializable
data class SetDOMBreakpointRequest(
    /**
     * Identifier of the node to set breakpoint on.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId,

    /**
     * Type of the operation to stop upon.
     */
    val type: DOMBreakpointType

)

/**
 * Represents request frame that can be used with [DOMDebugger#setEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setEventListenerBreakpoint) operation call.
 *
 * Sets breakpoint on particular DOM event.
 * @link [DOMDebugger#setEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setEventListenerBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.setEventListenerBreakpoint]
 */
@kotlinx.serialization.Serializable
data class SetEventListenerBreakpointRequest(
    /**
     * DOM Event name to stop on (any DOM event will do).
     */
    val eventName: String,

    /**
     * EventTarget interface name to stop on. If equal to `"*"` or not provided, will stop on any
EventTarget.
     */
    @pl.wendigo.chrome.protocol.Experimental val targetName: String? = null

)

/**
 * Represents request frame that can be used with [DOMDebugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setInstrumentationBreakpoint) operation call.
 *
 * Sets breakpoint on particular native event.
 * @link [DOMDebugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setInstrumentationBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.setInstrumentationBreakpoint]
 */
@kotlinx.serialization.Serializable
data class SetInstrumentationBreakpointRequest(
    /**
     * Instrumentation name to stop on.
     */
    val eventName: String

)

/**
 * Represents request frame that can be used with [DOMDebugger#setXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setXHRBreakpoint) operation call.
 *
 * Sets breakpoint on XMLHttpRequest.
 * @link [DOMDebugger#setXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setXHRBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.setXHRBreakpoint]
 */
@kotlinx.serialization.Serializable
data class SetXHRBreakpointRequest(
    /**
     * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
     */
    val url: String

)
