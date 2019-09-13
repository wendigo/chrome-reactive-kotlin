package pl.wendigo.chrome.api.applicationcache

/**
 * Detailed application cache resource information.
 *
 * @link [ApplicationCache#ApplicationCacheResource](https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache#type-ApplicationCacheResource) type documentation.
 */

data class ApplicationCacheResource(
    /**  
     * Resource url.  
     */  
    val url: String,

    /**  
     * Resource size.  
     */  
    val size: Int,

    /**  
     * Resource type.  
     */  
    val type: String
)

/**
 * Detailed application cache information.
 *
 * @link [ApplicationCache#ApplicationCache](https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache#type-ApplicationCache) type documentation.
 */

data class ApplicationCache(
    /**  
     * Manifest URL.  
     */  
    val manifestURL: String,

    /**  
     * Application cache size.  
     */  
    val size: Double,

    /**  
     * Application cache creation time.  
     */  
    val creationTime: Double,

    /**  
     * Application cache update time.  
     */  
    val updateTime: Double,

    /**  
     * Application cache resources.  
     */  
    val resources: List<ApplicationCacheResource>
)

/**
 * Frame identifier - manifest URL pair.
 *
 * @link [ApplicationCache#FrameWithManifest](https://chromedevtools.github.io/devtools-protocol/tot/ApplicationCache#type-FrameWithManifest) type documentation.
 */

data class FrameWithManifest(
    /**  
     * Frame identifier.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     * Manifest URL.  
     */  
    val manifestURL: String,

    /**  
     * Application cache status.  
     */  
    val status: Int
)
