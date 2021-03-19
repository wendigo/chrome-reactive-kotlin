package pl.wendigo.chrome.api.tethering

import kotlinx.serialization.json.Json

/**
 * The Tethering domain defines methods and events for browser port binding.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Tethering](https://chromedevtools.github.io/devtools-protocol/tot/Tethering) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class TetheringOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Request browser port binding.
     *
     * @link Protocol [Tethering#bind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-bind) method documentation.
     */
    fun bind(input: BindRequest) = connection.request("Tethering.bind", Json.encodeToJsonElement(BindRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Request browser port unbinding.
     *
     * @link Protocol [Tethering#unbind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-unbind) method documentation.
     */
    fun unbind(input: UnbindRequest) = connection.request("Tethering.unbind", Json.encodeToJsonElement(UnbindRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Informs that port was successfully bound and got a specified connection id.
     */
    fun accepted(): io.reactivex.rxjava3.core.Flowable<AcceptedEvent> = connection.events("Tethering.accepted", AcceptedEvent.serializer())

    /**
     * Returns flowable capturing all Tethering domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Tethering"
        }
    }
}

/**
 * Represents request frame that can be used with [Tethering#bind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-bind) operation call.
 *
 * Request browser port binding.
 * @link [Tethering#bind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-bind) method documentation.
 * @see [TetheringOperations.bind]
 */
@kotlinx.serialization.Serializable
data class BindRequest(
    /**
     * Port number to bind.
     */
    val port: Int

)

/**
 * Represents request frame that can be used with [Tethering#unbind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-unbind) operation call.
 *
 * Request browser port unbinding.
 * @link [Tethering#unbind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-unbind) method documentation.
 * @see [TetheringOperations.unbind]
 */
@kotlinx.serialization.Serializable
data class UnbindRequest(
    /**
     * Port number to unbind.
     */
    val port: Int

)

/**
 * Informs that port was successfully bound and got a specified connection id.
 *
 * @link [Tethering#accepted](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#event-accepted) event documentation.
 */
@kotlinx.serialization.Serializable
data class AcceptedEvent(
    /**  
     * Port number that was successfully bound.  
     */  
    val port: Int,

    /**  
     * Connection id to be used.  
     */  
    val connectionId: String

) : pl.wendigo.chrome.protocol.Event(domainName = "Tethering", domainEventName = "accepted")
