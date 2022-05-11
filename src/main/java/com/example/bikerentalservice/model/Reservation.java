package com.example.bikerentalservice.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "reservation ")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "bike_id")
    private  Bike bike;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private  User user;

    private LocalTime end_date;

    public Reservation(Bike bike, User user, LocalTime end_date) {
        this.bike = bike;
        this.user = user;
        this.end_date = end_date;
    }

    public Reservation() {
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

    public LocalTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalTime end_date) {
        this.end_date = end_date;
    }
}
