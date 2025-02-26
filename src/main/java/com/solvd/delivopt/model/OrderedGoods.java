package com.solvd.delivopt.model;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class OrderedGoods {
    private Warehouse warehouse;
    private Goods goods;
    private Integer quantity;

    public OrderedGoods() {}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "OrderedGoods{" +
                "goods=" + goods +
                ", quantity=" + quantity +
                ", warehouse=" + warehouse +
                '}';
    }
}
