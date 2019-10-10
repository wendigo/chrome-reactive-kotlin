package pl.wendigo.chrome.api.css

/**
 *
 *
 * @link [CSS#StyleSheetId](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-StyleSheetId) type documentation.
 */

typealias StyleSheetId = String

/**
 * Stylesheet type: &quot;injected&quot; for stylesheets injected via extension, &quot;user-agent&quot; for user-agent
stylesheets, &quot;inspector&quot; for stylesheets created by the inspector (i.e. those holding the &quot;via
inspector&quot; rules), &quot;regular&quot; for regular stylesheets.
 *
 * @link [CSS#StyleSheetOrigin](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-StyleSheetOrigin) type documentation.
 */
enum class StyleSheetOrigin {
    @com.fasterxml.jackson.annotation.JsonProperty("injected")
    INJECTED,
    @com.fasterxml.jackson.annotation.JsonProperty("user-agent")
    USER_AGENT,
    @com.fasterxml.jackson.annotation.JsonProperty("inspector")
    INSPECTOR,
    @com.fasterxml.jackson.annotation.JsonProperty("regular")
    REGULAR;
}

/**
 * CSS rule collection for a single pseudo style.
 *
 * @link [CSS#PseudoElementMatches](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-PseudoElementMatches) type documentation.
 */

data class PseudoElementMatches(
    /**  
     * Pseudo element type.  
     */  
    val pseudoType: pl.wendigo.chrome.api.dom.PseudoType,

    /**  
     * Matches of CSS rules applicable to the pseudo style.  
     */  
    val matches: List<RuleMatch>
)

/**
 * Inherited CSS rule collection from ancestor node.
 *
 * @link [CSS#InheritedStyleEntry](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-InheritedStyleEntry) type documentation.
 */

data class InheritedStyleEntry(
    /**  
     * The ancestor node's inline style, if any, in the style inheritance chain.  
     */  
    val inlineStyle: CSSStyle? = null,

    /**  
     * Matches of CSS rules matching the ancestor node in the style inheritance chain.  
     */  
    val matchedCSSRules: List<RuleMatch>
)

/**
 * Match data for a CSS rule.
 *
 * @link [CSS#RuleMatch](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-RuleMatch) type documentation.
 */

data class RuleMatch(
    /**  
     * CSS rule in the match.  
     */  
    val rule: CSSRule,

    /**  
     * Matching selector indices in the rule's selectorList selectors (0-based).  
     */  
    val matchingSelectors: List<Int>
)

/**
 * Data for a simple selector (these are delimited by commas in a selector list).
 *
 * @link [CSS#Value](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-Value) type documentation.
 */

data class Value(
    /**  
     * Value text.  
     */  
    val text: String,

    /**  
     * Value range in the underlying resource (if available).  
     */  
    val range: SourceRange? = null
)

/**
 * Selector list data.
 *
 * @link [CSS#SelectorList](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-SelectorList) type documentation.
 */

data class SelectorList(
    /**  
     * Selectors in the list.  
     */  
    val selectors: List<Value>,

    /**  
     * Rule selector text.  
     */  
    val text: String
)

/**
 * CSS stylesheet metainformation.
 *
 * @link [CSS#CSSStyleSheetHeader](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSStyleSheetHeader) type documentation.
 */

data class CSSStyleSheetHeader(
    /**  
     * The stylesheet identifier.  
     */  
    val styleSheetId: StyleSheetId,

    /**  
     * Owner frame identifier.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     * Stylesheet resource URL.  
     */  
    val sourceURL: String,

    /**  
     * URL of source map associated with the stylesheet (if any).  
     */  
    val sourceMapURL: String? = null,

    /**  
     * Stylesheet origin.  
     */  
    val origin: StyleSheetOrigin,

    /**  
     * Stylesheet title.  
     */  
    val title: String,

    /**  
     * The backend id for the owner node of the stylesheet.  
     */  
    val ownerNode: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

    /**  
     * Denotes whether the stylesheet is disabled.  
     */  
    val disabled: Boolean,

    /**  
     * Whether the sourceURL field value comes from the sourceURL comment.  
     */  
    val hasSourceURL: Boolean? = null,

    /**  
     * Whether this stylesheet is created for STYLE tag by parser. This flag is not set for  
     document.written STYLE tags.  
     */  
    val isInline: Boolean,

    /**  
     * Line offset of the stylesheet within the resource (zero based).  
     */  
    val startLine: Double,

    /**  
     * Column offset of the stylesheet within the resource (zero based).  
     */  
    val startColumn: Double,

    /**  
     * Size of the content (in characters).  
     */  
    val length: Double,

    /**  
     * Line offset of the end of the stylesheet within the resource (zero based).  
     */  
    val endLine: Double,

    /**  
     * Column offset of the end of the stylesheet within the resource (zero based).  
     */  
    val endColumn: Double
)

/**
 * CSS rule representation.
 *
 * @link [CSS#CSSRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSRule) type documentation.
 */

data class CSSRule(
    /**  
     * The css style sheet identifier (absent for user agent stylesheet and user-specified  
     stylesheet rules) this rule came from.  
     */  
    val styleSheetId: StyleSheetId? = null,

    /**  
     * Rule selector data.  
     */  
    val selectorList: SelectorList,

    /**  
     * Parent stylesheet's origin.  
     */  
    val origin: StyleSheetOrigin,

    /**  
     * Associated style declaration.  
     */  
    val style: CSSStyle,

    /**  
     * Media list array (for rules involving media queries). The array enumerates media queries  
     starting with the innermost one, going outwards.  
     */  
    val media: List<CSSMedia>? = null
)

/**
 * CSS coverage information.
 *
 * @link [CSS#RuleUsage](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-RuleUsage) type documentation.
 */

data class RuleUsage(
    /**  
     * The css style sheet identifier (absent for user agent stylesheet and user-specified  
     stylesheet rules) this rule came from.  
     */  
    val styleSheetId: StyleSheetId,

    /**  
     * Offset of the start of the rule (including selector) from the beginning of the stylesheet.  
     */  
    val startOffset: Double,

    /**  
     * Offset of the end of the rule body from the beginning of the stylesheet.  
     */  
    val endOffset: Double,

    /**  
     * Indicates whether the rule was actually used by some element in the page.  
     */  
    val used: Boolean
)

/**
 * Text range within a resource. All numbers are zero-based.
 *
 * @link [CSS#SourceRange](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-SourceRange) type documentation.
 */

data class SourceRange(
    /**  
     * Start line of range.  
     */  
    val startLine: Int,

    /**  
     * Start column of range (inclusive).  
     */  
    val startColumn: Int,

    /**  
     * End line of range  
     */  
    val endLine: Int,

    /**  
     * End column of range (exclusive).  
     */  
    val endColumn: Int
)

/**
 *
 *
 * @link [CSS#ShorthandEntry](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-ShorthandEntry) type documentation.
 */

data class ShorthandEntry(
    /**  
     * Shorthand name.  
     */  
    val name: String,

    /**  
     * Shorthand value.  
     */  
    val value: String,

    /**  
     * Whether the property has "!important" annotation (implies `false` if absent).  
     */  
    val important: Boolean? = null
)

/**
 *
 *
 * @link [CSS#CSSComputedStyleProperty](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSComputedStyleProperty) type documentation.
 */

data class CSSComputedStyleProperty(
    /**  
     * Computed style property name.  
     */  
    val name: String,

    /**  
     * Computed style property value.  
     */  
    val value: String
)

/**
 * CSS style representation.
 *
 * @link [CSS#CSSStyle](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSStyle) type documentation.
 */

data class CSSStyle(
    /**  
     * The css style sheet identifier (absent for user agent stylesheet and user-specified  
     stylesheet rules) this rule came from.  
     */  
    val styleSheetId: StyleSheetId? = null,

    /**  
     * CSS properties in the style.  
     */  
    val cssProperties: List<CSSProperty>,

    /**  
     * Computed values for all shorthands found in the style.  
     */  
    val shorthandEntries: List<ShorthandEntry>,

    /**  
     * Style declaration text (if available).  
     */  
    val cssText: String? = null,

    /**  
     * Style declaration range in the enclosing stylesheet (if available).  
     */  
    val range: SourceRange? = null
)

/**
 * CSS property declaration data.
 *
 * @link [CSS#CSSProperty](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSProperty) type documentation.
 */

data class CSSProperty(
    /**  
     * The property name.  
     */  
    val name: String,

    /**  
     * The property value.  
     */  
    val value: String,

    /**  
     * Whether the property has "!important" annotation (implies `false` if absent).  
     */  
    val important: Boolean? = null,

    /**  
     * Whether the property is implicit (implies `false` if absent).  
     */  
    val implicit: Boolean? = null,

    /**  
     * The full property text as specified in the style.  
     */  
    val text: String? = null,

    /**  
     * Whether the property is understood by the browser (implies `true` if absent).  
     */  
    val parsedOk: Boolean? = null,

    /**  
     * Whether the property is disabled by the user (present for source-based properties only).  
     */  
    val disabled: Boolean? = null,

    /**  
     * The entire property range in the enclosing style declaration (if available).  
     */  
    val range: SourceRange? = null
)

/**
 * CSS media rule descriptor.
 *
 * @link [CSS#CSSMedia](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSMedia) type documentation.
 */

data class CSSMedia(
    /**  
     * Media query text.  
     */  
    val text: String,

    /**  
     * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if  
     specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked  
     stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline  
     stylesheet's STYLE tag.  
     */  
    val source: String,

    /**  
     * URL of the document containing the media query description.  
     */  
    val sourceURL: String? = null,

    /**  
     * The associated rule (@media or @import) header range in the enclosing stylesheet (if  
     available).  
     */  
    val range: SourceRange? = null,

    /**  
     * Identifier of the stylesheet containing this object (if exists).  
     */  
    val styleSheetId: StyleSheetId? = null,

    /**  
     * Array of media queries.  
     */  
    val mediaList: List<MediaQuery>? = null
)

/**
 * Media query descriptor.
 *
 * @link [CSS#MediaQuery](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-MediaQuery) type documentation.
 */

data class MediaQuery(
    /**  
     * Array of media query expressions.  
     */  
    val expressions: List<MediaQueryExpression>,

    /**  
     * Whether the media query condition is satisfied.  
     */  
    val active: Boolean
)

/**
 * Media query expression descriptor.
 *
 * @link [CSS#MediaQueryExpression](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-MediaQueryExpression) type documentation.
 */

data class MediaQueryExpression(
    /**  
     * Media query expression value.  
     */  
    val value: Double,

    /**  
     * Media query expression units.  
     */  
    val unit: String,

    /**  
     * Media query expression feature.  
     */  
    val feature: String,

    /**  
     * The associated range of the value text in the enclosing stylesheet (if available).  
     */  
    val valueRange: SourceRange? = null,

    /**  
     * Computed length of media query expression (if applicable).  
     */  
    val computedLength: Double? = null
)

/**
 * Information about amount of glyphs that were rendered with given font.
 *
 * @link [CSS#PlatformFontUsage](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-PlatformFontUsage) type documentation.
 */

data class PlatformFontUsage(
    /**  
     * Font's family name reported by platform.  
     */  
    val familyName: String,

    /**  
     * Indicates if the font was downloaded or resolved locally.  
     */  
    val isCustomFont: Boolean,

    /**  
     * Amount of glyphs that were rendered with this font.  
     */  
    val glyphCount: Double
)

/**
 * Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 *
 * @link [CSS#FontFace](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-FontFace) type documentation.
 */

data class FontFace(
    /**  
     * The font-family.  
     */  
    val fontFamily: String,

    /**  
     * The font-style.  
     */  
    val fontStyle: String,

    /**  
     * The font-variant.  
     */  
    val fontVariant: String,

    /**  
     * The font-weight.  
     */  
    val fontWeight: String,

    /**  
     * The font-stretch.  
     */  
    val fontStretch: String,

    /**  
     * The unicode-range.  
     */  
    val unicodeRange: String,

    /**  
     * The src.  
     */  
    val src: String,

    /**  
     * The resolved platform font family  
     */  
    val platformFontFamily: String
)

/**
 * CSS keyframes rule representation.
 *
 * @link [CSS#CSSKeyframesRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSKeyframesRule) type documentation.
 */

data class CSSKeyframesRule(
    /**  
     * Animation name.  
     */  
    val animationName: Value,

    /**  
     * List of keyframes.  
     */  
    val keyframes: List<CSSKeyframeRule>
)

/**
 * CSS keyframe rule representation.
 *
 * @link [CSS#CSSKeyframeRule](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-CSSKeyframeRule) type documentation.
 */

data class CSSKeyframeRule(
    /**  
     * The css style sheet identifier (absent for user agent stylesheet and user-specified  
     stylesheet rules) this rule came from.  
     */  
    val styleSheetId: StyleSheetId? = null,

    /**  
     * Parent stylesheet's origin.  
     */  
    val origin: StyleSheetOrigin,

    /**  
     * Associated key text.  
     */  
    val keyText: Value,

    /**  
     * Associated style declaration.  
     */  
    val style: CSSStyle
)

/**
 * A descriptor of operation to mutate style declaration text.
 *
 * @link [CSS#StyleDeclarationEdit](https://chromedevtools.github.io/devtools-protocol/tot/CSS#type-StyleDeclarationEdit) type documentation.
 */

data class StyleDeclarationEdit(
    /**  
     * The css style sheet identifier.  
     */  
    val styleSheetId: StyleSheetId,

    /**  
     * The range of the style text in the enclosing stylesheet.  
     */  
    val range: SourceRange,

    /**  
     * New style text.  
     */  
    val text: String
)
