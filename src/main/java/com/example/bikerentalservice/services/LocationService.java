package com.example.bikerentalservice.services;

import com.example.bikerentalservice.Repository.LocationRepository;
import com.example.bikerentalservice.model.Location;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
    LocationRepository locationRepository;

    public Location getById(Long id){
        return locationRepository.getById(id);
    }
    public List<Location> findAll(){
        return locationRepository.findAll();
    }
    public List<Location> getByCity(String city){
        return locationRepository.getByCity(city);
    }
}
