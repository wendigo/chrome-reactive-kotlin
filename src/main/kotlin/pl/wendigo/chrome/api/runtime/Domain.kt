package pl.wendigo.chrome.api.runtime

import kotlinx.serialization.json.Json

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects.
Evaluation results are returned as mirror object that expose object type, string representation
and unique identifier that can be used for further object reference. Original objects are
maintained in memory unless they are either explicitly released or are released along with the
other objects in their object group.
 *
 * @link Protocol [Runtime](https://chromedevtools.github.io/devtools-protocol/tot/Runtime) domain documentation.
 */

class RuntimeDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebSocketConnection) :
    pl.wendigo.chrome.protocol.Domain(
        "Runtime",
        """Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects.
Evaluation results are returned as mirror object that expose object type, string representation
and unique identifier that can be used for further object reference. Original objects are
maintained in memory unless they are either explicitly released or are released along with the
other objects in their object group.""",
        connection
    ) {
    /**
     * Add handler to promise with given promise object id.
     *
     * @link Protocol [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) method documentation.
     */
    
    fun awaitPromise(input: AwaitPromiseRequest): io.reactivex.rxjava3.core.Single<AwaitPromiseResponse> = connection.request("Runtime.awaitPromise", Json.encodeToJsonElement(AwaitPromiseRequest.serializer(), input), AwaitPromiseResponse.serializer())

    /**
     * Calls function with given declaration on the given object. Object group of the result is
inherited from the target object.
     *
     * @link Protocol [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
     */
    
    fun callFunctionOn(input: CallFunctionOnRequest): io.reactivex.rxjava3.core.Single<CallFunctionOnResponse> = connection.request("Runtime.callFunctionOn", Json.encodeToJsonElement(CallFunctionOnRequest.serializer(), input), CallFunctionOnResponse.serializer())

    /**
     * Compiles expression.
     *
     * @link Protocol [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
     */
    
    fun compileScript(input: CompileScriptRequest): io.reactivex.rxjava3.core.Single<CompileScriptResponse> = connection.request("Runtime.compileScript", Json.encodeToJsonElement(CompileScriptRequest.serializer(), input), CompileScriptResponse.serializer())

    /**
     * Disables reporting of execution contexts creation.
     *
     * @link Protocol [Runtime#disable](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Discards collected exceptions and console API calls.
     *
     * @link Protocol [Runtime#discardConsoleEntries](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-discardConsoleEntries) method documentation.
     */
    
    fun discardConsoleEntries(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.discardConsoleEntries", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables reporting of execution contexts creation by means of `executionContextCreated` event.
When the reporting gets enabled the event will be sent immediately for each existing execution
context.
     *
     * @link Protocol [Runtime#enable](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Evaluates expression on global object.
     *
     * @link Protocol [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
     */
    
    fun evaluate(input: EvaluateRequest): io.reactivex.rxjava3.core.Single<EvaluateResponse> = connection.request("Runtime.evaluate", Json.encodeToJsonElement(EvaluateRequest.serializer(), input), EvaluateResponse.serializer())

    /**
     * Returns the isolate id.
     *
     * @link Protocol [Runtime#getIsolateId](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getIsolateId) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getIsolateId(): io.reactivex.rxjava3.core.Single<GetIsolateIdResponse> = connection.request("Runtime.getIsolateId", null, GetIsolateIdResponse.serializer())

    /**
     * Returns the JavaScript heap usage.
It is the total usage of the corresponding isolate not scoped to a particular Runtime.
     *
     * @link Protocol [Runtime#getHeapUsage](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getHeapUsage) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun getHeapUsage(): io.reactivex.rxjava3.core.Single<GetHeapUsageResponse> = connection.request("Runtime.getHeapUsage", null, GetHeapUsageResponse.serializer())

    /**
     * Returns properties of a given object. Object group of the result is inherited from the target
object.
     *
     * @link Protocol [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
     */
    
    fun getProperties(input: GetPropertiesRequest): io.reactivex.rxjava3.core.Single<GetPropertiesResponse> = connection.request("Runtime.getProperties", Json.encodeToJsonElement(GetPropertiesRequest.serializer(), input), GetPropertiesResponse.serializer())

    /**
     * Returns all let, const and class variables from global scope.
     *
     * @link Protocol [Runtime#globalLexicalScopeNames](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-globalLexicalScopeNames) method documentation.
     */
    
    fun globalLexicalScopeNames(input: GlobalLexicalScopeNamesRequest): io.reactivex.rxjava3.core.Single<GlobalLexicalScopeNamesResponse> = connection.request("Runtime.globalLexicalScopeNames", Json.encodeToJsonElement(GlobalLexicalScopeNamesRequest.serializer(), input), GlobalLexicalScopeNamesResponse.serializer())

    /**
     *
     *
     * @link Protocol [Runtime#queryObjects](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-queryObjects) method documentation.
     */
    
    fun queryObjects(input: QueryObjectsRequest): io.reactivex.rxjava3.core.Single<QueryObjectsResponse> = connection.request("Runtime.queryObjects", Json.encodeToJsonElement(QueryObjectsRequest.serializer(), input), QueryObjectsResponse.serializer())

    /**
     * Releases remote object with given id.
     *
     * @link Protocol [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) method documentation.
     */
    
    fun releaseObject(input: ReleaseObjectRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.releaseObject", Json.encodeToJsonElement(ReleaseObjectRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Releases all remote objects that belong to a given group.
     *
     * @link Protocol [Runtime#releaseObjectGroup](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObjectGroup) method documentation.
     */
    
    fun releaseObjectGroup(input: ReleaseObjectGroupRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.releaseObjectGroup", Json.encodeToJsonElement(ReleaseObjectGroupRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Tells inspected instance to run if it was waiting for debugger to attach.
     *
     * @link Protocol [Runtime#runIfWaitingForDebugger](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runIfWaitingForDebugger) method documentation.
     */
    
    fun runIfWaitingForDebugger(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.runIfWaitingForDebugger", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Runs script with given id in a given context.
     *
     * @link Protocol [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
     */
    
    fun runScript(input: RunScriptRequest): io.reactivex.rxjava3.core.Single<RunScriptResponse> = connection.request("Runtime.runScript", Json.encodeToJsonElement(RunScriptRequest.serializer(), input), RunScriptResponse.serializer())

    /**
     * Enables or disables async call stacks tracking.
     *
     * @link Protocol [Runtime#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setAsyncCallStackDepth) method documentation.
     */
    
    fun setAsyncCallStackDepth(input: SetAsyncCallStackDepthRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.setAsyncCallStackDepth", Json.encodeToJsonElement(SetAsyncCallStackDepthRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setCustomObjectFormatterEnabled(input: SetCustomObjectFormatterEnabledRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.setCustomObjectFormatterEnabled", Json.encodeToJsonElement(SetCustomObjectFormatterEnabledRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [Runtime#setMaxCallStackSizeToCapture](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setMaxCallStackSizeToCapture) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setMaxCallStackSizeToCapture(input: SetMaxCallStackSizeToCaptureRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.setMaxCallStackSizeToCapture", Json.encodeToJsonElement(SetMaxCallStackSizeToCaptureRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Terminate current or next JavaScript execution.
Will cancel the termination when the outer-most script execution ends.
     *
     * @link Protocol [Runtime#terminateExecution](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-terminateExecution) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun terminateExecution(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.terminateExecution", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * If executionContextId is empty, adds binding with the given name on the
global objects of all inspected contexts, including those created later,
bindings survive reloads.
Binding function takes exactly one argument, this argument should be string,
in case of any other input, function throws an exception.
Each binding function call produces Runtime.bindingCalled notification.
     *
     * @link Protocol [Runtime#addBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-addBinding) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun addBinding(input: AddBindingRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.addBinding", Json.encodeToJsonElement(AddBindingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * This method does not remove binding function from global object but
unsubscribes current runtime agent from Runtime.bindingCalled notifications.
     *
     * @link Protocol [Runtime#removeBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-removeBinding) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun removeBinding(input: RemoveBindingRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Runtime.removeBinding", Json.encodeToJsonElement(RemoveBindingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Notification is issued every time when binding is called.
     */
    fun bindingCalled(): io.reactivex.rxjava3.core.Flowable<BindingCalledEvent> = connection.events("Runtime.bindingCalled", BindingCalledEvent.serializer())

    /**
     *  Issued when console API was called.
     */
    fun consoleAPICalled(): io.reactivex.rxjava3.core.Flowable<ConsoleAPICalledEvent> = connection.events("Runtime.consoleAPICalled", ConsoleAPICalledEvent.serializer())

    /**
     *  Issued when unhandled exception was revoked.
     */
    fun exceptionRevoked(): io.reactivex.rxjava3.core.Flowable<ExceptionRevokedEvent> = connection.events("Runtime.exceptionRevoked", ExceptionRevokedEvent.serializer())

    /**
     *  Issued when exception was thrown and unhandled.
     */
    fun exceptionThrown(): io.reactivex.rxjava3.core.Flowable<ExceptionThrownEvent> = connection.events("Runtime.exceptionThrown", ExceptionThrownEvent.serializer())

    /**
     *  Issued when new execution context is created.
     */
    fun executionContextCreated(): io.reactivex.rxjava3.core.Flowable<ExecutionContextCreatedEvent> = connection.events("Runtime.executionContextCreated", ExecutionContextCreatedEvent.serializer())

    /**
     *  Issued when execution context is destroyed.
     */
    fun executionContextDestroyed(): io.reactivex.rxjava3.core.Flowable<ExecutionContextDestroyedEvent> = connection.events("Runtime.executionContextDestroyed", ExecutionContextDestroyedEvent.serializer())

    /**
     *  Issued when all executionContexts were cleared in browser
     */
    fun executionContextsCleared(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.RawEvent> = connection.events("Runtime.executionContextsCleared", pl.wendigo.chrome.protocol.RawEvent.serializer())

    /**
     *  Issued when object should be inspected (for example, as a result of inspect() command line API
call).
     */
    fun inspectRequested(): io.reactivex.rxjava3.core.Flowable<InspectRequestedEvent> = connection.events("Runtime.inspectRequested", InspectRequestedEvent.serializer())
}

/**
 * Represents request frame that can be used with [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) operation call.
 *
 * Add handler to promise with given promise object id.
 * @link [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) method documentation.
 * @see [RuntimeDomain.awaitPromise]
 */
@kotlinx.serialization.Serializable
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
 * @see [RuntimeDomain.awaitPromise]
 */
@kotlinx.serialization.Serializable
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
 * Calls function with given declaration on the given object. Object group of the result is
inherited from the target object.
 * @link [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
 * @see [RuntimeDomain.callFunctionOn]
 */
@kotlinx.serialization.Serializable
data class CallFunctionOnRequest(
    /**
     * Declaration of the function to call.
     */
    val functionDeclaration: String,

    /**
     * Identifier of the object to call function on. Either objectId or executionContextId should
be specified.
     */
    val objectId: RemoteObjectId? = null,

    /**
     * Call arguments. All call arguments must belong to the same JavaScript world as the target
object.
     */
    val arguments: List<CallArgument>? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
execution. Overrides `setPauseOnException` state.
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
    val userGesture: Boolean? = null,

    /**
     * Whether execution should `await` for resulting value and return once awaited promise is
resolved.
     */
    val awaitPromise: Boolean? = null,

    /**
     * Specifies execution context which global object will be used to call function on. Either
executionContextId or objectId should be specified.
     */
    val executionContextId: ExecutionContextId? = null,

    /**
     * Symbolic group name that can be used to release multiple objects. If objectGroup is not
specified and objectId is, objectGroup will be inherited from object.
     */
    val objectGroup: String? = null

)

/**
 * Represents response frame that is returned from [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) operation call.
 * Calls function with given declaration on the given object. Object group of the result is
inherited from the target object.
 *
  
 * @link [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
 * @see [RuntimeDomain.callFunctionOn]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) operation call.
 *
 * Compiles expression.
 * @link [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
 * @see [RuntimeDomain.compileScript]
 */
@kotlinx.serialization.Serializable
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
     * Specifies in which execution context to perform script run. If the parameter is omitted the
evaluation will be performed in the context of the inspected page.
     */
    val executionContextId: ExecutionContextId? = null

)

/**
 * Represents response frame that is returned from [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) operation call.
 * Compiles expression.
 *
  
 * @link [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
 * @see [RuntimeDomain.compileScript]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) operation call.
 *
 * Evaluates expression on global object.
 * @link [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
 * @see [RuntimeDomain.evaluate]
 */
@kotlinx.serialization.Serializable
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
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
execution. Overrides `setPauseOnException` state.
     */
    val silent: Boolean? = null,

    /**
     * Specifies in which execution context to perform evaluation. If the parameter is omitted the
evaluation will be performed in the context of the inspected page.
This is mutually exclusive with `uniqueContextId`, which offers an
alternative way to identify the execution context that is more reliable
in a multi-process environment.
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
    val userGesture: Boolean? = null,

    /**
     * Whether execution should `await` for resulting value and return once awaited promise is
resolved.
     */
    val awaitPromise: Boolean? = null,

    /**
     * Whether to throw an exception if side effect cannot be ruled out during evaluation.
This implies `disableBreaks` below.
     */
    @pl.wendigo.chrome.protocol.Experimental val throwOnSideEffect: Boolean? = null,

    /**
     * Terminate execution after timing out (number of milliseconds).
     */
    @pl.wendigo.chrome.protocol.Experimental val timeout: TimeDelta? = null,

    /**
     * Disable breakpoints during execution.
     */
    @pl.wendigo.chrome.protocol.Experimental val disableBreaks: Boolean? = null,

    /**
     * Setting this flag to true enables `let` re-declaration and top-level `await`.
Note that `let` variables can only be re-declared if they originate from
`replMode` themselves.
     */
    @pl.wendigo.chrome.protocol.Experimental val replMode: Boolean? = null,

    /**
     * The Content Security Policy (CSP) for the target might block 'unsafe-eval'
which includes eval(), Function(), setTimeout() and setInterval()
when called with non-callable arguments. This flag bypasses CSP for this
evaluation and allows unsafe-eval. Defaults to true.
     */
    @pl.wendigo.chrome.protocol.Experimental val allowUnsafeEvalBlockedByCSP: Boolean? = null,

    /**
     * An alternative way to specify the execution context to evaluate in.
Compared to contextId that may be reused accross processes, this is guaranteed to be
system-unique, so it can be used to prevent accidental evaluation of the expression
in context different than intended (e.g. as a result of navigation accross process
boundaries).
This is mutually exclusive with `contextId`.
     */
    @pl.wendigo.chrome.protocol.Experimental val uniqueContextId: String? = null

)

/**
 * Represents response frame that is returned from [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) operation call.
 * Evaluates expression on global object.
 *
  
 * @link [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
 * @see [RuntimeDomain.evaluate]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [Runtime#getIsolateId](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getIsolateId) operation call.
 * Returns the isolate id.
 *
  
 * @link [Runtime#getIsolateId](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getIsolateId) method documentation.
 * @see [RuntimeDomain.getIsolateId]
 */
@kotlinx.serialization.Serializable
data class GetIsolateIdResponse(
    /**  
     * The isolate id.  
     */  
    val id: String

)

/**
 * Represents response frame that is returned from [Runtime#getHeapUsage](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getHeapUsage) operation call.
 * Returns the JavaScript heap usage.
It is the total usage of the corresponding isolate not scoped to a particular Runtime.
 *
  
 * @link [Runtime#getHeapUsage](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getHeapUsage) method documentation.
 * @see [RuntimeDomain.getHeapUsage]
 */
@kotlinx.serialization.Serializable
data class GetHeapUsageResponse(
    /**  
     * Used heap size in bytes.  
     */  
    val usedSize: Double,

    /**  
     * Allocated heap size in bytes.  
     */  
    val totalSize: Double

)

/**
 * Represents request frame that can be used with [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) operation call.
 *
 * Returns properties of a given object. Object group of the result is inherited from the target
object.
 * @link [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
 * @see [RuntimeDomain.getProperties]
 */
@kotlinx.serialization.Serializable
data class GetPropertiesRequest(
    /**
     * Identifier of the object to return properties for.
     */
    val objectId: RemoteObjectId,

    /**
     * If true, returns properties belonging only to the element itself, not to its prototype
chain.
     */
    val ownProperties: Boolean? = null,

    /**
     * If true, returns accessor properties (with getter/setter) only; internal properties are not
returned either.
     */
    @pl.wendigo.chrome.protocol.Experimental val accessorPropertiesOnly: Boolean? = null,

    /**
     * Whether preview should be generated for the results.
     */
    @pl.wendigo.chrome.protocol.Experimental val generatePreview: Boolean? = null

)

/**
 * Represents response frame that is returned from [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) operation call.
 * Returns properties of a given object. Object group of the result is inherited from the target
object.
 *
  
 * @link [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
 * @see [RuntimeDomain.getProperties]
 */
@kotlinx.serialization.Serializable
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
     * Object private properties.  
     */  
    val privateProperties: List<PrivatePropertyDescriptor>? = null,

    /**  
     * Exception details.  
     */  
    val exceptionDetails: ExceptionDetails? = null

)

/**
 * Represents request frame that can be used with [Runtime#globalLexicalScopeNames](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-globalLexicalScopeNames) operation call.
 *
 * Returns all let, const and class variables from global scope.
 * @link [Runtime#globalLexicalScopeNames](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-globalLexicalScopeNames) method documentation.
 * @see [RuntimeDomain.globalLexicalScopeNames]
 */
@kotlinx.serialization.Serializable
data class GlobalLexicalScopeNamesRequest(
    /**
     * Specifies in which execution context to lookup global scope variables.
     */
    val executionContextId: ExecutionContextId? = null

)

/**
 * Represents response frame that is returned from [Runtime#globalLexicalScopeNames](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-globalLexicalScopeNames) operation call.
 * Returns all let, const and class variables from global scope.
 *
  
 * @link [Runtime#globalLexicalScopeNames](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-globalLexicalScopeNames) method documentation.
 * @see [RuntimeDomain.globalLexicalScopeNames]
 */
@kotlinx.serialization.Serializable
data class GlobalLexicalScopeNamesResponse(
    /**  
     *  
     */  
    val names: List<String>

)

/**
 * Represents request frame that can be used with [Runtime#queryObjects](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-queryObjects) operation call.
 *
 *
 * @link [Runtime#queryObjects](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-queryObjects) method documentation.
 * @see [RuntimeDomain.queryObjects]
 */
@kotlinx.serialization.Serializable
data class QueryObjectsRequest(
    /**
     * Identifier of the prototype to return objects for.
     */
    val prototypeObjectId: RemoteObjectId,

    /**
     * Symbolic group name that can be used to release the results.
     */
    val objectGroup: String? = null

)

/**
 * Represents response frame that is returned from [Runtime#queryObjects](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-queryObjects) operation call.
 *
 *
  
 * @link [Runtime#queryObjects](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-queryObjects) method documentation.
 * @see [RuntimeDomain.queryObjects]
 */
@kotlinx.serialization.Serializable
data class QueryObjectsResponse(
    /**  
     * Array with objects.  
     */  
    val objects: RemoteObject

)

/**
 * Represents request frame that can be used with [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) operation call.
 *
 * Releases remote object with given id.
 * @link [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) method documentation.
 * @see [RuntimeDomain.releaseObject]
 */
@kotlinx.serialization.Serializable
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
 * @see [RuntimeDomain.releaseObjectGroup]
 */
@kotlinx.serialization.Serializable
data class ReleaseObjectGroupRequest(
    /**
     * Symbolic object group name.
     */
    val objectGroup: String

)

/**
 * Represents request frame that can be used with [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) operation call.
 *
 * Runs script with given id in a given context.
 * @link [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
 * @see [RuntimeDomain.runScript]
 */
@kotlinx.serialization.Serializable
data class RunScriptRequest(
    /**
     * Id of the script to run.
     */
    val scriptId: ScriptId,

    /**
     * Specifies in which execution context to perform script run. If the parameter is omitted the
evaluation will be performed in the context of the inspected page.
     */
    val executionContextId: ExecutionContextId? = null,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup: String? = null,

    /**
     * In silent mode exceptions thrown during evaluation are not reported and do not pause
execution. Overrides `setPauseOnException` state.
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
     * Whether execution should `await` for resulting value and return once awaited promise is
resolved.
     */
    val awaitPromise: Boolean? = null

)

/**
 * Represents response frame that is returned from [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) operation call.
 * Runs script with given id in a given context.
 *
  
 * @link [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
 * @see [RuntimeDomain.runScript]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Runtime#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setAsyncCallStackDepth) operation call.
 *
 * Enables or disables async call stacks tracking.
 * @link [Runtime#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setAsyncCallStackDepth) method documentation.
 * @see [RuntimeDomain.setAsyncCallStackDepth]
 */
@kotlinx.serialization.Serializable
data class SetAsyncCallStackDepthRequest(
    /**
     * Maximum depth of async call stacks. Setting to `0` will effectively disable collecting async
call stacks (default).
     */
    val maxDepth: Int

)

/**
 * Represents request frame that can be used with [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) operation call.
 *
 *
 * @link [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) method documentation.
 * @see [RuntimeDomain.setCustomObjectFormatterEnabled]
 */
@kotlinx.serialization.Serializable
data class SetCustomObjectFormatterEnabledRequest(
    /**
     *
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Runtime#setMaxCallStackSizeToCapture](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setMaxCallStackSizeToCapture) operation call.
 *
 *
 * @link [Runtime#setMaxCallStackSizeToCapture](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setMaxCallStackSizeToCapture) method documentation.
 * @see [RuntimeDomain.setMaxCallStackSizeToCapture]
 */
@kotlinx.serialization.Serializable
data class SetMaxCallStackSizeToCaptureRequest(
    /**
     *
     */
    val size: Int

)

/**
 * Represents request frame that can be used with [Runtime#addBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-addBinding) operation call.
 *
 * If executionContextId is empty, adds binding with the given name on the
global objects of all inspected contexts, including those created later,
bindings survive reloads.
Binding function takes exactly one argument, this argument should be string,
in case of any other input, function throws an exception.
Each binding function call produces Runtime.bindingCalled notification.
 * @link [Runtime#addBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-addBinding) method documentation.
 * @see [RuntimeDomain.addBinding]
 */
@kotlinx.serialization.Serializable
data class AddBindingRequest(
    /**
     *
     */
    val name: String,

    /**
     * If specified, the binding would only be exposed to the specified
execution context. If omitted and `executionContextName` is not set,
the binding is exposed to all execution contexts of the target.
This parameter is mutually exclusive with `executionContextName`.
     */
    val executionContextId: ExecutionContextId? = null,

    /**
     * If specified, the binding is exposed to the executionContext with
matching name, even for contexts created after the binding is added.
See also `ExecutionContext.name` and `worldName` parameter to
`Page.addScriptToEvaluateOnNewDocument`.
This parameter is mutually exclusive with `executionContextId`.
     */
    @pl.wendigo.chrome.protocol.Experimental val executionContextName: String? = null

)

/**
 * Represents request frame that can be used with [Runtime#removeBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-removeBinding) operation call.
 *
 * This method does not remove binding function from global object but
unsubscribes current runtime agent from Runtime.bindingCalled notifications.
 * @link [Runtime#removeBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-removeBinding) method documentation.
 * @see [RuntimeDomain.removeBinding]
 */
@kotlinx.serialization.Serializable
data class RemoveBindingRequest(
    /**
     *
     */
    val name: String

)

/**
 * Notification is issued every time when binding is called.
 *
 * @link [Runtime#bindingCalled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-bindingCalled) event documentation.
 */
@kotlinx.serialization.Serializable
data class BindingCalledEvent(
    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val payload: String,

    /**  
     * Identifier of the context where the call was made.  
     */  
    val executionContextId: ExecutionContextId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "bindingCalled"
} 

/**
 * Issued when console API was called.
 *
 * @link [Runtime#consoleAPICalled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-consoleAPICalled) event documentation.
 */
@kotlinx.serialization.Serializable
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
     * Stack trace captured when the call was made. The async stack chain is automatically reported for  
     the following call types: `assert`, `error`, `trace`, `warning`. For other types the async call  
     chain can be retrieved using `Debugger.getStackTrace` and `stackTrace.parentId` field.  
     */  
    val stackTrace: StackTrace? = null,

    /**  
     * Console context descriptor for calls on non-default console context (not console.*):  
     'anonymous#unique-logger-id' for call on unnamed context, 'name#unique-logger-id' for call  
     on named context.  
     */  
    val context: String? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "consoleAPICalled"
} 

/**
 * Issued when unhandled exception was revoked.
 *
 * @link [Runtime#exceptionRevoked](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-exceptionRevoked) event documentation.
 */
@kotlinx.serialization.Serializable
data class ExceptionRevokedEvent(
    /**  
     * Reason describing why exception was revoked.  
     */  
    val reason: String,

    /**  
     * The id of revoked exception, as reported in `exceptionThrown`.  
     */  
    val exceptionId: Int

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "exceptionRevoked"
} 

/**
 * Issued when exception was thrown and unhandled.
 *
 * @link [Runtime#exceptionThrown](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-exceptionThrown) event documentation.
 */
@kotlinx.serialization.Serializable
data class ExceptionThrownEvent(
    /**  
     * Timestamp of the exception.  
     */  
    val timestamp: Timestamp,

    /**  
     *  
     */  
    val exceptionDetails: ExceptionDetails

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "exceptionThrown"
} 

/**
 * Issued when new execution context is created.
 *
 * @link [Runtime#executionContextCreated](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-executionContextCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class ExecutionContextCreatedEvent(
    /**  
     * A newly created execution context.  
     */  
    val context: ExecutionContextDescription

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "executionContextCreated"
} 

/**
 * Issued when execution context is destroyed.
 *
 * @link [Runtime#executionContextDestroyed](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-executionContextDestroyed) event documentation.
 */
@kotlinx.serialization.Serializable
data class ExecutionContextDestroyedEvent(
    /**  
     * Id of the destroyed context  
     */  
    val executionContextId: ExecutionContextId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "executionContextDestroyed"
} 

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API
call).
 *
 * @link [Runtime#inspectRequested](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-inspectRequested) event documentation.
 */
@kotlinx.serialization.Serializable
data class InspectRequestedEvent(
    /**  
     *  
     */  
    @kotlinx.serialization.SerialName("object") val _object: RemoteObject,

    /**  
     *  
     */  
    val hints: kotlinx.serialization.json.JsonElement

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Runtime" 
    override fun eventName() = "inspectRequested"
} 
