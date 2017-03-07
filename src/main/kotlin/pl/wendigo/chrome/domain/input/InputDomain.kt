package pl.wendigo.chrome.domain.input

/**
 * InputDomain represents remote debugger protocol domain.
 *
 * This class was autogenerated by main.go. Do not edit :)
 */
class InputDomain internal constructor(private val connection : pl.wendigo.chrome.RemoteChromeConnection) {

	/**
	 * Dispatches a key event to the page.
	 */
	  fun dispatchKeyEvent(input : DispatchKeyEventRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.dispatchKeyEvent", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Dispatches a mouse event to the page.
	 */
	  fun dispatchMouseEvent(input : DispatchMouseEventRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.dispatchMouseEvent", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Dispatches a touch event to the page.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun dispatchTouchEvent(input : DispatchTouchEventRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.dispatchTouchEvent", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Emulates touch event from the mouse event parameters.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun emulateTouchFromMouseEvent(input : EmulateTouchFromMouseEventRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.emulateTouchFromMouseEvent", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun synthesizePinchGesture(input : SynthesizePinchGestureRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.synthesizePinchGesture", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun synthesizeScrollGesture(input : SynthesizeScrollGestureRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.synthesizeScrollGesture", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun synthesizeTapGesture(input : SynthesizeTapGestureRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Input.synthesizeTapGesture", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  }

/**
 * Represents requestFrame parameters that can be used with Input.dispatchKeyEvent method call.
 *
 * Dispatches a key event to the page.
 */
data class DispatchKeyEventRequest (
    /**
     * Type of the key event.
     */
    val type : String,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Time at which the event occurred. Measured in UTC time in seconds since January 1, 1970 (default: current time).
     */
    val timestamp : Double? = null,

    /**
     * Text as generated by processing a virtual key code with a keyboard layout. Not needed for for <code>keyUp</code> and <code>rawKeyDown</code> events (default: "")
     */
    val text : String? = null,

    /**
     * Text that would have been generated by the keyboard if no modifiers were pressed (except for shift). Useful for shortcut (accelerator) key handling (default: "").
     */
    val unmodifiedText : String? = null,

    /**
     * Unique key identifier (e.g., 'U+0041') (default: "").
     */
    val keyIdentifier : String? = null,

    /**
     * Unique DOM defined string value for each physical key (e.g., 'KeyA') (default: "").
     */
    val code : String? = null,

    /**
     * Unique DOM defined string value describing the meaning of the key in the context of active modifiers, keyboard layout, etc (e.g., 'AltGr') (default: "").
     */
    val key : String? = null,

    /**
     * Windows virtual key code (default: 0).
     */
    val windowsVirtualKeyCode : Int? = null,

    /**
     * Native virtual key code (default: 0).
     */
    val nativeVirtualKeyCode : Int? = null,

    /**
     * Whether the event was generated from auto repeat (default: false).
     */
    val autoRepeat : Boolean? = null,

    /**
     * Whether the event was generated from the keypad (default: false).
     */
    val isKeypad : Boolean? = null,

    /**
     * Whether the event was a system key event (default: false).
     */
    val isSystemKey : Boolean? = null

)


/**
 * Represents requestFrame parameters that can be used with Input.dispatchMouseEvent method call.
 *
 * Dispatches a mouse event to the page.
 */
data class DispatchMouseEventRequest (
    /**
     * Type of the mouse event.
     */
    val type : String,

    /**
     * X coordinate of the event relative to the main frame's viewport.
     */
    val x : Int,

    /**
     * Y coordinate of the event relative to the main frame's viewport. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     */
    val y : Int,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Time at which the event occurred. Measured in UTC time in seconds since January 1, 1970 (default: current time).
     */
    val timestamp : Double? = null,

    /**
     * Mouse button (default: "none").
     */
    val button : String? = null,

    /**
     * Number of times the mouse button was clicked (default: 0).
     */
    val clickCount : Int? = null

)


/**
 * Represents requestFrame parameters that can be used with Input.dispatchTouchEvent method call.
 *
 * Dispatches a touch event to the page.
 */
data class DispatchTouchEventRequest (
    /**
     * Type of the touch event.
     */
    val type : String,

    /**
     * Touch points.
     */
    val touchPoints : Array<TouchPoint>,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Time at which the event occurred. Measured in UTC time in seconds since January 1, 1970 (default: current time).
     */
    val timestamp : Double? = null

)


/**
 * Represents requestFrame parameters that can be used with Input.emulateTouchFromMouseEvent method call.
 *
 * Emulates touch event from the mouse event parameters.
 */
data class EmulateTouchFromMouseEventRequest (
    /**
     * Type of the mouse event.
     */
    val type : String,

    /**
     * X coordinate of the mouse pointer in DIP.
     */
    val x : Int,

    /**
     * Y coordinate of the mouse pointer in DIP.
     */
    val y : Int,

    /**
     * Time at which the event occurred. Measured in UTC time in seconds since January 1, 1970.
     */
    val timestamp : Double,

    /**
     * Mouse button.
     */
    val button : String,

    /**
     * X delta in DIP for mouse wheel event (default: 0).
     */
    val deltaX : Double? = null,

    /**
     * Y delta in DIP for mouse wheel event (default: 0).
     */
    val deltaY : Double? = null,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Number of times the mouse button was clicked (default: 0).
     */
    val clickCount : Int? = null

)


/**
 * Represents requestFrame parameters that can be used with Input.synthesizePinchGesture method call.
 *
 * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
 */
data class SynthesizePinchGestureRequest (
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    val x : Int,

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    val y : Int,

    /**
     * Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
     */
    val scaleFactor : Double,

    /**
     * Relative pointer speed in pixels per second (default: 800).
     */
    val relativeSpeed : Int? = null,

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     */
    val gestureSourceType : GestureSourceType? = null

)


/**
 * Represents requestFrame parameters that can be used with Input.synthesizeScrollGesture method call.
 *
 * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
 */
data class SynthesizeScrollGestureRequest (
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    val x : Int,

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    val y : Int,

    /**
     * The distance to scroll along the X axis (positive to scroll left).
     */
    val xDistance : Int? = null,

    /**
     * The distance to scroll along the Y axis (positive to scroll up).
     */
    val yDistance : Int? = null,

    /**
     * The number of additional pixels to scroll back along the X axis, in addition to the given distance.
     */
    val xOverscroll : Int? = null,

    /**
     * The number of additional pixels to scroll back along the Y axis, in addition to the given distance.
     */
    val yOverscroll : Int? = null,

    /**
     * Prevent fling (default: true).
     */
    val preventFling : Boolean? = null,

    /**
     * Swipe speed in pixels per second (default: 800).
     */
    val speed : Int? = null,

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     */
    val gestureSourceType : GestureSourceType? = null,

    /**
     * The number of times to repeat the gesture (default: 0).
     */
    val repeatCount : Int? = null,

    /**
     * The number of milliseconds delay between each repeat. (default: 250).
     */
    val repeatDelayMs : Int? = null,

    /**
     * The name of the interaction markers to generate, if not empty (default: "").
     */
    val interactionMarkerName : String? = null

)


/**
 * Represents requestFrame parameters that can be used with Input.synthesizeTapGesture method call.
 *
 * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
 */
data class SynthesizeTapGestureRequest (
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    val x : Int,

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    val y : Int,

    /**
     * Duration between touchdown and touchup events in ms (default: 50).
     */
    val duration : Int? = null,

    /**
     * Number of times to perform the tap (e.g. 2 for double tap, default: 1).
     */
    val tapCount : Int? = null,

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     */
    val gestureSourceType : GestureSourceType? = null

)



