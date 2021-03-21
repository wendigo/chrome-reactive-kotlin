package pl.wendigo.chrome.api.fetch

import kotlinx.serialization.json.Json

/**
 * A domain for letting clients substitute browser's network layer with client code.
 *
 * @link Protocol [Fetch](https://chromedevtools.github.io/devtools-protocol/tot/Fetch) domain documentation.
 */

class FetchDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("Fetch", """A domain for letting clients substitute browser's network layer with client code.""", connection) {
    /**
     * Disables the fetch domain.
     *
     * @link Protocol [Fetch#disable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Fetch.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Enables issuing of requestPaused events. A request will be paused until client
calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
     *
     * @link Protocol [Fetch#enable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-enable) method documentation.
     */
    
    fun enable(input: EnableRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Fetch.enable", Json.encodeToJsonElement(EnableRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Causes the request to fail with specified reason.
     *
     * @link Protocol [Fetch#failRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-failRequest) method documentation.
     */
    
    fun failRequest(input: FailRequestRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Fetch.failRequest", Json.encodeToJsonElement(FailRequestRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Provides response to the request.
     *
     * @link Protocol [Fetch#fulfillRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-fulfillRequest) method documentation.
     */
    
    fun fulfillRequest(input: FulfillRequestRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Fetch.fulfillRequest", Json.encodeToJsonElement(FulfillRequestRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Continues the request, optionally modifying some of its parameters.
     *
     * @link Protocol [Fetch#continueRequest](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueRequest) method documentation.
     */
    
    fun continueRequest(input: ContinueRequestRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Fetch.continueRequest", Json.encodeToJsonElement(ContinueRequestRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Continues a request supplying authChallengeResponse following authRequired event.
     *
     * @link Protocol [Fetch#continueWithAuth](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueWithAuth) method documentation.
     */
    
    fun continueWithAuth(input: ContinueWithAuthRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Fetch.continueWithAuth", Json.encodeToJsonElement(ContinueWithAuthRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

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
    
    fun getResponseBody(input: GetResponseBodyRequest): io.reactivex.rxjava3.core.Single<GetResponseBodyResponse> = connection.request("Fetch.getResponseBody", Json.encodeToJsonElement(GetResponseBodyRequest.serializer(), input), GetResponseBodyResponse.serializer())

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
    
    fun takeResponseBodyAsStream(input: TakeResponseBodyAsStreamRequest): io.reactivex.rxjava3.core.Single<TakeResponseBodyAsStreamResponse> = connection.request("Fetch.takeResponseBodyAsStream", Json.encodeToJsonElement(TakeResponseBodyAsStreamRequest.serializer(), input), TakeResponseBodyAsStreamResponse.serializer())

    /**
     *  Issued when the domain is enabled and the request URL matches the
specified filter. The request is paused until the client responds
with one of continueRequest, failRequest or fulfillRequest.
The stage of the request can be determined by presence of responseErrorReason
and responseStatusCode -- the request is at the response stage if either
of these fields is present and in the request stage otherwise.
     */
    fun requestPaused(): io.reactivex.rxjava3.core.Flowable<RequestPausedEvent> = connection.events("Fetch.requestPaused", RequestPausedEvent.serializer())

    /**
     *  Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
     */
    fun authRequired(): io.reactivex.rxjava3.core.Flowable<AuthRequiredEvent> = connection.events("Fetch.authRequired", AuthRequiredEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.network.NetworkDomain(connection),
            pl.wendigo.chrome.api.io.IODomain(connection),
            pl.wendigo.chrome.api.page.PageDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [Fetch#enable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-enable) operation call.
 *
 * Enables issuing of requestPaused events. A request will be paused until client
calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
 * @link [Fetch#enable](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-enable) method documentation.
 * @see [FetchDomain.enable]
 */
@kotlinx.serialization.Serializable
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
 * @see [FetchDomain.failRequest]
 */
@kotlinx.serialization.Serializable
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
 * @see [FetchDomain.fulfillRequest]
 */
@kotlinx.serialization.Serializable
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
over the protocol as text. (Encoded as a base64 string when passed over JSON)
     */
    val binaryResponseHeaders: String? = null,

    /**
     * A response body. (Encoded as a base64 string when passed over JSON)
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
 * @see [FetchDomain.continueRequest]
 */
@kotlinx.serialization.Serializable
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
     * If set, overrides the post data in the request. (Encoded as a base64 string when passed over JSON)
     */
    val postData: String? = null,

    /**
     * If set, overrides the request headers.
     */
    val headers: List<HeaderEntry>? = null

)

/**
 * Represents request frame that can be used with [Fetch#continueWithAuth](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueWithAuth) operation call.
 *
 * Continues a request supplying authChallengeResponse following authRequired event.
 * @link [Fetch#continueWithAuth](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#method-continueWithAuth) method documentation.
 * @see [FetchDomain.continueWithAuth]
 */
@kotlinx.serialization.Serializable
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
 * @see [FetchDomain.getResponseBody]
 */
@kotlinx.serialization.Serializable
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
 * @see [FetchDomain.getResponseBody]
 */
@kotlinx.serialization.Serializable
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
 * @see [FetchDomain.takeResponseBodyAsStream]
 */
@kotlinx.serialization.Serializable
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
 * @see [FetchDomain.takeResponseBodyAsStream]
 */
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Fetch" 
    override fun eventName() = "requestPaused"
} 

/**
 * Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
 *
 * @link [Fetch#authRequired](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#event-authRequired) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Fetch" 
    override fun eventName() = "authRequired"
} 
