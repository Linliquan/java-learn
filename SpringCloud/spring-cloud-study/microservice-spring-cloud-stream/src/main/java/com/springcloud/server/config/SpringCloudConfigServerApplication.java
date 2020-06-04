package com.springcloud.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-05-14 18:23
 **/
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }
}
