package com.andremoresco.userlogin.resgistration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRegistrationRequest {

    private final String name;
    private final String email;
    private final String password;

}
