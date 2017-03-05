package pl.wendigo.chrome.domain.database

/*
 * Unique identifier of Database object.
 */
typealias DatabaseId = String





/*
 * Database object.
 */




data class Database(
  /**
   * Database ID.
   */
  val id : DatabaseId,

  /**
   * Database domain.
   */
  val domain : String,

  /**
   * Database name.
   */
  val name : String,

  /**
   * Database version.
   */
  val version : String

)

/*
 * Database error.
 */




data class Error(
  /**
   * Error message.
   */
  val message : String,

  /**
   * Error code.
   */
  val code : Int

)

