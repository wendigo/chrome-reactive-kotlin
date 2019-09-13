package pl.wendigo.chrome.domain.inspector

/**
 * Inspector represents remote debugger protocol domain.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Inspector](https://chromedevtools.github.io/devtools-protocol/tot/Inspector)
 */
class Inspector internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disables inspector domain notifications.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Inspector.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables inspector domain notifications.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Inspector.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Fired when remote debugging connection is about to be terminated. Contains detach reason.
     */
    fun detached(): io.reactivex.Flowable<DetachedEvent> {
        return detachedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when remote debugging connection is about to be terminated. Contains detach reason.
     */
    fun detachedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<DetachedEvent>> {
        return connectionRemote.captureEvents("Inspector.detached", DetachedEvent::class.java)
    }

    /**
     *  Fired when debugging target has crashed
     */
    fun targetCrashed(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return targetCrashedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when debugging target has crashed
     */
    fun targetCrashedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Inspector.targetCrashed", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     *  Fired when debugging target has reloaded after crash
     */
    fun targetReloadedAfterCrash(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return targetReloadedAfterCrashTimed().map {
            it.value()
        }
    }

    /**
     * Fired when debugging target has reloaded after crash
     */
    fun targetReloadedAfterCrashTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Inspector.targetReloadedAfterCrash", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Returns flowable capturing all Inspector domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Inspector"
        }
    }
}

/**
 * Represents event frames for Inspector.detached
 *
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 */
data class DetachedEvent(
    /**  
     * The reason why connection has been terminated.  
     */  
    val reason: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Inspector", name = "detached")
