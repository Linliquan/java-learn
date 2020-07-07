package com.rocketmq.study.consumer;

import com.rocketmq.study.message.Demo06Message;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
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
        topic = Demo06Message.TOPIC,
        consumerGroup = "demo06-consumer-group-" + Demo06Message.TOPIC,
        consumeMode = ConsumeMode.ORDERLY // 设置为顺序消费
)
public class Demo06Consumer implements RocketMQListener<Demo06Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Demo06Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);

//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
//         sleep 2 秒，用于查看顺序消费的效果分隔
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException ignore) {
        }
    }

}