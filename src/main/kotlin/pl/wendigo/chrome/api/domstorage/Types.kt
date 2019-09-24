package pl.wendigo.chrome.api.domstorage

/**
 * DOM Storage identifier.
 *
 * @link [DOMStorage#StorageId](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#type-StorageId) type documentation.
 */

data class StorageId(
    /**  
     * Security origin for the storage.  
     */  
    val securityOrigin: String,

    /**  
     * Whether the storage is local storage (not session storage).  
     */  
    val isLocalStorage: Boolean
)

/**
 * DOM Storage item.
 *
 * @link [DOMStorage#Item](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#type-Item) type documentation.
 */

typealias Item = List<String>
