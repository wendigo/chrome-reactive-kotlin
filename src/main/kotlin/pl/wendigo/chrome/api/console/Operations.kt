package pl.wendigo.chrome.api.console

/**
 * This domain is deprecated - use Runtime or Log instead.
 *
 * @link Protocol [Console](https://chromedevtools.github.io/devtools-protocol/tot/Console) domain documentation.
 */
@Deprecated(level = DeprecationLevel.WARNING, message = "This domain is deprecated - use Runtime or Log instead.")
class ConsoleOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Enables console domain, sends the messages collected so far to the client by means of the <code>messageAdded</code> notification.
     *
     * @link Protocol [Console#enable](https://chromedevtools.github.io/devtools-protocol/tot/Console#method-enable) method documentation.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Console.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables console domain, prevents further console messages from being reported to the client.
     *
     * @link Protocol [Console#disable](https://chromedevtools.github.io/devtools-protocol/tot/Console#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Console.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Does nothing.
     *
     * @link Protocol [Console#clearMessages](https://chromedevtools.github.io/devtools-protocol/tot/Console#method-clearMessages) method documentation.
     */
    fun clearMessages(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Console.clearMessages", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Issued when new console message is added.
     */
    fun messageAdded(): io.reactivex.Flowable<MessageAddedEvent> {
        return messageAddedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when new console message is added.
     */
    fun messageAddedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<MessageAddedEvent>> {
        return connection.captureEvents("Console.messageAdded", MessageAddedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Console domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Console"
        }
    }
}

/**
 * Issued when new console message is added.
 *
 * @link [Console#messageAdded](https://chromedevtools.github.io/devtools-protocol/tot/Console#event-messageAdded) event documentation.
 */
data class MessageAddedEvent(
    /**  
     * Console message that has been added.  
     */  
    val message: ConsoleMessage

) : pl.wendigo.chrome.protocol.Event(domain = "Console", name = "messageAdded")
