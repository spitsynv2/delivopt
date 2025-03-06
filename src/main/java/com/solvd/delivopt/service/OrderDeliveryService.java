package com.solvd.delivopt.service;

import com.solvd.delivopt.model.Car;
import com.solvd.delivopt.model.Order;
import com.solvd.delivopt.model.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-04
 */
public class OrderDeliveryService {
    private static final Logger log = LogManager.getLogger(OrderDeliveryService.class);

    public void deliverOrders(Warehouse warehouse, List<Order> orders, List<Car> cars){
        //TODO IMPLEMENT WITH CAR CAPACITY
    }

}
