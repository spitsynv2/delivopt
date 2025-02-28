package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.repo.impl.mybatis.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args ) {
        //AddressMyBatisImpl addressMyBatis = new AddressMyBatisImpl();
        //List<Address> addresses = addressMyBatis.readAll();
        //Address address = addressMyBatis.readById(1L);
        //address.setCity("TEST");
        //addressMyBatis.update(address);
        //addressMyBatis.create(address);
        //addressMyBatis.deleteById(8L);

        //CarMyBatisImpl carMyBatis = new CarMyBatisImpl();
        //List<Car> cars = carMyBatis.readAll();
        //Car car = carMyBatis.readById(1L);
        //car.setCarType("TEST");
        //carMyBatis.update(car);
        //carMyBatis.create(car);
        //carMyBatis.deleteById(4L);
        //carMyBatis.readByDeliveryId(1L);
        //carMyBatis.readAllByCompanyId(1L);

        //ClientMyBatisImpl clientMyBatis = new ClientMyBatisImpl();
        //Client client = clientMyBatis.readById(1L);
        //client.setAddress(addressMyBatis.readByClientId(client.getId()));
        //log.info(client);
        //clientMyBatis.update(client);
        //client.setEmail("TEST@MAIL.COM");
        //clientMyBatis.checkEmailExist("TEST@MAIL.COM");

        //CompanyMyBatisImpl companyMyBatis = new CompanyMyBatisImpl();
        //Company company = companyMyBatis.readById(1L);
        //company.setAddress(addressMyBatis.readByCompanyId(company.getId()));
        //log.info(company);
        //companyMyBatis.update(company);
        //company.setCompanyName("TEST");
        //companyMyBatis.create(company);

        //DeliveryMyBatisImpl deliveryMyBatis = new DeliveryMyBatisImpl();
        //Delivery delivery = deliveryMyBatis.readById(1L);
        //delivery.setCar(carMyBatis.readByDeliveryId(delivery.getId()));
        //deliveryMyBatis.update(delivery);
        //deliveryMyBatis.create(delivery);
        //deliveryMyBatis.readAllByOrderId(1L);
        //deliveryMyBatis.readAllByRouteId(1L);

        //GoodsMyBatisImpl goodsMyBatis = new GoodsMyBatisImpl();
        //goodsMyBatis.readAll();
        //Goods goods = goodsMyBatis.readById(1L);
        //goodsMyBatis.update(goods);
        //goodsMyBatis.create(goods);
        //goodsMyBatis.deleteById(11L);
        //goodsMyBatis.readAllByWarehouseId(1L);
        //goodsMyBatis.createByWarehouseAndGoodsId(1L,4L,3);

        //WarehouseMyBatisImpl warehouseMyBatis = new WarehouseMyBatisImpl();
        //warehouseMyBatis.readAll();
        //warehouseMyBatis.readById(1L);
        //warehouseMyBatis.readAllByGoodsId(1L);
        //warehouseMyBatis.update(warehouseMyBatis.readById(1L));
        //warehouseMyBatis.create(warehouseMyBatis.readById(1L));

        //OrderedGoodsMyBatisImpl orderedGoodsMyBatis = new OrderedGoodsMyBatisImpl();
        //orderedGoodsMyBatis.readAll();
        //OrderedGoods orderedGoods =  orderedGoodsMyBatis.readAllByOrderId(1L).getFirst();
        //orderedGoods.setQuantity(5);
        //orderedGoodsMyBatis.update(7L,orderedGoods);

        //OrderMyBatisImpl orderMyBatis = new OrderMyBatisImpl();
        //orderMyBatis.readAll();
        //orderMyBatis.readAllByClientId(1L);
        //orderMyBatis.readAllByDeliveryId(1L);
        //orderMyBatis.create(orderMyBatis.readById(2L));
        //orderMyBatis.update(orderMyBatis.readById(2L));
        //orderMyBatis.deleteById(1L);

        //RouteMyBatisImpl routeMyBatis = new RouteMyBatisImpl();
        //routeMyBatis.readAll();
    }
}
