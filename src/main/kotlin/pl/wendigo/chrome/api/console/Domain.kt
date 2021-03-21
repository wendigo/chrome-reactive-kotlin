package pl.wendigo.chrome.api.console

/**
 * This domain is deprecated - use Runtime or Log instead.
 *
 * @link Protocol [Console](https://chromedevtools.github.io/devtools-protocol/tot/Console) domain documentation.
 */
@Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated - use Runtime or Log instead.")
class ConsoleDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("Console", """This domain is deprecated - use Runtime or Log instead.""", connection) {
    /**
     * Does nothing.
     *
     * @link Protocol [Console#clearMessages](https://chromedevtools.github.io/devtools-protocol/tot/Console#method-clearMessages) method documentation.
     */
    
    fun clearMessages(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Console.clearMessages", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Disables console domain, prevents further console messages from being reported to the client.
     *
     * @link Protocol [Console#disable](https://chromedevtools.github.io/devtools-protocol/tot/Console#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Console.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Enables console domain, sends the messages collected so far to the client by means of the
`messageAdded` notification.
     *
     * @link Protocol [Console#enable](https://chromedevtools.github.io/devtools-protocol/tot/Console#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("Console.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     *  Issued when new console message is added.
     */
    fun messageAdded(): io.reactivex.rxjava3.core.Flowable<MessageAddedEvent> = connection.events("Console.messageAdded", MessageAddedEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.runtime.RuntimeDomain(connection),
        )
    }
}

/**
 * Issued when new console message is added.
 *
 * @link [Console#messageAdded](https://chromedevtools.github.io/devtools-protocol/tot/Console#event-messageAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class MessageAddedEvent(
    /**  
     * Console message that has been added.  
     */  
    val message: ConsoleMessage

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Console" 
    override fun eventName() = "messageAdded"
} 
