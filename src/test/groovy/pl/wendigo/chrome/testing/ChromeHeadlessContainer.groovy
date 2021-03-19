package pl.wendigo.chrome.testing

import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

class ChromeHeadlessContainer
        extends GenericContainer<ChromeHeadlessContainer>
{
    public static int PORT = 9222;

    ChromeHeadlessContainer(DockerImageName dockerImageName)
    {
        super(dockerImageName)

        this
                .withExposedPorts(PORT)
                .withCommand(
                        "chromium-browser",
                        "--headless",
                        "--disable-gpu",
                        "--disable-software-rasterizer",
                        "--disable-dev-shm-usage",
                        "--no-sandbox",
                        "--disable-setuid-sandbox",
                        "--remote-debugging-port=${PORT}",
                        "--remote-debugging-address=0.0.0.0",
                        "about:blank"
                )
                .withPrivilegedMode(true)
                .withReuse(true)

            addFixedExposedPort(PORT, PORT)
    }

    String getAddress()
    {
        return getContainerIpAddress() + ":" + PORT
    }

    void close()
    {
        super.close()
    }
}
