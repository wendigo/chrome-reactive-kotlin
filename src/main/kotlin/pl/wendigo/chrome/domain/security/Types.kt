package pl.wendigo.chrome.domain.security

/**
 * An internal certificate ID value.
 */

typealias CertificateId = Int

/**
 * A description of mixed content (HTTP resources on HTTPS pages), as defined by https://www.w3.org/TR/mixed-content/#categories
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
    @com.fasterxml.jackson.annotation.JsonProperty("warning") WARNING,
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
  val securityState : SecurityState,

  /**
   * Short phrase describing the type of factor.
   */
  val summary : String,

  /**
   * Full text explanation of the factor.
   */
  val description : String,

  /**
   * True if the page has a certificate.
   */
  val hasCertificate : Boolean,

  /**
   * The type of mixed content described by the explanation.
   */
  val mixedContentType : MixedContentType
)

/**
 * Information about insecure content on the page.
 */

data class InsecureContentStatus(
  /**
   * True if the page was loaded over HTTPS and ran mixed (HTTP) content such as scripts.
   */
  val ranMixedContent : Boolean,

  /**
   * True if the page was loaded over HTTPS and displayed mixed (HTTP) content such as images.
   */
  val displayedMixedContent : Boolean,

  /**
   * True if the page was loaded over HTTPS and contained a form targeting an insecure url.
   */
  val containedMixedForm : Boolean,

  /**
   * True if the page was loaded over HTTPS without certificate errors, and ran content such as scripts that were loaded with certificate errors.
   */
  val ranContentWithCertErrors : Boolean,

  /**
   * True if the page was loaded over HTTPS without certificate errors, and displayed content such as images that were loaded with certificate errors.
   */
  val displayedContentWithCertErrors : Boolean,

  /**
   * Security state representing a page that ran insecure content.
   */
  val ranInsecureContentStyle : SecurityState,

  /**
   * Security state representing a page that displayed insecure content.
   */
  val displayedInsecureContentStyle : SecurityState
)

/**
 * The action to take when a certificate error occurs. continue will continue processing the request and cancel will cancel the request.
 */
enum class CertificateErrorAction {
    @com.fasterxml.jackson.annotation.JsonProperty("continue") CONTINUE,
    @com.fasterxml.jackson.annotation.JsonProperty("cancel") CANCEL;
}

