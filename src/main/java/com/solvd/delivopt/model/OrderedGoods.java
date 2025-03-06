package com.solvd.delivopt.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedGoods {

    @XmlElement
    private Long warehouseId;

    @XmlElement
    private Goods goods;

    @XmlElement
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
