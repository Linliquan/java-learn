package com.springcloud.study;

import com.springcloud.study.listener.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: java-learn
 * @description: 测试单集群多实例的场景
 * @author: liquan
 * @create: 2020-06-13 00:19
 **/
@SpringBootApplication
@EnableBinding(MySink.class)
public class RabbitmqConsumerConcurrencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerConcurrencyApplication.class, args);
    }
}
