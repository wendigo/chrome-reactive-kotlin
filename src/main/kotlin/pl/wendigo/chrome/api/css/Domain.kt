package pl.wendigo.chrome.api.css

import kotlinx.serialization.json.Json

/**
 * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles)
have an associated `id` used in subsequent operations on the related object. Each object type has
a specific `id` structure, and those are not interchangeable between objects of different kinds.
CSS objects can be loaded using the `get*ForNode()` calls (which accept a DOM node id). A client
can also keep track of stylesheets via the `styleSheetAdded`/`styleSheetRemoved` events and
subsequently load the required stylesheet contents using the `getStyleSheet[Text]()` methods.
 *
 * This API is marked as experimental in protocol definition and can change in the future.
 * @link Protocol [CSS](https://chromedevtools.github.io/devtools-protocol/tot/CSS) domain documentation.
 */
@pl.wendigo.chrome.protocol.Experimental
class CSSDomain internal constructor(connection: pl.wendigo.chrome.protocol.DebuggerWebsocketConnection) :
    pl.wendigo.chrome.api.Domain(
        "CSS",
        """This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles)
have an associated `id` used in subsequent operations on the related object. Each object type has
a specific `id` structure, and those are not interchangeable between objects of different kinds.
CSS objects can be loaded using the `get*ForNode()` calls (which accept a DOM node id). A client
can also keep track of stylesheets via the `styleSheetAdded`/`styleSheetRemoved` events and
subsequently load the required stylesheet contents using the `getStyleSheet[Text]()` methods.""",
        connection
    ) {
    /**
     * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
     *
     * @link Protocol [CSS#addRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-addRule) method documentation.
     */
    
    fun addRule(input: AddRuleRequest) = connection.request("CSS.addRule", Json.encodeToJsonElement(AddRuleRequest.serializer(), input), AddRuleResponse.serializer())

    /**
     * Returns all class names from specified stylesheet.
     *
     * @link Protocol [CSS#collectClassNames](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-collectClassNames) method documentation.
     */
    
    fun collectClassNames(input: CollectClassNamesRequest) = connection.request("CSS.collectClassNames", Json.encodeToJsonElement(CollectClassNamesRequest.serializer(), input), CollectClassNamesResponse.serializer())

    /**
     * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
     *
     * @link Protocol [CSS#createStyleSheet](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-createStyleSheet) method documentation.
     */
    
    fun createStyleSheet(input: CreateStyleSheetRequest) = connection.request("CSS.createStyleSheet", Json.encodeToJsonElement(CreateStyleSheetRequest.serializer(), input), CreateStyleSheetResponse.serializer())

    /**
     * Disables the CSS agent for the given page.
     *
     * @link Protocol [CSS#disable](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-disable) method documentation.
     */
    
    fun disable() = connection.request("CSS.disable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been
enabled until the result of this command is received.
     *
     * @link Protocol [CSS#enable](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-enable) method documentation.
     */
    
    fun enable() = connection.request("CSS.enable", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
the browser.
     *
     * @link Protocol [CSS#forcePseudoState](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-forcePseudoState) method documentation.
     */
    
    fun forcePseudoState(input: ForcePseudoStateRequest) = connection.request("CSS.forcePseudoState", Json.encodeToJsonElement(ForcePseudoStateRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *
     *
     * @link Protocol [CSS#getBackgroundColors](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getBackgroundColors) method documentation.
     */
    
    fun getBackgroundColors(input: GetBackgroundColorsRequest) = connection.request("CSS.getBackgroundColors", Json.encodeToJsonElement(GetBackgroundColorsRequest.serializer(), input), GetBackgroundColorsResponse.serializer())

    /**
     * Returns the computed style for a DOM node identified by `nodeId`.
     *
     * @link Protocol [CSS#getComputedStyleForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getComputedStyleForNode) method documentation.
     */
    
    fun getComputedStyleForNode(input: GetComputedStyleForNodeRequest) = connection.request("CSS.getComputedStyleForNode", Json.encodeToJsonElement(GetComputedStyleForNodeRequest.serializer(), input), GetComputedStyleForNodeResponse.serializer())

    /**
     * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
     *
     * @link Protocol [CSS#getInlineStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getInlineStylesForNode) method documentation.
     */
    
    fun getInlineStylesForNode(input: GetInlineStylesForNodeRequest) = connection.request("CSS.getInlineStylesForNode", Json.encodeToJsonElement(GetInlineStylesForNodeRequest.serializer(), input), GetInlineStylesForNodeResponse.serializer())

    /**
     * Returns requested styles for a DOM node identified by `nodeId`.
     *
     * @link Protocol [CSS#getMatchedStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMatchedStylesForNode) method documentation.
     */
    
    fun getMatchedStylesForNode(input: GetMatchedStylesForNodeRequest) = connection.request("CSS.getMatchedStylesForNode", Json.encodeToJsonElement(GetMatchedStylesForNodeRequest.serializer(), input), GetMatchedStylesForNodeResponse.serializer())

    /**
     * Returns all media queries parsed by the rendering engine.
     *
     * @link Protocol [CSS#getMediaQueries](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMediaQueries) method documentation.
     */
    
    fun getMediaQueries() = connection.request("CSS.getMediaQueries", null, GetMediaQueriesResponse.serializer())

    /**
     * Requests information about platform fonts which we used to render child TextNodes in the given
node.
     *
     * @link Protocol [CSS#getPlatformFontsForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getPlatformFontsForNode) method documentation.
     */
    
    fun getPlatformFontsForNode(input: GetPlatformFontsForNodeRequest) = connection.request("CSS.getPlatformFontsForNode", Json.encodeToJsonElement(GetPlatformFontsForNodeRequest.serializer(), input), GetPlatformFontsForNodeResponse.serializer())

    /**
     * Returns the current textual content for a stylesheet.
     *
     * @link Protocol [CSS#getStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getStyleSheetText) method documentation.
     */
    
    fun getStyleSheetText(input: GetStyleSheetTextRequest) = connection.request("CSS.getStyleSheetText", Json.encodeToJsonElement(GetStyleSheetTextRequest.serializer(), input), GetStyleSheetTextResponse.serializer())

    /**
     * Starts tracking the given computed styles for updates. The specified array of properties
replaces the one previously specified. Pass empty array to disable tracking.
Use takeComputedStyleUpdates to retrieve the list of nodes that had properties modified.
The changes to computed style properties are only tracked for nodes pushed to the front-end
by the DOM agent. If no changes to the tracked properties occur after the node has been pushed
to the front-end, no updates will be issued for the node.
     *
     * @link Protocol [CSS#trackComputedStyleUpdates](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-trackComputedStyleUpdates) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun trackComputedStyleUpdates(input: TrackComputedStyleUpdatesRequest) = connection.request("CSS.trackComputedStyleUpdates", Json.encodeToJsonElement(TrackComputedStyleUpdatesRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Polls the next batch of computed style updates.
     *
     * @link Protocol [CSS#takeComputedStyleUpdates](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeComputedStyleUpdates) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun takeComputedStyleUpdates() = connection.request("CSS.takeComputedStyleUpdates", null, TakeComputedStyleUpdatesResponse.serializer())

    /**
     * Find a rule with the given active property for the given node and set the new value for this
property
     *
     * @link Protocol [CSS#setEffectivePropertyValueForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setEffectivePropertyValueForNode) method documentation.
     */
    
    fun setEffectivePropertyValueForNode(input: SetEffectivePropertyValueForNodeRequest) = connection.request("CSS.setEffectivePropertyValueForNode", Json.encodeToJsonElement(SetEffectivePropertyValueForNodeRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Modifies the keyframe rule key text.
     *
     * @link Protocol [CSS#setKeyframeKey](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setKeyframeKey) method documentation.
     */
    
    fun setKeyframeKey(input: SetKeyframeKeyRequest) = connection.request("CSS.setKeyframeKey", Json.encodeToJsonElement(SetKeyframeKeyRequest.serializer(), input), SetKeyframeKeyResponse.serializer())

    /**
     * Modifies the rule selector.
     *
     * @link Protocol [CSS#setMediaText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setMediaText) method documentation.
     */
    
    fun setMediaText(input: SetMediaTextRequest) = connection.request("CSS.setMediaText", Json.encodeToJsonElement(SetMediaTextRequest.serializer(), input), SetMediaTextResponse.serializer())

    /**
     * Modifies the rule selector.
     *
     * @link Protocol [CSS#setRuleSelector](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setRuleSelector) method documentation.
     */
    
    fun setRuleSelector(input: SetRuleSelectorRequest) = connection.request("CSS.setRuleSelector", Json.encodeToJsonElement(SetRuleSelectorRequest.serializer(), input), SetRuleSelectorResponse.serializer())

    /**
     * Sets the new stylesheet text.
     *
     * @link Protocol [CSS#setStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleSheetText) method documentation.
     */
    
    fun setStyleSheetText(input: SetStyleSheetTextRequest) = connection.request("CSS.setStyleSheetText", Json.encodeToJsonElement(SetStyleSheetTextRequest.serializer(), input), SetStyleSheetTextResponse.serializer())

    /**
     * Applies specified style edits one after another in the given order.
     *
     * @link Protocol [CSS#setStyleTexts](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleTexts) method documentation.
     */
    
    fun setStyleTexts(input: SetStyleTextsRequest) = connection.request("CSS.setStyleTexts", Json.encodeToJsonElement(SetStyleTextsRequest.serializer(), input), SetStyleTextsResponse.serializer())

    /**
     * Enables the selector recording.
     *
     * @link Protocol [CSS#startRuleUsageTracking](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-startRuleUsageTracking) method documentation.
     */
    
    fun startRuleUsageTracking() = connection.request("CSS.startRuleUsageTracking", null, pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     * Stop tracking rule usage and return the list of rules that were used since last call to
`takeCoverageDelta` (or since start of coverage instrumentation)
     *
     * @link Protocol [CSS#stopRuleUsageTracking](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-stopRuleUsageTracking) method documentation.
     */
    
    fun stopRuleUsageTracking() = connection.request("CSS.stopRuleUsageTracking", null, StopRuleUsageTrackingResponse.serializer())

    /**
     * Obtain list of rules that became used since last call to this method (or since start of coverage
instrumentation)
     *
     * @link Protocol [CSS#takeCoverageDelta](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeCoverageDelta) method documentation.
     */
    
    fun takeCoverageDelta() = connection.request("CSS.takeCoverageDelta", null, TakeCoverageDeltaResponse.serializer())

    /**
     * Enables/disables rendering of local CSS fonts (enabled by default).
     *
     * @link Protocol [CSS#setLocalFontsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setLocalFontsEnabled) method documentation.
     */
    @pl.wendigo.chrome.protocol.Experimental
    fun setLocalFontsEnabled(input: SetLocalFontsEnabledRequest) = connection.request("CSS.setLocalFontsEnabled", Json.encodeToJsonElement(SetLocalFontsEnabledRequest.serializer(), input), pl.wendigo.chrome.protocol.RequestResponseFrame.serializer())

    /**
     *  Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
     */
    fun fontsUpdated(): io.reactivex.rxjava3.core.Flowable<FontsUpdatedEvent> = connection.events("CSS.fontsUpdated", FontsUpdatedEvent.serializer())

    /**
     *  Fires whenever a MediaQuery result changes (for example, after a browser window has been
resized.) The current implementation considers only viewport-dependent media features.
     */
    fun mediaQueryResultChanged(): io.reactivex.rxjava3.core.Flowable<pl.wendigo.chrome.protocol.RawEvent> = connection.events("CSS.mediaQueryResultChanged", pl.wendigo.chrome.protocol.RawEvent.serializer())

    /**
     *  Fired whenever an active document stylesheet is added.
     */
    fun styleSheetAdded(): io.reactivex.rxjava3.core.Flowable<StyleSheetAddedEvent> = connection.events("CSS.styleSheetAdded", StyleSheetAddedEvent.serializer())

    /**
     *  Fired whenever a stylesheet is changed as a result of the client operation.
     */
    fun styleSheetChanged(): io.reactivex.rxjava3.core.Flowable<StyleSheetChangedEvent> = connection.events("CSS.styleSheetChanged", StyleSheetChangedEvent.serializer())

    /**
     *  Fired whenever an active document stylesheet is removed.
     */
    fun styleSheetRemoved(): io.reactivex.rxjava3.core.Flowable<StyleSheetRemovedEvent> = connection.events("CSS.styleSheetRemoved", StyleSheetRemovedEvent.serializer())

    /**
     * Returns list of dependant domains that should be enabled prior to enabling this domain.
     */
    override fun getDependencies(): List<pl.wendigo.chrome.api.Domain> {
        return arrayListOf(
            pl.wendigo.chrome.api.dom.DOMDomain(connection),
            pl.wendigo.chrome.api.page.PageDomain(connection),
        )
    }
}

/**
 * Represents request frame that can be used with [CSS#addRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-addRule) operation call.
 *
 * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
 * @link [CSS#addRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-addRule) method documentation.
 * @see [CSSOperations.addRule]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [CSS#addRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-addRule) operation call.
 * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
 *
  
 * @link [CSS#addRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-addRule) method documentation.
 * @see [CSSOperations.addRule]
 */
@kotlinx.serialization.Serializable
data class AddRuleResponse(
    /**  
     * The newly created rule.  
     */  
    val rule: CSSRule

)

/**
 * Represents request frame that can be used with [CSS#collectClassNames](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-collectClassNames) operation call.
 *
 * Returns all class names from specified stylesheet.
 * @link [CSS#collectClassNames](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-collectClassNames) method documentation.
 * @see [CSSOperations.collectClassNames]
 */
@kotlinx.serialization.Serializable
data class CollectClassNamesRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId

)

/**
 * Represents response frame that is returned from [CSS#collectClassNames](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-collectClassNames) operation call.
 * Returns all class names from specified stylesheet.
 *
  
 * @link [CSS#collectClassNames](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-collectClassNames) method documentation.
 * @see [CSSOperations.collectClassNames]
 */
@kotlinx.serialization.Serializable
data class CollectClassNamesResponse(
    /**  
     * Class name list.  
     */  
    val classNames: List<String>

)

/**
 * Represents request frame that can be used with [CSS#createStyleSheet](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-createStyleSheet) operation call.
 *
 * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
 * @link [CSS#createStyleSheet](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-createStyleSheet) method documentation.
 * @see [CSSOperations.createStyleSheet]
 */
@kotlinx.serialization.Serializable
data class CreateStyleSheetRequest(
    /**
     * Identifier of the frame where "via-inspector" stylesheet should be created.
     */
    val frameId: pl.wendigo.chrome.api.page.FrameId

)

/**
 * Represents response frame that is returned from [CSS#createStyleSheet](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-createStyleSheet) operation call.
 * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
 *
  
 * @link [CSS#createStyleSheet](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-createStyleSheet) method documentation.
 * @see [CSSOperations.createStyleSheet]
 */
@kotlinx.serialization.Serializable
data class CreateStyleSheetResponse(
    /**  
     * Identifier of the created "via-inspector" stylesheet.  
     */  
    val styleSheetId: StyleSheetId

)

/**
 * Represents request frame that can be used with [CSS#forcePseudoState](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-forcePseudoState) operation call.
 *
 * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
the browser.
 * @link [CSS#forcePseudoState](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-forcePseudoState) method documentation.
 * @see [CSSOperations.forcePseudoState]
 */
@kotlinx.serialization.Serializable
data class ForcePseudoStateRequest(
    /**
     * The element id for which to force the pseudo state.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId,

    /**
     * Element pseudo classes to force when computing the element's style.
     */
    val forcedPseudoClasses: List<String>

)

/**
 * Represents request frame that can be used with [CSS#getBackgroundColors](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getBackgroundColors) operation call.
 *
 *
 * @link [CSS#getBackgroundColors](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getBackgroundColors) method documentation.
 * @see [CSSOperations.getBackgroundColors]
 */
@kotlinx.serialization.Serializable
data class GetBackgroundColorsRequest(
    /**
     * Id of the node to get background colors for.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

)

/**
 * Represents response frame that is returned from [CSS#getBackgroundColors](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getBackgroundColors) operation call.
 *
 *
  
 * @link [CSS#getBackgroundColors](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getBackgroundColors) method documentation.
 * @see [CSSOperations.getBackgroundColors]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [CSS#getComputedStyleForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getComputedStyleForNode) operation call.
 *
 * Returns the computed style for a DOM node identified by `nodeId`.
 * @link [CSS#getComputedStyleForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getComputedStyleForNode) method documentation.
 * @see [CSSOperations.getComputedStyleForNode]
 */
@kotlinx.serialization.Serializable
data class GetComputedStyleForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

)

/**
 * Represents response frame that is returned from [CSS#getComputedStyleForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getComputedStyleForNode) operation call.
 * Returns the computed style for a DOM node identified by `nodeId`.
 *
  
 * @link [CSS#getComputedStyleForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getComputedStyleForNode) method documentation.
 * @see [CSSOperations.getComputedStyleForNode]
 */
@kotlinx.serialization.Serializable
data class GetComputedStyleForNodeResponse(
    /**  
     * Computed style for the specified DOM node.  
     */  
    val computedStyle: List<CSSComputedStyleProperty>

)

/**
 * Represents request frame that can be used with [CSS#getInlineStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getInlineStylesForNode) operation call.
 *
 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
 * @link [CSS#getInlineStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getInlineStylesForNode) method documentation.
 * @see [CSSOperations.getInlineStylesForNode]
 */
@kotlinx.serialization.Serializable
data class GetInlineStylesForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

)

/**
 * Represents response frame that is returned from [CSS#getInlineStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getInlineStylesForNode) operation call.
 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
 *
  
 * @link [CSS#getInlineStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getInlineStylesForNode) method documentation.
 * @see [CSSOperations.getInlineStylesForNode]
 */
@kotlinx.serialization.Serializable
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
 * Represents request frame that can be used with [CSS#getMatchedStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMatchedStylesForNode) operation call.
 *
 * Returns requested styles for a DOM node identified by `nodeId`.
 * @link [CSS#getMatchedStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMatchedStylesForNode) method documentation.
 * @see [CSSOperations.getMatchedStylesForNode]
 */
@kotlinx.serialization.Serializable
data class GetMatchedStylesForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

)

/**
 * Represents response frame that is returned from [CSS#getMatchedStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMatchedStylesForNode) operation call.
 * Returns requested styles for a DOM node identified by `nodeId`.
 *
  
 * @link [CSS#getMatchedStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMatchedStylesForNode) method documentation.
 * @see [CSSOperations.getMatchedStylesForNode]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [CSS#getMediaQueries](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMediaQueries) operation call.
 * Returns all media queries parsed by the rendering engine.
 *
  
 * @link [CSS#getMediaQueries](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMediaQueries) method documentation.
 * @see [CSSOperations.getMediaQueries]
 */
@kotlinx.serialization.Serializable
data class GetMediaQueriesResponse(
    /**  
     *  
     */  
    val medias: List<CSSMedia>

)

/**
 * Represents request frame that can be used with [CSS#getPlatformFontsForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getPlatformFontsForNode) operation call.
 *
 * Requests information about platform fonts which we used to render child TextNodes in the given
node.
 * @link [CSS#getPlatformFontsForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getPlatformFontsForNode) method documentation.
 * @see [CSSOperations.getPlatformFontsForNode]
 */
@kotlinx.serialization.Serializable
data class GetPlatformFontsForNodeRequest(
    /**
     *
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId

)

/**
 * Represents response frame that is returned from [CSS#getPlatformFontsForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getPlatformFontsForNode) operation call.
 * Requests information about platform fonts which we used to render child TextNodes in the given
node.
 *
  
 * @link [CSS#getPlatformFontsForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getPlatformFontsForNode) method documentation.
 * @see [CSSOperations.getPlatformFontsForNode]
 */
@kotlinx.serialization.Serializable
data class GetPlatformFontsForNodeResponse(
    /**  
     * Usage statistics for every employed platform font.  
     */  
    val fonts: List<PlatformFontUsage>

)

/**
 * Represents request frame that can be used with [CSS#getStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getStyleSheetText) operation call.
 *
 * Returns the current textual content for a stylesheet.
 * @link [CSS#getStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getStyleSheetText) method documentation.
 * @see [CSSOperations.getStyleSheetText]
 */
@kotlinx.serialization.Serializable
data class GetStyleSheetTextRequest(
    /**
     *
     */
    val styleSheetId: StyleSheetId

)

/**
 * Represents response frame that is returned from [CSS#getStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getStyleSheetText) operation call.
 * Returns the current textual content for a stylesheet.
 *
  
 * @link [CSS#getStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getStyleSheetText) method documentation.
 * @see [CSSOperations.getStyleSheetText]
 */
@kotlinx.serialization.Serializable
data class GetStyleSheetTextResponse(
    /**  
     * The stylesheet text.  
     */  
    val text: String

)

/**
 * Represents request frame that can be used with [CSS#trackComputedStyleUpdates](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-trackComputedStyleUpdates) operation call.
 *
 * Starts tracking the given computed styles for updates. The specified array of properties
replaces the one previously specified. Pass empty array to disable tracking.
Use takeComputedStyleUpdates to retrieve the list of nodes that had properties modified.
The changes to computed style properties are only tracked for nodes pushed to the front-end
by the DOM agent. If no changes to the tracked properties occur after the node has been pushed
to the front-end, no updates will be issued for the node.
 * @link [CSS#trackComputedStyleUpdates](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-trackComputedStyleUpdates) method documentation.
 * @see [CSSOperations.trackComputedStyleUpdates]
 */
@kotlinx.serialization.Serializable
data class TrackComputedStyleUpdatesRequest(
    /**
     *
     */
    val propertiesToTrack: List<CSSComputedStyleProperty>

)

/**
 * Represents response frame that is returned from [CSS#takeComputedStyleUpdates](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeComputedStyleUpdates) operation call.
 * Polls the next batch of computed style updates.
 *
  
 * @link [CSS#takeComputedStyleUpdates](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeComputedStyleUpdates) method documentation.
 * @see [CSSOperations.takeComputedStyleUpdates]
 */
@kotlinx.serialization.Serializable
data class TakeComputedStyleUpdatesResponse(
    /**  
     * The list of node Ids that have their tracked computed styles updated  
     */  
    val nodeIds: List<pl.wendigo.chrome.api.dom.NodeId>

)

/**
 * Represents request frame that can be used with [CSS#setEffectivePropertyValueForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setEffectivePropertyValueForNode) operation call.
 *
 * Find a rule with the given active property for the given node and set the new value for this
property
 * @link [CSS#setEffectivePropertyValueForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setEffectivePropertyValueForNode) method documentation.
 * @see [CSSOperations.setEffectivePropertyValueForNode]
 */
@kotlinx.serialization.Serializable
data class SetEffectivePropertyValueForNodeRequest(
    /**
     * The element id for which to set property.
     */
    val nodeId: pl.wendigo.chrome.api.dom.NodeId,

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
 * Represents request frame that can be used with [CSS#setKeyframeKey](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setKeyframeKey) operation call.
 *
 * Modifies the keyframe rule key text.
 * @link [CSS#setKeyframeKey](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setKeyframeKey) method documentation.
 * @see [CSSOperations.setKeyframeKey]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [CSS#setKeyframeKey](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setKeyframeKey) operation call.
 * Modifies the keyframe rule key text.
 *
  
 * @link [CSS#setKeyframeKey](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setKeyframeKey) method documentation.
 * @see [CSSOperations.setKeyframeKey]
 */
@kotlinx.serialization.Serializable
data class SetKeyframeKeyResponse(
    /**  
     * The resulting key text after modification.  
     */  
    val keyText: Value

)

/**
 * Represents request frame that can be used with [CSS#setMediaText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setMediaText) operation call.
 *
 * Modifies the rule selector.
 * @link [CSS#setMediaText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setMediaText) method documentation.
 * @see [CSSOperations.setMediaText]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [CSS#setMediaText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setMediaText) operation call.
 * Modifies the rule selector.
 *
  
 * @link [CSS#setMediaText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setMediaText) method documentation.
 * @see [CSSOperations.setMediaText]
 */
@kotlinx.serialization.Serializable
data class SetMediaTextResponse(
    /**  
     * The resulting CSS media rule after modification.  
     */  
    val media: CSSMedia

)

/**
 * Represents request frame that can be used with [CSS#setRuleSelector](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setRuleSelector) operation call.
 *
 * Modifies the rule selector.
 * @link [CSS#setRuleSelector](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setRuleSelector) method documentation.
 * @see [CSSOperations.setRuleSelector]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [CSS#setRuleSelector](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setRuleSelector) operation call.
 * Modifies the rule selector.
 *
  
 * @link [CSS#setRuleSelector](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setRuleSelector) method documentation.
 * @see [CSSOperations.setRuleSelector]
 */
@kotlinx.serialization.Serializable
data class SetRuleSelectorResponse(
    /**  
     * The resulting selector list after modification.  
     */  
    val selectorList: SelectorList

)

/**
 * Represents request frame that can be used with [CSS#setStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleSheetText) operation call.
 *
 * Sets the new stylesheet text.
 * @link [CSS#setStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleSheetText) method documentation.
 * @see [CSSOperations.setStyleSheetText]
 */
@kotlinx.serialization.Serializable
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
 * Represents response frame that is returned from [CSS#setStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleSheetText) operation call.
 * Sets the new stylesheet text.
 *
  
 * @link [CSS#setStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleSheetText) method documentation.
 * @see [CSSOperations.setStyleSheetText]
 */
@kotlinx.serialization.Serializable
data class SetStyleSheetTextResponse(
    /**  
     * URL of source map associated with script (if any).  
     */  
    val sourceMapURL: String? = null

)

/**
 * Represents request frame that can be used with [CSS#setStyleTexts](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleTexts) operation call.
 *
 * Applies specified style edits one after another in the given order.
 * @link [CSS#setStyleTexts](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleTexts) method documentation.
 * @see [CSSOperations.setStyleTexts]
 */
@kotlinx.serialization.Serializable
data class SetStyleTextsRequest(
    /**
     *
     */
    val edits: List<StyleDeclarationEdit>

)

/**
 * Represents response frame that is returned from [CSS#setStyleTexts](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleTexts) operation call.
 * Applies specified style edits one after another in the given order.
 *
  
 * @link [CSS#setStyleTexts](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleTexts) method documentation.
 * @see [CSSOperations.setStyleTexts]
 */
@kotlinx.serialization.Serializable
data class SetStyleTextsResponse(
    /**  
     * The resulting styles after modification.  
     */  
    val styles: List<CSSStyle>

)

/**
 * Represents response frame that is returned from [CSS#stopRuleUsageTracking](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-stopRuleUsageTracking) operation call.
 * Stop tracking rule usage and return the list of rules that were used since last call to
`takeCoverageDelta` (or since start of coverage instrumentation)
 *
  
 * @link [CSS#stopRuleUsageTracking](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-stopRuleUsageTracking) method documentation.
 * @see [CSSOperations.stopRuleUsageTracking]
 */
@kotlinx.serialization.Serializable
data class StopRuleUsageTrackingResponse(
    /**  
     *  
     */  
    val ruleUsage: List<RuleUsage>

)

/**
 * Represents response frame that is returned from [CSS#takeCoverageDelta](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeCoverageDelta) operation call.
 * Obtain list of rules that became used since last call to this method (or since start of coverage
instrumentation)
 *
  
 * @link [CSS#takeCoverageDelta](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeCoverageDelta) method documentation.
 * @see [CSSOperations.takeCoverageDelta]
 */
@kotlinx.serialization.Serializable
data class TakeCoverageDeltaResponse(
    /**  
     *  
     */  
    val coverage: List<RuleUsage>,

    /**  
     * Monotonically increasing time, in seconds.  
     */  
    val timestamp: Double

)

/**
 * Represents request frame that can be used with [CSS#setLocalFontsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setLocalFontsEnabled) operation call.
 *
 * Enables/disables rendering of local CSS fonts (enabled by default).
 * @link [CSS#setLocalFontsEnabled](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setLocalFontsEnabled) method documentation.
 * @see [CSSOperations.setLocalFontsEnabled]
 */
@kotlinx.serialization.Serializable
data class SetLocalFontsEnabledRequest(
    /**
     * Whether rendering of local fonts is enabled.
     */
    val enabled: Boolean

)

/**
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
 *
 * @link [CSS#fontsUpdated](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-fontsUpdated) event documentation.
 */
@kotlinx.serialization.Serializable
data class FontsUpdatedEvent(
    /**  
     * The web font that has loaded.  
     */  
    val font: FontFace? = null

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "CSS" 
    override fun eventName() = "fontsUpdated"
} 

/**
 * Fired whenever an active document stylesheet is added.
 *
 * @link [CSS#styleSheetAdded](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-styleSheetAdded) event documentation.
 */
@kotlinx.serialization.Serializable
data class StyleSheetAddedEvent(
    /**  
     * Added stylesheet metainfo.  
     */  
    val header: CSSStyleSheetHeader

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "CSS" 
    override fun eventName() = "styleSheetAdded"
} 

/**
 * Fired whenever a stylesheet is changed as a result of the client operation.
 *
 * @link [CSS#styleSheetChanged](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-styleSheetChanged) event documentation.
 */
@kotlinx.serialization.Serializable
data class StyleSheetChangedEvent(
    /**  
     *  
     */  
    val styleSheetId: StyleSheetId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "CSS" 
    override fun eventName() = "styleSheetChanged"
} 

/**
 * Fired whenever an active document stylesheet is removed.
 *
 * @link [CSS#styleSheetRemoved](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-styleSheetRemoved) event documentation.
 */
@kotlinx.serialization.Serializable
data class StyleSheetRemovedEvent(
    /**  
     * Identifier of the removed stylesheet.  
     */  
    val styleSheetId: StyleSheetId

) : pl.wendigo.chrome.protocol.Event {
    override fun domain() = "CSS" 
    override fun eventName() = "styleSheetRemoved"
} 
