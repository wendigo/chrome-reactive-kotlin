package pl.wendigo.chrome.domain.target

/*
 * 
 */
typealias TargetID = String

/*
 * 
 */
typealias BrowserContextID = String

/*
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
  val url : String

)

/*
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

