package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Override
    Reservation getById(Long id);

    @Override
    List<Reservation> findAll();

    @Query("SELECT r FROM Reservation r WHERE r.bike.location.id = ?1")
    Optional<List<Reservation>> getCurrentReservationByLocation(Long locationId);

    @Query(value = "SELECT r FROM Reservation r WHERE r.bike.bike_code = ?1 AND date(r.end_date p) >= CURRENT_DATE")
    Optional<Reservation> getByBike(String code);

    @Override
    <S extends Reservation> S save(S reservation);

}
