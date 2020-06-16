package com.rocketmq.study.consumer;

import com.rocketmq.study.message.Demo07Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 15:51
 **/
@Component
@RocketMQMessageListener(
        topic = Demo07Message.TOPIC,
        consumerGroup = "demo07-consumer-group-" + Demo07Message.TOPIC
)
public class Demo07Consumer implements RocketMQListener<Demo07Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo07Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}