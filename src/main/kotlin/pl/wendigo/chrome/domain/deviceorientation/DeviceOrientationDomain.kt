package pl.wendigo.chrome.domain.deviceorientation

/**
 * DeviceOrientationDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.Experimental class DeviceOrientationDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * Overrides the Device Orientation.
	 */
	  fun setDeviceOrientationOverride(input : SetDeviceOrientationOverrideRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DeviceOrientation.setDeviceOrientationOverride", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Clears the overridden Device Orientation.
	 */
	  fun clearDeviceOrientationOverride() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DeviceOrientation.clearDeviceOrientationOverride", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
    /**
     * Returns flowable capturing all DeviceOrientation domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "DeviceOrientation"
        }
    }
}
/**
 * Represents requestFrame parameters that can be used with DeviceOrientation.setDeviceOrientationOverride method call.
 *
 * Overrides the Device Orientation.
 */
data class SetDeviceOrientationOverrideRequest (
    /**
     * Mock alpha
     */
    val alpha : Double,

    /**
     * Mock beta
     */
    val beta : Double,

    /**
     * Mock gamma
     */
    val gamma : Double

)




