package com.solvd.delivopt.util.pathfinder;

import com.solvd.delivopt.util.pathfinder.graphmodel.Edge;
import com.solvd.delivopt.util.pathfinder.graphmodel.Graph;
import com.solvd.delivopt.util.pathfinder.graphmodel.Node;
import com.solvd.delivopt.util.pathfinder.graphmodel.NodeDistancePair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static Map<Long, Double> calculateShortestPath(Graph graph, Long startId) {
        Map<Long, Double> distances = new HashMap<>();
        Map<Long, Node> previousNodes = new HashMap<>();
        PriorityQueue<NodeDistancePair> queue = new PriorityQueue<>(Comparator.comparingDouble(NodeDistancePair::getDistance));

        for (Node node : graph.getNodes()) {
            distances.put(node.getId(), Double.MAX_VALUE);
        }
        distances.put(startId, 0.0);

        queue.add(new NodeDistancePair(startId, 0.0));

        while (!queue.isEmpty()) {
            NodeDistancePair current = queue.poll();
            Long currentNodeId = current.getNodeId();
            Double currentDistance = current.getDistance();

            if (currentDistance > distances.get(currentNodeId)) continue;

            Node currentNode = graph.getNode(currentNodeId);

            for (Edge edge : currentNode.getEdges()) {
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
}
