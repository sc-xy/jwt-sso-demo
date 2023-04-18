package com.xy.ssoserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class SsoAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenStore jwtTokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(ClientDetailsServiceConfigurer client) throws Exception {
        // 采用内存存储客户端信息
        client.inMemory()
                // 注册一个客户端
                .withClient("client1")
                // 客户端密码
                .secret(passwordEncoder.encode("client1secret"))
                // 令牌有效期1小时
                .accessTokenValiditySeconds(3600)
                // 重定向到客户端登陆界面
                .redirectUris("http://localhost:8081/client1/login")
                // 授权多种认证方式
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                // 指定作用域为 all
                .scopes("all")
                // 需要手动授权
                .autoApprove(false)
                .and()
                .withClient("client2")
                .secret(passwordEncoder.encode("client2secret"))
                .accessTokenValiditySeconds(3600)
                .redirectUris("http://localhost:8082/client2/login")
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("all")
                .autoApprove(false);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置令牌存储方式和令牌转换器
        endpoints.tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 只有经过身份验证的客户端才能访问令牌密钥
        security.tokenKeyAccess("isAuthenticated()");
    }
}
