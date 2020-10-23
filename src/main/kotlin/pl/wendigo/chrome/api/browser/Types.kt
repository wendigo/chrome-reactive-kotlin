package pl.wendigo.chrome.api.browser

/**
 *
 *
 * @link [Browser#BrowserContextID](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-BrowserContextID) type documentation.
 */

typealias BrowserContextID = String

/**
 *
 *
 * @link [Browser#WindowID](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-WindowID) type documentation.
 */

typealias WindowID = Int

/**
 * The state of the browser window.
 *
 * @link [Browser#WindowState](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-WindowState) type documentation.
 */
enum class WindowState {
    @com.fasterxml.jackson.annotation.JsonProperty("normal")
    NORMAL,
    @com.fasterxml.jackson.annotation.JsonProperty("minimized")
    MINIMIZED,
    @com.fasterxml.jackson.annotation.JsonProperty("maximized")
    MAXIMIZED,
    @com.fasterxml.jackson.annotation.JsonProperty("fullscreen")
    FULLSCREEN;
}

/**
 * Browser window bounds information
 *
 * @link [Browser#Bounds](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-Bounds) type documentation.
 */

data class Bounds(
    /**  
     * The offset from the left edge of the screen to the window in pixels.  
     */  
    val left: Int? = null,

    /**  
     * The offset from the top edge of the screen to the window in pixels.  
     */  
    val top: Int? = null,

    /**  
     * The window width in pixels.  
     */  
    val width: Int? = null,

    /**  
     * The window height in pixels.  
     */  
    val height: Int? = null,

    /**  
     * The window state. Default to normal.  
     */  
    val windowState: WindowState? = null
)

/**
 *
 *
 * @link [Browser#PermissionType](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-PermissionType) type documentation.
 */
enum class PermissionType {
    @com.fasterxml.jackson.annotation.JsonProperty("accessibilityEvents")
    ACCESSIBILITYEVENTS,
    @com.fasterxml.jackson.annotation.JsonProperty("audioCapture")
    AUDIOCAPTURE,
    @com.fasterxml.jackson.annotation.JsonProperty("backgroundSync")
    BACKGROUNDSYNC,
    @com.fasterxml.jackson.annotation.JsonProperty("backgroundFetch")
    BACKGROUNDFETCH,
    @com.fasterxml.jackson.annotation.JsonProperty("clipboardReadWrite")
    CLIPBOARDREADWRITE,
    @com.fasterxml.jackson.annotation.JsonProperty("clipboardSanitizedWrite")
    CLIPBOARDSANITIZEDWRITE,
    @com.fasterxml.jackson.annotation.JsonProperty("durableStorage")
    DURABLESTORAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("flash")
    FLASH,
    @com.fasterxml.jackson.annotation.JsonProperty("geolocation")
    GEOLOCATION,
    @com.fasterxml.jackson.annotation.JsonProperty("midi")
    MIDI,
    @com.fasterxml.jackson.annotation.JsonProperty("midiSysex")
    MIDISYSEX,
    @com.fasterxml.jackson.annotation.JsonProperty("nfc")
    NFC,
    @com.fasterxml.jackson.annotation.JsonProperty("notifications")
    NOTIFICATIONS,
    @com.fasterxml.jackson.annotation.JsonProperty("paymentHandler")
    PAYMENTHANDLER,
    @com.fasterxml.jackson.annotation.JsonProperty("periodicBackgroundSync")
    PERIODICBACKGROUNDSYNC,
    @com.fasterxml.jackson.annotation.JsonProperty("protectedMediaIdentifier")
    PROTECTEDMEDIAIDENTIFIER,
    @com.fasterxml.jackson.annotation.JsonProperty("sensors")
    SENSORS,
    @com.fasterxml.jackson.annotation.JsonProperty("videoCapture")
    VIDEOCAPTURE,
    @com.fasterxml.jackson.annotation.JsonProperty("videoCapturePanTiltZoom")
    VIDEOCAPTUREPANTILTZOOM,
    @com.fasterxml.jackson.annotation.JsonProperty("idleDetection")
    IDLEDETECTION,
    @com.fasterxml.jackson.annotation.JsonProperty("wakeLockScreen")
    WAKELOCKSCREEN,
    @com.fasterxml.jackson.annotation.JsonProperty("wakeLockSystem")
    WAKELOCKSYSTEM;
}

/**
 *
 *
 * @link [Browser#PermissionSetting](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-PermissionSetting) type documentation.
 */
enum class PermissionSetting {
    @com.fasterxml.jackson.annotation.JsonProperty("granted")
    GRANTED,
    @com.fasterxml.jackson.annotation.JsonProperty("denied")
    DENIED,
    @com.fasterxml.jackson.annotation.JsonProperty("prompt")
    PROMPT;
}

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
 *
 * @link [Browser#PermissionDescriptor](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-PermissionDescriptor) type documentation.
 */

data class PermissionDescriptor(
    /**  
     * Name of permission.  
     See https://cs.chromium.org/chromium/src/third_party/blink/renderer/modules/permissions/permission_descriptor.idl for valid permission names.  
     */  
    val name: String,

    /**  
     * For "midi" permission, may also specify sysex control.  
     */  
    val sysex: Boolean? = null,

    /**  
     * For "push" permission, may specify userVisibleOnly.  
     Note that userVisibleOnly = true is the only currently supported type.  
     */  
    val userVisibleOnly: Boolean? = null,

    /**  
     * For "clipboard" permission, may specify allowWithoutSanitization.  
     */  
    val allowWithoutSanitization: Boolean? = null,

    /**  
     * For "camera" permission, may specify panTiltZoom.  
     */  
    val panTiltZoom: Boolean? = null
)

/**
 * Browser command ids used by executeBrowserCommand.
 *
 * @link [Browser#BrowserCommandId](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-BrowserCommandId) type documentation.
 */
enum class BrowserCommandId {
    @com.fasterxml.jackson.annotation.JsonProperty("openTabSearch")
    OPENTABSEARCH;
}

/**
 * Chrome histogram bucket.
 *
 * @link [Browser#Bucket](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-Bucket) type documentation.
 */

data class Bucket(
    /**  
     * Minimum value (inclusive).  
     */  
    val low: Int,

    /**  
     * Maximum value (exclusive).  
     */  
    val high: Int,

    /**  
     * Number of samples.  
     */  
    val count: Int
)

/**
 * Chrome histogram.
 *
 * @link [Browser#Histogram](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-Histogram) type documentation.
 */

data class Histogram(
    /**  
     * Name.  
     */  
    val name: String,

    /**  
     * Sum of sample values.  
     */  
    val sum: Int,

    /**  
     * Total number of samples.  
     */  
    val count: Int,

    /**  
     * Buckets.  
     */  
    val buckets: List<Bucket>
)
