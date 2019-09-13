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
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Media.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables the Media domain.
     *
     * @link Protocol [Media#disable](https://chromedevtools.github.io/devtools-protocol/tot/Media#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Media.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
     */
    fun playerPropertiesChanged(): io.reactivex.Flowable<PlayerPropertiesChangedEvent> {
        return playerPropertiesChangedTimed().map {
            it.value()
        }
    }

    /**
     * This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
     */
    fun playerPropertiesChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<PlayerPropertiesChangedEvent>> {
        return connection.captureEvents("Media.playerPropertiesChanged", PlayerPropertiesChangedEvent::class.java)
    }

    /**
     *  Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
     */
    fun playerEventsAdded(): io.reactivex.Flowable<PlayerEventsAddedEvent> {
        return playerEventsAddedTimed().map {
            it.value()
        }
    }

    /**
     * Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
     */
    fun playerEventsAddedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<PlayerEventsAddedEvent>> {
        return connection.captureEvents("Media.playerEventsAdded", PlayerEventsAddedEvent::class.java)
    }

    /**
     *  Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
     */
    fun playersCreated(): io.reactivex.Flowable<PlayersCreatedEvent> {
        return playersCreatedTimed().map {
            it.value()
        }
    }

    /**
     * Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
     */
    fun playersCreatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<PlayersCreatedEvent>> {
        return connection.captureEvents("Media.playersCreated", PlayersCreatedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Media domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
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
