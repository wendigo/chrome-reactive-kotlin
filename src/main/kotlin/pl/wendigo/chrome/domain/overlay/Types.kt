package pl.wendigo.chrome.domain.overlay

/**
 * Configuration data for the highlighting of page elements.
 */

data class HighlightConfig(
  /**
   * Whether the node info tooltip should be shown (default: false).
   */
  val showInfo : Boolean? = null,

  /**
   * Whether the rulers should be shown (default: false).
   */
  val showRulers : Boolean? = null,

  /**
   * Whether the extension lines from node to the rulers should be shown (default: false).
   */
  val showExtensionLines : Boolean? = null,

  /**
   *
   */
  val displayAsMaterial : Boolean? = null,

  /**
   * The content box highlight fill color (default: transparent).
   */
  val contentColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * The padding highlight fill color (default: transparent).
   */
  val paddingColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * The border highlight fill color (default: transparent).
   */
  val borderColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * The margin highlight fill color (default: transparent).
   */
  val marginColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * The event target element highlight fill color (default: transparent).
   */
  val eventTargetColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * The shape outside fill color (default: transparent).
   */
  val shapeColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * The shape margin fill color (default: transparent).
   */
  val shapeMarginColor : pl.wendigo.chrome.domain.dom.RGBA? = null,

  /**
   * Selectors to highlight relevant nodes.
   */
  val selectorList : String? = null,

  /**
   * The grid layout color (default: transparent).
   */
  val cssGridColor : pl.wendigo.chrome.domain.dom.RGBA? = null
)

/**
 *
 */
enum class InspectMode {
    @com.fasterxml.jackson.annotation.JsonProperty("searchForNode") SEARCHFORNODE,
    @com.fasterxml.jackson.annotation.JsonProperty("searchForUAShadowDOM") SEARCHFORUASHADOWDOM,
    @com.fasterxml.jackson.annotation.JsonProperty("none") NONE;
}

