package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Timed
import org.slf4j.LoggerFactory
import pl.wendigo.chrome.domain.target.CloseTargetRequest
import pl.wendigo.chrome.domain.target.DisposeBrowserContextRequest
import pl.wendigo.chrome.domain.target.SendMessageToTargetRequest

/**
 * Frames stream that supports browser context with target/session ids
 */
class TargetedFramesStream(
    private val mapper: FrameMapper,
    private val api: ChromeProtocol,
    private val session: HeadlessSession
) : FramesStream {
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

    override fun send(frame: RequestFrame): Single<Boolean> {
        return mapper.serialize(frame).flatMap { message ->
            api.Target.sendMessageToTarget(SendMessageToTargetRequest(
                    sessionId = session.sessionId,
                    targetId = session.targetId,
                    message = message
            ))
            .map { it.isResponse() }
        }
    }

    override fun eventFrames(): Observable<Timed<ResponseFrame>> = frames().filter {
        it.value().isEvent()
    }

    override fun frames(): Observable<Timed<ResponseFrame>> {
        return api.Target.receivedMessageFromTargetTimed().filter { message ->
            message.value().run {
                sessionId == this@TargetedFramesStream.session.sessionId ||
                targetId == this@TargetedFramesStream.session.targetId
            }
        }
        .map { frame ->
            Timed(mapper.deserialize(frame.value().message, ResponseFrame::class.java), frame.time(), frame.unit())
        }
        .toObservable()
    }

    override fun close() {
        try {
            val response = api.Target.closeTarget(CloseTargetRequest(session.targetId)).flatMap {
                api.Target.disposeBrowserContext(DisposeBrowserContextRequest(session.browserContextId))
            }
            .blockingGet()

            logger.info("Closed session {} with status {}", session, response)

            api.close()
        } catch (e: Exception) {
            logger.info("Could not close target due to exception ${e.message}")
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(TargetedFramesStream::class.java) !!
    }
}
