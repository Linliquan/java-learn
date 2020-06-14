package com.springcloud.study;

import com.springcloud.study.listener.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: java-learn
 * @description: 消费异常处理机制
 * @author: liquan
 * @create: 2020-06-13 00:19
 **/
@SpringBootApplication
@EnableBinding(MySink.class)
public class RabbitmqConsumerErrorHandlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerErrorHandlerApplication.class, args);
    }
}
