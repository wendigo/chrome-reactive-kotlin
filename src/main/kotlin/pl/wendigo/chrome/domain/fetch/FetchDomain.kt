package pl.wendigo.chrome.domain.fetch

/**
 * A domain for letting clients substitute browser's network layer with client code.
 */
class FetchDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disables the fetch domain.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Fetch.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables issuing of requestPaused events. A request will be paused until client
calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
     */
    fun enable(input: EnableRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Fetch.enable", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Causes the request to fail with specified reason.
     */
    fun failRequest(input: FailRequestRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Fetch.failRequest", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Provides response to the request.
     */
    fun fulfillRequest(input: FulfillRequestRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Fetch.fulfillRequest", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Continues the request, optionally modifying some of its parameters.
     */
    fun continueRequest(input: ContinueRequestRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Fetch.continueRequest", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Continues a request supplying authChallengeResponse following authRequired event.
     */
    fun continueWithAuth(input: ContinueWithAuthRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Fetch.continueWithAuth", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Causes the body of the response to be received from the server and
returned as a single string. May only be issued for a request that
is paused in the Response stage and is mutually exclusive with
takeResponseBodyForInterceptionAsStream. Calling other methods that
affect the request or disabling fetch domain before body is received
results in an undefined behavior.
     */
    fun getResponseBody(input: GetResponseBodyRequest): io.reactivex.Single<GetResponseBodyResponse> {
        return connectionRemote.runAndCaptureResponse("Fetch.getResponseBody", input, GetResponseBodyResponse::class.java).map {
            it.value()
        }
    }

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
     */
    fun takeResponseBodyAsStream(input: TakeResponseBodyAsStreamRequest): io.reactivex.Single<TakeResponseBodyAsStreamResponse> {
        return connectionRemote.runAndCaptureResponse("Fetch.takeResponseBodyAsStream", input, TakeResponseBodyAsStreamResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Issued when the domain is enabled and the request URL matches the
specified filter. The request is paused until the client responds
with one of continueRequest, failRequest or fulfillRequest.
The stage of the request can be determined by presence of responseErrorReason
and responseStatusCode -- the request is at the response stage if either
of these fields is present and in the request stage otherwise.
     */
    fun requestPaused(): io.reactivex.Flowable<RequestPausedEvent> {
        return requestPausedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when the domain is enabled and the request URL matches the
specified filter. The request is paused until the client responds
with one of continueRequest, failRequest or fulfillRequest.
The stage of the request can be determined by presence of responseErrorReason
and responseStatusCode -- the request is at the response stage if either
of these fields is present and in the request stage otherwise.
     */
    fun requestPausedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<RequestPausedEvent>> {
        return connectionRemote.captureEvents("Fetch.requestPaused", RequestPausedEvent::class.java)
    }

    /**
     *  Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
     */
    fun authRequired(): io.reactivex.Flowable<AuthRequiredEvent> {
        return authRequiredTimed().map {
            it.value()
        }
    }

    /**
     * Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
     */
    fun authRequiredTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AuthRequiredEvent>> {
        return connectionRemote.captureEvents("Fetch.authRequired", AuthRequiredEvent::class.java)
    }

    /**
     * Returns flowable capturing all Fetch domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Fetch"
        }
    }
}

/**
 * Represents request frame that can be used with Fetch.enable method call.
 *
 * Enables issuing of requestPaused events. A request will be paused until client
calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
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
 * Represents request frame that can be used with Fetch.failRequest method call.
 *
 * Causes the request to fail with specified reason.
 */
data class FailRequestRequest(
    /**
     * An id the client received in requestPaused event.
     */
    val requestId: RequestId,

    /**
     * Causes the request to fail with the given reason.
     */
    val errorReason: pl.wendigo.chrome.domain.network.ErrorReason

)

/**
 * Represents request frame that can be used with Fetch.fulfillRequest method call.
 *
 * Provides response to the request.
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
    val responseHeaders: List<HeaderEntry>,

    /**
     * A response body.
     */
    val body: String? = null,

    /**
     * A textual representation of responseCode.
If absent, a standard phrase mathcing responseCode is used.
     */
    val responsePhrase: String? = null

)

/**
 * Represents request frame that can be used with Fetch.continueRequest method call.
 *
 * Continues the request, optionally modifying some of its parameters.
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
 * Represents request frame that can be used with Fetch.continueWithAuth method call.
 *
 * Continues a request supplying authChallengeResponse following authRequired event.
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
 * Represents request frame that can be used with Fetch.getResponseBody method call.
 *
 * Causes the body of the response to be received from the server and
returned as a single string. May only be issued for a request that
is paused in the Response stage and is mutually exclusive with
takeResponseBodyForInterceptionAsStream. Calling other methods that
affect the request or disabling fetch domain before body is received
results in an undefined behavior.
 */
data class GetResponseBodyRequest(
    /**
     * Identifier for the intercepted request to get body for.
     */
    val requestId: RequestId

)

/**
 * Represents response frame for Fetch.getResponseBody method call.
 *
 * Causes the body of the response to be received from the server and
returned as a single string. May only be issued for a request that
is paused in the Response stage and is mutually exclusive with
takeResponseBodyForInterceptionAsStream. Calling other methods that
affect the request or disabling fetch domain before body is received
results in an undefined behavior.
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
 * Represents request frame that can be used with Fetch.takeResponseBodyAsStream method call.
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
 */
data class TakeResponseBodyAsStreamRequest(
    /**
     *
     */
    val requestId: RequestId

)

/**
 * Represents response frame for Fetch.takeResponseBodyAsStream method call.
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
 */
data class TakeResponseBodyAsStreamResponse(
    /**  
     *  
     */  
    val stream: pl.wendigo.chrome.domain.io.StreamHandle

)

/**
 * Represents event frames for Fetch.requestPaused
 *
 * Issued when the domain is enabled and the request URL matches the
specified filter. The request is paused until the client responds
with one of continueRequest, failRequest or fulfillRequest.
The stage of the request can be determined by presence of responseErrorReason
and responseStatusCode -- the request is at the response stage if either
of these fields is present and in the request stage otherwise.
 */
data class RequestPausedEvent(
    /**  
     * Each request the page makes will have a unique id.  
     */  
    val requestId: RequestId,

    /**  
     * The details of the request.  
     */  
    val request: pl.wendigo.chrome.domain.network.Request,

    /**  
     * The id of the frame that initiated the request.  
     */  
    val frameId: pl.wendigo.chrome.domain.page.FrameId,

    /**  
     * How the requested resource will be used.  
     */  
    val resourceType: pl.wendigo.chrome.domain.network.ResourceType,

    /**  
     * Response error if intercepted at response stage.  
     */  
    val responseErrorReason: pl.wendigo.chrome.domain.network.ErrorReason? = null,

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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Fetch", name = "requestPaused")

/**
 * Represents event frames for Fetch.authRequired
 *
 * Issued when the domain is enabled with handleAuthRequests set to true.
The request is paused until client responds with continueWithAuth.
 */
data class AuthRequiredEvent(
    /**  
     * Each request the page makes will have a unique id.  
     */  
    val requestId: RequestId,

    /**  
     * The details of the request.  
     */  
    val request: pl.wendigo.chrome.domain.network.Request,

    /**  
     * The id of the frame that initiated the request.  
     */  
    val frameId: pl.wendigo.chrome.domain.page.FrameId,

    /**  
     * How the requested resource will be used.  
     */  
    val resourceType: pl.wendigo.chrome.domain.network.ResourceType,

    /**  
     * Details of the Authorization Challenge encountered.  
  If this is set, client should respond with continueRequest that  
  contains AuthChallengeResponse.  
     */  
    val authChallenge: AuthChallenge

) : pl.wendigo.chrome.ProtocolEvent(domain = "Fetch", name = "authRequired")
