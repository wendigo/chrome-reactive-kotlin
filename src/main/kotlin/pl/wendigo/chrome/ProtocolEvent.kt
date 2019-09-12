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
        internal fun fromMethodName(methodName: String) = methodName.split(".", limit = 2, ignoreCase = true).run {
            ProtocolEvent(domain = this[0], name = this[1])
        }
    }
}
