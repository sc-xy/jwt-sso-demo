package com.xy.ssoserver.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    List<? extends GrantedAuthority> getAuthoritiesByUsername(String username);
}
