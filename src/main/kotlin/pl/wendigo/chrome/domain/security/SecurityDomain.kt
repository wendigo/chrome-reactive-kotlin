package pl.wendigo.chrome.domain.security

/**
 * Security
 */
@pl.wendigo.chrome.Experimental class SecurityDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * Enables tracking security state changes.
	 */
	 fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Security.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * Enables tracking security state changes.
    */
     fun enableTimed() : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("Security.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * Disables tracking security state changes.
	 */
	 fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Security.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * Disables tracking security state changes.
    */
     fun disableTimed() : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("Security.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * Displays native dialog with the certificate details.
	 */
	 fun showCertificateViewer() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Security.showCertificateViewer", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * Displays native dialog with the certificate details.
    */
     fun showCertificateViewerTimed() : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("Security.showCertificateViewer", null, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * Handles a certificate error that fired a certificateError event.
	 */
	 fun handleCertificateError(input : HandleCertificateErrorRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Security.handleCertificateError", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * Handles a certificate error that fired a certificateError event.
    */
     fun handleCertificateErrorTimed(input : HandleCertificateErrorRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("Security.handleCertificateError", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * Enable/disable overriding certificate errors. If enabled, all certificate error events need to be handled by the DevTools client and should be answered with handleCertificateError commands.
	 */
	 fun setOverrideCertificateErrors(input : SetOverrideCertificateErrorsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Security.setOverrideCertificateErrors", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * Enable/disable overriding certificate errors. If enabled, all certificate error events need to be handled by the DevTools client and should be answered with handleCertificateError commands.
    */
     fun setOverrideCertificateErrorsTimed(input : SetOverrideCertificateErrorsRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("Security.setOverrideCertificateErrors", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

  
    /**
     * The security state of the page changed.
     */
    fun securityStateChanged() : io.reactivex.Flowable<SecurityStateChangedEvent> {
        return securityStateChangedTimed().map {
            it.value()
        }
    }

    /**
     * The security state of the page changed.
     */
     fun securityStateChangedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<SecurityStateChangedEvent>> {
        return connectionRemote.captureEvents("Security.securityStateChanged", SecurityStateChangedEvent::class.java)
     }

    /**
     * There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the handleCertificateError command. Note: this event does not fire if the certificate error has been allowed internally.
     */
    fun certificateError() : io.reactivex.Flowable<CertificateErrorEvent> {
        return certificateErrorTimed().map {
            it.value()
        }
    }

    /**
     * There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the handleCertificateError command. Note: this event does not fire if the certificate error has been allowed internally.
     */
     fun certificateErrorTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<CertificateErrorEvent>> {
        return connectionRemote.captureEvents("Security.certificateError", CertificateErrorEvent::class.java)
     }

    /**
     * Returns flowable capturing all Security domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Security"
        }
    }
}






/**
 * Represents requestFrame parameters that can be used with Security.handleCertificateError method call.
 *
 * Handles a certificate error that fired a certificateError event.
 */
data class HandleCertificateErrorRequest (
    /**
     * The ID of the event.
     */
    val eventId : Int,

    /**
     * The action to take on the certificate error.
     */
    val action : CertificateErrorAction

)


/**
 * Represents requestFrame parameters that can be used with Security.setOverrideCertificateErrors method call.
 *
 * Enable/disable overriding certificate errors. If enabled, all certificate error events need to be handled by the DevTools client and should be answered with handleCertificateError commands.
 */
data class SetOverrideCertificateErrorsRequest (
    /**
     * If true, certificate errors will be overridden.
     */
    val override : Boolean

)


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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Security", name = "securityStateChanged")

/**
 * Represents responseFrame from Security. method call.
 *
 * There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the handleCertificateError command. Note: this event does not fire if the certificate error has been allowed internally.
 */
data class CertificateErrorEvent(
  /**
   * The ID of the event.
   */
  val eventId : Int,

  /**
   * The type of the error.
   */
  val errorType : String,

  /**
   * The url that was requested.
   */
  val requestURL : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Security", name = "certificateError")

