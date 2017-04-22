package pl.wendigo.chrome.domain.dom

/**
 * Unique DOM node identifier.
 */

typealias NodeId = Int

/**
 * Unique DOM node identifier used to reference a node that may not have been pushed to the front-end.
 */

typealias BackendNodeId = Int

/**
 * Backend node with a friendly name.
 */

data class BackendNode(
  /**
   * <code>Node</code>'s nodeType.
   */
  val nodeType : Int,

  /**
   * <code>Node</code>'s nodeName.
   */
  val nodeName : String,

  /**
   * 
   */
  val backendNodeId : BackendNodeId
)

/**
 * Pseudo element type.
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
 */
enum class ShadowRootType {
    @com.fasterxml.jackson.annotation.JsonProperty("user-agent") USER_AGENT,
    @com.fasterxml.jackson.annotation.JsonProperty("open") OPEN,
    @com.fasterxml.jackson.annotation.JsonProperty("closed") CLOSED;
}

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes. DOMNode is a base node mirror type.
 */

data class Node(
  /**
   * Node identifier that is passed into the rest of the DOM messages as the <code>nodeId</code>. Backend will only push node with given <code>id</code> once. It is aware of all requested nodes and will only fire DOM events for nodes known to the client.
   */
  val nodeId : NodeId,

  /**
   * The id of the parent node if any.
   */
  @pl.wendigo.chrome.Experimental val parentId : NodeId? = null,

  /**
   * The BackendNodeId for this node.
   */
  @pl.wendigo.chrome.Experimental val backendNodeId : BackendNodeId,

  /**
   * <code>Node</code>'s nodeType.
   */
  val nodeType : Int,

  /**
   * <code>Node</code>'s nodeName.
   */
  val nodeName : String,

  /**
   * <code>Node</code>'s localName.
   */
  val localName : String,

  /**
   * <code>Node</code>'s nodeValue.
   */
  val nodeValue : String,

  /**
   * Child count for <code>Container</code> nodes.
   */
  val childNodeCount : Int? = null,

  /**
   * Child nodes of this node when requested with children.
   */
  val children : Array<Node>? = null,

  /**
   * Attributes of the <code>Element</code> node in the form of flat array <code>[name1, value1, name2, value2]</code>.
   */
  val attributes : Array<String>? = null,

  /**
   * Document URL that <code>Document</code> or <code>FrameOwner</code> node points to.
   */
  val documentURL : String? = null,

  /**
   * Base URL that <code>Document</code> or <code>FrameOwner</code> node uses for URL completion.
   */
  @pl.wendigo.chrome.Experimental val baseURL : String? = null,

  /**
   * <code>DocumentType</code>'s publicId.
   */
  val publicId : String? = null,

  /**
   * <code>DocumentType</code>'s systemId.
   */
  val systemId : String? = null,

  /**
   * <code>DocumentType</code>'s internalSubset.
   */
  val internalSubset : String? = null,

  /**
   * <code>Document</code>'s XML version in case of XML documents.
   */
  val xmlVersion : String? = null,

  /**
   * <code>Attr</code>'s name.
   */
  val name : String? = null,

  /**
   * <code>Attr</code>'s value.
   */
  val value : String? = null,

  /**
   * Pseudo element type for this node.
   */
  val pseudoType : PseudoType? = null,

  /**
   * Shadow root type.
   */
  val shadowRootType : ShadowRootType? = null,

  /**
   * Frame ID for frame owner elements.
   */
  @pl.wendigo.chrome.Experimental val frameId : pl.wendigo.chrome.domain.page.FrameId? = null,

  /**
   * Content document for frame owner elements.
   */
  val contentDocument : Node? = null,

  /**
   * Shadow root list for given element host.
   */
  @pl.wendigo.chrome.Experimental val shadowRoots : Array<Node>? = null,

  /**
   * Content document fragment for template elements.
   */
  @pl.wendigo.chrome.Experimental val templateContent : Node? = null,

  /**
   * Pseudo elements associated with this node.
   */
  @pl.wendigo.chrome.Experimental val pseudoElements : Array<Node>? = null,

  /**
   * Import document for the HTMLImport links.
   */
  val importedDocument : Node? = null,

  /**
   * Distributed nodes for given insertion point.
   */
  @pl.wendigo.chrome.Experimental val distributedNodes : Array<BackendNode>? = null,

  /**
   * Whether the node is SVG.
   */
  @pl.wendigo.chrome.Experimental val isSVG : Boolean? = null
)

/**
 * A structure holding an RGBA color.
 */

data class RGBA(
  /**
   * The red component, in the [0-255] range.
   */
  val r : Int,

  /**
   * The green component, in the [0-255] range.
   */
  val g : Int,

  /**
   * The blue component, in the [0-255] range.
   */
  val b : Int,

  /**
   * The alpha component, in the [0-1] range (default: 1).
   */
  val a : Double? = null
)

/**
 * An array of quad vertices, x immediately followed by y for each point, points clock-wise.
 */

typealias Quad = Array<Double>

/**
 * Box model.
 */

data class BoxModel(
  /**
   * Content box
   */
  val content : Quad,

  /**
   * Padding box
   */
  val padding : Quad,

  /**
   * Border box
   */
  val border : Quad,

  /**
   * Margin box
   */
  val margin : Quad,

  /**
   * Node width
   */
  val width : Int,

  /**
   * Node height
   */
  val height : Int,

  /**
   * Shape outside coordinates
   */
  val shapeOutside : ShapeOutsideInfo? = null
)

/**
 * CSS Shape Outside details.
 */

data class ShapeOutsideInfo(
  /**
   * Shape bounds
   */
  val bounds : Quad,

  /**
   * Shape coordinate details
   */
  val shape : Array<Any>,

  /**
   * Margin shape bounds
   */
  val marginShape : Array<Any>
)

/**
 * Rectangle.
 */

data class Rect(
  /**
   * X coordinate
   */
  val x : Double,

  /**
   * Y coordinate
   */
  val y : Double,

  /**
   * Rectangle width
   */
  val width : Double,

  /**
   * Rectangle height
   */
  val height : Double
)

