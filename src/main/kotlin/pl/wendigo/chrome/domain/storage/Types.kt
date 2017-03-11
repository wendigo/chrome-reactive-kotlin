package pl.wendigo.chrome.domain.storage

/**
 * Enum of possible storage types.
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
    @com.fasterxml.jackson.annotation.JsonProperty("all") ALL;
}

