package pl.wendigo.chrome.api.media

/**
 * This domain allows detailed inspection of media elements
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Media](https://chromedevtools.github.io/devtools-protocol/tot/Media) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class MediaDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("Media", """This domain allows detailed inspection of media elements""", connection) {
    /**
     * Enables the Media domain
     *
     * @link Protocol [Media#enable](https://chromedevtools.github.io/devtools-protocol/tot/Media#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Media.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Disables the Media domain.
     *
     * @link Protocol [Media#disable](https://chromedevtools.github.io/devtools-protocol/tot/Media#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Media.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     *  This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
     */
    fun playerPropertiesChanged(): io.reactivex.rxjava3.core.Flowable<PlayerPropertiesChangedEvent> = connection.events("Media.playerPropertiesChanged", PlayerPropertiesChangedEvent.serializer())

    /**
     *  Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
     */
    fun playerEventsAdded(): io.reactivex.rxjava3.core.Flowable<PlayerEventsAddedEvent> = connection.events("Media.playerEventsAdded", PlayerEventsAddedEvent.serializer())

    /**
     *  Send a list of any messages that need to be delivered.
     */
    fun playerMessagesLogged(): io.reactivex.rxjava3.core.Flowable<PlayerMessagesLoggedEvent> = connection.events("Media.playerMessagesLogged", PlayerMessagesLoggedEvent.serializer())

    /**
     *  Send a list of any errors that need to be delivered.
     */
    fun playerErrorsRaised(): io.reactivex.rxjava3.core.Flowable<PlayerErrorsRaisedEvent> = connection.events("Media.playerErrorsRaised", PlayerErrorsRaisedEvent.serializer())

    /**
     *  Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
     */
    fun playersCreated(): io.reactivex.rxjava3.core.Flowable<PlayersCreatedEvent> = connection.events("Media.playersCreated", PlayersCreatedEvent.serializer())
}

/**
 * This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
 *
 * @link [Media#playerPropertiesChanged](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerPropertiesChanged) event documentation.
 */
@kotlinx.serialization.Serializable
data class PlayerPropertiesChangedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val properties: List<PlayerProperty>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Media" 
    override fun eventName() = "playerPropertiesChanged"
} 

/**
 * Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
 *
 * @link [Media#playerEventsAdded](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerEventsAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class PlayerEventsAddedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val events: List<PlayerEvent>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Media" 
    override fun eventName() = "playerEventsAdded"
} 

/**
 * Send a list of any messages that need to be delivered.
 *
 * @link [Media#playerMessagesLogged](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerMessagesLogged) event documentation.
 */
@kotlinx.serialization.Serializable
data class PlayerMessagesLoggedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val messages: List<PlayerMessage>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Media" 
    override fun eventName() = "playerMessagesLogged"
} 

/**
 * Send a list of any errors that need to be delivered.
 *
 * @link [Media#playerErrorsRaised](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerErrorsRaised) event documentation.
 */
@kotlinx.serialization.Serializable
data class PlayerErrorsRaisedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val errors: List<PlayerError>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Media" 
    override fun eventName() = "playerErrorsRaised"
} 

/**
 * Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
 *
 * @link [Media#playersCreated](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playersCreated) event documentation.
 */
@kotlinx.serialization.Serializable
data class PlayersCreatedEvent(
    /**  
     *  
     */  
    val players: List<PlayerId>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Media" 
    override fun eventName() = "playersCreated"
} 
