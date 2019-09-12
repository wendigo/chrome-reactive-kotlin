package pl.wendigo.chrome.domain.performance

/**
 * PerformanceDomain represents remote debugger protocol domain.
 */
class PerformanceDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disable collecting and reporting metrics.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Performance.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enable collecting and reporting metrics.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Performance.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets time domain to use for collecting and reporting duration metrics.
Note that this must be called before enabling metrics collection. Calling
this method while metrics collection is enabled returns an error.
     */
    fun setTimeDomain(input: SetTimeDomainRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Performance.setTimeDomain", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Retrieve current values of run-time metrics.
     */
    fun getMetrics(): io.reactivex.Single<GetMetricsResponse> {
        return connectionRemote.runAndCaptureResponse("Performance.getMetrics", null, GetMetricsResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Current values of the metrics.
     */
    fun metrics(): io.reactivex.Flowable<MetricsEvent> {
        return metricsTimed().map {
            it.value()
        }
    }

    /**
     * Current values of the metrics.
     */
    fun metricsTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<MetricsEvent>> {
        return connectionRemote.captureEvents("Performance.metrics", MetricsEvent::class.java)
    }

    /**
     * Returns flowable capturing all Performance domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Performance"
        }
    }
}

/**
 * Represents request frame that can be used with Performance.setTimeDomain method call.
 *
 * Sets time domain to use for collecting and reporting duration metrics.
Note that this must be called before enabling metrics collection. Calling
this method while metrics collection is enabled returns an error.
 */
data class SetTimeDomainRequest(
    /**
     * Time domain
     */
    val timeDomain: String

)

/**
 * Represents response frame for Performance.getMetrics method call.
 *
 * Retrieve current values of run-time metrics.
 */
data class GetMetricsResponse(
    /**  
     * Current values for run-time metrics.  
     */  
    val metrics: List<Metric>

)

/**
 * Represents event frames for Performance.metrics
 *
 * Current values of the metrics.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Performance", name = "metrics")
