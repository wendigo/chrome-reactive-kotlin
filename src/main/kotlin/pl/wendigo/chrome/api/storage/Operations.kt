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
     * Returns all browser cookies.
     *
     * @link Protocol [Storage#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getCookies) method documentation.
     */
    fun getCookies(input: GetCookiesRequest) = connection.request("Storage.getCookies", input, GetCookiesResponse::class.java)

    /**
     * Sets given cookies.
     *
     * @link Protocol [Storage#setCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-setCookies) method documentation.
     */
    fun setCookies(input: SetCookiesRequest) = connection.request("Storage.setCookies", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Clears cookies.
     *
     * @link Protocol [Storage#clearCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-clearCookies) method documentation.
     */
    fun clearCookies(input: ClearCookiesRequest) = connection.request("Storage.clearCookies", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns usage and quota in bytes.
     *
     * @link Protocol [Storage#getUsageAndQuota](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getUsageAndQuota) method documentation.
     */
    fun getUsageAndQuota(input: GetUsageAndQuotaRequest) = connection.request("Storage.getUsageAndQuota", input, GetUsageAndQuotaResponse::class.java)

    /**
     * Override quota for the specified origin
     *
     * @link Protocol [Storage#overrideQuotaForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-overrideQuotaForOrigin) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun overrideQuotaForOrigin(input: OverrideQuotaForOriginRequest) = connection.request("Storage.overrideQuotaForOrigin", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

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
     * Returns the number of stored Trust Tokens per issuer for the
current browsing context.
     *
     * @link Protocol [Storage#getTrustTokens](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getTrustTokens) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getTrustTokens() = connection.request("Storage.getTrustTokens", null, GetTrustTokensResponse::class.java)

    /**
     *  A cache's contents have been modified.
     */
    fun cacheStorageContentUpdated(): io.reactivex.rxjava3.core.Flowable<CacheStorageContentUpdatedEvent> = connection.events("Storage.cacheStorageContentUpdated", CacheStorageContentUpdatedEvent::class.java)

    /**
     *  A cache has been added/deleted.
     */
    fun cacheStorageListUpdated(): io.reactivex.rxjava3.core.Flowable<CacheStorageListUpdatedEvent> = connection.events("Storage.cacheStorageListUpdated", CacheStorageListUpdatedEvent::class.java)

    /**
     *  The origin's IndexedDB object store has been modified.
     */
    fun indexedDBContentUpdated(): io.reactivex.rxjava3.core.Flowable<IndexedDBContentUpdatedEvent> = connection.events("Storage.indexedDBContentUpdated", IndexedDBContentUpdatedEvent::class.java)

    /**
     *  The origin's IndexedDB database list has been modified.
     */
    fun indexedDBListUpdated(): io.reactivex.rxjava3.core.Flowable<IndexedDBListUpdatedEvent> = connection.events("Storage.indexedDBListUpdated", IndexedDBListUpdatedEvent::class.java)

    /**
     * Returns flowable capturing all Storage domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
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
 * Represents request frame that can be used with [Storage#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getCookies) operation call.
 *
 * Returns all browser cookies.
 * @link [Storage#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getCookies) method documentation.
 * @see [StorageOperations.getCookies]
 */
data class GetCookiesRequest(
    /**
     * Browser context to use when called on the browser endpoint.
     */
    val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID? = null

)

/**
 * Represents response frame that is returned from [Storage#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getCookies) operation call.
 * Returns all browser cookies.
 *
  
 * @link [Storage#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getCookies) method documentation.
 * @see [StorageOperations.getCookies]
 */
data class GetCookiesResponse(
    /**  
     * Array of cookie objects.  
     */  
    val cookies: List<pl.wendigo.chrome.api.network.Cookie>

)

/**
 * Represents request frame that can be used with [Storage#setCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-setCookies) operation call.
 *
 * Sets given cookies.
 * @link [Storage#setCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-setCookies) method documentation.
 * @see [StorageOperations.setCookies]
 */
data class SetCookiesRequest(
    /**
     * Cookies to be set.
     */
    val cookies: List<pl.wendigo.chrome.api.network.CookieParam>,

    /**
     * Browser context to use when called on the browser endpoint.
     */
    val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID? = null

)

/**
 * Represents request frame that can be used with [Storage#clearCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-clearCookies) operation call.
 *
 * Clears cookies.
 * @link [Storage#clearCookies](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-clearCookies) method documentation.
 * @see [StorageOperations.clearCookies]
 */
data class ClearCookiesRequest(
    /**
     * Browser context to use when called on the browser endpoint.
     */
    val browserContextId: pl.wendigo.chrome.api.browser.BrowserContextID? = null

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
     * Whether or not the origin has an active storage quota override  
     */  
    val overrideActive: Boolean,

    /**  
     * Storage usage per type (bytes).  
     */  
    val usageBreakdown: List<UsageForType>

)

/**
 * Represents request frame that can be used with [Storage#overrideQuotaForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-overrideQuotaForOrigin) operation call.
 *
 * Override quota for the specified origin
 * @link [Storage#overrideQuotaForOrigin](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-overrideQuotaForOrigin) method documentation.
 * @see [StorageOperations.overrideQuotaForOrigin]
 */
data class OverrideQuotaForOriginRequest(
    /**
     * Security origin.
     */
    val origin: String,

    /**
     * The quota size (in bytes) to override the original quota with.
If this is called multiple times, the overriden quota will be equal to
the quotaSize provided in the final call. If this is called without
specifying a quotaSize, the quota will be reset to the default value for
the specified origin. If this is called multiple times with different
origins, the override will be maintained for each origin until it is
disabled (called without a quotaSize).
     */
    val quotaSize: Double? = null

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
 * Represents response frame that is returned from [Storage#getTrustTokens](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getTrustTokens) operation call.
 * Returns the number of stored Trust Tokens per issuer for the
current browsing context.
 *
  
 * @link [Storage#getTrustTokens](https://chromedevtools.github.io/devtools-protocol/tot/Storage#method-getTrustTokens) method documentation.
 * @see [StorageOperations.getTrustTokens]
 */
data class GetTrustTokensResponse(
    /**  
     *  
     */  
    val tokens: List<TrustTokens>

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
