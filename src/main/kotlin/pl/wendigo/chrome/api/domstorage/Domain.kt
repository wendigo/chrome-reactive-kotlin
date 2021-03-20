package pl.wendigo.chrome.api.domstorage

import kotlinx.serialization.json.Json

/**
 * Query and modify DOM storage.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [DOMStorage](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class DOMStorageDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebSocketConnection) :
    pl.wendigo.chrome.protocol.Domain("DOMStorage", """Query and modify DOM storage.""", connection) {
    /**
     *
     *
     * @link Protocol [DOMStorage#clear](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-clear) method documentation.
     */
    
    fun clear(input: ClearRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMStorage.clear", Json.encodeToJsonElement(ClearRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Disables storage tracking, prevents storage events from being sent to the client.
     *
     * @link Protocol [DOMStorage#disable](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-disable) method documentation.
     */
    
    fun disable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMStorage.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables storage tracking, storage events will now be delivered to the client.
     *
     * @link Protocol [DOMStorage#enable](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-enable) method documentation.
     */
    
    fun enable(): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMStorage.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [DOMStorage#getDOMStorageItems](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-getDOMStorageItems) method documentation.
     */
    
    fun getDOMStorageItems(input: GetDOMStorageItemsRequest): io.reactivex.rxjava3.core.Single<GetDOMStorageItemsResponse> = connection.request("DOMStorage.getDOMStorageItems", Json.encodeToJsonElement(GetDOMStorageItemsRequest.serializer(), input), GetDOMStorageItemsResponse.serializer())

    /**
     *
     *
     * @link Protocol [DOMStorage#removeDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-removeDOMStorageItem) method documentation.
     */
    
    fun removeDOMStorageItem(input: RemoveDOMStorageItemRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMStorage.removeDOMStorageItem", Json.encodeToJsonElement(RemoveDOMStorageItemRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [DOMStorage#setDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-setDOMStorageItem) method documentation.
     */
    
    fun setDOMStorageItem(input: SetDOMStorageItemRequest): io.reactivex.rxjava3.core.Single<pl.wendigo.chrome.protocol.RequestResponseFrame> = connection.request("DOMStorage.setDOMStorageItem", Json.encodeToJsonElement(SetDOMStorageItemRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemAdded events.
     */
    fun domStorageItemAdded(): io.reactivex.rxjava3.core.Flowable<DomStorageItemAddedEvent> = connection.events("DOMStorage.domStorageItemAdded", DomStorageItemAddedEvent.serializer())

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemRemoved events.
     */
    fun domStorageItemRemoved(): io.reactivex.rxjava3.core.Flowable<DomStorageItemRemovedEvent> = connection.events("DOMStorage.domStorageItemRemoved", DomStorageItemRemovedEvent.serializer())

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemUpdated events.
     */
    fun domStorageItemUpdated(): io.reactivex.rxjava3.core.Flowable<DomStorageItemUpdatedEvent> = connection.events("DOMStorage.domStorageItemUpdated", DomStorageItemUpdatedEvent.serializer())

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemsCleared events.
     */
    fun domStorageItemsCleared(): io.reactivex.rxjava3.core.Flowable<DomStorageItemsClearedEvent> = connection.events("DOMStorage.domStorageItemsCleared", DomStorageItemsClearedEvent.serializer())
}

/**
 * Represents request frame that can be used with [DOMStorage#clear](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-clear) operation call.
 *
 *
 * @link [DOMStorage#clear](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-clear) method documentation.
 * @see [DOMStorageDomain.clear]
 */
@kotlinx.serialization.Serializable
data class ClearRequest(
    /**
     *
     */
    val storageId: StorageId

)

/**
 * Represents request frame that can be used with [DOMStorage#getDOMStorageItems](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-getDOMStorageItems) operation call.
 *
 *
 * @link [DOMStorage#getDOMStorageItems](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-getDOMStorageItems) method documentation.
 * @see [DOMStorageDomain.getDOMStorageItems]
 */
@kotlinx.serialization.Serializable
data class GetDOMStorageItemsRequest(
    /**
     *
     */
    val storageId: StorageId

)

/**
 * Represents response frame that is returned from [DOMStorage#getDOMStorageItems](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-getDOMStorageItems) operation call.
 *
 *
  
 * @link [DOMStorage#getDOMStorageItems](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-getDOMStorageItems) method documentation.
 * @see [DOMStorageDomain.getDOMStorageItems]
 */
@kotlinx.serialization.Serializable
data class GetDOMStorageItemsResponse(
    /**  
     *  
     */  
    val entries: List<Item>

)

/**
 * Represents request frame that can be used with [DOMStorage#removeDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-removeDOMStorageItem) operation call.
 *
 *
 * @link [DOMStorage#removeDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-removeDOMStorageItem) method documentation.
 * @see [DOMStorageDomain.removeDOMStorageItem]
 */
@kotlinx.serialization.Serializable
data class RemoveDOMStorageItemRequest(
    /**
     *
     */
    val storageId: StorageId,

    /**
     *
     */
    val key: String

)

/**
 * Represents request frame that can be used with [DOMStorage#setDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-setDOMStorageItem) operation call.
 *
 *
 * @link [DOMStorage#setDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-setDOMStorageItem) method documentation.
 * @see [DOMStorageDomain.setDOMStorageItem]
 */
@kotlinx.serialization.Serializable
data class SetDOMStorageItemRequest(
    /**
     *
     */
    val storageId: StorageId,

    /**
     *
     */
    val key: String,

    /**
     *
     */
    val value: String

)

/**
 *
 *
 * @link [DOMStorage#domStorageItemAdded](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class DomStorageItemAddedEvent(
    /**  
     *  
     */  
    val storageId: StorageId,

    /**  
     *  
     */  
    val key: String,

    /**  
     *  
     */  
    val newValue: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "DOMStorage" 
    override fun eventName() = "domStorageItemAdded"
} 

/**
 *
 *
 * @link [DOMStorage#domStorageItemRemoved](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemRemoved) event documentation.
 */
@kotlinx.serialization.Serializable
data class DomStorageItemRemovedEvent(
    /**  
     *  
     */  
    val storageId: StorageId,

    /**  
     *  
     */  
    val key: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "DOMStorage" 
    override fun eventName() = "domStorageItemRemoved"
} 

/**
 *
 *
 * @link [DOMStorage#domStorageItemUpdated](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemUpdated) event documentation.
 */
@kotlinx.serialization.Serializable
data class DomStorageItemUpdatedEvent(
    /**  
     *  
     */  
    val storageId: StorageId,

    /**  
     *  
     */  
    val key: String,

    /**  
     *  
     */  
    val oldValue: String,

    /**  
     *  
     */  
    val newValue: String

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "DOMStorage" 
    override fun eventName() = "domStorageItemUpdated"
} 

/**
 *
 *
 * @link [DOMStorage#domStorageItemsCleared](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemsCleared) event documentation.
 */
@kotlinx.serialization.Serializable
data class DomStorageItemsClearedEvent(
    /**  
     *  
     */  
    val storageId: StorageId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "DOMStorage" 
    override fun eventName() = "domStorageItemsCleared"
} 
