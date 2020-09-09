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
    val hitCount: Int? = null,

    /**  
     * Child node ids.  
     */  
    val children: List<Int>? = null,

    /**  
     * The reason of being not optimized. The function may be deoptimized or marked as don't  
     optimize.  
     */  
    val deoptReason: String? = null,

    /**  
     * An array of source position ticks.  
     */  
    val positionTicks: List<PositionTickInfo>? = null
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
     * Time intervals between adjacent samples in microseconds. The first delta is relative to the  
     profile startTime.  
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

/**
 * Coverage data for a source range.
 *
 * @link [Profiler#CoverageRange](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-CoverageRange) type documentation.
 */

data class CoverageRange(
    /**  
     * JavaScript script source offset for the range start.  
     */  
    val startOffset: Int,

    /**  
     * JavaScript script source offset for the range end.  
     */  
    val endOffset: Int,

    /**  
     * Collected execution count of the source range.  
     */  
    val count: Int
)

/**
 * Coverage data for a JavaScript function.
 *
 * @link [Profiler#FunctionCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-FunctionCoverage) type documentation.
 */

data class FunctionCoverage(
    /**  
     * JavaScript function name.  
     */  
    val functionName: String,

    /**  
     * Source ranges inside the function with coverage data.  
     */  
    val ranges: List<CoverageRange>,

    /**  
     * Whether coverage data for this function has block granularity.  
     */  
    val isBlockCoverage: Boolean
)

/**
 * Coverage data for a JavaScript script.
 *
 * @link [Profiler#ScriptCoverage](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-ScriptCoverage) type documentation.
 */

data class ScriptCoverage(
    /**  
     * JavaScript script id.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * JavaScript script name or url.  
     */  
    val url: String,

    /**  
     * Functions contained in the script that has coverage data.  
     */  
    val functions: List<FunctionCoverage>
)

/**
 * Describes a type collected during runtime.
 *
 * @link [Profiler#TypeObject](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-TypeObject) type documentation.
 */

data class TypeObject(
    /**  
     * Name of a type collected with type profiling.  
     */  
    val name: String
)

/**
 * Source offset and types for a parameter or return value.
 *
 * @link [Profiler#TypeProfileEntry](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-TypeProfileEntry) type documentation.
 */

data class TypeProfileEntry(
    /**  
     * Source offset of the parameter or end of function for return values.  
     */  
    val offset: Int,

    /**  
     * The types for this parameter or return value.  
     */  
    val types: List<TypeObject>
)

/**
 * Type profile data collected during runtime for a JavaScript script.
 *
 * @link [Profiler#ScriptTypeProfile](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-ScriptTypeProfile) type documentation.
 */

data class ScriptTypeProfile(
    /**  
     * JavaScript script id.  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId,

    /**  
     * JavaScript script name or url.  
     */  
    val url: String,

    /**  
     * Type profile entries for parameters and return values of the functions in the script.  
     */  
    val entries: List<TypeProfileEntry>
)

/**
 * Collected counter information.
 *
 * @link [Profiler#CounterInfo](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-CounterInfo) type documentation.
 */

data class CounterInfo(
    /**  
     * Counter name.  
     */  
    val name: String,

    /**  
     * Counter value.  
     */  
    val value: Int
)

/**
 * Runtime call counter information.
 *
 * @link [Profiler#RuntimeCallCounterInfo](https://chromedevtools.github.io/devtools-protocol/tot/Profiler#type-RuntimeCallCounterInfo) type documentation.
 */

data class RuntimeCallCounterInfo(
    /**  
     * Counter name.  
     */  
    val name: String,

    /**  
     * Counter value.  
     */  
    val value: Double,

    /**  
     * Counter time in seconds.  
     */  
    val time: Double
)
