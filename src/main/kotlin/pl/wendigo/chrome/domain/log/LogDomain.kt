package pl.wendigo.chrome.domain.log

/**
 * Provides access to log entries.
 */
@pl.wendigo.chrome.ProtocolExperimental class LogDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * Enables log domain, sends the entries collected so far to the client by means of the <code>entryAdded</code> notification.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables log domain, prevents further log entries from being reported to the client.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Clears the log.
	 */
	  fun clear() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.clear", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * start violation reporting.
	 */
	  fun startViolationsReport(input : StartViolationsReportRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.startViolationsReport", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Stop violation reporting.
	 */
	  fun stopViolationsReport() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Log.stopViolationsReport", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
    /**
     * Issued when new message was logged.
     */
    fun entryAdded() : io.reactivex.Flowable<EntryAddedEvent> {
        return connectionRemote.captureEvents("Log.entryAdded", EntryAddedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Log domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "Log"
        }
    }
}






/**
 * Represents requestFrame parameters that can be used with Log.startViolationsReport method call.
 *
 * start violation reporting.
 */
data class StartViolationsReportRequest (
    /**
     * Configuration for violations.
     */
    val config : Array<ViolationSetting>

)




/**
 * Represents responseFrame from Log. method call.
 *
 * Issued when new message was logged.
 */
data class EntryAddedEvent(
  /**
   * The entry.
   */
  val entry : LogEntry

) : pl.wendigo.chrome.ProtocolEvent(domain = "Log", name = "entryAdded")

