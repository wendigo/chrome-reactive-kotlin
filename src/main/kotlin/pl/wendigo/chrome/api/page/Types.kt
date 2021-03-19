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
@kotlinx.serialization.Serializable
enum class AdFrameType {
    @kotlinx.serialization.SerialName("none")
    NONE,

    @kotlinx.serialization.SerialName("child")
    CHILD,

    @kotlinx.serialization.SerialName("root")
    ROOT;
}

/**
 * Indicates whether the frame is a secure context and why it is the case.
 *
 * @link [Page#SecureContextType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-SecureContextType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class SecureContextType {
    @kotlinx.serialization.SerialName("Secure")
    SECURE,

    @kotlinx.serialization.SerialName("SecureLocalhost")
    SECURELOCALHOST,

    @kotlinx.serialization.SerialName("InsecureScheme")
    INSECURESCHEME,

    @kotlinx.serialization.SerialName("InsecureAncestor")
    INSECUREANCESTOR;
}

/**
 * Indicates whether the frame is cross-origin isolated and why it is the case.
 *
 * @link [Page#CrossOriginIsolatedContextType](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-CrossOriginIsolatedContextType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class CrossOriginIsolatedContextType {
    @kotlinx.serialization.SerialName("Isolated")
    ISOLATED,

    @kotlinx.serialization.SerialName("NotIsolated")
    NOTISOLATED,

    @kotlinx.serialization.SerialName("NotIsolatedFeatureDisabled")
    NOTISOLATEDFEATUREDISABLED;
}

/**
 *
 *
 * @link [Page#GatedAPIFeatures](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-GatedAPIFeatures) type documentation.
 */
@kotlinx.serialization.Serializable
enum class GatedAPIFeatures {
    @kotlinx.serialization.SerialName("SharedArrayBuffers")
    SHAREDARRAYBUFFERS,

    @kotlinx.serialization.SerialName("SharedArrayBuffersTransferAllowed")
    SHAREDARRAYBUFFERSTRANSFERALLOWED,

    @kotlinx.serialization.SerialName("PerformanceMeasureMemory")
    PERFORMANCEMEASUREMEMORY,

    @kotlinx.serialization.SerialName("PerformanceProfile")
    PERFORMANCEPROFILE;
}

/**
 * All Permissions Policy features. This enum should match the one defined
in renderer/core/feature_policy/feature_policy_features.json5.
 *
 * @link [Page#PermissionsPolicyFeature](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyFeature) type documentation.
 */
@kotlinx.serialization.Serializable
enum class PermissionsPolicyFeature {
    @kotlinx.serialization.SerialName("accelerometer")
    ACCELEROMETER,

    @kotlinx.serialization.SerialName("ambient-light-sensor")
    AMBIENT_LIGHT_SENSOR,

    @kotlinx.serialization.SerialName("autoplay")
    AUTOPLAY,

    @kotlinx.serialization.SerialName("camera")
    CAMERA,

    @kotlinx.serialization.SerialName("ch-dpr")
    CH_DPR,

    @kotlinx.serialization.SerialName("ch-device-memory")
    CH_DEVICE_MEMORY,

    @kotlinx.serialization.SerialName("ch-downlink")
    CH_DOWNLINK,

    @kotlinx.serialization.SerialName("ch-ect")
    CH_ECT,

    @kotlinx.serialization.SerialName("ch-lang")
    CH_LANG,

    @kotlinx.serialization.SerialName("ch-rtt")
    CH_RTT,

    @kotlinx.serialization.SerialName("ch-ua")
    CH_UA,

    @kotlinx.serialization.SerialName("ch-ua-arch")
    CH_UA_ARCH,

    @kotlinx.serialization.SerialName("ch-ua-platform")
    CH_UA_PLATFORM,

    @kotlinx.serialization.SerialName("ch-ua-model")
    CH_UA_MODEL,

    @kotlinx.serialization.SerialName("ch-ua-mobile")
    CH_UA_MOBILE,

    @kotlinx.serialization.SerialName("ch-ua-full-version")
    CH_UA_FULL_VERSION,

    @kotlinx.serialization.SerialName("ch-ua-platform-version")
    CH_UA_PLATFORM_VERSION,

    @kotlinx.serialization.SerialName("ch-viewport-width")
    CH_VIEWPORT_WIDTH,

    @kotlinx.serialization.SerialName("ch-width")
    CH_WIDTH,

    @kotlinx.serialization.SerialName("clipboard-read")
    CLIPBOARD_READ,

    @kotlinx.serialization.SerialName("clipboard-write")
    CLIPBOARD_WRITE,

    @kotlinx.serialization.SerialName("conversion-measurement")
    CONVERSION_MEASUREMENT,

    @kotlinx.serialization.SerialName("cross-origin-isolated")
    CROSS_ORIGIN_ISOLATED,

    @kotlinx.serialization.SerialName("display-capture")
    DISPLAY_CAPTURE,

    @kotlinx.serialization.SerialName("document-domain")
    DOCUMENT_DOMAIN,

    @kotlinx.serialization.SerialName("encrypted-media")
    ENCRYPTED_MEDIA,

    @kotlinx.serialization.SerialName("execution-while-out-of-viewport")
    EXECUTION_WHILE_OUT_OF_VIEWPORT,

    @kotlinx.serialization.SerialName("execution-while-not-rendered")
    EXECUTION_WHILE_NOT_RENDERED,

    @kotlinx.serialization.SerialName("focus-without-user-activation")
    FOCUS_WITHOUT_USER_ACTIVATION,

    @kotlinx.serialization.SerialName("fullscreen")
    FULLSCREEN,

    @kotlinx.serialization.SerialName("frobulate")
    FROBULATE,

    @kotlinx.serialization.SerialName("gamepad")
    GAMEPAD,

    @kotlinx.serialization.SerialName("geolocation")
    GEOLOCATION,

    @kotlinx.serialization.SerialName("gyroscope")
    GYROSCOPE,

    @kotlinx.serialization.SerialName("hid")
    HID,

    @kotlinx.serialization.SerialName("idle-detection")
    IDLE_DETECTION,

    @kotlinx.serialization.SerialName("interest-cohort")
    INTEREST_COHORT,

    @kotlinx.serialization.SerialName("magnetometer")
    MAGNETOMETER,

    @kotlinx.serialization.SerialName("microphone")
    MICROPHONE,

    @kotlinx.serialization.SerialName("midi")
    MIDI,

    @kotlinx.serialization.SerialName("otp-credentials")
    OTP_CREDENTIALS,

    @kotlinx.serialization.SerialName("payment")
    PAYMENT,

    @kotlinx.serialization.SerialName("picture-in-picture")
    PICTURE_IN_PICTURE,

    @kotlinx.serialization.SerialName("publickey-credentials-get")
    PUBLICKEY_CREDENTIALS_GET,

    @kotlinx.serialization.SerialName("screen-wake-lock")
    SCREEN_WAKE_LOCK,

    @kotlinx.serialization.SerialName("serial")
    SERIAL,

    @kotlinx.serialization.SerialName("storage-access-api")
    STORAGE_ACCESS_API,

    @kotlinx.serialization.SerialName("sync-xhr")
    SYNC_XHR,

    @kotlinx.serialization.SerialName("trust-token-redemption")
    TRUST_TOKEN_REDEMPTION,

    @kotlinx.serialization.SerialName("usb")
    USB,

    @kotlinx.serialization.SerialName("vertical-scroll")
    VERTICAL_SCROLL,

    @kotlinx.serialization.SerialName("web-share")
    WEB_SHARE,

    @kotlinx.serialization.SerialName("xr-spatial-tracking")
    XR_SPATIAL_TRACKING;
}

/**
 * Reason for a permissions policy feature to be disabled.
 *
 * @link [Page#PermissionsPolicyBlockReason](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyBlockReason) type documentation.
 */
@kotlinx.serialization.Serializable
enum class PermissionsPolicyBlockReason {
    @kotlinx.serialization.SerialName("Header")
    HEADER,

    @kotlinx.serialization.SerialName("IframeAttribute")
    IFRAMEATTRIBUTE;
}

/**
 *
 *
 * @link [Page#PermissionsPolicyBlockLocator](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-PermissionsPolicyBlockLocator) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class TransitionType {
    @kotlinx.serialization.SerialName("link")
    LINK,

    @kotlinx.serialization.SerialName("typed")
    TYPED,

    @kotlinx.serialization.SerialName("address_bar")
    ADDRESS_BAR,

    @kotlinx.serialization.SerialName("auto_bookmark")
    AUTO_BOOKMARK,

    @kotlinx.serialization.SerialName("auto_subframe")
    AUTO_SUBFRAME,

    @kotlinx.serialization.SerialName("manual_subframe")
    MANUAL_SUBFRAME,

    @kotlinx.serialization.SerialName("generated")
    GENERATED,

    @kotlinx.serialization.SerialName("auto_toplevel")
    AUTO_TOPLEVEL,

    @kotlinx.serialization.SerialName("form_submit")
    FORM_SUBMIT,

    @kotlinx.serialization.SerialName("reload")
    RELOAD,

    @kotlinx.serialization.SerialName("keyword")
    KEYWORD,

    @kotlinx.serialization.SerialName("keyword_generated")
    KEYWORD_GENERATED,

    @kotlinx.serialization.SerialName("other")
    OTHER;
}

/**
 * Navigation history entry.
 *
 * @link [Page#NavigationEntry](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-NavigationEntry) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class DialogType {
    @kotlinx.serialization.SerialName("alert")
    ALERT,

    @kotlinx.serialization.SerialName("confirm")
    CONFIRM,

    @kotlinx.serialization.SerialName("prompt")
    PROMPT,

    @kotlinx.serialization.SerialName("beforeunload")
    BEFOREUNLOAD;
}

/**
 * Error while paring app manifest.
 *
 * @link [Page#AppManifestError](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-AppManifestError) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class ClientNavigationReason {
    @kotlinx.serialization.SerialName("formSubmissionGet")
    FORMSUBMISSIONGET,

    @kotlinx.serialization.SerialName("formSubmissionPost")
    FORMSUBMISSIONPOST,

    @kotlinx.serialization.SerialName("httpHeaderRefresh")
    HTTPHEADERREFRESH,

    @kotlinx.serialization.SerialName("scriptInitiated")
    SCRIPTINITIATED,

    @kotlinx.serialization.SerialName("metaTagRefresh")
    METATAGREFRESH,

    @kotlinx.serialization.SerialName("pageBlockInterstitial")
    PAGEBLOCKINTERSTITIAL,

    @kotlinx.serialization.SerialName("reload")
    RELOAD,

    @kotlinx.serialization.SerialName("anchorClick")
    ANCHORCLICK;
}

/**
 *
 *
 * @link [Page#ClientNavigationDisposition](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-ClientNavigationDisposition) type documentation.
 */
@kotlinx.serialization.Serializable
enum class ClientNavigationDisposition {
    @kotlinx.serialization.SerialName("currentTab")
    CURRENTTAB,

    @kotlinx.serialization.SerialName("newTab")
    NEWTAB,

    @kotlinx.serialization.SerialName("newWindow")
    NEWWINDOW,

    @kotlinx.serialization.SerialName("download")
    DOWNLOAD;
}

/**
 *
 *
 * @link [Page#InstallabilityErrorArgument](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-InstallabilityErrorArgument) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class ReferrerPolicy {
    @kotlinx.serialization.SerialName("noReferrer")
    NOREFERRER,

    @kotlinx.serialization.SerialName("noReferrerWhenDowngrade")
    NOREFERRERWHENDOWNGRADE,

    @kotlinx.serialization.SerialName("origin")
    ORIGIN,

    @kotlinx.serialization.SerialName("originWhenCrossOrigin")
    ORIGINWHENCROSSORIGIN,

    @kotlinx.serialization.SerialName("sameOrigin")
    SAMEORIGIN,

    @kotlinx.serialization.SerialName("strictOrigin")
    STRICTORIGIN,

    @kotlinx.serialization.SerialName("strictOriginWhenCrossOrigin")
    STRICTORIGINWHENCROSSORIGIN,

    @kotlinx.serialization.SerialName("unsafeUrl")
    UNSAFEURL;
}

/**
 * Per-script compilation cache parameters for `Page.produceCompilationCache`
 *
 * @link [Page#CompilationCacheParams](https://chromedevtools.github.io/devtools-protocol/tot/Page#type-CompilationCacheParams) type documentation.
 */

@kotlinx.serialization.Serializable
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
