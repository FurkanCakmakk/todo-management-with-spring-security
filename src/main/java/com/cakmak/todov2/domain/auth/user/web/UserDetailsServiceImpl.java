package com.cakmak.todov2.domain.auth.user.web;

import com.cakmak.todov2.domain.auth.user.api.UserService;
import com.cakmak.todov2.domain.auth.user.impl.User;
import com.cakmak.todov2.domain.auth.user.impl.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private  final UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.getByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }
}
