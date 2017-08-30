package pl.wendigo.chrome.domain.cachestorage

/**
 * Unique identifier of the Cache object.
 */

typealias CacheId = String

/**
 * Data entry.
 */

data class DataEntry(
  /**
   * Request URL.
   */
  val requestURL : String,

  /**
   * Number of seconds since epoch.
   */
  val responseTime : Double,

  /**
   * Response headers
   */
  val responseHeaders : List<Header>
)

/**
 * Cache identifier.
 */

data class Cache(
  /**
   * An opaque unique id of the cache.
   */
  val cacheId : CacheId,

  /**
   * Security origin of the cache.
   */
  val securityOrigin : String,

  /**
   * The name of the cache.
   */
  val cacheName : String
)

/**
 *
 */

data class Header(
  /**
   *
   */
  val name : String,

  /**
   *
   */
  val value : String
)

/**
 * Cached response
 */

data class CachedResponse(
  /**
   * Entry content, base64-encoded.
   */
  val body : String
)

