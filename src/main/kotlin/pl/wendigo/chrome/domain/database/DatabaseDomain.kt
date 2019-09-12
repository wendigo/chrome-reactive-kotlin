package pl.wendigo.chrome.domain.database

/**
 * DatabaseDomain represents remote debugger protocol domain.
 */
class DatabaseDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Disables database tracking, prevents database events from being sent to the client.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Database.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables database tracking, database events will now be delivered to the client.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Database.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun executeSQL(input: ExecuteSQLRequest): io.reactivex.Single<ExecuteSQLResponse> {
        return connectionRemote.runAndCaptureResponse("Database.executeSQL", input, ExecuteSQLResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun getDatabaseTableNames(input: GetDatabaseTableNamesRequest): io.reactivex.Single<GetDatabaseTableNamesResponse> {
        return connectionRemote.runAndCaptureResponse("Database.getDatabaseTableNames", input, GetDatabaseTableNamesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Database.addDatabase events.
     */
    fun addDatabase(): io.reactivex.Flowable<AddDatabaseEvent> {
        return addDatabaseTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Database.addDatabase events.
     */
    fun addDatabaseTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AddDatabaseEvent>> {
        return connectionRemote.captureEvents("Database.addDatabase", AddDatabaseEvent::class.java)
    }

    /**
     * Returns flowable capturing all Database domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Database"
        }
    }
}

/**
 * Represents request frame that can be used with Database.executeSQL method call.
 *
 *
 */
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
 * Represents response frame for Database.executeSQL method call.
 *
 *
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
 * Represents request frame that can be used with Database.getDatabaseTableNames method call.
 *
 *
 */
data class GetDatabaseTableNamesRequest(
    /**
     *
     */
    val databaseId: DatabaseId

)

/**
 * Represents response frame for Database.getDatabaseTableNames method call.
 *
 *
 */
data class GetDatabaseTableNamesResponse(
    /**  
     *  
     */  
    val tableNames: List<String>

)

/**
 * Represents event frames for Database.addDatabase
 *
 *
 */
data class AddDatabaseEvent(
    /**  
     *  
     */  
    val database: Database

) : pl.wendigo.chrome.ProtocolEvent(domain = "Database", name = "addDatabase")
