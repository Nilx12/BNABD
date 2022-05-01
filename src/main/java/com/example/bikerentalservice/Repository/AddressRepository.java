package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.Address;
import com.example.bikerentalservice.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Override
    Address getById(Long id);

    @Override
    java.util.List<Address> findAll();

    @Override
    <S extends Address> S save(S address);
}
