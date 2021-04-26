package com.andremoresco.userlogin.resgistration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users/")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public boolean register(@RequestBody UserRegistrationRequest request) {
        return registrationService.register(request);
    }

}
