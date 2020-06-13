package com.spring.study.springbootrabbitmqdirect.config;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-09 15:20
 **/
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QueueConfig {

    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange("test_exchange", "x-delayed-message",true, false,args);
    }

    @Bean
    public Queue queue() {
        Queue queue = new Queue("test_queue_1", true);
        return queue;
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(delayExchange()).with("test_queue_1").noargs();
    }
}