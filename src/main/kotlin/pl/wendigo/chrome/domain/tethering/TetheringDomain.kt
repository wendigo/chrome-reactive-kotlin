package pl.wendigo.chrome.domain.tethering

/**
 * The Tethering domain defines methods and events for browser port binding.
 */
class TetheringDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Request browser port binding.
     */
    fun bind(input : BindRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Tethering.bind", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Request browser port unbinding.
     */
    fun unbind(input : UnbindRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Tethering.unbind", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Informs that port was successfully bound and got a specified connection id.
     */
    fun accepted() : io.reactivex.Flowable<AcceptedEvent> {
        return acceptedTimed().map {
            it.value()
        }
    }

    /**
     * Informs that port was successfully bound and got a specified connection id.
     */
    fun acceptedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<AcceptedEvent>> {
        return connectionRemote.captureEvents("Tethering.accepted", AcceptedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Tethering domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Tethering"
        }
    }
}
/**
 * Represents request frame that can be used with Tethering.bind method call.
 *
 * Request browser port binding.
 */
data class BindRequest (
    /**
     * Port number to bind.
     */
    val port : Int

)

/**
 * Represents request frame that can be used with Tethering.unbind method call.
 *
 * Request browser port unbinding.
 */
data class UnbindRequest (
    /**
     * Port number to unbind.
     */
    val port : Int

)

/**
 * Represents event frames for Tethering.accepted
 *
 * Informs that port was successfully bound and got a specified connection id.
 */
data class AcceptedEvent(
  /**
   * Port number that was successfully bound.
   */
  val port : Int,

  /**
   * Connection id to be used.
   */
  val connectionId : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Tethering", name = "accepted")

