package pl.wendigo.chrome.domain.log

/**
 * Log entry.
 */
data class LogEntry(
  /**
   * Log entry source.
   */
  val source : String,

  /**
   * Log entry severity.
   */
  val level : String,

  /**
   * Logged text.
   */
  val text : String,

  /**
   * Timestamp when this entry was added.
   */
  val timestamp : pl.wendigo.chrome.domain.runtime.Timestamp,

  /**
   * URL of the resource if known.
   */
  val url : String? = null,

  /**
   * Line number in the resource.
   */
  val lineNumber : Int? = null,

  /**
   * JavaScript stack trace.
   */
  val stackTrace : pl.wendigo.chrome.domain.runtime.StackTrace? = null,

  /**
   * Identifier of the network request associated with this entry.
   */
  val networkRequestId : pl.wendigo.chrome.domain.network.RequestId? = null,

  /**
   * Identifier of the worker associated with this entry.
   */
  val workerId : String? = null
)

/**
 * Violation configuration setting.
 */
data class ViolationSetting(
  /**
   * Violation type.
   */
  val name : String,

  /**
   * Time threshold to trigger upon.
   */
  val threshold : Double
)

