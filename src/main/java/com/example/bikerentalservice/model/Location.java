package com.example.bikerentalservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "total_slots")
    private int total_slots;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "location")
    private List<Bike> bikes;



    public Location(int total_slots, Address address) {
        this.total_slots = total_slots;
        this.address = address;
    }

    public Location() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotal_slots() {
        return total_slots;
    }

    public void setTotal_slots(int total_slots) {
        this.total_slots = total_slots;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
