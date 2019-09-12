package pl.wendigo.chrome.domain.indexeddb

/**
 * Database with an array of object stores.
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
 */

data class DataEntry(
    /**  
     * Key object.  
     */  
    val key: pl.wendigo.chrome.domain.runtime.RemoteObject,

    /**  
     * Primary key object.  
     */  
    val primaryKey: pl.wendigo.chrome.domain.runtime.RemoteObject,

    /**  
     * Value object.  
     */  
    val value: pl.wendigo.chrome.domain.runtime.RemoteObject
)

/**
 * Key path.
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
