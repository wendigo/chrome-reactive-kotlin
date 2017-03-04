package pl.wendigo.chrome.domain.debugger

/*
 * Breakpoint identifier.
 */
typealias BreakpointId = String

/*
 * Call frame identifier.
 */
typealias CallFrameId = String

/*
 * Location in the source code.
 */

data class Location(
  /**
   * Script identifier as reported in the <code>Debugger.scriptParsed</code>.
   */
  val scriptId : pl.wendigo.chrome.domain.runtime.ScriptId,

  /**
   * Line number in the script (0-based).
   */
  val lineNumber : Int,

  /**
   * Column number in the script (0-based).
   */
  val columnNumber : Int? = null

)

/*
 * Location in the source code.
 */

data class ScriptPosition(
  /**
   *
   */
  val lineNumber : Int,

  /**
   *
   */
  val columnNumber : Int

)

/*
 * JavaScript call frame. Array of call frames form the call stack.
 */

data class CallFrame(
  /**
   * Call frame identifier. This identifier is only valid while the virtual machine is paused.
   */
  val callFrameId : CallFrameId,

  /**
   * Name of the JavaScript function called on this call frame.
   */
  val functionName : String,

  /**
   * Location in the source code.
   */
  @pl.wendigo.chrome.ProtocolExperimental val functionLocation : Location? = null,

  /**
   * Location in the source code.
   */
  val location : Location,

  /**
   * Scope chain for this call frame.
   */
  val scopeChain : Array<Scope>,

  /**
   * <code>this</code> object for this call frame.
   */
  @get:com.fasterxml.jackson.annotation.JsonProperty("this") val _this : pl.wendigo.chrome.domain.runtime.RemoteObject,

  /**
   * The value being returned, if the function is at return point.
   */
  val returnValue : pl.wendigo.chrome.domain.runtime.RemoteObject? = null

)

/*
 * Scope description.
 */

data class Scope(
  /**
   * Scope type.
   */
  val type : String,

  /**
   * Object representing the scope. For <code>global</code> and <code>with</code> scopes it represents the actual object; for the rest of the scopes, it is artificial transient object enumerating scope variables as its properties.
   */
  @get:com.fasterxml.jackson.annotation.JsonProperty("object") val _object : pl.wendigo.chrome.domain.runtime.RemoteObject,

  /**
   *
   */
  val name : String? = null,

  /**
   * Location in the source code where scope starts
   */
  val startLocation : Location? = null,

  /**
   * Location in the source code where scope ends
   */
  val endLocation : Location? = null

)

/*
 * Search match for resource.
 */

data class SearchMatch(
  /**
   * Line number in resource content.
   */
  val lineNumber : Double,

  /**
   * Line with match content.
   */
  val lineContent : String

)

