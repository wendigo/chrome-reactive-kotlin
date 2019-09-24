package pl.wendigo.chrome.api.emulation

/**
 * Screen orientation.
 *
 * @link [Emulation#ScreenOrientation](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-ScreenOrientation) type documentation.
 */

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
 * advance: If the scheduler runs out of immediate work, the virtual time base may fast forward to
allow the next delayed task (if any) to run; pause: The virtual time base may not advance;
pauseIfNetworkFetchesPending: The virtual time base may not advance if there are any pending
resource fetches.
 *
 * @link [Emulation#VirtualTimePolicy](https://chromedevtools.github.io/devtools-protocol/tot/Emulation#type-VirtualTimePolicy) type documentation.
 */
enum class VirtualTimePolicy {
    @com.fasterxml.jackson.annotation.JsonProperty("advance")
    ADVANCE,
    @com.fasterxml.jackson.annotation.JsonProperty("pause")
    PAUSE,
    @com.fasterxml.jackson.annotation.JsonProperty("pauseIfNetworkFetchesPending")
    PAUSEIFNETWORKFETCHESPENDING;
}
