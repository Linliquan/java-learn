package com.springcloud.study.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: java-learn
 * @description: RabbitMQ 的事务管理器
 * @author: liquan
 * @create: 2020-06-14 15:59
 **/
@Configuration
@EnableTransactionManagement
public class TransactionConfig {

    @Bean
    public RabbitTransactionManager rabbitTransactionManager(ConnectionFactory connectionFactory) {
        return new RabbitTransactionManager(connectionFactory);
    }

}