package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.repo.impl.mybatis.CarMyBatisImpl;
import com.solvd.delivopt.repo.impl.mybatis.OrderMyBatisImpl;
import com.solvd.delivopt.repo.impl.mybatis.WarehouseMyBatisImpl;
import com.solvd.delivopt.service.DeliveryService;
import com.solvd.delivopt.service.OrderDeliveryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger log = LogManager.getLogger(Runner.class);
    private static final WarehouseMyBatisImpl warehouseMyBatis = new WarehouseMyBatisImpl();
    private static final OrderMyBatisImpl orderMyBatis = new OrderMyBatisImpl();
    private static final CarMyBatisImpl carMyBatis = new CarMyBatisImpl();

    private static final DeliveryService delivService = new DeliveryService();

    public static void main(String[] args) {
        OrderDeliveryService orderDeliveryService = new OrderDeliveryService();
        Warehouse warehouse = warehouseMyBatis.readById(1L);
        List<Order> orders = orderMyBatis.readAllByWarehouseId(warehouse.getId());

        log.info(orders);
        List<Car> cars = carMyBatis.readAll();

        List<Delivery> deliveries = orderDeliveryService.deliverOrdersFromOneWarehouse(warehouse,orders,cars);

        delivService.writeDeliveryToJsonAndXml(deliveries);
    }

}
