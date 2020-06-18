package com.rocketmq.study.listener;

import com.rocketmq.study.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 21:47
 **/
@Component
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 在方法上，添加 @StreamListener 注解，声明对应的 Input Binding。这里，我们使用 MySink.DEMO01_INPUT。
     * 又因为我们消费的消息是 POJO 类型，所以我们需要添加 @Payload 注解，声明需要进行反序列化成 POJO 对象。
     */
    @StreamListener(MySink.DEMO01_INPUT)
    public void onMessage(@Payload Demo01Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("[接收时间：{}]", simpleDateFormat.format(new Date()));
    }

}