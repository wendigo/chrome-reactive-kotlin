package pl.wendigo.chrome

import pl.wendigo.chrome.domain.target.AttachToTargetRequest
import pl.wendigo.chrome.domain.target.CreateTargetRequest

class HeadlessChromeProtocol(
    api: DebuggerProtocol,
    val session: HeadlessSession
) : ChromeProtocol(api) {
    override fun toString(): String = "HeadlessChromeProtocol(session=$session)"

    companion object {
        @JvmOverloads
        fun create(api: ChromeProtocol, url: String, width: Int = 1024, height: Int = 768): HeadlessChromeProtocol {
            val mapper = FrameMapper()

            return api.Target.createBrowserContext().flatMap { (browserContextId) ->
                api.Target.createTarget(
                    CreateTargetRequest(
                        url = url,
                        browserContextId = browserContextId,
                        height = height,
                        width = width
                    )
                ).flatMap { (targetId) ->
                    api.Target.attachToTarget(AttachToTargetRequest(targetId = targetId)).map { (sessionId) ->
                        val session = HeadlessSession(
                            browserContextId = browserContextId,
                            targetId = targetId,
                            sessionId = sessionId,
                            url = url,
                            width = width,
                            height = height
                        )

                        HeadlessChromeProtocol(
                            ChromeDebuggerConnection(
                                TargetedFramesStream(
                                    mapper,
                                    api,
                                    session
                                ),
                                mapper
                            ),
                            session
                        )
                    }
                }
            }.blockingGet()
        }
    }
}
