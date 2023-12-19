package com.cakmak.todov2.domain.auth.user.web;

import com.cakmak.todov2.domain.auth.user.api.UserDto;
import com.cakmak.todov2.domain.auth.user.impl.User;
import com.cakmak.todov2.domain.auth.user.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public UserDto createuser(@RequestBody CreateUserRequest createUserRequest) {
        return toDto(userService.createUser(createUserRequest));
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .accountNonExpired(user.isAccountNonExpired())
                .enabled(user.isEnabled())
                .accountNonLocked(user.isAccountNonLocked())
                .credentialsNonExpired(user.isCredentialsNonExpired())
                .authorities(user.getAuthorities())
                .build();
    }

}
