package pl.wendigo.chrome.domain.memory

/**
 * Memory pressure level.
 */
enum class PressureLevel {
    @com.fasterxml.jackson.annotation.JsonProperty("moderate")
    MODERATE,
    @com.fasterxml.jackson.annotation.JsonProperty("critical")
    CRITICAL;
}

/**
 * Heap profile sample.
 */

data class SamplingProfileNode(
    /**  
     * Size of the sampled allocation.  
     */  
    val size: Double,

    /**  
     * Total bytes attributed to this sample.  
     */  
    val total: Double,

    /**  
     * Execution stack at the point of allocation.  
     */  
    val stack: List<String>
)

/**
 * Array of heap profile samples.
 */

data class SamplingProfile(
    /**  
     *  
     */  
    val samples: List<SamplingProfileNode>,

    /**  
     *  
     */  
    val modules: List<Module>
)

/**
 * Executable module information
 */

data class Module(
    /**  
     * Name of the module.  
     */  
    val name: String,

    /**  
     * UUID of the module.  
     */  
    val uuid: String,

    /**  
     * Base address where the module is loaded into memory. Encoded as a decimal  
     or hexadecimal (0x prefixed) string.  
     */  
    val baseAddress: String,

    /**  
     * Size of the module in bytes.  
     */  
    val size: Double
)
