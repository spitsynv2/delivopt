package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Route;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IRouteDAO extends IDAO<Route,Long> {
    List<Route> readAllByDeliveryId(Long deliveryId);
}
