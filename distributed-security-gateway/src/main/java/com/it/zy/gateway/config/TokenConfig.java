package com.it.zy.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author zouyu
 * @description 配置存储策略
 * @date 2020/5/12
 */
@Configuration
public class TokenConfig {
   private String SIGNING_KEY = "UAA";
    @Bean
    public TokenStore tokenStore(){
        //使用jwt存储令牌
        return new JwtTokenStore(accTokenConverter());
    }

    /**
     * 使用jwt对称加密
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
//    @Bean
//    public TokenStore tokenStore(){
//        //使用内存存储令牌
//        return new InMemoryTokenStore();
//    }
}
