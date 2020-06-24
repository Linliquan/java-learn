package com.rocketmq.study;

import com.rocketmq.study.message.MySource;
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
@EnableBinding(MySource.class)
public class RocketmqProducerErrorHandlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketmqProducerErrorHandlerApplication.class, args);
    }
}
