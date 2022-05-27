package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.model.Bike;
import com.example.bikerentalservice.model.Location;
import com.example.bikerentalservice.model.User;
import com.example.bikerentalservice.services.BikeService;
import com.example.bikerentalservice.services.LocationService;
import com.example.bikerentalservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/admin")
public class AdminController {

    UserService userService;

    BikeService bikeService;

    LocationService locationService;

    @RequestMapping("/panel")
    public String getAdminPanel(){
        return "admin";
    }

    @RequestMapping("/users")
    public String getUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "userAdminList";
    }

    @GetMapping("/user/{id}")
    public String editUserPage(@PathVariable("id") Long id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return "userEdit";
    }

    @PostMapping("/edit/user")
    public String editUser(@RequestParam("user")User user){
        userService.save(user);
        return "redirect:users";
    }

    @RequestMapping("/bikes")
    public String getBikes(Model model){
        List<Bike> bikes = bikeService.findAll();
        model.addAttribute("bikes",bikes);
        return "bikesAdminList";
    }

    @GetMapping("/bike/{id}")
    public String editBikePage(@PathVariable("id") Long id, Model model){
        Bike bike = bikeService.getById(id);
        model.addAttribute("bike",bike);
        return "bikeEdit";
    }

    @PostMapping("/edit/bike")
    public String editBike(@RequestParam("bike")Bike bike){
        bikeService.save(bike);
        return "redirect:bikes";
    }

    @RequestMapping("/locations")
    public String getLocations(Model model){
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations",locations);
        return "locattionsAdminList";
    }

    @GetMapping("/location/{id}")
    public String editLocationPage(@PathVariable("id") Long id, Model model){
        Bike bike = bikeService.getById(id);
        model.addAttribute("bike",bike);
        return "locationEdit";
    }

    @PostMapping("/edit/location")
    public String editLocation(@RequestParam("location")Location location){
        locationService.save(location);
        return "redirect:locations";
    }

    @PostMapping("/add/user")
    public String addUser(@RequestParam("user")User user) {
        
        return "redirect:users";
    }

}
