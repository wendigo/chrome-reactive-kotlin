package pl.wendigo.chrome.domain.accessibility

/**
 * Unique accessibility node identifier.
 */
typealias AXNodeId = String

/**
 * Enum of possible property types.
 */
typealias AXValueType = String

/**
 * Enum of possible property sources.
 */
typealias AXValueSourceType = String

/**
 * Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
 */
typealias AXValueNativeSourceType = String

/**
 * A single source for a computed AX property.
 */
data class AXValueSource(
  /**
   * What type of source this is.
   */
  val type : AXValueSourceType,

  /**
   * The value of this property source.
   */
  val value : AXValue? = null,

  /**
   * The name of the relevant attribute, if any.
   */
  val attribute : String? = null,

  /**
   * The value of the relevant attribute, if any.
   */
  val attributeValue : AXValue? = null,

  /**
   * Whether this source is superseded by a higher priority source.
   */
  val superseded : Boolean? = null,

  /**
   * The native markup source for this value, e.g. a <label> element.
   */
  val nativeSource : AXValueNativeSourceType? = null,

  /**
   * The value, such as a node or node list, of the native source.
   */
  val nativeSourceValue : AXValue? = null,

  /**
   * Whether the value for this property is invalid.
   */
  val invalid : Boolean? = null,

  /**
   * Reason for the value being invalid, if it is.
   */
  val invalidReason : String? = null
)

/**
 * 
 */
data class AXRelatedNode(
  /**
   * The BackendNodeId of the related DOM node.
   */
  val backendDOMNodeId : pl.wendigo.chrome.domain.dom.BackendNodeId,

  /**
   * The IDRef value provided, if any.
   */
  val idref : String? = null,

  /**
   * The text alternative of this node in the current context.
   */
  val text : String? = null
)

/**
 * 
 */
data class AXProperty(
  /**
   * The name of this property.
   */
  val name : String,

  /**
   * The value of this property.
   */
  val value : AXValue
)

/**
 * A single computed AX property.
 */
data class AXValue(
  /**
   * The type of this value.
   */
  val type : AXValueType,

  /**
   * The computed value of this property.
   */
  val value : Any? = null,

  /**
   * One or more related nodes, if applicable.
   */
  val relatedNodes : Array<AXRelatedNode>? = null,

  /**
   * The sources which contributed to the computation of this property.
   */
  val sources : Array<AXValueSource>? = null
)

/**
 * States which apply to every AX node.
 */
typealias AXGlobalStates = String

/**
 * Attributes which apply to nodes in live regions.
 */
typealias AXLiveRegionAttributes = String

/**
 * Attributes which apply to widgets.
 */
typealias AXWidgetAttributes = String

/**
 * States which apply to widgets.
 */
typealias AXWidgetStates = String

/**
 * Relationships between elements other than parent/child/sibling.
 */
typealias AXRelationshipAttributes = String

/**
 * A node in the accessibility tree.
 */
data class AXNode(
  /**
   * Unique identifier for this node.
   */
  val nodeId : AXNodeId,

  /**
   * Whether this node is ignored for accessibility
   */
  val ignored : Boolean,

  /**
   * Collection of reasons why this node is hidden.
   */
  val ignoredReasons : Array<AXProperty>? = null,

  /**
   * This <code>Node</code>'s role, whether explicit or implicit.
   */
  val role : AXValue? = null,

  /**
   * The accessible name for this <code>Node</code>.
   */
  val name : AXValue? = null,

  /**
   * The accessible description for this <code>Node</code>.
   */
  val description : AXValue? = null,

  /**
   * The value for this <code>Node</code>.
   */
  val value : AXValue? = null,

  /**
   * All other properties
   */
  val properties : Array<AXProperty>? = null,

  /**
   * IDs for each of this node's child nodes.
   */
  val childIds : Array<AXNodeId>? = null,

  /**
   * The backend ID for the associated DOM node, if any.
   */
  val backendDOMNodeId : pl.wendigo.chrome.domain.dom.BackendNodeId? = null
)

