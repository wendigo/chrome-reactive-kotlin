package pl.wendigo.chrome.api.deviceorientation

import kotlinx.serialization.json.Json

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
    fun clearDeviceOrientationOverride() = connection.request("DeviceOrientation.clearDeviceOrientationOverride", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Overrides the Device Orientation.
     *
     * @link Protocol [DeviceOrientation#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation#method-setDeviceOrientationOverride) method documentation.
     */
    fun setDeviceOrientationOverride(input: SetDeviceOrientationOverrideRequest) = connection.request("DeviceOrientation.setDeviceOrientationOverride", Json.encodeToJsonElement(SetDeviceOrientationOverrideRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Returns flowable capturing all DeviceOrientation domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
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
@kotlinx.serialization.Serializable
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
