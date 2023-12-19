package com.cakmak.todov2.domain.auth.user.impl;

import com.cakmak.todov2.domain.auth.user.web.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl  {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;


    public Optional<User> getByUsername(String username){
        return repository.findByUsername(username);
    }

    public User createUser(CreateUserRequest createUserRequest){
        User newUser = User.builder()
                .username(createUserRequest.username)
                .password(passwordEncoder.encode(createUserRequest.password))
                .authorities(createUserRequest.authorities)
                .enabled(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .build();
        return repository.save(newUser);
    }



}
