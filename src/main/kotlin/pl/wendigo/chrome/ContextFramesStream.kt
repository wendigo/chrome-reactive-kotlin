package pl.wendigo.chrome

import io.reactivex.Observable
import io.reactivex.Single
import pl.wendigo.chrome.domain.target.BrowserContextID
import pl.wendigo.chrome.domain.target.SendMessageToTargetRequest
import pl.wendigo.chrome.domain.target.TargetDomain
import pl.wendigo.chrome.domain.target.TargetID


/**
 * Frames stream that supports browser context
 */
class ContextFramesStream (
    private val mapper : FrameMapper,
    private val target : TargetDomain,
    private val targetId : TargetID,
    private val browserContextID : BrowserContextID
) : ProtocolStream {
    override fun <T> getResponse(requestFrame : RequestFrame, clazz : Class<T>) : Single<T> {
        return allFrames().filter {
            !it.isEvent()
        }.filter {
            it.id == requestFrame.id
        }.flatMapSingle {
            mapper.deserializeResponse(requestFrame, it, clazz)
        }
        .take(1)
        .singleOrError()
    }

    override fun send(frame : RequestFrame) : Single<Boolean> {
        return mapper.serialize(frame).flatMap {
            target.sendMessageToTarget(SendMessageToTargetRequest(
                    targetId = targetId,
                    message = it
            ))
        }.map {
            true
        }
    }

    override fun allEventFrames() : Observable<ResponseFrame> {
        return allFrames().filter(ResponseFrame::isEvent)
    }

    internal fun allFrames() : Observable<ResponseFrame> {
       return target.receivedMessageFromTarget().filter {
           it.targetId == targetId
       }.map {
           mapper.deserialize(it.message, ResponseFrame::class.java)
       }.toObservable()
    }

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}