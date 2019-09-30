package pl.wendigo.chrome.targets

import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.GetTargetInfoRequest
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection

/**
 * Represents browser [Target] that can be controlled via DevTools Protocol API
 */
class Target(
    val session: SessionTarget,
    connection: ChromeDebuggerConnection
) : DevToolsProtocol(connection) {
    override fun toString(): String {
        return "Target(id='${session.targetId}', sessionId='${session.sessionId}, browserContextId='${session.browserContextID}')"
    }

    /**
     * Returns [TargetInfo] for given target directly from inspector protocol.
     */
    fun info(): TargetInfo {
        return await {
            this.Target.getTargetInfo(GetTargetInfoRequest(session.targetId))
        }.targetInfo
    }
}
