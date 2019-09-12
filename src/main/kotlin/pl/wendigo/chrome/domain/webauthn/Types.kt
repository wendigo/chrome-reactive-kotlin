package pl.wendigo.chrome.domain.webauthn

/**
 *
 */

typealias AuthenticatorId = String

/**
 *
 */
enum class AuthenticatorProtocol {
    @com.fasterxml.jackson.annotation.JsonProperty("u2f")
    U2F,
    @com.fasterxml.jackson.annotation.JsonProperty("ctap2")
    CTAP2;
}

/**
 *
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
 */

data class VirtualAuthenticatorOptions(
    /**  
     *  
     */  
    val protocol: AuthenticatorProtocol,

    /**  
     *  
     */  
    val transport: AuthenticatorTransport,

    /**  
     *  
     */  
    val hasResidentKey: Boolean,

    /**  
     *  
     */  
    val hasUserVerification: Boolean,

    /**  
     * If set to true, tests of user presence will succeed immediately.  
     Otherwise, they will not be resolved. Defaults to true.  
     */  
    val automaticPresenceSimulation: Boolean? = null
)

/**
 *
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
    val signCount: Int
)
