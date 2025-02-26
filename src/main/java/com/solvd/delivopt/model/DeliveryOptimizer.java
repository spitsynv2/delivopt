package com.solvd.delivopt.model;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class DeliveryOptimizer {
    private List<Company> companies;
    private List<Client> clients;

    public DeliveryOptimizer() {}

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "DeliveryOptimizer{" +
                "companies=" + companies +
                ", clients=" + clients +
                '}';
    }
}
