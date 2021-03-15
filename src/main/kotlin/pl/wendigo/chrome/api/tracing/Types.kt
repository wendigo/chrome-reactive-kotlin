package pl.wendigo.chrome.api.tracing

/**
 * Configuration for memory dump. Used only when &quot;memory-infra&quot; category is enabled.
 *
 * @link [Tracing#MemoryDumpConfig](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-MemoryDumpConfig) type documentation.
 */

typealias MemoryDumpConfig = Map<String, Any>

/**
 *
 *
 * @link [Tracing#TraceConfig](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-TraceConfig) type documentation.
 */

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
enum class StreamFormat {
    @com.fasterxml.jackson.annotation.JsonProperty("json")
    JSON,
    @com.fasterxml.jackson.annotation.JsonProperty("proto")
    PROTO;
}

/**
 * Compression type to use for traces returned via streams.
 *
 * @link [Tracing#StreamCompression](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-StreamCompression) type documentation.
 */
enum class StreamCompression {
    @com.fasterxml.jackson.annotation.JsonProperty("none")
    NONE,
    @com.fasterxml.jackson.annotation.JsonProperty("gzip")
    GZIP;
}

/**
 * Details exposed when memory request explicitly declared.
Keep consistent with memory_dump_request_args.h and
memory_instrumentation.mojom
 *
 * @link [Tracing#MemoryDumpLevelOfDetail](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-MemoryDumpLevelOfDetail) type documentation.
 */
enum class MemoryDumpLevelOfDetail {
    @com.fasterxml.jackson.annotation.JsonProperty("background")
    BACKGROUND,
    @com.fasterxml.jackson.annotation.JsonProperty("light")
    LIGHT,
    @com.fasterxml.jackson.annotation.JsonProperty("detailed")
    DETAILED;
}

/**
 * Backend type to use for tracing. `chrome` uses the Chrome-integrated
tracing service and is supported on all platforms. `system` is only
supported on Chrome OS and uses the Perfetto system tracing service.
`auto` chooses `system` when the perfettoConfig provided to Tracing.start
specifies at least one non-Chrome data source; otherwise uses `chrome`.
 *
 * @link [Tracing#TracingBackend](https://chromedevtools.github.io/devtools-protocol/tot/Tracing#type-TracingBackend) type documentation.
 */
enum class TracingBackend {
    @com.fasterxml.jackson.annotation.JsonProperty("auto")
    AUTO,
    @com.fasterxml.jackson.annotation.JsonProperty("chrome")
    CHROME,
    @com.fasterxml.jackson.annotation.JsonProperty("system")
    SYSTEM;
}
