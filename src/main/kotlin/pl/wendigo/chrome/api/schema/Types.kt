package pl.wendigo.chrome.api.schema

/**
 * Description of the protocol domain.
 *
 * @link [Schema#Domain](https://chromedevtools.github.io/devtools-protocol/tot/Schema#type-Domain) type documentation.
 */

data class Domain(
    /**  
     * Domain name.  
     */  
    val name: String,

    /**  
     * Domain version.  
     */  
    val version: String
)
