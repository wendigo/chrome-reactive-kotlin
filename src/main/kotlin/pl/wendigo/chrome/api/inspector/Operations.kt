package pl.wendigo.chrome.api.inspector

/**
 * InspectorOperations represents Inspector protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Inspector](https://chromedevtools.github.io/devtools-protocol/tot/Inspector) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class InspectorOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables inspector domain notifications.
     *
     * @link Protocol [Inspector#disable](https://chromedevtools.github.io/devtools-protocol/tot/Inspector#method-disable) method documentation.
     */
    fun disable() = connection.request("Inspector.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables inspector domain notifications.
     *
     * @link Protocol [Inspector#enable](https://chromedevtools.github.io/devtools-protocol/tot/Inspector#method-enable) method documentation.
     */
    fun enable() = connection.request("Inspector.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Fired when remote debugging connection is about to be terminated. Contains detach reason.
     */
    fun detached(): io.reactivex.Flowable<DetachedEvent> = connection.events("Inspector.detached", DetachedEvent::class.java)

    /**
     *  Fired when debugging target has crashed
     */
    fun targetCrashed(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Inspector.targetCrashed", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Fired when debugging target has reloaded after crash
     */
    fun targetReloadedAfterCrash(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Inspector.targetReloadedAfterCrash", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     * Returns flowable capturing all Inspector domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Inspector"
        }
    }
}

/**
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 *
 * @link [Inspector#detached](https://chromedevtools.github.io/devtools-protocol/tot/Inspector#event-detached) event documentation.
 */
data class DetachedEvent(
    /**  
     * The reason why connection has been terminated.  
     */  
    val reason: String

) : pl.wendigo.chrome.protocol.Event(domain = "Inspector", name = "detached")
