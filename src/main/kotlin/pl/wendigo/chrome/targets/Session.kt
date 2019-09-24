package pl.wendigo.chrome.targets

import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetInfo
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection

/**
 * Represents browser session target
 */
class Session(
    val targetInfo: TargetInfo,
    val sessionId: SessionID,
    connection: ChromeDebuggerConnection
) : DevToolsProtocol(connection) {
    override fun toString(): String {
        return "Session(sessionId='$sessionId')"
    }
}
