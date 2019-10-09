package pl.wendigo.chrome.api.debugger

/**
 * Debugger domain exposes JavaScript debugging capabilities. It allows setting and removing
breakpoints, stepping through execution, exploring stack traces, etc.
 *
 * @link Protocol [Debugger](https://chromedevtools.github.io/devtools-protocol/tot/Debugger) domain documentation.
 */
class DebuggerOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Continues execution until specific location is reached.
     *
     * @link Protocol [Debugger#continueToLocation](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-continueToLocation) method documentation.
     */
    fun continueToLocation(input: ContinueToLocationRequest) = connection.request("Debugger.continueToLocation", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disables debugger for given page.
     *
     * @link Protocol [Debugger#disable](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-disable) method documentation.
     */
    fun disable() = connection.request("Debugger.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables debugger for the given page. Clients should not assume that the debugging has been
enabled until the result for this command is received.
     *
     * @link Protocol [Debugger#enable](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-enable) method documentation.
     */
    fun enable(input: EnableRequest) = connection.request("Debugger.enable", input, EnableResponse::class.java)

    /**
     * Evaluates expression on a given call frame.
     *
     * @link Protocol [Debugger#evaluateOnCallFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-evaluateOnCallFrame) method documentation.
     */
    fun evaluateOnCallFrame(input: EvaluateOnCallFrameRequest) = connection.request("Debugger.evaluateOnCallFrame", input, EvaluateOnCallFrameResponse::class.java)

    /**
     * Returns possible locations for breakpoint. scriptId in start and end range locations should be
the same.
     *
     * @link Protocol [Debugger#getPossibleBreakpoints](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getPossibleBreakpoints) method documentation.
     */
    fun getPossibleBreakpoints(input: GetPossibleBreakpointsRequest) = connection.request("Debugger.getPossibleBreakpoints", input, GetPossibleBreakpointsResponse::class.java)

    /**
     * Returns source for the script with given id.
     *
     * @link Protocol [Debugger#getScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getScriptSource) method documentation.
     */
    fun getScriptSource(input: GetScriptSourceRequest) = connection.request("Debugger.getScriptSource", input, GetScriptSourceResponse::class.java)

    /**
     * Returns bytecode for the WebAssembly script with given id.
     *
     * @link Protocol [Debugger#getWasmBytecode](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getWasmBytecode) method documentation.
     */
    fun getWasmBytecode(input: GetWasmBytecodeRequest) = connection.request("Debugger.getWasmBytecode", input, GetWasmBytecodeResponse::class.java)

    /**
     * Returns stack trace with given `stackTraceId`.
     *
     * @link Protocol [Debugger#getStackTrace](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getStackTrace) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getStackTrace(input: GetStackTraceRequest) = connection.request("Debugger.getStackTrace", input, GetStackTraceResponse::class.java)

    /**
     * Stops on the next JavaScript statement.
     *
     * @link Protocol [Debugger#pause](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-pause) method documentation.
     */
    fun pause() = connection.request("Debugger.pause", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Debugger#pauseOnAsyncCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-pauseOnAsyncCall) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "pauseOnAsyncCall is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun pauseOnAsyncCall(input: PauseOnAsyncCallRequest) = connection.request("Debugger.pauseOnAsyncCall", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Removes JavaScript breakpoint.
     *
     * @link Protocol [Debugger#removeBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-removeBreakpoint) method documentation.
     */
    fun removeBreakpoint(input: RemoveBreakpointRequest) = connection.request("Debugger.removeBreakpoint", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Restarts particular call frame from the beginning.
     *
     * @link Protocol [Debugger#restartFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-restartFrame) method documentation.
     */
    fun restartFrame(input: RestartFrameRequest) = connection.request("Debugger.restartFrame", input, RestartFrameResponse::class.java)

    /**
     * Resumes JavaScript execution.
     *
     * @link Protocol [Debugger#resume](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-resume) method documentation.
     */
    fun resume() = connection.request("Debugger.resume", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Searches for given string in script content.
     *
     * @link Protocol [Debugger#searchInContent](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-searchInContent) method documentation.
     */
    fun searchInContent(input: SearchInContentRequest) = connection.request("Debugger.searchInContent", input, SearchInContentResponse::class.java)

    /**
     * Enables or disables async call stacks tracking.
     *
     * @link Protocol [Debugger#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setAsyncCallStackDepth) method documentation.
     */
    fun setAsyncCallStackDepth(input: SetAsyncCallStackDepthRequest) = connection.request("Debugger.setAsyncCallStackDepth", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in
scripts with url matching one of the patterns. VM will try to leave blackboxed script by
performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
     *
     * @link Protocol [Debugger#setBlackboxPatterns](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBlackboxPatterns) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBlackboxPatterns(input: SetBlackboxPatternsRequest) = connection.request("Debugger.setBlackboxPatterns", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted
scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
Positions array contains positions where blackbox state is changed. First interval isn't
blackboxed. Array should be sorted.
     *
     * @link Protocol [Debugger#setBlackboxedRanges](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBlackboxedRanges) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBlackboxedRanges(input: SetBlackboxedRangesRequest) = connection.request("Debugger.setBlackboxedRanges", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Sets JavaScript breakpoint at a given location.
     *
     * @link Protocol [Debugger#setBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpoint) method documentation.
     */
    fun setBreakpoint(input: SetBreakpointRequest) = connection.request("Debugger.setBreakpoint", input, SetBreakpointResponse::class.java)

    /**
     * Sets instrumentation breakpoint.
     *
     * @link Protocol [Debugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setInstrumentationBreakpoint) method documentation.
     */
    fun setInstrumentationBreakpoint(input: SetInstrumentationBreakpointRequest) = connection.request("Debugger.setInstrumentationBreakpoint", input, SetInstrumentationBreakpointResponse::class.java)

    /**
     * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this
command is issued, all existing parsed scripts will have breakpoints resolved and returned in
`locations` property. Further matching script parsing will result in subsequent
`breakpointResolved` events issued. This logical breakpoint will survive page reloads.
     *
     * @link Protocol [Debugger#setBreakpointByUrl](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointByUrl) method documentation.
     */
    fun setBreakpointByUrl(input: SetBreakpointByUrlRequest) = connection.request("Debugger.setBreakpointByUrl", input, SetBreakpointByUrlResponse::class.java)

    /**
     * Sets JavaScript breakpoint before each call to the given function.
If another function was created from the same source as a given one,
calling it will also trigger the breakpoint.
     *
     * @link Protocol [Debugger#setBreakpointOnFunctionCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointOnFunctionCall) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBreakpointOnFunctionCall(input: SetBreakpointOnFunctionCallRequest) = connection.request("Debugger.setBreakpointOnFunctionCall", input, SetBreakpointOnFunctionCallResponse::class.java)

    /**
     * Activates / deactivates all breakpoints on the page.
     *
     * @link Protocol [Debugger#setBreakpointsActive](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointsActive) method documentation.
     */
    fun setBreakpointsActive(input: SetBreakpointsActiveRequest) = connection.request("Debugger.setBreakpointsActive", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions or
no exceptions. Initial pause on exceptions state is `none`.
     *
     * @link Protocol [Debugger#setPauseOnExceptions](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setPauseOnExceptions) method documentation.
     */
    fun setPauseOnExceptions(input: SetPauseOnExceptionsRequest) = connection.request("Debugger.setPauseOnExceptions", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Changes return value in top frame. Available only at return break position.
     *
     * @link Protocol [Debugger#setReturnValue](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setReturnValue) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setReturnValue(input: SetReturnValueRequest) = connection.request("Debugger.setReturnValue", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Edits JavaScript source live.
     *
     * @link Protocol [Debugger#setScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setScriptSource) method documentation.
     */
    fun setScriptSource(input: SetScriptSourceRequest) = connection.request("Debugger.setScriptSource", input, SetScriptSourceResponse::class.java)

    /**
     * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
     *
     * @link Protocol [Debugger#setSkipAllPauses](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setSkipAllPauses) method documentation.
     */
    fun setSkipAllPauses(input: SetSkipAllPausesRequest) = connection.request("Debugger.setSkipAllPauses", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Changes value of variable in a callframe. Object-based scopes are not supported and must be
mutated manually.
     *
     * @link Protocol [Debugger#setVariableValue](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setVariableValue) method documentation.
     */
    fun setVariableValue(input: SetVariableValueRequest) = connection.request("Debugger.setVariableValue", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Steps into the function call.
     *
     * @link Protocol [Debugger#stepInto](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-stepInto) method documentation.
     */
    fun stepInto(input: StepIntoRequest) = connection.request("Debugger.stepInto", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Steps out of the function call.
     *
     * @link Protocol [Debugger#stepOut](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-stepOut) method documentation.
     */
    fun stepOut() = connection.request("Debugger.stepOut", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Steps over the statement.
     *
     * @link Protocol [Debugger#stepOver](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-stepOver) method documentation.
     */
    fun stepOver() = connection.request("Debugger.stepOver", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Fired when breakpoint is resolved to an actual script and location.
     */
    fun breakpointResolved(): io.reactivex.Flowable<BreakpointResolvedEvent> = connection.events("Debugger.breakpointResolved", BreakpointResolvedEvent::class.java)

    /**
     *  Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
     */
    fun paused(): io.reactivex.Flowable<PausedEvent> = connection.events("Debugger.paused", PausedEvent::class.java)

    /**
     *  Fired when the virtual machine resumed execution.
     */
    fun resumed(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Debugger.resumed", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Fired when virtual machine fails to parse the script.
     */
    fun scriptFailedToParse(): io.reactivex.Flowable<ScriptFailedToParseEvent> = connection.events("Debugger.scriptFailedToParse", ScriptFailedToParseEvent::class.java)

    /**
     *  Fired when virtual machine parses script. This event is also fired for all known and uncollected
scripts upon enabling debugger.
     */
    fun scriptParsed(): io.reactivex.Flowable<ScriptParsedEvent> = connection.events("Debugger.scriptParsed", ScriptParsedEvent::class.java)

    /**
     * Returns flowable capturing all Debugger domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Debugger"
        }
    }
}
/**
 * Represents request frame that can be used with [Debugger#continueToLocation](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-continueToLocation) operation call.
 *
 * Continues execution until specific location is reached.
 * @link [Debugger#continueToLocation](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-continueToLocation) method documentation.
 * @see [DebuggerOperations.continueToLocation]
 */
data class ContinueToLocationRequest(
    /**
     * Location to continue to.
     */
    val location: Location,

    /**
     *
     */
    val targetCallFrames: String? = null

)

/**
 * Represents request frame that can be used with [Debugger#enable](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-enable) operation call.
 *
 * Enables debugger for the given page. Clients should not assume that the debugging has been
enabled until the result for this command is received.
 * @link [Debugger#enable](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-enable) method documentation.
 * @see [DebuggerOperations.enable]
 */
data class EnableRequest(
    /**
     * The maximum size in bytes of collected scripts (not referenced by other heap objects)
the debugger can hold. Puts no limit if paramter is omitted.
     */
    @pl.wendigo.chrome.protocol.Experimental val maxScriptsCacheSize: Double? = null

)
/**
 * Represents response frame that is returned from [Debugger#enable](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-enable) operation call.
 * Enables debugger for the given page. Clients should not assume that the debugging has been
enabled until the result for this command is received.
 *
  
 * @link [Debugger#enable](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-enable) method documentation.
 * @see [DebuggerOperations.enable]
 */
data class EnableResponse(
    /**  
     * Unique identifier of the debugger.  
     */  
    val debuggerId: pl.wendigo.chrome.api.runtime.UniqueDebuggerId

)

/**
 * Represents request frame that can be used with [Debugger#evaluateOnCallFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-evaluateOnCallFrame) operation call.
 *
 * Evaluates expression on a given call frame.
 * @link [Debugger#evaluateOnCallFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-evaluateOnCallFrame) method documentation.
 * @see [DebuggerOperations.evaluateOnCallFrame]
 */
data class EvaluateOnCallFrameRequest(
    /**
     * Call frame identifier to evaluate on.
     */
    val callFrameId: CallFrameId,

    /**
     * Expression to evaluate.
     */
    val expression: String,

    /**
     * String object group name to put result into (allows rapid releasing resulting object handles
using `releaseObjectGroup`).
     */
    val objectGroup: String? = null,

    /**
     * Specifies whether command line API should be available to the evaluated expression, defaults
to false.
     */
    val includeCommandLineAPI: Boolean? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
execution. Overrides `setPauseOnException` state.
     */
    val silent: Boolean? = null,

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    val returnByValue: Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    @pl.wendigo.chrome.protocol.Experimental val generatePreview: Boolean? = null,

    /**
     * Whether to throw an exception if side effect cannot be ruled out during evaluation.
     */
    val throwOnSideEffect: Boolean? = null,

    /**
     * Terminate execution after timing out (number of milliseconds).
     */
    @pl.wendigo.chrome.protocol.Experimental val timeout: pl.wendigo.chrome.api.runtime.TimeDelta? = null

)
/**
 * Represents response frame that is returned from [Debugger#evaluateOnCallFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-evaluateOnCallFrame) operation call.
 * Evaluates expression on a given call frame.
 *
  
 * @link [Debugger#evaluateOnCallFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-evaluateOnCallFrame) method documentation.
 * @see [DebuggerOperations.evaluateOnCallFrame]
 */
data class EvaluateOnCallFrameResponse(
    /**  
     * Object wrapper for the evaluation result.  
     */  
    val result: pl.wendigo.chrome.api.runtime.RemoteObject,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: pl.wendigo.chrome.api.runtime.ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Debugger#getPossibleBreakpoints](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getPossibleBreakpoints) operation call.
 *
 * Returns possible locations for breakpoint. scriptId in start and end range locations should be
the same.
 * @link [Debugger#getPossibleBreakpoints](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getPossibleBreakpoints) method documentation.
 * @see [DebuggerOperations.getPossibleBreakpoints]
 */
data class GetPossibleBreakpointsRequest(
    /**
     * Start of range to search possible breakpoint locations in.
     */
    val start: Location,

    /**
     * End of range to search possible breakpoint locations in (excluding). When not specified, end
of scripts is used as end of range.
     */
    val end: Location? = null,

    /**
     * Only consider locations which are in the same (non-nested) function as start.
     */
    val restrictToFunction: Boolean? = null

)
/**
 * Represents response frame that is returned from [Debugger#getPossibleBreakpoints](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getPossibleBreakpoints) operation call.
 * Returns possible locations for breakpoint. scriptId in start and end range locations should be
the same.
 *
  
 * @link [Debugger#getPossibleBreakpoints](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getPossibleBreakpoints) method documentation.
 * @see [DebuggerOperations.getPossibleBreakpoints]
 */
data class GetPossibleBreakpointsResponse(
    /**  
     * List of the possible breakpoint locations.  
     */  
    val locations: List<BreakLocation>

)

/**
 * Represents request frame that can be used with [Debugger#getScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getScriptSource) operation call.
 *
 * Returns source for the script with given id.
 * @link [Debugger#getScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getScriptSource) method documentation.
 * @see [DebuggerOperations.getScriptSource]
 */
data class GetScriptSourceRequest(
    /**
     * Id of the script to get source for.
     */
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId

)
/**
 * Represents response frame that is returned from [Debugger#getScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getScriptSource) operation call.
 * Returns source for the script with given id.
 *
  
 * @link [Debugger#getScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getScriptSource) method documentation.
 * @see [DebuggerOperations.getScriptSource]
 */
data class GetScriptSourceResponse(
    /**  
     * Script source.  
     */  
    val scriptSource: String

)

/**
 * Represents request frame that can be used with [Debugger#getWasmBytecode](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getWasmBytecode) operation call.
 *
 * Returns bytecode for the WebAssembly script with given id.
 * @link [Debugger#getWasmBytecode](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getWasmBytecode) method documentation.
 * @see [DebuggerOperations.getWasmBytecode]
 */
data class GetWasmBytecodeRequest(
    /**
     * Id of the Wasm script to get source for.
     */
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId

)
/**
 * Represents response frame that is returned from [Debugger#getWasmBytecode](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getWasmBytecode) operation call.
 * Returns bytecode for the WebAssembly script with given id.
 *
  
 * @link [Debugger#getWasmBytecode](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getWasmBytecode) method documentation.
 * @see [DebuggerOperations.getWasmBytecode]
 */
data class GetWasmBytecodeResponse(
    /**  
     * Script source.  
     */  
    val bytecode: String

)

/**
 * Represents request frame that can be used with [Debugger#getStackTrace](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getStackTrace) operation call.
 *
 * Returns stack trace with given `stackTraceId`.
 * @link [Debugger#getStackTrace](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getStackTrace) method documentation.
 * @see [DebuggerOperations.getStackTrace]
 */
data class GetStackTraceRequest(
    /**
     *
     */
    val stackTraceId: pl.wendigo.chrome.api.runtime.StackTraceId

)
/**
 * Represents response frame that is returned from [Debugger#getStackTrace](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getStackTrace) operation call.
 * Returns stack trace with given `stackTraceId`.
 *
  
 * @link [Debugger#getStackTrace](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-getStackTrace) method documentation.
 * @see [DebuggerOperations.getStackTrace]
 */
data class GetStackTraceResponse(
    /**  
     *  
     */  
    val stackTrace: pl.wendigo.chrome.api.runtime.StackTrace

)

/**
 * Represents request frame that can be used with [Debugger#pauseOnAsyncCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-pauseOnAsyncCall) operation call.
 *
 *
 * @link [Debugger#pauseOnAsyncCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-pauseOnAsyncCall) method documentation.
 * @see [DebuggerOperations.pauseOnAsyncCall]
 */
data class PauseOnAsyncCallRequest(
    /**
     * Debugger will pause when async call with given stack trace is started.
     */
    val parentStackTraceId: pl.wendigo.chrome.api.runtime.StackTraceId

)

/**
 * Represents request frame that can be used with [Debugger#removeBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-removeBreakpoint) operation call.
 *
 * Removes JavaScript breakpoint.
 * @link [Debugger#removeBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-removeBreakpoint) method documentation.
 * @see [DebuggerOperations.removeBreakpoint]
 */
data class RemoveBreakpointRequest(
    /**
     *
     */
    val breakpointId: BreakpointId

)

/**
 * Represents request frame that can be used with [Debugger#restartFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-restartFrame) operation call.
 *
 * Restarts particular call frame from the beginning.
 * @link [Debugger#restartFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-restartFrame) method documentation.
 * @see [DebuggerOperations.restartFrame]
 */
data class RestartFrameRequest(
    /**
     * Call frame identifier to evaluate on.
     */
    val callFrameId: CallFrameId

)
/**
 * Represents response frame that is returned from [Debugger#restartFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-restartFrame) operation call.
 * Restarts particular call frame from the beginning.
 *
  
 * @link [Debugger#restartFrame](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-restartFrame) method documentation.
 * @see [DebuggerOperations.restartFrame]
 */
data class RestartFrameResponse(
    /**  
     * New stack trace.  
     */  
    val callFrames: List<CallFrame>,

    /**  
     * Async stack trace, if any.  
     */  
    val asyncStackTrace: pl.wendigo.chrome.api.runtime.StackTrace? = null,

    /**  
     * Async stack trace, if any.  
     */  
    val asyncStackTraceId: pl.wendigo.chrome.api.runtime.StackTraceId? = null

)

/**
 * Represents request frame that can be used with [Debugger#searchInContent](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-searchInContent) operation call.
 *
 * Searches for given string in script content.
 * @link [Debugger#searchInContent](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-searchInContent) method documentation.
 * @see [DebuggerOperations.searchInContent]
 */
data class SearchInContentRequest(
    /**
     * Id of the script to search in.
     */
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**
     * String to search for.
     */
    val query: String,

    /**
     * If true, search is case sensitive.
     */
    val caseSensitive: Boolean? = null,

    /**
     * If true, treats string parameter as regex.
     */
    val isRegex: Boolean? = null

)
/**
 * Represents response frame that is returned from [Debugger#searchInContent](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-searchInContent) operation call.
 * Searches for given string in script content.
 *
  
 * @link [Debugger#searchInContent](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-searchInContent) method documentation.
 * @see [DebuggerOperations.searchInContent]
 */
data class SearchInContentResponse(
    /**  
     * List of search matches.  
     */  
    val result: List<SearchMatch>

)

/**
 * Represents request frame that can be used with [Debugger#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setAsyncCallStackDepth) operation call.
 *
 * Enables or disables async call stacks tracking.
 * @link [Debugger#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setAsyncCallStackDepth) method documentation.
 * @see [DebuggerOperations.setAsyncCallStackDepth]
 */
data class SetAsyncCallStackDepthRequest(
    /**
     * Maximum depth of async call stacks. Setting to `0` will effectively disable collecting async
call stacks (default).
     */
    val maxDepth: Int

)

/**
 * Represents request frame that can be used with [Debugger#setBlackboxPatterns](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBlackboxPatterns) operation call.
 *
 * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in
scripts with url matching one of the patterns. VM will try to leave blackboxed script by
performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
 * @link [Debugger#setBlackboxPatterns](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBlackboxPatterns) method documentation.
 * @see [DebuggerOperations.setBlackboxPatterns]
 */
data class SetBlackboxPatternsRequest(
    /**
     * Array of regexps that will be used to check script url for blackbox state.
     */
    val patterns: List<String>

)

/**
 * Represents request frame that can be used with [Debugger#setBlackboxedRanges](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBlackboxedRanges) operation call.
 *
 * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted
scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
Positions array contains positions where blackbox state is changed. First interval isn't
blackboxed. Array should be sorted.
 * @link [Debugger#setBlackboxedRanges](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBlackboxedRanges) method documentation.
 * @see [DebuggerOperations.setBlackboxedRanges]
 */
data class SetBlackboxedRangesRequest(
    /**
     * Id of the script.
     */
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**
     *
     */
    val positions: List<ScriptPosition>

)

/**
 * Represents request frame that can be used with [Debugger#setBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpoint) operation call.
 *
 * Sets JavaScript breakpoint at a given location.
 * @link [Debugger#setBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpoint) method documentation.
 * @see [DebuggerOperations.setBreakpoint]
 */
data class SetBreakpointRequest(
    /**
     * Location to set breakpoint in.
     */
    val location: Location,

    /**
     * Expression to use as a breakpoint condition. When specified, debugger will only stop on the
breakpoint if this expression evaluates to true.
     */
    val condition: String? = null

)
/**
 * Represents response frame that is returned from [Debugger#setBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpoint) operation call.
 * Sets JavaScript breakpoint at a given location.
 *
  
 * @link [Debugger#setBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpoint) method documentation.
 * @see [DebuggerOperations.setBreakpoint]
 */
data class SetBreakpointResponse(
    /**  
     * Id of the created breakpoint for further reference.  
     */  
    val breakpointId: BreakpointId,

    /**  
     * Location this breakpoint resolved into.  
     */  
    val actualLocation: Location

)

/**
 * Represents request frame that can be used with [Debugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setInstrumentationBreakpoint) operation call.
 *
 * Sets instrumentation breakpoint.
 * @link [Debugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setInstrumentationBreakpoint) method documentation.
 * @see [DebuggerOperations.setInstrumentationBreakpoint]
 */
data class SetInstrumentationBreakpointRequest(
    /**
     * Instrumentation name.
     */
    val instrumentation: String

)
/**
 * Represents response frame that is returned from [Debugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setInstrumentationBreakpoint) operation call.
 * Sets instrumentation breakpoint.
 *
  
 * @link [Debugger#setInstrumentationBreakpoint](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setInstrumentationBreakpoint) method documentation.
 * @see [DebuggerOperations.setInstrumentationBreakpoint]
 */
data class SetInstrumentationBreakpointResponse(
    /**  
     * Id of the created breakpoint for further reference.  
     */  
    val breakpointId: BreakpointId

)

/**
 * Represents request frame that can be used with [Debugger#setBreakpointByUrl](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointByUrl) operation call.
 *
 * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this
command is issued, all existing parsed scripts will have breakpoints resolved and returned in
`locations` property. Further matching script parsing will result in subsequent
`breakpointResolved` events issued. This logical breakpoint will survive page reloads.
 * @link [Debugger#setBreakpointByUrl](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointByUrl) method documentation.
 * @see [DebuggerOperations.setBreakpointByUrl]
 */
data class SetBreakpointByUrlRequest(
    /**
     * Line number to set breakpoint at.
     */
    val lineNumber: Int,

    /**
     * URL of the resources to set breakpoint on.
     */
    val url: String? = null,

    /**
     * Regex pattern for the URLs of the resources to set breakpoints on. Either `url` or
`urlRegex` must be specified.
     */
    val urlRegex: String? = null,

    /**
     * Script hash of the resources to set breakpoint on.
     */
    val scriptHash: String? = null,

    /**
     * Offset in the line to set breakpoint at.
     */
    val columnNumber: Int? = null,

    /**
     * Expression to use as a breakpoint condition. When specified, debugger will only stop on the
breakpoint if this expression evaluates to true.
     */
    val condition: String? = null

)
/**
 * Represents response frame that is returned from [Debugger#setBreakpointByUrl](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointByUrl) operation call.
 * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this
command is issued, all existing parsed scripts will have breakpoints resolved and returned in
`locations` property. Further matching script parsing will result in subsequent
`breakpointResolved` events issued. This logical breakpoint will survive page reloads.
 *
  
 * @link [Debugger#setBreakpointByUrl](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointByUrl) method documentation.
 * @see [DebuggerOperations.setBreakpointByUrl]
 */
data class SetBreakpointByUrlResponse(
    /**  
     * Id of the created breakpoint for further reference.  
     */  
    val breakpointId: BreakpointId,

    /**  
     * List of the locations this breakpoint resolved into upon addition.  
     */  
    val locations: List<Location>

)

/**
 * Represents request frame that can be used with [Debugger#setBreakpointOnFunctionCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointOnFunctionCall) operation call.
 *
 * Sets JavaScript breakpoint before each call to the given function.
If another function was created from the same source as a given one,
calling it will also trigger the breakpoint.
 * @link [Debugger#setBreakpointOnFunctionCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointOnFunctionCall) method documentation.
 * @see [DebuggerOperations.setBreakpointOnFunctionCall]
 */
data class SetBreakpointOnFunctionCallRequest(
    /**
     * Function object id.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId,

    /**
     * Expression to use as a breakpoint condition. When specified, debugger will
stop on the breakpoint if this expression evaluates to true.
     */
    val condition: String? = null

)
/**
 * Represents response frame that is returned from [Debugger#setBreakpointOnFunctionCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointOnFunctionCall) operation call.
 * Sets JavaScript breakpoint before each call to the given function.
If another function was created from the same source as a given one,
calling it will also trigger the breakpoint.
 *
  
 * @link [Debugger#setBreakpointOnFunctionCall](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointOnFunctionCall) method documentation.
 * @see [DebuggerOperations.setBreakpointOnFunctionCall]
 */
data class SetBreakpointOnFunctionCallResponse(
    /**  
     * Id of the created breakpoint for further reference.  
     */  
    val breakpointId: BreakpointId

)

/**
 * Represents request frame that can be used with [Debugger#setBreakpointsActive](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointsActive) operation call.
 *
 * Activates / deactivates all breakpoints on the page.
 * @link [Debugger#setBreakpointsActive](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setBreakpointsActive) method documentation.
 * @see [DebuggerOperations.setBreakpointsActive]
 */
data class SetBreakpointsActiveRequest(
    /**
     * New value for breakpoints active state.
     */
    val active: Boolean

)

/**
 * Represents request frame that can be used with [Debugger#setPauseOnExceptions](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setPauseOnExceptions) operation call.
 *
 * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions or
no exceptions. Initial pause on exceptions state is `none`.
 * @link [Debugger#setPauseOnExceptions](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setPauseOnExceptions) method documentation.
 * @see [DebuggerOperations.setPauseOnExceptions]
 */
data class SetPauseOnExceptionsRequest(
    /**
     * Pause on exceptions mode.
     */
    val state: String

)

/**
 * Represents request frame that can be used with [Debugger#setReturnValue](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setReturnValue) operation call.
 *
 * Changes return value in top frame. Available only at return break position.
 * @link [Debugger#setReturnValue](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setReturnValue) method documentation.
 * @see [DebuggerOperations.setReturnValue]
 */
data class SetReturnValueRequest(
    /**
     * New return value.
     */
    val newValue: pl.wendigo.chrome.api.runtime.CallArgument

)

/**
 * Represents request frame that can be used with [Debugger#setScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setScriptSource) operation call.
 *
 * Edits JavaScript source live.
 * @link [Debugger#setScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setScriptSource) method documentation.
 * @see [DebuggerOperations.setScriptSource]
 */
data class SetScriptSourceRequest(
    /**
     * Id of the script to edit.
     */
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**
     * New content of the script.
     */
    val scriptSource: String,

    /**
     * If true the change will not actually be applied. Dry run may be used to get result
description without actually modifying the code.
     */
    val dryRun: Boolean? = null

)
/**
 * Represents response frame that is returned from [Debugger#setScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setScriptSource) operation call.
 * Edits JavaScript source live.
 *
  
 * @link [Debugger#setScriptSource](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setScriptSource) method documentation.
 * @see [DebuggerOperations.setScriptSource]
 */
data class SetScriptSourceResponse(
    /**  
     * New stack trace in case editing has happened while VM was stopped.  
     */  
    val callFrames: List<CallFrame>? = null,

    /**  
     * Whether current call stack  was modified after applying the changes.  
     */  
    val stackChanged: Boolean? = null,

    /**  
     * Async stack trace, if any.  
     */  
    val asyncStackTrace: pl.wendigo.chrome.api.runtime.StackTrace? = null,

    /**  
     * Async stack trace, if any.  
     */  
    val asyncStackTraceId: pl.wendigo.chrome.api.runtime.StackTraceId? = null,

    /**  
     * Exception details if any.  
     */  
    val exceptionDetails: pl.wendigo.chrome.api.runtime.ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Debugger#setSkipAllPauses](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setSkipAllPauses) operation call.
 *
 * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
 * @link [Debugger#setSkipAllPauses](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setSkipAllPauses) method documentation.
 * @see [DebuggerOperations.setSkipAllPauses]
 */
data class SetSkipAllPausesRequest(
    /**
     * New value for skip pauses state.
     */
    val skip: Boolean

)

/**
 * Represents request frame that can be used with [Debugger#setVariableValue](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setVariableValue) operation call.
 *
 * Changes value of variable in a callframe. Object-based scopes are not supported and must be
mutated manually.
 * @link [Debugger#setVariableValue](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-setVariableValue) method documentation.
 * @see [DebuggerOperations.setVariableValue]
 */
data class SetVariableValueRequest(
    /**
     * 0-based number of scope as was listed in scope chain. Only 'local', 'closure' and 'catch'
scope types are allowed. Other scopes could be manipulated manually.
     */
    val scopeNumber: Int,

    /**
     * Variable name.
     */
    val variableName: String,

    /**
     * New variable value.
     */
    val newValue: pl.wendigo.chrome.api.runtime.CallArgument,

    /**
     * Id of callframe that holds variable.
     */
    val callFrameId: CallFrameId

)

/**
 * Represents request frame that can be used with [Debugger#stepInto](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-stepInto) operation call.
 *
 * Steps into the function call.
 * @link [Debugger#stepInto](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#method-stepInto) method documentation.
 * @see [DebuggerOperations.stepInto]
 */
data class StepIntoRequest(
    /**
     * Debugger will pause on the execution of the first async task which was scheduled
before next pause.
     */
    @pl.wendigo.chrome.protocol.Experimental val breakOnAsyncCall: Boolean? = null

)

/**
 * Fired when breakpoint is resolved to an actual script and location.
 *
 * @link [Debugger#breakpointResolved](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#event-breakpointResolved) event documentation.
 */
data class BreakpointResolvedEvent(
    /**  
     * Breakpoint unique identifier.  
     */  
    val breakpointId: BreakpointId,

    /**  
     * Actual breakpoint location.  
     */  
    val location: Location

) : pl.wendigo.chrome.protocol.Event(domain = "Debugger", name = "breakpointResolved")

/**
 * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
 *
 * @link [Debugger#paused](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#event-paused) event documentation.
 */
data class PausedEvent(
    /**  
     * Call stack the virtual machine stopped on.  
     */  
    val callFrames: List<CallFrame>,

    /**  
     * Pause reason.  
     */  
    val reason: String,

    /**  
     * Object containing break-specific auxiliary properties.  
     */  
    val data: com.fasterxml.jackson.databind.JsonNode? = null,

    /**  
     * Hit breakpoints IDs  
     */  
    val hitBreakpoints: List<String>? = null,

    /**  
     * Async stack trace, if any.  
     */  
    val asyncStackTrace: pl.wendigo.chrome.api.runtime.StackTrace? = null,

    /**  
     * Async stack trace, if any.  
     */  
    val asyncStackTraceId: pl.wendigo.chrome.api.runtime.StackTraceId? = null,

    /**  
     * Never present, will be removed.  
     */  
    val asyncCallStackTraceId: pl.wendigo.chrome.api.runtime.StackTraceId? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Debugger", name = "paused")

/**
 * Fired when virtual machine fails to parse the script.
 *
 * @link [Debugger#scriptFailedToParse](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#event-scriptFailedToParse) event documentation.
 */
data class ScriptFailedToParseEvent(
    /**  
     * Identifier of the script parsed.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * URL or name of the script parsed (if any).  
     */  
    val url: String,

    /**  
     * Line offset of the script within the resource with given URL (for script tags).  
     */  
    val startLine: Int,

    /**  
     * Column offset of the script within the resource with given URL.  
     */  
    val startColumn: Int,

    /**  
     * Last line of the script.  
     */  
    val endLine: Int,

    /**  
     * Length of the last line of the script.  
     */  
    val endColumn: Int,

    /**  
     * Specifies script creation context.  
     */  
    val executionContextId: pl.wendigo.chrome.api.runtime.ExecutionContextId,

    /**  
     * Content hash of the script.  
     */  
    val hash: String,

    /**  
     * Embedder-specific auxiliary data.  
     */  
    val executionContextAuxData: com.fasterxml.jackson.databind.JsonNode? = null,

    /**  
     * URL of source map associated with script (if any).  
     */  
    val sourceMapURL: String? = null,

    /**  
     * True, if this script has sourceURL.  
     */  
    val hasSourceURL: Boolean? = null,

    /**  
     * True, if this script is ES6 module.  
     */  
    val isModule: Boolean? = null,

    /**  
     * This script length.  
     */  
    val length: Int? = null,

    /**  
     * JavaScript top stack frame of where the script parsed event was triggered if available.  
     */  
    val stackTrace: pl.wendigo.chrome.api.runtime.StackTrace? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Debugger", name = "scriptFailedToParse")

/**
 * Fired when virtual machine parses script. This event is also fired for all known and uncollected
scripts upon enabling debugger.
 *
 * @link [Debugger#scriptParsed](https://chromedevtools.github.io/devtools-protocol/tot/Debugger#event-scriptParsed) event documentation.
 */
data class ScriptParsedEvent(
    /**  
     * Identifier of the script parsed.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * URL or name of the script parsed (if any).  
     */  
    val url: String,

    /**  
     * Line offset of the script within the resource with given URL (for script tags).  
     */  
    val startLine: Int,

    /**  
     * Column offset of the script within the resource with given URL.  
     */  
    val startColumn: Int,

    /**  
     * Last line of the script.  
     */  
    val endLine: Int,

    /**  
     * Length of the last line of the script.  
     */  
    val endColumn: Int,

    /**  
     * Specifies script creation context.  
     */  
    val executionContextId: pl.wendigo.chrome.api.runtime.ExecutionContextId,

    /**  
     * Content hash of the script.  
     */  
    val hash: String,

    /**  
     * Embedder-specific auxiliary data.  
     */  
    val executionContextAuxData: com.fasterxml.jackson.databind.JsonNode? = null,

    /**  
     * True, if this script is generated as a result of the live edit operation.  
     */  
    val isLiveEdit: Boolean? = null,

    /**  
     * URL of source map associated with script (if any).  
     */  
    val sourceMapURL: String? = null,

    /**  
     * True, if this script has sourceURL.  
     */  
    val hasSourceURL: Boolean? = null,

    /**  
     * True, if this script is ES6 module.  
     */  
    val isModule: Boolean? = null,

    /**  
     * This script length.  
     */  
    val length: Int? = null,

    /**  
     * JavaScript top stack frame of where the script parsed event was triggered if available.  
     */  
    val stackTrace: pl.wendigo.chrome.api.runtime.StackTrace? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Debugger", name = "scriptParsed")
