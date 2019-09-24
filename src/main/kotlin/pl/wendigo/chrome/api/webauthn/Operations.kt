package pl.wendigo.chrome.api.webauthn

/**
 * This domain allows configuring virtual authenticators to test the WebAuthn
API.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [WebAuthn](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class WebAuthnOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Enable the WebAuthn domain and start intercepting credential storage and
retrieval with a virtual authenticator.
     *
     * @link Protocol [WebAuthn#enable](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-enable) method documentation.
     */
    fun enable() = connection.runAndCaptureResponse("WebAuthn.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disable the WebAuthn domain.
     *
     * @link Protocol [WebAuthn#disable](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-disable) method documentation.
     */
    fun disable() = connection.runAndCaptureResponse("WebAuthn.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Creates and adds a virtual authenticator.
     *
     * @link Protocol [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) method documentation.
     */
    fun addVirtualAuthenticator(input: AddVirtualAuthenticatorRequest) = connection.runAndCaptureResponse("WebAuthn.addVirtualAuthenticator", input, AddVirtualAuthenticatorResponse::class.java)

    /**
     * Removes the given authenticator.
     *
     * @link Protocol [WebAuthn#removeVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeVirtualAuthenticator) method documentation.
     */
    fun removeVirtualAuthenticator(input: RemoveVirtualAuthenticatorRequest) = connection.runAndCaptureResponse("WebAuthn.removeVirtualAuthenticator", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Adds the credential to the specified authenticator.
     *
     * @link Protocol [WebAuthn#addCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addCredential) method documentation.
     */
    fun addCredential(input: AddCredentialRequest) = connection.runAndCaptureResponse("WebAuthn.addCredential", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
     *
     * @link Protocol [WebAuthn#getCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredential) method documentation.
     */
    fun getCredential(input: GetCredentialRequest) = connection.runAndCaptureResponse("WebAuthn.getCredential", input, GetCredentialResponse::class.java)

    /**
     * Returns all the credentials stored in the given virtual authenticator.
     *
     * @link Protocol [WebAuthn#getCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredentials) method documentation.
     */
    fun getCredentials(input: GetCredentialsRequest) = connection.runAndCaptureResponse("WebAuthn.getCredentials", input, GetCredentialsResponse::class.java)

    /**
     * Removes a credential from the authenticator.
     *
     * @link Protocol [WebAuthn#removeCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeCredential) method documentation.
     */
    fun removeCredential(input: RemoveCredentialRequest) = connection.runAndCaptureResponse("WebAuthn.removeCredential", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Clears all the credentials from the specified device.
     *
     * @link Protocol [WebAuthn#clearCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-clearCredentials) method documentation.
     */
    fun clearCredentials(input: ClearCredentialsRequest) = connection.runAndCaptureResponse("WebAuthn.clearCredentials", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Sets whether User Verification succeeds or fails for an authenticator.
The default is true.
     *
     * @link Protocol [WebAuthn#setUserVerified](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setUserVerified) method documentation.
     */
    fun setUserVerified(input: SetUserVerifiedRequest) = connection.runAndCaptureResponse("WebAuthn.setUserVerified", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns flowable capturing all WebAuthn domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "WebAuthn"
        }
    }
}

/**
 * Represents request frame that can be used with [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) operation call.
 *
 * Creates and adds a virtual authenticator.
 * @link [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) method documentation.
 * @see [WebAuthnOperations.addVirtualAuthenticator]
 */
data class AddVirtualAuthenticatorRequest(
    /**
     *
     */
    val options: VirtualAuthenticatorOptions

)
/**
 * Represents response frame that is returned from [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) operation call.
 * Creates and adds a virtual authenticator.
 *
  
 * @link [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) method documentation.
 * @see [WebAuthnOperations.addVirtualAuthenticator]
 */
data class AddVirtualAuthenticatorResponse(
    /**  
     *  
     */  
    val authenticatorId: AuthenticatorId

)

/**
 * Represents request frame that can be used with [WebAuthn#removeVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeVirtualAuthenticator) operation call.
 *
 * Removes the given authenticator.
 * @link [WebAuthn#removeVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeVirtualAuthenticator) method documentation.
 * @see [WebAuthnOperations.removeVirtualAuthenticator]
 */
data class RemoveVirtualAuthenticatorRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId

)

/**
 * Represents request frame that can be used with [WebAuthn#addCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addCredential) operation call.
 *
 * Adds the credential to the specified authenticator.
 * @link [WebAuthn#addCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addCredential) method documentation.
 * @see [WebAuthnOperations.addCredential]
 */
data class AddCredentialRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId,

    /**
     *
     */
    val credential: Credential

)

/**
 * Represents request frame that can be used with [WebAuthn#getCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredential) operation call.
 *
 * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
 * @link [WebAuthn#getCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredential) method documentation.
 * @see [WebAuthnOperations.getCredential]
 */
data class GetCredentialRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId,

    /**
     *
     */
    val credentialId: String

)
/**
 * Represents response frame that is returned from [WebAuthn#getCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredential) operation call.
 * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
 *
  
 * @link [WebAuthn#getCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredential) method documentation.
 * @see [WebAuthnOperations.getCredential]
 */
data class GetCredentialResponse(
    /**  
     *  
     */  
    val credential: Credential

)

/**
 * Represents request frame that can be used with [WebAuthn#getCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredentials) operation call.
 *
 * Returns all the credentials stored in the given virtual authenticator.
 * @link [WebAuthn#getCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredentials) method documentation.
 * @see [WebAuthnOperations.getCredentials]
 */
data class GetCredentialsRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId

)
/**
 * Represents response frame that is returned from [WebAuthn#getCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredentials) operation call.
 * Returns all the credentials stored in the given virtual authenticator.
 *
  
 * @link [WebAuthn#getCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredentials) method documentation.
 * @see [WebAuthnOperations.getCredentials]
 */
data class GetCredentialsResponse(
    /**  
     *  
     */  
    val credentials: List<Credential>

)

/**
 * Represents request frame that can be used with [WebAuthn#removeCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeCredential) operation call.
 *
 * Removes a credential from the authenticator.
 * @link [WebAuthn#removeCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeCredential) method documentation.
 * @see [WebAuthnOperations.removeCredential]
 */
data class RemoveCredentialRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId,

    /**
     *
     */
    val credentialId: String

)

/**
 * Represents request frame that can be used with [WebAuthn#clearCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-clearCredentials) operation call.
 *
 * Clears all the credentials from the specified device.
 * @link [WebAuthn#clearCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-clearCredentials) method documentation.
 * @see [WebAuthnOperations.clearCredentials]
 */
data class ClearCredentialsRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId

)

/**
 * Represents request frame that can be used with [WebAuthn#setUserVerified](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setUserVerified) operation call.
 *
 * Sets whether User Verification succeeds or fails for an authenticator.
The default is true.
 * @link [WebAuthn#setUserVerified](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setUserVerified) method documentation.
 * @see [WebAuthnOperations.setUserVerified]
 */
data class SetUserVerifiedRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId,

    /**
     *
     */
    val isUserVerified: Boolean

)
