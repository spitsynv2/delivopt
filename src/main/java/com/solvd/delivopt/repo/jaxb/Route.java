package com.solvd.delivopt.repo.jaxb;

import com.solvd.delivopt.model.Address;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name = "Route")
public class Route {
    private Long id;
    private Address fromAddress;
    private Address toAddress;
    private Double distanceKm;
    private Integer estimatedTimeMin;
    private LocalDateTime lastUpdated;

    public Route() {}

    @XmlElement
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @XmlElement
    public Integer getEstimatedTimeMin() {
        return estimatedTimeMin;
    }

    public void setEstimatedTimeMin(Integer estimatedTimeMin) {
        this.estimatedTimeMin = estimatedTimeMin;
    }

    @XmlElement
    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    @XmlElement
    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    @XmlElement
    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}