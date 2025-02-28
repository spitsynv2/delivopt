package com.solvd.delivopt.model;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Company {
    private Long id;
    private String companyName;
    private Address address;
    private List<Warehouse> warehouses;
    private List<Car> cars;

    public Company() {}

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address=" + address +
                ", warehouses=" + warehouses +
                ", cars=" + cars +
                '}';
    }
}
