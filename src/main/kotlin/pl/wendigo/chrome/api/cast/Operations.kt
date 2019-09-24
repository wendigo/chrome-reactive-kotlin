package pl.wendigo.chrome.api.cast

/**
 * A domain for interacting with Cast, Presentation API, and Remote Playback API
functionalities.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Cast](https://chromedevtools.github.io/devtools-protocol/tot/Cast) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class CastOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Starts observing for sinks that can be used for tab mirroring, and if set,
sinks compatible with |presentationUrl| as well. When sinks are found, a
|sinksUpdated| event is fired.
Also starts observing for issue messages. When an issue is added or removed,
an |issueUpdated| event is fired.
     *
     * @link Protocol [Cast#enable](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-enable) method documentation.
     */
    fun enable(input: EnableRequest) = connection.request("Cast.enable", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Stops observing for sinks and issues.
     *
     * @link Protocol [Cast#disable](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-disable) method documentation.
     */
    fun disable() = connection.request("Cast.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Sets a sink to be used when the web page requests the browser to choose a
sink via Presentation API, Remote Playback API, or Cast SDK.
     *
     * @link Protocol [Cast#setSinkToUse](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-setSinkToUse) method documentation.
     */
    fun setSinkToUse(input: SetSinkToUseRequest) = connection.request("Cast.setSinkToUse", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Starts mirroring the tab to the sink.
     *
     * @link Protocol [Cast#startTabMirroring](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-startTabMirroring) method documentation.
     */
    fun startTabMirroring(input: StartTabMirroringRequest) = connection.request("Cast.startTabMirroring", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Stops the active Cast session on the sink.
     *
     * @link Protocol [Cast#stopCasting](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-stopCasting) method documentation.
     */
    fun stopCasting(input: StopCastingRequest) = connection.request("Cast.stopCasting", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  This is fired whenever the list of available sinks changes. A sink is a
device or a software surface that you can cast to.
     */
    fun sinksUpdated(): io.reactivex.Flowable<SinksUpdatedEvent> = connection.events("Cast.sinksUpdated", SinksUpdatedEvent::class.java)

    /**
     *  This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
     */
    fun issueUpdated(): io.reactivex.Flowable<IssueUpdatedEvent> = connection.events("Cast.issueUpdated", IssueUpdatedEvent::class.java)

    /**
     * Returns flowable capturing all Cast domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Cast"
        }
    }
}
/**
 * Represents request frame that can be used with [Cast#enable](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-enable) operation call.
 *
 * Starts observing for sinks that can be used for tab mirroring, and if set,
sinks compatible with |presentationUrl| as well. When sinks are found, a
|sinksUpdated| event is fired.
Also starts observing for issue messages. When an issue is added or removed,
an |issueUpdated| event is fired.
 * @link [Cast#enable](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-enable) method documentation.
 * @see [CastOperations.enable]
 */
data class EnableRequest(
    /**
     *
     */
    val presentationUrl: String? = null

)

/**
 * Represents request frame that can be used with [Cast#setSinkToUse](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-setSinkToUse) operation call.
 *
 * Sets a sink to be used when the web page requests the browser to choose a
sink via Presentation API, Remote Playback API, or Cast SDK.
 * @link [Cast#setSinkToUse](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-setSinkToUse) method documentation.
 * @see [CastOperations.setSinkToUse]
 */
data class SetSinkToUseRequest(
    /**
     *
     */
    val sinkName: String

)

/**
 * Represents request frame that can be used with [Cast#startTabMirroring](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-startTabMirroring) operation call.
 *
 * Starts mirroring the tab to the sink.
 * @link [Cast#startTabMirroring](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-startTabMirroring) method documentation.
 * @see [CastOperations.startTabMirroring]
 */
data class StartTabMirroringRequest(
    /**
     *
     */
    val sinkName: String

)

/**
 * Represents request frame that can be used with [Cast#stopCasting](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-stopCasting) operation call.
 *
 * Stops the active Cast session on the sink.
 * @link [Cast#stopCasting](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-stopCasting) method documentation.
 * @see [CastOperations.stopCasting]
 */
data class StopCastingRequest(
    /**
     *
     */
    val sinkName: String

)

/**
 * This is fired whenever the list of available sinks changes. A sink is a
device or a software surface that you can cast to.
 *
 * @link [Cast#sinksUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Cast#event-sinksUpdated) event documentation.
 */
data class SinksUpdatedEvent(
    /**  
     *  
     */  
    val sinks: List<Sink>

) : pl.wendigo.chrome.protocol.Event(domain = "Cast", name = "sinksUpdated")

/**
 * This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
 *
 * @link [Cast#issueUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Cast#event-issueUpdated) event documentation.
 */
data class IssueUpdatedEvent(
    /**  
     *  
     */  
    val issueMessage: String

) : pl.wendigo.chrome.protocol.Event(domain = "Cast", name = "issueUpdated")
