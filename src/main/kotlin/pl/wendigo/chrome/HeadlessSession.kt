package pl.wendigo.chrome

import pl.wendigo.chrome.domain.target.BrowserContextID
import pl.wendigo.chrome.domain.target.SessionID
import pl.wendigo.chrome.domain.target.TargetID

data class HeadlessSession (
    val browserContextId: BrowserContextID,
    val targetId: TargetID,
    val sessionId: SessionID,
    val height : Int,
    val width : Int,
    val url : String
)