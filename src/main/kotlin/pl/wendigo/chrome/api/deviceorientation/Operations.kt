package pl.wendigo.chrome.api.deviceorientation

/**
 * DeviceOrientationOperations represents DeviceOrientation protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [DeviceOrientation](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class DeviceOrientationOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Clears the overridden Device Orientation.
     *
     * @link Protocol [DeviceOrientation#clearDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation#method-clearDeviceOrientationOverride) method documentation.
     */
    fun clearDeviceOrientationOverride() = connection.request("DeviceOrientation.clearDeviceOrientationOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Overrides the Device Orientation.
     *
     * @link Protocol [DeviceOrientation#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation#method-setDeviceOrientationOverride) method documentation.
     */
    fun setDeviceOrientationOverride(input: SetDeviceOrientationOverrideRequest) = connection.request("DeviceOrientation.setDeviceOrientationOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns flowable capturing all DeviceOrientation domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "DeviceOrientation"
        }
    }
}

/**
 * Represents request frame that can be used with [DeviceOrientation#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation#method-setDeviceOrientationOverride) operation call.
 *
 * Overrides the Device Orientation.
 * @link [DeviceOrientation#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation#method-setDeviceOrientationOverride) method documentation.
 * @see [DeviceOrientationOperations.setDeviceOrientationOverride]
 */
data class SetDeviceOrientationOverrideRequest(
    /**
     * Mock alpha
     */
    val alpha: Double,

    /**
     * Mock beta
     */
    val beta: Double,

    /**
     * Mock gamma
     */
    val gamma: Double

)
