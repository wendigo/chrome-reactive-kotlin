package pl.wendigo.chrome.domain.network

/**
 * Network domain allows tracking network activities of the page. It exposes information about http,
file, data and other requests and responses, their headers, bodies, timing, etc.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Network](https://chromedevtools.github.io/devtools-protocol/tot/Network)
 */
class Network internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Tells whether clearing browser cache is supported.
     */
    fun canClearBrowserCache(): io.reactivex.Single<CanClearBrowserCacheResponse> {
        return connectionRemote.runAndCaptureResponse("Network.canClearBrowserCache", null, CanClearBrowserCacheResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Tells whether clearing browser cookies is supported.
     */
    fun canClearBrowserCookies(): io.reactivex.Single<CanClearBrowserCookiesResponse> {
        return connectionRemote.runAndCaptureResponse("Network.canClearBrowserCookies", null, CanClearBrowserCookiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Tells whether emulation of network conditions is supported.
     */
    fun canEmulateNetworkConditions(): io.reactivex.Single<CanEmulateNetworkConditionsResponse> {
        return connectionRemote.runAndCaptureResponse("Network.canEmulateNetworkConditions", null, CanEmulateNetworkConditionsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Clears browser cache.
     */
    fun clearBrowserCache(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.clearBrowserCache", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears browser cookies.
     */
    fun clearBrowserCookies(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.clearBrowserCookies", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Response to Network.requestIntercepted which either modifies the request to continue with any
modifications, or blocks it, or completes it with the provided response bytes. If a network
fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
event will be sent with the same InterceptionId.
Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
     */
    fun continueInterceptedRequest(input: ContinueInterceptedRequestRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.continueInterceptedRequest", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Deletes browser cookies with matching name and url or domain/path pair.
     */
    fun deleteCookies(input: DeleteCookiesRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.deleteCookies", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables network tracking, prevents network events from being sent to the client.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Activates emulation of network conditions.
     */
    fun emulateNetworkConditions(input: EmulateNetworkConditionsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.emulateNetworkConditions", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables network tracking, network events will now be delivered to the client.
     */
    fun enable(input: EnableRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.enable", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
     */
    fun getAllCookies(): io.reactivex.Single<GetAllCookiesResponse> {
        return connectionRemote.runAndCaptureResponse("Network.getAllCookies", null, GetAllCookiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the DER-encoded certificate.
     */
    fun getCertificate(input: GetCertificateRequest): io.reactivex.Single<GetCertificateResponse> {
        return connectionRemote.runAndCaptureResponse("Network.getCertificate", input, GetCertificateResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all browser cookies for the current URL. Depending on the backend support, will return
detailed cookie information in the `cookies` field.
     */
    fun getCookies(input: GetCookiesRequest): io.reactivex.Single<GetCookiesResponse> {
        return connectionRemote.runAndCaptureResponse("Network.getCookies", input, GetCookiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns content served for the given request.
     */
    fun getResponseBody(input: GetResponseBodyRequest): io.reactivex.Single<GetResponseBodyResponse> {
        return connectionRemote.runAndCaptureResponse("Network.getResponseBody", input, GetResponseBodyResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns post data sent with the request. Returns an error when no data was sent with the request.
     */
    fun getRequestPostData(input: GetRequestPostDataRequest): io.reactivex.Single<GetRequestPostDataResponse> {
        return connectionRemote.runAndCaptureResponse("Network.getRequestPostData", input, GetRequestPostDataResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns content served for the given currently intercepted request.
     */
    fun getResponseBodyForInterception(input: GetResponseBodyForInterceptionRequest): io.reactivex.Single<GetResponseBodyForInterceptionResponse> {
        return connectionRemote.runAndCaptureResponse("Network.getResponseBodyForInterception", input, GetResponseBodyForInterceptionResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns a handle to the stream representing the response body. Note that after this command,
the intercepted request can't be continued as is -- you either need to cancel it or to provide
the response body. The stream only supports sequential read, IO.read will fail if the position
is specified.
     */
    fun takeResponseBodyForInterceptionAsStream(input: TakeResponseBodyForInterceptionAsStreamRequest): io.reactivex.Single<TakeResponseBodyForInterceptionAsStreamResponse> {
        return connectionRemote.runAndCaptureResponse("Network.takeResponseBodyForInterceptionAsStream", input, TakeResponseBodyForInterceptionAsStreamResponse::class.java).map {
            it.value()
        }
    }

    /**
     * This method sends a new XMLHttpRequest which is identical to the original one. The following
parameters should be identical: method, url, async, request body, extra headers, withCredentials
attribute, user, password.
     */
    fun replayXHR(input: ReplayXHRRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.replayXHR", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Searches for given string in response content.
     */
    fun searchInResponseBody(input: SearchInResponseBodyRequest): io.reactivex.Single<SearchInResponseBodyResponse> {
        return connectionRemote.runAndCaptureResponse("Network.searchInResponseBody", input, SearchInResponseBodyResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Blocks URLs from loading.
     */
    fun setBlockedURLs(input: SetBlockedURLsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setBlockedURLs", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Toggles ignoring of service worker for each request.
     */
    fun setBypassServiceWorker(input: SetBypassServiceWorkerRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setBypassServiceWorker", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Toggles ignoring cache for each request. If `true`, cache will not be used.
     */
    fun setCacheDisabled(input: SetCacheDisabledRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setCacheDisabled", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
     */
    fun setCookie(input: SetCookieRequest): io.reactivex.Single<SetCookieResponse> {
        return connectionRemote.runAndCaptureResponse("Network.setCookie", input, SetCookieResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sets given cookies.
     */
    fun setCookies(input: SetCookiesRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setCookies", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * For testing.
     */
    fun setDataSizeLimitsForTest(input: SetDataSizeLimitsForTestRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setDataSizeLimitsForTest", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Specifies whether to always send extra HTTP headers with the requests from this page.
     */
    fun setExtraHTTPHeaders(input: SetExtraHTTPHeadersRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setExtraHTTPHeaders", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets the requests to intercept that match the provided patterns and optionally resource types.
Deprecated, please use Fetch.enable instead.
     */
    fun setRequestInterception(input: SetRequestInterceptionRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setRequestInterception", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Allows overriding user agent with the given string.
     */
    fun setUserAgentOverride(input: SetUserAgentOverrideRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Network.setUserAgentOverride", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Fired when data chunk was received over the network.
     */
    fun dataReceived(): io.reactivex.Flowable<DataReceivedEvent> {
        return dataReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when data chunk was received over the network.
     */
    fun dataReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<DataReceivedEvent>> {
        return connectionRemote.captureEvents("Network.dataReceived", DataReceivedEvent::class.java)
    }

    /**
     *  Fired when EventSource message is received.
     */
    fun eventSourceMessageReceived(): io.reactivex.Flowable<EventSourceMessageReceivedEvent> {
        return eventSourceMessageReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when EventSource message is received.
     */
    fun eventSourceMessageReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<EventSourceMessageReceivedEvent>> {
        return connectionRemote.captureEvents("Network.eventSourceMessageReceived", EventSourceMessageReceivedEvent::class.java)
    }

    /**
     *  Fired when HTTP request has failed to load.
     */
    fun loadingFailed(): io.reactivex.Flowable<LoadingFailedEvent> {
        return loadingFailedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when HTTP request has failed to load.
     */
    fun loadingFailedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<LoadingFailedEvent>> {
        return connectionRemote.captureEvents("Network.loadingFailed", LoadingFailedEvent::class.java)
    }

    /**
     *  Fired when HTTP request has finished loading.
     */
    fun loadingFinished(): io.reactivex.Flowable<LoadingFinishedEvent> {
        return loadingFinishedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when HTTP request has finished loading.
     */
    fun loadingFinishedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<LoadingFinishedEvent>> {
        return connectionRemote.captureEvents("Network.loadingFinished", LoadingFinishedEvent::class.java)
    }

    /**
     *  Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
mocked.
Deprecated, use Fetch.requestPaused instead.
     */
    fun requestIntercepted(): io.reactivex.Flowable<RequestInterceptedEvent> {
        return requestInterceptedTimed().map {
            it.value()
        }
    }

    /**
     * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
mocked.
Deprecated, use Fetch.requestPaused instead.
     */
    fun requestInterceptedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<RequestInterceptedEvent>> {
        return connectionRemote.captureEvents("Network.requestIntercepted", RequestInterceptedEvent::class.java)
    }

    /**
     *  Fired if request ended up loading from cache.
     */
    fun requestServedFromCache(): io.reactivex.Flowable<RequestServedFromCacheEvent> {
        return requestServedFromCacheTimed().map {
            it.value()
        }
    }

    /**
     * Fired if request ended up loading from cache.
     */
    fun requestServedFromCacheTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<RequestServedFromCacheEvent>> {
        return connectionRemote.captureEvents("Network.requestServedFromCache", RequestServedFromCacheEvent::class.java)
    }

    /**
     *  Fired when page is about to send HTTP request.
     */
    fun requestWillBeSent(): io.reactivex.Flowable<RequestWillBeSentEvent> {
        return requestWillBeSentTimed().map {
            it.value()
        }
    }

    /**
     * Fired when page is about to send HTTP request.
     */
    fun requestWillBeSentTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<RequestWillBeSentEvent>> {
        return connectionRemote.captureEvents("Network.requestWillBeSent", RequestWillBeSentEvent::class.java)
    }

    /**
     *  Fired when resource loading priority is changed
     */
    fun resourceChangedPriority(): io.reactivex.Flowable<ResourceChangedPriorityEvent> {
        return resourceChangedPriorityTimed().map {
            it.value()
        }
    }

    /**
     * Fired when resource loading priority is changed
     */
    fun resourceChangedPriorityTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ResourceChangedPriorityEvent>> {
        return connectionRemote.captureEvents("Network.resourceChangedPriority", ResourceChangedPriorityEvent::class.java)
    }

    /**
     *  Fired when a signed exchange was received over the network
     */
    fun signedExchangeReceived(): io.reactivex.Flowable<SignedExchangeReceivedEvent> {
        return signedExchangeReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a signed exchange was received over the network
     */
    fun signedExchangeReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<SignedExchangeReceivedEvent>> {
        return connectionRemote.captureEvents("Network.signedExchangeReceived", SignedExchangeReceivedEvent::class.java)
    }

    /**
     *  Fired when HTTP response is available.
     */
    fun responseReceived(): io.reactivex.Flowable<ResponseReceivedEvent> {
        return responseReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when HTTP response is available.
     */
    fun responseReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ResponseReceivedEvent>> {
        return connectionRemote.captureEvents("Network.responseReceived", ResponseReceivedEvent::class.java)
    }

    /**
     *  Fired when WebSocket is closed.
     */
    fun webSocketClosed(): io.reactivex.Flowable<WebSocketClosedEvent> {
        return webSocketClosedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when WebSocket is closed.
     */
    fun webSocketClosedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketClosedEvent>> {
        return connectionRemote.captureEvents("Network.webSocketClosed", WebSocketClosedEvent::class.java)
    }

    /**
     *  Fired upon WebSocket creation.
     */
    fun webSocketCreated(): io.reactivex.Flowable<WebSocketCreatedEvent> {
        return webSocketCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Fired upon WebSocket creation.
     */
    fun webSocketCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketCreatedEvent>> {
        return connectionRemote.captureEvents("Network.webSocketCreated", WebSocketCreatedEvent::class.java)
    }

    /**
     *  Fired when WebSocket message error occurs.
     */
    fun webSocketFrameError(): io.reactivex.Flowable<WebSocketFrameErrorEvent> {
        return webSocketFrameErrorTimed().map {
            it.value()
        }
    }

    /**
     * Fired when WebSocket message error occurs.
     */
    fun webSocketFrameErrorTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketFrameErrorEvent>> {
        return connectionRemote.captureEvents("Network.webSocketFrameError", WebSocketFrameErrorEvent::class.java)
    }

    /**
     *  Fired when WebSocket message is received.
     */
    fun webSocketFrameReceived(): io.reactivex.Flowable<WebSocketFrameReceivedEvent> {
        return webSocketFrameReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when WebSocket message is received.
     */
    fun webSocketFrameReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketFrameReceivedEvent>> {
        return connectionRemote.captureEvents("Network.webSocketFrameReceived", WebSocketFrameReceivedEvent::class.java)
    }

    /**
     *  Fired when WebSocket message is sent.
     */
    fun webSocketFrameSent(): io.reactivex.Flowable<WebSocketFrameSentEvent> {
        return webSocketFrameSentTimed().map {
            it.value()
        }
    }

    /**
     * Fired when WebSocket message is sent.
     */
    fun webSocketFrameSentTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketFrameSentEvent>> {
        return connectionRemote.captureEvents("Network.webSocketFrameSent", WebSocketFrameSentEvent::class.java)
    }

    /**
     *  Fired when WebSocket handshake response becomes available.
     */
    fun webSocketHandshakeResponseReceived(): io.reactivex.Flowable<WebSocketHandshakeResponseReceivedEvent> {
        return webSocketHandshakeResponseReceivedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when WebSocket handshake response becomes available.
     */
    fun webSocketHandshakeResponseReceivedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketHandshakeResponseReceivedEvent>> {
        return connectionRemote.captureEvents("Network.webSocketHandshakeResponseReceived", WebSocketHandshakeResponseReceivedEvent::class.java)
    }

    /**
     *  Fired when WebSocket is about to initiate handshake.
     */
    fun webSocketWillSendHandshakeRequest(): io.reactivex.Flowable<WebSocketWillSendHandshakeRequestEvent> {
        return webSocketWillSendHandshakeRequestTimed().map {
            it.value()
        }
    }

    /**
     * Fired when WebSocket is about to initiate handshake.
     */
    fun webSocketWillSendHandshakeRequestTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WebSocketWillSendHandshakeRequestEvent>> {
        return connectionRemote.captureEvents("Network.webSocketWillSendHandshakeRequest", WebSocketWillSendHandshakeRequestEvent::class.java)
    }

    /**
     *  Fired when additional information about a requestWillBeSent event is available from the
network stack. Not every requestWillBeSent event will have an additional
requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
or requestWillBeSentExtraInfo will be fired first for the same request.
     */
    fun requestWillBeSentExtraInfo(): io.reactivex.Flowable<RequestWillBeSentExtraInfoEvent> {
        return requestWillBeSentExtraInfoTimed().map {
            it.value()
        }
    }

    /**
     * Fired when additional information about a requestWillBeSent event is available from the
network stack. Not every requestWillBeSent event will have an additional
requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
or requestWillBeSentExtraInfo will be fired first for the same request.
     */
    fun requestWillBeSentExtraInfoTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<RequestWillBeSentExtraInfoEvent>> {
        return connectionRemote.captureEvents("Network.requestWillBeSentExtraInfo", RequestWillBeSentExtraInfoEvent::class.java)
    }

    /**
     *  Fired when additional information about a responseReceived event is available from the network
stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
it, and responseReceivedExtraInfo may be fired before or after responseReceived.
     */
    fun responseReceivedExtraInfo(): io.reactivex.Flowable<ResponseReceivedExtraInfoEvent> {
        return responseReceivedExtraInfoTimed().map {
            it.value()
        }
    }

    /**
     * Fired when additional information about a responseReceived event is available from the network
stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
it, and responseReceivedExtraInfo may be fired before or after responseReceived.
     */
    fun responseReceivedExtraInfoTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ResponseReceivedExtraInfoEvent>> {
        return connectionRemote.captureEvents("Network.responseReceivedExtraInfo", ResponseReceivedExtraInfoEvent::class.java)
    }

    /**
     * Returns flowable capturing all Network domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Network"
        }
    }
}

/**
 * Represents response frame for Network.canClearBrowserCache method call.
 *
 * Tells whether clearing browser cache is supported.
 */
data class CanClearBrowserCacheResponse(
    /**  
     * True if browser cache can be cleared.  
     */  
    val result: Boolean

)

/**
 * Represents response frame for Network.canClearBrowserCookies method call.
 *
 * Tells whether clearing browser cookies is supported.
 */
data class CanClearBrowserCookiesResponse(
    /**  
     * True if browser cookies can be cleared.  
     */  
    val result: Boolean

)

/**
 * Represents response frame for Network.canEmulateNetworkConditions method call.
 *
 * Tells whether emulation of network conditions is supported.
 */
data class CanEmulateNetworkConditionsResponse(
    /**  
     * True if emulation of network conditions is supported.  
     */  
    val result: Boolean

)

/**
 * Represents request frame that can be used with Network.continueInterceptedRequest method call.
 *
 * Response to Network.requestIntercepted which either modifies the request to continue with any
modifications, or blocks it, or completes it with the provided response bytes. If a network
fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
event will be sent with the same InterceptionId.
Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
 */
data class ContinueInterceptedRequestRequest(
    /**
     *
     */
    val interceptionId: InterceptionId,

    /**
     * If set this causes the request to fail with the given reason. Passing `Aborted` for requests
marked with `isNavigationRequest` also cancels the navigation. Must not be set in response
to an authChallenge.
     */
    val errorReason: ErrorReason? = null,

    /**
     * If set the requests completes using with the provided base64 encoded raw response, including
HTTP status line and headers etc... Must not be set in response to an authChallenge.
     */
    val rawResponse: String? = null,

    /**
     * If set the request url will be modified in a way that's not observable by page. Must not be
set in response to an authChallenge.
     */
    val url: String? = null,

    /**
     * If set this allows the request method to be overridden. Must not be set in response to an
authChallenge.
     */
    val method: String? = null,

    /**
     * If set this allows postData to be set. Must not be set in response to an authChallenge.
     */
    val postData: String? = null,

    /**
     * If set this allows the request headers to be changed. Must not be set in response to an
authChallenge.
     */
    val headers: Headers? = null,

    /**
     * Response to a requestIntercepted with an authChallenge. Must not be set otherwise.
     */
    val authChallengeResponse: AuthChallengeResponse? = null

)

/**
 * Represents request frame that can be used with Network.deleteCookies method call.
 *
 * Deletes browser cookies with matching name and url or domain/path pair.
 */
data class DeleteCookiesRequest(
    /**
     * Name of the cookies to remove.
     */
    val name: String,

    /**
     * If specified, deletes all the cookies with the given name where domain and path match
provided URL.
     */
    val url: String? = null,

    /**
     * If specified, deletes only cookies with the exact domain.
     */
    val domain: String? = null,

    /**
     * If specified, deletes only cookies with the exact path.
     */
    val path: String? = null

)

/**
 * Represents request frame that can be used with Network.emulateNetworkConditions method call.
 *
 * Activates emulation of network conditions.
 */
data class EmulateNetworkConditionsRequest(
    /**
     * True to emulate internet disconnection.
     */
    val offline: Boolean,

    /**
     * Minimum latency from request sent to response headers received (ms).
     */
    val latency: Double,

    /**
     * Maximal aggregated download throughput (bytes/sec). -1 disables download throttling.
     */
    val downloadThroughput: Double,

    /**
     * Maximal aggregated upload throughput (bytes/sec).  -1 disables upload throttling.
     */
    val uploadThroughput: Double,

    /**
     * Connection type if known.
     */
    val connectionType: ConnectionType? = null

)

/**
 * Represents request frame that can be used with Network.enable method call.
 *
 * Enables network tracking, network events will now be delivered to the client.
 */
data class EnableRequest(
    /**
     * Buffer size in bytes to use when preserving network payloads (XHRs, etc).
     */
    @pl.wendigo.chrome.Experimental val maxTotalBufferSize: Int? = null,

    /**
     * Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
     */
    @pl.wendigo.chrome.Experimental val maxResourceBufferSize: Int? = null,

    /**
     * Longest post body size (in bytes) that would be included in requestWillBeSent notification
     */
    val maxPostDataSize: Int? = null

)

/**
 * Represents response frame for Network.getAllCookies method call.
 *
 * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
 */
data class GetAllCookiesResponse(
    /**  
     * Array of cookie objects.  
     */  
    val cookies: List<Cookie>

)

/**
 * Represents request frame that can be used with Network.getCertificate method call.
 *
 * Returns the DER-encoded certificate.
 */
data class GetCertificateRequest(
    /**
     * Origin to get certificate for.
     */
    val origin: String

)

/**
 * Represents response frame for Network.getCertificate method call.
 *
 * Returns the DER-encoded certificate.
 */
data class GetCertificateResponse(
    /**  
     *  
     */  
    val tableNames: List<String>

)

/**
 * Represents request frame that can be used with Network.getCookies method call.
 *
 * Returns all browser cookies for the current URL. Depending on the backend support, will return
detailed cookie information in the `cookies` field.
 */
data class GetCookiesRequest(
    /**
     * The list of URLs for which applicable cookies will be fetched
     */
    val urls: List<String>? = null

)

/**
 * Represents response frame for Network.getCookies method call.
 *
 * Returns all browser cookies for the current URL. Depending on the backend support, will return
detailed cookie information in the `cookies` field.
 */
data class GetCookiesResponse(
    /**  
     * Array of cookie objects.  
     */  
    val cookies: List<Cookie>

)

/**
 * Represents request frame that can be used with Network.getResponseBody method call.
 *
 * Returns content served for the given request.
 */
data class GetResponseBodyRequest(
    /**
     * Identifier of the network request to get content for.
     */
    val requestId: RequestId

)

/**
 * Represents response frame for Network.getResponseBody method call.
 *
 * Returns content served for the given request.
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
 * Represents request frame that can be used with Network.getRequestPostData method call.
 *
 * Returns post data sent with the request. Returns an error when no data was sent with the request.
 */
data class GetRequestPostDataRequest(
    /**
     * Identifier of the network request to get content for.
     */
    val requestId: RequestId

)

/**
 * Represents response frame for Network.getRequestPostData method call.
 *
 * Returns post data sent with the request. Returns an error when no data was sent with the request.
 */
data class GetRequestPostDataResponse(
    /**  
     * Request body string, omitting files from multipart requests  
     */  
    val postData: String

)

/**
 * Represents request frame that can be used with Network.getResponseBodyForInterception method call.
 *
 * Returns content served for the given currently intercepted request.
 */
data class GetResponseBodyForInterceptionRequest(
    /**
     * Identifier for the intercepted request to get body for.
     */
    val interceptionId: InterceptionId

)

/**
 * Represents response frame for Network.getResponseBodyForInterception method call.
 *
 * Returns content served for the given currently intercepted request.
 */
data class GetResponseBodyForInterceptionResponse(
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
 * Represents request frame that can be used with Network.takeResponseBodyForInterceptionAsStream method call.
 *
 * Returns a handle to the stream representing the response body. Note that after this command,
the intercepted request can't be continued as is -- you either need to cancel it or to provide
the response body. The stream only supports sequential read, IO.read will fail if the position
is specified.
 */
data class TakeResponseBodyForInterceptionAsStreamRequest(
    /**
     *
     */
    val interceptionId: InterceptionId

)

/**
 * Represents response frame for Network.takeResponseBodyForInterceptionAsStream method call.
 *
 * Returns a handle to the stream representing the response body. Note that after this command,
the intercepted request can't be continued as is -- you either need to cancel it or to provide
the response body. The stream only supports sequential read, IO.read will fail if the position
is specified.
 */
data class TakeResponseBodyForInterceptionAsStreamResponse(
    /**  
     *  
     */  
    val stream: pl.wendigo.chrome.domain.io.StreamHandle

)

/**
 * Represents request frame that can be used with Network.replayXHR method call.
 *
 * This method sends a new XMLHttpRequest which is identical to the original one. The following
parameters should be identical: method, url, async, request body, extra headers, withCredentials
attribute, user, password.
 */
data class ReplayXHRRequest(
    /**
     * Identifier of XHR to replay.
     */
    val requestId: RequestId

)

/**
 * Represents request frame that can be used with Network.searchInResponseBody method call.
 *
 * Searches for given string in response content.
 */
data class SearchInResponseBodyRequest(
    /**
     * Identifier of the network response to search.
     */
    val requestId: RequestId,

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
 * Represents response frame for Network.searchInResponseBody method call.
 *
 * Searches for given string in response content.
 */
data class SearchInResponseBodyResponse(
    /**  
     * List of search matches.  
     */  
    val result: List<pl.wendigo.chrome.domain.debugger.SearchMatch>

)

/**
 * Represents request frame that can be used with Network.setBlockedURLs method call.
 *
 * Blocks URLs from loading.
 */
data class SetBlockedURLsRequest(
    /**
     * URL patterns to block. Wildcards ('*') are allowed.
     */
    val urls: List<String>

)

/**
 * Represents request frame that can be used with Network.setBypassServiceWorker method call.
 *
 * Toggles ignoring of service worker for each request.
 */
data class SetBypassServiceWorkerRequest(
    /**
     * Bypass service worker and load from network.
     */
    val bypass: Boolean

)

/**
 * Represents request frame that can be used with Network.setCacheDisabled method call.
 *
 * Toggles ignoring cache for each request. If `true`, cache will not be used.
 */
data class SetCacheDisabledRequest(
    /**
     * Cache disabled state.
     */
    val cacheDisabled: Boolean

)

/**
 * Represents request frame that can be used with Network.setCookie method call.
 *
 * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
 */
data class SetCookieRequest(
    /**
     * Cookie name.
     */
    val name: String,

    /**
     * Cookie value.
     */
    val value: String,

    /**
     * The request-URI to associate with the setting of the cookie. This value can affect the
default domain and path values of the created cookie.
     */
    val url: String? = null,

    /**
     * Cookie domain.
     */
    val domain: String? = null,

    /**
     * Cookie path.
     */
    val path: String? = null,

    /**
     * True if cookie is secure.
     */
    val secure: Boolean? = null,

    /**
     * True if cookie is http-only.
     */
    val httpOnly: Boolean? = null,

    /**
     * Cookie SameSite type.
     */
    val sameSite: CookieSameSite? = null,

    /**
     * Cookie expiration date, session cookie if not set
     */
    val expires: TimeSinceEpoch? = null

)

/**
 * Represents response frame for Network.setCookie method call.
 *
 * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
 */
data class SetCookieResponse(
    /**  
     * True if successfully set cookie.  
     */  
    val success: Boolean

)

/**
 * Represents request frame that can be used with Network.setCookies method call.
 *
 * Sets given cookies.
 */
data class SetCookiesRequest(
    /**
     * Cookies to be set.
     */
    val cookies: List<CookieParam>

)

/**
 * Represents request frame that can be used with Network.setDataSizeLimitsForTest method call.
 *
 * For testing.
 */
data class SetDataSizeLimitsForTestRequest(
    /**
     * Maximum total buffer size.
     */
    val maxTotalSize: Int,

    /**
     * Maximum per-resource size.
     */
    val maxResourceSize: Int

)

/**
 * Represents request frame that can be used with Network.setExtraHTTPHeaders method call.
 *
 * Specifies whether to always send extra HTTP headers with the requests from this page.
 */
data class SetExtraHTTPHeadersRequest(
    /**
     * Map with extra HTTP headers.
     */
    val headers: Headers

)

/**
 * Represents request frame that can be used with Network.setRequestInterception method call.
 *
 * Sets the requests to intercept that match the provided patterns and optionally resource types.
Deprecated, please use Fetch.enable instead.
 */
data class SetRequestInterceptionRequest(
    /**
     * Requests matching any of these patterns will be forwarded and wait for the corresponding
continueInterceptedRequest call.
     */
    val patterns: List<RequestPattern>

)

/**
 * Represents request frame that can be used with Network.setUserAgentOverride method call.
 *
 * Allows overriding user agent with the given string.
 */
data class SetUserAgentOverrideRequest(
    /**
     * User agent to use.
     */
    val userAgent: String,

    /**
     * Browser langugage to emulate.
     */
    val acceptLanguage: String? = null,

    /**
     * The platform navigator.platform should return.
     */
    val platform: String? = null

)

/**
 * Represents event frames for Network.dataReceived
 *
 * Fired when data chunk was received over the network.
 */
data class DataReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Data chunk length.  
     */  
    val dataLength: Int,

    /**  
     * Actual bytes received (might be less than dataLength for compressed encodings).  
     */  
    val encodedDataLength: Int

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "dataReceived")

/**
 * Represents event frames for Network.eventSourceMessageReceived
 *
 * Fired when EventSource message is received.
 */
data class EventSourceMessageReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Message type.  
     */  
    val eventName: String,

    /**  
     * Message identifier.  
     */  
    val eventId: String,

    /**  
     * Message content.  
     */  
    val data: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "eventSourceMessageReceived")

/**
 * Represents event frames for Network.loadingFailed
 *
 * Fired when HTTP request has failed to load.
 */
data class LoadingFailedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Resource type.  
     */  
    val type: ResourceType,

    /**  
     * User friendly error message.  
     */  
    val errorText: String,

    /**  
     * True if loading was canceled.  
     */  
    val canceled: Boolean? = null,

    /**  
     * The reason why loading was blocked, if any.  
     */  
    val blockedReason: BlockedReason? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "loadingFailed")

/**
 * Represents event frames for Network.loadingFinished
 *
 * Fired when HTTP request has finished loading.
 */
data class LoadingFinishedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Total number of bytes received for this request.  
     */  
    val encodedDataLength: Double,

    /**  
     * Set when 1) response was blocked by Cross-Origin Read Blocking and also  
     2) this needs to be reported to the DevTools console.  
     */  
    val shouldReportCorbBlocking: Boolean? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "loadingFinished")

/**
 * Represents event frames for Network.requestIntercepted
 *
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
mocked.
Deprecated, use Fetch.requestPaused instead.
 */
data class RequestInterceptedEvent(
    /**  
     * Each request the page makes will have a unique id, however if any redirects are encountered  
     while processing that fetch, they will be reported with the same id as the original fetch.  
     Likewise if HTTP authentication is needed then the same fetch id will be used.  
     */  
    val interceptionId: InterceptionId,

    /**  
     *  
     */  
    val request: Request,

    /**  
     * The id of the frame that initiated the request.  
     */  
    val frameId: pl.wendigo.chrome.domain.page.FrameId,

    /**  
     * How the requested resource will be used.  
     */  
    val resourceType: ResourceType,

    /**  
     * Whether this is a navigation request, which can abort the navigation completely.  
     */  
    val isNavigationRequest: Boolean,

    /**  
     * Set if the request is a navigation that will result in a download.  
     Only present after response is received from the server (i.e. HeadersReceived stage).  
     */  
    val isDownload: Boolean? = null,

    /**  
     * Redirect location, only sent if a redirect was intercepted.  
     */  
    val redirectUrl: String? = null,

    /**  
     * Details of the Authorization Challenge encountered. If this is set then  
     continueInterceptedRequest must contain an authChallengeResponse.  
     */  
    val authChallenge: AuthChallenge? = null,

    /**  
     * Response error if intercepted at response stage or if redirect occurred while intercepting  
     request.  
     */  
    val responseErrorReason: ErrorReason? = null,

    /**  
     * Response code if intercepted at response stage or if redirect occurred while intercepting  
     request or auth retry occurred.  
     */  
    val responseStatusCode: Int? = null,

    /**  
     * Response headers if intercepted at the response stage or if redirect occurred while  
     intercepting request or auth retry occurred.  
     */  
    val responseHeaders: Headers? = null,

    /**  
     * If the intercepted request had a corresponding requestWillBeSent event fired for it, then  
     this requestId will be the same as the requestId present in the requestWillBeSent event.  
     */  
    val requestId: RequestId? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "requestIntercepted")

/**
 * Represents event frames for Network.requestServedFromCache
 *
 * Fired if request ended up loading from cache.
 */
data class RequestServedFromCacheEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "requestServedFromCache")

/**
 * Represents event frames for Network.requestWillBeSent
 *
 * Fired when page is about to send HTTP request.
 */
data class RequestWillBeSentEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Loader identifier. Empty string if the request is fetched from worker.  
     */  
    val loaderId: LoaderId,

    /**  
     * URL of the document this request is loaded for.  
     */  
    val documentURL: String,

    /**  
     * Request data.  
     */  
    val request: Request,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Timestamp.  
     */  
    val wallTime: TimeSinceEpoch,

    /**  
     * Request initiator.  
     */  
    val initiator: Initiator,

    /**  
     * Redirect response data.  
     */  
    val redirectResponse: Response? = null,

    /**  
     * Type of this resource.  
     */  
    val type: ResourceType? = null,

    /**  
     * Frame identifier.  
     */  
    val frameId: pl.wendigo.chrome.domain.page.FrameId? = null,

    /**  
     * Whether the request is initiated by a user gesture. Defaults to false.  
     */  
    val hasUserGesture: Boolean? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "requestWillBeSent")

/**
 * Represents event frames for Network.resourceChangedPriority
 *
 * Fired when resource loading priority is changed
 */
data class ResourceChangedPriorityEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * New priority  
     */  
    val newPriority: ResourcePriority,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "resourceChangedPriority")

/**
 * Represents event frames for Network.signedExchangeReceived
 *
 * Fired when a signed exchange was received over the network
 */
data class SignedExchangeReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Information about the signed exchange response.  
     */  
    val info: SignedExchangeInfo

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "signedExchangeReceived")

/**
 * Represents event frames for Network.responseReceived
 *
 * Fired when HTTP response is available.
 */
data class ResponseReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Loader identifier. Empty string if the request is fetched from worker.  
     */  
    val loaderId: LoaderId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Resource type.  
     */  
    val type: ResourceType,

    /**  
     * Response data.  
     */  
    val response: Response,

    /**  
     * Frame identifier.  
     */  
    val frameId: pl.wendigo.chrome.domain.page.FrameId? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "responseReceived")

/**
 * Represents event frames for Network.webSocketClosed
 *
 * Fired when WebSocket is closed.
 */
data class WebSocketClosedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketClosed")

/**
 * Represents event frames for Network.webSocketCreated
 *
 * Fired upon WebSocket creation.
 */
data class WebSocketCreatedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * WebSocket request URL.  
     */  
    val url: String,

    /**  
     * Request initiator.  
     */  
    val initiator: Initiator? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketCreated")

/**
 * Represents event frames for Network.webSocketFrameError
 *
 * Fired when WebSocket message error occurs.
 */
data class WebSocketFrameErrorEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * WebSocket error message.  
     */  
    val errorMessage: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketFrameError")

/**
 * Represents event frames for Network.webSocketFrameReceived
 *
 * Fired when WebSocket message is received.
 */
data class WebSocketFrameReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * WebSocket response data.  
     */  
    val response: WebSocketFrame

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketFrameReceived")

/**
 * Represents event frames for Network.webSocketFrameSent
 *
 * Fired when WebSocket message is sent.
 */
data class WebSocketFrameSentEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * WebSocket response data.  
     */  
    val response: WebSocketFrame

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketFrameSent")

/**
 * Represents event frames for Network.webSocketHandshakeResponseReceived
 *
 * Fired when WebSocket handshake response becomes available.
 */
data class WebSocketHandshakeResponseReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * WebSocket response data.  
     */  
    val response: WebSocketResponse

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketHandshakeResponseReceived")

/**
 * Represents event frames for Network.webSocketWillSendHandshakeRequest
 *
 * Fired when WebSocket is about to initiate handshake.
 */
data class WebSocketWillSendHandshakeRequestEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * UTC Timestamp.  
     */  
    val wallTime: TimeSinceEpoch,

    /**  
     * WebSocket request data.  
     */  
    val request: WebSocketRequest

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "webSocketWillSendHandshakeRequest")

/**
 * Represents event frames for Network.requestWillBeSentExtraInfo
 *
 * Fired when additional information about a requestWillBeSent event is available from the
network stack. Not every requestWillBeSent event will have an additional
requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
or requestWillBeSentExtraInfo will be fired first for the same request.
 */
data class RequestWillBeSentExtraInfoEvent(
    /**  
     * Request identifier. Used to match this information to an existing requestWillBeSent event.  
     */  
    val requestId: RequestId,

    /**  
     * A list of cookies which will not be sent with this request along with corresponding reasons  
     for blocking.  
     */  
    val blockedCookies: List<BlockedCookieWithReason>,

    /**  
     * Raw request headers as they will be sent over the wire.  
     */  
    val headers: Headers

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "requestWillBeSentExtraInfo")

/**
 * Represents event frames for Network.responseReceivedExtraInfo
 *
 * Fired when additional information about a responseReceived event is available from the network
stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
it, and responseReceivedExtraInfo may be fired before or after responseReceived.
 */
data class ResponseReceivedExtraInfoEvent(
    /**  
     * Request identifier. Used to match this information to another responseReceived event.  
     */  
    val requestId: RequestId,

    /**  
     * A list of cookies which were not stored from the response along with the corresponding  
     reasons for blocking. The cookies here may not be valid due to syntax errors, which  
     are represented by the invalid cookie line string instead of a proper cookie.  
     */  
    val blockedCookies: List<BlockedSetCookieWithReason>,

    /**  
     * Raw response headers as they were received over the wire.  
     */  
    val headers: Headers,

    /**  
     * Raw response header text as it was received over the wire. The raw text may not always be  
     available, such as in the case of HTTP/2 or QUIC.  
     */  
    val headersText: String? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Network", name = "responseReceivedExtraInfo")
