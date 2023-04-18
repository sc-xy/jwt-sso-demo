package com.xy.ssoclient1.Utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SessionUtil {
    // 获取当前用户认证信息
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    // 获取当前用户的权限信息
    public static List<String> getAuthorities() {
        Authentication authentication = getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            return authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }
        return null;
    }
    // 获取当前用户名
    public static String getCurrentUserName() {
        Authentication authentication = getAuthentication();
        if (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof String) {
                return (String) principal;
            } else if (principal instanceof UserDetails) {
                String currentuser = ((UserDetails) principal).getUsername();
                return currentuser;
            } else {
                System.out.println("not instanceof UserDetails");
            }
            return null;
        }
        return null;
    }
}
