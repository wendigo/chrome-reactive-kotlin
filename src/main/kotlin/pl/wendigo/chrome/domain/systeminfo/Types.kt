package pl.wendigo.chrome.domain.systeminfo

/**
 * Describes a single graphics processor (GPU).
 */

data class GPUDevice(
    /**  
     * PCI ID of the GPU vendor, if available; 0 otherwise.  
     */  
    val vendorId: Double,

    /**  
     * PCI ID of the GPU device, if available; 0 otherwise.  
     */  
    val deviceId: Double,

    /**  
     * String description of the GPU vendor, if the PCI ID is not available.  
     */  
    val vendorString: String,

    /**  
     * String description of the GPU device, if the PCI ID is not available.  
     */  
    val deviceString: String,

    /**  
     * String description of the GPU driver vendor.  
     */  
    val driverVendor: String,

    /**  
     * String description of the GPU driver version.  
     */  
    val driverVersion: String
)

/**
 * Describes the width and height dimensions of an entity.
 */

data class Size(
    /**  
     * Width in pixels.  
     */  
    val width: Int,

    /**  
     * Height in pixels.  
     */  
    val height: Int
)

/**
 * Describes a supported video decoding profile with its associated minimum and
maximum resolutions.
 */

data class VideoDecodeAcceleratorCapability(
    /**  
     * Video codec profile that is supported, e.g. VP9 Profile 2.  
     */  
    val profile: String,

    /**  
     * Maximum video dimensions in pixels supported for this |profile|.  
     */  
    val maxResolution: Size,

    /**  
     * Minimum video dimensions in pixels supported for this |profile|.  
     */  
    val minResolution: Size
)

/**
 * Describes a supported video encoding profile with its associated maximum
resolution and maximum framerate.
 */

data class VideoEncodeAcceleratorCapability(
    /**  
     * Video codec profile that is supported, e.g H264 Main.  
     */  
    val profile: String,

    /**  
     * Maximum video dimensions in pixels supported for this |profile|.  
     */  
    val maxResolution: Size,

    /**  
     * Maximum encoding framerate in frames per second supported for this  
     |profile|, as fraction's numerator and denominator, e.g. 24/1 fps,  
     24000/1001 fps, etc.  
     */  
    val maxFramerateNumerator: Int,

    /**  
     *  
     */  
    val maxFramerateDenominator: Int
)

/**
 * YUV subsampling type of the pixels of a given image.
 */
enum class SubsamplingFormat {
    @com.fasterxml.jackson.annotation.JsonProperty("yuv420")
    YUV420,
    @com.fasterxml.jackson.annotation.JsonProperty("yuv422")
    YUV422,
    @com.fasterxml.jackson.annotation.JsonProperty("yuv444")
    YUV444;
}

/**
 * Image format of a given image.
 */
enum class ImageType {
    @com.fasterxml.jackson.annotation.JsonProperty("jpeg")
    JPEG,
    @com.fasterxml.jackson.annotation.JsonProperty("webp")
    WEBP,
    @com.fasterxml.jackson.annotation.JsonProperty("unknown")
    UNKNOWN;
}

/**
 * Describes a supported image decoding profile with its associated minimum and
maximum resolutions and subsampling.
 */

data class ImageDecodeAcceleratorCapability(
    /**  
     * Image coded, e.g. Jpeg.  
     */  
    val imageType: ImageType,

    /**  
     * Maximum supported dimensions of the image in pixels.  
     */  
    val maxDimensions: Size,

    /**  
     * Minimum supported dimensions of the image in pixels.  
     */  
    val minDimensions: Size,

    /**  
     * Optional array of supported subsampling formats, e.g. 4:2:0, if known.  
     */  
    val subsamplings: List<SubsamplingFormat>
)

/**
 * Provides information about the GPU(s) on the system.
 */

data class GPUInfo(
    /**  
     * The graphics devices on the system. Element 0 is the primary GPU.  
     */  
    val devices: List<GPUDevice>,

    /**  
     * An optional dictionary of additional GPU related attributes.  
     */  
    val auxAttributes: com.fasterxml.jackson.databind.JsonNode? = null,

    /**  
     * An optional dictionary of graphics features and their status.  
     */  
    val featureStatus: com.fasterxml.jackson.databind.JsonNode? = null,

    /**  
     * An optional array of GPU driver bug workarounds.  
     */  
    val driverBugWorkarounds: List<String>,

    /**  
     * Supported accelerated video decoding capabilities.  
     */  
    val videoDecoding: List<VideoDecodeAcceleratorCapability>,

    /**  
     * Supported accelerated video encoding capabilities.  
     */  
    val videoEncoding: List<VideoEncodeAcceleratorCapability>,

    /**  
     * Supported accelerated image decoding capabilities.  
     */  
    val imageDecoding: List<ImageDecodeAcceleratorCapability>
)

/**
 * Represents process info.
 */

data class ProcessInfo(
    /**  
     * Specifies process type.  
     */  
    val type: String,

    /**  
     * Specifies process id.  
     */  
    val id: Int,

    /**  
     * Specifies cumulative CPU usage in seconds across all threads of the  
     process since the process start.  
     */  
    val cpuTime: Double
)
