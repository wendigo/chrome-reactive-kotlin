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
@kotlinx.serialization.Serializable
enum class AuthenticatorProtocol {
    @kotlinx.serialization.SerialName("u2f")
    U2F,

    @kotlinx.serialization.SerialName("ctap2")
    CTAP2;
}

/**
 *
 *
 * @link [WebAuthn#Ctap2Version](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-Ctap2Version) type documentation.
 */
@kotlinx.serialization.Serializable
enum class Ctap2Version {
    @kotlinx.serialization.SerialName("ctap2_0")
    CTAP2_0,

    @kotlinx.serialization.SerialName("ctap2_1")
    CTAP2_1;
}

/**
 *
 *
 * @link [WebAuthn#AuthenticatorTransport](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-AuthenticatorTransport) type documentation.
 */
@kotlinx.serialization.Serializable
enum class AuthenticatorTransport {
    @kotlinx.serialization.SerialName("usb")
    USB,

    @kotlinx.serialization.SerialName("nfc")
    NFC,

    @kotlinx.serialization.SerialName("ble")
    BLE,

    @kotlinx.serialization.SerialName("cable")
    CABLE,

    @kotlinx.serialization.SerialName("internal")
    INTERNAL;
}

/**
 *
 *
 * @link [WebAuthn#VirtualAuthenticatorOptions](https://chromedevtools.github.io/devtools-protocol/tot/WebAuthn#type-VirtualAuthenticatorOptions) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
     * The ECDSA P-256 private key in PKCS#8 format. (Encoded as a base64 string when passed over JSON)  
     */  
    val privateKey: String,

    /**  
     * An opaque byte sequence with a maximum size of 64 bytes mapping the  
     credential to a specific user. (Encoded as a base64 string when passed over JSON)  
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
     See https://w3c.github.io/webauthn/#sctn-large-blob-extension (Encoded as a base64 string when passed over JSON)  
     */  
    val largeBlob: String? = null
)
