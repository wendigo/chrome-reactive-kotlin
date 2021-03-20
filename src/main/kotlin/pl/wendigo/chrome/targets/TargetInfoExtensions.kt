package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetInfo

/**
 * Returns true if [TargetInfo] represents page.
 */
fun TargetInfo.isPage() = this.type == "page"

/**
 * Converts [TargetInfo] to [SessionTarget] for given sessionID
 */
fun TargetInfo.toTarget(sessionId: SessionID): SessionTarget = SessionTarget(
    sessionId = sessionId,
    targetId = this.targetId,
    browserContextID = this.browserContextId
)
