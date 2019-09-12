package pl.wendigo.chrome.domain.backgroundservice

/**
 * The Background Service that will be associated with the commands/events.
Every Background Service operates independently, but they share the same
API.
 */
enum class ServiceName {
    @com.fasterxml.jackson.annotation.JsonProperty("backgroundFetch") BACKGROUNDFETCH,
    @com.fasterxml.jackson.annotation.JsonProperty("backgroundSync") BACKGROUNDSYNC,
    @com.fasterxml.jackson.annotation.JsonProperty("pushMessaging") PUSHMESSAGING,
    @com.fasterxml.jackson.annotation.JsonProperty("notifications") NOTIFICATIONS,
    @com.fasterxml.jackson.annotation.JsonProperty("paymentHandler") PAYMENTHANDLER,
    @com.fasterxml.jackson.annotation.JsonProperty("periodicBackgroundSync") PERIODICBACKGROUNDSYNC;
}

/**
 * A key-value pair for additional event information to pass along.
 */

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
 */

data class BackgroundServiceEvent(
    /**  
     * Timestamp of the event (in seconds).  
     */  
    val timestamp: pl.wendigo.chrome.domain.network.TimeSinceEpoch,

    /**  
     * The origin this event belongs to.  
     */  
    val origin: String,

    /**  
     * The Service Worker ID that initiated the event.  
     */  
    val serviceWorkerRegistrationId: pl.wendigo.chrome.domain.serviceworker.RegistrationID,

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