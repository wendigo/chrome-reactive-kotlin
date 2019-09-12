package pl.wendigo.chrome.domain.cachestorage

/**
 * CacheStorageDomain represents remote debugger protocol domain.
 */
class CacheStorageDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Deletes a cache.
     */
    fun deleteCache(input: DeleteCacheRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CacheStorage.deleteCache", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Deletes a cache entry.
     */
    fun deleteEntry(input: DeleteEntryRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CacheStorage.deleteEntry", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests cache names.
     */
    fun requestCacheNames(input: RequestCacheNamesRequest): io.reactivex.Single<RequestCacheNamesResponse> {
        return connectionRemote.runAndCaptureResponse("CacheStorage.requestCacheNames", input, RequestCacheNamesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Fetches cache entry.
     */
    fun requestCachedResponse(input: RequestCachedResponseRequest): io.reactivex.Single<RequestCachedResponseResponse> {
        return connectionRemote.runAndCaptureResponse("CacheStorage.requestCachedResponse", input, RequestCachedResponseResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Requests data from cache.
     */
    fun requestEntries(input: RequestEntriesRequest): io.reactivex.Single<RequestEntriesResponse> {
        return connectionRemote.runAndCaptureResponse("CacheStorage.requestEntries", input, RequestEntriesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all CacheStorage domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "CacheStorage"
        }
    }
}
/**
 * Represents request frame that can be used with CacheStorage.deleteCache method call.
 *
 * Deletes a cache.
 */
data class DeleteCacheRequest(
    /**
     * Id of cache for deletion.
     */
    val cacheId: CacheId

)

/**
 * Represents request frame that can be used with CacheStorage.deleteEntry method call.
 *
 * Deletes a cache entry.
 */
data class DeleteEntryRequest(
    /**
     * Id of cache where the entry will be deleted.
     */
    val cacheId: CacheId,

    /**
     * URL spec of the request.
     */
    val request: String

)

/**
 * Represents request frame that can be used with CacheStorage.requestCacheNames method call.
 *
 * Requests cache names.
 */
data class RequestCacheNamesRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String

)

/**
 * Represents response frame for CacheStorage.requestCacheNames method call.
 *
 * Requests cache names.
 */
data class RequestCacheNamesResponse(
    /**  
     * Caches for the security origin.  
     */  
    val caches: List<Cache>

)

/**
 * Represents request frame that can be used with CacheStorage.requestCachedResponse method call.
 *
 * Fetches cache entry.
 */
data class RequestCachedResponseRequest(
    /**
     * Id of cache that contains the entry.
     */
    val cacheId: CacheId,

    /**
     * URL spec of the request.
     */
    val requestURL: String,

    /**
     * headers of the request.
     */
    val requestHeaders: List<Header>

)

/**
 * Represents response frame for CacheStorage.requestCachedResponse method call.
 *
 * Fetches cache entry.
 */
data class RequestCachedResponseResponse(
    /**  
     * Response read from the cache.  
     */  
    val response: CachedResponse

)

/**
 * Represents request frame that can be used with CacheStorage.requestEntries method call.
 *
 * Requests data from cache.
 */
data class RequestEntriesRequest(
    /**
     * ID of cache to get entries from.
     */
    val cacheId: CacheId,

    /**
     * Number of records to skip.
     */
    val skipCount: Int,

    /**
     * Number of records to fetch.
     */
    val pageSize: Int,

    /**
     * If present, only return the entries containing this substring in the path
     */
    val pathFilter: String? = null

)

/**
 * Represents response frame for CacheStorage.requestEntries method call.
 *
 * Requests data from cache.
 */
data class RequestEntriesResponse(
    /**  
     * Array of object store data entries.  
     */  
    val cacheDataEntries: List<DataEntry>,

    /**  
     * Count of returned entries from this storage. If pathFilter is empty, it  
     is the count of all entries from this storage.  
     */  
    val returnCount: Double

)
