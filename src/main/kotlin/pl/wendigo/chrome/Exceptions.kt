package pl.wendigo.chrome

/**
 * Frame deserialization failed on object mapper.
 */
class DeserializationFailed constructor(override val message: String, throwable: Throwable?) : Exception(message, throwable)

/**
 * Frame serialization failed on object mapper.
 */
class SerializationFailed constructor(override val message: String, throwable: Throwable?) : Exception(message, throwable)

/**
 * Remote debugger connection was not established.
 */
class NotConnected constructor(override val message: String, throwable: Throwable?) : Exception(message, throwable) {
    constructor(message : String) : this(message, null)
}

/**
 * Protocol request has failed.
 */
class RequestFailed constructor(override val message: String, throwable: Throwable?) : Exception(message, throwable) {
    constructor(request: RequestFrame, message : String) : this("request = $request, error = $message", null)
}

/**
 * Inspector command has failed.
 */
class InspectorCommandFailed constructor(override val message: String, throwable: Throwable?) : Exception(message, throwable) {
    constructor(message : String) : this(message, null)
}