package com.solvd.delivopt.model;

import java.time.LocalDateTime;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Route {
    private Long id;
    private Address fromAddress;
    private Address toAddress;
    private Double distanceKm;
    private Integer estimatedTimeMin;
    private LocalDateTime lastUpdated;

    public Route() {}

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getEstimatedTimeMin() {
        return estimatedTimeMin;
    }

    public void setEstimatedTimeMin(Integer estimatedTimeMin) {
        this.estimatedTimeMin = estimatedTimeMin;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Route{" +
                "estimatedTimeMin=" + estimatedTimeMin +
                ", lastUpdated=" + lastUpdated +
                ", distanceKm=" + distanceKm +
                ", toAddress=" + toAddress +
                ", fromAddress=" + fromAddress +
                ", id=" + id +
                '}';
    }
}