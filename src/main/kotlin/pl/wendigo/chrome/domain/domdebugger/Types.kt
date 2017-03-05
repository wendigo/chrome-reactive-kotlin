package pl.wendigo.chrome.domain.domdebugger

/*
 * DOM breakpoint type.
 */
typealias DOMBreakpointType = String





/*
 * Object event listener.
 */




data class EventListener(
  /**
   * <code>EventListener</code>'s type.
   */
  val type : String,

  /**
   * <code>EventListener</code>'s useCapture.
   */
  val useCapture : Boolean,

  /**
   * <code>EventListener</code>'s passive flag.
   */
  val passive : Boolean,

  /**
   * <code>EventListener</code>'s once flag.
   */
  val once : Boolean,

  /**
   * Script id of the handler code.
   */
  val scriptId : pl.wendigo.chrome.domain.runtime.ScriptId,

  /**
   * Line number in the script (0-based).
   */
  val lineNumber : Int,

  /**
   * Column number in the script (0-based).
   */
  val columnNumber : Int,

  /**
   * Event handler function value.
   */
  val handler : pl.wendigo.chrome.domain.runtime.RemoteObject? = null,

  /**
   * Event original handler function value.
   */
  val originalHandler : pl.wendigo.chrome.domain.runtime.RemoteObject? = null,

  /**
   * Event listener remove function.
   */
  val removeFunction : pl.wendigo.chrome.domain.runtime.RemoteObject? = null

)

