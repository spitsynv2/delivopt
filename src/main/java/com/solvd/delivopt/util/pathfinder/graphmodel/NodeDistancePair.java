package com.solvd.delivopt.util.pathfinder.graphmodel;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-03
 */
public class NodeDistancePair {
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