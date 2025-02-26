package com.solvd.delivopt.model;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Goods {
    private Long id;
    private String goodsName;
    private String description;
    private Double weight;
    private Double volume;

    public Goods() {}

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "weight=" + weight +
                ", volume=" + volume +
                ", description='" + description + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", id=" + id +
                '}';
    }
}
