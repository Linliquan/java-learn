package com.spring.study.springbootrabbitmqdirect.producer;


import com.spring.study.springbootrabbitmqdirect.message.Demo051Message;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 11:54
 **/
@Component
public class Demo051Producer {

    @Autowired
    private BatchingRabbitTemplate batchingRabbitTemplate;

    public void syncSend(Integer id) {
        // 创建 Demo051Message 消息
        Demo051Message message = new Demo051Message();
        message.setId(id);
        // 同步发送消息
        batchingRabbitTemplate.convertAndSend(Demo051Message.EXCHANGE, Demo051Message.ROUTING_KEY, message);
    }

}