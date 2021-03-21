package pl.wendigo.chrome.protocol.websocket

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Represents request frame.
 */
@Serializable
data class RequestFrame(
    /**
     * Request id, must be unique.
     */
    val id: Long,

    /**
     * Session ID for Target's flatten mode requests (see [http://crbug.com/991325](http://crbug.com/991325)).
     */
    @SerialName("sessionId")
    val sessionId: String? = null,

    /**
     * Protocol method (domain.method_name i.e. Page.navigateTo)
     */
    val method: String,

    /**
     * Request params (if any)
     */
    val params: JsonElement?
)
