package com.cakmak.todov2.domain.auth.user.impl.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_SUPER_ADMIN;


    @Override
    public String getAuthority() {
        return null;
    }
}
