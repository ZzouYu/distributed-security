package com.it.zy.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author zouyu
 * @description  配置资源服务
 * @date 2020/5/12
 */
@Configuration
public class ResourceConfig {
    @Autowired
    private TokenStore tokenStore;

    //资源ID
    private static final String RESOURCE_ID ="res1";
    //UAA资源
    @Configuration
    @EnableResourceServer
    public class UAAResourceConfig extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID)//资源 id
                    .tokenStore(tokenStore)
                    // .tokenServices(tokenService())//验证令牌的服务
                    .stateless(true);
        }
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/uaa/**").permitAll();
        }
    }
    //ORDER资源
    @Configuration
    @EnableResourceServer
    public class orderResourceConfig extends ResourceServerConfigurerAdapter {


        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID)//资源 id
                    .tokenStore(tokenStore)
                    // .tokenServices(tokenService())//验证令牌的服务
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/order/**").access("#oauth2.hasScope('ROLE_API')")
                    .and().csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//基于token 不记录session
        }
    }


}
