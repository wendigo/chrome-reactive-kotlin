package pl.wendigo.chrome.domain.layertree

/**
 * LayerTreeDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class LayerTreeDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables compositing tree inspection.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("LayerTree.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables compositing tree inspection.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("LayerTree.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Provides the reasons why the given layer was composited.
	 */
	  fun compositingReasons(input : CompositingReasonsRequest) : io.reactivex.Flowable<CompositingReasonsResponse> {
        return connection.runAndCaptureResponse("LayerTree.compositingReasons", input, CompositingReasonsResponse::class.java)
	}

	/**
	 * Returns the layer snapshot identifier.
	 */
	  fun makeSnapshot(input : MakeSnapshotRequest) : io.reactivex.Flowable<MakeSnapshotResponse> {
        return connection.runAndCaptureResponse("LayerTree.makeSnapshot", input, MakeSnapshotResponse::class.java)
	}

	/**
	 * Returns the snapshot identifier.
	 */
	  fun loadSnapshot(input : LoadSnapshotRequest) : io.reactivex.Flowable<LoadSnapshotResponse> {
        return connection.runAndCaptureResponse("LayerTree.loadSnapshot", input, LoadSnapshotResponse::class.java)
	}

	/**
	 * Releases layer snapshot captured by the back-end.
	 */
	  fun releaseSnapshot(input : ReleaseSnapshotRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("LayerTree.releaseSnapshot", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun profileSnapshot(input : ProfileSnapshotRequest) : io.reactivex.Flowable<ProfileSnapshotResponse> {
        return connection.runAndCaptureResponse("LayerTree.profileSnapshot", input, ProfileSnapshotResponse::class.java)
	}

	/**
	 * Replays the layer snapshot and returns the resulting bitmap.
	 */
	  fun replaySnapshot(input : ReplaySnapshotRequest) : io.reactivex.Flowable<ReplaySnapshotResponse> {
        return connection.runAndCaptureResponse("LayerTree.replaySnapshot", input, ReplaySnapshotResponse::class.java)
	}

	/**
	 * Replays the layer snapshot and returns canvas log.
	 */
	  fun snapshotCommandLog(input : SnapshotCommandLogRequest) : io.reactivex.Flowable<SnapshotCommandLogResponse> {
        return connection.runAndCaptureResponse("LayerTree.snapshotCommandLog", input, SnapshotCommandLogResponse::class.java)
	}

  
  /**
   * 
   */
   fun layerTreeDidChange() : io.reactivex.Flowable<LayerTreeDidChangeEvent> {
      return connection.captureEvents("LayerTree.layerTreeDidChange", LayerTreeDidChangeEvent::class.java)
   }

  /**
   * 
   */
   fun layerPainted() : io.reactivex.Flowable<LayerPaintedEvent> {
      return connection.captureEvents("LayerTree.layerPainted", LayerPaintedEvent::class.java)
   }
}





/**
 * Represents requestFrame parameters that can be used with LayerTree.compositingReasons method call.
 *
 * Provides the reasons why the given layer was composited.
 */
data class CompositingReasonsRequest (
    /**
     * The id of the layer for which we want to get the reasons it was composited.
     */
    val layerId : LayerId

)

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * Provides the reasons why the given layer was composited.
 */
data class CompositingReasonsResponse(
  /**
   * A list of strings specifying reasons for the given layer to become composited.
   */
  val compositingReasons : Array<String>

)

/**
 * Represents requestFrame parameters that can be used with LayerTree.makeSnapshot method call.
 *
 * Returns the layer snapshot identifier.
 */
data class MakeSnapshotRequest (
    /**
     * The id of the layer.
     */
    val layerId : LayerId

)

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * Returns the layer snapshot identifier.
 */
data class MakeSnapshotResponse(
  /**
   * The id of the layer snapshot.
   */
  val snapshotId : SnapshotId

)

/**
 * Represents requestFrame parameters that can be used with LayerTree.loadSnapshot method call.
 *
 * Returns the snapshot identifier.
 */
data class LoadSnapshotRequest (
    /**
     * An array of tiles composing the snapshot.
     */
    val tiles : Array<PictureTile>

)

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * Returns the snapshot identifier.
 */
data class LoadSnapshotResponse(
  /**
   * The id of the snapshot.
   */
  val snapshotId : SnapshotId

)

/**
 * Represents requestFrame parameters that can be used with LayerTree.releaseSnapshot method call.
 *
 * Releases layer snapshot captured by the back-end.
 */
data class ReleaseSnapshotRequest (
    /**
     * The id of the layer snapshot.
     */
    val snapshotId : SnapshotId

)


/**
 * Represents requestFrame parameters that can be used with LayerTree.profileSnapshot method call.
 *
 * 
 */
data class ProfileSnapshotRequest (
    /**
     * The id of the layer snapshot.
     */
    val snapshotId : SnapshotId,

    /**
     * The maximum number of times to replay the snapshot (1, if not specified).
     */
    val minRepeatCount : Int? = null,

    /**
     * The minimum duration (in seconds) to replay the snapshot.
     */
    val minDuration : Double? = null,

    /**
     * The clip rectangle to apply when replaying the snapshot.
     */
    val clipRect : pl.wendigo.chrome.domain.dom.Rect? = null

)

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * 
 */
data class ProfileSnapshotResponse(
  /**
   * The array of paint profiles, one per run.
   */
  val timings : Array<PaintProfile>

)

/**
 * Represents requestFrame parameters that can be used with LayerTree.replaySnapshot method call.
 *
 * Replays the layer snapshot and returns the resulting bitmap.
 */
data class ReplaySnapshotRequest (
    /**
     * The id of the layer snapshot.
     */
    val snapshotId : SnapshotId,

    /**
     * The first step to replay from (replay from the very start if not specified).
     */
    val fromStep : Int? = null,

    /**
     * The last step to replay to (replay till the end if not specified).
     */
    val toStep : Int? = null,

    /**
     * The scale to apply while replaying (defaults to 1).
     */
    val scale : Double? = null

)

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * Replays the layer snapshot and returns the resulting bitmap.
 */
data class ReplaySnapshotResponse(
  /**
   * A data: URL for resulting image.
   */
  val dataURL : String

)

/**
 * Represents requestFrame parameters that can be used with LayerTree.snapshotCommandLog method call.
 *
 * Replays the layer snapshot and returns canvas log.
 */
data class SnapshotCommandLogRequest (
    /**
     * The id of the layer snapshot.
     */
    val snapshotId : SnapshotId

)

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * Replays the layer snapshot and returns canvas log.
 */
data class SnapshotCommandLogResponse(
  /**
   * The array of canvas function calls.
   */
  val commandLog : Array<Any>

)


/**
 * Represents responseFrame from LayerTree. method call.
 *
 * 
 */
data class LayerTreeDidChangeEvent(
  /**
   * Layer tree, absent if not in the comspositing mode.
   */
  val layers : Array<Layer>? = null

) : pl.wendigo.chrome.DebuggerEvent(domain = "LayerTree", name = "layerTreeDidChange")

/**
 * Represents responseFrame from LayerTree. method call.
 *
 * 
 */
data class LayerPaintedEvent(
  /**
   * The id of the painted layer.
   */
  val layerId : LayerId,

  /**
   * Clip rectangle.
   */
  val clip : pl.wendigo.chrome.domain.dom.Rect

) : pl.wendigo.chrome.DebuggerEvent(domain = "LayerTree", name = "layerPainted")

