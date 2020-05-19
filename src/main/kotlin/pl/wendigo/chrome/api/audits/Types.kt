package pl.wendigo.chrome.api.audits

/**
 * Information about a cookie that is affected by an inspector issue.
 *
 * @link [Audits#AffectedCookie](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-AffectedCookie) type documentation.
 */

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
enum class SameSiteCookieExclusionReason {
    @com.fasterxml.jackson.annotation.JsonProperty("ExcludeSameSiteUnspecifiedTreatedAsLax")
    EXCLUDESAMESITEUNSPECIFIEDTREATEDASLAX,
    @com.fasterxml.jackson.annotation.JsonProperty("ExcludeSameSiteNoneInsecure")
    EXCLUDESAMESITENONEINSECURE;
}

/**
 *
 *
 * @link [Audits#SameSiteCookieWarningReason](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieWarningReason) type documentation.
 */
enum class SameSiteCookieWarningReason {
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteUnspecifiedCrossSiteContext")
    WARNSAMESITEUNSPECIFIEDCROSSSITECONTEXT,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteNoneInsecure")
    WARNSAMESITENONEINSECURE,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteUnspecifiedLaxAllowUnsafe")
    WARNSAMESITEUNSPECIFIEDLAXALLOWUNSAFE,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteStrictLaxDowngradeStrict")
    WARNSAMESITESTRICTLAXDOWNGRADESTRICT,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteStrictCrossDowngradeStrict")
    WARNSAMESITESTRICTCROSSDOWNGRADESTRICT,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteStrictCrossDowngradeLax")
    WARNSAMESITESTRICTCROSSDOWNGRADELAX,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteLaxCrossDowngradeStrict")
    WARNSAMESITELAXCROSSDOWNGRADESTRICT,
    @com.fasterxml.jackson.annotation.JsonProperty("WarnSameSiteLaxCrossDowngradeLax")
    WARNSAMESITELAXCROSSDOWNGRADELAX;
}

/**
 *
 *
 * @link [Audits#SameSiteCookieOperation](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieOperation) type documentation.
 */
enum class SameSiteCookieOperation {
    @com.fasterxml.jackson.annotation.JsonProperty("SetCookie")
    SETCOOKIE,
    @com.fasterxml.jackson.annotation.JsonProperty("ReadCookie")
    READCOOKIE;
}

/**
 * This information is currently necessary, as the front-end has a difficult
time finding a specific cookie. With this, we can convey specific error
information without the cookie.
 *
 * @link [Audits#SameSiteCookieIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-SameSiteCookieIssueDetails) type documentation.
 */

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
enum class MixedContentResolutionStatus {
    @com.fasterxml.jackson.annotation.JsonProperty("MixedContentBlocked")
    MIXEDCONTENTBLOCKED,
    @com.fasterxml.jackson.annotation.JsonProperty("MixedContentAutomaticallyUpgraded")
    MIXEDCONTENTAUTOMATICALLYUPGRADED,
    @com.fasterxml.jackson.annotation.JsonProperty("MixedContentWarning")
    MIXEDCONTENTWARNING;
}

/**
 *
 *
 * @link [Audits#MixedContentResourceType](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-MixedContentResourceType) type documentation.
 */
enum class MixedContentResourceType {
    @com.fasterxml.jackson.annotation.JsonProperty("Audio")
    AUDIO,
    @com.fasterxml.jackson.annotation.JsonProperty("Beacon")
    BEACON,
    @com.fasterxml.jackson.annotation.JsonProperty("CSPReport")
    CSPREPORT,
    @com.fasterxml.jackson.annotation.JsonProperty("Download")
    DOWNLOAD,
    @com.fasterxml.jackson.annotation.JsonProperty("EventSource")
    EVENTSOURCE,
    @com.fasterxml.jackson.annotation.JsonProperty("Favicon")
    FAVICON,
    @com.fasterxml.jackson.annotation.JsonProperty("Font")
    FONT,
    @com.fasterxml.jackson.annotation.JsonProperty("Form")
    FORM,
    @com.fasterxml.jackson.annotation.JsonProperty("Frame")
    FRAME,
    @com.fasterxml.jackson.annotation.JsonProperty("Image")
    IMAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("Import")
    IMPORT,
    @com.fasterxml.jackson.annotation.JsonProperty("Manifest")
    MANIFEST,
    @com.fasterxml.jackson.annotation.JsonProperty("Ping")
    PING,
    @com.fasterxml.jackson.annotation.JsonProperty("PluginData")
    PLUGINDATA,
    @com.fasterxml.jackson.annotation.JsonProperty("PluginResource")
    PLUGINRESOURCE,
    @com.fasterxml.jackson.annotation.JsonProperty("Prefetch")
    PREFETCH,
    @com.fasterxml.jackson.annotation.JsonProperty("Resource")
    RESOURCE,
    @com.fasterxml.jackson.annotation.JsonProperty("Script")
    SCRIPT,
    @com.fasterxml.jackson.annotation.JsonProperty("ServiceWorker")
    SERVICEWORKER,
    @com.fasterxml.jackson.annotation.JsonProperty("SharedWorker")
    SHAREDWORKER,
    @com.fasterxml.jackson.annotation.JsonProperty("Stylesheet")
    STYLESHEET,
    @com.fasterxml.jackson.annotation.JsonProperty("Track")
    TRACK,
    @com.fasterxml.jackson.annotation.JsonProperty("Video")
    VIDEO,
    @com.fasterxml.jackson.annotation.JsonProperty("Worker")
    WORKER,
    @com.fasterxml.jackson.annotation.JsonProperty("XMLHttpRequest")
    XMLHTTPREQUEST,
    @com.fasterxml.jackson.annotation.JsonProperty("XSLT")
    XSLT;
}

/**
 *
 *
 * @link [Audits#MixedContentIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-MixedContentIssueDetails) type documentation.
 */

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
enum class BlockedByResponseReason {
    @com.fasterxml.jackson.annotation.JsonProperty("CoepFrameResourceNeedsCoepHeader")
    COEPFRAMERESOURCENEEDSCOEPHEADER,
    @com.fasterxml.jackson.annotation.JsonProperty("CoopSandboxedIFrameCannotNavigateToCoopPage")
    COOPSANDBOXEDIFRAMECANNOTNAVIGATETOCOOPPAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("CorpNotSameOrigin")
    CORPNOTSAMEORIGIN,
    @com.fasterxml.jackson.annotation.JsonProperty("CorpNotSameOriginAfterDefaultedToSameOriginByCoep")
    CORPNOTSAMEORIGINAFTERDEFAULTEDTOSAMEORIGINBYCOEP,
    @com.fasterxml.jackson.annotation.JsonProperty("CorpNotSameSite")
    CORPNOTSAMESITE;
}

/**
 * Details for a request that has been blocked with the BLOCKED_BY_RESPONSE
code. Currently only used for COEP/COOP, but may be extended to include
some CSP errors in the future.
 *
 * @link [Audits#BlockedByResponseIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-BlockedByResponseIssueDetails) type documentation.
 */

data class BlockedByResponseIssueDetails(
    /**  
     *  
     */  
    val request: AffectedRequest,

    /**  
     *  
     */  
    val frame: AffectedFrame? = null,

    /**  
     *  
     */  
    val reason: BlockedByResponseReason
)

/**
 * A unique identifier for the type of issue. Each type may use one of the
optional fields in InspectorIssueDetails to convey more specific
information about the kind of issue.
 *
 * @link [Audits#InspectorIssueCode](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-InspectorIssueCode) type documentation.
 */
enum class InspectorIssueCode {
    @com.fasterxml.jackson.annotation.JsonProperty("SameSiteCookieIssue")
    SAMESITECOOKIEISSUE,
    @com.fasterxml.jackson.annotation.JsonProperty("MixedContentIssue")
    MIXEDCONTENTISSUE,
    @com.fasterxml.jackson.annotation.JsonProperty("BlockedByResponseIssue")
    BLOCKEDBYRESPONSEISSUE;
}

/**
 * This struct holds a list of optional fields with additional information
specific to the kind of issue. When adding a new issue code, please also
add a new optional field to this type.
 *
 * @link [Audits#InspectorIssueDetails](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-InspectorIssueDetails) type documentation.
 */

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
    val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null
)

/**
 * An inspector issue reported from the back-end.
 *
 * @link [Audits#InspectorIssue](https://chromedevtools.github.io/devtools-protocol/tot/Audits#type-InspectorIssue) type documentation.
 */

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
