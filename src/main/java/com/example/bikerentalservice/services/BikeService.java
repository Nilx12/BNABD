package com.example.bikerentalservice.services;


import com.example.bikerentalservice.Repository.BikeRepository;
import com.example.bikerentalservice.model.Bike;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class BikeService {
    private BikeRepository bikeRepository;

    public Bike getById(Long id){
        return bikeRepository.getById(id);
    }

    public List<Bike> findAll(){
        return bikeRepository.findAll();
    }

    public List<Bike> findByLocation(Long location){
        return bikeRepository.findByLocation(location);
    }

    public Bike getByCode(String code){
        return bikeRepository.getByCode(code);
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }
}
