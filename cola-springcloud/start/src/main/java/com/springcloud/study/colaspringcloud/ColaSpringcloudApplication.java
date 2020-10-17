package com.springcloud.study.colaspringcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.springcloud.study.colaspringcloud", "com.alibaba.cola" })
@MapperScan("com.springcloud.study.colaspringcloud.gatewayimpl.database")
public class ColaSpringcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColaSpringcloudApplication.class, args);
    }

}
