package com.solvd.delivopt.model;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class OrderedGoods {
    private Long warehouseId;
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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "OrderedGoods{" +
                "goods=" + goods +
                ", quantity=" + quantity +
                ", warehouseId=" + warehouseId +
                '}';
    }
}
