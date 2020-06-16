package com.rocketmq.study.consumer;

import com.rocketmq.study.message.Demo01Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @program: java-learn
 * @description:  messageModel默认为集群消费，可配置为广播消费
 * @author: liquan
 * @create: 2020-06-16 12:46
 **/
@Component
@RocketMQMessageListener(
        topic = Demo01Message.TOPIC,
        consumerGroup = "demo01-A-consumer-group-" + Demo01Message.TOPIC,
        messageModel = MessageModel.BROADCASTING
)
public class Demo01AConsumer implements RocketMQListener<MessageExt> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(MessageExt message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}