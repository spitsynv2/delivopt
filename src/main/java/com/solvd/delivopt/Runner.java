package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.model.enums.OrderStatus;
import com.solvd.delivopt.repo.impl.jaxb.JaxbDeliveryImpl;
import com.solvd.delivopt.repo.impl.mybatis.DeliveryMyBatisImpl;
import com.solvd.delivopt.repo.impl.jackson.JacksonDeliveryImpl;
import com.solvd.delivopt.service.OrderDeliveryService;
import com.solvd.delivopt.util.pathfinder.NearestNeighborWithDijkstra;
import com.solvd.delivopt.util.pathfinder.graphmodel.Graph;
import com.solvd.delivopt.util.pathfinder.HarvesineDistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Runner {
    private static final Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        notAllNodesConnectedSimulation();
        allNodesConnectedSimulation();
        DeliveryMyBatisImpl deliveryMyBatis = new DeliveryMyBatisImpl();
        List<Delivery> deliveries = deliveryMyBatis.readAll();

        JaxbDeliveryImpl jaxbDelivery = new JaxbDeliveryImpl();
        log.info(jaxbDelivery.marshalDeliveries(deliveries));
        log.info(jaxbDelivery.unmarshalDeliveries());
        JacksonDeliveryImpl jacksonDelivery = new JacksonDeliveryImpl();

        jacksonDelivery.writeListToJsonFile(deliveries);
        log.info(jacksonDelivery.listFromJsonFile());


        Runner runner = new Runner();
        runner.setupLogger();

        // Run the tests and log results
        runner.testSuccessfulAssignment();
        runner.testReallocationWhenNoCarAvailable();
        runner.testNoAvailableCar();
    }
    
    public static void notAllNodesConnectedSimulation(){
        log.info("notAllNodesConnectedSimulation");
        Graph graph = new Graph();

        Address warehouse = new Address();
        warehouse.setId(1L);
        warehouse.setStreet("Warehouse");
        warehouse.setCity("City");
        warehouse.setPostCode("00001");
        warehouse.setLatitude(52.2298);
        warehouse.setLongitude(21.0122);

        Address client1 = new Address();
        client1.setId(2L);
        client1.setStreet("Client 1");
        client1.setCity("City");
        client1.setPostCode("00002");
        client1.setLatitude(52.1900);
        client1.setLongitude(20.9900);

        Address client2 = new Address();
        client2.setId(3L);
        client2.setStreet("Client 2");
        client2.setCity("City");
        client2.setPostCode("00003");
        client2.setLatitude(52.2100);
        client2.setLongitude(21.0007);

        Address client3 = new Address();
        client3.setId(4L);
        client3.setStreet("Client 3");
        client3.setCity("City");
        client3.setPostCode("00004");
        client3.setLatitude(52.2100);
        client3.setLongitude(21.0008);

        Address client4 = new Address();
        client4.setId(5L);
        client4.setStreet("Client 4");
        client4.setCity("City");
        client4.setPostCode("00004");
        client4.setLatitude(52.2100);
        client4.setLongitude(25.0008);

        graph.addNode(1L, warehouse);
        graph.addNode(2L, client1);
        graph.addNode(3L, client2);
        graph.addNode(4L, client3);
        graph.addNode(5L, client4);

        graph.addEdgeWithDistance(3L, 4L); // Client 2 -> Client 3
        graph.addEdgeWithDistance(1L, 4L); // Warehouse -> Client 3
        graph.addEdgeWithDistance(1L, 2L); // Warehouse -> Client 1
        graph.addEdgeWithDistance(1L, 5L); // Warehouse -> Client 4

        double distance1_4 = HarvesineDistance.calculateDistance(
                graph.getNode(1L).getAddress().getLatitude(),
                graph.getNode(1L).getAddress().getLongitude(),
                graph.getNode(4L).getAddress().getLatitude(),
                graph.getNode(4L).getAddress().getLongitude()
        );

        double distance4_3 = HarvesineDistance.calculateDistance(
                graph.getNode(4L).getAddress().getLatitude(),
                graph.getNode(4L).getAddress().getLongitude(),
                graph.getNode(3L).getAddress().getLatitude(),
                graph.getNode(3L).getAddress().getLongitude()
        );

        double distance1_2 = HarvesineDistance.calculateDistance(
                graph.getNode(1L).getAddress().getLatitude(),
                graph.getNode(1L).getAddress().getLongitude(),
                graph.getNode(2L).getAddress().getLatitude(),
                graph.getNode(2L).getAddress().getLongitude()
        );

        double distance1_5 = HarvesineDistance.calculateDistance(
                graph.getNode(1L).getAddress().getLatitude(),
                graph.getNode(1L).getAddress().getLongitude(),
                graph.getNode(5L).getAddress().getLatitude(),
                graph.getNode(5L).getAddress().getLongitude()
        );

        log.info("Optimal Delivery Route notAllNodesConnectedSimulation: {}", NearestNeighborWithDijkstra.findOptimalRoute(graph, 1L));
        log.info(distance1_4);
        log.info(distance4_3);
        log.info(distance4_3 + distance1_4 + distance1_2 );
        log.info(distance1_2+distance1_5);

        //if nodes not connected directly, the distance is distance to return to connected node
        // + distance from that node to target node
    }

    public static void allNodesConnectedSimulation(){
        log.info("allNodesConnectedSimulation");
        Graph graph = new Graph();

        Address warehouse = new Address();
        warehouse.setId(1L);
        warehouse.setStreet("Warehouse");
        warehouse.setCity("City");
        warehouse.setPostCode("00001");
        warehouse.setLatitude(52.2298);
        warehouse.setLongitude(21.0122);

        Address client1 = new Address();
        client1.setId(2L);
        client1.setStreet("Client 1");
        client1.setCity("City");
        client1.setPostCode("00002");
        client1.setLatitude(52.1900);
        client1.setLongitude(20.9900);

        Address client2 = new Address();
        client2.setId(3L);
        client2.setStreet("Client 2");
        client2.setCity("City");
        client2.setPostCode("00003");
        client2.setLatitude(52.2100);
        client2.setLongitude(21.0007);

        Address client3 = new Address();
        client3.setId(4L);
        client3.setStreet("Client 3");
        client3.setCity("City");
        client3.setPostCode("00004");
        client3.setLatitude(52.2100);
        client3.setLongitude(21.0008);

        graph.addNode(1L, warehouse);
        graph.addNode(2L, client1);
        graph.addNode(3L, client2);
        graph.addNode(4L, client3);

        graph.addEdgeWithDistance(1L, 2L); // Warehouse -> Client 1
        graph.addEdgeWithDistance(1L, 3L); // Warehouse -> Client 2
        graph.addEdgeWithDistance(1L, 4L); // Warehouse -> Client 3

        graph.addEdgeWithDistance(2L, 3L); //  Client 1 -> Client 2
        graph.addEdgeWithDistance(2L, 4L); //  Client 1 -> Client 3

        graph.addEdgeWithDistance(3L, 4L); //  Client 2 -> Client 3


        double distance1_2 = HarvesineDistance.calculateDistance(
                graph.getNode(1L).getAddress().getLatitude(),
                graph.getNode(1L).getAddress().getLongitude(),
                graph.getNode(2L).getAddress().getLatitude(),
                graph.getNode(2L).getAddress().getLongitude()
        );

        double distance1_3 = HarvesineDistance.calculateDistance(
                graph.getNode(1L).getAddress().getLatitude(),
                graph.getNode(1L).getAddress().getLongitude(),
                graph.getNode(3L).getAddress().getLatitude(),
                graph.getNode(3L).getAddress().getLongitude()
        );

        double distance1_4 = HarvesineDistance.calculateDistance(
                graph.getNode(1L).getAddress().getLatitude(),
                graph.getNode(1L).getAddress().getLongitude(),
                graph.getNode(4L).getAddress().getLatitude(),
                graph.getNode(4L).getAddress().getLongitude()
        );

        double distance4_3 = HarvesineDistance.calculateDistance(
                graph.getNode(4L).getAddress().getLatitude(),
                graph.getNode(4L).getAddress().getLongitude(),
                graph.getNode(3L).getAddress().getLatitude(),
                graph.getNode(3L).getAddress().getLongitude()
        );

        double distance3_2 = HarvesineDistance.calculateDistance(
                graph.getNode(3L).getAddress().getLatitude(),
                graph.getNode(3L).getAddress().getLongitude(),
                graph.getNode(2L).getAddress().getLatitude(),
                graph.getNode(2L).getAddress().getLongitude()
        );

        log.info("Optimal Delivery Route allNodesConnectedSimulation: {}", NearestNeighborWithDijkstra.findOptimalRoute(graph, 1L));
        log.info(distance1_2);
        log.info(distance1_3);
        log.info(distance1_4);
        log.info(distance4_3);
        log.info(distance3_2);
    }

    // Test method 1: Test successful assignment of orders to cars
    public void testSuccessfulAssignment() {
        log.info("Running test: testSuccessfulAssignment");

        Warehouse warehouse = new Warehouse();
        List<Order> orders = createOrders();
        List<Car> cars = createCars();

        OrderDeliveryService deliverOrdersService = new OrderDeliveryService();
        deliverOrdersService.deliverOrders(warehouse, orders, cars);

        // Check if the first order was assigned correctly
        Order order1 = orders.get(0);
        Car car1 = cars.get(0);
        if (order1.getStatus() == OrderStatus.DELIVERED) {
            log.info("Test Passed: Order " + order1.getId() + " delivered successfully.");
        } else {
            log.warn("Test Failed: Order " + order1.getId() + " was not delivered.");
        }

        // Log remaining capacities for car1
        log.info("Remaining capacity of Car " + car1.getId() + " (Weight: " + car1.getMaxWeightCapacity() + ", Volume: " + car1.getMaxVolumeCapacity() + ")");
    }

    // Test method 2: Test reallocation when no car is available for the order
    public void testReallocationWhenNoCarAvailable() {
        log.info("Running test: testReallocationWhenNoCarAvailable");

        Warehouse warehouse = new Warehouse();
        List<Order> orders = createOrders();
        List<Car> cars = createCars();

        // Modify car2's capacity to simulate it cannot deliver the first order
        cars.get(1).setMaxWeightCapacity(50.0);
        cars.get(1).setMaxVolumeCapacity(20.0);

        OrderDeliveryService deliverOrdersService = new OrderDeliveryService();
        deliverOrdersService.deliverOrders(warehouse, orders, cars);

        // Check if the first order was reallocated to car2
        Order order1 = orders.get(0);
        Car car2 = cars.get(1);
        if (order1.getStatus() == OrderStatus.DELIVERED) {
            log.info("Test Passed: Order " + order1.getId() + " reallocated to Car " + car2.getId() + " successfully.");
        } else {
            log.warn("Test Failed: Order " + order1.getId() + " was not delivered or reallocated.");
        }

        // Log remaining capacities for car2
        log.info("Remaining capacity of Car " + car2.getId() + " (Weight: " + car2.getMaxWeightCapacity() + ", Volume: " + car2.getMaxVolumeCapacity() + ")");
    }

    // Test method 3: Test when no car is available to deliver an order
    public void testNoAvailableCar() {
        log.info("Running test: testNoAvailableCar");

        List<Order> orders = createOrders();
        List<Car> cars = createCars();

        // Set both cars to have insufficient capacity to handle any orders
        // Adjusted capacities to ensure neither car can handle the orders
        cars.get(0).setMaxWeightCapacity(10.0);  // Too small for the orders
        cars.get(0).setMaxVolumeCapacity(5.0);   // Too small for the orders
        cars.get(1).setMaxWeightCapacity(10.0);  // Too small for the orders
        cars.get(1).setMaxVolumeCapacity(5.0);   // Too small for the orders

        Warehouse warehouse = new Warehouse();

        OrderDeliveryService deliverOrdersService = new OrderDeliveryService();
        deliverOrdersService.deliverOrders(warehouse, orders, cars);

        // Ensure no order is delivered
        boolean allOrdersPending = true;
        for (Order order : orders) {
            if (order.getStatus() != OrderStatus.PENDING) {
                allOrdersPending = false;
                log.warn("Test Failed: Order " + order.getId() + " was unexpectedly delivered.");
            }
        }

        if (allOrdersPending) {
            log.info("Test Passed: All orders remain pending due to no available car.");
        }
    }

    // Helper method to create orders
    private List<Order> createOrders() {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order();
        order1.setId(1L);
        order1.setTotalWeight(80.0);
        order1.setTotalVolume(40.0);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setTotalWeight(120.0);
        order2.setTotalVolume(60.0);

        orders.add(order1);
        orders.add(order2);

        return orders;
    }

    // Helper method to create cars
    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car();
        car1.setId(1L);
        car1.setMaxWeightCapacity(100.0);
        car1.setMaxVolumeCapacity(50.0);

        Car car2 = new Car();
        car2.setId(2L);
        car2.setMaxWeightCapacity(150.0);
        car2.setMaxVolumeCapacity(75.0);

        cars.add(car1);
        cars.add(car2);

        return cars;
    }

    private void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("delivery_test_log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            log.atFatal();
            log.info("Test Log Started");
        } catch (IOException e) {
            System.out.println("Error setting up the logger: " + e.getMessage());
        }
    }
}
