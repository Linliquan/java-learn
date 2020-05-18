package com.springcloud.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: java-learn
 * @description: Eureka server
 * @author: liquan
 * @create: 2020-05-14 18:23
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDiscovery {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerDiscovery.class, args);
    }
}
