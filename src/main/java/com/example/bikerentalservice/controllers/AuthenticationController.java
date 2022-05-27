package com.example.bikerentalservice.controllers;
import java.util.*;
import java.util.stream.Collectors;

import com.example.bikerentalservice.Repository.UserRepository;
import com.example.bikerentalservice.config.JwtUtils;
import com.example.bikerentalservice.dto.UserDto;
import com.example.bikerentalservice.model.User;
import com.example.bikerentalservice.response.JWTResponse;
import com.example.bikerentalservice.response.MessageResponse;
import com.example.bikerentalservice.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping( "/signin")
    public ResponseEntity<?>  authenticateUser(@ModelAttribute("user") UserDto loginRequest, HttpServletRequest request,HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User user = userService.getByUserName(loginRequest.getUsername());


        HttpSession session = request.getSession(true);
        session.setAttribute("key","Bearer "+jwt);
        return ResponseEntity.ok(new JWTResponse(jwt,
                user.getId(),
                user.getUsername(),
                "",
                Arrays.asList(user.getRole().getRole_name())));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@ModelAttribute("user") UserDto signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        User user = new User();
        user.setUsername(signUpRequest.getUsername());

        user.setHashedPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(userService.getRoleById(1L));

        userService.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}