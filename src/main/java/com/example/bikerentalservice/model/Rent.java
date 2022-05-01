package com.example.bikerentalservice.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalTime rent_date;
    private LocalTime return_date;

    @ManyToOne()
    @JoinColumn(name = "bike_id")
    private  Bike bike;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private  User user;
    public Rent() {
    }
    public Rent(LocalTime rent_date, LocalTime return_date, Bike bike, User user) {
        this.rent_date = rent_date;
        this.return_date = return_date;
        this.bike = bike;
        this.user = user;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getRent_date() {
        return rent_date;
    }

    public void setRent_date(LocalTime rent_date) {
        this.rent_date = rent_date;
    }

    public LocalTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalTime return_date) {
        this.return_date = return_date;
    }
}
