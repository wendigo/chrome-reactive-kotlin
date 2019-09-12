package pl.wendigo.chrome

class InspectorException(reason: String): RuntimeException("Could not query inspector: $reason")
