package pl.wendigo.chrome.api.indexeddb

/**
 * Database with an array of object stores.
 *
 * @link [IndexedDB#DatabaseWithObjectStores](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-DatabaseWithObjectStores) type documentation.
 */

data class DatabaseWithObjectStores(
  /**
   * Database name.
   */
  val name: String,

  /**
   * Database version (type is not 'integer', as the standard
requires the version number to be 'unsigned long long')
   */
  val version: Double,

  /**
   * Object stores in this database.
   */
  val objectStores: List<ObjectStore>
)

/**
 * Object store.
 *
 * @link [IndexedDB#ObjectStore](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-ObjectStore) type documentation.
 */

data class ObjectStore(
  /**
   * Object store name.
   */
  val name: String,

  /**
   * Object store key path.
   */
  val keyPath: KeyPath,

  /**
   * If true, object store has auto increment flag set.
   */
  val autoIncrement: Boolean,

  /**
   * Indexes in this object store.
   */
  val indexes: List<ObjectStoreIndex>
)

/**
 * Object store index.
 *
 * @link [IndexedDB#ObjectStoreIndex](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-ObjectStoreIndex) type documentation.
 */

data class ObjectStoreIndex(
  /**
   * Index name.
   */
  val name: String,

  /**
   * Index key path.
   */
  val keyPath: KeyPath,

  /**
   * If true, index is unique.
   */
  val unique: Boolean,

  /**
   * If true, index allows multiple entries for a key.
   */
  val multiEntry: Boolean
)

/**
 * Key.
 *
 * @link [IndexedDB#Key](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-Key) type documentation.
 */

data class Key(
  /**
   * Key type.
   */
  val type: String,

  /**
   * Number value.
   */
  val number: Double? = null,

  /**
   * String value.
   */
  val string: String? = null,

  /**
   * Date value.
   */
  val date: Double? = null,

  /**
   * Array value.
   */
  val array: List<Key>? = null
)

/**
 * Key range.
 *
 * @link [IndexedDB#KeyRange](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-KeyRange) type documentation.
 */

data class KeyRange(
  /**
   * Lower bound.
   */
  val lower: Key? = null,

  /**
   * Upper bound.
   */
  val upper: Key? = null,

  /**
   * If true lower bound is open.
   */
  val lowerOpen: Boolean,

  /**
   * If true upper bound is open.
   */
  val upperOpen: Boolean
)

/**
 * Data entry.
 *
 * @link [IndexedDB#DataEntry](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-DataEntry) type documentation.
 */

data class DataEntry(
  /**
   * Key object.
   */
  val key: pl.wendigo.chrome.api.runtime.RemoteObject,

  /**
   * Primary key object.
   */
  val primaryKey: pl.wendigo.chrome.api.runtime.RemoteObject,

  /**
   * Value object.
   */
  val value: pl.wendigo.chrome.api.runtime.RemoteObject
)

/**
 * Key path.
 *
 * @link [IndexedDB#KeyPath](https://chromedevtools.github.io/devtools-protocol/tot/IndexedDB#type-KeyPath) type documentation.
 */

data class KeyPath(
  /**
   * Key path type.
   */
  val type: String,

  /**
   * String value.
   */
  val string: String? = null,

  /**
   * Array value.
   */
  val array: List<String>? = null
)

