package com.dosja.Dosja.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_STAFF,ROLE_CLIENT;
    public String getAuthority() {
        return name();
    }
}