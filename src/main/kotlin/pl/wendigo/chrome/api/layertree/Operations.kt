package pl.wendigo.chrome.api.layertree

/**
 * LayerTreeOperations represents LayerTree protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [LayerTree](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class LayerTreeOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Provides the reasons why the given layer was composited.
     *
     * @link Protocol [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) method documentation.
     */
    fun compositingReasons(input: CompositingReasonsRequest) = connection.request("LayerTree.compositingReasons", input, CompositingReasonsResponse::class.java)

    /**
     * Disables compositing tree inspection.
     *
     * @link Protocol [LayerTree#disable](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-disable) method documentation.
     */
    fun disable() = connection.request("LayerTree.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables compositing tree inspection.
     *
     * @link Protocol [LayerTree#enable](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-enable) method documentation.
     */
    fun enable() = connection.request("LayerTree.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns the snapshot identifier.
     *
     * @link Protocol [LayerTree#loadSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-loadSnapshot) method documentation.
     */
    fun loadSnapshot(input: LoadSnapshotRequest) = connection.request("LayerTree.loadSnapshot", input, LoadSnapshotResponse::class.java)

    /**
     * Returns the layer snapshot identifier.
     *
     * @link Protocol [LayerTree#makeSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-makeSnapshot) method documentation.
     */
    fun makeSnapshot(input: MakeSnapshotRequest) = connection.request("LayerTree.makeSnapshot", input, MakeSnapshotResponse::class.java)

    /**
     *
     *
     * @link Protocol [LayerTree#profileSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-profileSnapshot) method documentation.
     */
    fun profileSnapshot(input: ProfileSnapshotRequest) = connection.request("LayerTree.profileSnapshot", input, ProfileSnapshotResponse::class.java)

    /**
     * Releases layer snapshot captured by the back-end.
     *
     * @link Protocol [LayerTree#releaseSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-releaseSnapshot) method documentation.
     */
    fun releaseSnapshot(input: ReleaseSnapshotRequest) = connection.request("LayerTree.releaseSnapshot", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Replays the layer snapshot and returns the resulting bitmap.
     *
     * @link Protocol [LayerTree#replaySnapshot](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-replaySnapshot) method documentation.
     */
    fun replaySnapshot(input: ReplaySnapshotRequest) = connection.request("LayerTree.replaySnapshot", input, ReplaySnapshotResponse::class.java)

    /**
     * Replays the layer snapshot and returns canvas log.
     *
     * @link Protocol [LayerTree#snapshotCommandLog](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-snapshotCommandLog) method documentation.
     */
    fun snapshotCommandLog(input: SnapshotCommandLogRequest) = connection.request("LayerTree.snapshotCommandLog", input, SnapshotCommandLogResponse::class.java)

    /**
     *  Returns observable capturing all LayerTree.layerPainted events.
     */
    fun layerPainted(): io.reactivex.rxjava3.core.Flowable<LayerPaintedEvent> = connection.events("LayerTree.layerPainted", LayerPaintedEvent::class.java)

    /**
     *  Returns observable capturing all LayerTree.layerTreeDidChange events.
     */
    fun layerTreeDidChange(): io.reactivex.rxjava3.core.Flowable<LayerTreeDidChangeEvent> = connection.events("LayerTree.layerTreeDidChange", LayerTreeDidChangeEvent::class.java)

    /**
     * Returns flowable capturing all LayerTree domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "LayerTree"
        }
    }
}

/**
 * Represents request frame that can be used with [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) operation call.
 *
 * Provides the reasons why the given layer was composited.
 * @link [LayerTree#compositingReasons](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#method-compositingReasons) method documentation.
 * @see [LayerTreeOperations.compositingReasons]
 */
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
 * @see [LayerTreeOperations.compositingReasons]
 */
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
 * @see [LayerTreeOperations.loadSnapshot]
 */
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
 * @see [LayerTreeOperations.loadSnapshot]
 */
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
 * @see [LayerTreeOperations.makeSnapshot]
 */
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
 * @see [LayerTreeOperations.makeSnapshot]
 */
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
 * @see [LayerTreeOperations.profileSnapshot]
 */
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
 * @see [LayerTreeOperations.profileSnapshot]
 */
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
 * @see [LayerTreeOperations.releaseSnapshot]
 */
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
 * @see [LayerTreeOperations.replaySnapshot]
 */
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
 * @see [LayerTreeOperations.replaySnapshot]
 */
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
 * @see [LayerTreeOperations.snapshotCommandLog]
 */
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
 * @see [LayerTreeOperations.snapshotCommandLog]
 */
data class SnapshotCommandLogResponse(
    /**  
     * The array of canvas function calls.  
     */  
    val commandLog: List<Any>

)

/**
 *
 *
 * @link [LayerTree#layerPainted](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#event-layerPainted) event documentation.
 */
data class LayerPaintedEvent(
    /**  
     * The id of the painted layer.  
     */  
    val layerId: LayerId,

    /**  
     * Clip rectangle.  
     */  
    val clip: pl.wendigo.chrome.api.dom.Rect

) : pl.wendigo.chrome.protocol.Event(domain = "LayerTree", name = "layerPainted")

/**
 *
 *
 * @link [LayerTree#layerTreeDidChange](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree#event-layerTreeDidChange) event documentation.
 */
data class LayerTreeDidChangeEvent(
    /**  
     * Layer tree, absent if not in the comspositing mode.  
     */  
    val layers: List<Layer>? = null

) : pl.wendigo.chrome.protocol.Event(domain = "LayerTree", name = "layerTreeDidChange")
