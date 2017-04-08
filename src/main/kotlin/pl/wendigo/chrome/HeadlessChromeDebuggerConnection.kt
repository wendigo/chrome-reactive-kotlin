package pl.wendigo.chrome

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.subjects.ReplaySubject
import okhttp3.OkHttpClient
import pl.wendigo.chrome.domain.target.AttachToTargetRequest
import pl.wendigo.chrome.domain.target.BrowserContextID
import pl.wendigo.chrome.domain.target.CreateTargetRequest
import pl.wendigo.chrome.domain.target.SendMessageToTargetRequest
import pl.wendigo.chrome.domain.target.TargetDomain
import pl.wendigo.chrome.domain.target.TargetID

internal class HeadlessChromeDebuggerConnection(
        private val mapper: FrameMapper,
        private val target : TargetDomain,
        private val targetId : TargetID,
        private val browserContextId : BrowserContextID
) {
    companion object {
        /**
         * Opens new ChromeDebuggerConnection session for given websocket uri.
         */
        @JvmStatic
        fun openSession(url: String, eventBufferSize: Int = 128) : DebuggerProtocol {
            val mapper = FrameMapper()
            val frames = FramesStream(url, ReplaySubject.create(eventBufferSize), mapper, OkHttpClient())

            val connection = ChromeDebuggerConnection(frames, mapper)
            val targetDomain = TargetDomain(connection)
            val contextId = targetDomain.createBrowserContext().blockingGet()

            val siteTarget = targetDomain.createTarget(CreateTargetRequest(
                    url="about:blank",
                    browserContextId = contextId.browserContextId)
            ).flatMap { target ->
                targetDomain.attachToTarget(AttachToTargetRequest(target.targetId)).map {
                    target.targetId
                }
            }.blockingGet()

            println(contextId)
            println(siteTarget)

            return ChromeDebuggerConnection(
                ContextFramesStream(
                        mapper,
                        targetDomain,
                        siteTarget,
                        contextId.browserContextId
                ),
                mapper
            )
        }
    }
}