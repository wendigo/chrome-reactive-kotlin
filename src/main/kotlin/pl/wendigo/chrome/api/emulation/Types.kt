package pl.wendigo.chrome.api.emulation

/**
 * Screen orientation.
 *
 * @link [Emulation#ScreenOrientation](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-ScreenOrientation) type documentation.
 */

@kotlinx.serialization.Serializable
data class ScreenOrientation(
    /**  
     * Orientation type.  
     */  
    val type: String,

    /**  
     * Orientation angle.  
     */  
    val angle: Int
)

/**
 *
 *
 * @link [Emulation#DisplayFeature](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-DisplayFeature) type documentation.
 */

@kotlinx.serialization.Serializable
data class DisplayFeature(
    /**  
     * Orientation of a display feature in relation to screen  
     */  
    val orientation: String,

    /**  
     * The offset from the screen origin in either the x (for vertical  
     orientation) or y (for horizontal orientation) direction.  
     */  
    val offset: Int,

    /**  
     * A display feature may mask content such that it is not physically  
     displayed - this length along with the offset describes this area.  
     A display feature that only splits content will have a 0 mask_length.  
     */  
    val maskLength: Int
)

/**
 *
 *
 * @link [Emulation#MediaFeature](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-MediaFeature) type documentation.
 */

@kotlinx.serialization.Serializable
data class MediaFeature(
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
 * advance: If the scheduler runs out of immediate work, the virtual time base may fast forward to
allow the next delayed task (if any) to run; pause: The virtual time base may not advance;
pauseIfNetworkFetchesPending: The virtual time base may not advance if there are any pending
resource fetches.
 *
 * @link [Emulation#VirtualTimePolicy](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-VirtualTimePolicy) type documentation.
 */
@kotlinx.serialization.Serializable
enum class VirtualTimePolicy {
    @kotlinx.serialization.SerialName("advance")
    ADVANCE,

    @kotlinx.serialization.SerialName("pause")
    PAUSE,

    @kotlinx.serialization.SerialName("pauseIfNetworkFetchesPending")
    PAUSEIFNETWORKFETCHESPENDING;
}

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
 *
 * @link [Emulation#UserAgentBrandVersion](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-UserAgentBrandVersion) type documentation.
 */

@kotlinx.serialization.Serializable
data class UserAgentBrandVersion(
    /**  
     *  
     */  
    val brand: String,

    /**  
     *  
     */  
    val version: String
)

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
Missing optional values will be filled in by the target with what it would normally use.
 *
 * @link [Emulation#UserAgentMetadata](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-UserAgentMetadata) type documentation.
 */

@kotlinx.serialization.Serializable
data class UserAgentMetadata(
    /**  
     *  
     */  
    val brands: List<UserAgentBrandVersion>? = null,

    /**  
     *  
     */  
    val fullVersion: String? = null,

    /**  
     *  
     */  
    val platform: String,

    /**  
     *  
     */  
    val platformVersion: String,

    /**  
     *  
     */  
    val architecture: String,

    /**  
     *  
     */  
    val model: String,

    /**  
     *  
     */  
    val mobile: Boolean
)

/**
 * Enum of image types that can be disabled.
 *
 * @link [Emulation#DisabledImageType](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-DisabledImageType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class DisabledImageType {
    @kotlinx.serialization.SerialName("avif")
    AVIF,

    @kotlinx.serialization.SerialName("webp")
    WEBP;
}
