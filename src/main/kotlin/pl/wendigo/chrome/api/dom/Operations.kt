package pl.wendigo.chrome.api.dom

/**
 * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object
that has an `id`. This `id` can be used to get additional information on the Node, resolve it into
the JavaScript object wrapper, etc. It is important that client receives DOM events only for the
nodes that are known to the client. Backend keeps track of the nodes that were sent to the client
and never sends the same node twice. It is client's responsibility to collect information about
the nodes that were sent to the client.<p>Note that `iframe` owner elements will return
corresponding document elements as their child nodes.</p>
 *
 * @link Protocol [DOM](https://chromedevtools.github.io/devtools-protocol/tot/DOM) domain documentation.
 */
class DOMOperations internal constructor(private val connection: pl.wendigo.chrome.protocol.ChromeDebuggerConnection) {
    /**
     * Collects class names for the node with given id and all of it's child nodes.
     *
     * @link Protocol [DOM#collectClassNamesFromSubtree](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-collectClassNamesFromSubtree) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun collectClassNamesFromSubtree(input: CollectClassNamesFromSubtreeRequest): io.reactivex.Single<CollectClassNamesFromSubtreeResponse> {
        return connection.runAndCaptureResponse("DOM.collectClassNamesFromSubtree", input, CollectClassNamesFromSubtreeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Creates a deep copy of the specified node and places it into the target container before the
given anchor.
     *
     * @link Protocol [DOM#copyTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-copyTo) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun copyTo(input: CopyToRequest): io.reactivex.Single<CopyToResponse> {
        return connection.runAndCaptureResponse("DOM.copyTo", input, CopyToResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Describes node given its id, does not require domain to be enabled. Does not start tracking any
objects, can be used for automation.
     *
     * @link Protocol [DOM#describeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-describeNode) method documentation.
     */
    fun describeNode(input: DescribeNodeRequest): io.reactivex.Single<DescribeNodeResponse> {
        return connection.runAndCaptureResponse("DOM.describeNode", input, DescribeNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Disables DOM agent for the given page.
     *
     * @link Protocol [DOM#disable](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-disable) method documentation.
     */
    fun disable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.disable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Discards search results from the session with the given id. `getSearchResults` should no longer
be called for that search.
     *
     * @link Protocol [DOM#discardSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-discardSearchResults) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun discardSearchResults(input: DiscardSearchResultsRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.discardSearchResults", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Enables DOM agent for the given page.
     *
     * @link Protocol [DOM#enable](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-enable) method documentation.
     */
    fun enable(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.enable", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Focuses the given element.
     *
     * @link Protocol [DOM#focus](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-focus) method documentation.
     */
    fun focus(input: FocusRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.focus", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns attributes for the specified node.
     *
     * @link Protocol [DOM#getAttributes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getAttributes) method documentation.
     */
    fun getAttributes(input: GetAttributesRequest): io.reactivex.Single<GetAttributesResponse> {
        return connection.runAndCaptureResponse("DOM.getAttributes", input, GetAttributesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns boxes for the given node.
     *
     * @link Protocol [DOM#getBoxModel](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getBoxModel) method documentation.
     */
    fun getBoxModel(input: GetBoxModelRequest): io.reactivex.Single<GetBoxModelResponse> {
        return connection.runAndCaptureResponse("DOM.getBoxModel", input, GetBoxModelResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns quads that describe node position on the page. This method
might return multiple quads for inline nodes.
     *
     * @link Protocol [DOM#getContentQuads](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getContentQuads) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getContentQuads(input: GetContentQuadsRequest): io.reactivex.Single<GetContentQuadsResponse> {
        return connection.runAndCaptureResponse("DOM.getContentQuads", input, GetContentQuadsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the root DOM node (and optionally the subtree) to the caller.
     *
     * @link Protocol [DOM#getDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getDocument) method documentation.
     */
    fun getDocument(input: GetDocumentRequest): io.reactivex.Single<GetDocumentResponse> {
        return connection.runAndCaptureResponse("DOM.getDocument", input, GetDocumentResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the root DOM node (and optionally the subtree) to the caller.
     *
     * @link Protocol [DOM#getFlattenedDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFlattenedDocument) method documentation.
     */
    fun getFlattenedDocument(input: GetFlattenedDocumentRequest): io.reactivex.Single<GetFlattenedDocumentResponse> {
        return connection.runAndCaptureResponse("DOM.getFlattenedDocument", input, GetFlattenedDocumentResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is
either returned or not.
     *
     * @link Protocol [DOM#getNodeForLocation](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeForLocation) method documentation.
     */
    fun getNodeForLocation(input: GetNodeForLocationRequest): io.reactivex.Single<GetNodeForLocationResponse> {
        return connection.runAndCaptureResponse("DOM.getNodeForLocation", input, GetNodeForLocationResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns node's HTML markup.
     *
     * @link Protocol [DOM#getOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getOuterHTML) method documentation.
     */
    fun getOuterHTML(input: GetOuterHTMLRequest): io.reactivex.Single<GetOuterHTMLResponse> {
        return connection.runAndCaptureResponse("DOM.getOuterHTML", input, GetOuterHTMLResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns the id of the nearest ancestor that is a relayout boundary.
     *
     * @link Protocol [DOM#getRelayoutBoundary](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getRelayoutBoundary) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getRelayoutBoundary(input: GetRelayoutBoundaryRequest): io.reactivex.Single<GetRelayoutBoundaryResponse> {
        return connection.runAndCaptureResponse("DOM.getRelayoutBoundary", input, GetRelayoutBoundaryResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns search results from given `fromIndex` to given `toIndex` from the search with the given
identifier.
     *
     * @link Protocol [DOM#getSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getSearchResults) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getSearchResults(input: GetSearchResultsRequest): io.reactivex.Single<GetSearchResultsResponse> {
        return connection.runAndCaptureResponse("DOM.getSearchResults", input, GetSearchResultsResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Hides any highlight.
     *
     * @link Protocol [DOM#hideHighlight](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-hideHighlight) method documentation.
     */
    fun hideHighlight(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.hideHighlight", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights DOM node.
     *
     * @link Protocol [DOM#highlightNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-highlightNode) method documentation.
     */
    fun highlightNode(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.highlightNode", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Highlights given rectangle.
     *
     * @link Protocol [DOM#highlightRect](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-highlightRect) method documentation.
     */
    fun highlightRect(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.highlightRect", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Marks last undoable state.
     *
     * @link Protocol [DOM#markUndoableState](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-markUndoableState) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun markUndoableState(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.markUndoableState", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Moves node into the new container, places it before the given anchor.
     *
     * @link Protocol [DOM#moveTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-moveTo) method documentation.
     */
    fun moveTo(input: MoveToRequest): io.reactivex.Single<MoveToResponse> {
        return connection.runAndCaptureResponse("DOM.moveTo", input, MoveToResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or
`cancelSearch` to end this search session.
     *
     * @link Protocol [DOM#performSearch](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-performSearch) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun performSearch(input: PerformSearchRequest): io.reactivex.Single<PerformSearchResponse> {
        return connection.runAndCaptureResponse("DOM.performSearch", input, PerformSearchResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that the node is sent to the caller given its path. // FIXME, use XPath
     *
     * @link Protocol [DOM#pushNodeByPathToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodeByPathToFrontend) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun pushNodeByPathToFrontend(input: PushNodeByPathToFrontendRequest): io.reactivex.Single<PushNodeByPathToFrontendResponse> {
        return connection.runAndCaptureResponse("DOM.pushNodeByPathToFrontend", input, PushNodeByPathToFrontendResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that a batch of nodes is sent to the caller given their backend node ids.
     *
     * @link Protocol [DOM#pushNodesByBackendIdsToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodesByBackendIdsToFrontend) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun pushNodesByBackendIdsToFrontend(input: PushNodesByBackendIdsToFrontendRequest): io.reactivex.Single<PushNodesByBackendIdsToFrontendResponse> {
        return connection.runAndCaptureResponse("DOM.pushNodesByBackendIdsToFrontend", input, PushNodesByBackendIdsToFrontendResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Executes `querySelector` on a given node.
     *
     * @link Protocol [DOM#querySelector](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelector) method documentation.
     */
    fun querySelector(input: QuerySelectorRequest): io.reactivex.Single<QuerySelectorResponse> {
        return connection.runAndCaptureResponse("DOM.querySelector", input, QuerySelectorResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Executes `querySelectorAll` on a given node.
     *
     * @link Protocol [DOM#querySelectorAll](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelectorAll) method documentation.
     */
    fun querySelectorAll(input: QuerySelectorAllRequest): io.reactivex.Single<QuerySelectorAllResponse> {
        return connection.runAndCaptureResponse("DOM.querySelectorAll", input, QuerySelectorAllResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Re-does the last undone action.
     *
     * @link Protocol [DOM#redo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-redo) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun redo(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.redo", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes attribute with given name from an element with given id.
     *
     * @link Protocol [DOM#removeAttribute](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-removeAttribute) method documentation.
     */
    fun removeAttribute(input: RemoveAttributeRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.removeAttribute", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Removes node with given id.
     *
     * @link Protocol [DOM#removeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-removeNode) method documentation.
     */
    fun removeNode(input: RemoveNodeRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.removeNode", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that children of the node with given id are returned to the caller in form of
`setChildNodes` events where not only immediate children are retrieved, but all children down to
the specified depth.
     *
     * @link Protocol [DOM#requestChildNodes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestChildNodes) method documentation.
     */
    fun requestChildNodes(input: RequestChildNodesRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.requestChildNodes", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Requests that the node is sent to the caller given the JavaScript node object reference. All
nodes that form the path from the node to the root are also sent to the client as a series of
`setChildNodes` notifications.
     *
     * @link Protocol [DOM#requestNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestNode) method documentation.
     */
    fun requestNode(input: RequestNodeRequest): io.reactivex.Single<RequestNodeResponse> {
        return connection.runAndCaptureResponse("DOM.requestNode", input, RequestNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
     *
     * @link Protocol [DOM#resolveNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-resolveNode) method documentation.
     */
    fun resolveNode(input: ResolveNodeRequest): io.reactivex.Single<ResolveNodeResponse> {
        return connection.runAndCaptureResponse("DOM.resolveNode", input, ResolveNodeResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sets attribute for an element with given id.
     *
     * @link Protocol [DOM#setAttributeValue](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setAttributeValue) method documentation.
     */
    fun setAttributeValue(input: SetAttributeValueRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setAttributeValue", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets attributes on element with given id. This method is useful when user edits some existing
attribute value and types in several attribute name/value pairs.
     *
     * @link Protocol [DOM#setAttributesAsText](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setAttributesAsText) method documentation.
     */
    fun setAttributesAsText(input: SetAttributesAsTextRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setAttributesAsText", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets files for the given file input element.
     *
     * @link Protocol [DOM#setFileInputFiles](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setFileInputFiles) method documentation.
     */
    fun setFileInputFiles(input: SetFileInputFilesRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setFileInputFiles", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets if stack traces should be captured for Nodes. See `Node.getNodeStackTraces`. Default is disabled.
     *
     * @link Protocol [DOM#setNodeStackTracesEnabled](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeStackTracesEnabled) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setNodeStackTracesEnabled(input: SetNodeStackTracesEnabledRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setNodeStackTracesEnabled", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
     *
     * @link Protocol [DOM#getNodeStackTraces](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeStackTraces) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getNodeStackTraces(input: GetNodeStackTracesRequest): io.reactivex.Single<GetNodeStackTracesResponse> {
        return connection.runAndCaptureResponse("DOM.getNodeStackTraces", input, GetNodeStackTracesResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Returns file information for the given
File wrapper.
     *
     * @link Protocol [DOM#getFileInfo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFileInfo) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getFileInfo(input: GetFileInfoRequest): io.reactivex.Single<GetFileInfoResponse> {
        return connection.runAndCaptureResponse("DOM.getFileInfo", input, GetFileInfoResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Enables console to refer to the node with given id via $x (see Command Line API for more details
$x functions).
     *
     * @link Protocol [DOM#setInspectedNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setInspectedNode) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun setInspectedNode(input: SetInspectedNodeRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setInspectedNode", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets node name for a node with given id.
     *
     * @link Protocol [DOM#setNodeName](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeName) method documentation.
     */
    fun setNodeName(input: SetNodeNameRequest): io.reactivex.Single<SetNodeNameResponse> {
        return connection.runAndCaptureResponse("DOM.setNodeName", input, SetNodeNameResponse::class.java).map {
            it.value()
        }
    }

    /**
     * Sets node value for a node with given id.
     *
     * @link Protocol [DOM#setNodeValue](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeValue) method documentation.
     */
    fun setNodeValue(input: SetNodeValueRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setNodeValue", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Sets node HTML markup, returns new node id.
     *
     * @link Protocol [DOM#setOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setOuterHTML) method documentation.
     */
    fun setOuterHTML(input: SetOuterHTMLRequest): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.setOuterHTML", input, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Undoes the last performed action.
     *
     * @link Protocol [DOM#undo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-undo) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun undo(): io.reactivex.Single<pl.wendigo.chrome.protocol.ResponseFrame> {
        return connection.runAndCaptureResponse("DOM.undo", null, pl.wendigo.chrome.protocol.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns iframe node that owns iframe with the given domain.
     *
     * @link Protocol [DOM#getFrameOwner](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFrameOwner) method documentation.
     */
    
    @pl.wendigo.chrome.protocol.Experimental
    fun getFrameOwner(input: GetFrameOwnerRequest): io.reactivex.Single<GetFrameOwnerResponse> {
        return connection.runAndCaptureResponse("DOM.getFrameOwner", input, GetFrameOwnerResponse::class.java).map {
            it.value()
        }
    }

    /**
     *  Fired when `Element`'s attribute is modified.
     */
    fun attributeModified(): io.reactivex.Flowable<AttributeModifiedEvent> {
        return attributeModifiedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when `Element`'s attribute is modified.
     */
    fun attributeModifiedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AttributeModifiedEvent>> {
        return connection.captureEvents("DOM.attributeModified", AttributeModifiedEvent::class.java)
    }

    /**
     *  Fired when `Element`'s attribute is removed.
     */
    fun attributeRemoved(): io.reactivex.Flowable<AttributeRemovedEvent> {
        return attributeRemovedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when `Element`'s attribute is removed.
     */
    fun attributeRemovedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<AttributeRemovedEvent>> {
        return connection.captureEvents("DOM.attributeRemoved", AttributeRemovedEvent::class.java)
    }

    /**
     *  Mirrors `DOMCharacterDataModified` event.
     */
    fun characterDataModified(): io.reactivex.Flowable<CharacterDataModifiedEvent> {
        return characterDataModifiedTimed().map {
            it.value()
        }
    }

    /**
     * Mirrors `DOMCharacterDataModified` event.
     */
    fun characterDataModifiedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<CharacterDataModifiedEvent>> {
        return connection.captureEvents("DOM.characterDataModified", CharacterDataModifiedEvent::class.java)
    }

    /**
     *  Fired when `Container`'s child node count has changed.
     */
    fun childNodeCountUpdated(): io.reactivex.Flowable<ChildNodeCountUpdatedEvent> {
        return childNodeCountUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when `Container`'s child node count has changed.
     */
    fun childNodeCountUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ChildNodeCountUpdatedEvent>> {
        return connection.captureEvents("DOM.childNodeCountUpdated", ChildNodeCountUpdatedEvent::class.java)
    }

    /**
     *  Mirrors `DOMNodeInserted` event.
     */
    fun childNodeInserted(): io.reactivex.Flowable<ChildNodeInsertedEvent> {
        return childNodeInsertedTimed().map {
            it.value()
        }
    }

    /**
     * Mirrors `DOMNodeInserted` event.
     */
    fun childNodeInsertedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ChildNodeInsertedEvent>> {
        return connection.captureEvents("DOM.childNodeInserted", ChildNodeInsertedEvent::class.java)
    }

    /**
     *  Mirrors `DOMNodeRemoved` event.
     */
    fun childNodeRemoved(): io.reactivex.Flowable<ChildNodeRemovedEvent> {
        return childNodeRemovedTimed().map {
            it.value()
        }
    }

    /**
     * Mirrors `DOMNodeRemoved` event.
     */
    fun childNodeRemovedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ChildNodeRemovedEvent>> {
        return connection.captureEvents("DOM.childNodeRemoved", ChildNodeRemovedEvent::class.java)
    }

    /**
     *  Called when distrubution is changed.
     */
    fun distributedNodesUpdated(): io.reactivex.Flowable<DistributedNodesUpdatedEvent> {
        return distributedNodesUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * Called when distrubution is changed.
     */
    fun distributedNodesUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<DistributedNodesUpdatedEvent>> {
        return connection.captureEvents("DOM.distributedNodesUpdated", DistributedNodesUpdatedEvent::class.java)
    }

    /**
     *  Fired when `Document` has been totally updated. Node ids are no longer valid.
     */
    fun documentUpdated(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return documentUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when `Document` has been totally updated. Node ids are no longer valid.
     */
    fun documentUpdatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<pl.wendigo.chrome.protocol.Event>> {
        return connection.captureEvents("DOM.documentUpdated", pl.wendigo.chrome.protocol.Event::class.java)
    }

    /**
     *  Fired when `Element`'s inline style is modified via a CSS property modification.
     */
    fun inlineStyleInvalidated(): io.reactivex.Flowable<InlineStyleInvalidatedEvent> {
        return inlineStyleInvalidatedTimed().map {
            it.value()
        }
    }

    /**
     * Fired when `Element`'s inline style is modified via a CSS property modification.
     */
    fun inlineStyleInvalidatedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<InlineStyleInvalidatedEvent>> {
        return connection.captureEvents("DOM.inlineStyleInvalidated", InlineStyleInvalidatedEvent::class.java)
    }

    /**
     *  Called when a pseudo element is added to an element.
     */
    fun pseudoElementAdded(): io.reactivex.Flowable<PseudoElementAddedEvent> {
        return pseudoElementAddedTimed().map {
            it.value()
        }
    }

    /**
     * Called when a pseudo element is added to an element.
     */
    fun pseudoElementAddedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<PseudoElementAddedEvent>> {
        return connection.captureEvents("DOM.pseudoElementAdded", PseudoElementAddedEvent::class.java)
    }

    /**
     *  Called when a pseudo element is removed from an element.
     */
    fun pseudoElementRemoved(): io.reactivex.Flowable<PseudoElementRemovedEvent> {
        return pseudoElementRemovedTimed().map {
            it.value()
        }
    }

    /**
     * Called when a pseudo element is removed from an element.
     */
    fun pseudoElementRemovedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<PseudoElementRemovedEvent>> {
        return connection.captureEvents("DOM.pseudoElementRemoved", PseudoElementRemovedEvent::class.java)
    }

    /**
     *  Fired when backend wants to provide client with the missing DOM structure. This happens upon
most of the calls requesting node ids.
     */
    fun setChildNodes(): io.reactivex.Flowable<SetChildNodesEvent> {
        return setChildNodesTimed().map {
            it.value()
        }
    }

    /**
     * Fired when backend wants to provide client with the missing DOM structure. This happens upon
most of the calls requesting node ids.
     */
    fun setChildNodesTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<SetChildNodesEvent>> {
        return connection.captureEvents("DOM.setChildNodes", SetChildNodesEvent::class.java)
    }

    /**
     *  Called when shadow root is popped from the element.
     */
    fun shadowRootPopped(): io.reactivex.Flowable<ShadowRootPoppedEvent> {
        return shadowRootPoppedTimed().map {
            it.value()
        }
    }

    /**
     * Called when shadow root is popped from the element.
     */
    fun shadowRootPoppedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ShadowRootPoppedEvent>> {
        return connection.captureEvents("DOM.shadowRootPopped", ShadowRootPoppedEvent::class.java)
    }

    /**
     *  Called when shadow root is pushed into the element.
     */
    fun shadowRootPushed(): io.reactivex.Flowable<ShadowRootPushedEvent> {
        return shadowRootPushedTimed().map {
            it.value()
        }
    }

    /**
     * Called when shadow root is pushed into the element.
     */
    fun shadowRootPushedTimed(): io.reactivex.Flowable<io.reactivex.schedulers.Timed<ShadowRootPushedEvent>> {
        return connection.captureEvents("DOM.shadowRootPushed", ShadowRootPushedEvent::class.java)
    }

    /**
     * Returns flowable capturing all DOM domains events.
     */
    fun events(): io.reactivex.Flowable<pl.wendigo.chrome.protocol.Event> {
        return connection.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "DOM"
        }
    }
}
/**
 * Represents request frame that can be used with [DOM#collectClassNamesFromSubtree](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-collectClassNamesFromSubtree) operation call.
 *
 * Collects class names for the node with given id and all of it's child nodes.
 * @link [DOM#collectClassNamesFromSubtree](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-collectClassNamesFromSubtree) method documentation.
 * @see [DOMOperations.collectClassNamesFromSubtree]
 */
data class CollectClassNamesFromSubtreeRequest(
    /**
     * Id of the node to collect class names.
     */
    val nodeId: NodeId

)
/**
 * Represents response frame that is returned from [DOM#collectClassNamesFromSubtree](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-collectClassNamesFromSubtree) operation call.
 * Collects class names for the node with given id and all of it's child nodes.
 *
  
 * @link [DOM#collectClassNamesFromSubtree](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-collectClassNamesFromSubtree) method documentation.
 * @see [DOMOperations.collectClassNamesFromSubtree]
 */
data class CollectClassNamesFromSubtreeResponse(
    /**  
     * Class name list.  
     */  
    val classNames: List<String>

)

/**
 * Represents request frame that can be used with [DOM#copyTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-copyTo) operation call.
 *
 * Creates a deep copy of the specified node and places it into the target container before the
given anchor.
 * @link [DOM#copyTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-copyTo) method documentation.
 * @see [DOMOperations.copyTo]
 */
data class CopyToRequest(
    /**
     * Id of the node to copy.
     */
    val nodeId: NodeId,

    /**
     * Id of the element to drop the copy into.
     */
    val targetNodeId: NodeId,

    /**
     * Drop the copy before this node (if absent, the copy becomes the last child of
`targetNodeId`).
     */
    val insertBeforeNodeId: NodeId? = null

)
/**
 * Represents response frame that is returned from [DOM#copyTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-copyTo) operation call.
 * Creates a deep copy of the specified node and places it into the target container before the
given anchor.
 *
  
 * @link [DOM#copyTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-copyTo) method documentation.
 * @see [DOMOperations.copyTo]
 */
data class CopyToResponse(
    /**  
     * Id of the node clone.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#describeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-describeNode) operation call.
 *
 * Describes node given its id, does not require domain to be enabled. Does not start tracking any
objects, can be used for automation.
 * @link [DOM#describeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-describeNode) method documentation.
 * @see [DOMOperations.describeNode]
 */
data class DescribeNodeRequest(
    /**
     * Identifier of the node.
     */
    val nodeId: NodeId? = null,

    /**
     * Identifier of the backend node.
     */
    val backendNodeId: BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null,

    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
entire subtree or provide an integer larger than 0.
     */
    val depth: Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
(default is false).
     */
    val pierce: Boolean? = null

)
/**
 * Represents response frame that is returned from [DOM#describeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-describeNode) operation call.
 * Describes node given its id, does not require domain to be enabled. Does not start tracking any
objects, can be used for automation.
 *
  
 * @link [DOM#describeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-describeNode) method documentation.
 * @see [DOMOperations.describeNode]
 */
data class DescribeNodeResponse(
    /**  
     * Node description.  
     */  
    val node: Node

)

/**
 * Represents request frame that can be used with [DOM#discardSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-discardSearchResults) operation call.
 *
 * Discards search results from the session with the given id. `getSearchResults` should no longer
be called for that search.
 * @link [DOM#discardSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-discardSearchResults) method documentation.
 * @see [DOMOperations.discardSearchResults]
 */
data class DiscardSearchResultsRequest(
    /**
     * Unique search session identifier.
     */
    val searchId: String

)

/**
 * Represents request frame that can be used with [DOM#focus](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-focus) operation call.
 *
 * Focuses the given element.
 * @link [DOM#focus](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-focus) method documentation.
 * @see [DOMOperations.focus]
 */
data class FocusRequest(
    /**
     * Identifier of the node.
     */
    val nodeId: NodeId? = null,

    /**
     * Identifier of the backend node.
     */
    val backendNodeId: BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null

)

/**
 * Represents request frame that can be used with [DOM#getAttributes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getAttributes) operation call.
 *
 * Returns attributes for the specified node.
 * @link [DOM#getAttributes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getAttributes) method documentation.
 * @see [DOMOperations.getAttributes]
 */
data class GetAttributesRequest(
    /**
     * Id of the node to retrieve attibutes for.
     */
    val nodeId: NodeId

)
/**
 * Represents response frame that is returned from [DOM#getAttributes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getAttributes) operation call.
 * Returns attributes for the specified node.
 *
  
 * @link [DOM#getAttributes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getAttributes) method documentation.
 * @see [DOMOperations.getAttributes]
 */
data class GetAttributesResponse(
    /**  
     * An interleaved array of node attribute names and values.  
     */  
    val attributes: List<String>

)

/**
 * Represents request frame that can be used with [DOM#getBoxModel](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getBoxModel) operation call.
 *
 * Returns boxes for the given node.
 * @link [DOM#getBoxModel](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getBoxModel) method documentation.
 * @see [DOMOperations.getBoxModel]
 */
data class GetBoxModelRequest(
    /**
     * Identifier of the node.
     */
    val nodeId: NodeId? = null,

    /**
     * Identifier of the backend node.
     */
    val backendNodeId: BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null

)
/**
 * Represents response frame that is returned from [DOM#getBoxModel](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getBoxModel) operation call.
 * Returns boxes for the given node.
 *
  
 * @link [DOM#getBoxModel](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getBoxModel) method documentation.
 * @see [DOMOperations.getBoxModel]
 */
data class GetBoxModelResponse(
    /**  
     * Box model for the node.  
     */  
    val model: BoxModel

)

/**
 * Represents request frame that can be used with [DOM#getContentQuads](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getContentQuads) operation call.
 *
 * Returns quads that describe node position on the page. This method
might return multiple quads for inline nodes.
 * @link [DOM#getContentQuads](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getContentQuads) method documentation.
 * @see [DOMOperations.getContentQuads]
 */
data class GetContentQuadsRequest(
    /**
     * Identifier of the node.
     */
    val nodeId: NodeId? = null,

    /**
     * Identifier of the backend node.
     */
    val backendNodeId: BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null

)
/**
 * Represents response frame that is returned from [DOM#getContentQuads](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getContentQuads) operation call.
 * Returns quads that describe node position on the page. This method
might return multiple quads for inline nodes.
 *
  
 * @link [DOM#getContentQuads](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getContentQuads) method documentation.
 * @see [DOMOperations.getContentQuads]
 */
data class GetContentQuadsResponse(
    /**  
     * Quads that describe node layout relative to viewport.  
     */  
    val quads: List<Quad>

)

/**
 * Represents request frame that can be used with [DOM#getDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getDocument) operation call.
 *
 * Returns the root DOM node (and optionally the subtree) to the caller.
 * @link [DOM#getDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getDocument) method documentation.
 * @see [DOMOperations.getDocument]
 */
data class GetDocumentRequest(
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
entire subtree or provide an integer larger than 0.
     */
    val depth: Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
(default is false).
     */
    val pierce: Boolean? = null

)
/**
 * Represents response frame that is returned from [DOM#getDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getDocument) operation call.
 * Returns the root DOM node (and optionally the subtree) to the caller.
 *
  
 * @link [DOM#getDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getDocument) method documentation.
 * @see [DOMOperations.getDocument]
 */
data class GetDocumentResponse(
    /**  
     * Resulting node.  
     */  
    val root: Node

)

/**
 * Represents request frame that can be used with [DOM#getFlattenedDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFlattenedDocument) operation call.
 *
 * Returns the root DOM node (and optionally the subtree) to the caller.
 * @link [DOM#getFlattenedDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFlattenedDocument) method documentation.
 * @see [DOMOperations.getFlattenedDocument]
 */
data class GetFlattenedDocumentRequest(
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
entire subtree or provide an integer larger than 0.
     */
    val depth: Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
(default is false).
     */
    val pierce: Boolean? = null

)
/**
 * Represents response frame that is returned from [DOM#getFlattenedDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFlattenedDocument) operation call.
 * Returns the root DOM node (and optionally the subtree) to the caller.
 *
  
 * @link [DOM#getFlattenedDocument](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFlattenedDocument) method documentation.
 * @see [DOMOperations.getFlattenedDocument]
 */
data class GetFlattenedDocumentResponse(
    /**  
     * Resulting node.  
     */  
    val nodes: List<Node>

)

/**
 * Represents request frame that can be used with [DOM#getNodeForLocation](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeForLocation) operation call.
 *
 * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is
either returned or not.
 * @link [DOM#getNodeForLocation](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeForLocation) method documentation.
 * @see [DOMOperations.getNodeForLocation]
 */
data class GetNodeForLocationRequest(
    /**
     * X coordinate.
     */
    val x: Int,

    /**
     * Y coordinate.
     */
    val y: Int,

    /**
     * False to skip to the nearest non-UA shadow root ancestor (default: false).
     */
    val includeUserAgentShadowDOM: Boolean? = null,

    /**
     * Whether to ignore pointer-events: none on elements and hit test them.
     */
    val ignorePointerEventsNone: Boolean? = null

)
/**
 * Represents response frame that is returned from [DOM#getNodeForLocation](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeForLocation) operation call.
 * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is
either returned or not.
 *
  
 * @link [DOM#getNodeForLocation](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeForLocation) method documentation.
 * @see [DOMOperations.getNodeForLocation]
 */
data class GetNodeForLocationResponse(
    /**  
     * Resulting node.  
     */  
    val backendNodeId: BackendNodeId,

    /**  
     * Frame this node belongs to.  
     */  
    val frameId: pl.wendigo.chrome.api.page.FrameId,

    /**  
     * Id of the node at given coordinates, only when enabled and requested document.  
     */  
    val nodeId: NodeId? = null

)

/**
 * Represents request frame that can be used with [DOM#getOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getOuterHTML) operation call.
 *
 * Returns node's HTML markup.
 * @link [DOM#getOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getOuterHTML) method documentation.
 * @see [DOMOperations.getOuterHTML]
 */
data class GetOuterHTMLRequest(
    /**
     * Identifier of the node.
     */
    val nodeId: NodeId? = null,

    /**
     * Identifier of the backend node.
     */
    val backendNodeId: BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null

)
/**
 * Represents response frame that is returned from [DOM#getOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getOuterHTML) operation call.
 * Returns node's HTML markup.
 *
  
 * @link [DOM#getOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getOuterHTML) method documentation.
 * @see [DOMOperations.getOuterHTML]
 */
data class GetOuterHTMLResponse(
    /**  
     * Outer HTML markup.  
     */  
    val outerHTML: String

)

/**
 * Represents request frame that can be used with [DOM#getRelayoutBoundary](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getRelayoutBoundary) operation call.
 *
 * Returns the id of the nearest ancestor that is a relayout boundary.
 * @link [DOM#getRelayoutBoundary](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getRelayoutBoundary) method documentation.
 * @see [DOMOperations.getRelayoutBoundary]
 */
data class GetRelayoutBoundaryRequest(
    /**
     * Id of the node.
     */
    val nodeId: NodeId

)
/**
 * Represents response frame that is returned from [DOM#getRelayoutBoundary](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getRelayoutBoundary) operation call.
 * Returns the id of the nearest ancestor that is a relayout boundary.
 *
  
 * @link [DOM#getRelayoutBoundary](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getRelayoutBoundary) method documentation.
 * @see [DOMOperations.getRelayoutBoundary]
 */
data class GetRelayoutBoundaryResponse(
    /**  
     * Relayout boundary node id for the given node.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#getSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getSearchResults) operation call.
 *
 * Returns search results from given `fromIndex` to given `toIndex` from the search with the given
identifier.
 * @link [DOM#getSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getSearchResults) method documentation.
 * @see [DOMOperations.getSearchResults]
 */
data class GetSearchResultsRequest(
    /**
     * Unique search session identifier.
     */
    val searchId: String,

    /**
     * Start index of the search result to be returned.
     */
    val fromIndex: Int,

    /**
     * End index of the search result to be returned.
     */
    val toIndex: Int

)
/**
 * Represents response frame that is returned from [DOM#getSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getSearchResults) operation call.
 * Returns search results from given `fromIndex` to given `toIndex` from the search with the given
identifier.
 *
  
 * @link [DOM#getSearchResults](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getSearchResults) method documentation.
 * @see [DOMOperations.getSearchResults]
 */
data class GetSearchResultsResponse(
    /**  
     * Ids of the search result nodes.  
     */  
    val nodeIds: List<NodeId>

)

/**
 * Represents request frame that can be used with [DOM#moveTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-moveTo) operation call.
 *
 * Moves node into the new container, places it before the given anchor.
 * @link [DOM#moveTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-moveTo) method documentation.
 * @see [DOMOperations.moveTo]
 */
data class MoveToRequest(
    /**
     * Id of the node to move.
     */
    val nodeId: NodeId,

    /**
     * Id of the element to drop the moved node into.
     */
    val targetNodeId: NodeId,

    /**
     * Drop node before this one (if absent, the moved node becomes the last child of
`targetNodeId`).
     */
    val insertBeforeNodeId: NodeId? = null

)
/**
 * Represents response frame that is returned from [DOM#moveTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-moveTo) operation call.
 * Moves node into the new container, places it before the given anchor.
 *
  
 * @link [DOM#moveTo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-moveTo) method documentation.
 * @see [DOMOperations.moveTo]
 */
data class MoveToResponse(
    /**  
     * New id of the moved node.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#performSearch](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-performSearch) operation call.
 *
 * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or
`cancelSearch` to end this search session.
 * @link [DOM#performSearch](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-performSearch) method documentation.
 * @see [DOMOperations.performSearch]
 */
data class PerformSearchRequest(
    /**
     * Plain text or query selector or XPath search query.
     */
    val query: String,

    /**
     * True to search in user agent shadow DOM.
     */
    val includeUserAgentShadowDOM: Boolean? = null

)
/**
 * Represents response frame that is returned from [DOM#performSearch](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-performSearch) operation call.
 * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or
`cancelSearch` to end this search session.
 *
  
 * @link [DOM#performSearch](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-performSearch) method documentation.
 * @see [DOMOperations.performSearch]
 */
data class PerformSearchResponse(
    /**  
     * Unique search session identifier.  
     */  
    val searchId: String,

    /**  
     * Number of search results.  
     */  
    val resultCount: Int

)

/**
 * Represents request frame that can be used with [DOM#pushNodeByPathToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodeByPathToFrontend) operation call.
 *
 * Requests that the node is sent to the caller given its path. // FIXME, use XPath
 * @link [DOM#pushNodeByPathToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodeByPathToFrontend) method documentation.
 * @see [DOMOperations.pushNodeByPathToFrontend]
 */
data class PushNodeByPathToFrontendRequest(
    /**
     * Path to node in the proprietary format.
     */
    val path: String

)
/**
 * Represents response frame that is returned from [DOM#pushNodeByPathToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodeByPathToFrontend) operation call.
 * Requests that the node is sent to the caller given its path. // FIXME, use XPath
 *
  
 * @link [DOM#pushNodeByPathToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodeByPathToFrontend) method documentation.
 * @see [DOMOperations.pushNodeByPathToFrontend]
 */
data class PushNodeByPathToFrontendResponse(
    /**  
     * Id of the node for given path.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#pushNodesByBackendIdsToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodesByBackendIdsToFrontend) operation call.
 *
 * Requests that a batch of nodes is sent to the caller given their backend node ids.
 * @link [DOM#pushNodesByBackendIdsToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodesByBackendIdsToFrontend) method documentation.
 * @see [DOMOperations.pushNodesByBackendIdsToFrontend]
 */
data class PushNodesByBackendIdsToFrontendRequest(
    /**
     * The array of backend node ids.
     */
    val backendNodeIds: List<BackendNodeId>

)
/**
 * Represents response frame that is returned from [DOM#pushNodesByBackendIdsToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodesByBackendIdsToFrontend) operation call.
 * Requests that a batch of nodes is sent to the caller given their backend node ids.
 *
  
 * @link [DOM#pushNodesByBackendIdsToFrontend](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-pushNodesByBackendIdsToFrontend) method documentation.
 * @see [DOMOperations.pushNodesByBackendIdsToFrontend]
 */
data class PushNodesByBackendIdsToFrontendResponse(
    /**  
     * The array of ids of pushed nodes that correspond to the backend ids specified in  
     backendNodeIds.  
     */  
    val nodeIds: List<NodeId>

)

/**
 * Represents request frame that can be used with [DOM#querySelector](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelector) operation call.
 *
 * Executes `querySelector` on a given node.
 * @link [DOM#querySelector](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelector) method documentation.
 * @see [DOMOperations.querySelector]
 */
data class QuerySelectorRequest(
    /**
     * Id of the node to query upon.
     */
    val nodeId: NodeId,

    /**
     * Selector string.
     */
    val selector: String

)
/**
 * Represents response frame that is returned from [DOM#querySelector](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelector) operation call.
 * Executes `querySelector` on a given node.
 *
  
 * @link [DOM#querySelector](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelector) method documentation.
 * @see [DOMOperations.querySelector]
 */
data class QuerySelectorResponse(
    /**  
     * Query selector result.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#querySelectorAll](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelectorAll) operation call.
 *
 * Executes `querySelectorAll` on a given node.
 * @link [DOM#querySelectorAll](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelectorAll) method documentation.
 * @see [DOMOperations.querySelectorAll]
 */
data class QuerySelectorAllRequest(
    /**
     * Id of the node to query upon.
     */
    val nodeId: NodeId,

    /**
     * Selector string.
     */
    val selector: String

)
/**
 * Represents response frame that is returned from [DOM#querySelectorAll](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelectorAll) operation call.
 * Executes `querySelectorAll` on a given node.
 *
  
 * @link [DOM#querySelectorAll](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-querySelectorAll) method documentation.
 * @see [DOMOperations.querySelectorAll]
 */
data class QuerySelectorAllResponse(
    /**  
     * Query selector result.  
     */  
    val nodeIds: List<NodeId>

)

/**
 * Represents request frame that can be used with [DOM#removeAttribute](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-removeAttribute) operation call.
 *
 * Removes attribute with given name from an element with given id.
 * @link [DOM#removeAttribute](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-removeAttribute) method documentation.
 * @see [DOMOperations.removeAttribute]
 */
data class RemoveAttributeRequest(
    /**
     * Id of the element to remove attribute from.
     */
    val nodeId: NodeId,

    /**
     * Name of the attribute to remove.
     */
    val name: String

)

/**
 * Represents request frame that can be used with [DOM#removeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-removeNode) operation call.
 *
 * Removes node with given id.
 * @link [DOM#removeNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-removeNode) method documentation.
 * @see [DOMOperations.removeNode]
 */
data class RemoveNodeRequest(
    /**
     * Id of the node to remove.
     */
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#requestChildNodes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestChildNodes) operation call.
 *
 * Requests that children of the node with given id are returned to the caller in form of
`setChildNodes` events where not only immediate children are retrieved, but all children down to
the specified depth.
 * @link [DOM#requestChildNodes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestChildNodes) method documentation.
 * @see [DOMOperations.requestChildNodes]
 */
data class RequestChildNodesRequest(
    /**
     * Id of the node to get children for.
     */
    val nodeId: NodeId,

    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
entire subtree or provide an integer larger than 0.
     */
    val depth: Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the sub-tree
(default is false).
     */
    val pierce: Boolean? = null

)

/**
 * Represents request frame that can be used with [DOM#requestNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestNode) operation call.
 *
 * Requests that the node is sent to the caller given the JavaScript node object reference. All
nodes that form the path from the node to the root are also sent to the client as a series of
`setChildNodes` notifications.
 * @link [DOM#requestNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestNode) method documentation.
 * @see [DOMOperations.requestNode]
 */
data class RequestNodeRequest(
    /**
     * JavaScript object id to convert into node.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId

)
/**
 * Represents response frame that is returned from [DOM#requestNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestNode) operation call.
 * Requests that the node is sent to the caller given the JavaScript node object reference. All
nodes that form the path from the node to the root are also sent to the client as a series of
`setChildNodes` notifications.
 *
  
 * @link [DOM#requestNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-requestNode) method documentation.
 * @see [DOMOperations.requestNode]
 */
data class RequestNodeResponse(
    /**  
     * Node id for given object.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#resolveNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-resolveNode) operation call.
 *
 * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
 * @link [DOM#resolveNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-resolveNode) method documentation.
 * @see [DOMOperations.resolveNode]
 */
data class ResolveNodeRequest(
    /**
     * Id of the node to resolve.
     */
    val nodeId: NodeId? = null,

    /**
     * Backend identifier of the node to resolve.
     */
    val backendNodeId: pl.wendigo.chrome.api.dom.BackendNodeId? = null,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup: String? = null,

    /**
     * Execution context in which to resolve the node.
     */
    val executionContextId: pl.wendigo.chrome.api.runtime.ExecutionContextId? = null

)
/**
 * Represents response frame that is returned from [DOM#resolveNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-resolveNode) operation call.
 * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
 *
  
 * @link [DOM#resolveNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-resolveNode) method documentation.
 * @see [DOMOperations.resolveNode]
 */
data class ResolveNodeResponse(
    /**  
     * JavaScript object wrapper for given node.  
     */  
    @get:com.fasterxml.jackson.annotation.JsonProperty("object")
    val _object: pl.wendigo.chrome.api.runtime.RemoteObject

)

/**
 * Represents request frame that can be used with [DOM#setAttributeValue](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setAttributeValue) operation call.
 *
 * Sets attribute for an element with given id.
 * @link [DOM#setAttributeValue](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setAttributeValue) method documentation.
 * @see [DOMOperations.setAttributeValue]
 */
data class SetAttributeValueRequest(
    /**
     * Id of the element to set attribute for.
     */
    val nodeId: NodeId,

    /**
     * Attribute name.
     */
    val name: String,

    /**
     * Attribute value.
     */
    val value: String

)

/**
 * Represents request frame that can be used with [DOM#setAttributesAsText](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setAttributesAsText) operation call.
 *
 * Sets attributes on element with given id. This method is useful when user edits some existing
attribute value and types in several attribute name/value pairs.
 * @link [DOM#setAttributesAsText](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setAttributesAsText) method documentation.
 * @see [DOMOperations.setAttributesAsText]
 */
data class SetAttributesAsTextRequest(
    /**
     * Id of the element to set attributes for.
     */
    val nodeId: NodeId,

    /**
     * Text with a number of attributes. Will parse this text using HTML parser.
     */
    val text: String,

    /**
     * Attribute name to replace with new attributes derived from text in case text parsed
successfully.
     */
    val name: String? = null

)

/**
 * Represents request frame that can be used with [DOM#setFileInputFiles](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setFileInputFiles) operation call.
 *
 * Sets files for the given file input element.
 * @link [DOM#setFileInputFiles](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setFileInputFiles) method documentation.
 * @see [DOMOperations.setFileInputFiles]
 */
data class SetFileInputFilesRequest(
    /**
     * Array of file paths to set.
     */
    val files: List<String>,

    /**
     * Identifier of the node.
     */
    val nodeId: NodeId? = null,

    /**
     * Identifier of the backend node.
     */
    val backendNodeId: BackendNodeId? = null,

    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId? = null

)

/**
 * Represents request frame that can be used with [DOM#setNodeStackTracesEnabled](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeStackTracesEnabled) operation call.
 *
 * Sets if stack traces should be captured for Nodes. See `Node.getNodeStackTraces`. Default is disabled.
 * @link [DOM#setNodeStackTracesEnabled](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeStackTracesEnabled) method documentation.
 * @see [DOMOperations.setNodeStackTracesEnabled]
 */
data class SetNodeStackTracesEnabledRequest(
    /**
     * Enable or disable.
     */
    val enable: Boolean

)

/**
 * Represents request frame that can be used with [DOM#getNodeStackTraces](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeStackTraces) operation call.
 *
 * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
 * @link [DOM#getNodeStackTraces](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeStackTraces) method documentation.
 * @see [DOMOperations.getNodeStackTraces]
 */
data class GetNodeStackTracesRequest(
    /**
     * Id of the node to get stack traces for.
     */
    val nodeId: NodeId

)
/**
 * Represents response frame that is returned from [DOM#getNodeStackTraces](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeStackTraces) operation call.
 * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
 *
  
 * @link [DOM#getNodeStackTraces](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getNodeStackTraces) method documentation.
 * @see [DOMOperations.getNodeStackTraces]
 */
data class GetNodeStackTracesResponse(
    /**  
     * Creation stack trace, if available.  
     */  
    val creation: pl.wendigo.chrome.api.runtime.StackTrace? = null

)

/**
 * Represents request frame that can be used with [DOM#getFileInfo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFileInfo) operation call.
 *
 * Returns file information for the given
File wrapper.
 * @link [DOM#getFileInfo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFileInfo) method documentation.
 * @see [DOMOperations.getFileInfo]
 */
data class GetFileInfoRequest(
    /**
     * JavaScript object id of the node wrapper.
     */
    val objectId: pl.wendigo.chrome.api.runtime.RemoteObjectId

)
/**
 * Represents response frame that is returned from [DOM#getFileInfo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFileInfo) operation call.
 * Returns file information for the given
File wrapper.
 *
  
 * @link [DOM#getFileInfo](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFileInfo) method documentation.
 * @see [DOMOperations.getFileInfo]
 */
data class GetFileInfoResponse(
    /**  
     *  
     */  
    val path: String

)

/**
 * Represents request frame that can be used with [DOM#setInspectedNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setInspectedNode) operation call.
 *
 * Enables console to refer to the node with given id via $x (see Command Line API for more details
$x functions).
 * @link [DOM#setInspectedNode](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setInspectedNode) method documentation.
 * @see [DOMOperations.setInspectedNode]
 */
data class SetInspectedNodeRequest(
    /**
     * DOM node id to be accessible by means of $x command line API.
     */
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#setNodeName](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeName) operation call.
 *
 * Sets node name for a node with given id.
 * @link [DOM#setNodeName](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeName) method documentation.
 * @see [DOMOperations.setNodeName]
 */
data class SetNodeNameRequest(
    /**
     * Id of the node to set name for.
     */
    val nodeId: NodeId,

    /**
     * New node's name.
     */
    val name: String

)
/**
 * Represents response frame that is returned from [DOM#setNodeName](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeName) operation call.
 * Sets node name for a node with given id.
 *
  
 * @link [DOM#setNodeName](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeName) method documentation.
 * @see [DOMOperations.setNodeName]
 */
data class SetNodeNameResponse(
    /**  
     * New node's id.  
     */  
    val nodeId: NodeId

)

/**
 * Represents request frame that can be used with [DOM#setNodeValue](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeValue) operation call.
 *
 * Sets node value for a node with given id.
 * @link [DOM#setNodeValue](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setNodeValue) method documentation.
 * @see [DOMOperations.setNodeValue]
 */
data class SetNodeValueRequest(
    /**
     * Id of the node to set value for.
     */
    val nodeId: NodeId,

    /**
     * New node's value.
     */
    val value: String

)

/**
 * Represents request frame that can be used with [DOM#setOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setOuterHTML) operation call.
 *
 * Sets node HTML markup, returns new node id.
 * @link [DOM#setOuterHTML](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-setOuterHTML) method documentation.
 * @see [DOMOperations.setOuterHTML]
 */
data class SetOuterHTMLRequest(
    /**
     * Id of the node to set markup for.
     */
    val nodeId: NodeId,

    /**
     * Outer HTML markup to set.
     */
    val outerHTML: String

)

/**
 * Represents request frame that can be used with [DOM#getFrameOwner](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFrameOwner) operation call.
 *
 * Returns iframe node that owns iframe with the given domain.
 * @link [DOM#getFrameOwner](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFrameOwner) method documentation.
 * @see [DOMOperations.getFrameOwner]
 */
data class GetFrameOwnerRequest(
    /**
     *
     */
    val frameId: pl.wendigo.chrome.api.page.FrameId

)
/**
 * Represents response frame that is returned from [DOM#getFrameOwner](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFrameOwner) operation call.
 * Returns iframe node that owns iframe with the given domain.
 *
  
 * @link [DOM#getFrameOwner](https://chromedevtools.github.io/devtools-protocol/tot/DOM#method-getFrameOwner) method documentation.
 * @see [DOMOperations.getFrameOwner]
 */
data class GetFrameOwnerResponse(
    /**  
     * Resulting node.  
     */  
    val backendNodeId: BackendNodeId,

    /**  
     * Id of the node at given coordinates, only when enabled and requested document.  
     */  
    val nodeId: NodeId? = null

)

/**
 * Fired when `Element`'s attribute is modified.
 *
 * @link [DOM#attributeModified](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-attributeModified) event documentation.
 */
data class AttributeModifiedEvent(
    /**  
     * Id of the node that has changed.  
     */  
    val nodeId: NodeId,

    /**  
     * Attribute name.  
     */  
    val name: String,

    /**  
     * Attribute value.  
     */  
    val value: String

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "attributeModified")

/**
 * Fired when `Element`'s attribute is removed.
 *
 * @link [DOM#attributeRemoved](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-attributeRemoved) event documentation.
 */
data class AttributeRemovedEvent(
    /**  
     * Id of the node that has changed.  
     */  
    val nodeId: NodeId,

    /**  
     * A ttribute name.  
     */  
    val name: String

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "attributeRemoved")

/**
 * Mirrors `DOMCharacterDataModified` event.
 *
 * @link [DOM#characterDataModified](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-characterDataModified) event documentation.
 */
data class CharacterDataModifiedEvent(
    /**  
     * Id of the node that has changed.  
     */  
    val nodeId: NodeId,

    /**  
     * New text value.  
     */  
    val characterData: String

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "characterDataModified")

/**
 * Fired when `Container`'s child node count has changed.
 *
 * @link [DOM#childNodeCountUpdated](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-childNodeCountUpdated) event documentation.
 */
data class ChildNodeCountUpdatedEvent(
    /**  
     * Id of the node that has changed.  
     */  
    val nodeId: NodeId,

    /**  
     * New node count.  
     */  
    val childNodeCount: Int

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "childNodeCountUpdated")

/**
 * Mirrors `DOMNodeInserted` event.
 *
 * @link [DOM#childNodeInserted](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-childNodeInserted) event documentation.
 */
data class ChildNodeInsertedEvent(
    /**  
     * Id of the node that has changed.  
     */  
    val parentNodeId: NodeId,

    /**  
     * If of the previous siblint.  
     */  
    val previousNodeId: NodeId,

    /**  
     * Inserted node data.  
     */  
    val node: Node

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "childNodeInserted")

/**
 * Mirrors `DOMNodeRemoved` event.
 *
 * @link [DOM#childNodeRemoved](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-childNodeRemoved) event documentation.
 */
data class ChildNodeRemovedEvent(
    /**  
     * Parent id.  
     */  
    val parentNodeId: NodeId,

    /**  
     * Id of the node that has been removed.  
     */  
    val nodeId: NodeId

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "childNodeRemoved")

/**
 * Called when distrubution is changed.
 *
 * @link [DOM#distributedNodesUpdated](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-distributedNodesUpdated) event documentation.
 */
data class DistributedNodesUpdatedEvent(
    /**  
     * Insertion point where distrubuted nodes were updated.  
     */  
    val insertionPointId: NodeId,

    /**  
     * Distributed nodes for given insertion point.  
     */  
    val distributedNodes: List<BackendNode>

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "distributedNodesUpdated")

/**
 * Fired when `Element`'s inline style is modified via a CSS property modification.
 *
 * @link [DOM#inlineStyleInvalidated](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-inlineStyleInvalidated) event documentation.
 */
data class InlineStyleInvalidatedEvent(
    /**  
     * Ids of the nodes for which the inline styles have been invalidated.  
     */  
    val nodeIds: List<NodeId>

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "inlineStyleInvalidated")

/**
 * Called when a pseudo element is added to an element.
 *
 * @link [DOM#pseudoElementAdded](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-pseudoElementAdded) event documentation.
 */
data class PseudoElementAddedEvent(
    /**  
     * Pseudo element's parent element id.  
     */  
    val parentId: NodeId,

    /**  
     * The added pseudo element.  
     */  
    val pseudoElement: Node

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "pseudoElementAdded")

/**
 * Called when a pseudo element is removed from an element.
 *
 * @link [DOM#pseudoElementRemoved](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-pseudoElementRemoved) event documentation.
 */
data class PseudoElementRemovedEvent(
    /**  
     * Pseudo element's parent element id.  
     */  
    val parentId: NodeId,

    /**  
     * The removed pseudo element id.  
     */  
    val pseudoElementId: NodeId

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "pseudoElementRemoved")

/**
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon
most of the calls requesting node ids.
 *
 * @link [DOM#setChildNodes](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-setChildNodes) event documentation.
 */
data class SetChildNodesEvent(
    /**  
     * Parent node id to populate with children.  
     */  
    val parentId: NodeId,

    /**  
     * Child nodes array.  
     */  
    val nodes: List<Node>

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "setChildNodes")

/**
 * Called when shadow root is popped from the element.
 *
 * @link [DOM#shadowRootPopped](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-shadowRootPopped) event documentation.
 */
data class ShadowRootPoppedEvent(
    /**  
     * Host element id.  
     */  
    val hostId: NodeId,

    /**  
     * Shadow root id.  
     */  
    val rootId: NodeId

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "shadowRootPopped")

/**
 * Called when shadow root is pushed into the element.
 *
 * @link [DOM#shadowRootPushed](https://chromedevtools.github.io/devtools-protocol/tot/DOM#event-shadowRootPushed) event documentation.
 */
data class ShadowRootPushedEvent(
    /**  
     * Host element id.  
     */  
    val hostId: NodeId,

    /**  
     * Shadow root.  
     */  
    val root: Node

) : pl.wendigo.chrome.protocol.Event(domain = "DOM", name = "shadowRootPushed")
