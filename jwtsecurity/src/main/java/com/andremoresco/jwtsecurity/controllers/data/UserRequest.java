package com.andremoresco.jwtsecurity.controllers.data;

import com.andremoresco.jwtsecurity.model.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserRequest {

    private final String username;
    private final String password;
    private final Boolean locked;
    private final Boolean enabled;
    private final AppUserRole role;

}
