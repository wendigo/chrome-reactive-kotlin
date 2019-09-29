package pl.wendigo.chrome.protocol

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.util.concurrent.ConcurrentHashMap

/**
 * EventMapper is responsible for mapping events carried by [ResponseFrame] to typed events representations.
 */
class EventMapper(private val mapper: ObjectMapper = EventMapper.DEFAULT_MAPPER) {
    companion object {
        private val DEFAULT_MAPPER: ObjectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    private val nameToClassMapping: ConcurrentHashMap<String, Class<out Event>> = ConcurrentHashMap()

    /**
     * Add mapping from event name to class.
     */
    fun addMapping(name: String, clazz: Class<out Event>) {
        nameToClassMapping[name] = clazz
    }

    fun <T> deserialize(frame: ResponseFrame, outClazz: Class<T>): T where T : Event {
        try {
            if (outClazz == Event::class.java) {
                @Suppress("UNCHECKED_CAST")
                return Event.fromMethodName(frame.method!!) as T
            } else {
                return mapper.treeToValue(frame.params, outClazz)
            }
        } catch (e: Throwable) {
            throw DeserializationFailed("Could not deserialize event $frame to $outClazz", e)
        }
    }

    fun deserializeEvent(frame: ResponseFrame): Event {
        return deserialize(frame, nameToClassMapping[frame.method] ?: Event::class.java)
    }
}
