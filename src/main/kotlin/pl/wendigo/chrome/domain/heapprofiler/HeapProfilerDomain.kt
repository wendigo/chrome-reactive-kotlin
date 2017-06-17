package pl.wendigo.chrome.domain.heapprofiler

/**
 * HeapProfilerDomain represents remote debugger protocol domain.
 */
class HeapProfilerDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     *
     */
    fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun startTrackingHeapObjects(input : StartTrackingHeapObjectsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.startTrackingHeapObjects", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun stopTrackingHeapObjects(input : StopTrackingHeapObjectsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.stopTrackingHeapObjects", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun takeHeapSnapshot(input : TakeHeapSnapshotRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.takeHeapSnapshot", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun collectGarbage() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.collectGarbage", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun getObjectByHeapObjectId(input : GetObjectByHeapObjectIdRequest) : io.reactivex.Single<GetObjectByHeapObjectIdResponse> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.getObjectByHeapObjectId", input, GetObjectByHeapObjectIdResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
     */
    fun addInspectedHeapObject(input : AddInspectedHeapObjectRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.addInspectedHeapObject", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun getHeapObjectId(input : GetHeapObjectIdRequest) : io.reactivex.Single<GetHeapObjectIdResponse> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.getHeapObjectId", input, GetHeapObjectIdResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun startSampling(input : StartSamplingRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.startSampling", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun stopSampling() : io.reactivex.Single<StopSamplingResponse> {
        return connectionRemote.runAndCaptureResponse("HeapProfiler.stopSampling", null, StopSamplingResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all HeapProfiler.addHeapSnapshotChunk events.
     */
    fun addHeapSnapshotChunk() : io.reactivex.Flowable<AddHeapSnapshotChunkEvent> {
        return addHeapSnapshotChunkTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all HeapProfiler.addHeapSnapshotChunk events.
     */
    fun addHeapSnapshotChunkTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<AddHeapSnapshotChunkEvent>> {
        return connectionRemote.captureEvents("HeapProfiler.addHeapSnapshotChunk", AddHeapSnapshotChunkEvent::class.java)
    }

    /**
     * Returns observable capturing all HeapProfiler.resetProfiles events.
     */
    fun resetProfiles() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return resetProfilesTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all HeapProfiler.resetProfiles events.
     */
    fun resetProfilesTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("HeapProfiler.resetProfiles", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Returns observable capturing all HeapProfiler.reportHeapSnapshotProgress events.
     */
    fun reportHeapSnapshotProgress() : io.reactivex.Flowable<ReportHeapSnapshotProgressEvent> {
        return reportHeapSnapshotProgressTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all HeapProfiler.reportHeapSnapshotProgress events.
     */
    fun reportHeapSnapshotProgressTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ReportHeapSnapshotProgressEvent>> {
        return connectionRemote.captureEvents("HeapProfiler.reportHeapSnapshotProgress", ReportHeapSnapshotProgressEvent::class.java)
    }

    /**
     * If heap objects tracking has been started then backend regularly sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
     */
    fun lastSeenObjectId() : io.reactivex.Flowable<LastSeenObjectIdEvent> {
        return lastSeenObjectIdTimed().map {
            it.value()
        }
    }

    /**
     * If heap objects tracking has been started then backend regularly sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
     */
    fun lastSeenObjectIdTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<LastSeenObjectIdEvent>> {
        return connectionRemote.captureEvents("HeapProfiler.lastSeenObjectId", LastSeenObjectIdEvent::class.java)
    }

    /**
     * If heap objects tracking has been started then backend may send update for one or more fragments
     */
    fun heapStatsUpdate() : io.reactivex.Flowable<HeapStatsUpdateEvent> {
        return heapStatsUpdateTimed().map {
            it.value()
        }
    }

    /**
     * If heap objects tracking has been started then backend may send update for one or more fragments
     */
    fun heapStatsUpdateTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<HeapStatsUpdateEvent>> {
        return connectionRemote.captureEvents("HeapProfiler.heapStatsUpdate", HeapStatsUpdateEvent::class.java)
    }

    /**
     * Returns flowable capturing all HeapProfiler domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "HeapProfiler"
        }
    }
}

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.startTrackingHeapObjects method call.
 *
 *
 */
data class StartTrackingHeapObjectsRequest (
    /**
     *
     */
    val trackAllocations : Boolean? = null

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.stopTrackingHeapObjects method call.
 *
 *
 */
data class StopTrackingHeapObjectsRequest (
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken when the tracking is stopped.
     */
    val reportProgress : Boolean? = null

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.takeHeapSnapshot method call.
 *
 *
 */
data class TakeHeapSnapshotRequest (
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
     */
    val reportProgress : Boolean? = null

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.getObjectByHeapObjectId method call.
 *
 *
 */
data class GetObjectByHeapObjectIdRequest (
    /**
     *
     */
    val objectId : HeapSnapshotObjectId,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup : String? = null

)

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 *
 */
data class GetObjectByHeapObjectIdResponse(
  /**
   * Evaluation result.
   */
  val result : pl.wendigo.chrome.domain.runtime.RemoteObject

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.addInspectedHeapObject method call.
 *
 * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
 */
data class AddInspectedHeapObjectRequest (
    /**
     * Heap snapshot object id to be accessible by means of $x command line API.
     */
    val heapObjectId : HeapSnapshotObjectId

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.getHeapObjectId method call.
 *
 *
 */
data class GetHeapObjectIdRequest (
    /**
     * Identifier of the object to get heap object id for.
     */
    val objectId : pl.wendigo.chrome.domain.runtime.RemoteObjectId

)

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 *
 */
data class GetHeapObjectIdResponse(
  /**
   * Id of the heap snapshot object corresponding to the passed remote object id.
   */
  val heapSnapshotObjectId : HeapSnapshotObjectId

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.startSampling method call.
 *
 *
 */
data class StartSamplingRequest (
    /**
     * Average sample interval in bytes. Poisson distribution is used for the intervals. The default value is 32768 bytes.
     */
    val samplingInterval : Double? = null

)

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 *
 */
data class StopSamplingResponse(
  /**
   * Recorded sampling heap profile.
   */
  val profile : SamplingHeapProfile

)

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 *
 */
data class AddHeapSnapshotChunkEvent(
  /**
   *
   */
  val chunk : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "HeapProfiler", name = "addHeapSnapshotChunk")

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 *
 */
data class ReportHeapSnapshotProgressEvent(
  /**
   *
   */
  val done : Int,

  /**
   *
   */
  val total : Int,

  /**
   *
   */
  val finished : Boolean? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "HeapProfiler", name = "reportHeapSnapshotProgress")

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * If heap objects tracking has been started then backend regularly sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 */
data class LastSeenObjectIdEvent(
  /**
   *
   */
  val lastSeenObjectId : Int,

  /**
   *
   */
  val timestamp : Double

) : pl.wendigo.chrome.ProtocolEvent(domain = "HeapProfiler", name = "lastSeenObjectId")

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * If heap objects tracking has been started then backend may send update for one or more fragments
 */
data class HeapStatsUpdateEvent(
  /**
   * An array of triplets. Each triplet describes a fragment. The first integer is the fragment index, the second integer is a total count of objects for the fragment, the third integer is a total size of the objects for the fragment.
   */
  val statsUpdate : List<Int>

) : pl.wendigo.chrome.ProtocolEvent(domain = "HeapProfiler", name = "heapStatsUpdate")

