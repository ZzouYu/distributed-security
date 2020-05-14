package com.it.security.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author zouyu
 * @description
 * @date 2020/5/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZyOrderServer {
    public static void main(String[] args) {
        SpringApplication.run(ZyOrderServer.class,args);
    }

}
