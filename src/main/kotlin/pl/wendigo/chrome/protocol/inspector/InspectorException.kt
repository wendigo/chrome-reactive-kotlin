package pl.wendigo.chrome.protocol.inspector

class InspectorException(reason: String) : RuntimeException("Could not query inspector: $reason")
