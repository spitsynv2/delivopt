package com.solvd.delivopt.util.pathfinder;

import com.solvd.delivopt.model.graphmodel.Graph;
import com.solvd.delivopt.model.graphmodel.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class NearestNeighborWithDijkstra {
    private static final Logger log = LogManager.getLogger(NearestNeighborWithDijkstra.class);

    public static List<Long> findOptimalRoute(Graph graph, Long startId) {
        Set<Long> visited = new HashSet<>();
        List<Long> route = new ArrayList<>();
        Long currentNode = startId;

        route.add(currentNode);
        visited.add(currentNode);

        while (visited.size() < graph.getNodes().size()) {
            Map<Long, Double> shortestPaths = Dijkstra.calculateShortestPath(graph, currentNode);

            Long nextNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Map.Entry<Long, Double> entry : shortestPaths.entrySet()) {
                Long nodeId = entry.getKey();
                double distance = entry.getValue();

                if (!visited.contains(nodeId) && distance < shortestDistance) {
                    nextNode = nodeId;
                    shortestDistance = distance;
                }
            }

            if (nextNode == null) {
                for (Node node : graph.getNodes()) {
                    if (!visited.contains(node.getId())) {
                        nextNode = node.getId();
                        log.warn("Disconnected node found: Forcing visit to {}", nextNode);
                        break;
                    }
                }
            }

            log.info("Moving from {} -> {} (Distance: {})", currentNode, nextNode, shortestDistance);
            visited.add(nextNode);
            route.add(nextNode);
            currentNode = nextNode;
        }

        return route;
    }
}
