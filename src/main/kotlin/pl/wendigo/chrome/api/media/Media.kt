package pl.wendigo.chrome.domain.media

/**
 * This domain allows detailed inspection of media elements
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Media](https://chromedevtools.github.io/devtools-protocol/tot/Media)
 */
class Media internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Enables the Media domain
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Media.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables the Media domain.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Media.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
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
        return connectionRemote.captureEvents("Media.playerPropertiesChanged", PlayerPropertiesChangedEvent::class.java)
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
        return connectionRemote.captureEvents("Media.playerEventsAdded", PlayerEventsAddedEvent::class.java)
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
        return connectionRemote.captureEvents("Media.playersCreated", PlayersCreatedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Media domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Media"
        }
    }
}

/**
 * Represents event frames for Media.playerPropertiesChanged
 *
 * This can be called multiple times, and can be used to set / override /
remove player properties. A null propValue indicates removal.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Media", name = "playerPropertiesChanged")

/**
 * Represents event frames for Media.playerEventsAdded
 *
 * Send events as a list, allowing them to be batched on the browser for less
congestion. If batched, events must ALWAYS be in chronological order.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Media", name = "playerEventsAdded")

/**
 * Represents event frames for Media.playersCreated
 *
 * Called whenever a player is created, or when a new agent joins and recieves
a list of active players. If an agent is restored, it will recieve the full
list of player ids and all events again.
 */
data class PlayersCreatedEvent(
    /**  
     *  
     */  
    val players: List<PlayerId>

) : pl.wendigo.chrome.ProtocolEvent(domain = "Media", name = "playersCreated")
