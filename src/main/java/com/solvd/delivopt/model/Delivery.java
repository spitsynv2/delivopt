package com.solvd.delivopt.model;

import com.solvd.delivopt.model.enums.DeliveryType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Delivery {
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime estimatedArrivalTime;
    private DeliveryType type;
    private Car car;
    private List<Order> orders;
    private List<Route> routes;

    public Delivery() {}

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public DeliveryType getType() {
        return type;
    }

    public void setType(DeliveryType type) {
        this.type = type;
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

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
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
                ", departureTime=" + departureTime +
                ", estimatedArrivalTime=" + estimatedArrivalTime +
                ", type=" + type +
                ", car=" + car +
                ", orders=" + orders +
                ", routes=" + routes +
                '}';
    }
}
