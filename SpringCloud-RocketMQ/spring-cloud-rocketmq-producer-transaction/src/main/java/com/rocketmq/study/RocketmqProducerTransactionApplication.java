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
public class RocketmqProducerTransactionApplication {
    // 可能因为版本原因，目前这个事务例子目前还有点bug
    public static void main(String[] args) {
        SpringApplication.run(RocketmqProducerTransactionApplication.class, args);
    }
}
