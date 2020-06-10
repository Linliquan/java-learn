package com.spring.study.springbootrabbitmqdirect.config;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-06 21:32
 **/

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMqConfig {
    private String host;
    private int port;
    private String userName;
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host,port);
        cachingConnectionFactory.setUsername(userName);
        cachingConnectionFactory.setPassword(password);
        cachingConnectionFactory.setVirtualHost("/");
        cachingConnectionFactory.setPublisherConfirms(true);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}