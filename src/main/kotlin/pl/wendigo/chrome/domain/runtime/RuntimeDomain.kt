package pl.wendigo.chrome.domain.runtime

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects. Evaluation results are returned as mirror object that expose object type, string representation and unique identifier that can be used for further object reference. Original objects are maintained in memory unless they are either explicitly released or are released along with the other objects in their object group.
 */
class RuntimeDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Evaluates expression on global object.
	 */
	  fun evaluate(input : EvaluateRequest) : io.reactivex.Flowable<EvaluateResponse> {
        return connection.runAndCaptureResponse("Runtime.evaluate", input, EvaluateResponse::class.java)
	}

	/**
	 * Add handler to promise with given promise object id.
	 */
	  fun awaitPromise(input : AwaitPromiseRequest) : io.reactivex.Flowable<AwaitPromiseResponse> {
        return connection.runAndCaptureResponse("Runtime.awaitPromise", input, AwaitPromiseResponse::class.java)
	}

	/**
	 * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
	 */
	  fun callFunctionOn(input : CallFunctionOnRequest) : io.reactivex.Flowable<CallFunctionOnResponse> {
        return connection.runAndCaptureResponse("Runtime.callFunctionOn", input, CallFunctionOnResponse::class.java)
	}

	/**
	 * Returns properties of a given object. Object group of the result is inherited from the target object.
	 */
	  fun getProperties(input : GetPropertiesRequest) : io.reactivex.Flowable<GetPropertiesResponse> {
        return connection.runAndCaptureResponse("Runtime.getProperties", input, GetPropertiesResponse::class.java)
	}

	/**
	 * Releases remote object with given id.
	 */
	  fun releaseObject(input : ReleaseObjectRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.releaseObject", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Releases all remote objects that belong to a given group.
	 */
	  fun releaseObjectGroup(input : ReleaseObjectGroupRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.releaseObjectGroup", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Tells inspected instance to run if it was waiting for debugger to attach.
	 */
	  fun runIfWaitingForDebugger() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.runIfWaitingForDebugger", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Enables reporting of execution contexts creation by means of <code>executionContextCreated</code> event. When the reporting gets enabled the event will be sent immediately for each existing execution context.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables reporting of execution contexts creation.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Discards collected exceptions and console API calls.
	 */
	  fun discardConsoleEntries() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.discardConsoleEntries", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun setCustomObjectFormatterEnabled(input : SetCustomObjectFormatterEnabledRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.setCustomObjectFormatterEnabled", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Compiles expression.
	 */
	  fun compileScript(input : CompileScriptRequest) : io.reactivex.Flowable<CompileScriptResponse> {
        return connection.runAndCaptureResponse("Runtime.compileScript", input, CompileScriptResponse::class.java)
	}

	/**
	 * Runs script with given id in a given context.
	 */
	  fun runScript(input : RunScriptRequest) : io.reactivex.Flowable<RunScriptResponse> {
        return connection.runAndCaptureResponse("Runtime.runScript", input, RunScriptResponse::class.java)
	}

  
  /**
   * Issued when new execution context is created.
   */
   fun onExecutionContextCreated() : io.reactivex.Flowable<ExecutionContextCreatedEvent> {
      return connection.captureEvents("Runtime.executionContextCreated", ExecutionContextCreatedEvent::class.java)
   }

  /**
   * Issued when execution context is destroyed.
   */
   fun onExecutionContextDestroyed() : io.reactivex.Flowable<ExecutionContextDestroyedEvent> {
      return connection.captureEvents("Runtime.executionContextDestroyed", ExecutionContextDestroyedEvent::class.java)
   }

  /**
   * Issued when all executionContexts were cleared in browser
   */
   fun onExecutionContextsCleared() : io.reactivex.Flowable<pl.wendigo.chrome.DebuggerEvent> {
      return connection.captureEvents("Runtime.executionContextsCleared", pl.wendigo.chrome.DebuggerEvent::class.java)
   }

  /**
   * Issued when exception was thrown and unhandled.
   */
   fun onExceptionThrown() : io.reactivex.Flowable<ExceptionThrownEvent> {
      return connection.captureEvents("Runtime.exceptionThrown", ExceptionThrownEvent::class.java)
   }

  /**
   * Issued when unhandled exception was revoked.
   */
   fun onExceptionRevoked() : io.reactivex.Flowable<ExceptionRevokedEvent> {
      return connection.captureEvents("Runtime.exceptionRevoked", ExceptionRevokedEvent::class.java)
   }

  /**
   * Issued when console API was called.
   */
   fun onConsoleAPICalled() : io.reactivex.Flowable<ConsoleAPICalledEvent> {
      return connection.captureEvents("Runtime.consoleAPICalled", ConsoleAPICalledEvent::class.java)
   }

  /**
   * Issued when object should be inspected (for example, as a result of inspect() command line API call).
   */
   fun onInspectRequested() : io.reactivex.Flowable<InspectRequestedEvent> {
      return connection.captureEvents("Runtime.inspectRequested", InspectRequestedEvent::class.java)
   }
}

/**
 * Represents requestFrame parameters that can be used with Runtime.evaluate method call.
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
    @pl.wendigo.chrome.ProtocolExperimental val generatePreview : Boolean? = null,

    /**
     * Whether execution should be treated as initiated by user in the UI.
     */
    @pl.wendigo.chrome.ProtocolExperimental val userGesture : Boolean? = null,

    /**
     * Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
     */
    val awaitPromise : Boolean? = null

)

/**
 * Represents responseFrame from Runtime. method call.
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
 * Represents requestFrame parameters that can be used with Runtime.awaitPromise method call.
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
 * Represents responseFrame from Runtime. method call.
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
 * Represents requestFrame parameters that can be used with Runtime.callFunctionOn method call.
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
    val arguments : Array<CallArgument>? = null,

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
    @pl.wendigo.chrome.ProtocolExperimental val generatePreview : Boolean? = null,

    /**
     * Whether execution should be treated as initiated by user in the UI.
     */
    @pl.wendigo.chrome.ProtocolExperimental val userGesture : Boolean? = null,

    /**
     * Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
     */
    val awaitPromise : Boolean? = null

)

/**
 * Represents responseFrame from Runtime. method call.
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
 * Represents requestFrame parameters that can be used with Runtime.getProperties method call.
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
    @pl.wendigo.chrome.ProtocolExperimental val accessorPropertiesOnly : Boolean? = null,

    /**
     * Whether preview should be generated for the results.
     */
    @pl.wendigo.chrome.ProtocolExperimental val generatePreview : Boolean? = null

)

/**
 * Represents responseFrame from Runtime. method call.
 *
 * Returns properties of a given object. Object group of the result is inherited from the target object.
 */
data class GetPropertiesResponse(
  /**
   * Object properties.
   */
  val result : Array<PropertyDescriptor>,

  /**
   * Internal object properties (only of the element itself).
   */
  val internalProperties : Array<InternalPropertyDescriptor>? = null,

  /**
   * Exception details.
   */
  val exceptionDetails : ExceptionDetails? = null

)

/**
 * Represents requestFrame parameters that can be used with Runtime.releaseObject method call.
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
 * Represents requestFrame parameters that can be used with Runtime.releaseObjectGroup method call.
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
 * Represents requestFrame parameters that can be used with Runtime.setCustomObjectFormatterEnabled method call.
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
 * Represents requestFrame parameters that can be used with Runtime.compileScript method call.
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
 * Represents responseFrame from Runtime. method call.
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
 * Represents requestFrame parameters that can be used with Runtime.runScript method call.
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
     * Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
     */
    val awaitPromise : Boolean? = null

)

/**
 * Represents responseFrame from Runtime. method call.
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
 * Represents responseFrame from Runtime. method call.
 *
 * Issued when new execution context is created.
 */
data class ExecutionContextCreatedEvent(
  /**
   * A newly created execution contex.
   */
  val context : ExecutionContextDescription

) : pl.wendigo.chrome.DebuggerEvent(domain = "Runtime", name = "executionContextCreated")

/**
 * Represents responseFrame from Runtime. method call.
 *
 * Issued when execution context is destroyed.
 */
data class ExecutionContextDestroyedEvent(
  /**
   * Id of the destroyed context
   */
  val executionContextId : ExecutionContextId

) : pl.wendigo.chrome.DebuggerEvent(domain = "Runtime", name = "executionContextDestroyed")


/**
 * Represents responseFrame from Runtime. method call.
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

) : pl.wendigo.chrome.DebuggerEvent(domain = "Runtime", name = "exceptionThrown")

/**
 * Represents responseFrame from Runtime. method call.
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

) : pl.wendigo.chrome.DebuggerEvent(domain = "Runtime", name = "exceptionRevoked")

/**
 * Represents responseFrame from Runtime. method call.
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
  val args : Array<RemoteObject>,

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
  val stackTrace : StackTrace? = null

) : pl.wendigo.chrome.DebuggerEvent(domain = "Runtime", name = "consoleAPICalled")

/**
 * Represents responseFrame from Runtime. method call.
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

) : pl.wendigo.chrome.DebuggerEvent(domain = "Runtime", name = "inspectRequested")

