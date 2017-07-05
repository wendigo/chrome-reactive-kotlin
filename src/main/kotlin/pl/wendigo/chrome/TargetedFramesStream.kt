package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Timed
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.domain.target.BrowserContextID
import pl.wendigo.chrome.domain.target.CloseTargetRequest
import pl.wendigo.chrome.domain.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.domain.target.SendMessageToTargetRequest
import pl.wendigo.chrome.domain.target.TargetID

/**
 * Frames stream that supports browser context
 */
class TargetedFramesStream(
    private val mapper : FrameMapper,
    private val api : ChromeProtocol,
    private val targetId : TargetID,
    private val browserContextID : BrowserContextID
) : FramesStream {
    override fun <T> getResponse(requestFrame : RequestFrame, clazz : Class<T>) : Single<Timed<T>> {
        return frames().filter {
            it.value().isResponse(requestFrame.id)
        }
        .flatMapSingle { frame ->
            mapper.deserializeResponse(requestFrame, frame.value(), clazz).map {
                Timed<T>(it, frame.time(), frame.unit())
            }
        }
        .take(1)
        .singleOrError()
    }

    override fun send(frame : RequestFrame) : Single<Boolean> {
        return mapper.serialize(frame).flatMap { message ->
            api.Target.sendMessageToTarget(SendMessageToTargetRequest(
                    targetId = targetId,
                    message = message
            ))
            .map { it.isResponse() }
        }
    }

    override fun eventFrames() : Observable<Timed<ResponseFrame>> {
        return frames().filter { it.value().isEvent() }
    }

    override fun frames() : Observable<Timed<ResponseFrame>> {
        return api.Target.receivedMessageFromTargetTimed().filter { message ->
            message.value().targetId == targetId
        }
        .map { frame ->
            Timed<ResponseFrame>(mapper.deserialize(frame.value().message, ResponseFrame::class.java), frame.time(), frame.unit())
        }
        .toObservable()
    }

    override fun close() {
        try {
            val response = api.Target.closeTarget(CloseTargetRequest(targetId)).flatMap {
                api.Target.disposeBrowserContext(DisposeBrowserContextRequest(browserContextID))
            }
            .blockingGet()

            logger.info("Closed target {} with status {}", targetId, response)

            api.close()

        } catch (e : Exception) {
            logger.info("Could not close target: {}", e)
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(TargetedFramesStream::class.java) !!
    }
}