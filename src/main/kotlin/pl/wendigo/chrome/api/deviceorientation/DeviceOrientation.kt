package pl.wendigo.chrome.domain.deviceorientation

/**
 * DeviceOrientation represents remote debugger protocol domain.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation](https://chromedevtools.github.io/devtools-protocol/tot/DeviceOrientation)
 */
class DeviceOrientation internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Clears the overridden Device Orientation.
     */
    fun clearDeviceOrientationOverride(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DeviceOrientation.clearDeviceOrientationOverride", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the Device Orientation.
     */
    fun setDeviceOrientationOverride(input: SetDeviceOrientationOverrideRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DeviceOrientation.setDeviceOrientationOverride", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all DeviceOrientation domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "DeviceOrientation"
        }
    }
}

/**
 * Represents request frame that can be used with DeviceOrientation.setDeviceOrientationOverride method call.
 *
 * Overrides the Device Orientation.
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
