package pl.wendigo.chrome.targets

import pl.wendigo.chrome.api.target.TargetInfo

fun TargetInfo.isPage() = this.type == "page"
fun TargetInfo.toTarget(sessionId: String) = pl.wendigo.chrome.targets.Target(
    sessionId = sessionId,
    targetId = this.targetId
)
