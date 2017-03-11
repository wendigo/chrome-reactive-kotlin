package pl.wendigo.chrome.domain.css

/**
 * This domain exposes CSS read/write operations. All CSS objects (stylesheets, rules, and styles) have an associated <code>id</code> used in subsequent operations on the related object. Each object type has a specific <code>id</code> structure, and those are not interchangeable between objects of different kinds. CSS objects can be loaded using the <code>get*ForNode()</code> calls (which accept a DOM node id). A client can also discover all the existing stylesheets with the <code>getAllStyleSheets()</code> method (or keeping track of the <code>styleSheetAdded</code>/<code>styleSheetRemoved</code> events) and subsequently load the required stylesheet contents using the <code>getStyleSheet[Text]()</code> methods.
 */
@pl.wendigo.chrome.ProtocolExperimental class CSSDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been enabled until the result of this command is received.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("CSS.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables the CSS agent for the given page.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("CSS.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns requested styles for a DOM node identified by <code>nodeId</code>.
	 */
	  fun getMatchedStylesForNode(input : GetMatchedStylesForNodeRequest) : io.reactivex.Flowable<GetMatchedStylesForNodeResponse> {
        return connection.runAndCaptureResponse("CSS.getMatchedStylesForNode", input, GetMatchedStylesForNodeResponse::class.java)
	}

	/**
	 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by <code>nodeId</code>.
	 */
	  fun getInlineStylesForNode(input : GetInlineStylesForNodeRequest) : io.reactivex.Flowable<GetInlineStylesForNodeResponse> {
        return connection.runAndCaptureResponse("CSS.getInlineStylesForNode", input, GetInlineStylesForNodeResponse::class.java)
	}

	/**
	 * Returns the computed style for a DOM node identified by <code>nodeId</code>.
	 */
	  fun getComputedStyleForNode(input : GetComputedStyleForNodeRequest) : io.reactivex.Flowable<GetComputedStyleForNodeResponse> {
        return connection.runAndCaptureResponse("CSS.getComputedStyleForNode", input, GetComputedStyleForNodeResponse::class.java)
	}

	/**
	 * Requests information about platform fonts which we used to render child TextNodes in the given node.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun getPlatformFontsForNode(input : GetPlatformFontsForNodeRequest) : io.reactivex.Flowable<GetPlatformFontsForNodeResponse> {
        return connection.runAndCaptureResponse("CSS.getPlatformFontsForNode", input, GetPlatformFontsForNodeResponse::class.java)
	}

	/**
	 * Returns the current textual content and the URL for a stylesheet.
	 */
	  fun getStyleSheetText(input : GetStyleSheetTextRequest) : io.reactivex.Flowable<GetStyleSheetTextResponse> {
        return connection.runAndCaptureResponse("CSS.getStyleSheetText", input, GetStyleSheetTextResponse::class.java)
	}

	/**
	 * Returns all class names from specified stylesheet.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun collectClassNames(input : CollectClassNamesRequest) : io.reactivex.Flowable<CollectClassNamesResponse> {
        return connection.runAndCaptureResponse("CSS.collectClassNames", input, CollectClassNamesResponse::class.java)
	}

	/**
	 * Sets the new stylesheet text.
	 */
	  fun setStyleSheetText(input : SetStyleSheetTextRequest) : io.reactivex.Flowable<SetStyleSheetTextResponse> {
        return connection.runAndCaptureResponse("CSS.setStyleSheetText", input, SetStyleSheetTextResponse::class.java)
	}

	/**
	 * Modifies the rule selector.
	 */
	  fun setRuleSelector(input : SetRuleSelectorRequest) : io.reactivex.Flowable<SetRuleSelectorResponse> {
        return connection.runAndCaptureResponse("CSS.setRuleSelector", input, SetRuleSelectorResponse::class.java)
	}

	/**
	 * Modifies the keyframe rule key text.
	 */
	  fun setKeyframeKey(input : SetKeyframeKeyRequest) : io.reactivex.Flowable<SetKeyframeKeyResponse> {
        return connection.runAndCaptureResponse("CSS.setKeyframeKey", input, SetKeyframeKeyResponse::class.java)
	}

	/**
	 * Applies specified style edits one after another in the given order.
	 */
	  fun setStyleTexts(input : SetStyleTextsRequest) : io.reactivex.Flowable<SetStyleTextsResponse> {
        return connection.runAndCaptureResponse("CSS.setStyleTexts", input, SetStyleTextsResponse::class.java)
	}

	/**
	 * Modifies the rule selector.
	 */
	  fun setMediaText(input : SetMediaTextRequest) : io.reactivex.Flowable<SetMediaTextResponse> {
        return connection.runAndCaptureResponse("CSS.setMediaText", input, SetMediaTextResponse::class.java)
	}

	/**
	 * Creates a new special "via-inspector" stylesheet in the frame with given <code>frameId</code>.
	 */
	  fun createStyleSheet(input : CreateStyleSheetRequest) : io.reactivex.Flowable<CreateStyleSheetResponse> {
        return connection.runAndCaptureResponse("CSS.createStyleSheet", input, CreateStyleSheetResponse::class.java)
	}

	/**
	 * Inserts a new rule with the given <code>ruleText</code> in a stylesheet with given <code>styleSheetId</code>, at the position specified by <code>location</code>.
	 */
	  fun addRule(input : AddRuleRequest) : io.reactivex.Flowable<AddRuleResponse> {
        return connection.runAndCaptureResponse("CSS.addRule", input, AddRuleResponse::class.java)
	}

	/**
	 * Ensures that the given node will have specified pseudo-classes whenever its style is computed by the browser.
	 */
	  fun forcePseudoState(input : ForcePseudoStateRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("CSS.forcePseudoState", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns all media queries parsed by the rendering engine.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun getMediaQueries() : io.reactivex.Flowable<GetMediaQueriesResponse> {
        return connection.runAndCaptureResponse("CSS.getMediaQueries", null, GetMediaQueriesResponse::class.java)
	}

	/**
	 * Find a rule with the given active property for the given node and set the new value for this property
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun setEffectivePropertyValueForNode(input : SetEffectivePropertyValueForNodeRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("CSS.setEffectivePropertyValueForNode", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun getBackgroundColors(input : GetBackgroundColorsRequest) : io.reactivex.Flowable<GetBackgroundColorsResponse> {
        return connection.runAndCaptureResponse("CSS.getBackgroundColors", input, GetBackgroundColorsResponse::class.java)
	}

	/**
	 * For the main document and any content documents, return the LayoutTreeNodes and a whitelisted subset of the computed style. It only returns pushed nodes, on way to pull all nodes is to call DOM.getDocument with a depth of -1.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun getLayoutTreeAndStyles(input : GetLayoutTreeAndStylesRequest) : io.reactivex.Flowable<GetLayoutTreeAndStylesResponse> {
        return connection.runAndCaptureResponse("CSS.getLayoutTreeAndStyles", input, GetLayoutTreeAndStylesResponse::class.java)
	}

	/**
	 * Enables the selector recording.
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun startRuleUsageTracking() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("CSS.startRuleUsageTracking", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * The list of rules with an indication of whether these were used
	 */
	@pl.wendigo.chrome.ProtocolExperimental
    fun stopRuleUsageTracking() : io.reactivex.Flowable<StopRuleUsageTrackingResponse> {
        return connection.runAndCaptureResponse("CSS.stopRuleUsageTracking", null, StopRuleUsageTrackingResponse::class.java)
	}

  
  /**
   * Fires whenever a MediaQuery result changes (for example, after a browser window has been resized.) The current implementation considers only viewport-dependent media features.
   */
   fun onMediaQueryResultChanged() : io.reactivex.Flowable<pl.wendigo.chrome.DebuggerEvent> {
      return connection.captureEvents("CSS.mediaQueryResultChanged", pl.wendigo.chrome.DebuggerEvent::class.java)
   }

  /**
   * Fires whenever a web font gets loaded.
   */
   fun onFontsUpdated() : io.reactivex.Flowable<pl.wendigo.chrome.DebuggerEvent> {
      return connection.captureEvents("CSS.fontsUpdated", pl.wendigo.chrome.DebuggerEvent::class.java)
   }

  /**
   * Fired whenever a stylesheet is changed as a result of the client operation.
   */
   fun onStyleSheetChanged() : io.reactivex.Flowable<StyleSheetChangedEvent> {
      return connection.captureEvents("CSS.styleSheetChanged", StyleSheetChangedEvent::class.java)
   }

  /**
   * Fired whenever an active document stylesheet is added.
   */
   fun onStyleSheetAdded() : io.reactivex.Flowable<StyleSheetAddedEvent> {
      return connection.captureEvents("CSS.styleSheetAdded", StyleSheetAddedEvent::class.java)
   }

  /**
   * Fired whenever an active document stylesheet is removed.
   */
   fun onStyleSheetRemoved() : io.reactivex.Flowable<StyleSheetRemovedEvent> {
      return connection.captureEvents("CSS.styleSheetRemoved", StyleSheetRemovedEvent::class.java)
   }
}





/**
 * Represents requestFrame parameters that can be used with CSS.getMatchedStylesForNode method call.
 *
 * Returns requested styles for a DOM node identified by <code>nodeId</code>.
 */
data class GetMatchedStylesForNodeRequest (
    /**
     * 
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Returns requested styles for a DOM node identified by <code>nodeId</code>.
 */
data class GetMatchedStylesForNodeResponse(
  /**
   * Inline style for the specified DOM node.
   */
  val inlineStyle : CSSStyle? = null,

  /**
   * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
   */
  val attributesStyle : CSSStyle? = null,

  /**
   * CSS rules matching this node, from all applicable stylesheets.
   */
  val matchedCSSRules : Array<RuleMatch>? = null,

  /**
   * Pseudo style matches for this node.
   */
  val pseudoElements : Array<PseudoElementMatches>? = null,

  /**
   * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
   */
  val inherited : Array<InheritedStyleEntry>? = null,

  /**
   * A list of CSS keyframed animations matching this node.
   */
  val cssKeyframesRules : Array<CSSKeyframesRule>? = null

)

/**
 * Represents requestFrame parameters that can be used with CSS.getInlineStylesForNode method call.
 *
 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by <code>nodeId</code>.
 */
data class GetInlineStylesForNodeRequest (
    /**
     * 
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by <code>nodeId</code>.
 */
data class GetInlineStylesForNodeResponse(
  /**
   * Inline style for the specified DOM node.
   */
  val inlineStyle : CSSStyle? = null,

  /**
   * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
   */
  val attributesStyle : CSSStyle? = null

)

/**
 * Represents requestFrame parameters that can be used with CSS.getComputedStyleForNode method call.
 *
 * Returns the computed style for a DOM node identified by <code>nodeId</code>.
 */
data class GetComputedStyleForNodeRequest (
    /**
     * 
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Returns the computed style for a DOM node identified by <code>nodeId</code>.
 */
data class GetComputedStyleForNodeResponse(
  /**
   * Computed style for the specified DOM node.
   */
  val computedStyle : Array<CSSComputedStyleProperty>

)

/**
 * Represents requestFrame parameters that can be used with CSS.getPlatformFontsForNode method call.
 *
 * Requests information about platform fonts which we used to render child TextNodes in the given node.
 */
data class GetPlatformFontsForNodeRequest (
    /**
     * 
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Requests information about platform fonts which we used to render child TextNodes in the given node.
 */
data class GetPlatformFontsForNodeResponse(
  /**
   * Usage statistics for every employed platform font.
   */
  val fonts : Array<PlatformFontUsage>

)

/**
 * Represents requestFrame parameters that can be used with CSS.getStyleSheetText method call.
 *
 * Returns the current textual content and the URL for a stylesheet.
 */
data class GetStyleSheetTextRequest (
    /**
     * 
     */
    val styleSheetId : StyleSheetId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Returns the current textual content and the URL for a stylesheet.
 */
data class GetStyleSheetTextResponse(
  /**
   * The stylesheet text.
   */
  val text : String

)

/**
 * Represents requestFrame parameters that can be used with CSS.collectClassNames method call.
 *
 * Returns all class names from specified stylesheet.
 */
data class CollectClassNamesRequest (
    /**
     * 
     */
    val styleSheetId : StyleSheetId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Returns all class names from specified stylesheet.
 */
data class CollectClassNamesResponse(
  /**
   * Class name list.
   */
  val classNames : Array<String>

)

/**
 * Represents requestFrame parameters that can be used with CSS.setStyleSheetText method call.
 *
 * Sets the new stylesheet text.
 */
data class SetStyleSheetTextRequest (
    /**
     * 
     */
    val styleSheetId : StyleSheetId,

    /**
     * 
     */
    val text : String

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Sets the new stylesheet text.
 */
data class SetStyleSheetTextResponse(
  /**
   * URL of source map associated with script (if any).
   */
  val sourceMapURL : String? = null

)

/**
 * Represents requestFrame parameters that can be used with CSS.setRuleSelector method call.
 *
 * Modifies the rule selector.
 */
data class SetRuleSelectorRequest (
    /**
     * 
     */
    val styleSheetId : StyleSheetId,

    /**
     * 
     */
    val range : SourceRange,

    /**
     * 
     */
    val selector : String

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Modifies the rule selector.
 */
data class SetRuleSelectorResponse(
  /**
   * The resulting selector list after modification.
   */
  val selectorList : SelectorList

)

/**
 * Represents requestFrame parameters that can be used with CSS.setKeyframeKey method call.
 *
 * Modifies the keyframe rule key text.
 */
data class SetKeyframeKeyRequest (
    /**
     * 
     */
    val styleSheetId : StyleSheetId,

    /**
     * 
     */
    val range : SourceRange,

    /**
     * 
     */
    val keyText : String

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Modifies the keyframe rule key text.
 */
data class SetKeyframeKeyResponse(
  /**
   * The resulting key text after modification.
   */
  val keyText : Value

)

/**
 * Represents requestFrame parameters that can be used with CSS.setStyleTexts method call.
 *
 * Applies specified style edits one after another in the given order.
 */
data class SetStyleTextsRequest (
    /**
     * 
     */
    val edits : Array<StyleDeclarationEdit>

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Applies specified style edits one after another in the given order.
 */
data class SetStyleTextsResponse(
  /**
   * The resulting styles after modification.
   */
  val styles : Array<CSSStyle>

)

/**
 * Represents requestFrame parameters that can be used with CSS.setMediaText method call.
 *
 * Modifies the rule selector.
 */
data class SetMediaTextRequest (
    /**
     * 
     */
    val styleSheetId : StyleSheetId,

    /**
     * 
     */
    val range : SourceRange,

    /**
     * 
     */
    val text : String

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Modifies the rule selector.
 */
data class SetMediaTextResponse(
  /**
   * The resulting CSS media rule after modification.
   */
  val media : CSSMedia

)

/**
 * Represents requestFrame parameters that can be used with CSS.createStyleSheet method call.
 *
 * Creates a new special "via-inspector" stylesheet in the frame with given <code>frameId</code>.
 */
data class CreateStyleSheetRequest (
    /**
     * Identifier of the frame where "via-inspector" stylesheet should be created.
     */
    val frameId : pl.wendigo.chrome.domain.page.FrameId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Creates a new special "via-inspector" stylesheet in the frame with given <code>frameId</code>.
 */
data class CreateStyleSheetResponse(
  /**
   * Identifier of the created "via-inspector" stylesheet.
   */
  val styleSheetId : StyleSheetId

)

/**
 * Represents requestFrame parameters that can be used with CSS.addRule method call.
 *
 * Inserts a new rule with the given <code>ruleText</code> in a stylesheet with given <code>styleSheetId</code>, at the position specified by <code>location</code>.
 */
data class AddRuleRequest (
    /**
     * The css style sheet identifier where a new rule should be inserted.
     */
    val styleSheetId : StyleSheetId,

    /**
     * The text of a new rule.
     */
    val ruleText : String,

    /**
     * Text position of a new rule in the target style sheet.
     */
    val location : SourceRange

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * Inserts a new rule with the given <code>ruleText</code> in a stylesheet with given <code>styleSheetId</code>, at the position specified by <code>location</code>.
 */
data class AddRuleResponse(
  /**
   * The newly created rule.
   */
  val rule : CSSRule

)

/**
 * Represents requestFrame parameters that can be used with CSS.forcePseudoState method call.
 *
 * Ensures that the given node will have specified pseudo-classes whenever its style is computed by the browser.
 */
data class ForcePseudoStateRequest (
    /**
     * The element id for which to force the pseudo state.
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId,

    /**
     * Element pseudo classes to force when computing the element's style.
     */
    val forcedPseudoClasses : Array<String>

)



/**
 * Represents responseFrame from CSS. method call.
 *
 * Returns all media queries parsed by the rendering engine.
 */
data class GetMediaQueriesResponse(
  /**
   * 
   */
  val medias : Array<CSSMedia>

)

/**
 * Represents requestFrame parameters that can be used with CSS.setEffectivePropertyValueForNode method call.
 *
 * Find a rule with the given active property for the given node and set the new value for this property
 */
data class SetEffectivePropertyValueForNodeRequest (
    /**
     * The element id for which to set property.
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId,

    /**
     * 
     */
    val propertyName : String,

    /**
     * 
     */
    val value : String

)


/**
 * Represents requestFrame parameters that can be used with CSS.getBackgroundColors method call.
 *
 * 
 */
data class GetBackgroundColorsRequest (
    /**
     * Id of the node to get background colors for.
     */
    val nodeId : pl.wendigo.chrome.domain.dom.NodeId

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * 
 */
data class GetBackgroundColorsResponse(
  /**
   * The range of background colors behind this element, if it contains any visible text. If no visible text is present, this will be undefined. In the case of a flat background color, this will consist of simply that color. In the case of a gradient, this will consist of each of the color stops. For anything more complicated, this will be an empty array. Images will be ignored (as if the image had failed to load).
   */
  val backgroundColors : Array<String>? = null

)

/**
 * Represents requestFrame parameters that can be used with CSS.getLayoutTreeAndStyles method call.
 *
 * For the main document and any content documents, return the LayoutTreeNodes and a whitelisted subset of the computed style. It only returns pushed nodes, on way to pull all nodes is to call DOM.getDocument with a depth of -1.
 */
data class GetLayoutTreeAndStylesRequest (
    /**
     * Whitelist of computed styles to return.
     */
    val computedStyleWhitelist : Array<String>

)

/**
 * Represents responseFrame from CSS. method call.
 *
 * For the main document and any content documents, return the LayoutTreeNodes and a whitelisted subset of the computed style. It only returns pushed nodes, on way to pull all nodes is to call DOM.getDocument with a depth of -1.
 */
data class GetLayoutTreeAndStylesResponse(
  /**
   * 
   */
  val layoutTreeNodes : Array<LayoutTreeNode>,

  /**
   * 
   */
  val computedStyles : Array<ComputedStyle>

)




/**
 * Represents responseFrame from CSS. method call.
 *
 * The list of rules with an indication of whether these were used
 */
data class StopRuleUsageTrackingResponse(
  /**
   * 
   */
  val ruleUsage : Array<RuleUsage>

)




/**
 * Represents responseFrame from CSS. method call.
 *
 * Fired whenever a stylesheet is changed as a result of the client operation.
 */
data class StyleSheetChangedEvent(
  /**
   * 
   */
  val styleSheetId : StyleSheetId

) : pl.wendigo.chrome.DebuggerEvent(domain = "CSS", name = "styleSheetChanged")

/**
 * Represents responseFrame from CSS. method call.
 *
 * Fired whenever an active document stylesheet is added.
 */
data class StyleSheetAddedEvent(
  /**
   * Added stylesheet metainfo.
   */
  val header : CSSStyleSheetHeader

) : pl.wendigo.chrome.DebuggerEvent(domain = "CSS", name = "styleSheetAdded")

/**
 * Represents responseFrame from CSS. method call.
 *
 * Fired whenever an active document stylesheet is removed.
 */
data class StyleSheetRemovedEvent(
  /**
   * Identifier of the removed stylesheet.
   */
  val styleSheetId : StyleSheetId

) : pl.wendigo.chrome.DebuggerEvent(domain = "CSS", name = "styleSheetRemoved")

