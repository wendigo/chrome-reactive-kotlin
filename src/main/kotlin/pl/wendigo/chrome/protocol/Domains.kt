package pl.wendigo.chrome.protocol

import io.reactivex.rxjava3.core.Flowable
import pl.wendigo.chrome.api.target.SessionID
import java.io.Closeable

open class Domains internal constructor(private val protocolVersion: String, protected val connection: DebuggerWebSocketConnection) :
    Closeable, AutoCloseable {

    /**
     * Returns [Flowable] capturing all events.
     */
    fun events(): Flowable<Event> {
        return connection.events()
    }

    /**
     * Closes underlying debugger WebSocket connection.
     */
    override fun close() {
        return connection.close()
    }

    /**
     * Returns protocol version.
     */
    fun protocolVersion(): String {
        return protocolVersion
    }

    internal fun cloneConnection(sessionID: SessionID) = connection.cloneForSessionId(sessionID)
}
