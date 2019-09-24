package pl.wendigo.chrome.api.heapprofiler

/**
 * HeapProfilerOperations represents HeapProfiler protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [HeapProfiler](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class HeapProfilerOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Enables console to refer to the node with given id via $x (see Command Line API for more details
$x functions).
     *
     * @link Protocol [HeapProfiler#addInspectedHeapObject](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-addInspectedHeapObject) method documentation.
     */
    fun addInspectedHeapObject(input: AddInspectedHeapObjectRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.addInspectedHeapObject", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#collectGarbage](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-collectGarbage) method documentation.
     */
    fun collectGarbage(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.collectGarbage", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#disable](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#enable](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-enable) method documentation.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#getHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getHeapObjectId) method documentation.
     */
    fun getHeapObjectId(input: GetHeapObjectIdRequest): io.reactivex.Single<GetHeapObjectIdResponse> = connection.runAndCaptureResponse("HeapProfiler.getHeapObjectId", input, GetHeapObjectIdResponse::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#getObjectByHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getObjectByHeapObjectId) method documentation.
     */
    fun getObjectByHeapObjectId(input: GetObjectByHeapObjectIdRequest): io.reactivex.Single<GetObjectByHeapObjectIdResponse> = connection.runAndCaptureResponse("HeapProfiler.getObjectByHeapObjectId", input, GetObjectByHeapObjectIdResponse::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getSamplingProfile) method documentation.
     */
    fun getSamplingProfile(): io.reactivex.Single<GetSamplingProfileResponse> = connection.runAndCaptureResponse("HeapProfiler.getSamplingProfile", null, GetSamplingProfileResponse::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startSampling) method documentation.
     */
    fun startSampling(input: StartSamplingRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.startSampling", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#startTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startTrackingHeapObjects) method documentation.
     */
    fun startTrackingHeapObjects(input: StartTrackingHeapObjectsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.startTrackingHeapObjects", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#stopSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopSampling) method documentation.
     */
    fun stopSampling(): io.reactivex.Single<StopSamplingResponse> = connection.runAndCaptureResponse("HeapProfiler.stopSampling", null, StopSamplingResponse::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#stopTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopTrackingHeapObjects) method documentation.
     */
    fun stopTrackingHeapObjects(input: StopTrackingHeapObjectsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.stopTrackingHeapObjects", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [HeapProfiler#takeHeapSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-takeHeapSnapshot) method documentation.
     */
    fun takeHeapSnapshot(input: TakeHeapSnapshotRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("HeapProfiler.takeHeapSnapshot", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Returns observable capturing all HeapProfiler.addHeapSnapshotChunk events.
     */
    fun addHeapSnapshotChunk(): io.reactivex.Flowable<AddHeapSnapshotChunkEvent> = connection.captureEvents("HeapProfiler.addHeapSnapshotChunk", AddHeapSnapshotChunkEvent::class.java)

    /**
     *  If heap objects tracking has been started then backend may send update for one or more fragments
     */
    fun heapStatsUpdate(): io.reactivex.Flowable<HeapStatsUpdateEvent> = connection.captureEvents("HeapProfiler.heapStatsUpdate", HeapStatsUpdateEvent::class.java)

    /**
     *  If heap objects tracking has been started then backend regularly sends a current value for last
seen object id and corresponding timestamp. If the were changes in the heap since last event
then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
     */
    fun lastSeenObjectId(): io.reactivex.Flowable<LastSeenObjectIdEvent> = connection.captureEvents("HeapProfiler.lastSeenObjectId", LastSeenObjectIdEvent::class.java)

    /**
     *  Returns observable capturing all HeapProfiler.reportHeapSnapshotProgress events.
     */
    fun reportHeapSnapshotProgress(): io.reactivex.Flowable<ReportHeapSnapshotProgressEvent> = connection.captureEvents("HeapProfiler.reportHeapSnapshotProgress", ReportHeapSnapshotProgressEvent::class.java)

    /**
     *  Returns observable capturing all HeapProfiler.resetProfiles events.
     */
    fun resetProfiles(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.captureEvents("HeapProfiler.resetProfiles", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     * Returns flowable capturing all HeapProfiler domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "HeapProfiler"
        }
    }
}
/**
 * Represents request frame that can be used with [HeapProfiler#addInspectedHeapObject](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-addInspectedHeapObject) operation call.
 *
 * Enables console to refer to the node with given id via $x (see Command Line API for more details
$x functions).
 * @link [HeapProfiler#addInspectedHeapObject](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-addInspectedHeapObject) method documentation.
 * @see [HeapProfilerOperations.addInspectedHeapObject]
 */
data class AddInspectedHeapObjectRequest(
    /**
     * Heap snapshot object id to be accessible by means of $x command line API.
     */
    val heapObjectId: HeapSnapshotObjectId

)

/**
 * Represents request frame that can be used with [HeapProfiler#getHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getHeapObjectId) operation call.
 *
 *
 * @link [HeapProfiler#getHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getHeapObjectId) method documentation.
 * @see [HeapProfilerOperations.getHeapObjectId]
 */
data class GetHeapObjectIdRequest(
    /**
     * Identifier of the object to get heap object id for.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId

)
/**
 * Represents response frame that is returned from [HeapProfiler#getHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getHeapObjectId) operation call.
 *
 *
  
 * @link [HeapProfiler#getHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getHeapObjectId) method documentation.
 * @see [HeapProfilerOperations.getHeapObjectId]
 */
data class GetHeapObjectIdResponse(
    /**  
     * Id of the heap snapshot object corresponding to the passed remote object id.  
     */  
    val heapSnapshotObjectId: HeapSnapshotObjectId

)

/**
 * Represents request frame that can be used with [HeapProfiler#getObjectByHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getObjectByHeapObjectId) operation call.
 *
 *
 * @link [HeapProfiler#getObjectByHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getObjectByHeapObjectId) method documentation.
 * @see [HeapProfilerOperations.getObjectByHeapObjectId]
 */
data class GetObjectByHeapObjectIdRequest(
    /**
     *
     */
    val objectId: HeapSnapshotObjectId,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup: String? = null

)
/**
 * Represents response frame that is returned from [HeapProfiler#getObjectByHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getObjectByHeapObjectId) operation call.
 *
 *
  
 * @link [HeapProfiler#getObjectByHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getObjectByHeapObjectId) method documentation.
 * @see [HeapProfilerOperations.getObjectByHeapObjectId]
 */
data class GetObjectByHeapObjectIdResponse(
    /**  
     * Evaluation result.  
     */  
    val result: pl.wendigo.chrome.api.runtime.RemoteObject

)

/**
 * Represents response frame that is returned from [HeapProfiler#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getSamplingProfile) operation call.
 *
 *
  
 * @link [HeapProfiler#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getSamplingProfile) method documentation.
 * @see [HeapProfilerOperations.getSamplingProfile]
 */
data class GetSamplingProfileResponse(
    /**  
     * Return the sampling profile being collected.  
     */  
    val profile: SamplingHeapProfile

)

/**
 * Represents request frame that can be used with [HeapProfiler#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startSampling) operation call.
 *
 *
 * @link [HeapProfiler#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startSampling) method documentation.
 * @see [HeapProfilerOperations.startSampling]
 */
data class StartSamplingRequest(
    /**
     * Average sample interval in bytes. Poisson distribution is used for the intervals. The
default value is 32768 bytes.
     */
    val samplingInterval: Double? = null

)

/**
 * Represents request frame that can be used with [HeapProfiler#startTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startTrackingHeapObjects) operation call.
 *
 *
 * @link [HeapProfiler#startTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startTrackingHeapObjects) method documentation.
 * @see [HeapProfilerOperations.startTrackingHeapObjects]
 */
data class StartTrackingHeapObjectsRequest(
    /**
     *
     */
    val trackAllocations: Boolean? = null

)

/**
 * Represents response frame that is returned from [HeapProfiler#stopSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopSampling) operation call.
 *
 *
  
 * @link [HeapProfiler#stopSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopSampling) method documentation.
 * @see [HeapProfilerOperations.stopSampling]
 */
data class StopSamplingResponse(
    /**  
     * Recorded sampling heap profile.  
     */  
    val profile: SamplingHeapProfile

)

/**
 * Represents request frame that can be used with [HeapProfiler#stopTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopTrackingHeapObjects) operation call.
 *
 *
 * @link [HeapProfiler#stopTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopTrackingHeapObjects) method documentation.
 * @see [HeapProfilerOperations.stopTrackingHeapObjects]
 */
data class StopTrackingHeapObjectsRequest(
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken
when the tracking is stopped.
     */
    val reportProgress: Boolean? = null

)

/**
 * Represents request frame that can be used with [HeapProfiler#takeHeapSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-takeHeapSnapshot) operation call.
 *
 *
 * @link [HeapProfiler#takeHeapSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-takeHeapSnapshot) method documentation.
 * @see [HeapProfilerOperations.takeHeapSnapshot]
 */
data class TakeHeapSnapshotRequest(
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
     */
    val reportProgress: Boolean? = null

)

/**
 *
 *
 * @link [HeapProfiler#addHeapSnapshotChunk](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-addHeapSnapshotChunk) event documentation.
 */
data class AddHeapSnapshotChunkEvent(
    /**  
     *  
     */  
    val chunk: String

) : pl.wendigo.chrome.protocol.Event(domain = "HeapProfiler", name = "addHeapSnapshotChunk")

/**
 * If heap objects tracking has been started then backend may send update for one or more fragments
 *
 * @link [HeapProfiler#heapStatsUpdate](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-heapStatsUpdate) event documentation.
 */
data class HeapStatsUpdateEvent(
    /**  
     * An array of triplets. Each triplet describes a fragment. The first integer is the fragment  
     index, the second integer is a total count of objects for the fragment, the third integer is  
     a total size of the objects for the fragment.  
     */  
    val statsUpdate: List<Int>

) : pl.wendigo.chrome.protocol.Event(domain = "HeapProfiler", name = "heapStatsUpdate")

/**
 * If heap objects tracking has been started then backend regularly sends a current value for last
seen object id and corresponding timestamp. If the were changes in the heap since last event
then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 *
 * @link [HeapProfiler#lastSeenObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-lastSeenObjectId) event documentation.
 */
data class LastSeenObjectIdEvent(
    /**  
     *  
     */  
    val lastSeenObjectId: Int,

    /**  
     *  
     */  
    val timestamp: Double

) : pl.wendigo.chrome.protocol.Event(domain = "HeapProfiler", name = "lastSeenObjectId")

/**
 *
 *
 * @link [HeapProfiler#reportHeapSnapshotProgress](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-reportHeapSnapshotProgress) event documentation.
 */
data class ReportHeapSnapshotProgressEvent(
    /**  
     *  
     */  
    val done: Int,

    /**  
     *  
     */  
    val total: Int,

    /**  
     *  
     */  
    val finished: Boolean? = null

) : pl.wendigo.chrome.protocol.Event(domain = "HeapProfiler", name = "reportHeapSnapshotProgress")
