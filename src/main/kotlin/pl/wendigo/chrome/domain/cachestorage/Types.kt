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
   * Request url spec.
   */
  val request : String,

  /**
   * Response status text.
   */
  val response : String,

  /**
   * Number of seconds since epoch.
   */
  val responseTime : Double
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

