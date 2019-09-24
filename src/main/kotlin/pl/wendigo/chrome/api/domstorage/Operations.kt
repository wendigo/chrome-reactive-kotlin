package pl.wendigo.chrome.api.domstorage

/**
 * Query and modify DOM storage.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [DOMStorage](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class DOMStorageOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     *
     *
     * @link Protocol [DOMStorage#clear](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-clear) method documentation.
     */
    fun clear(input: ClearRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("DOMStorage.clear", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disables storage tracking, prevents storage events from being sent to the client.
     *
     * @link Protocol [DOMStorage#disable](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("DOMStorage.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables storage tracking, storage events will now be delivered to the client.
     *
     * @link Protocol [DOMStorage#enable](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-enable) method documentation.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("DOMStorage.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [DOMStorage#getDOMStorageItems](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-getDOMStorageItems) method documentation.
     */
    fun getDOMStorageItems(input: GetDOMStorageItemsRequest): io.reactivex.Single<GetDOMStorageItemsResponse> = connection.runAndCaptureResponse("DOMStorage.getDOMStorageItems", input, GetDOMStorageItemsResponse::class.java)

    /**
     *
     *
     * @link Protocol [DOMStorage#removeDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-removeDOMStorageItem) method documentation.
     */
    fun removeDOMStorageItem(input: RemoveDOMStorageItemRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("DOMStorage.removeDOMStorageItem", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [DOMStorage#setDOMStorageItem](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-setDOMStorageItem) method documentation.
     */
    fun setDOMStorageItem(input: SetDOMStorageItemRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> = connection.runAndCaptureResponse("DOMStorage.setDOMStorageItem", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemAdded events.
     */
    fun domStorageItemAdded(): io.reactivex.Flowable<DomStorageItemAddedEvent> = connection.captureEvents("DOMStorage.domStorageItemAdded", DomStorageItemAddedEvent::class.java)

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemRemoved events.
     */
    fun domStorageItemRemoved(): io.reactivex.Flowable<DomStorageItemRemovedEvent> = connection.captureEvents("DOMStorage.domStorageItemRemoved", DomStorageItemRemovedEvent::class.java)

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemUpdated events.
     */
    fun domStorageItemUpdated(): io.reactivex.Flowable<DomStorageItemUpdatedEvent> = connection.captureEvents("DOMStorage.domStorageItemUpdated", DomStorageItemUpdatedEvent::class.java)

    /**
     *  Returns observable capturing all DOMStorage.domStorageItemsCleared events.
     */
    fun domStorageItemsCleared(): io.reactivex.Flowable<DomStorageItemsClearedEvent> = connection.captureEvents("DOMStorage.domStorageItemsCleared", DomStorageItemsClearedEvent::class.java)

    /**
     * Returns flowable capturing all DOMStorage domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().filter {
            it.protocolDomain() == "DOMStorage"
        }
    }
}
/**
 * Represents request frame that can be used with [DOMStorage#clear](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-clear) operation call.
 *
 *
 * @link [DOMStorage#clear](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#method-clear) method documentation.
 * @see [DOMStorageOperations.clear]
 */
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
 * @see [DOMStorageOperations.getDOMStorageItems]
 */
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
 * @see [DOMStorageOperations.getDOMStorageItems]
 */
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
 * @see [DOMStorageOperations.removeDOMStorageItem]
 */
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
 * @see [DOMStorageOperations.setDOMStorageItem]
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "DOMStorage", name = "domStorageItemAdded")

/**
 *
 *
 * @link [DOMStorage#domStorageItemRemoved](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemRemoved) event documentation.
 */
data class DomStorageItemRemovedEvent(
    /**  
     *  
     */  
    val storageId: StorageId,

    /**  
     *  
     */  
    val key: String

) : pl.wendigo.chrome.protocol.Event(domain = "DOMStorage", name = "domStorageItemRemoved")

/**
 *
 *
 * @link [DOMStorage#domStorageItemUpdated](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemUpdated) event documentation.
 */
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

) : pl.wendigo.chrome.protocol.Event(domain = "DOMStorage", name = "domStorageItemUpdated")

/**
 *
 *
 * @link [DOMStorage#domStorageItemsCleared](https://chromedevtools.github.io/devtools-protocol/tot/DOMStorage#event-domStorageItemsCleared) event documentation.
 */
data class DomStorageItemsClearedEvent(
    /**  
     *  
     */  
    val storageId: StorageId

) : pl.wendigo.chrome.protocol.Event(domain = "DOMStorage", name = "domStorageItemsCleared")
