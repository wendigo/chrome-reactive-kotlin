package pl.wendigo.chrome.domain.cast

/**
 * A domain for interacting with Cast, Presentation API, and Remote Playback API
functionalities.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Cast](https://chromedevtools.github.io/devtools-protocol/tot/Cast)
 */
class Cast internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Starts observing for sinks that can be used for tab mirroring, and if set,
sinks compatible with |presentationUrl| as well. When sinks are found, a
|sinksUpdated| event is fired.
Also starts observing for issue messages. When an issue is added or removed,
an |issueUpdated| event is fired.
     */
    fun enable(input: EnableRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Cast.enable", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stops observing for sinks and issues.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Cast.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets a sink to be used when the web page requests the browser to choose a
sink via Presentation API, Remote Playback API, or Cast SDK.
     */
    fun setSinkToUse(input: SetSinkToUseRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Cast.setSinkToUse", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Starts mirroring the tab to the sink.
     */
    fun startTabMirroring(input: StartTabMirroringRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Cast.startTabMirroring", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stops the active Cast session on the sink.
     */
    fun stopCasting(input: StopCastingRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Cast.stopCasting", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  This is fired whenever the list of available sinks changes. A sink is a
device or a software surface that you can cast to.
     */
    fun sinksUpdated(): io.reactivex.Flowable<SinksUpdatedEvent> {
        return sinksUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * This is fired whenever the list of available sinks changes. A sink is a
device or a software surface that you can cast to.
     */
    fun sinksUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<SinksUpdatedEvent>> {
        return connectionRemote.captureEvents("Cast.sinksUpdated", SinksUpdatedEvent::class.java)
    }

    /**
     *  This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
     */
    fun issueUpdated(): io.reactivex.Flowable<IssueUpdatedEvent> {
        return issueUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
     */
    fun issueUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<IssueUpdatedEvent>> {
        return connectionRemote.captureEvents("Cast.issueUpdated", IssueUpdatedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Cast domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Cast"
        }
    }
}
/**
 * Represents request frame that can be used with Cast.enable method call.
 *
 * Starts observing for sinks that can be used for tab mirroring, and if set,
sinks compatible with |presentationUrl| as well. When sinks are found, a
|sinksUpdated| event is fired.
Also starts observing for issue messages. When an issue is added or removed,
an |issueUpdated| event is fired.
 */
data class EnableRequest(
    /**
     *
     */
    val presentationUrl: String? = null

)

/**
 * Represents request frame that can be used with Cast.setSinkToUse method call.
 *
 * Sets a sink to be used when the web page requests the browser to choose a
sink via Presentation API, Remote Playback API, or Cast SDK.
 */
data class SetSinkToUseRequest(
    /**
     *
     */
    val sinkName: String

)

/**
 * Represents request frame that can be used with Cast.startTabMirroring method call.
 *
 * Starts mirroring the tab to the sink.
 */
data class StartTabMirroringRequest(
    /**
     *
     */
    val sinkName: String

)

/**
 * Represents request frame that can be used with Cast.stopCasting method call.
 *
 * Stops the active Cast session on the sink.
 */
data class StopCastingRequest(
    /**
     *
     */
    val sinkName: String

)

/**
 * Represents event frames for Cast.sinksUpdated
 *
 * This is fired whenever the list of available sinks changes. A sink is a
device or a software surface that you can cast to.
 */
data class SinksUpdatedEvent(
    /**  
     *  
     */  
    val sinks: List<Sink>

) : pl.wendigo.chrome.ProtocolEvent(domain = "Cast", name = "sinksUpdated")

/**
 * Represents event frames for Cast.issueUpdated
 *
 * This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
 */
data class IssueUpdatedEvent(
    /**  
     *  
     */  
    val issueMessage: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Cast", name = "issueUpdated")
