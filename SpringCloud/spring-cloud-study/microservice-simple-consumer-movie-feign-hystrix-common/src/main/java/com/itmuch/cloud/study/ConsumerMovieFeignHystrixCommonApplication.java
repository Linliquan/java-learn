package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linliquan
 */
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class ConsumerMovieFeignHystrixCommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignHystrixCommonApplication.class, args);
    }
}
