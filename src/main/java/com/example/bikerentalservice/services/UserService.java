package com.example.bikerentalservice.services;

import com.example.bikerentalservice.Repository.UserRepository;
import com.example.bikerentalservice.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public User getById(Long id){
        return userRepository.getById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getByUserName(String username){
        return userRepository.getByUserName(username);
    }
}
