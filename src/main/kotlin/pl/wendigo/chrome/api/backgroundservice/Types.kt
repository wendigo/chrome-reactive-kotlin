package pl.wendigo.chrome.api.backgroundservice

/**
 * The Background Service that will be associated with the commands/events.
Every Background Service operates independently, but they share the same
API.
 *
 * @link [BackgroundService#ServiceName](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#type-ServiceName) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ServiceName {
    @kotlinx.serialization.SerialName("backgroundFetch")
    BACKGROUNDFETCH,

    @kotlinx.serialization.SerialName("backgroundSync")
    BACKGROUNDSYNC,

    @kotlinx.serialization.SerialName("pushMessaging")
    PUSHMESSAGING,

    @kotlinx.serialization.SerialName("notifications")
    NOTIFICATIONS,

    @kotlinx.serialization.SerialName("paymentHandler")
    PAYMENTHANDLER,

    @kotlinx.serialization.SerialName("periodicBackgroundSync")
    PERIODICBACKGROUNDSYNC;
}

/**
 * A key-value pair for additional event information to pass along.
 *
 * @link [BackgroundService#EventMetadata](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#type-EventMetadata) type documentation.
 */

@kotlinx.serialization.Serializable
data class EventMetadata(
    /**  
     *  
     */  
    val key: String,

    /**  
     *  
     */  
    val value: String
)

/**
 *
 *
 * @link [BackgroundService#BackgroundServiceEvent](https://chromedevtools.github.io/devtools-protocol/tot/BackgroundService#type-BackgroundServiceEvent) type documentation.
 */

@kotlinx.serialization.Serializable
data class BackgroundServiceEvent(
    /**  
     * Timestamp of the event (in seconds).  
     */  
    val timestamp: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     * The origin this event belongs to.  
     */  
    val origin: String,

    /**  
     * The Service Worker ID that initiated the event.  
     */  
    val serviceWorkerRegistrationId: pl.wendigo.chrome.api.serviceworker.RegistrationID,

    /**  
     * The Background Service this event belongs to.  
     */  
    val service: ServiceName,

    /**  
     * A description of the event.  
     */  
    val eventName: String,

    /**  
     * An identifier that groups related events together.  
     */  
    val instanceId: String,

    /**  
     * A list of event-specific information.  
     */  
    val eventMetadata: List<EventMetadata>
)
