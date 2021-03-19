package pl.wendigo.chrome.api.headlessexperimental

/**
 * Encoding options for a screenshot.
 *
 * @link [HeadlessExperimental#ScreenshotParams](https://chromedevtools.github.io/devtools-protocol/tot/HeadlessExperimental#type-ScreenshotParams) type documentation.
 */

@kotlinx.serialization.Serializable
data class ScreenshotParams(
    /**  
     * Image compression format (defaults to png).  
     */  
    val format: String? = null,

    /**  
     * Compression quality from range [0..100] (jpeg only).  
     */  
    val quality: Int? = null
)
