package pl.wendigo.chrome.api.audits

/**
 * Information about a cookie that is affected by an inspector issue.
 *
 * @link [Audits#AffectedCookie](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-AffectedCookie) type documentation.
 */

@kotlinx.serialization.Serializable
data class AffectedCookie(
    /**  
     * The following three properties uniquely identify a cookie  
     */  
    val name: String,

    /**  
     *  
     */  
    val path: String,

    /**  
     *  
     */  
    val domain: String
)

/**
 * Information about a request that is affected by an inspector issue.
 *
 * @link [Audits#AffectedRequest](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-AffectedRequest) type documentation.
 */

@kotlinx.serialization.Serializable
data class AffectedRequest(
    /**  
     * The unique request id.  
     */  
    val requestId: pl.wendigo.chrome.api.network.RequestId,

    /**  
     *  
     */  
    val url: String? = null
)

/**
 * Information about the frame affected by an inspector issue.
 *
 * @link [Audits#AffectedFrame](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-AffectedFrame) type documentation.
 */

@kotlinx.serialization.Serializable
data class AffectedFrame(
    /**  
     *  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId
)

/**
 *
 *
 * @link [Audits#SameSiteCookieExclusionReason](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieExclusionReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SameSiteCookieExclusionReason {
    @kotlinx.serialization.SerialName("ExcludeSameSiteUnspecifiedTreatedAsLax")
    EXCLUDESAMESITEUNSPECIFIEDTREATEDASLAX,

    @kotlinx.serialization.SerialName("ExcludeSameSiteNoneInsecure")
    EXCLUDESAMESITENONEINSECURE,

    @kotlinx.serialization.SerialName("ExcludeSameSiteLax")
    EXCLUDESAMESITELAX,

    @kotlinx.serialization.SerialName("ExcludeSameSiteStrict")
    EXCLUDESAMESITESTRICT;
}

/**
 *
 *
 * @link [Audits#SameSiteCookieWarningReason](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieWarningReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SameSiteCookieWarningReason {
    @kotlinx.serialization.SerialName("WarnSameSiteUnspecifiedCrossSiteContext")
    WARNSAMESITEUNSPECIFIEDCROSSSITECONTEXT,

    @kotlinx.serialization.SerialName("WarnSameSiteNoneInsecure")
    WARNSAMESITENONEINSECURE,

    @kotlinx.serialization.SerialName("WarnSameSiteUnspecifiedLaxAllowUnsafe")
    WARNSAMESITEUNSPECIFIEDLAXALLOWUNSAFE,

    @kotlinx.serialization.SerialName("WarnSameSiteStrictLaxDowngradeStrict")
    WARNSAMESITESTRICTLAXDOWNGRADESTRICT,

    @kotlinx.serialization.SerialName("WarnSameSiteStrictCrossDowngradeStrict")
    WARNSAMESITESTRICTCROSSDOWNGRADESTRICT,

    @kotlinx.serialization.SerialName("WarnSameSiteStrictCrossDowngradeLax")
    WARNSAMESITESTRICTCROSSDOWNGRADELAX,

    @kotlinx.serialization.SerialName("WarnSameSiteLaxCrossDowngradeStrict")
    WARNSAMESITELAXCROSSDOWNGRADESTRICT,

    @kotlinx.serialization.SerialName("WarnSameSiteLaxCrossDowngradeLax")
    WARNSAMESITELAXCROSSDOWNGRADELAX;
}

/**
 *
 *
 * @link [Audits#SameSiteCookieOperation](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieOperation) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SameSiteCookieOperation {
    @kotlinx.serialization.SerialName("SetCookie")
    SETCOOKIE,

    @kotlinx.serialization.SerialName("ReadCookie")
    READCOOKIE;
}

/**
 * This information is currently necessary, as the front-end has a difficult
time finding a specific cookie. With this, we can convey specific error
information without the cookie.
 *
 * @link [Audits#SameSiteCookieIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class SameSiteCookieIssueDetails(
    /**  
     *  
     */  
    val cookie: AffectedCookie,

    /**  
     *  
     */  
    val cookieWarningReasons: List<SameSiteCookieWarningReason>,

    /**  
     *  
     */  
    val cookieExclusionReasons: List<SameSiteCookieExclusionReason>,

    /**  
     * Optionally identifies the site-for-cookies and the cookie url, which  
     may be used by the front-end as additional context.  
     */  
    val operation: SameSiteCookieOperation,

    /**  
     *  
     */  
    val siteForCookies: String? = null,

    /**  
     *  
     */  
    val cookieUrl: String? = null,

    /**  
     *  
     */  
    val request: AffectedRequest? = null
)

/**
 *
 *
 * @link [Audits#MixedContentResolutionStatus](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-MixedContentResolutionStatus) type documentation.
 */
@kotlinx.serialization.Serializable
enum class MixedContentResolutionStatus {
    @kotlinx.serialization.SerialName("MixedContentBlocked")
    MIXEDCONTENTBLOCKED,

    @kotlinx.serialization.SerialName("MixedContentAutomaticallyUpgraded")
    MIXEDCONTENTAUTOMATICALLYUPGRADED,

    @kotlinx.serialization.SerialName("MixedContentWarning")
    MIXEDCONTENTWARNING;
}

/**
 *
 *
 * @link [Audits#MixedContentResourceType](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-MixedContentResourceType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class MixedContentResourceType {
    @kotlinx.serialization.SerialName("Audio")
    AUDIO,

    @kotlinx.serialization.SerialName("Beacon")
    BEACON,

    @kotlinx.serialization.SerialName("CSPReport")
    CSPREPORT,

    @kotlinx.serialization.SerialName("Download")
    DOWNLOAD,

    @kotlinx.serialization.SerialName("EventSource")
    EVENTSOURCE,

    @kotlinx.serialization.SerialName("Favicon")
    FAVICON,

    @kotlinx.serialization.SerialName("Font")
    FONT,

    @kotlinx.serialization.SerialName("Form")
    FORM,

    @kotlinx.serialization.SerialName("Frame")
    FRAME,

    @kotlinx.serialization.SerialName("Image")
    IMAGE,

    @kotlinx.serialization.SerialName("Import")
    IMPORT,

    @kotlinx.serialization.SerialName("Manifest")
    MANIFEST,

    @kotlinx.serialization.SerialName("Ping")
    PING,

    @kotlinx.serialization.SerialName("PluginData")
    PLUGINDATA,

    @kotlinx.serialization.SerialName("PluginResource")
    PLUGINRESOURCE,

    @kotlinx.serialization.SerialName("Prefetch")
    PREFETCH,

    @kotlinx.serialization.SerialName("Resource")
    RESOURCE,

    @kotlinx.serialization.SerialName("Script")
    SCRIPT,

    @kotlinx.serialization.SerialName("ServiceWorker")
    SERVICEWORKER,

    @kotlinx.serialization.SerialName("SharedWorker")
    SHAREDWORKER,

    @kotlinx.serialization.SerialName("Stylesheet")
    STYLESHEET,

    @kotlinx.serialization.SerialName("Track")
    TRACK,

    @kotlinx.serialization.SerialName("Video")
    VIDEO,

    @kotlinx.serialization.SerialName("Worker")
    WORKER,

    @kotlinx.serialization.SerialName("XMLHttpRequest")
    XMLHTTPREQUEST,

    @kotlinx.serialization.SerialName("XSLT")
    XSLT;
}

/**
 *
 *
 * @link [Audits#MixedContentIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-MixedContentIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class MixedContentIssueDetails(
    /**  
     * The type of resource causing the mixed content issue (css, js, iframe,  
     form,...). Marked as optional because it is mapped to from  
     blink::mojom::RequestContextType, which will be replaced  
     by network::mojom::RequestDestination  
     */  
    val resourceType: MixedContentResourceType? = null,

    /**  
     * The way the mixed content issue is being resolved.  
     */  
    val resolutionStatus: MixedContentResolutionStatus,

    /**  
     * The unsafe http url causing the mixed content issue.  
     */  
    val insecureURL: String,

    /**  
     * The url responsible for the call to an unsafe url.  
     */  
    val mainResourceURL: String,

    /**  
     * The mixed content request.  
     Does not always exist (e.g. for unsafe form submission urls).  
     */  
    val request: AffectedRequest? = null,

    /**  
     * Optional because not every mixed content issue is necessarily linked to a frame.  
     */  
    val frame: AffectedFrame? = null
)

/**
 * Enum indicating the reason a response has been blocked. These reasons are
refinements of the net error BLOCKED_BY_RESPONSE.
 *
 * @link [Audits#BlockedByResponseReason](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-BlockedByResponseReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class BlockedByResponseReason {
    @kotlinx.serialization.SerialName("CoepFrameResourceNeedsCoepHeader")
    COEPFRAMERESOURCENEEDSCOEPHEADER,

    @kotlinx.serialization.SerialName("CoopSandboxedIFrameCannotNavigateToCoopPage")
    COOPSANDBOXEDIFRAMECANNOTNAVIGATETOCOOPPAGE,

    @kotlinx.serialization.SerialName("CorpNotSameOrigin")
    CORPNOTSAMEORIGIN,

    @kotlinx.serialization.SerialName("CorpNotSameOriginAfterDefaultedToSameOriginByCoep")
    CORPNOTSAMEORIGINAFTERDEFAULTEDTOSAMEORIGINBYCOEP,

    @kotlinx.serialization.SerialName("CorpNotSameSite")
    CORPNOTSAMESITE;
}

/**
 * Details for a request that has been blocked with the BLOCKED_BY_RESPONSE
code. Currently only used for COEP/COOP, but may be extended to include
some CSP errors in the future.
 *
 * @link [Audits#BlockedByResponseIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-BlockedByResponseIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class BlockedByResponseIssueDetails(
    /**  
     *  
     */  
    val request: AffectedRequest,

    /**  
     *  
     */  
    val parentFrame: AffectedFrame? = null,

    /**  
     *  
     */  
    val blockedFrame: AffectedFrame? = null,

    /**  
     *  
     */  
    val reason: BlockedByResponseReason
)

/**
 *
 *
 * @link [Audits#HeavyAdResolutionStatus](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-HeavyAdResolutionStatus) type documentation.
 */
@kotlinx.serialization.Serializable
enum class HeavyAdResolutionStatus {
    @kotlinx.serialization.SerialName("HeavyAdBlocked")
    HEAVYADBLOCKED,

    @kotlinx.serialization.SerialName("HeavyAdWarning")
    HEAVYADWARNING;
}

/**
 *
 *
 * @link [Audits#HeavyAdReason](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-HeavyAdReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class HeavyAdReason {
    @kotlinx.serialization.SerialName("NetworkTotalLimit")
    NETWORKTOTALLIMIT,

    @kotlinx.serialization.SerialName("CpuTotalLimit")
    CPUTOTALLIMIT,

    @kotlinx.serialization.SerialName("CpuPeakLimit")
    CPUPEAKLIMIT;
}

/**
 *
 *
 * @link [Audits#HeavyAdIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-HeavyAdIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class HeavyAdIssueDetails(
    /**  
     * The resolution status, either blocking the content or warning.  
     */  
    val resolution: HeavyAdResolutionStatus,

    /**  
     * The reason the ad was blocked, total network or cpu or peak cpu.  
     */  
    val reason: HeavyAdReason,

    /**  
     * The frame that was blocked.  
     */  
    val frame: AffectedFrame
)

/**
 *
 *
 * @link [Audits#ContentSecurityPolicyViolationType](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-ContentSecurityPolicyViolationType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ContentSecurityPolicyViolationType {
    @kotlinx.serialization.SerialName("kInlineViolation")
    KINLINEVIOLATION,

    @kotlinx.serialization.SerialName("kEvalViolation")
    KEVALVIOLATION,

    @kotlinx.serialization.SerialName("kURLViolation")
    KURLVIOLATION,

    @kotlinx.serialization.SerialName("kTrustedTypesSinkViolation")
    KTRUSTEDTYPESSINKVIOLATION,

    @kotlinx.serialization.SerialName("kTrustedTypesPolicyViolation")
    KTRUSTEDTYPESPOLICYVIOLATION;
}

/**
 *
 *
 * @link [Audits#SourceCodeLocation](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SourceCodeLocation) type documentation.
 */

@kotlinx.serialization.Serializable
data class SourceCodeLocation(
    /**  
     *  
     */  
    val scriptId: pl.wendigo.chrome.api.runtime.ScriptId? = null,

    /**  
     *  
     */  
    val url: String,

    /**  
     *  
     */  
    val lineNumber: Int,

    /**  
     *  
     */  
    val columnNumber: Int
)

/**
 *
 *
 * @link [Audits#ContentSecurityPolicyIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-ContentSecurityPolicyIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class ContentSecurityPolicyIssueDetails(
    /**  
     * The url not included in allowed sources.  
     */  
    val blockedURL: String? = null,

    /**  
     * Specific directive that is violated, causing the CSP issue.  
     */  
    val violatedDirective: String,

    /**  
     *  
     */  
    val isReportOnly: Boolean,

    /**  
     *  
     */  
    val contentSecurityPolicyViolationType: ContentSecurityPolicyViolationType,

    /**  
     *  
     */  
    val frameAncestor: AffectedFrame? = null,

    /**  
     *  
     */  
    val sourceCodeLocation: SourceCodeLocation? = null,

    /**  
     *  
     */  
    val violatingNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null
)

/**
 *
 *
 * @link [Audits#SharedArrayBufferIssueType](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SharedArrayBufferIssueType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SharedArrayBufferIssueType {
    @kotlinx.serialization.SerialName("TransferIssue")
    TRANSFERISSUE,

    @kotlinx.serialization.SerialName("CreationIssue")
    CREATIONISSUE;
}

/**
 * Details for a issue arising from an SAB being instantiated in, or
transfered to a context that is not cross-origin isolated.
 *
 * @link [Audits#SharedArrayBufferIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SharedArrayBufferIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class SharedArrayBufferIssueDetails(
    /**  
     *  
     */  
    val sourceCodeLocation: SourceCodeLocation,

    /**  
     *  
     */  
    val isWarning: Boolean,

    /**  
     *  
     */  
    val type: SharedArrayBufferIssueType
)

/**
 *
 *
 * @link [Audits#TwaQualityEnforcementViolationType](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-TwaQualityEnforcementViolationType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class TwaQualityEnforcementViolationType {
    @kotlinx.serialization.SerialName("kHttpError")
    KHTTPERROR,

    @kotlinx.serialization.SerialName("kUnavailableOffline")
    KUNAVAILABLEOFFLINE,

    @kotlinx.serialization.SerialName("kDigitalAssetLinks")
    KDIGITALASSETLINKS;
}

/**
 *
 *
 * @link [Audits#TrustedWebActivityIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-TrustedWebActivityIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class TrustedWebActivityIssueDetails(
    /**  
     * The url that triggers the violation.  
     */  
    val url: String,

    /**  
     *  
     */  
    val violationType: TwaQualityEnforcementViolationType,

    /**  
     *  
     */  
    val httpStatusCode: Int? = null,

    /**  
     * The package name of the Trusted Web Activity client app. This field is  
     only used when violation type is kDigitalAssetLinks.  
     */  
    val packageName: String? = null,

    /**  
     * The signature of the Trusted Web Activity client app. This field is only  
     used when violation type is kDigitalAssetLinks.  
     */  
    val signature: String? = null
)

/**
 *
 *
 * @link [Audits#LowTextContrastIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-LowTextContrastIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class LowTextContrastIssueDetails(
    /**  
     *  
     */  
    val violatingNodeId: pl.wendigo.chrome.api.dom.BackendNodeId,

    /**  
     *  
     */  
    val violatingNodeSelector: String,

    /**  
     *  
     */  
    val contrastRatio: Double,

    /**  
     *  
     */  
    val thresholdAA: Double,

    /**  
     *  
     */  
    val thresholdAAA: Double,

    /**  
     *  
     */  
    val fontSize: String,

    /**  
     *  
     */  
    val fontWeight: String
)

/**
 * Details for a CORS related issue, e.g. a warning or error related to
CORS RFC1918 enforcement.
 *
 * @link [Audits#CorsIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-CorsIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class CorsIssueDetails(
    /**  
     *  
     */  
    val corsErrorStatus: pl.wendigo.chrome.api.network.CorsErrorStatus,

    /**  
     *  
     */  
    val isWarning: Boolean,

    /**  
     *  
     */  
    val request: AffectedRequest,

    /**  
     *  
     */  
    val resourceIPAddressSpace: pl.wendigo.chrome.api.network.IPAddressSpace? = null,

    /**  
     *  
     */  
    val clientSecurityState: pl.wendigo.chrome.api.network.ClientSecurityState? = null
)

/**
 * A unique identifier for the type of issue. Each type may use one of the
optional fields in InspectorIssueDetails to convey more specific
information about the kind of issue.
 *
 * @link [Audits#InspectorIssueCode](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-InspectorIssueCode) type documentation.
 */
@kotlinx.serialization.Serializable
enum class InspectorIssueCode {
    @kotlinx.serialization.SerialName("SameSiteCookieIssue")
    SAMESITECOOKIEISSUE,

    @kotlinx.serialization.SerialName("MixedContentIssue")
    MIXEDCONTENTISSUE,

    @kotlinx.serialization.SerialName("BlockedByResponseIssue")
    BLOCKEDBYRESPONSEISSUE,

    @kotlinx.serialization.SerialName("HeavyAdIssue")
    HEAVYADISSUE,

    @kotlinx.serialization.SerialName("ContentSecurityPolicyIssue")
    CONTENTSECURITYPOLICYISSUE,

    @kotlinx.serialization.SerialName("SharedArrayBufferIssue")
    SHAREDARRAYBUFFERISSUE,

    @kotlinx.serialization.SerialName("TrustedWebActivityIssue")
    TRUSTEDWEBACTIVITYISSUE,

    @kotlinx.serialization.SerialName("LowTextContrastIssue")
    LOWTEXTCONTRASTISSUE,

    @kotlinx.serialization.SerialName("CorsIssue")
    CORSISSUE;
}

/**
 * This struct holds a list of optional fields with additional information
specific to the kind of issue. When adding a new issue code, please also
add a new optional field to this type.
 *
 * @link [Audits#InspectorIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-InspectorIssueDetails) type documentation.
 */

@kotlinx.serialization.Serializable
data class InspectorIssueDetails(
    /**  
     *  
     */  
    val sameSiteCookieIssueDetails: SameSiteCookieIssueDetails? = null,

    /**  
     *  
     */  
    val mixedContentIssueDetails: MixedContentIssueDetails? = null,

    /**  
     *  
     */  
    val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null,

    /**  
     *  
     */  
    val heavyAdIssueDetails: HeavyAdIssueDetails? = null,

    /**  
     *  
     */  
    val contentSecurityPolicyIssueDetails: ContentSecurityPolicyIssueDetails? = null,

    /**  
     *  
     */  
    val sharedArrayBufferIssueDetails: SharedArrayBufferIssueDetails? = null,

    /**  
     *  
     */  
    val twaQualityEnforcementDetails: TrustedWebActivityIssueDetails? = null,

    /**  
     *  
     */  
    val lowTextContrastIssueDetails: LowTextContrastIssueDetails? = null,

    /**  
     *  
     */  
    val corsIssueDetails: CorsIssueDetails? = null
)

/**
 * An inspector issue reported from the back-end.
 *
 * @link [Audits#InspectorIssue](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-InspectorIssue) type documentation.
 */

@kotlinx.serialization.Serializable
data class InspectorIssue(
    /**  
     *  
     */  
    val code: InspectorIssueCode,

    /**  
     *  
     */  
    val details: InspectorIssueDetails
)
