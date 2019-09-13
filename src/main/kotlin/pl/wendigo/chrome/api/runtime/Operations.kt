package pl.wendigo.chrome.api.runtime

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects. Evaluation results are returned as mirror object that expose object type, string representation and unique identifier that can be used for further object reference. Original objects are maintained in memory unless they are either explicitly released or are released along with the other objects in their object group.
 *
 * @link Protocol [Runtime](https://chromedevtools.github.io/devtools-protocol/tot/Runtime) domain documentation.
 */
class RuntimeOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Evaluates expression on global object.
     *
     * @link Protocol [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
     */
    fun evaluate(input: EvaluateRequest): io.reactivex.Single<EvaluateResponse> {
        return connection.runAndCaptureResponse("Runtime.evaluate", input, EvaluateResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Add handler to promise with given promise object id.
     *
     * @link Protocol [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) method documentation.
     */
    fun awaitPromise(input: AwaitPromiseRequest): io.reactivex.Single<AwaitPromiseResponse> {
        return connection.runAndCaptureResponse("Runtime.awaitPromise", input, AwaitPromiseResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
     *
     * @link Protocol [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
     */
    fun callFunctionOn(input: CallFunctionOnRequest): io.reactivex.Single<CallFunctionOnResponse> {
        return connection.runAndCaptureResponse("Runtime.callFunctionOn", input, CallFunctionOnResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns properties of a given object. Object group of the result is inherited from the target object.
     *
     * @link Protocol [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
     */
    fun getProperties(input: GetPropertiesRequest): io.reactivex.Single<GetPropertiesResponse> {
        return connection.runAndCaptureResponse("Runtime.getProperties", input, GetPropertiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Releases remote object with given id.
     *
     * @link Protocol [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) method documentation.
     */
    fun releaseObject(input: ReleaseObjectRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.releaseObject", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Releases all remote objects that belong to a given group.
     *
     * @link Protocol [Runtime#releaseObjectGroup](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObjectGroup) method documentation.
     */
    fun releaseObjectGroup(input: ReleaseObjectGroupRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.releaseObjectGroup", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Tells inspected instance to run if it was waiting for debugger to attach.
     *
     * @link Protocol [Runtime#runIfWaitingForDebugger](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runIfWaitingForDebugger) method documentation.
     */
    fun runIfWaitingForDebugger(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.runIfWaitingForDebugger", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables reporting of execution contexts creation by means of <code>executionContextCreated</code> event. When the reporting gets enabled the event will be sent immediately for each existing execution context.
     *
     * @link Protocol [Runtime#enable](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-enable) method documentation.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables reporting of execution contexts creation.
     *
     * @link Protocol [Runtime#disable](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Discards collected exceptions and console API calls.
     *
     * @link Protocol [Runtime#discardConsoleEntries](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-discardConsoleEntries) method documentation.
     */
    fun discardConsoleEntries(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.discardConsoleEntries", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     *
     * @link Protocol [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setCustomObjectFormatterEnabled(input: SetCustomObjectFormatterEnabledRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Runtime.setCustomObjectFormatterEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Compiles expression.
     *
     * @link Protocol [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
     */
    fun compileScript(input: CompileScriptRequest): io.reactivex.Single<CompileScriptResponse> {
        return connection.runAndCaptureResponse("Runtime.compileScript", input, CompileScriptResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Runs script with given id in a given context.
     *
     * @link Protocol [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
     */
    fun runScript(input: RunScriptRequest): io.reactivex.Single<RunScriptResponse> {
        return connection.runAndCaptureResponse("Runtime.runScript", input, RunScriptResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Issued when new execution context is created.
     */
    fun executionContextCreated(): io.reactivex.Flowable<ExecutionContextCreatedEvent> {
        return executionContextCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when new execution context is created.
     */
    fun executionContextCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExecutionContextCreatedEvent>> {
        return connection.captureEvents("Runtime.executionContextCreated", ExecutionContextCreatedEvent::class.java)
    }

    /**
     *  Issued when execution context is destroyed.
     */
    fun executionContextDestroyed(): io.reactivex.Flowable<ExecutionContextDestroyedEvent> {
        return executionContextDestroyedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when execution context is destroyed.
     */
    fun executionContextDestroyedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExecutionContextDestroyedEvent>> {
        return connection.captureEvents("Runtime.executionContextDestroyed", ExecutionContextDestroyedEvent::class.java)
    }

    /**
     *  Issued when all executionContexts were cleared in browser
     */
    fun executionContextsCleared(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return executionContextsClearedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when all executionContexts were cleared in browser
     */
    fun executionContextsClearedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.protocol.Event>> {
        return connection.captureEvents("Runtime.executionContextsCleared", pl.wendigo.chrome.protocol.Event::class.java)
    }

    /**
     *  Issued when exception was thrown and unhandled.
     */
    fun exceptionThrown(): io.reactivex.Flowable<ExceptionThrownEvent> {
        return exceptionThrownTimed().map {
            it.value()
        }
    }

    /**
     * Issued when exception was thrown and unhandled.
     */
    fun exceptionThrownTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExceptionThrownEvent>> {
        return connection.captureEvents("Runtime.exceptionThrown", ExceptionThrownEvent::class.java)
    }

    /**
     *  Issued when unhandled exception was revoked.
     */
    fun exceptionRevoked(): io.reactivex.Flowable<ExceptionRevokedEvent> {
        return exceptionRevokedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when unhandled exception was revoked.
     */
    fun exceptionRevokedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ExceptionRevokedEvent>> {
        return connection.captureEvents("Runtime.exceptionRevoked", ExceptionRevokedEvent::class.java)
    }

    /**
     *  Issued when console API was called.
     */
    fun consoleAPICalled(): io.reactivex.Flowable<ConsoleAPICalledEvent> {
        return consoleAPICalledTimed().map {
            it.value()
        }
    }

    /**
     * Issued when console API was called.
     */
    fun consoleAPICalledTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ConsoleAPICalledEvent>> {
        return connection.captureEvents("Runtime.consoleAPICalled", ConsoleAPICalledEvent::class.java)
    }

    /**
     *  Issued when object should be inspected (for example, as a result of inspect() command line API call).
     */
    fun inspectRequested(): io.reactivex.Flowable<InspectRequestedEvent> {
        return inspectRequestedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when object should be inspected (for example, as a result of inspect() command line API call).
     */
    fun inspectRequestedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<InspectRequestedEvent>> {
        return connection.captureEvents("Runtime.inspectRequested", InspectRequestedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Runtime domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Runtime"
        }
    }
}
/**
 * Represents request frame that can be used with [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) operation call.
 *
 * Evaluates expression on global object.
 * @link [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
 * @see [RuntimeOperations.evaluate]
 */
data class EvaluateRequest(
    /**
     * Expression to evaluate.
     */
    val expression: String,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup: String? = null,

    /**
     * Determines whether Command Line API should be available during the evaluation.
     */
    val includeCommandLineAPI: Boolean? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
     */
    val silent: Boolean? = null,

    /**
     * Specifies in which execution context to perform evaluation. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     */
    val contextId: ExecutionContextId? = null,

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    val returnByValue: Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    @pl.wendigo.chrome.protocol.Experimental val generatePreview: Boolean? = null,

    /**
     * Whether execution should be treated as initiated by user in the UI.
     */
    @pl.wendigo.chrome.protocol.Experimental val userGesture: Boolean? = null,

    /**
     * Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
     */
    val awaitPromise: Boolean? = null

)
/**
 * Represents response frame that is returned from [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) operation call.
 * Evaluates expression on global object.
 *
  
 * @link [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
 * @see [RuntimeOperations.evaluate]
 */
data class EvaluateResponse(
    /**  
     * Evaluation result.  
     */  
    val result: RemoteObject,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) operation call.
 *
 * Add handler to promise with given promise object id.
 * @link [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) method documentation.
 * @see [RuntimeOperations.awaitPromise]
 */
data class AwaitPromiseRequest(
    /**
     * Identifier of the promise.
     */
    val promiseObjectId: RemoteObjectId,

    /**
     * Whether the result is expected to be a JSON object that should be sent by value.
     */
    val returnByValue: Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    val generatePreview: Boolean? = null

)
/**
 * Represents response frame that is returned from [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) operation call.
 * Add handler to promise with given promise object id.
 *
  
 * @link [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) method documentation.
 * @see [RuntimeOperations.awaitPromise]
 */
data class AwaitPromiseResponse(
    /**  
     * Promise result. Will contain rejected value if promise was rejected.  
     */  
    val result: RemoteObject,

    /**  
     * Exception details if stack strace is available.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) operation call.
 *
 * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
 * @link [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
 * @see [RuntimeOperations.callFunctionOn]
 */
data class CallFunctionOnRequest(
    /**
     * Identifier of the object to call function on.
     */
    val objectId: RemoteObjectId,

    /**
     * Declaration of the function to call.
     */
    val functionDeclaration: String,

    /**
     * Call arguments. All call arguments must belong to the same JavaScript world as the target object.
     */
    val arguments: List<CallArgument>? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
     */
    val silent: Boolean? = null,

    /**
     * Whether the result is expected to be a JSON object which should be sent by value.
     */
    val returnByValue: Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    @pl.wendigo.chrome.protocol.Experimental val generatePreview: Boolean? = null,

    /**
     * Whether execution should be treated as initiated by user in the UI.
     */
    @pl.wendigo.chrome.protocol.Experimental val userGesture: Boolean? = null,

    /**
     * Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
     */
    val awaitPromise: Boolean? = null

)
/**
 * Represents response frame that is returned from [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) operation call.
 * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
 *
  
 * @link [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
 * @see [RuntimeOperations.callFunctionOn]
 */
data class CallFunctionOnResponse(
    /**  
     * Call result.  
     */  
    val result: RemoteObject,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) operation call.
 *
 * Returns properties of a given object. Object group of the result is inherited from the target object.
 * @link [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
 * @see [RuntimeOperations.getProperties]
 */
data class GetPropertiesRequest(
    /**
     * Identifier of the object to return properties for.
     */
    val objectId: RemoteObjectId,

    /**
     * If true, returns properties belonging only to the element itself, not to its prototype chain.
     */
    val ownProperties: Boolean? = null,

    /**
     * If true, returns accessor properties (with getter/setter) only; internal properties are not returned either.
     */
    @pl.wendigo.chrome.protocol.Experimental val accessorPropertiesOnly: Boolean? = null,

    /**
     * Whether preview should be generated for the results.
     */
    @pl.wendigo.chrome.protocol.Experimental val generatePreview: Boolean? = null

)
/**
 * Represents response frame that is returned from [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) operation call.
 * Returns properties of a given object. Object group of the result is inherited from the target object.
 *
  
 * @link [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
 * @see [RuntimeOperations.getProperties]
 */
data class GetPropertiesResponse(
    /**  
     * Object properties.  
     */  
    val result: List<PropertyDescriptor>,

    /**  
     * Internal object properties (only of the element itself).  
     */  
    val internalProperties: List<InternalPropertyDescriptor>? = null,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) operation call.
 *
 * Releases remote object with given id.
 * @link [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) method documentation.
 * @see [RuntimeOperations.releaseObject]
 */
data class ReleaseObjectRequest(
    /**
     * Identifier of the object to release.
     */
    val objectId: RemoteObjectId

)

/**
 * Represents request frame that can be used with [Runtime#releaseObjectGroup](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObjectGroup) operation call.
 *
 * Releases all remote objects that belong to a given group.
 * @link [Runtime#releaseObjectGroup](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObjectGroup) method documentation.
 * @see [RuntimeOperations.releaseObjectGroup]
 */
data class ReleaseObjectGroupRequest(
    /**
     * Symbolic object group name.
     */
    val objectGroup: String

)

/**
 * Represents request frame that can be used with [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) operation call.
 *
 *
 * @link [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) method documentation.
 * @see [RuntimeOperations.setCustomObjectFormatterEnabled]
 */
data class SetCustomObjectFormatterEnabledRequest(
    /**
     *
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) operation call.
 *
 * Compiles expression.
 * @link [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
 * @see [RuntimeOperations.compileScript]
 */
data class CompileScriptRequest(
    /**
     * Expression to compile.
     */
    val expression: String,

    /**
     * Source url to be set for the script.
     */
    val sourceURL: String,

    /**
     * Specifies whether the compiled script should be persisted.
     */
    val persistScript: Boolean,

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     */
    val executionContextId: ExecutionContextId? = null

)
/**
 * Represents response frame that is returned from [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) operation call.
 * Compiles expression.
 *
  
 * @link [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
 * @see [RuntimeOperations.compileScript]
 */
data class CompileScriptResponse(
    /**  
     * Id of the script.  
     */  
    val scriptId: ScriptId? = null,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) operation call.
 *
 * Runs script with given id in a given context.
 * @link [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
 * @see [RuntimeOperations.runScript]
 */
data class RunScriptRequest(
    /**
     * Id of the script to run.
     */
    val scriptId: ScriptId,

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
     */
    val executionContextId: ExecutionContextId? = null,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup: String? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
     */
    val silent: Boolean? = null,

    /**
     * Determines whether Command Line API should be available during the evaluation.
     */
    val includeCommandLineAPI: Boolean? = null,

    /**
     * Whether the result is expected to be a JSON object which should be sent by value.
     */
    val returnByValue: Boolean? = null,

    /**
     * Whether preview should be generated for the result.
     */
    val generatePreview: Boolean? = null,

    /**
     * Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
     */
    val awaitPromise: Boolean? = null

)
/**
 * Represents response frame that is returned from [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) operation call.
 * Runs script with given id in a given context.
 *
  
 * @link [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
 * @see [RuntimeOperations.runScript]
 */
data class RunScriptResponse(
    /**  
     * Run result.  
     */  
    val result: RemoteObject,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Issued when new execution context is created.
 *
 * @link [Runtime#executionContextCreated](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-executionContextCreated) event documentation.
 */
data class ExecutionContextCreatedEvent(
    /**  
     * A newly created execution contex.  
     */  
    val context: ExecutionContextDescription

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "executionContextCreated")

/**
 * Issued when execution context is destroyed.
 *
 * @link [Runtime#executionContextDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-executionContextDestroyed) event documentation.
 */
data class ExecutionContextDestroyedEvent(
    /**  
     * Id of the destroyed context  
     */  
    val executionContextId: ExecutionContextId

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "executionContextDestroyed")

/**
 * Issued when exception was thrown and unhandled.
 *
 * @link [Runtime#exceptionThrown](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-exceptionThrown) event documentation.
 */
data class ExceptionThrownEvent(
    /**  
     * Timestamp of the exception.  
     */  
    val timestamp: Timestamp,

    /**  
     *  
     */  
    val exceptionDetails: ExceptionDetails

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "exceptionThrown")

/**
 * Issued when unhandled exception was revoked.
 *
 * @link [Runtime#exceptionRevoked](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-exceptionRevoked) event documentation.
 */
data class ExceptionRevokedEvent(
    /**  
     * Reason describing why exception was revoked.  
     */  
    val reason: String,

    /**  
     * The id of revoked exception, as reported in <code>exceptionUnhandled</code>.  
     */  
    val exceptionId: Int

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "exceptionRevoked")

/**
 * Issued when console API was called.
 *
 * @link [Runtime#consoleAPICalled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-consoleAPICalled) event documentation.
 */
data class ConsoleAPICalledEvent(
    /**  
     * Type of the call.  
     */  
    val type: String,

    /**  
     * Call arguments.  
     */  
    val args: List<RemoteObject>,

    /**  
     * Identifier of the context where the call was made.  
     */  
    val executionContextId: ExecutionContextId,

    /**  
     * Call timestamp.  
     */  
    val timestamp: Timestamp,

    /**  
     * Stack trace captured when the call was made.  
     */  
    val stackTrace: StackTrace? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "consoleAPICalled")

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API call).
 *
 * @link [Runtime#inspectRequested](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-inspectRequested) event documentation.
 */
data class InspectRequestedEvent(
    /**  
     *  
     */  
    @get:com.fasterxml.jackson.annotation.JsonProperty("object")
    val _object: RemoteObject,

    /**  
     *  
     */  
    val hints: com.fasterxml.jackson.databind.JsonNode

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "inspectRequested")
