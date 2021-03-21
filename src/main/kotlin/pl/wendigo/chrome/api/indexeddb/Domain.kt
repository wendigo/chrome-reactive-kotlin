package pl.wendigo.chrome.api.indexeddb

import kotlinx.serialization.json.Json

/**
 * IndexedDBDomain represents IndexedDB protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [IndexedDB](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class IndexedDBDomain internal constructor(connection: pl.wendigo.chrome.protocol.ProtocolConnection) :
    pl.wendigo.chrome.protocol.Domain("IndexedDB", """""", connection) {
    /**
     * Clears all entries from an object store.
     *
     * @link Protocol [IndexedDB#clearObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-clearObjectStore) method documentation.
     */
    
    fun clearObjectStore(input: ClearObjectStoreRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("IndexedDB.clearObjectStore", Json.encodeToJsonElement(ClearObjectStoreRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Deletes a database.
     *
     * @link Protocol [IndexedDB#deleteDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteDatabase) method documentation.
     */
    
    fun deleteDatabase(input: DeleteDatabaseRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("IndexedDB.deleteDatabase", Json.encodeToJsonElement(DeleteDatabaseRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Delete a range of entries from an object store
     *
     * @link Protocol [IndexedDB#deleteObjectStoreEntries](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-deleteObjectStoreEntries) method documentation.
     */
    
    fun deleteObjectStoreEntries(input: DeleteObjectStoreEntriesRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("IndexedDB.deleteObjectStoreEntries", Json.encodeToJsonElement(DeleteObjectStoreEntriesRequest.serializer(), input), pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Disables events from backend.
     *
     * @link Protocol [IndexedDB#disable](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("IndexedDB.disable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Enables events from backend.
     *
     * @link Protocol [IndexedDB#enable](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.websocket.RequestResponseFrame> = connection.request("IndexedDB.enable", null, pl.wendigo.chrome.protocol.websocket.RequestResponseFrame.serializer())

    /**
     * Requests data from object store or index.
     *
     * @link Protocol [IndexedDB#requestData](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestData) method documentation.
     */
    
    fun requestData(input: RequestDataRequest): io.reactivex.rxjava3.core.Single<RequestDataResponse> = connection.request("IndexedDB.requestData", Json.encodeToJsonElement(RequestDataRequest.serializer(), input), RequestDataResponse.serializer())

    /**
     * Gets metadata of an object store
     *
     * @link Protocol [IndexedDB#getMetadata](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-getMetadata) method documentation.
     */
    
    fun getMetadata(input: GetMetadataRequest): io.reactivex.rxjava3.core.Single<GetMetadataResponse> = connection.request("IndexedDB.getMetadata", Json.encodeToJsonElement(GetMetadataRequest.serializer(), input), GetMetadataResponse.serializer())

    /**
     * Requests database with given name in given frame.
     *
     * @link Protocol [IndexedDB#requestDatabase](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabase) method documentation.
     */
    
    fun requestDatabase(input: RequestDatabaseRequest): io.reactivex.rxjava3.core.Single<RequestDatabaseResponse> = connection.request("IndexedDB.requestDatabase", Json.encodeToJsonElement(RequestDatabaseRequest.serializer(), input), RequestDatabaseResponse.serializer())

    /**
     * Requests database names for given security origin.
     *
     * @link Protocol [IndexedDB#requestDatabaseNames](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-requestDatabaseNames) method documentation.
     */
    
    fun requestDatabaseNames(input: RequestDatabaseNamesRequest): io.reactivex.rxjava3.core.Single<RequestDatabaseNamesResponse> = connection.request("IndexedDB.requestDatabaseNames", Json.encodeToJsonElement(RequestDatabaseNamesRequest.serializer(), input), RequestDatabaseNamesResponse.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.protocol.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.runtime.RuntimeDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [IndexedDB#clearObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-clearObjectStore) operation call.
 *
 * Clears all entries from an object store.
 * @link [IndexedDB#clearObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#method-clearObjectStore) method documentation.
 * @see [IndexedDBDomain.clearObjectStore]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.deleteDatabase]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.deleteObjectStoreEntries]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.requestData]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.requestData]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.getMetadata]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.getMetadata]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.requestDatabase]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.requestDatabase]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.requestDatabaseNames]
 */
@kotlinx.serialization.Serializable
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
 * @see [IndexedDBDomain.requestDatabaseNames]
 */
@kotlinx.serialization.Serializable
data class RequestDatabaseNamesResponse(
    /**  
     * Database names for origin.  
     */  
    val databaseNames: List<String>

)
