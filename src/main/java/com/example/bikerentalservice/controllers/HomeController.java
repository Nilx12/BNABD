package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.config.UserData;
import com.example.bikerentalservice.dto.UserDto;
import com.example.bikerentalservice.model.Bike;
import com.example.bikerentalservice.model.Location;
import com.example.bikerentalservice.model.User;
import com.example.bikerentalservice.services.BikeService;
import com.example.bikerentalservice.services.LocationService;
import com.example.bikerentalservice.services.RentService;
import com.example.bikerentalservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/rental")
public class HomeController {

    private UserService userService;
    private BikeService bikeService;
    private RentService rentService;
    private LocationService locationService;

    @GetMapping("/home")
    public String getHomePage(Model model){
        User user = userService.getById(Long.valueOf(1));
        model.addAttribute("user",user);
        return "index";
    }


}
