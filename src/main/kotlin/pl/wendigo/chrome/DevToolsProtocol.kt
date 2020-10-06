package pl.wendigo.chrome

import io.reactivex.Flowable
import java.io.Closeable
import pl.wendigo.chrome.protocol.ChromeDebuggerConnection

/**
 * DevToolsProtocol represents all operations on all domains that can be issued to control Chrome via [DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).
 *
 * @link [https://github.com/chromedevtools/devtools-protocol](https://github.com/chromedevtools/devtools-protocol)
 * @link [https://chromedevtools.github.io/devtools-protocol/](https://chromedevtools.github.io/devtools-protocol/)
 */
open class DevToolsProtocol internal constructor(internal val connection: ChromeDebuggerConnection) : Closeable {

    /**
     * Register events mappings.
     */
    init {
    }

    /**
     * Returns [Flowable] capturing all events.
     */
    fun Events(): Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents()
    }

    /**
     * Closes target.
     */
    override fun close() {
        return connection.close()
    }
}
