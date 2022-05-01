package com.example.bikerentalservice.Repository;

import com.example.bikerentalservice.model.Address;
import com.example.bikerentalservice.model.Reservation;
import com.example.bikerentalservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    Role getById(Long id);

    @Override
    java.util.List<Role> findAll();

    @Override
    <S extends Role> S save(S role);

}
