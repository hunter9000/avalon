package com.test.model.pathing.graph;


import com.test.model.pathing.node.Node;
import com.test.model.pathing.node.Travelable;

public class UndirectedGraph<P extends Travelable> extends DirectedGraph<P> {

	/** Adds the edge in both directions with the same weight */
	@Override
	public void addEdge(Node<P> nodeA, Node<P> nodeB, double weight) {
		super.addEdge(nodeA, nodeB, weight);
		super.addEdge(nodeB, nodeA, weight);
	}

}
