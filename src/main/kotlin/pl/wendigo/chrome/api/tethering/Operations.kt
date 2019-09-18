package pl.wendigo.chrome.api.tethering

/**
 * The Tethering domain defines methods and events for browser port binding.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Tethering](https://chromedevtools.github.io/devtools-protocol/tot/Tethering) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class TetheringOperations internal constructor(private val connection : pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Request browser port binding.
     *
     * @link Protocol [Tethering#bind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-bind) method documentation.
     */
        fun bind(input: BindRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Tethering.bind", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Request browser port unbinding.
     *
     * @link Protocol [Tethering#unbind](https://chromedevtools.github.io/devtools-protocol/tot/Tethering#method-unbind) method documentation.
     */
        fun unbind(input: UnbindRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Tethering.unbind", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *  Informs that port was successfully bound and got a specified connection id.
     */
    fun accepted(): io.reactivex.Flowable<AcceptedEvent> = connection.captureEvents("Tethering.accepted", AcceptedEvent::class.java);


    /**
     * Returns flowable capturing all Tethering domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
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
data class BindRequest (
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
data class UnbindRequest (
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
data class AcceptedEvent(
  /**
   * Port number that was successfully bound.
   */
  val port: Int,

  /**
   * Connection id to be used.
   */
  val connectionId: String

): pl.wendigo.chrome.protocol.Event(domain = "Tethering", name = "accepted")

