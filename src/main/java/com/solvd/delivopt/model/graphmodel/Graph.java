package com.solvd.delivopt.model.graphmodel;

import com.solvd.delivopt.model.Address;
import com.solvd.delivopt.util.pathfinder.HarvesineDistance;

import java.util.*;

public class Graph {
    private final Map<Long, Node> nodes = new HashMap<>();

    public void addNode(Long id, Address address) {
            nodes.put(id, new Node(id, address));
    }

    public void addEdge(Long fromId, Long toId, Double distance) {
        Node fromNode = nodes.get(fromId);
        Node toNode = nodes.get(toId);
        fromNode.addEdge(new Edge(toNode, distance));
        toNode.addEdge(new Edge(fromNode, distance));
    }

    public Node getNode(Long id) {
            return nodes.get(id);
    }

    public Collection<Node> getNodes() {
            return nodes.values();
    }

    public void addEdgeWithDistance(Long fromId, Long toId) {
        Node fromNode = this.getNode(fromId);
        Node toNode = this.getNode(toId);

        double distance = HarvesineDistance.calculateDistance(
                fromNode.getAddress().getLatitude(),
                fromNode.getAddress().getLongitude(),
                toNode.getAddress().getLatitude(),
                toNode.getAddress().getLongitude()
        );

        fromNode.addEdge(new Edge(toNode, distance));
        toNode.addEdge(new Edge(fromNode, distance));
    }
}

