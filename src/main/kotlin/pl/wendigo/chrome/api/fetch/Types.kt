package pl.wendigo.chrome.api.fetch

/**
 * Unique request identifier.
 *
 * @link [Fetch#RequestId](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#type-RequestId) type documentation.
 */

typealias RequestId = String

/**
 * Stages of the request to handle. Request will intercept before the request is
sent. Response will intercept after the response is received (but before response
body is received.
 *
 * @link [Fetch#RequestStage](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#type-RequestStage) type documentation.
 */
enum class RequestStage {
    @com.fasterxml.jackson.annotation.JsonProperty("Request")
    REQUEST,
    @com.fasterxml.jackson.annotation.JsonProperty("Response")
    RESPONSE;
}

/**
 *
 *
 * @link [Fetch#RequestPattern](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#type-RequestPattern) type documentation.
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
    val resourceType: pl.wendigo.chrome.api.network.ResourceType? = null,

    /**  
     * Stage at wich to begin intercepting requests. Default is Request.  
     */  
    val requestStage: RequestStage? = null
)

/**
 * Response HTTP header entry
 *
 * @link [Fetch#HeaderEntry](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#type-HeaderEntry) type documentation.
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
 *
 * @link [Fetch#AuthChallenge](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#type-AuthChallenge) type documentation.
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
 *
 * @link [Fetch#AuthChallengeResponse](https://chromedevtools.github.io/devtools-protocol/tot/Fetch#type-AuthChallengeResponse) type documentation.
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
