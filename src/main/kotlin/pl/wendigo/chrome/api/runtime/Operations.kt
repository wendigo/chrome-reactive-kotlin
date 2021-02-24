package pl.wendigo.chrome.api.runtime

/**
 * Runtime domain exposes JavaScript runtime by means of remote evaluation and mirror objects.
Evaluation results are returned as mirror object that expose object type, string representation
and unique identifier that can be used for further object reference. Original objects are
maintained in memory unless they are either explicitly released or are released along with the
other objects in their object group.
 *
 * @link Protocol [Runtime](https://chromedevtools.github.io/devtools-protocol/tot/Runtime) domain documentation.
 */
class RuntimeOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Add handler to promise with given promise object id.
     *
     * @link Protocol [Runtime#awaitPromise](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-awaitPromise) method documentation.
     */
    fun awaitPromise(input: AwaitPromiseRequest) = connection.request("Runtime.awaitPromise", input, AwaitPromiseResponse::class.java)

    /**
     * Calls function with given declaration on the given object. Object group of the result is
inherited from the target object.
     *
     * @link Protocol [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
     */
    fun callFunctionOn(input: CallFunctionOnRequest) = connection.request("Runtime.callFunctionOn", input, CallFunctionOnResponse::class.java)

    /**
     * Compiles expression.
     *
     * @link Protocol [Runtime#compileScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-compileScript) method documentation.
     */
    fun compileScript(input: CompileScriptRequest) = connection.request("Runtime.compileScript", input, CompileScriptResponse::class.java)

    /**
     * Disables reporting of execution contexts creation.
     *
     * @link Protocol [Runtime#disable](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-disable) method documentation.
     */
    fun disable() = connection.request("Runtime.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Discards collected exceptions and console API calls.
     *
     * @link Protocol [Runtime#discardConsoleEntries](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-discardConsoleEntries) method documentation.
     */
    fun discardConsoleEntries() = connection.request("Runtime.discardConsoleEntries", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables reporting of execution contexts creation by means of `executionContextCreated` event.
When the reporting gets enabled the event will be sent immediately for each existing execution
context.
     *
     * @link Protocol [Runtime#enable](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-enable) method documentation.
     */
    fun enable() = connection.request("Runtime.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Evaluates expression on global object.
     *
     * @link Protocol [Runtime#evaluate](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-evaluate) method documentation.
     */
    fun evaluate(input: EvaluateRequest) = connection.request("Runtime.evaluate", input, EvaluateResponse::class.java)

    /**
     * Returns the isolate id.
     *
     * @link Protocol [Runtime#getIsolateId](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getIsolateId) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getIsolateId() = connection.request("Runtime.getIsolateId", null, GetIsolateIdResponse::class.java)

    /**
     * Returns the JavaScript heap usage.
It is the total usage of the corresponding isolate not scoped to a particular Runtime.
     *
     * @link Protocol [Runtime#getHeapUsage](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getHeapUsage) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getHeapUsage() = connection.request("Runtime.getHeapUsage", null, GetHeapUsageResponse::class.java)

    /**
     * Returns properties of a given object. Object group of the result is inherited from the target
object.
     *
     * @link Protocol [Runtime#getProperties](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getProperties) method documentation.
     */
    fun getProperties(input: GetPropertiesRequest) = connection.request("Runtime.getProperties", input, GetPropertiesResponse::class.java)

    /**
     * Returns all let, const and class variables from global scope.
     *
     * @link Protocol [Runtime#globalLexicalScopeNames](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-globalLexicalScopeNames) method documentation.
     */
    fun globalLexicalScopeNames(input: GlobalLexicalScopeNamesRequest) = connection.request("Runtime.globalLexicalScopeNames", input, GlobalLexicalScopeNamesResponse::class.java)

    /**
     *
     *
     * @link Protocol [Runtime#queryObjects](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-queryObjects) method documentation.
     */
    fun queryObjects(input: QueryObjectsRequest) = connection.request("Runtime.queryObjects", input, QueryObjectsResponse::class.java)

    /**
     * Releases remote object with given id.
     *
     * @link Protocol [Runtime#releaseObject](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObject) method documentation.
     */
    fun releaseObject(input: ReleaseObjectRequest) = connection.request("Runtime.releaseObject", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Releases all remote objects that belong to a given group.
     *
     * @link Protocol [Runtime#releaseObjectGroup](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-releaseObjectGroup) method documentation.
     */
    fun releaseObjectGroup(input: ReleaseObjectGroupRequest) = connection.request("Runtime.releaseObjectGroup", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Tells inspected instance to run if it was waiting for debugger to attach.
     *
     * @link Protocol [Runtime#runIfWaitingForDebugger](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runIfWaitingForDebugger) method documentation.
     */
    fun runIfWaitingForDebugger() = connection.request("Runtime.runIfWaitingForDebugger", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Runs script with given id in a given context.
     *
     * @link Protocol [Runtime#runScript](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-runScript) method documentation.
     */
    fun runScript(input: RunScriptRequest) = connection.request("Runtime.runScript", input, RunScriptResponse::class.java)

    /**
     * Enables or disables async call stacks tracking.
     *
     * @link Protocol [Runtime#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setAsyncCallStackDepth) method documentation.
     */
    fun setAsyncCallStackDepth(input: SetAsyncCallStackDepthRequest) = connection.request("Runtime.setAsyncCallStackDepth", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Runtime#setCustomObjectFormatterEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setCustomObjectFormatterEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setCustomObjectFormatterEnabled(input: SetCustomObjectFormatterEnabledRequest) = connection.request("Runtime.setCustomObjectFormatterEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Runtime#setMaxCallStackSizeToCapture](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setMaxCallStackSizeToCapture) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setMaxCallStackSizeToCapture(input: SetMaxCallStackSizeToCaptureRequest) = connection.request("Runtime.setMaxCallStackSizeToCapture", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Terminate current or next JavaScript execution.
Will cancel the termination when the outer-most script execution ends.
     *
     * @link Protocol [Runtime#terminateExecution](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-terminateExecution) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun terminateExecution() = connection.request("Runtime.terminateExecution", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

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
    fun addBinding(input: AddBindingRequest) = connection.request("Runtime.addBinding", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * This method does not remove binding function from global object but
unsubscribes current runtime agent from Runtime.bindingCalled notifications.
     *
     * @link Protocol [Runtime#removeBinding](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-removeBinding) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun removeBinding(input: RemoveBindingRequest) = connection.request("Runtime.removeBinding", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Notification is issued every time when binding is called.
     */
    fun bindingCalled(): io.reactivex.Flowable<BindingCalledEvent> = connection.events("Runtime.bindingCalled", BindingCalledEvent::class.java)

    /**
     *  Issued when console API was called.
     */
    fun consoleAPICalled(): io.reactivex.Flowable<ConsoleAPICalledEvent> = connection.events("Runtime.consoleAPICalled", ConsoleAPICalledEvent::class.java)

    /**
     *  Issued when unhandled exception was revoked.
     */
    fun exceptionRevoked(): io.reactivex.Flowable<ExceptionRevokedEvent> = connection.events("Runtime.exceptionRevoked", ExceptionRevokedEvent::class.java)

    /**
     *  Issued when exception was thrown and unhandled.
     */
    fun exceptionThrown(): io.reactivex.Flowable<ExceptionThrownEvent> = connection.events("Runtime.exceptionThrown", ExceptionThrownEvent::class.java)

    /**
     *  Issued when new execution context is created.
     */
    fun executionContextCreated(): io.reactivex.Flowable<ExecutionContextCreatedEvent> = connection.events("Runtime.executionContextCreated", ExecutionContextCreatedEvent::class.java)

    /**
     *  Issued when execution context is destroyed.
     */
    fun executionContextDestroyed(): io.reactivex.Flowable<ExecutionContextDestroyedEvent> = connection.events("Runtime.executionContextDestroyed", ExecutionContextDestroyedEvent::class.java)

    /**
     *  Issued when all executionContexts were cleared in browser
     */
    fun executionContextsCleared(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Runtime.executionContextsCleared", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Issued when object should be inspected (for example, as a result of inspect() command line API
call).
     */
    fun inspectRequested(): io.reactivex.Flowable<InspectRequestedEvent> = connection.events("Runtime.inspectRequested", InspectRequestedEvent::class.java)

    /**
     * Returns flowable capturing all Runtime domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Runtime"
        }
    }
}

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
 * Calls function with given declaration on the given object. Object group of the result is
inherited from the target object.
 * @link [Runtime#callFunctionOn](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-callFunctionOn) method documentation.
 * @see [RuntimeOperations.callFunctionOn]
 */
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
 * Represents response frame that is returned from [Runtime#getIsolateId](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getIsolateId) operation call.
 * Returns the isolate id.
 *
  
 * @link [Runtime#getIsolateId](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-getIsolateId) method documentation.
 * @see [RuntimeOperations.getIsolateId]
 */
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
 * @see [RuntimeOperations.getHeapUsage]
 */
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
 * @see [RuntimeOperations.getProperties]
 */
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
 * @see [RuntimeOperations.globalLexicalScopeNames]
 */
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
 * @see [RuntimeOperations.globalLexicalScopeNames]
 */
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
 * @see [RuntimeOperations.queryObjects]
 */
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
 * @see [RuntimeOperations.queryObjects]
 */
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
 * Represents request frame that can be used with [Runtime#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setAsyncCallStackDepth) operation call.
 *
 * Enables or disables async call stacks tracking.
 * @link [Runtime#setAsyncCallStackDepth](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#method-setAsyncCallStackDepth) method documentation.
 * @see [RuntimeOperations.setAsyncCallStackDepth]
 */
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
 * @see [RuntimeOperations.setCustomObjectFormatterEnabled]
 */
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
 * @see [RuntimeOperations.setMaxCallStackSizeToCapture]
 */
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
 * @see [RuntimeOperations.addBinding]
 */
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
 * @see [RuntimeOperations.removeBinding]
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "bindingCalled")

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

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "consoleAPICalled")

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
     * The id of revoked exception, as reported in `exceptionThrown`.  
     */  
    val exceptionId: Int

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "exceptionRevoked")

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
 * Issued when new execution context is created.
 *
 * @link [Runtime#executionContextCreated](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-executionContextCreated) event documentation.
 */
data class ExecutionContextCreatedEvent(
    /**  
     * A newly created execution context.  
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
 * Issued when object should be inspected (for example, as a result of inspect() command line API
call).
 *
 * @link [Runtime#inspectRequested](https://chromedevtools.github.io/devtools-protocol/tot/Runtime#event-inspectRequested) event documentation.
 */
data class InspectRequestedEvent(
    /**  
     *  
     */  
    @get:com.fasterxml.jackson.annotation.JsonProperty("object") val _object: RemoteObject,

    /**  
     *  
     */  
    val hints: com.fasterxml.jackson.databind.JsonNode

) : pl.wendigo.chrome.protocol.Event(domain = "Runtime", name = "inspectRequested")
