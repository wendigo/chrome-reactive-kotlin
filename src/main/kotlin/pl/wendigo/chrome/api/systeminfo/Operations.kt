package pl.wendigo.chrome.api.systeminfo

/**
 * The SystemInfo domain defines methods and events for querying low-level system information.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [SystemInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class SystemInfoOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Returns information about the system.
     *
     * @link Protocol [SystemInfo#getInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getInfo) method documentation.
     */
    fun getInfo() = connection.request("SystemInfo.getInfo", null, GetInfoResponse::class.java)

    /**
     * Returns information about all running processes.
     *
     * @link Protocol [SystemInfo#getProcessInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getProcessInfo) method documentation.
     */
    fun getProcessInfo() = connection.request("SystemInfo.getProcessInfo", null, GetProcessInfoResponse::class.java)

    /**
     * Returns flowable capturing all SystemInfo domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "SystemInfo"
        }
    }
}

/**
 * Represents response frame that is returned from [SystemInfo#getInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getInfo) operation call.
 * Returns information about the system.
 *
  
 * @link [SystemInfo#getInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getInfo) method documentation.
 * @see [SystemInfoOperations.getInfo]
 */
data class GetInfoResponse(
    /**  
     * Information about the GPUs on the system.  
     */  
    val gpu: GPUInfo,

    /**  
     * A platform-dependent description of the model of the machine. On Mac OS, this is, for  
     example, 'MacBookPro'. Will be the empty string if not supported.  
     */  
    val modelName: String,

    /**  
     * A platform-dependent description of the version of the machine. On Mac OS, this is, for  
     example, '10.1'. Will be the empty string if not supported.  
     */  
    val modelVersion: String,

    /**  
     * The command line string used to launch the browser. Will be the empty string if not  
     supported.  
     */  
    val commandLine: String

)

/**
 * Represents response frame that is returned from [SystemInfo#getProcessInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getProcessInfo) operation call.
 * Returns information about all running processes.
 *
  
 * @link [SystemInfo#getProcessInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getProcessInfo) method documentation.
 * @see [SystemInfoOperations.getProcessInfo]
 */
data class GetProcessInfoResponse(
    /**  
     * An array of process info blocks.  
     */  
    val processInfo: List<ProcessInfo>

)
