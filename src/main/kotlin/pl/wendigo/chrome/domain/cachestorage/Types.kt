package pl.wendigo.chrome.domain.cachestorage

/**
 * Unique identifier of the Cache object.
 */

typealias CacheId = String

/**
 * type of HTTP response cached
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
 */

data class CachedResponse(
    /**  
     * Entry content, base64-encoded.  
     */  
    val body: String
)
