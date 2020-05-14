package com.it.zy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zouyu
 * @description
 * @date 2020/5/13
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class gatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(gatewayServer.class,args);
    }
}
