package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.SessionID
import pl.wendigo.chrome.api.target.TargetInfo

/**
 * Returns true if [TargetInfo] represents page.
 */
fun TargetInfo.isPage() = this.type == "page"

/**
 * Converts [TargetInfo] to [Target] for given sessionID
 */
fun TargetInfo.toTarget(sessionId: SessionID) = Target(
    sessionId = sessionId,
    targetId = this.targetId
)
