package pl.wendigo.chrome

class HeadlessChromeProtocol(
        api : DebuggerProtocol,
        val url : String,
        val height : Int,
        val width: Int,
        val targetId : String,
        val browserContextId : String
) : ChromeProtocol(api)