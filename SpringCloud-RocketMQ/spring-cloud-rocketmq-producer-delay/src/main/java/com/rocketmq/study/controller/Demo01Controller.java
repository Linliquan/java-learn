package com.rocketmq.study.controller;

import com.rocketmq.study.message.Demo01Message;
import com.rocketmq.study.message.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MySource mySource;

    @GetMapping("/send_delay")
    public boolean sendDelay() {
        // 创建 Message
        Demo01Message message = new Demo01Message()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        //rocketmq的18个定时级别： 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                .setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, "3") // <X> 设置延迟级别为 3，10 秒后消费。
                .build();
        // 发送消息
        boolean sendResult = mySource.demo01Output().send(springMessage);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("[sendDelay][发送消息完成, 结果 = {}]", sendResult);
        logger.info("[发送时间：{}]", simpleDateFormat.format(new Date()));
        return sendResult;
    }

}