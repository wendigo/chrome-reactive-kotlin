package pl.wendigo.chrome.api.target

/**
 *
 *
 * @link [Target#TargetID](https://chromedevtools.github.io/devtools-protocol/tot/Target#type-TargetID) type documentation.
 */

typealias TargetID = String

/**
 * Unique identifier of attached debugging session.
 *
 * @link [Target#SessionID](https://chromedevtools.github.io/devtools-protocol/tot/Target#type-SessionID) type documentation.
 */

typealias SessionID = String

/**
 *
 *
 * @link [Target#TargetInfo](https://chromedevtools.github.io/devtools-protocol/tot/Target#type-TargetInfo) type documentation.
 */

data class TargetInfo(
    /**  
     *  
     */  
    val targetId: TargetID,

    /**  
     *  
     */  
    val type: String,

    /**  
     *  
     */  
    val title: String,

    /**  
     *  
     */  
    val url: String,

    /**  
     * Whether the target has an attached client.  
     */  
    val attached: Boolean,

    /**  
     * Opener target Id  
     */  
    val openerId: TargetID? = null,

    /**  
     *  
     */  
    @pl.wendigo.chrome.protocol.Experimental val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID? = null
)

/**
 *
 *
 * @link [Target#RemoteLocation](https://chromedevtools.github.io/devtools-protocol/tot/Target#type-RemoteLocation) type documentation.
 */

data class RemoteLocation(
    /**  
     *  
     */  
    val host: String,

    /**  
     *  
     */  
    val port: Int
)
