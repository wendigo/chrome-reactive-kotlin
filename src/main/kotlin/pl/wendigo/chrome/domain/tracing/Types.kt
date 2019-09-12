package pl.wendigo.chrome.domain.tracing

/**
 * Configuration for memory dump. Used only when &quot;memory-infra&quot; category is enabled.
 */

typealias MemoryDumpConfig = Map<String, Any>

/**
 *
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
 */
enum class StreamFormat {
    @com.fasterxml.jackson.annotation.JsonProperty("json") JSON,
    @com.fasterxml.jackson.annotation.JsonProperty("proto") PROTO;
}

/**
 * Compression type to use for traces returned via streams.
 */
enum class StreamCompression {
    @com.fasterxml.jackson.annotation.JsonProperty("none") NONE,
    @com.fasterxml.jackson.annotation.JsonProperty("gzip") GZIP;
}
