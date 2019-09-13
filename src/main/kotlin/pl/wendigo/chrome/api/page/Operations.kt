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
    fun addScriptToEvaluateOnLoad(input: AddScriptToEvaluateOnLoadRequest): io.reactivex.Single<AddScriptToEvaluateOnLoadResponse> {
        return connection.runAndCaptureResponse("Page.addScriptToEvaluateOnLoad", input, AddScriptToEvaluateOnLoadResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Evaluates given script in every frame upon creation (before loading frame's scripts).
     *
     * @link Protocol [Page#addScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addScriptToEvaluateOnNewDocument) method documentation.
     */
    fun addScriptToEvaluateOnNewDocument(input: AddScriptToEvaluateOnNewDocumentRequest): io.reactivex.Single<AddScriptToEvaluateOnNewDocumentResponse> {
        return connection.runAndCaptureResponse("Page.addScriptToEvaluateOnNewDocument", input, AddScriptToEvaluateOnNewDocumentResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Brings page to front (activates tab).
     *
     * @link Protocol [Page#bringToFront](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-bringToFront) method documentation.
     */
    fun bringToFront(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.bringToFront", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Capture page screenshot.
     *
     * @link Protocol [Page#captureScreenshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureScreenshot) method documentation.
     */
    fun captureScreenshot(input: CaptureScreenshotRequest): io.reactivex.Single<CaptureScreenshotResponse> {
        return connection.runAndCaptureResponse("Page.captureScreenshot", input, CaptureScreenshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
iframes, shadow DOM, external resources, and element-inline styles.
     *
     * @link Protocol [Page#captureSnapshot](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-captureSnapshot) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun captureSnapshot(input: CaptureSnapshotRequest): io.reactivex.Single<CaptureSnapshotResponse> {
        return connection.runAndCaptureResponse("Page.captureSnapshot", input, CaptureSnapshotResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Clears the overriden device metrics.
     *
     * @link Protocol [Page#clearDeviceMetricsOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearDeviceMetricsOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "clearDeviceMetricsOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun clearDeviceMetricsOverride(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.clearDeviceMetricsOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears the overridden Device Orientation.
     *
     * @link Protocol [Page#clearDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearDeviceOrientationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "clearDeviceOrientationOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun clearDeviceOrientationOverride(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.clearDeviceOrientationOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears the overriden Geolocation Position and Error.
     *
     * @link Protocol [Page#clearGeolocationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearGeolocationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "clearGeolocationOverride is deprecated.")
    fun clearGeolocationOverride(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.clearGeolocationOverride", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Creates an isolated world for the given frame.
     *
     * @link Protocol [Page#createIsolatedWorld](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-createIsolatedWorld) method documentation.
     */
    fun createIsolatedWorld(input: CreateIsolatedWorldRequest): io.reactivex.Single<CreateIsolatedWorldResponse> {
        return connection.runAndCaptureResponse("Page.createIsolatedWorld", input, CreateIsolatedWorldResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Deletes browser cookie with given name, domain and path.
     *
     * @link Protocol [Page#deleteCookie](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-deleteCookie) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "deleteCookie is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun deleteCookie(input: DeleteCookieRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.deleteCookie", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Disables page domain notifications.
     *
     * @link Protocol [Page#disable](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables page domain notifications.
     *
     * @link Protocol [Page#enable](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-enable) method documentation.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     *
     * @link Protocol [Page#getAppManifest](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getAppManifest) method documentation.
     */
    fun getAppManifest(): io.reactivex.Single<GetAppManifestResponse> {
        return connection.runAndCaptureResponse("Page.getAppManifest", null, GetAppManifestResponse::class.java).map {
            it.value()
        }
    }

    /**
     *
     *
     * @link Protocol [Page#getInstallabilityErrors](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getInstallabilityErrors) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getInstallabilityErrors(): io.reactivex.Single<GetInstallabilityErrorsResponse> {
        return connection.runAndCaptureResponse("Page.getInstallabilityErrors", null, GetInstallabilityErrorsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all browser cookies. Depending on the backend support, will return detailed cookie
information in the `cookies` field.
     *
     * @link Protocol [Page#getCookies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getCookies) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "getCookies is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getCookies(): io.reactivex.Single<GetCookiesResponse> {
        return connection.runAndCaptureResponse("Page.getCookies", null, GetCookiesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns present frame tree structure.
     *
     * @link Protocol [Page#getFrameTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getFrameTree) method documentation.
     */
    fun getFrameTree(): io.reactivex.Single<GetFrameTreeResponse> {
        return connection.runAndCaptureResponse("Page.getFrameTree", null, GetFrameTreeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
     *
     * @link Protocol [Page#getLayoutMetrics](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getLayoutMetrics) method documentation.
     */
    fun getLayoutMetrics(): io.reactivex.Single<GetLayoutMetricsResponse> {
        return connection.runAndCaptureResponse("Page.getLayoutMetrics", null, GetLayoutMetricsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns navigation history for the current page.
     *
     * @link Protocol [Page#getNavigationHistory](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getNavigationHistory) method documentation.
     */
    fun getNavigationHistory(): io.reactivex.Single<GetNavigationHistoryResponse> {
        return connection.runAndCaptureResponse("Page.getNavigationHistory", null, GetNavigationHistoryResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Resets navigation history for the current page.
     *
     * @link Protocol [Page#resetNavigationHistory](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-resetNavigationHistory) method documentation.
     */
    fun resetNavigationHistory(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.resetNavigationHistory", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns content of the given resource.
     *
     * @link Protocol [Page#getResourceContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceContent) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getResourceContent(input: GetResourceContentRequest): io.reactivex.Single<GetResourceContentResponse> {
        return connection.runAndCaptureResponse("Page.getResourceContent", input, GetResourceContentResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns present frame / resource tree structure.
     *
     * @link Protocol [Page#getResourceTree](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-getResourceTree) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getResourceTree(): io.reactivex.Single<GetResourceTreeResponse> {
        return connection.runAndCaptureResponse("Page.getResourceTree", null, GetResourceTreeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
     *
     * @link Protocol [Page#handleJavaScriptDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleJavaScriptDialog) method documentation.
     */
    fun handleJavaScriptDialog(input: HandleJavaScriptDialogRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.handleJavaScriptDialog", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Navigates current page to the given URL.
     *
     * @link Protocol [Page#navigate](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigate) method documentation.
     */
    fun navigate(input: NavigateRequest): io.reactivex.Single<NavigateResponse> {
        return connection.runAndCaptureResponse("Page.navigate", input, NavigateResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Navigates current page to the given history entry.
     *
     * @link Protocol [Page#navigateToHistoryEntry](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-navigateToHistoryEntry) method documentation.
     */
    fun navigateToHistoryEntry(input: NavigateToHistoryEntryRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.navigateToHistoryEntry", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Print page as PDF.
     *
     * @link Protocol [Page#printToPDF](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-printToPDF) method documentation.
     */
    fun printToPDF(input: PrintToPDFRequest): io.reactivex.Single<PrintToPDFResponse> {
        return connection.runAndCaptureResponse("Page.printToPDF", input, PrintToPDFResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Reloads given page optionally ignoring the cache.
     *
     * @link Protocol [Page#reload](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-reload) method documentation.
     */
    fun reload(input: ReloadRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.reload", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
     *
     * @link Protocol [Page#removeScriptToEvaluateOnLoad](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnLoad) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "removeScriptToEvaluateOnLoad is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun removeScriptToEvaluateOnLoad(input: RemoveScriptToEvaluateOnLoadRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.removeScriptToEvaluateOnLoad", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes given script from the list.
     *
     * @link Protocol [Page#removeScriptToEvaluateOnNewDocument](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-removeScriptToEvaluateOnNewDocument) method documentation.
     */
    fun removeScriptToEvaluateOnNewDocument(input: RemoveScriptToEvaluateOnNewDocumentRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.removeScriptToEvaluateOnNewDocument", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Acknowledges that a screencast frame has been received by the frontend.
     *
     * @link Protocol [Page#screencastFrameAck](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-screencastFrameAck) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun screencastFrameAck(input: ScreencastFrameAckRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.screencastFrameAck", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Searches for given string in resource content.
     *
     * @link Protocol [Page#searchInResource](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-searchInResource) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun searchInResource(input: SearchInResourceRequest): io.reactivex.Single<SearchInResourceResponse> {
        return connection.runAndCaptureResponse("Page.searchInResource", input, SearchInResourceResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Enable Chrome's experimental ad filter on all sites.
     *
     * @link Protocol [Page#setAdBlockingEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setAdBlockingEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setAdBlockingEnabled(input: SetAdBlockingEnabledRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setAdBlockingEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enable page Content Security Policy by-passing.
     *
     * @link Protocol [Page#setBypassCSP](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setBypassCSP) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setBypassCSP(input: SetBypassCSPRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setBypassCSP", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
query results).
     *
     * @link Protocol [Page#setDeviceMetricsOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceMetricsOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setDeviceMetricsOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDeviceMetricsOverride(input: SetDeviceMetricsOverrideRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setDeviceMetricsOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the Device Orientation.
     *
     * @link Protocol [Page#setDeviceOrientationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDeviceOrientationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setDeviceOrientationOverride is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDeviceOrientationOverride(input: SetDeviceOrientationOverrideRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setDeviceOrientationOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Set generic font families.
     *
     * @link Protocol [Page#setFontFamilies](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontFamilies) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setFontFamilies(input: SetFontFamiliesRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setFontFamilies", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Set default font sizes.
     *
     * @link Protocol [Page#setFontSizes](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setFontSizes) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setFontSizes(input: SetFontSizesRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setFontSizes", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets given markup as the document's HTML.
     *
     * @link Protocol [Page#setDocumentContent](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDocumentContent) method documentation.
     */
    fun setDocumentContent(input: SetDocumentContentRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setDocumentContent", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Set the behavior when downloading a file.
     *
     * @link Protocol [Page#setDownloadBehavior](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setDownloadBehavior) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setDownloadBehavior(input: SetDownloadBehaviorRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setDownloadBehavior", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position
unavailable.
     *
     * @link Protocol [Page#setGeolocationOverride](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setGeolocationOverride) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setGeolocationOverride is deprecated.")
    fun setGeolocationOverride(input: SetGeolocationOverrideRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setGeolocationOverride", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Controls whether page will emit lifecycle events.
     *
     * @link Protocol [Page#setLifecycleEventsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setLifecycleEventsEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setLifecycleEventsEnabled(input: SetLifecycleEventsEnabledRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setLifecycleEventsEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Toggles mouse event-based touch event emulation.
     *
     * @link Protocol [Page#setTouchEmulationEnabled](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setTouchEmulationEnabled) method documentation.
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "setTouchEmulationEnabled is deprecated.")
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setTouchEmulationEnabled(input: SetTouchEmulationEnabledRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setTouchEmulationEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Starts sending each frame using the `screencastFrame` event.
     *
     * @link Protocol [Page#startScreencast](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-startScreencast) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun startScreencast(input: StartScreencastRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.startScreencast", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Force the page stop all navigations and pending resource fetches.
     *
     * @link Protocol [Page#stopLoading](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-stopLoading) method documentation.
     */
    fun stopLoading(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.stopLoading", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Crashes renderer on the IO thread, generates minidumps.
     *
     * @link Protocol [Page#crash](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-crash) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun crash(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.crash", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Tries to close page, running its beforeunload hooks, if any.
     *
     * @link Protocol [Page#close](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-close) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun close(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.close", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Tries to update the web lifecycle state of the page.
It will transition the page to the given state according to:
https://github.com/WICG/web-lifecycle/
     *
     * @link Protocol [Page#setWebLifecycleState](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setWebLifecycleState) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setWebLifecycleState(input: SetWebLifecycleStateRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setWebLifecycleState", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stops sending each frame in the `screencastFrame`.
     *
     * @link Protocol [Page#stopScreencast](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-stopScreencast) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun stopScreencast(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.stopScreencast", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Forces compilation cache to be generated for every subresource script.
     *
     * @link Protocol [Page#setProduceCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setProduceCompilationCache) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setProduceCompilationCache(input: SetProduceCompilationCacheRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setProduceCompilationCache", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Seeds compilation cache for given url. Compilation cache does not survive
cross-process navigation.
     *
     * @link Protocol [Page#addCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-addCompilationCache) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun addCompilationCache(input: AddCompilationCacheRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.addCompilationCache", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Clears seeded compilation cache.
     *
     * @link Protocol [Page#clearCompilationCache](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-clearCompilationCache) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun clearCompilationCache(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.clearCompilationCache", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Generates a report for testing.
     *
     * @link Protocol [Page#generateTestReport](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-generateTestReport) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun generateTestReport(input: GenerateTestReportRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.generateTestReport", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
     *
     * @link Protocol [Page#waitForDebugger](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-waitForDebugger) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun waitForDebugger(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.waitForDebugger", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Intercept file chooser requests and transfer control to protocol clients.
When file chooser interception is enabled, native file chooser dialog is not shown.
Instead, a protocol event `Page.fileChooserOpened` is emitted.
File chooser can be handled with `page.handleFileChooser` command.
     *
     * @link Protocol [Page#setInterceptFileChooserDialog](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-setInterceptFileChooserDialog) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setInterceptFileChooserDialog(input: SetInterceptFileChooserDialogRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.setInterceptFileChooserDialog", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Accepts or cancels an intercepted file chooser dialog.
     *
     * @link Protocol [Page#handleFileChooser](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleFileChooser) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun handleFileChooser(input: HandleFileChooserRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("Page.handleFileChooser", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *  Returns observable capturing all Page.domContentEventFired events.
     */
    fun domContentEventFired(): io.reactivex.Flowable<DomContentEventFiredEvent> {
        return domContentEventFiredTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.domContentEventFired events.
     */
    fun domContentEventFiredTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<DomContentEventFiredEvent>> {
        return connection.captureEvents("Page.domContentEventFired", DomContentEventFiredEvent::class.java)
    }

    /**
     *  Emitted only when `page.interceptFileChooser` is enabled.
     */
    fun fileChooserOpened(): io.reactivex.Flowable<FileChooserOpenedEvent> {
        return fileChooserOpenedTimed().map {
            it.value()
        }
    }

    /**
     * Emitted only when `page.interceptFileChooser` is enabled.
     */
    fun fileChooserOpenedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FileChooserOpenedEvent>> {
        return connection.captureEvents("Page.fileChooserOpened", FileChooserOpenedEvent::class.java)
    }

    /**
     *  Fired when frame has been attached to its parent.
     */
    fun frameAttached(): io.reactivex.Flowable<FrameAttachedEvent> {
        return frameAttachedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has been attached to its parent.
     */
    fun frameAttachedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameAttachedEvent>> {
        return connection.captureEvents("Page.frameAttached", FrameAttachedEvent::class.java)
    }

    /**
     *  Fired when frame no longer has a scheduled navigation.
     */
    fun frameClearedScheduledNavigation(): io.reactivex.Flowable<FrameClearedScheduledNavigationEvent> {
        return frameClearedScheduledNavigationTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame no longer has a scheduled navigation.
     */
    fun frameClearedScheduledNavigationTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameClearedScheduledNavigationEvent>> {
        return connection.captureEvents("Page.frameClearedScheduledNavigation", FrameClearedScheduledNavigationEvent::class.java)
    }

    /**
     *  Fired when frame has been detached from its parent.
     */
    fun frameDetached(): io.reactivex.Flowable<FrameDetachedEvent> {
        return frameDetachedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has been detached from its parent.
     */
    fun frameDetachedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameDetachedEvent>> {
        return connection.captureEvents("Page.frameDetached", FrameDetachedEvent::class.java)
    }

    /**
     *  Fired once navigation of the frame has completed. Frame is now associated with the new loader.
     */
    fun frameNavigated(): io.reactivex.Flowable<FrameNavigatedEvent> {
        return frameNavigatedTimed().map {
            it.value()
        }
    }

    /**
     * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
     */
    fun frameNavigatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameNavigatedEvent>> {
        return connection.captureEvents("Page.frameNavigated", FrameNavigatedEvent::class.java)
    }

    /**
     *  Returns observable capturing all Page.frameResized events.
     */
    fun frameResized(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return frameResizedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.frameResized events.
     */
    fun frameResizedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.protocol.Event>> {
        return connection.captureEvents("Page.frameResized", pl.wendigo.chrome.protocol.Event::class.java)
    }

    /**
     *  Fired when a renderer-initiated navigation is requested.
Navigation may still be cancelled after the event is issued.
     */
    fun frameRequestedNavigation(): io.reactivex.Flowable<FrameRequestedNavigationEvent> {
        return frameRequestedNavigationTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a renderer-initiated navigation is requested.
Navigation may still be cancelled after the event is issued.
     */
    fun frameRequestedNavigationTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameRequestedNavigationEvent>> {
        return connection.captureEvents("Page.frameRequestedNavigation", FrameRequestedNavigationEvent::class.java)
    }

    /**
     *  Fired when frame schedules a potential navigation.
     */
    fun frameScheduledNavigation(): io.reactivex.Flowable<FrameScheduledNavigationEvent> {
        return frameScheduledNavigationTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame schedules a potential navigation.
     */
    fun frameScheduledNavigationTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameScheduledNavigationEvent>> {
        return connection.captureEvents("Page.frameScheduledNavigation", FrameScheduledNavigationEvent::class.java)
    }

    /**
     *  Fired when frame has started loading.
     */
    fun frameStartedLoading(): io.reactivex.Flowable<FrameStartedLoadingEvent> {
        return frameStartedLoadingTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has started loading.
     */
    fun frameStartedLoadingTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameStartedLoadingEvent>> {
        return connection.captureEvents("Page.frameStartedLoading", FrameStartedLoadingEvent::class.java)
    }

    /**
     *  Fired when frame has stopped loading.
     */
    fun frameStoppedLoading(): io.reactivex.Flowable<FrameStoppedLoadingEvent> {
        return frameStoppedLoadingTimed().map {
            it.value()
        }
    }

    /**
     * Fired when frame has stopped loading.
     */
    fun frameStoppedLoadingTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FrameStoppedLoadingEvent>> {
        return connection.captureEvents("Page.frameStoppedLoading", FrameStoppedLoadingEvent::class.java)
    }

    /**
     *  Fired when page is about to start a download.
     */
    fun downloadWillBegin(): io.reactivex.Flowable<DownloadWillBeginEvent> {
        return downloadWillBeginTimed().map {
            it.value()
        }
    }

    /**
     * Fired when page is about to start a download.
     */
    fun downloadWillBeginTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<DownloadWillBeginEvent>> {
        return connection.captureEvents("Page.downloadWillBegin", DownloadWillBeginEvent::class.java)
    }

    /**
     *  Fired when interstitial page was hidden
     */
    fun interstitialHidden(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return interstitialHiddenTimed().map {
            it.value()
        }
    }

    /**
     * Fired when interstitial page was hidden
     */
    fun interstitialHiddenTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.protocol.Event>> {
        return connection.captureEvents("Page.interstitialHidden", pl.wendigo.chrome.protocol.Event::class.java)
    }

    /**
     *  Fired when interstitial page was shown
     */
    fun interstitialShown(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return interstitialShownTimed().map {
            it.value()
        }
    }

    /**
     * Fired when interstitial page was shown
     */
    fun interstitialShownTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.protocol.Event>> {
        return connection.captureEvents("Page.interstitialShown", pl.wendigo.chrome.protocol.Event::class.java)
    }

    /**
     *  Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
closed.
     */
    fun javascriptDialogClosed(): io.reactivex.Flowable<JavascriptDialogClosedEvent> {
        return javascriptDialogClosedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
closed.
     */
    fun javascriptDialogClosedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<JavascriptDialogClosedEvent>> {
        return connection.captureEvents("Page.javascriptDialogClosed", JavascriptDialogClosedEvent::class.java)
    }

    /**
     *  Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
open.
     */
    fun javascriptDialogOpening(): io.reactivex.Flowable<JavascriptDialogOpeningEvent> {
        return javascriptDialogOpeningTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
open.
     */
    fun javascriptDialogOpeningTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<JavascriptDialogOpeningEvent>> {
        return connection.captureEvents("Page.javascriptDialogOpening", JavascriptDialogOpeningEvent::class.java)
    }

    /**
     *  Fired for top level page lifecycle events such as navigation, load, paint, etc.
     */
    fun lifecycleEvent(): io.reactivex.Flowable<LifecycleEventEvent> {
        return lifecycleEventTimed().map {
            it.value()
        }
    }

    /**
     * Fired for top level page lifecycle events such as navigation, load, paint, etc.
     */
    fun lifecycleEventTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<LifecycleEventEvent>> {
        return connection.captureEvents("Page.lifecycleEvent", LifecycleEventEvent::class.java)
    }

    /**
     *  Returns observable capturing all Page.loadEventFired events.
     */
    fun loadEventFired(): io.reactivex.Flowable<LoadEventFiredEvent> {
        return loadEventFiredTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all Page.loadEventFired events.
     */
    fun loadEventFiredTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<LoadEventFiredEvent>> {
        return connection.captureEvents("Page.loadEventFired", LoadEventFiredEvent::class.java)
    }

    /**
     *  Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
     */
    fun navigatedWithinDocument(): io.reactivex.Flowable<NavigatedWithinDocumentEvent> {
        return navigatedWithinDocumentTimed().map {
            it.value()
        }
    }

    /**
     * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
     */
    fun navigatedWithinDocumentTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<NavigatedWithinDocumentEvent>> {
        return connection.captureEvents("Page.navigatedWithinDocument", NavigatedWithinDocumentEvent::class.java)
    }

    /**
     *  Compressed image data requested by the `startScreencast`.
     */
    fun screencastFrame(): io.reactivex.Flowable<ScreencastFrameEvent> {
        return screencastFrameTimed().map {
            it.value()
        }
    }

    /**
     * Compressed image data requested by the `startScreencast`.
     */
    fun screencastFrameTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ScreencastFrameEvent>> {
        return connection.captureEvents("Page.screencastFrame", ScreencastFrameEvent::class.java)
    }

    /**
     *  Fired when the page with currently enabled screencast was shown or hidden `.
     */
    fun screencastVisibilityChanged(): io.reactivex.Flowable<ScreencastVisibilityChangedEvent> {
        return screencastVisibilityChangedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when the page with currently enabled screencast was shown or hidden `.
     */
    fun screencastVisibilityChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ScreencastVisibilityChangedEvent>> {
        return connection.captureEvents("Page.screencastVisibilityChanged", ScreencastVisibilityChangedEvent::class.java)
    }

    /**
     *  Fired when a new window is going to be opened, via window.open(), link click, form submission,
etc.
     */
    fun windowOpen(): io.reactivex.Flowable<WindowOpenEvent> {
        return windowOpenTimed().map {
            it.value()
        }
    }

    /**
     * Fired when a new window is going to be opened, via window.open(), link click, form submission,
etc.
     */
    fun windowOpenTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<WindowOpenEvent>> {
        return connection.captureEvents("Page.windowOpen", WindowOpenEvent::class.java)
    }

    /**
     *  Issued for every compilation cache generated. Is only available
if Page.setGenerateCompilationCache is enabled.
     */
    fun compilationCacheProduced(): io.reactivex.Flowable<CompilationCacheProducedEvent> {
        return compilationCacheProducedTimed().map {
            it.value()
        }
    }

    /**
     * Issued for every compilation cache generated. Is only available
if Page.setGenerateCompilationCache is enabled.
     */
    fun compilationCacheProducedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<CompilationCacheProducedEvent>> {
        return connection.captureEvents("Page.compilationCacheProduced", CompilationCacheProducedEvent::class.java)
    }

    /**
     * Returns flowable capturing all Page domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
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
    @pl.wendigo.chrome.protocol.Experimental val fromSurface: Boolean? = null

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
     * Base64-encoded image data.  
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
    val data: String? = null

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
    val errors: List<String>

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
    val frameId: FrameId? = null

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
     * Base64-encoded pdf data. Empty if |returnAsStream| is specified.  
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
     * Base64-encoded data
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
File chooser can be handled with `page.handleFileChooser` command.
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
 * Represents request frame that can be used with [Page#handleFileChooser](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleFileChooser) operation call.
 *
 * Accepts or cancels an intercepted file chooser dialog.
 * @link [Page#handleFileChooser](https://chromedevtools.github.io/devtools-protocol/tot/Page#method-handleFileChooser) method documentation.
 * @see [PageOperations.handleFileChooser]
 */
data class HandleFileChooserRequest(
    /**
     *
     */
    val action: String,

    /**
     * Array of absolute file paths to set, only respected with `accept` action.
     */
    val files: List<String>? = null

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
     *  
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
    val frameId: FrameId

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
    val url: String

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
    val reason: String,

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
     * URL of the resource being downloaded.  
     */  
    val url: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "downloadWillBegin")

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
     * Base64-encoded compressed image.  
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
     * Base64-encoded data  
     */  
    val data: String

) : pl.wendigo.chrome.protocol.Event(domain = "Page", name = "compilationCacheProduced")
