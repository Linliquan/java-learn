package com.springcloud.study;

import com.springcloud.study.message.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-12 23:27
 **/
@SpringBootApplication
@EnableBinding(MySource.class)
public class RabbitmqProducerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerDemoApplication.class, args);
    }
}
