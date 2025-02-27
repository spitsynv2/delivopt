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
    private Long ownerCompanyId;
    private Map<Goods, Integer> goodsInventory;

    public Warehouse() {}

    public Map<Goods, Integer> getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Map<Goods, Integer> goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public Long getOwnerCompanyId() {
        return ownerCompanyId;
    }

    public void setOwnerCompanyId(Long ownerCompanyId) {
        this.ownerCompanyId = ownerCompanyId;
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
                ", ownerCompanyId=" + ownerCompanyId +
                ", goodsInventory=" + goodsInventory +
                '}';
    }
}