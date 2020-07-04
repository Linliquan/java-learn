package com.rocketmq.study.consumer;

import com.rocketmq.study.message.Demo03Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-06-16 15:51
 **/
@Component
@RocketMQMessageListener(
        topic = Demo03Message.TOPIC,
        consumerGroup = "demo03-consumer-group-" + Demo03Message.TOPIC
)
public class Demo03Consumer implements RocketMQListener<Demo03Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo03Message message) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        logger.info("[接收时间：{}]", simpleDateFormat.format(new Date()));
    }

}