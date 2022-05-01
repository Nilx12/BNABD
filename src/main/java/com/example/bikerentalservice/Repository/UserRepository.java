package com.example.bikerentalservice.Repository;


import com.example.bikerentalservice.model.Address;
import com.example.bikerentalservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User getById(Long id);

    @Override
    java.util.List<User> findAll();

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getByUserName(String username);

    @Override
    <S extends User> S save(S user);

}
