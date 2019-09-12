package pl.wendigo.chrome.domain.fetch

/**
 * Unique request identifier.
 */

typealias RequestId = String

/**
 * Stages of the request to handle. Request will intercept before the request is
sent. Response will intercept after the response is received (but before response
body is received.
 */
enum class RequestStage {
    @com.fasterxml.jackson.annotation.JsonProperty("Request") REQUEST,
    @com.fasterxml.jackson.annotation.JsonProperty("Response") RESPONSE;
}

/**
 *
 */

data class RequestPattern(
    /**  
     * Wildcards ('*' -> zero or more, '?' -> exactly one) are allowed. Escape character is  
  backslash. Omitting is equivalent to "*".  
     */  
    val urlPattern: String? = null,

    /**  
     * If set, only requests for matching resource types will be intercepted.  
     */  
    val resourceType: pl.wendigo.chrome.domain.network.ResourceType? = null,

    /**  
     * Stage at wich to begin intercepting requests. Default is Request.  
     */  
    val requestStage: RequestStage? = null
)

/**
 * Response HTTP header entry
 */

data class HeaderEntry(
    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val value: String
)

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */

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
 */

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
