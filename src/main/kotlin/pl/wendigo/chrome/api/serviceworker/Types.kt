package pl.wendigo.chrome.api.serviceworker

/**
 *
 *
 * @link [ServiceWorker#RegistrationID](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-RegistrationID) type documentation.
 */

typealias RegistrationID = String

/**
 * ServiceWorker registration.
 *
 * @link [ServiceWorker#ServiceWorkerRegistration](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerRegistration) type documentation.
 */

data class ServiceWorkerRegistration(
    /**  
     *  
     */  
    val registrationId: RegistrationID,

    /**  
     *  
     */  
    val scopeURL: String,

    /**  
     *  
     */  
    val isDeleted: Boolean
)

/**
 *
 *
 * @link [ServiceWorker#ServiceWorkerVersionRunningStatus](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerVersionRunningStatus) type documentation.
 */
enum class ServiceWorkerVersionRunningStatus {
    @com.fasterxml.jackson.annotation.JsonProperty("stopped")
    STOPPED,
    @com.fasterxml.jackson.annotation.JsonProperty("starting")
    STARTING,
    @com.fasterxml.jackson.annotation.JsonProperty("running")
    RUNNING,
    @com.fasterxml.jackson.annotation.JsonProperty("stopping")
    STOPPING;
}

/**
 *
 *
 * @link [ServiceWorker#ServiceWorkerVersionStatus](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerVersionStatus) type documentation.
 */
enum class ServiceWorkerVersionStatus {
    @com.fasterxml.jackson.annotation.JsonProperty("new")
    NEW,
    @com.fasterxml.jackson.annotation.JsonProperty("installing")
    INSTALLING,
    @com.fasterxml.jackson.annotation.JsonProperty("installed")
    INSTALLED,
    @com.fasterxml.jackson.annotation.JsonProperty("activating")
    ACTIVATING,
    @com.fasterxml.jackson.annotation.JsonProperty("activated")
    ACTIVATED,
    @com.fasterxml.jackson.annotation.JsonProperty("redundant")
    REDUNDANT;
}

/**
 * ServiceWorker version.
 *
 * @link [ServiceWorker#ServiceWorkerVersion](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerVersion) type documentation.
 */

data class ServiceWorkerVersion(
    /**  
     *  
     */  
    val versionId: String,

    /**  
     *  
     */  
    val registrationId: RegistrationID,

    /**  
     *  
     */  
    val scriptURL: String,

    /**  
     *  
     */  
    val runningStatus: ServiceWorkerVersionRunningStatus,

    /**  
     *  
     */  
    val status: ServiceWorkerVersionStatus,

    /**  
     * The Last-Modified header value of the main script.  
     */  
    val scriptLastModified: Double? = null,

    /**  
     * The time at which the response headers of the main script were received from the server.  
     For cached script it is the last time the cache entry was validated.  
     */  
    val scriptResponseTime: Double? = null,

    /**  
     *  
     */  
    val controlledClients: List<pl.wendigo.chrome.api.target.TargetID>? = null,

    /**  
     *  
     */  
    val targetId: pl.wendigo.chrome.api.target.TargetID? = null
)

/**
 * ServiceWorker error message.
 *
 * @link [ServiceWorker#ServiceWorkerErrorMessage](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerErrorMessage) type documentation.
 */

data class ServiceWorkerErrorMessage(
    /**  
     *  
     */  
    val errorMessage: String,

    /**  
     *  
     */  
    val registrationId: RegistrationID,

    /**  
     *  
     */  
    val versionId: String,

    /**  
     *  
     */  
    val sourceURL: String,

    /**  
     *  
     */  
    val lineNumber: Int,

    /**  
     *  
     */  
    val columnNumber: Int
)
