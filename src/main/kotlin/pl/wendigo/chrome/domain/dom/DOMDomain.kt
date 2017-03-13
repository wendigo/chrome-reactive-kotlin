package pl.wendigo.chrome.domain.dom

/**
 * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object that has an <code>id</code>. This <code>id</code> can be used to get additional information on the Node, resolve it into the JavaScript object wrapper, etc. It is important that client receives DOM events only for the nodes that are known to the client. Backend keeps track of the nodes that were sent to the client and never sends the same node twice. It is client's responsibility to collect information about the nodes that were sent to the client.<p>Note that <code>iframe</code> owner elements will return corresponding document elements as their child nodes.</p>
 */
class DOMDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.RemoteDebuggerConnection) {

	/**
	 * Enables DOM agent for the given page.
	 */
	  fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables DOM agent for the given page.
	 */
	  fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns the root DOM node (and optionally the subtree) to the caller.
	 */
	  fun getDocument(input : GetDocumentRequest) : io.reactivex.Single<GetDocumentResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getDocument", input, GetDocumentResponse::class.java)
	}

	/**
	 * Returns the root DOM node (and optionally the subtree) to the caller.
	 */
	  fun getFlattenedDocument(input : GetFlattenedDocumentRequest) : io.reactivex.Single<GetFlattenedDocumentResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getFlattenedDocument", input, GetFlattenedDocumentResponse::class.java)
	}

	/**
	 * Collects class names for the node with given id and all of it's child nodes.
	 */
	@pl.wendigo.chrome.Experimental
    fun collectClassNamesFromSubtree(input : CollectClassNamesFromSubtreeRequest) : io.reactivex.Single<CollectClassNamesFromSubtreeResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.collectClassNamesFromSubtree", input, CollectClassNamesFromSubtreeResponse::class.java)
	}

	/**
	 * Requests that children of the node with given id are returned to the caller in form of <code>setChildNodes</code> events where not only immediate children are retrieved, but all children down to the specified depth.
	 */
	  fun requestChildNodes(input : RequestChildNodesRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.requestChildNodes", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Executes <code>querySelector</code> on a given node.
	 */
	  fun querySelector(input : QuerySelectorRequest) : io.reactivex.Single<QuerySelectorResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.querySelector", input, QuerySelectorResponse::class.java)
	}

	/**
	 * Executes <code>querySelectorAll</code> on a given node.
	 */
	  fun querySelectorAll(input : QuerySelectorAllRequest) : io.reactivex.Single<QuerySelectorAllResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.querySelectorAll", input, QuerySelectorAllResponse::class.java)
	}

	/**
	 * Sets node name for a node with given id.
	 */
	  fun setNodeName(input : SetNodeNameRequest) : io.reactivex.Single<SetNodeNameResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.setNodeName", input, SetNodeNameResponse::class.java)
	}

	/**
	 * Sets node value for a node with given id.
	 */
	  fun setNodeValue(input : SetNodeValueRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setNodeValue", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Removes node with given id.
	 */
	  fun removeNode(input : RemoveNodeRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.removeNode", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Sets attribute for an element with given id.
	 */
	  fun setAttributeValue(input : SetAttributeValueRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setAttributeValue", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Sets attributes on element with given id. This method is useful when user edits some existing attribute value and types in several attribute name/value pairs.
	 */
	  fun setAttributesAsText(input : SetAttributesAsTextRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setAttributesAsText", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Removes attribute with given name from an element with given id.
	 */
	  fun removeAttribute(input : RemoveAttributeRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.removeAttribute", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns node's HTML markup.
	 */
	  fun getOuterHTML(input : GetOuterHTMLRequest) : io.reactivex.Single<GetOuterHTMLResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getOuterHTML", input, GetOuterHTMLResponse::class.java)
	}

	/**
	 * Sets node HTML markup, returns new node id.
	 */
	  fun setOuterHTML(input : SetOuterHTMLRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setOuterHTML", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Searches for a given string in the DOM tree. Use <code>getSearchResults</code> to access search results or <code>cancelSearch</code> to end this search session.
	 */
	@pl.wendigo.chrome.Experimental
    fun performSearch(input : PerformSearchRequest) : io.reactivex.Single<PerformSearchResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.performSearch", input, PerformSearchResponse::class.java)
	}

	/**
	 * Returns search results from given <code>fromIndex</code> to given <code>toIndex</code> from the sarch with the given identifier.
	 */
	@pl.wendigo.chrome.Experimental
    fun getSearchResults(input : GetSearchResultsRequest) : io.reactivex.Single<GetSearchResultsResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getSearchResults", input, GetSearchResultsResponse::class.java)
	}

	/**
	 * Discards search results from the session with the given id. <code>getSearchResults</code> should no longer be called for that search.
	 */
	@pl.wendigo.chrome.Experimental
    fun discardSearchResults(input : DiscardSearchResultsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.discardSearchResults", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of <code>setChildNodes</code> notifications.
	 */
	  fun requestNode(input : RequestNodeRequest) : io.reactivex.Single<RequestNodeResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.requestNode", input, RequestNodeResponse::class.java)
	}

	/**
	 * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
	 */
	@pl.wendigo.chrome.Experimental
    fun setInspectMode(input : SetInspectModeRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setInspectMode", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
	 */
	  fun highlightRect(input : HighlightRectRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.highlightRect", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
	 */
	@pl.wendigo.chrome.Experimental
    fun highlightQuad(input : HighlightQuadRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.highlightQuad", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
	 */
	  fun highlightNode(input : HighlightNodeRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.highlightNode", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Hides DOM node highlight.
	 */
	  fun hideHighlight() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.hideHighlight", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Highlights owner element of the frame with given id.
	 */
	@pl.wendigo.chrome.Experimental
    fun highlightFrame(input : HighlightFrameRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.highlightFrame", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Requests that the node is sent to the caller given its path. // FIXME, use XPath
	 */
	@pl.wendigo.chrome.Experimental
    fun pushNodeByPathToFrontend(input : PushNodeByPathToFrontendRequest) : io.reactivex.Single<PushNodeByPathToFrontendResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.pushNodeByPathToFrontend", input, PushNodeByPathToFrontendResponse::class.java)
	}

	/**
	 * Requests that a batch of nodes is sent to the caller given their backend node ids.
	 */
	@pl.wendigo.chrome.Experimental
    fun pushNodesByBackendIdsToFrontend(input : PushNodesByBackendIdsToFrontendRequest) : io.reactivex.Single<PushNodesByBackendIdsToFrontendResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.pushNodesByBackendIdsToFrontend", input, PushNodesByBackendIdsToFrontendResponse::class.java)
	}

	/**
	 * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
	 */
	@pl.wendigo.chrome.Experimental
    fun setInspectedNode(input : SetInspectedNodeRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setInspectedNode", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Resolves JavaScript node object for given node id.
	 */
	  fun resolveNode(input : ResolveNodeRequest) : io.reactivex.Single<ResolveNodeResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.resolveNode", input, ResolveNodeResponse::class.java)
	}

	/**
	 * Returns attributes for the specified node.
	 */
	  fun getAttributes(input : GetAttributesRequest) : io.reactivex.Single<GetAttributesResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getAttributes", input, GetAttributesResponse::class.java)
	}

	/**
	 * Creates a deep copy of the specified node and places it into the target container before the given anchor.
	 */
	@pl.wendigo.chrome.Experimental
    fun copyTo(input : CopyToRequest) : io.reactivex.Single<CopyToResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.copyTo", input, CopyToResponse::class.java)
	}

	/**
	 * Moves node into the new container, places it before the given anchor.
	 */
	  fun moveTo(input : MoveToRequest) : io.reactivex.Single<MoveToResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.moveTo", input, MoveToResponse::class.java)
	}

	/**
	 * Undoes the last performed action.
	 */
	@pl.wendigo.chrome.Experimental
    fun undo() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.undo", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Re-does the last undone action.
	 */
	@pl.wendigo.chrome.Experimental
    fun redo() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.redo", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Marks last undoable state.
	 */
	@pl.wendigo.chrome.Experimental
    fun markUndoableState() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.markUndoableState", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Focuses the given element.
	 */
	@pl.wendigo.chrome.Experimental
    fun focus(input : FocusRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.focus", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Sets files for the given file input element.
	 */
	@pl.wendigo.chrome.Experimental
    fun setFileInputFiles(input : SetFileInputFilesRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("DOM.setFileInputFiles", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Returns boxes for the currently selected nodes.
	 */
	@pl.wendigo.chrome.Experimental
    fun getBoxModel(input : GetBoxModelRequest) : io.reactivex.Single<GetBoxModelResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getBoxModel", input, GetBoxModelResponse::class.java)
	}

	/**
	 * Returns node id at given location.
	 */
	@pl.wendigo.chrome.Experimental
    fun getNodeForLocation(input : GetNodeForLocationRequest) : io.reactivex.Single<GetNodeForLocationResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getNodeForLocation", input, GetNodeForLocationResponse::class.java)
	}

	/**
	 * Returns the id of the nearest ancestor that is a relayout boundary.
	 */
	@pl.wendigo.chrome.Experimental
    fun getRelayoutBoundary(input : GetRelayoutBoundaryRequest) : io.reactivex.Single<GetRelayoutBoundaryResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getRelayoutBoundary", input, GetRelayoutBoundaryResponse::class.java)
	}

	/**
	 * For testing.
	 */
	@pl.wendigo.chrome.Experimental
    fun getHighlightObjectForTest(input : GetHighlightObjectForTestRequest) : io.reactivex.Single<GetHighlightObjectForTestResponse> {
        return connectionRemote.runAndCaptureResponse("DOM.getHighlightObjectForTest", input, GetHighlightObjectForTestResponse::class.java)
	}

  
    /**
     * Fired when <code>Document</code> has been totally updated. Node ids are no longer valid.
     */
    fun documentUpdated() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureEvents("DOM.documentUpdated", pl.wendigo.chrome.ProtocolEvent::class.java)
    }

    /**
     * Fired when the node should be inspected. This happens after call to <code>setInspectMode</code>.
     */
    fun inspectNodeRequested() : io.reactivex.Flowable<InspectNodeRequestedEvent> {
        return connectionRemote.captureEvents("DOM.inspectNodeRequested", InspectNodeRequestedEvent::class.java)
    }

    /**
     * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
     */
    fun setChildNodes() : io.reactivex.Flowable<SetChildNodesEvent> {
        return connectionRemote.captureEvents("DOM.setChildNodes", SetChildNodesEvent::class.java)
    }

    /**
     * Fired when <code>Element</code>'s attribute is modified.
     */
    fun attributeModified() : io.reactivex.Flowable<AttributeModifiedEvent> {
        return connectionRemote.captureEvents("DOM.attributeModified", AttributeModifiedEvent::class.java)
    }

    /**
     * Fired when <code>Element</code>'s attribute is removed.
     */
    fun attributeRemoved() : io.reactivex.Flowable<AttributeRemovedEvent> {
        return connectionRemote.captureEvents("DOM.attributeRemoved", AttributeRemovedEvent::class.java)
    }

    /**
     * Fired when <code>Element</code>'s inline style is modified via a CSS property modification.
     */
    fun inlineStyleInvalidated() : io.reactivex.Flowable<InlineStyleInvalidatedEvent> {
        return connectionRemote.captureEvents("DOM.inlineStyleInvalidated", InlineStyleInvalidatedEvent::class.java)
    }

    /**
     * Mirrors <code>DOMCharacterDataModified</code> event.
     */
    fun characterDataModified() : io.reactivex.Flowable<CharacterDataModifiedEvent> {
        return connectionRemote.captureEvents("DOM.characterDataModified", CharacterDataModifiedEvent::class.java)
    }

    /**
     * Fired when <code>Container</code>'s child node count has changed.
     */
    fun childNodeCountUpdated() : io.reactivex.Flowable<ChildNodeCountUpdatedEvent> {
        return connectionRemote.captureEvents("DOM.childNodeCountUpdated", ChildNodeCountUpdatedEvent::class.java)
    }

    /**
     * Mirrors <code>DOMNodeInserted</code> event.
     */
    fun childNodeInserted() : io.reactivex.Flowable<ChildNodeInsertedEvent> {
        return connectionRemote.captureEvents("DOM.childNodeInserted", ChildNodeInsertedEvent::class.java)
    }

    /**
     * Mirrors <code>DOMNodeRemoved</code> event.
     */
    fun childNodeRemoved() : io.reactivex.Flowable<ChildNodeRemovedEvent> {
        return connectionRemote.captureEvents("DOM.childNodeRemoved", ChildNodeRemovedEvent::class.java)
    }

    /**
     * Called when shadow root is pushed into the element.
     */
    fun shadowRootPushed() : io.reactivex.Flowable<ShadowRootPushedEvent> {
        return connectionRemote.captureEvents("DOM.shadowRootPushed", ShadowRootPushedEvent::class.java)
    }

    /**
     * Called when shadow root is popped from the element.
     */
    fun shadowRootPopped() : io.reactivex.Flowable<ShadowRootPoppedEvent> {
        return connectionRemote.captureEvents("DOM.shadowRootPopped", ShadowRootPoppedEvent::class.java)
    }

    /**
     * Called when a pseudo element is added to an element.
     */
    fun pseudoElementAdded() : io.reactivex.Flowable<PseudoElementAddedEvent> {
        return connectionRemote.captureEvents("DOM.pseudoElementAdded", PseudoElementAddedEvent::class.java)
    }

    /**
     * Called when a pseudo element is removed from an element.
     */
    fun pseudoElementRemoved() : io.reactivex.Flowable<PseudoElementRemovedEvent> {
        return connectionRemote.captureEvents("DOM.pseudoElementRemoved", PseudoElementRemovedEvent::class.java)
    }

    /**
     * Called when distrubution is changed.
     */
    fun distributedNodesUpdated() : io.reactivex.Flowable<DistributedNodesUpdatedEvent> {
        return connectionRemote.captureEvents("DOM.distributedNodesUpdated", DistributedNodesUpdatedEvent::class.java)
    }

    /**
     * Returns observable capturing all DOM.nodeHighlightRequested events.
     */
    fun nodeHighlightRequested() : io.reactivex.Flowable<NodeHighlightRequestedEvent> {
        return connectionRemote.captureEvents("DOM.nodeHighlightRequested", NodeHighlightRequestedEvent::class.java)
    }

    /**
     * Returns flowable capturing all DOM domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().filter {
            it.protocolDomain() == "DOM"
        }
    }
}




/**
 * Represents requestFrame parameters that can be used with DOM.getDocument method call.
 *
 * Returns the root DOM node (and optionally the subtree) to the caller.
 */
data class GetDocumentRequest (
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
     */
    @pl.wendigo.chrome.Experimental val depth : Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
     */
    @pl.wendigo.chrome.Experimental val pierce : Boolean? = null

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns the root DOM node (and optionally the subtree) to the caller.
 */
data class GetDocumentResponse(
  /**
   * Resulting node.
   */
  val root : Node

)

/**
 * Represents requestFrame parameters that can be used with DOM.getFlattenedDocument method call.
 *
 * Returns the root DOM node (and optionally the subtree) to the caller.
 */
data class GetFlattenedDocumentRequest (
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
     */
    @pl.wendigo.chrome.Experimental val depth : Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
     */
    @pl.wendigo.chrome.Experimental val pierce : Boolean? = null

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns the root DOM node (and optionally the subtree) to the caller.
 */
data class GetFlattenedDocumentResponse(
  /**
   * Resulting node.
   */
  val nodes : Array<Node>

)

/**
 * Represents requestFrame parameters that can be used with DOM.collectClassNamesFromSubtree method call.
 *
 * Collects class names for the node with given id and all of it's child nodes.
 */
data class CollectClassNamesFromSubtreeRequest (
    /**
     * Id of the node to collect class names.
     */
    val nodeId : NodeId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Collects class names for the node with given id and all of it's child nodes.
 */
data class CollectClassNamesFromSubtreeResponse(
  /**
   * Class name list.
   */
  val classNames : Array<String>

)

/**
 * Represents requestFrame parameters that can be used with DOM.requestChildNodes method call.
 *
 * Requests that children of the node with given id are returned to the caller in form of <code>setChildNodes</code> events where not only immediate children are retrieved, but all children down to the specified depth.
 */
data class RequestChildNodesRequest (
    /**
     * Id of the node to get children for.
     */
    val nodeId : NodeId,

    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
     */
    @pl.wendigo.chrome.Experimental val depth : Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the sub-tree (default is false).
     */
    @pl.wendigo.chrome.Experimental val pierce : Boolean? = null

)


/**
 * Represents requestFrame parameters that can be used with DOM.querySelector method call.
 *
 * Executes <code>querySelector</code> on a given node.
 */
data class QuerySelectorRequest (
    /**
     * Id of the node to query upon.
     */
    val nodeId : NodeId,

    /**
     * Selector string.
     */
    val selector : String

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Executes <code>querySelector</code> on a given node.
 */
data class QuerySelectorResponse(
  /**
   * Query selector result.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.querySelectorAll method call.
 *
 * Executes <code>querySelectorAll</code> on a given node.
 */
data class QuerySelectorAllRequest (
    /**
     * Id of the node to query upon.
     */
    val nodeId : NodeId,

    /**
     * Selector string.
     */
    val selector : String

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Executes <code>querySelectorAll</code> on a given node.
 */
data class QuerySelectorAllResponse(
  /**
   * Query selector result.
   */
  val nodeIds : Array<NodeId>

)

/**
 * Represents requestFrame parameters that can be used with DOM.setNodeName method call.
 *
 * Sets node name for a node with given id.
 */
data class SetNodeNameRequest (
    /**
     * Id of the node to set name for.
     */
    val nodeId : NodeId,

    /**
     * New node's name.
     */
    val name : String

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Sets node name for a node with given id.
 */
data class SetNodeNameResponse(
  /**
   * New node's id.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.setNodeValue method call.
 *
 * Sets node value for a node with given id.
 */
data class SetNodeValueRequest (
    /**
     * Id of the node to set value for.
     */
    val nodeId : NodeId,

    /**
     * New node's value.
     */
    val value : String

)


/**
 * Represents requestFrame parameters that can be used with DOM.removeNode method call.
 *
 * Removes node with given id.
 */
data class RemoveNodeRequest (
    /**
     * Id of the node to remove.
     */
    val nodeId : NodeId

)


/**
 * Represents requestFrame parameters that can be used with DOM.setAttributeValue method call.
 *
 * Sets attribute for an element with given id.
 */
data class SetAttributeValueRequest (
    /**
     * Id of the element to set attribute for.
     */
    val nodeId : NodeId,

    /**
     * Attribute name.
     */
    val name : String,

    /**
     * Attribute value.
     */
    val value : String

)


/**
 * Represents requestFrame parameters that can be used with DOM.setAttributesAsText method call.
 *
 * Sets attributes on element with given id. This method is useful when user edits some existing attribute value and types in several attribute name/value pairs.
 */
data class SetAttributesAsTextRequest (
    /**
     * Id of the element to set attributes for.
     */
    val nodeId : NodeId,

    /**
     * Text with a number of attributes. Will parse this text using HTML parser.
     */
    val text : String,

    /**
     * Attribute name to replace with new attributes derived from text in case text parsed successfully.
     */
    val name : String? = null

)


/**
 * Represents requestFrame parameters that can be used with DOM.removeAttribute method call.
 *
 * Removes attribute with given name from an element with given id.
 */
data class RemoveAttributeRequest (
    /**
     * Id of the element to remove attribute from.
     */
    val nodeId : NodeId,

    /**
     * Name of the attribute to remove.
     */
    val name : String

)


/**
 * Represents requestFrame parameters that can be used with DOM.getOuterHTML method call.
 *
 * Returns node's HTML markup.
 */
data class GetOuterHTMLRequest (
    /**
     * Id of the node to get markup for.
     */
    val nodeId : NodeId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns node's HTML markup.
 */
data class GetOuterHTMLResponse(
  /**
   * Outer HTML markup.
   */
  val outerHTML : String

)

/**
 * Represents requestFrame parameters that can be used with DOM.setOuterHTML method call.
 *
 * Sets node HTML markup, returns new node id.
 */
data class SetOuterHTMLRequest (
    /**
     * Id of the node to set markup for.
     */
    val nodeId : NodeId,

    /**
     * Outer HTML markup to set.
     */
    val outerHTML : String

)


/**
 * Represents requestFrame parameters that can be used with DOM.performSearch method call.
 *
 * Searches for a given string in the DOM tree. Use <code>getSearchResults</code> to access search results or <code>cancelSearch</code> to end this search session.
 */
data class PerformSearchRequest (
    /**
     * Plain text or query selector or XPath search query.
     */
    val query : String,

    /**
     * True to search in user agent shadow DOM.
     */
    @pl.wendigo.chrome.Experimental val includeUserAgentShadowDOM : Boolean? = null

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Searches for a given string in the DOM tree. Use <code>getSearchResults</code> to access search results or <code>cancelSearch</code> to end this search session.
 */
data class PerformSearchResponse(
  /**
   * Unique search session identifier.
   */
  val searchId : String,

  /**
   * Number of search results.
   */
  val resultCount : Int

)

/**
 * Represents requestFrame parameters that can be used with DOM.getSearchResults method call.
 *
 * Returns search results from given <code>fromIndex</code> to given <code>toIndex</code> from the sarch with the given identifier.
 */
data class GetSearchResultsRequest (
    /**
     * Unique search session identifier.
     */
    val searchId : String,

    /**
     * Start index of the search result to be returned.
     */
    val fromIndex : Int,

    /**
     * End index of the search result to be returned.
     */
    val toIndex : Int

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns search results from given <code>fromIndex</code> to given <code>toIndex</code> from the sarch with the given identifier.
 */
data class GetSearchResultsResponse(
  /**
   * Ids of the search result nodes.
   */
  val nodeIds : Array<NodeId>

)

/**
 * Represents requestFrame parameters that can be used with DOM.discardSearchResults method call.
 *
 * Discards search results from the session with the given id. <code>getSearchResults</code> should no longer be called for that search.
 */
data class DiscardSearchResultsRequest (
    /**
     * Unique search session identifier.
     */
    val searchId : String

)


/**
 * Represents requestFrame parameters that can be used with DOM.requestNode method call.
 *
 * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of <code>setChildNodes</code> notifications.
 */
data class RequestNodeRequest (
    /**
     * JavaScript object id to convert into node.
     */
    val objectId : pl.wendigo.chrome.domain.runtime.RemoteObjectId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of <code>setChildNodes</code> notifications.
 */
data class RequestNodeResponse(
  /**
   * Node id for given object.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.setInspectMode method call.
 *
 * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
 */
data class SetInspectModeRequest (
    /**
     * Set an inspection mode.
     */
    val mode : InspectMode,

    /**
     * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if <code>enabled == false</code>.
     */
    val highlightConfig : HighlightConfig? = null

)


/**
 * Represents requestFrame parameters that can be used with DOM.highlightRect method call.
 *
 * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
 */
data class HighlightRectRequest (
    /**
     * X coordinate
     */
    val x : Int,

    /**
     * Y coordinate
     */
    val y : Int,

    /**
     * Rectangle width
     */
    val width : Int,

    /**
     * Rectangle height
     */
    val height : Int,

    /**
     * The highlight fill color (default: transparent).
     */
    val color : RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor : RGBA? = null

)


/**
 * Represents requestFrame parameters that can be used with DOM.highlightQuad method call.
 *
 * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
 */
data class HighlightQuadRequest (
    /**
     * Quad to highlight
     */
    val quad : Quad,

    /**
     * The highlight fill color (default: transparent).
     */
    val color : RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor : RGBA? = null

)


/**
 * Represents requestFrame parameters that can be used with DOM.highlightNode method call.
 *
 * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
 */
data class HighlightNodeRequest (
    /**
     * A descriptor for the highlight appearance.
     */
    val highlightConfig : HighlightConfig,

    /**
     * Identifier of the node to highlight.
     */
    val nodeId : NodeId? = null,

    /**
     * Identifier of the backend node to highlight.
     */
    val backendNodeId : BackendNodeId? = null,

    /**
     * JavaScript object id of the node to be highlighted.
     */
    @pl.wendigo.chrome.Experimental val objectId : pl.wendigo.chrome.domain.runtime.RemoteObjectId? = null

)




/**
 * Represents requestFrame parameters that can be used with DOM.highlightFrame method call.
 *
 * Highlights owner element of the frame with given id.
 */
data class HighlightFrameRequest (
    /**
     * Identifier of the frame to highlight.
     */
    val frameId : pl.wendigo.chrome.domain.page.FrameId,

    /**
     * The content box highlight fill color (default: transparent).
     */
    val contentColor : RGBA? = null,

    /**
     * The content box highlight outline color (default: transparent).
     */
    val contentOutlineColor : RGBA? = null

)


/**
 * Represents requestFrame parameters that can be used with DOM.pushNodeByPathToFrontend method call.
 *
 * Requests that the node is sent to the caller given its path. // FIXME, use XPath
 */
data class PushNodeByPathToFrontendRequest (
    /**
     * Path to node in the proprietary format.
     */
    val path : String

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Requests that the node is sent to the caller given its path. // FIXME, use XPath
 */
data class PushNodeByPathToFrontendResponse(
  /**
   * Id of the node for given path.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.pushNodesByBackendIdsToFrontend method call.
 *
 * Requests that a batch of nodes is sent to the caller given their backend node ids.
 */
data class PushNodesByBackendIdsToFrontendRequest (
    /**
     * The array of backend node ids.
     */
    val backendNodeIds : Array<BackendNodeId>

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Requests that a batch of nodes is sent to the caller given their backend node ids.
 */
data class PushNodesByBackendIdsToFrontendResponse(
  /**
   * The array of ids of pushed nodes that correspond to the backend ids specified in backendNodeIds.
   */
  val nodeIds : Array<NodeId>

)

/**
 * Represents requestFrame parameters that can be used with DOM.setInspectedNode method call.
 *
 * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
 */
data class SetInspectedNodeRequest (
    /**
     * DOM node id to be accessible by means of $x command line API.
     */
    val nodeId : NodeId

)


/**
 * Represents requestFrame parameters that can be used with DOM.resolveNode method call.
 *
 * Resolves JavaScript node object for given node id.
 */
data class ResolveNodeRequest (
    /**
     * Id of the node to resolve.
     */
    val nodeId : NodeId,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup : String? = null

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Resolves JavaScript node object for given node id.
 */
data class ResolveNodeResponse(
  /**
   * JavaScript object wrapper for given node.
   */
  @get:com.fasterxml.jackson.annotation.JsonProperty("object") val _object : pl.wendigo.chrome.domain.runtime.RemoteObject

)

/**
 * Represents requestFrame parameters that can be used with DOM.getAttributes method call.
 *
 * Returns attributes for the specified node.
 */
data class GetAttributesRequest (
    /**
     * Id of the node to retrieve attibutes for.
     */
    val nodeId : NodeId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns attributes for the specified node.
 */
data class GetAttributesResponse(
  /**
   * An interleaved array of node attribute names and values.
   */
  val attributes : Array<String>

)

/**
 * Represents requestFrame parameters that can be used with DOM.copyTo method call.
 *
 * Creates a deep copy of the specified node and places it into the target container before the given anchor.
 */
data class CopyToRequest (
    /**
     * Id of the node to copy.
     */
    val nodeId : NodeId,

    /**
     * Id of the element to drop the copy into.
     */
    val targetNodeId : NodeId,

    /**
     * Drop the copy before this node (if absent, the copy becomes the last child of <code>targetNodeId</code>).
     */
    val insertBeforeNodeId : NodeId? = null

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Creates a deep copy of the specified node and places it into the target container before the given anchor.
 */
data class CopyToResponse(
  /**
   * Id of the node clone.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.moveTo method call.
 *
 * Moves node into the new container, places it before the given anchor.
 */
data class MoveToRequest (
    /**
     * Id of the node to move.
     */
    val nodeId : NodeId,

    /**
     * Id of the element to drop the moved node into.
     */
    val targetNodeId : NodeId,

    /**
     * Drop node before this one (if absent, the moved node becomes the last child of <code>targetNodeId</code>).
     */
    val insertBeforeNodeId : NodeId? = null

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Moves node into the new container, places it before the given anchor.
 */
data class MoveToResponse(
  /**
   * New id of the moved node.
   */
  val nodeId : NodeId

)







/**
 * Represents requestFrame parameters that can be used with DOM.focus method call.
 *
 * Focuses the given element.
 */
data class FocusRequest (
    /**
     * Id of the node to focus.
     */
    val nodeId : NodeId

)


/**
 * Represents requestFrame parameters that can be used with DOM.setFileInputFiles method call.
 *
 * Sets files for the given file input element.
 */
data class SetFileInputFilesRequest (
    /**
     * Id of the file input node to set files for.
     */
    val nodeId : NodeId,

    /**
     * Array of file paths to set.
     */
    val files : Array<String>

)


/**
 * Represents requestFrame parameters that can be used with DOM.getBoxModel method call.
 *
 * Returns boxes for the currently selected nodes.
 */
data class GetBoxModelRequest (
    /**
     * Id of the node to get box model for.
     */
    val nodeId : NodeId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns boxes for the currently selected nodes.
 */
data class GetBoxModelResponse(
  /**
   * Box model for the node.
   */
  val model : BoxModel

)

/**
 * Represents requestFrame parameters that can be used with DOM.getNodeForLocation method call.
 *
 * Returns node id at given location.
 */
data class GetNodeForLocationRequest (
    /**
     * X coordinate.
     */
    val x : Int,

    /**
     * Y coordinate.
     */
    val y : Int

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns node id at given location.
 */
data class GetNodeForLocationResponse(
  /**
   * Id of the node at given coordinates.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.getRelayoutBoundary method call.
 *
 * Returns the id of the nearest ancestor that is a relayout boundary.
 */
data class GetRelayoutBoundaryRequest (
    /**
     * Id of the node.
     */
    val nodeId : NodeId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * Returns the id of the nearest ancestor that is a relayout boundary.
 */
data class GetRelayoutBoundaryResponse(
  /**
   * Relayout boundary node id for the given node.
   */
  val nodeId : NodeId

)

/**
 * Represents requestFrame parameters that can be used with DOM.getHighlightObjectForTest method call.
 *
 * For testing.
 */
data class GetHighlightObjectForTestRequest (
    /**
     * Id of the node to get highlight object for.
     */
    val nodeId : NodeId

)

/**
 * Represents responseFrame from DOM. method call.
 *
 * For testing.
 */
data class GetHighlightObjectForTestResponse(
  /**
   * Highlight data for the node.
   */
  val highlight : String

)


/**
 * Represents responseFrame from DOM. method call.
 *
 * Fired when the node should be inspected. This happens after call to <code>setInspectMode</code>.
 */
data class InspectNodeRequestedEvent(
  /**
   * Id of the node to inspect.
   */
  val backendNodeId : BackendNodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "inspectNodeRequested")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
 */
data class SetChildNodesEvent(
  /**
   * Parent node id to populate with children.
   */
  val parentId : NodeId,

  /**
   * Child nodes array.
   */
  val nodes : Array<Node>

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "setChildNodes")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Fired when <code>Element</code>'s attribute is modified.
 */
data class AttributeModifiedEvent(
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * Attribute name.
   */
  val name : String,

  /**
   * Attribute value.
   */
  val value : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "attributeModified")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Fired when <code>Element</code>'s attribute is removed.
 */
data class AttributeRemovedEvent(
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * A ttribute name.
   */
  val name : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "attributeRemoved")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Fired when <code>Element</code>'s inline style is modified via a CSS property modification.
 */
data class InlineStyleInvalidatedEvent(
  /**
   * Ids of the nodes for which the inline styles have been invalidated.
   */
  val nodeIds : Array<NodeId>

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "inlineStyleInvalidated")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Mirrors <code>DOMCharacterDataModified</code> event.
 */
data class CharacterDataModifiedEvent(
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * New text value.
   */
  val characterData : String

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "characterDataModified")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Fired when <code>Container</code>'s child node count has changed.
 */
data class ChildNodeCountUpdatedEvent(
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * New node count.
   */
  val childNodeCount : Int

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "childNodeCountUpdated")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Mirrors <code>DOMNodeInserted</code> event.
 */
data class ChildNodeInsertedEvent(
  /**
   * Id of the node that has changed.
   */
  val parentNodeId : NodeId,

  /**
   * If of the previous siblint.
   */
  val previousNodeId : NodeId,

  /**
   * Inserted node data.
   */
  val node : Node

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "childNodeInserted")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Mirrors <code>DOMNodeRemoved</code> event.
 */
data class ChildNodeRemovedEvent(
  /**
   * Parent id.
   */
  val parentNodeId : NodeId,

  /**
   * Id of the node that has been removed.
   */
  val nodeId : NodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "childNodeRemoved")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Called when shadow root is pushed into the element.
 */
data class ShadowRootPushedEvent(
  /**
   * Host element id.
   */
  val hostId : NodeId,

  /**
   * Shadow root.
   */
  val root : Node

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "shadowRootPushed")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Called when shadow root is popped from the element.
 */
data class ShadowRootPoppedEvent(
  /**
   * Host element id.
   */
  val hostId : NodeId,

  /**
   * Shadow root id.
   */
  val rootId : NodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "shadowRootPopped")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Called when a pseudo element is added to an element.
 */
data class PseudoElementAddedEvent(
  /**
   * Pseudo element's parent element id.
   */
  val parentId : NodeId,

  /**
   * The added pseudo element.
   */
  val pseudoElement : Node

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "pseudoElementAdded")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Called when a pseudo element is removed from an element.
 */
data class PseudoElementRemovedEvent(
  /**
   * Pseudo element's parent element id.
   */
  val parentId : NodeId,

  /**
   * The removed pseudo element id.
   */
  val pseudoElementId : NodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "pseudoElementRemoved")

/**
 * Represents responseFrame from DOM. method call.
 *
 * Called when distrubution is changed.
 */
data class DistributedNodesUpdatedEvent(
  /**
   * Insertion point where distrubuted nodes were updated.
   */
  val insertionPointId : NodeId,

  /**
   * Distributed nodes for given insertion point.
   */
  val distributedNodes : Array<BackendNode>

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "distributedNodesUpdated")

/**
 * Represents responseFrame from DOM. method call.
 *
 * 
 */
data class NodeHighlightRequestedEvent(
  /**
   * 
   */
  val nodeId : NodeId

) : pl.wendigo.chrome.ProtocolEvent(domain = "DOM", name = "nodeHighlightRequested")

