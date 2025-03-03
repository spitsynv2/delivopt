package com.solvd.delivopt.util;

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
            toNode.addEdge(new Edge(fromNode, distance));  // Undirected graph (bi-directional)
        }

        public Node getNode(Long id) {
            return nodes.get(id);
        }

        public Collection<Node> getNodes() {
            return nodes.values();
        }

        public static class Node {
            private final Long id;
            private final Address address;
            private final List<Edge> edges;

            public Node(Long id, Address address) {
                this.id = id;
                this.address = address;
                this.edges = new ArrayList<>();
            }

            public void addEdge(Edge edge) {
                edges.add(edge);
            }

            public List<Edge> getEdges() {
                return edges;
            }

            public Long getId() {
                return id;
            }

            public Address getAddress() {
                return address;
            }
        }

        public static class Edge {
            private final Node destination;
            private final Double distance;

            public Edge(Node destination, Double distance) {
                this.destination = destination;
                this.distance = distance;
            }

            public Node getDestination() {
                return destination;
            }

            public Double getDistance() {
                return distance;
            }
        }
    }

