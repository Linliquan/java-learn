package com.spring.study.springbootrabbitmqdirect.producer;


import com.spring.study.springbootrabbitmqdirect.message.Demo04Message;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 11:54
 **/
@Component
public class Demo04Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id, String headerValue) {
        // 创建 MessageProperties 属性
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader(Demo04Message.HEADER_KEY, headerValue); // 设置 header
        // 创建 Message 消息
        Message message = rabbitTemplate.getMessageConverter().toMessage(
                new Demo04Message().setId(id), messageProperties);
        // 同步发送消息
        rabbitTemplate.send(Demo04Message.EXCHANGE, null, message);
    }

}