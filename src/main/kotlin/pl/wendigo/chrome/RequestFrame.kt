package pl.wendigo.chrome

data class RequestFrame(
        val id: Long,
        val method: String,
        val params: Any?
) {
    internal fun toLog(): String {
        return "$method(id=$id)"
    }
}