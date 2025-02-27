package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Delivery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IDeliveryDAO extends IDAO<Delivery,Long> {
    List<Delivery> readAllByOrderId(Long orderId);

    void updateOrdersDelivery(@Param("newOrderId") Long newOrderId,
                              @Param("newDeliveryId") Long newDeliveryId,
                              @Param("orderId") Long orderId,
                              @Param("deliveryId") Long deliveryId);

    void createOrdersDelivery(@Param("orderId") Long orderId,
                              @Param("deliveryId") Long deliveryId);

    void deleteOrdersDelivery(@Param("orderId") Long orderId,
                              @Param("deliveryId") Long deliveryId);

    List<Delivery> readAllByRouteId(Long routeId);

    void updateDeliveryRoutes(@Param("newRouteId") Long newRouteId,
                              @Param("newDeliveryId") Long newDeliveryId,
                              @Param("sequence") Integer sequence,
                              @Param("routeId") Long routeId,
                              @Param("deliveryId") Long deliveryId);

    void createDeliveryRoutes(@Param("routeId") Long routeId,
                              @Param("deliveryId") Long deliveryId,
                              @Param("sequence") Integer sequence);

    void deleteDeliveryRoutes(@Param("routeId") Long routeId,
                              @Param("deliveryId") Long deliveryId);
}
