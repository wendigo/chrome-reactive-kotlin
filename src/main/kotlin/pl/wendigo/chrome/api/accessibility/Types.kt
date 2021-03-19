package pl.wendigo.chrome.api.accessibility

/**
 * Unique accessibility node identifier.
 *
 * @link [Accessibility#AXNodeId](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXNodeId) type documentation.
 */

typealias AXNodeId = String

/**
 * Enum of possible property types.
 *
 * @link [Accessibility#AXValueType](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXValueType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class AXValueType {
    @kotlinx.serialization.SerialName("boolean")
    BOOLEAN,

    @kotlinx.serialization.SerialName("tristate")
    TRISTATE,

    @kotlinx.serialization.SerialName("booleanOrUndefined")
    BOOLEANORUNDEFINED,

    @kotlinx.serialization.SerialName("idref")
    IDREF,

    @kotlinx.serialization.SerialName("idrefList")
    IDREFLIST,

    @kotlinx.serialization.SerialName("integer")
    INTEGER,

    @kotlinx.serialization.SerialName("node")
    NODE,

    @kotlinx.serialization.SerialName("nodeList")
    NODELIST,

    @kotlinx.serialization.SerialName("number")
    NUMBER,

    @kotlinx.serialization.SerialName("string")
    STRING,

    @kotlinx.serialization.SerialName("computedString")
    COMPUTEDSTRING,

    @kotlinx.serialization.SerialName("token")
    TOKEN,

    @kotlinx.serialization.SerialName("tokenList")
    TOKENLIST,

    @kotlinx.serialization.SerialName("domRelation")
    DOMRELATION,

    @kotlinx.serialization.SerialName("role")
    ROLE,

    @kotlinx.serialization.SerialName("internalRole")
    INTERNALROLE,

    @kotlinx.serialization.SerialName("valueUndefined")
    VALUEUNDEFINED;
}

/**
 * Enum of possible property sources.
 *
 * @link [Accessibility#AXValueSourceType](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXValueSourceType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class AXValueSourceType {
    @kotlinx.serialization.SerialName("attribute")
    ATTRIBUTE,

    @kotlinx.serialization.SerialName("implicit")
    IMPLICIT,

    @kotlinx.serialization.SerialName("style")
    STYLE,

    @kotlinx.serialization.SerialName("contents")
    CONTENTS,

    @kotlinx.serialization.SerialName("placeholder")
    PLACEHOLDER,

    @kotlinx.serialization.SerialName("relatedElement")
    RELATEDELEMENT;
}

/**
 * Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
 *
 * @link [Accessibility#AXValueNativeSourceType](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXValueNativeSourceType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class AXValueNativeSourceType {
    @kotlinx.serialization.SerialName("figcaption")
    FIGCAPTION,

    @kotlinx.serialization.SerialName("label")
    LABEL,

    @kotlinx.serialization.SerialName("labelfor")
    LABELFOR,

    @kotlinx.serialization.SerialName("labelwrapped")
    LABELWRAPPED,

    @kotlinx.serialization.SerialName("legend")
    LEGEND,

    @kotlinx.serialization.SerialName("rubyannotation")
    RUBYANNOTATION,

    @kotlinx.serialization.SerialName("tablecaption")
    TABLECAPTION,

    @kotlinx.serialization.SerialName("title")
    TITLE,

    @kotlinx.serialization.SerialName("other")
    OTHER;
}

/**
 * A single source for a computed AX property.
 *
 * @link [Accessibility#AXValueSource](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXValueSource) type documentation.
 */

@kotlinx.serialization.Serializable
data class AXValueSource(
    /**  
     * What type of source this is.  
     */  
    val type: AXValueSourceType,

    /**  
     * The value of this property source.  
     */  
    val value: AXValue? = null,

    /**  
     * The name of the relevant attribute, if any.  
     */  
    val attribute: String? = null,

    /**  
     * The value of the relevant attribute, if any.  
     */  
    val attributeValue: AXValue? = null,

    /**  
     * Whether this source is superseded by a higher priority source.  
     */  
    val superseded: Boolean? = null,

    /**  
     * The native markup source for this value, e.g. a <label> element.  
     */  
    val nativeSource: AXValueNativeSourceType? = null,

    /**  
     * The value, such as a node or node list, of the native source.  
     */  
    val nativeSourceValue: AXValue? = null,

    /**  
     * Whether the value for this property is invalid.  
     */  
    val invalid: Boolean? = null,

    /**  
     * Reason for the value being invalid, if it is.  
     */  
    val invalidReason: String? = null
)

/**
 *
 *
 * @link [Accessibility#AXRelatedNode](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXRelatedNode) type documentation.
 */

@kotlinx.serialization.Serializable
data class AXRelatedNode(
    /**  
     * The BackendNodeId of the related DOM node.  
     */  
    val backendDOMNodeId: pl.wendigo.chrome.api.dom.BackendNodeId,

    /**  
     * The IDRef value provided, if any.  
     */  
    val idref: String? = null,

    /**  
     * The text alternative of this node in the current context.  
     */  
    val text: String? = null
)

/**
 *
 *
 * @link [Accessibility#AXProperty](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXProperty) type documentation.
 */

@kotlinx.serialization.Serializable
data class AXProperty(
    /**  
     * The name of this property.  
     */  
    val name: AXPropertyName,

    /**  
     * The value of this property.  
     */  
    val value: AXValue
)

/**
 * A single computed AX property.
 *
 * @link [Accessibility#AXValue](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXValue) type documentation.
 */

@kotlinx.serialization.Serializable
data class AXValue(
    /**  
     * The type of this value.  
     */  
    val type: AXValueType,

    /**  
     * The computed value of this property.  
     */  
    val value: kotlinx.serialization.json.JsonElement? = null,

    /**  
     * One or more related nodes, if applicable.  
     */  
    val relatedNodes: List<AXRelatedNode>? = null,

    /**  
     * The sources which contributed to the computation of this property.  
     */  
    val sources: List<AXValueSource>? = null
)

/**
 * Values of AXProperty name:
- from &apos;busy&apos; to &apos;roledescription&apos;: states which apply to every AX node
- from &apos;live&apos; to &apos;root&apos;: attributes which apply to nodes in live regions
- from &apos;autocomplete&apos; to &apos;valuetext&apos;: attributes which apply to widgets
- from &apos;checked&apos; to &apos;selected&apos;: states which apply to widgets
- from &apos;activedescendant&apos; to &apos;owns&apos; - relationships between elements other than parent/child/sibling.
 *
 * @link [Accessibility#AXPropertyName](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXPropertyName) type documentation.
 */
@kotlinx.serialization.Serializable
enum class AXPropertyName {
    @kotlinx.serialization.SerialName("busy")
    BUSY,

    @kotlinx.serialization.SerialName("disabled")
    DISABLED,

    @kotlinx.serialization.SerialName("editable")
    EDITABLE,

    @kotlinx.serialization.SerialName("focusable")
    FOCUSABLE,

    @kotlinx.serialization.SerialName("focused")
    FOCUSED,

    @kotlinx.serialization.SerialName("hidden")
    HIDDEN,

    @kotlinx.serialization.SerialName("hiddenRoot")
    HIDDENROOT,

    @kotlinx.serialization.SerialName("invalid")
    INVALID,

    @kotlinx.serialization.SerialName("keyshortcuts")
    KEYSHORTCUTS,

    @kotlinx.serialization.SerialName("settable")
    SETTABLE,

    @kotlinx.serialization.SerialName("roledescription")
    ROLEDESCRIPTION,

    @kotlinx.serialization.SerialName("live")
    LIVE,

    @kotlinx.serialization.SerialName("atomic")
    ATOMIC,

    @kotlinx.serialization.SerialName("relevant")
    RELEVANT,

    @kotlinx.serialization.SerialName("root")
    ROOT,

    @kotlinx.serialization.SerialName("autocomplete")
    AUTOCOMPLETE,

    @kotlinx.serialization.SerialName("hasPopup")
    HASPOPUP,

    @kotlinx.serialization.SerialName("level")
    LEVEL,

    @kotlinx.serialization.SerialName("multiselectable")
    MULTISELECTABLE,

    @kotlinx.serialization.SerialName("orientation")
    ORIENTATION,

    @kotlinx.serialization.SerialName("multiline")
    MULTILINE,

    @kotlinx.serialization.SerialName("readonly")
    READONLY,

    @kotlinx.serialization.SerialName("required")
    REQUIRED,

    @kotlinx.serialization.SerialName("valuemin")
    VALUEMIN,

    @kotlinx.serialization.SerialName("valuemax")
    VALUEMAX,

    @kotlinx.serialization.SerialName("valuetext")
    VALUETEXT,

    @kotlinx.serialization.SerialName("checked")
    CHECKED,

    @kotlinx.serialization.SerialName("expanded")
    EXPANDED,

    @kotlinx.serialization.SerialName("modal")
    MODAL,

    @kotlinx.serialization.SerialName("pressed")
    PRESSED,

    @kotlinx.serialization.SerialName("selected")
    SELECTED,

    @kotlinx.serialization.SerialName("activedescendant")
    ACTIVEDESCENDANT,

    @kotlinx.serialization.SerialName("controls")
    CONTROLS,

    @kotlinx.serialization.SerialName("describedby")
    DESCRIBEDBY,

    @kotlinx.serialization.SerialName("details")
    DETAILS,

    @kotlinx.serialization.SerialName("errormessage")
    ERRORMESSAGE,

    @kotlinx.serialization.SerialName("flowto")
    FLOWTO,

    @kotlinx.serialization.SerialName("labelledby")
    LABELLEDBY,

    @kotlinx.serialization.SerialName("owns")
    OWNS;
}

/**
 * A node in the accessibility tree.
 *
 * @link [Accessibility#AXNode](https://chromedevtools.github.io/devtools-protocol/tot/Accessibility#type-AXNode) type documentation.
 */

@kotlinx.serialization.Serializable
data class AXNode(
    /**  
     * Unique identifier for this node.  
     */  
    val nodeId: AXNodeId,

    /**  
     * Whether this node is ignored for accessibility  
     */  
    val ignored: Boolean,

    /**  
     * Collection of reasons why this node is hidden.  
     */  
    val ignoredReasons: List<AXProperty>? = null,

    /**  
     * This `Node`'s role, whether explicit or implicit.  
     */  
    val role: AXValue? = null,

    /**  
     * The accessible name for this `Node`.  
     */  
    val name: AXValue? = null,

    /**  
     * The accessible description for this `Node`.  
     */  
    val description: AXValue? = null,

    /**  
     * The value for this `Node`.  
     */  
    val value: AXValue? = null,

    /**  
     * All other properties  
     */  
    val properties: List<AXProperty>? = null,

    /**  
     * IDs for each of this node's child nodes.  
     */  
    val childIds: List<AXNodeId>? = null,

    /**  
     * The backend ID for the associated DOM node, if any.  
     */  
    val backendDOMNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null
)
