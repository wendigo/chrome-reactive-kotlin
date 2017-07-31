package pl.wendigo.chrome.domain.domsnapshot

/**
 * A Node in the DOM tree.
 */

data class DOMNode(
  /**
   * <code>Node</code>'s nodeType.
   */
  val nodeType : Int,

  /**
   * <code>Node</code>'s nodeName.
   */
  val nodeName : String,

  /**
   * <code>Node</code>'s nodeValue.
   */
  val nodeValue : String,

  /**
   * Only set for textarea elements, contains the text value.
   */
  val textValue : String? = null,

  /**
   * Only set for input elements, contains the input's associated text value.
   */
  val inputValue : String? = null,

  /**
   * Only set for radio and checkbox input elements, indicates if the element has been checked
   */
  val inputChecked : Boolean? = null,

  /**
   * Only set for option elements, indicates if the element has been selected
   */
  val optionSelected : Boolean? = null,

  /**
   * <code>Node</code>'s id, corresponds to DOM.Node.backendNodeId.
   */
  val backendNodeId : pl.wendigo.chrome.domain.dom.BackendNodeId,

  /**
   * The indexes of the node's child nodes in the <code>domNodes</code> array returned by <code>getSnapshot</code>, if any.
   */
  val childNodeIndexes : List<Int>? = null,

  /**
   * Attributes of an <code>Element</code> node.
   */
  val attributes : List<NameValue>? = null,

  /**
   * Indexes of pseudo elements associated with this node in the <code>domNodes</code> array returned by <code>getSnapshot</code>, if any.
   */
  val pseudoElementIndexes : List<Int>? = null,

  /**
   * The index of the node's related layout tree node in the <code>layoutTreeNodes</code> array returned by <code>getSnapshot</code>, if any.
   */
  val layoutNodeIndex : Int? = null,

  /**
   * Document URL that <code>Document</code> or <code>FrameOwner</code> node points to.
   */
  val documentURL : String? = null,

  /**
   * Base URL that <code>Document</code> or <code>FrameOwner</code> node uses for URL completion.
   */
  val baseURL : String? = null,

  /**
   * Only set for documents, contains the document's content language.
   */
  val contentLanguage : String? = null,

  /**
   * Only set for documents, contains the document's character set encoding.
   */
  val documentEncoding : String? = null,

  /**
   * <code>DocumentType</code> node's publicId.
   */
  val publicId : String? = null,

  /**
   * <code>DocumentType</code> node's systemId.
   */
  val systemId : String? = null,

  /**
   * Frame ID for frame owner elements.
   */
  val frameId : pl.wendigo.chrome.domain.page.FrameId? = null,

  /**
   * The index of a frame owner element's content document in the <code>domNodes</code> array returned by <code>getSnapshot</code>, if any.
   */
  val contentDocumentIndex : Int? = null,

  /**
   * Index of the imported document's node of a link element in the <code>domNodes</code> array returned by <code>getSnapshot</code>, if any.
   */
  val importedDocumentIndex : Int? = null,

  /**
   * Index of the content node of a template element in the <code>domNodes</code> array returned by <code>getSnapshot</code>.
   */
  val templateContentIndex : Int? = null,

  /**
   * Type of a pseudo element node.
   */
  val pseudoType : pl.wendigo.chrome.domain.dom.PseudoType? = null,

  /**
   * Whether this DOM node responds to mouse clicks. This includes nodes that have had click event listeners attached via JavaScript as well as anchor tags that naturally navigate when clicked.
   */
  val isClickable : Boolean? = null
)

/**
 * Details of an element in the DOM tree with a LayoutObject.
 */

data class LayoutTreeNode(
  /**
   * The index of the related DOM node in the <code>domNodes</code> array returned by <code>getSnapshot</code>.
   */
  val domNodeIndex : Int,

  /**
   * The absolute position bounding box.
   */
  val boundingBox : pl.wendigo.chrome.domain.dom.Rect,

  /**
   * Contents of the LayoutText, if any.
   */
  val layoutText : String? = null,

  /**
   * The post-layout inline text nodes, if any.
   */
  val inlineTextNodes : List<pl.wendigo.chrome.domain.css.InlineTextBox>? = null,

  /**
   * Index into the <code>computedStyles</code> array returned by <code>getSnapshot</code>.
   */
  val styleIndex : Int? = null
)

/**
 * A subset of the full ComputedStyle as defined by the request whitelist.
 */

data class ComputedStyle(
  /**
   * Name/value pairs of computed style properties.
   */
  val properties : List<NameValue>
)

/**
 * A name/value pair.
 */

data class NameValue(
  /**
   * Attribute/property name.
   */
  val name : String,

  /**
   * Attribute/property value.
   */
  val value : String
)

