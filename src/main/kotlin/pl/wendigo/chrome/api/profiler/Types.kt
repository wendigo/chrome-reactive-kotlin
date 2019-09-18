package pl.wendigo.chrome.api.profiler

/**
 * Profile node. Holds callsite information, execution statistics and child nodes.
 *
 * @link [Profiler#ProfileNode](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-ProfileNode) type documentation.
 */

data class ProfileNode(
  /**
   * Unique id of the node.
   */
  val id: Int,

  /**
   * Function location.
   */
  val callFrame: pl.wendigo.chrome.api.runtime.CallFrame,

  /**
   * Number of samples where this node was on top of the call stack.
   */
  @pl.wendigo.chrome.protocol.Experimental val hitCount: Int? = null,

  /**
   * Child node ids.
   */
  val children: List<Int>? = null,

  /**
   * The reason of being not optimized. The function may be deoptimized or marked as don't optimize.
   */
  val deoptReason: String? = null,

  /**
   * An array of source position ticks.
   */
  @pl.wendigo.chrome.protocol.Experimental val positionTicks: List<PositionTickInfo>? = null
)

/**
 * Profile.
 *
 * @link [Profiler#Profile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-Profile) type documentation.
 */

data class Profile(
  /**
   * The list of profile nodes. First item is the root node.
   */
  val nodes: List<ProfileNode>,

  /**
   * Profiling start timestamp in microseconds.
   */
  val startTime: Double,

  /**
   * Profiling end timestamp in microseconds.
   */
  val endTime: Double,

  /**
   * Ids of samples top nodes.
   */
  val samples: List<Int>? = null,

  /**
   * Time intervals between adjacent samples in microseconds. The first delta is relative to the profile startTime.
   */
  val timeDeltas: List<Int>? = null
)

/**
 * Specifies a number of samples attributed to a certain source position.
 *
 * @link [Profiler#PositionTickInfo](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-PositionTickInfo) type documentation.
 */

data class PositionTickInfo(
  /**
   * Source line number (1-based).
   */
  val line: Int,

  /**
   * Number of samples attributed to the source line.
   */
  val ticks: Int
)

