package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.model.*;
import com.example.bikerentalservice.services.BikeService;
import com.example.bikerentalservice.services.LocationService;
import com.example.bikerentalservice.services.RentService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/appi/rental")
public class RentController {

    RentService rentService;
    BikeService bikeService;
    LocationService locationService;

    @PostMapping("/reserve/{code}")
    public String reserwe(@PathVariable("code") String code, Model model){
        Bike bike = bikeService.getByCode(code);
        Optional<Reservation> reservation = rentService.getReservationByBike(bike);
        if(reservation.isPresent()){
            return "reserved";
        }
        //TODO:Wyciąganie usera
        User user = new User();
        Reservation reservation1 = new Reservation(bike,user,LocalTime.now().plusHours(2));

        return "";
    }

    @PostMapping("/rent/{code}")
    public String rentBike(@PathVariable("code") String code, Model model){
        Bike bike = bikeService.getByCode(code);
        Optional<Reservation> reservation = rentService.getReservationByBike(bike);
        //TODO:Wyciąganie usera
        User user = new User();
        if(reservation.isPresent() && reservation.get().getUser().equals(user)){
            return "reserved";
        }
        if(reservation.isPresent()) {
            reservation.get().setEnd_date(LocalTime.now());
            rentService.save(reservation.get());
        }
        bike.setLocation(null);
        bikeService.save(bike);

        Rent rent = new Rent(LocalTime.now(),LocalTime.now().plusHours(2),bike,user);
        rentService.save(rent);

        return "";
    }

    @PostMapping("/return/{id}")
    public String returnBike(@PathVariable("id") Long id, @RequestParam("location_id") Long location_id, Model model){
        Rent rent = rentService.getRentById(id);
        rent.setReturn_date(LocalTime.now());
        Bike bike = rent.getBike();
        Location location = locationService.getById(location_id);
        bike.setLocation(location);
        bikeService.save(bike);
        rentService.save(rent);
        return "home";
    }
}
