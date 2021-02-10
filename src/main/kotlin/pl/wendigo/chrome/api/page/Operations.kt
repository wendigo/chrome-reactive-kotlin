package pl.wendigo.chrome.api.page

/**
 * Actions and events related to the inspected page belong to the page domain.
 *
 * @link Protocol [Page](https://chromedevtools.github.io/devtools-protocol/tot/Page) domain documentation.
 */
class PageOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
     *
     * @link Protocol [Page#addScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnLoad) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "addScriptToEvaluateOnLoad is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun addScriptToEvaluateOnLoad(input: AddScriptToEvaluateOnLoadRequest) = connection.request("Page.addScriptToEvaluateOnLoad", input, AddScriptToEvaluateOnLoadResponse::class.java)

    /**
     * Evaluates given script in every frame upon creation (before loading frame's scripts).
     *
     * @link Protocol [Page#addScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnNewDocument) method documentation.
     */
    fun addScriptToEvaluateOnNewDocument(input: AddScriptToEvaluateOnNewDocumentRequest) = connection.request("Page.addScriptToEvaluateOnNewDocument", input, AddScriptToEvaluateOnNewDocumentResponse::class.java)

    /**
     * Brings page to front (activates tab).
     *
     * @link Protocol [Page#bringToFront](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-bringToFront) method documentation.
     */
    fun bringToFront() = connection.request("Page.bringToFront", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Capture page screenshot.
     *
     * @link Protocol [Page#captureScreenshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureScreenshot) method documentation.
     */
    fun captureScreenshot(input: CaptureScreenshotRequest) = connection.request("Page.captureScreenshot", input, CaptureScreenshotResponse::class.java)

    /**
     * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
iframes, shadow DOM, external resources, and element-inline styles.
     *
     * @link Protocol [Page#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureSnapshot) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun captureSnapshot(input: CaptureSnapshotRequest) = connection.request("Page.captureSnapshot", input, CaptureSnapshotResponse::class.java)

    /**
     * Clears the overriden device metrics.
     *
     * @link Protocol [Page#clearDeviceMetricsOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearDeviceMetricsOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "clearDeviceMetricsOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun clearDeviceMetricsOverride() = connection.request("Page.clearDeviceMetricsOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Clears the overridden Device Orientation.
     *
     * @link Protocol [Page#clearDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearDeviceOrientationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "clearDeviceOrientationOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun clearDeviceOrientationOverride() = connection.request("Page.clearDeviceOrientationOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Clears the overriden Geolocation Position and Error.
     *
     * @link Protocol [Page#clearGeolocationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearGeolocationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "clearGeolocationOverride is deprecated.")
    fun clearGeolocationOverride() = connection.request("Page.clearGeolocationOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Creates an isolated world for the given frame.
     *
     * @link Protocol [Page#createIsolatedWorld](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-createIsolatedWorld) method documentation.
     */
    fun createIsolatedWorld(input: CreateIsolatedWorldRequest) = connection.request("Page.createIsolatedWorld", input, CreateIsolatedWorldResponse::class.java)

    /**
     * Deletes browser cookie with given name, domain and path.
     *
     * @link Protocol [Page#deleteCookie](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-deleteCookie) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "deleteCookie is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun deleteCookie(input: DeleteCookieRequest) = connection.request("Page.deleteCookie", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Disables page domain notifications.
     *
     * @link Protocol [Page#disable](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-disable) method documentation.
     */
    fun disable() = connection.request("Page.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables page domain notifications.
     *
     * @link Protocol [Page#enable](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-enable) method documentation.
     */
    fun enable() = connection.request("Page.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [Page#getAppManifest](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getAppManifest) method documentation.
     */
    fun getAppManifest() = connection.request("Page.getAppManifest", null, GetAppManifestResponse::class.java)

    /**
     *
     *
     * @link Protocol [Page#getInstallabilityErrors](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getInstallabilityErrors) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getInstallabilityErrors() = connection.request("Page.getInstallabilityErrors", null, GetInstallabilityErrorsResponse::class.java)

    /**
     *
     *
     * @link Protocol [Page#getManifestIcons](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getManifestIcons) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getManifestIcons() = connection.request("Page.getManifestIcons", null, GetManifestIconsResponse::class.java)

    /**
     * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
     *
     * @link Protocol [Page#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getCookies) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "getCookies is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getCookies() = connection.request("Page.getCookies", null, GetCookiesResponse::class.java)

    /**
     * Returns present frame tree structure.
     *
     * @link Protocol [Page#getFrameTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getFrameTree) method documentation.
     */
    fun getFrameTree() = connection.request("Page.getFrameTree", null, GetFrameTreeResponse::class.java)

    /**
     * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
     *
     * @link Protocol [Page#getLayoutMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getLayoutMetrics) method documentation.
     */
    fun getLayoutMetrics() = connection.request("Page.getLayoutMetrics", null, GetLayoutMetricsResponse::class.java)

    /**
     * Returns navigation history for the current page.
     *
     * @link Protocol [Page#getNavigationHistory](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getNavigationHistory) method documentation.
     */
    fun getNavigationHistory() = connection.request("Page.getNavigationHistory", null, GetNavigationHistoryResponse::class.java)

    /**
     * Resets navigation history for the current page.
     *
     * @link Protocol [Page#resetNavigationHistory](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-resetNavigationHistory) method documentation.
     */
    fun resetNavigationHistory() = connection.request("Page.resetNavigationHistory", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Returns content of the given resource.
     *
     * @link Protocol [Page#getResourceContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceContent) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getResourceContent(input: GetResourceContentRequest) = connection.request("Page.getResourceContent", input, GetResourceContentResponse::class.java)

    /**
     * Returns present frame / resource tree structure.
     *
     * @link Protocol [Page#getResourceTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceTree) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getResourceTree() = connection.request("Page.getResourceTree", null, GetResourceTreeResponse::class.java)

    /**
     * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
     *
     * @link Protocol [Page#handleJavaScriptDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleJavaScriptDialog) method documentation.
     */
    fun handleJavaScriptDialog(input: HandleJavaScriptDialogRequest) = connection.request("Page.handleJavaScriptDialog", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Navigates current page to the given URL.
     *
     * @link Protocol [Page#navigate](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigate) method documentation.
     */
    fun navigate(input: NavigateRequest) = connection.request("Page.navigate", input, NavigateResponse::class.java)

    /**
     * Navigates current page to the given history entry.
     *
     * @link Protocol [Page#navigateToHistoryEntry](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigateToHistoryEntry) method documentation.
     */
    fun navigateToHistoryEntry(input: NavigateToHistoryEntryRequest) = connection.request("Page.navigateToHistoryEntry", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Print page as PDF.
     *
     * @link Protocol [Page#printToPDF](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-printToPDF) method documentation.
     */
    fun printToPDF(input: PrintToPDFRequest) = connection.request("Page.printToPDF", input, PrintToPDFResponse::class.java)

    /**
     * Reloads given page optionally ignoring the cache.
     *
     * @link Protocol [Page#reload](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-reload) method documentation.
     */
    fun reload(input: ReloadRequest) = connection.request("Page.reload", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
     *
     * @link Protocol [Page#removeScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnLoad) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "removeScriptToEvaluateOnLoad is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun removeScriptToEvaluateOnLoad(input: RemoveScriptToEvaluateOnLoadRequest) = connection.request("Page.removeScriptToEvaluateOnLoad", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Removes given script from the list.
     *
     * @link Protocol [Page#removeScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnNewDocument) method documentation.
     */
    fun removeScriptToEvaluateOnNewDocument(input: RemoveScriptToEvaluateOnNewDocumentRequest) = connection.request("Page.removeScriptToEvaluateOnNewDocument", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Acknowledges that a screencast frame has been received by the frontend.
     *
     * @link Protocol [Page#screencastFrameAck](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-screencastFrameAck) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun screencastFrameAck(input: ScreencastFrameAckRequest) = connection.request("Page.screencastFrameAck", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Searches for given string in resource content.
     *
     * @link Protocol [Page#searchInResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-searchInResource) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun searchInResource(input: SearchInResourceRequest) = connection.request("Page.searchInResource", input, SearchInResourceResponse::class.java)

    /**
     * Enable Chrome's experimental ad filter on all sites.
     *
     * @link Protocol [Page#setAdBlockingEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setAdBlockingEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setAdBlockingEnabled(input: SetAdBlockingEnabledRequest) = connection.request("Page.setAdBlockingEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enable page Content Security Policy by-passing.
     *
     * @link Protocol [Page#setBypassCSP](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setBypassCSP) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBypassCSP(input: SetBypassCSPRequest) = connection.request("Page.setBypassCSP", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
query results).
     *
     * @link Protocol [Page#setDeviceMetricsOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceMetricsOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setDeviceMetricsOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDeviceMetricsOverride(input: SetDeviceMetricsOverrideRequest) = connection.request("Page.setDeviceMetricsOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Overrides the Device Orientation.
     *
     * @link Protocol [Page#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceOrientationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setDeviceOrientationOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDeviceOrientationOverride(input: SetDeviceOrientationOverrideRequest) = connection.request("Page.setDeviceOrientationOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Set generic font families.
     *
     * @link Protocol [Page#setFontFamilies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontFamilies) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setFontFamilies(input: SetFontFamiliesRequest) = connection.request("Page.setFontFamilies", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Set default font sizes.
     *
     * @link Protocol [Page#setFontSizes](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontSizes) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setFontSizes(input: SetFontSizesRequest) = connection.request("Page.setFontSizes", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Sets given markup as the document's HTML.
     *
     * @link Protocol [Page#setDocumentContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDocumentContent) method documentation.
     */
    fun setDocumentContent(input: SetDocumentContentRequest) = connection.request("Page.setDocumentContent", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Set the behavior when downloading a file.
     *
     * @link Protocol [Page#setDownloadBehavior](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDownloadBehavior) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setDownloadBehavior is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDownloadBehavior(input: SetDownloadBehaviorRequest) = connection.request("Page.setDownloadBehavior", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position
unavailable.
     *
     * @link Protocol [Page#setGeolocationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setGeolocationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setGeolocationOverride is deprecated.")
    fun setGeolocationOverride(input: SetGeolocationOverrideRequest) = connection.request("Page.setGeolocationOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Controls whether page will emit lifecycle events.
     *
     * @link Protocol [Page#setLifecycleEventsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setLifecycleEventsEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setLifecycleEventsEnabled(input: SetLifecycleEventsEnabledRequest) = connection.request("Page.setLifecycleEventsEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Toggles mouse event-based touch event emulation.
     *
     * @link Protocol [Page#setTouchEmulationEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setTouchEmulationEnabled) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setTouchEmulationEnabled is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setTouchEmulationEnabled(input: SetTouchEmulationEnabledRequest) = connection.request("Page.setTouchEmulationEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Starts sending each frame using the `screencastFrame` event.
     *
     * @link Protocol [Page#startScreencast](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-startScreencast) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun startScreencast(input: StartScreencastRequest) = connection.request("Page.startScreencast", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Force the page stop all navigations and pending resource fetches.
     *
     * @link Protocol [Page#stopLoading](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-stopLoading) method documentation.
     */
    fun stopLoading() = connection.request("Page.stopLoading", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Crashes renderer on the IO thread, generates minidumps.
     *
     * @link Protocol [Page#crash](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-crash) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun crash() = connection.request("Page.crash", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Tries to close page, running its beforeunload hooks, if any.
     *
     * @link Protocol [Page#close](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-close) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun close() = connection.request("Page.close", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Tries to update the web lifecycle state of the page.
It will transition the page to the given state according to:
https://github.com/WICG/web-lifecycle/
     *
     * @link Protocol [Page#setWebLifecycleState](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setWebLifecycleState) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setWebLifecycleState(input: SetWebLifecycleStateRequest) = connection.request("Page.setWebLifecycleState", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Stops sending each frame in the `screencastFrame`.
     *
     * @link Protocol [Page#stopScreencast](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-stopScreencast) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun stopScreencast() = connection.request("Page.stopScreencast", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Forces compilation cache to be generated for every subresource script.
     *
     * @link Protocol [Page#setProduceCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setProduceCompilationCache) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setProduceCompilationCache(input: SetProduceCompilationCacheRequest) = connection.request("Page.setProduceCompilationCache", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Seeds compilation cache for given url. Compilation cache does not survive
cross-process navigation.
     *
     * @link Protocol [Page#addCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addCompilationCache) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun addCompilationCache(input: AddCompilationCacheRequest) = connection.request("Page.addCompilationCache", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Clears seeded compilation cache.
     *
     * @link Protocol [Page#clearCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearCompilationCache) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun clearCompilationCache() = connection.request("Page.clearCompilationCache", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Generates a report for testing.
     *
     * @link Protocol [Page#generateTestReport](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-generateTestReport) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun generateTestReport(input: GenerateTestReportRequest) = connection.request("Page.generateTestReport", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
     *
     * @link Protocol [Page#waitForDebugger](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-waitForDebugger) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun waitForDebugger() = connection.request("Page.waitForDebugger", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Intercept file chooser requests and transfer control to protocol clients.
When file chooser interception is enabled, native file chooser dialog is not shown.
Instead, a protocol event `Page.fileChooserOpened` is emitted.
     *
     * @link Protocol [Page#setInterceptFileChooserDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setInterceptFileChooserDialog) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setInterceptFileChooserDialog(input: SetInterceptFileChooserDialogRequest) = connection.request("Page.setInterceptFileChooserDialog", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *  Returns observable capturing all Page.domContentEventFired events.
     */
    fun domContentEventFired(): io.reactivex.Flowable<DomContentEventFiredEvent> = connection.events("Page.domContentEventFired", DomContentEventFiredEvent::class.java)

    /**
     *  Emitted only when `page.interceptFileChooser` is enabled.
     */
    fun fileChooserOpened(): io.reactivex.Flowable<FileChooserOpenedEvent> = connection.events("Page.fileChooserOpened", FileChooserOpenedEvent::class.java)

    /**
     *  Fired when frame has been attached to its parent.
     */
    fun frameAttached(): io.reactivex.Flowable<FrameAttachedEvent> = connection.events("Page.frameAttached", FrameAttachedEvent::class.java)

    /**
     *  Fired when frame no longer has a scheduled navigation.
     */
    fun frameClearedScheduledNavigation(): io.reactivex.Flowable<FrameClearedScheduledNavigationEvent> = connection.events("Page.frameClearedScheduledNavigation", FrameClearedScheduledNavigationEvent::class.java)

    /**
     *  Fired when frame has been detached from its parent.
     */
    fun frameDetached(): io.reactivex.Flowable<FrameDetachedEvent> = connection.events("Page.frameDetached", FrameDetachedEvent::class.java)

    /**
     *  Fired once navigation of the frame has completed. Frame is now associated with the new loader.
     */
    fun frameNavigated(): io.reactivex.Flowable<FrameNavigatedEvent> = connection.events("Page.frameNavigated", FrameNavigatedEvent::class.java)

    /**
     *  Fired when opening document to write to.
     */
    fun documentOpened(): io.reactivex.Flowable<DocumentOpenedEvent> = connection.events("Page.documentOpened", DocumentOpenedEvent::class.java)

    /**
     *  Returns observable capturing all Page.frameResized events.
     */
    fun frameResized(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Page.frameResized", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Fired when a renderer-initiated navigation is requested.
Navigation may still be cancelled after the event is issued.
     */
    fun frameRequestedNavigation(): io.reactivex.Flowable<FrameRequestedNavigationEvent> = connection.events("Page.frameRequestedNavigation", FrameRequestedNavigationEvent::class.java)

    /**
     *  Fired when frame schedules a potential navigation.
     */
    fun frameScheduledNavigation(): io.reactivex.Flowable<FrameScheduledNavigationEvent> = connection.events("Page.frameScheduledNavigation", FrameScheduledNavigationEvent::class.java)

    /**
     *  Fired when frame has started loading.
     */
    fun frameStartedLoading(): io.reactivex.Flowable<FrameStartedLoadingEvent> = connection.events("Page.frameStartedLoading", FrameStartedLoadingEvent::class.java)

    /**
     *  Fired when frame has stopped loading.
     */
    fun frameStoppedLoading(): io.reactivex.Flowable<FrameStoppedLoadingEvent> = connection.events("Page.frameStoppedLoading", FrameStoppedLoadingEvent::class.java)

    /**
     *  Fired when page is about to start a download.
     */
    fun downloadWillBegin(): io.reactivex.Flowable<DownloadWillBeginEvent> = connection.events("Page.downloadWillBegin", DownloadWillBeginEvent::class.java)

    /**
     *  Fired when download makes progress. Last call has |done| == true.
     */
    fun downloadProgress(): io.reactivex.Flowable<DownloadProgressEvent> = connection.events("Page.downloadProgress", DownloadProgressEvent::class.java)

    /**
     *  Fired when interstitial page was hidden
     */
    fun interstitialHidden(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Page.interstitialHidden", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Fired when interstitial page was shown
     */
    fun interstitialShown(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("Page.interstitialShown", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
closed.
     */
    fun javascriptDialogClosed(): io.reactivex.Flowable<JavascriptDialogClosedEvent> = connection.events("Page.javascriptDialogClosed", JavascriptDialogClosedEvent::class.java)

    /**
     *  Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
open.
     */
    fun javascriptDialogOpening(): io.reactivex.Flowable<JavascriptDialogOpeningEvent> = connection.events("Page.javascriptDialogOpening", JavascriptDialogOpeningEvent::class.java)

    /**
     *  Fired for top level page lifecycle events such as navigation, load, paint, etc.
     */
    fun lifecycleEvent(): io.reactivex.Flowable<LifecycleEventEvent> = connection.events("Page.lifecycleEvent", LifecycleEventEvent::class.java)

    /**
     *  Returns observable capturing all Page.loadEventFired events.
     */
    fun loadEventFired(): io.reactivex.Flowable<LoadEventFiredEvent> = connection.events("Page.loadEventFired", LoadEventFiredEvent::class.java)

    /**
     *  Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
     */
    fun navigatedWithinDocument(): io.reactivex.Flowable<NavigatedWithinDocumentEvent> = connection.events("Page.navigatedWithinDocument", NavigatedWithinDocumentEvent::class.java)

    /**
     *  Compressed image data requested by the `startScreencast`.
     */
    fun screencastFrame(): io.reactivex.Flowable<ScreencastFrameEvent> = connection.events("Page.screencastFrame", ScreencastFrameEvent::class.java)

    /**
     *  Fired when the page with currently enabled screencast was shown or hidden `.
     */
    fun screencastVisibilityChanged(): io.reactivex.Flowable<ScreencastVisibilityChangedEvent> = connection.events("Page.screencastVisibilityChanged", ScreencastVisibilityChangedEvent::class.java)

    /**
     *  Fired when a new window is going to be opened, via window.open(), link click, form submission,
etc.
     */
    fun windowOpen(): io.reactivex.Flowable<WindowOpenEvent> = connection.events("Page.windowOpen", WindowOpenEvent::class.java)

    /**
     *  Issued for every compilation cache generated. Is only available
if Page.setGenerateCompilationCache is enabled.
     */
    fun compilationCacheProduced(): io.reactivex.Flowable<CompilationCacheProducedEvent> = connection.events("Page.compilationCacheProduced", CompilationCacheProducedEvent::class.java)

    /**
     * Returns flowable capturing all Page domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "Page"
        }
    }
}

/**
 * Represents request frame that can be used with [Page#addScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnLoad) operation call.
 *
 * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
 * @link [Page#addScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnLoad) method documentation.
 * @see [PageOperations.addScriptToEvaluateOnLoad]
 */
data class AddScriptToEvaluateOnLoadRequest(
    /**
     *
     */
    val scriptSource: String

)

/**
 * Represents response frame that is returned from [Page#addScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnLoad) operation call.
 * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
 *
  
 * @link [Page#addScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnLoad) method documentation.
 * @see [PageOperations.addScriptToEvaluateOnLoad]
 */
data class AddScriptToEvaluateOnLoadResponse(
    /**  
     * Identifier of the added script.  
     */  
    val identifier: ScriptIdentifier

)

/**
 * Represents request frame that can be used with [Page#addScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnNewDocument) operation call.
 *
 * Evaluates given script in every frame upon creation (before loading frame's scripts).
 * @link [Page#addScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnNewDocument) method documentation.
 * @see [PageOperations.addScriptToEvaluateOnNewDocument]
 */
data class AddScriptToEvaluateOnNewDocumentRequest(
    /**
     *
     */
    val source: String,

    /**
     * If specified, creates an isolated world with the given name and evaluates given script in it.
This world name will be used as the ExecutionContextDescription::name when the corresponding
event is emitted.
     */
    @pl.wendigo.chrome.protocol.Experimental val worldName: String? = null

)

/**
 * Represents response frame that is returned from [Page#addScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnNewDocument) operation call.
 * Evaluates given script in every frame upon creation (before loading frame's scripts).
 *
  
 * @link [Page#addScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnNewDocument) method documentation.
 * @see [PageOperations.addScriptToEvaluateOnNewDocument]
 */
data class AddScriptToEvaluateOnNewDocumentResponse(
    /**  
     * Identifier of the added script.  
     */  
    val identifier: ScriptIdentifier

)

/**
 * Represents request frame that can be used with [Page#captureScreenshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureScreenshot) operation call.
 *
 * Capture page screenshot.
 * @link [Page#captureScreenshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureScreenshot) method documentation.
 * @see [PageOperations.captureScreenshot]
 */
data class CaptureScreenshotRequest(
    /**
     * Image compression format (defaults to png).
     */
    val format: String? = null,

    /**
     * Compression quality from range [0..100] (jpeg only).
     */
    val quality: Int? = null,

    /**
     * Capture the screenshot of a given region only.
     */
    val clip: Viewport? = null,

    /**
     * Capture the screenshot from the surface, rather than the view. Defaults to true.
     */
    @pl.wendigo.chrome.protocol.Experimental val fromSurface: Boolean? = null,

    /**
     * Capture the screenshot beyond the viewport. Defaults to false.
     */
    @pl.wendigo.chrome.protocol.Experimental val captureBeyondViewport: Boolean? = null

)

/**
 * Represents response frame that is returned from [Page#captureScreenshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureScreenshot) operation call.
 * Capture page screenshot.
 *
  
 * @link [Page#captureScreenshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureScreenshot) method documentation.
 * @see [PageOperations.captureScreenshot]
 */
data class CaptureScreenshotResponse(
    /**  
     * Base64-encoded image data. (Encoded as a base64 string when passed over JSON)  
     */  
    val data: String

)

/**
 * Represents request frame that can be used with [Page#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureSnapshot) operation call.
 *
 * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
iframes, shadow DOM, external resources, and element-inline styles.
 * @link [Page#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureSnapshot) method documentation.
 * @see [PageOperations.captureSnapshot]
 */
data class CaptureSnapshotRequest(
    /**
     * Format (defaults to mhtml).
     */
    val format: String? = null

)

/**
 * Represents response frame that is returned from [Page#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureSnapshot) operation call.
 * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
iframes, shadow DOM, external resources, and element-inline styles.
 *
  
 * @link [Page#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureSnapshot) method documentation.
 * @see [PageOperations.captureSnapshot]
 */
data class CaptureSnapshotResponse(
    /**  
     * Serialized page data.  
     */  
    val data: String

)

/**
 * Represents request frame that can be used with [Page#createIsolatedWorld](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-createIsolatedWorld) operation call.
 *
 * Creates an isolated world for the given frame.
 * @link [Page#createIsolatedWorld](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-createIsolatedWorld) method documentation.
 * @see [PageOperations.createIsolatedWorld]
 */
data class CreateIsolatedWorldRequest(
    /**
     * Id of the frame in which the isolated world should be created.
     */
    val frameId: FrameId,

    /**
     * An optional name which is reported in the Execution Context.
     */
    val worldName: String? = null,

    /**
     * Whether or not universal access should be granted to the isolated world. This is a powerful
option, use with caution.
     */
    val grantUniveralAccess: Boolean? = null

)

/**
 * Represents response frame that is returned from [Page#createIsolatedWorld](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-createIsolatedWorld) operation call.
 * Creates an isolated world for the given frame.
 *
  
 * @link [Page#createIsolatedWorld](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-createIsolatedWorld) method documentation.
 * @see [PageOperations.createIsolatedWorld]
 */
data class CreateIsolatedWorldResponse(
    /**  
     * Execution context of the isolated world.  
     */  
    val executionContextId: pl.wendigo.chrome.api.runtime.ExecutionContextId

)

/**
 * Represents request frame that can be used with [Page#deleteCookie](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-deleteCookie) operation call.
 *
 * Deletes browser cookie with given name, domain and path.
 * @link [Page#deleteCookie](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-deleteCookie) method documentation.
 * @see [PageOperations.deleteCookie]
 */
data class DeleteCookieRequest(
    /**
     * Name of the cookie to remove.
     */
    val cookieName: String,

    /**
     * URL to match cooke domain and path.
     */
    val url: String

)

/**
 * Represents response frame that is returned from [Page#getAppManifest](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getAppManifest) operation call.
 *
 *
  
 * @link [Page#getAppManifest](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getAppManifest) method documentation.
 * @see [PageOperations.getAppManifest]
 */
data class GetAppManifestResponse(
    /**  
     * Manifest location.  
     */  
    val url: String,

    /**  
     *  
     */  
    val errors: List<AppManifestError>,

    /**  
     * Manifest content.  
     */  
    val data: String? = null,

    /**  
     * Parsed manifest properties  
     */  
    val parsed: AppManifestParsedProperties? = null

)

/**
 * Represents response frame that is returned from [Page#getInstallabilityErrors](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getInstallabilityErrors) operation call.
 *
 *
  
 * @link [Page#getInstallabilityErrors](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getInstallabilityErrors) method documentation.
 * @see [PageOperations.getInstallabilityErrors]
 */
data class GetInstallabilityErrorsResponse(
    /**  
     *  
     */  
    val installabilityErrors: List<InstallabilityError>

)

/**
 * Represents response frame that is returned from [Page#getManifestIcons](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getManifestIcons) operation call.
 *
 *
  
 * @link [Page#getManifestIcons](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getManifestIcons) method documentation.
 * @see [PageOperations.getManifestIcons]
 */
data class GetManifestIconsResponse(
    /**  
     *  
     */  
    val primaryIcon: String? = null

)

/**
 * Represents response frame that is returned from [Page#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getCookies) operation call.
 * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
 *
  
 * @link [Page#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getCookies) method documentation.
 * @see [PageOperations.getCookies]
 */
data class GetCookiesResponse(
    /**  
     * Array of cookie objects.  
     */  
    val cookies: List<pl.wendigo.chrome.api.network.Cookie>

)

/**
 * Represents response frame that is returned from [Page#getFrameTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getFrameTree) operation call.
 * Returns present frame tree structure.
 *
  
 * @link [Page#getFrameTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getFrameTree) method documentation.
 * @see [PageOperations.getFrameTree]
 */
data class GetFrameTreeResponse(
    /**  
     * Present frame tree structure.  
     */  
    val frameTree: FrameTree

)

/**
 * Represents response frame that is returned from [Page#getLayoutMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getLayoutMetrics) operation call.
 * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
 *
  
 * @link [Page#getLayoutMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getLayoutMetrics) method documentation.
 * @see [PageOperations.getLayoutMetrics]
 */
data class GetLayoutMetricsResponse(
    /**  
     * Metrics relating to the layout viewport.  
     */  
    val layoutViewport: LayoutViewport,

    /**  
     * Metrics relating to the visual viewport.  
     */  
    val visualViewport: VisualViewport,

    /**  
     * Size of scrollable area.  
     */  
    val contentSize: pl.wendigo.chrome.api.dom.Rect

)

/**
 * Represents response frame that is returned from [Page#getNavigationHistory](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getNavigationHistory) operation call.
 * Returns navigation history for the current page.
 *
  
 * @link [Page#getNavigationHistory](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getNavigationHistory) method documentation.
 * @see [PageOperations.getNavigationHistory]
 */
data class GetNavigationHistoryResponse(
    /**  
     * Index of the current navigation history entry.  
     */  
    val currentIndex: Int,

    /**  
     * Array of navigation history entries.  
     */  
    val entries: List<NavigationEntry>

)

/**
 * Represents request frame that can be used with [Page#getResourceContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceContent) operation call.
 *
 * Returns content of the given resource.
 * @link [Page#getResourceContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceContent) method documentation.
 * @see [PageOperations.getResourceContent]
 */
data class GetResourceContentRequest(
    /**
     * Frame id to get resource for.
     */
    val frameId: FrameId,

    /**
     * URL of the resource to get content for.
     */
    val url: String

)

/**
 * Represents response frame that is returned from [Page#getResourceContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceContent) operation call.
 * Returns content of the given resource.
 *
  
 * @link [Page#getResourceContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceContent) method documentation.
 * @see [PageOperations.getResourceContent]
 */
data class GetResourceContentResponse(
    /**  
     * Resource content.  
     */  
    val content: String,

    /**  
     * True, if content was served as base64.  
     */  
    val base64Encoded: Boolean

)

/**
 * Represents response frame that is returned from [Page#getResourceTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceTree) operation call.
 * Returns present frame / resource tree structure.
 *
  
 * @link [Page#getResourceTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceTree) method documentation.
 * @see [PageOperations.getResourceTree]
 */
data class GetResourceTreeResponse(
    /**  
     * Present frame / resource tree structure.  
     */  
    val frameTree: FrameResourceTree

)

/**
 * Represents request frame that can be used with [Page#handleJavaScriptDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleJavaScriptDialog) operation call.
 *
 * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
 * @link [Page#handleJavaScriptDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleJavaScriptDialog) method documentation.
 * @see [PageOperations.handleJavaScriptDialog]
 */
data class HandleJavaScriptDialogRequest(
    /**
     * Whether to accept or dismiss the dialog.
     */
    val accept: Boolean,

    /**
     * The text to enter into the dialog prompt before accepting. Used only if this is a prompt
dialog.
     */
    val promptText: String? = null

)

/**
 * Represents request frame that can be used with [Page#navigate](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigate) operation call.
 *
 * Navigates current page to the given URL.
 * @link [Page#navigate](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigate) method documentation.
 * @see [PageOperations.navigate]
 */
data class NavigateRequest(
    /**
     * URL to navigate the page to.
     */
    val url: String,

    /**
     * Referrer URL.
     */
    val referrer: String? = null,

    /**
     * Intended transition type.
     */
    val transitionType: TransitionType? = null,

    /**
     * Frame id to navigate, if not specified navigates the top frame.
     */
    val frameId: FrameId? = null,

    /**
     * Referrer-policy used for the navigation.
     */
    @pl.wendigo.chrome.protocol.Experimental val referrerPolicy: ReferrerPolicy? = null

)

/**
 * Represents response frame that is returned from [Page#navigate](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigate) operation call.
 * Navigates current page to the given URL.
 *
  
 * @link [Page#navigate](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigate) method documentation.
 * @see [PageOperations.navigate]
 */
data class NavigateResponse(
    /**  
     * Frame id that has navigated (or failed to navigate)  
     */  
    val frameId: FrameId,

    /**  
     * Loader identifier.  
     */  
    val loaderId: pl.wendigo.chrome.api.network.LoaderId? = null,

    /**  
     * User friendly error message, present if and only if navigation has failed.  
     */  
    val errorText: String? = null

)

/**
 * Represents request frame that can be used with [Page#navigateToHistoryEntry](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigateToHistoryEntry) operation call.
 *
 * Navigates current page to the given history entry.
 * @link [Page#navigateToHistoryEntry](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigateToHistoryEntry) method documentation.
 * @see [PageOperations.navigateToHistoryEntry]
 */
data class NavigateToHistoryEntryRequest(
    /**
     * Unique id of the entry to navigate to.
     */
    val entryId: Int

)

/**
 * Represents request frame that can be used with [Page#printToPDF](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-printToPDF) operation call.
 *
 * Print page as PDF.
 * @link [Page#printToPDF](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-printToPDF) method documentation.
 * @see [PageOperations.printToPDF]
 */
data class PrintToPDFRequest(
    /**
     * Paper orientation. Defaults to false.
     */
    val landscape: Boolean? = null,

    /**
     * Display header and footer. Defaults to false.
     */
    val displayHeaderFooter: Boolean? = null,

    /**
     * Print background graphics. Defaults to false.
     */
    val printBackground: Boolean? = null,

    /**
     * Scale of the webpage rendering. Defaults to 1.
     */
    val scale: Double? = null,

    /**
     * Paper width in inches. Defaults to 8.5 inches.
     */
    val paperWidth: Double? = null,

    /**
     * Paper height in inches. Defaults to 11 inches.
     */
    val paperHeight: Double? = null,

    /**
     * Top margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginTop: Double? = null,

    /**
     * Bottom margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginBottom: Double? = null,

    /**
     * Left margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginLeft: Double? = null,

    /**
     * Right margin in inches. Defaults to 1cm (~0.4 inches).
     */
    val marginRight: Double? = null,

    /**
     * Paper ranges to print, e.g., '1-5, 8, 11-13'. Defaults to the empty string, which means
print all pages.
     */
    val pageRanges: String? = null,

    /**
     * Whether to silently ignore invalid but successfully parsed page ranges, such as '3-2'.
Defaults to false.
     */
    val ignoreInvalidPageRanges: Boolean? = null,

    /**
     * HTML template for the print header. Should be valid HTML markup with following
classes used to inject printing values into them:
- `date`: formatted print date
- `title`: document title
- `url`: document location
- `pageNumber`: current page number
- `totalPages`: total pages in the document

For example, `<span class=title></span>` would generate span containing the title.
     */
    val headerTemplate: String? = null,

    /**
     * HTML template for the print footer. Should use the same format as the `headerTemplate`.
     */
    val footerTemplate: String? = null,

    /**
     * Whether or not to prefer page size as defined by css. Defaults to false,
in which case the content will be scaled to fit the paper size.
     */
    val preferCSSPageSize: Boolean? = null,

    /**
     * return as stream
     */
    @pl.wendigo.chrome.protocol.Experimental val transferMode: String? = null

)

/**
 * Represents response frame that is returned from [Page#printToPDF](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-printToPDF) operation call.
 * Print page as PDF.
 *
  
 * @link [Page#printToPDF](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-printToPDF) method documentation.
 * @see [PageOperations.printToPDF]
 */
data class PrintToPDFResponse(
    /**  
     * Base64-encoded pdf data. Empty if |returnAsStream| is specified. (Encoded as a base64 string when passed over JSON)  
     */  
    val data: String,

    /**  
     * A handle of the stream that holds resulting PDF data.  
     */  
    val stream: pl.wendigo.chrome.api.io.StreamHandle? = null

)

/**
 * Represents request frame that can be used with [Page#reload](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-reload) operation call.
 *
 * Reloads given page optionally ignoring the cache.
 * @link [Page#reload](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-reload) method documentation.
 * @see [PageOperations.reload]
 */
data class ReloadRequest(
    /**
     * If true, browser cache is ignored (as if the user pressed Shift+refresh).
     */
    val ignoreCache: Boolean? = null,

    /**
     * If set, the script will be injected into all frames of the inspected page after reload.
Argument will be ignored if reloading dataURL origin.
     */
    val scriptToEvaluateOnLoad: String? = null

)

/**
 * Represents request frame that can be used with [Page#removeScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnLoad) operation call.
 *
 * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
 * @link [Page#removeScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnLoad) method documentation.
 * @see [PageOperations.removeScriptToEvaluateOnLoad]
 */
data class RemoveScriptToEvaluateOnLoadRequest(
    /**
     *
     */
    val identifier: ScriptIdentifier

)

/**
 * Represents request frame that can be used with [Page#removeScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnNewDocument) operation call.
 *
 * Removes given script from the list.
 * @link [Page#removeScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnNewDocument) method documentation.
 * @see [PageOperations.removeScriptToEvaluateOnNewDocument]
 */
data class RemoveScriptToEvaluateOnNewDocumentRequest(
    /**
     *
     */
    val identifier: ScriptIdentifier

)

/**
 * Represents request frame that can be used with [Page#screencastFrameAck](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-screencastFrameAck) operation call.
 *
 * Acknowledges that a screencast frame has been received by the frontend.
 * @link [Page#screencastFrameAck](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-screencastFrameAck) method documentation.
 * @see [PageOperations.screencastFrameAck]
 */
data class ScreencastFrameAckRequest(
    /**
     * Frame number.
     */
    val sessionId: Int

)

/**
 * Represents request frame that can be used with [Page#searchInResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-searchInResource) operation call.
 *
 * Searches for given string in resource content.
 * @link [Page#searchInResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-searchInResource) method documentation.
 * @see [PageOperations.searchInResource]
 */
data class SearchInResourceRequest(
    /**
     * Frame id for resource to search in.
     */
    val frameId: FrameId,

    /**
     * URL of the resource to search in.
     */
    val url: String,

    /**
     * String to search for.
     */
    val query: String,

    /**
     * If true, search is case sensitive.
     */
    val caseSensitive: Boolean? = null,

    /**
     * If true, treats string parameter as regex.
     */
    val isRegex: Boolean? = null

)

/**
 * Represents response frame that is returned from [Page#searchInResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-searchInResource) operation call.
 * Searches for given string in resource content.
 *
  
 * @link [Page#searchInResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-searchInResource) method documentation.
 * @see [PageOperations.searchInResource]
 */
data class SearchInResourceResponse(
    /**  
     * List of search matches.  
     */  
    val result: List<pl.wendigo.chrome.api.debugger.SearchMatch>

)

/**
 * Represents request frame that can be used with [Page#setAdBlockingEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setAdBlockingEnabled) operation call.
 *
 * Enable Chrome's experimental ad filter on all sites.
 * @link [Page#setAdBlockingEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setAdBlockingEnabled) method documentation.
 * @see [PageOperations.setAdBlockingEnabled]
 */
data class SetAdBlockingEnabledRequest(
    /**
     * Whether to block ads.
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Page#setBypassCSP](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setBypassCSP) operation call.
 *
 * Enable page Content Security Policy by-passing.
 * @link [Page#setBypassCSP](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setBypassCSP) method documentation.
 * @see [PageOperations.setBypassCSP]
 */
data class SetBypassCSPRequest(
    /**
     * Whether to bypass page CSP.
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Page#setDeviceMetricsOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceMetricsOverride) operation call.
 *
 * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
query results).
 * @link [Page#setDeviceMetricsOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceMetricsOverride) method documentation.
 * @see [PageOperations.setDeviceMetricsOverride]
 */
data class SetDeviceMetricsOverrideRequest(
    /**
     * Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    val width: Int,

    /**
     * Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    val height: Int,

    /**
     * Overriding device scale factor value. 0 disables the override.
     */
    val deviceScaleFactor: Double,

    /**
     * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text
autosizing and more.
     */
    val mobile: Boolean,

    /**
     * Scale to apply to resulting view image.
     */
    val scale: Double? = null,

    /**
     * Overriding screen width value in pixels (minimum 0, maximum 10000000).
     */
    val screenWidth: Int? = null,

    /**
     * Overriding screen height value in pixels (minimum 0, maximum 10000000).
     */
    val screenHeight: Int? = null,

    /**
     * Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
     */
    val positionX: Int? = null,

    /**
     * Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
     */
    val positionY: Int? = null,

    /**
     * Do not set visible view size, rely upon explicit setVisibleSize call.
     */
    val dontSetVisibleSize: Boolean? = null,

    /**
     * Screen orientation override.
     */
    val screenOrientation: pl.wendigo.chrome.api.emulation.ScreenOrientation? = null,

    /**
     * The viewport dimensions and scale. If not set, the override is cleared.
     */
    val viewport: Viewport? = null

)

/**
 * Represents request frame that can be used with [Page#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceOrientationOverride) operation call.
 *
 * Overrides the Device Orientation.
 * @link [Page#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceOrientationOverride) method documentation.
 * @see [PageOperations.setDeviceOrientationOverride]
 */
data class SetDeviceOrientationOverrideRequest(
    /**
     * Mock alpha
     */
    val alpha: Double,

    /**
     * Mock beta
     */
    val beta: Double,

    /**
     * Mock gamma
     */
    val gamma: Double

)

/**
 * Represents request frame that can be used with [Page#setFontFamilies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontFamilies) operation call.
 *
 * Set generic font families.
 * @link [Page#setFontFamilies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontFamilies) method documentation.
 * @see [PageOperations.setFontFamilies]
 */
data class SetFontFamiliesRequest(
    /**
     * Specifies font families to set. If a font family is not specified, it won't be changed.
     */
    val fontFamilies: FontFamilies

)

/**
 * Represents request frame that can be used with [Page#setFontSizes](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontSizes) operation call.
 *
 * Set default font sizes.
 * @link [Page#setFontSizes](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontSizes) method documentation.
 * @see [PageOperations.setFontSizes]
 */
data class SetFontSizesRequest(
    /**
     * Specifies font sizes to set. If a font size is not specified, it won't be changed.
     */
    val fontSizes: FontSizes

)

/**
 * Represents request frame that can be used with [Page#setDocumentContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDocumentContent) operation call.
 *
 * Sets given markup as the document's HTML.
 * @link [Page#setDocumentContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDocumentContent) method documentation.
 * @see [PageOperations.setDocumentContent]
 */
data class SetDocumentContentRequest(
    /**
     * Frame id to set HTML for.
     */
    val frameId: FrameId,

    /**
     * HTML content to set.
     */
    val html: String

)

/**
 * Represents request frame that can be used with [Page#setDownloadBehavior](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDownloadBehavior) operation call.
 *
 * Set the behavior when downloading a file.
 * @link [Page#setDownloadBehavior](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDownloadBehavior) method documentation.
 * @see [PageOperations.setDownloadBehavior]
 */
data class SetDownloadBehaviorRequest(
    /**
     * Whether to allow all or deny all download requests, or use default Chrome behavior if
available (otherwise deny).
     */
    val behavior: String,

    /**
     * The default path to save downloaded files to. This is requred if behavior is set to 'allow'
     */
    val downloadPath: String? = null

)

/**
 * Represents request frame that can be used with [Page#setGeolocationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setGeolocationOverride) operation call.
 *
 * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position
unavailable.
 * @link [Page#setGeolocationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setGeolocationOverride) method documentation.
 * @see [PageOperations.setGeolocationOverride]
 */
data class SetGeolocationOverrideRequest(
    /**
     * Mock latitude
     */
    val latitude: Double? = null,

    /**
     * Mock longitude
     */
    val longitude: Double? = null,

    /**
     * Mock accuracy
     */
    val accuracy: Double? = null

)

/**
 * Represents request frame that can be used with [Page#setLifecycleEventsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setLifecycleEventsEnabled) operation call.
 *
 * Controls whether page will emit lifecycle events.
 * @link [Page#setLifecycleEventsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setLifecycleEventsEnabled) method documentation.
 * @see [PageOperations.setLifecycleEventsEnabled]
 */
data class SetLifecycleEventsEnabledRequest(
    /**
     * If true, starts emitting lifecycle events.
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Page#setTouchEmulationEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setTouchEmulationEnabled) operation call.
 *
 * Toggles mouse event-based touch event emulation.
 * @link [Page#setTouchEmulationEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setTouchEmulationEnabled) method documentation.
 * @see [PageOperations.setTouchEmulationEnabled]
 */
data class SetTouchEmulationEnabledRequest(
    /**
     * Whether the touch event emulation should be enabled.
     */
    val enabled: Boolean,

    /**
     * Touch/gesture events configuration. Default: current platform.
     */
    val configuration: String? = null

)

/**
 * Represents request frame that can be used with [Page#startScreencast](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-startScreencast) operation call.
 *
 * Starts sending each frame using the `screencastFrame` event.
 * @link [Page#startScreencast](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-startScreencast) method documentation.
 * @see [PageOperations.startScreencast]
 */
data class StartScreencastRequest(
    /**
     * Image compression format.
     */
    val format: String? = null,

    /**
     * Compression quality from range [0..100].
     */
    val quality: Int? = null,

    /**
     * Maximum screenshot width.
     */
    val maxWidth: Int? = null,

    /**
     * Maximum screenshot height.
     */
    val maxHeight: Int? = null,

    /**
     * Send every n-th frame.
     */
    val everyNthFrame: Int? = null

)

/**
 * Represents request frame that can be used with [Page#setWebLifecycleState](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setWebLifecycleState) operation call.
 *
 * Tries to update the web lifecycle state of the page.
It will transition the page to the given state according to:
https://github.com/WICG/web-lifecycle/
 * @link [Page#setWebLifecycleState](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setWebLifecycleState) method documentation.
 * @see [PageOperations.setWebLifecycleState]
 */
data class SetWebLifecycleStateRequest(
    /**
     * Target lifecycle state
     */
    val state: String

)

/**
 * Represents request frame that can be used with [Page#setProduceCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setProduceCompilationCache) operation call.
 *
 * Forces compilation cache to be generated for every subresource script.
 * @link [Page#setProduceCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setProduceCompilationCache) method documentation.
 * @see [PageOperations.setProduceCompilationCache]
 */
data class SetProduceCompilationCacheRequest(
    /**
     *
     */
    val enabled: Boolean

)

/**
 * Represents request frame that can be used with [Page#addCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addCompilationCache) operation call.
 *
 * Seeds compilation cache for given url. Compilation cache does not survive
cross-process navigation.
 * @link [Page#addCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addCompilationCache) method documentation.
 * @see [PageOperations.addCompilationCache]
 */
data class AddCompilationCacheRequest(
    /**
     *
     */
    val url: String,

    /**
     * Base64-encoded data (Encoded as a base64 string when passed over JSON)
     */
    val data: String

)

/**
 * Represents request frame that can be used with [Page#generateTestReport](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-generateTestReport) operation call.
 *
 * Generates a report for testing.
 * @link [Page#generateTestReport](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-generateTestReport) method documentation.
 * @see [PageOperations.generateTestReport]
 */
data class GenerateTestReportRequest(
    /**
     * Message to be displayed in the report.
     */
    val message: String,

    /**
     * Specifies the endpoint group to deliver the report to.
     */
    val group: String? = null

)

/**
 * Represents request frame that can be used with [Page#setInterceptFileChooserDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setInterceptFileChooserDialog) operation call.
 *
 * Intercept file chooser requests and transfer control to protocol clients.
When file chooser interception is enabled, native file chooser dialog is not shown.
Instead, a protocol event `Page.fileChooserOpened` is emitted.
 * @link [Page#setInterceptFileChooserDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setInterceptFileChooserDialog) method documentation.
 * @see [PageOperations.setInterceptFileChooserDialog]
 */
data class SetInterceptFileChooserDialogRequest(
    /**
     *
     */
    val enabled: Boolean

)

/**
 *
 *
 * @link [Page#domContentEventFired](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-domContentEventFired) event documentation.
 */
data class DomContentEventFiredEvent(
    /**  
     *  
     */  
    val timestamp: pl.wendigo.chrome.api.network.MonotonicTime

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "domContentEventFired")

/**
 * Emitted only when `page.interceptFileChooser` is enabled.
 *
 * @link [Page#fileChooserOpened](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-fileChooserOpened) event documentation.
 */
data class FileChooserOpenedEvent(
    /**  
     * Id of the frame containing input node.  
     */  
    val frameId: FrameId,

    /**  
     * Input node id.  
     */  
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId,

    /**  
     * Input mode.  
     */  
    val mode: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "fileChooserOpened")

/**
 * Fired when frame has been attached to its parent.
 *
 * @link [Page#frameAttached](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameAttached) event documentation.
 */
data class FrameAttachedEvent(
    /**  
     * Id of the frame that has been attached.  
     */  
    val frameId: FrameId,

    /**  
     * Parent frame identifier.  
     */  
    val parentFrameId: FrameId,

    /**  
     * JavaScript stack trace of when frame was attached, only set if frame initiated from script.  
     */  
    val stack: pl.wendigo.chrome.api.runtime.StackTrace? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameAttached")

/**
 * Fired when frame no longer has a scheduled navigation.
 *
 * @link [Page#frameClearedScheduledNavigation](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameClearedScheduledNavigation) event documentation.
 */
data class FrameClearedScheduledNavigationEvent(
    /**  
     * Id of the frame that has cleared its scheduled navigation.  
     */  
    val frameId: FrameId

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameClearedScheduledNavigation")

/**
 * Fired when frame has been detached from its parent.
 *
 * @link [Page#frameDetached](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameDetached) event documentation.
 */
data class FrameDetachedEvent(
    /**  
     * Id of the frame that has been detached.  
     */  
    val frameId: FrameId,

    /**  
     *  
     */  
    val reason: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameDetached")

/**
 * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
 *
 * @link [Page#frameNavigated](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameNavigated) event documentation.
 */
data class FrameNavigatedEvent(
    /**  
     * Frame object.  
     */  
    val frame: Frame

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameNavigated")

/**
 * Fired when opening document to write to.
 *
 * @link [Page#documentOpened](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-documentOpened) event documentation.
 */
data class DocumentOpenedEvent(
    /**  
     * Frame object.  
     */  
    val frame: Frame

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "documentOpened")

/**
 * Fired when a renderer-initiated navigation is requested.
Navigation may still be cancelled after the event is issued.
 *
 * @link [Page#frameRequestedNavigation](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameRequestedNavigation) event documentation.
 */
data class FrameRequestedNavigationEvent(
    /**  
     * Id of the frame that is being navigated.  
     */  
    val frameId: FrameId,

    /**  
     * The reason for the navigation.  
     */  
    val reason: ClientNavigationReason,

    /**  
     * The destination URL for the requested navigation.  
     */  
    val url: String,

    /**  
     * The disposition for the navigation.  
     */  
    val disposition: ClientNavigationDisposition

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameRequestedNavigation")

/**
 * Fired when frame schedules a potential navigation.
 *
 * @link [Page#frameScheduledNavigation](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameScheduledNavigation) event documentation.
 */
data class FrameScheduledNavigationEvent(
    /**  
     * Id of the frame that has scheduled a navigation.  
     */  
    val frameId: FrameId,

    /**  
     * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not  
     guaranteed to start.  
     */  
    val delay: Double,

    /**  
     * The reason for the navigation.  
     */  
    val reason: ClientNavigationReason,

    /**  
     * The destination URL for the scheduled navigation.  
     */  
    val url: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameScheduledNavigation")

/**
 * Fired when frame has started loading.
 *
 * @link [Page#frameStartedLoading](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameStartedLoading) event documentation.
 */
data class FrameStartedLoadingEvent(
    /**  
     * Id of the frame that has started loading.  
     */  
    val frameId: FrameId

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameStartedLoading")

/**
 * Fired when frame has stopped loading.
 *
 * @link [Page#frameStoppedLoading](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-frameStoppedLoading) event documentation.
 */
data class FrameStoppedLoadingEvent(
    /**  
     * Id of the frame that has stopped loading.  
     */  
    val frameId: FrameId

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "frameStoppedLoading")

/**
 * Fired when page is about to start a download.
 *
 * @link [Page#downloadWillBegin](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-downloadWillBegin) event documentation.
 */
data class DownloadWillBeginEvent(
    /**  
     * Id of the frame that caused download to begin.  
     */  
    val frameId: FrameId,

    /**  
     * Global unique identifier of the download.  
     */  
    val guid: String,

    /**  
     * URL of the resource being downloaded.  
     */  
    val url: String,

    /**  
     * Suggested file name of the resource (the actual name of the file saved on disk may differ).  
     */  
    val suggestedFilename: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "downloadWillBegin")

/**
 * Fired when download makes progress. Last call has |done| == true.
 *
 * @link [Page#downloadProgress](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-downloadProgress) event documentation.
 */
data class DownloadProgressEvent(
    /**  
     * Global unique identifier of the download.  
     */  
    val guid: String,

    /**  
     * Total expected bytes to download.  
     */  
    val totalBytes: Double,

    /**  
     * Total bytes received.  
     */  
    val receivedBytes: Double,

    /**  
     * Download status.  
     */  
    val state: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "downloadProgress")

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
closed.
 *
 * @link [Page#javascriptDialogClosed](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-javascriptDialogClosed) event documentation.
 */
data class JavascriptDialogClosedEvent(
    /**  
     * Whether dialog was confirmed.  
     */  
    val result: Boolean,

    /**  
     * User input in case of prompt.  
     */  
    val userInput: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "javascriptDialogClosed")

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
open.
 *
 * @link [Page#javascriptDialogOpening](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-javascriptDialogOpening) event documentation.
 */
data class JavascriptDialogOpeningEvent(
    /**  
     * Frame url.  
     */  
    val url: String,

    /**  
     * Message that will be displayed by the dialog.  
     */  
    val message: String,

    /**  
     * Dialog type.  
     */  
    val type: DialogType,

    /**  
     * True iff browser is capable showing or acting on the given dialog. When browser has no  
     dialog handler for given target, calling alert while Page domain is engaged will stall  
     the page execution. Execution can be resumed via calling Page.handleJavaScriptDialog.  
     */  
    val hasBrowserHandler: Boolean,

    /**  
     * Default dialog prompt.  
     */  
    val defaultPrompt: String? = null

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "javascriptDialogOpening")

/**
 * Fired for top level page lifecycle events such as navigation, load, paint, etc.
 *
 * @link [Page#lifecycleEvent](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-lifecycleEvent) event documentation.
 */
data class LifecycleEventEvent(
    /**  
     * Id of the frame.  
     */  
    val frameId: FrameId,

    /**  
     * Loader identifier. Empty string if the request is fetched from worker.  
     */  
    val loaderId: pl.wendigo.chrome.api.network.LoaderId,

    /**  
     *  
     */  
    val name: String,

    /**  
     *  
     */  
    val timestamp: pl.wendigo.chrome.api.network.MonotonicTime

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "lifecycleEvent")

/**
 *
 *
 * @link [Page#loadEventFired](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-loadEventFired) event documentation.
 */
data class LoadEventFiredEvent(
    /**  
     *  
     */  
    val timestamp: pl.wendigo.chrome.api.network.MonotonicTime

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "loadEventFired")

/**
 * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
 *
 * @link [Page#navigatedWithinDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-navigatedWithinDocument) event documentation.
 */
data class NavigatedWithinDocumentEvent(
    /**  
     * Id of the frame.  
     */  
    val frameId: FrameId,

    /**  
     * Frame's new url.  
     */  
    val url: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "navigatedWithinDocument")

/**
 * Compressed image data requested by the `startScreencast`.
 *
 * @link [Page#screencastFrame](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-screencastFrame) event documentation.
 */
data class ScreencastFrameEvent(
    /**  
     * Base64-encoded compressed image. (Encoded as a base64 string when passed over JSON)  
     */  
    val data: String,

    /**  
     * Screencast frame metadata.  
     */  
    val metadata: ScreencastFrameMetadata,

    /**  
     * Frame number.  
     */  
    val sessionId: Int

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "screencastFrame")

/**
 * Fired when the page with currently enabled screencast was shown or hidden `.
 *
 * @link [Page#screencastVisibilityChanged](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-screencastVisibilityChanged) event documentation.
 */
data class ScreencastVisibilityChangedEvent(
    /**  
     * True if the page is visible.  
     */  
    val visible: Boolean

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "screencastVisibilityChanged")

/**
 * Fired when a new window is going to be opened, via window.open(), link click, form submission,
etc.
 *
 * @link [Page#windowOpen](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-windowOpen) event documentation.
 */
data class WindowOpenEvent(
    /**  
     * The URL for the new window.  
     */  
    val url: String,

    /**  
     * Window name.  
     */  
    val windowName: String,

    /**  
     * An array of enabled window features.  
     */  
    val windowFeatures: List<String>,

    /**  
     * Whether or not it was triggered by user gesture.  
     */  
    val userGesture: Boolean

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "windowOpen")

/**
 * Issued for every compilation cache generated. Is only available
if Page.setGenerateCompilationCache is enabled.
 *
 * @link [Page#compilationCacheProduced](https://chromedevtools.github.io/devtools-protocol/tot/Page#event-compilationCacheProduced) event documentation.
 */
data class CompilationCacheProducedEvent(
    /**  
     *  
     */  
    val url: String,

    /**  
     * Base64-encoded data (Encoded as a base64 string when passed over JSON)  
     */  
    val data: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "compilationCacheProduced")
