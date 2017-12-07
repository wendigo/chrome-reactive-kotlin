package pl.wendigo.chrome.domain.accessibility

/**
 * Unique accessibility node identifier.
 */

typealias AXNodeId = String

/**
 * Enum of possible property types.
 */
enum class AXValueType {
    @com.fasterxml.jackson.annotation.JsonProperty("boolean") BOOLEAN,
    @com.fasterxml.jackson.annotation.JsonProperty("tristate") TRISTATE,
    @com.fasterxml.jackson.annotation.JsonProperty("booleanOrUndefined") BOOLEANORUNDEFINED,
    @com.fasterxml.jackson.annotation.JsonProperty("idref") IDREF,
    @com.fasterxml.jackson.annotation.JsonProperty("idrefList") IDREFLIST,
    @com.fasterxml.jackson.annotation.JsonProperty("integer") INTEGER,
    @com.fasterxml.jackson.annotation.JsonProperty("node") NODE,
    @com.fasterxml.jackson.annotation.JsonProperty("nodeList") NODELIST,
    @com.fasterxml.jackson.annotation.JsonProperty("number") NUMBER,
    @com.fasterxml.jackson.annotation.JsonProperty("string") STRING,
    @com.fasterxml.jackson.annotation.JsonProperty("computedString") COMPUTEDSTRING,
    @com.fasterxml.jackson.annotation.JsonProperty("token") TOKEN,
    @com.fasterxml.jackson.annotation.JsonProperty("tokenList") TOKENLIST,
    @com.fasterxml.jackson.annotation.JsonProperty("domRelation") DOMRELATION,
    @com.fasterxml.jackson.annotation.JsonProperty("role") ROLE,
    @com.fasterxml.jackson.annotation.JsonProperty("internalRole") INTERNALROLE,
    @com.fasterxml.jackson.annotation.JsonProperty("valueUndefined") VALUEUNDEFINED;
}

/**
 * Enum of possible property sources.
 */
enum class AXValueSourceType {
    @com.fasterxml.jackson.annotation.JsonProperty("attribute") ATTRIBUTE,
    @com.fasterxml.jackson.annotation.JsonProperty("implicit") IMPLICIT,
    @com.fasterxml.jackson.annotation.JsonProperty("style") STYLE,
    @com.fasterxml.jackson.annotation.JsonProperty("contents") CONTENTS,
    @com.fasterxml.jackson.annotation.JsonProperty("placeholder") PLACEHOLDER,
    @com.fasterxml.jackson.annotation.JsonProperty("relatedElement") RELATEDELEMENT;
}

/**
 * Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
 */
enum class AXValueNativeSourceType {
    @com.fasterxml.jackson.annotation.JsonProperty("figcaption") FIGCAPTION,
    @com.fasterxml.jackson.annotation.JsonProperty("label") LABEL,
    @com.fasterxml.jackson.annotation.JsonProperty("labelfor") LABELFOR,
    @com.fasterxml.jackson.annotation.JsonProperty("labelwrapped") LABELWRAPPED,
    @com.fasterxml.jackson.annotation.JsonProperty("legend") LEGEND,
    @com.fasterxml.jackson.annotation.JsonProperty("tablecaption") TABLECAPTION,
    @com.fasterxml.jackson.annotation.JsonProperty("title") TITLE,
    @com.fasterxml.jackson.annotation.JsonProperty("other") OTHER;
}

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
  val name : AXPropertyName,

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
  val relatedNodes : List<AXRelatedNode>? = null,

  /**
   * The sources which contributed to the computation of this property.
   */
  val sources : List<AXValueSource>? = null
)

/**
 * Values of AXProperty name: from &apos;busy&apos; to &apos;roledescription&apos; - states which apply to every AX
node, from &apos;live&apos; to &apos;root&apos; - attributes which apply to nodes in live regions, from
&apos;autocomplete&apos; to &apos;valuetext&apos; - attributes which apply to widgets, from &apos;checked&apos; to &apos;selected&apos;
- states which apply to widgets, from &apos;activedescendant&apos; to &apos;owns&apos; - relationships between
elements other than parent/child/sibling.
 */
enum class AXPropertyName {
    @com.fasterxml.jackson.annotation.JsonProperty("busy") BUSY,
    @com.fasterxml.jackson.annotation.JsonProperty("disabled") DISABLED,
    @com.fasterxml.jackson.annotation.JsonProperty("hidden") HIDDEN,
    @com.fasterxml.jackson.annotation.JsonProperty("hiddenRoot") HIDDENROOT,
    @com.fasterxml.jackson.annotation.JsonProperty("invalid") INVALID,
    @com.fasterxml.jackson.annotation.JsonProperty("keyshortcuts") KEYSHORTCUTS,
    @com.fasterxml.jackson.annotation.JsonProperty("roledescription") ROLEDESCRIPTION,
    @com.fasterxml.jackson.annotation.JsonProperty("live") LIVE,
    @com.fasterxml.jackson.annotation.JsonProperty("atomic") ATOMIC,
    @com.fasterxml.jackson.annotation.JsonProperty("relevant") RELEVANT,
    @com.fasterxml.jackson.annotation.JsonProperty("root") ROOT,
    @com.fasterxml.jackson.annotation.JsonProperty("autocomplete") AUTOCOMPLETE,
    @com.fasterxml.jackson.annotation.JsonProperty("haspopup") HASPOPUP,
    @com.fasterxml.jackson.annotation.JsonProperty("level") LEVEL,
    @com.fasterxml.jackson.annotation.JsonProperty("multiselectable") MULTISELECTABLE,
    @com.fasterxml.jackson.annotation.JsonProperty("orientation") ORIENTATION,
    @com.fasterxml.jackson.annotation.JsonProperty("multiline") MULTILINE,
    @com.fasterxml.jackson.annotation.JsonProperty("readonly") READONLY,
    @com.fasterxml.jackson.annotation.JsonProperty("required") REQUIRED,
    @com.fasterxml.jackson.annotation.JsonProperty("valuemin") VALUEMIN,
    @com.fasterxml.jackson.annotation.JsonProperty("valuemax") VALUEMAX,
    @com.fasterxml.jackson.annotation.JsonProperty("valuetext") VALUETEXT,
    @com.fasterxml.jackson.annotation.JsonProperty("checked") CHECKED,
    @com.fasterxml.jackson.annotation.JsonProperty("expanded") EXPANDED,
    @com.fasterxml.jackson.annotation.JsonProperty("modal") MODAL,
    @com.fasterxml.jackson.annotation.JsonProperty("pressed") PRESSED,
    @com.fasterxml.jackson.annotation.JsonProperty("selected") SELECTED,
    @com.fasterxml.jackson.annotation.JsonProperty("activedescendant") ACTIVEDESCENDANT,
    @com.fasterxml.jackson.annotation.JsonProperty("controls") CONTROLS,
    @com.fasterxml.jackson.annotation.JsonProperty("describedby") DESCRIBEDBY,
    @com.fasterxml.jackson.annotation.JsonProperty("details") DETAILS,
    @com.fasterxml.jackson.annotation.JsonProperty("errormessage") ERRORMESSAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("flowto") FLOWTO,
    @com.fasterxml.jackson.annotation.JsonProperty("labelledby") LABELLEDBY,
    @com.fasterxml.jackson.annotation.JsonProperty("owns") OWNS;
}

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
  val ignoredReasons : List<AXProperty>? = null,

  /**
   * This `Node`'s role, whether explicit or implicit.
   */
  val role : AXValue? = null,

  /**
   * The accessible name for this `Node`.
   */
  val name : AXValue? = null,

  /**
   * The accessible description for this `Node`.
   */
  val description : AXValue? = null,

  /**
   * The value for this `Node`.
   */
  val value : AXValue? = null,

  /**
   * All other properties
   */
  val properties : List<AXProperty>? = null,

  /**
   * IDs for each of this node's child nodes.
   */
  val childIds : List<AXNodeId>? = null,

  /**
   * The backend ID for the associated DOM node, if any.
   */
  val backendDOMNodeId : pl.wendigo.chrome.domain.dom.BackendNodeId? = null
)

