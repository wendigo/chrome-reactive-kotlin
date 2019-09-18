package pl.wendigo.chrome.api.layertree

/**
 * Unique Layer identifier.
 *
 * @link [LayerTree#LayerId](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-LayerId) type documentation.
 */

typealias LayerId = String

/**
 * Unique snapshot identifier.
 *
 * @link [LayerTree#SnapshotId](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-SnapshotId) type documentation.
 */

typealias SnapshotId = String

/**
 * Rectangle where scrolling happens on the main thread.
 *
 * @link [LayerTree#ScrollRect](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-ScrollRect) type documentation.
 */

data class ScrollRect(
  /**
   * Rectangle itself.
   */
  val rect: pl.wendigo.chrome.api.dom.Rect,

  /**
   * Reason for rectangle to force scrolling on the main thread
   */
  val type: String
)

/**
 * Sticky position constraints.
 *
 * @link [LayerTree#StickyPositionConstraint](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-StickyPositionConstraint) type documentation.
 */

data class StickyPositionConstraint(
  /**
   * Layout rectangle of the sticky element before being shifted
   */
  val stickyBoxRect: pl.wendigo.chrome.api.dom.Rect,

  /**
   * Layout rectangle of the containing block of the sticky element
   */
  val containingBlockRect: pl.wendigo.chrome.api.dom.Rect,

  /**
   * The nearest sticky layer that shifts the sticky box
   */
  val nearestLayerShiftingStickyBox: LayerId? = null,

  /**
   * The nearest sticky layer that shifts the containing block
   */
  val nearestLayerShiftingContainingBlock: LayerId? = null
)

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 *
 * @link [LayerTree#PictureTile](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-PictureTile) type documentation.
 */

data class PictureTile(
  /**
   * Offset from owning layer left boundary
   */
  val x: Double,

  /**
   * Offset from owning layer top boundary
   */
  val y: Double,

  /**
   * Base64-encoded snapshot data.
   */
  val picture: String
)

/**
 * Information about a compositing layer.
 *
 * @link [LayerTree#Layer](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-Layer) type documentation.
 */

data class Layer(
  /**
   * The unique id for this layer.
   */
  val layerId: LayerId,

  /**
   * The id of parent (not present for root).
   */
  val parentLayerId: LayerId? = null,

  /**
   * The backend id for the node associated with this layer.
   */
  val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

  /**
   * Offset from parent layer, X coordinate.
   */
  val offsetX: Double,

  /**
   * Offset from parent layer, Y coordinate.
   */
  val offsetY: Double,

  /**
   * Layer width.
   */
  val width: Double,

  /**
   * Layer height.
   */
  val height: Double,

  /**
   * Transformation matrix for layer, default is identity matrix
   */
  val transform: List<Double>? = null,

  /**
   * Transform anchor point X, absent if no transform specified
   */
  val anchorX: Double? = null,

  /**
   * Transform anchor point Y, absent if no transform specified
   */
  val anchorY: Double? = null,

  /**
   * Transform anchor point Z, absent if no transform specified
   */
  val anchorZ: Double? = null,

  /**
   * Indicates how many time this layer has painted.
   */
  val paintCount: Int,

  /**
   * Indicates whether this layer hosts any content, rather than being used for
transform/scrolling purposes only.
   */
  val drawsContent: Boolean,

  /**
   * Set if layer is not visible.
   */
  val invisible: Boolean? = null,

  /**
   * Rectangles scrolling on main thread only.
   */
  val scrollRects: List<ScrollRect>? = null,

  /**
   * Sticky position constraint information
   */
  val stickyPositionConstraint: StickyPositionConstraint? = null
)

/**
 * Array of timings, one per paint step.
 *
 * @link [LayerTree#PaintProfile](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#type-PaintProfile) type documentation.
 */

typealias PaintProfile = List<Double>

