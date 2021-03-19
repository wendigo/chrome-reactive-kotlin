package pl.wendigo.chrome.api.network

/**
 * Resource type as it was perceived by the rendering engine.
 *
 * @link [Network#ResourceType](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ResourceType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ResourceType {
    @kotlinx.serialization.SerialName("Document")
    DOCUMENT,

    @kotlinx.serialization.SerialName("Stylesheet")
    STYLESHEET,

    @kotlinx.serialization.SerialName("Image")
    IMAGE,

    @kotlinx.serialization.SerialName("Media")
    MEDIA,

    @kotlinx.serialization.SerialName("Font")
    FONT,

    @kotlinx.serialization.SerialName("Script")
    SCRIPT,

    @kotlinx.serialization.SerialName("TextTrack")
    TEXTTRACK,

    @kotlinx.serialization.SerialName("XHR")
    XHR,

    @kotlinx.serialization.SerialName("Fetch")
    FETCH,

    @kotlinx.serialization.SerialName("EventSource")
    EVENTSOURCE,

    @kotlinx.serialization.SerialName("WebSocket")
    WEBSOCKET,

    @kotlinx.serialization.SerialName("Manifest")
    MANIFEST,

    @kotlinx.serialization.SerialName("SignedExchange")
    SIGNEDEXCHANGE,

    @kotlinx.serialization.SerialName("Ping")
    PING,

    @kotlinx.serialization.SerialName("CSPViolationReport")
    CSPVIOLATIONREPORT,

    @kotlinx.serialization.SerialName("Preflight")
    PREFLIGHT,

    @kotlinx.serialization.SerialName("Other")
    OTHER;
}

/**
 * Unique loader identifier.
 *
 * @link [Network#LoaderId](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-LoaderId) type documentation.
 */

typealias LoaderId = String

/**
 * Unique request identifier.
 *
 * @link [Network#RequestId](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-RequestId) type documentation.
 */

typealias RequestId = String

/**
 * Unique intercepted request identifier.
 *
 * @link [Network#InterceptionId](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-InterceptionId) type documentation.
 */

typealias InterceptionId = String

/**
 * Network level fetch failure reason.
 *
 * @link [Network#ErrorReason](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ErrorReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ErrorReason {
    @kotlinx.serialization.SerialName("Failed")
    FAILED,

    @kotlinx.serialization.SerialName("Aborted")
    ABORTED,

    @kotlinx.serialization.SerialName("TimedOut")
    TIMEDOUT,

    @kotlinx.serialization.SerialName("AccessDenied")
    ACCESSDENIED,

    @kotlinx.serialization.SerialName("ConnectionClosed")
    CONNECTIONCLOSED,

    @kotlinx.serialization.SerialName("ConnectionReset")
    CONNECTIONRESET,

    @kotlinx.serialization.SerialName("ConnectionRefused")
    CONNECTIONREFUSED,

    @kotlinx.serialization.SerialName("ConnectionAborted")
    CONNECTIONABORTED,

    @kotlinx.serialization.SerialName("ConnectionFailed")
    CONNECTIONFAILED,

    @kotlinx.serialization.SerialName("NameNotResolved")
    NAMENOTRESOLVED,

    @kotlinx.serialization.SerialName("InternetDisconnected")
    INTERNETDISCONNECTED,

    @kotlinx.serialization.SerialName("AddressUnreachable")
    ADDRESSUNREACHABLE,

    @kotlinx.serialization.SerialName("BlockedByClient")
    BLOCKEDBYCLIENT,

    @kotlinx.serialization.SerialName("BlockedByResponse")
    BLOCKEDBYRESPONSE;
}

/**
 * UTC time in seconds, counted from January 1, 1970.
 *
 * @link [Network#TimeSinceEpoch](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-TimeSinceEpoch) type documentation.
 */

typealias TimeSinceEpoch = Double

/**
 * Monotonically increasing time in seconds since an arbitrary point in the past.
 *
 * @link [Network#MonotonicTime](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-MonotonicTime) type documentation.
 */

typealias MonotonicTime = Double

/**
 * Request / response headers as keys / values of JSON object.
 *
 * @link [Network#Headers](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-Headers) type documentation.
 */

typealias Headers = Map<String, kotlinx.serialization.json.JsonElement>

/**
 * The underlying connection technology that the browser is supposedly using.
 *
 * @link [Network#ConnectionType](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ConnectionType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ConnectionType {
    @kotlinx.serialization.SerialName("none")
    NONE,

    @kotlinx.serialization.SerialName("cellular2g")
    CELLULAR2G,

    @kotlinx.serialization.SerialName("cellular3g")
    CELLULAR3G,

    @kotlinx.serialization.SerialName("cellular4g")
    CELLULAR4G,

    @kotlinx.serialization.SerialName("bluetooth")
    BLUETOOTH,

    @kotlinx.serialization.SerialName("ethernet")
    ETHERNET,

    @kotlinx.serialization.SerialName("wifi")
    WIFI,

    @kotlinx.serialization.SerialName("wimax")
    WIMAX,

    @kotlinx.serialization.SerialName("other")
    OTHER;
}

/**
 * Represents the cookie&apos;s &apos;SameSite&apos; status:
https://tools.ietf.org/html/draft-west-first-party-cookies
 *
 * @link [Network#CookieSameSite](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CookieSameSite) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CookieSameSite {
    @kotlinx.serialization.SerialName("Strict")
    STRICT,

    @kotlinx.serialization.SerialName("Lax")
    LAX,

    @kotlinx.serialization.SerialName("None")
    NONE;
}

/**
 * Represents the cookie&apos;s &apos;Priority&apos; status:
https://tools.ietf.org/html/draft-west-cookie-priority-00
 *
 * @link [Network#CookiePriority](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CookiePriority) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CookiePriority {
    @kotlinx.serialization.SerialName("Low")
    LOW,

    @kotlinx.serialization.SerialName("Medium")
    MEDIUM,

    @kotlinx.serialization.SerialName("High")
    HIGH;
}

/**
 * Represents the source scheme of the origin that originally set the cookie.
A value of &quot;Unset&quot; allows protocol clients to emulate legacy cookie scope for the scheme.
This is a temporary ability and it will be removed in the future.
 *
 * @link [Network#CookieSourceScheme](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CookieSourceScheme) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CookieSourceScheme {
    @kotlinx.serialization.SerialName("Unset")
    UNSET,

    @kotlinx.serialization.SerialName("NonSecure")
    NONSECURE,

    @kotlinx.serialization.SerialName("Secure")
    SECURE;
}

/**
 * Timing information for the request.
 *
 * @link [Network#ResourceTiming](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ResourceTiming) type documentation.
 */

@kotlinx.serialization.Serializable
data class ResourceTiming(
    /**  
     * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in  
     milliseconds relatively to this requestTime.  
     */  
    val requestTime: Double,

    /**  
     * Started resolving proxy.  
     */  
    val proxyStart: Double,

    /**  
     * Finished resolving proxy.  
     */  
    val proxyEnd: Double,

    /**  
     * Started DNS address resolve.  
     */  
    val dnsStart: Double,

    /**  
     * Finished DNS address resolve.  
     */  
    val dnsEnd: Double,

    /**  
     * Started connecting to the remote host.  
     */  
    val connectStart: Double,

    /**  
     * Connected to the remote host.  
     */  
    val connectEnd: Double,

    /**  
     * Started SSL handshake.  
     */  
    val sslStart: Double,

    /**  
     * Finished SSL handshake.  
     */  
    val sslEnd: Double,

    /**  
     * Started running ServiceWorker.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val workerStart: Double,

    /**  
     * Finished Starting ServiceWorker.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val workerReady: Double,

    /**  
     * Started fetch event.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val workerFetchStart: Double,

    /**  
     * Settled fetch event respondWith promise.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val workerRespondWithSettled: Double,

    /**  
     * Started sending request.  
     */  
    val sendStart: Double,

    /**  
     * Finished sending request.  
     */  
    val sendEnd: Double,

    /**  
     * Time the server started pushing request.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val pushStart: Double,

    /**  
     * Time the server finished pushing request.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val pushEnd: Double,

    /**  
     * Finished receiving response headers.  
     */  
    val receiveHeadersEnd: Double
)

/**
 * Loading priority of a resource request.
 *
 * @link [Network#ResourcePriority](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ResourcePriority) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ResourcePriority {
    @kotlinx.serialization.SerialName("VeryLow")
    VERYLOW,

    @kotlinx.serialization.SerialName("Low")
    LOW,

    @kotlinx.serialization.SerialName("Medium")
    MEDIUM,

    @kotlinx.serialization.SerialName("High")
    HIGH,

    @kotlinx.serialization.SerialName("VeryHigh")
    VERYHIGH;
}

/**
 * Post data entry for HTTP request
 *
 * @link [Network#PostDataEntry](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-PostDataEntry) type documentation.
 */

@kotlinx.serialization.Serializable
data class PostDataEntry(
    /**  
     *  
     */  
    val bytes: String? = null
)

/**
 * HTTP request data.
 *
 * @link [Network#Request](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-Request) type documentation.
 */

@kotlinx.serialization.Serializable
data class Request(
    /**  
     * Request URL (without fragment).  
     */  
    val url: String,

    /**  
     * Fragment of the requested URL starting with hash, if present.  
     */  
    val urlFragment: String? = null,

    /**  
     * HTTP request method.  
     */  
    val method: String,

    /**  
     * HTTP request headers.  
     */  
    val headers: Headers,

    /**  
     * HTTP POST request data.  
     */  
    val postData: String? = null,

    /**  
     * True when the request has POST data. Note that postData might still be omitted when this flag is true when the data is too long.  
     */  
    val hasPostData: Boolean? = null,

    /**  
     * Request body elements. This will be converted from base64 to binary  
     */  
    @pl.wendigo.chrome.protocol.Experimental val postDataEntries: List<PostDataEntry>? = null,

    /**  
     * The mixed content type of the request.  
     */  
    val mixedContentType: pl.wendigo.chrome.api.security.MixedContentType? = null,

    /**  
     * Priority of the resource request at the time request is sent.  
     */  
    val initialPriority: ResourcePriority,

    /**  
     * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/  
     */  
    val referrerPolicy: String,

    /**  
     * Whether is loaded via link preload.  
     */  
    val isLinkPreload: Boolean? = null,

    /**  
     * Set for requests when the TrustToken API is used. Contains the parameters  
     passed by the developer (e.g. via "fetch") as understood by the backend.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val trustTokenParams: TrustTokenParams? = null
)

/**
 * Details of a signed certificate timestamp (SCT).
 *
 * @link [Network#SignedCertificateTimestamp](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SignedCertificateTimestamp) type documentation.
 */

@kotlinx.serialization.Serializable
data class SignedCertificateTimestamp(
    /**  
     * Validation status.  
     */  
    val status: String,

    /**  
     * Origin.  
     */  
    val origin: String,

    /**  
     * Log name / description.  
     */  
    val logDescription: String,

    /**  
     * Log ID.  
     */  
    val logId: String,

    /**  
     * Issuance date.  
     */  
    val timestamp: TimeSinceEpoch,

    /**  
     * Hash algorithm.  
     */  
    val hashAlgorithm: String,

    /**  
     * Signature algorithm.  
     */  
    val signatureAlgorithm: String,

    /**  
     * Signature data.  
     */  
    val signatureData: String
)

/**
 * Security details about a request.
 *
 * @link [Network#SecurityDetails](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SecurityDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class SecurityDetails(
    /**  
     * Protocol name (e.g. "TLS 1.2" or "QUIC").  
     */  
    val protocol: String,

    /**  
     * Key Exchange used by the connection, or the empty string if not applicable.  
     */  
    val keyExchange: String,

    /**  
     * (EC)DH group used by the connection, if applicable.  
     */  
    val keyExchangeGroup: String? = null,

    /**  
     * Cipher name.  
     */  
    val cipher: String,

    /**  
     * TLS MAC. Note that AEAD ciphers do not have separate MACs.  
     */  
    val mac: String? = null,

    /**  
     * Certificate ID value.  
     */  
    val certificateId: pl.wendigo.chrome.api.security.CertificateId,

    /**  
     * Certificate subject name.  
     */  
    val subjectName: String,

    /**  
     * Subject Alternative Name (SAN) DNS names and IP addresses.  
     */  
    val sanList: List<String>,

    /**  
     * Name of the issuing CA.  
     */  
    val issuer: String,

    /**  
     * Certificate valid from date.  
     */  
    val validFrom: TimeSinceEpoch,

    /**  
     * Certificate valid to (expiration) date  
     */  
    val validTo: TimeSinceEpoch,

    /**  
     * List of signed certificate timestamps (SCTs).  
     */  
    val signedCertificateTimestampList: List<SignedCertificateTimestamp>,

    /**  
     * Whether the request complied with Certificate Transparency policy  
     */  
    val certificateTransparencyCompliance: CertificateTransparencyCompliance
)

/**
 * Whether the request complied with Certificate Transparency policy.
 *
 * @link [Network#CertificateTransparencyCompliance](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CertificateTransparencyCompliance) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CertificateTransparencyCompliance {
    @kotlinx.serialization.SerialName("unknown")
    UNKNOWN,

    @kotlinx.serialization.SerialName("not-compliant")
    NOT_COMPLIANT,

    @kotlinx.serialization.SerialName("compliant")
    COMPLIANT;
}

/**
 * The reason why request was blocked.
 *
 * @link [Network#BlockedReason](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-BlockedReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class BlockedReason {
    @kotlinx.serialization.SerialName("other")
    OTHER,

    @kotlinx.serialization.SerialName("csp")
    CSP,

    @kotlinx.serialization.SerialName("mixed-content")
    MIXED_CONTENT,

    @kotlinx.serialization.SerialName("origin")
    ORIGIN,

    @kotlinx.serialization.SerialName("inspector")
    INSPECTOR,

    @kotlinx.serialization.SerialName("subresource-filter")
    SUBRESOURCE_FILTER,

    @kotlinx.serialization.SerialName("content-type")
    CONTENT_TYPE,

    @kotlinx.serialization.SerialName("collapsed-by-client")
    COLLAPSED_BY_CLIENT,

    @kotlinx.serialization.SerialName("coep-frame-resource-needs-coep-header")
    COEP_FRAME_RESOURCE_NEEDS_COEP_HEADER,

    @kotlinx.serialization.SerialName("coop-sandboxed-iframe-cannot-navigate-to-coop-page")
    COOP_SANDBOXED_IFRAME_CANNOT_NAVIGATE_TO_COOP_PAGE,

    @kotlinx.serialization.SerialName("corp-not-same-origin")
    CORP_NOT_SAME_ORIGIN,

    @kotlinx.serialization.SerialName("corp-not-same-origin-after-defaulted-to-same-origin-by-coep")
    CORP_NOT_SAME_ORIGIN_AFTER_DEFAULTED_TO_SAME_ORIGIN_BY_COEP,

    @kotlinx.serialization.SerialName("corp-not-same-site")
    CORP_NOT_SAME_SITE;
}

/**
 * The reason why request was blocked.
 *
 * @link [Network#CorsError](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CorsError) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CorsError {
    @kotlinx.serialization.SerialName("DisallowedByMode")
    DISALLOWEDBYMODE,

    @kotlinx.serialization.SerialName("InvalidResponse")
    INVALIDRESPONSE,

    @kotlinx.serialization.SerialName("WildcardOriginNotAllowed")
    WILDCARDORIGINNOTALLOWED,

    @kotlinx.serialization.SerialName("MissingAllowOriginHeader")
    MISSINGALLOWORIGINHEADER,

    @kotlinx.serialization.SerialName("MultipleAllowOriginValues")
    MULTIPLEALLOWORIGINVALUES,

    @kotlinx.serialization.SerialName("InvalidAllowOriginValue")
    INVALIDALLOWORIGINVALUE,

    @kotlinx.serialization.SerialName("AllowOriginMismatch")
    ALLOWORIGINMISMATCH,

    @kotlinx.serialization.SerialName("InvalidAllowCredentials")
    INVALIDALLOWCREDENTIALS,

    @kotlinx.serialization.SerialName("CorsDisabledScheme")
    CORSDISABLEDSCHEME,

    @kotlinx.serialization.SerialName("PreflightInvalidStatus")
    PREFLIGHTINVALIDSTATUS,

    @kotlinx.serialization.SerialName("PreflightDisallowedRedirect")
    PREFLIGHTDISALLOWEDREDIRECT,

    @kotlinx.serialization.SerialName("PreflightWildcardOriginNotAllowed")
    PREFLIGHTWILDCARDORIGINNOTALLOWED,

    @kotlinx.serialization.SerialName("PreflightMissingAllowOriginHeader")
    PREFLIGHTMISSINGALLOWORIGINHEADER,

    @kotlinx.serialization.SerialName("PreflightMultipleAllowOriginValues")
    PREFLIGHTMULTIPLEALLOWORIGINVALUES,

    @kotlinx.serialization.SerialName("PreflightInvalidAllowOriginValue")
    PREFLIGHTINVALIDALLOWORIGINVALUE,

    @kotlinx.serialization.SerialName("PreflightAllowOriginMismatch")
    PREFLIGHTALLOWORIGINMISMATCH,

    @kotlinx.serialization.SerialName("PreflightInvalidAllowCredentials")
    PREFLIGHTINVALIDALLOWCREDENTIALS,

    @kotlinx.serialization.SerialName("PreflightMissingAllowExternal")
    PREFLIGHTMISSINGALLOWEXTERNAL,

    @kotlinx.serialization.SerialName("PreflightInvalidAllowExternal")
    PREFLIGHTINVALIDALLOWEXTERNAL,

    @kotlinx.serialization.SerialName("InvalidAllowMethodsPreflightResponse")
    INVALIDALLOWMETHODSPREFLIGHTRESPONSE,

    @kotlinx.serialization.SerialName("InvalidAllowHeadersPreflightResponse")
    INVALIDALLOWHEADERSPREFLIGHTRESPONSE,

    @kotlinx.serialization.SerialName("MethodDisallowedByPreflightResponse")
    METHODDISALLOWEDBYPREFLIGHTRESPONSE,

    @kotlinx.serialization.SerialName("HeaderDisallowedByPreflightResponse")
    HEADERDISALLOWEDBYPREFLIGHTRESPONSE,

    @kotlinx.serialization.SerialName("RedirectContainsCredentials")
    REDIRECTCONTAINSCREDENTIALS,

    @kotlinx.serialization.SerialName("InsecurePrivateNetwork")
    INSECUREPRIVATENETWORK;
}

/**
 *
 *
 * @link [Network#CorsErrorStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CorsErrorStatus) type documentation.
 */

@kotlinx.serialization.Serializable
data class CorsErrorStatus(
    /**  
     *  
     */  
    val corsError: CorsError,

    /**  
     *  
     */  
    val failedParameter: String
)

/**
 * Source of serviceworker response.
 *
 * @link [Network#ServiceWorkerResponseSource](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ServiceWorkerResponseSource) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ServiceWorkerResponseSource {
    @kotlinx.serialization.SerialName("cache-storage")
    CACHE_STORAGE,

    @kotlinx.serialization.SerialName("http-cache")
    HTTP_CACHE,

    @kotlinx.serialization.SerialName("fallback-code")
    FALLBACK_CODE,

    @kotlinx.serialization.SerialName("network")
    NETWORK;
}

/**
 * Determines what type of Trust Token operation is executed and
depending on the type, some additional parameters. The values
are specified in third_party/blink/renderer/core/fetch/trust_token.idl.
 *
 * @link [Network#TrustTokenParams](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-TrustTokenParams) type documentation.
 */

@kotlinx.serialization.Serializable
data class TrustTokenParams(
    /**  
     *  
     */  
    val type: TrustTokenOperationType,

    /**  
     * Only set for "token-redemption" type and determine whether  
     to request a fresh SRR or use a still valid cached SRR.  
     */  
    val refreshPolicy: String,

    /**  
     * Origins of issuers from whom to request tokens or redemption  
     records.  
     */  
    val issuers: List<String>? = null
)

/**
 *
 *
 * @link [Network#TrustTokenOperationType](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-TrustTokenOperationType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class TrustTokenOperationType {
    @kotlinx.serialization.SerialName("Issuance")
    ISSUANCE,

    @kotlinx.serialization.SerialName("Redemption")
    REDEMPTION,

    @kotlinx.serialization.SerialName("Signing")
    SIGNING;
}

/**
 * HTTP response data.
 *
 * @link [Network#Response](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-Response) type documentation.
 */

@kotlinx.serialization.Serializable
data class Response(
    /**  
     * Response URL. This URL can be different from CachedResource.url in case of redirect.  
     */  
    val url: String,

    /**  
     * HTTP response status code.  
     */  
    val status: Int,

    /**  
     * HTTP response status text.  
     */  
    val statusText: String,

    /**  
     * HTTP response headers.  
     */  
    val headers: Headers,

    /**  
     * HTTP response headers text.  
     */  
    val headersText: String? = null,

    /**  
     * Resource mimeType as determined by the browser.  
     */  
    val mimeType: String,

    /**  
     * Refined HTTP request headers that were actually transmitted over the network.  
     */  
    val requestHeaders: Headers? = null,

    /**  
     * HTTP request headers text.  
     */  
    val requestHeadersText: String? = null,

    /**  
     * Specifies whether physical connection was actually reused for this request.  
     */  
    val connectionReused: Boolean,

    /**  
     * Physical connection id that was actually used for this request.  
     */  
    val connectionId: Double,

    /**  
     * Remote IP address.  
     */  
    val remoteIPAddress: String? = null,

    /**  
     * Remote port.  
     */  
    val remotePort: Int? = null,

    /**  
     * Specifies that the request was served from the disk cache.  
     */  
    val fromDiskCache: Boolean? = null,

    /**  
     * Specifies that the request was served from the ServiceWorker.  
     */  
    val fromServiceWorker: Boolean? = null,

    /**  
     * Specifies that the request was served from the prefetch cache.  
     */  
    val fromPrefetchCache: Boolean? = null,

    /**  
     * Total number of bytes received for this request so far.  
     */  
    val encodedDataLength: Double,

    /**  
     * Timing information for the given request.  
     */  
    val timing: ResourceTiming? = null,

    /**  
     * Response source of response from ServiceWorker.  
     */  
    val serviceWorkerResponseSource: ServiceWorkerResponseSource? = null,

    /**  
     * The time at which the returned response was generated.  
     */  
    val responseTime: TimeSinceEpoch? = null,

    /**  
     * Cache Storage Cache Name.  
     */  
    val cacheStorageCacheName: String? = null,

    /**  
     * Protocol used to fetch this request.  
     */  
    val protocol: String? = null,

    /**  
     * Security state of the request resource.  
     */  
    val securityState: pl.wendigo.chrome.api.security.SecurityState,

    /**  
     * Security details for the request.  
     */  
    val securityDetails: SecurityDetails? = null
)

/**
 * WebSocket request data.
 *
 * @link [Network#WebSocketRequest](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-WebSocketRequest) type documentation.
 */

@kotlinx.serialization.Serializable
data class WebSocketRequest(
    /**  
     * HTTP request headers.  
     */  
    val headers: Headers
)

/**
 * WebSocket response data.
 *
 * @link [Network#WebSocketResponse](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-WebSocketResponse) type documentation.
 */

@kotlinx.serialization.Serializable
data class WebSocketResponse(
    /**  
     * HTTP response status code.  
     */  
    val status: Int,

    /**  
     * HTTP response status text.  
     */  
    val statusText: String,

    /**  
     * HTTP response headers.  
     */  
    val headers: Headers,

    /**  
     * HTTP response headers text.  
     */  
    val headersText: String? = null,

    /**  
     * HTTP request headers.  
     */  
    val requestHeaders: Headers? = null,

    /**  
     * HTTP request headers text.  
     */  
    val requestHeadersText: String? = null
)

/**
 * WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
 *
 * @link [Network#WebSocketFrame](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-WebSocketFrame) type documentation.
 */

@kotlinx.serialization.Serializable
data class WebSocketFrame(
    /**  
     * WebSocket message opcode.  
     */  
    val opcode: Double,

    /**  
     * WebSocket message mask.  
     */  
    val mask: Boolean,

    /**  
     * WebSocket message payload data.  
     If the opcode is 1, this is a text message and payloadData is a UTF-8 string.  
     If the opcode isn't 1, then payloadData is a base64 encoded string representing binary data.  
     */  
    val payloadData: String
)

/**
 * Information about the cached resource.
 *
 * @link [Network#CachedResource](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CachedResource) type documentation.
 */

@kotlinx.serialization.Serializable
data class CachedResource(
    /**  
     * Resource URL. This is the url of the original network request.  
     */  
    val url: String,

    /**  
     * Type of this resource.  
     */  
    val type: ResourceType,

    /**  
     * Cached response data.  
     */  
    val response: Response? = null,

    /**  
     * Cached response body size.  
     */  
    val bodySize: Double
)

/**
 * Information about the request initiator.
 *
 * @link [Network#Initiator](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-Initiator) type documentation.
 */

@kotlinx.serialization.Serializable
data class Initiator(
    /**  
     * Type of this initiator.  
     */  
    val type: String,

    /**  
     * Initiator JavaScript stack trace, set for Script only.  
     */  
    val stack: pl.wendigo.chrome.api.runtime.StackTrace? = null,

    /**  
     * Initiator URL, set for Parser type or for Script type (when script is importing module) or for SignedExchange type.  
     */  
    val url: String? = null,

    /**  
     * Initiator line number, set for Parser type or for Script type (when script is importing  
     module) (0-based).  
     */  
    val lineNumber: Double? = null,

    /**  
     * Initiator column number, set for Parser type or for Script type (when script is importing  
     module) (0-based).  
     */  
    val columnNumber: Double? = null,

    /**  
     * Set if another request triggered this request (e.g. preflight).  
     */  
    val requestId: RequestId? = null
)

/**
 * Cookie object
 *
 * @link [Network#Cookie](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-Cookie) type documentation.
 */

@kotlinx.serialization.Serializable
data class Cookie(
    /**  
     * Cookie name.  
     */  
    val name: String,

    /**  
     * Cookie value.  
     */  
    val value: String,

    /**  
     * Cookie domain.  
     */  
    val domain: String,

    /**  
     * Cookie path.  
     */  
    val path: String,

    /**  
     * Cookie expiration date as the number of seconds since the UNIX epoch.  
     */  
    val expires: Double,

    /**  
     * Cookie size.  
     */  
    val size: Int,

    /**  
     * True if cookie is http-only.  
     */  
    val httpOnly: Boolean,

    /**  
     * True if cookie is secure.  
     */  
    val secure: Boolean,

    /**  
     * True in case of session cookie.  
     */  
    val session: Boolean,

    /**  
     * Cookie SameSite type.  
     */  
    val sameSite: CookieSameSite? = null,

    /**  
     * Cookie Priority  
     */  
    @pl.wendigo.chrome.protocol.Experimental val priority: CookiePriority,

    /**  
     * True if cookie is SameParty.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val sameParty: Boolean,

    /**  
     * Cookie source scheme type.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val sourceScheme: CookieSourceScheme,

    /**  
     * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port.  
     An unspecified port value allows protocol clients to emulate legacy cookie scope for the port.  
     This is a temporary ability and it will be removed in the future.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val sourcePort: Int
)

/**
 * Types of reasons why a cookie may not be stored from a response.
 *
 * @link [Network#SetCookieBlockedReason](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SetCookieBlockedReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SetCookieBlockedReason {
    @kotlinx.serialization.SerialName("SecureOnly")
    SECUREONLY,

    @kotlinx.serialization.SerialName("SameSiteStrict")
    SAMESITESTRICT,

    @kotlinx.serialization.SerialName("SameSiteLax")
    SAMESITELAX,

    @kotlinx.serialization.SerialName("SameSiteUnspecifiedTreatedAsLax")
    SAMESITEUNSPECIFIEDTREATEDASLAX,

    @kotlinx.serialization.SerialName("SameSiteNoneInsecure")
    SAMESITENONEINSECURE,

    @kotlinx.serialization.SerialName("UserPreferences")
    USERPREFERENCES,

    @kotlinx.serialization.SerialName("SyntaxError")
    SYNTAXERROR,

    @kotlinx.serialization.SerialName("SchemeNotSupported")
    SCHEMENOTSUPPORTED,

    @kotlinx.serialization.SerialName("OverwriteSecure")
    OVERWRITESECURE,

    @kotlinx.serialization.SerialName("InvalidDomain")
    INVALIDDOMAIN,

    @kotlinx.serialization.SerialName("InvalidPrefix")
    INVALIDPREFIX,

    @kotlinx.serialization.SerialName("UnknownError")
    UNKNOWNERROR,

    @kotlinx.serialization.SerialName("SchemefulSameSiteStrict")
    SCHEMEFULSAMESITESTRICT,

    @kotlinx.serialization.SerialName("SchemefulSameSiteLax")
    SCHEMEFULSAMESITELAX,

    @kotlinx.serialization.SerialName("SchemefulSameSiteUnspecifiedTreatedAsLax")
    SCHEMEFULSAMESITEUNSPECIFIEDTREATEDASLAX,

    @kotlinx.serialization.SerialName("SamePartyFromCrossPartyContext")
    SAMEPARTYFROMCROSSPARTYCONTEXT,

    @kotlinx.serialization.SerialName("SamePartyConflictsWithOtherAttributes")
    SAMEPARTYCONFLICTSWITHOTHERATTRIBUTES;
}

/**
 * Types of reasons why a cookie may not be sent with a request.
 *
 * @link [Network#CookieBlockedReason](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CookieBlockedReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CookieBlockedReason {
    @kotlinx.serialization.SerialName("SecureOnly")
    SECUREONLY,

    @kotlinx.serialization.SerialName("NotOnPath")
    NOTONPATH,

    @kotlinx.serialization.SerialName("DomainMismatch")
    DOMAINMISMATCH,

    @kotlinx.serialization.SerialName("SameSiteStrict")
    SAMESITESTRICT,

    @kotlinx.serialization.SerialName("SameSiteLax")
    SAMESITELAX,

    @kotlinx.serialization.SerialName("SameSiteUnspecifiedTreatedAsLax")
    SAMESITEUNSPECIFIEDTREATEDASLAX,

    @kotlinx.serialization.SerialName("SameSiteNoneInsecure")
    SAMESITENONEINSECURE,

    @kotlinx.serialization.SerialName("UserPreferences")
    USERPREFERENCES,

    @kotlinx.serialization.SerialName("UnknownError")
    UNKNOWNERROR,

    @kotlinx.serialization.SerialName("SchemefulSameSiteStrict")
    SCHEMEFULSAMESITESTRICT,

    @kotlinx.serialization.SerialName("SchemefulSameSiteLax")
    SCHEMEFULSAMESITELAX,

    @kotlinx.serialization.SerialName("SchemefulSameSiteUnspecifiedTreatedAsLax")
    SCHEMEFULSAMESITEUNSPECIFIEDTREATEDASLAX,

    @kotlinx.serialization.SerialName("SamePartyFromCrossPartyContext")
    SAMEPARTYFROMCROSSPARTYCONTEXT;
}

/**
 * A cookie which was not stored from a response with the corresponding reason.
 *
 * @link [Network#BlockedSetCookieWithReason](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-BlockedSetCookieWithReason) type documentation.
 */

@kotlinx.serialization.Serializable
data class BlockedSetCookieWithReason(
    /**  
     * The reason(s) this cookie was blocked.  
     */  
    val blockedReasons: List<SetCookieBlockedReason>,

    /**  
     * The string representing this individual cookie as it would appear in the header.  
     This is not the entire "cookie" or "set-cookie" header which could have multiple cookies.  
     */  
    val cookieLine: String,

    /**  
     * The cookie object which represents the cookie which was not stored. It is optional because  
     sometimes complete cookie information is not available, such as in the case of parsing  
     errors.  
     */  
    val cookie: Cookie? = null
)

/**
 * A cookie with was not sent with a request with the corresponding reason.
 *
 * @link [Network#BlockedCookieWithReason](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-BlockedCookieWithReason) type documentation.
 */

@kotlinx.serialization.Serializable
data class BlockedCookieWithReason(
    /**  
     * The reason(s) the cookie was blocked.  
     */  
    val blockedReasons: List<CookieBlockedReason>,

    /**  
     * The cookie object representing the cookie which was not sent.  
     */  
    val cookie: Cookie
)

/**
 * Cookie parameter object
 *
 * @link [Network#CookieParam](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CookieParam) type documentation.
 */

@kotlinx.serialization.Serializable
data class CookieParam(
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
     * Cookie Priority.  
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
 * Authorization challenge for HTTP status code 401 or 407.
 *
 * @link [Network#AuthChallenge](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-AuthChallenge) type documentation.
 */

@kotlinx.serialization.Serializable
data class AuthChallenge(
    /**  
     * Source of the authentication challenge.  
     */  
    val source: String? = null,

    /**  
     * Origin of the challenger.  
     */  
    val origin: String,

    /**  
     * The authentication scheme used, such as basic or digest  
     */  
    val scheme: String,

    /**  
     * The realm of the challenge. May be empty.  
     */  
    val realm: String
)

/**
 * Response to an AuthChallenge.
 *
 * @link [Network#AuthChallengeResponse](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-AuthChallengeResponse) type documentation.
 */

@kotlinx.serialization.Serializable
data class AuthChallengeResponse(
    /**  
     * The decision on what to do in response to the authorization challenge.  Default means  
     deferring to the default behavior of the net stack, which will likely either the Cancel  
     authentication or display a popup dialog box.  
     */  
    val response: String,

    /**  
     * The username to provide, possibly empty. Should only be set if response is  
     ProvideCredentials.  
     */  
    val username: String? = null,

    /**  
     * The password to provide, possibly empty. Should only be set if response is  
     ProvideCredentials.  
     */  
    val password: String? = null
)

/**
 * Stages of the interception to begin intercepting. Request will intercept before the request is
sent. Response will intercept after the response is received.
 *
 * @link [Network#InterceptionStage](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-InterceptionStage) type documentation.
 */
@kotlinx.serialization.Serializable
enum class InterceptionStage {
    @kotlinx.serialization.SerialName("Request")
    REQUEST,

    @kotlinx.serialization.SerialName("HeadersReceived")
    HEADERSRECEIVED;
}

/**
 * Request pattern for interception.
 *
 * @link [Network#RequestPattern](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-RequestPattern) type documentation.
 */

@kotlinx.serialization.Serializable
data class RequestPattern(
    /**  
     * Wildcards ('*' -> zero or more, '?' -> exactly one) are allowed. Escape character is  
     backslash. Omitting is equivalent to "*".  
     */  
    val urlPattern: String? = null,

    /**  
     * If set, only requests for matching resource types will be intercepted.  
     */  
    val resourceType: ResourceType? = null,

    /**  
     * Stage at wich to begin intercepting requests. Default is Request.  
     */  
    val interceptionStage: InterceptionStage? = null
)

/**
 * Information about a signed exchange signature.
https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
 *
 * @link [Network#SignedExchangeSignature](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SignedExchangeSignature) type documentation.
 */

@kotlinx.serialization.Serializable
data class SignedExchangeSignature(
    /**  
     * Signed exchange signature label.  
     */  
    val label: String,

    /**  
     * The hex string of signed exchange signature.  
     */  
    val signature: String,

    /**  
     * Signed exchange signature integrity.  
     */  
    val integrity: String,

    /**  
     * Signed exchange signature cert Url.  
     */  
    val certUrl: String? = null,

    /**  
     * The hex string of signed exchange signature cert sha256.  
     */  
    val certSha256: String? = null,

    /**  
     * Signed exchange signature validity Url.  
     */  
    val validityUrl: String,

    /**  
     * Signed exchange signature date.  
     */  
    val date: Int,

    /**  
     * Signed exchange signature expires.  
     */  
    val expires: Int,

    /**  
     * The encoded certificates.  
     */  
    val certificates: List<String>? = null
)

/**
 * Information about a signed exchange header.
https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
 *
 * @link [Network#SignedExchangeHeader](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SignedExchangeHeader) type documentation.
 */

@kotlinx.serialization.Serializable
data class SignedExchangeHeader(
    /**  
     * Signed exchange request URL.  
     */  
    val requestUrl: String,

    /**  
     * Signed exchange response code.  
     */  
    val responseCode: Int,

    /**  
     * Signed exchange response headers.  
     */  
    val responseHeaders: Headers,

    /**  
     * Signed exchange response signature.  
     */  
    val signatures: List<SignedExchangeSignature>,

    /**  
     * Signed exchange header integrity hash in the form of "sha256-<base64-hash-value>".  
     */  
    val headerIntegrity: String
)

/**
 * Field type for a signed exchange related error.
 *
 * @link [Network#SignedExchangeErrorField](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SignedExchangeErrorField) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SignedExchangeErrorField {
    @kotlinx.serialization.SerialName("signatureSig")
    SIGNATURESIG,

    @kotlinx.serialization.SerialName("signatureIntegrity")
    SIGNATUREINTEGRITY,

    @kotlinx.serialization.SerialName("signatureCertUrl")
    SIGNATURECERTURL,

    @kotlinx.serialization.SerialName("signatureCertSha256")
    SIGNATURECERTSHA256,

    @kotlinx.serialization.SerialName("signatureValidityUrl")
    SIGNATUREVALIDITYURL,

    @kotlinx.serialization.SerialName("signatureTimestamps")
    SIGNATURETIMESTAMPS;
}

/**
 * Information about a signed exchange response.
 *
 * @link [Network#SignedExchangeError](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SignedExchangeError) type documentation.
 */

@kotlinx.serialization.Serializable
data class SignedExchangeError(
    /**  
     * Error message.  
     */  
    val message: String,

    /**  
     * The index of the signature which caused the error.  
     */  
    val signatureIndex: Int? = null,

    /**  
     * The field which caused the error.  
     */  
    val errorField: SignedExchangeErrorField? = null
)

/**
 * Information about a signed exchange response.
 *
 * @link [Network#SignedExchangeInfo](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SignedExchangeInfo) type documentation.
 */

@kotlinx.serialization.Serializable
data class SignedExchangeInfo(
    /**  
     * The outer response of signed HTTP exchange which was received from network.  
     */  
    val outerResponse: Response,

    /**  
     * Information about the signed exchange header.  
     */  
    val header: SignedExchangeHeader? = null,

    /**  
     * Security details for the signed exchange header.  
     */  
    val securityDetails: SecurityDetails? = null,

    /**  
     * Errors occurred while handling the signed exchagne.  
     */  
    val errors: List<SignedExchangeError>? = null
)

/**
 *
 *
 * @link [Network#PrivateNetworkRequestPolicy](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-PrivateNetworkRequestPolicy) type documentation.
 */
@kotlinx.serialization.Serializable
enum class PrivateNetworkRequestPolicy {
    @kotlinx.serialization.SerialName("Allow")
    ALLOW,

    @kotlinx.serialization.SerialName("BlockFromInsecureToMorePrivate")
    BLOCKFROMINSECURETOMOREPRIVATE,

    @kotlinx.serialization.SerialName("WarnFromInsecureToMorePrivate")
    WARNFROMINSECURETOMOREPRIVATE;
}

/**
 *
 *
 * @link [Network#IPAddressSpace](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-IPAddressSpace) type documentation.
 */
@kotlinx.serialization.Serializable
enum class IPAddressSpace {
    @kotlinx.serialization.SerialName("Local")
    LOCAL,

    @kotlinx.serialization.SerialName("Private")
    PRIVATE,

    @kotlinx.serialization.SerialName("Public")
    PUBLIC,

    @kotlinx.serialization.SerialName("Unknown")
    UNKNOWN;
}

/**
 *
 *
 * @link [Network#ClientSecurityState](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-ClientSecurityState) type documentation.
 */

@kotlinx.serialization.Serializable
data class ClientSecurityState(
    /**  
     *  
     */  
    val initiatorIsSecureContext: Boolean,

    /**  
     *  
     */  
    val initiatorIPAddressSpace: IPAddressSpace,

    /**  
     *  
     */  
    val privateNetworkRequestPolicy: PrivateNetworkRequestPolicy
)

/**
 *
 *
 * @link [Network#CrossOriginOpenerPolicyValue](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CrossOriginOpenerPolicyValue) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CrossOriginOpenerPolicyValue {
    @kotlinx.serialization.SerialName("SameOrigin")
    SAMEORIGIN,

    @kotlinx.serialization.SerialName("SameOriginAllowPopups")
    SAMEORIGINALLOWPOPUPS,

    @kotlinx.serialization.SerialName("UnsafeNone")
    UNSAFENONE,

    @kotlinx.serialization.SerialName("SameOriginPlusCoep")
    SAMEORIGINPLUSCOEP;
}

/**
 *
 *
 * @link [Network#CrossOriginOpenerPolicyStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CrossOriginOpenerPolicyStatus) type documentation.
 */

@kotlinx.serialization.Serializable
data class CrossOriginOpenerPolicyStatus(
    /**  
     *  
     */  
    val value: CrossOriginOpenerPolicyValue,

    /**  
     *  
     */  
    val reportOnlyValue: CrossOriginOpenerPolicyValue,

    /**  
     *  
     */  
    val reportingEndpoint: String? = null,

    /**  
     *  
     */  
    val reportOnlyReportingEndpoint: String? = null
)

/**
 *
 *
 * @link [Network#CrossOriginEmbedderPolicyValue](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CrossOriginEmbedderPolicyValue) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CrossOriginEmbedderPolicyValue {
    @kotlinx.serialization.SerialName("None")
    NONE,

    @kotlinx.serialization.SerialName("RequireCorp")
    REQUIRECORP;
}

/**
 *
 *
 * @link [Network#CrossOriginEmbedderPolicyStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-CrossOriginEmbedderPolicyStatus) type documentation.
 */

@kotlinx.serialization.Serializable
data class CrossOriginEmbedderPolicyStatus(
    /**  
     *  
     */  
    val value: CrossOriginEmbedderPolicyValue,

    /**  
     *  
     */  
    val reportOnlyValue: CrossOriginEmbedderPolicyValue,

    /**  
     *  
     */  
    val reportingEndpoint: String? = null,

    /**  
     *  
     */  
    val reportOnlyReportingEndpoint: String? = null
)

/**
 *
 *
 * @link [Network#SecurityIsolationStatus](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-SecurityIsolationStatus) type documentation.
 */

@kotlinx.serialization.Serializable
data class SecurityIsolationStatus(
    /**  
     *  
     */  
    val coop: CrossOriginOpenerPolicyStatus? = null,

    /**  
     *  
     */  
    val coep: CrossOriginEmbedderPolicyStatus? = null
)

/**
 * An object providing the result of a network resource load.
 *
 * @link [Network#LoadNetworkResourcePageResult](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-LoadNetworkResourcePageResult) type documentation.
 */

@kotlinx.serialization.Serializable
data class LoadNetworkResourcePageResult(
    /**  
     *  
     */  
    val success: Boolean,

    /**  
     * Optional values used for error reporting.  
     */  
    val netError: Double? = null,

    /**  
     *  
     */  
    val netErrorName: String? = null,

    /**  
     *  
     */  
    val httpStatusCode: Double? = null,

    /**  
     * If successful, one of the following two fields holds the result.  
     */  
    val stream: pl.wendigo.chrome.api.io.StreamHandle? = null,

    /**  
     * Response headers.  
     */  
    val headers: pl.wendigo.chrome.api.network.Headers? = null
)

/**
 * An options object that may be extended later to better support CORS,
CORB and streaming.
 *
 * @link [Network#LoadNetworkResourceOptions](https://chromedevtools.github.io/devtools-protocol/tot/Network#type-LoadNetworkResourceOptions) type documentation.
 */

@kotlinx.serialization.Serializable
data class LoadNetworkResourceOptions(
    /**  
     *  
     */  
    val disableCache: Boolean,

    /**  
     *  
     */  
    val includeCredentials: Boolean
)
