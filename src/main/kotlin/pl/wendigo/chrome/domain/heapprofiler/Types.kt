package pl.wendigo.chrome.domain.heapprofiler

/**
 * Heap snapshot object id.
 */

typealias HeapSnapshotObjectId = String

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 */

data class SamplingHeapProfileNode(
  /**
   * Function location.
   */
  val callFrame : pl.wendigo.chrome.domain.runtime.CallFrame,

  /**
   * Allocations size in bytes for the node excluding children.
   */
  val selfSize : Double,

  /**
   * Child nodes.
   */
  val children : List<SamplingHeapProfileNode>
)

/**
 * Profile.
 */

data class SamplingHeapProfile(
  /**
   *
   */
  val head : SamplingHeapProfileNode
)

