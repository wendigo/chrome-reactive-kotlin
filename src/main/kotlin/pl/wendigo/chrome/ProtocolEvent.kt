package pl.wendigo.chrome

/**
 * Debugger event represents generic protocol event consisting of domain and event names.
 * This class is also supertype of all parameterized events.
 */
open class ProtocolEvent(
    private val domain: String,
    private val name: String
) {
    internal fun name() = "$domain.$name"

    fun protocolDomain() = domain

    companion object {
        /**
         * Creates parameterless ProtocolEvent from given name (protocol domain + event name)
         */
        internal fun fromMethodName(methodName: String): ProtocolEvent {
            val parts = methodName.split(".", limit = 2, ignoreCase = true)
            return ProtocolEvent(domain = parts[0], name = parts[1])
        }
    }
}