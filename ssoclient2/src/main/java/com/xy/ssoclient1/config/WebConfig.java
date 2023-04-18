package com.xy.ssoclient1.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout()
                .logoutSuccessUrl("http://localhost:8080/server/exit")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }
}
