package pl.wendigo.chrome.api

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.functions.Predicate
import pl.wendigo.chrome.protocol.Event

open class Domain(
    private val name: String,
    private val description: String,
    protected val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection
) {
    /**
     * Returns flowable capturing all domains events.
     */
    fun events(): Flowable<Event> {
        return connection.allEvents().filter {
            it.domain() == name
        }
    }

    /**
     * Returns domain name.
     */
    fun name() = name

    /**
     * Returns domain description.
     */
    fun description() = description

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
