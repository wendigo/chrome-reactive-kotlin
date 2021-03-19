package pl.wendigo.chrome.protocol

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import pl.wendigo.chrome.api.EventSerializers

/**
 * EventMapper is responsible for mapping events carried by [EventResponseFrame] to typed events representations.
 */
class EventMapper {
    fun <T> deserialize(eventFrame: EventResponseFrame, eventSerializer: KSerializer<T>): T where T : Event {
        try {
            if (eventSerializer == RawEvent.serializer()) {
                @Suppress("UNCHECKED_CAST")
                return Event.fromFrame(eventFrame) as T
            } else {
                return Json.decodeFromJsonElement(eventSerializer, eventFrame.params)
            }
        } catch (e: Throwable) {
            throw DeserializationFailed("Could not deserialize event $eventFrame with $eventSerializer", e)
        }
    }

    fun deserialize(eventFrame: EventResponseFrame): Event {
        return deserialize(eventFrame, EventSerializers.getByEventName(eventFrame.method))
    }
}
