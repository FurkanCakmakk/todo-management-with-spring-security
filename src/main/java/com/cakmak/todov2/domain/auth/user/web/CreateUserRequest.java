package com.cakmak.todov2.domain.auth.user.web;

import com.cakmak.todov2.domain.auth.user.impl.enums.Role;

import java.util.Set;

public class CreateUserRequest {
    public String username;
    public String password;
    public Set<Role> authorities;
}
