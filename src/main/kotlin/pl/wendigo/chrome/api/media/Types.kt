package pl.wendigo.chrome.domain.media

/**
 * Players will get an ID that is unique within the agent context.
 */

typealias PlayerId = String

/**
 *
 */

typealias Timestamp = Double

/**
 * Player Property type
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
 */
enum class PlayerEventType {
    @com.fasterxml.jackson.annotation.JsonProperty("playbackEvent")
    PLAYBACKEVENT,
    @com.fasterxml.jackson.annotation.JsonProperty("systemEvent")
    SYSTEMEVENT,
    @com.fasterxml.jackson.annotation.JsonProperty("messageEvent")
    MESSAGEEVENT;
}

/**
 *
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
