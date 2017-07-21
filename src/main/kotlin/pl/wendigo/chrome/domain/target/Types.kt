package pl.wendigo.chrome.domain.target

/**
 *
 */

typealias TargetID = String

/**
 * Unique identifier of attached debugging session.
 */

typealias SessionID = String

/**
 *
 */

typealias BrowserContextID = String

/**
 *
 */

data class TargetInfo(
  /**
   *
   */
  val targetId : TargetID,

  /**
   *
   */
  val type : String,

  /**
   *
   */
  val title : String,

  /**
   *
   */
  val url : String,

  /**
   * Whether the target has an attached client.
   */
  val attached : Boolean
)

/**
 *
 */

data class RemoteLocation(
  /**
   *
   */
  val host : String,

  /**
   *
   */
  val port : Int
)

