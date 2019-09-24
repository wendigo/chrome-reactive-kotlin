package pl.wendigo.chrome.api.storage

/**
 * StorageOperations represents Storage protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Storage](https://chromedevtools.github.io/devtools-protocol/tot/Storage) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class StorageOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Clears storage for origin.
     *
     * @link Protocol [Storage#clearDataForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-clearDataForOrigin) method documentation.
     */
    fun clearDataForOrigin(input: ClearDataForOriginRequest) = connection.request("Storage.clearDataForOrigin", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns usage and quota in bytes.
     *
     * @link Protocol [Storage#getUsageAndQuota](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getUsageAndQuota) method documentation.
     */
    fun getUsageAndQuota(input: GetUsageAndQuotaRequest) = connection.request("Storage.getUsageAndQuota", input, GetUsageAndQuotaResponse::class.java)

    /**
     * Registers origin to be notified when an update occurs to its cache storage list.
     *
     * @link Protocol [Storage#trackCacheStorageForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-trackCacheStorageForOrigin) method documentation.
     */
    fun trackCacheStorageForOrigin(input: TrackCacheStorageForOriginRequest) = connection.request("Storage.trackCacheStorageForOrigin", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Registers origin to be notified when an update occurs to its IndexedDB.
     *
     * @link Protocol [Storage#trackIndexedDBForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-trackIndexedDBForOrigin) method documentation.
     */
    fun trackIndexedDBForOrigin(input: TrackIndexedDBForOriginRequest) = connection.request("Storage.trackIndexedDBForOrigin", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Unregisters origin from receiving notifications for cache storage.
     *
     * @link Protocol [Storage#untrackCacheStorageForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-untrackCacheStorageForOrigin) method documentation.
     */
    fun untrackCacheStorageForOrigin(input: UntrackCacheStorageForOriginRequest) = connection.request("Storage.untrackCacheStorageForOrigin", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Unregisters origin from receiving notifications for IndexedDB.
     *
     * @link Protocol [Storage#untrackIndexedDBForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-untrackIndexedDBForOrigin) method documentation.
     */
    fun untrackIndexedDBForOrigin(input: UntrackIndexedDBForOriginRequest) = connection.request("Storage.untrackIndexedDBForOrigin", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  A cache's contents have been modified.
     */
    fun cacheStorageContentUpdated(): io.reactivex.Flowable<CacheStorageContentUpdatedEvent> = connection.events("Storage.cacheStorageContentUpdated", CacheStorageContentUpdatedEvent::class.java)

    /**
     *  A cache has been added/deleted.
     */
    fun cacheStorageListUpdated(): io.reactivex.Flowable<CacheStorageListUpdatedEvent> = connection.events("Storage.cacheStorageListUpdated", CacheStorageListUpdatedEvent::class.java)

    /**
     *  The origin's IndexedDB object store has been modified.
     */
    fun indexedDBContentUpdated(): io.reactivex.Flowable<IndexedDBContentUpdatedEvent> = connection.events("Storage.indexedDBContentUpdated", IndexedDBContentUpdatedEvent::class.java)

    /**
     *  The origin's IndexedDB database list has been modified.
     */
    fun indexedDBListUpdated(): io.reactivex.Flowable<IndexedDBListUpdatedEvent> = connection.events("Storage.indexedDBListUpdated", IndexedDBListUpdatedEvent::class.java)

    /**
     * Returns flowable capturing all Storage domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Storage"
        }
    }
}
/**
 * Represents request frame that can be used with [Storage#clearDataForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-clearDataForOrigin) operation call.
 *
 * Clears storage for origin.
 * @link [Storage#clearDataForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-clearDataForOrigin) method documentation.
 * @see [StorageOperations.clearDataForOrigin]
 */
data class ClearDataForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String,

    /**
     * Comma separated list of StorageType to clear.
     */
    val storageTypes: String

)

/**
 * Represents request frame that can be used with [Storage#getUsageAndQuota](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getUsageAndQuota) operation call.
 *
 * Returns usage and quota in bytes.
 * @link [Storage#getUsageAndQuota](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getUsageAndQuota) method documentation.
 * @see [StorageOperations.getUsageAndQuota]
 */
data class GetUsageAndQuotaRequest(
    /**
     * Security origin.
     */
    val origin: String

)
/**
 * Represents response frame that is returned from [Storage#getUsageAndQuota](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getUsageAndQuota) operation call.
 * Returns usage and quota in bytes.
 *
  
 * @link [Storage#getUsageAndQuota](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getUsageAndQuota) method documentation.
 * @see [StorageOperations.getUsageAndQuota]
 */
data class GetUsageAndQuotaResponse(
    /**  
     * Storage usage (bytes).  
     */  
    val usage: Double,

    /**  
     * Storage quota (bytes).  
     */  
    val quota: Double,

    /**  
     * Storage usage per type (bytes).  
     */  
    val usageBreakdown: List<UsageForType>

)

/**
 * Represents request frame that can be used with [Storage#trackCacheStorageForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-trackCacheStorageForOrigin) operation call.
 *
 * Registers origin to be notified when an update occurs to its cache storage list.
 * @link [Storage#trackCacheStorageForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-trackCacheStorageForOrigin) method documentation.
 * @see [StorageOperations.trackCacheStorageForOrigin]
 */
data class TrackCacheStorageForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents request frame that can be used with [Storage#trackIndexedDBForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-trackIndexedDBForOrigin) operation call.
 *
 * Registers origin to be notified when an update occurs to its IndexedDB.
 * @link [Storage#trackIndexedDBForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-trackIndexedDBForOrigin) method documentation.
 * @see [StorageOperations.trackIndexedDBForOrigin]
 */
data class TrackIndexedDBForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents request frame that can be used with [Storage#untrackCacheStorageForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-untrackCacheStorageForOrigin) operation call.
 *
 * Unregisters origin from receiving notifications for cache storage.
 * @link [Storage#untrackCacheStorageForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-untrackCacheStorageForOrigin) method documentation.
 * @see [StorageOperations.untrackCacheStorageForOrigin]
 */
data class UntrackCacheStorageForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents request frame that can be used with [Storage#untrackIndexedDBForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-untrackIndexedDBForOrigin) operation call.
 *
 * Unregisters origin from receiving notifications for IndexedDB.
 * @link [Storage#untrackIndexedDBForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-untrackIndexedDBForOrigin) method documentation.
 * @see [StorageOperations.untrackIndexedDBForOrigin]
 */
data class UntrackIndexedDBForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * A cache's contents have been modified.
 *
 * @link [Storage#cacheStorageContentUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Storage#event-cacheStorageContentUpdated) event documentation.
 */
data class CacheStorageContentUpdatedEvent(
    /**  
     * Origin to update.  
     */  
    val origin: String,

    /**  
     * Name of cache in origin.  
     */  
    val cacheName: String

) : pl.wendigo.chrome.protocol.Event(domain = "Storage", name = "cacheStorageContentUpdated")

/**
 * A cache has been added/deleted.
 *
 * @link [Storage#cacheStorageListUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Storage#event-cacheStorageListUpdated) event documentation.
 */
data class CacheStorageListUpdatedEvent(
    /**  
     * Origin to update.  
     */  
    val origin: String

) : pl.wendigo.chrome.protocol.Event(domain = "Storage", name = "cacheStorageListUpdated")

/**
 * The origin's IndexedDB object store has been modified.
 *
 * @link [Storage#indexedDBContentUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Storage#event-indexedDBContentUpdated) event documentation.
 */
data class IndexedDBContentUpdatedEvent(
    /**  
     * Origin to update.  
     */  
    val origin: String,

    /**  
     * Database to update.  
     */  
    val databaseName: String,

    /**  
     * ObjectStore to update.  
     */  
    val objectStoreName: String

) : pl.wendigo.chrome.protocol.Event(domain = "Storage", name = "indexedDBContentUpdated")

/**
 * The origin's IndexedDB database list has been modified.
 *
 * @link [Storage#indexedDBListUpdated](https://chromedevtools.github.io/devtools-protocol/tot/Storage#event-indexedDBListUpdated) event documentation.
 */
data class IndexedDBListUpdatedEvent(
    /**  
     * Origin to update.  
     */  
    val origin: String

) : pl.wendigo.chrome.protocol.Event(domain = "Storage", name = "indexedDBListUpdated")
