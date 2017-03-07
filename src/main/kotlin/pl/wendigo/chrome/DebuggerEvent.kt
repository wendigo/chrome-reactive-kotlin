package pl.wendigo.chrome

open class DebuggerEvent(
        private val domain: String,
        private val name: String
) {
    internal fun name() = "$domain.$name"

    fun protocolDomain() = domain

    companion object {
        internal fun fromMethodName(methodName: String): DebuggerEvent {
            val parts = methodName.split(".", limit = 2, ignoreCase = true)
            return DebuggerEvent(domain = parts[0], name = parts[1])
        }
    }
}