package pl.wendigo.chrome

import java.lang.RuntimeException

/**
 * BrowserInfoDiscoveryFailedException is thrown when there's no possibility to query browser for debugger WebSocket endpoint.
 */
class BrowserInfoDiscoveryFailedException(reason: String) : RuntimeException(reason)
