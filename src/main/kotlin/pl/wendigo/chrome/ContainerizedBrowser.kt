package pl.wendigo.chrome

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testcontainers.utility.DockerImageName
import pl.wendigo.chrome.api.ProtocolDomains
import pl.wendigo.chrome.protocol.ProtocolConnection
import pl.wendigo.chrome.targets.Manager

internal class ContainerizedBrowser private constructor(
    private val container: HeadlessChromeContainer,
    browserInfo: BrowserInfo,
    options: Options,
    connection: ProtocolConnection,
    manager: Manager
) : pl.wendigo.chrome.Browser(browserInfo, options, connection, manager) {
    override fun close() {
        super.close()

        logger.info("Stopping container {}", container.containerId)
        container.close()
    }

    override fun toString(): String {
        return "ContainerizedBrowser(container=${container.dockerImageName}[${container.containerId}])"
    }

    companion object {

        private val logger: Logger = LoggerFactory.getLogger(ContainerizedBrowser::class.java)

        /**
         * Creates new Browser instance by connecting to remote chrome debugger.
         */
        internal fun connect(dockerImageName: DockerImageName, options: Options): Browser {
            logger.info("Creating new headless Chrome instance from image {}", dockerImageName)
            val container = HeadlessChromeContainer(dockerImageName)
            container.start()

            logger.info("Started container {}", container.containerId)
            logger.info("Debugger is available on http://{}", container.getBrowserEndpoint())

            val info = fetchInfo(container.getBrowserEndpoint())

            val connection = ProtocolConnection.open(info.webSocketDebuggerUrl, options.eventsBufferSize)
            val protocol = ProtocolDomains(connection)

            return ContainerizedBrowser(
                container,
                info,
                options,
                connection,
                Manager(
                    info.webSocketDebuggerUrl,
                    options.multiplexConnections,
                    options.eventsBufferSize,
                    protocol
                )
            )
        }
    }
}
