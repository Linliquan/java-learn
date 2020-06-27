package com.rocketmq.study.controller;

import com.rocketmq.study.message.Demo01Message;
import com.rocketmq.study.message.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/send_tag")
    public boolean sendTag() {
        int i = 1;
        for (String tag : new String[]{"yunai", "yutou", "tudou"}) {
            // 创建 Message
            Demo01Message message = new Demo01Message()
                    .setId(i++);
            // 创建 Spring Message 对象
            Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                    .setHeader(MessageConst.PROPERTY_TAGS, tag) // <X> 设置 Tag
                    .build();
            // 发送消息
            mySource.demo01Output().send(springMessage);
        }
        return true;
    }

}