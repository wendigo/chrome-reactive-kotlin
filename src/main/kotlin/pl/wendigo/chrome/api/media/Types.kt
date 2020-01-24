package pl.wendigo.chrome.api.media

/**
 * Players will get an ID that is unique within the agent context.
 *
 * @link [Media#PlayerId](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerId) type documentation.
 */

typealias PlayerId = String

/**
 *
 *
 * @link [Media#Timestamp](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-Timestamp) type documentation.
 */

typealias Timestamp = Double

/**
 * Player Property type
 *
 * @link [Media#PlayerProperty](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerProperty) type documentation.
 */

data class PlayerProperty(
    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val value: String? = null
)

/**
 * Break out events into different types
 *
 * @link [Media#PlayerEventType](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerEventType) type documentation.
 */
enum class PlayerEventType {
    @com.fasterxml.jackson.annotation.JsonProperty("errorEvent")
    ERROREVENT,
    @com.fasterxml.jackson.annotation.JsonProperty("triggeredEvent")
    TRIGGEREDEVENT,
    @com.fasterxml.jackson.annotation.JsonProperty("messageEvent")
    MESSAGEEVENT;
}

/**
 *
 *
 * @link [Media#PlayerEvent](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerEvent) type documentation.
 */

data class PlayerEvent(
    /**  
     *  
     */  
    val type: PlayerEventType,

    /**  
     * Events are timestamped relative to the start of the player creation  
     not relative to the start of playback.  
     */  
    val timestamp: Timestamp,

    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val value: String
)
