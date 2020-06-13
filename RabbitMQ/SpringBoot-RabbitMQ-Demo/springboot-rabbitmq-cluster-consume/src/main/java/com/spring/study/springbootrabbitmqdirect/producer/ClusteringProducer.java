package com.spring.study.springbootrabbitmqdirect.producer;

import com.spring.study.springbootrabbitmqdirect.message.ClusteringMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description: 集群生产者
 * @author: liquan
 * @create: 2020-06-10 14:59
 **/
@Component
public class ClusteringProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 ClusteringMessage  消息
        ClusteringMessage message = new ClusteringMessage();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(ClusteringMessage.EXCHANGE, null, message);
    }

}