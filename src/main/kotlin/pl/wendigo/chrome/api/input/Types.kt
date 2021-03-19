package pl.wendigo.chrome.api.input

/**
 *
 *
 * @link [Input#TouchPoint](https://chromedevtools.github.io/devtools-protocol/tot/Input#type-TouchPoint) type documentation.
 */

@kotlinx.serialization.Serializable
data class TouchPoint(
    /**  
     * X coordinate of the event relative to the main frame's viewport in CSS pixels.  
     */  
    val x: Double,

    /**  
     * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to  
     the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.  
     */  
    val y: Double,

    /**  
     * X radius of the touch area (default: 1.0).  
     */  
    val radiusX: Double? = null,

    /**  
     * Y radius of the touch area (default: 1.0).  
     */  
    val radiusY: Double? = null,

    /**  
     * Rotation angle (default: 0.0).  
     */  
    val rotationAngle: Double? = null,

    /**  
     * Force (default: 1.0).  
     */  
    val force: Double? = null,

    /**  
     * The normalized tangential pressure, which has a range of [-1,1] (default: 0).  
     */  
    @pl.wendigo.chrome.protocol.Experimental val tangentialPressure: Double? = null,

    /**  
     * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0)  
     */  
    @pl.wendigo.chrome.protocol.Experimental val tiltX: Int? = null,

    /**  
     * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).  
     */  
    @pl.wendigo.chrome.protocol.Experimental val tiltY: Int? = null,

    /**  
     * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range [0,359] (default: 0).  
     */  
    @pl.wendigo.chrome.protocol.Experimental val twist: Int? = null,

    /**  
     * Identifier used to track touch sources between events, must be unique within an event.  
     */  
    val id: Double? = null
)

/**
 *
 *
 * @link [Input#GestureSourceType](https://chromedevtools.github.io/devtools-protocol/tot/Input#type-GestureSourceType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class GestureSourceType {
    @kotlinx.serialization.SerialName("default")
    DEFAULT,

    @kotlinx.serialization.SerialName("touch")
    TOUCH,

    @kotlinx.serialization.SerialName("mouse")
    MOUSE;
}

/**
 *
 *
 * @link [Input#MouseButton](https://chromedevtools.github.io/devtools-protocol/tot/Input#type-MouseButton) type documentation.
 */
@kotlinx.serialization.Serializable
enum class MouseButton {
    @kotlinx.serialization.SerialName("none")
    NONE,

    @kotlinx.serialization.SerialName("left")
    LEFT,

    @kotlinx.serialization.SerialName("middle")
    MIDDLE,

    @kotlinx.serialization.SerialName("right")
    RIGHT,

    @kotlinx.serialization.SerialName("back")
    BACK,

    @kotlinx.serialization.SerialName("forward")
    FORWARD;
}

/**
 * UTC time in seconds, counted from January 1, 1970.
 *
 * @link [Input#TimeSinceEpoch](https://chromedevtools.github.io/devtools-protocol/tot/Input#type-TimeSinceEpoch) type documentation.
 */

typealias TimeSinceEpoch = Double
