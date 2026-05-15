package com.pragati.expensetracker.service;

import com.pragati.expensetracker.entity.User;
import com.pragati.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User register(User user) {
        return repository.save(user);
    }

    public User login(String username, String password) {

        User user = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}