package pl.wendigo.chrome.api.log

import kotlinx.serialization.json.Json

/**
 * Provides access to log entries.
 *
 * @link Protocol [Log](https://chromedevtools.github.io/devtools-protocol/tot/Log) domain documentation.
 */
class LogOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Clears the log.
     *
     * @link Protocol [Log#clear](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-clear) method documentation.
     */
    fun clear() = connection.request("Log.clear", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Disables log domain, prevents further log entries from being reported to the client.
     *
     * @link Protocol [Log#disable](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-disable) method documentation.
     */
    fun disable() = connection.request("Log.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables log domain, sends the entries collected so far to the client by means of the
`entryAdded` notification.
     *
     * @link Protocol [Log#enable](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-enable) method documentation.
     */
    fun enable() = connection.request("Log.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * start violation reporting.
     *
     * @link Protocol [Log#startViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-startViolationsReport) method documentation.
     */
    fun startViolationsReport(input: StartViolationsReportRequest) = connection.request("Log.startViolationsReport", Json.encodeToJsonElement(StartViolationsReportRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Stop violation reporting.
     *
     * @link Protocol [Log#stopViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-stopViolationsReport) method documentation.
     */
    fun stopViolationsReport() = connection.request("Log.stopViolationsReport", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Issued when new message was logged.
     */
    fun entryAdded(): io.reactivex.rxjava3.core.Flowable<EntryAddedEvent> = connection.events("Log.entryAdded", EntryAddedEvent.serializer())

    /**
     * Returns flowable capturing all Log domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Log"
        }
    }
}

/**
 * Represents request frame that can be used with [Log#startViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-startViolationsReport) operation call.
 *
 * start violation reporting.
 * @link [Log#startViolationsReport](https://chromedevtools.github.io/devtools-protocol/tot/Log#method-startViolationsReport) method documentation.
 * @see [LogOperations.startViolationsReport]
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

) : pl.wendigo.chrome.protocol.Event(domainName = "Log", domainEventName = "entryAdded")
