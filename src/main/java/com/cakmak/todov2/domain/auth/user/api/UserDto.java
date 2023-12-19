package com.cakmak.todov2.domain.auth.user.api;

import com.cakmak.todov2.domain.auth.user.impl.enums.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public class UserDto {
    private String id;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean enabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Set<Role> authorities;

}
