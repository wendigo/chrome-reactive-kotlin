package pl.wendigo.chrome.api.media

/**
 * This domain allows detailed inspection of media elements
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Media](https://chromedevtools.github.io/devtools-protocol/tot/Media) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class MediaOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Enables the Media domain
     *
     * @link Protocol [Media#enable](https://chromedevtools.github.io/devtools-protocol/tot/Media#method-enable) method documentation.
     */
    fun enable() = connection.request("Media.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disables the Media domain.
     *
     * @link Protocol [Media#disable](https://chromedevtools.github.io/devtools-protocol/tot/Media#method-disable) method documentation.
     */
    fun disable() = connection.request("Media.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
     */
    fun playerPropertiesChanged(): io.reactivex.Flowable<PlayerPropertiesChangedEvent> = connection.events("Media.playerPropertiesChanged", PlayerPropertiesChangedEvent::class.java)

    /**
     *  Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
     */
    fun playerEventsAdded(): io.reactivex.Flowable<PlayerEventsAddedEvent> = connection.events("Media.playerEventsAdded", PlayerEventsAddedEvent::class.java)

    /**
     *  Send a list of any messages that need to be delivered.
     */
    fun playerMessagesLogged(): io.reactivex.Flowable<PlayerMessagesLoggedEvent> = connection.events("Media.playerMessagesLogged", PlayerMessagesLoggedEvent::class.java)

    /**
     *  Send a list of any errors that need to be delivered.
     */
    fun playerErrorsRaised(): io.reactivex.Flowable<PlayerErrorsRaisedEvent> = connection.events("Media.playerErrorsRaised", PlayerErrorsRaisedEvent::class.java)

    /**
     *  Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
     */
    fun playersCreated(): io.reactivex.Flowable<PlayersCreatedEvent> = connection.events("Media.playersCreated", PlayersCreatedEvent::class.java)

    /**
     * Returns flowable capturing all Media domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Media"
        }
    }
}

/**
 * This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
 *
 * @link [Media#playerPropertiesChanged](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerPropertiesChanged) event documentation.
 */
data class PlayerPropertiesChangedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val properties: List<PlayerProperty>

) : pl.wendigo.chrome.protocol.Event(domain = "Media", name = "playerPropertiesChanged")

/**
 * Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
 *
 * @link [Media#playerEventsAdded](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerEventsAdded) event documentation.
 */
data class PlayerEventsAddedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val events: List<PlayerEvent>

) : pl.wendigo.chrome.protocol.Event(domain = "Media", name = "playerEventsAdded")

/**
 * Send a list of any messages that need to be delivered.
 *
 * @link [Media#playerMessagesLogged](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerMessagesLogged) event documentation.
 */
data class PlayerMessagesLoggedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val messages: List<PlayerMessage>

) : pl.wendigo.chrome.protocol.Event(domain = "Media", name = "playerMessagesLogged")

/**
 * Send a list of any errors that need to be delivered.
 *
 * @link [Media#playerErrorsRaised](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playerErrorsRaised) event documentation.
 */
data class PlayerErrorsRaisedEvent(
    /**  
     *  
     */  
    val playerId: PlayerId,

    /**  
     *  
     */  
    val errors: List<PlayerError>

) : pl.wendigo.chrome.protocol.Event(domain = "Media", name = "playerErrorsRaised")

/**
 * Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
 *
 * @link [Media#playersCreated](https://chromedevtools.github.io/devtools-protocol/tot/Media#event-playersCreated) event documentation.
 */
data class PlayersCreatedEvent(
    /**  
     *  
     */  
    val players: List<PlayerId>

) : pl.wendigo.chrome.protocol.Event(domain = "Media", name = "playersCreated")
