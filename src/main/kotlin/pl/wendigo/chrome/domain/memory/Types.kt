package pl.wendigo.chrome.domain.memory

/**
 * Memory pressure level.
 */
enum class PressureLevel {
    @com.fasterxml.jackson.annotation.JsonProperty("moderate") MODERATE,
    @com.fasterxml.jackson.annotation.JsonProperty("critical") CRITICAL;
}

