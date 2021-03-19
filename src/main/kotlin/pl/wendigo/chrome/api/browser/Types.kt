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
@kotlinx.serialization.Serializable
enum class WindowState {
    @kotlinx.serialization.SerialName("normal")
    NORMAL,

    @kotlinx.serialization.SerialName("minimized")
    MINIMIZED,

    @kotlinx.serialization.SerialName("maximized")
    MAXIMIZED,

    @kotlinx.serialization.SerialName("fullscreen")
    FULLSCREEN;
}

/**
 * Browser window bounds information
 *
 * @link [Browser#Bounds](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-Bounds) type documentation.
 */

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class PermissionType {
    @kotlinx.serialization.SerialName("accessibilityEvents")
    ACCESSIBILITYEVENTS,

    @kotlinx.serialization.SerialName("audioCapture")
    AUDIOCAPTURE,

    @kotlinx.serialization.SerialName("backgroundSync")
    BACKGROUNDSYNC,

    @kotlinx.serialization.SerialName("backgroundFetch")
    BACKGROUNDFETCH,

    @kotlinx.serialization.SerialName("clipboardReadWrite")
    CLIPBOARDREADWRITE,

    @kotlinx.serialization.SerialName("clipboardSanitizedWrite")
    CLIPBOARDSANITIZEDWRITE,

    @kotlinx.serialization.SerialName("displayCapture")
    DISPLAYCAPTURE,

    @kotlinx.serialization.SerialName("durableStorage")
    DURABLESTORAGE,

    @kotlinx.serialization.SerialName("flash")
    FLASH,

    @kotlinx.serialization.SerialName("geolocation")
    GEOLOCATION,

    @kotlinx.serialization.SerialName("midi")
    MIDI,

    @kotlinx.serialization.SerialName("midiSysex")
    MIDISYSEX,

    @kotlinx.serialization.SerialName("nfc")
    NFC,

    @kotlinx.serialization.SerialName("notifications")
    NOTIFICATIONS,

    @kotlinx.serialization.SerialName("paymentHandler")
    PAYMENTHANDLER,

    @kotlinx.serialization.SerialName("periodicBackgroundSync")
    PERIODICBACKGROUNDSYNC,

    @kotlinx.serialization.SerialName("protectedMediaIdentifier")
    PROTECTEDMEDIAIDENTIFIER,

    @kotlinx.serialization.SerialName("sensors")
    SENSORS,

    @kotlinx.serialization.SerialName("videoCapture")
    VIDEOCAPTURE,

    @kotlinx.serialization.SerialName("videoCapturePanTiltZoom")
    VIDEOCAPTUREPANTILTZOOM,

    @kotlinx.serialization.SerialName("idleDetection")
    IDLEDETECTION,

    @kotlinx.serialization.SerialName("wakeLockScreen")
    WAKELOCKSCREEN,

    @kotlinx.serialization.SerialName("wakeLockSystem")
    WAKELOCKSYSTEM;
}

/**
 *
 *
 * @link [Browser#PermissionSetting](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-PermissionSetting) type documentation.
 */
@kotlinx.serialization.Serializable
enum class PermissionSetting {
    @kotlinx.serialization.SerialName("granted")
    GRANTED,

    @kotlinx.serialization.SerialName("denied")
    DENIED,

    @kotlinx.serialization.SerialName("prompt")
    PROMPT;
}

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
 *
 * @link [Browser#PermissionDescriptor](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-PermissionDescriptor) type documentation.
 */

@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
enum class BrowserCommandId {
    @kotlinx.serialization.SerialName("openTabSearch")
    OPENTABSEARCH,

    @kotlinx.serialization.SerialName("closeTabSearch")
    CLOSETABSEARCH;
}

/**
 * Chrome histogram bucket.
 *
 * @link [Browser#Bucket](https://chromedevtools.github.io/devtools-protocol/tot/Browser#type-Bucket) type documentation.
 */

@kotlinx.serialization.Serializable
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

@kotlinx.serialization.Serializable
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
