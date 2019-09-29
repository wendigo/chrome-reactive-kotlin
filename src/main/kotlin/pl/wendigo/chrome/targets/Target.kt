package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.BrowserContextID
import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetID

/**
 * SessionTarget represents session we are currently connected to.
 */
data class Target(
    val sessionId: SessionID,
    val targetId: TargetID,
    val browserContextID: BrowserContextID? = null
)
