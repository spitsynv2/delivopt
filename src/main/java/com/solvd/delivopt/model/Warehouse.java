package com.solvd.delivopt.model;

import java.util.Map;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Warehouse {
    private Long id;
    private Address warehouseAddress;
    private String warehouseName;
    private Company ownerCompany;
    private Map<Goods, Integer> goodsInventory;

    public Warehouse() {}

    public Map<Goods, Integer> getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Map<Goods, Integer> goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public Company getOwnerCompany() {
        return ownerCompany;
    }

    public void setOwnerCompany(Company ownerCompany) {
        this.ownerCompany = ownerCompany;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Address getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(Address warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouseAddress=" + warehouseAddress +
                ", warehouseName='" + warehouseName + '\'' +
                ", ownerCompany=" + ownerCompany +
                ", goodsInventory=" + goodsInventory +
                '}';
    }
}