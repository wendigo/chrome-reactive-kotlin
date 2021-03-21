package pl.wendigo.chrome.protocol

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.functions.Predicate

open class Domain(
    private val name: String,
    private val description: String,
    internal val connection: ProtocolConnection
) {
    /**
     * Returns domain name.
     */
    fun name(): String = name

    /**
     * Returns domain description.
     */
    fun description(): String = description

    /**
     * Returns flowable capturing all domains events.
     */
    fun events(): Flowable<Event> {
        return connection.events().filter {
            it.domain() == name
        }
    }

    /**
     * Returns flowable capturing all domains events matching predicate.
     */
    fun events(filter: Predicate<Event>): Flowable<Event> {
        return connection.events().filter {
            it.domain() == name && filter.test(it)
        }
    }

    /**
     * Returns flowable capturing all domain events of a given type.
     */
    fun <T> events(eventClass: Class<T>): Flowable<T> where T : Event {
        return events().ofType(eventClass)
    }

    /**
     * Returns flowable capturing all domain events of a given type matching predicate.
     */
    fun <T> events(eventClass: Class<T>, filter: Predicate<T>): Flowable<T> where T : Event {
        return events(eventClass).filter(filter)
    }

    /**
     * Returns domain dependencies.
     */
    open fun getDependencies(): List<Domain> = listOf()
}
