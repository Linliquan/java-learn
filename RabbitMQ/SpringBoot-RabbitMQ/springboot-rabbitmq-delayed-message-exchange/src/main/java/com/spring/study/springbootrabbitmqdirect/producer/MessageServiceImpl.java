package com.spring.study.springbootrabbitmqdirect.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: java-learn
 * @description: 消息发送
 * @author: liquan
 * @create: 2020-06-09 15:22
 **/

@Service
public class MessageServiceImpl {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String queueName,String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange", queueName, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 延迟3秒
                message.getMessageProperties().setHeader("x-delay",3000);
                return message;
            }
        });
    }
}