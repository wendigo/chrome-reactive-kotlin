package pl.wendigo.chrome.api.security

/**
 * An internal certificate ID value.
 *
 * @link [Security#CertificateId](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-CertificateId) type documentation.
 */

typealias CertificateId = Int

/**
 * A description of mixed content (HTTP resources on HTTPS pages), as defined by
https://www.w3.org/TR/mixed-content/#categories
 *
 * @link [Security#MixedContentType](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-MixedContentType) type documentation.
 */
enum class MixedContentType {
    @com.fasterxml.jackson.annotation.JsonProperty("blockable")
    BLOCKABLE,
    @com.fasterxml.jackson.annotation.JsonProperty("optionally-blockable")
    OPTIONALLY_BLOCKABLE,
    @com.fasterxml.jackson.annotation.JsonProperty("none")
    NONE;
}

/**
 * The security level of a page or resource.
 *
 * @link [Security#SecurityState](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-SecurityState) type documentation.
 */
enum class SecurityState {
    @com.fasterxml.jackson.annotation.JsonProperty("unknown")
    UNKNOWN,
    @com.fasterxml.jackson.annotation.JsonProperty("neutral")
    NEUTRAL,
    @com.fasterxml.jackson.annotation.JsonProperty("insecure")
    INSECURE,
    @com.fasterxml.jackson.annotation.JsonProperty("secure")
    SECURE,
    @com.fasterxml.jackson.annotation.JsonProperty("info")
    INFO;
}

/**
 * Details about the security state of the page certificate.
 *
 * @link [Security#CertificateSecurityState](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-CertificateSecurityState) type documentation.
 */

data class CertificateSecurityState(
    /**  
     * Protocol name (e.g. "TLS 1.2" or "QUIC").  
     */  
    val protocol: String,

    /**  
     * Key Exchange used by the connection, or the empty string if not applicable.  
     */  
    val keyExchange: String,

    /**  
     * (EC)DH group used by the connection, if applicable.  
     */  
    val keyExchangeGroup: String? = null,

    /**  
     * Cipher name.  
     */  
    val cipher: String,

    /**  
     * TLS MAC. Note that AEAD ciphers do not have separate MACs.  
     */  
    val mac: String? = null,

    /**  
     * Page certificate.  
     */  
    val certificate: List<String>,

    /**  
     * Certificate subject name.  
     */  
    val subjectName: String,

    /**  
     * Name of the issuing CA.  
     */  
    val issuer: String,

    /**  
     * Certificate valid from date.  
     */  
    val validFrom: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     * Certificate valid to (expiration) date  
     */  
    val validTo: pl.wendigo.chrome.api.network.TimeSinceEpoch,

    /**  
     * True if the certificate uses a weak signature aglorithm.  
     */  
    val certifcateHasWeakSignature: Boolean,

    /**  
     * True if modern SSL  
     */  
    val modernSSL: Boolean,

    /**  
     * True if the connection is using an obsolete SSL protocol.  
     */  
    val obsoleteSslProtocol: Boolean,

    /**  
     * True if the connection is using an obsolete SSL key exchange.  
     */  
    val obsoleteSslKeyExchange: Boolean,

    /**  
     * True if the connection is using an obsolete SSL cipher.  
     */  
    val obsoleteSslCipher: Boolean,

    /**  
     * True if the connection is using an obsolete SSL signature.  
     */  
    val obsoleteSslSignature: Boolean
)

/**
 * Security state information about the page.
 *
 * @link [Security#VisibleSecurityState](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-VisibleSecurityState) type documentation.
 */

data class VisibleSecurityState(
    /**  
     * The security level of the page.  
     */  
    val securityState: SecurityState,

    /**  
     * Security state details about the page certificate.  
     */  
    val certificateSecurityState: CertificateSecurityState? = null,

    /**  
     * Array of security state issues ids.  
     */  
    val securityStateIssueIds: List<String>
)

/**
 * An explanation of an factor contributing to the security state.
 *
 * @link [Security#SecurityStateExplanation](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-SecurityStateExplanation) type documentation.
 */

data class SecurityStateExplanation(
    /**  
     * Security state representing the severity of the factor being explained.  
     */  
    val securityState: SecurityState,

    /**  
     * Title describing the type of factor.  
     */  
    val title: String,

    /**  
     * Short phrase describing the type of factor.  
     */  
    val summary: String,

    /**  
     * Full text explanation of the factor.  
     */  
    val description: String,

    /**  
     * The type of mixed content described by the explanation.  
     */  
    val mixedContentType: MixedContentType,

    /**  
     * Page certificate.  
     */  
    val certificate: List<String>,

    /**  
     * Recommendations to fix any issues.  
     */  
    val recommendations: List<String>? = null
)

/**
 * Information about insecure content on the page.
 *
 * @link [Security#InsecureContentStatus](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-InsecureContentStatus) type documentation.
 */

data class InsecureContentStatus(
    /**  
     * Always false.  
     */  
    val ranMixedContent: Boolean,

    /**  
     * Always false.  
     */  
    val displayedMixedContent: Boolean,

    /**  
     * Always false.  
     */  
    val containedMixedForm: Boolean,

    /**  
     * Always false.  
     */  
    val ranContentWithCertErrors: Boolean,

    /**  
     * Always false.  
     */  
    val displayedContentWithCertErrors: Boolean,

    /**  
     * Always set to unknown.  
     */  
    val ranInsecureContentStyle: SecurityState,

    /**  
     * Always set to unknown.  
     */  
    val displayedInsecureContentStyle: SecurityState
)

/**
 * The action to take when a certificate error occurs. continue will continue processing the
request and cancel will cancel the request.
 *
 * @link [Security#CertificateErrorAction](https://chromedevtools.github.io/devtools-protocol/tot/Security#type-CertificateErrorAction) type documentation.
 */
enum class CertificateErrorAction {
    @com.fasterxml.jackson.annotation.JsonProperty("continue")
    CONTINUE,
    @com.fasterxml.jackson.annotation.JsonProperty("cancel")
    CANCEL;
}
