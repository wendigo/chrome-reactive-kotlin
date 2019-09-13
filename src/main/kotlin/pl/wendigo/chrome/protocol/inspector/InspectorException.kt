package pl.wendigo.chrome.protocol.inspector

/**
 * InspectorException is thrown when querying inspector API (http://[]:9222/json) fails.
 */
class InspectorException(reason: String) : RuntimeException("Could not query inspector: $reason")
