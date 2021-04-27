package com.andremoresco.jwtsecurity.services;

import com.andremoresco.jwtsecurity.controllers.data.UserRequest;
import com.andremoresco.jwtsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found!", username)));
    }

    public List<UserRequest> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build()
                ).collect(Collectors.toList());
    }
}
