package com.rocketmq.study.consumer;

import com.rocketmq.study.message.Demo05Message;
import org.apache.rocketmq.spring.annotation.MessageModel;
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
        topic = Demo05Message.TOPIC,
        consumerGroup = "demo05-consumer-group-" + Demo05Message.TOPIC,
        messageModel = MessageModel.BROADCASTING // 设置为广播消费
)
public class Demo05Consumer implements RocketMQListener<Demo05Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo05Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}