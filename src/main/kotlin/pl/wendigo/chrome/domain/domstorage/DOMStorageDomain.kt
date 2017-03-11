package pl.wendigo.chrome.domain.domstorage

/**
 * Query and modify DOM storage.
 */
@pl.wendigo.chrome.Experimental class DOMStorageDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * Enables storage tracking, storage events will now be delivered to the client.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMStorage.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables storage tracking, prevents storage events from being sent to the client.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMStorage.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun clear(input : ClearRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMStorage.clear", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun getDOMStorageItems(input : GetDOMStorageItemsRequest) : io.reactivex.Flowable<GetDOMStorageItemsResponse> {
        return connectionRemote.runAndCaptureResponse("DOMStorage.getDOMStorageItems", input, GetDOMStorageItemsResponse::class.java)
	}

	/**
	 * 
	 */
	  fun setDOMStorageItem(input : SetDOMStorageItemRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMStorage.setDOMStorageItem", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun removeDOMStorageItem(input : RemoveDOMStorageItemRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOMStorage.removeDOMStorageItem", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
    /**
     * Returns observable capturing all DOMStorage.domStorageItemsCleared events.
     */
    fun domStorageItemsCleared() : io.reactivex.Flowable<DomStorageItemsClearedEvent> {
        return connectionRemote.captureEvents("DOMStorage.domStorageItemsCleared", DomStorageItemsClearedEvent::class.java)
    }

    /**
     * Returns observable capturing all DOMStorage.domStorageItemRemoved events.
     */
    fun domStorageItemRemoved() : io.reactivex.Flowable<DomStorageItemRemovedEvent> {
        return connectionRemote.captureEvents("DOMStorage.domStorageItemRemoved", DomStorageItemRemovedEvent::class.java)
    }

    /**
     * Returns observable capturing all DOMStorage.domStorageItemAdded events.
     */
    fun domStorageItemAdded() : io.reactivex.Flowable<DomStorageItemAddedEvent> {
        return connectionRemote.captureEvents("DOMStorage.domStorageItemAdded", DomStorageItemAddedEvent::class.java)
    }

    /**
     * Returns observable capturing all DOMStorage.domStorageItemUpdated events.
     */
    fun domStorageItemUpdated() : io.reactivex.Flowable<DomStorageItemUpdatedEvent> {
        return connectionRemote.captureEvents("DOMStorage.domStorageItemUpdated", DomStorageItemUpdatedEvent::class.java)
    }

    /**
     * Returns flowable capturing all DOMStorage domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "DOMStorage"
        }
    }
}




/**
 * Represents requestFrame parameters that can be used with DOMStorage.clear method call.
 *
 * 
 */
data class ClearRequest (
    /**
     * 
     */
    val storageId : StorageId

)


/**
 * Represents requestFrame parameters that can be used with DOMStorage.getDOMStorageItems method call.
 *
 * 
 */
data class GetDOMStorageItemsRequest (
    /**
     * 
     */
    val storageId : StorageId

)

/**
 * Represents responseFrame from DOMStorage. method call.
 *
 * 
 */
data class GetDOMStorageItemsResponse(
  /**
   * 
   */
  val entries : Array<Item>

)

/**
 * Represents requestFrame parameters that can be used with DOMStorage.setDOMStorageItem method call.
 *
 * 
 */
data class SetDOMStorageItemRequest (
    /**
     * 
     */
    val storageId : StorageId,

    /**
     * 
     */
    val key : String,

    /**
     * 
     */
    val value : String

)


/**
 * Represents requestFrame parameters that can be used with DOMStorage.removeDOMStorageItem method call.
 *
 * 
 */
data class RemoveDOMStorageItemRequest (
    /**
     * 
     */
    val storageId : StorageId,

    /**
     * 
     */
    val key : String

)


/**
 * Represents responseFrame from DOMStorage. method call.
 *
 * 
 */
data class DomStorageItemsClearedEvent(
  /**
   * 
   */
  val storageId : StorageId

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOMStorage", name = "domStorageItemsCleared")

/**
 * Represents responseFrame from DOMStorage. method call.
 *
 * 
 */
data class DomStorageItemRemovedEvent(
  /**
   * 
   */
  val storageId : StorageId,

  /**
   * 
   */
  val key : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOMStorage", name = "domStorageItemRemoved")

/**
 * Represents responseFrame from DOMStorage. method call.
 *
 * 
 */
data class DomStorageItemAddedEvent(
  /**
   * 
   */
  val storageId : StorageId,

  /**
   * 
   */
  val key : String,

  /**
   * 
   */
  val newValue : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOMStorage", name = "domStorageItemAdded")

/**
 * Represents responseFrame from DOMStorage. method call.
 *
 * 
 */
data class DomStorageItemUpdatedEvent(
  /**
   * 
   */
  val storageId : StorageId,

  /**
   * 
   */
  val key : String,

  /**
   * 
   */
  val oldValue : String,

  /**
   * 
   */
  val newValue : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOMStorage", name = "domStorageItemUpdated")

