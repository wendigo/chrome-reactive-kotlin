package pl.wendigo.chrome.domain.page

/**
 * Actions and events related to the inspected page belong to the page domain.
 */
class PageDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Enables page domain notifications.
     */
    fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables page domain notifications.
     */
    fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
     */
    fun addScriptToEvaluateOnLoad(input : AddScriptToEvaluateOnLoadRequest) : io.reactivex.Single<AddScriptToEvaluateOnLoadResponse> {
        return connectionRemote.runAndCaptureResponse("Page.addScriptToEvaluateOnLoad", input, AddScriptToEvaluateOnLoadResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
     */
    fun removeScriptToEvaluateOnLoad(input : RemoveScriptToEvaluateOnLoadRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.removeScriptToEvaluateOnLoad", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Evaluates given script in every frame upon creation (before loading frame's scripts).
     */
    fun addScriptToEvaluateOnNewDocument(input : AddScriptToEvaluateOnNewDocumentRequest) : io.reactivex.Single<AddScriptToEvaluateOnNewDocumentResponse> {
        return connectionRemote.runAndCaptureResponse("Page.addScriptToEvaluateOnNewDocument", input, AddScriptToEvaluateOnNewDocumentResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Removes given script from the list.
     */
    fun removeScriptToEvaluateOnNewDocument(input : RemoveScriptToEvaluateOnNewDocumentRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.removeScriptToEvaluateOnNewDocument", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Controls whether browser will open a new inspector window for connected pages.
     */
    fun setAutoAttachToCreatedPages(input : SetAutoAttachToCreatedPagesRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setAutoAttachToCreatedPages", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Reloads given page optionally ignoring the cache.
     */
    fun reload(input : ReloadRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.reload", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Navigates current page to the given URL.
     */
    fun navigate(input : NavigateRequest) : io.reactivex.Single<NavigateResponse> {
        return connectionRemote.runAndCaptureResponse("Page.navigate", input, NavigateResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Force the page stop all navigations and pending resource fetches.
     */
    fun stopLoading() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.stopLoading", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns navigation history for the current page.
     */
    fun getNavigationHistory() : io.reactivex.Single<GetNavigationHistoryResponse> {
        return connectionRemote.runAndCaptureResponse("Page.getNavigationHistory", null, GetNavigationHistoryResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Navigates current page to the given history entry.
     */
    fun navigateToHistoryEntry(input : NavigateToHistoryEntryRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.navigateToHistoryEntry", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the <code>cookies</code> field.
     */
    fun getCookies() : io.reactivex.Single<GetCookiesResponse> {
        return connectionRemote.runAndCaptureResponse("Page.getCookies", null, GetCookiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Deletes browser cookie with given name, domain and path.
     */
    fun deleteCookie(input : DeleteCookieRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.deleteCookie", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns present frame / resource tree structure.
     */
    fun getResourceTree() : io.reactivex.Single<GetResourceTreeResponse> {
        return connectionRemote.runAndCaptureResponse("Page.getResourceTree", null, GetResourceTreeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns content of the given resource.
     */
    fun getResourceContent(input : GetResourceContentRequest) : io.reactivex.Single<GetResourceContentResponse> {
        return connectionRemote.runAndCaptureResponse("Page.getResourceContent", input, GetResourceContentResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Searches for given string in resource content.
     */
    fun searchInResource(input : SearchInResourceRequest) : io.reactivex.Single<SearchInResourceResponse> {
        return connectionRemote.runAndCaptureResponse("Page.searchInResource", input, SearchInResourceResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sets given markup as the document's HTML.
     */
    fun setDocumentContent(input : SetDocumentContentRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setDocumentContent", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
     */
    fun setDeviceMetricsOverride(input : SetDeviceMetricsOverrideRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setDeviceMetricsOverride", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears the overriden device metrics.
     */
    fun clearDeviceMetricsOverride() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.clearDeviceMetricsOverride", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
     */
    fun setGeolocationOverride(input : SetGeolocationOverrideRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setGeolocationOverride", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears the overriden Geolocation Position and Error.
     */
    fun clearGeolocationOverride() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.clearGeolocationOverride", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the Device Orientation.
     */
    fun setDeviceOrientationOverride(input : SetDeviceOrientationOverrideRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setDeviceOrientationOverride", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears the overridden Device Orientation.
     */
    fun clearDeviceOrientationOverride() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.clearDeviceOrientationOverride", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Toggles mouse event-based touch event emulation.
     */
    fun setTouchEmulationEnabled(input : SetTouchEmulationEnabledRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setTouchEmulationEnabled", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Capture page screenshot.
     */
    fun captureScreenshot(input : CaptureScreenshotRequest) : io.reactivex.Single<CaptureScreenshotResponse> {
        return connectionRemote.runAndCaptureResponse("Page.captureScreenshot", input, CaptureScreenshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Print page as PDF.
     */
    fun printToPDF(input : PrintToPDFRequest) : io.reactivex.Single<PrintToPDFResponse> {
        return connectionRemote.runAndCaptureResponse("Page.printToPDF", input, PrintToPDFResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Starts sending each frame using the <code>screencastFrame</code> event.
     */
    fun startScreencast(input : StartScreencastRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.startScreencast", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stops sending each frame in the <code>screencastFrame</code>.
     */
    fun stopScreencast() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.stopScreencast", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Acknowledges that a screencast frame has been received by the frontend.
     */
    fun screencastFrameAck(input : ScreencastFrameAckRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.screencastFrameAck", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
     */
    fun handleJavaScriptDialog(input : HandleJavaScriptDialogRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.handleJavaScriptDialog", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun getAppManifest() : io.reactivex.Single<GetAppManifestResponse> {
        return connectionRemote.runAndCaptureResponse("Page.getAppManifest", null, GetAppManifestResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun requestAppBanner() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.requestAppBanner", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Toggles navigation throttling which allows programatic control over navigation and redirect response.
     */
    fun setControlNavigations(input : SetControlNavigationsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.setControlNavigations", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Should be sent in response to a navigationRequested or a redirectRequested event, telling the browser how to handle the navigation.
     */
    fun processNavigation(input : ProcessNavigationRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Page.processNavigation", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
     */
    fun getLayoutMetrics() : io.reactivex.Single<GetLayoutMetricsResponse> {
        return connectionRemote.runAndCaptureResponse("Page.getLayoutMetrics", null, GetLayoutMetricsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Creates an isolated world for the given frame.
     */
    fun createIsolatedWorld(input : CreateIsolatedWorldRequest) : io.reactivex.Single<CreateIsolatedWorldResponse> {
        return connectionRemote.runAndCaptureResponse("Page.createIsolatedWorld", input, CreateIsolatedWorldResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.domContentEventFired events.
     */
    fun domContentEventFired() : io.reactivex.Flowable<DomContentEventFiredEvent> {
        return domContentEventFiredTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.domContentEventFired events.
     */
    fun domContentEventFiredTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<DomContentEventFiredEvent>> {
        return connectionRemote.captureEvents("Page.domContentEventFired", DomContentEventFiredEvent::class.java)
    }

    /**
     * Returns observable capturing all Page.loadEventFired events.
     */
    fun loadEventFired() : io.reactivex.Flowable<LoadEventFiredEvent> {
        return loadEventFiredTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.loadEventFired events.
     */
    fun loadEventFiredTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<LoadEventFiredEvent>> {
        return connectionRemote.captureEvents("Page.loadEventFired", LoadEventFiredEvent::class.java)
    }

    /**
     * Fired when frame has been attached to its parent.
     */
    fun frameAttached() : io.reactivex.Flowable<FrameAttachedEvent> {
        return frameAttachedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has been attached to its parent.
     */
    fun frameAttachedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameAttachedEvent>> {
        return connectionRemote.captureEvents("Page.frameAttached", FrameAttachedEvent::class.java)
    }

    /**
     * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
     */
    fun frameNavigated() : io.reactivex.Flowable<FrameNavigatedEvent> {
        return frameNavigatedTimed().map {
            it.value()
        }
    }

    /**
     * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
     */
    fun frameNavigatedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameNavigatedEvent>> {
        return connectionRemote.captureEvents("Page.frameNavigated", FrameNavigatedEvent::class.java)
    }

    /**
     * Fired when frame has been detached from its parent.
     */
    fun frameDetached() : io.reactivex.Flowable<FrameDetachedEvent> {
        return frameDetachedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has been detached from its parent.
     */
    fun frameDetachedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameDetachedEvent>> {
        return connectionRemote.captureEvents("Page.frameDetached", FrameDetachedEvent::class.java)
    }

    /**
     * Fired when frame has started loading.
     */
    fun frameStartedLoading() : io.reactivex.Flowable<FrameStartedLoadingEvent> {
        return frameStartedLoadingTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has started loading.
     */
    fun frameStartedLoadingTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameStartedLoadingEvent>> {
        return connectionRemote.captureEvents("Page.frameStartedLoading", FrameStartedLoadingEvent::class.java)
    }

    /**
     * Fired when frame has stopped loading.
     */
    fun frameStoppedLoading() : io.reactivex.Flowable<FrameStoppedLoadingEvent> {
        return frameStoppedLoadingTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has stopped loading.
     */
    fun frameStoppedLoadingTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameStoppedLoadingEvent>> {
        return connectionRemote.captureEvents("Page.frameStoppedLoading", FrameStoppedLoadingEvent::class.java)
    }

    /**
     * Fired when frame schedules a potential navigation.
     */
    fun frameScheduledNavigation() : io.reactivex.Flowable<FrameScheduledNavigationEvent> {
        return frameScheduledNavigationTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame schedules a potential navigation.
     */
    fun frameScheduledNavigationTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameScheduledNavigationEvent>> {
        return connectionRemote.captureEvents("Page.frameScheduledNavigation", FrameScheduledNavigationEvent::class.java)
    }

    /**
     * Fired when frame no longer has a scheduled navigation.
     */
    fun frameClearedScheduledNavigation() : io.reactivex.Flowable<FrameClearedScheduledNavigationEvent> {
        return frameClearedScheduledNavigationTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame no longer has a scheduled navigation.
     */
    fun frameClearedScheduledNavigationTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameClearedScheduledNavigationEvent>> {
        return connectionRemote.captureEvents("Page.frameClearedScheduledNavigation", FrameClearedScheduledNavigationEvent::class.java)
    }

    /**
     * Returns observable capturing all Page.frameResized events.
     */
    fun frameResized() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return frameResizedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.frameResized events.
     */
    fun frameResizedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Page.frameResized", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
     */
    fun javascriptDialogOpening() : io.reactivex.Flowable<JavascriptDialogOpeningEvent> {
        return javascriptDialogOpeningTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
     */
    fun javascriptDialogOpeningTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<JavascriptDialogOpeningEvent>> {
        return connectionRemote.captureEvents("Page.javascriptDialogOpening", JavascriptDialogOpeningEvent::class.java)
    }

    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
     */
    fun javascriptDialogClosed() : io.reactivex.Flowable<JavascriptDialogClosedEvent> {
        return javascriptDialogClosedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
     */
    fun javascriptDialogClosedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<JavascriptDialogClosedEvent>> {
        return connectionRemote.captureEvents("Page.javascriptDialogClosed", JavascriptDialogClosedEvent::class.java)
    }

    /**
     * Compressed image data requested by the <code>startScreencast</code>.
     */
    fun screencastFrame() : io.reactivex.Flowable<ScreencastFrameEvent> {
        return screencastFrameTimed().map {
            it.value()
        }
    }

    /**
     * Compressed image data requested by the <code>startScreencast</code>.
     */
    fun screencastFrameTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ScreencastFrameEvent>> {
        return connectionRemote.captureEvents("Page.screencastFrame", ScreencastFrameEvent::class.java)
    }

    /**
     * Fired when the page with currently enabled screencast was shown or hidden </code>.
     */
    fun screencastVisibilityChanged() : io.reactivex.Flowable<ScreencastVisibilityChangedEvent> {
        return screencastVisibilityChangedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when the page with currently enabled screencast was shown or hidden </code>.
     */
    fun screencastVisibilityChangedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<ScreencastVisibilityChangedEvent>> {
        return connectionRemote.captureEvents("Page.screencastVisibilityChanged", ScreencastVisibilityChangedEvent::class.java)
    }

    /**
     * Fired when interstitial page was shown
     */
    fun interstitialShown() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return interstitialShownTimed().map {
            it.value()
        }
    }

    /**
     * Fired when interstitial page was shown
     */
    fun interstitialShownTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Page.interstitialShown", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Fired when interstitial page was hidden
     */
    fun interstitialHidden() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return interstitialHiddenTimed().map {
            it.value()
        }
    }

    /**
     * Fired when interstitial page was hidden
     */
    fun interstitialHiddenTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("Page.interstitialHidden", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Fired when a navigation is started if navigation throttles are enabled.  The navigation will be deferred until processNavigation is called.
     */
    fun navigationRequested() : io.reactivex.Flowable<NavigationRequestedEvent> {
        return navigationRequestedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a navigation is started if navigation throttles are enabled.  The navigation will be deferred until processNavigation is called.
     */
    fun navigationRequestedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<NavigationRequestedEvent>> {
        return connectionRemote.captureEvents("Page.navigationRequested", NavigationRequestedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Page domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Page"
        }
    }
}

/**
 * Represents requestFrame parameters that can be used with Page.addScriptToEvaluateOnLoad method call.
 *
 * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
 */
data class AddScriptToEvaluateOnLoadRequest (
    /**
     *
     */
    val scriptSource : String

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
 */
data class AddScriptToEvaluateOnLoadResponse(
  /**
   * Identifier of the added script.
   */
  val identifier : ScriptIdentifier

)

/**
 * Represents requestFrame parameters that can be used with Page.removeScriptToEvaluateOnLoad method call.
 *
 * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
 */
data class RemoveScriptToEvaluateOnLoadRequest (
    /**
     *
     */
    val identifier : ScriptIdentifier

)

/**
 * Represents requestFrame parameters that can be used with Page.addScriptToEvaluateOnNewDocument method call.
 *
 * Evaluates given script in every frame upon creation (before loading frame's scripts).
 */
data class AddScriptToEvaluateOnNewDocumentRequest (
    /**
     *
     */
    val source : String

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Evaluates given script in every frame upon creation (before loading frame's scripts).
 */
data class AddScriptToEvaluateOnNewDocumentResponse(
  /**
   * Identifier of the added script.
   */
  val identifier : ScriptIdentifier

)

/**
 * Represents requestFrame parameters that can be used with Page.removeScriptToEvaluateOnNewDocument method call.
 *
 * Removes given script from the list.
 */
data class RemoveScriptToEvaluateOnNewDocumentRequest (
    /**
     *
     */
    val identifier : ScriptIdentifier

)

/**
 * Represents requestFrame parameters that can be used with Page.setAutoAttachToCreatedPages method call.
 *
 * Controls whether browser will open a new inspector window for connected pages.
 */
data class SetAutoAttachToCreatedPagesRequest (
    /**
     * If true, browser will open a new inspector window for every page created from this one.
     */
    val autoAttach : Boolean

)

/**
 * Represents requestFrame parameters that can be used with Page.reload method call.
 *
 * Reloads given page optionally ignoring the cache.
 */
data class ReloadRequest (
    /**
     * If true, browser cache is ignored (as if the user pressed Shift+refresh).
     */
    val ignoreCache : Boolean? = null,

    /**
     * If set, the script will be injected into all frames of the inspected page after reload.
     */
    val scriptToEvaluateOnLoad : String? = null

)

/**
 * Represents requestFrame parameters that can be used with Page.navigate method call.
 *
 * Navigates current page to the given URL.
 */
data class NavigateRequest (
    /**
     * URL to navigate the page to.
     */
    val url : String,

    /**
     * Referrer URL.
     */
    @pl.wendigo.chrome.Experimental val referrer : String? = null,

    /**
     * Intended transition type.
     */
    @pl.wendigo.chrome.Experimental val transitionType : TransitionType? = null

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Navigates current page to the given URL.
 */
data class NavigateResponse(
  /**
   * Frame id that will be navigated.
   */
  @pl.wendigo.chrome.Experimental val frameId : FrameId

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Returns navigation history for the current page.
 */
data class GetNavigationHistoryResponse(
  /**
   * Index of the current navigation history entry.
   */
  val currentIndex : Int,

  /**
   * Array of navigation history entries.
   */
  val entries : List<NavigationEntry>

)

/**
 * Represents requestFrame parameters that can be used with Page.navigateToHistoryEntry method call.
 *
 * Navigates current page to the given history entry.
 */
data class NavigateToHistoryEntryRequest (
    /**
     * Unique id of the entry to navigate to.
     */
    val entryId : Int

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the <code>cookies</code> field.
 */
data class GetCookiesResponse(
  /**
   * Array of cookie objects.
   */
  val cookies : List<pl.wendigo.chrome.domain.network.Cookie>

)

/**
 * Represents requestFrame parameters that can be used with Page.deleteCookie method call.
 *
 * Deletes browser cookie with given name, domain and path.
 */
data class DeleteCookieRequest (
    /**
     * Name of the cookie to remove.
     */
    val cookieName : String,

    /**
     * URL to match cooke domain and path.
     */
    val url : String

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Returns present frame / resource tree structure.
 */
data class GetResourceTreeResponse(
  /**
   * Present frame / resource tree structure.
   */
  val frameTree : FrameResourceTree

)

/**
 * Represents requestFrame parameters that can be used with Page.getResourceContent method call.
 *
 * Returns content of the given resource.
 */
data class GetResourceContentRequest (
    /**
     * Frame id to get resource for.
     */
    val frameId : FrameId,

    /**
     * URL of the resource to get content for.
     */
    val url : String

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Returns content of the given resource.
 */
data class GetResourceContentResponse(
  /**
   * Resource content.
   */
  val content : String,

  /**
   * True, if content was served as base64.
   */
  val base64Encoded : Boolean

)

/**
 * Represents requestFrame parameters that can be used with Page.searchInResource method call.
 *
 * Searches for given string in resource content.
 */
data class SearchInResourceRequest (
    /**
     * Frame id for resource to search in.
     */
    val frameId : FrameId,

    /**
     * URL of the resource to search in.
     */
    val url : String,

    /**
     * String to search for.
     */
    val query : String,

    /**
     * If true, search is case sensitive.
     */
    val caseSensitive : Boolean? = null,

    /**
     * If true, treats string parameter as regex.
     */
    val isRegex : Boolean? = null

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Searches for given string in resource content.
 */
data class SearchInResourceResponse(
  /**
   * List of search matches.
   */
  val result : List<pl.wendigo.chrome.domain.debugger.SearchMatch>

)

/**
 * Represents requestFrame parameters that can be used with Page.setDocumentContent method call.
 *
 * Sets given markup as the document's HTML.
 */
data class SetDocumentContentRequest (
    /**
     * Frame id to set HTML for.
     */
    val frameId : FrameId,

    /**
     * HTML content to set.
     */
    val html : String

)

/**
 * Represents requestFrame parameters that can be used with Page.setDeviceMetricsOverride method call.
 *
 * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
 */
data class SetDeviceMetricsOverrideRequest (
    /**
     * Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    val width : Int,

    /**
     * Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    val height : Int,

    /**
     * Overriding device scale factor value. 0 disables the override.
     */
    val deviceScaleFactor : Double,

    /**
     * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text autosizing and more.
     */
    val mobile : Boolean,

    /**
     * Scale to apply to resulting view image. Ignored in |fitWindow| mode.
     */
    val scale : Double? = null,

    /**
     * Overriding screen width value in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
     */
    val screenWidth : Int? = null,

    /**
     * Overriding screen height value in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
     */
    val screenHeight : Int? = null,

    /**
     * Overriding view X position on screen in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
     */
    val positionX : Int? = null,

    /**
     * Overriding view Y position on screen in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
     */
    val positionY : Int? = null,

    /**
     * Do not set visible view size, rely upon explicit setVisibleSize call.
     */
    val dontSetVisibleSize : Boolean? = null,

    /**
     * Screen orientation override.
     */
    val screenOrientation : pl.wendigo.chrome.domain.emulation.ScreenOrientation? = null

)

/**
 * Represents requestFrame parameters that can be used with Page.setGeolocationOverride method call.
 *
 * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
 */
data class SetGeolocationOverrideRequest (
    /**
     * Mock latitude
     */
    val latitude : Double? = null,

    /**
     * Mock longitude
     */
    val longitude : Double? = null,

    /**
     * Mock accuracy
     */
    val accuracy : Double? = null

)

/**
 * Represents requestFrame parameters that can be used with Page.setDeviceOrientationOverride method call.
 *
 * Overrides the Device Orientation.
 */
data class SetDeviceOrientationOverrideRequest (
    /**
     * Mock alpha
     */
    val alpha : Double,

    /**
     * Mock beta
     */
    val beta : Double,

    /**
     * Mock gamma
     */
    val gamma : Double

)

/**
 * Represents requestFrame parameters that can be used with Page.setTouchEmulationEnabled method call.
 *
 * Toggles mouse event-based touch event emulation.
 */
data class SetTouchEmulationEnabledRequest (
    /**
     * Whether the touch event emulation should be enabled.
     */
    val enabled : Boolean,

    /**
     * Touch/gesture events configuration. Default: current platform.
     */
    val configuration : String? = null

)

/**
 * Represents requestFrame parameters that can be used with Page.captureScreenshot method call.
 *
 * Capture page screenshot.
 */
data class CaptureScreenshotRequest (
    /**
     * Image compression format (defaults to png).
     */
    val format : String? = null,

    /**
     * Compression quality from range [0..100] (jpeg only).
     */
    val quality : Int? = null,

    /**
     * Capture the screenshot of a given region only.
     */
    @pl.wendigo.chrome.Experimental val clip : Viewport? = null,

    /**
     * Capture the screenshot from the surface, rather than the view. Defaults to true.
     */
    @pl.wendigo.chrome.Experimental val fromSurface : Boolean? = null

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Capture page screenshot.
 */
data class CaptureScreenshotResponse(
  /**
   * Base64-encoded image data.
   */
  val data : String

)

/**
 * Represents requestFrame parameters that can be used with Page.printToPDF method call.
 *
 * Print page as PDF.
 */
data class PrintToPDFRequest (
    /**
     * Paper orientation. Defaults to false.
     */
    val landscape : Boolean? = null,

    /**
     * Display header and footer. Defaults to false.
     */
    val displayHeaderFooter : Boolean? = null,

    /**
     * Print background graphics. Defaults to false.
     */
    val printBackground : Boolean? = null,

    /**
     * Scale of the webpage rendering. Defaults to 1.
     */
    val scale : Double? = null,

    /**
     * Paper width in inches. Defaults to 8.5 inches.
     */
    val paperWidth : Double? = null,

    /**
     * Paper height in inches. Defaults to 11 inches.
     */
    val paperHeight : Double? = null,

    /**
     * Top margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginTop : Double? = null,

    /**
     * Bottom margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginBottom : Double? = null,

    /**
     * Left margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginLeft : Double? = null,

    /**
     * Right margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginRight : Double? = null,

    /**
     * Paper ranges to print, e.g., '1-5, 8, 11-13'. Defaults to the empty string, which means print all pages.
     */
    val pageRanges : String? = null,

    /**
     * Whether to silently ignore invalid but successfully parsed page ranges, such as '3-2'. Defaults to false.
     */
    val ignoreInvalidPageRanges : Boolean? = null

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Print page as PDF.
 */
data class PrintToPDFResponse(
  /**
   * Base64-encoded pdf data.
   */
  val data : String

)

/**
 * Represents requestFrame parameters that can be used with Page.startScreencast method call.
 *
 * Starts sending each frame using the <code>screencastFrame</code> event.
 */
data class StartScreencastRequest (
    /**
     * Image compression format.
     */
    val format : String? = null,

    /**
     * Compression quality from range [0..100].
     */
    val quality : Int? = null,

    /**
     * Maximum screenshot width.
     */
    val maxWidth : Int? = null,

    /**
     * Maximum screenshot height.
     */
    val maxHeight : Int? = null,

    /**
     * Send every n-th frame.
     */
    val everyNthFrame : Int? = null

)

/**
 * Represents requestFrame parameters that can be used with Page.screencastFrameAck method call.
 *
 * Acknowledges that a screencast frame has been received by the frontend.
 */
data class ScreencastFrameAckRequest (
    /**
     * Frame number.
     */
    val sessionId : Int

)

/**
 * Represents requestFrame parameters that can be used with Page.handleJavaScriptDialog method call.
 *
 * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
 */
data class HandleJavaScriptDialogRequest (
    /**
     * Whether to accept or dismiss the dialog.
     */
    val accept : Boolean,

    /**
     * The text to enter into the dialog prompt before accepting. Used only if this is a prompt dialog.
     */
    val promptText : String? = null

)

/**
 * Represents responseFrame from Page. method call.
 *
 *
 */
data class GetAppManifestResponse(
  /**
   * Manifest location.
   */
  val url : String,

  /**
   *
   */
  val errors : List<AppManifestError>,

  /**
   * Manifest content.
   */
  val data : String? = null

)

/**
 * Represents requestFrame parameters that can be used with Page.setControlNavigations method call.
 *
 * Toggles navigation throttling which allows programatic control over navigation and redirect response.
 */
data class SetControlNavigationsRequest (
    /**
     *
     */
    val enabled : Boolean

)

/**
 * Represents requestFrame parameters that can be used with Page.processNavigation method call.
 *
 * Should be sent in response to a navigationRequested or a redirectRequested event, telling the browser how to handle the navigation.
 */
data class ProcessNavigationRequest (
    /**
     *
     */
    val response : NavigationResponse,

    /**
     *
     */
    val navigationId : Int

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
 */
data class GetLayoutMetricsResponse(
  /**
   * Metrics relating to the layout viewport.
   */
  val layoutViewport : LayoutViewport,

  /**
   * Metrics relating to the visual viewport.
   */
  val visualViewport : VisualViewport,

  /**
   * Size of scrollable area.
   */
  val contentSize : pl.wendigo.chrome.domain.dom.Rect

)

/**
 * Represents requestFrame parameters that can be used with Page.createIsolatedWorld method call.
 *
 * Creates an isolated world for the given frame.
 */
data class CreateIsolatedWorldRequest (
    /**
     * Id of the frame in which the isolated world should be created.
     */
    val frameId : FrameId,

    /**
     * An optional name which is reported in the Execution Context.
     */
    val worldName : String? = null,

    /**
     * Whether or not universal access should be granted to the isolated world. This is a powerful option, use with caution.
     */
    val grantUniveralAccess : Boolean? = null

)

/**
 * Represents responseFrame from Page. method call.
 *
 * Creates an isolated world for the given frame.
 */
data class CreateIsolatedWorldResponse(
  /**
   * Execution context of the isolated world.
   */
  val executionContextId : pl.wendigo.chrome.domain.runtime.ExecutionContextId

)

/**
 * Represents responseFrame from Page. method call.
 *
 *
 */
data class DomContentEventFiredEvent(
  /**
   *
   */
  val timestamp : pl.wendigo.chrome.domain.network.MonotonicTime

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "domContentEventFired")

/**
 * Represents responseFrame from Page. method call.
 *
 *
 */
data class LoadEventFiredEvent(
  /**
   *
   */
  val timestamp : pl.wendigo.chrome.domain.network.MonotonicTime

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "loadEventFired")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when frame has been attached to its parent.
 */
data class FrameAttachedEvent(
  /**
   * Id of the frame that has been attached.
   */
  val frameId : FrameId,

  /**
   * Parent frame identifier.
   */
  val parentFrameId : FrameId,

  /**
   * JavaScript stack trace of when frame was attached, only set if frame initiated from script.
   */
  @pl.wendigo.chrome.Experimental val stack : pl.wendigo.chrome.domain.runtime.StackTrace? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameAttached")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
 */
data class FrameNavigatedEvent(
  /**
   * Frame object.
   */
  val frame : Frame

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameNavigated")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when frame has been detached from its parent.
 */
data class FrameDetachedEvent(
  /**
   * Id of the frame that has been detached.
   */
  val frameId : FrameId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameDetached")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when frame has started loading.
 */
data class FrameStartedLoadingEvent(
  /**
   * Id of the frame that has started loading.
   */
  val frameId : FrameId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameStartedLoading")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when frame has stopped loading.
 */
data class FrameStoppedLoadingEvent(
  /**
   * Id of the frame that has stopped loading.
   */
  val frameId : FrameId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameStoppedLoading")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when frame schedules a potential navigation.
 */
data class FrameScheduledNavigationEvent(
  /**
   * Id of the frame that has scheduled a navigation.
   */
  val frameId : FrameId,

  /**
   * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not guaranteed to start.
   */
  val delay : Double

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameScheduledNavigation")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when frame no longer has a scheduled navigation.
 */
data class FrameClearedScheduledNavigationEvent(
  /**
   * Id of the frame that has cleared its scheduled navigation.
   */
  val frameId : FrameId

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "frameClearedScheduledNavigation")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
 */
data class JavascriptDialogOpeningEvent(
  /**
   * Message that will be displayed by the dialog.
   */
  val message : String,

  /**
   * Dialog type.
   */
  val type : DialogType

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "javascriptDialogOpening")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
 */
data class JavascriptDialogClosedEvent(
  /**
   * Whether dialog was confirmed.
   */
  val result : Boolean

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "javascriptDialogClosed")

/**
 * Represents responseFrame from Page. method call.
 *
 * Compressed image data requested by the <code>startScreencast</code>.
 */
data class ScreencastFrameEvent(
  /**
   * Base64-encoded compressed image.
   */
  val data : String,

  /**
   * Screencast frame metadata.
   */
  val metadata : ScreencastFrameMetadata,

  /**
   * Frame number.
   */
  val sessionId : Int

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "screencastFrame")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when the page with currently enabled screencast was shown or hidden </code>.
 */
data class ScreencastVisibilityChangedEvent(
  /**
   * True if the page is visible.
   */
  val visible : Boolean

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "screencastVisibilityChanged")

/**
 * Represents responseFrame from Page. method call.
 *
 * Fired when a navigation is started if navigation throttles are enabled.  The navigation will be deferred until processNavigation is called.
 */
data class NavigationRequestedEvent(
  /**
   * Whether the navigation is taking place in the main frame or in a subframe.
   */
  val isInMainFrame : Boolean,

  /**
   * Whether the navigation has encountered a server redirect or not.
   */
  val isRedirect : Boolean,

  /**
   *
   */
  val navigationId : Int,

  /**
   * URL of requested navigation.
   */
  val url : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "Page", name = "navigationRequested")

