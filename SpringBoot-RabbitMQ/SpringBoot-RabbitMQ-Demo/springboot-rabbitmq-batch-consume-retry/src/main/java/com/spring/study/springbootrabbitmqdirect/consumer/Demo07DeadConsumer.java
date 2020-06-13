package com.spring.study.springbootrabbitmqdirect.consumer;

import com.spring.study.springbootrabbitmqdirect.message.Demo07Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-08 14:49
 **/
@Component
@RabbitListener(queues = Demo07Message.DEAD_QUEUE)
public class Demo07DeadConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo07Message message) {
        logger.info("[onMessage][【死信队列】线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
