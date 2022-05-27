package com.example.bikerentalservice.controllers;

import com.example.bikerentalservice.dto.UserDto;
import com.example.bikerentalservice.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Controller
@RequestMapping("/api/rental")
public class UserController {

    @GetMapping("/profile")
    public String gwtUserProfile(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "profile";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user",user);
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user",user);
        return "register";
    }
}
