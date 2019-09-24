package pl.wendigo.chrome.api.heapprofiler

/**
 * Heap snapshot object id.
 *
 * @link [HeapProfiler#HeapSnapshotObjectId](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#type-HeapSnapshotObjectId) type documentation.
 */

typealias HeapSnapshotObjectId = String

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 *
 * @link [HeapProfiler#SamplingHeapProfileNode](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#type-SamplingHeapProfileNode) type documentation.
 */

data class SamplingHeapProfileNode(
    /**  
     * Function location.  
     */  
    val callFrame: pl.wendigo.chrome.api.runtime.CallFrame,

    /**  
     * Allocations size in bytes for the node excluding children.  
     */  
    val selfSize: Double,

    /**  
     * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.  
     */  
    val id: Int,

    /**  
     * Child nodes.  
     */  
    val children: List<SamplingHeapProfileNode>
)

/**
 * A single sample from a sampling profile.
 *
 * @link [HeapProfiler#SamplingHeapProfileSample](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#type-SamplingHeapProfileSample) type documentation.
 */

data class SamplingHeapProfileSample(
    /**  
     * Allocation size in bytes attributed to the sample.  
     */  
    val size: Double,

    /**  
     * Id of the corresponding profile tree node.  
     */  
    val nodeId: Int,

    /**  
     * Time-ordered sample ordinal number. It is unique across all profiles retrieved  
     between startSampling and stopSampling.  
     */  
    val ordinal: Double
)

/**
 * Sampling profile.
 *
 * @link [HeapProfiler#SamplingHeapProfile](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#type-SamplingHeapProfile) type documentation.
 */

data class SamplingHeapProfile(
    /**  
     *  
     */  
    val head: SamplingHeapProfileNode,

    /**  
     *  
     */  
    val samples: List<SamplingHeapProfileSample>
)
