package com.solvd.delivopt.util;

import com.solvd.delivopt.util.Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static Map<Long, Double> calculateShortestPath(Graph graph, Long startId) {
        Map<Long, Double> distances = new HashMap<>();
        Map<Long, Graph.Node> previousNodes = new HashMap<>();
        PriorityQueue<NodeDistancePair> queue = new PriorityQueue<>(Comparator.comparingDouble(NodeDistancePair::getDistance));

        // Initialize distances
        for (Graph.Node node : graph.getNodes()) {
            distances.put(node.getId(), Double.MAX_VALUE);
        }
        distances.put(startId, 0.0);

        queue.add(new NodeDistancePair(startId, 0.0));

        while (!queue.isEmpty()) {
            NodeDistancePair current = queue.poll();
            Long currentNodeId = current.getNodeId();
            Double currentDistance = current.getDistance();

            // Skip processing if we have already found a shorter path
            if (currentDistance > distances.get(currentNodeId)) continue;

            Graph.Node currentNode = graph.getNode(currentNodeId);

            for (Graph.Edge edge : currentNode.getEdges()) {
                Long neighborId = edge.getDestination().getId();
                Double newDist = currentDistance + edge.getDistance();
                if (newDist < distances.get(neighborId)) {
                    distances.put(neighborId, newDist);
                    previousNodes.put(neighborId, currentNode);
                    queue.add(new NodeDistancePair(neighborId, newDist));
                }
            }
        }
        return distances;
    }

    private static class NodeDistancePair {
        private final Long nodeId;
        private final Double distance;

        public NodeDistancePair(Long nodeId, Double distance) {
            this.nodeId = nodeId;
            this.distance = distance;
        }

        public Long getNodeId() {
            return nodeId;
        }

        public Double getDistance() {
            return distance;
        }
    }
}
