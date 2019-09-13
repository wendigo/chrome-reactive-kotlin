package pl.wendigo.chrome.domain.domdebugger

/**
 * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
execution will stop on these operations as if there was a regular breakpoint set.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger](https://chromedevtools.github.io/devtools-protocol/tot/DOMDebugger)
 */
class DOMDebugger internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Returns event listeners of the given object.
     */
    fun getEventListeners(input: GetEventListenersRequest): io.reactivex.Single<GetEventListenersResponse> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.getEventListeners", input, GetEventListenersResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
     */
    fun removeDOMBreakpoint(input: RemoveDOMBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.removeDOMBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes breakpoint on particular DOM event.
     */
    fun removeEventListenerBreakpoint(input: RemoveEventListenerBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.removeEventListenerBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes breakpoint on particular native event.
     */
    fun removeInstrumentationBreakpoint(input: RemoveInstrumentationBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.removeInstrumentationBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes breakpoint from XMLHttpRequest.
     */
    fun removeXHRBreakpoint(input: RemoveXHRBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.removeXHRBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on particular operation with DOM.
     */
    fun setDOMBreakpoint(input: SetDOMBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.setDOMBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on particular DOM event.
     */
    fun setEventListenerBreakpoint(input: SetEventListenerBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.setEventListenerBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on particular native event.
     */
    fun setInstrumentationBreakpoint(input: SetInstrumentationBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.setInstrumentationBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets breakpoint on XMLHttpRequest.
     */
    fun setXHRBreakpoint(input: SetXHRBreakpointRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMDebugger.setXHRBreakpoint", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all DOMDebugger domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "DOMDebugger"
        }
    }
}
/**
 * Represents request frame that can be used with DOMDebugger.getEventListeners method call.
 *
 * Returns event listeners of the given object.
 */
data class GetEventListenersRequest(
    /**
     * Identifier of the object to return listeners for.
     */
    val objectId: pl.wendigo.chrome.domain.runtime.RemoteObjectId,

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
 * Represents response frame for DOMDebugger.getEventListeners method call.
 *
 * Returns event listeners of the given object.
 */
data class GetEventListenersResponse(
    /**  
     * Array of relevant listeners.  
     */  
    val listeners: List<EventListener>

)

/**
 * Represents request frame that can be used with DOMDebugger.removeDOMBreakpoint method call.
 *
 * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
 */
data class RemoveDOMBreakpointRequest(
    /**
     * Identifier of the node to remove breakpoint from.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId,

    /**
     * Type of the breakpoint to remove.
     */
    val type: DOMBreakpointType

)

/**
 * Represents request frame that can be used with DOMDebugger.removeEventListenerBreakpoint method call.
 *
 * Removes breakpoint on particular DOM event.
 */
data class RemoveEventListenerBreakpointRequest(
    /**
     * Event name.
     */
    val eventName: String,

    /**
     * EventTarget interface name.
     */
    @pl.wendigo.chrome.Experimental val targetName: String? = null

)

/**
 * Represents request frame that can be used with DOMDebugger.removeInstrumentationBreakpoint method call.
 *
 * Removes breakpoint on particular native event.
 */
data class RemoveInstrumentationBreakpointRequest(
    /**
     * Instrumentation name to stop on.
     */
    val eventName: String

)

/**
 * Represents request frame that can be used with DOMDebugger.removeXHRBreakpoint method call.
 *
 * Removes breakpoint from XMLHttpRequest.
 */
data class RemoveXHRBreakpointRequest(
    /**
     * Resource URL substring.
     */
    val url: String

)

/**
 * Represents request frame that can be used with DOMDebugger.setDOMBreakpoint method call.
 *
 * Sets breakpoint on particular operation with DOM.
 */
data class SetDOMBreakpointRequest(
    /**
     * Identifier of the node to set breakpoint on.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId,

    /**
     * Type of the operation to stop upon.
     */
    val type: DOMBreakpointType

)

/**
 * Represents request frame that can be used with DOMDebugger.setEventListenerBreakpoint method call.
 *
 * Sets breakpoint on particular DOM event.
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
    @pl.wendigo.chrome.Experimental val targetName: String? = null

)

/**
 * Represents request frame that can be used with DOMDebugger.setInstrumentationBreakpoint method call.
 *
 * Sets breakpoint on particular native event.
 */
data class SetInstrumentationBreakpointRequest(
    /**
     * Instrumentation name to stop on.
     */
    val eventName: String

)

/**
 * Represents request frame that can be used with DOMDebugger.setXHRBreakpoint method call.
 *
 * Sets breakpoint on XMLHttpRequest.
 */
data class SetXHRBreakpointRequest(
    /**
     * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
     */
    val url: String

)
