package com.solvd.delivopt.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Delivery {
    private Long id;
    private Car car;
    private Route route;
    private LocalDateTime departureTime;
    private LocalDateTime estimatedArrivalTime;
    private LocalDateTime actualArrivalTime;
    private String type;
    private List<Order> orders;

    public Delivery() {}

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getActualArrivalTime() {
        return actualArrivalTime;
    }

    public void setActualArrivalTime(LocalDateTime actualArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
    }

    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", car=" + car +
                ", route=" + route +
                ", departureTime=" + departureTime +
                ", estimatedArrivalTime=" + estimatedArrivalTime +
                ", actualArrivalTime=" + actualArrivalTime +
                ", type='" + type + '\'' +
                ", orders=" + orders +
                '}';
    }
}
