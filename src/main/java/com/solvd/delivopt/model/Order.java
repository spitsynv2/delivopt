package com.solvd.delivopt.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Order {
    private Long id;
    private Client client;
    private Address destinationAddress;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderedGoods> orderedGoods;

    public Order() {}

    public List<OrderedGoods> getOrderedGoods() {
        return orderedGoods;
    }

    public void setOrderedGoods(List<OrderedGoods> orderedGoods) {
        this.orderedGoods = orderedGoods;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Address getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(Address destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderedGoods=" + orderedGoods +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", destinationAddress=" + destinationAddress +
                ", client=" + client +
                ", id=" + id +
                '}';
    }
}