package pl.wendigo.chrome

open class ChromeProtocolEvent(
        val protocolDomain : String,
        val protocolEventName : String
) {
    internal fun name() = "$protocolDomain.$protocolEventName"

    companion object {
        internal fun fromMethodName(methodName: String): ChromeProtocolEvent {
            val parts = methodName.split(".", limit = 2, ignoreCase = true)
            return ChromeProtocolEvent(protocolDomain = parts[0], protocolEventName = parts[1])
        }
    }
}