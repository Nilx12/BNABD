package com.example.bikerentalservice.model;

import javax.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bike_id")
    private Long id;

    @Column(name="bike_code")
    private  String bike_code;

    @Column(name="bike_model")
    private  String bike_model;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    public Bike(String bike_code, String bike_model, Location location) {
        this.bike_code = bike_code;
        this.bike_model = bike_model;
        this.location = location;
    }

    public Bike() {
    }

    public String getBike_code() {
        return bike_code;
    }

    public void setBike_code(String bike_code) {
        this.bike_code = bike_code;
    }

    public String getBike_model() {
        return bike_model;
    }

    public void setBike_model(String bike_model) {
        this.bike_model = bike_model;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
