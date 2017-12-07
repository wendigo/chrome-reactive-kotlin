package pl.wendigo.chrome.domain.serviceworker

/**
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

/**
 *
 */
enum class ServiceWorkerVersionRunningStatus {
    @com.fasterxml.jackson.annotation.JsonProperty("stopped") STOPPED,
    @com.fasterxml.jackson.annotation.JsonProperty("starting") STARTING,
    @com.fasterxml.jackson.annotation.JsonProperty("running") RUNNING,
    @com.fasterxml.jackson.annotation.JsonProperty("stopping") STOPPING;
}

/**
 *
 */
enum class ServiceWorkerVersionStatus {
    @com.fasterxml.jackson.annotation.JsonProperty("new") NEW,
    @com.fasterxml.jackson.annotation.JsonProperty("installing") INSTALLING,
    @com.fasterxml.jackson.annotation.JsonProperty("installed") INSTALLED,
    @com.fasterxml.jackson.annotation.JsonProperty("activating") ACTIVATING,
    @com.fasterxml.jackson.annotation.JsonProperty("activated") ACTIVATED,
    @com.fasterxml.jackson.annotation.JsonProperty("redundant") REDUNDANT;
}

/**
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
   * The time at which the response headers of the main script were received from the server.
For cached script it is the last time the cache entry was validated.
   */
  val scriptResponseTime : Double? = null,

  /**
   *
   */
  val controlledClients : List<pl.wendigo.chrome.domain.target.TargetID>? = null,

  /**
   *
   */
  val targetId : pl.wendigo.chrome.domain.target.TargetID? = null
)

/**
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

