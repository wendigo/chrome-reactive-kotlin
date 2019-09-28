package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.BrowserContextID
import pl.wendigo.chrome.api.target.ReceivedMessageFromTargetEvent
import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetID

/**
 * SessionTarget represents headless session data.
 */
data class Target(
    val sessionId: SessionID,
    val targetId: TargetID,
    val browserContextID: BrowserContextID? = null
)
