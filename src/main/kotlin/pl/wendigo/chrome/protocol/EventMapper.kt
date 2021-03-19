package pl.wendigo.chrome.protocol

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import java.util.concurrent.ConcurrentHashMap

/**
 * EventMapper is responsible for mapping events carried by [ResponseFrame] to typed events representations.
 */
class EventMapper {
    private val eventNameToSerializerMapping: ConcurrentHashMap<String, KSerializer<out Event>> = ConcurrentHashMap()

    /**
     * Add mapping from event name to class.
     */
    fun addMapping(name: String, serializer: KSerializer<out Event>) {
        eventNameToSerializerMapping[name] = serializer
    }

    fun <T> deserialize(frame: EventResponseFrame, serializer: KSerializer<T>): T where T : Event {
        try {
            if (serializer == Event.serializer()) {
                @Suppress("UNCHECKED_CAST")
                return Event.fromMethodName(frame.method) as T
            } else {
                return Json.decodeFromJsonElement(serializer, frame.params)
            }
        } catch (e: Throwable) {
            throw DeserializationFailed("Could not deserialize event $frame with $serializer", e)
        }
    }

    fun deserializeEvent(frame: EventResponseFrame): Event {
        return deserialize(frame, eventNameToSerializerMapping[frame.method] ?: Event.serializer())
    }
}
