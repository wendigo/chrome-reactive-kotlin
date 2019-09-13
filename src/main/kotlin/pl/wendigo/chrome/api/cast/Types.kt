package pl.wendigo.chrome.api.cast

/**
 *
 *
 * @link [Cast#Sink](https://chromedevtools.github.io/devtools-protocol/tot/Cast#type-Sink) type documentation.
 */

data class Sink(
    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val id: String,

    /**  
     * Text describing the current session. Present only if there is an active  
     session on the sink.  
     */  
    val session: String? = null
)
