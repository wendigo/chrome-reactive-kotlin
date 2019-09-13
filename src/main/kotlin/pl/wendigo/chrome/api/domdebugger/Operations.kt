package pl.wendigo.chrome.api.domdebugger

/**
 * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
execution will stop on these operations as if there was a regular breakpoint set.
 *
 * @link Protocol [DOMDebugger](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger) domain documentation.
 */
class DOMDebuggerOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Returns event listeners of the given object.
     *
     * @link Protocol [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) method documentation.
     */
    fun getEventListeners(input: GetEventListenersRequest): io.reactivex.Single<GetEventListenersResponse> {
        return connection.runAndCaptureResponse("DOMDebugger.getEventListeners", input, GetEventListenersResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
     *
     * @link Protocol [DOMDebugger#removeDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeDOMBreakpoint) method documentation.
     */
    fun removeDOMBreakpoint(input: RemoveDOMBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.removeDOMBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes breakpoint on particular DOM event.
     *
     * @link Protocol [DOMDebugger#removeEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeEventListenerBreakpoint) method documentation.
     */
    fun removeEventListenerBreakpoint(input: RemoveEventListenerBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.removeEventListenerBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes breakpoint on particular native event.
     *
     * @link Protocol [DOMDebugger#removeInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeInstrumentationBreakpoint) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun removeInstrumentationBreakpoint(input: RemoveInstrumentationBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.removeInstrumentationBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes breakpoint from XMLHttpRequest.
     *
     * @link Protocol [DOMDebugger#removeXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-removeXHRBreakpoint) method documentation.
     */
    fun removeXHRBreakpoint(input: RemoveXHRBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.removeXHRBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on particular operation with DOM.
     *
     * @link Protocol [DOMDebugger#setDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setDOMBreakpoint) method documentation.
     */
    fun setDOMBreakpoint(input: SetDOMBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.setDOMBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on particular DOM event.
     *
     * @link Protocol [DOMDebugger#setEventListenerBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setEventListenerBreakpoint) method documentation.
     */
    fun setEventListenerBreakpoint(input: SetEventListenerBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.setEventListenerBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on particular native event.
     *
     * @link Protocol [DOMDebugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setInstrumentationBreakpoint) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setInstrumentationBreakpoint(input: SetInstrumentationBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.setInstrumentationBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on XMLHttpRequest.
     *
     * @link Protocol [DOMDebugger#setXHRBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setXHRBreakpoint) method documentation.
     */
    fun setXHRBreakpoint(input: SetXHRBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOMDebugger.setXHRBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all DOMDebugger domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "DOMDebugger"
        }
    }
}
/**
 * Represents request frame that can be used with [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) operation call.
 *
 * Returns event listeners of the given object.
 * @link [DOMDebugger#getEventListeners](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-getEventListeners) method documentation.
 * @see [DOMDebuggerOperations.getEventListeners]
 */
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
data class RemoveXHRBreakpointRequest(
    /**
     * Resource URL substring.
     */
    val url: String

)

/**
 * Represents request frame that can be used with [DOMDebugger#setDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setDOMBreakpoint) operation call.
 *
 * Sets breakpoint on particular operation with DOM.
 * @link [DOMDebugger#setDOMBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger#method-setDOMBreakpoint) method documentation.
 * @see [DOMDebuggerOperations.setDOMBreakpoint]
 */
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
data class SetXHRBreakpointRequest(
    /**
     * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
     */
    val url: String

)
