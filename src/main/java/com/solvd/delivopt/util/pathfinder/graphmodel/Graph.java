package com.solvd.delivopt.util.pathfinder.graphmodel;

import com.solvd.delivopt.model.Address;

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

}

