package com.andremoresco.userlogin.resgistration;

import com.andremoresco.userlogin.user.User;
import com.andremoresco.userlogin.user.UserRole;
import com.andremoresco.userlogin.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    public final UserService userService;

    public boolean register(UserRegistrationRequest request) {
        return userService.signUpUser(new User(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));
    }
}