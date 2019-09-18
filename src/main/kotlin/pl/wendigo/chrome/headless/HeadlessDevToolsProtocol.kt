package pl.wendigo.chrome.headless

import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.AttachToTargetRequest
import pl.wendigo.chrome.api.target.CreateTargetRequest
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection
import pl.wendigo.chrome.protocol.Experimental
import pl.wendigo.chrome.protocol.FrameMapper

class HeadlessDevToolsProtocol(
    connection: ChromeDebuggerConnection,
    val sessionDescriptor: SessionDescriptor
) : DevToolsProtocol(connection) {
    override fun toString(): String = "HeadlessChromeProtocol(session=$sessionDescriptor)"

    companion object {

        @Experimental
        @JvmOverloads
        fun create(api: DevToolsProtocol, url: String, width: Int = 1024, height: Int = 768): HeadlessDevToolsProtocol {
            val mapper = FrameMapper()

            val (browserContextId) = await {
                api.Target.createBrowserContext()
            }

            val (targetId) = await {
                api.Target.createTarget(
                        CreateTargetRequest(
                                url = url,
                                browserContextId = browserContextId,
                                height = height,
                                width = width
                        ))
            }

            val (sessionId) = await {
                api.Target.attachToTarget(AttachToTargetRequest(targetId = targetId))
            }

            val session = SessionDescriptor(
                    browserContextId = browserContextId,
                    targetId = targetId,
                    sessionId = sessionId,
                    url = url,
                    width = width,
                    height = height
            )

            val connection = ChromeDebuggerConnection(
                    TargetedFramesStream(
                        mapper,
                        api,
                        session
                    )
            )

            return HeadlessDevToolsProtocol(
                connection,
                session
            )
        }
    }
}

