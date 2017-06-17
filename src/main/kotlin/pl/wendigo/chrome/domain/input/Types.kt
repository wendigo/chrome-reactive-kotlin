package pl.wendigo.chrome.domain.input

/**
 *
 */

data class TouchPoint(
  /**
   * State of the touch point.
   */
  val state : String,

  /**
   * X coordinate of the event relative to the main frame's viewport.
   */
  val x : Int,

  /**
   * Y coordinate of the event relative to the main frame's viewport. 0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
   */
  val y : Int,

  /**
   * X radius of the touch area (default: 1).
   */
  val radiusX : Int? = null,

  /**
   * Y radius of the touch area (default: 1).
   */
  val radiusY : Int? = null,

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

