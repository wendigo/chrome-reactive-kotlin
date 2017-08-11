package pl.wendigo.chrome.domain.performance

/**
 * Run-time execution metric.
 */

data class Metric(
  /**
   * Metric name.
   */
  val name : String,

  /**
   * Metric value.
   */
  val value : Double
)

