package pl.wendigo.chrome.domain.security

/**
 * An internal certificate ID value.
 */
typealias CertificateId = Int

/**
 * The security level of a page or resource.
 */
typealias SecurityState = String

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
  val hasCertificate : Boolean
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

