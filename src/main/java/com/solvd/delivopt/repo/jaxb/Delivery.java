package com.solvd.delivopt.repo.jaxb;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Delivery")
public class Delivery {

    private Long id;
    private String departureTime;
    private String estimatedArrivalTime;
    private String type;
    private List<OrdersDelivery> ordersDeliveries;
    private List<DeliveryRoute> deliveryRoutes;

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @XmlElement
    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "OrdersDelivery")
    public List<OrdersDelivery> getOrdersDeliveries() {
        return ordersDeliveries;
    }

    public void setOrdersDeliveries(List<OrdersDelivery> ordersDeliveries) {
        this.ordersDeliveries = ordersDeliveries;
    }

    @XmlElement(name = "DeliveryRoute")
    public List<DeliveryRoute> getDeliveryRoutes() {
        return deliveryRoutes;
    }

    public void setDeliveryRoutes(List<DeliveryRoute> deliveryRoutes) {
        this.deliveryRoutes = deliveryRoutes;
    }
}

