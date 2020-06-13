package com.spring.study.springbootrabbitmqdirect.consumer;

import com.spring.study.springbootrabbitmqdirect.message.Demo08Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-07 11:59
 **/
@Component
@RabbitListener(queues = Demo08Message.DELAY_QUEUE)
public class Demo08Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo08Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("消费成功时间：{}",simpleDateFormat.format(new Date()) );
    }

}