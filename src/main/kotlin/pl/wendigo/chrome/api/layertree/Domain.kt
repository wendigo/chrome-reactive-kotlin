package pl.wendigo.chrome.api.layertree

import kotlinx.serialization.json.Json

/**
 * LayerTreeDomain represents LayerTree protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [LayerTree](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class LayerTreeDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("LayerTree", """""", connection) {
    /**
     * Provides the reasons why the given layer was composited.
     *
     * @link Protocol [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) method documentation.
     */
    
    fun compositingReasons(input: CompositingReasonsRequest): io.reactivex.rxjava3.core.Single<CompositingReasonsResponse> = connection.request("LayerTree.compositingReasons", Json.encodeToJsonElement(CompositingReasonsRequest.serializer(), input), CompositingReasonsResponse.serializer())

    /**
     * Disables compositing tree inspection.
     *
     * @link Protocol [LayerTree#disable](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("LayerTree.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Enables compositing tree inspection.
     *
     * @link Protocol [LayerTree#enable](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("LayerTree.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Returns the snapshot identifier.
     *
     * @link Protocol [LayerTree#loadSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-loadSnapshot) method documentation.
     */
    
    fun loadSnapshot(input: LoadSnapshotRequest): io.reactivex.rxjava3.core.Single<LoadSnapshotResponse> = connection.request("LayerTree.loadSnapshot", Json.encodeToJsonElement(LoadSnapshotRequest.serializer(), input), LoadSnapshotResponse.serializer())

    /**
     * Returns the layer snapshot identifier.
     *
     * @link Protocol [LayerTree#makeSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-makeSnapshot) method documentation.
     */
    
    fun makeSnapshot(input: MakeSnapshotRequest): io.reactivex.rxjava3.core.Single<MakeSnapshotResponse> = connection.request("LayerTree.makeSnapshot", Json.encodeToJsonElement(MakeSnapshotRequest.serializer(), input), MakeSnapshotResponse.serializer())

    /**
     *
     *
     * @link Protocol [LayerTree#profileSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-profileSnapshot) method documentation.
     */
    
    fun profileSnapshot(input: ProfileSnapshotRequest): io.reactivex.rxjava3.core.Single<ProfileSnapshotResponse> = connection.request("LayerTree.profileSnapshot", Json.encodeToJsonElement(ProfileSnapshotRequest.serializer(), input), ProfileSnapshotResponse.serializer())

    /**
     * Releases layer snapshot captured by the back-end.
     *
     * @link Protocol [LayerTree#releaseSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-releaseSnapshot) method documentation.
     */
    
    fun releaseSnapshot(input: ReleaseSnapshotRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("LayerTree.releaseSnapshot", Json.encodeToJsonElement(ReleaseSnapshotRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Replays the layer snapshot and returns the resulting bitmap.
     *
     * @link Protocol [LayerTree#replaySnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-replaySnapshot) method documentation.
     */
    
    fun replaySnapshot(input: ReplaySnapshotRequest): io.reactivex.rxjava3.core.Single<ReplaySnapshotResponse> = connection.request("LayerTree.replaySnapshot", Json.encodeToJsonElement(ReplaySnapshotRequest.serializer(), input), ReplaySnapshotResponse.serializer())

    /**
     * Replays the layer snapshot and returns canvas log.
     *
     * @link Protocol [LayerTree#snapshotCommandLog](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-snapshotCommandLog) method documentation.
     */
    
    fun snapshotCommandLog(input: SnapshotCommandLogRequest): io.reactivex.rxjava3.core.Single<SnapshotCommandLogResponse> = connection.request("LayerTree.snapshotCommandLog", Json.encodeToJsonElement(SnapshotCommandLogRequest.serializer(), input), SnapshotCommandLogResponse.serializer())

    /**
     *  Returns observable capturing all LayerTree.layerPainted events.
     */
    fun layerPainted(): io.reactivex.rxjava3.core.Flowable<LayerPaintedEvent> = connection.events("LayerTree.layerPainted", LayerPaintedEvent.serializer())

    /**
     *  Returns observable capturing all LayerTree.layerTreeDidChange events.
     */
    fun layerTreeDidChange(): io.reactivex.rxjava3.core.Flowable<LayerTreeDidChangeEvent> = connection.events("LayerTree.layerTreeDidChange", LayerTreeDidChangeEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) operation call.
 *
 * Provides the reasons why the given layer was composited.
 * @link [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) method documentation.
 * @see [LayerTreeDomain.compositingReasons]
 */
@kotlinx.serialization.Serializable
data class CompositingReasonsRequest(
    /**
     * The id of the layer for which we want to get the reasons it was composited.
     */
    val layerId: LayerId

)

/**
 * Represents response frame that is returned from [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) operation call.
 * Provides the reasons why the given layer was composited.
 *
  
 * @link [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) method documentation.
 * @see [LayerTreeDomain.compositingReasons]
 */
@kotlinx.serialization.Serializable
data class CompositingReasonsResponse(
    /**  
     * A list of strings specifying reasons for the given layer to become composited.  
     */  
    val compositingReasons: List<String>,

    /**  
     * A list of strings specifying reason IDs for the given layer to become composited.  
     */  
    val compositingReasonIds: List<String>

)

/**
 * Represents request frame that can be used with [LayerTree#loadSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-loadSnapshot) operation call.
 *
 * Returns the snapshot identifier.
 * @link [LayerTree#loadSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-loadSnapshot) method documentation.
 * @see [LayerTreeDomain.loadSnapshot]
 */
@kotlinx.serialization.Serializable
data class LoadSnapshotRequest(
    /**
     * An array of tiles composing the snapshot.
     */
    val tiles: List<PictureTile>

)

/**
 * Represents response frame that is returned from [LayerTree#loadSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-loadSnapshot) operation call.
 * Returns the snapshot identifier.
 *
  
 * @link [LayerTree#loadSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-loadSnapshot) method documentation.
 * @see [LayerTreeDomain.loadSnapshot]
 */
@kotlinx.serialization.Serializable
data class LoadSnapshotResponse(
    /**  
     * The id of the snapshot.  
     */  
    val snapshotId: SnapshotId

)

/**
 * Represents request frame that can be used with [LayerTree#makeSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-makeSnapshot) operation call.
 *
 * Returns the layer snapshot identifier.
 * @link [LayerTree#makeSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-makeSnapshot) method documentation.
 * @see [LayerTreeDomain.makeSnapshot]
 */
@kotlinx.serialization.Serializable
data class MakeSnapshotRequest(
    /**
     * The id of the layer.
     */
    val layerId: LayerId

)

/**
 * Represents response frame that is returned from [LayerTree#makeSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-makeSnapshot) operation call.
 * Returns the layer snapshot identifier.
 *
  
 * @link [LayerTree#makeSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-makeSnapshot) method documentation.
 * @see [LayerTreeDomain.makeSnapshot]
 */
@kotlinx.serialization.Serializable
data class MakeSnapshotResponse(
    /**  
     * The id of the layer snapshot.  
     */  
    val snapshotId: SnapshotId

)

/**
 * Represents request frame that can be used with [LayerTree#profileSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-profileSnapshot) operation call.
 *
 *
 * @link [LayerTree#profileSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-profileSnapshot) method documentation.
 * @see [LayerTreeDomain.profileSnapshot]
 */
@kotlinx.serialization.Serializable
data class ProfileSnapshotRequest(
    /**
     * The id of the layer snapshot.
     */
    val snapshotId: SnapshotId,

    /**
     * The maximum number of times to replay the snapshot (1, if not specified).
     */
    val minRepeatCount: Int? = null,

    /**
     * The minimum duration (in seconds) to replay the snapshot.
     */
    val minDuration: Double? = null,

    /**
     * The clip rectangle to apply when replaying the snapshot.
     */
    val clipRect: pl.wendigo.chrome.api.dom.Rect? = null

)

/**
 * Represents response frame that is returned from [LayerTree#profileSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-profileSnapshot) operation call.
 *
 *
  
 * @link [LayerTree#profileSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-profileSnapshot) method documentation.
 * @see [LayerTreeDomain.profileSnapshot]
 */
@kotlinx.serialization.Serializable
data class ProfileSnapshotResponse(
    /**  
     * The array of paint profiles, one per run.  
     */  
    val timings: List<PaintProfile>

)

/**
 * Represents request frame that can be used with [LayerTree#releaseSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-releaseSnapshot) operation call.
 *
 * Releases layer snapshot captured by the back-end.
 * @link [LayerTree#releaseSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-releaseSnapshot) method documentation.
 * @see [LayerTreeDomain.releaseSnapshot]
 */
@kotlinx.serialization.Serializable
data class ReleaseSnapshotRequest(
    /**
     * The id of the layer snapshot.
     */
    val snapshotId: SnapshotId

)

/**
 * Represents request frame that can be used with [LayerTree#replaySnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-replaySnapshot) operation call.
 *
 * Replays the layer snapshot and returns the resulting bitmap.
 * @link [LayerTree#replaySnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-replaySnapshot) method documentation.
 * @see [LayerTreeDomain.replaySnapshot]
 */
@kotlinx.serialization.Serializable
data class ReplaySnapshotRequest(
    /**
     * The id of the layer snapshot.
     */
    val snapshotId: SnapshotId,

    /**
     * The first step to replay from (replay from the very start if not specified).
     */
    val fromStep: Int? = null,

    /**
     * The last step to replay to (replay till the end if not specified).
     */
    val toStep: Int? = null,

    /**
     * The scale to apply while replaying (defaults to 1).
     */
    val scale: Double? = null

)

/**
 * Represents response frame that is returned from [LayerTree#replaySnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-replaySnapshot) operation call.
 * Replays the layer snapshot and returns the resulting bitmap.
 *
  
 * @link [LayerTree#replaySnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-replaySnapshot) method documentation.
 * @see [LayerTreeDomain.replaySnapshot]
 */
@kotlinx.serialization.Serializable
data class ReplaySnapshotResponse(
    /**  
     * A data: URL for resulting image.  
     */  
    val dataURL: String

)

/**
 * Represents request frame that can be used with [LayerTree#snapshotCommandLog](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-snapshotCommandLog) operation call.
 *
 * Replays the layer snapshot and returns canvas log.
 * @link [LayerTree#snapshotCommandLog](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-snapshotCommandLog) method documentation.
 * @see [LayerTreeDomain.snapshotCommandLog]
 */
@kotlinx.serialization.Serializable
data class SnapshotCommandLogRequest(
    /**
     * The id of the layer snapshot.
     */
    val snapshotId: SnapshotId

)

/**
 * Represents response frame that is returned from [LayerTree#snapshotCommandLog](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-snapshotCommandLog) operation call.
 * Replays the layer snapshot and returns canvas log.
 *
  
 * @link [LayerTree#snapshotCommandLog](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-snapshotCommandLog) method documentation.
 * @see [LayerTreeDomain.snapshotCommandLog]
 */
@kotlinx.serialization.Serializable
data class SnapshotCommandLogResponse(
    /**  
     * The array of canvas function calls.  
     */  
    val commandLog: List<kotlinx.serialization.json.JsonElement>

)

/**
 *
 *
 * @link [LayerTree#layerPainted](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#event-layerPainted) event documentation.
 */
@kotlinx.serialization.Serializable
data class LayerPaintedEvent(
    /**  
     * The id of the painted layer.  
     */  
    val layerId: LayerId,

    /**  
     * Clip rectangle.  
     */  
    val clip: pl.wendigo.chrome.api.dom.Rect

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "LayerTree" 
    override fun eventName() = "layerPainted"
} 

/**
 *
 *
 * @link [LayerTree#layerTreeDidChange](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#event-layerTreeDidChange) event documentation.
 */
@kotlinx.serialization.Serializable
data class LayerTreeDidChangeEvent(
    /**  
     * Layer tree, absent if not in the comspositing mode.  
     */  
    val layers: List<Layer>? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "LayerTree" 
    override fun eventName() = "layerTreeDidChange"
} 
