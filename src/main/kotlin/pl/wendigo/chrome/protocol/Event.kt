package pl.wendigo.chrome.protocol

import kotlinx.serialization.Serializable
import pl.wendigo.chrome.api.target.SessionID

interface Event {
    fun eventName(): String
    fun domain(): String

    companion object {
        /**
         * Creates parameterless Event from given name (protocol domain + event name)
         */
        internal fun fromFrame(eventFrame: EventResponseFrame) = eventFrame.method.split(".", limit = 2, ignoreCase = true).run {
            RawEvent(domain = this[0], eventName = this[1], sessionId = eventFrame.sessionId)
        }
    }
}

@Serializable
class RawEvent(
    private val domain: String,
    private val eventName: String,
    private val sessionId: SessionID?
) : Event {
    override fun domain(): String = domain
    override fun eventName(): String = eventName
    fun sessionId(): SessionID? = sessionId
}
