package pl.wendigo.chrome.domain.css

/*
 * 
 */
typealias StyleSheetId = String

/*
 * Stylesheet type: &quot;injected&quot; for stylesheets injected via extension, &quot;user-agent&quot; for user-agent stylesheets, &quot;inspector&quot; for stylesheets created by the inspector (i.e. those holding the &quot;via inspector&quot; rules), &quot;regular&quot; for regular stylesheets.
 */
typealias StyleSheetOrigin = String

/*
 * CSS rule collection for a single pseudo style.
 */

data class PseudoElementMatches(
  /**
   * Pseudo element type.
   */
  val pseudoType : pl.wendigo.chrome.domain.dom.PseudoType,

  /**
   * Matches of CSS rules applicable to the pseudo style.
   */
  val matches : Array<RuleMatch>

)

/*
 * Inherited CSS rule collection from ancestor node.
 */

data class InheritedStyleEntry(
  /**
   * The ancestor node's inline style, if any, in the style inheritance chain.
   */
  val inlineStyle : CSSStyle? = null,

  /**
   * Matches of CSS rules matching the ancestor node in the style inheritance chain.
   */
  val matchedCSSRules : Array<RuleMatch>

)

/*
 * Match data for a CSS rule.
 */

data class RuleMatch(
  /**
   * CSS rule in the match.
   */
  val rule : CSSRule,

  /**
   * Matching selector indices in the rule's selectorList selectors (0-based).
   */
  val matchingSelectors : Array<Int>

)

/*
 * Data for a simple selector (these are delimited by commas in a selector list).
 */

data class Value(
  /**
   * Value text.
   */
  val text : String,

  /**
   * Value range in the underlying resource (if available).
   */
  val range : SourceRange? = null

)

/*
 * Selector list data.
 */

data class SelectorList(
  /**
   * Selectors in the list.
   */
  val selectors : Array<Value>,

  /**
   * Rule selector text.
   */
  val text : String

)

/*
 * CSS stylesheet metainformation.
 */

data class CSSStyleSheetHeader(
  /**
   * The stylesheet identifier.
   */
  val styleSheetId : StyleSheetId,

  /**
   * Owner frame identifier.
   */
  val frameId : pl.wendigo.chrome.domain.page.FrameId,

  /**
   * Stylesheet resource URL.
   */
  val sourceURL : String,

  /**
   * URL of source map associated with the stylesheet (if any).
   */
  val sourceMapURL : String? = null,

  /**
   * Stylesheet origin.
   */
  val origin : StyleSheetOrigin,

  /**
   * Stylesheet title.
   */
  val title : String,

  /**
   * The backend id for the owner node of the stylesheet.
   */
  val ownerNode : pl.wendigo.chrome.domain.dom.BackendNodeId? = null,

  /**
   * Denotes whether the stylesheet is disabled.
   */
  val disabled : Boolean,

  /**
   * Whether the sourceURL field value comes from the sourceURL comment.
   */
  val hasSourceURL : Boolean? = null,

  /**
   * Whether this stylesheet is created for STYLE tag by parser. This flag is not set for document.written STYLE tags.
   */
  val isInline : Boolean,

  /**
   * Line offset of the stylesheet within the resource (zero based).
   */
  val startLine : Double,

  /**
   * Column offset of the stylesheet within the resource (zero based).
   */
  val startColumn : Double

)

/*
 * CSS rule representation.
 */

data class CSSRule(
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
   */
  val styleSheetId : StyleSheetId? = null,

  /**
   * Rule selector data.
   */
  val selectorList : SelectorList,

  /**
   * Parent stylesheet's origin.
   */
  val origin : StyleSheetOrigin,

  /**
   * Associated style declaration.
   */
  val style : CSSStyle,

  /**
   * Media list array (for rules involving media queries). The array enumerates media queries starting with the innermost one, going outwards.
   */
  val media : Array<CSSMedia>? = null

)

/*
 * CSS rule usage information.
 */

data class RuleUsage(
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
   */
  val styleSheetId : StyleSheetId,

  /**
   * Style declaration range in the enclosing stylesheet (if available).
   */
  val range : SourceRange,

  /**
   * Indicates whether the rule was actually used by some element in the page.
   */
  val used : Boolean

)

/*
 * Text range within a resource. All numbers are zero-based.
 */

data class SourceRange(
  /**
   * Start line of range.
   */
  val startLine : Int,

  /**
   * Start column of range (inclusive).
   */
  val startColumn : Int,

  /**
   * End line of range
   */
  val endLine : Int,

  /**
   * End column of range (exclusive).
   */
  val endColumn : Int

)

/*
 * 
 */

data class ShorthandEntry(
  /**
   * Shorthand name.
   */
  val name : String,

  /**
   * Shorthand value.
   */
  val value : String,

  /**
   * Whether the property has "!important" annotation (implies <code>false</code> if absent).
   */
  val important : Boolean? = null

)

/*
 * 
 */

data class CSSComputedStyleProperty(
  /**
   * Computed style property name.
   */
  val name : String,

  /**
   * Computed style property value.
   */
  val value : String

)

/*
 * CSS style representation.
 */

data class CSSStyle(
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
   */
  val styleSheetId : StyleSheetId? = null,

  /**
   * CSS properties in the style.
   */
  val cssProperties : Array<CSSProperty>,

  /**
   * Computed values for all shorthands found in the style.
   */
  val shorthandEntries : Array<ShorthandEntry>,

  /**
   * Style declaration text (if available).
   */
  val cssText : String? = null,

  /**
   * Style declaration range in the enclosing stylesheet (if available).
   */
  val range : SourceRange? = null

)

/*
 * CSS property declaration data.
 */

data class CSSProperty(
  /**
   * The property name.
   */
  val name : String,

  /**
   * The property value.
   */
  val value : String,

  /**
   * Whether the property has "!important" annotation (implies <code>false</code> if absent).
   */
  val important : Boolean? = null,

  /**
   * Whether the property is implicit (implies <code>false</code> if absent).
   */
  val implicit : Boolean? = null,

  /**
   * The full property text as specified in the style.
   */
  val text : String? = null,

  /**
   * Whether the property is understood by the browser (implies <code>true</code> if absent).
   */
  val parsedOk : Boolean? = null,

  /**
   * Whether the property is disabled by the user (present for source-based properties only).
   */
  val disabled : Boolean? = null,

  /**
   * The entire property range in the enclosing style declaration (if available).
   */
  val range : SourceRange? = null

)

/*
 * CSS media rule descriptor.
 */

data class CSSMedia(
  /**
   * Media query text.
   */
  val text : String,

  /**
   * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline stylesheet's STYLE tag.
   */
  val source : String,

  /**
   * URL of the document containing the media query description.
   */
  val sourceURL : String? = null,

  /**
   * The associated rule (@media or @import) header range in the enclosing stylesheet (if available).
   */
  val range : SourceRange? = null,

  /**
   * Identifier of the stylesheet containing this object (if exists).
   */
  val styleSheetId : StyleSheetId? = null,

  /**
   * Array of media queries.
   */
  @pl.wendigo.chrome.ProtocolExperimental val mediaList : Array<MediaQuery>? = null

)

/*
 * Media query descriptor.
 */

data class MediaQuery(
  /**
   * Array of media query expressions.
   */
  val expressions : Array<MediaQueryExpression>,

  /**
   * Whether the media query condition is satisfied.
   */
  val active : Boolean

)

/*
 * Media query expression descriptor.
 */

data class MediaQueryExpression(
  /**
   * Media query expression value.
   */
  val value : Double,

  /**
   * Media query expression units.
   */
  val unit : String,

  /**
   * Media query expression feature.
   */
  val feature : String,

  /**
   * The associated range of the value text in the enclosing stylesheet (if available).
   */
  val valueRange : SourceRange? = null,

  /**
   * Computed length of media query expression (if applicable).
   */
  val computedLength : Double? = null

)

/*
 * Information about amount of glyphs that were rendered with given font.
 */

data class PlatformFontUsage(
  /**
   * Font's family name reported by platform.
   */
  val familyName : String,

  /**
   * Indicates if the font was downloaded or resolved locally.
   */
  val isCustomFont : Boolean,

  /**
   * Amount of glyphs that were rendered with this font.
   */
  val glyphCount : Double

)

/*
 * CSS keyframes rule representation.
 */

data class CSSKeyframesRule(
  /**
   * Animation name.
   */
  val animationName : Value,

  /**
   * List of keyframes.
   */
  val keyframes : Array<CSSKeyframeRule>

)

/*
 * CSS keyframe rule representation.
 */

data class CSSKeyframeRule(
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
   */
  val styleSheetId : StyleSheetId? = null,

  /**
   * Parent stylesheet's origin.
   */
  val origin : StyleSheetOrigin,

  /**
   * Associated key text.
   */
  val keyText : Value,

  /**
   * Associated style declaration.
   */
  val style : CSSStyle

)

/*
 * A descriptor of operation to mutate style declaration text.
 */

data class StyleDeclarationEdit(
  /**
   * The css style sheet identifier.
   */
  val styleSheetId : StyleSheetId,

  /**
   * The range of the style text in the enclosing stylesheet.
   */
  val range : SourceRange,

  /**
   * New style text.
   */
  val text : String

)

/*
 * Details of post layout rendered text positions. The exact layout should not be regarded as stable and may change between versions.
 */

data class InlineTextBox(
  /**
   * The absolute position bounding box.
   */
  val boundingBox : pl.wendigo.chrome.domain.dom.Rect,

  /**
   * The starting index in characters, for this post layout textbox substring.
   */
  val startCharacterIndex : Int,

  /**
   * The number of characters in this post layout textbox substring.
   */
  val numCharacters : Int

)

/*
 * Details of an element in the DOM tree with a LayoutObject.
 */

data class LayoutTreeNode(
  /**
   * The id of the related DOM node matching one from DOM.GetDocument.
   */
  val nodeId : pl.wendigo.chrome.domain.dom.NodeId,

  /**
   * The absolute position bounding box.
   */
  val boundingBox : pl.wendigo.chrome.domain.dom.Rect,

  /**
   * Contents of the LayoutText if any
   */
  val layoutText : String? = null,

  /**
   * The post layout inline text nodes, if any.
   */
  val inlineTextNodes : Array<InlineTextBox>? = null,

  /**
   * Index into the computedStyles array returned by getLayoutTreeAndStyles.
   */
  val styleIndex : Int? = null

)

/*
 * A subset of the full ComputedStyle as defined by the request whitelist.
 */

data class ComputedStyle(
  /**
   *
   */
  val properties : Array<CSSComputedStyleProperty>

)

