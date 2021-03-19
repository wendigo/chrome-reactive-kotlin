package pl.wendigo.chrome.api.database

import kotlinx.serialization.json.Json

/**
 * DatabaseOperations represents Database protocol domain request/response operations and events that can be captured.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [Database](https://chromedevtools.github.io/devtools-protocol/tot/Database) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class DatabaseOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Disables database tracking, prevents database events from being sent to the client.
     *
     * @link Protocol [Database#disable](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-disable) method documentation.
     */
    fun disable() = connection.request("Database.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables database tracking, database events will now be delivered to the client.
     *
     * @link Protocol [Database#enable](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-enable) method documentation.
     */
    fun enable() = connection.request("Database.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [Database#executeSQL](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-executeSQL) method documentation.
     */
    fun executeSQL(input: ExecuteSQLRequest) = connection.request("Database.executeSQL", Json.encodeToJsonElement(ExecuteSQLRequest.serializer(), input), ExecuteSQLResponse.serializer())

    /**
     *
     *
     * @link Protocol [Database#getDatabaseTableNames](https://chromedevtools.github.io/devtools-protocol/tot/Database#method-getDatabaseTableNames) method documentation.
     */
    fun getDatabaseTableNames(input: GetDatabaseTableNamesRequest) = connection.request("Database.getDatabaseTableNames", Json.encodeToJsonElement(GetDatabaseTableNamesRequest.serializer(), input), GetDatabaseTableNamesResponse.serializer())

    /**
     *  Returns observable capturing all Database.addDatabase events.
     */
    fun addDatabase(): io.reactivex.rxjava3.core.Flowable<AddDatabaseEvent> = connection.events("Database.addDatabase", AddDatabaseEvent.serializer())

    /**
     * Returns flowable capturing all Database domains events.
     */
    fun events(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
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
@kotlinx.serialization.Serializable
data class ExecuteSQLRequest(
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
@kotlinx.serialization.Serializable
data class ExecuteSQLResponse(
    /**  
     *  
     */  
    val columnNames: List<String>? = null,

    /**  
     *  
     */  
    val values: List<kotlinx.serialization.json.JsonElement>? = null,

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
@kotlinx.serialization.Serializable
data class GetDatabaseTableNamesRequest(
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
@kotlinx.serialization.Serializable
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
@kotlinx.serialization.Serializable
data class AddDatabaseEvent(
    /**  
     *  
     */  
    val database: Database

) : pl.wendigo.chrome.protocol.Event(domainName = "Database", domainEventName = "addDatabase")
