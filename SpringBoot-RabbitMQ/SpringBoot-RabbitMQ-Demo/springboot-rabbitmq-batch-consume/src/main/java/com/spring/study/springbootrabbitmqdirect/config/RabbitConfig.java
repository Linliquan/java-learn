package com.spring.study.springbootrabbitmqdirect.config;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-06 21:32
 **/

import com.spring.study.springbootrabbitmqdirect.message.Demo051Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
public class RabbitConfig {

    /**
     * Direct Exchange 示例的配置类
     */
    public static class DirectExchangeDemoConfiguration {

        // 创建 Queue
        @Bean
        public Queue demo05Queue() {
            return new Queue(Demo051Message.QUEUE, // Queue 名字
                    true, // durable: 是否持久化
                    false, // exclusive: 是否排它
                    false); // autoDelete: 是否自动删除
        }

        // 创建 Direct Exchange
        @Bean
        public DirectExchange demo05Exchange() {
            return new DirectExchange(Demo051Message.EXCHANGE,
                    true,  // durable: 是否持久化
                    false);  // exclusive: 是否排它
        }

        // 创建 Binding
        // Exchange：Demo051Message.EXCHANGE
        // Routing key：Demo051Message.ROUTING_KEY
        // Queue：Demo051Message.QUEUE
        @Bean
        public Binding demo05Binding() {
            return BindingBuilder.bind(demo05Queue()).to(demo05Exchange()).with(Demo051Message.ROUTING_KEY);
        }

        // 用于创建支持批量消费的 SimpleRabbitListenerContainer
        @Bean(name = "consumerBatchContainerFactory")
        public SimpleRabbitListenerContainerFactory consumerBatchContainerFactory(
                SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
            // 创建 SimpleRabbitListenerContainerFactory 对象
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
            configurer.configure(factory, connectionFactory);
            // <X> 额外添加批量消费的属性
            factory.setBatchListener(true);
            return factory;
        }

    }

    @Bean
    public BatchingRabbitTemplate batchRabbitTemplate(ConnectionFactory connectionFactory) {
        // 创建 BatchingStrategy 对象，代表批量策略
        int batchSize = 16384; // 超过收集的消息数量的最大条数。
        int bufferLimit = 33554432; // 每次批量发送消息的最大内存
        int timeout = 10000; // 超过收集的时间的最大等待时长，单位：毫秒
        BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(batchSize, bufferLimit, timeout);

        // 创建 TaskScheduler 对象，用于实现超时发送的定时器
        TaskScheduler taskScheduler = new ConcurrentTaskScheduler();

        // 创建 BatchingRabbitTemplate 对象
        BatchingRabbitTemplate batchTemplate = new BatchingRabbitTemplate(batchingStrategy, taskScheduler);
        batchTemplate.setConnectionFactory(connectionFactory);
        return batchTemplate;
    }


}