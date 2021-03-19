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

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class ServiceWorkerVersionRunningStatus {
    @kotlinx.serialization.SerialName("stopped")
    STOPPED,

    @kotlinx.serialization.SerialName("starting")
    STARTING,

    @kotlinx.serialization.SerialName("running")
    RUNNING,

    @kotlinx.serialization.SerialName("stopping")
    STOPPING;
}

/**
 *
 *
 * @link [ServiceWorker#ServiceWorkerVersionStatus](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerVersionStatus) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ServiceWorkerVersionStatus {
    @kotlinx.serialization.SerialName("new")
    NEW,

    @kotlinx.serialization.SerialName("installing")
    INSTALLING,

    @kotlinx.serialization.SerialName("installed")
    INSTALLED,

    @kotlinx.serialization.SerialName("activating")
    ACTIVATING,

    @kotlinx.serialization.SerialName("activated")
    ACTIVATED,

    @kotlinx.serialization.SerialName("redundant")
    REDUNDANT;
}

/**
 * ServiceWorker version.
 *
 * @link [ServiceWorker#ServiceWorkerVersion](https://chromedevtools.github.io/devtools-protocol/tot/ServiceWorker#type-ServiceWorkerVersion) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
