package pl.wendigo.chrome.api.css

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
class CSSOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the
position specified by `location`.
     *
     * @link Protocol [CSS#addRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-addRule) method documentation.
     */
    fun addRule(input: AddRuleRequest) = connection.request("CSS.addRule", input, AddRuleResponse::class.java)

    /**
     * Returns all class names from specified stylesheet.
     *
     * @link Protocol [CSS#collectClassNames](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-collectClassNames) method documentation.
     */
    fun collectClassNames(input: CollectClassNamesRequest) = connection.request("CSS.collectClassNames", input, CollectClassNamesResponse::class.java)

    /**
     * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
     *
     * @link Protocol [CSS#createStyleSheet](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-createStyleSheet) method documentation.
     */
    fun createStyleSheet(input: CreateStyleSheetRequest) = connection.request("CSS.createStyleSheet", input, CreateStyleSheetResponse::class.java)

    /**
     * Disables the CSS agent for the given page.
     *
     * @link Protocol [CSS#disable](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-disable) method documentation.
     */
    fun disable() = connection.request("CSS.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been
enabled until the result of this command is received.
     *
     * @link Protocol [CSS#enable](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-enable) method documentation.
     */
    fun enable() = connection.request("CSS.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Ensures that the given node will have specified pseudo-classes whenever its style is computed by
the browser.
     *
     * @link Protocol [CSS#forcePseudoState](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-forcePseudoState) method documentation.
     */
    fun forcePseudoState(input: ForcePseudoStateRequest) = connection.request("CSS.forcePseudoState", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     *
     *
     * @link Protocol [CSS#getBackgroundColors](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getBackgroundColors) method documentation.
     */
    fun getBackgroundColors(input: GetBackgroundColorsRequest) = connection.request("CSS.getBackgroundColors", input, GetBackgroundColorsResponse::class.java)

    /**
     * Returns the computed style for a DOM node identified by `nodeId`.
     *
     * @link Protocol [CSS#getComputedStyleForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getComputedStyleForNode) method documentation.
     */
    fun getComputedStyleForNode(input: GetComputedStyleForNodeRequest) = connection.request("CSS.getComputedStyleForNode", input, GetComputedStyleForNodeResponse::class.java)

    /**
     * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM
attributes) for a DOM node identified by `nodeId`.
     *
     * @link Protocol [CSS#getInlineStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getInlineStylesForNode) method documentation.
     */
    fun getInlineStylesForNode(input: GetInlineStylesForNodeRequest) = connection.request("CSS.getInlineStylesForNode", input, GetInlineStylesForNodeResponse::class.java)

    /**
     * Returns requested styles for a DOM node identified by `nodeId`.
     *
     * @link Protocol [CSS#getMatchedStylesForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMatchedStylesForNode) method documentation.
     */
    fun getMatchedStylesForNode(input: GetMatchedStylesForNodeRequest) = connection.request("CSS.getMatchedStylesForNode", input, GetMatchedStylesForNodeResponse::class.java)

    /**
     * Returns all media queries parsed by the rendering engine.
     *
     * @link Protocol [CSS#getMediaQueries](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getMediaQueries) method documentation.
     */
    fun getMediaQueries() = connection.request("CSS.getMediaQueries", null, GetMediaQueriesResponse::class.java)

    /**
     * Requests information about platform fonts which we used to render child TextNodes in the given
node.
     *
     * @link Protocol [CSS#getPlatformFontsForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getPlatformFontsForNode) method documentation.
     */
    fun getPlatformFontsForNode(input: GetPlatformFontsForNodeRequest) = connection.request("CSS.getPlatformFontsForNode", input, GetPlatformFontsForNodeResponse::class.java)

    /**
     * Returns the current textual content for a stylesheet.
     *
     * @link Protocol [CSS#getStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-getStyleSheetText) method documentation.
     */
    fun getStyleSheetText(input: GetStyleSheetTextRequest) = connection.request("CSS.getStyleSheetText", input, GetStyleSheetTextResponse::class.java)

    /**
     * Find a rule with the given active property for the given node and set the new value for this
property
     *
     * @link Protocol [CSS#setEffectivePropertyValueForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setEffectivePropertyValueForNode) method documentation.
     */
    fun setEffectivePropertyValueForNode(input: SetEffectivePropertyValueForNodeRequest) = connection.request("CSS.setEffectivePropertyValueForNode", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Modifies the keyframe rule key text.
     *
     * @link Protocol [CSS#setKeyframeKey](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setKeyframeKey) method documentation.
     */
    fun setKeyframeKey(input: SetKeyframeKeyRequest) = connection.request("CSS.setKeyframeKey", input, SetKeyframeKeyResponse::class.java)

    /**
     * Modifies the rule selector.
     *
     * @link Protocol [CSS#setMediaText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setMediaText) method documentation.
     */
    fun setMediaText(input: SetMediaTextRequest) = connection.request("CSS.setMediaText", input, SetMediaTextResponse::class.java)

    /**
     * Modifies the rule selector.
     *
     * @link Protocol [CSS#setRuleSelector](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setRuleSelector) method documentation.
     */
    fun setRuleSelector(input: SetRuleSelectorRequest) = connection.request("CSS.setRuleSelector", input, SetRuleSelectorResponse::class.java)

    /**
     * Sets the new stylesheet text.
     *
     * @link Protocol [CSS#setStyleSheetText](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleSheetText) method documentation.
     */
    fun setStyleSheetText(input: SetStyleSheetTextRequest) = connection.request("CSS.setStyleSheetText", input, SetStyleSheetTextResponse::class.java)

    /**
     * Applies specified style edits one after another in the given order.
     *
     * @link Protocol [CSS#setStyleTexts](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setStyleTexts) method documentation.
     */
    fun setStyleTexts(input: SetStyleTextsRequest) = connection.request("CSS.setStyleTexts", input, SetStyleTextsResponse::class.java)

    /**
     * Enables the selector recording.
     *
     * @link Protocol [CSS#startRuleUsageTracking](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-startRuleUsageTracking) method documentation.
     */
    fun startRuleUsageTracking() = connection.request("CSS.startRuleUsageTracking", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java)

    /**
     * Stop tracking rule usage and return the list of rules that were used since last call to
`takeCoverageDelta` (or since start of coverage instrumentation)
     *
     * @link Protocol [CSS#stopRuleUsageTracking](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-stopRuleUsageTracking) method documentation.
     */
    fun stopRuleUsageTracking() = connection.request("CSS.stopRuleUsageTracking", null, StopRuleUsageTrackingResponse::class.java)

    /**
     * Obtain list of rules that became used since last call to this method (or since start of coverage
instrumentation)
     *
     * @link Protocol [CSS#takeCoverageDelta](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-takeCoverageDelta) method documentation.
     */
    fun takeCoverageDelta() = connection.request("CSS.takeCoverageDelta", null, TakeCoverageDeltaResponse::class.java)

    /**
     *  Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
     */
    fun fontsUpdated(): io.reactivex.Flowable<FontsUpdatedEvent> = connection.events("CSS.fontsUpdated", FontsUpdatedEvent::class.java)

    /**
     *  Fires whenever a MediaQuery result changes (for example, after a browser window has been
resized.) The current implementation considers only viewport-dependent media features.
     */
    fun mediaQueryResultChanged(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> = connection.events("CSS.mediaQueryResultChanged", pl.wendigo.chrome.protocol.Event::class.java)

    /**
     *  Fired whenever an active document stylesheet is added.
     */
    fun styleSheetAdded(): io.reactivex.Flowable<StyleSheetAddedEvent> = connection.events("CSS.styleSheetAdded", StyleSheetAddedEvent::class.java)

    /**
     *  Fired whenever a stylesheet is changed as a result of the client operation.
     */
    fun styleSheetChanged(): io.reactivex.Flowable<StyleSheetChangedEvent> = connection.events("CSS.styleSheetChanged", StyleSheetChangedEvent::class.java)

    /**
     *  Fired whenever an active document stylesheet is removed.
     */
    fun styleSheetRemoved(): io.reactivex.Flowable<StyleSheetRemovedEvent> = connection.events("CSS.styleSheetRemoved", StyleSheetRemovedEvent::class.java)

    /**
     * Returns flowable capturing all CSS domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.allEvents().filter {
            it.protocolDomain() == "CSS"
        }
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
data class GetStyleSheetTextResponse(
    /**  
     * The stylesheet text.  
     */  
    val text: String

)

/**
 * Represents request frame that can be used with [CSS#setEffectivePropertyValueForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setEffectivePropertyValueForNode) operation call.
 *
 * Find a rule with the given active property for the given node and set the new value for this
property
 * @link [CSS#setEffectivePropertyValueForNode](https://chromedevtools.github.io/devtools-protocol/tot/CSS#method-setEffectivePropertyValueForNode) method documentation.
 * @see [CSSOperations.setEffectivePropertyValueForNode]
 */
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
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
web font
 *
 * @link [CSS#fontsUpdated](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-fontsUpdated) event documentation.
 */
data class FontsUpdatedEvent(
    /**  
     * The web font that has loaded.  
     */  
    val font: FontFace? = null

) : pl.wendigo.chrome.protocol.Event(domain = "CSS", name = "fontsUpdated")

/**
 * Fired whenever an active document stylesheet is added.
 *
 * @link [CSS#styleSheetAdded](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-styleSheetAdded) event documentation.
 */
data class StyleSheetAddedEvent(
    /**  
     * Added stylesheet metainfo.  
     */  
    val header: CSSStyleSheetHeader

) : pl.wendigo.chrome.protocol.Event(domain = "CSS", name = "styleSheetAdded")

/**
 * Fired whenever a stylesheet is changed as a result of the client operation.
 *
 * @link [CSS#styleSheetChanged](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-styleSheetChanged) event documentation.
 */
data class StyleSheetChangedEvent(
    /**  
     *  
     */  
    val styleSheetId: StyleSheetId

) : pl.wendigo.chrome.protocol.Event(domain = "CSS", name = "styleSheetChanged")

/**
 * Fired whenever an active document stylesheet is removed.
 *
 * @link [CSS#styleSheetRemoved](https://chromedevtools.github.io/devtools-protocol/tot/CSS#event-styleSheetRemoved) event documentation.
 */
data class StyleSheetRemovedEvent(
    /**  
     * Identifier of the removed stylesheet.  
     */  
    val styleSheetId: StyleSheetId

) : pl.wendigo.chrome.protocol.Event(domain = "CSS", name = "styleSheetRemoved")
