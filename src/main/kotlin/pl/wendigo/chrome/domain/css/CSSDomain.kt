package pl.wendigo.chrome.domain.css

/**
 * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles)
have an associated `id` used in subsequent operations on the related object. Each object type has
a specific `id` structure, and those are not interchangeable between objects of different kinds.
CSS objects can be loaded using the `get*ForNode()` calls (which accept a DOM node id). A client
can also keep track of stylesheets via the `styleSheetAdded`/`styleSheetRemoved` events and
subsequently load the required stylesheet contents using the `getStyleSheet[Text]()` methods.
 */
class CSSDomain internal constructor(private val connectionRemote: pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
     */
    fun addRule(input: AddRuleRequest): io.reactivex.Single<AddRuleResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.addRule", input, AddRuleResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all class names from specified stylesheet.
     */
    fun collectClassNames(input: CollectClassNamesRequest): io.reactivex.Single<CollectClassNamesResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.collectClassNames", input, CollectClassNamesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
     */
    fun createStyleSheet(input: CreateStyleSheetRequest): io.reactivex.Single<CreateStyleSheetResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.createStyleSheet", input, CreateStyleSheetResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Disables the CSS agent for the given page.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CSS.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been
enabled until the result of this command is received.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CSS.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
the browser.
     */
    fun forcePseudoState(input: ForcePseudoStateRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CSS.forcePseudoState", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     *
     */
    fun getBackgroundColors(input: GetBackgroundColorsRequest): io.reactivex.Single<GetBackgroundColorsResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getBackgroundColors", input, GetBackgroundColorsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the computed style for a DOM node identified by `nodeId`.
     */
    fun getComputedStyleForNode(input: GetComputedStyleForNodeRequest): io.reactivex.Single<GetComputedStyleForNodeResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getComputedStyleForNode", input, GetComputedStyleForNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
     */
    fun getInlineStylesForNode(input: GetInlineStylesForNodeRequest): io.reactivex.Single<GetInlineStylesForNodeResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getInlineStylesForNode", input, GetInlineStylesForNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns requested styles for a DOM node identified by `nodeId`.
     */
    fun getMatchedStylesForNode(input: GetMatchedStylesForNodeRequest): io.reactivex.Single<GetMatchedStylesForNodeResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getMatchedStylesForNode", input, GetMatchedStylesForNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns all media queries parsed by the rendering engine.
     */
    fun getMediaQueries(): io.reactivex.Single<GetMediaQueriesResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getMediaQueries", null, GetMediaQueriesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Requests information about platform fonts which we used to render child TextNodes in the given
node.
     */
    fun getPlatformFontsForNode(input: GetPlatformFontsForNodeRequest): io.reactivex.Single<GetPlatformFontsForNodeResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getPlatformFontsForNode", input, GetPlatformFontsForNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the current textual content for a stylesheet.
     */
    fun getStyleSheetText(input: GetStyleSheetTextRequest): io.reactivex.Single<GetStyleSheetTextResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.getStyleSheetText", input, GetStyleSheetTextResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Find a rule with the given active property for the given node and set the new value for this
property
     */
    fun setEffectivePropertyValueForNode(input: SetEffectivePropertyValueForNodeRequest): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CSS.setEffectivePropertyValueForNode", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Modifies the keyframe rule key text.
     */
    fun setKeyframeKey(input: SetKeyframeKeyRequest): io.reactivex.Single<SetKeyframeKeyResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.setKeyframeKey", input, SetKeyframeKeyResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Modifies the rule selector.
     */
    fun setMediaText(input: SetMediaTextRequest): io.reactivex.Single<SetMediaTextResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.setMediaText", input, SetMediaTextResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Modifies the rule selector.
     */
    fun setRuleSelector(input: SetRuleSelectorRequest): io.reactivex.Single<SetRuleSelectorResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.setRuleSelector", input, SetRuleSelectorResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sets the new stylesheet text.
     */
    fun setStyleSheetText(input: SetStyleSheetTextRequest): io.reactivex.Single<SetStyleSheetTextResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.setStyleSheetText", input, SetStyleSheetTextResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Applies specified style edits one after another in the given order.
     */
    fun setStyleTexts(input: SetStyleTextsRequest): io.reactivex.Single<SetStyleTextsResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.setStyleTexts", input, SetStyleTextsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Enables the selector recording.
     */
    fun startRuleUsageTracking(): io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("CSS.startRuleUsageTracking", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Stop tracking rule usage and return the list of rules that were used since last call to
`takeCoverageDelta` (or since start of coverage instrumentation)
     */
    fun stopRuleUsageTracking(): io.reactivex.Single<StopRuleUsageTrackingResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.stopRuleUsageTracking", null, StopRuleUsageTrackingResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Obtain list of rules that became used since last call to this method (or since start of coverage
instrumentation)
     */
    fun takeCoverageDelta(): io.reactivex.Single<TakeCoverageDeltaResponse> {
        return connectionRemote.runAndCaptureResponse("CSS.takeCoverageDelta", null, TakeCoverageDeltaResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
     */
    fun fontsUpdated(): io.reactivex.Flowable<FontsUpdatedEvent> {
        return fontsUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
     */
    fun fontsUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<FontsUpdatedEvent>> {
        return connectionRemote.captureEvents("CSS.fontsUpdated", FontsUpdatedEvent::class.java)
    }

    /**
     *  Fires whenever a MediaQuery result changes (for example, after a browser window has been
resized.) The current implementation considers only viewport-dependent media features.
     */
    fun mediaQueryResultChanged(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return mediaQueryResultChangedTimed().map {
            it.value()
        }
    }

    /**
     * Fires whenever a MediaQuery result changes (for example, after a browser window has been
resized.) The current implementation considers only viewport-dependent media features.
     */
    fun mediaQueryResultChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ProtocolEvent>> {
        return connectionRemote.captureEvents("CSS.mediaQueryResultChanged", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     *  Fired whenever an active document stylesheet is added.
     */
    fun styleSheetAdded(): io.reactivex.Flowable<StyleSheetAddedEvent> {
        return styleSheetAddedTimed().map {
            it.value()
        }
    }

    /**
     * Fired whenever an active document stylesheet is added.
     */
    fun styleSheetAddedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<StyleSheetAddedEvent>> {
        return connectionRemote.captureEvents("CSS.styleSheetAdded", StyleSheetAddedEvent::class.java)
    }

    /**
     *  Fired whenever a stylesheet is changed as a result of the client operation.
     */
    fun styleSheetChanged(): io.reactivex.Flowable<StyleSheetChangedEvent> {
        return styleSheetChangedTimed().map {
            it.value()
        }
    }

    /**
     * Fired whenever a stylesheet is changed as a result of the client operation.
     */
    fun styleSheetChangedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<StyleSheetChangedEvent>> {
        return connectionRemote.captureEvents("CSS.styleSheetChanged", StyleSheetChangedEvent::class.java)
    }

    /**
     *  Fired whenever an active document stylesheet is removed.
     */
    fun styleSheetRemoved(): io.reactivex.Flowable<StyleSheetRemovedEvent> {
        return styleSheetRemovedTimed().map {
            it.value()
        }
    }

    /**
     * Fired whenever an active document stylesheet is removed.
     */
    fun styleSheetRemovedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<StyleSheetRemovedEvent>> {
        return connectionRemote.captureEvents("CSS.styleSheetRemoved", StyleSheetRemovedEvent::class.java)
    }

    /**
     * Returns flowable capturing all CSS domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "CSS"
        }
    }
}
/**
 * Represents request frame that can be used with CSS.addRule method call.
 *
 * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
 */
data class AddRuleRequest(
    /**
     * The css style sheet identifier where a new rule should be inserted.
     */
    val styleSheetId: StyleSheetId,

    /**
     * The text of a new rule.
     */
    val ruleText: String,

    /**
     * Text position of a new rule in the target style sheet.
     */
    val location: SourceRange

)

/**
 * Represents response frame for CSS.addRule method call.
 *
 * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
 */
data class AddRuleResponse(
    /**  
     * The newly created rule.  
     */  
    val rule: CSSRule

)

/**
 * Represents request frame that can be used with CSS.collectClassNames method call.
 *
 * Returns all class names from specified stylesheet.
 */
data class CollectClassNamesRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId

)

/**
 * Represents response frame for CSS.collectClassNames method call.
 *
 * Returns all class names from specified stylesheet.
 */
data class CollectClassNamesResponse(
    /**  
     * Class name list.  
     */  
    val classNames: List<String>

)

/**
 * Represents request frame that can be used with CSS.createStyleSheet method call.
 *
 * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
 */
data class CreateStyleSheetRequest(
    /**
     * Identifier of the frame where "via-inspector" stylesheet should be created.
     */
    val frameId: pl.wendigo.chrome.domain.page.FrameId

)

/**
 * Represents response frame for CSS.createStyleSheet method call.
 *
 * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
 */
data class CreateStyleSheetResponse(
    /**  
     * Identifier of the created "via-inspector" stylesheet.  
     */  
    val styleSheetId: StyleSheetId

)

/**
 * Represents request frame that can be used with CSS.forcePseudoState method call.
 *
 * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
the browser.
 */
data class ForcePseudoStateRequest(
    /**
     * The element id for which to force the pseudo state.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId,

    /**
     * Element pseudo classes to force when computing the element's style.
     */
    val forcedPseudoClasses: List<String>

)

/**
 * Represents request frame that can be used with CSS.getBackgroundColors method call.
 *
 *
 */
data class GetBackgroundColorsRequest(
    /**
     * Id of the node to get background colors for.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents response frame for CSS.getBackgroundColors method call.
 *
 *
 */
data class GetBackgroundColorsResponse(
    /**  
     * The range of background colors behind this element, if it contains any visible text. If no  
  visible text is present, this will be undefined. In the case of a flat background color,  
  this will consist of simply that color. In the case of a gradient, this will consist of each  
  of the color stops. For anything more complicated, this will be an empty array. Images will  
  be ignored (as if the image had failed to load).  
     */  
    val backgroundColors: List<String>? = null,

    /**  
     * The computed font size for this node, as a CSS computed value string (e.g. '12px').  
     */  
    val computedFontSize: String? = null,

    /**  
     * The computed font weight for this node, as a CSS computed value string (e.g. 'normal' or  
  '100').  
     */  
    val computedFontWeight: String? = null

)

/**
 * Represents request frame that can be used with CSS.getComputedStyleForNode method call.
 *
 * Returns the computed style for a DOM node identified by `nodeId`.
 */
data class GetComputedStyleForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents response frame for CSS.getComputedStyleForNode method call.
 *
 * Returns the computed style for a DOM node identified by `nodeId`.
 */
data class GetComputedStyleForNodeResponse(
    /**  
     * Computed style for the specified DOM node.  
     */  
    val computedStyle: List<CSSComputedStyleProperty>

)

/**
 * Represents request frame that can be used with CSS.getInlineStylesForNode method call.
 *
 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
 */
data class GetInlineStylesForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents response frame for CSS.getInlineStylesForNode method call.
 *
 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
 */
data class GetInlineStylesForNodeResponse(
    /**  
     * Inline style for the specified DOM node.  
     */  
    val inlineStyle: CSSStyle? = null,

    /**  
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").  
     */  
    val attributesStyle: CSSStyle? = null

)

/**
 * Represents request frame that can be used with CSS.getMatchedStylesForNode method call.
 *
 * Returns requested styles for a DOM node identified by `nodeId`.
 */
data class GetMatchedStylesForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents response frame for CSS.getMatchedStylesForNode method call.
 *
 * Returns requested styles for a DOM node identified by `nodeId`.
 */
data class GetMatchedStylesForNodeResponse(
    /**  
     * Inline style for the specified DOM node.  
     */  
    val inlineStyle: CSSStyle? = null,

    /**  
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").  
     */  
    val attributesStyle: CSSStyle? = null,

    /**  
     * CSS rules matching this node, from all applicable stylesheets.  
     */  
    val matchedCSSRules: List<RuleMatch>? = null,

    /**  
     * Pseudo style matches for this node.  
     */  
    val pseudoElements: List<PseudoElementMatches>? = null,

    /**  
     * A chain of inherited styles (from the immediate node parent up to the DOM tree root).  
     */  
    val inherited: List<InheritedStyleEntry>? = null,

    /**  
     * A list of CSS keyframed animations matching this node.  
     */  
    val cssKeyframesRules: List<CSSKeyframesRule>? = null

)

/**
 * Represents response frame for CSS.getMediaQueries method call.
 *
 * Returns all media queries parsed by the rendering engine.
 */
data class GetMediaQueriesResponse(
    /**  
     *  
     */  
    val medias: List<CSSMedia>

)

/**
 * Represents request frame that can be used with CSS.getPlatformFontsForNode method call.
 *
 * Requests information about platform fonts which we used to render child TextNodes in the given
node.
 */
data class GetPlatformFontsForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents response frame for CSS.getPlatformFontsForNode method call.
 *
 * Requests information about platform fonts which we used to render child TextNodes in the given
node.
 */
data class GetPlatformFontsForNodeResponse(
    /**  
     * Usage statistics for every employed platform font.  
     */  
    val fonts: List<PlatformFontUsage>

)

/**
 * Represents request frame that can be used with CSS.getStyleSheetText method call.
 *
 * Returns the current textual content for a stylesheet.
 */
data class GetStyleSheetTextRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId

)

/**
 * Represents response frame for CSS.getStyleSheetText method call.
 *
 * Returns the current textual content for a stylesheet.
 */
data class GetStyleSheetTextResponse(
    /**  
     * The stylesheet text.  
     */  
    val text: String

)

/**
 * Represents request frame that can be used with CSS.setEffectivePropertyValueForNode method call.
 *
 * Find a rule with the given active property for the given node and set the new value for this
property
 */
data class SetEffectivePropertyValueForNodeRequest(
    /**
     * The element id for which to set property.
     */
    val nodeId: pl.wendigo.chrome.domain.dom.NodeId,

    /**
     *
     */
    val propertyName: String,

    /**
     *
     */
    val value: String

)

/**
 * Represents request frame that can be used with CSS.setKeyframeKey method call.
 *
 * Modifies the keyframe rule key text.
 */
data class SetKeyframeKeyRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId,

    /**
     *
     */
    val range: SourceRange,

    /**
     *
     */
    val keyText: String

)

/**
 * Represents response frame for CSS.setKeyframeKey method call.
 *
 * Modifies the keyframe rule key text.
 */
data class SetKeyframeKeyResponse(
    /**  
     * The resulting key text after modification.  
     */  
    val keyText: Value

)

/**
 * Represents request frame that can be used with CSS.setMediaText method call.
 *
 * Modifies the rule selector.
 */
data class SetMediaTextRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId,

    /**
     *
     */
    val range: SourceRange,

    /**
     *
     */
    val text: String

)

/**
 * Represents response frame for CSS.setMediaText method call.
 *
 * Modifies the rule selector.
 */
data class SetMediaTextResponse(
    /**  
     * The resulting CSS media rule after modification.  
     */  
    val media: CSSMedia

)

/**
 * Represents request frame that can be used with CSS.setRuleSelector method call.
 *
 * Modifies the rule selector.
 */
data class SetRuleSelectorRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId,

    /**
     *
     */
    val range: SourceRange,

    /**
     *
     */
    val selector: String

)

/**
 * Represents response frame for CSS.setRuleSelector method call.
 *
 * Modifies the rule selector.
 */
data class SetRuleSelectorResponse(
    /**  
     * The resulting selector list after modification.  
     */  
    val selectorList: SelectorList

)

/**
 * Represents request frame that can be used with CSS.setStyleSheetText method call.
 *
 * Sets the new stylesheet text.
 */
data class SetStyleSheetTextRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId,

    /**
     *
     */
    val text: String

)

/**
 * Represents response frame for CSS.setStyleSheetText method call.
 *
 * Sets the new stylesheet text.
 */
data class SetStyleSheetTextResponse(
    /**  
     * URL of source map associated with script (if any).  
     */  
    val sourceMapURL: String? = null

)

/**
 * Represents request frame that can be used with CSS.setStyleTexts method call.
 *
 * Applies specified style edits one after another in the given order.
 */
data class SetStyleTextsRequest(
    /**
     *
     */
    val edits: List<StyleDeclarationEdit>

)

/**
 * Represents response frame for CSS.setStyleTexts method call.
 *
 * Applies specified style edits one after another in the given order.
 */
data class SetStyleTextsResponse(
    /**  
     * The resulting styles after modification.  
     */  
    val styles: List<CSSStyle>

)

/**
 * Represents response frame for CSS.stopRuleUsageTracking method call.
 *
 * Stop tracking rule usage and return the list of rules that were used since last call to
`takeCoverageDelta` (or since start of coverage instrumentation)
 */
data class StopRuleUsageTrackingResponse(
    /**  
     *  
     */  
    val ruleUsage: List<RuleUsage>

)

/**
 * Represents response frame for CSS.takeCoverageDelta method call.
 *
 * Obtain list of rules that became used since last call to this method (or since start of coverage
instrumentation)
 */
data class TakeCoverageDeltaResponse(
    /**  
     *  
     */  
    val coverage: List<RuleUsage>

)

/**
 * Represents event frames for CSS.fontsUpdated
 *
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
 */
data class FontsUpdatedEvent(
    /**  
     * The web font that has loaded.  
     */  
    val font: FontFace? = null

) : pl.wendigo.chrome.ProtocolEvent(domain = "CSS", name = "fontsUpdated")

/**
 * Represents event frames for CSS.styleSheetAdded
 *
 * Fired whenever an active document stylesheet is added.
 */
data class StyleSheetAddedEvent(
    /**  
     * Added stylesheet metainfo.  
     */  
    val header: CSSStyleSheetHeader

) : pl.wendigo.chrome.ProtocolEvent(domain = "CSS", name = "styleSheetAdded")

/**
 * Represents event frames for CSS.styleSheetChanged
 *
 * Fired whenever a stylesheet is changed as a result of the client operation.
 */
data class StyleSheetChangedEvent(
    /**  
     *  
     */  
    val styleSheetId: StyleSheetId

) : pl.wendigo.chrome.ProtocolEvent(domain = "CSS", name = "styleSheetChanged")

/**
 * Represents event frames for CSS.styleSheetRemoved
 *
 * Fired whenever an active document stylesheet is removed.
 */
data class StyleSheetRemovedEvent(
    /**  
     * Identifier of the removed stylesheet.  
     */  
    val styleSheetId: StyleSheetId

) : pl.wendigo.chrome.ProtocolEvent(domain = "CSS", name = "styleSheetRemoved")
