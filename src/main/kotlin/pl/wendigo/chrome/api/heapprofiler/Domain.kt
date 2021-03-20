package pl.wendigo.chrome.api.heapprofiler

import kotlinx.serialization.json.Json

/**
 * HeapProfilerDomain represents HeapProfiler protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [HeapProfiler](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class HeapProfilerDomain internal constructor(connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) :
    pl.wendigo.chrome.api.Domain("HeapProfiler", """""", connection) {
    /**
     * Enables console to refer to the node with given id via $x (see Command Line API for more details
$x functions).
     *
     * @link Protocol [HeapProfiler#addInspectedHeapObject](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-addInspectedHeapObject) method documentation.
     */
    
    fun addInspectedHeapObject(input: AddInspectedHeapObjectRequest) = connection.request("HeapProfiler.addInspectedHeapObject", Json.encodeToJsonElement(AddInspectedHeapObjectRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#collectGarbage](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-collectGarbage) method documentation.
     */
    
    fun collectGarbage() = connection.request("HeapProfiler.collectGarbage", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#disable](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-disable) method documentation.
     */
    
    fun disable() = connection.request("HeapProfiler.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#enable](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-enable) method documentation.
     */
    
    fun enable() = connection.request("HeapProfiler.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#getHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getHeapObjectId) method documentation.
     */
    
    fun getHeapObjectId(input: GetHeapObjectIdRequest) = connection.request("HeapProfiler.getHeapObjectId", Json.encodeToJsonElement(GetHeapObjectIdRequest.serializer(), input), GetHeapObjectIdResponse.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#getObjectByHeapObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getObjectByHeapObjectId) method documentation.
     */
    
    fun getObjectByHeapObjectId(input: GetObjectByHeapObjectIdRequest) = connection.request("HeapProfiler.getObjectByHeapObjectId", Json.encodeToJsonElement(GetObjectByHeapObjectIdRequest.serializer(), input), GetObjectByHeapObjectIdResponse.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#getSamplingProfile](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-getSamplingProfile) method documentation.
     */
    
    fun getSamplingProfile() = connection.request("HeapProfiler.getSamplingProfile", null, GetSamplingProfileResponse.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#startSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startSampling) method documentation.
     */
    
    fun startSampling(input: StartSamplingRequest) = connection.request("HeapProfiler.startSampling", Json.encodeToJsonElement(StartSamplingRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#startTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-startTrackingHeapObjects) method documentation.
     */
    
    fun startTrackingHeapObjects(input: StartTrackingHeapObjectsRequest) = connection.request("HeapProfiler.startTrackingHeapObjects", Json.encodeToJsonElement(StartTrackingHeapObjectsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#stopSampling](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopSampling) method documentation.
     */
    
    fun stopSampling() = connection.request("HeapProfiler.stopSampling", null, StopSamplingResponse.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#stopTrackingHeapObjects](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-stopTrackingHeapObjects) method documentation.
     */
    
    fun stopTrackingHeapObjects(input: StopTrackingHeapObjectsRequest) = connection.request("HeapProfiler.stopTrackingHeapObjects", Json.encodeToJsonElement(StopTrackingHeapObjectsRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [HeapProfiler#takeHeapSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-takeHeapSnapshot) method documentation.
     */
    
    fun takeHeapSnapshot(input: TakeHeapSnapshotRequest) = connection.request("HeapProfiler.takeHeapSnapshot", Json.encodeToJsonElement(TakeHeapSnapshotRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Returns observable capturing all HeapProfiler.addHeapSnapshotChunk events.
     */
    fun addHeapSnapshotChunk(): io.reactivex.rxjava3.core.Flowable<AddHeapSnapshotChunkEvent> = connection.events("HeapProfiler.addHeapSnapshotChunk", AddHeapSnapshotChunkEvent.serializer())

    /**
     *  If heap objects tracking has been started then backend may send update for one or more fragments
     */
    fun heapStatsUpdate(): io.reactivex.rxjava3.core.Flowable<HeapStatsUpdateEvent> = connection.events("HeapProfiler.heapStatsUpdate", HeapStatsUpdateEvent.serializer())

    /**
     *  If heap objects tracking has been started then backend regularly sends a current value for last
seen object id and corresponding timestamp. If the were changes in the heap since last event
then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
     */
    fun lastSeenObjectId(): io.reactivex.rxjava3.core.Flowable<LastSeenObjectIdEvent> = connection.events("HeapProfiler.lastSeenObjectId", LastSeenObjectIdEvent.serializer())

    /**
     *  Returns observable capturing all HeapProfiler.reportHeapSnapshotProgress events.
     */
    fun reportHeapSnapshotProgress(): io.reactivex.rxjava3.core.Flowable<ReportHeapSnapshotProgressEvent> = connection.events("HeapProfiler.reportHeapSnapshotProgress", ReportHeapSnapshotProgressEvent.serializer())

    /**
     *  Returns observable capturing all HeapProfiler.resetProfiles events.
     */
    fun resetProfiles(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.RawEvent> = connection.events("HeapProfiler.resetProfiles", pl.wendigo.chrome.protocol.RawEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.api.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.runtime.RuntimeDomain(connection),
        )
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
data class StopTrackingHeapObjectsRequest(
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken
when the tracking is stopped.
     */
    val reportProgress: Boolean? = null,

    /**
     *
     */
    val treatGlobalObjectsAsRoots: Boolean? = null

)

/**
 * Represents request frame that can be used with [HeapProfiler#takeHeapSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-takeHeapSnapshot) operation call.
 *
 *
 * @link [HeapProfiler#takeHeapSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#method-takeHeapSnapshot) method documentation.
 * @see [HeapProfilerOperations.takeHeapSnapshot]
 */
@kotlinx.serialization.Serializable
data class TakeHeapSnapshotRequest(
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
     */
    val reportProgress: Boolean? = null,

    /**
     * If true, a raw snapshot without artifical roots will be generated
     */
    val treatGlobalObjectsAsRoots: Boolean? = null

)

/**
 *
 *
 * @link [HeapProfiler#addHeapSnapshotChunk](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-addHeapSnapshotChunk) event documentation.
 */
@kotlinx.serialization.Serializable
data class AddHeapSnapshotChunkEvent(
    /**  
     *  
     */  
    val chunk: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "HeapProfiler" 
    override fun eventName() = "addHeapSnapshotChunk"
} 

/**
 * If heap objects tracking has been started then backend may send update for one or more fragments
 *
 * @link [HeapProfiler#heapStatsUpdate](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-heapStatsUpdate) event documentation.
 */
@kotlinx.serialization.Serializable
data class HeapStatsUpdateEvent(
    /**  
     * An array of triplets. Each triplet describes a fragment. The first integer is the fragment  
     index, the second integer is a total count of objects for the fragment, the third integer is  
     a total size of the objects for the fragment.  
     */  
    val statsUpdate: List<Int>

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "HeapProfiler" 
    override fun eventName() = "heapStatsUpdate"
} 

/**
 * If heap objects tracking has been started then backend regularly sends a current value for last
seen object id and corresponding timestamp. If the were changes in the heap since last event
then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 *
 * @link [HeapProfiler#lastSeenObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-lastSeenObjectId) event documentation.
 */
@kotlinx.serialization.Serializable
data class LastSeenObjectIdEvent(
    /**  
     *  
     */  
    val lastSeenObjectId: Int,

    /**  
     *  
     */  
    val timestamp: Double

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "HeapProfiler" 
    override fun eventName() = "lastSeenObjectId"
} 

/**
 *
 *
 * @link [HeapProfiler#reportHeapSnapshotProgress](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#event-reportHeapSnapshotProgress) event documentation.
 */
@kotlinx.serialization.Serializable
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

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "HeapProfiler" 
    override fun eventName() = "reportHeapSnapshotProgress"
} 
