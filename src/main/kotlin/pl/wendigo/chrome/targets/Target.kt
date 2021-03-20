package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.ProtocolDomains
import pl.wendigo.chrome.api.target.GetTargetInfoRequest
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.sync
import pl.wendigo.chrome.protocol.DebuggerWebsocketConnection
import java.io.Closeable

/**
 * Represents browser [Target] that can be controlled via DevTools Protocol API
 */
class Target(
    private val manager: Manager,
    val session: SessionTarget,
    connection: DebuggerWebsocketConnection
) : ProtocolDomains(connection), AutoCloseable, Closeable {
    /**
     * Returns [TargetInfo] for given target directly from inspector protocol.
     */
    fun info(): TargetInfo {
        return sync(Target.getTargetInfo(GetTargetInfoRequest(session.targetId))).targetInfo
    }

    /**
     * Closes target releasing all resources on the browser side.
     */
    override fun close() {
        return manager.close(this)
    }

    /**
     * Releases underlying connection.
     */
    internal fun closeConnection() {
        return connection.close()
    }

    override fun toString(): String {
        return "Target(id='${session.targetId}', sessionId='${session.sessionId}, browserContextId='${session.browserContextID}')"
    }
}
