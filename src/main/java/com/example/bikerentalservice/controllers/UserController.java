package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.model.User;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/appi/rental")
public class UserController {

    @GetMapping("/profile")
    public String gwtUserProfile(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "profile";
    }

}
