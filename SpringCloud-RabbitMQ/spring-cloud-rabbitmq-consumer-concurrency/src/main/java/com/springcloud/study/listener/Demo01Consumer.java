package com.springcloud.study.listener;

import com.springcloud.study.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * @program: java-learn
 * @description: 创建 Demo01Controller 类，提供发送消息的 HTTP 接口
 * @author: liquan
 * @create: 2020-06-12 23:34
 **/
@Component
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(MySink.DEMO01_INPUT)
    public void onMessage(@Payload Demo01Message message) throws InterruptedException {
        Thread.sleep(5000);
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}