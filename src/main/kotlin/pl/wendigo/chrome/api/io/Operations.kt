package pl.wendigo.chrome.api.io

/**
 * Input/Output operations for streams produced by DevTools.
 *
 * @link Protocol [IO](https://chromedevtools.github.io/devtools-protocol/tot/IO) domain documentation.
 */
class IOOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Close the stream, discard any temporary backing storage.
     *
     * @link Protocol [IO#close](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-close) method documentation.
     */
    fun close(input: CloseRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("IO.close", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Read a chunk of the stream
     *
     * @link Protocol [IO#read](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-read) method documentation.
     */
    fun read(input: ReadRequest): io.reactivex.Single<ReadResponse> = connection.runAndCaptureResponse("IO.read", input, ReadResponse::class.java)

    /**
     * Return UUID of Blob object specified by a remote object id.
     *
     * @link Protocol [IO#resolveBlob](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-resolveBlob) method documentation.
     */
    fun resolveBlob(input: ResolveBlobRequest): io.reactivex.Single<ResolveBlobResponse> = connection.runAndCaptureResponse("IO.resolveBlob", input, ResolveBlobResponse::class.java)

    /**
     * Returns flowable capturing all IO domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "IO"
        }
    }
}
/**
 * Represents request frame that can be used with [IO#close](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-close) operation call.
 *
 * Close the stream, discard any temporary backing storage.
 * @link [IO#close](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-close) method documentation.
 * @see [IOOperations.close]
 */
data class CloseRequest(
    /**
     * Handle of the stream to close.
     */
    val handle: StreamHandle

)

/**
 * Represents request frame that can be used with [IO#read](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-read) operation call.
 *
 * Read a chunk of the stream
 * @link [IO#read](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-read) method documentation.
 * @see [IOOperations.read]
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
 * Represents response frame that is returned from [IO#read](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-read) operation call.
 * Read a chunk of the stream
 *
  
 * @link [IO#read](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-read) method documentation.
 * @see [IOOperations.read]
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
 * Represents request frame that can be used with [IO#resolveBlob](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-resolveBlob) operation call.
 *
 * Return UUID of Blob object specified by a remote object id.
 * @link [IO#resolveBlob](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-resolveBlob) method documentation.
 * @see [IOOperations.resolveBlob]
 */
data class ResolveBlobRequest(
    /**
     * Object id of a Blob object wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId

)
/**
 * Represents response frame that is returned from [IO#resolveBlob](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-resolveBlob) operation call.
 * Return UUID of Blob object specified by a remote object id.
 *
  
 * @link [IO#resolveBlob](https://chromedevtools.github.io/devtools-protocol/tot/IO#method-resolveBlob) method documentation.
 * @see [IOOperations.resolveBlob]
 */
data class ResolveBlobResponse(
    /**  
     * UUID of the specified Blob.  
     */  
    val uuid: String

)
