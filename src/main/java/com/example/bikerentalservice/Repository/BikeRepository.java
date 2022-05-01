package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Override
    Bike getById(Long id);

    @Override
    java.util.List<Bike> findAll();

    @Query("SELECT b FROM Bike b WHERE b.location.id = ?1")
    List<Bike> findByLocation(Long location);

    @Query("SELECT b FROM Bike b WHERE b.bike_code = ?1")
    Bike getByCode(String code);

    @Override
    <S extends Bike> S save(S bike);
}
