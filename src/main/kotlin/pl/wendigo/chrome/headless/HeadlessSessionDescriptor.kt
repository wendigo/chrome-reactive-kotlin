package pl.wendigo.chrome.headless

import pl.wendigo.chrome.api.target.BrowserContextID
import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetID

/**
 * Represents basic headless session data.
 */
data class HeadlessSessionDescriptor(
    val browserContextId: BrowserContextID,
    val targetId: TargetID,
    val sessionId: SessionID,
    val height: Int,
    val width: Int,
    val url: String
)
