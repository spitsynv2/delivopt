package com.solvd.delivopt.service;

import com.solvd.delivopt.model.*;
import com.solvd.delivopt.model.enums.DeliveryType;
import com.solvd.delivopt.repo.impl.mybatis.DeliveryMyBatisImpl;
import com.solvd.delivopt.repo.impl.mybatis.RouteMyBatisImpl;
import com.solvd.delivopt.util.pathfinder.NearestNeighborWithDijkstra;
import com.solvd.delivopt.model.graphmodel.Edge;
import com.solvd.delivopt.model.graphmodel.Graph;
import com.solvd.delivopt.model.graphmodel.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-04
 */
public class OrderDeliveryService {
    private static Long lastGeneratedDeliveryId = null;
    private static Long lastGeneratedRouteId = null;

    private static final DeliveryMyBatisImpl delimpl = new DeliveryMyBatisImpl();
    private static final RouteMyBatisImpl routeimpl = new RouteMyBatisImpl();
    private static final Logger log = LogManager.getLogger(OrderDeliveryService.class);

    public List<Delivery> deliverOrdersFromOneWarehouse(Warehouse warehouse, List<Order> orders, List<Car> cars) {
        List<Delivery> deliveries = new ArrayList<>();

        Map<Long, List<Order>> clientOrdersMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getClientId));

        Map<Long, Double> clientTotalWeight = new HashMap<>();
        Map<Long, Double> clientTotalVolume = new HashMap<>();

        for (Map.Entry<Long, List<Order>> entry : clientOrdersMap.entrySet()) {
            Long clientId = entry.getKey();
            List<Order> clientOrders = entry.getValue();

            double totalWeight = clientOrders.stream().mapToDouble(Order::getTotalWeight).sum();
            double totalVolume = clientOrders.stream().mapToDouble(Order::getTotalVolume).sum();
            clientTotalWeight.put(clientId, totalWeight);
            clientTotalVolume.put(clientId, totalVolume);
        }

        Map<Car, List<Long>> carAssignments = new HashMap<>();
        List<Long> remainingClients = new ArrayList<>(clientOrdersMap.keySet());

        for (Car car : cars) {
            double remainingWeight = car.getMaxWeightCapacity();
            double remainingVolume = car.getMaxVolumeCapacity();
            List<Long> assignedClients = new ArrayList<>();

            Iterator<Long> iterator = remainingClients.iterator();
            while (iterator.hasNext()) {
                Long clientId = iterator.next();
                double clientWeight = clientTotalWeight.get(clientId);
                double clientVolume = clientTotalVolume.get(clientId);

                if (clientWeight <= remainingWeight && clientVolume <= remainingVolume) {
                    assignedClients.add(clientId);
                    remainingWeight -= clientWeight;
                    remainingVolume -= clientVolume;
                    iterator.remove();
                } else {
                    if (clientWeight > remainingWeight) {
                        log.warn("Client ID: {}'s order exceeds the remaining weight capacity of car ID: {}. Client weight: {}, Remaining car weight capacity: {}.",
                                clientId, car.getId(), clientWeight, remainingWeight);
                    }
                    if (clientVolume > remainingVolume) {
                        log.warn("Client ID: {}'s order exceeds the remaining volume capacity of car ID: {}. Client volume: {}, Remaining car volume capacity: {}.",
                                clientId, car.getId(), clientVolume, remainingVolume);
                    }
                }
            }

            carAssignments.put(car, assignedClients);
        }

        for (Map.Entry<Car, List<Long>> entry : carAssignments.entrySet()) {
            Car car = entry.getKey();
            List<Long> assignedClientIds = entry.getValue();

            if (assignedClientIds.isEmpty()) {
                log.info("Car ID: {} has no assigned orders.", car.getId());
                continue;
            }

            Graph carGraph = new Graph();
            Long warehouseStartId = warehouse.getWarehouseAddress().getId();
            carGraph.addNode(warehouseStartId, warehouse.getWarehouseAddress());

            for (Long clientId : assignedClientIds) {
                Address clientAddress = clientOrdersMap.get(clientId).get(0).getDestinationAddress();
                carGraph.addNode(clientAddress.getId(), clientAddress);
            }

            List<Long> allNodes = new ArrayList<>(carGraph.getNodes().stream().map(Node::getId).collect(Collectors.toList()));
            for (int i = 0; i < allNodes.size(); i++) {
                for (int j = i + 1; j < allNodes.size(); j++) {
                    carGraph.addEdgeWithDistance(allNodes.get(i), allNodes.get(j));
                }
            }

            List<Long> optimalRouteForCar = NearestNeighborWithDijkstra.findOptimalRoute(carGraph, warehouseStartId);
            if (optimalRouteForCar.isEmpty()) {
                log.warn("No valid delivery route found for car ID: {}", car.getId());
                continue;
            }

            List<Route> routes = generateRoutesFromEdges(optimalRouteForCar, carGraph);

            List<Order> assignedOrders = new ArrayList<>();
            for (Long clientId : assignedClientIds) {
                List<Order> clientOrders = clientOrdersMap.get(clientId);
                if (clientOrders != null) {
                    assignedOrders.addAll(clientOrders);
                }
            }

            Delivery delivery = new Delivery();
            delivery.setId(generateDeliveryId());
            delivery.setCar(car);
            delivery.setType(DeliveryType.WAREHOUSE_TO_CLIENT);
            delivery.setOrders(assignedOrders);
            delivery.setRoutes(routes);
            delivery.setDepartureTime(LocalDateTime.now());
            delivery.setEstimatedArrivalTime(calculateEstimatedArrivalTime(routes));

            deliveries.add(delivery);
        }

        if (!remainingClients.isEmpty()) {
            log.warn("Some clients' orders couldn't be assigned due to capacity constraints.");
        }

        return deliveries;
    }

    private List<Route> generateRoutesFromEdges(List<Long> optimalRoute, Graph graph) {
        List<Route> routes = new ArrayList<>();
        for (int i = 0; i < optimalRoute.size() - 1; i++) {
            Long fromId = optimalRoute.get(i);
            Long toId = optimalRoute.get(i + 1);

            Node fromNode = graph.getNode(fromId);
            Node toNode = graph.getNode(toId);
            double distance = getDistanceBetweenNodes(fromNode, toNode);

            Route route = new Route();
            route.setId(generateRouteId());
            route.setFromAddress(fromNode.getAddress());
            route.setToAddress(toNode.getAddress());
            route.setDistanceKm(distance);
            route.setEstimatedTimeMin(calculateEstimatedTime(distance));
            route.setLastUpdated(LocalDateTime.now());

            routes.add(route);
        }

        return routes;
    }

    private double getDistanceBetweenNodes(Node fromNode, Node toNode) {
        for (Edge edge : fromNode.getEdges()) {
            if (edge.getDestination().equals(toNode)) {
                return edge.getDistance();
            }
        }
        return 0.0;
    }

    private int calculateEstimatedTime(double distance) {
        double speedInKmPerMin = 0.8;

        int estimatedTime = (int) (distance / speedInKmPerMin);

        if (estimatedTime < 1 && distance > 0) {
            estimatedTime = 1;
        }

        return estimatedTime;
    }

    private Long generateDeliveryId() {
        if (lastGeneratedDeliveryId == null) {
            lastGeneratedDeliveryId = delimpl.getLastId();
        } else {
            lastGeneratedDeliveryId++;
        }
        return lastGeneratedDeliveryId;
    }

    private Long generateRouteId() {
        if (lastGeneratedRouteId == null) {
            lastGeneratedRouteId = routeimpl.getLastId();
        } else {
            lastGeneratedRouteId++;
        }
        return lastGeneratedRouteId;
    }

    private LocalDateTime calculateEstimatedArrivalTime(List<Route> routes) {
        int totalEstimatedTimeInMinutes = routes.stream().mapToInt(Route::getEstimatedTimeMin).sum();
        return LocalDateTime.now().plusMinutes(totalEstimatedTimeInMinutes);
    }
}