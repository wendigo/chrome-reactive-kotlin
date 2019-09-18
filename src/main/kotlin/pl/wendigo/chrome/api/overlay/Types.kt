package pl.wendigo.chrome.api.overlay

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
  val cssGridColor: pl.wendigo.chrome.api.dom.RGBA? = null
)

/**
 *
 *
 * @link [Overlay#InspectMode](https://chromedevtools.github.io/devtools-protocol/tot/Overlay#type-InspectMode) type documentation.
 */
enum class InspectMode {
    @com.fasterxml.jackson.annotation.JsonProperty("searchForNode") SEARCHFORNODE,
    @com.fasterxml.jackson.annotation.JsonProperty("searchForUAShadowDOM") SEARCHFORUASHADOWDOM,
    @com.fasterxml.jackson.annotation.JsonProperty("captureAreaScreenshot") CAPTUREAREASCREENSHOT,
    @com.fasterxml.jackson.annotation.JsonProperty("showDistances") SHOWDISTANCES,
    @com.fasterxml.jackson.annotation.JsonProperty("none") NONE;
}

