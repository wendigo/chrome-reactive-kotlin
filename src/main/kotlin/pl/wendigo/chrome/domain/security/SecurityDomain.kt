package pl.wendigo.chrome.domain.security

/**
 * Security
 */
@pl.wendigo.chrome.ProtocolExperimental class SecurityDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables tracking security state changes.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Security.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables tracking security state changes.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Security.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Displays native dialog with the certificate details.
	 */
	  fun showCertificateViewer() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Security.showCertificateViewer", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
  /**
   * The security state of the page changed.
   */
   fun onSecurityStateChanged() : io.reactivex.Flowable<SecurityStateChangedEvent> {
      return connection.captureEvents("Security.securityStateChanged", SecurityStateChangedEvent::class.java)
   }
}








/**
 * Represents responseFrame from Security. method call.
 *
 * The security state of the page changed.
 */
data class SecurityStateChangedEvent(
  /**
   * Security state.
   */
  val securityState : SecurityState,

  /**
   * True if the page was loaded over cryptographic transport such as HTTPS.
   */
  val schemeIsCryptographic : Boolean,

  /**
   * List of explanations for the security state. If the overall security state is `insecure` or `warning`, at least one corresponding explanation should be included.
   */
  val explanations : Array<SecurityStateExplanation>,

  /**
   * Information about insecure content on the page.
   */
  val insecureContentStatus : InsecureContentStatus,

  /**
   * Overrides user-visible description of the state.
   */
  val summary : String? = null

) : pl.wendigo.chrome.DebuggerEvent(domain = "Security", name = "securityStateChanged")

