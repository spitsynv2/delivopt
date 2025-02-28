package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.model.enums.DeliveryType;
import com.solvd.delivopt.model.enums.OrderStatus;
import com.solvd.delivopt.repo.impl.mybatis.*;
import com.solvd.delivopt.util.DeliveryMapper;
import com.solvd.delivopt.util.Graph;
import com.solvd.delivopt.util.Dijkstra;
import com.solvd.delivopt.util.HarvesineDistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;


public class Runner {
    private static final Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args ) throws Exception{
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

        OrderMyBatisImpl orderMyBatis = new OrderMyBatisImpl();
        orderMyBatis.readAll();
        //orderMyBatis.readAllByClientId(1L);
        //orderMyBatis.readAllByDeliveryId(1L);
        //orderMyBatis.create(orderMyBatis.readById(2L));
        //orderMyBatis.update(orderMyBatis.readById(2L));
        //orderMyBatis.deleteById(1L);

        //RouteMyBatisImpl routeMyBatis = new RouteMyBatisImpl();
        //routeMyBatis.readAll();

        Graph graph = new Graph();

        // Add nodes (addresses)
        Address warehouseAddress1 = new Address();
        Address clientAddress1 = new Address();

        warehouseAddress1.setId(1L);
        warehouseAddress1.setStreet("Mazowiecka 1");
        warehouseAddress1.setCity("Warsaw");
        warehouseAddress1.setPostCode("00-001");
        warehouseAddress1.setLatitude(52.2298);
        warehouseAddress1.setLongitude(21.0122);

        clientAddress1.setId(2L);
        clientAddress1.setStreet("Pilsudskiego 15");
        clientAddress1.setCity("Warsaw");
        clientAddress1.setPostCode("00-010");
        clientAddress1.setLatitude(52.2200);
        clientAddress1.setLongitude(21.0050);

        Address clientAddress2 = new Address();
        clientAddress2.setId(3L);
        clientAddress2.setStreet("Pulawska 30");
        clientAddress2.setCity("Warsaw");
        clientAddress2.setPostCode("00-020");
        clientAddress2.setLatitude(52.2100);
        clientAddress2.setLongitude(21.0005);

        Address clientAddress3 = new Address();
        clientAddress3.setId(4L);
        clientAddress3.setStreet("Saska 45");
        clientAddress3.setCity("Warsaw");
        clientAddress3.setPostCode("00-030");
        clientAddress3.setLatitude(52.2000);
        clientAddress3.setLongitude(20.9950);

        // Create Clients based on SQL data
        Client client1 = new Client();
        client1.setId(1L);
        client1.setClientName("Jan Kowalski");
        client1.setEmail("jan.kowalski@example.com");
        client1.setPhoneNumber("+48 600 700 800");
        client1.setAddress(clientAddress1);

        Client client2 = new Client();
        client2.setId(2L);
        client2.setClientName("Anna Nowak");
        client2.setEmail("anna.nowak@example.com");
        client2.setPhoneNumber("+48 601 702 803");
        client2.setAddress(clientAddress2);

        Client client3 = new Client();
        client3.setId(3L);
        client3.setClientName("Piotr Zielinski");
        client3.setEmail("piotr.zielinski@example.com");
        client3.setPhoneNumber("+48 602 703 804");
        client3.setAddress(clientAddress3);

        graph.addNode(1L, warehouseAddress1);
        graph.addNode(2L, clientAddress1);

        HarvesineDistance harvesineDistance = new HarvesineDistance();

        double distance = harvesineDistance.calculateDistance(
                warehouseAddress1.getLatitude(), warehouseAddress1.getLongitude(),
                clientAddress1.getLatitude(), clientAddress1.getLongitude()
        );
        System.out.println("Distance between warehouse and client: " + distance + " km");

        // Add edges (routes between warehouse and client)
        graph.addEdge(1L, 2L, distance);

        // Use Dijkstra to find shortest path from warehouse (1) to client (2)
        Map<Long, Double> shortestPaths = Dijkstra.calculateShortestPath(graph, 1L);

        System.out.println("Shortest path from Warehouse to Client: " + shortestPaths.get(2L) + " km");

        // Use Dijkstra to find shortest path from client (2) to warehouse (1)
        Map<Long, Double> reverseShortestPaths = Dijkstra.calculateShortestPath(graph, 2L);

        System.out.println("Shortest path from Client to Warehouse: " + reverseShortestPaths.get(1L) + " km");

        Car car = new Car();
        car.setId(1L);
        car.setCarType("Truck");
        car.setMaxWeightCapacity(2000.0);
        car.setMaxVolumeCapacity(15.0);
        car.setOwnerCompanyId(1L);

        Order order1 = createOrder(client1, clientAddress1, 1L);
        Order order2 = createOrder(client2, clientAddress2, 2L);
        Order order3 = createOrder(client3, clientAddress3, 3L);

        // Create Routes for the delivery
        Route route1 = createRoute(warehouseAddress1, clientAddress1);
        Route route2 = createRoute(warehouseAddress1, clientAddress2);
        Route route3 = createRoute(warehouseAddress1, clientAddress3);

        // Create Delivery for the delivery
        Delivery delivery = new Delivery();
        delivery.setId(1L);
        delivery.setDepartureTime(LocalDateTime.now());
        delivery.setEstimatedArrivalTime(LocalDateTime.now().plusHours(2));
        delivery.setType(DeliveryType.WAREHOUSE_TO_CLIENT);
        delivery.setCar(car);
        delivery.setOrders(Arrays.asList(order1, order2, order3));
        delivery.setRoutes(Arrays.asList(route1, route2, route3));

        // Set total weight and total volume for the orders
        setTotalWeightAndVolume(order1);
        setTotalWeightAndVolume(order2);
        setTotalWeightAndVolume(order3);

        System.out.println(delivery);

        // Serialize to JSON
        String json = DeliveryMapper.toJson(delivery);
        System.out.println("Serialized JSON: " + json);

        // Deserialize from JSON
        Delivery deserializedDelivery = DeliveryMapper.fromJson(json);
        System.out.println("Deserialized Delivery: " + deserializedDelivery);

        try {
            DeliveryMapper.writeJsonToFile(deserializedDelivery, "output_delivery.json");
        } catch (IOException e) {
            System.err.println("Error writing JSON to file: " + e.getMessage());
        }




    }

    private static Order createOrder(Client client, Address destinationAddress, Long orderId) {
        Order order = new Order();
        order.setId(orderId);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setClientId(client.getId());
        order.setDestinationAddress(destinationAddress);

        // Create Goods for the ordered goods
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setGoodsName("Electronics");
        goods.setDescription("Various electronic items");
        goods.setWeight(10.0);
        goods.setVolume(5.0);

        OrderedGoods orderedGoods = new OrderedGoods();
        orderedGoods.setWarehouseId(1L);
        orderedGoods.setGoods(goods);
        orderedGoods.setQuantity(2);

        order.setOrderedGoods(Arrays.asList(orderedGoods));
        return order;
    }

    // Helper method to create routes
    private static Route createRoute(Address fromAddress, Address toAddress) {
        Route route = new Route();
        route.setId(1L);
        route.setFromAddress(fromAddress);
        route.setToAddress(toAddress);
        route.setDistanceKm(5.0);
        route.setEstimatedTimeMin(30);
        route.setLastUpdated(LocalDateTime.now());
        return route;
    }

    // Helper method to set total weight and volume
    private static void setTotalWeightAndVolume(Order order) {
        double totalWeight = order.getTotalWeight();
        double totalVolume = order.getTotalVolume();
        order.setTotalWeight(totalWeight);
        order.setTotalVolume(totalVolume);
    }
}
