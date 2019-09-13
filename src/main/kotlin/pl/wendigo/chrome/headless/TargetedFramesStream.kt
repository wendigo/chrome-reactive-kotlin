package pl.wendigo.chrome.headless

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Timed
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.DevToolsProtocol
import pl.wendigo.chrome.api.target.CloseTargetRequest
import pl.wendigo.chrome.api.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.api.target.SendMessageToTargetRequest
import pl.wendigo.chrome.await
import pl.wendigo.chrome.protocol.FrameMapper
import pl.wendigo.chrome.protocol.FramesStream
import pl.wendigo.chrome.protocol.RequestFrame
import pl.wendigo.chrome.protocol.ResponseFrame

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
    private val sessionDescriptor: HeadlessSessionDescriptor
) : FramesStream {
    /**
     * Retrieves response from frames stream matching request id (frames are filtered by session and target id).
     */
    override fun <T> getResponse(requestFrame: RequestFrame, clazz: Class<T>): Single<Timed<T>> {
        return frames().filter {
            it.value().isResponse(requestFrame.id)
        }
            .flatMapSingle { frame ->
                mapper.deserializeResponse(requestFrame, frame.value(), clazz).map {
                    Timed(it, frame.time(), frame.unit())
                }
            }
            .take(1)
            .singleOrError()
    }

    /**
     * Sends request frame to a given session and target.
     */
    override fun send(frame: RequestFrame): Single<Boolean> {
        return mapper.serialize(frame).flatMap { serializedMessage ->
            api.Target.sendMessageToTarget(
                SendMessageToTargetRequest(
                    sessionId = sessionDescriptor.sessionId,
                    targetId = sessionDescriptor.targetId,
                    message = serializedMessage
                )
            )
                .map { it.isResponse() }
        }
    }

    /**
     * Returns all frames that are events for given session and target.
     */
    override fun eventFrames(): Observable<Timed<ResponseFrame>> = frames().filter {
        it.value().isEvent()
    }

    /**
     * Receives all frames and filters out frames which are not belonging to given session and target.
     */
    override fun frames(): Observable<Timed<ResponseFrame>> {
        return api.Target.receivedMessageFromTargetTimed().filter { message ->
            message.value().run {
                sessionId == this@TargetedFramesStream.sessionDescriptor.sessionId ||
                    targetId == this@TargetedFramesStream.sessionDescriptor.targetId
            }
        }
            .map { frame ->
                Timed(mapper.deserialize(frame.value().message, ResponseFrame::class.java), frame.time(), frame.unit())
            }
            .toObservable()
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
