package pl.wendigo.chrome.domain.headlessexperimental

/**
 * Encoding options for a screenshot.
 */

data class ScreenshotParams(
  /**
   * Image compression format (defaults to png).
   */
  val format : String? = null,

  /**
   * Compression quality from range [0..100] (jpeg only).
   */
  val quality : Int? = null
)

