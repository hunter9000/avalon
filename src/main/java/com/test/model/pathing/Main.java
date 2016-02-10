package com.test.model.pathing;


import com.test.model.dungeons.CellModel;
import com.test.model.dungeons.GroundType;
import com.test.model.pathing.graph.GridGraph;
import com.test.model.pathing.node.GridNode;
import com.test.model.pathing.node.Node;

import java.util.List;

public class Main {

	public static void main(String/*...*/ args) {
		GridGraph<CellModel> graph = new GridGraph<>(5, 5);
		graph.addNode(new GridNode<CellModel>(0, 0, new CellModel(null, 0, 0, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(0, 1, new CellModel(null, 0, 1, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(1, 0, new CellModel(null, 1, 0, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(1, 1, new CellModel(null, 1, 1, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(2, 1, new CellModel(null, 2, 1, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(3, 1, new CellModel(null, 3, 1, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(3, 2, new CellModel(null, 3, 2, GroundType.DIRT)));
		graph.addNode(new GridNode<CellModel>(3, 3, new CellModel(null, 3, 3, GroundType.DIRT)));

		List<Node<CellModel>> nodeList = graph.getNodeSet();
		//List<Node<String>> neighbors = graph.getNeighbors(nodeList.get(0));
		//double dist = graph.getDistance(nodeList.get(0), nodeList.get(1));

		AStar<CellModel> as = new AStar<CellModel>(graph, nodeList.get(0), nodeList.get(7), new Traveler());

//		DirectedGraph<String> graph = new UndirectedGraph<>();
//		graph.addNode(new UnweightedNode<String>(0, 0, "a"));
//		graph.addNode(new UnweightedNode<String>(2, 3.5, "b"));
//		graph.addNode(new UnweightedNode<String>(1.75, 1.25, "c"));
//		graph.addNode(new UnweightedNode<String>(.5, 2.5, "d"));
//		graph.addNode(new UnweightedNode<String>(3, 4, "e"));
//
//		List<Node<String>> nodeList = graph.getNodeSet();
//		graph.addEdge(nodeList.get(0), nodeList.get(2), 1.7);
//		graph.addEdge(nodeList.get(0), nodeList.get(3), 2.5);
//		graph.addEdge(nodeList.get(2), nodeList.get(1), 1);
//		graph.addEdge(nodeList.get(3), nodeList.get(1), 1);
//		graph.addEdge(nodeList.get(4), nodeList.get(1), 1);
//
//		AStar<String> as = new AStar<String>(graph, nodeList.get(0), nodeList.get(4));

		List<Node<CellModel>> path = as.run();
		System.out.println("path found " + (path != null));
		AStar.printPath(path);
		System.out.println("distance: " + as.getTotalPathDistance());
	}

}
