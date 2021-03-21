package pl.wendigo.chrome.api.systeminfo

/**
 * The SystemInfo domain defines methods and events for querying low-level system information.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [SystemInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class SystemInfoDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("SystemInfo", """The SystemInfo domain defines methods and events for querying low-level system information.""", connection) {
    /**
     * Returns information about the system.
     *
     * @link Protocol [SystemInfo#getInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getInfo) method documentation.
     */
    
    fun getInfo(): io.reactivex.rxjava3.core.Single<GetInfoResponse> = connection.request("SystemInfo.getInfo", null, GetInfoResponse.serializer())

    /**
     * Returns information about all running processes.
     *
     * @link Protocol [SystemInfo#getProcessInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getProcessInfo) method documentation.
     */
    
    fun getProcessInfo(): io.reactivex.rxjava3.core.Single<GetProcessInfoResponse> = connection.request("SystemInfo.getProcessInfo", null, GetProcessInfoResponse.serializer())
}

/**
 * Represents response frame that is returned from [SystemInfo#getInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getInfo) operation call.
 * Returns information about the system.
 *
  
 * @link [SystemInfo#getInfo](https://chromedevtools.github.io/devtools-protocol/tot/SystemInfo#method-getInfo) method documentation.
 * @see [SystemInfoDomain.getInfo]
 */
@kotlinx.serialization.Serializable
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
 * @see [SystemInfoDomain.getProcessInfo]
 */
@kotlinx.serialization.Serializable
data class GetProcessInfoResponse(
    /**  
     * An array of process info blocks.  
     */  
    val processInfo: List<ProcessInfo>

)
