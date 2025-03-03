package com.solvd.delivopt.repo.jaxb;

import com.solvd.delivopt.model.Car;
import com.solvd.delivopt.model.Order;
import com.solvd.delivopt.model.Route;

import com.solvd.delivopt.model.enums.DeliveryType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "Delivery")
public class Delivery {
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime estimatedArrivalTime;
    private DeliveryType type;
    private Car car;
    private List<Order> orders;
    private List<Route> routes;

    public Delivery() {}

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @XmlElement
    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    @XmlElement
    public DeliveryType getType() {
        return type;
    }

    public void setType(DeliveryType type) {
        this.type = type;
    }

    @XmlElement
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @XmlElement(name = "Order")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @XmlElement(name = "Route")
    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
