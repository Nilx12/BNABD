package com.example.bikerentalservice.services;

import com.example.bikerentalservice.Repository.RentRepository;
import com.example.bikerentalservice.Repository.ReservationRepository;
import com.example.bikerentalservice.model.Bike;
import com.example.bikerentalservice.model.Rent;
import com.example.bikerentalservice.model.Reservation;
import com.example.bikerentalservice.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService {

    RentRepository rentRepository;
    ReservationRepository reservationRepository;

    public Rent getRentById(Long id){
        return rentRepository.getById(id);
    }

    public List<Rent> findAllRents(){
        return rentRepository.findAll();
    }

    public Rent getBydate(LocalTime rent_date){
        return rentRepository.getBydate(rent_date);
    }

    public Rent getRentByUser(User user){
        return rentRepository.getByUser(user);
    }

    public Rent getRentByBike(Bike bike){
        return rentRepository.getByBike(bike.getBike_code());
    }

    public Reservation getReservationById(Long id){
        return reservationRepository.getById(id);
    }

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationByBike(Bike bike){
        return reservationRepository.findBybike(bike.getBike_code());
    }

    public Rent save(Rent rent){
        return rentRepository.save(rent);
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }


}
