package pl.wendigo.chrome.api.storage

/**
 * Enum of possible storage types.
 *
 * @link [Storage#StorageType](https://chromedevtools.github.io/devtools-protocol/tot/Storage#type-StorageType) type documentation.
 */
@kotlinx.serialization.Serializable
enum class StorageType {
    @kotlinx.serialization.SerialName("appcache")
    APPCACHE,

    @kotlinx.serialization.SerialName("cookies")
    COOKIES,

    @kotlinx.serialization.SerialName("file_systems")
    FILE_SYSTEMS,

    @kotlinx.serialization.SerialName("indexeddb")
    INDEXEDDB,

    @kotlinx.serialization.SerialName("local_storage")
    LOCAL_STORAGE,

    @kotlinx.serialization.SerialName("shader_cache")
    SHADER_CACHE,

    @kotlinx.serialization.SerialName("websql")
    WEBSQL,

    @kotlinx.serialization.SerialName("service_workers")
    SERVICE_WORKERS,

    @kotlinx.serialization.SerialName("cache_storage")
    CACHE_STORAGE,

    @kotlinx.serialization.SerialName("all")
    ALL,

    @kotlinx.serialization.SerialName("other")
    OTHER;
}

/**
 * Usage for a storage type.
 *
 * @link [Storage#UsageForType](https://chromedevtools.github.io/devtools-protocol/tot/Storage#type-UsageForType) type documentation.
 */

@kotlinx.serialization.Serializable
data class UsageForType(
    /**  
     * Name of storage type.  
     */  
    val storageType: StorageType,

    /**  
     * Storage usage (bytes).  
     */  
    val usage: Double
)

/**
 * Pair of issuer origin and number of available (signed, but not used) Trust
Tokens from that issuer.
 *
 * @link [Storage#TrustTokens](https://chromedevtools.github.io/devtools-protocol/tot/Storage#type-TrustTokens) type documentation.
 */

@kotlinx.serialization.Serializable
data class TrustTokens(
    /**  
     *  
     */  
    val issuerOrigin: String,

    /**  
     *  
     */  
    val count: Double
)
