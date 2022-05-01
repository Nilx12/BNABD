package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.model.Bike;
import com.example.bikerentalservice.services.BikeService;
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
@RequestMapping("/appi/rental")
public class BikeController {
    private BikeService bikeService;

    @GetMapping("/bikes")
    public String getBikes(Model model){
        model.addAttribute("bikes",bikeService.findAll());
        return "bikeList";
    }
    @GetMapping("bikes/{id}")
    public String getBike(@PathVariable("id") String id,Model model){
        model.addAttribute("bike",bikeService.getByCode(id));
        return "bikePage";
    }
}
