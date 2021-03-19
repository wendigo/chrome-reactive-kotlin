package pl.wendigo.chrome.api.network

import kotlinx.serialization.json.Json

/**
 * Network domain allows tracking network activities of the page. It exposes information about http,
file, data and other requests and responses, their headers, bodies, timing, etc.
 *
 * @link Protocol [Network](https://chromedevtools.github.io/devtools-protocol/tot/Network) domain documentation.
 */
class NetworkOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Tells whether clearing browser cache is supported.
     *
     * @link Protocol [Network#canClearBrowserCache](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canClearBrowserCache) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "canClearBrowserCache is deprecated.")
    fun canClearBrowserCache() = connection.request("Network.canClearBrowserCache", null, CanClearBrowserCacheResponse.serializer())

    /**
     * Tells whether clearing browser cookies is supported.
     *
     * @link Protocol [Network#canClearBrowserCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canClearBrowserCookies) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "canClearBrowserCookies is deprecated.")
    fun canClearBrowserCookies() = connection.request("Network.canClearBrowserCookies", null, CanClearBrowserCookiesResponse.serializer())

    /**
     * Tells whether emulation of network conditions is supported.
     *
     * @link Protocol [Network#canEmulateNetworkConditions](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canEmulateNetworkConditions) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "canEmulateNetworkConditions is deprecated.")
    fun canEmulateNetworkConditions() = connection.request("Network.canEmulateNetworkConditions", null, CanEmulateNetworkConditionsResponse.serializer())

    /**
     * Clears browser cache.
     *
     * @link Protocol [Network#clearBrowserCache](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-clearBrowserCache) method documentation.
     */
    fun clearBrowserCache() = connection.request("Network.clearBrowserCache", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Clears browser cookies.
     *
     * @link Protocol [Network#clearBrowserCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-clearBrowserCookies) method documentation.
     */
    fun clearBrowserCookies() = connection.request("Network.clearBrowserCookies", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Response to Network.requestIntercepted which either modifies the request to continue with any
modifications, or blocks it, or completes it with the provided response bytes. If a network
fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
event will be sent with the same InterceptionId.
Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
     *
     * @link Protocol [Network#continueInterceptedRequest](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-continueInterceptedRequest) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "continueInterceptedRequest is deprecated.")
    @pl.wendigo.chrome.protocol.Experimental
    fun continueInterceptedRequest(input: ContinueInterceptedRequestRequest) = connection.request("Network.continueInterceptedRequest", Json.encodeToJsonElement(ContinueInterceptedRequestRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Deletes browser cookies with matching name and url or domain/path pair.
     *
     * @link Protocol [Network#deleteCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-deleteCookies) method documentation.
     */
    fun deleteCookies(input: DeleteCookiesRequest) = connection.request("Network.deleteCookies", Json.encodeToJsonElement(DeleteCookiesRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Disables network tracking, prevents network events from being sent to the client.
     *
     * @link Protocol [Network#disable](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-disable) method documentation.
     */
    fun disable() = connection.request("Network.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Activates emulation of network conditions.
     *
     * @link Protocol [Network#emulateNetworkConditions](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-emulateNetworkConditions) method documentation.
     */
    fun emulateNetworkConditions(input: EmulateNetworkConditionsRequest) = connection.request("Network.emulateNetworkConditions", Json.encodeToJsonElement(EmulateNetworkConditionsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables network tracking, network events will now be delivered to the client.
     *
     * @link Protocol [Network#enable](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-enable) method documentation.
     */
    fun enable(input: EnableRequest) = connection.request("Network.enable", Json.encodeToJsonElement(EnableRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
     *
     * @link Protocol [Network#getAllCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getAllCookies) method documentation.
     */
    fun getAllCookies() = connection.request("Network.getAllCookies", null, GetAllCookiesResponse.serializer())

    /**
     * Returns the DER-encoded certificate.
     *
     * @link Protocol [Network#getCertificate](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCertificate) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getCertificate(input: GetCertificateRequest) = connection.request("Network.getCertificate", Json.encodeToJsonElement(GetCertificateRequest.serializer(), input), GetCertificateResponse.serializer())

    /**
     * Returns all browser cookies for the current URL. Depending on the backend support, will return
detailed cookie information in the `cookies` field.
     *
     * @link Protocol [Network#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCookies) method documentation.
     */
    fun getCookies(input: GetCookiesRequest) = connection.request("Network.getCookies", Json.encodeToJsonElement(GetCookiesRequest.serializer(), input), GetCookiesResponse.serializer())

    /**
     * Returns content served for the given request.
     *
     * @link Protocol [Network#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBody) method documentation.
     */
    fun getResponseBody(input: GetResponseBodyRequest) = connection.request("Network.getResponseBody", Json.encodeToJsonElement(GetResponseBodyRequest.serializer(), input), GetResponseBodyResponse.serializer())

    /**
     * Returns post data sent with the request. Returns an error when no data was sent with the request.
     *
     * @link Protocol [Network#getRequestPostData](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getRequestPostData) method documentation.
     */
    fun getRequestPostData(input: GetRequestPostDataRequest) = connection.request("Network.getRequestPostData", Json.encodeToJsonElement(GetRequestPostDataRequest.serializer(), input), GetRequestPostDataResponse.serializer())

    /**
     * Returns content served for the given currently intercepted request.
     *
     * @link Protocol [Network#getResponseBodyForInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBodyForInterception) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getResponseBodyForInterception(input: GetResponseBodyForInterceptionRequest) = connection.request("Network.getResponseBodyForInterception", Json.encodeToJsonElement(GetResponseBodyForInterceptionRequest.serializer(), input), GetResponseBodyForInterceptionResponse.serializer())

    /**
     * Returns a handle to the stream representing the response body. Note that after this command,
the intercepted request can't be continued as is -- you either need to cancel it or to provide
the response body. The stream only supports sequential read, IO.read will fail if the position
is specified.
     *
     * @link Protocol [Network#takeResponseBodyForInterceptionAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-takeResponseBodyForInterceptionAsStream) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun takeResponseBodyForInterceptionAsStream(input: TakeResponseBodyForInterceptionAsStreamRequest) = connection.request("Network.takeResponseBodyForInterceptionAsStream", Json.encodeToJsonElement(TakeResponseBodyForInterceptionAsStreamRequest.serializer(), input), TakeResponseBodyForInterceptionAsStreamResponse.serializer())

    /**
     * This method sends a new XMLHttpRequest which is identical to the original one. The following
parameters should be identical: method, url, async, request body, extra headers, withCredentials
attribute, user, password.
     *
     * @link Protocol [Network#replayXHR](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-replayXHR) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun replayXHR(input: ReplayXHRRequest) = connection.request("Network.replayXHR", Json.encodeToJsonElement(ReplayXHRRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Searches for given string in response content.
     *
     * @link Protocol [Network#searchInResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-searchInResponseBody) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun searchInResponseBody(input: SearchInResponseBodyRequest) = connection.request("Network.searchInResponseBody", Json.encodeToJsonElement(SearchInResponseBodyRequest.serializer(), input), SearchInResponseBodyResponse.serializer())

    /**
     * Blocks URLs from loading.
     *
     * @link Protocol [Network#setBlockedURLs](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setBlockedURLs) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBlockedURLs(input: SetBlockedURLsRequest) = connection.request("Network.setBlockedURLs", Json.encodeToJsonElement(SetBlockedURLsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Toggles ignoring of service worker for each request.
     *
     * @link Protocol [Network#setBypassServiceWorker](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setBypassServiceWorker) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBypassServiceWorker(input: SetBypassServiceWorkerRequest) = connection.request("Network.setBypassServiceWorker", Json.encodeToJsonElement(SetBypassServiceWorkerRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Toggles ignoring cache for each request. If `true`, cache will not be used.
     *
     * @link Protocol [Network#setCacheDisabled](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCacheDisabled) method documentation.
     */
    fun setCacheDisabled(input: SetCacheDisabledRequest) = connection.request("Network.setCacheDisabled", Json.encodeToJsonElement(SetCacheDisabledRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
     *
     * @link Protocol [Network#setCookie](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookie) method documentation.
     */
    fun setCookie(input: SetCookieRequest) = connection.request("Network.setCookie", Json.encodeToJsonElement(SetCookieRequest.serializer(), input), SetCookieResponse.serializer())

    /**
     * Sets given cookies.
     *
     * @link Protocol [Network#setCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookies) method documentation.
     */
    fun setCookies(input: SetCookiesRequest) = connection.request("Network.setCookies", Json.encodeToJsonElement(SetCookiesRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * For testing.
     *
     * @link Protocol [Network#setDataSizeLimitsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setDataSizeLimitsForTest) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDataSizeLimitsForTest(input: SetDataSizeLimitsForTestRequest) = connection.request("Network.setDataSizeLimitsForTest", Json.encodeToJsonElement(SetDataSizeLimitsForTestRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Specifies whether to always send extra HTTP headers with the requests from this page.
     *
     * @link Protocol [Network#setExtraHTTPHeaders](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setExtraHTTPHeaders) method documentation.
     */
    fun setExtraHTTPHeaders(input: SetExtraHTTPHeadersRequest) = connection.request("Network.setExtraHTTPHeaders", Json.encodeToJsonElement(SetExtraHTTPHeadersRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Specifies whether to attach a page script stack id in requests
     *
     * @link Protocol [Network#setAttachDebugStack](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setAttachDebugStack) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setAttachDebugStack(input: SetAttachDebugStackRequest) = connection.request("Network.setAttachDebugStack", Json.encodeToJsonElement(SetAttachDebugStackRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets the requests to intercept that match the provided patterns and optionally resource types.
Deprecated, please use Fetch.enable instead.
     *
     * @link Protocol [Network#setRequestInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setRequestInterception) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setRequestInterception is deprecated.")
    @pl.wendigo.chrome.protocol.Experimental
    fun setRequestInterception(input: SetRequestInterceptionRequest) = connection.request("Network.setRequestInterception", Json.encodeToJsonElement(SetRequestInterceptionRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Allows overriding user agent with the given string.
     *
     * @link Protocol [Network#setUserAgentOverride](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setUserAgentOverride) method documentation.
     */
    fun setUserAgentOverride(input: SetUserAgentOverrideRequest) = connection.request("Network.setUserAgentOverride", Json.encodeToJsonElement(SetUserAgentOverrideRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Returns information about the COEP/COOP isolation status.
     *
     * @link Protocol [Network#getSecurityIsolationStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getSecurityIsolationStatus) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getSecurityIsolationStatus(input: GetSecurityIsolationStatusRequest) = connection.request("Network.getSecurityIsolationStatus", Json.encodeToJsonElement(GetSecurityIsolationStatusRequest.serializer(), input), GetSecurityIsolationStatusResponse.serializer())

    /**
     * Fetches the resource and returns the content.
     *
     * @link Protocol [Network#loadNetworkResource](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-loadNetworkResource) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun loadNetworkResource(input: LoadNetworkResourceRequest) = connection.request("Network.loadNetworkResource", Json.encodeToJsonElement(LoadNetworkResourceRequest.serializer(), input), LoadNetworkResourceResponse.serializer())

    /**
     *  Fired when data chunk was received over the network.
     */
    fun dataReceived(): io.reactivex.rxjava3.core.Flowable<DataReceivedEvent> = connection.events("Network.dataReceived", DataReceivedEvent.serializer())

    /**
     *  Fired when EventSource message is received.
     */
    fun eventSourceMessageReceived(): io.reactivex.rxjava3.core.Flowable<EventSourceMessageReceivedEvent> = connection.events("Network.eventSourceMessageReceived", EventSourceMessageReceivedEvent.serializer())

    /**
     *  Fired when HTTP request has failed to load.
     */
    fun loadingFailed(): io.reactivex.rxjava3.core.Flowable<LoadingFailedEvent> = connection.events("Network.loadingFailed", LoadingFailedEvent.serializer())

    /**
     *  Fired when HTTP request has finished loading.
     */
    fun loadingFinished(): io.reactivex.rxjava3.core.Flowable<LoadingFinishedEvent> = connection.events("Network.loadingFinished", LoadingFinishedEvent.serializer())

    /**
     *  Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
mocked.
Deprecated, use Fetch.requestPaused instead.
     */
    fun requestIntercepted(): io.reactivex.rxjava3.core.Flowable<RequestInterceptedEvent> = connection.events("Network.requestIntercepted", RequestInterceptedEvent.serializer())

    /**
     *  Fired if request ended up loading from cache.
     */
    fun requestServedFromCache(): io.reactivex.rxjava3.core.Flowable<RequestServedFromCacheEvent> = connection.events("Network.requestServedFromCache", RequestServedFromCacheEvent.serializer())

    /**
     *  Fired when page is about to send HTTP request.
     */
    fun requestWillBeSent(): io.reactivex.rxjava3.core.Flowable<RequestWillBeSentEvent> = connection.events("Network.requestWillBeSent", RequestWillBeSentEvent.serializer())

    /**
     *  Fired when resource loading priority is changed
     */
    fun resourceChangedPriority(): io.reactivex.rxjava3.core.Flowable<ResourceChangedPriorityEvent> = connection.events("Network.resourceChangedPriority", ResourceChangedPriorityEvent.serializer())

    /**
     *  Fired when a signed exchange was received over the network
     */
    fun signedExchangeReceived(): io.reactivex.rxjava3.core.Flowable<SignedExchangeReceivedEvent> = connection.events("Network.signedExchangeReceived", SignedExchangeReceivedEvent.serializer())

    /**
     *  Fired when HTTP response is available.
     */
    fun responseReceived(): io.reactivex.rxjava3.core.Flowable<ResponseReceivedEvent> = connection.events("Network.responseReceived", ResponseReceivedEvent.serializer())

    /**
     *  Fired when WebSocket is closed.
     */
    fun webSocketClosed(): io.reactivex.rxjava3.core.Flowable<WebSocketClosedEvent> = connection.events("Network.webSocketClosed", WebSocketClosedEvent.serializer())

    /**
     *  Fired upon WebSocket creation.
     */
    fun webSocketCreated(): io.reactivex.rxjava3.core.Flowable<WebSocketCreatedEvent> = connection.events("Network.webSocketCreated", WebSocketCreatedEvent.serializer())

    /**
     *  Fired when WebSocket message error occurs.
     */
    fun webSocketFrameError(): io.reactivex.rxjava3.core.Flowable<WebSocketFrameErrorEvent> = connection.events("Network.webSocketFrameError", WebSocketFrameErrorEvent.serializer())

    /**
     *  Fired when WebSocket message is received.
     */
    fun webSocketFrameReceived(): io.reactivex.rxjava3.core.Flowable<WebSocketFrameReceivedEvent> = connection.events("Network.webSocketFrameReceived", WebSocketFrameReceivedEvent.serializer())

    /**
     *  Fired when WebSocket message is sent.
     */
    fun webSocketFrameSent(): io.reactivex.rxjava3.core.Flowable<WebSocketFrameSentEvent> = connection.events("Network.webSocketFrameSent", WebSocketFrameSentEvent.serializer())

    /**
     *  Fired when WebSocket handshake response becomes available.
     */
    fun webSocketHandshakeResponseReceived(): io.reactivex.rxjava3.core.Flowable<WebSocketHandshakeResponseReceivedEvent> = connection.events("Network.webSocketHandshakeResponseReceived", WebSocketHandshakeResponseReceivedEvent.serializer())

    /**
     *  Fired when WebSocket is about to initiate handshake.
     */
    fun webSocketWillSendHandshakeRequest(): io.reactivex.rxjava3.core.Flowable<WebSocketWillSendHandshakeRequestEvent> = connection.events("Network.webSocketWillSendHandshakeRequest", WebSocketWillSendHandshakeRequestEvent.serializer())

    /**
     *  Fired upon WebTransport creation.
     */
    fun webTransportCreated(): io.reactivex.rxjava3.core.Flowable<WebTransportCreatedEvent> = connection.events("Network.webTransportCreated", WebTransportCreatedEvent.serializer())

    /**
     *  Fired when WebTransport handshake is finished.
     */
    fun webTransportConnectionEstablished(): io.reactivex.rxjava3.core.Flowable<WebTransportConnectionEstablishedEvent> = connection.events("Network.webTransportConnectionEstablished", WebTransportConnectionEstablishedEvent.serializer())

    /**
     *  Fired when WebTransport is disposed.
     */
    fun webTransportClosed(): io.reactivex.rxjava3.core.Flowable<WebTransportClosedEvent> = connection.events("Network.webTransportClosed", WebTransportClosedEvent.serializer())

    /**
     *  Fired when additional information about a requestWillBeSent event is available from the
network stack. Not every requestWillBeSent event will have an additional
requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
or requestWillBeSentExtraInfo will be fired first for the same request.
     */
    fun requestWillBeSentExtraInfo(): io.reactivex.rxjava3.core.Flowable<RequestWillBeSentExtraInfoEvent> = connection.events("Network.requestWillBeSentExtraInfo", RequestWillBeSentExtraInfoEvent.serializer())

    /**
     *  Fired when additional information about a responseReceived event is available from the network
stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
it, and responseReceivedExtraInfo may be fired before or after responseReceived.
     */
    fun responseReceivedExtraInfo(): io.reactivex.rxjava3.core.Flowable<ResponseReceivedExtraInfoEvent> = connection.events("Network.responseReceivedExtraInfo", ResponseReceivedExtraInfoEvent.serializer())

    /**
     *  Fired exactly once for each Trust Token operation. Depending on
the type of the operation and whether the operation succeeded or
failed, the event is fired before the corresponding request was sent
or after the response was received.
     */
    fun trustTokenOperationDone(): io.reactivex.rxjava3.core.Flowable<TrustTokenOperationDoneEvent> = connection.events("Network.trustTokenOperationDone", TrustTokenOperationDoneEvent.serializer())

    /**
     * Returns flowable capturing all Network domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.domain() == "Network"
        }
    }
}

/**
 * Represents response frame that is returned from [Network#canClearBrowserCache](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canClearBrowserCache) operation call.
 * Tells whether clearing browser cache is supported.
 *
  
 * @link [Network#canClearBrowserCache](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canClearBrowserCache) method documentation.
 * @see [NetworkOperations.canClearBrowserCache]
 */
@kotlinx.serialization.Serializable
data class CanClearBrowserCacheResponse(
    /**  
     * True if browser cache can be cleared.  
     */  
    val result: Boolean

)

/**
 * Represents response frame that is returned from [Network#canClearBrowserCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canClearBrowserCookies) operation call.
 * Tells whether clearing browser cookies is supported.
 *
  
 * @link [Network#canClearBrowserCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canClearBrowserCookies) method documentation.
 * @see [NetworkOperations.canClearBrowserCookies]
 */
@kotlinx.serialization.Serializable
data class CanClearBrowserCookiesResponse(
    /**  
     * True if browser cookies can be cleared.  
     */  
    val result: Boolean

)

/**
 * Represents response frame that is returned from [Network#canEmulateNetworkConditions](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canEmulateNetworkConditions) operation call.
 * Tells whether emulation of network conditions is supported.
 *
  
 * @link [Network#canEmulateNetworkConditions](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-canEmulateNetworkConditions) method documentation.
 * @see [NetworkOperations.canEmulateNetworkConditions]
 */
@kotlinx.serialization.Serializable
data class CanEmulateNetworkConditionsResponse(
    /**  
     * True if emulation of network conditions is supported.  
     */  
    val result: Boolean

)

/**
 * Represents request frame that can be used with [Network#continueInterceptedRequest](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-continueInterceptedRequest) operation call.
 *
 * Response to Network.requestIntercepted which either modifies the request to continue with any
modifications, or blocks it, or completes it with the provided response bytes. If a network
fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
event will be sent with the same InterceptionId.
Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
 * @link [Network#continueInterceptedRequest](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-continueInterceptedRequest) method documentation.
 * @see [NetworkOperations.continueInterceptedRequest]
 */
@kotlinx.serialization.Serializable
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
HTTP status line and headers etc... Must not be set in response to an authChallenge. (Encoded as a base64 string when passed over JSON)
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
 * Represents request frame that can be used with [Network#deleteCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-deleteCookies) operation call.
 *
 * Deletes browser cookies with matching name and url or domain/path pair.
 * @link [Network#deleteCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-deleteCookies) method documentation.
 * @see [NetworkOperations.deleteCookies]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Network#emulateNetworkConditions](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-emulateNetworkConditions) operation call.
 *
 * Activates emulation of network conditions.
 * @link [Network#emulateNetworkConditions](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-emulateNetworkConditions) method documentation.
 * @see [NetworkOperations.emulateNetworkConditions]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Network#enable](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-enable) operation call.
 *
 * Enables network tracking, network events will now be delivered to the client.
 * @link [Network#enable](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-enable) method documentation.
 * @see [NetworkOperations.enable]
 */
@kotlinx.serialization.Serializable
data class EnableRequest(
    /**
     * Buffer size in bytes to use when preserving network payloads (XHRs, etc).
     */
    @pl.wendigo.chrome.protocol.Experimental val maxTotalBufferSize: Int? = null,

    /**
     * Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
     */
    @pl.wendigo.chrome.protocol.Experimental val maxResourceBufferSize: Int? = null,

    /**
     * Longest post body size (in bytes) that would be included in requestWillBeSent notification
     */
    val maxPostDataSize: Int? = null

)

/**
 * Represents response frame that is returned from [Network#getAllCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getAllCookies) operation call.
 * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
 *
  
 * @link [Network#getAllCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getAllCookies) method documentation.
 * @see [NetworkOperations.getAllCookies]
 */
@kotlinx.serialization.Serializable
data class GetAllCookiesResponse(
    /**  
     * Array of cookie objects.  
     */  
    val cookies: List<Cookie>

)

/**
 * Represents request frame that can be used with [Network#getCertificate](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCertificate) operation call.
 *
 * Returns the DER-encoded certificate.
 * @link [Network#getCertificate](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCertificate) method documentation.
 * @see [NetworkOperations.getCertificate]
 */
@kotlinx.serialization.Serializable
data class GetCertificateRequest(
    /**
     * Origin to get certificate for.
     */
    val origin: String

)

/**
 * Represents response frame that is returned from [Network#getCertificate](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCertificate) operation call.
 * Returns the DER-encoded certificate.
 *
  
 * @link [Network#getCertificate](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCertificate) method documentation.
 * @see [NetworkOperations.getCertificate]
 */
@kotlinx.serialization.Serializable
data class GetCertificateResponse(
    /**  
     *  
     */  
    val tableNames: List<String>

)

/**
 * Represents request frame that can be used with [Network#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCookies) operation call.
 *
 * Returns all browser cookies for the current URL. Depending on the backend support, will return
detailed cookie information in the `cookies` field.
 * @link [Network#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCookies) method documentation.
 * @see [NetworkOperations.getCookies]
 */
@kotlinx.serialization.Serializable
data class GetCookiesRequest(
    /**
     * The list of URLs for which applicable cookies will be fetched.
If not specified, it's assumed to be set to the list containing
the URLs of the page and all of its subframes.
     */
    val urls: List<String>? = null

)

/**
 * Represents response frame that is returned from [Network#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCookies) operation call.
 * Returns all browser cookies for the current URL. Depending on the backend support, will return
detailed cookie information in the `cookies` field.
 *
  
 * @link [Network#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getCookies) method documentation.
 * @see [NetworkOperations.getCookies]
 */
@kotlinx.serialization.Serializable
data class GetCookiesResponse(
    /**  
     * Array of cookie objects.  
     */  
    val cookies: List<Cookie>

)

/**
 * Represents request frame that can be used with [Network#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBody) operation call.
 *
 * Returns content served for the given request.
 * @link [Network#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBody) method documentation.
 * @see [NetworkOperations.getResponseBody]
 */
@kotlinx.serialization.Serializable
data class GetResponseBodyRequest(
    /**
     * Identifier of the network request to get content for.
     */
    val requestId: RequestId

)

/**
 * Represents response frame that is returned from [Network#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBody) operation call.
 * Returns content served for the given request.
 *
  
 * @link [Network#getResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBody) method documentation.
 * @see [NetworkOperations.getResponseBody]
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
 * Represents request frame that can be used with [Network#getRequestPostData](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getRequestPostData) operation call.
 *
 * Returns post data sent with the request. Returns an error when no data was sent with the request.
 * @link [Network#getRequestPostData](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getRequestPostData) method documentation.
 * @see [NetworkOperations.getRequestPostData]
 */
@kotlinx.serialization.Serializable
data class GetRequestPostDataRequest(
    /**
     * Identifier of the network request to get content for.
     */
    val requestId: RequestId

)

/**
 * Represents response frame that is returned from [Network#getRequestPostData](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getRequestPostData) operation call.
 * Returns post data sent with the request. Returns an error when no data was sent with the request.
 *
  
 * @link [Network#getRequestPostData](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getRequestPostData) method documentation.
 * @see [NetworkOperations.getRequestPostData]
 */
@kotlinx.serialization.Serializable
data class GetRequestPostDataResponse(
    /**  
     * Request body string, omitting files from multipart requests  
     */  
    val postData: String

)

/**
 * Represents request frame that can be used with [Network#getResponseBodyForInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBodyForInterception) operation call.
 *
 * Returns content served for the given currently intercepted request.
 * @link [Network#getResponseBodyForInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBodyForInterception) method documentation.
 * @see [NetworkOperations.getResponseBodyForInterception]
 */
@kotlinx.serialization.Serializable
data class GetResponseBodyForInterceptionRequest(
    /**
     * Identifier for the intercepted request to get body for.
     */
    val interceptionId: InterceptionId

)

/**
 * Represents response frame that is returned from [Network#getResponseBodyForInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBodyForInterception) operation call.
 * Returns content served for the given currently intercepted request.
 *
  
 * @link [Network#getResponseBodyForInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getResponseBodyForInterception) method documentation.
 * @see [NetworkOperations.getResponseBodyForInterception]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Network#takeResponseBodyForInterceptionAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-takeResponseBodyForInterceptionAsStream) operation call.
 *
 * Returns a handle to the stream representing the response body. Note that after this command,
the intercepted request can't be continued as is -- you either need to cancel it or to provide
the response body. The stream only supports sequential read, IO.read will fail if the position
is specified.
 * @link [Network#takeResponseBodyForInterceptionAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-takeResponseBodyForInterceptionAsStream) method documentation.
 * @see [NetworkOperations.takeResponseBodyForInterceptionAsStream]
 */
@kotlinx.serialization.Serializable
data class TakeResponseBodyForInterceptionAsStreamRequest(
    /**
     *
     */
    val interceptionId: InterceptionId

)

/**
 * Represents response frame that is returned from [Network#takeResponseBodyForInterceptionAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-takeResponseBodyForInterceptionAsStream) operation call.
 * Returns a handle to the stream representing the response body. Note that after this command,
the intercepted request can't be continued as is -- you either need to cancel it or to provide
the response body. The stream only supports sequential read, IO.read will fail if the position
is specified.
 *
  
 * @link [Network#takeResponseBodyForInterceptionAsStream](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-takeResponseBodyForInterceptionAsStream) method documentation.
 * @see [NetworkOperations.takeResponseBodyForInterceptionAsStream]
 */
@kotlinx.serialization.Serializable
data class TakeResponseBodyForInterceptionAsStreamResponse(
    /**  
     *  
     */  
    val stream: pl.wendigo.chrome.api.io.StreamHandle

)

/**
 * Represents request frame that can be used with [Network#replayXHR](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-replayXHR) operation call.
 *
 * This method sends a new XMLHttpRequest which is identical to the original one. The following
parameters should be identical: method, url, async, request body, extra headers, withCredentials
attribute, user, password.
 * @link [Network#replayXHR](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-replayXHR) method documentation.
 * @see [NetworkOperations.replayXHR]
 */
@kotlinx.serialization.Serializable
data class ReplayXHRRequest(
    /**
     * Identifier of XHR to replay.
     */
    val requestId: RequestId

)

/**
 * Represents request frame that can be used with [Network#searchInResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-searchInResponseBody) operation call.
 *
 * Searches for given string in response content.
 * @link [Network#searchInResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-searchInResponseBody) method documentation.
 * @see [NetworkOperations.searchInResponseBody]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [Network#searchInResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-searchInResponseBody) operation call.
 * Searches for given string in response content.
 *
  
 * @link [Network#searchInResponseBody](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-searchInResponseBody) method documentation.
 * @see [NetworkOperations.searchInResponseBody]
 */
@kotlinx.serialization.Serializable
data class SearchInResponseBodyResponse(
    /**  
     * List of search matches.  
     */  
    val result: List<pl.wendigo.chrome.api.debugger.SearchMatch>

)

/**
 * Represents request frame that can be used with [Network#setBlockedURLs](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setBlockedURLs) operation call.
 *
 * Blocks URLs from loading.
 * @link [Network#setBlockedURLs](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setBlockedURLs) method documentation.
 * @see [NetworkOperations.setBlockedURLs]
 */
@kotlinx.serialization.Serializable
data class SetBlockedURLsRequest(
    /**
     * URL patterns to block. Wildcards ('*') are allowed.
     */
    val urls: List<String>

)

/**
 * Represents request frame that can be used with [Network#setBypassServiceWorker](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setBypassServiceWorker) operation call.
 *
 * Toggles ignoring of service worker for each request.
 * @link [Network#setBypassServiceWorker](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setBypassServiceWorker) method documentation.
 * @see [NetworkOperations.setBypassServiceWorker]
 */
@kotlinx.serialization.Serializable
data class SetBypassServiceWorkerRequest(
    /**
     * Bypass service worker and load from network.
     */
    val bypass: Boolean

)

/**
 * Represents request frame that can be used with [Network#setCacheDisabled](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCacheDisabled) operation call.
 *
 * Toggles ignoring cache for each request. If `true`, cache will not be used.
 * @link [Network#setCacheDisabled](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCacheDisabled) method documentation.
 * @see [NetworkOperations.setCacheDisabled]
 */
@kotlinx.serialization.Serializable
data class SetCacheDisabledRequest(
    /**
     * Cache disabled state.
     */
    val cacheDisabled: Boolean

)

/**
 * Represents request frame that can be used with [Network#setCookie](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookie) operation call.
 *
 * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
 * @link [Network#setCookie](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookie) method documentation.
 * @see [NetworkOperations.setCookie]
 */
@kotlinx.serialization.Serializable
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
default domain, path, source port, and source scheme values of the created cookie.
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
    val expires: TimeSinceEpoch? = null,

    /**
     * Cookie Priority type.
     */
    @pl.wendigo.chrome.protocol.Experimental val priority: CookiePriority? = null,

    /**
     * True if cookie is SameParty.
     */
    @pl.wendigo.chrome.protocol.Experimental val sameParty: Boolean? = null,

    /**
     * Cookie source scheme type.
     */
    @pl.wendigo.chrome.protocol.Experimental val sourceScheme: CookieSourceScheme? = null,

    /**
     * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port.
An unspecified port value allows protocol clients to emulate legacy cookie scope for the port.
This is a temporary ability and it will be removed in the future.
     */
    @pl.wendigo.chrome.protocol.Experimental val sourcePort: Int? = null

)

/**
 * Represents response frame that is returned from [Network#setCookie](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookie) operation call.
 * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
 *
  
 * @link [Network#setCookie](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookie) method documentation.
 * @see [NetworkOperations.setCookie]
 */
@kotlinx.serialization.Serializable
data class SetCookieResponse(
    /**  
     * Always set to true. If an error occurs, the response indicates protocol error.  
     */  
    val success: Boolean

)

/**
 * Represents request frame that can be used with [Network#setCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookies) operation call.
 *
 * Sets given cookies.
 * @link [Network#setCookies](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setCookies) method documentation.
 * @see [NetworkOperations.setCookies]
 */
@kotlinx.serialization.Serializable
data class SetCookiesRequest(
    /**
     * Cookies to be set.
     */
    val cookies: List<CookieParam>

)

/**
 * Represents request frame that can be used with [Network#setDataSizeLimitsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setDataSizeLimitsForTest) operation call.
 *
 * For testing.
 * @link [Network#setDataSizeLimitsForTest](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setDataSizeLimitsForTest) method documentation.
 * @see [NetworkOperations.setDataSizeLimitsForTest]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [Network#setExtraHTTPHeaders](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setExtraHTTPHeaders) operation call.
 *
 * Specifies whether to always send extra HTTP headers with the requests from this page.
 * @link [Network#setExtraHTTPHeaders](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setExtraHTTPHeaders) method documentation.
 * @see [NetworkOperations.setExtraHTTPHeaders]
 */
@kotlinx.serialization.Serializable
data class SetExtraHTTPHeadersRequest(
    /**
     * Map with extra HTTP headers.
     */
    val headers: Headers

)

/**
 * Represents request frame that can be used with [Network#setAttachDebugStack](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setAttachDebugStack) operation call.
 *
 * Specifies whether to attach a page script stack id in requests
 * @link [Network#setAttachDebugStack](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setAttachDebugStack) method documentation.
 * @see [NetworkOperations.setAttachDebugStack]
 */
@kotlinx.serialization.Serializable
data class SetAttachDebugStackRequest(
    /**
     * Whether to attach a page script stack for debugging purpose.
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Network#setRequestInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setRequestInterception) operation call.
 *
 * Sets the requests to intercept that match the provided patterns and optionally resource types.
Deprecated, please use Fetch.enable instead.
 * @link [Network#setRequestInterception](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setRequestInterception) method documentation.
 * @see [NetworkOperations.setRequestInterception]
 */
@kotlinx.serialization.Serializable
data class SetRequestInterceptionRequest(
    /**
     * Requests matching any of these patterns will be forwarded and wait for the corresponding
continueInterceptedRequest call.
     */
    val patterns: List<RequestPattern>

)

/**
 * Represents request frame that can be used with [Network#setUserAgentOverride](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setUserAgentOverride) operation call.
 *
 * Allows overriding user agent with the given string.
 * @link [Network#setUserAgentOverride](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-setUserAgentOverride) method documentation.
 * @see [NetworkOperations.setUserAgentOverride]
 */
@kotlinx.serialization.Serializable
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
    val platform: String? = null,

    /**
     * To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData
     */
    @pl.wendigo.chrome.protocol.Experimental val userAgentMetadata: pl.wendigo.chrome.api.emulation.UserAgentMetadata? = null

)

/**
 * Represents request frame that can be used with [Network#getSecurityIsolationStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getSecurityIsolationStatus) operation call.
 *
 * Returns information about the COEP/COOP isolation status.
 * @link [Network#getSecurityIsolationStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getSecurityIsolationStatus) method documentation.
 * @see [NetworkOperations.getSecurityIsolationStatus]
 */
@kotlinx.serialization.Serializable
data class GetSecurityIsolationStatusRequest(
    /**
     * If no frameId is provided, the status of the target is provided.
     */
    val frameId: pl.wendigo.chrome.api.page.FrameId? = null

)

/**
 * Represents response frame that is returned from [Network#getSecurityIsolationStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getSecurityIsolationStatus) operation call.
 * Returns information about the COEP/COOP isolation status.
 *
  
 * @link [Network#getSecurityIsolationStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-getSecurityIsolationStatus) method documentation.
 * @see [NetworkOperations.getSecurityIsolationStatus]
 */
@kotlinx.serialization.Serializable
data class GetSecurityIsolationStatusResponse(
    /**  
     *  
     */  
    val status: SecurityIsolationStatus

)

/**
 * Represents request frame that can be used with [Network#loadNetworkResource](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-loadNetworkResource) operation call.
 *
 * Fetches the resource and returns the content.
 * @link [Network#loadNetworkResource](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-loadNetworkResource) method documentation.
 * @see [NetworkOperations.loadNetworkResource]
 */
@kotlinx.serialization.Serializable
data class LoadNetworkResourceRequest(
    /**
     * Frame id to get the resource for.
     */
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**
     * URL of the resource to get content for.
     */
    val url: String,

    /**
     * Options for the request.
     */
    val options: LoadNetworkResourceOptions

)

/**
 * Represents response frame that is returned from [Network#loadNetworkResource](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-loadNetworkResource) operation call.
 * Fetches the resource and returns the content.
 *
  
 * @link [Network#loadNetworkResource](https://chromedevtools.github.io/devtools-protocol/tot/Network#method-loadNetworkResource) method documentation.
 * @see [NetworkOperations.loadNetworkResource]
 */
@kotlinx.serialization.Serializable
data class LoadNetworkResourceResponse(
    /**  
     *  
     */  
    val resource: LoadNetworkResourcePageResult

)

/**
 * Fired when data chunk was received over the network.
 *
 * @link [Network#dataReceived](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-dataReceived) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "dataReceived"
} 

/**
 * Fired when EventSource message is received.
 *
 * @link [Network#eventSourceMessageReceived](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-eventSourceMessageReceived) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "eventSourceMessageReceived"
} 

/**
 * Fired when HTTP request has failed to load.
 *
 * @link [Network#loadingFailed](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-loadingFailed) event documentation.
 */
@kotlinx.serialization.Serializable
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
    val blockedReason: BlockedReason? = null,

    /**  
     * The reason why loading was blocked by CORS, if any.  
     */  
    val corsErrorStatus: CorsErrorStatus? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "loadingFailed"
} 

/**
 * Fired when HTTP request has finished loading.
 *
 * @link [Network#loadingFinished](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-loadingFinished) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "loadingFinished"
} 

/**
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
mocked.
Deprecated, use Fetch.requestPaused instead.
 *
 * @link [Network#requestIntercepted](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-requestIntercepted) event documentation.
 */
@kotlinx.serialization.Serializable
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
    val frameId: pl.wendigo.chrome.api.page.FrameId,

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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "requestIntercepted"
} 

/**
 * Fired if request ended up loading from cache.
 *
 * @link [Network#requestServedFromCache](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-requestServedFromCache) event documentation.
 */
@kotlinx.serialization.Serializable
data class RequestServedFromCacheEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "requestServedFromCache"
} 

/**
 * Fired when page is about to send HTTP request.
 *
 * @link [Network#requestWillBeSent](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-requestWillBeSent) event documentation.
 */
@kotlinx.serialization.Serializable
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
    val frameId: pl.wendigo.chrome.api.page.FrameId? = null,

    /**  
     * Whether the request is initiated by a user gesture. Defaults to false.  
     */  
    val hasUserGesture: Boolean? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "requestWillBeSent"
} 

/**
 * Fired when resource loading priority is changed
 *
 * @link [Network#resourceChangedPriority](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-resourceChangedPriority) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "resourceChangedPriority"
} 

/**
 * Fired when a signed exchange was received over the network
 *
 * @link [Network#signedExchangeReceived](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-signedExchangeReceived) event documentation.
 */
@kotlinx.serialization.Serializable
data class SignedExchangeReceivedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Information about the signed exchange response.  
     */  
    val info: SignedExchangeInfo

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "signedExchangeReceived"
} 

/**
 * Fired when HTTP response is available.
 *
 * @link [Network#responseReceived](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-responseReceived) event documentation.
 */
@kotlinx.serialization.Serializable
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
    val frameId: pl.wendigo.chrome.api.page.FrameId? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "responseReceived"
} 

/**
 * Fired when WebSocket is closed.
 *
 * @link [Network#webSocketClosed](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketClosed) event documentation.
 */
@kotlinx.serialization.Serializable
data class WebSocketClosedEvent(
    /**  
     * Request identifier.  
     */  
    val requestId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketClosed"
} 

/**
 * Fired upon WebSocket creation.
 *
 * @link [Network#webSocketCreated](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketCreated) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketCreated"
} 

/**
 * Fired when WebSocket message error occurs.
 *
 * @link [Network#webSocketFrameError](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketFrameError) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketFrameError"
} 

/**
 * Fired when WebSocket message is received.
 *
 * @link [Network#webSocketFrameReceived](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketFrameReceived) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketFrameReceived"
} 

/**
 * Fired when WebSocket message is sent.
 *
 * @link [Network#webSocketFrameSent](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketFrameSent) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketFrameSent"
} 

/**
 * Fired when WebSocket handshake response becomes available.
 *
 * @link [Network#webSocketHandshakeResponseReceived](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketHandshakeResponseReceived) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketHandshakeResponseReceived"
} 

/**
 * Fired when WebSocket is about to initiate handshake.
 *
 * @link [Network#webSocketWillSendHandshakeRequest](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webSocketWillSendHandshakeRequest) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webSocketWillSendHandshakeRequest"
} 

/**
 * Fired upon WebTransport creation.
 *
 * @link [Network#webTransportCreated](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webTransportCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class WebTransportCreatedEvent(
    /**  
     * WebTransport identifier.  
     */  
    val transportId: RequestId,

    /**  
     * WebTransport request URL.  
     */  
    val url: String,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime,

    /**  
     * Request initiator.  
     */  
    val initiator: Initiator? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webTransportCreated"
} 

/**
 * Fired when WebTransport handshake is finished.
 *
 * @link [Network#webTransportConnectionEstablished](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webTransportConnectionEstablished) event documentation.
 */
@kotlinx.serialization.Serializable
data class WebTransportConnectionEstablishedEvent(
    /**  
     * WebTransport identifier.  
     */  
    val transportId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webTransportConnectionEstablished"
} 

/**
 * Fired when WebTransport is disposed.
 *
 * @link [Network#webTransportClosed](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-webTransportClosed) event documentation.
 */
@kotlinx.serialization.Serializable
data class WebTransportClosedEvent(
    /**  
     * WebTransport identifier.  
     */  
    val transportId: RequestId,

    /**  
     * Timestamp.  
     */  
    val timestamp: MonotonicTime

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "webTransportClosed"
} 

/**
 * Fired when additional information about a requestWillBeSent event is available from the
network stack. Not every requestWillBeSent event will have an additional
requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
or requestWillBeSentExtraInfo will be fired first for the same request.
 *
 * @link [Network#requestWillBeSentExtraInfo](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-requestWillBeSentExtraInfo) event documentation.
 */
@kotlinx.serialization.Serializable
data class RequestWillBeSentExtraInfoEvent(
    /**  
     * Request identifier. Used to match this information to an existing requestWillBeSent event.  
     */  
    val requestId: RequestId,

    /**  
     * A list of cookies potentially associated to the requested URL. This includes both cookies sent with  
     the request and the ones not sent; the latter are distinguished by having blockedReason field set.  
     */  
    val associatedCookies: List<BlockedCookieWithReason>,

    /**  
     * Raw request headers as they will be sent over the wire.  
     */  
    val headers: Headers,

    /**  
     * The client security state set for the request.  
     */  
    val clientSecurityState: ClientSecurityState? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "requestWillBeSentExtraInfo"
} 

/**
 * Fired when additional information about a responseReceived event is available from the network
stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
it, and responseReceivedExtraInfo may be fired before or after responseReceived.
 *
 * @link [Network#responseReceivedExtraInfo](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-responseReceivedExtraInfo) event documentation.
 */
@kotlinx.serialization.Serializable
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
     * The IP address space of the resource. The address space can only be determined once the transport  
     established the connection, so we can't send it in `requestWillBeSentExtraInfo`.  
     */  
    val resourceIPAddressSpace: IPAddressSpace,

    /**  
     * Raw response header text as it was received over the wire. The raw text may not always be  
     available, such as in the case of HTTP/2 or QUIC.  
     */  
    val headersText: String? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "responseReceivedExtraInfo"
} 

/**
 * Fired exactly once for each Trust Token operation. Depending on
the type of the operation and whether the operation succeeded or
failed, the event is fired before the corresponding request was sent
or after the response was received.
 *
 * @link [Network#trustTokenOperationDone](https://chromedevtools.github.io/devtools-protocol/tot/Network#event-trustTokenOperationDone) event documentation.
 */
@kotlinx.serialization.Serializable
data class TrustTokenOperationDoneEvent(
    /**  
     * Detailed success or error status of the operation.  
     'AlreadyExists' also signifies a successful operation, as the result  
     of the operation already exists und thus, the operation was abort  
     preemptively (e.g. a cache hit).  
     */  
    val status: String,

    /**  
     *  
     */  
    val type: TrustTokenOperationType,

    /**  
     *  
     */  
    val requestId: RequestId,

    /**  
     * Top level origin. The context in which the operation was attempted.  
     */  
    val topLevelOrigin: String? = null,

    /**  
     * Origin of the issuer in case of a "Issuance" or "Redemption" operation.  
     */  
    val issuerOrigin: String? = null,

    /**  
     * The number of obtained Trust Tokens on a successful "Issuance" operation.  
     */  
    val issuedTokenCount: Int? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Network" 
    override fun eventName() = "trustTokenOperationDone"
} 
