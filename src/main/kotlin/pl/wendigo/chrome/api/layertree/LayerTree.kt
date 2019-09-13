package pl.wendigo.chrome.domain.layertree

/**
 * LayerTree represents remote debugger protocol domain.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/LayerTree](https://chromedevtools.github.io/devtools-protocol/tot/LayerTree)
 */
class LayerTree internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Provides the reasons why the given layer was composited.
     */
    fun compositingReasons(input: CompositingReasonsRequest): io.reactivex.Single<CompositingReasonsResponse> {
        return connectionRemote.runAndCaptureResponse("LayerTree.compositingReasons", input, CompositingReasonsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Disables compositing tree inspection.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("LayerTree.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables compositing tree inspection.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("LayerTree.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the snapshot identifier.
     */
    fun loadSnapshot(input: LoadSnapshotRequest): io.reactivex.Single<LoadSnapshotResponse> {
        return connectionRemote.runAndCaptureResponse("LayerTree.loadSnapshot", input, LoadSnapshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the layer snapshot identifier.
     */
    fun makeSnapshot(input: MakeSnapshotRequest): io.reactivex.Single<MakeSnapshotResponse> {
        return connectionRemote.runAndCaptureResponse("LayerTree.makeSnapshot", input, MakeSnapshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun profileSnapshot(input: ProfileSnapshotRequest): io.reactivex.Single<ProfileSnapshotResponse> {
        return connectionRemote.runAndCaptureResponse("LayerTree.profileSnapshot", input, ProfileSnapshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Releases layer snapshot captured by the back-end.
     */
    fun releaseSnapshot(input: ReleaseSnapshotRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("LayerTree.releaseSnapshot", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Replays the layer snapshot and returns the resulting bitmap.
     */
    fun replaySnapshot(input: ReplaySnapshotRequest): io.reactivex.Single<ReplaySnapshotResponse> {
        return connectionRemote.runAndCaptureResponse("LayerTree.replaySnapshot", input, ReplaySnapshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Replays the layer snapshot and returns canvas log.
     */
    fun snapshotCommandLog(input: SnapshotCommandLogRequest): io.reactivex.Single<SnapshotCommandLogResponse> {
        return connectionRemote.runAndCaptureResponse("LayerTree.snapshotCommandLog", input, SnapshotCommandLogResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all LayerTree.layerPainted events.
     */
    fun layerPainted(): io.reactivex.Flowable<LayerPaintedEvent> {
        return layerPaintedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all LayerTree.layerPainted events.
     */
    fun layerPaintedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<LayerPaintedEvent>> {
        return connectionRemote.captureEvents("LayerTree.layerPainted", LayerPaintedEvent::class.java)
    }

    /**
     * Returns observable capturing all LayerTree.layerTreeDidChange events.
     */
    fun layerTreeDidChange(): io.reactivex.Flowable<LayerTreeDidChangeEvent> {
        return layerTreeDidChangeTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all LayerTree.layerTreeDidChange events.
     */
    fun layerTreeDidChangeTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<LayerTreeDidChangeEvent>> {
        return connectionRemote.captureEvents("LayerTree.layerTreeDidChange", LayerTreeDidChangeEvent::class.java)
    }

    /**
     * Returns flowable capturing all LayerTree domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "LayerTree"
        }
    }
}
/**
 * Represents request frame that can be used with LayerTree.compositingReasons method call.
 *
 * Provides the reasons why the given layer was composited.
 */
data class CompositingReasonsRequest(
    /**
     * The id of the layer for which we want to get the reasons it was composited.
     */
    val layerId: LayerId

)

/**
 * Represents response frame for LayerTree.compositingReasons method call.
 *
 * Provides the reasons why the given layer was composited.
 */
data class CompositingReasonsResponse(
    /**  
     * A list of strings specifying reasons for the given layer to become composited.  
     */  
    val compositingReasons: List<String>

)

/**
 * Represents request frame that can be used with LayerTree.loadSnapshot method call.
 *
 * Returns the snapshot identifier.
 */
data class LoadSnapshotRequest(
    /**
     * An array of tiles composing the snapshot.
     */
    val tiles: List<PictureTile>

)

/**
 * Represents response frame for LayerTree.loadSnapshot method call.
 *
 * Returns the snapshot identifier.
 */
data class LoadSnapshotResponse(
    /**  
     * The id of the snapshot.  
     */  
    val snapshotId: SnapshotId

)

/**
 * Represents request frame that can be used with LayerTree.makeSnapshot method call.
 *
 * Returns the layer snapshot identifier.
 */
data class MakeSnapshotRequest(
    /**
     * The id of the layer.
     */
    val layerId: LayerId

)

/**
 * Represents response frame for LayerTree.makeSnapshot method call.
 *
 * Returns the layer snapshot identifier.
 */
data class MakeSnapshotResponse(
    /**  
     * The id of the layer snapshot.  
     */  
    val snapshotId: SnapshotId

)

/**
 * Represents request frame that can be used with LayerTree.profileSnapshot method call.
 *
 *
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
    val clipRect: pl.wendigo.chrome.domain.dom.Rect? = null

)

/**
 * Represents response frame for LayerTree.profileSnapshot method call.
 *
 *
 */
data class ProfileSnapshotResponse(
    /**  
     * The array of paint profiles, one per run.  
     */  
    val timings: List<PaintProfile>

)

/**
 * Represents request frame that can be used with LayerTree.releaseSnapshot method call.
 *
 * Releases layer snapshot captured by the back-end.
 */
data class ReleaseSnapshotRequest(
    /**
     * The id of the layer snapshot.
     */
    val snapshotId: SnapshotId

)

/**
 * Represents request frame that can be used with LayerTree.replaySnapshot method call.
 *
 * Replays the layer snapshot and returns the resulting bitmap.
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
 * Represents response frame for LayerTree.replaySnapshot method call.
 *
 * Replays the layer snapshot and returns the resulting bitmap.
 */
data class ReplaySnapshotResponse(
    /**  
     * A data: URL for resulting image.  
     */  
    val dataURL: String

)

/**
 * Represents request frame that can be used with LayerTree.snapshotCommandLog method call.
 *
 * Replays the layer snapshot and returns canvas log.
 */
data class SnapshotCommandLogRequest(
    /**
     * The id of the layer snapshot.
     */
    val snapshotId: SnapshotId

)

/**
 * Represents response frame for LayerTree.snapshotCommandLog method call.
 *
 * Replays the layer snapshot and returns canvas log.
 */
data class SnapshotCommandLogResponse(
    /**  
     * The array of canvas function calls.  
     */  
    val commandLog: List<Any>

)

/**
 * Represents event frames for LayerTree.layerPainted
 *
 *
 */
data class LayerPaintedEvent(
    /**  
     * The id of the painted layer.  
     */  
    val layerId: LayerId,

    /**  
     * Clip rectangle.  
     */  
    val clip: pl.wendigo.chrome.domain.dom.Rect

) : pl.wendigo.chrome.ProtocolEvent(domain = "LayerTree", name = "layerPainted")

/**
 * Represents event frames for LayerTree.layerTreeDidChange
 *
 *
 */
data class LayerTreeDidChangeEvent(
    /**  
     * Layer tree, absent if not in the comspositing mode.  
     */  
    val layers: List<Layer>? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "LayerTree", name = "layerTreeDidChange")
