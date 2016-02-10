package com.test.model.pathing.graph;


import com.test.model.pathing.Traveler;
import com.test.model.pathing.node.Node;
import com.test.model.pathing.node.Travelable;

import java.util.List;

// graph has nodeset, can get neighbors of given node and the distance between them
public interface Graph<P extends Travelable> {		// P is payload type of nodes
	public List<Node<P>> getNodeSet();
	public List<Node<P>> getNeighbors(Node<P> node);
	public double getDistance(Node<P> nodeA, Node<P> nodeB, Traveler travelerInfo);
}