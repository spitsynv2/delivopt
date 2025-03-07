package com.solvd.delivopt.model.graphmodel;

public class EdgeDistances {
    private Long fromNodeId;
    private Long toNodeId;
    private double distance;

    public EdgeDistances(Long fromNodeId, Long toNodeId, double distance) {
        this.fromNodeId = fromNodeId;
        this.toNodeId = toNodeId;
        this.distance = distance;
    }

    public Long getFromNodeId() {
        return fromNodeId;
    }

    public Long getToNodeId() {
        return toNodeId;
    }

    public double getDistance() {
        return distance;
    }
}
