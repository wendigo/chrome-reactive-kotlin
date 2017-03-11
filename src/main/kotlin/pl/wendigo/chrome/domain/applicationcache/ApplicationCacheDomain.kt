package pl.wendigo.chrome.domain.applicationcache

/**
 * ApplicationCacheDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class ApplicationCacheDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * Returns array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
	 */
	  fun getFramesWithManifests() : io.reactivex.Flowable<GetFramesWithManifestsResponse> {
        return connectionRemote.runAndCaptureResponse("ApplicationCache.getFramesWithManifests", null, GetFramesWithManifestsResponse::class.java)
	}

	/**
	 * Enables application cache domain notifications.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ApplicationCache.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns manifest URL for document in the given frame.
	 */
	  fun getManifestForFrame(input : GetManifestForFrameRequest) : io.reactivex.Flowable<GetManifestForFrameResponse> {
        return connectionRemote.runAndCaptureResponse("ApplicationCache.getManifestForFrame", input, GetManifestForFrameResponse::class.java)
	}

	/**
	 * Returns relevant application cache data for the document in given frame.
	 */
	  fun getApplicationCacheForFrame(input : GetApplicationCacheForFrameRequest) : io.reactivex.Flowable<GetApplicationCacheForFrameResponse> {
        return connectionRemote.runAndCaptureResponse("ApplicationCache.getApplicationCacheForFrame", input, GetApplicationCacheForFrameResponse::class.java)
	}

  
    /**
     * Returns observable capturing all ApplicationCache.applicationCacheStatusUpdated events.
     */
    fun applicationCacheStatusUpdated() : io.reactivex.Flowable<ApplicationCacheStatusUpdatedEvent> {
        return connectionRemote.captureEvents("ApplicationCache.applicationCacheStatusUpdated", ApplicationCacheStatusUpdatedEvent::class.java)
    }

    /**
     * Returns observable capturing all ApplicationCache.networkStateUpdated events.
     */
    fun networkStateUpdated() : io.reactivex.Flowable<NetworkStateUpdatedEvent> {
        return connectionRemote.captureEvents("ApplicationCache.networkStateUpdated", NetworkStateUpdatedEvent::class.java)
    }

    /**
     * Returns flowable capturing all ApplicationCache domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "ApplicationCache"
        }
    }
}

/**
 * Represents responseFrame from ApplicationCache. method call.
 *
 * Returns array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
 */
data class GetFramesWithManifestsResponse(
  /**
   * Array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
   */
  val frameIds : Array<FrameWithManifest>

)



/**
 * Represents requestFrame parameters that can be used with ApplicationCache.getManifestForFrame method call.
 *
 * Returns manifest URL for document in the given frame.
 */
data class GetManifestForFrameRequest (
    /**
     * Identifier of the frame containing document whose manifest is retrieved.
     */
    val frameId : pl.wendigo.chrome.domain.page.FrameId

)

/**
 * Represents responseFrame from ApplicationCache. method call.
 *
 * Returns manifest URL for document in the given frame.
 */
data class GetManifestForFrameResponse(
  /**
   * Manifest URL for document in the given frame.
   */
  val manifestURL : String

)

/**
 * Represents requestFrame parameters that can be used with ApplicationCache.getApplicationCacheForFrame method call.
 *
 * Returns relevant application cache data for the document in given frame.
 */
data class GetApplicationCacheForFrameRequest (
    /**
     * Identifier of the frame containing document whose application cache is retrieved.
     */
    val frameId : pl.wendigo.chrome.domain.page.FrameId

)

/**
 * Represents responseFrame from ApplicationCache. method call.
 *
 * Returns relevant application cache data for the document in given frame.
 */
data class GetApplicationCacheForFrameResponse(
  /**
   * Relevant application cache data for the document in given frame.
   */
  val applicationCache : ApplicationCache

)

/**
 * Represents responseFrame from ApplicationCache. method call.
 *
 * 
 */
data class ApplicationCacheStatusUpdatedEvent(
  /**
   * Identifier of the frame containing document whose application cache updated status.
   */
  val frameId : pl.wendigo.chrome.domain.page.FrameId,

  /**
   * Manifest URL.
   */
  val manifestURL : String,

  /**
   * Updated application cache status.
   */
  val status : Int

) : pl.wendigo.chrome.ProtocolEvent(domain = "ApplicationCache", name = "applicationCacheStatusUpdated")

/**
 * Represents responseFrame from ApplicationCache. method call.
 *
 * 
 */
data class NetworkStateUpdatedEvent(
  /**
   * 
   */
  val isNowOnline : Boolean

) : pl.wendigo.chrome.ProtocolEvent(domain = "ApplicationCache", name = "networkStateUpdated")

