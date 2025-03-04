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
public class Goods {

    @XmlElement
    private Long id;

    @XmlElement
    private String goodsName;

    @XmlElement
    private String description;

    @XmlElement
    private Double weight;

    @XmlElement
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
