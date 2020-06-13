package com.spring.study.springbootrabbitmqdirect.config;

import com.spring.study.springbootrabbitmqdirect.message.ClusteringMessage;
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
     * 集群消费的示例的配置
     */
    public static class ClusteringConfiguration {

        // 创建 Topic Exchange,使用topic，不使用Direct
        @Bean
        public TopicExchange clusteringExchange() {
            return new TopicExchange(ClusteringMessage.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

    }

}