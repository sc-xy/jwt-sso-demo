package com.xy.ssoserver.service.impl;

import com.xy.ssoserver.mapper.RoleMapper;
import com.xy.ssoserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<? extends GrantedAuthority> getAuthoritiesByUsername(String username) {
        List<String> rolesStr =  roleMapper.getAuthoritiesByUsername(username);
        List<? extends  GrantedAuthority> roles = AuthorityUtils.
                commaSeparatedStringToAuthorityList(String.join(",", rolesStr));
        return roles;
    }

}
