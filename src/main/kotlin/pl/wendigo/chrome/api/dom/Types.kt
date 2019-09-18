package pl.wendigo.chrome.api.dom

/**
 * Unique DOM node identifier.
 *
 * @link [DOM#NodeId](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-NodeId) type documentation.
 */

typealias NodeId = Int

/**
 * Unique DOM node identifier used to reference a node that may not have been pushed to the
front-end.
 *
 * @link [DOM#BackendNodeId](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-BackendNodeId) type documentation.
 */

typealias BackendNodeId = Int

/**
 * Backend node with a friendly name.
 *
 * @link [DOM#BackendNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-BackendNode) type documentation.
 */

data class BackendNode(
  /**
   * `Node`'s nodeType.
   */
  val nodeType: Int,

  /**
   * `Node`'s nodeName.
   */
  val nodeName: String,

  /**
   *
   */
  val backendNodeId: BackendNodeId
)

/**
 * Pseudo element type.
 *
 * @link [DOM#PseudoType](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-PseudoType) type documentation.
 */
enum class PseudoType {
    @com.fasterxml.jackson.annotation.JsonProperty("first-line") FIRST_LINE,
    @com.fasterxml.jackson.annotation.JsonProperty("first-letter") FIRST_LETTER,
    @com.fasterxml.jackson.annotation.JsonProperty("before") BEFORE,
    @com.fasterxml.jackson.annotation.JsonProperty("after") AFTER,
    @com.fasterxml.jackson.annotation.JsonProperty("backdrop") BACKDROP,
    @com.fasterxml.jackson.annotation.JsonProperty("selection") SELECTION,
    @com.fasterxml.jackson.annotation.JsonProperty("first-line-inherited") FIRST_LINE_INHERITED,
    @com.fasterxml.jackson.annotation.JsonProperty("scrollbar") SCROLLBAR,
    @com.fasterxml.jackson.annotation.JsonProperty("scrollbar-thumb") SCROLLBAR_THUMB,
    @com.fasterxml.jackson.annotation.JsonProperty("scrollbar-button") SCROLLBAR_BUTTON,
    @com.fasterxml.jackson.annotation.JsonProperty("scrollbar-track") SCROLLBAR_TRACK,
    @com.fasterxml.jackson.annotation.JsonProperty("scrollbar-track-piece") SCROLLBAR_TRACK_PIECE,
    @com.fasterxml.jackson.annotation.JsonProperty("scrollbar-corner") SCROLLBAR_CORNER,
    @com.fasterxml.jackson.annotation.JsonProperty("resizer") RESIZER,
    @com.fasterxml.jackson.annotation.JsonProperty("input-list-button") INPUT_LIST_BUTTON;
}

/**
 * Shadow root type.
 *
 * @link [DOM#ShadowRootType](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-ShadowRootType) type documentation.
 */
enum class ShadowRootType {
    @com.fasterxml.jackson.annotation.JsonProperty("user-agent") USER_AGENT,
    @com.fasterxml.jackson.annotation.JsonProperty("open") OPEN,
    @com.fasterxml.jackson.annotation.JsonProperty("closed") CLOSED;
}

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes.
DOMNode is a base node mirror type.
 *
 * @link [DOM#Node](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-Node) type documentation.
 */

data class Node(
  /**
   * Node identifier that is passed into the rest of the DOM messages as the `nodeId`. Backend
will only push node with given `id` once. It is aware of all requested nodes and will only
fire DOM events for nodes known to the client.
   */
  val nodeId: NodeId,

  /**
   * The id of the parent node if any.
   */
  val parentId: NodeId? = null,

  /**
   * The BackendNodeId for this node.
   */
  val backendNodeId: BackendNodeId,

  /**
   * `Node`'s nodeType.
   */
  val nodeType: Int,

  /**
   * `Node`'s nodeName.
   */
  val nodeName: String,

  /**
   * `Node`'s localName.
   */
  val localName: String,

  /**
   * `Node`'s nodeValue.
   */
  val nodeValue: String,

  /**
   * Child count for `Container` nodes.
   */
  val childNodeCount: Int? = null,

  /**
   * Child nodes of this node when requested with children.
   */
  val children: List<Node>? = null,

  /**
   * Attributes of the `Element` node in the form of flat array `[name1, value1, name2, value2]`.
   */
  val attributes: List<String>? = null,

  /**
   * Document URL that `Document` or `FrameOwner` node points to.
   */
  val documentURL: String? = null,

  /**
   * Base URL that `Document` or `FrameOwner` node uses for URL completion.
   */
  val baseURL: String? = null,

  /**
   * `DocumentType`'s publicId.
   */
  val publicId: String? = null,

  /**
   * `DocumentType`'s systemId.
   */
  val systemId: String? = null,

  /**
   * `DocumentType`'s internalSubset.
   */
  val internalSubset: String? = null,

  /**
   * `Document`'s XML version in case of XML documents.
   */
  val xmlVersion: String? = null,

  /**
   * `Attr`'s name.
   */
  val name: String? = null,

  /**
   * `Attr`'s value.
   */
  val value: String? = null,

  /**
   * Pseudo element type for this node.
   */
  val pseudoType: PseudoType? = null,

  /**
   * Shadow root type.
   */
  val shadowRootType: ShadowRootType? = null,

  /**
   * Frame ID for frame owner elements.
   */
  val frameId: pl.wendigo.chrome.api.page.FrameId? = null,

  /**
   * Content document for frame owner elements.
   */
  val contentDocument: Node? = null,

  /**
   * Shadow root list for given element host.
   */
  val shadowRoots: List<Node>? = null,

  /**
   * Content document fragment for template elements.
   */
  val templateContent: Node? = null,

  /**
   * Pseudo elements associated with this node.
   */
  val pseudoElements: List<Node>? = null,

  /**
   * Import document for the HTMLImport links.
   */
  val importedDocument: Node? = null,

  /**
   * Distributed nodes for given insertion point.
   */
  val distributedNodes: List<BackendNode>? = null,

  /**
   * Whether the node is SVG.
   */
  val isSVG: Boolean? = null
)

/**
 * A structure holding an RGBA color.
 *
 * @link [DOM#RGBA](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-RGBA) type documentation.
 */

data class RGBA(
  /**
   * The red component, in the [0-255] range.
   */
  val r: Int,

  /**
   * The green component, in the [0-255] range.
   */
  val g: Int,

  /**
   * The blue component, in the [0-255] range.
   */
  val b: Int,

  /**
   * The alpha component, in the [0-1] range (default: 1).
   */
  val a: Double? = null
)

/**
 * An array of quad vertices, x immediately followed by y for each point, points clock-wise.
 *
 * @link [DOM#Quad](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-Quad) type documentation.
 */

typealias Quad = List<Double>

/**
 * Box model.
 *
 * @link [DOM#BoxModel](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-BoxModel) type documentation.
 */

data class BoxModel(
  /**
   * Content box
   */
  val content: Quad,

  /**
   * Padding box
   */
  val padding: Quad,

  /**
   * Border box
   */
  val border: Quad,

  /**
   * Margin box
   */
  val margin: Quad,

  /**
   * Node width
   */
  val width: Int,

  /**
   * Node height
   */
  val height: Int,

  /**
   * Shape outside coordinates
   */
  val shapeOutside: ShapeOutsideInfo? = null
)

/**
 * CSS Shape Outside details.
 *
 * @link [DOM#ShapeOutsideInfo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-ShapeOutsideInfo) type documentation.
 */

data class ShapeOutsideInfo(
  /**
   * Shape bounds
   */
  val bounds: Quad,

  /**
   * Shape coordinate details
   */
  val shape: List<Any>,

  /**
   * Margin shape bounds
   */
  val marginShape: List<Any>
)

/**
 * Rectangle.
 *
 * @link [DOM#Rect](https://chromedevtools.github.io/devtools-protocol/tot/DOM#type-Rect) type documentation.
 */

data class Rect(
  /**
   * X coordinate
   */
  val x: Double,

  /**
   * Y coordinate
   */
  val y: Double,

  /**
   * Rectangle width
   */
  val width: Double,

  /**
   * Rectangle height
   */
  val height: Double
)

