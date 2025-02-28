package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.model.enums.DeliveryType;
import com.solvd.delivopt.model.enums.OrderStatus;
import com.solvd.delivopt.repo.impl.mybatis.*;
import com.solvd.delivopt.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        warehouseAddress1.setId(1L);
        warehouseAddress1.setStreet("Mazowiecka 1");
        warehouseAddress1.setCity("Warsaw");
        warehouseAddress1.setPostCode("00-001");
        warehouseAddress1.setLatitude(52.2298);
        warehouseAddress1.setLongitude(21.0122);

        Address warehouseAddress2 = new Address();
        warehouseAddress2.setId(2L);
        warehouseAddress2.setStreet("Karmelicka 18");
        warehouseAddress2.setCity("Krakow");
        warehouseAddress2.setPostCode("30-00");
        warehouseAddress2.setLatitude(50.0651);
        warehouseAddress2.setLongitude(19.9440);

        Address clientAddress1 = new Address();
        clientAddress1.setId(3L);
        clientAddress1.setStreet("Wilanowska 60");
        clientAddress1.setCity("Warsaw");
        clientAddress1.setPostCode("00-040");
        clientAddress1.setLatitude(52.1900);
        clientAddress1.setLongitude(20.9900);

        Address clientAddress2 = new Address();
        clientAddress2.setId(4L);
        clientAddress2.setStreet("Pulawska 30");
        clientAddress2.setCity("Warsaw");
        clientAddress2.setPostCode("00-020");
        clientAddress2.setLatitude(52.2100);
        clientAddress2.setLongitude(21.0005);

        Address clientAddress3 = new Address();
        clientAddress3.setId(5L);
        clientAddress3.setStreet("Saska 45");
        clientAddress3.setCity("Warsaw");
        clientAddress3.setPostCode("00-030");
        clientAddress3.setLatitude(52.2000);
        clientAddress3.setLongitude(20.9950);

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
        graph.addNode(2L, warehouseAddress2);
        graph.addNode(3L, clientAddress1);
        graph.addNode(4L, clientAddress2);
        graph.addNode(5L, clientAddress2);

        List<EdgeDistances> edgeDistances = new ArrayList<>();  // List to store distances for each edge
        addEdgeWithDistance(graph, 1L, 3L, edgeDistances);  // Warehouse 1 to Client 1
        addEdgeWithDistance(graph, 1L, 4L, edgeDistances);  // Warehouse 1 to Client 2
        addEdgeWithDistance(graph, 2L, 3L, edgeDistances);  // Warehouse 2 to Client 1
        addEdgeWithDistance(graph, 2L, 4L, edgeDistances);  // Warehouse 2 to Client 2
        addEdgeWithDistance(graph, 1L, 2L, edgeDistances);  // Warehouse 1 to Warehouse 2

        // Calculate and output shortest paths for all edges
        Map<Long, Double> shortestPathsFromWarehouse1 = Dijkstra.calculateShortestPath(graph, 1L);
        Map<Long, Double> shortestPathsFromWarehouse2 = Dijkstra.calculateShortestPath(graph, 2L);

        System.out.println("\nShortest path from Warehouse 1:");
        printShortestPaths(shortestPathsFromWarehouse1);

        System.out.println("\nShortest path from Warehouse 2:");
        printShortestPaths(shortestPathsFromWarehouse2);

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

    private static void addEdgeWithDistance(Graph graph, Long fromId, Long toId, List<EdgeDistances> edgeDistances) {
        Graph.Node fromNode = graph.getNode(fromId);
        Graph.Node toNode = graph.getNode(toId);

        HarvesineDistance harvesineDistance = new HarvesineDistance();
        double distance = harvesineDistance.calculateDistance(
                fromNode.getAddress().getLatitude(),
                fromNode.getAddress().getLongitude(),
                toNode.getAddress().getLatitude(),
                toNode.getAddress().getLongitude()
        );

        // Store the edge distance in the list
        edgeDistances.add(new EdgeDistances(fromId, toId, distance));

        // Add the edge to both nodes (undirected graph)
        fromNode.addEdge(new Graph.Edge(toNode, distance));
        toNode.addEdge(new Graph.Edge(fromNode, distance));  // Undirected graph (bi-directional)
    }

    // Method to print shortest paths for each node
    private static void printShortestPaths(Map<Long, Double> shortestPaths) {
        for (Map.Entry<Long, Double> entry : shortestPaths.entrySet()) {
            System.out.println("To node " + entry.getKey() + ": " + entry.getValue() + " km");
        }
    }
}
