package pl.wendigo.chrome

class RemoteChromeException constructor(override val message: String, throwable: Throwable?) : Exception(message, throwable) {
    constructor(message: String) : this(message, null)
}
