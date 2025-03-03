package com.solvd.delivopt.util.pathfinder.graphmodel;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-03
 */
public class Edge {
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