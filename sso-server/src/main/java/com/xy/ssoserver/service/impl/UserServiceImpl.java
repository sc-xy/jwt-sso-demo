package com.xy.ssoserver.service.impl;

import com.xy.ssoserver.entity.User;
import com.xy.ssoserver.mapper.UserMapper;
import com.xy.ssoserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xy.ssoserver.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public User checkUser(String username, String password) {
        User user =  userMapper.checkUser(username, password);
        user.setRoles(roleService.getAuthoritiesByUsername(username));
        return user;
    }

    @Override
    public User loadUserByUsername(String username) {
        User user = userMapper.loadUserByUsername(username);
        user.setRoles(roleService.getAuthoritiesByUsername(username));
        return user;
    }

}
