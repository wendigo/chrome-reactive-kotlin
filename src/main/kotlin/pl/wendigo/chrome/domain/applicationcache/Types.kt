package pl.wendigo.chrome.domain.applicationcache

/**
 * Detailed application cache resource information.
 */

data class ApplicationCacheResource(
  /**
   * Resource url.
   */
  val url : String,

  /**
   * Resource size.
   */
  val size : Int,

  /**
   * Resource type.
   */
  val type : String
)

/**
 * Detailed application cache information.
 */

data class ApplicationCache(
  /**
   * Manifest URL.
   */
  val manifestURL : String,

  /**
   * Application cache size.
   */
  val size : Double,

  /**
   * Application cache creation time.
   */
  val creationTime : Double,

  /**
   * Application cache update time.
   */
  val updateTime : Double,

  /**
   * Application cache resources.
   */
  val resources : List<ApplicationCacheResource>
)

/**
 * Frame identifier - manifest URL pair.
 */

data class FrameWithManifest(
  /**
   * Frame identifier.
   */
  val frameId : pl.wendigo.chrome.domain.page.FrameId,

  /**
   * Manifest URL.
   */
  val manifestURL : String,

  /**
   * Application cache status.
   */
  val status : Int
)

