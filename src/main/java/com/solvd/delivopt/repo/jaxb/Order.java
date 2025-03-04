package com.solvd.delivopt.repo.jaxb;

import com.solvd.delivopt.model.Address;
import com.solvd.delivopt.model.OrderedGoods;
import com.solvd.delivopt.model.enums.OrderStatus;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "Order")
public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Long clientId;
    private Address destinationAddress;
    private List<OrderedGoods> orderedGoods;
    private Double totalWeight;
    private Double totalVolume;

    public Order() {}

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @XmlElement
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @XmlElement
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @XmlElement
    public Address getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(Address destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @XmlElement(name = "OrderedGoods")
    public List<OrderedGoods> getOrderedGoods() {
        return orderedGoods;
    }

    public void setOrderedGoods(List<OrderedGoods> orderedGoods) {
        this.orderedGoods = orderedGoods;
    }

    @XmlElement
    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @XmlElement
    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }
}
