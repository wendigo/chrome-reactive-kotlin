package pl.wendigo.chrome.protocol

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class Event(
    @Transient private val domainName: String = "unknown",
    @Transient private val domainEventName: String = "unknown"
) {
    internal fun name() = "$domainName.$domainEventName"

    fun protocolDomain() = domainName

    companion object {
        /**
         * Creates parameterless Event from given name (protocol domain + event name)
         */
        internal fun fromMethodName(methodName: String) = methodName.split(".", limit = 2, ignoreCase = true).run {
            Event(domainName = this[0], domainEventName = this[1])
        }
    }
}
