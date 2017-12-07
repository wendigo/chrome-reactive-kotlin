package pl.wendigo.chrome.domain.log

/**
 * Provides access to log entries.
 */
class LogDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Clears the log.
     */
    fun clear() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.clear", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables log domain, prevents further log entries from being reported to the client.
     */
    fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables log domain, sends the entries collected so far to the client by means of the
`entryAdded` notification.
     */
    fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * start violation reporting.
     */
    fun startViolationsReport(input : StartViolationsReportRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.startViolationsReport", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stop violation reporting.
     */
    fun stopViolationsReport() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.stopViolationsReport", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Issued when new message was logged.
     */
    fun entryAdded() : io.reactivex.Flowable<EntryAddedEvent> {
        return entryAddedTimed().map {
            it.value()
        }
    }

    /**
     * Issued when new message was logged.
     */
    fun entryAddedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<EntryAddedEvent>> {
        return connectionRemote.captureEvents("Log.entryAdded", EntryAddedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Log domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Log"
        }
    }
}

/**
 * Represents request frame that can be used with Log.startViolationsReport method call.
 *
 * start violation reporting.
 */
data class StartViolationsReportRequest (
    /**
     * Configuration for violations.
     */
    val config : List<ViolationSetting>

)

/**
 * Represents event frames for Log.entryAdded
 *
 * Issued when new message was logged.
 */
data class EntryAddedEvent(
  /**
   * The entry.
   */
  val entry : LogEntry

) : pl.wendigo.chrome.ProtocolEvent(domain = "Log", name = "entryAdded")

