package pl.wendigo.chrome.domain.database

/**
 * DatabaseDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.Experimental class DatabaseDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * Enables database tracking, database events will now be delivered to the client.
	 */
	  fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Database.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables database tracking, prevents database events from being sent to the client.
	 */
	  fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Database.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun getDatabaseTableNames(input : GetDatabaseTableNamesRequest) : io.reactivex.Single<GetDatabaseTableNamesResponse> {
        return connectionRemote.runAndCaptureResponse("Database.getDatabaseTableNames", input, GetDatabaseTableNamesResponse::class.java)
	}

	/**
	 * 
	 */
	  fun executeSQL(input : ExecuteSQLRequest) : io.reactivex.Single<ExecuteSQLResponse> {
        return connectionRemote.runAndCaptureResponse("Database.executeSQL", input, ExecuteSQLResponse::class.java)
	}

  
    /**
     * Returns observable capturing all Database.addDatabase events.
     */
    fun addDatabase() : io.reactivex.Flowable<AddDatabaseEvent> {
        return connectionRemote.captureEvents("Database.addDatabase", AddDatabaseEvent::class.java)
    }

    /**
     * Returns flowable capturing all Database domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "Database"
        }
    }
}




/**
 * Represents requestFrame parameters that can be used with Database.getDatabaseTableNames method call.
 *
 * 
 */
data class GetDatabaseTableNamesRequest (
    /**
     * 
     */
    val databaseId : DatabaseId

)

/**
 * Represents responseFrame from Database. method call.
 *
 * 
 */
data class GetDatabaseTableNamesResponse(
  /**
   * 
   */
  val tableNames : Array<String>

)

/**
 * Represents requestFrame parameters that can be used with Database.executeSQL method call.
 *
 * 
 */
data class ExecuteSQLRequest (
    /**
     * 
     */
    val databaseId : DatabaseId,

    /**
     * 
     */
    val query : String

)

/**
 * Represents responseFrame from Database. method call.
 *
 * 
 */
data class ExecuteSQLResponse(
  /**
   * 
   */
  val columnNames : Array<String>? = null,

  /**
   * 
   */
  val values : Array<Any>? = null,

  /**
   * 
   */
  val sqlError : Error? = null

)

/**
 * Represents responseFrame from Database. method call.
 *
 * 
 */
data class AddDatabaseEvent(
  /**
   * 
   */
  val database : Database

) : pl.wendigo.chrome.ProtocolEvent(domain = "Database", name = "addDatabase")

