package pl.wendigo.chrome.api.webauthn

import kotlinx.serialization.json.Json

/**
 * This domain allows configuring virtual authenticators to test the WebAuthn
API.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [WebAuthn](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class WebAuthnDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain(
        "WebAuthn",
        """This domain allows configuring virtual authenticators to test the WebAuthn
API.""",
        connection
    ) {
    /**
     * Enable the WebAuthn domain and start intercepting credential storage and
retrieval with a virtual authenticator.
     *
     * @link Protocol [WebAuthn#enable](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Disable the WebAuthn domain.
     *
     * @link Protocol [WebAuthn#disable](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Creates and adds a virtual authenticator.
     *
     * @link Protocol [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) method documentation.
     */
    
    fun addVirtualAuthenticator(input: AddVirtualAuthenticatorRequest): io.reactivex.rxjava3.core.Single<AddVirtualAuthenticatorResponse> = connection.request("WebAuthn.addVirtualAuthenticator", Json.encodeToJsonElement(AddVirtualAuthenticatorRequest.serializer(), input), AddVirtualAuthenticatorResponse.serializer())

    /**
     * Removes the given authenticator.
     *
     * @link Protocol [WebAuthn#removeVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeVirtualAuthenticator) method documentation.
     */
    
    fun removeVirtualAuthenticator(input: RemoveVirtualAuthenticatorRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.removeVirtualAuthenticator", Json.encodeToJsonElement(RemoveVirtualAuthenticatorRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Adds the credential to the specified authenticator.
     *
     * @link Protocol [WebAuthn#addCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addCredential) method documentation.
     */
    
    fun addCredential(input: AddCredentialRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.addCredential", Json.encodeToJsonElement(AddCredentialRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Returns a single credential stored in the given virtual authenticator that
matches the credential ID.
     *
     * @link Protocol [WebAuthn#getCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredential) method documentation.
     */
    
    fun getCredential(input: GetCredentialRequest): io.reactivex.rxjava3.core.Single<GetCredentialResponse> = connection.request("WebAuthn.getCredential", Json.encodeToJsonElement(GetCredentialRequest.serializer(), input), GetCredentialResponse.serializer())

    /**
     * Returns all the credentials stored in the given virtual authenticator.
     *
     * @link Protocol [WebAuthn#getCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-getCredentials) method documentation.
     */
    
    fun getCredentials(input: GetCredentialsRequest): io.reactivex.rxjava3.core.Single<GetCredentialsResponse> = connection.request("WebAuthn.getCredentials", Json.encodeToJsonElement(GetCredentialsRequest.serializer(), input), GetCredentialsResponse.serializer())

    /**
     * Removes a credential from the authenticator.
     *
     * @link Protocol [WebAuthn#removeCredential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-removeCredential) method documentation.
     */
    
    fun removeCredential(input: RemoveCredentialRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.removeCredential", Json.encodeToJsonElement(RemoveCredentialRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Clears all the credentials from the specified device.
     *
     * @link Protocol [WebAuthn#clearCredentials](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-clearCredentials) method documentation.
     */
    
    fun clearCredentials(input: ClearCredentialsRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.clearCredentials", Json.encodeToJsonElement(ClearCredentialsRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Sets whether User Verification succeeds or fails for an authenticator.
The default is true.
     *
     * @link Protocol [WebAuthn#setUserVerified](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setUserVerified) method documentation.
     */
    
    fun setUserVerified(input: SetUserVerifiedRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.setUserVerified", Json.encodeToJsonElement(SetUserVerifiedRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator.
The default is true.
     *
     * @link Protocol [WebAuthn#setAutomaticPresenceSimulation](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setAutomaticPresenceSimulation) method documentation.
     */
    
    fun setAutomaticPresenceSimulation(input: SetAutomaticPresenceSimulationRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("WebAuthn.setAutomaticPresenceSimulation", Json.encodeToJsonElement(SetAutomaticPresenceSimulationRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())
}

/**
 * Represents request frame that can be used with [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) operation call.
 *
 * Creates and adds a virtual authenticator.
 * @link [WebAuthn#addVirtualAuthenticator](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-addVirtualAuthenticator) method documentation.
 * @see [WebAuthnDomain.addVirtualAuthenticator]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.addVirtualAuthenticator]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.removeVirtualAuthenticator]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.addCredential]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.getCredential]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.getCredential]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.getCredentials]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.getCredentials]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.removeCredential]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.clearCredentials]
 */
@kotlinx.serialization.Serializable
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
 * @see [WebAuthnDomain.setUserVerified]
 */
@kotlinx.serialization.Serializable
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

/**
 * Represents request frame that can be used with [WebAuthn#setAutomaticPresenceSimulation](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setAutomaticPresenceSimulation) operation call.
 *
 * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator.
The default is true.
 * @link [WebAuthn#setAutomaticPresenceSimulation](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#method-setAutomaticPresenceSimulation) method documentation.
 * @see [WebAuthnDomain.setAutomaticPresenceSimulation]
 */
@kotlinx.serialization.Serializable
data class SetAutomaticPresenceSimulationRequest(
    /**
     *
     */
    val authenticatorId: AuthenticatorId,

    /**
     *
     */
    val enabled: Boolean

)
