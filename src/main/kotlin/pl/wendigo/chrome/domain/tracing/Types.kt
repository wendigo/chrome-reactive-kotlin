package pl.wendigo.chrome.domain.tracing

/**
 * Configuration for memory dump. Used only when &quot;memory-infra&quot; category is enabled.
 */
typealias MemoryDumpConfig = Map<String,Any>

/**
 * 
 */
data class TraceConfig(
  /**
   * Controls how the trace buffer stores data.
   */
  val recordMode : String? = null,

  /**
   * Turns on JavaScript stack sampling.
   */
  val enableSampling : Boolean? = null,

  /**
   * Turns on system tracing.
   */
  val enableSystrace : Boolean? = null,

  /**
   * Turns on argument filter.
   */
  val enableArgumentFilter : Boolean? = null,

  /**
   * Included category filters.
   */
  val includedCategories : Array<String>? = null,

  /**
   * Excluded category filters.
   */
  val excludedCategories : Array<String>? = null,

  /**
   * Configuration to synthesize the delays in tracing.
   */
  val syntheticDelays : Array<String>? = null,

  /**
   * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.
   */
  val memoryDumpConfig : MemoryDumpConfig? = null
)

