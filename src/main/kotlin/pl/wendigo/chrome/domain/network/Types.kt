package pl.wendigo.chrome.domain.network

/**
 * Unique loader identifier.
 */

typealias LoaderId = String

/**
 * Unique request identifier.
 */

typealias RequestId = String

/**
 * Unique intercepted request identifier.
 */

typealias InterceptionId = String

/**
 * Network level fetch failure reason.
 */
enum class ErrorReason {
    @com.fasterxml.jackson.annotation.JsonProperty("Failed") FAILED,
    @com.fasterxml.jackson.annotation.JsonProperty("Aborted") ABORTED,
    @com.fasterxml.jackson.annotation.JsonProperty("TimedOut") TIMEDOUT,
    @com.fasterxml.jackson.annotation.JsonProperty("AccessDenied") ACCESSDENIED,
    @com.fasterxml.jackson.annotation.JsonProperty("ConnectionClosed") CONNECTIONCLOSED,
    @com.fasterxml.jackson.annotation.JsonProperty("ConnectionReset") CONNECTIONRESET,
    @com.fasterxml.jackson.annotation.JsonProperty("ConnectionRefused") CONNECTIONREFUSED,
    @com.fasterxml.jackson.annotation.JsonProperty("ConnectionAborted") CONNECTIONABORTED,
    @com.fasterxml.jackson.annotation.JsonProperty("ConnectionFailed") CONNECTIONFAILED,
    @com.fasterxml.jackson.annotation.JsonProperty("NameNotResolved") NAMENOTRESOLVED,
    @com.fasterxml.jackson.annotation.JsonProperty("InternetDisconnected") INTERNETDISCONNECTED,
    @com.fasterxml.jackson.annotation.JsonProperty("AddressUnreachable") ADDRESSUNREACHABLE;
}

/**
 * UTC time in seconds, counted from January 1, 1970.
 */

typealias TimeSinceEpoch = Double

/**
 * Monotonically increasing time in seconds since an arbitrary point in the past.
 */

typealias MonotonicTime = Double

/**
 * Request / response headers as keys / values of JSON object.
 */

typealias Headers = Map<String, Any>

/**
 * The underlying connection technology that the browser is supposedly using.
 */
enum class ConnectionType {
    @com.fasterxml.jackson.annotation.JsonProperty("none") NONE,
    @com.fasterxml.jackson.annotation.JsonProperty("cellular2g") CELLULAR2G,
    @com.fasterxml.jackson.annotation.JsonProperty("cellular3g") CELLULAR3G,
    @com.fasterxml.jackson.annotation.JsonProperty("cellular4g") CELLULAR4G,
    @com.fasterxml.jackson.annotation.JsonProperty("bluetooth") BLUETOOTH,
    @com.fasterxml.jackson.annotation.JsonProperty("ethernet") ETHERNET,
    @com.fasterxml.jackson.annotation.JsonProperty("wifi") WIFI,
    @com.fasterxml.jackson.annotation.JsonProperty("wimax") WIMAX,
    @com.fasterxml.jackson.annotation.JsonProperty("other") OTHER;
}

/**
 * Represents the cookie&apos;s &apos;SameSite&apos; status: https://tools.ietf.org/html/draft-west-first-party-cookies
 */
enum class CookieSameSite {
    @com.fasterxml.jackson.annotation.JsonProperty("Strict") STRICT,
    @com.fasterxml.jackson.annotation.JsonProperty("Lax") LAX;
}

/**
 * Timing information for the request.
 */

data class ResourceTiming(
  /**
   * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in milliseconds relatively to this requestTime.
   */
  val requestTime : Double,

  /**
   * Started resolving proxy.
   */
  val proxyStart : Double,

  /**
   * Finished resolving proxy.
   */
  val proxyEnd : Double,

  /**
   * Started DNS address resolve.
   */
  val dnsStart : Double,

  /**
   * Finished DNS address resolve.
   */
  val dnsEnd : Double,

  /**
   * Started connecting to the remote host.
   */
  val connectStart : Double,

  /**
   * Connected to the remote host.
   */
  val connectEnd : Double,

  /**
   * Started SSL handshake.
   */
  val sslStart : Double,

  /**
   * Finished SSL handshake.
   */
  val sslEnd : Double,

  /**
   * Started running ServiceWorker.
   */
  @pl.wendigo.chrome.Experimental val workerStart : Double,

  /**
   * Finished Starting ServiceWorker.
   */
  @pl.wendigo.chrome.Experimental val workerReady : Double,

  /**
   * Started sending request.
   */
  val sendStart : Double,

  /**
   * Finished sending request.
   */
  val sendEnd : Double,

  /**
   * Time the server started pushing request.
   */
  @pl.wendigo.chrome.Experimental val pushStart : Double,

  /**
   * Time the server finished pushing request.
   */
  @pl.wendigo.chrome.Experimental val pushEnd : Double,

  /**
   * Finished receiving response headers.
   */
  val receiveHeadersEnd : Double
)

/**
 * Loading priority of a resource request.
 */
enum class ResourcePriority {
    @com.fasterxml.jackson.annotation.JsonProperty("VeryLow") VERYLOW,
    @com.fasterxml.jackson.annotation.JsonProperty("Low") LOW,
    @com.fasterxml.jackson.annotation.JsonProperty("Medium") MEDIUM,
    @com.fasterxml.jackson.annotation.JsonProperty("High") HIGH,
    @com.fasterxml.jackson.annotation.JsonProperty("VeryHigh") VERYHIGH;
}

/**
 * HTTP request data.
 */

data class Request(
  /**
   * Request URL.
   */
  val url : String,

  /**
   * HTTP request method.
   */
  val method : String,

  /**
   * HTTP request headers.
   */
  val headers : Headers,

  /**
   * HTTP POST request data.
   */
  val postData : String? = null,

  /**
   * The mixed content type of the request.
   */
  val mixedContentType : pl.wendigo.chrome.domain.security.MixedContentType? = null,

  /**
   * Priority of the resource request at the time request is sent.
   */
  val initialPriority : ResourcePriority,

  /**
   * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/
   */
  val referrerPolicy : String,

  /**
   * Whether is loaded via link preload.
   */
  val isLinkPreload : Boolean? = null
)

/**
 * Details of a signed certificate timestamp (SCT).
 */

data class SignedCertificateTimestamp(
  /**
   * Validation status.
   */
  val status : String,

  /**
   * Origin.
   */
  val origin : String,

  /**
   * Log name / description.
   */
  val logDescription : String,

  /**
   * Log ID.
   */
  val logId : String,

  /**
   * Issuance date.
   */
  val timestamp : TimeSinceEpoch,

  /**
   * Hash algorithm.
   */
  val hashAlgorithm : String,

  /**
   * Signature algorithm.
   */
  val signatureAlgorithm : String,

  /**
   * Signature data.
   */
  val signatureData : String
)

/**
 * Security details about a request.
 */

data class SecurityDetails(
  /**
   * Protocol name (e.g. "TLS 1.2" or "QUIC").
   */
  val protocol : String,

  /**
   * Key Exchange used by the connection, or the empty string if not applicable.
   */
  val keyExchange : String,

  /**
   * (EC)DH group used by the connection, if applicable.
   */
  val keyExchangeGroup : String? = null,

  /**
   * Cipher name.
   */
  val cipher : String,

  /**
   * TLS MAC. Note that AEAD ciphers do not have separate MACs.
   */
  val mac : String? = null,

  /**
   * Certificate ID value.
   */
  val certificateId : pl.wendigo.chrome.domain.security.CertificateId,

  /**
   * Certificate subject name.
   */
  val subjectName : String,

  /**
   * Subject Alternative Name (SAN) DNS names and IP addresses.
   */
  val sanList : List<String>,

  /**
   * Name of the issuing CA.
   */
  val issuer : String,

  /**
   * Certificate valid from date.
   */
  val validFrom : TimeSinceEpoch,

  /**
   * Certificate valid to (expiration) date
   */
  val validTo : TimeSinceEpoch,

  /**
   * List of signed certificate timestamps (SCTs).
   */
  val signedCertificateTimestampList : List<SignedCertificateTimestamp>
)

/**
 * The reason why request was blocked.
 */
enum class BlockedReason {
    @com.fasterxml.jackson.annotation.JsonProperty("csp") CSP,
    @com.fasterxml.jackson.annotation.JsonProperty("mixed-content") MIXED_CONTENT,
    @com.fasterxml.jackson.annotation.JsonProperty("origin") ORIGIN,
    @com.fasterxml.jackson.annotation.JsonProperty("inspector") INSPECTOR,
    @com.fasterxml.jackson.annotation.JsonProperty("subresource-filter") SUBRESOURCE_FILTER,
    @com.fasterxml.jackson.annotation.JsonProperty("other") OTHER;
}

/**
 * HTTP response data.
 */

data class Response(
  /**
   * Response URL. This URL can be different from CachedResource.url in case of redirect.
   */
  val url : String,

  /**
   * HTTP response status code.
   */
  val status : Int,

  /**
   * HTTP response status text.
   */
  val statusText : String,

  /**
   * HTTP response headers.
   */
  val headers : Headers,

  /**
   * HTTP response headers text.
   */
  val headersText : String? = null,

  /**
   * Resource mimeType as determined by the browser.
   */
  val mimeType : String,

  /**
   * Refined HTTP request headers that were actually transmitted over the network.
   */
  val requestHeaders : Headers? = null,

  /**
   * HTTP request headers text.
   */
  val requestHeadersText : String? = null,

  /**
   * Specifies whether physical connection was actually reused for this request.
   */
  val connectionReused : Boolean,

  /**
   * Physical connection id that was actually used for this request.
   */
  val connectionId : Double,

  /**
   * Remote IP address.
   */
  val remoteIPAddress : String? = null,

  /**
   * Remote port.
   */
  val remotePort : Int? = null,

  /**
   * Specifies that the request was served from the disk cache.
   */
  val fromDiskCache : Boolean? = null,

  /**
   * Specifies that the request was served from the ServiceWorker.
   */
  val fromServiceWorker : Boolean? = null,

  /**
   * Total number of bytes received for this request so far.
   */
  val encodedDataLength : Double,

  /**
   * Timing information for the given request.
   */
  val timing : ResourceTiming? = null,

  /**
   * Protocol used to fetch this request.
   */
  val protocol : String? = null,

  /**
   * Security state of the request resource.
   */
  val securityState : pl.wendigo.chrome.domain.security.SecurityState,

  /**
   * Security details for the request.
   */
  val securityDetails : SecurityDetails? = null
)

/**
 * WebSocket request data.
 */

data class WebSocketRequest(
  /**
   * HTTP request headers.
   */
  val headers : Headers
)

/**
 * WebSocket response data.
 */

data class WebSocketResponse(
  /**
   * HTTP response status code.
   */
  val status : Int,

  /**
   * HTTP response status text.
   */
  val statusText : String,

  /**
   * HTTP response headers.
   */
  val headers : Headers,

  /**
   * HTTP response headers text.
   */
  val headersText : String? = null,

  /**
   * HTTP request headers.
   */
  val requestHeaders : Headers? = null,

  /**
   * HTTP request headers text.
   */
  val requestHeadersText : String? = null
)

/**
 * WebSocket frame data.
 */

data class WebSocketFrame(
  /**
   * WebSocket frame opcode.
   */
  val opcode : Double,

  /**
   * WebSocke frame mask.
   */
  val mask : Boolean,

  /**
   * WebSocke frame payload data.
   */
  val payloadData : String
)

/**
 * Information about the cached resource.
 */

data class CachedResource(
  /**
   * Resource URL. This is the url of the original network request.
   */
  val url : String,

  /**
   * Type of this resource.
   */
  val type : pl.wendigo.chrome.domain.page.ResourceType,

  /**
   * Cached response data.
   */
  val response : Response? = null,

  /**
   * Cached response body size.
   */
  val bodySize : Double
)

/**
 * Information about the request initiator.
 */

data class Initiator(
  /**
   * Type of this initiator.
   */
  val type : String,

  /**
   * Initiator JavaScript stack trace, set for Script only.
   */
  val stack : pl.wendigo.chrome.domain.runtime.StackTrace? = null,

  /**
   * Initiator URL, set for Parser type or for Script type (when script is importing module).
   */
  val url : String? = null,

  /**
   * Initiator line number, set for Parser type or for Script type (when script is importing module) (0-based).
   */
  val lineNumber : Double? = null
)

/**
 * Cookie object
 */

data class Cookie(
  /**
   * Cookie name.
   */
  val name : String,

  /**
   * Cookie value.
   */
  val value : String,

  /**
   * Cookie domain.
   */
  val domain : String,

  /**
   * Cookie path.
   */
  val path : String,

  /**
   * Cookie expiration date as the number of seconds since the UNIX epoch.
   */
  val expires : Double,

  /**
   * Cookie size.
   */
  val size : Int,

  /**
   * True if cookie is http-only.
   */
  val httpOnly : Boolean,

  /**
   * True if cookie is secure.
   */
  val secure : Boolean,

  /**
   * True in case of session cookie.
   */
  val session : Boolean,

  /**
   * Cookie SameSite type.
   */
  val sameSite : CookieSameSite? = null
)

/**
 * Cookie parameter object
 */

data class CookieParam(
  /**
   * Cookie name.
   */
  val name : String,

  /**
   * Cookie value.
   */
  val value : String,

  /**
   * The request-URI to associate with the setting of the cookie. This value can affect the default domain and path values of the created cookie.
   */
  val url : String? = null,

  /**
   * Cookie domain.
   */
  val domain : String? = null,

  /**
   * Cookie path.
   */
  val path : String? = null,

  /**
   * True if cookie is secure.
   */
  val secure : Boolean? = null,

  /**
   * True if cookie is http-only.
   */
  val httpOnly : Boolean? = null,

  /**
   * Cookie SameSite type.
   */
  val sameSite : CookieSameSite? = null,

  /**
   * Cookie expiration date, session cookie if not set
   */
  val expires : TimeSinceEpoch? = null
)

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */

data class AuthChallenge(
  /**
   * Source of the authentication challenge.
   */
  val source : String? = null,

  /**
   * Origin of the challenger.
   */
  val origin : String,

  /**
   * The authentication scheme used, such as basic or digest
   */
  val scheme : String,

  /**
   * The realm of the challenge. May be empty.
   */
  val realm : String
)

/**
 * Response to an AuthChallenge.
 */

data class AuthChallengeResponse(
  /**
   * The decision on what to do in response to the authorization challenge.  Default means deferring to the default behavior of the net stack, which will likely either the Cancel authentication or display a popup dialog box.
   */
  val response : String,

  /**
   * The username to provide, possibly empty. Should only be set if response is ProvideCredentials.
   */
  val username : String? = null,

  /**
   * The password to provide, possibly empty. Should only be set if response is ProvideCredentials.
   */
  val password : String? = null
)

/**
 * Stages of the interception to begin intercepting. Request will intercept before the request is sent. Response will intercept after the response is received.
 */
enum class InterceptionStage {
    @com.fasterxml.jackson.annotation.JsonProperty("Request") REQUEST,
    @com.fasterxml.jackson.annotation.JsonProperty("HeadersReceived") HEADERSRECEIVED;
}

/**
 * Request pattern for interception.
 */

data class RequestPattern(
  /**
   * Wildcards ('*' -> zero or more, '?' -> exactly one) are allowed. Escape character is backslash. Omitting is equivalent to "*".
   */
  val urlPattern : String? = null,

  /**
   * If set, only requests for matching resource types will be intercepted.
   */
  val resourceType : pl.wendigo.chrome.domain.page.ResourceType? = null,

  /**
   * Stage at wich to begin intercepting requests. Default is Request.
   */
  val interceptionStage : InterceptionStage? = null
)

