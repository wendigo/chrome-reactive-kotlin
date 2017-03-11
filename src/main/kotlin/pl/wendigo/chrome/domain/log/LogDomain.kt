package pl.wendigo.chrome.domain.log

/**
 * Provides access to log entries.
 */
@pl.wendigo.chrome.ProtocolExperimental class LogDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables log domain, sends the entries collected so far to the client by means of the <code>entryAdded</code> notification.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Log.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables log domain, prevents further log entries from being reported to the client.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Log.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Clears the log.
	 */
	  fun clear() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Log.clear", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * start violation reporting.
	 */
	  fun startViolationsReport(input : StartViolationsReportRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Log.startViolationsReport", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Stop violation reporting.
	 */
	  fun stopViolationsReport() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Log.stopViolationsReport", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
  /**
   * Issued when new message was logged.
   */
   fun onEntryAdded() : io.reactivex.Flowable<EntryAddedEvent> {
      return connection.captureEvents("Log.entryAdded", EntryAddedEvent::class.java)
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

) : pl.wendigo.chrome.DebuggerEvent(domain = "Log", name = "entryAdded")

