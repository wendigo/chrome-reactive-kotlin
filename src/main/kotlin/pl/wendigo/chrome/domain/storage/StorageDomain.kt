package pl.wendigo.chrome.domain.storage

/**
 * StorageDomain represents remote debugger protocol domain.
 */
class StorageDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Clears storage for origin.
     */
    fun clearDataForOrigin(input: ClearDataForOriginRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Storage.clearDataForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns usage and quota in bytes.
     */
    fun getUsageAndQuota(input: GetUsageAndQuotaRequest): io.reactivex.Single<GetUsageAndQuotaResponse> {
        return connectionRemote.runAndCaptureResponse("Storage.getUsageAndQuota", input, GetUsageAndQuotaResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Registers origin to be notified when an update occurs to its cache storage list.
     */
    fun trackCacheStorageForOrigin(input: TrackCacheStorageForOriginRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Storage.trackCacheStorageForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Registers origin to be notified when an update occurs to its IndexedDB.
     */
    fun trackIndexedDBForOrigin(input: TrackIndexedDBForOriginRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Storage.trackIndexedDBForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Unregisters origin from receiving notifications for cache storage.
     */
    fun untrackCacheStorageForOrigin(input: UntrackCacheStorageForOriginRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Storage.untrackCacheStorageForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Unregisters origin from receiving notifications for IndexedDB.
     */
    fun untrackIndexedDBForOrigin(input: UntrackIndexedDBForOriginRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Storage.untrackIndexedDBForOrigin", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  A cache's contents have been modified.
     */
    fun cacheStorageContentUpdated(): io.reactivex.Flowable<CacheStorageContentUpdatedEvent> {
        return cacheStorageContentUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * A cache's contents have been modified.
     */
    fun cacheStorageContentUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<CacheStorageContentUpdatedEvent>> {
        return connectionRemote.captureEvents("Storage.cacheStorageContentUpdated", CacheStorageContentUpdatedEvent::class.java)
    }

    /**
     *  A cache has been added/deleted.
     */
    fun cacheStorageListUpdated(): io.reactivex.Flowable<CacheStorageListUpdatedEvent> {
        return cacheStorageListUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * A cache has been added/deleted.
     */
    fun cacheStorageListUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<CacheStorageListUpdatedEvent>> {
        return connectionRemote.captureEvents("Storage.cacheStorageListUpdated", CacheStorageListUpdatedEvent::class.java)
    }

    /**
     *  The origin's IndexedDB object store has been modified.
     */
    fun indexedDBContentUpdated(): io.reactivex.Flowable<IndexedDBContentUpdatedEvent> {
        return indexedDBContentUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * The origin's IndexedDB object store has been modified.
     */
    fun indexedDBContentUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<IndexedDBContentUpdatedEvent>> {
        return connectionRemote.captureEvents("Storage.indexedDBContentUpdated", IndexedDBContentUpdatedEvent::class.java)
    }

    /**
     *  The origin's IndexedDB database list has been modified.
     */
    fun indexedDBListUpdated(): io.reactivex.Flowable<IndexedDBListUpdatedEvent> {
        return indexedDBListUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * The origin's IndexedDB database list has been modified.
     */
    fun indexedDBListUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<IndexedDBListUpdatedEvent>> {
        return connectionRemote.captureEvents("Storage.indexedDBListUpdated", IndexedDBListUpdatedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Storage domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Storage"
        }
    }
}
/**
 * Represents request frame that can be used with Storage.clearDataForOrigin method call.
 *
 * Clears storage for origin.
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
 * Represents request frame that can be used with Storage.getUsageAndQuota method call.
 *
 * Returns usage and quota in bytes.
 */
data class GetUsageAndQuotaRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents response frame for Storage.getUsageAndQuota method call.
 *
 * Returns usage and quota in bytes.
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
 * Represents request frame that can be used with Storage.trackCacheStorageForOrigin method call.
 *
 * Registers origin to be notified when an update occurs to its cache storage list.
 */
data class TrackCacheStorageForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents request frame that can be used with Storage.trackIndexedDBForOrigin method call.
 *
 * Registers origin to be notified when an update occurs to its IndexedDB.
 */
data class TrackIndexedDBForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents request frame that can be used with Storage.untrackCacheStorageForOrigin method call.
 *
 * Unregisters origin from receiving notifications for cache storage.
 */
data class UntrackCacheStorageForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents request frame that can be used with Storage.untrackIndexedDBForOrigin method call.
 *
 * Unregisters origin from receiving notifications for IndexedDB.
 */
data class UntrackIndexedDBForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String

)

/**
 * Represents event frames for Storage.cacheStorageContentUpdated
 *
 * A cache's contents have been modified.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Storage", name = "cacheStorageContentUpdated")

/**
 * Represents event frames for Storage.cacheStorageListUpdated
 *
 * A cache has been added/deleted.
 */
data class CacheStorageListUpdatedEvent(
    /**  
     * Origin to update.  
     */  
    val origin: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Storage", name = "cacheStorageListUpdated")

/**
 * Represents event frames for Storage.indexedDBContentUpdated
 *
 * The origin's IndexedDB object store has been modified.
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "Storage", name = "indexedDBContentUpdated")

/**
 * Represents event frames for Storage.indexedDBListUpdated
 *
 * The origin's IndexedDB database list has been modified.
 */
data class IndexedDBListUpdatedEvent(
    /**  
     * Origin to update.  
     */  
    val origin: String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Storage", name = "indexedDBListUpdated")
