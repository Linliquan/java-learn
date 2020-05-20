package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linliquan
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerMovieFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignHystrixApplication.class, args);
    }
}
