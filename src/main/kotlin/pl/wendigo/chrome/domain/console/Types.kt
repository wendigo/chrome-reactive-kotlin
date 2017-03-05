package pl.wendigo.chrome.domain.console

/*
 * Console message.
 */




data class ConsoleMessage(
  /**
   * Message source.
   */
  val source : String,

  /**
   * Message severity.
   */
  val level : String,

  /**
   * Message text.
   */
  val text : String,

  /**
   * URL of the message origin.
   */
  val url : String? = null,

  /**
   * Line number in the resource that generated this message (1-based).
   */
  val line : Int? = null,

  /**
   * Column number in the resource that generated this message (1-based).
   */
  val column : Int? = null

)

