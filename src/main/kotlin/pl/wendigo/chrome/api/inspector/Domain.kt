package pl.wendigo.chrome.api.inspector

/**
 * InspectorDomain represents Inspector protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Inspector](https://chromedevtools.github.io/devtools-protocol/tot/Inspector) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class InspectorDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebsocketConnection) :
    pl.wendigo.chrome.api.Domain("Inspector", """""", connection) {
    /**
     * Disables inspector domain notifications.
     *
     * @link Protocol [Inspector#disable](https://chromedevtools.github.io/devtools-protocol/tot/Inspector#method-disable) method documentation.
     */
    
    fun disable() = connection.request("Inspector.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables inspector domain notifications.
     *
     * @link Protocol [Inspector#enable](https://chromedevtools.github.io/devtools-protocol/tot/Inspector#method-enable) method documentation.
     */
    
    fun enable() = connection.request("Inspector.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Fired when remote debugging connection is about to be terminated. Contains detach reason.
     */
    fun detached(): io.reactivex.rxjava3.core.Flowable<DetachedEvent> = connection.events("Inspector.detached", DetachedEvent.serializer())

    /**
     *  Fired when debugging target has crashed
     */
    fun targetCrashed(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.RawEvent> = connection.events("Inspector.targetCrashed", pl.wendigo.chrome.protocol.RawEvent.serializer())

    /**
     *  Fired when debugging target has reloaded after crash
     */
    fun targetReloadedAfterCrash(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.RawEvent> = connection.events("Inspector.targetReloadedAfterCrash", pl.wendigo.chrome.protocol.RawEvent.serializer())
}

/**
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 *
 * @link [Inspector#detached](https://chromedevtools.github.io/devtools-protocol/tot/Inspector#event-detached) event documentation.
 */
@kotlinx.serialization.Serializable
data class DetachedEvent(
    /**  
     * The reason why connection has been terminated.  
     */  
    val reason: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Inspector" 
    override fun eventName() = "detached"
} 
