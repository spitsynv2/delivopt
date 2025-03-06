package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Order;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IOrderDAO extends IDAO<Order,Long> {
    List<Order> readAllByClientId(Long clientId);
    List<Order> readAllByDeliveryId(Long deliveryId);
    List<Order> readAllByWarehouseId(Long warehouseId);
}
