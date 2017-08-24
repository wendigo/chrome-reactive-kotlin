package pl.wendigo.chrome.domain.runtime

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects. Evaluation results are returned as mirror object that expose object type, string representation and unique identifier that can be used for further object reference. Original objects are maintained in memory unless they are either explicitly released or are released along with the other objects in their object group.
 */
class RuntimeDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Evaluates expression on global object.
     */
    fun evaluate(input : EvaluateRequest) : io.reactivex.Single<EvaluateResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.evaluate", input, EvaluateResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Add handler to promise with given promise object id.
     */
    fun awaitPromise(input : AwaitPromiseRequest) : io.reactivex.Single<AwaitPromiseResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.awaitPromise", input, AwaitPromiseResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
     */
    fun callFunctionOn(input : CallFunctionOnRequest) : io.reactivex.Single<CallFunctionOnResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.callFunctionOn", input, CallFunctionOnResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns properties of a given object. Object group of the result is inherited from the target object.
     */
    fun getProperties(input : GetPropertiesRequest) : io.reactivex.Single<GetPropertiesResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.getProperties", input, GetPropertiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Releases remote object with given id.
     */
    fun releaseObject(input : ReleaseObjectRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.releaseObject", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Releases all remote objects that belong to a given group.
     */
    fun releaseObjectGroup(input : ReleaseObjectGroupRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.releaseObjectGroup", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Tells inspected instance to run if it was waiting for debugger to attach.
     */
    fun runIfWaitingForDebugger() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.runIfWaitingForDebugger", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables reporting of execution contexts creation by means of <code>executionContextCreated</code> event. When the reporting gets enabled the event will be sent immediately for each existing execution context.
     */
    fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables reporting of execution contexts creation.
     */
    fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Discards collected exceptions and console API calls.
     */
    fun discardConsoleEntries() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.discardConsoleEntries", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun setCustomObjectFormatterEnabled(input : SetCustomObjectFormatterEnabledRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Runtime.setCustomObjectFormatterEnabled", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Compiles expression.
     */
    fun compileScript(input : CompileScriptRequest) : io.reactivex.Single<CompileScriptResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.compileScript", input, CompileScriptResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Runs script with given id in a given context.
     */
    fun runScript(input : RunScriptRequest) : io.reactivex.Single<RunScriptResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.runScript", input, RunScriptResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun queryObjects(input : QueryObjectsRequest) : io.reactivex.Single<QueryObjectsResponse> {
        return connectionRemote.runAndCaptureResponse("Runtime.queryObjects", input, QueryObjectsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Issued when new execution context is created.
     */
    fun executionContextCreated() : io.reactivex.Flowable<ExecutionContextCreatedEvent> {
        return executionContextCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when new execution context is created.
     */
    fun executionContextCreatedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExecutionContextCreatedEvent>> {
        return connectionRemote.captureEvents("Runtime.executionContextCreated", ExecutionContextCreatedEvent::class.java)
    }

    /**
     * Issued when execution context is destroyed.
     */
    fun executionContextDestroyed() : io.reactivex.Flowable<ExecutionContextDestroyedEvent> {
        return executionContextDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when execution context is destroyed.
     */
    fun executionContextDestroyedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExecutionContextDestroyedEvent>> {
        return connectionRemote.captureEvents("Runtime.executionContextDestroyed", ExecutionContextDestroyedEvent::class.java)
    }

    /**
     * Issued when all executionContexts were cleared in browser
     */
    fun executionContextsCleared() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return executionContextsClearedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when all executionContexts were cleared in browser
     */
    fun executionContextsClearedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Runtime.executionContextsCleared", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Issued when exception was thrown and unhandled.
     */
    fun exceptionThrown() : io.reactivex.Flowable<ExceptionThrownEvent> {
        return exceptionThrownTimed().map {
            it.value()
        }
    }

    /**
     * Issued when exception was thrown and unhandled.
     */
    fun exceptionThrownTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExceptionThrownEvent>> {
        return connectionRemote.captureEvents("Runtime.exceptionThrown", ExceptionThrownEvent::class.java)
    }

    /**
     * Issued when unhandled exception was revoked.
     */
    fun exceptionRevoked() : io.reactivex.Flowable<ExceptionRevokedEvent> {
        return exceptionRevokedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when unhandled exception was revoked.
     */
    fun exceptionRevokedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExceptionRevokedEvent>> {
        return connectionRemote.captureEvents("Runtime.exceptionRevoked", ExceptionRevokedEvent::class.java)
    }

    /**
     * Issued when console API was called.
     */
    fun consoleAPICalled() : io.reactivex.Flowable<ConsoleAPICalledEvent> {
        return consoleAPICalledTimed().map {
            it.value()
        }
    }

    /**
     * Issued when console API was called.
     */
    fun consoleAPICalledTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ConsoleAPICalledEvent>> {
        return connectionRemote.captureEvents("Runtime.consoleAPICalled", ConsoleAPICalledEvent::class.java)
    }

    /**
     * Issued when object should be inspected (for example, as a result of inspect() command line API call).
     */
    fun inspectRequested() : io.reactivex.Flowable<InspectRequestedEvent> {
        return inspectRequestedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when object should be inspected (for example, as a result of inspect() command line API call).
     */
    fun inspectRequestedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<InspectRequestedEvent>> {
        return connectionRemote.captureEvents("Runtime.inspectRequested", InspectRequestedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Runtime domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Runtime"
        }
    }
}
/**
 * Represents request frame that can be used with Runtime.evaluate method call.
 *
 * Evaluates expression on global object.
 */
data class EvaluateRequest (
    /**
     * Expression to evaluate.
     */
    val expression : String,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup : String? = null,

    /**
     * Determines whether Command Line API should be available during the evaluation.
     */
    val includeCommandLineAPI : Boolean? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
     */
    val silent : Boolean? = null,

    /**
     * Specifies in which execution context to perform evaluation. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     */
    val contextId : ExecutionContextId? = null,

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    val returnByValue : Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    @pl.wendigo.chrome.Experimental val generatePreview : Boolean? = null,

    /**
     * Whether execution should be treated as initiated by user in the UI.
     */
    @pl.wendigo.chrome.Experimental val userGesture : Boolean? = null,

    /**
     * Whether execution should <code>await</code> for resulting value and return once awaited promise is resolved.
     */
    val awaitPromise : Boolean? = null

)

/**
 * Represents response frame for Runtime.evaluate method call.
 *
 * Evaluates expression on global object.
 */
data class EvaluateResponse(
  /**
   * Evaluation result.
   */
  val result : RemoteObject,

  /**
   * Exception details.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with Runtime.awaitPromise method call.
 *
 * Add handler to promise with given promise object id.
 */
data class AwaitPromiseRequest (
    /**
     * Identifier of the promise.
     */
    val promiseObjectId : RemoteObjectId,

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    val returnByValue : Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    val generatePreview : Boolean? = null

)

/**
 * Represents response frame for Runtime.awaitPromise method call.
 *
 * Add handler to promise with given promise object id.
 */
data class AwaitPromiseResponse(
  /**
   * Promise result. Will contain rejected value if promise was rejected.
   */
  val result : RemoteObject,

  /**
   * Exception details if stack strace is available.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with Runtime.callFunctionOn method call.
 *
 * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
 */
data class CallFunctionOnRequest (
    /**
     * Identifier of the object to call function on.
     */
    val objectId : RemoteObjectId,

    /**
     * Declaration of the function to call.
     */
    val functionDeclaration : String,

    /**
     * Call arguments. All call arguments must belong to the same JavaScript world as the target object.
     */
    val arguments : List<CallArgument>? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
     */
    val silent : Boolean? = null,

    /**
     * Whether the result is expected to be a JSON object which should be sent by value.
     */
    val returnByValue : Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    @pl.wendigo.chrome.Experimental val generatePreview : Boolean? = null,

    /**
     * Whether execution should be treated as initiated by user in the UI.
     */
    @pl.wendigo.chrome.Experimental val userGesture : Boolean? = null,

    /**
     * Whether execution should <code>await</code> for resulting value and return once awaited promise is resolved.
     */
    val awaitPromise : Boolean? = null

)

/**
 * Represents response frame for Runtime.callFunctionOn method call.
 *
 * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
 */
data class CallFunctionOnResponse(
  /**
   * Call result.
   */
  val result : RemoteObject,

  /**
   * Exception details.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with Runtime.getProperties method call.
 *
 * Returns properties of a given object. Object group of the result is inherited from the target object.
 */
data class GetPropertiesRequest (
    /**
     * Identifier of the object to return properties for.
     */
    val objectId : RemoteObjectId,

    /**
     * If true, returns properties belonging only to the element itself, not to its prototype chain.
     */
    val ownProperties : Boolean? = null,

    /**
     * If true, returns accessor properties (with getter/setter) only; internal properties are not returned either.
     */
    @pl.wendigo.chrome.Experimental val accessorPropertiesOnly : Boolean? = null,

    /**
     * Whether preview should be generated for the results.
     */
    @pl.wendigo.chrome.Experimental val generatePreview : Boolean? = null

)

/**
 * Represents response frame for Runtime.getProperties method call.
 *
 * Returns properties of a given object. Object group of the result is inherited from the target object.
 */
data class GetPropertiesResponse(
  /**
   * Object properties.
   */
  val result : List<PropertyDescriptor>,

  /**
   * Internal object properties (only of the element itself).
   */
  val internalProperties : List<InternalPropertyDescriptor>? = null,

  /**
   * Exception details.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with Runtime.releaseObject method call.
 *
 * Releases remote object with given id.
 */
data class ReleaseObjectRequest (
    /**
     * Identifier of the object to release.
     */
    val objectId : RemoteObjectId

)

/**
 * Represents request frame that can be used with Runtime.releaseObjectGroup method call.
 *
 * Releases all remote objects that belong to a given group.
 */
data class ReleaseObjectGroupRequest (
    /**
     * Symbolic object group name.
     */
    val objectGroup : String

)

/**
 * Represents request frame that can be used with Runtime.setCustomObjectFormatterEnabled method call.
 *
 *
 */
data class SetCustomObjectFormatterEnabledRequest (
    /**
     *
     */
    val enabled : Boolean

)

/**
 * Represents request frame that can be used with Runtime.compileScript method call.
 *
 * Compiles expression.
 */
data class CompileScriptRequest (
    /**
     * Expression to compile.
     */
    val expression : String,

    /**
     * Source url to be set for the script.
     */
    val sourceURL : String,

    /**
     * Specifies whether the compiled script should be persisted.
     */
    val persistScript : Boolean,

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     */
    val executionContextId : ExecutionContextId? = null

)

/**
 * Represents response frame for Runtime.compileScript method call.
 *
 * Compiles expression.
 */
data class CompileScriptResponse(
  /**
   * Id of the script.
   */
  val scriptId : ScriptId? = null,

  /**
   * Exception details.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with Runtime.runScript method call.
 *
 * Runs script with given id in a given context.
 */
data class RunScriptRequest (
    /**
     * Id of the script to run.
     */
    val scriptId : ScriptId,

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     */
    val executionContextId : ExecutionContextId? = null,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup : String? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
     */
    val silent : Boolean? = null,

    /**
     * Determines whether Command Line API should be available during the evaluation.
     */
    val includeCommandLineAPI : Boolean? = null,

    /**
     * Whether the result is expected to be a JSON object which should be sent by value.
     */
    val returnByValue : Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    val generatePreview : Boolean? = null,

    /**
     * Whether execution should <code>await</code> for resulting value and return once awaited promise is resolved.
     */
    val awaitPromise : Boolean? = null

)

/**
 * Represents response frame for Runtime.runScript method call.
 *
 * Runs script with given id in a given context.
 */
data class RunScriptResponse(
  /**
   * Run result.
   */
  val result : RemoteObject,

  /**
   * Exception details.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with Runtime.queryObjects method call.
 *
 *
 */
data class QueryObjectsRequest (
    /**
     * Identifier of the prototype to return objects for.
     */
    val prototypeObjectId : RemoteObjectId

)

/**
 * Represents response frame for Runtime.queryObjects method call.
 *
 *
 */
data class QueryObjectsResponse(
  /**
   * Array with objects.
   */
  val objects : RemoteObject

)

/**
 * Represents event frames for Runtime.executionContextCreated
 *
 * Issued when new execution context is created.
 */
data class ExecutionContextCreatedEvent(
  /**
   * A newly created execution context.
   */
  val context : ExecutionContextDescription

) : pl.wendigo.chrome.ProtocolEvent(domain = "Runtime", name = "executionContextCreated")

/**
 * Represents event frames for Runtime.executionContextDestroyed
 *
 * Issued when execution context is destroyed.
 */
data class ExecutionContextDestroyedEvent(
  /**
   * Id of the destroyed context
   */
  val executionContextId : ExecutionContextId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Runtime", name = "executionContextDestroyed")

/**
 * Represents event frames for Runtime.exceptionThrown
 *
 * Issued when exception was thrown and unhandled.
 */
data class ExceptionThrownEvent(
  /**
   * Timestamp of the exception.
   */
  val timestamp : Timestamp,

  /**
   *
   */
  val exceptionDetails : ExceptionDetails

) : pl.wendigo.chrome.ProtocolEvent(domain = "Runtime", name = "exceptionThrown")

/**
 * Represents event frames for Runtime.exceptionRevoked
 *
 * Issued when unhandled exception was revoked.
 */
data class ExceptionRevokedEvent(
  /**
   * Reason describing why exception was revoked.
   */
  val reason : String,

  /**
   * The id of revoked exception, as reported in <code>exceptionUnhandled</code>.
   */
  val exceptionId : Int

) : pl.wendigo.chrome.ProtocolEvent(domain = "Runtime", name = "exceptionRevoked")

/**
 * Represents event frames for Runtime.consoleAPICalled
 *
 * Issued when console API was called.
 */
data class ConsoleAPICalledEvent(
  /**
   * Type of the call.
   */
  val type : String,

  /**
   * Call arguments.
   */
  val args : List<RemoteObject>,

  /**
   * Identifier of the context where the call was made.
   */
  val executionContextId : ExecutionContextId,

  /**
   * Call timestamp.
   */
  val timestamp : Timestamp,

  /**
   * Stack trace captured when the call was made.
   */
  val stackTrace : StackTrace? = null,

  /**
   * Console context descriptor for calls on non-default console context (not console.*): 'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call on named context.
   */
  @pl.wendigo.chrome.Experimental val context : String? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Runtime", name = "consoleAPICalled")

/**
 * Represents event frames for Runtime.inspectRequested
 *
 * Issued when object should be inspected (for example, as a result of inspect() command line API call).
 */
data class InspectRequestedEvent(
  /**
   *
   */
  @get:com.fasterxml.jackson.annotation.JsonProperty("object") val _object : RemoteObject,

  /**
   *
   */
  val hints : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Runtime", name = "inspectRequested")

