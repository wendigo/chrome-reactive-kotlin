package pl.wendigo.chrome.domain.domsnapshot

/**
 * A Node in the DOM tree.
 */

data class DOMNode(
    /**  
     * `Node`'s nodeType.  
     */  
    val nodeType: Int,

    /**  
     * `Node`'s nodeName.  
     */  
    val nodeName: String,

    /**  
     * `Node`'s nodeValue.  
     */  
    val nodeValue: String,

    /**  
     * Only set for textarea elements, contains the text value.  
     */  
    val textValue: String? = null,

    /**  
     * Only set for input elements, contains the input's associated text value.  
     */  
    val inputValue: String? = null,

    /**  
     * Only set for radio and checkbox input elements, indicates if the element has been checked  
     */  
    val inputChecked: Boolean? = null,

    /**  
     * Only set for option elements, indicates if the element has been selected  
     */  
    val optionSelected: Boolean? = null,

    /**  
     * `Node`'s id, corresponds to DOM.Node.backendNodeId.  
     */  
    val backendNodeId: pl.wendigo.chrome.domain.dom.BackendNodeId,

    /**  
     * The indexes of the node's child nodes in the `domNodes` array returned by `getSnapshot`, if  
     any.  
     */  
    val childNodeIndexes: List<Int>? = null,

    /**  
     * Attributes of an `Element` node.  
     */  
    val attributes: List<NameValue>? = null,

    /**  
     * Indexes of pseudo elements associated with this node in the `domNodes` array returned by  
     `getSnapshot`, if any.  
     */  
    val pseudoElementIndexes: List<Int>? = null,

    /**  
     * The index of the node's related layout tree node in the `layoutTreeNodes` array returned by  
     `getSnapshot`, if any.  
     */  
    val layoutNodeIndex: Int? = null,

    /**  
     * Document URL that `Document` or `FrameOwner` node points to.  
     */  
    val documentURL: String? = null,

    /**  
     * Base URL that `Document` or `FrameOwner` node uses for URL completion.  
     */  
    val baseURL: String? = null,

    /**  
     * Only set for documents, contains the document's content language.  
     */  
    val contentLanguage: String? = null,

    /**  
     * Only set for documents, contains the document's character set encoding.  
     */  
    val documentEncoding: String? = null,

    /**  
     * `DocumentType` node's publicId.  
     */  
    val publicId: String? = null,

    /**  
     * `DocumentType` node's systemId.  
     */  
    val systemId: String? = null,

    /**  
     * Frame ID for frame owner elements and also for the document node.  
     */  
    val frameId: pl.wendigo.chrome.domain.page.FrameId? = null,

    /**  
     * The index of a frame owner element's content document in the `domNodes` array returned by  
     `getSnapshot`, if any.  
     */  
    val contentDocumentIndex: Int? = null,

    /**  
     * Type of a pseudo element node.  
     */  
    val pseudoType: pl.wendigo.chrome.domain.dom.PseudoType? = null,

    /**  
     * Shadow root type.  
     */  
    val shadowRootType: pl.wendigo.chrome.domain.dom.ShadowRootType? = null,

    /**  
     * Whether this DOM node responds to mouse clicks. This includes nodes that have had click  
     event listeners attached via JavaScript as well as anchor tags that naturally navigate when  
     clicked.  
     */  
    val isClickable: Boolean? = null,

    /**  
     * Details of the node's event listeners, if any.  
     */  
    val eventListeners: List<pl.wendigo.chrome.domain.domdebugger.EventListener>? = null,

    /**  
     * The selected url for nodes with a srcset attribute.  
     */  
    val currentSourceURL: String? = null,

    /**  
     * The url of the script (if any) that generates this node.  
     */  
    val originURL: String? = null,

    /**  
     * Scroll offsets, set when this node is a Document.  
     */  
    val scrollOffsetX: Double? = null,

    /**  
     *  
     */  
    val scrollOffsetY: Double? = null
)

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
stable and may change between versions.
 */

data class InlineTextBox(
    /**  
     * The bounding box in document coordinates. Note that scroll offset of the document is ignored.  
     */  
    val boundingBox: pl.wendigo.chrome.domain.dom.Rect,

    /**  
     * The starting index in characters, for this post layout textbox substring. Characters that  
     would be represented as a surrogate pair in UTF-16 have length 2.  
     */  
    val startCharacterIndex: Int,

    /**  
     * The number of characters in this post layout textbox substring. Characters that would be  
     represented as a surrogate pair in UTF-16 have length 2.  
     */  
    val numCharacters: Int
)

/**
 * Details of an element in the DOM tree with a LayoutObject.
 */

data class LayoutTreeNode(
    /**  
     * The index of the related DOM node in the `domNodes` array returned by `getSnapshot`.  
     */  
    val domNodeIndex: Int,

    /**  
     * The bounding box in document coordinates. Note that scroll offset of the document is ignored.  
     */  
    val boundingBox: pl.wendigo.chrome.domain.dom.Rect,

    /**  
     * Contents of the LayoutText, if any.  
     */  
    val layoutText: String? = null,

    /**  
     * The post-layout inline text nodes, if any.  
     */  
    val inlineTextNodes: List<InlineTextBox>? = null,

    /**  
     * Index into the `computedStyles` array returned by `getSnapshot`.  
     */  
    val styleIndex: Int? = null,

    /**  
     * Global paint order index, which is determined by the stacking order of the nodes. Nodes  
     that are painted together will have the same index. Only provided if includePaintOrder in  
     getSnapshot was true.  
     */  
    val paintOrder: Int? = null,

    /**  
     * Set to true to indicate the element begins a new stacking context.  
     */  
    val isStackingContext: Boolean? = null
)

/**
 * A subset of the full ComputedStyle as defined by the request whitelist.
 */

data class ComputedStyle(
    /**  
     * Name/value pairs of computed style properties.  
     */  
    val properties: List<NameValue>
)

/**
 * A name/value pair.
 */

data class NameValue(
    /**  
     * Attribute/property name.  
     */  
    val name: String,

    /**  
     * Attribute/property value.  
     */  
    val value: String
)

/**
 * Index of the string in the strings table.
 */

typealias StringIndex = Int

/**
 * Index of the string in the strings table.
 */

typealias ArrayOfStrings = List<StringIndex>

/**
 * Data that is only present on rare nodes.
 */

data class RareStringData(
    /**  
     *  
     */  
    val index: List<Int>,

    /**  
     *  
     */  
    val value: List<StringIndex>
)

/**
 *
 */

data class RareBooleanData(
    /**  
     *  
     */  
    val index: List<Int>
)

/**
 *
 */

data class RareIntegerData(
    /**  
     *  
     */  
    val index: List<Int>,

    /**  
     *  
     */  
    val value: List<Int>
)

/**
 *
 */

typealias Rectangle = List<Double>

/**
 * Document snapshot.
 */

data class DocumentSnapshot(
    /**  
     * Document URL that `Document` or `FrameOwner` node points to.  
     */  
    val documentURL: StringIndex,

    /**  
     * Base URL that `Document` or `FrameOwner` node uses for URL completion.  
     */  
    val baseURL: StringIndex,

    /**  
     * Contains the document's content language.  
     */  
    val contentLanguage: StringIndex,

    /**  
     * Contains the document's character set encoding.  
     */  
    val encodingName: StringIndex,

    /**  
     * `DocumentType` node's publicId.  
     */  
    val publicId: StringIndex,

    /**  
     * `DocumentType` node's systemId.  
     */  
    val systemId: StringIndex,

    /**  
     * Frame ID for frame owner elements and also for the document node.  
     */  
    val frameId: StringIndex,

    /**  
     * A table with dom nodes.  
     */  
    val nodes: NodeTreeSnapshot,

    /**  
     * The nodes in the layout tree.  
     */  
    val layout: LayoutTreeSnapshot,

    /**  
     * The post-layout inline text nodes.  
     */  
    val textBoxes: TextBoxSnapshot,

    /**  
     * Horizontal scroll offset.  
     */  
    val scrollOffsetX: Double? = null,

    /**  
     * Vertical scroll offset.  
     */  
    val scrollOffsetY: Double? = null
)

/**
 * Table containing nodes.
 */

data class NodeTreeSnapshot(
    /**  
     * Parent node index.  
     */  
    val parentIndex: List<Int>? = null,

    /**  
     * `Node`'s nodeType.  
     */  
    val nodeType: List<Int>? = null,

    /**  
     * `Node`'s nodeName.  
     */  
    val nodeName: List<StringIndex>? = null,

    /**  
     * `Node`'s nodeValue.  
     */  
    val nodeValue: List<StringIndex>? = null,

    /**  
     * `Node`'s id, corresponds to DOM.Node.backendNodeId.  
     */  
    val backendNodeId: List<pl.wendigo.chrome.domain.dom.BackendNodeId>? = null,

    /**  
     * Attributes of an `Element` node. Flatten name, value pairs.  
     */  
    val attributes: List<ArrayOfStrings>? = null,

    /**  
     * Only set for textarea elements, contains the text value.  
     */  
    val textValue: RareStringData? = null,

    /**  
     * Only set for input elements, contains the input's associated text value.  
     */  
    val inputValue: RareStringData? = null,

    /**  
     * Only set for radio and checkbox input elements, indicates if the element has been checked  
     */  
    val inputChecked: RareBooleanData? = null,

    /**  
     * Only set for option elements, indicates if the element has been selected  
     */  
    val optionSelected: RareBooleanData? = null,

    /**  
     * The index of the document in the list of the snapshot documents.  
     */  
    val contentDocumentIndex: RareIntegerData? = null,

    /**  
     * Type of a pseudo element node.  
     */  
    val pseudoType: RareStringData? = null,

    /**  
     * Whether this DOM node responds to mouse clicks. This includes nodes that have had click  
     event listeners attached via JavaScript as well as anchor tags that naturally navigate when  
     clicked.  
     */  
    val isClickable: RareBooleanData? = null,

    /**  
     * The selected url for nodes with a srcset attribute.  
     */  
    val currentSourceURL: RareStringData? = null,

    /**  
     * The url of the script (if any) that generates this node.  
     */  
    val originURL: RareStringData? = null
)

/**
 * Table of details of an element in the DOM tree with a LayoutObject.
 */

data class LayoutTreeSnapshot(
    /**  
     * Index of the corresponding node in the `NodeTreeSnapshot` array returned by `captureSnapshot`.  
     */  
    val nodeIndex: List<Int>,

    /**  
     * Array of indexes specifying computed style strings, filtered according to the `computedStyles` parameter passed to `captureSnapshot`.  
     */  
    val styles: List<ArrayOfStrings>,

    /**  
     * The absolute position bounding box.  
     */  
    val bounds: List<Rectangle>,

    /**  
     * Contents of the LayoutText, if any.  
     */  
    val text: List<StringIndex>,

    /**  
     * Stacking context information.  
     */  
    val stackingContexts: RareBooleanData,

    /**  
     * Global paint order index, which is determined by the stacking order of the nodes. Nodes  
     that are painted together will have the same index. Only provided if includePaintOrder in  
     captureSnapshot was true.  
     */  
    val paintOrders: List<Int>? = null,

    /**  
     * The offset rect of nodes. Only available when includeDOMRects is set to true  
     */  
    val offsetRects: List<Rectangle>? = null,

    /**  
     * The scroll rect of nodes. Only available when includeDOMRects is set to true  
     */  
    val scrollRects: List<Rectangle>? = null,

    /**  
     * The client rect of nodes. Only available when includeDOMRects is set to true  
     */  
    val clientRects: List<Rectangle>? = null
)

/**
 * Table of details of the post layout rendered text positions. The exact layout should not be regarded as
stable and may change between versions.
 */

data class TextBoxSnapshot(
    /**  
     * Index of the layout tree node that owns this box collection.  
     */  
    val layoutIndex: List<Int>,

    /**  
     * The absolute position bounding box.  
     */  
    val bounds: List<Rectangle>,

    /**  
     * The starting index in characters, for this post layout textbox substring. Characters that  
     would be represented as a surrogate pair in UTF-16 have length 2.  
     */  
    val start: List<Int>,

    /**  
     * The number of characters in this post layout textbox substring. Characters that would be  
     represented as a surrogate pair in UTF-16 have length 2.  
     */  
    val length: List<Int>
)
