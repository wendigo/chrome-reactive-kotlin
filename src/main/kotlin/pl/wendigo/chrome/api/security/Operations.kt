package pl.wendigo.chrome.api.security

/**
 * Security
 *
 * @link Protocol [Security](https://chromedevtools.github.io/devtools-protocol/tot/Security) domain documentation.
 */
class SecurityOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables tracking security state changes.
     *
     * @link Protocol [Security#disable](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-disable) method documentation.
     */
    fun disable() = connection.request("Security.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables tracking security state changes.
     *
     * @link Protocol [Security#enable](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-enable) method documentation.
     */
    fun enable() = connection.request("Security.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enable/disable whether all certificate errors should be ignored.
     *
     * @link Protocol [Security#setIgnoreCertificateErrors](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-setIgnoreCertificateErrors) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setIgnoreCertificateErrors(input: SetIgnoreCertificateErrorsRequest) = connection.request("Security.setIgnoreCertificateErrors", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Handles a certificate error that fired a certificateError event.
     *
     * @link Protocol [Security#handleCertificateError](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-handleCertificateError) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "handleCertificateError is deprecated.")
    fun handleCertificateError(input: HandleCertificateErrorRequest) = connection.request("Security.handleCertificateError", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enable/disable overriding certificate errors. If enabled, all certificate error events need to
be handled by the DevTools client and should be answered with `handleCertificateError` commands.
     *
     * @link Protocol [Security#setOverrideCertificateErrors](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-setOverrideCertificateErrors) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setOverrideCertificateErrors is deprecated.")
    fun setOverrideCertificateErrors(input: SetOverrideCertificateErrorsRequest) = connection.request("Security.setOverrideCertificateErrors", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  There is a certificate error. If overriding certificate errors is enabled, then it should be
handled with the `handleCertificateError` command. Note: this event does not fire if the
certificate error has been allowed internally. Only one client per target should override
certificate errors at the same time.
     */
    fun certificateError(): io.reactivex.Flowable<CertificateErrorEvent> = connection.events("Security.certificateError", CertificateErrorEvent::class.java)

    /**
     *  The security state of the page changed.
     */
    fun securityStateChanged(): io.reactivex.Flowable<SecurityStateChangedEvent> = connection.events("Security.securityStateChanged", SecurityStateChangedEvent::class.java)

    /**
     * Returns flowable capturing all Security domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Security"
        }
    }
}

/**
 * Represents request frame that can be used with [Security#setIgnoreCertificateErrors](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-setIgnoreCertificateErrors) operation call.
 *
 * Enable/disable whether all certificate errors should be ignored.
 * @link [Security#setIgnoreCertificateErrors](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-setIgnoreCertificateErrors) method documentation.
 * @see [SecurityOperations.setIgnoreCertificateErrors]
 */
data class SetIgnoreCertificateErrorsRequest(
    /**
     * If true, all certificate errors will be ignored.
     */
    val ignore: Boolean

)

/**
 * Represents request frame that can be used with [Security#handleCertificateError](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-handleCertificateError) operation call.
 *
 * Handles a certificate error that fired a certificateError event.
 * @link [Security#handleCertificateError](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-handleCertificateError) method documentation.
 * @see [SecurityOperations.handleCertificateError]
 */
data class HandleCertificateErrorRequest(
    /**
     * The ID of the event.
     */
    val eventId: Int,

    /**
     * The action to take on the certificate error.
     */
    val action: CertificateErrorAction

)

/**
 * Represents request frame that can be used with [Security#setOverrideCertificateErrors](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-setOverrideCertificateErrors) operation call.
 *
 * Enable/disable overriding certificate errors. If enabled, all certificate error events need to
be handled by the DevTools client and should be answered with `handleCertificateError` commands.
 * @link [Security#setOverrideCertificateErrors](https://chromedevtools.github.io/devtools-protocol/tot/Security#method-setOverrideCertificateErrors) method documentation.
 * @see [SecurityOperations.setOverrideCertificateErrors]
 */
data class SetOverrideCertificateErrorsRequest(
    /**
     * If true, certificate errors will be overridden.
     */
    val override: Boolean

)

/**
 * There is a certificate error. If overriding certificate errors is enabled, then it should be
handled with the `handleCertificateError` command. Note: this event does not fire if the
certificate error has been allowed internally. Only one client per target should override
certificate errors at the same time.
 *
 * @link [Security#certificateError](https://chromedevtools.github.io/devtools-protocol/tot/Security#event-certificateError) event documentation.
 */
data class CertificateErrorEvent(
    /**  
     * The ID of the event.  
     */  
    val eventId: Int,

    /**  
     * The type of the error.  
     */  
    val errorType: String,

    /**  
     * The url that was requested.  
     */  
    val requestURL: String

) : pl.wendigo.chrome.protocol.Event(domain = "Security", name = "certificateError")

/**
 * The security state of the page changed.
 *
 * @link [Security#securityStateChanged](https://chromedevtools.github.io/devtools-protocol/tot/Security#event-securityStateChanged) event documentation.
 */
data class SecurityStateChangedEvent(
    /**  
     * Security state.  
     */  
    val securityState: SecurityState,

    /**  
     * True if the page was loaded over cryptographic transport such as HTTPS.  
     */  
    val schemeIsCryptographic: Boolean,

    /**  
     * List of explanations for the security state. If the overall security state is `insecure` or  
     `warning`, at least one corresponding explanation should be included.  
     */  
    val explanations: List<SecurityStateExplanation>,

    /**  
     * Information about insecure content on the page.  
     */  
    val insecureContentStatus: InsecureContentStatus,

    /**  
     * Overrides user-visible description of the state.  
     */  
    val summary: String? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Security", name = "securityStateChanged")
