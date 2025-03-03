package com.solvd.delivopt.util.pathfinder.graphmodel;

import com.solvd.delivopt.model.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-03-03
 */
public class Node {
    private final Long id;
    private final Address address;
    private final List<Edge> edges;

    public Node(Long id, Address address) {
        this.id = id;
        this.address = address;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}