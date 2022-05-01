package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.Address;
import com.example.bikerentalservice.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Override
    public Location getById(Long id);

    @Override
    public List<Location> findAll();

    @Query("SELECT l FROM Location as l WHERE l.address.city_name like ?1")
    public List<Location> getByCity(String city);

    @Override
    <S extends Location> S save(S location);

}
