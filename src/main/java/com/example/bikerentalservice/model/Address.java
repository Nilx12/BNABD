package com.example.bikerentalservice.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "city_name")
    private String city_name;
    @Column(name = "street_name")
    private String street_name;
    @Column(name = "street_number")
    private String street_number;
    @Column(name = "postal_code")
    private String postal_code;

    public Address() {
    }

    public Address(String city_name, String street_name, String street_number, String postal_code) {
        this.city_name = city_name;
        this.street_name = street_name;
        this.street_number = street_number;
        this.postal_code = postal_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
}
