package pl.wendigo.chrome.api.webauthn

/**
 *
 *
 * @link [WebAuthn#AuthenticatorId](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-AuthenticatorId) type documentation.
 */

typealias AuthenticatorId = String

/**
 *
 *
 * @link [WebAuthn#AuthenticatorProtocol](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-AuthenticatorProtocol) type documentation.
 */
enum class AuthenticatorProtocol {
    @com.fasterxml.jackson.annotation.JsonProperty("u2f")
    U2F,
    @com.fasterxml.jackson.annotation.JsonProperty("ctap2")
    CTAP2;
}

/**
 *
 *
 * @link [WebAuthn#Ctap2Version](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-Ctap2Version) type documentation.
 */
enum class Ctap2Version {
    @com.fasterxml.jackson.annotation.JsonProperty("ctap2_0")
    CTAP2_0,
    @com.fasterxml.jackson.annotation.JsonProperty("ctap2_1")
    CTAP2_1;
}

/**
 *
 *
 * @link [WebAuthn#AuthenticatorTransport](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-AuthenticatorTransport) type documentation.
 */
enum class AuthenticatorTransport {
    @com.fasterxml.jackson.annotation.JsonProperty("usb")
    USB,
    @com.fasterxml.jackson.annotation.JsonProperty("nfc")
    NFC,
    @com.fasterxml.jackson.annotation.JsonProperty("ble")
    BLE,
    @com.fasterxml.jackson.annotation.JsonProperty("cable")
    CABLE,
    @com.fasterxml.jackson.annotation.JsonProperty("internal")
    INTERNAL;
}

/**
 *
 *
 * @link [WebAuthn#VirtualAuthenticatorOptions](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-VirtualAuthenticatorOptions) type documentation.
 */

data class VirtualAuthenticatorOptions(
    /**  
     *  
     */  
    val protocol: AuthenticatorProtocol,

    /**  
     * Defaults to ctap2_0. Ignored if |protocol| == u2f.  
     */  
    val ctap2Version: Ctap2Version? = null,

    /**  
     *  
     */  
    val transport: AuthenticatorTransport,

    /**  
     * Defaults to false.  
     */  
    val hasResidentKey: Boolean? = null,

    /**  
     * Defaults to false.  
     */  
    val hasUserVerification: Boolean? = null,

    /**  
     * If set to true, the authenticator will support the largeBlob extension.  
     https://w3c.github.io/webauthn#largeBlob  
     Defaults to false.  
     */  
    val hasLargeBlob: Boolean? = null,

    /**  
     * If set to true, tests of user presence will succeed immediately.  
     Otherwise, they will not be resolved. Defaults to true.  
     */  
    val automaticPresenceSimulation: Boolean? = null,

    /**  
     * Sets whether User Verification succeeds or fails for an authenticator.  
     Defaults to false.  
     */  
    val isUserVerified: Boolean? = null
)

/**
 *
 *
 * @link [WebAuthn#Credential](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-Credential) type documentation.
 */

data class Credential(
    /**  
     *  
     */  
    val credentialId: String,

    /**  
     *  
     */  
    val isResidentCredential: Boolean,

    /**  
     * Relying Party ID the credential is scoped to. Must be set when adding a  
     credential.  
     */  
    val rpId: String? = null,

    /**  
     * The ECDSA P-256 private key in PKCS#8 format.  
     */  
    val privateKey: String,

    /**  
     * An opaque byte sequence with a maximum size of 64 bytes mapping the  
     credential to a specific user.  
     */  
    val userHandle: String? = null,

    /**  
     * Signature counter. This is incremented by one for each successful  
     assertion.  
     See https://w3c.github.io/webauthn/#signature-counter  
     */  
    val signCount: Int,

    /**  
     * The large blob associated with the credential.  
     See https://w3c.github.io/webauthn/#sctn-large-blob-extension  
     */  
    val largeBlob: String? = null
)
