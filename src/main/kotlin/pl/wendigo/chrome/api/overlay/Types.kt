package pl.wendigo.chrome.api.overlay

/**
 * Configuration data for the highlighting of Grid elements.
 *
 * @link [Overlay#GridHighlightConfig](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-GridHighlightConfig) type documentation.
 */

data class GridHighlightConfig(
    /**  
     * Whether the extension lines from grid cells to the rulers should be shown (default: false).  
     */  
    val showGridExtensionLines: Boolean? = null,

    /**  
     * Show Positive line number labels (default: false).  
     */  
    val showPositiveLineNumbers: Boolean? = null,

    /**  
     * Show Negative line number labels (default: false).  
     */  
    val showNegativeLineNumbers: Boolean? = null,

    /**  
     * Show area name labels (default: false).  
     */  
    val showAreaNames: Boolean? = null,

    /**  
     * The grid container border highlight color (default: transparent).  
     */  
    val gridBorderColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The cell border color (default: transparent).  
     */  
    val cellBorderColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * Whether the grid border is dashed (default: false).  
     */  
    val gridBorderDash: Boolean? = null,

    /**  
     * Whether the cell border is dashed (default: false).  
     */  
    val cellBorderDash: Boolean? = null,

    /**  
     * The row gap highlight fill color (default: transparent).  
     */  
    val rowGapColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The row gap hatching fill color (default: transparent).  
     */  
    val rowHatchColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The column gap highlight fill color (default: transparent).  
     */  
    val columnGapColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The column gap hatching fill color (default: transparent).  
     */  
    val columnHatchColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The named grid areas border color (Default: transparent).  
     */  
    val areaBorderColor: pl.wendigo.chrome.api.dom.RGBA? = null
)

/**
 * Configuration data for the highlighting of page elements.
 *
 * @link [Overlay#HighlightConfig](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-HighlightConfig) type documentation.
 */

data class HighlightConfig(
    /**  
     * Whether the node info tooltip should be shown (default: false).  
     */  
    val showInfo: Boolean? = null,

    /**  
     * Whether the node styles in the tooltip (default: false).  
     */  
    val showStyles: Boolean? = null,

    /**  
     * Whether the rulers should be shown (default: false).  
     */  
    val showRulers: Boolean? = null,

    /**  
     * Whether the a11y info should be shown (default: true).  
     */  
    val showAccessibilityInfo: Boolean? = null,

    /**  
     * Whether the extension lines from node to the rulers should be shown (default: false).  
     */  
    val showExtensionLines: Boolean? = null,

    /**  
     * The content box highlight fill color (default: transparent).  
     */  
    val contentColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The padding highlight fill color (default: transparent).  
     */  
    val paddingColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The border highlight fill color (default: transparent).  
     */  
    val borderColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The margin highlight fill color (default: transparent).  
     */  
    val marginColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The event target element highlight fill color (default: transparent).  
     */  
    val eventTargetColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The shape outside fill color (default: transparent).  
     */  
    val shapeColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The shape margin fill color (default: transparent).  
     */  
    val shapeMarginColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The grid layout color (default: transparent).  
     */  
    val cssGridColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The color format used to format color styles (default: hex).  
     */  
    val colorFormat: ColorFormat? = null,

    /**  
     * The grid layout highlight configuration (default: all transparent).  
     */  
    val gridHighlightConfig: GridHighlightConfig? = null
)

/**
 *
 *
 * @link [Overlay#ColorFormat](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-ColorFormat) type documentation.
 */
enum class ColorFormat {
    @com.fasterxml.jackson.annotation.JsonProperty("rgb")
    RGB,
    @com.fasterxml.jackson.annotation.JsonProperty("hsl")
    HSL,
    @com.fasterxml.jackson.annotation.JsonProperty("hex")
    HEX;
}

/**
 * Configurations for Persistent Grid Highlight
 *
 * @link [Overlay#GridNodeHighlightConfig](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-GridNodeHighlightConfig) type documentation.
 */

data class GridNodeHighlightConfig(
    /**  
     * A descriptor for the highlight appearance.  
     */  
    val gridHighlightConfig: GridHighlightConfig,

    /**  
     * Identifier of the node to highlight.  
     */  
    val nodeId: pl.wendigo.chrome.api.dom.NodeId
)

/**
 * Configuration for dual screen hinge
 *
 * @link [Overlay#HingeConfig](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-HingeConfig) type documentation.
 */

data class HingeConfig(
    /**  
     * A rectangle represent hinge  
     */  
    val rect: pl.wendigo.chrome.api.dom.Rect,

    /**  
     * The content box highlight fill color (default: a dark color).  
     */  
    val contentColor: pl.wendigo.chrome.api.dom.RGBA? = null,

    /**  
     * The content box highlight outline color (default: transparent).  
     */  
    val outlineColor: pl.wendigo.chrome.api.dom.RGBA? = null
)

/**
 *
 *
 * @link [Overlay#InspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-InspectMode) type documentation.
 */
enum class InspectMode {
    @com.fasterxml.jackson.annotation.JsonProperty("searchForNode")
    SEARCHFORNODE,
    @com.fasterxml.jackson.annotation.JsonProperty("searchForUAShadowDOM")
    SEARCHFORUASHADOWDOM,
    @com.fasterxml.jackson.annotation.JsonProperty("captureAreaScreenshot")
    CAPTUREAREASCREENSHOT,
    @com.fasterxml.jackson.annotation.JsonProperty("showDistances")
    SHOWDISTANCES,
    @com.fasterxml.jackson.annotation.JsonProperty("none")
    NONE;
}
