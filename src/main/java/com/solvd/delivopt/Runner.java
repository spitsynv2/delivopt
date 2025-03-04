package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.repo.impl.jaxb.JaxbDeliveryImpl;
import com.solvd.delivopt.repo.impl.mybatis.DeliveryMyBatisImpl;
import com.solvd.delivopt.repo.impl.jackson.JacksonDeliveryImpl;
import com.solvd.delivopt.util.pathfinder.NearestNeighborWithDijkstra;
import com.solvd.delivopt.util.pathfinder.graphmodel.Graph;
import com.solvd.delivopt.util.pathfinder.HarvesineDistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

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
        log.info(distance1_4);
        log.info(distance4_3);
        log.info(distance3_2);
    }
}
