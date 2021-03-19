package pl.wendigo.chrome.api.tracing

/**
 * Configuration for memory dump. Used only when &quot;memory-infra&quot; category is enabled.
 *
 * @link [Tracing#MemoryDumpConfig](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-MemoryDumpConfig) type documentation.
 */

typealias MemoryDumpConfig = Map<String, kotlinx.serialization.json.JsonElement>

/**
 *
 *
 * @link [Tracing#TraceConfig](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-TraceConfig) type documentation.
 */

@kotlinx.serialization.Serializable
data class TraceConfig(
    /**  
     * Controls how the trace buffer stores data.  
     */  
    val recordMode: String? = null,

    /**  
     * Turns on JavaScript stack sampling.  
     */  
    val enableSampling: Boolean? = null,

    /**  
     * Turns on system tracing.  
     */  
    val enableSystrace: Boolean? = null,

    /**  
     * Turns on argument filter.  
     */  
    val enableArgumentFilter: Boolean? = null,

    /**  
     * Included category filters.  
     */  
    val includedCategories: List<String>? = null,

    /**  
     * Excluded category filters.  
     */  
    val excludedCategories: List<String>? = null,

    /**  
     * Configuration to synthesize the delays in tracing.  
     */  
    val syntheticDelays: List<String>? = null,

    /**  
     * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.  
     */  
    val memoryDumpConfig: MemoryDumpConfig? = null
)

/**
 * Data format of a trace. Can be either the legacy JSON format or the
protocol buffer format. Note that the JSON format will be deprecated soon.
 *
 * @link [Tracing#StreamFormat](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-StreamFormat) type documentation.
 */
@kotlinx.serialization.Serializable
enum class StreamFormat {
    @kotlinx.serialization.SerialName("json")
    JSON,

    @kotlinx.serialization.SerialName("proto")
    PROTO;
}

/**
 * Compression type to use for traces returned via streams.
 *
 * @link [Tracing#StreamCompression](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-StreamCompression) type documentation.
 */
@kotlinx.serialization.Serializable
enum class StreamCompression {
    @kotlinx.serialization.SerialName("none")
    NONE,

    @kotlinx.serialization.SerialName("gzip")
    GZIP;
}

/**
 * Details exposed when memory request explicitly declared.
Keep consistent with memory_dump_request_args.h and
memory_instrumentation.mojom
 *
 * @link [Tracing#MemoryDumpLevelOfDetail](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-MemoryDumpLevelOfDetail) type documentation.
 */
@kotlinx.serialization.Serializable
enum class MemoryDumpLevelOfDetail {
    @kotlinx.serialization.SerialName("background")
    BACKGROUND,

    @kotlinx.serialization.SerialName("light")
    LIGHT,

    @kotlinx.serialization.SerialName("detailed")
    DETAILED;
}
