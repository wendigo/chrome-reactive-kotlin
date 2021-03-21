package pl.wendigo.chrome.protocol

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import pl.wendigo.chrome.api.EventSerializers
import pl.wendigo.chrome.protocol.websocket.EventResponseFrame

/**
 * EventMapper is responsible for mapping events carried by [EventResponseFrame] to concrete events representations.
 */
class EventMapper {
    fun <T> deserialize(eventFrame: EventResponseFrame, eventSerializer: KSerializer<T>): T where T : Event {
        try {
            if (eventSerializer == RawEvent.serializer()) {
                @Suppress("UNCHECKED_CAST")
                return Event.fromFrame(eventFrame) as T
            }

            return Json.decodeFromJsonElement(eventSerializer, eventFrame.params)
        } catch (e: Throwable) {
            throw DeserializationFailed("Could not deserialize event $eventFrame with $eventSerializer", e)
        }
    }

    /**
     * Deserializes [EventResponseFrame] into concrete event type representation using
     * serializer returned by [EventSerializers.getByEventName].
     */
    fun deserialize(eventFrame: EventResponseFrame): Event {
        return deserialize(eventFrame, EventSerializers.getByEventName(eventFrame))
    }
}
