package pl.wendigo.chrome.api.console

/**
 * Console message.
 *
 * @link [Console#ConsoleMessage](https://chromedevtools.github.io/devtools-protocol/tot/Console#type-ConsoleMessage) type documentation.
 */

data class ConsoleMessage(
  /**
   * Message source.
   */
  val source: String,

  /**
   * Message severity.
   */
  val level: String,

  /**
   * Message text.
   */
  val text: String,

  /**
   * URL of the message origin.
   */
  val url: String? = null,

  /**
   * Line number in the resource that generated this message (1-based).
   */
  val line: Int? = null,

  /**
   * Column number in the resource that generated this message (1-based).
   */
  val column: Int? = null
)

