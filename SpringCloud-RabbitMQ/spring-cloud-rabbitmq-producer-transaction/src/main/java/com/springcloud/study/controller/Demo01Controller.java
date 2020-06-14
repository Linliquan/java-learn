package com.springcloud.study.controller;

import com.springcloud.study.message.Demo01Message;
import com.springcloud.study.message.MySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @program: java-learn
 * @description: 创建 Demo01Controller 类，提供发送消息的 HTTP 接口
 * @author: liquan
 * @create: 2020-06-12 23:34
 **/
@RestController
@RequestMapping("/demo01")
public class Demo01Controller {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MySource mySource;

    @Transactional
    @GetMapping("/send_transaction")
    public Boolean sendTransaction() throws InterruptedException {
        // 创建 Message
        int id = new Random().nextInt();
        Demo01Message message = new Demo01Message()
                .setId(id);
        // 创建 Spring Message 对象
        Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        mySource.demo01Output().send(springMessage);
        logger.info("[syncSend][发送编号：[{}] 发送成功]", id);

        // <X> 等待
        Thread.sleep(10 * 1000L);
        return true;
    }

}