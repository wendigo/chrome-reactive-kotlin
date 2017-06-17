package pl.wendigo.chrome.domain.systeminfo

/**
 * Describes a single graphics processor (GPU).
 */

data class GPUDevice(
  /**
   * PCI ID of the GPU vendor, if available; 0 otherwise.
   */
  val vendorId : Double,

  /**
   * PCI ID of the GPU device, if available; 0 otherwise.
   */
  val deviceId : Double,

  /**
   * String description of the GPU vendor, if the PCI ID is not available.
   */
  val vendorString : String,

  /**
   * String description of the GPU device, if the PCI ID is not available.
   */
  val deviceString : String
)

/**
 * Provides information about the GPU(s) on the system.
 */

data class GPUInfo(
  /**
   * The graphics devices on the system. Element 0 is the primary GPU.
   */
  val devices : List<GPUDevice>,

  /**
   * An optional dictionary of additional GPU related attributes.
   */
  val auxAttributes : String? = null,

  /**
   * An optional dictionary of graphics features and their status.
   */
  val featureStatus : String? = null,

  /**
   * An optional array of GPU driver bug workarounds.
   */
  val driverBugWorkarounds : List<String>
)

