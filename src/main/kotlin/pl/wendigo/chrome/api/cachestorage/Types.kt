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
@kotlinx.serialization.Serializable
enum class CachedResponseType {
    @kotlinx.serialization.SerialName("basic")
    BASIC,

    @kotlinx.serialization.SerialName("cors")
    CORS,

    @kotlinx.serialization.SerialName("default")
    DEFAULT,

    @kotlinx.serialization.SerialName("error")
    ERROR,

    @kotlinx.serialization.SerialName("opaqueResponse")
    OPAQUERESPONSE,

    @kotlinx.serialization.SerialName("opaqueRedirect")
    OPAQUEREDIRECT;
}

/**
 * Data entry.
 *
 * @link [CacheStorage#DataEntry](https://chromedevtools.github.io/devtools-protocol/tot/CacheStorage#type-DataEntry) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
data class CachedResponse(
    /**  
     * Entry content, base64-encoded. (Encoded as a base64 string when passed over JSON)  
     */  
    val body: String
)
