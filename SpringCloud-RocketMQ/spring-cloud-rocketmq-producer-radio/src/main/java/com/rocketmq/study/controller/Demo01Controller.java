package com.rocketmq.study.controller;

import com.rocketmq.study.message.Demo01Message;
import com.rocketmq.study.message.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 21:35
 **/
@RestController
@RequestMapping("/demo01")
public class Demo01Controller {

    @Autowired
    private MySource mySource;

    @GetMapping("/send")
    public boolean send() {
        // <1> 创建 Message
        Demo01Message message = new Demo01Message()
                .setId(new Random().nextInt());
        // <2> 创建 Spring Message 对象
        Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                .build();
        // <3> 发送消息
        return mySource.demo01Output().send(springMessage);
    }

}