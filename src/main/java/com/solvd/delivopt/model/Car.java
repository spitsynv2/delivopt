package com.solvd.delivopt.model;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class Car {
    private Long id;
    private String carType;
    private Double maxWeightCapacity;
    private Double maxVolumeCapacity;
    private Long ownerCompanyId;

    public Car() {}

    public Long getOwnerCompanyId() {
        return ownerCompanyId;
    }

    public void setOwnerCompanyId(Long ownerCompanyId) {
        this.ownerCompanyId = ownerCompanyId;
    }

    public Double getMaxVolumeCapacity() {
        return maxVolumeCapacity;
    }

    public void setMaxVolumeCapacity(Double maxVolumeCapacity) {
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    public Double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void setMaxWeightCapacity(Double maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", maxWeightCapacity=" + maxWeightCapacity +
                ", maxVolumeCapacity=" + maxVolumeCapacity +
                ", ownerCompanyId=" + ownerCompanyId +
                '}';
    }
}