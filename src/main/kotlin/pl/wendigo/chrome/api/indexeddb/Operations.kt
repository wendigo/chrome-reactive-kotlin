package pl.wendigo.chrome.api.indexeddb

/**
 * IndexedDBOperations represents IndexedDB protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [IndexedDB](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class IndexedDBOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Clears all entries from an object store.
     *
     * @link Protocol [IndexedDB#clearObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-clearObjectStore) method documentation.
     */
    fun clearObjectStore(input: ClearObjectStoreRequest) = connection.runAndCaptureResponse("IndexedDB.clearObjectStore", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Deletes a database.
     *
     * @link Protocol [IndexedDB#deleteDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteDatabase) method documentation.
     */
    fun deleteDatabase(input: DeleteDatabaseRequest) = connection.runAndCaptureResponse("IndexedDB.deleteDatabase", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Delete a range of entries from an object store
     *
     * @link Protocol [IndexedDB#deleteObjectStoreEntries](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteObjectStoreEntries) method documentation.
     */
    fun deleteObjectStoreEntries(input: DeleteObjectStoreEntriesRequest) = connection.runAndCaptureResponse("IndexedDB.deleteObjectStoreEntries", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disables events from backend.
     *
     * @link Protocol [IndexedDB#disable](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-disable) method documentation.
     */
    fun disable() = connection.runAndCaptureResponse("IndexedDB.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables events from backend.
     *
     * @link Protocol [IndexedDB#enable](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-enable) method documentation.
     */
    fun enable() = connection.runAndCaptureResponse("IndexedDB.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Requests data from object store or index.
     *
     * @link Protocol [IndexedDB#requestData](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestData) method documentation.
     */
    fun requestData(input: RequestDataRequest) = connection.runAndCaptureResponse("IndexedDB.requestData", input, RequestDataResponse::class.java)

    /**
     * Gets metadata of an object store
     *
     * @link Protocol [IndexedDB#getMetadata](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-getMetadata) method documentation.
     */
    fun getMetadata(input: GetMetadataRequest) = connection.runAndCaptureResponse("IndexedDB.getMetadata", input, GetMetadataResponse::class.java)

    /**
     * Requests database with given name in given frame.
     *
     * @link Protocol [IndexedDB#requestDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabase) method documentation.
     */
    fun requestDatabase(input: RequestDatabaseRequest) = connection.runAndCaptureResponse("IndexedDB.requestDatabase", input, RequestDatabaseResponse::class.java)

    /**
     * Requests database names for given security origin.
     *
     * @link Protocol [IndexedDB#requestDatabaseNames](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabaseNames) method documentation.
     */
    fun requestDatabaseNames(input: RequestDatabaseNamesRequest) = connection.runAndCaptureResponse("IndexedDB.requestDatabaseNames", input, RequestDatabaseNamesResponse::class.java)

    /**
     * Returns flowable capturing all IndexedDB domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "IndexedDB"
        }
    }
}
/**
 * Represents request frame that can be used with [IndexedDB#clearObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-clearObjectStore) operation call.
 *
 * Clears all entries from an object store.
 * @link [IndexedDB#clearObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-clearObjectStore) method documentation.
 * @see [IndexedDBOperations.clearObjectStore]
 */
data class ClearObjectStoreRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String,

    /**
     * Database name.
     */
    val databaseName: String,

    /**
     * Object store name.
     */
    val objectStoreName: String

)

/**
 * Represents request frame that can be used with [IndexedDB#deleteDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteDatabase) operation call.
 *
 * Deletes a database.
 * @link [IndexedDB#deleteDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteDatabase) method documentation.
 * @see [IndexedDBOperations.deleteDatabase]
 */
data class DeleteDatabaseRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String,

    /**
     * Database name.
     */
    val databaseName: String

)

/**
 * Represents request frame that can be used with [IndexedDB#deleteObjectStoreEntries](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteObjectStoreEntries) operation call.
 *
 * Delete a range of entries from an object store
 * @link [IndexedDB#deleteObjectStoreEntries](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteObjectStoreEntries) method documentation.
 * @see [IndexedDBOperations.deleteObjectStoreEntries]
 */
data class DeleteObjectStoreEntriesRequest(
    /**
     *
     */
    val securityOrigin: String,

    /**
     *
     */
    val databaseName: String,

    /**
     *
     */
    val objectStoreName: String,

    /**
     * Range of entry keys to delete
     */
    val keyRange: KeyRange

)

/**
 * Represents request frame that can be used with [IndexedDB#requestData](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestData) operation call.
 *
 * Requests data from object store or index.
 * @link [IndexedDB#requestData](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestData) method documentation.
 * @see [IndexedDBOperations.requestData]
 */
data class RequestDataRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String,

    /**
     * Database name.
     */
    val databaseName: String,

    /**
     * Object store name.
     */
    val objectStoreName: String,

    /**
     * Index name, empty string for object store data requests.
     */
    val indexName: String,

    /**
     * Number of records to skip.
     */
    val skipCount: Int,

    /**
     * Number of records to fetch.
     */
    val pageSize: Int,

    /**
     * Key range.
     */
    val keyRange: KeyRange? = null

)
/**
 * Represents response frame that is returned from [IndexedDB#requestData](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestData) operation call.
 * Requests data from object store or index.
 *
  
 * @link [IndexedDB#requestData](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestData) method documentation.
 * @see [IndexedDBOperations.requestData]
 */
data class RequestDataResponse(
    /**  
     * Array of object store data entries.  
     */  
    val objectStoreDataEntries: List<DataEntry>,

    /**  
     * If true, there are more entries to fetch in the given range.  
     */  
    val hasMore: Boolean

)

/**
 * Represents request frame that can be used with [IndexedDB#getMetadata](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-getMetadata) operation call.
 *
 * Gets metadata of an object store
 * @link [IndexedDB#getMetadata](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-getMetadata) method documentation.
 * @see [IndexedDBOperations.getMetadata]
 */
data class GetMetadataRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String,

    /**
     * Database name.
     */
    val databaseName: String,

    /**
     * Object store name.
     */
    val objectStoreName: String

)
/**
 * Represents response frame that is returned from [IndexedDB#getMetadata](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-getMetadata) operation call.
 * Gets metadata of an object store
 *
  
 * @link [IndexedDB#getMetadata](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-getMetadata) method documentation.
 * @see [IndexedDBOperations.getMetadata]
 */
data class GetMetadataResponse(
    /**  
     * the entries count  
     */  
    val entriesCount: Double,

    /**  
     * the current value of key generator, to become the next inserted  
     key into the object store. Valid if objectStore.autoIncrement  
     is true.  
     */  
    val keyGeneratorValue: Double

)

/**
 * Represents request frame that can be used with [IndexedDB#requestDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabase) operation call.
 *
 * Requests database with given name in given frame.
 * @link [IndexedDB#requestDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabase) method documentation.
 * @see [IndexedDBOperations.requestDatabase]
 */
data class RequestDatabaseRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String,

    /**
     * Database name.
     */
    val databaseName: String

)
/**
 * Represents response frame that is returned from [IndexedDB#requestDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabase) operation call.
 * Requests database with given name in given frame.
 *
  
 * @link [IndexedDB#requestDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabase) method documentation.
 * @see [IndexedDBOperations.requestDatabase]
 */
data class RequestDatabaseResponse(
    /**  
     * Database with an array of object stores.  
     */  
    val databaseWithObjectStores: DatabaseWithObjectStores

)

/**
 * Represents request frame that can be used with [IndexedDB#requestDatabaseNames](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabaseNames) operation call.
 *
 * Requests database names for given security origin.
 * @link [IndexedDB#requestDatabaseNames](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabaseNames) method documentation.
 * @see [IndexedDBOperations.requestDatabaseNames]
 */
data class RequestDatabaseNamesRequest(
    /**
     * Security origin.
     */
    val securityOrigin: String

)
/**
 * Represents response frame that is returned from [IndexedDB#requestDatabaseNames](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabaseNames) operation call.
 * Requests database names for given security origin.
 *
  
 * @link [IndexedDB#requestDatabaseNames](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabaseNames) method documentation.
 * @see [IndexedDBOperations.requestDatabaseNames]
 */
data class RequestDatabaseNamesResponse(
    /**  
     * Database names for origin.  
     */  
    val databaseNames: List<String>

)
