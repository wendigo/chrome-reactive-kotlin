package pl.wendigo.chrome.api.database

/**
 * DatabaseOperations represents Database protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Database](https://chromedevtools.github.io/devtools-protocol/tot/Database) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class DatabaseOperations internal constructor(private val connection : pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables database tracking, prevents database events from being sent to the client.
     *
     * @link Protocol [Database#disable](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-disable) method documentation.
     */
        fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Database.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     * Enables database tracking, database events will now be delivered to the client.
     *
     * @link Protocol [Database#enable](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-enable) method documentation.
     */
        fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("Database.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)


    /**
     *
     *
     * @link Protocol [Database#executeSQL](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-executeSQL) method documentation.
     */
        fun executeSQL(input: ExecuteSQLRequest): io.reactivex.Single<ExecuteSQLResponse> = connection.runAndCaptureResponse("Database.executeSQL", input, ExecuteSQLResponse::class.java)


    /**
     *
     *
     * @link Protocol [Database#getDatabaseTableNames](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-getDatabaseTableNames) method documentation.
     */
        fun getDatabaseTableNames(input: GetDatabaseTableNamesRequest): io.reactivex.Single<GetDatabaseTableNamesResponse> = connection.runAndCaptureResponse("Database.getDatabaseTableNames", input, GetDatabaseTableNamesResponse::class.java)


    /**
     *  Returns observable capturing all Database.addDatabase events.
     */
    fun addDatabase(): io.reactivex.Flowable<AddDatabaseEvent> = connection.captureEvents("Database.addDatabase", AddDatabaseEvent::class.java);


    /**
     * Returns flowable capturing all Database domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "Database"
        }
    }
}




/**
 * Represents request frame that can be used with [Database#executeSQL](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-executeSQL) operation call.
 *
 *
 * @link [Database#executeSQL](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-executeSQL) method documentation.
 * @see [DatabaseOperations.executeSQL]
 */
data class ExecuteSQLRequest (
    /**
     *
     */
    val databaseId: DatabaseId,

    /**
     *
     */
    val query: String

)
/**
 * Represents response frame that is returned from [Database#executeSQL](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-executeSQL) operation call.
 *
 *
  
  * @link [Database#executeSQL](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-executeSQL) method documentation.
  * @see [DatabaseOperations.executeSQL]
 */
data class ExecuteSQLResponse(
  /**
   *
   */
  val columnNames: List<String>? = null,

  /**
   *
   */
  val values: List<Any>? = null,

  /**
   *
   */
  val sqlError: Error? = null

)

/**
 * Represents request frame that can be used with [Database#getDatabaseTableNames](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-getDatabaseTableNames) operation call.
 *
 *
 * @link [Database#getDatabaseTableNames](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-getDatabaseTableNames) method documentation.
 * @see [DatabaseOperations.getDatabaseTableNames]
 */
data class GetDatabaseTableNamesRequest (
    /**
     *
     */
    val databaseId: DatabaseId

)
/**
 * Represents response frame that is returned from [Database#getDatabaseTableNames](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-getDatabaseTableNames) operation call.
 *
 *
  
  * @link [Database#getDatabaseTableNames](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-getDatabaseTableNames) method documentation.
  * @see [DatabaseOperations.getDatabaseTableNames]
 */
data class GetDatabaseTableNamesResponse(
  /**
   *
   */
  val tableNames: List<String>

)

/**
 *
 *
 * @link [Database#addDatabase](https://chromedevtools.github.io/devtools-protocol/tot/Database#event-addDatabase) event documentation.
   */
data class AddDatabaseEvent(
  /**
   *
   */
  val database: Database

): pl.wendigo.chrome.protocol.Event(domain = "Database", name = "addDatabase")

