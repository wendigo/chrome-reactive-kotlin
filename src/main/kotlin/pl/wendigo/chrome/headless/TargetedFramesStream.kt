package pl.wendigo.chrome.headless

import io.reactivex.Flowable
import io.reactivex.Single
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.CloseTargetRequest
import pl.wendigo.chrome.api.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.api.target.SendMessageToTargetRequest
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.*

/**
 * TargetedFramesStream is a [FramesStream] that talks with Chrome DevTools Protocol via [Target](https://chromedevtools.github.io/devtools-protocol/tot/Target) domain.
 *
 * It encapsulates all frames in target's frames.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/Target](https://chromedevtools.github.io/devtools-protocol/tot/Target)
 * @see [pl.wendigo.chrome.api.target.TargetOperations]
 */
class TargetedFramesStream(
    private val mapper: FrameMapper,
    private val api: DevToolsProtocol,
    private val sessionDescriptor: SessionDescriptor
) : FramesStream {
    /**
     * Retrieves response from frames stream matching request id (frames are filtered by session and target id).
     */
    override fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>): Single<T> {
        return frames().filter {
            it.matchesRequest(requestFrame)
        }
        .map { frame ->
            mapper.deserializeResponse(requestFrame, frame, clazz)
        }
        .take(1)
        .singleOrError()
    }

    /**
     * Sends request frame to a given session and target.
     */
    override fun send(request: RequestFrame): Single<Boolean> {
        val frame = SendMessageToTargetRequest(
            sessionId = sessionDescriptor.sessionId,
            targetId = sessionDescriptor.targetId,
            message = mapper.serialize(request)
        )

        return api.Target.sendMessageToTarget(frame).map { it.isResponse() }
    }

    /**
     * Returns all frames that are events for given session and target.
     */
    override fun eventFrames(): Flowable<ResponseFrame> = frames().filter(ResponseFrame::isEvent)

    /**
     * Receives all frames and filters out frames which are not belonging to given session and target.
     */
    override fun frames(): Flowable<ResponseFrame> {
        return api.Target.receivedMessageFromTarget().filter { message ->
            message.run {
                sessionId == this@TargetedFramesStream.sessionDescriptor.sessionId ||
                    targetId == this@TargetedFramesStream.sessionDescriptor.targetId
            }
        }.map { frame ->
            mapper.deserialize(frame.message, ResponseFrame::class.java)
        }
    }

    /**
     * Closes given session.
     */
    override fun close() {
        try {
            val response = await {
                api.Target.closeTarget(CloseTargetRequest(sessionDescriptor.targetId)).flatMap {
                    api.Target.disposeBrowserContext(DisposeBrowserContextRequest(sessionDescriptor.browserContextId))
                }
            }

            logger.info("Closed session {} with status {}", sessionDescriptor, response)
            api.close()
        } catch (e: Exception) {
            logger.info("Could not close target due to exception ${e.message}")
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(TargetedFramesStream::class.java) !!
    }
}
