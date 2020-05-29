package com.springcloud.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: java-learn
 * @description: Eureka安全认证
 * @author: liquan
 * @create: 2020-05-14 18:23
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDiscoveryAuthenticating {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerDiscoveryAuthenticating.class, args);
    }
}
