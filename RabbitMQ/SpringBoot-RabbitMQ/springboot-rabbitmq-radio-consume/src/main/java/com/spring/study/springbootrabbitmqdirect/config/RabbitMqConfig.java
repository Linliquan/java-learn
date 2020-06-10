package com.spring.study.springbootrabbitmqdirect.config;

import com.spring.study.springbootrabbitmqdirect.message.BroadcastMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-10 14:32
 **/

@Configuration
public class RabbitMqConfig {

    /**
     * 广播消费的示例的配置
     */
    public static class BroadcastingConfiguration {

        // 创建 Topic Exchange
        @Bean
        public TopicExchange broadcastingExchange() {
            return new TopicExchange(BroadcastMessage.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

    }

}