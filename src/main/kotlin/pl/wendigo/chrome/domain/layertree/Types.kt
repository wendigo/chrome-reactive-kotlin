package pl.wendigo.chrome.domain.layertree

/**
 * Unique Layer identifier.
 */

typealias LayerId = String

/**
 * Unique snapshot identifier.
 */

typealias SnapshotId = String

/**
 * Rectangle where scrolling happens on the main thread.
 */

data class ScrollRect(
  /**
   * Rectangle itself.
   */
  val rect : pl.wendigo.chrome.domain.dom.Rect,

  /**
   * Reason for rectangle to force scrolling on the main thread
   */
  val type : String
)

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 */

data class PictureTile(
  /**
   * Offset from owning layer left boundary
   */
  val x : Double,

  /**
   * Offset from owning layer top boundary
   */
  val y : Double,

  /**
   * Base64-encoded snapshot data.
   */
  val picture : String
)

/**
 * Information about a compositing layer.
 */

data class Layer(
  /**
   * The unique id for this layer.
   */
  val layerId : LayerId,

  /**
   * The id of parent (not present for root).
   */
  val parentLayerId : LayerId? = null,

  /**
   * The backend id for the node associated with this layer.
   */
  val backendNodeId : pl.wendigo.chrome.domain.dom.BackendNodeId? = null,

  /**
   * Offset from parent layer, X coordinate.
   */
  val offsetX : Double,

  /**
   * Offset from parent layer, Y coordinate.
   */
  val offsetY : Double,

  /**
   * Layer width.
   */
  val width : Double,

  /**
   * Layer height.
   */
  val height : Double,

  /**
   * Transformation matrix for layer, default is identity matrix
   */
  val transform : List<Double>? = null,

  /**
   * Transform anchor point X, absent if no transform specified
   */
  val anchorX : Double? = null,

  /**
   * Transform anchor point Y, absent if no transform specified
   */
  val anchorY : Double? = null,

  /**
   * Transform anchor point Z, absent if no transform specified
   */
  val anchorZ : Double? = null,

  /**
   * Indicates how many time this layer has painted.
   */
  val paintCount : Int,

  /**
   * Indicates whether this layer hosts any content, rather than being used for transform/scrolling purposes only.
   */
  val drawsContent : Boolean,

  /**
   * Set if layer is not visible.
   */
  val invisible : Boolean? = null,

  /**
   * Rectangles scrolling on main thread only.
   */
  val scrollRects : List<ScrollRect>? = null
)

/**
 * Array of timings, one per paint step.
 */

typealias PaintProfile = List<Double>

