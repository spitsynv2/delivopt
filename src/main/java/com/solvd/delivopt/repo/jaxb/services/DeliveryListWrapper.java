package com.solvd.delivopt.repo.jaxb.services;

import com.solvd.delivopt.repo.jaxb.Delivery;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Deliveries")
public class DeliveryListWrapper {

    private List<Delivery> deliveries;

    @XmlElement(name = "Delivery")
    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
