package pl.wendigo.chrome.api.performance

/**
 * Run-time execution metric.
 *
 * @link [Performance#Metric](https://chromedevtools.github.io/devtools-protocol/tot/Performance#type-Metric) type documentation.
 */

data class Metric(
    /**  
     * Metric name.  
     */  
    val name: String,

    /**  
     * Metric value.  
     */  
    val value: Double
)
