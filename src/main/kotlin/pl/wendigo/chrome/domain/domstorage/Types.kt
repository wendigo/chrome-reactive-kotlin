package pl.wendigo.chrome.domain.domstorage

/**
 * DOM Storage identifier.
 */

data class StorageId(
  /**
   * Security origin for the storage.
   */
  val securityOrigin : String,

  /**
   * Whether the storage is local storage (not session storage).
   */
  val isLocalStorage : Boolean
)

/**
 * DOM Storage item.
 */

typealias Item = List<String>

