package com.springcloud.study;

import com.springcloud.study.message.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: java-learn
 * @description: 生产者的发送确认
 * @author: liquan
 * @create: 2020-06-12 23:27
 **/
@SpringBootApplication
@EnableBinding(MySource.class)
public class RabbitmqProducerConfirmApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerConfirmApplication.class, args);
    }
}
