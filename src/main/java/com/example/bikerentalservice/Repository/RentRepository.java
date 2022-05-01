package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.Address;
import com.example.bikerentalservice.model.Bike;
import com.example.bikerentalservice.model.Rent;
import com.example.bikerentalservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;

public interface RentRepository extends JpaRepository<Rent, Long> {

    @Override
    Rent getById(Long id);

    @Override
    java.util.List<Rent> findAll();

    @Query("SELECT r FROM Rent r WHERE r.rent_date = ?1")
    Rent getBydate(LocalTime rent_date);

    @Query("SELECT r FROM Rent r WHERE r.user = ?1")
    Rent getByUser(User user);

    @Query("SELECT r FROM Rent r WHERE r.bike.bike_code = ?1 AND date(r.return_date) >= CURRENT_DATE")
    Rent getByBike(String code);

    @Override
    <S extends Rent> S save(S rent);
}
