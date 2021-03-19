package pl.wendigo.chrome.api.cachestorage

/**
 * Unique identifier of the Cache object.
 *
 * @link [CacheStorage#CacheId](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-CacheId) type documentation.
 */

typealias CacheId = String

/**
 * type of HTTP response cached
 *
 * @link [CacheStorage#CachedResponseType](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-CachedResponseType) type documentation.
 */
enum class CachedResponseType {
    @com.fasterxml.jackson.annotation.JsonProperty("basic")
    BASIC,

    @com.fasterxml.jackson.annotation.JsonProperty("cors")
    CORS,

    @com.fasterxml.jackson.annotation.JsonProperty("default")
    DEFAULT,

    @com.fasterxml.jackson.annotation.JsonProperty("error")
    ERROR,

    @com.fasterxml.jackson.annotation.JsonProperty("opaqueResponse")
    OPAQUERESPONSE,

    @com.fasterxml.jackson.annotation.JsonProperty("opaqueRedirect")
    OPAQUEREDIRECT;
}

/**
 * Data entry.
 *
 * @link [CacheStorage#DataEntry](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-DataEntry) type documentation.
 */

data class DataEntry(
    /**  
     * Request URL.  
     */  
    val requestURL: String,

    /**  
     * Request method.  
     */  
    val requestMethod: String,

    /**  
     * Request headers  
     */  
    val requestHeaders: List<Header>,

    /**  
     * Number of seconds since epoch.  
     */  
    val responseTime: Double,

    /**  
     * HTTP response status code.  
     */  
    val responseStatus: Int,

    /**  
     * HTTP response status text.  
     */  
    val responseStatusText: String,

    /**  
     * HTTP response type  
     */  
    val responseType: CachedResponseType,

    /**  
     * Response headers  
     */  
    val responseHeaders: List<Header>
)

/**
 * Cache identifier.
 *
 * @link [CacheStorage#Cache](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-Cache) type documentation.
 */

data class Cache(
    /**  
     * An opaque unique id of the cache.  
     */  
    val cacheId: CacheId,

    /**  
     * Security origin of the cache.  
     */  
    val securityOrigin: String,

    /**  
     * The name of the cache.  
     */  
    val cacheName: String
)

/**
 *
 *
 * @link [CacheStorage#Header](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-Header) type documentation.
 */

data class Header(
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
 * Cached response
 *
 * @link [CacheStorage#CachedResponse](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-CachedResponse) type documentation.
 */

data class CachedResponse(
    /**  
     * Entry content, base64-encoded. (Encoded as a base64 string when passed over JSON)  
     */  
    val body: String
)
