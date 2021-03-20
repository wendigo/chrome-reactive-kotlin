package pl.wendigo.chrome.api.cast

import kotlinx.serialization.json.Json

/**
 * A domain for interacting with Cast, Presentation API, and Remote Playback API
functionalities.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Cast](https://chromedevtools.github.io/devtools-protocol/tot/Cast) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class CastDomain internal constructor(connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) :
    pl.wendigo.chrome.api.Domain(
        "Cast",
        """A domain for interacting with Cast, Presentation API, and Remote Playback API
functionalities.""",
        connection
    ) {
    /**
     * Starts observing for sinks that can be used for tab mirroring, and if set,
sinks compatible with |presentationUrl| as well. When sinks are found, a
|sinksUpdated| event is fired.
Also starts observing for issue messages. When an issue is added or removed,
an |issueUpdated| event is fired.
     *
     * @link Protocol [Cast#enable](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-enable) method documentation.
     */
    
    fun enable(input: EnableRequest) = connection.request("Cast.enable", Json.encodeToJsonElement(EnableRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Stops observing for sinks and issues.
     *
     * @link Protocol [Cast#disable](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-disable) method documentation.
     */
    
    fun disable() = connection.request("Cast.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets a sink to be used when the web page requests the browser to choose a
sink via Presentation API, Remote Playback API, or Cast SDK.
     *
     * @link Protocol [Cast#setSinkToUse](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-setSinkToUse) method documentation.
     */
    
    fun setSinkToUse(input: SetSinkToUseRequest) = connection.request("Cast.setSinkToUse", Json.encodeToJsonElement(SetSinkToUseRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Starts mirroring the tab to the sink.
     *
     * @link Protocol [Cast#startTabMirroring](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-startTabMirroring) method documentation.
     */
    
    fun startTabMirroring(input: StartTabMirroringRequest) = connection.request("Cast.startTabMirroring", Json.encodeToJsonElement(StartTabMirroringRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Stops the active Cast session on the sink.
     *
     * @link Protocol [Cast#stopCasting](https://chromedevtools.github.io/devtools-protocol/tot/Cast#method-stopCasting) method documentation.
     */
    
    fun stopCasting(input: StopCastingRequest) = connection.request("Cast.stopCasting", Json.encodeToJsonElement(StopCastingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  This is fired whenever the list of available sinks changes. A sink is a
device or a software surface that you can cast to.
     */
    fun sinksUpdated(): io.reactivex.rxjava3.core.Flowable<SinksUpdatedEvent> = connection.events("Cast.sinksUpdated", SinksUpdatedEvent.serializer())

    /**
     *  This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
     */
    fun issueUpdated(): io.reactivex.rxjava3.core.Flowable<IssueUpdatedEvent> = connection.events("Cast.issueUpdated", IssueUpdatedEvent.serializer())
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
data class SinksUpdatedEvent(
    /**  
     *  
     */  
    val sinks: List<Sink>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Cast" 
    override fun eventName() = "sinksUpdated"
} 

/**
 * This is fired whenever the outstanding issue/error message changes.
|issueMessage| is empty if there is no issue.
 *
 * @link [Cast#issueUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Cast#event-issueUpdated) event documentation.
 */
@kotlinx.serialization.Serializable
data class IssueUpdatedEvent(
    /**  
     *  
     */  
    val issueMessage: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Cast" 
    override fun eventName() = "issueUpdated"
} 
