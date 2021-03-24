package pl.wendigo.chrome

import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

internal class HeadlessChromeContainer(dockerImageName: DockerImageName) : GenericContainer<HeadlessChromeContainer>(dockerImageName) {
    init {
        this
            .withCommand(
                "chromium-browser",
                "--headless",
                "--disable-gpu",
                "--disable-software-rasterizer",
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--disable-setuid-sandbox",
                "--remote-debugging-port=9222",
                "--remote-debugging-address=0.0.0.0",
                "about:blank"
            )
            .withPrivilegedMode(true)
            .withReuse(true)

        this.addExposedPort(9222)
    }

    fun getBrowserEndpoint(): String {
        return this.containerIpAddress + ":" + this.getMappedPort(9222)
    }
}
