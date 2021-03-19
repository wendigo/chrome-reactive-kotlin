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
 * Have one type per entry in MediaLogRecord::Type
Corresponds to kMessage
 *
 * @link [Media#PlayerMessage](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerMessage) type documentation.
 */

@kotlinx.serialization.Serializable
data class PlayerMessage(
    /**  
     * Keep in sync with MediaLogMessageLevel  
     We are currently keeping the message level 'error' separate from the  
     PlayerError type because right now they represent different things,  
     this one being a DVLOG(ERROR) style log message that gets printed  
     based on what log level is selected in the UI, and the other is a  
     representation of a media::PipelineStatus object. Soon however we're  
     going to be moving away from using PipelineStatus for errors and  
     introducing a new error type which should hopefully let us integrate  
     the error log level into the PlayerError type.  
     */  
    val level: String,

    /**  
     *  
     */  
    val message: String
)

/**
 * Corresponds to kMediaPropertyChange
 *
 * @link [Media#PlayerProperty](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerProperty) type documentation.
 */

@kotlinx.serialization.Serializable
data class PlayerProperty(
    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val value: String
)

/**
 * Corresponds to kMediaEventTriggered
 *
 * @link [Media#PlayerEvent](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerEvent) type documentation.
 */

@kotlinx.serialization.Serializable
data class PlayerEvent(
    /**  
     *  
     */  
    val timestamp: Timestamp,

    /**  
     *  
     */  
    val value: String
)

/**
 * Corresponds to kMediaError
 *
 * @link [Media#PlayerError](https://chromedevtools.github.io/devtools-protocol/tot/Media#type-PlayerError) type documentation.
 */

@kotlinx.serialization.Serializable
data class PlayerError(
    /**  
     *  
     */  
    val type: String,

    /**  
     * When this switches to using media::Status instead of PipelineStatus  
     we can remove "errorCode" and replace it with the fields from  
     a Status instance. This also seems like a duplicate of the error  
     level enum - there is a todo bug to have that level removed and  
     use this instead. (crbug.com/1068454)  
     */  
    val errorCode: String
)
