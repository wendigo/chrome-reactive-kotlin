package pl.wendigo.chrome.domain.indexeddb

/**
 * IndexedDBDomain represents remote debugger protocol domain.
 */
class IndexedDBDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Enables events from backend.
     */
    fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables events from backend.
     */
    fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests database names for given security origin.
     */
    fun requestDatabaseNames(input : RequestDatabaseNamesRequest) : io.reactivex.Single<RequestDatabaseNamesResponse> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.requestDatabaseNames", input, RequestDatabaseNamesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Requests database with given name in given frame.
     */
    fun requestDatabase(input : RequestDatabaseRequest) : io.reactivex.Single<RequestDatabaseResponse> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.requestDatabase", input, RequestDatabaseResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Requests data from object store or index.
     */
    fun requestData(input : RequestDataRequest) : io.reactivex.Single<RequestDataResponse> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.requestData", input, RequestDataResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Clears all entries from an object store.
     */
    fun clearObjectStore(input : ClearObjectStoreRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.clearObjectStore", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Deletes a database.
     */
    fun deleteDatabase(input : DeleteDatabaseRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("IndexedDB.deleteDatabase", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all IndexedDB domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "IndexedDB"
        }
    }
}

/**
 * Represents request frame that can be used with IndexedDB.requestDatabaseNames method call.
 *
 * Requests database names for given security origin.
 */
data class RequestDatabaseNamesRequest (
    /**
     * Security origin.
     */
    val securityOrigin : String

)

/**
 * Represents response frame for IndexedDB.requestDatabaseNames method call.
 *
 * Requests database names for given security origin.
 */
data class RequestDatabaseNamesResponse(
  /**
   * Database names for origin.
   */
  val databaseNames : List<String>

)

/**
 * Represents request frame that can be used with IndexedDB.requestDatabase method call.
 *
 * Requests database with given name in given frame.
 */
data class RequestDatabaseRequest (
    /**
     * Security origin.
     */
    val securityOrigin : String,

    /**
     * Database name.
     */
    val databaseName : String

)

/**
 * Represents response frame for IndexedDB.requestDatabase method call.
 *
 * Requests database with given name in given frame.
 */
data class RequestDatabaseResponse(
  /**
   * Database with an array of object stores.
   */
  val databaseWithObjectStores : DatabaseWithObjectStores

)

/**
 * Represents request frame that can be used with IndexedDB.requestData method call.
 *
 * Requests data from object store or index.
 */
data class RequestDataRequest (
    /**
     * Security origin.
     */
    val securityOrigin : String,

    /**
     * Database name.
     */
    val databaseName : String,

    /**
     * Object store name.
     */
    val objectStoreName : String,

    /**
     * Index name, empty string for object store data requests.
     */
    val indexName : String,

    /**
     * Number of records to skip.
     */
    val skipCount : Int,

    /**
     * Number of records to fetch.
     */
    val pageSize : Int,

    /**
     * Key range.
     */
    val keyRange : KeyRange? = null

)

/**
 * Represents response frame for IndexedDB.requestData method call.
 *
 * Requests data from object store or index.
 */
data class RequestDataResponse(
  /**
   * Array of object store data entries.
   */
  val objectStoreDataEntries : List<DataEntry>,

  /**
   * If true, there are more entries to fetch in the given range.
   */
  val hasMore : Boolean

)

/**
 * Represents request frame that can be used with IndexedDB.clearObjectStore method call.
 *
 * Clears all entries from an object store.
 */
data class ClearObjectStoreRequest (
    /**
     * Security origin.
     */
    val securityOrigin : String,

    /**
     * Database name.
     */
    val databaseName : String,

    /**
     * Object store name.
     */
    val objectStoreName : String

)

/**
 * Represents request frame that can be used with IndexedDB.deleteDatabase method call.
 *
 * Deletes a database.
 */
data class DeleteDatabaseRequest (
    /**
     * Security origin.
     */
    val securityOrigin : String,

    /**
     * Database name.
     */
    val databaseName : String

)

