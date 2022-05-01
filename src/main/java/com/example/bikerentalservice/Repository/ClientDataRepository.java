package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.Address;
import com.example.bikerentalservice.model.ClientData;
import com.example.bikerentalservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDataRepository extends JpaRepository<ClientData, Long> {
    @Override
    ClientData getById(Long id);

    @Override
    java.util.List<ClientData> findAll();

    @Override
    <S extends ClientData> S save(S clientData);

}
