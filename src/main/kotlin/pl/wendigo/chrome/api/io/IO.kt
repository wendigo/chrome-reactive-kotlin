package pl.wendigo.chrome.domain.io

/**
 * Input/Output operations for streams produced by DevTools.
 *
 * @link [https://chromedevtools.github.io/devtools-protocol/tot/IO](https://chromedevtools.github.io/devtools-protocol/tot/IO)
 */
class IO internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Close the stream, discard any temporary backing storage.
     */
    fun close(input: CloseRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("IO.close", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Read a chunk of the stream
     */
    fun read(input: ReadRequest): io.reactivex.Single<ReadResponse> {
        return connectionRemote.runAndCaptureResponse("IO.read", input, ReadResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Return UUID of Blob object specified by a remote object id.
     */
    fun resolveBlob(input: ResolveBlobRequest): io.reactivex.Single<ResolveBlobResponse> {
        return connectionRemote.runAndCaptureResponse("IO.resolveBlob", input, ResolveBlobResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all IO domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "IO"
        }
    }
}
/**
 * Represents request frame that can be used with IO.close method call.
 *
 * Close the stream, discard any temporary backing storage.
 */
data class CloseRequest(
    /**
     * Handle of the stream to close.
     */
    val handle: StreamHandle

)

/**
 * Represents request frame that can be used with IO.read method call.
 *
 * Read a chunk of the stream
 */
data class ReadRequest(
    /**
     * Handle of the stream to read.
     */
    val handle: StreamHandle,

    /**
     * Seek to the specified offset before reading (if not specificed, proceed with offset
following the last read). Some types of streams may only support sequential reads.
     */
    val offset: Int? = null,

    /**
     * Maximum number of bytes to read (left upon the agent discretion if not specified).
     */
    val size: Int? = null

)

/**
 * Represents response frame for IO.read method call.
 *
 * Read a chunk of the stream
 */
data class ReadResponse(
    /**  
     * Set if the data is base64-encoded  
     */  
    val base64Encoded: Boolean? = null,

    /**  
     * Data that were read.  
     */  
    val data: String,

    /**  
     * Set if the end-of-file condition occured while reading.  
     */  
    val eof: Boolean

)

/**
 * Represents request frame that can be used with IO.resolveBlob method call.
 *
 * Return UUID of Blob object specified by a remote object id.
 */
data class ResolveBlobRequest(
    /**
     * Object id of a Blob object wrapper.
     */
    val objectId: pl.wendigo.chrome.domain.runtime.RemoteObjectId

)

/**
 * Represents response frame for IO.resolveBlob method call.
 *
 * Return UUID of Blob object specified by a remote object id.
 */
data class ResolveBlobResponse(
    /**  
     * UUID of the specified Blob.  
     */  
    val uuid: String

)
