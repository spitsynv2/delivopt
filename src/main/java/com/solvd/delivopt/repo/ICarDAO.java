package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Car;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface ICarDAO extends IDAO<Car,Long> {
    List<Car> readAllByCompanyId(Long companyId);
    Car readByDeliveryId(Long deliveryId);
}
