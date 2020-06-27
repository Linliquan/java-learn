package com.rocketmq.study;

import com.rocketmq.study.listener.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: java-learn
 * @description: 
 * @author: liquan
 * @create: 2020-06-16 21:29
 **/
@SpringBootApplication
@EnableBinding(MySink.class)
public class RocketmqConsumerTransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketmqConsumerTransactionApplication.class, args);
    }
}
