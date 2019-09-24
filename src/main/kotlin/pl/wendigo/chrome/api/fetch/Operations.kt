package pl.wendigo.chrome.api.fetch

/**
 * A domain for letting clients substitute browser's network layer with client code.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Fetch](https://chromedevtools.github.io/devtools-protocol/tot/Fetch) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class FetchOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables the fetch domain.
     *
     * @link Protocol [Fetch#disable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-disable) method documentation.
     */
    fun disable() = connection.runAndCaptureResponse("Fetch.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables issuing of requestPaused events. A request will be paused until client
calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
     *
     * @link Protocol [Fetch#enable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-enable) method documentation.
     */
    fun enable(input: EnableRequest) = connection.runAndCaptureResponse("Fetch.enable", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Causes the request to fail with specified reason.
     *
     * @link Protocol [Fetch#failRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-failRequest) method documentation.
     */
    fun failRequest(input: FailRequestRequest) = connection.runAndCaptureResponse("Fetch.failRequest", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Provides response to the request.
     *
     * @link Protocol [Fetch#fulfillRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-fulfillRequest) method documentation.
     */
    fun fulfillRequest(input: FulfillRequestRequest) = connection.runAndCaptureResponse("Fetch.fulfillRequest", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Continues the request, optionally modifying some of its parameters.
     *
     * @link Protocol [Fetch#continueRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueRequest) method documentation.
     */
    fun continueRequest(input: ContinueRequestRequest) = connection.runAndCaptureResponse("Fetch.continueRequest", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Continues a request supplying authChallengeResponse following authRequired event.
     *
     * @link Protocol [Fetch#continueWithAuth](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueWithAuth) method documentation.
     */
    fun continueWithAuth(input: ContinueWithAuthRequest) = connection.runAndCaptureResponse("Fetch.continueWithAuth", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Causes the body of the response to be received from the server and
returned as a single string. May only be issued for a request that
is paused in the Response stage and is mutually exclusive with
takeResponseBodyForInterceptionAsStream. Calling other methods that
affect the request or disabling fetch domain before body is received
results in an undefined behavior.
     *
     * @link Protocol [Fetch#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-getResponseBody) method documentation.
     */
    fun getResponseBody(input: GetResponseBodyRequest) = connection.runAndCaptureResponse("Fetch.getResponseBody", input, GetResponseBodyResponse::class.java)

    /**
     * Returns a handle to the stream representing the response body.
The request must be paused in the HeadersReceived stage.
Note that after this command the request can't be continued
as is -- client either needs to cancel it or to provide the
response body.
The stream only supports sequential read, IO.read will fail if the position
is specified.
This method is mutually exclusive with getResponseBody.
Calling other methods that affect the request or disabling fetch
domain before body is received results in an undefined behavior.
     *
     * @link Protocol [Fetch#takeResponseBodyAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-takeResponseBodyAsStream) method documentation.
     */
    fun takeResponseBodyAsStream(input: TakeResponseBodyAsStreamRequest) = connection.runAndCaptureResponse("Fetch.takeResponseBodyAsStream", input, TakeResponseBodyAsStreamResponse::class.java)

    /**
     *  Issued when the domain is enabled and the request URL matches the
specified filter. The request is paused until the client responds
with one of continueRequest, failRequest or fulfillRequest.
The stage of the request can be determined by presence of responseErrorReason
and responseStatusCode -- the request is at the response stage if either
of these fields is present and in the request stage otherwise.
     */
    fun requestPaused(): io.reactivex.Flowable<RequestPausedEvent> = connection.captureEvents("Fetch.requestPaused", RequestPausedEvent::class.java)

    /**
     *  Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
     */
    fun authRequired(): io.reactivex.Flowable<AuthRequiredEvent> = connection.captureEvents("Fetch.authRequired", AuthRequiredEvent::class.java)

    /**
     * Returns flowable capturing all Fetch domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "Fetch"
        }
    }
}

/**
 * Represents request frame that can be used with [Fetch#enable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-enable) operation call.
 *
 * Enables issuing of requestPaused events. A request will be paused until client
calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
 * @link [Fetch#enable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-enable) method documentation.
 * @see [FetchOperations.enable]
 */
data class EnableRequest(
    /**
     * If specified, only requests matching any of these patterns will produce
fetchRequested event and will be paused until clients response. If not set,
all requests will be affected.
     */
    val patterns: List<RequestPattern>? = null,

    /**
     * If true, authRequired events will be issued and requests will be paused
expecting a call to continueWithAuth.
     */
    val handleAuthRequests: Boolean? = null

)

/**
 * Represents request frame that can be used with [Fetch#failRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-failRequest) operation call.
 *
 * Causes the request to fail with specified reason.
 * @link [Fetch#failRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-failRequest) method documentation.
 * @see [FetchOperations.failRequest]
 */
data class FailRequestRequest(
    /**
     * An id the client received in requestPaused event.
     */
    val requestId: RequestId,

    /**
     * Causes the request to fail with the given reason.
     */
    val errorReason: pl.wendigo.chrome.api.network.ErrorReason

)

/**
 * Represents request frame that can be used with [Fetch#fulfillRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-fulfillRequest) operation call.
 *
 * Provides response to the request.
 * @link [Fetch#fulfillRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-fulfillRequest) method documentation.
 * @see [FetchOperations.fulfillRequest]
 */
data class FulfillRequestRequest(
    /**
     * An id the client received in requestPaused event.
     */
    val requestId: RequestId,

    /**
     * An HTTP response code.
     */
    val responseCode: Int,

    /**
     * Response headers.
     */
    val responseHeaders: List<HeaderEntry>? = null,

    /**
     * Alternative way of specifying response headers as a \0-separated
series of name: value pairs. Prefer the above method unless you
need to represent some non-UTF8 values that can't be transmitted
over the protocol as text.
     */
    val binaryResponseHeaders: String? = null,

    /**
     * A response body.
     */
    val body: String? = null,

    /**
     * A textual representation of responseCode.
If absent, a standard phrase matching responseCode is used.
     */
    val responsePhrase: String? = null

)

/**
 * Represents request frame that can be used with [Fetch#continueRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueRequest) operation call.
 *
 * Continues the request, optionally modifying some of its parameters.
 * @link [Fetch#continueRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueRequest) method documentation.
 * @see [FetchOperations.continueRequest]
 */
data class ContinueRequestRequest(
    /**
     * An id the client received in requestPaused event.
     */
    val requestId: RequestId,

    /**
     * If set, the request url will be modified in a way that's not observable by page.
     */
    val url: String? = null,

    /**
     * If set, the request method is overridden.
     */
    val method: String? = null,

    /**
     * If set, overrides the post data in the request.
     */
    val postData: String? = null,

    /**
     * If set, overrides the request headrts.
     */
    val headers: List<HeaderEntry>? = null

)

/**
 * Represents request frame that can be used with [Fetch#continueWithAuth](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueWithAuth) operation call.
 *
 * Continues a request supplying authChallengeResponse following authRequired event.
 * @link [Fetch#continueWithAuth](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueWithAuth) method documentation.
 * @see [FetchOperations.continueWithAuth]
 */
data class ContinueWithAuthRequest(
    /**
     * An id the client received in authRequired event.
     */
    val requestId: RequestId,

    /**
     * Response to  with an authChallenge.
     */
    val authChallengeResponse: AuthChallengeResponse

)

/**
 * Represents request frame that can be used with [Fetch#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-getResponseBody) operation call.
 *
 * Causes the body of the response to be received from the server and
returned as a single string. May only be issued for a request that
is paused in the Response stage and is mutually exclusive with
takeResponseBodyForInterceptionAsStream. Calling other methods that
affect the request or disabling fetch domain before body is received
results in an undefined behavior.
 * @link [Fetch#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-getResponseBody) method documentation.
 * @see [FetchOperations.getResponseBody]
 */
data class GetResponseBodyRequest(
    /**
     * Identifier for the intercepted request to get body for.
     */
    val requestId: RequestId

)
/**
 * Represents response frame that is returned from [Fetch#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-getResponseBody) operation call.
 * Causes the body of the response to be received from the server and
returned as a single string. May only be issued for a request that
is paused in the Response stage and is mutually exclusive with
takeResponseBodyForInterceptionAsStream. Calling other methods that
affect the request or disabling fetch domain before body is received
results in an undefined behavior.
 *
  
 * @link [Fetch#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-getResponseBody) method documentation.
 * @see [FetchOperations.getResponseBody]
 */
data class GetResponseBodyResponse(
    /**  
     * Response body.  
     */  
    val body: String,

    /**  
     * True, if content was sent as base64.  
     */  
    val base64Encoded: Boolean

)

/**
 * Represents request frame that can be used with [Fetch#takeResponseBodyAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-takeResponseBodyAsStream) operation call.
 *
 * Returns a handle to the stream representing the response body.
The request must be paused in the HeadersReceived stage.
Note that after this command the request can't be continued
as is -- client either needs to cancel it or to provide the
response body.
The stream only supports sequential read, IO.read will fail if the position
is specified.
This method is mutually exclusive with getResponseBody.
Calling other methods that affect the request or disabling fetch
domain before body is received results in an undefined behavior.
 * @link [Fetch#takeResponseBodyAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-takeResponseBodyAsStream) method documentation.
 * @see [FetchOperations.takeResponseBodyAsStream]
 */
data class TakeResponseBodyAsStreamRequest(
    /**
     *
     */
    val requestId: RequestId

)
/**
 * Represents response frame that is returned from [Fetch#takeResponseBodyAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-takeResponseBodyAsStream) operation call.
 * Returns a handle to the stream representing the response body.
The request must be paused in the HeadersReceived stage.
Note that after this command the request can't be continued
as is -- client either needs to cancel it or to provide the
response body.
The stream only supports sequential read, IO.read will fail if the position
is specified.
This method is mutually exclusive with getResponseBody.
Calling other methods that affect the request or disabling fetch
domain before body is received results in an undefined behavior.
 *
  
 * @link [Fetch#takeResponseBodyAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-takeResponseBodyAsStream) method documentation.
 * @see [FetchOperations.takeResponseBodyAsStream]
 */
data class TakeResponseBodyAsStreamResponse(
    /**  
     *  
     */  
    val stream: pl.wendigo.chrome.api.io.StreamHandle

)

/**
 * Issued when the domain is enabled and the request URL matches the
specified filter. The request is paused until the client responds
with one of continueRequest, failRequest or fulfillRequest.
The stage of the request can be determined by presence of responseErrorReason
and responseStatusCode -- the request is at the response stage if either
of these fields is present and in the request stage otherwise.
 *
 * @link [Fetch#requestPaused](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#event-requestPaused) event documentation.
 */
data class RequestPausedEvent(
    /**  
     * Each request the page makes will have a unique id.  
     */  
    val requestId: RequestId,

    /**  
     * The details of the request.  
     */  
    val request: pl.wendigo.chrome.api.network.Request,

    /**  
     * The id of the frame that initiated the request.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     * How the requested resource will be used.  
     */  
    val resourceType: pl.wendigo.chrome.api.network.ResourceType,

    /**  
     * Response error if intercepted at response stage.  
     */  
    val responseErrorReason: pl.wendigo.chrome.api.network.ErrorReason? = null,

    /**  
     * Response code if intercepted at response stage.  
     */  
    val responseStatusCode: Int? = null,

    /**  
     * Response headers if intercepted at the response stage.  
     */  
    val responseHeaders: List<HeaderEntry>? = null,

    /**  
     * If the intercepted request had a corresponding Network.requestWillBeSent event fired for it,  
     then this networkId will be the same as the requestId present in the requestWillBeSent event.  
     */  
    val networkId: RequestId? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Fetch", name = "requestPaused")

/**
 * Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
 *
 * @link [Fetch#authRequired](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#event-authRequired) event documentation.
 */
data class AuthRequiredEvent(
    /**  
     * Each request the page makes will have a unique id.  
     */  
    val requestId: RequestId,

    /**  
     * The details of the request.  
     */  
    val request: pl.wendigo.chrome.api.network.Request,

    /**  
     * The id of the frame that initiated the request.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     * How the requested resource will be used.  
     */  
    val resourceType: pl.wendigo.chrome.api.network.ResourceType,

    /**  
     * Details of the Authorization Challenge encountered.  
     If this is set, client should respond with continueRequest that  
     contains AuthChallengeResponse.  
     */  
    val authChallenge: AuthChallenge

) : pl.wendigo.chrome.protocol.Event(domain = "Fetch", name = "authRequired")
