package com.xy.ssoserver.service.impl;

import com.xy.ssoserver.entity.User;
import com.xy.ssoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SsoUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        判断用户是否存在并返回
        User user = userService.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                user.getRoles());
    }
}
