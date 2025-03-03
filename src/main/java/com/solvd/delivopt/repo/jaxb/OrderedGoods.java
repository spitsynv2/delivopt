package com.solvd.delivopt.repo.jaxb;

import com.solvd.delivopt.model.Goods;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderedGoods")
public class OrderedGoods {
    private Long warehouseId;
    private Goods goods;
    private Integer quantity;

    public OrderedGoods() {}

    @XmlElement
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlElement
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @XmlElement
    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}