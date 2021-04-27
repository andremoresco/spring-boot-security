package com.andremoresco.jwtsecurity.controllers;

import com.andremoresco.jwtsecurity.controllers.data.UserRequest;
import com.andremoresco.jwtsecurity.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserRequest> getUsers(@RequestBody UserRequest userRequest) {
        return userService.findAll();
    }
}