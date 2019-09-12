package pl.wendigo.chrome.domain.cast

/**
 *
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
