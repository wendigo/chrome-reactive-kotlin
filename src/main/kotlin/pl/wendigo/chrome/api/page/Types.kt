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
    @pl.wendigo.chrome.protocol.Experimental val adFrameType: AdFrameType? = null
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
