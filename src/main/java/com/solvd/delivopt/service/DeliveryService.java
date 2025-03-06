package com.solvd.delivopt.service;

import com.solvd.delivopt.model.Delivery;
import com.solvd.delivopt.repo.impl.jackson.JacksonDeliveryImpl;
import com.solvd.delivopt.repo.impl.jaxb.JaxbDeliveryImpl;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-06
 */
public class DeliveryService {
    private static final JacksonDeliveryImpl jackson = new JacksonDeliveryImpl();
    private static final JaxbDeliveryImpl jaxb = new JaxbDeliveryImpl();

    public void writeDeliveryToJsonAndXml(List<Delivery> deliveries){
        jackson.writeListToJsonFile(deliveries);
        jaxb.marshalDeliveries(deliveries);
    }
}
