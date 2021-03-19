package pl.wendigo.chrome.api.page

/**
 * Unique frame identifier.
 *
 * @link [Page#FrameId](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-FrameId) type documentation.
 */

typealias FrameId = String

/**
 * Indicates whether a frame has been identified as an ad.
 *
 * @link [Page#AdFrameType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-AdFrameType) type documentation.
 */
enum class AdFrameType {
    @com.fasterxml.jackson.annotation.JsonProperty("none")
    NONE,

    @com.fasterxml.jackson.annotation.JsonProperty("child")
    CHILD,

    @com.fasterxml.jackson.annotation.JsonProperty("root")
    ROOT;
}

/**
 * Indicates whether the frame is a secure context and why it is the case.
 *
 * @link [Page#SecureContextType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-SecureContextType) type documentation.
 */
enum class SecureContextType {
    @com.fasterxml.jackson.annotation.JsonProperty("Secure")
    SECURE,

    @com.fasterxml.jackson.annotation.JsonProperty("SecureLocalhost")
    SECURELOCALHOST,

    @com.fasterxml.jackson.annotation.JsonProperty("InsecureScheme")
    INSECURESCHEME,

    @com.fasterxml.jackson.annotation.JsonProperty("InsecureAncestor")
    INSECUREANCESTOR;
}

/**
 * Indicates whether the frame is cross-origin isolated and why it is the case.
 *
 * @link [Page#CrossOriginIsolatedContextType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-CrossOriginIsolatedContextType) type documentation.
 */
enum class CrossOriginIsolatedContextType {
    @com.fasterxml.jackson.annotation.JsonProperty("Isolated")
    ISOLATED,

    @com.fasterxml.jackson.annotation.JsonProperty("NotIsolated")
    NOTISOLATED,

    @com.fasterxml.jackson.annotation.JsonProperty("NotIsolatedFeatureDisabled")
    NOTISOLATEDFEATUREDISABLED;
}

/**
 *
 *
 * @link [Page#GatedAPIFeatures](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-GatedAPIFeatures) type documentation.
 */
enum class GatedAPIFeatures {
    @com.fasterxml.jackson.annotation.JsonProperty("SharedArrayBuffers")
    SHAREDARRAYBUFFERS,

    @com.fasterxml.jackson.annotation.JsonProperty("SharedArrayBuffersTransferAllowed")
    SHAREDARRAYBUFFERSTRANSFERALLOWED,

    @com.fasterxml.jackson.annotation.JsonProperty("PerformanceMeasureMemory")
    PERFORMANCEMEASUREMEMORY,

    @com.fasterxml.jackson.annotation.JsonProperty("PerformanceProfile")
    PERFORMANCEPROFILE;
}

/**
 * All Permissions Policy features. This enum should match the one defined
in renderer/core/feature_policy/feature_policy_features.json5.
 *
 * @link [Page#PermissionsPolicyFeature](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyFeature) type documentation.
 */
enum class PermissionsPolicyFeature {
    @com.fasterxml.jackson.annotation.JsonProperty("accelerometer")
    ACCELEROMETER,

    @com.fasterxml.jackson.annotation.JsonProperty("ambient-light-sensor")
    AMBIENT_LIGHT_SENSOR,

    @com.fasterxml.jackson.annotation.JsonProperty("autoplay")
    AUTOPLAY,

    @com.fasterxml.jackson.annotation.JsonProperty("camera")
    CAMERA,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-dpr")
    CH_DPR,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-device-memory")
    CH_DEVICE_MEMORY,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-downlink")
    CH_DOWNLINK,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ect")
    CH_ECT,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-lang")
    CH_LANG,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-rtt")
    CH_RTT,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua")
    CH_UA,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua-arch")
    CH_UA_ARCH,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua-platform")
    CH_UA_PLATFORM,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua-model")
    CH_UA_MODEL,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua-mobile")
    CH_UA_MOBILE,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua-full-version")
    CH_UA_FULL_VERSION,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-ua-platform-version")
    CH_UA_PLATFORM_VERSION,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-viewport-width")
    CH_VIEWPORT_WIDTH,

    @com.fasterxml.jackson.annotation.JsonProperty("ch-width")
    CH_WIDTH,

    @com.fasterxml.jackson.annotation.JsonProperty("clipboard-read")
    CLIPBOARD_READ,

    @com.fasterxml.jackson.annotation.JsonProperty("clipboard-write")
    CLIPBOARD_WRITE,

    @com.fasterxml.jackson.annotation.JsonProperty("conversion-measurement")
    CONVERSION_MEASUREMENT,

    @com.fasterxml.jackson.annotation.JsonProperty("cross-origin-isolated")
    CROSS_ORIGIN_ISOLATED,

    @com.fasterxml.jackson.annotation.JsonProperty("display-capture")
    DISPLAY_CAPTURE,

    @com.fasterxml.jackson.annotation.JsonProperty("document-domain")
    DOCUMENT_DOMAIN,

    @com.fasterxml.jackson.annotation.JsonProperty("encrypted-media")
    ENCRYPTED_MEDIA,

    @com.fasterxml.jackson.annotation.JsonProperty("execution-while-out-of-viewport")
    EXECUTION_WHILE_OUT_OF_VIEWPORT,

    @com.fasterxml.jackson.annotation.JsonProperty("execution-while-not-rendered")
    EXECUTION_WHILE_NOT_RENDERED,

    @com.fasterxml.jackson.annotation.JsonProperty("focus-without-user-activation")
    FOCUS_WITHOUT_USER_ACTIVATION,

    @com.fasterxml.jackson.annotation.JsonProperty("fullscreen")
    FULLSCREEN,

    @com.fasterxml.jackson.annotation.JsonProperty("frobulate")
    FROBULATE,

    @com.fasterxml.jackson.annotation.JsonProperty("gamepad")
    GAMEPAD,

    @com.fasterxml.jackson.annotation.JsonProperty("geolocation")
    GEOLOCATION,

    @com.fasterxml.jackson.annotation.JsonProperty("gyroscope")
    GYROSCOPE,

    @com.fasterxml.jackson.annotation.JsonProperty("hid")
    HID,

    @com.fasterxml.jackson.annotation.JsonProperty("idle-detection")
    IDLE_DETECTION,

    @com.fasterxml.jackson.annotation.JsonProperty("interest-cohort")
    INTEREST_COHORT,

    @com.fasterxml.jackson.annotation.JsonProperty("magnetometer")
    MAGNETOMETER,

    @com.fasterxml.jackson.annotation.JsonProperty("microphone")
    MICROPHONE,

    @com.fasterxml.jackson.annotation.JsonProperty("midi")
    MIDI,

    @com.fasterxml.jackson.annotation.JsonProperty("otp-credentials")
    OTP_CREDENTIALS,

    @com.fasterxml.jackson.annotation.JsonProperty("payment")
    PAYMENT,

    @com.fasterxml.jackson.annotation.JsonProperty("picture-in-picture")
    PICTURE_IN_PICTURE,

    @com.fasterxml.jackson.annotation.JsonProperty("publickey-credentials-get")
    PUBLICKEY_CREDENTIALS_GET,

    @com.fasterxml.jackson.annotation.JsonProperty("screen-wake-lock")
    SCREEN_WAKE_LOCK,

    @com.fasterxml.jackson.annotation.JsonProperty("serial")
    SERIAL,

    @com.fasterxml.jackson.annotation.JsonProperty("storage-access-api")
    STORAGE_ACCESS_API,

    @com.fasterxml.jackson.annotation.JsonProperty("sync-xhr")
    SYNC_XHR,

    @com.fasterxml.jackson.annotation.JsonProperty("trust-token-redemption")
    TRUST_TOKEN_REDEMPTION,

    @com.fasterxml.jackson.annotation.JsonProperty("usb")
    USB,

    @com.fasterxml.jackson.annotation.JsonProperty("vertical-scroll")
    VERTICAL_SCROLL,

    @com.fasterxml.jackson.annotation.JsonProperty("web-share")
    WEB_SHARE,

    @com.fasterxml.jackson.annotation.JsonProperty("xr-spatial-tracking")
    XR_SPATIAL_TRACKING;
}

/**
 * Reason for a permissions policy feature to be disabled.
 *
 * @link [Page#PermissionsPolicyBlockReason](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyBlockReason) type documentation.
 */
enum class PermissionsPolicyBlockReason {
    @com.fasterxml.jackson.annotation.JsonProperty("Header")
    HEADER,

    @com.fasterxml.jackson.annotation.JsonProperty("IframeAttribute")
    IFRAMEATTRIBUTE;
}

/**
 *
 *
 * @link [Page#PermissionsPolicyBlockLocator](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyBlockLocator) type documentation.
 */

data class PermissionsPolicyBlockLocator(
    /**  
     *  
     */  
    val frameId: FrameId,

    /**  
     *  
     */  
    val blockReason: PermissionsPolicyBlockReason
)

/**
 *
 *
 * @link [Page#PermissionsPolicyFeatureState](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyFeatureState) type documentation.
 */

data class PermissionsPolicyFeatureState(
    /**  
     *  
     */  
    val feature: PermissionsPolicyFeature,

    /**  
     *  
     */  
    val allowed: Boolean,

    /**  
     *  
     */  
    val locator: PermissionsPolicyBlockLocator? = null
)

/**
 * Information about the Frame on the page.
 *
 * @link [Page#Frame](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-Frame) type documentation.
 */

data class Frame(
    /**  
     * Frame unique identifier.  
     */  
    val id: FrameId,

    /**  
     * Parent frame identifier.  
     */  
    val parentId: String? = null,

    /**  
     * Identifier of the loader associated with this frame.  
     */  
    val loaderId: pl.wendigo.chrome.api.network.LoaderId,

    /**  
     * Frame's name as specified in the tag.  
     */  
    val name: String? = null,

    /**  
     * Frame document's URL without fragment.  
     */  
    val url: String,

    /**  
     * Frame document's URL fragment including the '#'.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val urlFragment: String? = null,

    /**  
     * Frame document's registered domain, taking the public suffixes list into account.  
     Extracted from the Frame's url.  
     Example URLs: http://www.google.com/file.html -> "google.com"  
     http://a.b.co.uk/file.html      -> "b.co.uk"  
     */  
    @pl.wendigo.chrome.protocol.Experimental val domainAndRegistry: String,

    /**  
     * Frame document's security origin.  
     */  
    val securityOrigin: String,

    /**  
     * Frame document's mimeType as determined by the browser.  
     */  
    val mimeType: String,

    /**  
     * If the frame failed to load, this contains the URL that could not be loaded. Note that unlike url above, this URL may contain a fragment.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val unreachableUrl: String? = null,

    /**  
     * Indicates whether this frame was tagged as an ad.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val adFrameType: AdFrameType? = null,

    /**  
     * Indicates whether the main document is a secure context and explains why that is the case.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val secureContextType: SecureContextType,

    /**  
     * Indicates whether this is a cross origin isolated context.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val crossOriginIsolatedContextType: CrossOriginIsolatedContextType,

    /**  
     * Indicated which gated APIs / features are available.  
     */  
    @pl.wendigo.chrome.protocol.Experimental val gatedAPIFeatures: List<GatedAPIFeatures>
)

/**
 * Information about the Resource on the page.
 *
 * @link [Page#FrameResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-FrameResource) type documentation.
 */

data class FrameResource(
    /**  
     * Resource URL.  
     */  
    val url: String,

    /**  
     * Type of this resource.  
     */  
    val type: pl.wendigo.chrome.api.network.ResourceType,

    /**  
     * Resource mimeType as determined by the browser.  
     */  
    val mimeType: String,

    /**  
     * last-modified timestamp as reported by server.  
     */  
    val lastModified: pl.wendigo.chrome.api.network.TimeSinceEpoch? = null,

    /**  
     * Resource content size.  
     */  
    val contentSize: Double? = null,

    /**  
     * True if the resource failed to load.  
     */  
    val failed: Boolean? = null,

    /**  
     * True if the resource was canceled during loading.  
     */  
    val canceled: Boolean? = null
)

/**
 * Information about the Frame hierarchy along with their cached resources.
 *
 * @link [Page#FrameResourceTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-FrameResourceTree) type documentation.
 */

data class FrameResourceTree(
    /**  
     * Frame information for this tree item.  
     */  
    val frame: Frame,

    /**  
     * Child frames.  
     */  
    val childFrames: List<FrameResourceTree>? = null,

    /**  
     * Information about frame resources.  
     */  
    val resources: List<FrameResource>
)

/**
 * Information about the Frame hierarchy.
 *
 * @link [Page#FrameTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-FrameTree) type documentation.
 */

data class FrameTree(
    /**  
     * Frame information for this tree item.  
     */  
    val frame: Frame,

    /**  
     * Child frames.  
     */  
    val childFrames: List<FrameTree>? = null
)

/**
 * Unique script identifier.
 *
 * @link [Page#ScriptIdentifier](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-ScriptIdentifier) type documentation.
 */

typealias ScriptIdentifier = String

/**
 * Transition type.
 *
 * @link [Page#TransitionType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-TransitionType) type documentation.
 */
enum class TransitionType {
    @com.fasterxml.jackson.annotation.JsonProperty("link")
    LINK,

    @com.fasterxml.jackson.annotation.JsonProperty("typed")
    TYPED,

    @com.fasterxml.jackson.annotation.JsonProperty("address_bar")
    ADDRESS_BAR,

    @com.fasterxml.jackson.annotation.JsonProperty("auto_bookmark")
    AUTO_BOOKMARK,

    @com.fasterxml.jackson.annotation.JsonProperty("auto_subframe")
    AUTO_SUBFRAME,

    @com.fasterxml.jackson.annotation.JsonProperty("manual_subframe")
    MANUAL_SUBFRAME,

    @com.fasterxml.jackson.annotation.JsonProperty("generated")
    GENERATED,

    @com.fasterxml.jackson.annotation.JsonProperty("auto_toplevel")
    AUTO_TOPLEVEL,

    @com.fasterxml.jackson.annotation.JsonProperty("form_submit")
    FORM_SUBMIT,

    @com.fasterxml.jackson.annotation.JsonProperty("reload")
    RELOAD,

    @com.fasterxml.jackson.annotation.JsonProperty("keyword")
    KEYWORD,

    @com.fasterxml.jackson.annotation.JsonProperty("keyword_generated")
    KEYWORD_GENERATED,

    @com.fasterxml.jackson.annotation.JsonProperty("other")
    OTHER;
}

/**
 * Navigation history entry.
 *
 * @link [Page#NavigationEntry](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-NavigationEntry) type documentation.
 */

data class NavigationEntry(
    /**  
     * Unique id of the navigation history entry.  
     */  
    val id: Int,

    /**  
     * URL of the navigation history entry.  
     */  
    val url: String,

    /**  
     * URL that the user typed in the url bar.  
     */  
    val userTypedURL: String,

    /**  
     * Title of the navigation history entry.  
     */  
    val title: String,

    /**  
     * Transition type.  
     */  
    val transitionType: TransitionType
)

/**
 * Screencast frame metadata.
 *
 * @link [Page#ScreencastFrameMetadata](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-ScreencastFrameMetadata) type documentation.
 */

data class ScreencastFrameMetadata(
    /**  
     * Top offset in DIP.  
     */  
    val offsetTop: Double,

    /**  
     * Page scale factor.  
     */  
    val pageScaleFactor: Double,

    /**  
     * Device screen width in DIP.  
     */  
    val deviceWidth: Double,

    /**  
     * Device screen height in DIP.  
     */  
    val deviceHeight: Double,

    /**  
     * Position of horizontal scroll in CSS pixels.  
     */  
    val scrollOffsetX: Double,

    /**  
     * Position of vertical scroll in CSS pixels.  
     */  
    val scrollOffsetY: Double,

    /**  
     * Frame swap timestamp.  
     */  
    val timestamp: pl.wendigo.chrome.api.network.TimeSinceEpoch? = null
)

/**
 * Javascript dialog type.
 *
 * @link [Page#DialogType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-DialogType) type documentation.
 */
enum class DialogType {
    @com.fasterxml.jackson.annotation.JsonProperty("alert")
    ALERT,

    @com.fasterxml.jackson.annotation.JsonProperty("confirm")
    CONFIRM,

    @com.fasterxml.jackson.annotation.JsonProperty("prompt")
    PROMPT,

    @com.fasterxml.jackson.annotation.JsonProperty("beforeunload")
    BEFOREUNLOAD;
}

/**
 * Error while paring app manifest.
 *
 * @link [Page#AppManifestError](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-AppManifestError) type documentation.
 */

data class AppManifestError(
    /**  
     * Error message.  
     */  
    val message: String,

    /**  
     * If criticial, this is a non-recoverable parse error.  
     */  
    val critical: Int,

    /**  
     * Error line.  
     */  
    val line: Int,

    /**  
     * Error column.  
     */  
    val column: Int
)

/**
 * Parsed app manifest properties.
 *
 * @link [Page#AppManifestParsedProperties](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-AppManifestParsedProperties) type documentation.
 */

data class AppManifestParsedProperties(
    /**  
     * Computed scope value  
     */  
    val scope: String
)

/**
 * Layout viewport position and dimensions.
 *
 * @link [Page#LayoutViewport](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-LayoutViewport) type documentation.
 */

data class LayoutViewport(
    /**  
     * Horizontal offset relative to the document (CSS pixels).  
     */  
    val pageX: Int,

    /**  
     * Vertical offset relative to the document (CSS pixels).  
     */  
    val pageY: Int,

    /**  
     * Width (CSS pixels), excludes scrollbar if present.  
     */  
    val clientWidth: Int,

    /**  
     * Height (CSS pixels), excludes scrollbar if present.  
     */  
    val clientHeight: Int
)

/**
 * Visual viewport position, dimensions, and scale.
 *
 * @link [Page#VisualViewport](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-VisualViewport) type documentation.
 */

data class VisualViewport(
    /**  
     * Horizontal offset relative to the layout viewport (CSS pixels).  
     */  
    val offsetX: Double,

    /**  
     * Vertical offset relative to the layout viewport (CSS pixels).  
     */  
    val offsetY: Double,

    /**  
     * Horizontal offset relative to the document (CSS pixels).  
     */  
    val pageX: Double,

    /**  
     * Vertical offset relative to the document (CSS pixels).  
     */  
    val pageY: Double,

    /**  
     * Width (CSS pixels), excludes scrollbar if present.  
     */  
    val clientWidth: Double,

    /**  
     * Height (CSS pixels), excludes scrollbar if present.  
     */  
    val clientHeight: Double,

    /**  
     * Scale relative to the ideal viewport (size at width=device-width).  
     */  
    val scale: Double,

    /**  
     * Page zoom factor (CSS to device independent pixels ratio).  
     */  
    val zoom: Double? = null
)

/**
 * Viewport for capturing screenshot.
 *
 * @link [Page#Viewport](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-Viewport) type documentation.
 */

data class Viewport(
    /**  
     * X offset in device independent pixels (dip).  
     */  
    val x: Double,

    /**  
     * Y offset in device independent pixels (dip).  
     */  
    val y: Double,

    /**  
     * Rectangle width in device independent pixels (dip).  
     */  
    val width: Double,

    /**  
     * Rectangle height in device independent pixels (dip).  
     */  
    val height: Double,

    /**  
     * Page scale factor.  
     */  
    val scale: Double
)

/**
 * Generic font families collection.
 *
 * @link [Page#FontFamilies](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-FontFamilies) type documentation.
 */

data class FontFamilies(
    /**  
     * The standard font-family.  
     */  
    val standard: String? = null,

    /**  
     * The fixed font-family.  
     */  
    val fixed: String? = null,

    /**  
     * The serif font-family.  
     */  
    val serif: String? = null,

    /**  
     * The sansSerif font-family.  
     */  
    val sansSerif: String? = null,

    /**  
     * The cursive font-family.  
     */  
    val cursive: String? = null,

    /**  
     * The fantasy font-family.  
     */  
    val fantasy: String? = null,

    /**  
     * The pictograph font-family.  
     */  
    val pictograph: String? = null
)

/**
 * Default font sizes.
 *
 * @link [Page#FontSizes](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-FontSizes) type documentation.
 */

data class FontSizes(
    /**  
     * Default standard font size.  
     */  
    val standard: Int? = null,

    /**  
     * Default fixed font size.  
     */  
    val fixed: Int? = null
)

/**
 *
 *
 * @link [Page#ClientNavigationReason](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-ClientNavigationReason) type documentation.
 */
enum class ClientNavigationReason {
    @com.fasterxml.jackson.annotation.JsonProperty("formSubmissionGet")
    FORMSUBMISSIONGET,

    @com.fasterxml.jackson.annotation.JsonProperty("formSubmissionPost")
    FORMSUBMISSIONPOST,

    @com.fasterxml.jackson.annotation.JsonProperty("httpHeaderRefresh")
    HTTPHEADERREFRESH,

    @com.fasterxml.jackson.annotation.JsonProperty("scriptInitiated")
    SCRIPTINITIATED,

    @com.fasterxml.jackson.annotation.JsonProperty("metaTagRefresh")
    METATAGREFRESH,

    @com.fasterxml.jackson.annotation.JsonProperty("pageBlockInterstitial")
    PAGEBLOCKINTERSTITIAL,

    @com.fasterxml.jackson.annotation.JsonProperty("reload")
    RELOAD,

    @com.fasterxml.jackson.annotation.JsonProperty("anchorClick")
    ANCHORCLICK;
}

/**
 *
 *
 * @link [Page#ClientNavigationDisposition](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-ClientNavigationDisposition) type documentation.
 */
enum class ClientNavigationDisposition {
    @com.fasterxml.jackson.annotation.JsonProperty("currentTab")
    CURRENTTAB,

    @com.fasterxml.jackson.annotation.JsonProperty("newTab")
    NEWTAB,

    @com.fasterxml.jackson.annotation.JsonProperty("newWindow")
    NEWWINDOW,

    @com.fasterxml.jackson.annotation.JsonProperty("download")
    DOWNLOAD;
}

/**
 *
 *
 * @link [Page#InstallabilityErrorArgument](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-InstallabilityErrorArgument) type documentation.
 */

data class InstallabilityErrorArgument(
    /**  
     * Argument name (e.g. name:'minimum-icon-size-in-pixels').  
     */  
    val name: String,

    /**  
     * Argument value (e.g. value:'64').  
     */  
    val value: String
)

/**
 * The installability error
 *
 * @link [Page#InstallabilityError](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-InstallabilityError) type documentation.
 */

data class InstallabilityError(
    /**  
     * The error id (e.g. 'manifest-missing-suitable-icon').  
     */  
    val errorId: String,

    /**  
     * The list of error arguments (e.g. {name:'minimum-icon-size-in-pixels', value:'64'}).  
     */  
    val errorArguments: List<InstallabilityErrorArgument>
)

/**
 * The referring-policy used for the navigation.
 *
 * @link [Page#ReferrerPolicy](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-ReferrerPolicy) type documentation.
 */
enum class ReferrerPolicy {
    @com.fasterxml.jackson.annotation.JsonProperty("noReferrer")
    NOREFERRER,

    @com.fasterxml.jackson.annotation.JsonProperty("noReferrerWhenDowngrade")
    NOREFERRERWHENDOWNGRADE,

    @com.fasterxml.jackson.annotation.JsonProperty("origin")
    ORIGIN,

    @com.fasterxml.jackson.annotation.JsonProperty("originWhenCrossOrigin")
    ORIGINWHENCROSSORIGIN,

    @com.fasterxml.jackson.annotation.JsonProperty("sameOrigin")
    SAMEORIGIN,

    @com.fasterxml.jackson.annotation.JsonProperty("strictOrigin")
    STRICTORIGIN,

    @com.fasterxml.jackson.annotation.JsonProperty("strictOriginWhenCrossOrigin")
    STRICTORIGINWHENCROSSORIGIN,

    @com.fasterxml.jackson.annotation.JsonProperty("unsafeUrl")
    UNSAFEURL;
}

/**
 * Per-script compilation cache parameters for `Page.produceCompilationCache`
 *
 * @link [Page#CompilationCacheParams](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-CompilationCacheParams) type documentation.
 */

data class CompilationCacheParams(
    /**  
     * The URL of the script to produce a compilation cache entry for.  
     */  
    val url: String,

    /**  
     * A hint to the backend whether eager compilation is recommended.  
     (the actual compilation mode used is upon backend discretion).  
     */  
    val eager: Boolean? = null
)
