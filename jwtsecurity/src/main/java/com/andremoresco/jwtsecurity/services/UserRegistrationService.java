package com.andremoresco.jwtsecurity.services;

import com.andremoresco.jwtsecurity.controllers.data.UserRequest;
import com.andremoresco.jwtsecurity.exception.CustomException;
import com.andremoresco.jwtsecurity.model.AppUser;
import com.andremoresco.jwtsecurity.model.AppUserRole;
import com.andremoresco.jwtsecurity.repository.UserRepository;
import com.andremoresco.jwtsecurity.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;



    public AppUser findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found!", username)));
    }

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, findByUsername(username).getAppUserRole().name());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid Username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Transactional
    public String signUp(UserRequest userRequest) {
        AppUser user = userRepository.save(
                AppUser.builder()
                        .username(userRequest.getUsername())
                        .password(passwordEncoder.encode(userRequest.getPassword()))
                        .locked(false)
                        .enabled(false)
                        .appUserRole(AppUserRole.USER)
                        .build()
        );
        return jwtTokenProvider.createToken(user.getUsername(), user.getAppUserRole().name());
    }
}
