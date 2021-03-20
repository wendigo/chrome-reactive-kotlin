package pl.wendigo.chrome.api.log

import kotlinx.serialization.json.Json

/**
 * Provides access to log entries.
 *
 * @link Protocol [Log](https://chromedevtools.github.io/devtools-protocol/tot/Log) domain documentation.
 */

class LogDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebSocketConnection) :
    pl.wendigo.chrome.protocol.Domain("Log", """Provides access to log entries.""", connection) {
    /**
     * Clears the log.
     *
     * @link Protocol [Log#clear](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-clear) method documentation.
     */
    
    fun clear(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Log.clear", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Disables log domain, prevents further log entries from being reported to the client.
     *
     * @link Protocol [Log#disable](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Log.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables log domain, sends the entries collected so far to the client by means of the
`entryAdded` notification.
     *
     * @link Protocol [Log#enable](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Log.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * start violation reporting.
     *
     * @link Protocol [Log#startViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-startViolationsReport) method documentation.
     */
    
    fun startViolationsReport(input: StartViolationsReportRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Log.startViolationsReport", Json.encodeToJsonElement(StartViolationsReportRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Stop violation reporting.
     *
     * @link Protocol [Log#stopViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-stopViolationsReport) method documentation.
     */
    
    fun stopViolationsReport(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("Log.stopViolationsReport", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Issued when new message was logged.
     */
    fun entryAdded(): io.reactivex.rxjava3.core.Flowable<EntryAddedEvent> = connection.events("Log.entryAdded", EntryAddedEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.runtime.RuntimeDomain(connection),
            pl.wendigo.chrome.api.network.NetworkDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [Log#startViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-startViolationsReport) operation call.
 *
 * start violation reporting.
 * @link [Log#startViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-startViolationsReport) method documentation.
 * @see [LogDomain.startViolationsReport]
 */
@kotlinx.serialization.Serializable
data class StartViolationsReportRequest(
    /**
     * Configuration for violations.
     */
    val config: List<ViolationSetting>

)

/**
 * Issued when new message was logged.
 *
 * @link [Log#entryAdded](https://chromedevtools.github.io/devtools-protocol/tot/Log#event-entryAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class EntryAddedEvent(
    /**  
     * The entry.  
     */  
    val entry: LogEntry

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "Log" 
    override fun eventName() = "entryAdded"
} 
