package pl.wendigo.chrome.domain.security

/**
 * An internal certificate ID value.
 */

typealias CertificateId = Int

/**
 * A description of mixed content (HTTP resources on HTTPS pages), as defined by
https://www.w3.org/TR/mixed-content/#categories
 */
enum class MixedContentType {
    @com.fasterxml.jackson.annotation.JsonProperty("blockable") BLOCKABLE,
    @com.fasterxml.jackson.annotation.JsonProperty("optionally-blockable") OPTIONALLY_BLOCKABLE,
    @com.fasterxml.jackson.annotation.JsonProperty("none") NONE;
}

/**
 * The security level of a page or resource.
 */
enum class SecurityState {
    @com.fasterxml.jackson.annotation.JsonProperty("unknown") UNKNOWN,
    @com.fasterxml.jackson.annotation.JsonProperty("neutral") NEUTRAL,
    @com.fasterxml.jackson.annotation.JsonProperty("insecure") INSECURE,
    @com.fasterxml.jackson.annotation.JsonProperty("secure") SECURE,
    @com.fasterxml.jackson.annotation.JsonProperty("info") INFO;
}

/**
 * An explanation of an factor contributing to the security state.
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
 */
enum class CertificateErrorAction {
    @com.fasterxml.jackson.annotation.JsonProperty("continue") CONTINUE,
    @com.fasterxml.jackson.annotation.JsonProperty("cancel") CANCEL;
}
