package com.springcloud.study.controller;

import com.springcloud.study.message.Demo01Message;
import com.springcloud.study.message.MySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
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

    @GetMapping("/send_batch")
    public boolean sendBatch() throws InterruptedException {
        // 发送 3 条消息，每条中间间隔 10 秒
        for (int i = 0; i < 3; i++) {
            // 创建 Message
            Demo01Message message = new Demo01Message()
                    .setId(new Random().nextInt());
            // 创建 Spring Message 对象
            Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                    .build();
            // 发送消息
            mySource.demo01Output().send(springMessage);

            // 故意每条消息之间，隔离 10 秒
            logger.info("[sendBatch][发送编号：[{}] 发送成功]", message.getId());
            Thread.sleep(5 * 1000L);
        }
        return true;
    }

}