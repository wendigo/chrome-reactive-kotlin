package pl.wendigo.chrome.protocol

/**
 * Debugger event represents generic protocol event consisting of domain and event names.
 * This class is also supertype of all parameterized events.
 */
open class Event(
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
            Event(domain = this[0], name = this[1])
        }
    }
}