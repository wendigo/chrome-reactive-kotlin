package pl.wendigo.chrome.api.performance

/**
 * PerformanceOperations represents Performance protocol domain request/response operations and events that can be captured.
 *
 * @link Protocol [Performance](https://chromedevtools.github.io/devtools-protocol/tot/Performance) domain documentation.
 */
class PerformanceOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disable collecting and reporting metrics.
     *
     * @link Protocol [Performance#disable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-disable) method documentation.
     */
    fun disable() = connection.request("Performance.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enable collecting and reporting metrics.
     *
     * @link Protocol [Performance#enable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-enable) method documentation.
     */
    fun enable(input: EnableRequest) = connection.request("Performance.enable", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Sets time domain to use for collecting and reporting duration metrics.
Note that this must be called before enabling metrics collection. Calling
this method while metrics collection is enabled returns an error.
     *
     * @link Protocol [Performance#setTimeDomain](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-setTimeDomain) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setTimeDomain is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setTimeDomain(input: SetTimeDomainRequest) = connection.request("Performance.setTimeDomain", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Retrieve current values of run-time metrics.
     *
     * @link Protocol [Performance#getMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-getMetrics) method documentation.
     */
    fun getMetrics() = connection.request("Performance.getMetrics", null, GetMetricsResponse::class.java)

    /**
     *  Current values of the metrics.
     */
    fun metrics(): io.reactivex.Flowable<MetricsEvent> = connection.events("Performance.metrics", MetricsEvent::class.java)

    /**
     * Returns flowable capturing all Performance domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Performance"
        }
    }
}

/**
 * Represents request frame that can be used with [Performance#enable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-enable) operation call.
 *
 * Enable collecting and reporting metrics.
 * @link [Performance#enable](https://chromedevtools.github.io/devtools-protocol/tot/Performance#method-enable) method documentation.
 * @see [PerformanceOperations.enable]
 */
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
data class MetricsEvent(
    /**  
     * Current values of the metrics.  
     */  
    val metrics: List<Metric>,

    /**  
     * Timestamp title.  
     */  
    val title: String

) : pl.wendigo.chrome.protocol.Event(domain = "Performance", name = "metrics")
