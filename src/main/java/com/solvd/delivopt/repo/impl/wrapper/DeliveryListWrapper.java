package com.solvd.delivopt.repo.impl.wrapper;

import com.solvd.delivopt.model.Delivery;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-04
 */


@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryListWrapper {

    @XmlElement(name = "delivery")
    private List<Delivery> deliveries;

    public DeliveryListWrapper() {}

    public DeliveryListWrapper(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}