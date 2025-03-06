package com.solvd.delivopt;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.util.pathfinder.NearestNeighborWithDijkstra;
import com.solvd.delivopt.util.pathfinder.graphmodel.Edge;
import com.solvd.delivopt.util.pathfinder.graphmodel.Graph;
import com.solvd.delivopt.util.pathfinder.HarvesineDistance;
import com.solvd.delivopt.util.pathfinder.graphmodel.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        notAllNodesConnectedSimulation();
        allNodesConnectedSimulation();
    }

    public static void addEdgeWithDistance(Graph graph, Long fromId, Long toId) {
        Node fromNode = graph.getNode(fromId);
        Node toNode = graph.getNode(toId);

        double distance = HarvesineDistance.calculateDistance(
                fromNode.getAddress().getLatitude(),
                fromNode.getAddress().getLongitude(),
                toNode.getAddress().getLatitude(),
                toNode.getAddress().getLongitude()
        );

        fromNode.addEdge(new Edge(toNode, distance));
        toNode.addEdge(new Edge(fromNode, distance));
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

        addEdgeWithDistance(graph, 3L, 4L); // Client 2 -> Client 3
        addEdgeWithDistance(graph, 1L, 4L); // Warehouse -> Client 3
        addEdgeWithDistance(graph, 1L, 2L); // Warehouse -> Client 1
        addEdgeWithDistance(graph, 1L, 5L);

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

        addEdgeWithDistance(graph, 1L, 2L); // Warehouse -> Client 1
        addEdgeWithDistance(graph, 1L, 3L); // Warehouse -> Client 2
        addEdgeWithDistance(graph, 1L, 4L); // Warehouse -> Client 3

        addEdgeWithDistance(graph, 2L, 3L); //  Client 1 -> Client 2
        addEdgeWithDistance(graph, 2L, 4L); //  Client 1 -> Client 3

        addEdgeWithDistance(graph, 3L, 4L); //  Client 2 -> Client 3


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
}
