package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.ReceivedMessageFromTargetEvent
import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetID

/**
 * SessionTarget represents headless session data.
 */
data class Target(
    val sessionId: SessionID,
    val targetId: TargetID
) {
    fun matches(message: ReceivedMessageFromTargetEvent): Boolean {
        return message.sessionId == sessionId && message.targetId == targetId;
    }
}