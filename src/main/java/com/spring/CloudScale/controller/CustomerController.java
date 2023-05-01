package com.spring.CloudScale.controller;

import com.spring.CloudScale.model.Customers;
import com.spring.CloudScale.model.dto.userCreation;
import com.spring.CloudScale.persistence.UserRepository;
import com.spring.CloudScale.util.DTO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class CustomerController {

    private UserRepository userRepository;

    public CustomerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void newUser(@DTO(userCreation.class) Customers user) {
        userRepository.save(user);
    }
}
