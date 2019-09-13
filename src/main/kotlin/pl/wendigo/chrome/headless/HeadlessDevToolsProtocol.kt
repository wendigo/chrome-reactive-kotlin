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
    val sessionDescriptor: HeadlessSessionDescriptor
) : DevToolsProtocol(connection) {
    override fun toString(): String = "HeadlessChromeProtocol(session=$sessionDescriptor)"

    companion object {

        @Experimental
        @JvmOverloads
        fun create(api: DevToolsProtocol, url: String, width: Int = 1024, height: Int = 768): HeadlessDevToolsProtocol = await {
            val mapper = FrameMapper()

            api.Target.createBrowserContext().flatMap { (browserContextId) ->
                api.Target.createTarget(
                    CreateTargetRequest(
                        url = url,
                        browserContextId = browserContextId,
                        height = height,
                        width = width
                    )
                ).flatMap { (targetId) ->
                    api.Target.attachToTarget(AttachToTargetRequest(targetId = targetId)).map { (sessionId) ->
                        val session = HeadlessSessionDescriptor(
                            browserContextId = browserContextId,
                            targetId = targetId,
                            sessionId = sessionId,
                            url = url,
                            width = width,
                            height = height
                        )

                        HeadlessDevToolsProtocol(
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
            }
        }
    }
}
