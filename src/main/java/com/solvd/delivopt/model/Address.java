package com.solvd.delivopt.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */

@XmlRootElement(name = "Address")
public class Address {
    private Long id;
    private String street;
    private String city;
    private String postCode;
    private Double latitude;
    private Double longitude;

    public Address(Long id, String street, String city, String postCode, Double latitude, Double longitude) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Address() {}

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @XmlElement
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @XmlElement
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Address{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", id=" + id +
                '}';
    }
}