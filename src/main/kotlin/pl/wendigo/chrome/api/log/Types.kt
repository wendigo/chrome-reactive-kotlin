package pl.wendigo.chrome.api.log

/**
 * Log entry.
 *
 * @link [Log#LogEntry](https://chromedevtools.github.io/devtools-protocol/tot/Log#type-LogEntry) type documentation.
 */

@kotlinx.serialization.Serializable
data class LogEntry(
    /**  
     * Log entry source.  
     */  
    val source: String,

    /**  
     * Log entry severity.  
     */  
    val level: String,

    /**  
     * Logged text.  
     */  
    val text: String,

    /**  
     * Timestamp when this entry was added.  
     */  
    val timestamp: pl.wendigo.chrome.api.runtime.Timestamp,

    /**  
     * URL of the resource if known.  
     */  
    val url: String? = null,

    /**  
     * Line number in the resource.  
     */  
    val lineNumber: Int? = null,

    /**  
     * JavaScript stack trace.  
     */  
    val stackTrace: pl.wendigo.chrome.api.runtime.StackTrace? = null,

    /**  
     * Identifier of the network request associated with this entry.  
     */  
    val networkRequestId: pl.wendigo.chrome.api.network.RequestId? = null,

    /**  
     * Identifier of the worker associated with this entry.  
     */  
    val workerId: String? = null,

    /**  
     * Call arguments.  
     */  
    val args: List<pl.wendigo.chrome.api.runtime.RemoteObject>? = null
)

/**
 * Violation configuration setting.
 *
 * @link [Log#ViolationSetting](https://chromedevtools.github.io/devtools-protocol/tot/Log#type-ViolationSetting) type documentation.
 */

@kotlinx.serialization.Serializable
data class ViolationSetting(
    /**  
     * Violation type.  
     */  
    val name: String,

    /**  
     * Time threshold to trigger upon.  
     */  
    val threshold: Double
)
