package com.spring.study.springbootrabbitmqdirect.config;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-06 21:32
 **/

import com.spring.study.springbootrabbitmqdirect.message.Demo03Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static class FanoutExchangeDemoConfiguration {

        // 创建 Queue A
        @Bean
        public Queue demo03QueueA() {
            return new Queue(Demo03Message.QUEUE_A, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Queue B
        @Bean
        public Queue demo03QueueB() {
            return new Queue(Demo03Message.QUEUE_B, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Fanout Exchange
        @Bean
        public FanoutExchange demo03Exchange() {
            return new FanoutExchange(Demo03Message.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

        // 创建 Binding A
        // Exchange：Demo03Message.EXCHANGE
        // Queue：Demo03Message.QUEUE_A
        @Bean
        public Binding demo03BindingA() {
            return BindingBuilder.bind(demo03QueueA()).to(demo03Exchange());
        }

        // 创建 Binding B
        // Exchange：Demo03Message.EXCHANGE
        // Queue：Demo03Message.QUEUE_B
        @Bean
        public Binding demo03BindingB() {
            return BindingBuilder.bind(demo03QueueB()).to(demo03Exchange());
        }

    }

}