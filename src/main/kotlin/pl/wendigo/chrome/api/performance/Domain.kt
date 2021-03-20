package pl.wendigo.chrome.api.performance

import kotlinx.serialization.json.Json

/**
 * PerformanceDomain represents Performance protocol domain request/response operations and events that can be captured.
 *
 * @link Protocol [Performance](https://chromedevtools.github.io/devtools-protocol/tot/Performance) domain documentation.
 */

class PerformanceDomain internal constructor(connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) :
    pl.wendigo.chrome.api.Domain("Performance", """""", connection) {
    /**
     * Disable collecting and reporting metrics.
     *
     * @link Protocol [Performance#disable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-disable) method documentation.
     */
    
    fun disable() = connection.request("Performance.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enable collecting and reporting metrics.
     *
     * @link Protocol [Performance#enable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-enable) method documentation.
     */
    
    fun enable(input: EnableRequest) = connection.request("Performance.enable", Json.encodeToJsonElement(EnableRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Sets time domain to use for collecting and reporting duration metrics.
Note that this must be called before enabling metrics collection. Calling
this method while metrics collection is enabled returns an error.
     *
     * @link Protocol [Performance#setTimeDomain](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-setTimeDomain) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "{{setTimeDomain}} is deprecated.")
    @pl.wendigo.chrome.protocol.Experimental
    fun setTimeDomain(input: SetTimeDomainRequest) = connection.request("Performance.setTimeDomain", Json.encodeToJsonElement(SetTimeDomainRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Retrieve current values of run-time metrics.
     *
     * @link Protocol [Performance#getMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-getMetrics) method documentation.
     */
    
    fun getMetrics() = connection.request("Performance.getMetrics", null, GetMetricsResponse.serializer())

    /**
     *  Current values of the metrics.
     */
    fun metrics(): io.reactivex.rxjava3.core.Flowable<MetricsEvent> = connection.events("Performance.metrics", MetricsEvent.serializer())
}

/**
 * Represents request frame that can be used with [Performance#enable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-enable) operation call.
 *
 * Enable collecting and reporting metrics.
 * @link [Performance#enable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-enable) method documentation.
 * @see [PerformanceOperations.enable]
 */
@kotlinx.serialization.Serializable
data class EnableRequest(
    /**
     * Time domain to use for collecting and reporting duration metrics.
     */
    val timeDomain: String? = null

)

/**
 * Represents request frame that can be used with [Performance#setTimeDomain](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-setTimeDomain) operation call.
 *
 * Sets time domain to use for collecting and reporting duration metrics.
Note that this must be called before enabling metrics collection. Calling
this method while metrics collection is enabled returns an error.
 * @link [Performance#setTimeDomain](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-setTimeDomain) method documentation.
 * @see [PerformanceOperations.setTimeDomain]
 */
@kotlinx.serialization.Serializable
data class SetTimeDomainRequest(
    /**
     * Time domain
     */
    val timeDomain: String

)

/**
 * Represents response frame that is returned from [Performance#getMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-getMetrics) operation call.
 * Retrieve current values of run-time metrics.
 *
  
 * @link [Performance#getMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-getMetrics) method documentation.
 * @see [PerformanceOperations.getMetrics]
 */
@kotlinx.serialization.Serializable
data class GetMetricsResponse(
    /**  
     * Current values for run-time metrics.  
     */  
    val metrics: List<Metric>

)

/**
 * Current values of the metrics.
 *
 * @link [Performance#metrics](https://chromedevtools.github.io/devtools-protocol/tot/Performance#event-metrics) event documentation.
 */
@kotlinx.serialization.Serializable
data class MetricsEvent(
    /**  
     * Current values of the metrics.  
     */  
    val metrics: List<Metric>,

    /**  
     * Timestamp title.  
     */  
    val title: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Performance" 
    override fun eventName() = "metrics"
} 
