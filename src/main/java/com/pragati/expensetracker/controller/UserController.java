package com.pragati.expensetracker.controller;

import com.pragati.expensetracker.entity.User;
import com.pragati.expensetracker.service.UserService;
import com.pragati.expensetracker.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedUser = service.login(user.getUsername(), user.getPassword());

        String token = JwtUtil.generateToken(loggedUser.getUsername());

        return token;
    }
}