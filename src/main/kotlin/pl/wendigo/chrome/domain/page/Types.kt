package pl.wendigo.chrome.domain.page

/**
 * Resource type as it was perceived by the rendering engine.
 */
enum class ResourceType {
    @com.fasterxml.jackson.annotation.JsonProperty("Document") DOCUMENT,
    @com.fasterxml.jackson.annotation.JsonProperty("Stylesheet") STYLESHEET,
    @com.fasterxml.jackson.annotation.JsonProperty("Image") IMAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("Media") MEDIA,
    @com.fasterxml.jackson.annotation.JsonProperty("Font") FONT,
    @com.fasterxml.jackson.annotation.JsonProperty("Script") SCRIPT,
    @com.fasterxml.jackson.annotation.JsonProperty("TextTrack") TEXTTRACK,
    @com.fasterxml.jackson.annotation.JsonProperty("XHR") XHR,
    @com.fasterxml.jackson.annotation.JsonProperty("Fetch") FETCH,
    @com.fasterxml.jackson.annotation.JsonProperty("EventSource") EVENTSOURCE,
    @com.fasterxml.jackson.annotation.JsonProperty("WebSocket") WEBSOCKET,
    @com.fasterxml.jackson.annotation.JsonProperty("Manifest") MANIFEST,
    @com.fasterxml.jackson.annotation.JsonProperty("Other") OTHER;
}

/**
 * Unique frame identifier.
 */

typealias FrameId = String

/**
 * Information about the Frame on the page.
 */

data class Frame(
  /**
   * Frame unique identifier.
   */
  val id : String,

  /**
   * Parent frame identifier.
   */
  val parentId : String? = null,

  /**
   * Identifier of the loader associated with this frame.
   */
  val loaderId : pl.wendigo.chrome.domain.network.LoaderId,

  /**
   * Frame's name as specified in the tag.
   */
  val name : String? = null,

  /**
   * Frame document's URL.
   */
  val url : String,

  /**
   * Frame document's security origin.
   */
  val securityOrigin : String,

  /**
   * Frame document's mimeType as determined by the browser.
   */
  val mimeType : String
)

/**
 * Information about the Resource on the page.
 */

data class FrameResource(
  /**
   * Resource URL.
   */
  val url : String,

  /**
   * Type of this resource.
   */
  val type : ResourceType,

  /**
   * Resource mimeType as determined by the browser.
   */
  val mimeType : String,

  /**
   * last-modified timestamp as reported by server.
   */
  val lastModified : pl.wendigo.chrome.domain.network.Timestamp? = null,

  /**
   * Resource content size.
   */
  val contentSize : Double? = null,

  /**
   * True if the resource failed to load.
   */
  val failed : Boolean? = null,

  /**
   * True if the resource was canceled during loading.
   */
  val canceled : Boolean? = null
)

/**
 * Information about the Frame hierarchy along with their cached resources.
 */

data class FrameResourceTree(
  /**
   * Frame information for this tree item.
   */
  val frame : Frame,

  /**
   * Child frames.
   */
  val childFrames : Array<FrameResourceTree>? = null,

  /**
   * Information about frame resources.
   */
  val resources : Array<FrameResource>
)

/**
 * Unique script identifier.
 */

typealias ScriptIdentifier = String

/**
 * Navigation history entry.
 */

data class NavigationEntry(
  /**
   * Unique id of the navigation history entry.
   */
  val id : Int,

  /**
   * URL of the navigation history entry.
   */
  val url : String,

  /**
   * Title of the navigation history entry.
   */
  val title : String
)

/**
 * Screencast frame metadata.
 */

data class ScreencastFrameMetadata(
  /**
   * Top offset in DIP.
   */
  @pl.wendigo.chrome.Experimental val offsetTop : Double,

  /**
   * Page scale factor.
   */
  @pl.wendigo.chrome.Experimental val pageScaleFactor : Double,

  /**
   * Device screen width in DIP.
   */
  @pl.wendigo.chrome.Experimental val deviceWidth : Double,

  /**
   * Device screen height in DIP.
   */
  @pl.wendigo.chrome.Experimental val deviceHeight : Double,

  /**
   * Position of horizontal scroll in CSS pixels.
   */
  @pl.wendigo.chrome.Experimental val scrollOffsetX : Double,

  /**
   * Position of vertical scroll in CSS pixels.
   */
  @pl.wendigo.chrome.Experimental val scrollOffsetY : Double,

  /**
   * Frame swap timestamp.
   */
  @pl.wendigo.chrome.Experimental val timestamp : Double? = null
)

/**
 * Javascript dialog type.
 */
enum class DialogType {
    @com.fasterxml.jackson.annotation.JsonProperty("alert") ALERT,
    @com.fasterxml.jackson.annotation.JsonProperty("confirm") CONFIRM,
    @com.fasterxml.jackson.annotation.JsonProperty("prompt") PROMPT,
    @com.fasterxml.jackson.annotation.JsonProperty("beforeunload") BEFOREUNLOAD;
}

/**
 * Error while paring app manifest.
 */

data class AppManifestError(
  /**
   * Error message.
   */
  val message : String,

  /**
   * If criticial, this is a non-recoverable parse error.
   */
  val critical : Int,

  /**
   * Error line.
   */
  val line : Int,

  /**
   * Error column.
   */
  val column : Int
)

/**
 * Proceed: allow the navigation; Cancel: cancel the navigation; CancelAndIgnore: cancels the navigation and makes the requester of the navigation acts like the request was never made.
 */
enum class NavigationResponse {
    @com.fasterxml.jackson.annotation.JsonProperty("Proceed") PROCEED,
    @com.fasterxml.jackson.annotation.JsonProperty("Cancel") CANCEL,
    @com.fasterxml.jackson.annotation.JsonProperty("CancelAndIgnore") CANCELANDIGNORE;
}

/**
 * Layout viewport position and dimensions.
 */

data class LayoutViewport(
  /**
   * Horizontal offset relative to the document (CSS pixels).
   */
  val pageX : Int,

  /**
   * Vertical offset relative to the document (CSS pixels).
   */
  val pageY : Int,

  /**
   * Width (CSS pixels), excludes scrollbar if present.
   */
  val clientWidth : Int,

  /**
   * Height (CSS pixels), excludes scrollbar if present.
   */
  val clientHeight : Int
)

/**
 * Visual viewport position, dimensions, and scale.
 */

data class VisualViewport(
  /**
   * Horizontal offset relative to the layout viewport (CSS pixels).
   */
  val offsetX : Double,

  /**
   * Vertical offset relative to the layout viewport (CSS pixels).
   */
  val offsetY : Double,

  /**
   * Horizontal offset relative to the document (CSS pixels).
   */
  val pageX : Double,

  /**
   * Vertical offset relative to the document (CSS pixels).
   */
  val pageY : Double,

  /**
   * Width (CSS pixels), excludes scrollbar if present.
   */
  val clientWidth : Double,

  /**
   * Height (CSS pixels), excludes scrollbar if present.
   */
  val clientHeight : Double,

  /**
   * Scale relative to the ideal viewport (size at width=device-width).
   */
  val scale : Double
)

