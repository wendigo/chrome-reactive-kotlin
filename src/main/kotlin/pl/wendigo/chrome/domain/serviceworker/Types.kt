package pl.wendigo.chrome.domain.serviceworker

/*
 * ServiceWorker registration.
 */

data class ServiceWorkerRegistration(
  /**
   *
   */
  val registrationId : String,

  /**
   *
   */
  val scopeURL : String,

  /**
   *
   */
  val isDeleted : Boolean

)

/*
 * 
 */
typealias ServiceWorkerVersionRunningStatus = String

/*
 * 
 */
typealias ServiceWorkerVersionStatus = String

/*
 * ServiceWorker version.
 */

data class ServiceWorkerVersion(
  /**
   *
   */
  val versionId : String,

  /**
   *
   */
  val registrationId : String,

  /**
   *
   */
  val scriptURL : String,

  /**
   *
   */
  val runningStatus : ServiceWorkerVersionRunningStatus,

  /**
   *
   */
  val status : ServiceWorkerVersionStatus,

  /**
   * The Last-Modified header value of the main script.
   */
  val scriptLastModified : Double? = null,

  /**
   * The time at which the response headers of the main script were received from the server.  For cached script it is the last time the cache entry was validated.
   */
  val scriptResponseTime : Double? = null,

  /**
   *
   */
  val controlledClients : Array<pl.wendigo.chrome.domain.target.TargetID>? = null,

  /**
   *
   */
  val targetId : pl.wendigo.chrome.domain.target.TargetID? = null

)

/*
 * ServiceWorker error message.
 */

data class ServiceWorkerErrorMessage(
  /**
   *
   */
  val errorMessage : String,

  /**
   *
   */
  val registrationId : String,

  /**
   *
   */
  val versionId : String,

  /**
   *
   */
  val sourceURL : String,

  /**
   *
   */
  val lineNumber : Int,

  /**
   *
   */
  val columnNumber : Int

)

