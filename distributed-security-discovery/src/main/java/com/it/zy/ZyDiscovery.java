package com.it.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zouyu
 * @description
 * @date 2020/5/12
 */
@SpringBootApplication
@EnableEurekaServer
public class ZyDiscovery {
    public static void main(String[] args) {
        SpringApplication.run(ZyDiscovery.class,args);
    }

}
