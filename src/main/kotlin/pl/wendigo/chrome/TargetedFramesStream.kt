package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.domain.target.BrowserContextID
import pl.wendigo.chrome.domain.target.CloseTargetRequest
import pl.wendigo.chrome.domain.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.domain.target.SendMessageToTargetRequest
import pl.wendigo.chrome.domain.target.TargetDomain
import pl.wendigo.chrome.domain.target.TargetID

/**
 * Frames stream that supports browser context
 */
class TargetedFramesStream(
    private val mapper : FrameMapper,
    private val target : TargetDomain,
    private val targetId : TargetID,
    private val browserContextID : BrowserContextID
) : FramesStream {
    override fun <T> getResponse(requestFrame : RequestFrame, clazz : Class<T>) : Single<T> {
        return frames().filter {
            it.isResponse(requestFrame.id)
        }
        .flatMapSingle {
            mapper.deserializeResponse(requestFrame, it, clazz)
        }
        .take(1)
        .singleOrError()
    }

    override fun send(frame : RequestFrame) : Single<Boolean> {
        return mapper.serialize(frame).flatMap { message ->
            target.sendMessageToTarget(SendMessageToTargetRequest(
                    targetId = targetId,
                    message = message
            ))
            .map { it.isResponse() }
        }
    }

    override fun eventFrames() : Observable<ResponseFrame> {
        return frames().filter(ResponseFrame::isEvent)
    }

    override fun frames() : Observable<ResponseFrame> {
        return target.receivedMessageFromTarget().filter { message ->
            message.targetId == targetId
        }
        .map {
            mapper.deserialize(it.message, ResponseFrame::class.java)
        }
        .toObservable()
    }

    override fun close() {
        target.closeTarget(CloseTargetRequest(targetId)).flatMap {
            target.disposeBrowserContext(DisposeBrowserContextRequest(browserContextID))
        }
        .observeOn(Schedulers.trampoline())
        .subscribe { closed, err ->
            logger.warn("[{}] closed with status: {}, {}", targetId, closed, err)
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(TargetedFramesStream::class.java) !!
    }
}