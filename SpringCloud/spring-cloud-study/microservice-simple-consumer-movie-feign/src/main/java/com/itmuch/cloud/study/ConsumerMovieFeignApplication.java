package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linliquan
 */
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class ConsumerMovieFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignApplication.class, args);
    }
}
