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
     * Child nodes.  
     */  
    val children: List<SamplingHeapProfileNode>
)

/**
 * Profile.
 *
 * @link [HeapProfiler#SamplingHeapProfile](https://chromedevtools.github.io/devtools-protocol/tot/HeapProfiler#type-SamplingHeapProfile) type documentation.
 */

data class SamplingHeapProfile(
    /**  
     *  
     */  
    val head: SamplingHeapProfileNode
)
