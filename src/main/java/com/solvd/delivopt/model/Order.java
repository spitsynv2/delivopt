package com.solvd.delivopt.model;

import com.solvd.delivopt.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Long clientId;
    private Address destinationAddress;
    //LIMITATION --> all orderedGoods must be from same warehouse.
    private List<OrderedGoods> orderedGoods;
    private Double totalWeight;
    private Double totalVolume;

    public Order() {}

    public List<OrderedGoods> getOrderedGoods() {
        return orderedGoods;
    }

    public void setOrderedGoods(List<OrderedGoods> orderedGoods) {
        this.orderedGoods = orderedGoods;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalWeight() {
        if (totalWeight == null){
            totalWeight = calcTotalWeight();
        }
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalVolume() {
        if (totalVolume == null){
            totalVolume = calcTotalVolume();
        }
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double calcTotalWeight(){
        double ordersWeight = 0;
        for (OrderedGoods orderedGood : orderedGoods) {
            if (orderedGood.getGoods().getWeight() != null && orderedGood.getQuantity() != null) {
                ordersWeight = ordersWeight + orderedGood.getGoods().getWeight() * orderedGood.getQuantity();
            }
        }
        return ordersWeight;
    }

    public Double calcTotalVolume(){
        double ordersVolume = 0;
        for (OrderedGoods orderedGood : orderedGoods) {
            if (orderedGood.getGoods().getVolume() != null && orderedGood.getQuantity() != null) {
                ordersVolume = ordersVolume + orderedGood.getGoods().getVolume() * orderedGood.getQuantity();
            }
        }
        return ordersVolume;
    }

    public void setTotalWeightAndVolume() {
        double totalWeight = this.getTotalWeight();
        double totalVolume = this.getTotalVolume();
        this.setTotalWeight(totalWeight);
        this.setTotalVolume(totalVolume);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", clientId='" + clientId + '\'' +
                ", destinationAddress=" + destinationAddress +
                ", orderedGoods=" + orderedGoods +
                ", totalWeight=" + totalWeight +
                ", totalVolume=" + totalVolume +
                '}';
    }
}