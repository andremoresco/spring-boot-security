package com.andremoresco.jwtsecurity.controllers;

import com.andremoresco.jwtsecurity.controllers.data.UserRequest;
import com.andremoresco.jwtsecurity.services.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "users")
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping(path = "signup")
    public String signUp(@RequestBody UserRequest userRequest) {
        return userRegistrationService.signUp(userRequest);
    }

    @PostMapping(path = "signin")
    public String signIn(@RequestParam String username, @RequestParam String password) {
        return userRegistrationService.signIn(username, password);
    }
}
