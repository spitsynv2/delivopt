package com.solvd.delivopt.service;

import com.solvd.delivopt.model.Car;
import com.solvd.delivopt.model.Order;
import com.solvd.delivopt.model.Warehouse;
import com.solvd.delivopt.model.enums.OrderStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-04
 */
public class OrderDeliveryService {
    private static final Logger log = LogManager.getLogger(OrderDeliveryService.class);

    public void deliverOrders(Warehouse warehouse, List<Order> orders, List<Car> cars) {
        try (FileWriter logFile = new FileWriter("delivery_log.txt", true)) {

            for (Order order : orders) {
                boolean assigned = false;

                for (Car car : cars) {
                    if (car.getMaxWeightCapacity() >= order.getTotalWeight() &&
                            car.getMaxVolumeCapacity() >= order.getTotalVolume()) {

                        logFile.write("Order " + order.getId() + " assigned to Car " + car.getId() + "\n");

                        car.setMaxWeightCapacity(car.getMaxWeightCapacity() - order.getTotalWeight());
                        car.setMaxVolumeCapacity(car.getMaxVolumeCapacity() - order.getTotalVolume());

                        order.setStatus(OrderStatus.DELIVERED);

                        System.out.println("Delivery for Order " + order.getId() + " is complete. Status: DELIVERED");

                        assigned = true;
                        break;
                    }
                }

                // If no car can deliver the order, try reallocation
                if (!assigned) {
                    order.setStatus(OrderStatus.PENDING);
                }

                // If no car could deliver the order after all reallocations, log the issue
                if (!assigned) {
                    logFile.write("No available car for Order " + order.getId() + "\n");
                    System.out.println("No available car for Order " + order.getId());
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing to the log file: " + e.getMessage());
        }
    }

}
