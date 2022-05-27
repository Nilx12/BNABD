package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.model.*;
import com.example.bikerentalservice.services.BikeService;
import com.example.bikerentalservice.services.LocationService;
import com.example.bikerentalservice.services.RentService;
import com.example.bikerentalservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Optional;


@AllArgsConstructor
@Controller
@RequestMapping("/api/rental")
public class LocationController {

    private LocationService locationService;
    private BikeService bikeService;

    @GetMapping("/locations")
    public String getLocations(Model model){
        model.addAttribute("locations",locationService.findAll());
        return "locationList";
    }

    @GetMapping("/city/{name}/locations")
    public String getLocationByCity(@PathVariable("name") String city,Model model){
        model.addAttribute("locations",locationService.getByCity(city));
        return "locationCityList";
    }

    @GetMapping("/locations/{id}")
    public String getLocationById(@PathVariable("id") Long id,Model model){
        System.out.println(id);
        model.addAttribute("location",locationService.getById(id));
        model.addAttribute("bikes",bikeService.findByLocation(id));
        return "locationPage";
    }

}
