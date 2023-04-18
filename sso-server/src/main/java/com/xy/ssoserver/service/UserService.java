package com.xy.ssoserver.service;

import com.xy.ssoserver.entity.User;

public interface UserService {
    User checkUser(String username, String password);

    User loadUserByUsername(String username);
}
