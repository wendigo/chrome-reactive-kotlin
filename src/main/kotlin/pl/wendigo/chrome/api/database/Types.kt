package pl.wendigo.chrome.api.database

/**
 * Unique identifier of Database object.
 *
 * @link [Database#DatabaseId](https://chromedevtools.github.io/devtools-protocol/tot/Database#type-DatabaseId) type documentation.
 */

typealias DatabaseId = String

/**
 * Database object.
 *
 * @link [Database#Database](https://chromedevtools.github.io/devtools-protocol/tot/Database#type-Database) type documentation.
 */

data class Database(
  /**
   * Database ID.
   */
  val id: DatabaseId,

  /**
   * Database domain.
   */
  val domain: String,

  /**
   * Database name.
   */
  val name: String,

  /**
   * Database version.
   */
  val version: String
)

/**
 * Database error.
 *
 * @link [Database#Error](https://chromedevtools.github.io/devtools-protocol/tot/Database#type-Error) type documentation.
 */

data class Error(
  /**
   * Error message.
   */
  val message: String,

  /**
   * Error code.
   */
  val code: Int
)

