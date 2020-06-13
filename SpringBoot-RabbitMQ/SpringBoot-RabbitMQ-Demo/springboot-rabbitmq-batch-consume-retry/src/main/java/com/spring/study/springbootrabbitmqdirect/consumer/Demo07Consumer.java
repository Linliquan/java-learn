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
 * @create: 2020-06-07 11:59
 **/
@Component
public class Demo07Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    @RabbitListener(queues = Demo07Message.QUEUE)
    public void onMessage(Demo07Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
//        throw new RuntimeException("我就是故意抛出一个异常");
    }

}