package pl.wendigo.chrome.api.storage

/**
 * Enum of possible storage types.
 *
 * @link [Storage#StorageType](https://chromedevtools.github.io/devtools-protocol/tot/Storage#type-StorageType) type documentation.
 */
enum class StorageType {
    @com.fasterxml.jackson.annotation.JsonProperty("appcache") APPCACHE,
    @com.fasterxml.jackson.annotation.JsonProperty("cookies") COOKIES,
    @com.fasterxml.jackson.annotation.JsonProperty("file_systems") FILE_SYSTEMS,
    @com.fasterxml.jackson.annotation.JsonProperty("indexeddb") INDEXEDDB,
    @com.fasterxml.jackson.annotation.JsonProperty("local_storage") LOCAL_STORAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("shader_cache") SHADER_CACHE,
    @com.fasterxml.jackson.annotation.JsonProperty("websql") WEBSQL,
    @com.fasterxml.jackson.annotation.JsonProperty("service_workers") SERVICE_WORKERS,
    @com.fasterxml.jackson.annotation.JsonProperty("cache_storage") CACHE_STORAGE,
    @com.fasterxml.jackson.annotation.JsonProperty("all") ALL,
    @com.fasterxml.jackson.annotation.JsonProperty("other") OTHER;
}

/**
 * Usage for a storage type.
 *
 * @link [Storage#UsageForType](https://chromedevtools.github.io/devtools-protocol/tot/Storage#type-UsageForType) type documentation.
 */

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

