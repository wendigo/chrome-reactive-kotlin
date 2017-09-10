package pl.wendigo.chrome.domain.input

/**
 *
 */

data class TouchPoint(
  /**
   * X coordinate of the event relative to the main frame's viewport in CSS pixels.
   */
  val x : Double,

  /**
   * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
   */
  val y : Double,

  /**
   * X radius of the touch area (default: 1.0).
   */
  val radiusX : Double? = null,

  /**
   * Y radius of the touch area (default: 1.0).
   */
  val radiusY : Double? = null,

  /**
   * Rotation angle (default: 0.0).
   */
  val rotationAngle : Double? = null,

  /**
   * Force (default: 1.0).
   */
  val force : Double? = null,

  /**
   * Identifier used to track touch sources between events, must be unique within an event.
   */
  val id : Double? = null
)

/**
 *
 */
enum class GestureSourceType {
    @com.fasterxml.jackson.annotation.JsonProperty("default") DEFAULT,
    @com.fasterxml.jackson.annotation.JsonProperty("touch") TOUCH,
    @com.fasterxml.jackson.annotation.JsonProperty("mouse") MOUSE;
}

/**
 * UTC time in seconds, counted from January 1, 1970.
 */

typealias TimeSinceEpoch = Double

