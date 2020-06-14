package com.springcloud.study;

import com.springcloud.study.message.MySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-13 14:41
 **/
@SpringBootApplication
@EnableBinding(MySource.class)
public class ProducerDelayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerDelayApplication.class, args);
    }
}
