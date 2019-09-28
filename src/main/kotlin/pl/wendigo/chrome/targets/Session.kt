package pl.wendigo.chrome.targets

import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.GetTargetInfoRequest
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection

/**
 * Represents browser session target
 */
class Session(
    val target: Target,
    connection: ChromeDebuggerConnection
) : DevToolsProtocol(connection) {
    override fun toString(): String {
        return "Session(sessionId='${target.sessionId}, targetId='${target.targetId}')"
    }

    /**
     * Returns [TargetInfo] for given session directly from inspector protocol.
     */
    fun info(): TargetInfo {
        return await {
            this.Target.getTargetInfo(GetTargetInfoRequest(target.targetId))
        }.targetInfo
    }
}
