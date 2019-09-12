package pl.wendigo.chrome.domain.webauthn

/**
 * This domain allows configuring virtual authenticators to test the WebAuthn
API.
 */
class WebAuthnDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Enable the WebAuthn domain and start intercepting credential storage and
retrieval with a virtual authenticator.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disable the WebAuthn domain.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Creates and adds a virtual authenticator.
     */
    fun addVirtualAuthenticator(input: AddVirtualAuthenticatorRequest): io.reactivex.Single<AddVirtualAuthenticatorResponse> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.addVirtualAuthenticator", input, AddVirtualAuthenticatorResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Removes the given authenticator.
     */
    fun removeVirtualAuthenticator(input: RemoveVirtualAuthenticatorRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.removeVirtualAuthenticator", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Adds the credential to the specified authenticator.
     */
    fun addCredential(input: AddCredentialRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.addCredential", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
     */
    fun getCredential(input: GetCredentialRequest): io.reactivex.Single<GetCredentialResponse> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.getCredential", input, GetCredentialResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all the credentials stored in the given virtual authenticator.
     */
    fun getCredentials(input: GetCredentialsRequest): io.reactivex.Single<GetCredentialsResponse> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.getCredentials", input, GetCredentialsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Removes a credential from the authenticator.
     */
    fun removeCredential(input: RemoveCredentialRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.removeCredential", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears all the credentials from the specified device.
     */
    fun clearCredentials(input: ClearCredentialsRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.clearCredentials", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets whether User Verification succeeds or fails for an authenticator.
The default is true.
     */
    fun setUserVerified(input: SetUserVerifiedRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("WebAuthn.setUserVerified", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all WebAuthn domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "WebAuthn"
        }
    }
}

/**
 * Represents request frame that can be used with WebAuthn.addVirtualAuthenticator method call.
 *
 * Creates and adds a virtual authenticator.
 */
data class AddVirtualAuthenticatorRequest(
    /**
     *
     */
    val options: VirtualAuthenticatorOptions

)

/**
 * Represents response frame for WebAuthn.addVirtualAuthenticator method call.
 *
 * Creates and adds a virtual authenticator.
 */
data class AddVirtualAuthenticatorResponse(
    /**  
     *  
     */  
    val authenticatorId: AuthenticatorId

)

/**
 * Represents request frame that can be used with WebAuthn.removeVirtualAuthenticator method call.
 *
 * Removes the given authenticator.
 */
data class RemoveVirtualAuthenticatorRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId

)

/**
 * Represents request frame that can be used with WebAuthn.addCredential method call.
 *
 * Adds the credential to the specified authenticator.
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
 * Represents request frame that can be used with WebAuthn.getCredential method call.
 *
 * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
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
 * Represents response frame for WebAuthn.getCredential method call.
 *
 * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
 */
data class GetCredentialResponse(
    /**  
     *  
     */  
    val credential: Credential

)

/**
 * Represents request frame that can be used with WebAuthn.getCredentials method call.
 *
 * Returns all the credentials stored in the given virtual authenticator.
 */
data class GetCredentialsRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId

)

/**
 * Represents response frame for WebAuthn.getCredentials method call.
 *
 * Returns all the credentials stored in the given virtual authenticator.
 */
data class GetCredentialsResponse(
    /**  
     *  
     */  
    val credentials: List<Credential>

)

/**
 * Represents request frame that can be used with WebAuthn.removeCredential method call.
 *
 * Removes a credential from the authenticator.
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
 * Represents request frame that can be used with WebAuthn.clearCredentials method call.
 *
 * Clears all the credentials from the specified device.
 */
data class ClearCredentialsRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId

)

/**
 * Represents request frame that can be used with WebAuthn.setUserVerified method call.
 *
 * Sets whether User Verification succeeds or fails for an authenticator.
The default is true.
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
